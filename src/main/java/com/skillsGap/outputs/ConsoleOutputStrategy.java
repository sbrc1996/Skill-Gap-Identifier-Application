package com.skillsGap.outputs;

import com.skillsGap.pojos.Skill;
import com.skillsGap.pojos.SkillGapReport;

import java.util.List;

public class ConsoleOutputStrategy implements SkillGapReportStrategy{

    @Override
    public void generateReport(List<SkillGapReport> reports) {
        System.out.println("==========================================");
        System.out.println("          SKILL GAP ANALYSIS REPORT        ");
        System.out.println("==========================================");

        if (reports == null || reports.isEmpty()) {
            System.out.println("No reports available.");
            return;
        }

        for (SkillGapReport report : reports){
            System.out.println("\n------------------------------------------");
            System.out.println("User ID : " + report.getUserId());
            System.out.println("------------------------------------------");

            printSkillSection("Met Skills", report.getMetSkills());
            printSkillSection("Weak Skills", report.getWeakSkills());
            printSkillSection("Missing Skills", report.getMissingSkills());

            System.out.println("\n==========================================");
            System.out.println("        END OF SKILL GAP REPORT            ");
            System.out.println("==========================================");
        }
    }

    private void printSkillSection(String title, List<Skill> skills) {
        System.out.println("\n" + title + ":");
        if (skills == null || skills.isEmpty()) {
            System.out.println("  - None");
            return;
        }
        for (Skill skill : skills) {
            System.out.println("  - " + skill.getSkillName() + " (" + skill.getCategory() + ")");
        }
    }
}
