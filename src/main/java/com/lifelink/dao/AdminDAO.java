package com.lifelink.dao;
import com.lifelink.util.PasswordUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lifelink.model.Admin;
import com.lifelink.util.DBConnection;

public class AdminDAO {


public Admin login(String username, String password) {

    Admin admin = null;

    try {
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM admin WHERE username = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            String storedPassword = rs.getString("password");
            boolean passwordMatches;

            if (storedPassword != null
                    && storedPassword.startsWith("pbkdf2_sha256$")) {

                passwordMatches =
                        PasswordUtil.verifyPassword(password, storedPassword);

            } else {

                // Support existing plain-text admin passwords
                passwordMatches = storedPassword != null
                        && storedPassword.equals(password);

                // Upgrade to a hash after successful login
                if (passwordMatches) {
                    String hashedPassword =
                            PasswordUtil.hashPassword(password);

                    PreparedStatement updatePs = con.prepareStatement(
                            "UPDATE admin SET password = ? WHERE admin_id = ?");

                    updatePs.setString(1, hashedPassword);
                    updatePs.setInt(2, rs.getInt("admin_id"));
                    updatePs.executeUpdate();
                    updatePs.close();
                }
            }

            if (passwordMatches) {
                admin = new Admin();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setName(rs.getString("name"));
                admin.setPassword(null);
            }
        }

        rs.close();
        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return admin;
}


}