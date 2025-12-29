package com.skillsGap.observers.notification.consumer;

import com.skillsGap.pojos.Skill;
import com.skillsGap.pojos.SkillGapReport;

public class ConsoleUserNotifier implements SkillGapObserver {
    @Override
    public void notify(SkillGapReport report) {
        System.out.println("\n Notification for User: " + report.getUserId());
        if (report.getMissingSkills().isEmpty() && report.getWeakSkills().isEmpty()) {
            System.out.println(" You meet all required skills!");
            return;
        }
        if (!report.getMissingSkills().isEmpty()) {
            System.out.println("Missing Skills:");
            for (Skill skill : report.getMissingSkills()) {
                System.out.println("  - " + skill.getSkillName());
            }
        }
        if (!report.getWeakSkills().isEmpty()) {
            System.out.println("Weak Skills (Need Improvement):");
            for (Skill skill : report.getWeakSkills()) {
                System.out.println("  - " + skill.getSkillName());
            }
        }
    }
}
