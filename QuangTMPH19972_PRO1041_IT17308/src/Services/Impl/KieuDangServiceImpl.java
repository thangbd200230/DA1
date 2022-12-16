/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.KieuDang;
import Repositories.Impl.KieuDangRepositoryImpl;
import Repositories.KieuDangRepository;
import Services.KieuDangService;
import ViewModels.QLKieuDang;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class KieuDangServiceImpl implements KieuDangService{

    private KieuDangRepository kieuDangRepository=new KieuDangRepositoryImpl();
    @Override
    public List<KieuDang> getAll() {
        return kieuDangRepository.getAll();
    }

    @Override
    public String add(KieuDang kieuDang) {
        boolean testAdd=kieuDangRepository.add(kieuDang);
        if(testAdd){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KieuDang kieuDang, String ma) {
        boolean testUpdate=kieuDangRepository.update(kieuDang, ma);
        if(testUpdate){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean testDelete =kieuDangRepository.delete(ma);
        if(testDelete){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<QLKieuDang> getList() {
        return kieuDangRepository.getList();
    }
    
}
