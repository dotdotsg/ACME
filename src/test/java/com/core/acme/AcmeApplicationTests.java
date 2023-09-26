package com.core.acme;

import com.core.acme.domain.Question;
import com.core.acme.service.AcmeService;
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
	private AcmeService acmeService;
	@Autowired
	private TestService testService;

	@Test
	void contextLoads() {
	}

	@Test
	void findAllQuestions(){
		List<Question> allQuestions =  acmeService.getAllQuestions();
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
		List<Question> matchingQuestions =  acmeService.searchQuestionsByTag(tags);
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
		List<com.core.acme.domain.Test> allTests =  testService.getAllTests();
		// System.out.println("List of all Tests :"+allTests.size());
		// for(int i =0; i<allTests.size();i++){
		// 	System.out.println(allTests.get(i).toString());

		// }
		assertNotNull(allTests);
	}
	

}
