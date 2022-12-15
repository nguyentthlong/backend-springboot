package com.spring.qlda.SpringbootReact.model;


import lombok.*;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //đây là table trong db
@Table(name = "lop")
public class Class {
    @Id
    @GeneratedValue
    @Column(name="id_lop", nullable = false)
    private Long idLop;

    @Column(name = "tenLop", nullable = false)
    private String tenLop;

    @Column(name = "so_sv", nullable = false)
    private String soSV;

    @OneToOne
    @JoinColumn(name = "khoa_ID")
    private Khoa khoaID;

    public Long getIdLop() {
        return idLop;
    }

    public void setIdLop(Long idLop) {
        this.idLop = idLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getSoSV() {
        return soSV;
    }

    public void setSoSV(String soSV) {
        this.soSV = soSV;
    }

    public Khoa getKhoaID() {
        return khoaID;
    }

    public void setKhoaID(Khoa khoaID) {
        this.khoaID = khoaID;
    }
}

