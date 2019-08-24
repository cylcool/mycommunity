package com.cyl.mycommunity.ControllerIndex;

import com.cyl.mycommunity.ControllerAccessToken.AccessToken;
import com.cyl.mycommunity.DTO.GitProvator;
import com.cyl.mycommunity.DTO.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class controller {

    @Autowired
    AccessToken getAccess;
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name ="state")String state,
                           HttpServletRequest request){


        GitProvator git = new GitProvator();
        git.setClient_id("a7deac3021b649badfb4");
        git.setRedirect_uri("http://localhost:8989/callback");
        git.setClient_secret("625ddc1474b60e7ed1763622840827f80d42a6f0");
        git.setCode(code);
        git.setState(state);


        String accessToken = getAccess.getAccessToken(git);
        System.out.println(accessToken);
        Userinfo user = getAccess.getUser();
        request.getSession().setAttribute("user",user);
        System.out.println(user);

        return "redirect:/index";
    }

}
