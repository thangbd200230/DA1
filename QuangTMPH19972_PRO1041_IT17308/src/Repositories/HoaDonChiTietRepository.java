/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface HoaDonChiTietRepository {
    boolean saveHoaDonCT(HoaDonChiTiet hoaDonChiTiet);
    
    boolean deleteHoanDonCT(String id);
    
    List<HoaDonChiTiet> getAll();
    
    boolean delete(String idHD, String idCTSP);
    
    List<HoaDonChiTiet> getDataByID(String id);
}
