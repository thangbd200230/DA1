/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.SanPham;
import ViewModels.QLChiTietSP;
import ViewModels.QLSanPham;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface SanPhamRepository {
    List<SanPham> getAll();
    
    List<QLSanPham> getList();
    
    boolean add(SanPham sp);
    
    boolean update(SanPham sp, String ma);
    
    boolean delete(String ma);
   
}
