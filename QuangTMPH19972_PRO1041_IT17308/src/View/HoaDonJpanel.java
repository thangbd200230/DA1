/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModels.HinhThucThanhToan;
import DomainModels.HoaDon;
import DomainModels.HoaDonChiTiet;
import DomainModels.KhachHang;
import Services.ChiTietSPService;
import Services.HinhThucThanhToanService;
import Services.HoaDonChiTietService;
import Services.HoaDonService;
import Services.Impl.ChiTietSPServiceImpl;
import Services.Impl.HinhThucThanhToanServiceImp;
import Services.Impl.HoaDonChiTietServiceImpl;
import Services.Impl.HoaDonServiceImpl;
import Services.Impl.KhachHangServiceImpl;
import Services.KhachHangService;
import ViewModels.QLChiTietSP;
import ViewModels.QLHoaDonChiTiet;
import ViewModels.QlKhachHang;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author truongmanhquang
 */
public class HoaDonJpanel extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private HoaDonService hoaDonService = new HoaDonServiceImpl();

    private DefaultTableModel tableChiTietSP;
    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImpl();

    private List<HinhThucThanhToan> listHTTT = new ArrayList<>();
    private HinhThucThanhToanService hinhThucThanhToanService = new HinhThucThanhToanServiceImp();

    private DefaultTableModel tableGioHang;

    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private List<QLHoaDonChiTiet> listQLHDCT = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietServiceImpl();
    private List<HoaDon> listHD = new ArrayList<>();

    private List<KhachHang> listKH = new ArrayList<>();
    private KhachHangService khachHangService = new KhachHangServiceImpl();

    /**
     * Creates new form HoaDonJpanel
     */
    public HoaDonJpanel() {
        initComponents();
        cbbHinhThucThanhToan.setModel(dcbm);
        listHTTT = hinhThucThanhToanService.getAll();
        addCBHTTT(listHTTT);

        addHoaDon(hoaDonService.getAll());
        addChiTietSP(chiTietSPService.getAll());
    }

    private void addCBHTTT(List<HinhThucThanhToan> listHTTT) {
        for (HinhThucThanhToan hinhThucThanhToan : listHTTT) {
            dcbm.addElement(hinhThucThanhToan.getTenHTTT());
        }
    }

    private void addHoaDon(List<HoaDon> listHD) {
        dtm = (DefaultTableModel) tbHoaDon.getModel();
        dtm.setRowCount(0);
        String tenNV = "Quản lý";
        for (HoaDon hoaDon : listHD) {
            dtm.addRow(new Object[]{
                hoaDon.getId(), hoaDon.getMa(), tenNV, hoaDon.getTenNguoiNhan(), hoaDon.getNgayTao(), hoaDon.inTrangThai()
            });
        }
    }

    private void addChiTietSP(List<QLChiTietSP> listQLCTSP) {
        tableChiTietSP = (DefaultTableModel) tbSanPham.getModel();
        tableChiTietSP.setRowCount(0);
        for (QLChiTietSP qLChiTietSP : listQLCTSP) {
            tableChiTietSP.addRow(new Object[]{
                qLChiTietSP.getId(),
                qLChiTietSP.getMaSP(), qLChiTietSP.getTenSP(), qLChiTietSP.getMauSac(), qLChiTietSP.getChatLieu(), qLChiTietSP.getKieuDang(),
                qLChiTietSP.getKichCo(), qLChiTietSP.getDongSP(), qLChiTietSP.getNSX(), qLChiTietSP.getGiaBan(), qLChiTietSP.getGiaNhap(),
                qLChiTietSP.getSoLuong(), qLChiTietSP.getMoTa()
            });
        }
    }

    private void addTableGioHang(List<HoaDonChiTiet> listHDCT) {
        tableGioHang = (DefaultTableModel) tbGioHang.getModel();
        tableGioHang.setRowCount(0);
        for (HoaDonChiTiet hoaDonChiTiet : listHDCT) {
            tableGioHang.addRow(new Object[]{hoaDonChiTiet.getIdChiTietSP(),
                hoaDonChiTiet.getMaSP(), hoaDonChiTiet.getTenSP(), hoaDonChiTiet.getSoLuong(), hoaDonChiTiet.getDonGia(),
                hoaDonChiTiet.getDonGiaKhiGiam(), hoaDonChiTiet.getSoLuong() * hoaDonChiTiet.getDonGia(), hoaDonChiTiet.getTrangThai()
            });
        }
    }

    public void getTongTien() {
        Double sum = 0.0;
        Double tienShip = Double.valueOf(txtTienShip.getText());
        if (txtTienShip.getText().isEmpty()) {
            tienShip = 0.0;
        }
        for (int i = 0; i < tbGioHang.getRowCount(); i++) {
            sum = sum + Double.parseDouble(tbGioHang.getValueAt(i, 6).toString());
        }
        System.out.println(sum);
        Locale locale = new Locale("vi", "VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        jTongTien.setText(format.format(sum));
        jTongTienHang.setText(format.format(sum + tienShip));
        jLabel13.setText(format.format(sum));
        jLabel23.setText(format.format(sum + tienShip));//Float.toString(sum+ tienShip)
    }

    private void capNhapSoLuongTonKho() {
        int rowGH = tbGioHang.getSelectedRow();
        String idSelected = (String) tbGioHang.getValueAt(rowGH, 0);
        int soLuongThemLai = (int) tbGioHang.getValueAt(rowGH, 3);
        List<QLChiTietSP> listSL = chiTietSPService.getSoLuongById(idSelected);
        int soLuongTon = 0;
        for (QLChiTietSP qLChiTietSP : listSL) {
            soLuongTon = qLChiTietSP.getSoLuong();
        }
        System.out.println(soLuongTon);
        System.out.println(soLuongThemLai);
        int soLuongSauKhiXoa = soLuongTon + Integer.valueOf(soLuongThemLai);
        System.out.println(soLuongSauKhiXoa);
        QLChiTietSP qLChiTietSP = new QLChiTietSP(soLuongSauKhiXoa);
        JOptionPane.showMessageDialog(this, chiTietSPService.updateSoLuongSP(qLChiTietSP, idSelected));
        addChiTietSP(chiTietSPService.getAll());
    }

    private void checkTTKH() {
        if (txtTenKH.getText().trim().isEmpty() || txtTenKH.getText() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên KH");
            return;
        }
        if (txtSdt.getText().trim().isEmpty() || txtSdt.getText() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập SĐT");
            return;
        }
    }

    private void checkTTKHGiaoHang() {
        if (txtDiaChiGiaoHang.getText().trim().isEmpty() || txtDiaChiGiaoHang.getText() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ giao hàng");
            return;
        }
        if (txtSDTGiaoHang.getText().trim().isEmpty() || txtSDTGiaoHang.getText() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập SĐT KH");
            return;
        }
        if (txtTenKHGiaoHang.getText().trim().isEmpty() || txtTenKHGiaoHang.getText() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên KH");
            return;
        }
        if (txtTienShip.getText().trim().isEmpty() || txtTienShip.getText() == null) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tiền ship");
            return;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGioHang = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbHinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jTongTien = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTienThua = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtTenKHGiaoHang = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSDTGiaoHang = new javax.swing.JTextField();
        txtDiaChiGiaoHang = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTongTienHang = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTienShip = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbbHinhThucThanhToan1 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        txtTienKhachDuaGH = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTienThuaGH = new javax.swing.JLabel();
        btnTaoHDGH = new javax.swing.JButton();
        btnGH = new javax.swing.JButton();
        btnHuyHoaDonGH = new javax.swing.JButton();
        btnDaGiao = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtNgayHen = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtNgayTaoGH = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtMaHDGH = new javax.swing.JTextField();
        txtTenNVGH = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cbbTrangThaiGH = new javax.swing.JComboBox<>();
        cbbSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Đơn giá khi giảm", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tbGioHang);

        btnXoa.setBackground(new java.awt.Color(153, 204, 255));
        btnXoa.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/3643729_bin_delete_garbage_rubbish_trash_icon 20px.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã SP", "Tên SP", "Màu sắc ", "Chất liệu", "Kiểu dáng", "Kích cỡ", "Dòng sản phẩm", "NSX", "Giá bán ", "Giá nhập", "Số lượng", "Mô tả"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSanPham);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("Danh sách hoá đơn");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã HĐ", "Tên NV", "Tên KH", "Ngày tạo", "Trạng thái"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Danh sách sản phẩm");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Tạo hoá đơn");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("Giỏ hàng");

        jTabbedPane1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel4.setBackground(new java.awt.Color(255, 204, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel5.setText("Tên KH");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel6.setText("SĐT");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel7.setText("Tổng tiền hàng : ");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel8.setText("Khách cần trả : ");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel9.setText("HT Thanh toán");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel10.setText("Tiền khách đưa");

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel11.setText("Tiền thừa : ");

        btnThanhToan.setBackground(new java.awt.Color(153, 255, 204));
        btnThanhToan.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnTaoHoaDon.setBackground(new java.awt.Color(204, 255, 255));
        btnTaoHoaDon.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnTaoHoaDon.setText("Tạo hoá đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(204, 204, 255));
        btnHuy.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnHuy.setText("Huỷ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jTongTien.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jTongTien.setText("0");

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jLabel13.setText("0");

        jTienThua.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jTienThua.setText("0");

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel14.setText("Mã HĐ");

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel20.setText("Tên NV");

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel27.setText("Ngày tạo");

        jLabel28.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel28.setText("Trạng thái");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chờ thanh toán", "Đã thanh toán ", "Đã huỷ", "Đang giao", "Đã giao" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(jTienThua)
                            .addGap(197, 197, 197))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbHinhThucThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTienKhachDua)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jTongTien)))
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel20)
                                                .addComponent(jLabel27)
                                                .addComponent(jLabel28))
                                            .addGap(67, 67, 67)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                                .addComponent(txtMaHD)
                                                .addComponent(txtTenNV)
                                                .addComponent(txtNgayTao)
                                                .addComponent(cbbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTongTien))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTienThua))
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Hoá đơn", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 204, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel15.setText("Tên KH");

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel16.setText("SĐT");

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel17.setText("Địa chỉ");

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel19.setText("Tổng tiền hàng");

        jTongTienHang.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jTongTienHang.setText("0");

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel21.setText("Tiền ship");

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel22.setText("Khách cần trả");

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jLabel23.setText("0");

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel24.setText("HT Thanh toán");

        cbbHinhThucThanhToan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Tài khoản" }));

        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel25.setText("Tiền khách đưa");

        jLabel26.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel26.setText("Tiền thừa");

        jTienThuaGH.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        jTienThuaGH.setText("0");

        btnTaoHDGH.setBackground(new java.awt.Color(153, 255, 204));
        btnTaoHDGH.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnTaoHDGH.setText("Tạo hoá đơn");
        btnTaoHDGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDGHActionPerformed(evt);
            }
        });

        btnGH.setBackground(new java.awt.Color(204, 255, 255));
        btnGH.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnGH.setText("Giao Hàng");
        btnGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGHActionPerformed(evt);
            }
        });

        btnHuyHoaDonGH.setBackground(new java.awt.Color(204, 204, 255));
        btnHuyHoaDonGH.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnHuyHoaDonGH.setText("Huỷ");
        btnHuyHoaDonGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonGHActionPerformed(evt);
            }
        });

        btnDaGiao.setBackground(new java.awt.Color(204, 255, 204));
        btnDaGiao.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnDaGiao.setText("Đã giao");
        btnDaGiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaGiaoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel12.setText("Ngày hẹn");

        jLabel29.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel29.setText("Ngày tạo");

        jLabel30.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel30.setText("Mã HĐ");

        jLabel31.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel31.setText("Tên NV");

        jLabel32.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel32.setText("Trạng thái");

        cbbTrangThaiGH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chờ thanh toán", "Đã thanh toán ", "Đã huỷ", "Đang giao", "Đã giao" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel30)
                                .addGap(38, 38, 38)
                                .addComponent(txtMaHDGH, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(btnGH, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDaGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnTaoHDGH, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                    .addComponent(btnHuyHoaDonGH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel26)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(jTienThuaGH))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTienKhachDuaGH))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txtTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbbHinhThucThanhToan1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(13, 13, 13))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel23))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(30, 30, 30)
                        .addComponent(jTongTienHang))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31)
                            .addComponent(jLabel17)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSDTGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(txtDiaChiGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(txtNgayHen, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(txtTenKHGiaoHang, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(txtNgayTaoGH)
                            .addComponent(txtTenNVGH)
                            .addComponent(cbbTrangThaiGH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtMaHDGH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNVGH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayTaoGH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKHGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtSDTGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChiGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel32)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTrangThaiGH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNgayHen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTongTienHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cbbHinhThucThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtTienKhachDuaGH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTienThuaGH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTaoHDGH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDaGiao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuyHoaDonGH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("Đặt hàng", jPanel5);

        cbbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chờ thanh toán", "Đã thanh toán ", "Đã huỷ", "Đang giao", "Đã giao" }));
        cbbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(255, 153, 102));
        btnTimKiem.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Bản sao 211818_search_icon_20px.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(269, 644, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        int rowSP = tbSanPham.getSelectedRow();
        int rowHD = tbHoaDon.getSelectedRow();
        if (tbHoaDon.isRowSelected(rowHD) == false) {
            btnTaoHoaDon.doClick();
        } else {
            try {

                String input = JOptionPane.showInputDialog("Mời nhập số lượng: ");
                if ((int) tbSanPham.getValueAt(rowSP, 11) < Integer.valueOf(input)) {
                    JOptionPane.showMessageDialog(this, "Số lượng hàng vượt quá số lượng hàng tồn kho");
                    return;
                }
                hoaDonChiTiet.setIdChiTietSP((String) tbSanPham.getValueAt(rowSP, 0));
                hoaDonChiTiet.setMaSP((String) tbSanPham.getValueAt(rowSP, 1));
                hoaDonChiTiet.setTenSP((String) tbSanPham.getValueAt(rowSP, 2));
                hoaDonChiTiet.setSoLuong(Integer.valueOf(input));
                hoaDonChiTiet.setDonGia((Double) tbSanPham.getValueAt(rowSP, 9));
                HoaDonChiTiet hoaDonChiTiet1 = new HoaDonChiTiet((String) tbHoaDon.getValueAt(rowHD, 0), (String) tbSanPham.getValueAt(rowSP, 0), Integer.valueOf(input), (Double) tbSanPham.getValueAt(rowSP, 9));
                hoaDonChiTietService.saveHoaDonCT(hoaDonChiTiet1);
                listHDCT.add(hoaDonChiTiet);
                addTableGioHang(listHDCT);

                //cap nhat lai danh sach sp sau khi them vao gio
                String idCTSP = (String) tbSanPham.getValueAt(rowSP, 0);
                int soLuongSauKhiThem = (int) tbSanPham.getValueAt(rowSP, 11) - Integer.valueOf(input);
                QLChiTietSP qLChiTietSP = new QLChiTietSP(soLuongSauKhiThem);
                JOptionPane.showMessageDialog(this, chiTietSPService.updateSoLuongSP(qLChiTietSP, idCTSP));
                addChiTietSP(chiTietSPService.getAll());
                getTongTien();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn");
            }
        }
    }//GEN-LAST:event_tbSanPhamMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int rowGH = tbGioHang.getSelectedRow();
        int rowHD = tbHoaDon.getSelectedRow();
        String idHD = (String) tbHoaDon.getValueAt(rowHD, 0);
        String idCTSP = (String) tbGioHang.getValueAt(rowGH, 0);
        capNhapSoLuongTonKho();
        JOptionPane.showMessageDialog(this, hoaDonChiTietService.delete(idHD, idCTSP));
        listHDCT = hoaDonChiTietService.getDataByID(idHD);
        addTableGioHang(listHDCT);
        getTongTien();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int row = tbHoaDon.getSelectedRow();
        //tb Giao Hang
        String id = (String) tbHoaDon.getValueAt(row, 0);

        // lay thong tin khach hang
        List<HoaDon> listTTKH = hoaDonService.getTTKhByID(id);
        String maHD;
        String tenNV;
        Date ngayTao;
        String tenKH;
        String Sdt;
        for (HoaDon hoaDon : listTTKH) {
            maHD = hoaDon.getMa();
            ngayTao = hoaDon.getNgayTao();
            tenKH = hoaDon.getTenNguoiNhan();
            Sdt = hoaDon.getSdt();
            txtTenNV.setText("Quản lý");
            txtTenKH.setText(tenKH);
            txtSdt.setText(Sdt);
            txtMaHD.setText(maHD);
            txtNgayTao.setText(String.valueOf(ngayTao));
            cbbTrangThai.setSelectedItem(hoaDon.inTrangThai());
        }
        List<HoaDon> listTTKHGiaoHang = hoaDonService.getTTKhGiaoHangByID(id);
        String tenKHGH;
        String SdtGH;
        String diaChiGH;
        Double tienShip;
        for (HoaDon hoaDonGH : listTTKHGiaoHang) {
            tenKHGH = hoaDonGH.getTenNguoiNhan();
            SdtGH = hoaDonGH.getSdt();
            diaChiGH = hoaDonGH.getDiaChi();
            tienShip = hoaDonGH.getTienShip();
            txtTenNVGH.setText("Quản lý");
            txtDiaChiGiaoHang.setText(diaChiGH);
            txtTenKHGiaoHang.setText(tenKHGH);
            txtSDTGiaoHang.setText(SdtGH);
            txtTienShip.setText(Double.valueOf((Double) tienShip) + "");
            txtMaHDGH.setText(hoaDonGH.getMa());
            txtTenNVGH.setText("Quản lý");
            txtNgayTaoGH.setText(String.valueOf(hoaDonGH.getNgayTao()));
            txtNgayHen.setText(hoaDonGH.getNgayHen());
            cbbTrangThaiGH.setSelectedItem(hoaDonGH.inTrangThai());
        }

        //show len tbhoadon
        listHDCT = hoaDonChiTietService.getDataByID(id);
        addTableGioHang(listHDCT);
        getTongTien();
        if (tbHoaDon.getValueAt(row, 5).toString() == "Đã huỷ") {
            btnThanhToan.setEnabled(false);
            btnHuy.setEnabled(false);
            btnGH.setEnabled(false);
            btnHuyHoaDonGH.setEnabled(false);
            btnDaGiao.setEnabled(false);
            txtMaHD.setEnabled(false);
            txtMaHDGH.setEnabled(false);
            txtTenNV.setEnabled(false);
            txtTenNVGH.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtNgayHen.setEnabled(false);
            txtNgayTaoGH.setEnabled(false);
            cbbHinhThucThanhToan.setEnabled(false);
            cbbHinhThucThanhToan1.setEnabled(false);
            cbbTrangThai.setEnabled(false);
            cbbTrangThaiGH.setEnabled(false);
            txtTienKhachDua.setEnabled(false);
            txtSdt.setEnabled(false);
            txtTenKH.setEnabled(false);
            txtTienKhachDuaGH.setEnabled(false);
            txtSDTGiaoHang.setEnabled(false);
            txtTenKHGiaoHang.setEnabled(false);
            txtDiaChiGiaoHang.setEnabled(false);
            txtTienShip.setEnabled(false);
        } else if (tbHoaDon.getValueAt(row, 5).toString() == "Chờ thanh toán") {
            btnThanhToan.setEnabled(true);
            btnHuy.setEnabled(true);
            btnGH.setEnabled(true);
            btnHuyHoaDonGH.setEnabled(true);
            btnDaGiao.setEnabled(false);
            txtMaHD.setEnabled(false);
            txtMaHDGH.setEnabled(false);
            txtTenNV.setEnabled(false);
            txtTenNVGH.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtNgayHen.setEnabled(true);
            txtNgayTaoGH.setEnabled(false);
            cbbHinhThucThanhToan.setEnabled(true);
            cbbHinhThucThanhToan1.setEnabled(true);
            cbbTrangThai.setEnabled(false);
            cbbTrangThaiGH.setEnabled(false);
            txtTienKhachDua.setEnabled(true);
            txtSdt.setEnabled(true);
            txtTenKH.setEnabled(true);
            txtTienKhachDuaGH.setEnabled(true);
            txtSDTGiaoHang.setEnabled(true);
            txtTenKHGiaoHang.setEnabled(true);
            txtDiaChiGiaoHang.setEnabled(true);
            txtTienShip.setEnabled(true);
        } else if (tbHoaDon.getValueAt(row, 5).toString() == "Đã thanh toán") {
            btnThanhToan.setEnabled(false);
            btnHuy.setEnabled(false);
            btnGH.setEnabled(false);
            btnHuyHoaDonGH.setEnabled(false);
            btnDaGiao.setEnabled(false);
            txtMaHD.setEnabled(false);
            txtMaHDGH.setEnabled(false);
            txtTenNV.setEnabled(false);
            txtTenNVGH.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtNgayHen.setEnabled(false);
            txtNgayTaoGH.setEnabled(false);
            cbbHinhThucThanhToan.setEnabled(false);
            cbbHinhThucThanhToan1.setEnabled(false);
            cbbTrangThai.setEnabled(false);
            cbbTrangThaiGH.setEnabled(false);
            txtTienKhachDua.setEnabled(false);
            txtSdt.setEnabled(false);
            txtTenKH.setEnabled(false);
            txtTienKhachDuaGH.setEnabled(false);
            txtSDTGiaoHang.setEnabled(false);
            txtTenKHGiaoHang.setEnabled(false);
            txtDiaChiGiaoHang.setEnabled(false);
            txtTienShip.setEnabled(false);
        } else if (tbHoaDon.getValueAt(row, 5).toString() == "Đang giao") {
            btnThanhToan.setEnabled(false);
            btnHuy.setEnabled(false);
            btnGH.setEnabled(false);
            btnHuyHoaDonGH.setEnabled(false);
            btnDaGiao.setEnabled(true);
            txtMaHD.setEnabled(false);
            txtMaHDGH.setEnabled(false);
            txtTenNV.setEnabled(false);
            txtTenNVGH.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtNgayHen.setEnabled(false);
            txtNgayTaoGH.setEnabled(false);
            cbbHinhThucThanhToan.setEnabled(false);
            cbbHinhThucThanhToan1.setEnabled(false);
            cbbTrangThai.setEnabled(false);
            cbbTrangThaiGH.setEnabled(false);
            txtTienKhachDua.setEnabled(false);
            txtSdt.setEnabled(false);
            txtTenKH.setEnabled(false);
            txtTienKhachDuaGH.setEnabled(false);
            txtSDTGiaoHang.setEnabled(false);
            txtTenKHGiaoHang.setEnabled(false);
            txtDiaChiGiaoHang.setEnabled(false);
            txtTienShip.setEnabled(false);
        } else {
            btnThanhToan.setEnabled(false);
            btnHuy.setEnabled(false);
            btnGH.setEnabled(false);
            btnHuyHoaDonGH.setEnabled(false);
            btnDaGiao.setEnabled(false);
            txtMaHD.setEnabled(false);
            txtMaHDGH.setEnabled(false);
            txtTenNV.setEnabled(false);
            txtTenNVGH.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtNgayHen.setEnabled(false);
            txtNgayTaoGH.setEnabled(false);
            cbbHinhThucThanhToan.setEnabled(false);
            cbbHinhThucThanhToan1.setEnabled(false);
            cbbTrangThai.setEnabled(false);
            cbbTrangThaiGH.setEnabled(false);
            txtTienKhachDua.setEnabled(false);
            txtSdt.setEnabled(false);
            txtTenKH.setEnabled(false);
            txtTienKhachDuaGH.setEnabled(false);
            txtSDTGiaoHang.setEnabled(false);
            txtTenKHGiaoHang.setEnabled(false);
            txtDiaChiGiaoHang.setEnabled(false);
            txtTienShip.setEnabled(false);
        }
        txtTienKhachDua.setText("");
        jTienThua.setText("0");
        txtTienKhachDuaGH.setText("");
        jTienThuaGH.setText("0");
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int row = tbHoaDon.getSelectedRow();
        String ma = tbHoaDon.getValueAt(row, 1).toString();
        int trangThai = 2;
        HoaDon hoaDon = new HoaDon(trangThai);
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn huỷ hoá đơn", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, hoaDonService.updateHuy(hoaDon, ma));
        } else {
            return;
        }
        listHD = hoaDonService.getAll();
        addHoaDon(listHD);
    }//GEN-LAST:event_btnHuyActionPerformed
    private void showHoaDonChoThanhToan() {
        int trangThai = 0;
        addHoaDon(hoaDonService.searchTT(trangThai));
    }
    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        HoaDon hoaDon = new HoaDon();
        List<HoaDon> listHD = hoaDonService.getAll();
        int i = listHD.size() + 1;
        hoaDon.setMa("HD" + i++);
        hoaDon.setNgayTao(new Date());
        hoaDon.setTrangThai(0);
        hoaDon.setIdNV("D2C0A11D-1CFE-407C-B270-B5B2AB9451B9");
        hoaDonService.add(hoaDon);
        addHoaDon(hoaDonService.getAll());
        dtm.setRowCount(0);
        showHoaDonChoThanhToan();
        tbHoaDon.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        try {
            //them thong tin khach hang vao hoa don
            int rowHD = tbHoaDon.getSelectedRow();
            String idSelected = tbHoaDon.getValueAt(rowHD, 0).toString();
            int indexHTTT = cbbHinhThucThanhToan.getSelectedIndex();
            HinhThucThanhToan hinhThucThanhToan = listHTTT.get(indexHTTT);
            List<QlKhachHang> listQLKH=khachHangService.getAll();
            int j = listQLKH.size() + 1;
            String ma="KH" + j++;
            String tenkh = txtTenKH.getText();
            String sdt = txtSdt.getText();
            checkTTKH();
            HoaDon hoaDonTTKH = new HoaDon(hinhThucThanhToan.getId(), tenkh, sdt);
            JOptionPane.showMessageDialog(this, hoaDonService.updateTTKH(hoaDonTTKH, idSelected));

            //Tien thua
            Double tienKhachDua = Double.valueOf(txtTienKhachDua.getText());
            Double sum = 0.0;
            for (int i = 0; i < tbGioHang.getRowCount(); i++) {
                sum = sum + Double.parseDouble(tbGioHang.getValueAt(i, 6).toString());
            }
            if (tienKhachDua < sum) {
                JOptionPane.showMessageDialog(this, "Số tiền khách trả không đủ");
                return;
            }
            Double tienThua = tienKhachDua - sum;
            Locale locale = new Locale("vi", "VN");
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            jTienThua.setText(format.format(tienThua));

            //cap nhat trang thai 
            String maSelected = tbHoaDon.getValueAt(rowHD, 1).toString();
            int trangThai = 1;
            HoaDon hoaDon = new HoaDon(new Date(), trangThai);
            int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn thanh toán", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                KhachHang kh = new KhachHang(ma, tenkh, null, null, sdt, null, 1);
                JOptionPane.showMessageDialog(this, khachHangService.add(kh));
                JOptionPane.showMessageDialog(this, hoaDonService.updateThanhToan(hoaDon, maSelected));
            } else {
                return;
            }
            listHD = hoaDonService.getAll();
            addHoaDon(listHD);
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn");
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số tiền khách hàng đưa");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHDGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDGHActionPerformed
        HoaDon hoaDon = new HoaDon();
        List<HoaDon> listHD = hoaDonService.getAll();
        int i = listHD.size() + 1;
        hoaDon.setMa("HD" + i++);
        hoaDon.setNgayTao(new Date());
        hoaDon.setTrangThai(0);
        hoaDon.setIdNV("D2C0A11D-1CFE-407C-B270-B5B2AB9451B9");
        hoaDonService.add(hoaDon);
        addHoaDon(hoaDonService.getAll());
        dtm.setRowCount(0);
        showHoaDonChoThanhToan();
        tbHoaDon.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_btnTaoHDGHActionPerformed

    private void btnGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGHActionPerformed
        try {
            //them thong tin khach hang vao hoa don
            int rowHD = tbHoaDon.getSelectedRow();
            String idSelected = tbHoaDon.getValueAt(rowHD, 0).toString();
            int indexHTTT = cbbHinhThucThanhToan.getSelectedIndex();
            HinhThucThanhToan hinhThucThanhToan = listHTTT.get(indexHTTT);
            List<QlKhachHang> listQLKH=khachHangService.getAll();
            int j = listQLKH.size() + 1;
            String ma="KH" + j++;
            String tenkh = txtTenKHGiaoHang.getText();
            String sdt = txtSDTGiaoHang.getText();
            String diaChi = txtDiaChiGiaoHang.getText();
            String ngayHen = String.valueOf(txtNgayHen.getText());
            Double tienShip = Double.valueOf(txtTienShip.getText());
            checkTTKHGiaoHang();
//            HoaDon hoaDonTTKHGH = new HoaDon(tenkh, diaChi, sdt, tienShip);
            HoaDon hoaDonTTKHGH = new HoaDon(hinhThucThanhToan.getId(), tenkh, diaChi, sdt, tienShip, ngayHen);
            JOptionPane.showMessageDialog(this, hoaDonService.updateTTKHGiaoHang(hoaDonTTKHGH, idSelected));

            //Tien thua
            Double tienKhachDua = Double.valueOf(txtTienKhachDuaGH.getText());
            Double sum = 0.0;
            Double tienShipp = Double.valueOf(txtTienShip.getText());
            if (txtTienShip.getText().isEmpty()) {
                tienShipp = 0.0;
            }
            for (int i = 0; i < tbGioHang.getRowCount(); i++) {
                sum = sum + Double.parseDouble(tbGioHang.getValueAt(i, 6).toString());
            }
            if (tienKhachDua < sum) {
                JOptionPane.showMessageDialog(this, "Số tiền khách trả không đủ");
                return;
            }
            Double tienThua = tienKhachDua - (sum + tienShipp);
            Locale locale = new Locale("vi", "VN");
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            jTienThuaGH.setText(format.format(tienThua));

            //cap nhat trang thai 
            String maSelected = tbHoaDon.getValueAt(rowHD, 1).toString();
            int trangThai = 3;
            HoaDon hoaDon = new HoaDon(trangThai, new Date(), new Date());
            int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn giao hàng", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                KhachHang kh = new KhachHang(ma, tenkh, null, null, sdt, diaChi, 1);
                JOptionPane.showMessageDialog(this, khachHangService.add(kh));
                JOptionPane.showMessageDialog(this, hoaDonService.updateGH(hoaDon, maSelected));
            } else {
                return;
            }
            listHD = hoaDonService.getAll();
            addHoaDon(listHD);
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn");
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số tiền khách hàng đưa");
        }
    }//GEN-LAST:event_btnGHActionPerformed

    private void btnHuyHoaDonGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonGHActionPerformed
        int row = tbHoaDon.getSelectedRow();
        String ma = tbHoaDon.getValueAt(row, 1).toString();
        int trangThai = 2;
        HoaDon hoaDon = new HoaDon(trangThai);
        int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn huỷ hoá đơn", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, hoaDonService.updateHuy(hoaDon, ma));
        } else {
            return;
        }
        listHD = hoaDonService.getAll();
        addHoaDon(listHD);
    }//GEN-LAST:event_btnHuyHoaDonGHActionPerformed

    private void btnDaGiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaGiaoActionPerformed
        int row = tbHoaDon.getSelectedRow();
        String ma = tbHoaDon.getValueAt(row, 1).toString();
        int trangThai = 4;
        HoaDon hoaDon = new HoaDon(trangThai, new Date());
        int result = JOptionPane.showConfirmDialog(this, "Xác nhận đã giao hàng thành công", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, hoaDonService.updateDaGiao(hoaDon, ma));
        } else {
            return;
        }
        listHD = hoaDonService.getAll();
        addHoaDon(listHD);
    }//GEN-LAST:event_btnDaGiaoActionPerformed

    private void cbbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchActionPerformed
        int trangThai = cbbSearch.getSelectedIndex();
        if (trangThai == 0) {
            addHoaDon(hoaDonService.searchTT(trangThai));
        } else if (trangThai == 1) {
            addHoaDon(hoaDonService.searchTT(trangThai));
        } else if (trangThai == 2) {
            addHoaDon(hoaDonService.searchTT(trangThai));
        } else if (trangThai == 3) {
            addHoaDon(hoaDonService.searchTT(trangThai));
        } else {
            addHoaDon(hoaDonService.searchTT(trangThai));
        }
    }//GEN-LAST:event_cbbSearchActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String ma = txtSearch.getText();
        addHoaDon(hoaDonService.getOne(ma));
    }//GEN-LAST:event_btnTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDaGiao;
    private javax.swing.JButton btnGH;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnHuyHoaDonGH;
    private javax.swing.JButton btnTaoHDGH;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbHinhThucThanhToan;
    private javax.swing.JComboBox<String> cbbHinhThucThanhToan1;
    private javax.swing.JComboBox<String> cbbSearch;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JComboBox<String> cbbTrangThaiGH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jTienThua;
    private javax.swing.JLabel jTienThuaGH;
    private javax.swing.JLabel jTongTien;
    private javax.swing.JLabel jTongTienHang;
    private javax.swing.JTable tbGioHang;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtDiaChiGiaoHang;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDGH;
    private javax.swing.JTextField txtNgayHen;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNgayTaoGH;
    private javax.swing.JTextField txtSDTGiaoHang;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenKHGiaoHang;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenNVGH;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienKhachDuaGH;
    private javax.swing.JTextField txtTienShip;
    // End of variables declaration//GEN-END:variables

}
