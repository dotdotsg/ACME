package com.core.acme.domain;

import com.core.acme.domain.enums.ExamStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
    @NonNull String examId;        //User given Id , again Unique for each student -> unique instance of exam created for each student
    @NonNull String studentId;
    @NonNull String testId;
    private int score;
    private List<String> attemptedQuestionIds;
    private int currentQuestionIndex;
    private int currentSubQuestionIndex;
    int questionNumber ;
    ExamStatus examStatus;
    //    Instant startTime;
    //    Instant endTime;
}
