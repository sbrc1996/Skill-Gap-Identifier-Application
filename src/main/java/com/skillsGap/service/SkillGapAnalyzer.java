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

        return reports;
    }

    private Map<String, String> buildSkillIdToNameMap(List<Skill> skills) {
        Map<String, String> map = new HashMap<>();
        for (Skill skill : skills) {
            map.put(skill.getSkillId(),normalize(skill.getSkillName()));
        }
        return map;
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim().toLowerCase();
    }

    private Map<String, Map<String, Proficiency>> buildUserSkillMap(List<UserProfileSkill> userProfileSkills) {
        Map<String, Map<String, Proficiency>> map = new HashMap<>();

        for(UserProfileSkill ups: userProfileSkills){
            Map<String, Proficiency> skills = map.get(ups.getUserId());
            if(skills == null){
                skills = new HashMap<>();
                map.put(ups.getUserId(),skills);
            }
            skills.put(ups.getSkillId(),ups.getProficiency());
        }
        return map;
    }

    private Map<String, Skill> buildSkillLookup(List<Skill> skills) {
        Map<String, Skill> lookup = new HashMap<>();
        for(Skill skill : skills){
            lookup.put(skill.getSkillId(),skill);
        }
        return lookup;
    }
}
