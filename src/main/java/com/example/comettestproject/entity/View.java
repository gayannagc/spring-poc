//package com.example.comettestproject.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Entity
//public class View {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    private Long id;
//    private String name;
//    private String displayName;
//    private String viewType;
//    private String description;
//
//    @OneToMany(mappedBy = "view" , cascade = CascadeType.ALL )
//    private List<ViewAction> viewActionList;
//
//    @ManyToOne
//    @JoinColumn(name = "MENU_ID")
//    private Menu menu;
//
//    @Override
//    public String toString() {
//        return "View{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", displayName='" + displayName + '\'' +
//                ", viewType='" + viewType + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
//
//    //    @OneToOne(mappedBy = "view")
////    private Permission viewPermission;
//
////    @OneToMany(mappedBy = "view" , cascade = CascadeType.ALL )
////    private List<ViewAttribute> viewAttributeList;
//}
//
