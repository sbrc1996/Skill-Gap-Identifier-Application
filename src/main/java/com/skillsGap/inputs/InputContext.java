package com.skillsGap.inputs;

import com.skillsGap.pojos.ExpectedSkill;
import com.skillsGap.pojos.Skill;
import com.skillsGap.pojos.UserProfile;
import com.skillsGap.pojos.UserProfileSkill;

import java.util.List;

public class InputContext {
    private InputStrategy inputStrategy;

    public InputContext(InputStrategy inputStrategy) {
        this.inputStrategy = inputStrategy;
    }
    public void setInputStrategy(InputStrategy inputStrategy){
        this.inputStrategy = inputStrategy;
    }
    public List<UserProfile> readUsers(String filePath){
        return inputStrategy.readUsers(filePath);
    }
    public List<Skill> readSkills(String filePath){
        return inputStrategy.readSkills(filePath);
    }
    public List<UserProfileSkill> readUserProfileSkills(String filePath){
        return inputStrategy.readUserProfileSkills(filePath);
    }
    public List<ExpectedSkill> readExpectedSkills(String filePath){
        return inputStrategy.readExpectedSkills(filePath);
    }
}
