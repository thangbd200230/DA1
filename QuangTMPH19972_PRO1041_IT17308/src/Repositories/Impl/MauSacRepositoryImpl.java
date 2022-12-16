/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.MauSac;
import Repositories.MauSacRepository;
import Utilities.DBConnection;
import ViewModels.QLMauSac;
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
public class MauSacRepositoryImpl implements MauSacRepository{

    @Override
    public List<MauSac> getAll() {
        String query="SELECT Id, Ma, Ten\n" +
                "               FROM DA1.dbo.MauSac";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<MauSac> listMauSac=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                MauSac mauSac=new MauSac(rs.getString(1), rs.getString(2), rs.getString(3));
                listMauSac.add(mauSac);
            }
            return listMauSac;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(MauSac mauSac) {
        String query="INSERT INTO DA1.dbo.MauSac\n" +
                "           (Ma, Ten, TrangThai)\n" +
                "           VALUES(?, ?, ?)";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, mauSac.getMa());
            ps.setObject(2, mauSac.getTen());
            ps.setObject(3, mauSac.getTrangThai());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean update(MauSac mauSac, String ma) {
        String query="UPDATE DA1.dbo.MauSac\n" +
                "           SET Ma=?, Ten=?, TrangThai=?\n" +
                "           WHERE Ma=?";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, mauSac.getMa());
            ps.setObject(2, mauSac.getTen());
            ps.setObject(3, mauSac.getTrangThai());
            ps.setObject(4, ma);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean delete(String ma) {
        String query="DELETE FROM DA1.dbo.MauSac\n" +
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
    public List<QLMauSac> getList() {
        String query="SELECT Ma, Ten, TrangThai\n" +
                "           FROM DA1.dbo.MauSac";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLMauSac> listQLMauSac=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLMauSac qLMauSac=new QLMauSac(rs.getString(1), rs.getString(2), rs.getInt(3));
                listQLMauSac.add(qLMauSac);
            }
            return listQLMauSac;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
