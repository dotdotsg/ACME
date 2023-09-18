package com.core.acme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
//import org.springframework.data.annotation.Id;
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
@Entity
public class Question {
    @JsonProperty("id")
    @Id
    private String id;
    @Indexed(unique = true)
    @JsonProperty("questionId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String questionId;
    String question;
    int difficultyLevel; //maybe a scale of 1 to 5 or 1 to 10.
    List<String> tags;
    List<String> options;
    String correctOpt;
    //String nextQid;        // Question id of next nested question.        // implemented inside Tests
    // add marks field




}
