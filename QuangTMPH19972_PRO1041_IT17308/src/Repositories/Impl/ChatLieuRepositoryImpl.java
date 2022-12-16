/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.ChatLieu;
import Repositories.ChatLieuRepository;
import Utilities.DBConnection;
import ViewModels.QLChatLieu;
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
public class ChatLieuRepositoryImpl implements ChatLieuRepository{

    @Override
    public List<ChatLieu> getAll() {
        String query="SELECT Id, Ma, Ten\n" +
                "           FROM DA1.dbo.ChatLieu";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<ChatLieu> listChatLieu=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                ChatLieu chatLieu=new ChatLieu(rs.getString(1), rs.getString(2), rs.getString(3));
                listChatLieu.add(chatLieu);
            }
            return listChatLieu;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(ChatLieu chatLieu) {
        String query="INSERT INTO DA1.dbo.ChatLieu\n" +
                "           (Ma, Ten, TrangThai)\n" +
                "           VALUES(?, ?, ?)";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, chatLieu.getMa());
            ps.setObject(2, chatLieu.getTen());
            ps.setObject(3, chatLieu.getTrangThai());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean update(ChatLieu chatLieu, String ma) {
        String query="UPDATE DA1.dbo.ChatLieu\n" +
                "           SET Ma=?, Ten=?, TrangThai=?\n" +
                "           WHERE Ma=?";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, chatLieu.getMa());
            ps.setObject(2, chatLieu.getTen());
            ps.setObject(3, chatLieu.getTrangThai());
            ps.setObject(4, ma);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean delete(String ma) {
        String query="DELETE FROM DA1.dbo.ChatLieu\n" +
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
    public List<QLChatLieu> getList() {
        String query="SELECT Ma, Ten, TrangThai\n" +
                "           FROM DA1.dbo.ChatLieu";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLChatLieu> listQLChatLieu=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLChatLieu qLChatLieu=new QLChatLieu(rs.getString(1), rs.getString(2),rs.getInt(3));
                listQLChatLieu.add(qLChatLieu);
            }
            return listQLChatLieu;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
         public static void main(String[] args) {
        List<QLChatLieu> lists = new ChatLieuRepositoryImpl().getList();
        for (QLChatLieu dv : lists) {
            System.out.println(dv.toString());
        }
    }
//    public static void main(String[] args) {
//        ChiTietSP dv = new ChiTietSP(null, null, null, null, null, null, null, null, null, 15000, 10000, 23, "Dep", 0);
//        boolean testAdd = new ChiTietSPRepositoryImpl().update(dv, "3921BF17-8556-4AA5-ADD4-E0D0971E63AB");
//        System.out.println(testAdd);//cua add
//    }
}
