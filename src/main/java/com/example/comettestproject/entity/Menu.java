package com.example.comettestproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String displayName;
    private Long parentId;

    @OneToMany(mappedBy = "menu")
    private List<Permission> permissionList;

//    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
//    private List<View> viewList;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}

//    @JoinTable(name = "menu_permission", joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
//    @JoinTable(name = "view_list" , joinColumns = @JoinColumn(name = "menu_id"), inverseJoinColumns = @JoinColumn(name = "view_id"))
