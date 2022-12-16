/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import ViewModels.QLChiTietSP;
import ViewModels.QLSanPham;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface SanPhamService {
   List<SanPham> getAll();
   
   List<QLSanPham> getList();
   
   String add(SanPham sp);
    
   String update(SanPham sp,String ma);
    
   String delete(String ma);
  
}
