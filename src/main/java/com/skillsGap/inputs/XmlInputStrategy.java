package com.skillsGap.inputs;

import com.skillsGap.pojos.ExpectedSkill;
import com.skillsGap.pojos.Skill;
import com.skillsGap.pojos.UserProfile;
import com.skillsGap.pojos.UserProfileSkill;

import java.util.List;

public class XmlInputStrategy implements InputStrategy{
    @Override
    public List<UserProfile> readUsers(String filePath) {
        return List.of();
    }

    @Override
    public List<Skill> readSkills(String filePath) {
        return List.of();
    }

    @Override
    public List<UserProfileSkill> readUserProfileSkills(String filePath) {
        return List.of();
    }

    @Override
    public List<ExpectedSkill> readExpectedSkills(String filepath) {
        return List.of();
    }
}
