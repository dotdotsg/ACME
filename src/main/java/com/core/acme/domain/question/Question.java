package com.core.acme.domain.question;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Questions")
public class Question {
    @Id
    private String id;
    @Indexed(unique = true)
    private String questionId;
    String question;
    int difficultyLevel;
    List<String> tags;
    List<String> options;
    String correctOpt;
}
