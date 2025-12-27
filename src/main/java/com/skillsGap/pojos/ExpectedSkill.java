package com.skillsGap.pojos;

public class ExpectedSkill {
    private String skillId;
    private String skillName;
    private String category;
    private Proficiency level;

    public ExpectedSkill(String skillId, String skillName, String category, Proficiency level) {
        this.skillId = skillId;
        this.skillName = skillName;
        this.category = category;
        this.level = level;
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

    public Proficiency getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "ExpectedSkill{" +
                "skillId='" + skillId + '\'' +
                ", skillName='" + skillName + '\'' +
                ", category='" + category + '\'' +
                ", level=" + level +
                '}';
    }
}
