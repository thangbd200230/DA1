/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.ChatLieu;
import Repositories.ChatLieuRepository;
import Repositories.Impl.ChatLieuRepositoryImpl;
import Services.ChatLieuService;
import ViewModels.QLChatLieu;
import java.util.List;

/**
 *
 * @author truongmanhquang
 */
public class ChatLieuServiceImpl implements ChatLieuService{
            
    private ChatLieuRepository ChatLieuRepository=new ChatLieuRepositoryImpl();
    @Override
    public List<ChatLieu> getAll() {
        return ChatLieuRepository.getAll();
    }

    @Override
    public String add(ChatLieu chatLieu) {
        boolean testAdd=ChatLieuRepository.add(chatLieu);
        if(testAdd){
            return "Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
    }

    @Override
    public String update(ChatLieu chatLieu, String ma) {
        boolean testUpdate=ChatLieuRepository.update(chatLieu, ma);
        if(testUpdate){
            return "Sửa thành công";
        }else{
            return "Sửa thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean testDelete =ChatLieuRepository.delete(ma);
        if(testDelete){
            return "Xoá thành công";
        }else{
            return "Xoá thất bại";
        }
    }

    @Override
    public List<QLChatLieu> getList() {
        return ChatLieuRepository.getList();
    }
    
}
