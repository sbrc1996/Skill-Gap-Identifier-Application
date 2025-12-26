package com.skillsGap.pojos;

public class UserProfileSkill {
    private String userId;
    private String skillId;
    private Proficiency proficiency;

    public UserProfileSkill(String userId, String skillId, Proficiency proficiency) {
        this.userId = userId;
        this.skillId = skillId;
        this.proficiency = proficiency;
    }

    public String getUserId() {
        return userId;
    }

    public String getSkillId() {
        return skillId;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    @Override
    public String toString() {
        return "UserProfileSkill{" +
                "userId='" + userId + '\'' +
                ", skillId='" + skillId + '\'' +
                ", proficiency=" + proficiency +
                '}';
    }
}
