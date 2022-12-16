/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.DongSP;
import Repositories.DongSPRepository;
import Utilities.DBConnection;
import ViewModels.QLDongSP;
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
public class DongSPRepositoryImpl implements DongSPRepository{

    @Override
    public List<DongSP> getAll() {
        String query="SELECT Id, Ma, Ten\n" +
            "           FROM DA1.dbo.DongSP";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<DongSP> listDongSP=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                DongSP dongSP=new DongSP(rs.getString(1), rs.getString(2), rs.getString(3));
                listDongSP.add(dongSP);
            }
            return listDongSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(DongSP dongSP) {
        String query="INSERT INTO DA1.dbo.DongSP\n" +
                "           (Ma, Ten, TrangThai)\n" +
                "           VALUES(?, ?, ?)";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, dongSP.getMa());
            ps.setObject(2, dongSP.getTen());
            ps.setObject(3, dongSP.getTrangThai());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean update(DongSP dongSP, String ma) {
        String query="UPDATE DA1.dbo.DongSP\n" +
                "           SET Ma=?, Ten=?, TrangThai=?\n" +
                "           WHERE Ma=?";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, dongSP.getMa());
            ps.setObject(2, dongSP.getTen());
            ps.setObject(3, dongSP.getTrangThai());
            ps.setObject(4, ma);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean delete(String ma) {
        String query="DELETE FROM DA1.dbo.DongSP\n" +
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
    public List<QLDongSP> getList() {
        String query="SELECT Ma, Ten, TrangThai\n" +
                "           FROM DA1.dbo.DongSP";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLDongSP> listQLDongSP=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLDongSP qLDongSP=new QLDongSP(rs.getString(1), rs.getString(2),rs.getInt(3));
                listQLDongSP.add(qLDongSP);
            }
            return listQLDongSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
