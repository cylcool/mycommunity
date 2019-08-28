package com.cyl.mycommunity.Controller;

import com.cyl.mycommunity.ControllerAccessToken.AccessToken;
import com.cyl.mycommunity.DTO.GitProvator;
import com.cyl.mycommunity.DTO.QuestionDTO;
import com.cyl.mycommunity.DTO.Userinfo;
import com.cyl.mycommunity.mapper.usermapper;
import com.cyl.mycommunity.modul.User;
import com.cyl.mycommunity.service.QuestionImp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Index {

    @Autowired
    AccessToken getAccess;

    @Autowired
    usermapper usermapper;

    @Autowired
    QuestionImp questionDTOimp;

    @RequestMapping("/index")
    public String index(Model model){
        List<QuestionDTO> Questions = questionDTOimp.getQuestionDTO();
        model.addAttribute("Questions",Questions);
        return "/index";
    }



    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name ="state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response){

        GitProvator git = new GitProvator();
        git.setClient_id("a7deac3021b649badfb4");
        git.setRedirect_uri("http://localhost:8989/callback");
        git.setClient_secret("625ddc1474b60e7ed1763622840827f80d42a6f0");
        git.setCode(code);
        git.setState(state);

        String accessToken = getAccess.getAccessToken(git);

        Userinfo userinfo = getAccess.getUser();

        User user = new User();
        user.setName(userinfo.getLogin());
        user.setAccount_id(String.valueOf(userinfo.getId()));
        user.setToken(accessToken);
        user.setGmt_create(String.valueOf(System.currentTimeMillis()));
        user.setGmt_modified(user.getGmt_create());
        user.setAvatar_url(userinfo.getAvatar_url());
        System.out.println(user);

        request.getSession().setAttribute("user",user);

        usermapper.insert(user);
        return "redirect:/index";
    }

}
