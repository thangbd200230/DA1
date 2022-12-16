/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.DoiMatKhauJpanel;
import View.HoaDonJpanel;
import View.Home;
import View.KhachHangJpanel;
import View.KhuyenMaiJpanel;
import View.NhanVienJpanel;
import View.SanPhamJpanel;
import View.ThongKeJpanel;
import View.ViewDangNhap;
import ViewModels.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author truongmanhquang
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected="";
    
    private List<DanhMucBean> listItem=null;
    
    public ChuyenManHinhController(JPanel jpnRoot){
        this.root=jpnRoot;
    }
    
    public void setView(JPanel jpnItem,JLabel jlbItem){
        kindSelected="ThongKe";
        
        jpnItem.setBackground(new Color(255,255,153));
        jlbItem.setBackground(new Color(255,255,153));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new Home());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem=listItem;
        
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "ThongKe":
                    node=new ThongKeJpanel();
                    break;
                case "HoaDon":
                    node=new HoaDonJpanel();
                    break;
                case "SanPham":
                    node=new SanPhamJpanel();
                    break;
                case "NhanVien":
                    node=new NhanVienJpanel();
                    break;
                case "KhuyenMai":
                    node=new KhuyenMaiJpanel();
                    break;
                case "KhachHang":
                    node=new KhachHangJpanel();
                    break;
                case "DoiMatKhau":
                    node=new DoiMatKhauJpanel();
                    break;
//                case "Thoat":
//                    
//                    break;
                default:
                    System.exit(0);
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected=kind;
            jpnItem.setBackground(new Color(255,255,153));//
            jlbItem.setBackground(new Color(255,255,153));//255,255,153
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(76,175,80));//255,255,153
            jlbItem.setBackground(new Color(76,175,80));//255,255,153
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(255,255,153));//
                jlbItem.setBackground(new Color(255,255,153));
            }
        }
        
        private void setChangeBackground(String kind){
            for (DanhMucBean item : listItem) {
                if(item.getKind().equalsIgnoreCase(kind)){
                    item.getJlb().setBackground(new Color(76,175,80));
                    item.getJpn().setBackground(new Color(76,175,80));
                }else{
                    item.getJlb().setBackground(new Color(255,255,153));
                    item.getJpn().setBackground(new Color(255,255,153));
                }
            }
        }
    }
}
