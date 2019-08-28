package com.cyl.mycommunity.service;

import com.cyl.mycommunity.DTO.QuestionDTO;
import com.cyl.mycommunity.mapper.Questionmapper;
import com.cyl.mycommunity.mapper.usermapper;
import com.cyl.mycommunity.modul.Question;
import com.cyl.mycommunity.modul.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.cyl.mycommunity.mapper.usermapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionImp {
    @Autowired
    usermapper usermapper;

    @Autowired
    Questionmapper questionmapper;

    public List<QuestionDTO> getQuestionDTO(){
        List<Question> questions = questionmapper.select();
        List<QuestionDTO> questionsDTO = new ArrayList<>();
        User s = null;
        for (Question q:questions) {
            s = usermapper.selectByCreator(q.getCreator());
            QuestionDTO dto = new QuestionDTO();
            BeanUtils.copyProperties(q,dto);
            dto.setUser(s);
            questionsDTO.add(dto);
        }
        return questionsDTO;
    }
}
