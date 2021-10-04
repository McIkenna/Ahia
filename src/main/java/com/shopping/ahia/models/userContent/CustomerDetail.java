package com.shopping.ahia.models;

import java.util.List;

public class CustomerDetail {
    private Gender gender;
    private String phoneNum;
    private List<Address> address;
    private List<Cart> cart; //one to many with cart

}
