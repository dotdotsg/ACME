package com.core.acme;

import com.core.acme.domain.question.Question;
import com.core.acme.service.QuestionService;
import com.core.acme.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.mongodb.assertions.Assertions.assertNotNull;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
		StudentTests.class,
})
@AutoConfiguration
class AcmeApplicationTests {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private TestService testService;

	@Test
	void contextLoads() {
	}

	@Test
	void findAllQuestions(){
		List<Question> allQuestions =  questionService.getAllQuestions();
		// System.out.println("AllQuestions :"+allQuestions.size());
		// for(int i =0; i<allQuestions.size();i++){
		// 	System.out.println(allQuestions.get(i).toString());
		// }
		assertNotNull(allQuestions);
	}
	@Test
	void whenFindByTags_returnQuestionsWithMatchingTags()
	{
		List<String> tags = List.of(new String[]{
				"gk"
		});
		List<Question> matchingQuestions =  questionService.searchQuestionsByTags(tags);
		 System.out.println("questions with given tags :"+matchingQuestions.size());
        for (Question matchingQuestion : matchingQuestions) {
            System.out.println(matchingQuestion.toString());

        }
		assertNotNull(matchingQuestions);
	}

	// Tests for the Test Entity
	@Test
	void getAllTestfromTestServices()
	{
		List<com.core.acme.domain.test.Test> allTests =  testService.getAllTests();
		// System.out.println("List of all Tests :"+allTests.size());
		// for(int i =0; i<allTests.size();i++){
		// 	System.out.println(allTests.get(i).toString());

		// }
		assertNotNull(allTests);
	}
	

}
