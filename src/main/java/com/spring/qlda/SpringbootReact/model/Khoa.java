package com.spring.qlda.SpringbootReact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khoa")
public class Khoa {
    @Id
    @GeneratedValue
    @Column(name="idKhoa", nullable = false)
    private Long idKhoa;

    @Column(name = "tenKhoa", nullable = false)
    private String tenKhoa;

    @Column(name = "truongKhoa", nullable = false)
    private String truongKhoa;

    public Long getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(Long idKhoa) {
        this.idKhoa = idKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getTruongKhoa() {
        return truongKhoa;
    }

    public void setTruongKhoa(String truongKhoa) {
        this.truongKhoa = truongKhoa;
    }
}
