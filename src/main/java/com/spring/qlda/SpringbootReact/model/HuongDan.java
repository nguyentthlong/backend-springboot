package com.spring.qlda.SpringbootReact.model;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //đây là table trong db
@Table(name = "huongdan")
public class HuongDan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "giangvien_id")
    private GiangVien giangvienID;

    @OneToOne
    @JoinColumn(name = "sinhvien_id")
    private Student sinhvienID;

    @ManyToOne
    @JoinColumn(name = "detai_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private DeTai deTai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GiangVien getGiangvienID() {
        return giangvienID;
    }

    public void setGiangvienID(GiangVien giangvienID) {
        this.giangvienID = giangvienID;
    }

    public Student getSinhvienID() {
        return sinhvienID;
    }

    public void setSinhvienID(Student sinhvienID) {
        this.sinhvienID = sinhvienID;
    }

    public DeTai getDeTai() {
        return deTai;
    }

    public void setDeTai(DeTai deTai) {
        this.deTai = deTai;
    }
}

