//package com.example.comettestproject.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Entity
//public class ViewAction {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    private Long id;
//    private String name;
//    private String description;
//    private boolean isMandatory;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "VIEW_ID")
//    private View view;
//
//    @ManyToMany(mappedBy = "viewActionList", cascade = CascadeType.ALL)
//    private List<Permission> permissionList;
//
//    @Override
//    public String toString() {
//        return "ViewAction{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
//    //    @ManyToMany
////    @JoinTable(name = "view_action_view_permission", joinColumns = @JoinColumn(name = "view_action_id"), inverseJoinColumns = @JoinColumn(name = "view_permission_id"))
////    private List<ViewPermission> viewPermissionList;
//
//}
