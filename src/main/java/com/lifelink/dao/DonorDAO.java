
package com.lifelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lifelink.model.Donor;
import com.lifelink.util.DBConnection;

public class DonorDAO {

    // Add donor and increase matching blood stock by entered units.
    public boolean addDonor(Donor donor, int donatedUnits) {

        Connection con = null;

        try {
            con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("ERROR: Database connection failed.");
                return false;
            }

            if (donatedUnits < 1) {
                System.out.println("ERROR: Donated units must be at least 1.");
                return false;
            }

            con.setAutoCommit(false);

            // 1. Save donor details
            String donorSql =
                "INSERT INTO donor " +
                "(donor_name, blood_group, age, gender, phone, last_donation) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = con.prepareStatement(donorSql)) {
                ps.setString(1, donor.getDonorName());
                ps.setString(2, donor.getBloodGroup());
                ps.setInt(3, donor.getAge());
                ps.setString(4, donor.getGender());
                ps.setString(5, donor.getPhone());
                ps.setDate(6, donor.getLastDonation());

                int donorRows = ps.executeUpdate();

                System.out.println("Donor rows inserted: " + donorRows);
            }

            // 2. Increase inventory by the entered number of units
            String stockSql =
                "UPDATE blood_inventory " +
                "SET available_units = available_units + ? " +
                "WHERE blood_group = ?";

            try (PreparedStatement ps = con.prepareStatement(stockSql)) {
                ps.setInt(1, donatedUnits);
                ps.setString(2, donor.getBloodGroup());

                System.out.println("Blood group: " + donor.getBloodGroup());
                System.out.println("Units received: " + donatedUnits);

                int rows = ps.executeUpdate();

                System.out.println("Inventory rows updated: " + rows);

                if (rows == 0) {
                    System.out.println(
                        "ERROR: No inventory row found for blood group "
                        + donor.getBloodGroup()
                    );

                    con.rollback();
                    return false;
                }
            }

            // 3. Commit both changes
            con.commit();

            System.out.println(
                "SUCCESS: Donor saved and inventory updated."
            );

            return true;

        } catch (Exception e) {

            System.out.println("ERROR while adding donor or updating inventory:");

            e.printStackTrace();

            if (con != null) {
                try {
                    con.rollback();
                    System.out.println("Transaction rolled back.");
                } catch (Exception rollbackError) {
                    rollbackError.printStackTrace();
                }
            }

            return false;

        } finally {

            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Get all donors
    public List<Donor> getAllDonors() {

        List<Donor> donorList = new ArrayList<>();

        String sql = "SELECT * FROM donor";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Donor donor = new Donor();

                donor.setDonorId(rs.getInt("donor_id"));
                donor.setDonorName(rs.getString("donor_name"));
                donor.setBloodGroup(rs.getString("blood_group"));
                donor.setAge(rs.getInt("age"));
                donor.setGender(rs.getString("gender"));
                donor.setPhone(rs.getString("phone"));
                donor.setLastDonation(rs.getDate("last_donation"));

                donorList.add(donor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return donorList;
    }

    // Delete donor record
    public boolean deleteDonor(int donorId) {

        String sql = "DELETE FROM donor WHERE donor_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, donorId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
