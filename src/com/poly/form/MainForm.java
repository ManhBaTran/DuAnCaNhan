
package com.poly.form;
import ThanhToan1.From_ThanhToan;
 
import bacsi.From_BacSi;
import benhnhan.BenhNhan;
import benhnhan.From_BenhNhan;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.poly.Application;
import com.poly.form.other.FormDashboard;
import com.poly.menu.Menu;
import com.poly.menu.MenuAction;
import com.poly.menu.MenuEvent;
import com.poly.ph49507.LichHen;
import com.poly.ph49507.ViewBenhAn1;
import com.poly.ph49507.ViewLichHen1;
import com.poly.ph49571.From_ThongKe;
import com.poly.ph49571.ViewChiTietHoaDon;
import com.poly.ph49571.ViewDichVuu;
import com.poly.ph49571.ViewThongKe;
import com.poly.view.From_BacSi1;
import com.poly.view.From_BenhAn;
import com.poly.view.From_ChiTietHoaDon;
import com.poly.view.From_DichVu;
import com.poly.view.From_HoaDon;
import com.poly.view.From_LichHen1;
import com.poly.view.From_LeTan;
import java.sql.SQLException;
 import com.poly.view.From_LichLamViec;
import com.poly.view.From_QLLichHen;
import com.poly.view.From_TrangChu;
import java.text.Normalizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import lichlamviec.LichLamViec_jpanel;

/**
 *
 * @author Raven
 */
public class MainForm extends JLayeredPane {

    public MainForm() {
        init();
    }

    private void init() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new MainFormLayout());
        menu = new Menu();
        panelBody = new JPanel(new BorderLayout());
        initMenuArrowIcon();
        menuButton.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Menu.button.background;"
                + "arc:999;"
                + "focusWidth:0;"
                + "borderWidth:0");
        menuButton.addActionListener((ActionEvent e) -> {
            setMenuFull(!menu.isMenuFull());
        });
        initMenuEvent();
        setLayer(menuButton, JLayeredPane.POPUP_LAYER);
        add(menuButton);
        add(menu);
        add(panelBody);
    }

    @Override
    public void applyComponentOrientation(ComponentOrientation o) {
        super.applyComponentOrientation(o);
        initMenuArrowIcon();
    }

    private void initMenuArrowIcon() {
        if (menuButton == null) {
            menuButton = new JButton();
        }
        String icon = (getComponentOrientation().isLeftToRight()) ? "menu_left.svg" : "menu_right.svg";
        menuButton.setIcon(new FlatSVGIcon("raven/icon/svg/" + icon, 0.8f));
    }

    // Xác định hành động khi menu được kích hoạt
    private void initMenuEvent() {
        menu.addMenuEvent(new MenuEvent() {
            @Override
            public void menuSelected(int index, int subIndex, MenuAction action) {
                // index là chỉ mục cha của menu
                // subIndex là chỉ mục con của menu
                // Application.showForm(Form muốn hiển thị) => tạo form bằng cách sao chép và đổi tên từ package "other"
                // Lưu ý: Mỗi form nên có một label, không nên xóa nó, chỉ cần thu nhỏ kích thước nếu cần thiết.
                // Sau đó kéo và thả các phần tử bạn muốn sử dụng trên form và build lại dự án trước khi chạy.
                // Chạy form tương ứng với chỉ mục
                // các element muốn dùng + build lại dự án rồi chay (các file ko còn cái icon cờ lê nữa :)))
                
                if (index == 0) {
                    try {
                        Application.showForm(new From_TrangChu());
//
                    } catch (SQLException ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else if (index == 1) {
                    Application.showForm(new From_QLLichHen());
                    
                }else if (index == 2) {
                    Application.showForm(new From_LeTan());
                } else if (index == 3) {
                    Application.showForm(new LichLamViec_jpanel());
                }else if (index == 4) {
                    Application.showForm(new ViewBenhAn1());
                }else if (index == 5) {
                    Application.showForm(new  From_BacSi());
                } else if (index == 6) {
                    try {
                        Application.showForm(new  ViewDichVuu());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (index == 7) {
                    Application.showForm(new  From_ThanhToan());
                }else if (index == 8) {
                    try {
                        Application.showForm(new  ViewChiTietHoaDon());
                    } catch (SQLException ex) {
                        Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     if (subIndex == 2) {
                        try {
                            Application.showForm(new From_ThongKe());
                        } catch (SQLException ex) {
                            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                } else {

                }
                } else if (index == 9) {
                Application.logout();
            } else {
                action.cancel();
            }
                
         
            }
        });
    }

                
                
    private void setMenuFull(boolean full) {
        String icon;
        if (getComponentOrientation().isLeftToRight()) {
            icon = (full) ? "menu_left.svg" : "menu_right.svg";
        } else {
            icon = (full) ? "menu_right.svg" : "menu_left.svg";
        }
        menuButton.setIcon(new FlatSVGIcon("raven/icon/svg/" + icon, 0.8f));
        menu.setMenuFull(full);
        revalidate();
    }

    public void hideMenu() {
        menu.hideMenuItem();
    }

    public void showForm(Component component) {
        panelBody.removeAll();
        panelBody.add(component);
        panelBody.repaint();
        panelBody.revalidate();
    }

    public void setSelectedMenu(int index, int subIndex) {
        menu.setSelectedMenu(index, subIndex);
    }

    private Menu menu;
    private JPanel panelBody;
    private JButton menuButton;

    private class MainFormLayout implements LayoutManager {

        @Override
        public void addLayoutComponent(String name, Component comp) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(5, 5);
            }
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            synchronized (parent.getTreeLock()) {
                return new Dimension(0, 0);
            }
        }

        @Override
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                boolean ltr = parent.getComponentOrientation().isLeftToRight();
                Insets insets = UIScale.scale(parent.getInsets());
                int x = insets.left;
                int y = insets.top;
                int width = parent.getWidth() - (insets.left + insets.right);
                int height = parent.getHeight() - (insets.top + insets.bottom);
                int menuWidth = UIScale.scale(menu.isMenuFull() ? menu.getMenuMaxWidth() : menu.getMenuMinWidth());
                int menuX = ltr ? x : x + width - menuWidth;
                menu.setBounds(menuX, y, menuWidth, height);
                int menuButtonWidth = menuButton.getPreferredSize().width;
                int menuButtonHeight = menuButton.getPreferredSize().height;
                int menubX;
                if (ltr) {
                    menubX = (int) (x + menuWidth - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.3f)));
                } else {
                    menubX = (int) (menuX - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.7f)));
                }
                menuButton.setBounds(menubX, UIScale.scale(30), menuButtonWidth, menuButtonHeight);
                int gap = UIScale.scale(5);
                int bodyWidth = width - menuWidth - gap;
                int bodyHeight = height;
                int bodyx = ltr ? (x + menuWidth + gap) : x;
                int bodyy = y;
                panelBody.setBounds(bodyx, bodyy, bodyWidth, bodyHeight);
            }
        }
    }
//    private DoiHangConfigs doiHangConfigs = new DoiHangConfigs();
}
