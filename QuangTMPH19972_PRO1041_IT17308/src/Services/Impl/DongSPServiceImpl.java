/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.DongSP;
import Repositories.DongSPRepository;
import Repositories.Impl.DongSPRepositoryImpl;
import Services.DongSPService;
import ViewModels.QLDongSP;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class DongSPServiceImpl implements DongSPService{

    private DongSPRepository dongSPRepository=new DongSPRepositoryImpl();
    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.getAll();
    }

    @Override
    public List<QLDongSP> getList() {
        return dongSPRepository.getList();
    }

    @Override
    public String add(DongSP dongSP) {
        boolean testAdd=dongSPRepository.add(dongSP);
        if(testAdd){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(DongSP dongSP, String ma) {
        boolean testUpdate=dongSPRepository.update(dongSP, ma);
        if(testUpdate){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean testDelete =dongSPRepository.delete(ma);
        if(testDelete){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }
    
}
