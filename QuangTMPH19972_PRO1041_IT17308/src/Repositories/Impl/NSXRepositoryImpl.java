/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.NSX;
import Repositories.NSXRepository;
import Utilities.DBConnection;
import ViewModels.QLNSX;
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
public class NSXRepositoryImpl implements NSXRepository{

    @Override
    public List<NSX> getAll() {
        String query="SELECT Id, Ma, Ten\n" +
                "           FROM DA1.dbo.NSX";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<NSX> listNsx=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                NSX nSX=new NSX(rs.getString(1), rs.getString(2), rs.getString(3));
                listNsx.add(nSX);
            }
            return listNsx;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(NSX nSX) {
        String query="INSERT INTO DA1.dbo.NSX\n" +
                "           (Ma, Ten, TrangThai)\n" +
                "           VALUES(?, ?, ?)";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, nSX.getMa());
            ps.setObject(2, nSX.getTen());
            ps.setObject(3, nSX.getTrangThai());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean update(NSX nSX, String ma) {
        String query="UPDATE DA1.dbo.NSX\n" +
                "           SET Ma=?, Ten=?, TrangThai=?\n" +
                "           WHERE Ma=?";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, nSX.getMa());
            ps.setObject(2, nSX.getTen());
            ps.setObject(3, nSX.getTrangThai());
            ps.setObject(4, ma);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean delete(String ma) {
        String query="DELETE FROM DA1.dbo.NSX\n" +
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
    public List<QLNSX> getList() {
        String query="SELECT Ma, Ten, TrangThai\n" +
                "           FROM DA1.dbo.NSX";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLNSX> listQLNSX=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLNSX qLNSX=new QLNSX(rs.getString(1), rs.getString(2), rs.getInt(3));
                listQLNSX.add(qLNSX);
            }
            return listQLNSX;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
