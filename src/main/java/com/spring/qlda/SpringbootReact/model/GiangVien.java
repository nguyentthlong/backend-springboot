package com.spring.qlda.SpringbootReact.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //đây là table trong db
@Table(name = "giangvien")
public class GiangVien {
    @Id
    @GeneratedValue
    @Column(name="id_giangvien", nullable = false)
    private Long idGiangVien;

    @Column(name = "ten_giangvien", nullable = false)
    private String tenGiangVien;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "address")
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "hoc_vi", nullable = false)
    private String hocVi;

    @Column(name = "chuc_vu", nullable = false)
    private String chucVu;

    @OneToOne
    @JoinColumn(name = "khoa_id")
    private Khoa khoaID;

    public Long getIdGiangVien() {
        return idGiangVien;
    }

    public void setIdGiangVien(Long idGiangVien) {
        this.idGiangVien = idGiangVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Khoa getKhoaID() {
        return khoaID;
    }

    public void setKhoaID(Khoa khoaID) {
        this.khoaID = khoaID;
    }
}

