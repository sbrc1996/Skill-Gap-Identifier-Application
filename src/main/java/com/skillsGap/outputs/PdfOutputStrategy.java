package com.skillsGap.outputs;

import com.skillsGap.pojos.SkillGapReport;

import java.util.List;

public class PdfOutputStrategy implements SkillGapReportStrategy{
    private final String filePath;

    public PdfOutputStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void generateReport(List<SkillGapReport> reports) {
        System.out.println("PDF file generated in: "+filePath);
    }
}
