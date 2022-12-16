/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.KichCo;
import ViewModels.QLKichCo;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface KichCoRepository {
    List<KichCo> getAll();
    
    List<QLKichCo> getList();
    
    boolean add(KichCo kichCo);
    
    boolean update(KichCo kichCo, String ma);
    
    boolean delete(String ma);
}
