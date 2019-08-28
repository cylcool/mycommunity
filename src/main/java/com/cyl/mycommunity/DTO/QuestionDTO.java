package com.cyl.mycommunity.DTO;

import com.cyl.mycommunity.modul.Question;
import com.cyl.mycommunity.modul.User;
import lombok.Data;

@Data
public class QuestionDTO extends Question {
    private User user;
}
