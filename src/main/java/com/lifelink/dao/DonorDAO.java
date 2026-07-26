package com.lifelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lifelink.model.Donor;
import com.lifelink.util.DBConnection;

public class DonorDAO {

    public boolean addDonor(Donor donor) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO donor "
                    + "(donor_name, blood_group, age, gender, phone, last_donation) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, donor.getDonorName());
            ps.setString(2, donor.getBloodGroup());
            ps.setInt(3, donor.getAge());
            ps.setString(4, donor.getGender());
            ps.setString(5, donor.getPhone());
            ps.setDate(6, donor.getLastDonation());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<Donor> getAllDonors() {

        List<Donor> donorList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM donor";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

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

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return donorList;
    }
    public boolean deleteDonor(int donorId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM donor WHERE donor_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, donorId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}