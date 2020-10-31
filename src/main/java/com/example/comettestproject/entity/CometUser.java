//package com.example.comettestproject.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//
//@Data
//@Entity
//public class CometUser {
//// in this level not care about authorities, So havn't map relation ship among permition related entities
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    private Long userId;
//    private String userName;
//    private String password;
//    private String givenName;
//    private String familyName;
//    private String email;
//    private String msisdn;
//    private String lastLogin;
//
//    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
//    private Status status;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ROLE_ID")
//    private Role role;
//
//
//    @Override
//    public String toString() {
//        return "CometUser{" +
//                "userId=" + userId +
//                ", userName='" + userName + '\'' +
//                ", password='" + password + '\'' +
//                ", givenName='" + givenName + '\'' +
//                ", familyName='" + familyName + '\'' +
//                ", email='" + email + '\'' +
//                ", msisdn='" + msisdn + '\'' +
//                ", lastLogin='" + lastLogin + '\'' +
//                '}';
//    }
//}
