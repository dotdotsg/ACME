package com.core.acme.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Exams")
@Entity
public class Exam {

    @Id
    private String id;      // DataBase Id

    @Indexed(unique = true)
    String examId;        //User given Id , again Unique for each student -> unique instance of exam created for each student
    String studentId;
    String testId;
    int score;
    List<String> attemptedQuestionIds;
    String studentAns;// check if studentAns == correctAns in exam service layer
    String correctAns;// to copy the correct ans from the Question object cuz Only QuestionDTO will be sent wich does not contain the correctAns of Question.
    int currentQuestionIndex;
    int currentSubQuestionIndex;



    //    Instant startTime;
    //    Instant endTime;


}
