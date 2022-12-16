/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KieuDang;
import ViewModels.QLKieuDang;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface KieuDangService {
    List<KieuDang> getAll();
    
    List<QLKieuDang> getList();
    
    String add(KieuDang kieuDang);
    
    String update(KieuDang kieuDang,String ma);
    
    String delete(String ma);
}
