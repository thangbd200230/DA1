/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.KhachHang;
import ViewModels.QlKhachHang;
import java.util.List;

/**
 *
 * @author thang
 */
public interface KhachHangRepository {
    List<QlKhachHang> getAll();
    QlKhachHang getOne(String ma);
    boolean add(KhachHang khachHang);
    boolean update(KhachHang khachHang, String Ma);
    boolean delete(String Ma);
    List<QlKhachHang> Search(String ma);
     List<QlKhachHang> SearchTrangThai(int trangthai);
}
