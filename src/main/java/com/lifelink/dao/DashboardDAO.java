package com.lifelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lifelink.util.DBConnection;

public class DashboardDAO {

    private int getCount(String sql) {

        int count = 0;

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public int getTotalHospitals() {
        return getCount("SELECT COUNT(*) FROM hospital");
    }

    public int getTotalBloodUnits() {
        return getCount(
            "SELECT COALESCE(SUM(available_units), 0) FROM blood_inventory"
        );
    }

    public int getPendingRequests() {
        return getCount(
            "SELECT COUNT(*) FROM blood_request WHERE status = 'Pending'"
        );
    }

    public int getApprovedRequests() {
        return getCount(
            "SELECT COUNT(*) FROM blood_request WHERE status = 'Approved'"
        );
    }
    public int getTotalDonors() {
        return getCount(
            "SELECT COUNT(*) FROM donor"
        );
    }

    public int getRejectedRequests() {
        return getCount(
            "SELECT COUNT(*) FROM blood_request "
            + "WHERE status = 'Rejected'"
        );
    }
}