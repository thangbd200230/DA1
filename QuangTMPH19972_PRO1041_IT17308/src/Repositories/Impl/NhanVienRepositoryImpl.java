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
        String query = "SELECT dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.Sdt, dbo.NhanVien.DiaChi, dbo.NhanVien.TrangThai, dbo.ChucVu.Ten \n"
                + "FROM     dbo.NhanVien INNER JOIN\n"
                + "                  dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<QLNhanVien> listqlNhanVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));

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
        String query = "SELECT dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.Sdt, dbo.NhanVien.DiaChi, dbo.NhanVien.TrangThai, dbo.ChucVu.Ten \n"
                + "FROM     dbo.NhanVien INNER JOIN\n"
                + "                  dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id where Ma = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));

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
                + "           ,[GioiTinh]\n"
                + "           ,[NgaySinh]\n"
                + "           ,[Sdt]\n"
                + "           ,[DiaChi]\n"
                + "           ,[TrangThai]\n"
                + "           ,[IdCV])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, NhanVien.getMa());
            ps.setObject(2, NhanVien.getTen());
            ps.setObject(3, NhanVien.getGioiTinh());
            ps.setObject(4, NhanVien.getNgaySinh());
            ps.setObject(5, NhanVien.getSdt());
            ps.setObject(6, NhanVien.getDiaChi());
            ps.setObject(7, NhanVien.getTrangThai());
            ps.setObject(8, NhanVien.getChucVu());

            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(NhanVien NhanVien, String ma) {
        String query = " UPDATE [dbo].[NhanVien]\n"
                + "         SET [Ten] = ? \n"
                + "      ,[GioiTinh] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + "      ,[Sdt] = ?\n"
                + "      ,[DiaChi] = ?\n"
                + "      ,[TrangThai] = ?\n"
                + "       ,[IdCV] =  ?\n"
                + "         WHERE Ma= ? ";
        int check = 0;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {

            ps.setObject(1, NhanVien.getTen());
            ps.setObject(2, NhanVien.getGioiTinh());
            ps.setObject(3, NhanVien.getNgaySinh());
            ps.setObject(4, NhanVien.getSdt());
            ps.setObject(5, NhanVien.getDiaChi());
            ps.setObject(6, NhanVien.getTrangThai());
            ps.setObject(7, NhanVien.getChucVu());
            ps.setObject(8, ma);

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
        String query = " SELECT dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.Sdt, dbo.NhanVien.DiaChi, dbo.NhanVien.TrangThai, dbo.ChucVu.Ten \n"
                + "FROM     dbo.NhanVien INNER JOIN\n"
                + "                  dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id where Ma = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            List<QLNhanVien> listqlNhanVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
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
        String query = " SELECT dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.Sdt, dbo.NhanVien.DiaChi, dbo.NhanVien.TrangThai, dbo.ChucVu.Ten \n"
                + "FROM     dbo.NhanVien INNER JOIN\n"
                + "                  dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id where TrangThai = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, trangThai);
            List<QLNhanVien> listqlNhanVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
                
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
        String query = " SELECT dbo.NhanVien.Ma, dbo.NhanVien.Ten, dbo.NhanVien.GioiTinh, dbo.NhanVien.NgaySinh, dbo.NhanVien.Sdt, dbo.NhanVien.DiaChi, dbo.NhanVien.TrangThai, dbo.ChucVu.Ten \n" +
"FROM     dbo.NhanVien INNER JOIN\n" +
"                  dbo.ChucVu ON dbo.NhanVien.IdCV = dbo.ChucVu.Id where ChucVu = ? ";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chucVu);
            List<QLNhanVien> listqlNhanVien = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                QLNhanVien qlNhanVien = new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));
                
                listqlNhanVien.add(qlNhanVien);
            }
            return listqlNhanVien;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
