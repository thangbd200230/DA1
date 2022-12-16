/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.HoaDonChiTiet;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface HoaDonChiTietService {
    String saveHoaDonCT(HoaDonChiTiet hoaDonChiTiet);
    String deleteHoanDonCT(String id);
    List<HoaDonChiTiet> getAll();
    String delete(String idHD, String idCTSP);
    List<HoaDonChiTiet> getDataByID(String id);
}
