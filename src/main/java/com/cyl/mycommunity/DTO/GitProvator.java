package com.cyl.mycommunity.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class GitProvator {
    String client_id;
    String redirect_uri;
    String code;
    String client_secret;
    String state;
}
