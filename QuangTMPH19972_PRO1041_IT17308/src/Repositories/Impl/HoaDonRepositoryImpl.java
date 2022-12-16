/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.HoaDon;
import Repositories.HoaDonRepository;
import Utilities.DBConnection;
import ViewModels.QLHoaDon;
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
public class HoaDonRepositoryImpl implements HoaDonRepository{

    @Override
    public List<HoaDon> getAll() {
        String query = "SELECT Id, Ma, NgayTao, TenNguoiNhan, TrangThai FROM HoaDon\n";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon=new HoaDon(rs.getString(1),rs.getString(2), rs.getDate(3),rs.getString(4), rs.getInt(5));
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(HoaDon hoaDon) {
        String query = "INSERT INTO DA1.dbo.HoaDon\n"
                + "               (IdNV, Ma, NgayTao, TrangThai)\n"
                + "               VALUES(?, ?, ?, ?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getIdNV());
            ps.setObject(2, hoaDon.getMa());
            ps.setObject(3, hoaDon.getNgayTao());
            ps.setObject(4, hoaDon.getTrangThai());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateThanhToan(HoaDon hoaDon, String ma) {
        String query = "UPDATE DA1.dbo.HoaDon\n"
                + "             SET NgayThanhToan = ?"
                + "             ,TrangThai = ?"
                + "             WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getNgayThanhToan());
            ps.setObject(2, hoaDon.getTrangThai());
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean updateHuy(HoaDon hoaDon, String ma) {
        String query = "UPDATE DA1.dbo.HoaDon\n"
                + "   SET TrangThai = ?"
                + " WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getTrangThai());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean updateTTKH(HoaDon hoaDon, String id) {
        String query = "UPDATE DA1.dbo.HoaDon\n"
                + "         SET IdHTTT=?"
                + "         ,TenNguoiNhan=?"
                + "         ,Sdt=?"
                + "         WHERE Id=?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getIdHTTT());
            ps.setObject(2, hoaDon.getTenNguoiNhan());
            ps.setObject(3, hoaDon.getSdt());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean updateTTKHGiaoHang(HoaDon hoaDon, String id) {
        String query = "UPDATE DA1.dbo.HoaDon\n"
                + "             SET IdHTTT=?"
                + "             ,TienShip = ?"
                + "             ,TenNguoiNhan = ?"
                + "             ,Sdt = ?"
                + "             ,DiaChi = ?"
                + "             ,NgayHen = ?"
                + "             WHERE Id = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getIdHTTT());
            ps.setObject(2, hoaDon.getTienShip());
            ps.setObject(3, hoaDon.getTenNguoiNhan());
            ps.setObject(4, hoaDon.getSdt());
            ps.setObject(5, hoaDon.getDiaChi());
            ps.setObject(6, hoaDon.getNgayHen());
            ps.setObject(7, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public List<HoaDon> getTTKhByID(String id) {
        String query = "SELECT Ma, NgayTao, TenNguoiNhan, Sdt, TrangThai\n"
                + "             FROM DA1.dbo.HoaDon Where Id = ?";
        List<HoaDon> listHD = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(rs.getString(1), rs.getDate(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                listHD.add(hoaDon);
            }
            return listHD;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<HoaDon> getTTKhGiaoHangByID(String id) {
        String query = "SELECT Ma, NgayTao, NgayHen, TenNguoiNhan, DiaChi, Sdt, TrangThai, TienShip\n"
                + "         FROM DA1.dbo.HoaDon Where Id = ?";
        List<HoaDon> listHD = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(rs.getString(1), rs.getDate(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getDouble(8));
                listHD.add(hoaDon);
            }
            return listHD;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateGH(HoaDon hoaDon, String ma) {
        String query = "UPDATE DA1.dbo.HoaDon\n"
                + "             SET TrangThai = ?"
                + "             ,NgayShip = ?"
                + "             ,NgayThanhToan = ?"
                + "             WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getTrangThai());
            ps.setObject(2, hoaDon.getNgayShip());
            ps.setObject(3, hoaDon.getNgayThanhToan());
            ps.setObject(4, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean updateDaGiao(HoaDon hoaDon, String ma) {
        String query = "UPDATE DA1.dbo.HoaDon\n"
                + "             SET TrangThai = ?"
                + "             ,NgayNhan = ?"
                + "             WHERE Ma = ?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getTrangThai());
            ps.setObject(2, hoaDon.getNgayNhan());
            ps.setObject(3, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public List<HoaDon> searchTT(int trangThai) {
        String query = "SELECT Id, Ma, NgayTao, TenNguoiNhan, TrangThai\n" +
                "           FROM DA1.dbo.HoaDon WHERE TrangThai=? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ps.setObject(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon=new HoaDon(rs.getString(1),rs.getString(2), rs.getDate(3),rs.getString(4), rs.getInt(5));
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QLHoaDon> getDaHuy(String ngayBatDau, String ngayKetThuc) {
        String query = "SELECT COUNT(TrangThai) FROM HoaDon WHERE TrangThai=1";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<QLHoaDon> listQLHD = new ArrayList<>();
            ps.setObject(1, ngayBatDau);
            ps.setObject(2, ngayKetThuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLHoaDon qLHoaDon=new QLHoaDon(rs.getInt(1));
                listQLHD.add(qLHoaDon);
            }
            return listQLHD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QLHoaDon> getDaTT(String ngayBatDau, String ngayKetThuc) {
        String query = "SELECT COUNT(TrangThai) FROM HoaDon WHERE TrangThai=1";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<QLHoaDon> listQLHD = new ArrayList<>();
            ps.setObject(1, ngayBatDau);
            ps.setObject(2, ngayKetThuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLHoaDon qLHoaDon=new QLHoaDon(rs.getInt(1));
                listQLHD.add(qLHoaDon);
            }
            return listQLHD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        List<QLHoaDon> lists = new HoaDonRepositoryImpl().getDaHuy("2022-11-24", "2022-11-25");
        for (QLHoaDon dv : lists) {
            System.out.println(dv.toString());
        }
    }

    @Override
    public List<HoaDon> getOne(String ma) {
        String query = "SELECT Id, Ma, NgayTao, TenNguoiNhan, TrangThai\n" +
                "           FROM DA1.dbo.HoaDon WHERE Ma=?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<HoaDon> listHoaDon = new ArrayList<>();
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon=new HoaDon(rs.getString(1),rs.getString(2), rs.getDate(3),rs.getString(4), rs.getInt(5));
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
