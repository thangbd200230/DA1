/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDon;
import ViewModels.QLHoaDon;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface HoaDonService {
    List<HoaDon> getAll();
    
    List<HoaDon> searchTT(int trangThai);
            
    boolean add(HoaDon hoaDon);
    
    String updateThanhToan(HoaDon hoaDon, String ma);
    
    String updateHuy(HoaDon hoaDon, String ma);
    
    String updateGH(HoaDon hoaDon,String ma);
    
    String updateDaGiao(HoaDon hoaDon,String ma);
    
    boolean updateTTKH(HoaDon hoaDon, String id);
    
    boolean updateTTKHGiaoHang(HoaDon hoaDon, String id);
    
    List<HoaDon> getTTKhByID(String id);
    
    List<HoaDon> getTTKhGiaoHangByID(String id);
    
    List<QLHoaDon> getDaHuy(String ngayBatDau,String ngayKetThuc);
    
    List<QLHoaDon> getDaTT(String ngayBatDau,String ngayKetThuc);
    
    List<HoaDon> getOne(String ma);
}
