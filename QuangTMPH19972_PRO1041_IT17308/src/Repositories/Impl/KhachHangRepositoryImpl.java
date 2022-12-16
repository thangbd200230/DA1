/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.KhachHang;
import Repositories.KhachHangRepository;
import Utilities.DBConnection;
import ViewModels.QlKhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thang
 */
public class KhachHangRepositoryImpl implements KhachHangRepository {

    @Override
    public List<QlKhachHang> getAll() {
        String query = "select Ma,Ten,GioiTinh,NgaySinh,Sdt,DiaChi,TrangThai  from KhachHang";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<QlKhachHang> listqlkhachhang = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QlKhachHang qlkhachhang = new QlKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                listqlkhachhang.add(qlkhachhang);
            }
            return listqlkhachhang;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public QlKhachHang getOne(String ma) {
        String query = "select Ma,Ten,GioiTinh,NgaySinh,Sdt,DiaChi,TrangThai  from KhachHang where Ma = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                QlKhachHang qlkhachhang = new QlKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                return qlkhachhang;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(KhachHang khachHang) {
        String query = "INSERT INTO [dbo].[KhachHang]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[Sdt]\n"
                + "           ,[DiaChi]\n"
                + "           ,[TrangThai])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?) ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, khachHang.getMa());
            ps.setObject(2, khachHang.getTen());
            ps.setObject(3, khachHang.getGioiTinh());
            ps.setObject(4, khachHang.getNgaySinh());
            ps.setObject(5, khachHang.getSdt());
            ps.setObject(6, khachHang.getDiaChi());
            ps.setObject(7, khachHang.getTrangThai());

            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(KhachHang khachHang, String Ma) {
        String query = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [Ten] = ? \n"
                + "      ,[GioiTinh] = ? \n"
                + "      ,[NgaySinh] = ? \n"
                + "      ,[Sdt] = ? \n"
                + "      ,[DiaChi] = ? \n"
                + "      ,[TrangThai] = ? \n"
                + " WHERE Ma= ? ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, khachHang.getTen());
            ps.setObject(2, khachHang.getGioiTinh());
            ps.setObject(3, khachHang.getNgaySinh());
            ps.setObject(4, khachHang.getSdt());
            ps.setObject(5, khachHang.getDiaChi());
            ps.setObject(6, khachHang.getTrangThai());
            ps.setObject(7, Ma);

            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String Ma) {
        String query = "DELETE FROM [dbo].[KhachHang]\n"
                + " WHERE Ma= ? ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Ma);
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public List<QlKhachHang> Search(String ma) {
        String query = "select Ma,Ten,GioiTinh,NgaySinh,Sdt,DiaChi,TrangThai  from KhachHang where Ma=?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            List<QlKhachHang> listqlkhachhang = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QlKhachHang qlkhachhang = new QlKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                listqlkhachhang.add(qlkhachhang);
            }
            return listqlkhachhang;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QlKhachHang> SearchTrangThai(int trangthai) {
        String query = "select Ma,Ten,GioiTinh,NgaySinh,Sdt,DiaChi,TrangThai  from KhachHang where TrangThai=?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, trangthai);
            List<QlKhachHang> listqlkhachhang = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                  QlKhachHang qlkhachhang = new QlKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));               
                listqlkhachhang.add(qlkhachhang);
            }
            return listqlkhachhang;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
