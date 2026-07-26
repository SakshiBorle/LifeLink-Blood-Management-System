package com.lifelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lifelink.model.Hospital;
import com.lifelink.util.DBConnection;

public class HospitalDAO {

    public boolean addHospital(Hospital hospital) {

        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO hospital"
                    + "(hospital_name, email, phone, address, username, password) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, hospital.getHospitalName());
            ps.setString(2, hospital.getEmail());
            ps.setString(3, hospital.getPhone());
            ps.setString(4, hospital.getAddress());
            ps.setString(5, hospital.getUsername());
            ps.setString(6, hospital.getPassword());

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

    public List<Hospital> getAllHospitals() {

        List<Hospital> hospitals = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM hospital";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Hospital hospital = new Hospital();

                hospital.setHospitalId(rs.getInt("hospital_id"));
                hospital.setHospitalName(rs.getString("hospital_name"));
                hospital.setEmail(rs.getString("email"));
                hospital.setPhone(rs.getString("phone"));
                hospital.setAddress(rs.getString("address"));
                hospital.setUsername(rs.getString("username"));
                hospital.setPassword(rs.getString("password"));

                hospitals.add(hospital);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hospitals;
    }
    public boolean deleteHospital(int hospitalId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM hospital WHERE hospital_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, hospitalId);

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
    public Hospital getHospitalById(int hospitalId) {

        Hospital hospital = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM hospital WHERE hospital_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hospitalId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                hospital = new Hospital();

                hospital.setHospitalId(rs.getInt("hospital_id"));
                hospital.setHospitalName(rs.getString("hospital_name"));
                hospital.setEmail(rs.getString("email"));
                hospital.setPhone(rs.getString("phone"));
                hospital.setAddress(rs.getString("address"));
                hospital.setUsername(rs.getString("username"));
                hospital.setPassword(rs.getString("password"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hospital;
    }


    public boolean updateHospital(Hospital hospital) {

        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE hospital SET hospital_name=?, email=?, "
                    + "phone=?, address=?, username=?, password=? "
                    + "WHERE hospital_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, hospital.getHospitalName());
            ps.setString(2, hospital.getEmail());
            ps.setString(3, hospital.getPhone());
            ps.setString(4, hospital.getAddress());
            ps.setString(5, hospital.getUsername());
            ps.setString(6, hospital.getPassword());
            ps.setInt(7, hospital.getHospitalId());

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
    public Hospital login(String username, String password) {

        Hospital hospital = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM hospital "
                    + "WHERE username = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                hospital = new Hospital();

                hospital.setHospitalId(rs.getInt("hospital_id"));
                hospital.setHospitalName(rs.getString("hospital_name"));
                hospital.setEmail(rs.getString("email"));
                hospital.setPhone(rs.getString("phone"));
                hospital.setAddress(rs.getString("address"));
                hospital.setUsername(rs.getString("username"));
                hospital.setPassword(rs.getString("password"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hospital;
    }
}