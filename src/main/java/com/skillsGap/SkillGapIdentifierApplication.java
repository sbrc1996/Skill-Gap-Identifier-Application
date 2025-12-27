package com.skillsGap;

import com.skillsGap.factory.InputStrategyFactory;
import com.skillsGap.inputs.InputStrategy;
import com.skillsGap.inputs.InputType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkillGapIdentifierApplication {

	public static void main(String[] args) {

		SpringApplication.run(SkillGapIdentifierApplication.class, args);
        InputStrategy obj = InputStrategyFactory.getStrategy(InputType.CSV);
        System.out.println(obj.readUsers("inputFiles/UserProfile.csv"));
        System.out.println(obj.readSkills("inputFiles/Skills.csv"));
        System.out.println(obj.readExpectedSkills("inputFiles/expected_skills.csv"));
        System.out.println(obj.readUserProfileSkills("inputFiles/userProfile_Skills.csv"));
	}
}
