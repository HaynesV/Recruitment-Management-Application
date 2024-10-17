package Views.javaswingdev.form;

import Controller.UserAccountController;
import Model.Education;
import Model.Experience;
import Model.SeekerProfile;
import Model.UserAccount;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Form_DangKy2 extends javax.swing.JPanel {

    public Form_DangKy2() {

        initComponents();
        loadPreviousData();
    }

    private void loadPreviousData() {
        // Hiển thị thông tin họ tên và giới tính đã lưu từ Form_DangKy
        System.out.println("Họ tên: " + Form_DangKy.name);
        System.out.println("Giới tính: " + Form_DangKy.gioiTinh);

        // In danh sách học vấn
        if (Form_DangKy.educationList.isEmpty()) {
            System.out.println("Danh sách học vấn trống");
        } else {
            System.out.println("Danh sách học vấn:");
            for (Education edu : Form_DangKy.educationList) {
                System.out.println(edu.toString());
            }
        }

        // In danh sách kinh nghiệm
        if (Form_DangKy.experienceList.isEmpty()) {
            System.out.println("Danh sách kinh nghiệm trống");
        } else {
            System.out.println("Danh sách kinh nghiệm:");
            for (Experience exp : Form_DangKy.experienceList) {
                System.out.println(exp.toString());
            }
        }
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(emailPattern, email);
    }

    private boolean isValidPhoneNumber(String phoneNumber) {

        String phonePattern = "^[0-9]{9,11}$";
        return Pattern.matches(phonePattern, phoneNumber);
    }

    private boolean validateForm() {
        String email = txt_email.getText().trim();
        String password = new String(txt_mk.getPassword()).trim();
        String confirmPassword = new String(txt_mk2.getPassword()).trim();
        String phoneNumber = txt_sdt.getText().trim();

        // Validate email
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ!");
            return false;
        }

        // Validate mật khẩu
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Mật khẩu phải có ít nhất 6 ký tự!");
            return false;
        }

        // Validate mật khẩu xác nhận
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu xác nhận không khớp!");
            return false;
        }

        // Validate số điện thoại
        if (!isValidPhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!");
            return false;
        }

        // Validate danh sách học vấn và kinh nghiệm không trống
        if (Form_DangKy.educationList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Danh sách học vấn không được trống!");
            return false;
        }

        if (Form_DangKy.experienceList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Danh sách kinh nghiệm không được trống!");
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new Views.javaswingdev.login.swing.TextField();
        txt_sdt = new Views.javaswingdev.login.swing.TextField();
        txt_mk = new Views.javaswingdev.login.swing.PasswordField();
        txt_mk2 = new Views.javaswingdev.login.swing.PasswordField();
        btn_dangky = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        chk_nv = new javax.swing.JCheckBox();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("NHẬP THÔNG TIN TÀI KHOẢN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Email:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("MẬT KHẨU:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("XÁC NHẬN MẬT KHẨU:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("SỐ ĐIỆN THOẠI:");

        txt_email.setForeground(new java.awt.Color(0, 0, 0));

        txt_sdt.setForeground(new java.awt.Color(0, 0, 0));

        txt_mk.setForeground(new java.awt.Color(0, 0, 0));
        txt_mk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mkActionPerformed(evt);
            }
        });

        txt_mk2.setForeground(new java.awt.Color(0, 0, 0));

        btn_dangky.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_dangky.setText("ĐĂNG KÝ");
        btn_dangky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangkyActionPerformed(evt);
            }
        });

        btn_thoat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_thoat.setText("THOÁT");

        chk_nv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chk_nv.setText("NHÂN VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btn_dangky)
                        .addGap(114, 114, 114)
                        .addComponent(btn_thoat))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(chk_nv))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mk2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_mk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(chk_nv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dangky)
                    .addComponent(btn_thoat))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mkActionPerformed

    private void btn_dangkyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangkyActionPerformed
        if (validateForm()) {
            // Lấy thông tin từ form
            String email = txt_email.getText().trim();
            String password = new String(txt_mk.getPassword()).trim();
            String phoneNumber = txt_sdt.getText().trim();
            boolean isEmployee = chk_nv.isSelected(); // Kiểm tra checkbox "NHÂN VIÊN"

            // Tạo đối tượng UserAccount
            UserAccount userAccount = new UserAccount();
            userAccount.setEmail(email);
            userAccount.setPassword(password);
            userAccount.setContactNumber(phoneNumber);
            userAccount.setUserType(isEmployee ? "Nhân Viên" : "Ứng Viên");
            userAccount.setActive(true); // Mặc định là active
            userAccount.setRegistrationDate(new Date()); // Ngày đăng ký hiện tại

            // Tạo đối tượng SeekerProfile và lưu thông tin vào đó
            SeekerProfile seekerProfile = new SeekerProfile();
            seekerProfile.setEmailContact(Form_DangKy.email);  // Email được lưu vào SeekerProfile
            seekerProfile.setFirstName(Form_DangKy.name); // Lấy tên từ form trước đó
            seekerProfile.setLastName(""); // Bạn có thể chia tách họ và tên nếu cần
            seekerProfile.setIsAnnuallyMonthly(1); // Mặc định đặt loại lương hằng năm/tháng

            // Lấy giới tính từ form trước đó
            seekerProfile.setGender(Form_DangKy.gioiTinh);

            // Đặt đối tượng SeekerProfile vào UserAccount
            userAccount.setSeekerProfile(seekerProfile);

            // Kiểm tra danh sách học vấn và kinh nghiệm trước khi thêm
            if (Form_DangKy.educationList.isEmpty()) {
                System.out.println("Danh sách học vấn trống.");
            } else {
                userAccount.setEducationDetails(Form_DangKy.educationList); // Lưu danh sách học vấn
            }

            if (Form_DangKy.experienceList.isEmpty()) {
                System.out.println("Danh sách kinh nghiệm trống.");
            } else {
                userAccount.setExperienceDetails(Form_DangKy.experienceList); // Lưu danh sách kinh nghiệm
            }

            // Gọi phương thức tạo tài khoản từ controller
            UserAccountController userAccountController = new UserAccountController();
            userAccountController.createUser(userAccount);

            JOptionPane.showMessageDialog(this, "Đăng ký tài khoản thành công!");
            
        }
    }//GEN-LAST:event_btn_dangkyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dangky;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JCheckBox chk_nv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private Views.javaswingdev.login.swing.TextField txt_email;
    private Views.javaswingdev.login.swing.PasswordField txt_mk;
    private Views.javaswingdev.login.swing.PasswordField txt_mk2;
    private Views.javaswingdev.login.swing.TextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}
