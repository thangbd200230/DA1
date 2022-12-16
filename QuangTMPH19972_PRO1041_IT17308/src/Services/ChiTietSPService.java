/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChiTietSP;
import ViewModels.QLChiTietSP;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface ChiTietSPService {

    List<QLChiTietSP> getAll();

    List<QLChiTietSP> getList();

    List<QLChiTietSP> getOne(String ma);

    List<QLChiTietSP> getSoLuongById(String id);

    String add(ChiTietSP chiTietSP);

    String update(ChiTietSP chiTietSP, String id);

    String delete(String id);

    boolean updateSoLuongSP(QLChiTietSP qLChiTietSP, String idCTSP);

    List<QLChiTietSP> SearchTrangThai(int trangThai);
   
}
