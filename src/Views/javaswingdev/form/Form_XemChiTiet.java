package Views.javaswingdev.form;

import Controller.JobPostController;
import Model.JobPost;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Form_XemChiTiet extends javax.swing.JPanel {

    private JobPost jobPost;

    public Form_XemChiTiet() {
        initComponents();
        loadJobTypes();
        loadCategories();
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
        cb_jobtype.setModel(new DefaultComboBoxModel<>(jobTypes.toArray(new String[0])));
        cb_jobtype.setSelectedIndex(0); // Đặt lựa chọn đầu tiên là chuỗi rỗng
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

    public void loadData(JobPost jobPost) {
        this.jobPost = jobPost;
        System.out.println("JOB ID: " + jobPost.getId());
        txt_descrpJob.setText(jobPost.getJobDescription());
        txt_salary.setText(String.valueOf(jobPost.getSalary())); // Chuyển lương từ Integer sang String

        // Định dạng ngày
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // Hiển thị ngày bắt đầu và ngày kết thúc nếu có
        txt_ngayBatDau.setText(jobPost.getDateReceivingApplication() != null ? dateFormat.format(jobPost.getDateReceivingApplication()) : "N/A");
        txt_ngayKetThuc.setText(jobPost.getDateExpire() != null ? dateFormat.format(jobPost.getDateExpire()) : "N/A");

        // Địa chỉ
        if (jobPost.getJobLocation() != null) {
            txt_city.setText(jobPost.getJobLocation().getCity());
            txt_state.setText(jobPost.getJobLocation().getState());
            txt_zip.setText(jobPost.getJobLocation().getZip());
        } else {
            txt_city.setText("Unknown");
            txt_state.setText("Unknown");
            txt_zip.setText("Unknown");
        }

        // Người nhận công việc
        txt_userName.setText(jobPost.getUserName() != null ? jobPost.getUserName() : "Chưa có người nhận");

        // Chọn JobType nếu có
        if (jobPost.getJobType() != null) {
            cb_jobtype.setSelectedItem(jobPost.getJobType().getJobTypeName());
        } else {
            cb_jobtype.setSelectedIndex(0); // Chọn giá trị trống nếu không có JobType
        }

        // Chọn Category nếu có
        if (jobPost.getCategory() != null) {
            cb_category.setSelectedItem(jobPost.getCategory().getName());
        } else {
            cb_category.setSelectedIndex(0); // Chọn giá trị trống nếu không có Category
        }
    }

    // Add listeners for buttons
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField6 = new Views.javaswingdev.login.swing.TextField();
        textField8 = new Views.javaswingdev.login.swing.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_zip = new Views.javaswingdev.login.swing.TextField();
        txt_city = new Views.javaswingdev.login.swing.TextField();
        txt_state = new Views.javaswingdev.login.swing.TextField();
        txt_salary = new Views.javaswingdev.login.swing.TextField();
        txt_ngayKetThuc = new Views.javaswingdev.login.swing.TextField();
        txt_descrpJob = new Views.javaswingdev.login.swing.TextField();
        jLabel10 = new javax.swing.JLabel();
        txt_userName = new Views.javaswingdev.login.swing.TextField();
        btnChinhSua = new javax.swing.JButton();
        btn_Dong = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cb_jobtype = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_ngayBatDau = new Views.javaswingdev.login.swing.TextField();

        textField6.setText("textField1");

        textField8.setText("textField1");

        setForeground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CHI TIẾT CÔNG VIỆC");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("MÔ TẢ CÔNG VIỆC:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("LƯƠNG:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("NGÀY TẠO:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("ĐỊA CHỈ"));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("ĐƯỜNG");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("TỈNH/THÀNH PHỐ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("QUẬN/HUYỆN");

        txt_zip.setForeground(new java.awt.Color(0, 0, 0));
        txt_zip.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txt_city.setForeground(new java.awt.Color(0, 0, 0));
        txt_city.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txt_state.setForeground(new java.awt.Color(0, 0, 0));
        txt_state.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_zip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_city, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                    .addComponent(txt_state, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_zip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7))
                    .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        txt_salary.setForeground(new java.awt.Color(0, 0, 0));
        txt_salary.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txt_ngayKetThuc.setForeground(new java.awt.Color(0, 0, 0));
        txt_ngayKetThuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txt_descrpJob.setForeground(new java.awt.Color(0, 0, 0));
        txt_descrpJob.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("NGƯỜI LÀM:");

        txt_userName.setForeground(new java.awt.Color(0, 0, 0));
        txt_userName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnChinhSua.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnChinhSua.setText("CHỈNH SỬA");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        btn_Dong.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btn_Dong.setText("ĐÓNG");
        btn_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("LOẠI CÔNG VIỆC:");

        cb_jobtype.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("NGÀNH:");

        cb_category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("NGÀY KẾT THÚC:");

        txt_ngayBatDau.setForeground(new java.awt.Color(0, 0, 0));
        txt_ngayBatDau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnChinhSua)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_Dong)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 11, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel2)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jLabel3)
                                                            .addGap(96, 96, 96))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(jLabel4)
                                                            .addGap(72, 72, 72)))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txt_salary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(txt_descrpJob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                    .addComponent(cb_jobtype, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(41, 41, 41)
                                                                    .addComponent(jLabel12)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                    .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                    .addComponent(txt_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(jLabel5)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                    .addComponent(txt_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGap(0, 0, Short.MAX_VALUE)))))
                                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel9)
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4))
                    .addComponent(txt_descrpJob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cb_jobtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_ngayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txt_ngayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChinhSua)
                            .addComponent(btn_Dong))
                        .addGap(34, 34, 34))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        if (jobPost == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy công việc để cập nhật.");
            return; // Stop further execution
        }

        // Xác nhận từ người dùng trước khi thực hiện chỉnh sửa
        int confirmed = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn chỉnh sửa công việc này?", "Xác nhận chỉnh sửa", JOptionPane.YES_NO_OPTION);

        if (confirmed != JOptionPane.YES_OPTION) {
            // Nếu người dùng chọn "No" hoặc đóng hộp thoại, dừng việc cập nhật
            return;
        }

        // Validate dữ liệu trước khi cập nhật
        try {
            // Kiểm tra mô tả công việc không được để trống
            if (txt_descrpJob.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mô tả công việc.");
                return;
            }

            // Kiểm tra mức lương không được để trống và phải là số
            if (txt_salary.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mức lương.");
                return;
            }

            try {
                Integer.parseInt(txt_salary.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Mức lương phải là một số hợp lệ.");
                return;
            }

            // Kiểm tra ngày bắt đầu và ngày kết thúc phải có định dạng đúng "dd-MM-yyyy"
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);  // Để đảm bảo kiểm tra chặt chẽ định dạng ngày tháng

            Date dateStart = null;
            Date dateEnd = null;

            if (!txt_ngayBatDau.getText().trim().isEmpty()) {
                try {
                    dateStart = dateFormat.parse(txt_ngayBatDau.getText().trim());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Ngày bắt đầu không hợp lệ. Vui lòng nhập đúng định dạng dd-MM-yyyy.");
                    return;
                }
            }

            if (!txt_ngayKetThuc.getText().trim().isEmpty()) {
                try {
                    dateEnd = dateFormat.parse(txt_ngayKetThuc.getText().trim());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Ngày kết thúc không hợp lệ. Vui lòng nhập đúng định dạng dd-MM-yyyy.");
                    return;
                }
            }

            // Cập nhật dữ liệu cho đối tượng jobPost
            jobPost.setJobDescription(txt_descrpJob.getText().trim());
            jobPost.setSalary(Integer.parseInt(txt_salary.getText().trim()));
            jobPost.setDateReceivingApplication(dateStart);
            jobPost.setDateExpire(dateEnd);

            // Cập nhật loại công việc nếu có
            if (!cb_jobtype.getSelectedItem().toString().isEmpty()) {
                if (jobPost.getJobType() == null) {
                    jobPost.setJobType(new JobPost.JobType()); // Khởi tạo JobType nếu null
                }
                jobPost.getJobType().setJobTypeName(cb_jobtype.getSelectedItem().toString());
            }

            // Cập nhật ngành nghề nếu có
            if (!cb_category.getSelectedItem().toString().isEmpty()) {
                if (jobPost.getCategory() == null) {
                    jobPost.setCategory(new JobPost.Category()); // Khởi tạo Category nếu null
                }
                jobPost.getCategory().setName(cb_category.getSelectedItem().toString());
            }

            // Cập nhật địa chỉ
            if (jobPost.getJobLocation() == null) {
                jobPost.setJobLocation(new JobPost.JobLocation()); // Khởi tạo JobLocation nếu null
            }
            jobPost.getJobLocation().setCity(txt_city.getText().trim());
            jobPost.getJobLocation().setState(txt_state.getText().trim());
            jobPost.getJobLocation().setZip(txt_zip.getText().trim());

            // Gọi phương thức cập nhật trong JobPostController để lưu dữ liệu vào MongoDB
            JobPostController jobPostController = new JobPostController();
            jobPostController.updateJobPost(jobPost.getId().toHexString(), jobPost);

            // Thông báo cập nhật thành công
            JOptionPane.showMessageDialog(this, "Cập nhật công việc thành công!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi cập nhật công việc: " + e.getMessage());
        }
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btn_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DongActionPerformed
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btn_DongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btn_Dong;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JComboBox<String> cb_jobtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private Views.javaswingdev.login.swing.TextField textField6;
    private Views.javaswingdev.login.swing.TextField textField8;
    private Views.javaswingdev.login.swing.TextField txt_city;
    private Views.javaswingdev.login.swing.TextField txt_descrpJob;
    private Views.javaswingdev.login.swing.TextField txt_ngayBatDau;
    private Views.javaswingdev.login.swing.TextField txt_ngayKetThuc;
    private Views.javaswingdev.login.swing.TextField txt_salary;
    private Views.javaswingdev.login.swing.TextField txt_state;
    private Views.javaswingdev.login.swing.TextField txt_userName;
    private Views.javaswingdev.login.swing.TextField txt_zip;
    // End of variables declaration//GEN-END:variables
}
