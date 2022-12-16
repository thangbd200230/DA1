/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.Impl;

import DomainModels.SanPham_KhuyenMai;
import Repositories.SanPham_KMRepository;
import Utilities.DBConnection;
import ViewModels.QLSanPham_KhuyenMai;
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
public class SanPham_KMRepositoryImpl implements SanPham_KMRepository{

    @Override
    public List<QLSanPham_KhuyenMai> getAll() {
        String query="SELECT KhuyenMai.Ten, SanPham.Ma, SanPham.Ten, ChiTietSP.GiaBan , ChiTietSP.GiaBan * (100-KhuyenMai.MucGiamGiaPhanTram)/100 - KhuyenMai.MucGiamGiaTienMat\n" +
                    "               FROM SanPham_KhuyenMai\n" +
                    "               INNER JOIN ChiTietSP ON SanPham_KhuyenMai.IdSPKM = ChiTietSP.IdChiTietSP \n" +
                    "               INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id \n" +
                    "               INNER JOIN KhuyenMai ON SanPham_KhuyenMai.IdKM = KhuyenMai.Id ";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLSanPham_KhuyenMai> listQLSPKM=new ArrayList<>();
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                QLSanPham_KhuyenMai qLSanPham_KhuyenMai=new QLSanPham_KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5));
                listQLSPKM.add(qLSanPham_KhuyenMai);
            }
            return listQLSPKM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

//        public static void main(String[] args) {
//        List<QLSanPham_KhuyenMai> lists = new SanPham_KMRepositoryImpl().getAll();
//        for (QLSanPham_KhuyenMai dv : lists) {
//            System.out.println(dv.toString());
//        }
//    }
    public static void main(String[] args) {
        SanPham_KhuyenMai dv = new SanPham_KhuyenMai("109BC5DD-A6C8-4B9B-BF0E-55D042EEEC01", "45B98959-F757-44CD-9EC6-373DFEB1277A");
        boolean testAdd = new SanPham_KMRepositoryImpl().add(dv);
        System.out.println(testAdd);//cua add
    }
        
    @Override
    public boolean add(SanPham_KhuyenMai sp_KM) {
        String query="INSERT INTO DA1.dbo.SanPham_KhuyenMai\n" +
                "               (IdKM, IdSPKM)\n" +
                "               VALUES(?, ?)";
        int check=0;
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            ps.setObject(1, sp_KM.getIdKM());
            ps.setObject(2, sp_KM.getIdCTSP());
            check=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }

    @Override
    public List<QLSanPham_KhuyenMai> getOne(String ma) {
        String query="SELECT KhuyenMai.Ten, SanPham.Ma, SanPham.Ten, ChiTietSP.GiaBan , ChiTietSP.GiaBan * (100-KhuyenMai.MucGiamGiaPhanTram)/100 - KhuyenMai.MucGiamGiaTienMat\n" +
                    "               FROM SanPham_KhuyenMai\n" +
                    "               INNER JOIN ChiTietSP ON SanPham_KhuyenMai.IdSPKM = ChiTietSP.IdChiTietSP \n" +
                    "               INNER JOIN SanPham ON ChiTietSP.IdSP = SanPham.Id \n" +
                    "               INNER JOIN KhuyenMai ON SanPham_KhuyenMai.IdKM = KhuyenMai.Id "
                +   "               WHERE SanPham.Ma=?";
        try(Connection con=DBConnection.getConnection();
                PreparedStatement ps=con.prepareStatement(query);) {
            List<QLSanPham_KhuyenMai> listQLSPKM=new ArrayList<>();
            ps.setObject(1, ma);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                QLSanPham_KhuyenMai qLSanPham_KhuyenMai=new QLSanPham_KhuyenMai(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5));
                listQLSPKM.add(qLSanPham_KhuyenMai);
            }
            return listQLSPKM;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
