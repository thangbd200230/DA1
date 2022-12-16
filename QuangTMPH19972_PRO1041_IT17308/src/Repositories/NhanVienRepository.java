/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.NhanVien;
import ViewModels.QLNhanVien;
import java.util.List;

/**
 *
 * @author thang
 */
public interface NhanVienRepository {

    List<QLNhanVien> getAll();

    QLNhanVien getOne(String ma);

    boolean add(NhanVien NhanVien);

    boolean update(NhanVien NhanVien, String ma);

    boolean delete(String ma);

    List<QLNhanVien> Search(String ma);

    List<QLNhanVien> SearchTrangThai1(int trangThai);

    List<QLNhanVien> SearchTrangThai2(String chucVu);
}
