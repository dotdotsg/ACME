package com.core.acme.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

public class QuestionDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Question {
        @Id
        private String id;

        @Indexed(unique = true)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private String questionId;
        String question;
        int difficultyLevel; //maybe a scale of 1 to 5 or 1 to 10.
        List<String> tags;
        List<String> options;
        //String correctOpt;




    }
}
