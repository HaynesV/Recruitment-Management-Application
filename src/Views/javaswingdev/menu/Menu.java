package Views.javaswingdev.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import Views.javaswingdev.swing.scroll.ScrollBar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;


public class Menu extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();

    public Menu() {
        init();
    }

    private void init() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        addTitle("MAIN");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DASHBOARD, "Trang chủ"));
        addTitle("ỨNG VIÊN");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.MAIL_OUTLINE, "Cá nhân", "Đăng ký tài khoản"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.MESSAGE, "Quản lý ứng viên"));
        
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PERM_CONTACT_CALENDAR, "Công việc","Quản lí công việc","Thống kê công việc"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.CODE, "Duyệt ứng viên"));
        addTitle("PHỎNG VẤN");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.WHATSHOT, "Quản lý lịch phỏng vấn", "Xem danh sách lịch","Lên lịch phỏng vấn"));
       
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DVR, "Quản lý phỏng vấn", "Lên lịch phỏng vấn", "Gửi lời mời phỏng vấn", "Ghi nhận nhận xét, đánh giá"));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PIE_CHART_OUTLINED, "Quản lý hợp đồng", "Xác nhận thông tin tuyển dụng", "Quản lý hợp đồng"));
//        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.VIEW_LIST, "Quản lý khóa đào tạo", "Tổ chức các khóa đào tạo", "Quản lý danh sách người tham gia và thời gian tổ chức"));
       
     
    }

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());
        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);
        menuItem.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                if (!menuItem.isHasSubMenu() || indexSubMenu != 0) {
                    clearSelected();
                    setSelectedIndex(index, indexSubMenu);
                }
            }
        });
        return menuItem;
    }

    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    //  Public Method
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(170, 170, 170));
        panelMenu.add(label);
    }

    public void addSpace(int size) {
        panelMenu.add(new JLabel(), "h " + size + "!");
    }

    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
                    break;
                }
            }
        }
    }

    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                item.clearSelected();
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

    private MigLayout menuLayout;
    private JPanel panelMenu;
}
