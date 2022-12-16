/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.HinhThucThanhToan;
import Repositories.HinhThucThanhToanRepository;
import Utilities.DBConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author truongmanhquang
 */
public class HinhThucThanhToanRepositoryImpl implements HinhThucThanhToanRepository{

    @Override
    public List<HinhThucThanhToan> getAll() {
        String query="SELECT Id, TenHTTT\n" +
                "           FROM DA1.dbo.HinhThucThanhToan";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<HinhThucThanhToan> listHTTT=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                HinhThucThanhToan httt=new HinhThucThanhToan(rs.getString(1),rs.getString(2));
                listHTTT.add(httt);
            }
            return listHTTT;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
