/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.TaiKhoan;
import Repositories.TaiKhoanRepository;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        

/**
 *
 * @author truongmanhquang
 */
public class TaiKhoanRepositoryImpl implements TaiKhoanRepository{

    @Override
    public boolean checkLogin(String userName, String pass) {
        TaiKhoan taiKhoan = getOne(userName);
         if(taiKhoan !=null){
             if(taiKhoan.getMatKhau().equals(pass)){
                 return true;
             }
         }
         return false;
    }

    @Override
    public TaiKhoan getOne(String name) {
        String query = "SELECT Id, TenTaiKhoan, MatKhau, TrangThai\n" +
                "           FROM DA1.dbo.TaiKhoan WHERE TenTaiKhoan=?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                return taiKhoan;
            }
           
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean update(TaiKhoan tk, String tenTK) {
        String query = "UPDATE DA1.dbo.TaiKhoan\n" +
                "               SET MatKhau=?" +
                "               WHERE TenTaiKhoan=?";
        int check=0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, tk.getMatKhau());
            ps.setObject(2, tenTK);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    
//        public static void main(String[] args) {
//        TaiKhoan dv = new TaiKhoan(null, "admin1", "123", 1);
//        boolean testAdd = new TaiKhoanRepositoryImpl().update(dv, "admin1");
//        System.out.println(testAdd);//cua add
//    }
//    
}
