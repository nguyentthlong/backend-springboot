package com.spring.qlda.SpringbootReact.model;

import javax.persistence.*;

@Entity
@Table(name = "Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "ROLE_UK", columnNames = "Role_Name") })
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "Role_Id", nullable = false)
    private Long roleId;

    @Column(name = "Role_Name", length = 30, nullable = false)
    private String roleName;

    @Override
    public String toString() {
        return "Role {roleId=" + roleId + ", roleName=" + roleName + "}";
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
