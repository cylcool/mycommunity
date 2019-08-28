package com.cyl.mycommunity.modul;


import lombok.Data;

@Data
public class User {
    private String name;
    private String account_id;
    private String gmt_create;
    private String gmt_modified;
    private String token;
    private String avatar_url;
}
