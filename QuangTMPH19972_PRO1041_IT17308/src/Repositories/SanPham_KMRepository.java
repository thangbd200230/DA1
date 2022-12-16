/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.SanPham_KhuyenMai;
import ViewModels.QLSanPham_KhuyenMai;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface SanPham_KMRepository {
    List<QLSanPham_KhuyenMai> getAll();
    List<QLSanPham_KhuyenMai> getOne(String ma);
    boolean add(SanPham_KhuyenMai sp_KM);
}
