package Views.javaswingdev.form;

import Controller.JobPostController;
import Model.JobPost;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import org.bson.types.ObjectId;

public class Form_ThemCongViec extends javax.swing.JPanel {

    private JobPostController jobPostController = new JobPostController();

    public Form_ThemCongViec() {
        initComponents();
        loadJobTypes(); // Load dữ liệu cho combobox loại công việc
        loadCategories(); // Load dữ liệu cho combobox ngành nghề
    }

    private void loadJobTypes() {
        // Dữ liệu cho loại công việc (ví dụ)
        ArrayList<String> jobTypes = new ArrayList<>();
        jobTypes.add(""); // Thêm một chuỗi rỗng để không chọn gì lúc đầu
        jobTypes.add("Full-time");
        jobTypes.add("Part-time");
        jobTypes.add("Freelance");
        jobTypes.add("Internship");

        // Gán dữ liệu vào combobox và không chọn gì lúc đầu
        cb_job_type.setModel(new DefaultComboBoxModel<>(jobTypes.toArray(new String[0])));
        cb_job_type.setSelectedIndex(0); // Đặt lựa chọn đầu tiên là chuỗi rỗng
    }

    private boolean validateForm() {
        String jobDescription = txt_descJob.getText();
        String salary = textField1.getText();
        String dateStartStr = txt_NgayBatDau.getText();
        String dateEndStr = txt_ngayKetThuc.getText();
        String jobType = cb_job_type.getSelectedItem().toString();
        String category = cb_category.getSelectedItem().toString();

        // Kiểm tra mô tả công việc không được rỗng
        if (jobDescription.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Mô tả công việc không được để trống.");
            return false;
        }

        // Kiểm tra lương không được rỗng và phải là số hợp lệ
        if (salary.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lương không được để trống.");
            return false;
        }
        try {
            int salaryInt = Integer.parseInt(salary);
            if (salaryInt < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Lương phải lớn hơn hoặc bằng 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lương phải là số.");
            return false;
        }

        // Kiểm tra ngày bắt đầu và ngày kết thúc không được rỗng và phải có định dạng hợp lệ
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyyy");
        dateFormat.setLenient(false);
        try {
            Date dateStart = dateFormat.parse(dateStartStr);
            Date dateEnd = dateFormat.parse(dateEndStr);
            if (dateStart.after(dateEnd)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được sau ngày kết thúc.");
                return false;
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng ngày/tháng/năm.");
            return false;
        }

        // Kiểm tra loại công việc phải được chọn
        if (jobType.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn loại công việc.");
            return false;
        }

        // Kiểm tra ngành nghề phải được chọn
        if (category.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn ngành nghề.");
            return false;
        }

        // Nếu tất cả kiểm tra hợp lệ, trả về true
        return true;
    }

    private void loadCategories() {
        // Dữ liệu cho ngành nghề (ví dụ)
        ArrayList<String> categories = new ArrayList<>();
        categories.add(""); // Thêm một chuỗi rỗng để không chọn gì lúc đầu
        categories.add("Engineering");
        categories.add("Finance");
        categories.add("Marketing");
        categories.add("Human Resources");
        categories.add("Design");
        categories.add("IT");

        // Gán dữ liệu vào combobox và không chọn gì lúc đầu
        cb_category.setModel(new DefaultComboBoxModel<>(categories.toArray(new String[0])));
        cb_category.setSelectedIndex(0); // Đặt lựa chọn đầu tiên là chuỗi rỗng
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_job_type = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descJob = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        textField1 = new Views.javaswingdev.login.swing.TextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_state = new Views.javaswingdev.login.swing.TextField();
        txt_zip = new Views.javaswingdev.login.swing.TextField();
        txt_city = new Views.javaswingdev.login.swing.TextField();
        jLabel8 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox<>();
        btn_Them = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_ngayKetThuc = new Views.javaswingdev.login.swing.TextField();
        txt_NgayBatDau = new Views.javaswingdev.login.swing.TextField();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("THÊM CÔNG VIỆC");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("NGÀY KẾT THÚC:");

        cb_job_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("MÔ TẢ CÔNG VIỆC:");

        txt_descJob.setColumns(20);
        txt_descJob.setRows(5);
        jScrollPane1.setViewportView(txt_descJob);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("LƯƠNG:");

        textField1.setForeground(new java.awt.Color(0, 0, 0));
        textField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐỊA ĐIỂM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("QUẬN/HUYỆN");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("TỈNH/THÀNH PHỐ:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("SỐ ĐƯỜNG:");

        txt_state.setForeground(new java.awt.Color(0, 0, 0));

        txt_zip.setForeground(new java.awt.Color(0, 0, 0));

        txt_city.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_zip, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addComponent(txt_state, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addComponent(txt_city, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_zip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addGap(28, 28, 28))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("NGÀNH NGHỀ:");

        cb_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_Them.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_Them.setText("THÊM");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("LOẠI CÔNG VIỆC:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("NGÀY BẮT ĐẦU:");

        txt_ngayKetThuc.setForeground(new java.awt.Color(0, 0, 0));
        txt_ngayKetThuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txt_NgayBatDau.setForeground(new java.awt.Color(0, 0, 0));
        txt_NgayBatDau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(139, 139, 139)
                                            .addComponent(cb_job_type, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(jLabel8))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(175, 175, 175)
                                            .addComponent(jLabel1))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_category, 0, 194, Short.MAX_VALUE)
                                    .addComponent(txt_ngayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(jLabel9)
                    .addContainerGap(517, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(196, 196, 196)
                    .addComponent(txt_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(346, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_job_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addComponent(jLabel9)
                    .addContainerGap(494, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(txt_NgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(442, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        if (!validateForm()) {
            return; // Dừng xử lý nếu form không hợp lệ
        }

        JobPost jobPost = new JobPost();

        // Lấy dữ liệu từ các trường nhập liệu trong form
        String jobDescription = txt_descJob.getText(); // Mô tả công việc
        String salary = textField1.getText(); // Lương (dưới dạng chuỗi, cần chuyển đổi thành số nguyên)
        String jobType = cb_job_type.getSelectedItem().toString(); // Loại công việc
        String category = cb_category.getSelectedItem().toString(); // Ngành nghề
        String city = txt_city.getText(); // Thành phố
        String state = txt_state.getText(); // Bang
        String zip = txt_zip.getText(); // Mã bưu điện
        String dateStartStr = txt_NgayBatDau.getText(); // Ngày bắt đầu
        String dateEndStr = txt_ngayKetThuc.getText(); // Ngày kết thúc

        // Chuyển đổi ngày từ chuỗi sang kiểu Date
        Date dateStart = null;
        Date dateEnd = null;
        try {
            dateStart = new SimpleDateFormat("dd/MM/yyyyy").parse(dateStartStr);
            dateEnd = new SimpleDateFormat("dd/MM/yyyyy").parse(dateEndStr);
        } catch (Exception e) {
            e.printStackTrace();
            // Hiển thị thông báo lỗi nếu chuyển đổi ngày không hợp lệ
            javax.swing.JOptionPane.showMessageDialog(this, "Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng ngày/tháng/năm.");
            return;
        }

        // Thiết lập các trường cho đối tượng jobPost
        jobPost.setJobDescription(jobDescription);
        jobPost.setSalary(Integer.parseInt(salary)); // Chuyển đổi lương thành số nguyên
        jobPost.setCreatedDate(new Date()); // Đặt ngày tạo là thời gian hiện tại
        jobPost.setActive(true); // Thiết lập is_active
        jobPost.setDateExpire(dateEnd); // Gán ngày hết hạn nhận hồ sơ
        jobPost.setDateReceivingApplication(dateStart); // Gán ngày bắt đầu nhận hồ sơ

        // Tạo JobType
        JobPost.JobType jobTypeObj = new JobPost.JobType();
        jobTypeObj.setJobTypeName(jobType); // Tên loại công việc
        jobPost.setJobType(jobTypeObj);

        // Tạo JobLocation
        JobPost.JobLocation location = new JobPost.JobLocation();
        location.setCity(city);
        location.setState(state);
        location.setZip(zip);
        location.setCountry("Việt Nam"); // Mặc định là Việt Nam
        jobPost.setJobLocation(location);

        // Tạo Category
        JobPost.Category categoryObj = new JobPost.Category();
        categoryObj.setName(category); // Tên ngành nghề
        jobPost.setCategory(categoryObj);

        // Gán giá trị post_by_id (ObjectId) hợp lệ
        jobPost.setPostById(new ObjectId("652dcc4858f1f76c8fd435bc"));  // Sử dụng ObjectId hợp lệ

        // Thêm vào MongoDB qua JobPostController
        try {
            jobPostController.createJobPost(jobPost);

            // Hiển thị thông báo thành công
            javax.swing.JOptionPane.showMessageDialog(this, "Thêm công việc mới thành công!");
        } catch (Exception e) {
            // Hiển thị thông báo lỗi nếu không thêm được
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm công việc: " + e.getMessage());
        }


    }//GEN-LAST:event_btn_ThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Them;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JComboBox<String> cb_job_type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Views.javaswingdev.login.swing.TextField textField1;
    private Views.javaswingdev.login.swing.TextField txt_NgayBatDau;
    private Views.javaswingdev.login.swing.TextField txt_city;
    private javax.swing.JTextArea txt_descJob;
    private Views.javaswingdev.login.swing.TextField txt_ngayKetThuc;
    private Views.javaswingdev.login.swing.TextField txt_state;
    private Views.javaswingdev.login.swing.TextField txt_zip;
    // End of variables declaration//GEN-END:variables
}
