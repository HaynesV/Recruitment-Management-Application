package Views.javaswingdev.swing;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
public class ActionCellRenderer extends JPanel implements TableCellRenderer {

    public ActionCellRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        JButton btnView = new JButton(new ImageIcon("D:/Code/MongoDB_DoAn/src/Views/javaswingdev/swing/icons/view.png"));
        btnView.setPreferredSize(new Dimension(24, 24));  // Đặt kích thước cho nút
        btnView.setBorderPainted(false);  // Ẩn viền nút
        btnView.setContentAreaFilled(false);  // Ẩn nền nút
//        JButton btnEdit = new JButton(new ImageIcon("icons/edit.png")); // Đặt icon cây bút
//        btnEdit.setPreferredSize(new Dimension(24, 24));  // Đặt kích thước cho nút
//        btnEdit.setBorderPainted(false);  // Ẩn viền nút
//        btnEdit.setContentAreaFilled(false);  // Ẩn nền nút
//        JButton btnDelete = new JButton(new ImageIcon("icons/delete.png")); // Đặt icon thùng rác
//        btnDelete.setPreferredSize(new Dimension(24, 24));  // Đặt kích thước cho nút
//        btnDelete.setBorderPainted(false);  // Ẩn viền nút
//        btnDelete.setContentAreaFilled(false);  // Ẩn nền nút

        add(btnView);
//        add(btnEdit);
//        add(btnDelete);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}

