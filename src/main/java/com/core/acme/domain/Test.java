package com.core.acme.domain;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Tests")
@Entity
public class Test {
    @Id
    String id;     // database generated id
    String testId; // id for user recognition
    String testName;
    TestDifficulty testDifficulty;
    List<List<String>> questionsInTest; // some frontend logic to create ADD button to copy Question Id from the central Questions repository to the testQuestions
    int questionsToBeAttempted;

}

enum TestDifficulty{
    EASY, MEDIUM, HARD
}
