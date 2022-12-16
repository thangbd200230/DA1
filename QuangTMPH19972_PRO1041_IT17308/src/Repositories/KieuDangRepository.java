/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.KieuDang;
import ViewModels.QLKieuDang;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface KieuDangRepository {
    List<KieuDang> getAll();
    
    List<QLKieuDang> getList();
    
    boolean add(KieuDang kieuDang);
    
    boolean update(KieuDang kieuDang, String ma);
    
    boolean delete(String ma);
}
