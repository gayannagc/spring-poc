package com.example.comettestproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Permission {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String Type;
    private String description;

    @ManyToMany(mappedBy = "permissionList",cascade = CascadeType.PERSIST)
    private List<Role> roleList;

//    @ManyToMany(cascade=CascadeType.ALL)
//    @JoinTable(
//               name = "VIEW_ACTION_PERMISSION",
//               joinColumns = @JoinColumn(name = "PERMISSION_ID"),
//               inverseJoinColumns = @JoinColumn(name = "VIEW_ACTION_ID"))
//    private List<ViewAction> viewActionList;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "MENU_ID")
    private Menu menu;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Type='" + Type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    //    @ManyToMany(mappedBy = "permissionList")
//    private List<ViewPermission> viewPermissionList;

//


//    @OneToMany(mappedBy = "permission" , cascade = CascadeType.ALL )
//    private List<ViewPermission> viewPermissionList;

//    @OneToMany(mappedBy = "permission" , cascade = CascadeType.ALL )
//    private List<MenuPermission> menuPermissionList;
}
