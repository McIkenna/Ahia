package com.shopping.ahia.models;

public class AppUser {
    private Long id;
    private String username;
    private String email;
    private String password;
    //private String authorities;
   // private String userImage;
    private CustomerDetail customerDetail;//One to one with the User
}
