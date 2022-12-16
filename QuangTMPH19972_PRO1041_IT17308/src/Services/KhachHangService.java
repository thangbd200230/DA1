/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import ViewModels.QlKhachHang;
import java.util.List;

/**
 *
 * @author thang
 */
public interface KhachHangService {

    List<QlKhachHang> getAll();

    QlKhachHang getOne(String ma);

    String add(KhachHang khachHang);

    String update(KhachHang khachHang, String Ma);

    String delete(String Ma);

    List<QlKhachHang> Search(String ma);

    List<QlKhachHang> SearchTrangThai(int trangthai);
}
