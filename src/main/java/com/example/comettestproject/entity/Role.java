package com.example.comettestproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String description;

//    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
//    private List<CometUser> cometUser;

    @ManyToMany(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(name = "ROLE_PERMISSION",
               joinColumns = @JoinColumn(name = "ROLE_ID"),
               inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID"))
    private List<Permission> permissionList;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
