package Views.javaswingdev.card;

import Model.JobPost;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.GoogleMaterialIcon;
import javaswingdev.GradientType;
import Views.javaswingdev.card.ModelCard;
import java.awt.event.ActionListener;

public class Card extends javax.swing.JPanel {

    private GoogleMaterialDesignIcon icon;

    public Card() {
        initComponents();
        init();
    }

    private void init() {
        setOpaque(false);
        setBackground(Color.WHITE);
        setIcon(GoogleMaterialDesignIcon.WORK);  // Sử dụng icon mặc định cho công việc
    }

    // Thiết lập icon cho card
    public void setIcon(GoogleMaterialDesignIcon icon) {
        this.icon = icon;
        lbIcon.setIcon(new GoogleMaterialIcon(icon, GradientType.DIAGONAL_1, new Color(191, 191, 191), Color.WHITE, 32).toIcon());
    }

    public GoogleMaterialDesignIcon getIcon() {
        return icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Area area = new Area(new RoundRectangle2D.Double(0, 20, getWidth(), getHeight() - 20, 10, 10));
        g2.setColor(getBackground());
        g2.fill(area);
        area.subtract(new Area(new Rectangle2D.Double(0, 20, getWidth(), getHeight() - 23)));
        g2.setPaint(new GradientPaint(0, 0, lbIcon.getColor1(), getWidth(), 0, lbIcon.getColor2()));
        g2.fill(area);
        g2.dispose();
        super.paintComponent(g);
    }

    public Color getColor1() {
        return lbIcon.getColor1();
    }

    public void setColor1(Color color1) {
        lbIcon.setColor1(color1);
    }

    public Color getColor2() {
        return lbIcon.getColor2();
    }

    public void setColor2(Color color2) {
        lbIcon.setColor2(color2);
    }
    private JobPost jobPost;

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }

    public JobPost getJobPost() {
        return this.jobPost;
    }

    // Phương thức để set thông tin từ ModelCard
    public void setData(ModelCard data) {
        lbDescription.setText(data.getJobDescription().toUpperCase());  // Hiển thị mô tả công việc
        lbValues.setText((data.getSalary() + "$").toUpperCase());  // Hiển thị mức lương
        lbLocation.setText(data.getLocation().toUpperCase());  // Hiển thị địa điểm
        lbJobType.setText(data.getJobType().toUpperCase());  // Hiển thị loại công việc
        lbCreatedDate.setText(data.getCreatedDate().toUpperCase());  // Hiển thị ngày đăng
        lbUserName.setText(data.getUserName().toUpperCase());  // Hiển thị tên người nhận (hoặc Chưa có người nhận)
        repaint();
    }

    public void addDetailButtonListener(ActionListener action) {
        btn_xemChiTiet.addActionListener(action);

    }

    public void addDeleteButtonListener(ActionListener action) {
        btn_Xoa.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbValues = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();
        lbJobType = new javax.swing.JLabel();
        lbLocation = new javax.swing.JLabel();
        lbCreatedDate = new javax.swing.JLabel();
        lbIcon = new Views.javaswingdev.card.LabelIcon();
        btn_xemChiTiet = new javax.swing.JButton();
        lbUserName = new javax.swing.JLabel();
        btn_Xoa = new javax.swing.JButton();

        lbValues.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbValues.setForeground(new java.awt.Color(128, 128, 128));
        lbValues.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValues.setText("$ 0.00");

        lbDescription.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbDescription.setForeground(new java.awt.Color(153, 153, 153));
        lbDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDescription.setText("MÔ TẢ CÔNG VIỆC");

        lbJobType.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbJobType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJobType.setText("LOẠI CÔNG VIỆC");

        lbLocation.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbLocation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLocation.setText("ĐỊA ĐIỂM");

        lbCreatedDate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbCreatedDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCreatedDate.setText("Ngày đăng");

        btn_xemChiTiet.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_xemChiTiet.setText("XEM CHI TIẾT");
        btn_xemChiTiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbUserName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUserName.setText("N");

        btn_Xoa.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_Xoa.setText("XÓA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbJobType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbValues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCreatedDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_xemChiTiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Xoa)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbJobType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLocation)
                .addGap(8, 8, 8)
                .addComponent(lbCreatedDate)
                .addGap(18, 18, 18)
                .addComponent(lbValues)
                .addGap(18, 18, 18)
                .addComponent(lbUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xemChiTiet)
                    .addComponent(btn_Xoa))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_xemChiTiet;
    private javax.swing.JLabel lbCreatedDate;
    private javax.swing.JLabel lbDescription;
    private Views.javaswingdev.card.LabelIcon lbIcon;
    private javax.swing.JLabel lbJobType;
    private javax.swing.JLabel lbLocation;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JLabel lbValues;
    // End of variables declaration//GEN-END:variables
}
