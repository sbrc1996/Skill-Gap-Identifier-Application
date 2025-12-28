package com.skillsGap.service;

import com.skillsGap.factory.InputStrategyFactory;
import com.skillsGap.factory.OutputReportStrategyFactory;
import com.skillsGap.inputs.InputStrategy;
import com.skillsGap.inputs.InputType;
import com.skillsGap.observers.ConsoleUserNotifier;
import com.skillsGap.observers.recommendationObserver.OllamaRecomendation;
import com.skillsGap.observers.subject.OnlineCourseRecommendationPublisher;
import com.skillsGap.observers.subject.SkillGapNotificationPublisher;
import com.skillsGap.outputs.OutputType;
import com.skillsGap.outputs.SkillGapReportStrategy;
import com.skillsGap.pojos.*;

import java.util.List;

public class SkillGapManager {
    private static final SkillGapManager INSTANCE = new SkillGapManager();

    private SkillGapManager() {}

    public static SkillGapManager getInstance(){
        return INSTANCE;
    }

    public void runSkillGapAnalysis(InputType inputType, OutputType outputType, String userFile, String skillFile, String expectedSkillFile, String userSkillFile, String outputPath){
        // ------------------- Input Phase -------------------
        System.out.println("------------------- Input Phase -------------------");
        InputStrategy inputStrategy = InputStrategyFactory.getStrategy(inputType);
        List<UserProfile> userProfiles = inputStrategy.readUsers(userFile);
        List<Skill> skills = inputStrategy.readSkills(skillFile);
        List<ExpectedSkill> expectedSkills = inputStrategy.readExpectedSkills(expectedSkillFile);
        List<UserProfileSkill> userProfileSkills = inputStrategy.readUserProfileSkills(userSkillFile);

        System.out.println(userProfiles);
        System.out.println(skills);
        System.out.println(expectedSkills);
        System.out.println(userProfileSkills);

        // ------------------- Processing Phase -------------------
        SkillGapAnalyzer analyzer = new SkillGapAnalyzer();
        List<SkillGapReport> reports = analyzer.analyze(userProfiles, userProfileSkills, expectedSkills, skills);

        // ------------------- Output Phase -------------------
        System.out.println("------------------- Output Phase -------------------");
        SkillGapReportStrategy outputStrategy = OutputReportStrategyFactory.getStrategy(outputType,outputPath);
        outputStrategy.generateReport(reports);

        // -------- Notification Phase --------
        System.out.println("-------- Notification Phase --------");
        SkillGapNotificationPublisher publisher = new SkillGapNotificationPublisher();
        publisher.addObserver(new ConsoleUserNotifier());
        publisher.notifyUsers(reports);

        // -------- Online Course Recommendation Phase --------
        System.out.println("-------- Online Course Recommendation Phase --------");
        OnlineCourseRecommendationPublisher recommendor = new OnlineCourseRecommendationPublisher();
        recommendor.addObserver(new OllamaRecomendation());
        recommendor.notifyUsers(reports);
    }
}
