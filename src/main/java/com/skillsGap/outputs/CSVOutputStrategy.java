package com.skillsGap.outputs;

import com.skillsGap.pojos.SkillGapReport;

import java.util.List;

public class CSVOutputStrategy implements SkillGapReportStrategy{
    private final String filePath;

    public CSVOutputStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void generateReport(List<SkillGapReport> reports) {
        System.out.println("CSV file generated in: "+filePath);
    }
}
