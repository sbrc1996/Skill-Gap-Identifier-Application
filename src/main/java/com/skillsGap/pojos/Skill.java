package com.skillsGap.pojos;

public class Skill {
    private String skillId;
    private String skillName;
    private String category;

    public Skill(String skillId, String skillName, String category) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.category = category;
    }

    public String getSkillId() {
        return skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId='" + skillId + '\'' +
                ", skillName='" + skillName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
