package Views.javaswingdev.form;

import Model.Education;
import Model.Experience;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Form_DangKy extends javax.swing.JPanel {


    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String name;
    public static String gioiTinh;
    public static String email;
    public static ArrayList<Education> educationList = new ArrayList<>();
    public static ArrayList<Experience> experienceList = new ArrayList<>();

    public Form_DangKy() {

        initComponents();
        initGroupButton();
        check_isJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_isJobActionPerformed(evt);
            }
        });
    }

    public void initGroupButton() {
        buttonGroup1.add(btn_rad_nu);
        buttonGroup1.add(bt_rad_nam);
    }

    private boolean validatePersonalInformation() {
        // Kiểm tra họ tên
        if (txt_hoten.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên.");
            return false;
        }

        // Kiểm tra giới tính
        if (!bt_rad_nam.isSelected() && !btn_rad_nu.isSelected()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn giới tính.");
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_truong = new javax.swing.JTextField();
        txt_bang = new javax.swing.JTextField();
        txt_batdau = new javax.swing.JTextField();
        txt_ketthuc = new javax.swing.JTextField();
        txt_phantram = new javax.swing.JTextField();
        txt_gpa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_hocvan = new javax.swing.JList<>();
        btn_themHV = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_suaHV = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        btn_themKN = new javax.swing.JButton();
        check_isJob = new javax.swing.JCheckBox();
        txt_congviec = new javax.swing.JTextField();
        txt_ngaylam = new javax.swing.JTextField();
        txt_congty = new javax.swing.JTextField();
        txt_noilamviec = new javax.swing.JTextField();
        txt_mota = new javax.swing.JTextField();
        txt_ngayketthuc = new javax.swing.JTextField();
        btn_XoaKN = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        txt_hoten = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        bt_rad_nam = new javax.swing.JRadioButton();
        btn_rad_nu = new javax.swing.JRadioButton();
        btn_tt = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Họ tên:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Giới tính:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Học vấn"));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Trường:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Bằng cấp:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Ngày bắt đầu:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Ngày kết thúc:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Điểm GPA:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Tỉ lệ %:");

        list_hocvan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        list_hocvan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_hocvanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list_hocvan);

        btn_themHV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_themHV.setText("Thêm");
        btn_themHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themHVActionPerformed(evt);
            }
        });

        btn_Xoa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_suaHV.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_suaHV.setText("Sửa");
        btn_suaHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaHVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btn_themHV)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_phantram, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txt_ketthuc, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_truong, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_bang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_batdau, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_gpa)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Xoa)
                        .addGap(30, 30, 30)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(btn_suaHV)
                        .addGap(58, 58, 58))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_truong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_bang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_batdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_ketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_phantram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_gpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_suaHV)
                    .addComponent(btn_Xoa)
                    .addComponent(btn_themHV))
                .addGap(17, 17, 17))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Kinh nghiệm"));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Công ty:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Tên công việc:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Ngày làm:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Ngày kết thúc:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Mô tả công việc:");

        jList1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Nơi làm việc:");

        btn_themKN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_themKN.setText("Thêm");
        btn_themKN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themKNActionPerformed(evt);
            }
        });

        check_isJob.setText("Công việc hiện tại");
        check_isJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_isJobActionPerformed(evt);
            }
        });

        btn_XoaKN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_XoaKN.setText("Xóa");
        btn_XoaKN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaKNActionPerformed(evt);
            }
        });

        btn_Sua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(70, 70, 70)
                                .addComponent(txt_congty, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(26, 26, 26)
                                .addComponent(txt_congviec, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(59, 59, 59)
                                .addComponent(txt_ngaylam, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(36, 36, 36)
                                .addComponent(txt_noilamviec, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(28, 28, 28)
                                .addComponent(txt_ngayketthuc, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txt_mota, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(check_isJob)
                        .addGap(18, 18, 18)
                        .addComponent(btn_themKN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_XoaKN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_Sua)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_congty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_congviec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_ngaylam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txt_ngayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_noilamviec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_isJob)
                    .addComponent(btn_themKN)
                    .addComponent(btn_XoaKN)
                    .addComponent(btn_Sua))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel15.setText("NHẬP THÔNG TIN");

        bt_rad_nam.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bt_rad_nam.setText("Nam");

        btn_rad_nu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_rad_nu.setText("Nữ");

        btn_tt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_tt.setText("TIẾP TỤC");
        btn_tt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt_rad_nam)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_rad_nu))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(btn_tt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_rad_nam)
                    .addComponent(btn_rad_nu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btn_tt)
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void addEducation() {
        try {
            String truong = txt_truong.getText();
            String bangCap = txt_bang.getText();
            Date ngayBatDau = dateFormat.parse(txt_batdau.getText()); // Chuyển đổi String thành Date
            Date ngayKetThuc = dateFormat.parse(txt_ketthuc.getText());
            int tiLe = Integer.parseInt(txt_phantram.getText());
            double gpa = Double.parseDouble(txt_gpa.getText());

            // Tạo đối tượng Education và thêm vào ArrayList
            Education education = new Education(bangCap, truong, ngayBatDau, ngayKetThuc, tiLe, gpa);
            educationList.add(education);

            // Cập nhật danh sách hiển thị học vấn
            updateEducationList();

        } catch (Exception e) {
            // Xử lý lỗi nếu nhập sai dữ liệu
            e.printStackTrace();
        }
    }

    private boolean validateExperienceFields() {
        if (txt_congty.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên công ty.");
            return false;
        }
        if (txt_congviec.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên công việc.");
            return false;
        }
        try {
            dateFormat.parse(txt_ngaylam.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ngày bắt đầu không hợp lệ. Vui lòng nhập lại (dd/MM/yyyy).");
            return false;
        }
        if (!check_isJob.isSelected()) {
            try {
                dateFormat.parse(txt_ngayketthuc.getText().trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ngày kết thúc không hợp lệ. Vui lòng nhập lại (dd/MM/yyyy).");
                return false;
            }
        }
        if (txt_noilamviec.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập nơi làm việc.");
            return false;
        }
        if (txt_mota.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mô tả công việc.");
            return false;
        }
        return true;
    }

    private boolean validateEducationFields() {
        if (txt_truong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên trường.");
            return false;
        }
        if (txt_bang.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập tên bằng cấp.");
            return false;
        }
        try {
            dateFormat.parse(txt_batdau.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ngày bắt đầu không hợp lệ. Vui lòng nhập lại (dd/MM/yyyy).");
            return false;
        }
        try {
            dateFormat.parse(txt_ketthuc.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ngày kết thúc không hợp lệ. Vui lòng nhập lại (dd/MM/yyyy).");
            return false;
        }
        try {
            int tiLe = Integer.parseInt(txt_phantram.getText().trim());
            if (tiLe < 0 || tiLe > 100) {
                JOptionPane.showMessageDialog(null, "Tỉ lệ phần trăm phải từ 0 đến 100.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tỉ lệ phần trăm không hợp lệ.");
            return false;
        }
        try {
            double gpa = Double.parseDouble(txt_gpa.getText().trim());
            if (gpa < 0 || gpa > 4.0) {
                JOptionPane.showMessageDialog(null, "GPA phải từ 0.0 đến 4.0.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Điểm GPA không hợp lệ.");
            return false;
        }
        return true;
    }

    // Hàm thêm kinh nghiệm vào danh sách
    private void addExperience() {
        try {
            String congTy = txt_congty.getText();
            String tenCongViec = txt_congviec.getText();

            // Kiểm tra chuỗi ngày bắt đầu có rỗng hay không
            Date ngayLam = null;
            if (!txt_ngaylam.getText().trim().isEmpty()) {
                ngayLam = dateFormat.parse(txt_ngaylam.getText().trim()); // Chuyển đổi String thành Date
            } else {
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu không được để trống.");
                return;
            }

            Date ngayKetThuc = null;
            if (!check_isJob.isSelected()) {
                // Kiểm tra chuỗi ngày kết thúc có rỗng hay không
                if (!txt_ngayketthuc.getText().trim().isEmpty()) {
                    ngayKetThuc = dateFormat.parse(txt_ngayketthuc.getText().trim());
                } else {
                    JOptionPane.showMessageDialog(null, "Ngày kết thúc không được để trống khi công việc không phải hiện tại.");
                    return;
                }
            }

            String noiLamViec = txt_noilamviec.getText();
            String moTaCongViec = txt_mota.getText();
            boolean congViecHienTai = check_isJob.isSelected();

            // Tạo đối tượng Experience và thêm vào ArrayList
            Experience experience = new Experience(tenCongViec, congTy, ngayLam, ngayKetThuc, congViecHienTai, noiLamViec, moTaCongViec);
            experienceList.add(experience);

            // Cập nhật danh sách hiển thị kinh nghiệm
            updateExperienceList();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi thêm kinh nghiệm. Vui lòng kiểm tra lại thông tin.");
        }
    }

    private void updateEducationList() {
        String[] data = new String[educationList.size()];
        for (int i = 0; i < educationList.size(); i++) {
            data[i] = (i + 1) + ". " + educationList.get(i).toString();  // Hiển thị thông tin học vấn
        }
        list_hocvan.setListData(data);
    }

    // Cập nhật danh sách hiển thị kinh nghiệm
    private void updateExperienceList() {
        String[] data = new String[experienceList.size()];
        for (int i = 0; i < experienceList.size(); i++) {
            data[i] = (i + 1) + ". " + experienceList.get(i).toString();  // Hiển thị thông tin kinh nghiệm
        }
        jList1.setListData(data);
    }
    private void btn_ttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttActionPerformed
        if (validatePersonalInformation() && validateLists()) {
            // Nếu hợp lệ thì tiếp tục
            JFrame frame = new JFrame("ĐĂNG KÝ TÀI KHOẢN");
            name = txt_hoten.getText();
            if (bt_rad_nam.isSelected()) {
                gioiTinh = "Nam";
            } else {
                gioiTinh = "Nữ";
            }
            email = txt_email.getText();
            System.out.println(gioiTinh);
            Form_DangKy2 form = new Form_DangKy2();
            frame.add(form);
            frame.setSize(500, 700);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_btn_ttActionPerformed
    private boolean validateLists() {
        if (educationList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Danh sách học vấn không được trống.");
            return false;
        }

        if (experienceList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Danh sách kinh nghiệm không được trống.");
            return false;
        }

        return true;
    }

    private void btn_themHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themHVActionPerformed
        if (validateEducationFields()) {
            try {
                addEducation();
                JOptionPane.showMessageDialog(null, "Thêm học vấn thành công.");
            } catch (Exception e) {

            }

        }

    }//GEN-LAST:event_btn_themHVActionPerformed

    private void btn_themKNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themKNActionPerformed
        if (validateExperienceFields()) {
            try {
                addExperience();
                JOptionPane.showMessageDialog(null, "Thêm kinh nghiệm thành công.");
            } catch (Exception e) {

            }

        }

    }//GEN-LAST:event_btn_themKNActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        int selectedIndex = list_hocvan.getSelectedIndex();
        if (selectedIndex != -1) {
            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa học vấn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Xóa mục khỏi danh sách educationList
                educationList.remove(selectedIndex);

                // Cập nhật lại danh sách hiển thị trong JList
                updateEducationList();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một học vấn để xóa.");
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_suaHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaHVActionPerformed
        int selectedIndex = list_hocvan.getSelectedIndex();
        if (selectedIndex != -1) {
            if (validateEducationFields()) {
                try {
                    String truong = txt_truong.getText();
                    String bangCap = txt_bang.getText();
                    Date ngayBatDau = dateFormat.parse(txt_batdau.getText());
                    Date ngayKetThuc = dateFormat.parse(txt_ketthuc.getText());
                    int tiLe = Integer.parseInt(txt_phantram.getText());
                    double gpa = Double.parseDouble(txt_gpa.getText());

                    Education education = educationList.get(selectedIndex);
                    education.setInstituteUniversityName(truong);
                    education.setCertificateDegreeName(bangCap);
                    education.setStartingDate(ngayBatDau);
                    education.setCompletionDate(ngayKetThuc);
                    education.setPercentage(tiLe);
                    education.setCgpa(gpa);

                    updateEducationList();
                    JOptionPane.showMessageDialog(null, "Cập nhật học vấn thành công.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi cập nhật học vấn.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một học vấn để sửa.");
        }
    }//GEN-LAST:event_btn_suaHVActionPerformed

    private void btn_XoaKNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaKNActionPerformed
        int selectedIndex = jList1.getSelectedIndex();
        if (selectedIndex != -1) {
            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa kinh nghiệm này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Xóa mục khỏi danh sách experienceList
                experienceList.remove(selectedIndex);

                // Cập nhật lại danh sách hiển thị trong JList
                updateExperienceList();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một kinh nghiệm để xóa.");
        }
    }//GEN-LAST:event_btn_XoaKNActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        int selectedIndex = jList1.getSelectedIndex();
        if (selectedIndex != -1) {
            if (validateExperienceFields()) {
                try {
                    String congTy = txt_congty.getText();
                    String tenCongViec = txt_congviec.getText();
                    Date ngayLam = dateFormat.parse(txt_ngaylam.getText());
                    Date ngayKetThuc = check_isJob.isSelected() ? null : dateFormat.parse(txt_ngayketthuc.getText());
                    String noiLamViec = txt_noilamviec.getText();
                    String moTaCongViec = txt_mota.getText();
                    boolean congViecHienTai = check_isJob.isSelected();

                    Experience experience = experienceList.get(selectedIndex);
                    experience.setCompanyName(congTy);
                    experience.setJobTitle(tenCongViec);
                    experience.setStartDate(ngayLam);
                    experience.setEndDate(ngayKetThuc);
                    experience.setJobLocationCity(noiLamViec);
                    experience.setDescription(moTaCongViec);
                    experience.setCurrentJob(congViecHienTai);

                    updateExperienceList();
                    JOptionPane.showMessageDialog(null, "Cập nhật kinh nghiệm thành công.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra khi cập nhật kinh nghiệm.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một kinh nghiệm để sửa.");
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void list_hocvanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_hocvanMouseClicked
        int selectedIndex = list_hocvan.getSelectedIndex();  // Lấy chỉ số mục được chọn
        if (selectedIndex != -1) {
            // Lấy đối tượng Education từ danh sách
            Education selectedEducation = educationList.get(selectedIndex);

            // Hiển thị lại dữ liệu trên các JTextField
            txt_truong.setText(selectedEducation.getInstituteUniversityName());
            txt_bang.setText(selectedEducation.getCertificateDegreeName());
            txt_batdau.setText(dateFormat.format(selectedEducation.getStartingDate()));
            txt_ketthuc.setText(dateFormat.format(selectedEducation.getCompletionDate()));
            txt_phantram.setText(String.valueOf(selectedEducation.getPercentage()));
            txt_gpa.setText(String.valueOf(selectedEducation.getCgpa()));
        }
    }//GEN-LAST:event_list_hocvanMouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        int selectedIndex = jList1.getSelectedIndex();  // Lấy chỉ số mục được chọn
        if (selectedIndex != -1) {
            // Lấy đối tượng Experience từ danh sách
            Experience selectedExperience = experienceList.get(selectedIndex);

            // Hiển thị lại dữ liệu trên các JTextField
            txt_congty.setText(selectedExperience.getCompanyName());
            txt_congviec.setText(selectedExperience.getJobTitle());
            txt_noilamviec.setText(selectedExperience.getJobLocationCity());
            txt_mota.setText(selectedExperience.getDescription());
            txt_ngaylam.setText(dateFormat.format(selectedExperience.getStartDate()));

            // Kiểm tra xem đây có phải là công việc hiện tại không
            if (selectedExperience.isCurrentJob()) {
                check_isJob.setSelected(true);  // Chọn checkbox nếu là công việc hiện tại
                txt_ngayketthuc.setText("");  // Xóa giá trị của ngày kết thúc
                txt_ngayketthuc.setEnabled(false);  // Vô hiệu hóa trường nhập liệu ngày kết thúc
            } else {
                check_isJob.setSelected(false);  // Bỏ chọn checkbox nếu không phải công việc hiện tại
                if (selectedExperience.getEndDate() != null) {
                    txt_ngayketthuc.setText(dateFormat.format(selectedExperience.getEndDate()));
                } else {
                    txt_ngayketthuc.setText("");
                }
                txt_ngayketthuc.setEnabled(true);  // Kích hoạt lại trường nhập liệu ngày kết thúc
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void check_isJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_isJobActionPerformed
        if (check_isJob.isSelected()) {
            txt_ngayketthuc.setEnabled(false); // Disable end date field
            txt_ngayketthuc.setText(""); // Clear the value
        } else {
            txt_ngayketthuc.setEnabled(true); // Enable end date field
        }
    }//GEN-LAST:event_check_isJobActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bt_rad_nam;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XoaKN;
    private javax.swing.JRadioButton btn_rad_nu;
    private javax.swing.JButton btn_suaHV;
    private javax.swing.JButton btn_themHV;
    private javax.swing.JButton btn_themKN;
    private javax.swing.JButton btn_tt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox check_isJob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Object> list_hocvan;
    private javax.swing.JTextField txt_bang;
    private javax.swing.JTextField txt_batdau;
    private javax.swing.JTextField txt_congty;
    private javax.swing.JTextField txt_congviec;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_gpa;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_ketthuc;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_ngayketthuc;
    private javax.swing.JTextField txt_ngaylam;
    private javax.swing.JTextField txt_noilamviec;
    private javax.swing.JTextField txt_phantram;
    private javax.swing.JTextField txt_truong;
    // End of variables declaration//GEN-END:variables
}
