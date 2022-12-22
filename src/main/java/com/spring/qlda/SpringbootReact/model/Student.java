package com.spring.qlda.SpringbootReact.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity //đây là table trong db
@Table(name = "student")
public class Student {
    @Id
    @Column(name="msv", nullable = false)
    private Long msv;

    @Column(name = "name", nullable = false)
    private String name;

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

    @OneToOne
    @JoinColumn(name = "lopID")
    private Class lopID;

    @OneToOne
    @JoinColumn(name = "detaiID")
    private DeTai detaiID;

    public DeTai getDetaiID() {
        return detaiID;
    }

    public void setDetaiID(DeTai detaiID) {
        this.detaiID = detaiID;
    }

    public Class getLopID() {
        return lopID;
    }

    public void setLopID(Class lopID) {
        this.lopID = lopID;
    }

    public Long getMsv() {
        return msv;
    }

    public void setMsv(Long msv) {
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
