/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.HinhThucThanhToan;
import Repositories.HinhThucThanhToanRepository;
import Repositories.Impl.HinhThucThanhToanRepositoryImpl;
import Services.HinhThucThanhToanService;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class HinhThucThanhToanServiceImp implements HinhThucThanhToanService{

    private HinhThucThanhToanRepository hinhThucThanhToanRepository=new HinhThucThanhToanRepositoryImpl();
    @Override
    public List<HinhThucThanhToan> getAll() {
        return hinhThucThanhToanRepository.getAll();
    }
    
}
