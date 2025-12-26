package com.skillsGap.inputs;

import com.skillsGap.pojos.Skill;
import com.skillsGap.pojos.UserProfile;
import com.skillsGap.pojos.UserProfileSkill;

import java.util.List;

public interface InputStrategy {
    List<UserProfile> readUsers(String filePath);
    List<Skill> readSkills(String filePath);
    List<UserProfileSkill> readUserProfileSkills(String filePath);
}
