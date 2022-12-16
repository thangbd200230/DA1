/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.KichCo;
import Repositories.KichCoRepository;
import Utilities.DBConnection;
import ViewModels.QLKichCo;
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
public class KichCoRepositoryImpl implements KichCoRepository{

    @Override
    public List<KichCo> getAll() {
        String query="SELECT Id, Ma, Ten\n" +
                "           FROM DA1.dbo.KichCo";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<KichCo> listKichCo=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                KichCo kichCo=new KichCo(rs.getString(1), rs.getString(2), rs.getString(3));
                listKichCo.add(kichCo);
            }
            return listKichCo;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(KichCo kichCo) {
        String query="INSERT INTO DA1.dbo.KichCo\n" +
                "           (Ma, Ten, TrangThai)\n" +
                "           VALUES(?, ?, ?)";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, kichCo.getMa());
            ps.setObject(2, kichCo.getTen());
            ps.setObject(3, kichCo.getTrangThai());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean update(KichCo kichCo, String ma) {
        String query="UPDATE DA1.dbo.KichCo\n" +
                "           SET Ma=?, Ten=?, TrangThai=?\n" +
                "           WHERE Ma=?";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, kichCo.getMa());
            ps.setObject(2, kichCo.getTen());
            ps.setObject(3, kichCo.getTrangThai());
            ps.setObject(4, ma);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean delete(String ma) {
        String query="DELETE FROM DA1.dbo.KichCo\n" +
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
    public List<QLKichCo> getList() {
        String query="SELECT Ma, Ten, TrangThai\n" +
                "           FROM DA1.dbo.KichCo";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLKichCo> listQLKichCo=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLKichCo qLKichCo=new QLKichCo(rs.getString(1), rs.getString(2),rs.getInt(3));
                listQLKichCo.add(qLKichCo);
            }
            return listQLKichCo;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
