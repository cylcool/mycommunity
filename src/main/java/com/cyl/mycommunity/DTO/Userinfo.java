package com.cyl.mycommunity.DTO;

import lombok.Data;

@Data
public class Userinfo {
    private Integer id;
    private String login;
    private String bio;
    private String avatar_url;
}
