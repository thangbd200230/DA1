/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.HoaDonChiTiet;
import Repositories.HoaDonChiTietRepository;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class HoaDonChiTietRepositoryImpl implements HoaDonChiTietRepository{

    @Override
    public boolean saveHoaDonCT(HoaDonChiTiet hoaDonChiTiet) {
        String query= "INSERT INTO DA1.dbo.HoaDonChiTiet\n" +
                "           (IdHoaDon, IdChiTietSP, SoLuong, DonGia)\n" +
                "           VALUES(?, ?, ?, ?)";
        int check=0;
        try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDonChiTiet.getIdHoaDon());
            ps.setObject(2, hoaDonChiTiet.getIdChiTietSP());
            ps.setObject(3, hoaDonChiTiet.getSoLuong());
            ps.setObject(4, hoaDonChiTiet.getDonGia());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public boolean deleteHoanDonCT(String id) {
        String query= "DELETE FROM DA1.dbo.HoaDonChiTiet\n" +
                "           WHERE IdHoaDonChiTiet=?";
        int check=0;
        try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public List<HoaDonChiTiet> getAll() {
        String query="SELECT ChiTietSP.IdChiTietSP, SanPham.Ma, SanPham.Ten, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia,HoaDonChiTiet.TrangThai  FROM DA1.dbo.HoaDonChiTiet\n" +
                "               INNER JOIN ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.IdChiTietSP \n" +
                "               INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id ";
        try(Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            List<HoaDonChiTiet> listHDCT=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                HoaDonChiTiet hoaDonChiTiet=new HoaDonChiTiet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getInt(6));
                listHDCT.add(hoaDonChiTiet);
            }
            return listHDCT;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean delete(String idHD, String idCTSP) {
        String query = "DELETE FROM DA1.dbo.HoaDonChiTiet\n"
                + "          WHERE IdHoaDon = ? and IdChiTietSP = ?";
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, idHD);
            ps.setObject(2, idCTSP);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public List<HoaDonChiTiet> getDataByID(String id) {
        String query = "SELECT ChiTietSP.IdChiTietSP, SanPham.Ma, SanPham.Ten, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia,HoaDonChiTiet.TrangThai  FROM DA1.dbo.HoaDonChiTiet\n" +
                "               INNER JOIN ChiTietSP ON HoaDonChiTiet.IdChiTietSP = ChiTietSP.IdChiTietSP \n" +
                "               INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id Where dbo.HoaDonChiTiet.IdHoaDon = ?";
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hoaDonChiTiet=new HoaDonChiTiet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getInt(6));
                listHDCT.add(hoaDonChiTiet);
            }
            return listHDCT;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
