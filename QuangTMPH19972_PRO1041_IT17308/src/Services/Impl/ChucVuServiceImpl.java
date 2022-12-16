/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import Repositories.ChucVuRepository;
import Repositories.Impl.ChucVuRepositoryImpl;
import Services.ChucVuService;
import ViewModels.QLChucVu;
import java.util.List;

/**
 *
 * @author thang
 */
public class ChucVuServiceImpl implements ChucVuService{
    private ChucVuRepository chucvurepo = new ChucVuRepositoryImpl();
    @Override
    public List<QLChucVu> getAll() {
       return chucvurepo.getAll();
    }
    
}
