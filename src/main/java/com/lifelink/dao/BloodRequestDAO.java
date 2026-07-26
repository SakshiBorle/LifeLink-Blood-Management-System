package com.lifelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lifelink.model.BloodRequest;
import com.lifelink.util.DBConnection;

public class BloodRequestDAO {

    public List<BloodRequest> getAllRequests() {

        List<BloodRequest> requestList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM blood_request "
                    + "ORDER BY request_date DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                BloodRequest bloodRequest = new BloodRequest();

                bloodRequest.setRequestId(
                        rs.getInt("request_id"));

                bloodRequest.setHospitalId(
                        rs.getInt("hospital_id"));

                bloodRequest.setPatientName(
                        rs.getString("patient_name"));

                bloodRequest.setBloodGroup(
                        rs.getString("blood_group"));

                bloodRequest.setUnitsRequired(
                        rs.getInt("units_required"));

                bloodRequest.setEmergencyLevel(
                        rs.getString("emergency_level"));

                bloodRequest.setReason(
                        rs.getString("reason"));

                bloodRequest.setRequestDate(
                        rs.getTimestamp("request_date"));

                bloodRequest.setStatus(
                        rs.getString("status"));

                requestList.add(bloodRequest);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return requestList;
    }
    public boolean addRequest(BloodRequest bloodRequest) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO blood_request "
                    + "(hospital_id, patient_name, blood_group, "
                    + "units_required, emergency_level, reason, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, bloodRequest.getHospitalId());
            ps.setString(2, bloodRequest.getPatientName());
            ps.setString(3, bloodRequest.getBloodGroup());
            ps.setInt(4, bloodRequest.getUnitsRequired());
            ps.setString(5, bloodRequest.getEmergencyLevel());
            ps.setString(6, bloodRequest.getReason());
            ps.setString(7, "Pending");

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
    public boolean approveRequest(int requestId) {

        boolean status = false;
        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            String requestSql =
                    "SELECT blood_group, units_required "
                    + "FROM blood_request "
                    + "WHERE request_id = ? AND status = 'Pending'";

            PreparedStatement requestPs =
                    con.prepareStatement(requestSql);

            requestPs.setInt(1, requestId);

            ResultSet rs = requestPs.executeQuery();

            if (rs.next()) {

                String bloodGroup = rs.getString("blood_group");
                int unitsRequired = rs.getInt("units_required");

                String stockSql =
                        "UPDATE blood_inventory "
                        + "SET available_units = available_units - ? "
                        + "WHERE blood_group = ? "
                        + "AND available_units >= ?";

                PreparedStatement stockPs =
                        con.prepareStatement(stockSql);

                stockPs.setInt(1, unitsRequired);
                stockPs.setString(2, bloodGroup);
                stockPs.setInt(3, unitsRequired);

                int stockRows = stockPs.executeUpdate();

                if (stockRows > 0) {

                    String updateSql =
                            "UPDATE blood_request "
                            + "SET status = 'Approved' "
                            + "WHERE request_id = ?";

                    PreparedStatement updatePs =
                            con.prepareStatement(updateSql);

                    updatePs.setInt(1, requestId);

                    updatePs.executeUpdate();

                    con.commit();

                    status = true;

                    updatePs.close();

                } else {

                    con.rollback();
                }

                stockPs.close();
            }

            rs.close();
            requestPs.close();

            con.setAutoCommit(true);
            con.close();

        } catch (Exception e) {

            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        }

        return status;
    }
    public boolean rejectRequest(int requestId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE blood_request "
                    + "SET status = 'Rejected' "
                    + "WHERE request_id = ? "
                    + "AND status = 'Pending'";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, requestId);

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
    public List<BloodRequest> getRequestsByHospitalId(int hospitalId) {

        List<BloodRequest> requestList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM blood_request "
                    + "WHERE hospital_id = ? "
                    + "ORDER BY request_date DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, hospitalId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                BloodRequest bloodRequest = new BloodRequest();

                bloodRequest.setRequestId(rs.getInt("request_id"));
                bloodRequest.setHospitalId(rs.getInt("hospital_id"));
                bloodRequest.setPatientName(rs.getString("patient_name"));
                bloodRequest.setBloodGroup(rs.getString("blood_group"));
                bloodRequest.setUnitsRequired(rs.getInt("units_required"));
                bloodRequest.setEmergencyLevel(rs.getString("emergency_level"));
                bloodRequest.setReason(rs.getString("reason"));
                bloodRequest.setRequestDate(rs.getTimestamp("request_date"));
                bloodRequest.setStatus(rs.getString("status"));

                requestList.add(bloodRequest);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return requestList;
    }
}