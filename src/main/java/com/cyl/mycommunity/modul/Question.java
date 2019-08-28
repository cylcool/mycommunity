package com.cyl.mycommunity.modul;

import lombok.Data;

@Data
public class Question {
    private String title;
    private String description;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer creator;
    private Integer comment_count;
    private Integer view_count;
    private Integer like_count;
    private String tag;
    private String avatar_url;
}
