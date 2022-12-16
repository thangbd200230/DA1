/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.KichCo;
import Repositories.Impl.KichCoRepositoryImpl;
import Repositories.KichCoRepository;
import Services.KichCoService;
import ViewModels.QLKichCo;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class KichCoServiceImpl implements KichCoService{

    private KichCoRepository kichCoRepository=new KichCoRepositoryImpl();
    @Override
    public List<KichCo> getAll() {
        return kichCoRepository.getAll();
    }

    @Override
    public String add(KichCo kichCo) {
        boolean testAdd=kichCoRepository.add(kichCo);
        if(testAdd){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(KichCo kichCo, String ma) {
        boolean testUpdate=kichCoRepository.update(kichCo, ma);
        if(testUpdate){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean testDelete =kichCoRepository.delete(ma);
        if(testDelete){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<QLKichCo> getList() {
        return kichCoRepository.getList();
    }
    
}
