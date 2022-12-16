/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.ChiTietSP;
import Repositories.ChiTietSPRepository;
import Utilities.DBConnection;
import ViewModels.QLChiTietSP;
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
public class ChiTietSPRepositoryImpl implements ChiTietSPRepository {

    @Override
    public List<QLChiTietSP> getAll() {
        String query = "SELECT IdChiTietSP, SanPham.Ma, SanPham.Ten, MauSac.Ten, ChatLieu.Ten, KieuDang.Ten, KichCo.Ten, DongSP.Ten, NSX.Ten, GiaBan, GiaNhap, SoLuongTon, MoTa, ChiTietSP.TrangThai FROM ChiTietSP \n"
                + "               INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id \n"
                + "               INNER JOIN MauSac ON ChiTietSP.IdMauSac = MauSac.Id \n"
                + "               INNER JOIN ChatLieu ON ChiTietSP.IdChatLieu = ChatLieu.Id \n"
                + "               INNER JOIN KieuDang ON ChiTietSP.IdKieuDang = KieuDang.Id \n"
                + "               INNER JOIN KichCo ON ChiTietSP.IdKichCo = KichCo.Id \n"
                + "               INNER JOIN DongSP ON ChiTietSP.IdDongSP = DongSP.Id \n"
                + "               INNER JOIN NSX ON ChiTietSP.IdNsx = NSX.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<QLChiTietSP> listQLCTSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLChiTietSP qLChiTietSP = new QLChiTietSP(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10), rs.getDouble(11), rs.getInt(12), rs.getString(13), rs.getInt(14));
                listQLCTSP.add(qLChiTietSP);
            }
            return listQLCTSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QLChiTietSP> getOne(String ma) {
        String query = "SELECT IdChiTietSP, SanPham.Ma, SanPham.Ten, MauSac.Ten, ChatLieu.Ten, KieuDang.Ten, KichCo.Ten, DongSP.Ten, NSX.Ten, GiaBan, GiaNhap, SoLuongTon, MoTa, ChiTietSP.TrangThai FROM ChiTietSP \n"
                + "                   INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id \n"
                + "                   INNER JOIN MauSac ON ChiTietSP.IdMauSac = MauSac.Id \n"
                + "                   INNER JOIN ChatLieu ON ChiTietSP.IdChatLieu = ChatLieu.Id \n"
                + "                   INNER JOIN KieuDang ON ChiTietSP.IdKieuDang = KieuDang.Id \n"
                + "                   INNER JOIN KichCo ON ChiTietSP.IdKichCo = KichCo.Id \n"
                + "                   INNER JOIN DongSP ON ChiTietSP.IdDongSP = DongSP.Id \n"
                + "                   INNER JOIN NSX ON ChiTietSP.IdNsx = NSX.Id WHERE SanPham.Ma=?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<QLChiTietSP> listQLCTSP = new ArrayList<>();
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLChiTietSP qLChiTietSP = new QLChiTietSP(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10), rs.getDouble(11), rs.getInt(12), rs.getString(13), rs.getInt(14));
                listQLCTSP.add(qLChiTietSP);
            }
            return listQLCTSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(ChiTietSP chiTietSP) {
        String query = "INSERT INTO DA1.dbo.ChiTietSP\n"
                + "               (IdSP, IdNsx, IdMauSac, IdDongSP, IdChatLieu, IdKichCo, IdKieuDang, MoTa, SoLuongTon, GiaNhap, GiaBan, TrangThai)\n"
                + "               VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chiTietSP.getIdSP());
            ps.setObject(2, chiTietSP.getIdNSX());
            ps.setObject(3, chiTietSP.getIdMauSac());
            ps.setObject(4, chiTietSP.getIdDongSP());
            ps.setObject(5, chiTietSP.getIdChatLieu());
            ps.setObject(6, chiTietSP.getIdKichCo());
            ps.setObject(7, chiTietSP.getIdKieuDang());
            ps.setObject(8, chiTietSP.getMoTa());
            ps.setObject(9, chiTietSP.getSoLuong());
            ps.setObject(10, chiTietSP.getGiaNhap());
            ps.setObject(11, chiTietSP.getGiaBan());
            ps.setObject(12, chiTietSP.getTrangThai());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(ChiTietSP chiTietSP, String id) {
        String query = " UPDATE DA1.dbo.ChiTietSP\n"
                + "               SET IdSP=?, IdNsx=?, IdMauSac=?, IdDongSP=?, IdChatLieu=?, IdKichCo=?, IdKieuDang=?, MoTa=?, SoLuongTon=?, GiaNhap=?, GiaBan=?, TrangThai=?\n"
                + "               WHERE IdChiTietSP=? ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chiTietSP.getIdSP());
            ps.setObject(2, chiTietSP.getIdNSX());
            ps.setObject(3, chiTietSP.getIdMauSac());
            ps.setObject(4, chiTietSP.getIdDongSP());
            ps.setObject(5, chiTietSP.getIdChatLieu());
            ps.setObject(6, chiTietSP.getIdKichCo());
            ps.setObject(7, chiTietSP.getIdKieuDang());
            ps.setObject(8, chiTietSP.getMoTa());
            ps.setObject(9, chiTietSP.getSoLuong());
            ps.setObject(10, chiTietSP.getGiaNhap());
            ps.setObject(11, chiTietSP.getGiaBan());
            ps.setObject(12, chiTietSP.getTrangThai());
            ps.setObject(13, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        String query = " DELETE FROM DA1.dbo.ChiTietSP\n"
                + "           WHERE IdChiTietSP=?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<QLChiTietSP> lists = new ChiTietSPRepositoryImpl().getAll();
        for (QLChiTietSP dv : lists) {
            System.out.println(dv.toString());
        }
    }
//    public static void main(String[] args) {
//        ChiTietSP dv = new ChiTietSP(null, null, null, null, null, null, null, null, null, 15000, 10000, 23, "Dep", 0);
//        boolean testAdd = new ChiTietSPRepositoryImpl().update(dv, "3921BF17-8556-4AA5-ADD4-E0D0971E63AB");
//        System.out.println(testAdd);//cua add
//    }

    @Override
    public List<QLChiTietSP> getList() {
        String query = "SELECT SanPham.Ma, SanPham.Ten, MauSac.Ten, ChatLieu.Ten, KieuDang.Ten, KichCo.Ten, DongSP.Ten, NSX.Ten, GiaBan, GiaNhap, SoLuongTon, MoTa FROM ChiTietSP \n"
                + "               INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id \n"
                + "               INNER JOIN MauSac ON ChiTietSP.IdMauSac = MauSac.Id \n"
                + "               INNER JOIN ChatLieu ON ChiTietSP.IdChatLieu = ChatLieu.Id \n"
                + "               INNER JOIN KieuDang ON ChiTietSP.IdKieuDang = KieuDang.Id \n"
                + "               INNER JOIN KichCo ON ChiTietSP.IdKichCo = KichCo.Id \n"
                + "               INNER JOIN DongSP ON ChiTietSP.IdDongSP = DongSP.Id \n"
                + "               INNER JOIN NSX ON ChiTietSP.IdNsx = NSX.Id ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<QLChiTietSP> listQLCTSP = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLChiTietSP qLChiTietSP = new QLChiTietSP(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getDouble(10), rs.getInt(11), rs.getString(12));
                listQLCTSP.add(qLChiTietSP);
            }
            return listQLCTSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean updateSoLuongSP(QLChiTietSP qLChiTietSP, String idCTSP) {
        String query = " UPDATE DA1.dbo.ChiTietSP\n"
                + "               SET SoLuongTon=?\n"
                + "               WHERE IdChiTietSP=? ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, qLChiTietSP.getSoLuong());
            ps.setObject(2, idCTSP);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public List<QLChiTietSP> getSoLuongById(String id) {
        String query = "SELECT SoLuongTon\n"
                + "         FROM     DA1.dbo.ChiTietSP Where IdChiTietSP = ?";
        List<QLChiTietSP> listQLCTSP = new ArrayList<>();
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLChiTietSP qLChiTietSP = new QLChiTietSP(rs.getInt(1));
                listQLCTSP.add(qLChiTietSP);
            }
            return listQLCTSP;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QLChiTietSP> SearchTrangThai(int trangThai) {
        String query = "SELECT IdChiTietSP, SanPham.Ma, SanPham.Ten, MauSac.Ten, ChatLieu.Ten, KieuDang.Ten, KichCo.Ten, DongSP.Ten, NSX.Ten, GiaBan, GiaNhap, SoLuongTon, MoTa, ChiTietSP.TrangThai FROM ChiTietSP \n"
                + "                              INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id \n"
                + "                               INNER JOIN MauSac ON ChiTietSP.IdMauSac = MauSac.Id \n"
                + "                               INNER JOIN ChatLieu ON ChiTietSP.IdChatLieu = ChatLieu.Id \n"
                + "                              INNER JOIN KieuDang ON ChiTietSP.IdKieuDang = KieuDang.Id \n"
                + "                             INNER JOIN KichCo ON ChiTietSP.IdKichCo = KichCo.Id \n"
                + "                               INNER JOIN DongSP ON ChiTietSP.IdDongSP = DongSP.Id \n"
                + "                              INNER JOIN NSX ON ChiTietSP.IdNsx = NSX.Id where ChiTietSP.TrangThai= ?";

        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, trangThai);
            List<QLChiTietSP> listSanPham = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLChiTietSP qlsp = new QLChiTietSP(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10), rs.getDouble(11), rs.getInt(12), rs.getString(13), rs.getInt(14));
                listSanPham.add(qlsp);
            }
            return listSanPham;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
