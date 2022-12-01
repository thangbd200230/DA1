/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.NhanVien;
import Repositories.NhanVienRepository;
import Utilities.DBConnection;
import ViewModels.QLNhanVien;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author thang
 */
public class NhanVienRepositoryImpl implements NhanVienRepository {

    @Override
    public List<QLNhanVien> getAll() {
        String query = "select Ma,Ho,TenDem,Ten,GioiTinh,NgaySinh,Sdt,DiaChi,TrangThai,ChucVu  from NhanVien";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<QLNhanVien> listqlNhanVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
                listqlNhanVien.add(qlNhanVien);
            }
            return listqlNhanVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public QLNhanVien getOne(String ma) {
        String query = "select Ma,Ho,TenDem,Ten,GioiTinh,NgaySinh,Sdt,DiaChi,TrangThai,ChucVu  from NhanVien where Ma = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
                return qlNhanVien;
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(NhanVien NhanVien) {
        String query = "INSERT INTO [dbo].[NhanVien]\n"
                + "           ([Ma]\n"
                + "           ,[Ten]\n"
                + "           ,[TenDem]\n"
                + "           ,[Ho]\n"
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[Sdt]\n"
                + "           ,[DiaChi]\n"
                + "           ,[TrangThai]\n"
                + "           ,[ChucVu])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, NhanVien.getMa());
            ps.setObject(2, NhanVien.getTen());
            ps.setObject(3, NhanVien.getTenDem());
            ps.setObject(4, NhanVien.getHo());
            ps.setObject(5, NhanVien.getGioiTinh());
            ps.setObject(6, NhanVien.getNgaySinh());
            ps.setObject(7, NhanVien.getSdt());
            ps.setObject(8, NhanVien.getDiaChi());
            ps.setObject(9, NhanVien.getTrangThai());
            ps.setObject(10, NhanVien.getChucVu());

            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(NhanVien NhanVien, String ma) {
        String query = " UPDATE [dbo].[NhanVien]\n"
                + "   SET [Ten] = ? \n"
                + "      ,[TenDem] = ?\n"
                + "      ,[Ho] = ?\n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "      ,[ChucVu] = ?\n"
                + " WHERE Ma= ? ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, NhanVien.getTen());
            ps.setObject(2, NhanVien.getTenDem());
            ps.setObject(3, NhanVien.getHo());
            ps.setObject(4, NhanVien.getGioiTinh());
            ps.setObject(5, NhanVien.getNgaySinh());
            ps.setObject(6, NhanVien.getSdt());
            ps.setObject(7, NhanVien.getDiaChi());
            ps.setObject(8, NhanVien.getTrangThai());
            ps.setObject(9, NhanVien.getChucVu());
            ps.setObject(10, NhanVien.getMa());

            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(String ma) {
        String query = "DELETE FROM [dbo].[NhanVien]\n"
                + "      WHERE Ma=?";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public List<QLNhanVien> Search(String ma) {
        String query = "select Ma,Ho,TenDem,Ten,GioiTinh,NgaySinh,Sdt,DiaChi,TrangThai,ChucVu  from NhanVien where Ma = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            List<QLNhanVien> listqlNhanVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
                listqlNhanVien.add(qlNhanVien);
            }
            return listqlNhanVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QLNhanVien> SearchTrangThai1(int trangThai) {
        String query = "select Ma,Ho,TenDem,Ten,GioiTinh,NgaySinh,Sdt,DiaChi,TrangThai,ChucVu  from NhanVien where TrangThai = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, trangThai);
            List<QLNhanVien> listqlNhanVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
                listqlNhanVien.add(qlNhanVien);
            }
            return listqlNhanVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<QLNhanVien> SearchTrangThai2(String chucVu) {
        String query = "select Ma,Ho,TenDem,Ten,GioiTinh,NgaySinh,Sdt,DiaChi,TrangThai,ChucVu  from NhanVien where ChucVu = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chucVu);
            List<QLNhanVien> listqlNhanVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
                listqlNhanVien.add(qlNhanVien);
            }
            return listqlNhanVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
