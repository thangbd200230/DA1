/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.KhuyenMai;
import ViewModels.QLKhuyenMai;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface KhuyenMaiRepository {
    List<QLKhuyenMai> getAll();
    List<QLKhuyenMai> getList();
    List<QLKhuyenMai> getOne(String ma);
    List<QLKhuyenMai> getSearchLoaiKMPT(int loaiKM);
    List<QLKhuyenMai> getSearchLoaiKMTien(int loaiKM);
    List<QLKhuyenMai> getSearchTTNHD(int trangThai);
    List<QLKhuyenMai> getSearchTTCHD(int trangThai);
    boolean add(KhuyenMai km);
    boolean update(KhuyenMai km,String ma);
    boolean delete(String ma);
}
