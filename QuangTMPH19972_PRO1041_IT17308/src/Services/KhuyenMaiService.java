/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KhuyenMai;
import ViewModels.QLKhuyenMai;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface KhuyenMaiService {
    List<QLKhuyenMai> getAll();
    List<QLKhuyenMai> getList();
    List<QLKhuyenMai> getOne(String ma);
    List<QLKhuyenMai> getSearchLoaiKMPT(int loaiKM);
    List<QLKhuyenMai> getSearchLoaiKMTien(int loaiKM);
    List<QLKhuyenMai> getSearchTTNHD(int trangThai);
    List<QLKhuyenMai> getSearchTTCHD(int trangThai);
    String add(KhuyenMai km);
    String update(KhuyenMai km,String ma);
    String delete(String ma);
}
