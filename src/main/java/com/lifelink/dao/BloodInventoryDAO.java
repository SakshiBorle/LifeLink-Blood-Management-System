package com.lifelink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lifelink.model.BloodInventory;
import com.lifelink.util.DBConnection;

public class BloodInventoryDAO {

    public List<BloodInventory> getAllInventory() {

        List<BloodInventory> inventoryList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM blood_inventory";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                BloodInventory inventory = new BloodInventory();

                inventory.setInventoryId(
                        rs.getInt("inventory_id"));

                inventory.setBloodGroup(
                        rs.getString("blood_group"));

                inventory.setAvailableUnits(
                        rs.getInt("available_units"));

                inventoryList.add(inventory);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return inventoryList;
    }
    public boolean addStock(int inventoryId, int units) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE blood_inventory "
                    + "SET available_units = available_units + ? "
                    + "WHERE inventory_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, units);
            ps.setInt(2, inventoryId);

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
    public boolean removeStock(int inventoryId, int units) {

        boolean status = false;

        String sql =
            "UPDATE blood_inventory " +
            "SET available_units = available_units - ? " +
            "WHERE inventory_id = ? " +
            "AND available_units >= ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, units);
            ps.setInt(2, inventoryId);
            ps.setInt(3, units);

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
    public List<BloodInventory> getLowStockInventory() {

        List<BloodInventory> list = new ArrayList<>();

        String sql =
            "SELECT * FROM blood_inventory " +
            "WHERE available_units <= 5";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                BloodInventory inventory =
                        new BloodInventory();

                inventory.setInventoryId(
                        rs.getInt("inventory_id"));

                inventory.setBloodGroup(
                        rs.getString("blood_group"));

                inventory.setAvailableUnits(
                        rs.getInt("available_units"));

                list.add(inventory);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}