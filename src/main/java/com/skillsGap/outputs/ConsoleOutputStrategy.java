package com.skillsGap.outputs;

import com.skillsGap.pojos.SkillGapReport;

import java.util.List;

public class ConsoleOutputStrategy implements SkillGapReportStrategy{

    @Override
    public void generateReport(List<SkillGapReport> reports) {
        System.out.println("Output generated in the console.");
    }
}
