/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import Repositories.ChucVuRepository;
import Utilities.DBConnection;
import ViewModels.QLChucVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thang
 */
public class ChucVuRepositoryImpl implements ChucVuRepository {

    @Override
    public List<QLChucVu> getAll() {
        String query = "select Id, MaCV,Ten,TrangThai from ChucVu";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<QLChucVu> ListQlChucVu = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLChucVu cv = new QLChucVu(rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4));
                ListQlChucVu.add(cv);
            }
            return ListQlChucVu;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
