/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.HoaDon;
import Repositories.HoaDonRepository;
import Repositories.Impl.HoaDonRepositoryImpl;
import Services.HoaDonService;
import ViewModels.QLHoaDon;
import java.util.List;


/**
 *
 * @author truongmanhquang
 */
public class HoaDonServiceImpl implements HoaDonService{

    private HoaDonRepository hoaDonRepository=new HoaDonRepositoryImpl();
    @Override
    public List<HoaDon> getAll() {
        return hoaDonRepository.getAll();
    }

    @Override
    public boolean add(HoaDon hoaDon) {
        return hoaDonRepository.add(hoaDon);
    }

    @Override
    public String updateThanhToan(HoaDon hoaDon, String ma) {
        boolean testUpdateTT= hoaDonRepository.updateThanhToan(hoaDon, ma);
        if(testUpdateTT){
            return "Thanh toán thành công";
        }else{
            return "Thanh toán thất bại";
        }
    }

    @Override
    public String updateHuy(HoaDon hoaDon, String ma) {
        boolean testUpdateHuy= hoaDonRepository.updateHuy(hoaDon, ma);
        if(testUpdateHuy){
            return "Huỷ hoá đơn thành công";
        }else{
            return "Huỷ hoá đơn thất bại";
        }
    }

    @Override
    public boolean updateTTKH(HoaDon hoaDon, String id) {
        return hoaDonRepository.updateTTKH(hoaDon, id);
    }

    @Override
    public boolean updateTTKHGiaoHang(HoaDon hoaDon, String id) {
         return hoaDonRepository.updateTTKHGiaoHang(hoaDon, id);
    }

    @Override
    public List<HoaDon> getTTKhByID(String id) {
        return hoaDonRepository.getTTKhByID(id);
    }

    @Override
    public List<HoaDon> getTTKhGiaoHangByID(String id) {
        return hoaDonRepository.getTTKhGiaoHangByID(id);
    }

    @Override
    public String updateGH(HoaDon hoaDon, String ma) {
        boolean testUpdateGH= hoaDonRepository.updateGH(hoaDon, ma);
        if(testUpdateGH){
            return "Đang giao hàng";
        }else{
            return "Không giao hàng thành công";
        }
    }

    @Override
    public String updateDaGiao(HoaDon hoaDon, String ma) {
        boolean testUpdateDaGiao= hoaDonRepository.updateDaGiao(hoaDon, ma);
        if(testUpdateDaGiao){
            return "Giao hàng thành công";
        }else{
            return "Không giao hàng thành công";
        }
    }

    @Override
    public List<HoaDon> searchTT(int trangThai) {
        return hoaDonRepository.searchTT(trangThai);
    }

    @Override
    public List<QLHoaDon> getDaHuy(String ngayBatDau, String ngayKetThuc) {
        return hoaDonRepository.getDaHuy(ngayBatDau, ngayKetThuc);
    }

    @Override
    public List<QLHoaDon> getDaTT(String ngayBatDau, String ngayKetThuc) {
        return hoaDonRepository.getDaTT(ngayBatDau, ngayKetThuc);
    }

    @Override
    public List<HoaDon> getOne(String ma) {
        return hoaDonRepository.getOne(ma);
    }

}
