package com.cyl.mycommunity.Controller;


import com.cyl.mycommunity.DTO.Userinfo;
import com.cyl.mycommunity.mapper.Questionmapper;
import com.cyl.mycommunity.mapper.usermapper;
import com.cyl.mycommunity.modul.Question;
import com.cyl.mycommunity.modul.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class publish {

    @Autowired
    Questionmapper questionmapper;

    @Autowired
    com.cyl.mycommunity.mapper.usermapper usermapper;

    @GetMapping("/publish")
    public String dopublish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String publish(@RequestParam(name = "title") String title,
                          @RequestParam(name = "description") String description,
                          @RequestParam(name = "tag") String tag,
                          Model model,
                          HttpServletRequest request){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(StringUtils.isBlank(title) ){
            model.addAttribute("msg","请输入标题");
            return "/publish";
        }
        if(StringUtils.isBlank(description) ){
            model.addAttribute("msg","请输入正文内容");
            return "/publish";
        }
        if(StringUtils.isBlank(tag) ){
            model.addAttribute("msg","请输入标签");
            return "/publish";
        }

        User user = (User) request.getSession().getAttribute("user");
        Integer id = usermapper.findByToken(user.getToken());

        Question q = new Question();
        q.setTitle(title);
        q.setDescription(description);
        q.setTag(tag);
        q.setCreator(id);
        q.setGmt_create(System.currentTimeMillis());
        q.setGmt_modified(q.getGmt_create());
        q.setAvatar_url(user.getAvatar_url());

        questionmapper.insert(q);

        return "redirect:/index";
    }
}
