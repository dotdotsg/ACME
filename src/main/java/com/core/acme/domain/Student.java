package com.core.acme.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Students")
@Entity
public class Student {  // This class is not useful if admin system have separate
    @Id
    String Id;
    String studentId;
    String studentName;
    String rollNo;
    String email;
    //String administeredTestId;    // Map needed to store the score also
    String administeredTestId;

}
