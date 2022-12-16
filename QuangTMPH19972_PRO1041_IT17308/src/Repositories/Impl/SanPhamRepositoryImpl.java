/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.SanPham;
import Repositories.SanPhamRepository;
import Utilities.DBConnection;
import ViewModels.QLChiTietSP;
import ViewModels.QLSanPham;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author truongmanhquang
 */
public class SanPhamRepositoryImpl implements SanPhamRepository{

    @Override
    public List<SanPham> getAll() {
        String query="SELECT Id, Ma, Ten\n" +
                "           FROM DA1.dbo.SanPham";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<SanPham> listSanPham=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                SanPham sp=new SanPham(rs.getString(1), rs.getString(2), rs.getString(3));
                listSanPham.add(sp);
            }
            return listSanPham;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(SanPham sp) {
        String query="INSERT INTO DA1.dbo.SanPham\n" +
                "           (Ma, Ten, TrangThai)\n" +
                "           VALUES(?, ?, ?)";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, sp.getTrangThai());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean update(SanPham sp, String ma) {
        String query="UPDATE DA1.dbo.SanPham\n" +
                "           SET Ma=?, Ten=?, TrangThai=?\n" +
                "           WHERE Ma=?";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, sp.getTrangThai());
            ps.setObject(4, ma);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean delete(String ma) {
        String query="DELETE FROM DA1.dbo.SanPham\n" +
                "           WHERE Ma=?";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public List<QLSanPham> getList() {
        String query="SELECT Ma, Ten, TrangThai\n" +
                "           FROM DA1.dbo.SanPham";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLSanPham> listQLSanPham=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLSanPham qLSanPham=new QLSanPham(rs.getString(1), rs.getString(2), rs.getInt(3));
                listQLSanPham.add(qLSanPham);
            }
            return listQLSanPham;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

  

   
    
}
