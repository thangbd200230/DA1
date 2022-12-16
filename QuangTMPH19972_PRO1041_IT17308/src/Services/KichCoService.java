/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KichCo;
import ViewModels.QLKichCo;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public interface KichCoService {
    List<KichCo> getAll();
    
    List<QLKichCo> getList();
    
    String add(KichCo kichCo);
    
    String update(KichCo kichCo,String ma);
    
    String delete(String ma);
}
