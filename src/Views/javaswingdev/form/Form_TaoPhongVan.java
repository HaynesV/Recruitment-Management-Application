package Views.javaswingdev.form;

import Controller.InterviewController;
import Controller.JobPostController;
import Controller.RecruitmentProcessController;
import Controller.UserAccountController;
import Model.ComboItem;
import Model.Interview;
import Model.Interviewer;
import Model.JobPost;
import Model.Location;
import Model.RecruitmentProcess;
import Model.UserAccount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Form_TaoPhongVan extends javax.swing.JPanel {

    private DefaultListModel<Object> listModel;
    private ArrayList<RecruitmentProcess.Stage> stagesList;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Form_TaoPhongVan() {
        initComponents();
        loadComboBoxes();
        stagesList = new ArrayList<>(); // Khởi tạo danh sách stages
        listModel = new DefaultListModel<Object>(); // Thay đổi kiểu thành DefaultListModel<Object>
        list_process.setModel(listModel); // Set model cho JList
    }

    private void updateStageList() {
        listModel.clear(); // Xóa tất cả các phần tử cũ
        for (RecruitmentProcess.Stage stage : stagesList) {
            String stageInfo = String.format("%s - %s", stage.getStageName(), stage.getStageStatus());
            listModel.addElement(stageInfo); // Thêm từng giai đoạn vào listModel
        }
    }

    private void loadComboBoxes() {
        loadJobPostCombo();
        loadInterviewerCombo();
        loadUserAccountCombo();
        loadInterviewTypeCombo();
        loadProcessCombo();
    }

    private void loadInterviewTypeCombo() {
        // Hardcoded interview types
        cb_ivType.addItem("Technical");
        cb_ivType.addItem("HR");
        cb_ivType.addItem("Managerial");
        cb_ivType.addItem("Final Round");
    }

    private void loadInterviewerCombo() {
        // Simulating interviewers data (can replace with actual data from InterviewController)
        ArrayList<Interviewer> interviewers = new ArrayList<>();
        interviewers.add(new Interviewer("Nguyen Van B", "Lead Engineer"));
        interviewers.add(new Interviewer("Tran Thi C", "HR Manager"));

        // Add to the ComboBox with both name and position
        for (Interviewer interviewer : interviewers) {
            cb_ivName.addItem(new ComboItem(interviewer.getName(), interviewer.getPosition()));
        }
    }

    private boolean isValidDate(String dateStr) {
        String[] dateFormats = {"dd/MM/yyyy", "dd-MM-yyyy"};
        for (String format : dateFormats) {
            if (isValidFormat(dateStr, format)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidFormat(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);  // Kiểm tra nếu chuỗi có thể được phân tích theo định dạng này
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean validateForm() {
        // Kiểm tra tên vòng phỏng vấn
        if (textField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên vòng phỏng vấn không được để trống.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra trạng thái vòng phỏng vấn (combobox process)
        if (cb_process.getSelectedItem() == null || cb_process.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Trạng thái vòng phỏng vấn không được để trống.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra ngày bắt đầu
        String ngayBatDauStr = txt_ngayBatdau.getText();
        if (ngayBatDauStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được để trống.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra định dạng ngày bắt đầu với nhiều định dạng
        Date dateStarted = null;
        if (!isValidDate(ngayBatDauStr)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không hợp lệ, vui lòng nhập theo định dạng dd/MM/yyyy hoặc dd-MM-yyyy.", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra giờ và phút bắt đầu (Spinner)
        if ((Integer) spin_hour.getValue() < 0 || (Integer) spin_hour.getValue() > 23) {
            JOptionPane.showMessageDialog(this, "Giờ bắt đầu không hợp lệ, phải nằm trong khoảng 0-23.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if ((Integer) spin_minute.getValue() < 0 || (Integer) spin_minute.getValue() > 59) {
            JOptionPane.showMessageDialog(this, "Phút bắt đầu không hợp lệ, phải nằm trong khoảng 0-59.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra ngày kết thúc (nếu có)
        String ngayKetThucStr = txt_NgayKetThuc.getText();
        if (!ngayKetThucStr.isEmpty()) {
            if (!isValidDate(ngayKetThucStr)) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc không hợp lệ, vui lòng nhập theo định dạng dd/MM/yyyy hoặc dd-MM-yyyy.", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Kiểm tra giờ và phút kết thúc (Spinner)
            if ((Integer) spin_hourketthuc.getValue() < 0 || (Integer) spin_hourketthuc.getValue() > 23) {
                JOptionPane.showMessageDialog(this, "Giờ kết thúc không hợp lệ, phải nằm trong khoảng 0-23.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if ((Integer) spin_minuteketthuc.getValue() < 0 || (Integer) spin_minuteketthuc.getValue() > 59) {
                JOptionPane.showMessageDialog(this, "Phút kết thúc không hợp lệ, phải nằm trong khoảng 0-59.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Nếu tất cả các kiểm tra đều thành công
        return true;
    }

    private void loadJobPostCombo() {
        JobPostController jobPostController = new JobPostController();
        ArrayList<JobPost> jobPosts = jobPostController.getAllJobPosts(); // Lấy tất cả JobPost

        // Clear the combobox before adding new items
        cb_jobPost.removeAllItems();

        // Thêm các JobPost trực tiếp vào ComboBox
        for (JobPost jobPost : jobPosts) {
            cb_jobPost.addItem(jobPost);  // Thêm trực tiếp đối tượng JobPost vào ComboBox
        }

        // Xử lý khi người dùng chọn một JobPost từ ComboBox
        cb_jobPost.addActionListener(e -> {
            JobPost selectedJobPost = (JobPost) cb_jobPost.getSelectedItem();
            if (selectedJobPost != null) {
                String selectedJobPostId = selectedJobPost.getId().toHexString();  // Lấy ID của JobPost đã chọn
                System.out.println("Selected JobPost ID: " + selectedJobPostId);  // In ra ID
            }
        });
    }

// Load UserAccount data into cb_sk ComboBox without using ComboItem
    private void loadUserAccountCombo() {
        UserAccountController userAccountController = new UserAccountController();
        ArrayList<UserAccount> userAccounts = userAccountController.getAllUsers(); // Lấy tất cả tài khoản người dùng

        // Clear the combobox before adding new items
        cb_sk.removeAllItems();

        // Thêm các UserAccount trực tiếp vào ComboBox
        for (UserAccount userAccount : userAccounts) {
            cb_sk.addItem(userAccount);  // Thêm trực tiếp đối tượng UserAccount vào ComboBox
        }

        // Xử lý khi người dùng chọn một UserAccount từ ComboBox
        cb_sk.addActionListener(e -> {
            UserAccount selectedUser = (UserAccount) cb_sk.getSelectedItem();
            if (selectedUser != null) {
                String selectedUserId = selectedUser.getId();  // Lấy ID của User đã chọn
                System.out.println("Selected UserAccount ID: " + selectedUserId);  // In ra ID
            }
        });
    }

    private void loadProcessCombo() {
        // Xóa tất cả các mục trước khi thêm mới
        cb_process.removeAllItems();

        // Thêm các giá trị cứng cho trạng thái tiến trình phỏng vấn
        cb_process.addItem("Not Started");     // Chưa bắt đầu
        cb_process.addItem("In Progress");     // Đang tiến hành
        cb_process.addItem("Completed");       // Đã hoàn thành
        cb_process.addItem("Canceled");        // Đã hủy

        // Thiết lập sự kiện khi người dùng chọn một trạng thái
        cb_process.addActionListener(e -> {
            String selectedProcessStatus = cb_process.getSelectedItem().toString();
            System.out.println("Selected Process Status: " + selectedProcessStatus);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_ivType = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ivDate = new Views.javaswingdev.login.swing.TextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_state = new Views.javaswingdev.login.swing.TextField();
        txt_city = new Views.javaswingdev.login.swing.TextField();
        txt_zip = new Views.javaswingdev.login.swing.TextField();
        cb_jobPost = new javax.swing.JComboBox<>();
        cb_ivName = new javax.swing.JComboBox<>();
        cb_sk = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_process = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        spin_hour = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        spin_minute = new javax.swing.JSpinner();
        btn_addState = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cb_process = new javax.swing.JComboBox<>();
        txt_ngayBatdau = new Views.javaswingdev.login.swing.TextField();
        textField2 = new Views.javaswingdev.login.swing.TextField();
        jLabel15 = new javax.swing.JLabel();
        txt_NgayKetThuc = new Views.javaswingdev.login.swing.TextField();
        jLabel16 = new javax.swing.JLabel();
        spin_hourketthuc = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        spin_minuteketthuc = new javax.swing.JSpinner();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TẠO LỊCH PHỎNG VẤN");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("THÔNG TIN "));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("CÔNG VIỆC:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("LOẠI PHỎNG VẤN:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("NGƯỜI PHỎNG VẤN:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("ỨNG VIÊN:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("NGÀY PHỎNG VẤN:");

        txt_ivDate.setForeground(new java.awt.Color(0, 0, 0));
        txt_ivDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐỊA ĐIỂM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("TỈNH/THÀNH PHỐ:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("QUẬN/HUYỆN:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("SỐ NHÀ/ĐƯỜNG");

        txt_state.setForeground(new java.awt.Color(0, 0, 0));
        txt_state.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txt_city.setForeground(new java.awt.Color(0, 0, 0));
        txt_city.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        txt_zip.setForeground(new java.awt.Color(0, 0, 0));
        txt_zip.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txt_state, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(txt_zip, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(41, 41, 41)
                        .addComponent(txt_city, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_zip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        cb_sk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_ivType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_ivDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_jobPost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_ivName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_sk, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_ivType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_ivDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_jobPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cb_ivName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_sk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("VÒNG PHỎNG VẤN"));

        list_process.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_processMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list_process);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("TÊN VÒNG:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("NGÀY BẮT ĐẦU");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("GIỜ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("PHÚT");

        btn_addState.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_addState.setText("THÊM VÒNG");
        btn_addState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addStateActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("TIẾN TRÌNH");

        cb_process.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_ngayBatdau.setForeground(new java.awt.Color(0, 0, 0));
        txt_ngayBatdau.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        textField2.setForeground(new java.awt.Color(0, 0, 0));
        textField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("NGÀY KẾT THÚC");

        txt_NgayKetThuc.setForeground(new java.awt.Color(0, 0, 0));
        txt_NgayKetThuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("GIỜ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("PHÚT");

        btn_Sua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Sua.setText("SỬA");

        btn_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Xoa.setText("XÓA");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spin_hourketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spin_minuteketthuc))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_ngayBatdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spin_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spin_minute))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_NgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                        .addComponent(cb_process, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_Sua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Xoa)
                                .addGap(40, 40, 40))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btn_addState)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayBatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(spin_hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spin_minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(spin_hourketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spin_minuteketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cb_process, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Xoa)
                    .addComponent(btn_Sua))
                .addGap(30, 30, 30)
                .addComponent(btn_addState)
                .addGap(34, 34, 34))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("TẠO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addStateActionPerformed
        // Validate dữ liệu nhập liệu cho nút Thêm giai đoạn
        if (!validateForm()) {
            return; // Nếu dữ liệu không hợp lệ, dừng xử lý
        }

        try {
            String stageName = textField2.getText(); // Lấy tên giai đoạn từ textField2
            String stageStatus = cb_process.getSelectedItem().toString(); // Lấy trạng thái từ combobox cb_process

            // Định dạng ngày
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String ngayBatDauStr = txt_ngayBatdau.getText();
            Date dateStarted = dateFormat.parse(ngayBatDauStr);

            // Lấy giờ và phút từ spinner
            int hourStarted = (Integer) spin_hour.getValue();
            int minuteStarted = (Integer) spin_minute.getValue();

            // Kết hợp giờ phút với ngày bắt đầu
            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(dateStarted);
            startCalendar.set(Calendar.HOUR_OF_DAY, hourStarted);
            startCalendar.set(Calendar.MINUTE, minuteStarted);
            dateStarted = startCalendar.getTime();  // Ngày bắt đầu với thời gian

            // Xử lý ngày kết thúc
            Date dateCompleted = null;
            String ngayKetThucStr = txt_NgayKetThuc.getText();
            if (!ngayKetThucStr.isEmpty()) {
                dateCompleted = dateFormat.parse(ngayKetThucStr);

                // Lấy giờ và phút từ spinner cho ngày kết thúc
                int hourCompleted = (Integer) spin_hourketthuc.getValue();
                int minuteCompleted = (Integer) spin_minuteketthuc.getValue();

                // Kết hợp ngày và thời gian cho ngày kết thúc
                Calendar endCalendar = Calendar.getInstance();
                endCalendar.setTime(dateCompleted);
                endCalendar.set(Calendar.HOUR_OF_DAY, hourCompleted);
                endCalendar.set(Calendar.MINUTE, minuteCompleted);
                dateCompleted = endCalendar.getTime();  // Ngày kết thúc với thời gian
            }

            // Tạo một đối tượng Stage mới và thêm vào danh sách
            RecruitmentProcess.Stage stage = new RecruitmentProcess.Stage();
            stage.setStageName(stageName);
            stage.setStageStatus(stageStatus);
            stage.setDateStarted(dateStarted);
            stage.setDateCompleted(dateCompleted); // Có thể null nếu không có ngày kết thúc
            stage.setFeedback(null); // Có thể thêm phản hồi nếu cần

            stagesList.add(stage); // Thêm giai đoạn vào ArrayList
            updateStageList(); // Cập nhật JList sau khi thêm giai đoạn

            JOptionPane.showMessageDialog(this, "Đã thêm giai đoạn: " + stageName, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Lỗi định dạng ngày: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + e.getMessage(), "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi không xác định: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_addStateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Validate form lịch phỏng vấn trước khi tạo
        if (!validateFormLich()) {
            return; // Dừng lại nếu form không hợp lệ
        }

        try {
            // Lấy thông tin từ các combobox và trường nhập liệu
            String jobPostId = ((JobPost) cb_jobPost.getSelectedItem()).getId().toHexString(); // Lấy ID công việc từ combobox
            String userAccountId = ((UserAccount) cb_sk.getSelectedItem()).getId(); // Lấy ID ứng viên từ combobox
            String interviewType = cb_ivType.getSelectedItem().toString(); // Lấy loại phỏng vấn
            String interviewer = cb_ivName.getSelectedItem().toString(); // Lấy tên người phỏng vấn
            String interviewDateStr = txt_ivDate.getText(); // Lấy ngày phỏng vấn
            String processStatus = cb_process.getSelectedItem().toString(); // Lấy trạng thái tiến trình phỏng vấn

            // Định dạng ngày phỏng vấn
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date interviewDate = dateFormat.parse(interviewDateStr);

            // Tạo đối tượng Interview mới
            Interview interview = new Interview();
            interview.setJobPostId(jobPostId);
            interview.setUserAccountId(userAccountId);
            interview.setInterviewType(interviewType);
            interview.setInterviewDate(interviewDate);

            // Địa điểm phỏng vấn
            Location location = new Location();
            location.setCity(txt_city.getText());
            location.setState(txt_state.getText());
            location.setZip(txt_zip.getText()); // Địa điểm phỏng vấn từ textfields
            interview.setLocation(location);

            // Người phỏng vấn
            ArrayList<Interviewer> interviewers = new ArrayList<>();
            Interviewer interviewerObj = new Interviewer();
            interviewerObj.setName(interviewer);
            interviewerObj.setPosition("Position Example"); // Bạn có thể thay thế "Position Example" bằng giá trị thực
            interviewers.add(interviewerObj);
            interview.setInterviewers(interviewers);

            // Gọi controller để lưu Interview
            InterviewController interviewController = new InterviewController();
            interviewController.createInterview(interview);

            // Sau khi tạo lịch phỏng vấn thành công, tiếp tục tạo đối tượng RecruitmentProcess
            RecruitmentProcess recruitmentProcess = new RecruitmentProcess();
            recruitmentProcess.setJobPostId(jobPostId);
            recruitmentProcess.setUserAccountId(userAccountId);
            recruitmentProcess.setProcessStatus(processStatus);
            recruitmentProcess.setStages(stagesList); // Thêm danh sách các giai đoạn đã thêm

            // Gọi controller để lưu RecruitmentProcess
            RecruitmentProcessController recruitmentProcessController = new RecruitmentProcessController();
            recruitmentProcessController.createRecruitmentProcess(recruitmentProcess);

            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Đã tạo lịch phỏng vấn và tiến trình tuyển dụng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Lỗi định dạng ngày: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi tạo lịch phỏng vấn hoặc tiến trình tuyển dụng: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean validateFormLich() {
        // Kiểm tra công việc (job post)
        if (cb_jobPost.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn công việc.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra ứng viên (user account)
        if (cb_sk.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ứng viên.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra loại phỏng vấn (interview type)
        if (cb_ivType.getSelectedItem() == null || cb_ivType.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại phỏng vấn.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra người phỏng vấn (interviewer)
        if (cb_ivName.getSelectedItem() == null || cb_ivName.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn người phỏng vấn.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra ngày phỏng vấn (interview date)
        String interviewDateStr = txt_ivDate.getText();
        if (interviewDateStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ngày phỏng vấn không được để trống.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra định dạng ngày phỏng vấn (dd/MM/yyyy)
        if (!isValidDate(interviewDateStr)) {
            JOptionPane.showMessageDialog(this, "Ngày phỏng vấn không hợp lệ, vui lòng nhập theo định dạng dd/MM/yyyy hoặc dd-MM-yyyy.", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra địa điểm (city, state, zip)
        if (txt_city.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thành phố.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txt_state.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên tỉnh hoặc bang.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txt_zip.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã bưu điện (ZIP).", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Nếu tất cả các kiểm tra đều thành công
        return true;
    }

    private void list_processMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_processMouseClicked
        int selectedIndex = list_process.getSelectedIndex(); // Lấy index của mục được chọn
        if (selectedIndex != -1) { // Kiểm tra xem có mục nào được chọn không
            RecruitmentProcess.Stage selectedStage = stagesList.get(selectedIndex); // Lấy đối tượng Stage được chọn

            // Hiển thị lại thông tin vào các trường
            textField2.setText(selectedStage.getStageName()); // Đặt lại tên giai đoạn
            cb_process.setSelectedItem(selectedStage.getStageStatus()); // Đặt lại trạng thái của giai đoạn

            // Hiển thị lại ngày bắt đầu
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if (selectedStage.getDateStarted() != null) {
                txt_ngayBatdau.setText(dateFormat.format(selectedStage.getDateStarted())); // Đặt lại ngày bắt đầu
                Calendar startCalendar = Calendar.getInstance();
                startCalendar.setTime(selectedStage.getDateStarted());
                spin_hour.setValue(startCalendar.get(Calendar.HOUR_OF_DAY)); // Đặt lại giờ bắt đầu
                spin_minute.setValue(startCalendar.get(Calendar.MINUTE)); // Đặt lại phút bắt đầu
            }

            // Hiển thị lại ngày kết thúc (nếu có)
            if (selectedStage.getDateCompleted() != null) {
                txt_NgayKetThuc.setText(dateFormat.format(selectedStage.getDateCompleted())); // Đặt lại ngày kết thúc
                Calendar endCalendar = Calendar.getInstance();
                endCalendar.setTime(selectedStage.getDateCompleted());
                spin_hourketthuc.setValue(endCalendar.get(Calendar.HOUR_OF_DAY)); // Đặt lại giờ kết thúc
                spin_minuteketthuc.setValue(endCalendar.get(Calendar.MINUTE)); // Đặt lại phút kết thúc
            } else {
                // Nếu không có ngày kết thúc, xóa sạch các trường liên quan
                txt_NgayKetThuc.setText("");
                spin_hourketthuc.setValue(0);
                spin_minuteketthuc.setValue(0);
            }
        }
    }//GEN-LAST:event_list_processMouseClicked

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void textField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_addState;
    private javax.swing.JComboBox<Object> cb_ivName;
    private javax.swing.JComboBox<String> cb_ivType;
    private javax.swing.JComboBox<Object> cb_jobPost;
    private javax.swing.JComboBox<String> cb_process;
    private javax.swing.JComboBox<Object> cb_sk;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Object> list_process;
    private javax.swing.JSpinner spin_hour;
    private javax.swing.JSpinner spin_hourketthuc;
    private javax.swing.JSpinner spin_minute;
    private javax.swing.JSpinner spin_minuteketthuc;
    private Views.javaswingdev.login.swing.TextField textField2;
    private Views.javaswingdev.login.swing.TextField txt_NgayKetThuc;
    private Views.javaswingdev.login.swing.TextField txt_city;
    private Views.javaswingdev.login.swing.TextField txt_ivDate;
    private Views.javaswingdev.login.swing.TextField txt_ngayBatdau;
    private Views.javaswingdev.login.swing.TextField txt_state;
    private Views.javaswingdev.login.swing.TextField txt_zip;
    // End of variables declaration//GEN-END:variables
}
