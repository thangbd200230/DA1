/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.HoaDonChiTiet;
import Repositories.HoaDonChiTietRepository;
import Repositories.Impl.HoaDonChiTietRepositoryImpl;
import Services.HoaDonChiTietService;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService{

    private HoaDonChiTietRepository hoaDonChiTietRepository=new HoaDonChiTietRepositoryImpl();
    @Override
    public String saveHoaDonCT(HoaDonChiTiet hoaDonChiTiet) {
        boolean testSaveHD=hoaDonChiTietRepository.saveHoaDonCT(hoaDonChiTiet);
        if(testSaveHD){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String deleteHoanDonCT(String id) {
        boolean testDeleteHDCT= hoaDonChiTietRepository.deleteHoanDonCT(id);
        if(testDeleteHDCT){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepository.getAll();
    }

    @Override
    public String delete(String idHD, String idCTSP) {
        boolean testDelete= hoaDonChiTietRepository.delete(idHD, idCTSP);
        if(testDelete){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<HoaDonChiTiet> getDataByID(String id) {
        return hoaDonChiTietRepository.getDataByID(id);
    }
    
}
