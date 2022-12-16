/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.KieuDang;
import Repositories.KieuDangRepository;
import Utilities.DBConnection;
import ViewModels.QLKieuDang;
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
public class KieuDangRepositoryImpl implements KieuDangRepository{

    @Override
    public List<KieuDang> getAll() {
        String query="SELECT Id, Ma, Ten\n" +
            "           FROM DA1.dbo.KieuDang";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<KieuDang> listKieuDang=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                KieuDang kieuDang=new KieuDang(rs.getString(1), rs.getString(2), rs.getString(3));
                listKieuDang.add(kieuDang);
            }
            return listKieuDang;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(KieuDang kieuDang) {
        String query="INSERT INTO DA1.dbo.KieuDang\n" +
                "           (Ma, Ten, TrangThai)\n" +
                "           VALUES(?, ?, ?)";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, kieuDang.getMa());
            ps.setObject(2, kieuDang.getTen());
            ps.setObject(3, kieuDang.getTrangThai());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean update(KieuDang kieuDang, String ma) {
        String query="UPDATE DA1.dbo.KieuDang\n" +
                "           SET Ma=?, Ten=?, TrangThai=?\n" +
                "           WHERE Ma=?";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, kieuDang.getMa());
            ps.setObject(2, kieuDang.getTen());
            ps.setObject(3, kieuDang.getTrangThai());
            ps.setObject(4, ma);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean delete(String ma) {
        String query="DELETE FROM DA1.dbo.KieuDang\n" +
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
    public List<QLKieuDang> getList() {
        String query="SELECT Ma, Ten, TrangThai\n" +
                "           FROM DA1.dbo.KieuDang";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLKieuDang> listQLKieuDang=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLKieuDang qLKieuDang=new QLKieuDang(rs.getString(1), rs.getString(2),rs.getInt(3));
                listQLKieuDang.add(qLKieuDang);
            }
            return listQLKieuDang;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
