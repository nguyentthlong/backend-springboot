package com.spring.qlda.SpringbootReact.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detai")
public class DeTai {
    @Id
    @GeneratedValue
    @Column(name="id_DT", nullable = false)
    private Long idDT;

    @Column(name = "ten_DT", nullable = false)
    private String tenDT;

    @Column(name = "file_DT", nullable = false)
    private String fileDT;

    @Column(name = "nam")
    private String nam;

    @OneToMany(mappedBy = "deTai", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<HuongDan> huongDans;

    public Long getIdDT() {
        return idDT;
    }

    public void setIdDT(Long idDT) {
        this.idDT = idDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getFileDT() {
        return fileDT;
    }

    public void setFileDT(String fileDT) {
        this.fileDT = fileDT;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public Collection<HuongDan> getHuongDans() {
        return huongDans;
    }

    public void setHuongDans(Collection<HuongDan> huongDans) {
        this.huongDans = huongDans;
    }
}
