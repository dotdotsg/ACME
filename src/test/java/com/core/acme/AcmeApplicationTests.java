package com.core.acme;

import com.core.acme.domain.Question;
import com.core.acme.service.AcmeService;
import com.core.acme.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.springframework.boot.SpringApplication.run;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
		StudentTests.class,
		AcmeApplicationTests.class
})
class AcmeApplicationTests {

	@Autowired
	private AcmeService acmeService;
	@Autowired
	private TestService testService;
	@Test
	void contextLoads() {
	}

	@Test
	void findAllQuestions(){
		List<Question> allQuestions =  acmeService.getAllQuestions();
		System.out.println("AllQuestions :"+allQuestions.size());
		for(int i =0; i<allQuestions.size();i++){
			System.out.println(allQuestions.get(i).toString());
		}
		assertNotNull(allQuestions);
	}
	@Test
	void whenFindByTags_returnQuestionsWithMatchingTags()
	{
		List<String> tags = List.of(new String[]{
				"math",
				"pm"
		});
		List<Question> matchingQuestions =  acmeService.searchQuestionsByTag(tags);
		System.out.println("questions with given tags :"+matchingQuestions.size());
		for(int i =0; i<matchingQuestions.size();i++){
			System.out.println(matchingQuestions.get(i).toString());

		}
		assertNotNull(matchingQuestions);
	}

	// Tests for the Test Entity
	@Test
	void getAllTestsfromTestServices()
	{
		List<com.core.acme.domain.Test> allTests =  testService.getAllTests();
		System.out.println("List of all Tests :"+allTests.size());
		for(int i =0; i<allTests.size();i++){
			System.out.println(allTests.get(i).toString());

		}
		assertNotNull(allTests);
	}

}
