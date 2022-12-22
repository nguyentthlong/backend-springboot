package com.spring.qlda.SpringbootReact.model;

import javax.persistence.*;

@Entity
@Table(name = "roles" //
//        uniqueConstraints = { //
//                @UniqueConstraint(name = "ROLE_UK", columnNames = "Role_Name") }
               )
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "id_role")
    private Integer idRole;

    private String roleName;

//    @Override
//    public String toString() {
//        return "Role {idRole=" + idRole + ", roleName=" + roleName + "}";
//    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
