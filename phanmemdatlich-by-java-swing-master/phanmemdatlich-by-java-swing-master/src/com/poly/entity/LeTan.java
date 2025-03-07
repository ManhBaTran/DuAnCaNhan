    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.poly.entity;

    import java.util.Date;

    /**
     *
     * @author ASUS
     */
    public class LeTan {
        private int id;
        private String ten;
        private String email;
        private int sodienthoai;
        private String matkhau;    
        private String diachi;
        private Date ngaySinh;
        private String gioiTinh;
        private String ngaytao;
        private String trangthai;

        public LeTan() {
        }

        public LeTan(int id, String ten, String email, int sodienthoai, String matkhau, String diachi, Date ngaySinh, String gioiTinh, String ngaytao, String trangthai) {
            this.id = id;
            this.ten = ten;
            this.email = email;
            this.sodienthoai = sodienthoai;
            this.matkhau = matkhau;
            this.diachi = diachi;
            this.ngaySinh = ngaySinh;
            this.gioiTinh = gioiTinh;
            this.ngaytao = ngaytao;
            this.trangthai = trangthai;
        }



        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }




        public String getTen() {
            return ten;
        }

        public void setTen(String ten) {
            this.ten = ten;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getSodienthoai() {
            return sodienthoai;
        }

        public void setSodienthoai(int sodienthoai) {
            this.sodienthoai = sodienthoai;
        }

        public String getMatkhau() {
            return matkhau;
        }

        public void setMatkhau(String matkhau) {
            this.matkhau = matkhau;
        }



        public Date getNgaySinh() {
            return ngaySinh;
        }

        public void setNgaySinh(Date ngaySinh) {
            this.ngaySinh = ngaySinh;
        }

        public String getGioiTinh() {
            return gioiTinh;
        }

        public void setGioiTinh(String gioiTinh) {
            this.gioiTinh = gioiTinh;
        }



        public String getDiachi() {
            return diachi;
        }

        public void setDiachi(String diachi) {
            this.diachi = diachi;
        }

        public String getNgaytao() {
            return ngaytao;
        }

        public void setNgaytao(String ngaytao) {
            this.ngaytao = ngaytao;
        }

        public String getTrangthai() {
            return trangthai;
        }

        public void setTrangthai(String trangthai) {
            this.trangthai = trangthai;
        }


        public Object[] rowDt(){
            return new Object[]{
               id,ten, email, sodienthoai, matkhau, diachi, ngaySinh, gioiTinh, ngaytao, trangthai
            };
        }
    }
