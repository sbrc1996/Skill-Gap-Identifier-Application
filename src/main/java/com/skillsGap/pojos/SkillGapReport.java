package com.skillsGap.pojos;

import java.util.List;

public class SkillGapReport {
    private String userId;
    private List<Skill> metSkills;
    private List<Skill> missingSkills;
    private List<Skill> weakSkills;

    public SkillGapReport(String userId, List<Skill> metSkills, List<Skill> missingSkills, List<Skill> weakSkills) {
        this.userId = userId;
        this.metSkills = metSkills;
        this.missingSkills = missingSkills;
        this.weakSkills = weakSkills;
    }

    public String getUserId() {
        return userId;
    }

    public List<Skill> getMetSkills() {
        return metSkills;
    }

    public List<Skill> getMissingSkills() {
        return missingSkills;
    }

    public List<Skill> getWeakSkills() {
        return weakSkills;
    }
}
