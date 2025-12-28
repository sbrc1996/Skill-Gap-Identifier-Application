package com.skillsGap;

import com.skillsGap.inputs.InputType;
import com.skillsGap.outputs.OutputType;
import com.skillsGap.pojos.*;
import com.skillsGap.service.SkillGapManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkillGapIdentifierApplication {

	public static void main(String[] args) {

		SpringApplication.run(SkillGapIdentifierApplication.class, args);

        // ------------------- Configuration -------------------
        InputType inputType = InputType.CSV;
        OutputType outputType = OutputType.CONSOLE;

        String userFile = "inputFiles/UserProfile.csv";
        String skillFile = "inputFiles/Skills.csv";
        String expectedSkillFile = "inputFiles/expected_skills.csv";
        String userSkillFile = "inputFiles/userProfile_Skills.csv";

        String outputPath = "output/skill_gap_report";

        SkillGapManager manager = SkillGapManager.getInstance();
        manager.runSkillGapAnalysis(inputType,outputType,userFile,skillFile,expectedSkillFile,userSkillFile,outputPath);

        System.out.println("Skill Gap Analysis completed successfully.");
	}
}
