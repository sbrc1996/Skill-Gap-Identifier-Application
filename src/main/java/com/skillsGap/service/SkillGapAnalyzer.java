package com.skillsGap.service;

import com.skillsGap.pojos.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkillGapAnalyzer {
    public List<SkillGapReport> analyze(List<UserProfile> users,
                                        List<UserProfileSkill> userProfileSkills,
                                        List<ExpectedSkill> expectedSkills,
                                        List<Skill> skills){

        //Build helper lookups
        // skillId → skillName
        Map<String, String> skillIdToNameMap = buildSkillIdToNameMap(skills);

        //userId  → ( skillName → proficiency )
        Map<String, Map<String, Proficiency>> userSkillMap = buildUserSkillMap(userProfileSkills, skillIdToNameMap);

        List<SkillGapReport> reports = new ArrayList<>();

        //Analyze Skill Gap per user
        for(UserProfile user : users){
            Map<String, Proficiency> userSkills = userSkillMap.get(user.getId());

            List<Skill> metSkills = new ArrayList<>();
            List<Skill> missingSkills = new ArrayList<>();
            List<Skill> weakSkills = new ArrayList<>();

            for(ExpectedSkill expected : expectedSkills){
                String expectedSkillName = normalize(expected.getSkillName());
                if(userSkills == null || !userSkills.containsKey(expectedSkillName)){
                    missingSkills.add(toSkill(expected));
                    continue;
                }
                Proficiency actual = userSkills.get(expectedSkillName);
                if(actual.ordinal() >= expected.getLevel().ordinal()){
                    metSkills.add(toSkill(expected));
                }else{
                    weakSkills.add(toSkill(expected));
                }
            }
            SkillGapReport report = new SkillGapReport(user.getId(),metSkills,missingSkills,weakSkills);
            reports.add(report);
        }

        return reports;
    }

    private Skill toSkill(ExpectedSkill expected) {
        return new Skill(expected.getSkillId(), expected.getSkillName(), expected.getCategory());
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim().toLowerCase();
    }

    private Map<String, String> buildSkillIdToNameMap(List<Skill> skills) {
        Map<String, String> map = new HashMap<>();
        for (Skill skill : skills) {
            map.put(skill.getSkillId(),normalize(skill.getSkillName()));
        }
        return map;
    }

    private Map<String, Map<String, Proficiency>> buildUserSkillMap(List<UserProfileSkill> userProfileSkills,Map<String, String> skillIdToNameMap) {
        Map<String, Map<String, Proficiency>> result = new HashMap<>();

        for(UserProfileSkill ups : userProfileSkills){
            String skillName = skillIdToNameMap.get(ups.getSkillId());
            if(skillName == null)   continue;
            Map<String, Proficiency> userSkills = result.get(ups.getUserId());
            if(userSkills == null){
                userSkills = new HashMap<>();
                result.put(ups.getUserId(),userSkills);
            }
            userSkills.put(skillName,ups.getProficiency());
        }
        return result;
    }
}
