/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.KhuyenMai;
import Repositories.KhuyenMaiRepository;
import Utilities.DBConnection;
import ViewModels.QLKhuyenMai;
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
public class KhuyenMaiRepositoryImpl implements KhuyenMaiRepository{

    @Override
    public List<QLKhuyenMai> getAll() {
        String query="SELECT Ma, Ten, LoaiKM, NgayBatDau, NgayKetThuc, MucGiamGiaPhanTram, MucGiamGiaTienMat, TrangThai\n" +
                    "           FROM DA1.dbo.KhuyenMai";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLKhuyenMai> listQLKM=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLKhuyenMai qLKhuyenMai=new QLKhuyenMai(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getInt(8));
                listQLKM.add(qLKhuyenMai);
            }
            return listQLKM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QLKhuyenMai> getOne(String ma) {
        String query="SELECT Ma, Ten, LoaiKM, NgayBatDau, NgayKetThuc, MucGiamGiaPhanTram, MucGiamGiaTienMat, TrangThai\n" +
                "           FROM DA1.dbo.KhuyenMai WHERE Ma=?";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLKhuyenMai> listQLKM=new ArrayList<>();
            ps.setObject(1, ma);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLKhuyenMai qLKhuyenMai=new QLKhuyenMai(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getInt(8));
                listQLKM.add(qLKhuyenMai);
            }
            return listQLKM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(KhuyenMai km) {
        String query="INSERT INTO DA1.dbo.KhuyenMai\n" +
                "               (Ma, Ten, LoaiKM, NgayBatDau, NgayKetThuc, MucGiamGiaPhanTram, MucGiamGiaTienMat, TrangThai)\n" +
                "               VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, km.getMa());
            ps.setObject(2, km.getTen());
            ps.setObject(3, km.getLoaiKM());
            ps.setObject(4, km.getNgayBatDau());
            ps.setObject(5, km.getNgayKetThuc());
            ps.setObject(6, km.getMucGiamGiaTheoPhanTram());
            ps.setObject(7, km.getMucGiamGiaTheoTien());
            ps.setObject(8, km.getTrangThai());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean update(KhuyenMai km, String ma) {
        String query="UPDATE DA1.dbo.KhuyenMai\n" +
            "               SET Ma=?, Ten=?,LoaiKM=?, NgayBatDau=?, NgayKetThuc=?, MucGiamGiaPhanTram=?, MucGiamGiaTienMat=?, TrangThai=?\n" +
            "               WHERE Ma=?";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, km.getMa());
            ps.setObject(2, km.getTen());
            ps.setObject(3, km.getLoaiKM());
            ps.setObject(4, km.getNgayBatDau());
            ps.setObject(5, km.getNgayKetThuc());
            ps.setObject(6, km.getMucGiamGiaTheoPhanTram());
            ps.setObject(7, km.getMucGiamGiaTheoTien());
            ps.setObject(8, km.getTrangThai());
            ps.setObject(9, ma);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean delete(String ma) {
        String query="DELETE FROM DA1.dbo.KhuyenMai\n" +
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
    public List<QLKhuyenMai> getSearchLoaiKMPT(int loaiKM) {
        String query="SELECT Ma, Ten, LoaiKM, NgayBatDau, NgayKetThuc, MucGiamGiaPhanTram, MucGiamGiaTienMat, TrangThai\n" +
                    "           FROM DA1.dbo.KhuyenMai WHERE LoaiKM=?";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLKhuyenMai> listQLKM=new ArrayList<>();
            ps.setObject(1, loaiKM);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLKhuyenMai qLKhuyenMai=new QLKhuyenMai(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getInt(8));
                listQLKM.add(qLKhuyenMai);
            }
            return listQLKM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    @Override
    public List<QLKhuyenMai> getSearchTTNHD(int trangThai) {
        String query="SELECT Ma, Ten, LoaiKM, NgayBatDau, NgayKetThuc, MucGiamGiaPhanTram, MucGiamGiaTienMat, TrangThai\n" +
                "           FROM DA1.dbo.KhuyenMai WHERE TrangThai=?";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLKhuyenMai> listQLKM=new ArrayList<>();
            ps.setObject(1, trangThai);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLKhuyenMai qLKhuyenMai=new QLKhuyenMai(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getInt(8));
                listQLKM.add(qLKhuyenMai);
            }
            return listQLKM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    @Override
    public List<QLKhuyenMai> getSearchLoaiKMTien(int loaiKM) {
        String query="SELECT Ma, Ten, LoaiKM, NgayBatDau, NgayKetThuc, MucGiamGiaPhanTram, MucGiamGiaTienMat, TrangThai\n" +
                "           FROM DA1.dbo.KhuyenMai WHERE LoaiKM=1";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLKhuyenMai> listQLKM=new ArrayList<>();
            ps.setObject(1, loaiKM);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLKhuyenMai qLKhuyenMai=new QLKhuyenMai(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getInt(8));
                listQLKM.add(qLKhuyenMai);
            }
            return listQLKM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QLKhuyenMai> getSearchTTCHD(int trangThai) {
        String query="SELECT Ma, Ten, LoaiKM, NgayBatDau, NgayKetThuc, MucGiamGiaPhanTram, MucGiamGiaTienMat, TrangThai\n" +
                "           FROM DA1.dbo.KhuyenMai WHERE TrangThai=1";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLKhuyenMai> listQLKM=new ArrayList<>();
            ps.setObject(1, trangThai);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLKhuyenMai qLKhuyenMai=new QLKhuyenMai(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDouble(7),rs.getInt(8));
                listQLKM.add(qLKhuyenMai);
            }
            return listQLKM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QLKhuyenMai> getList() {
        String query="SELECT Id, Ma, Ten, LoaiKM, NgayBatDau, NgayKetThuc, MucGiamGiaPhanTram, MucGiamGiaTienMat, TrangThai\n" +
                    "           FROM DA1.dbo.KhuyenMai";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLKhuyenMai> listQLKM=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                QLKhuyenMai qLKhuyenMai=new QLKhuyenMai(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getInt(9));
                listQLKM.add(qLKhuyenMai);
            }
            return listQLKM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }


    
}
