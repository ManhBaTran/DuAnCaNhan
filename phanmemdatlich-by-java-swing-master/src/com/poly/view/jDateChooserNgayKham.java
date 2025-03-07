/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.view;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser; // Sử dụng thư viện JDateChooser

/**
 *
 * @author manh9
 */
class jDateChooserNgayKham {

    static Date getDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private JDateChooser dateChooser; // Sử dụng JDateChooser từ thư viện bên ngoài

    public jDateChooserNgayKham() {
        dateChooser = new JDateChooser();
        this.add(dateChooser);
    }


    // Phương thức để đặt ngày cho JDateChooser
    public void setDate(Date date) {
        dateChooser.setDate(date);
    }

    private void add(JDateChooser dateChooser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
