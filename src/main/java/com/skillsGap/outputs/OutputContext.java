package com.skillsGap.outputs;

import com.skillsGap.pojos.SkillGapReport;

import java.util.List;

public class OutputContext {
    private SkillGapReportStrategy strategy;

    public OutputContext(SkillGapReportStrategy strategy){
        this.strategy = strategy;
    }
    public void setStrategy(SkillGapReportStrategy strategy){
        this.strategy = strategy;
    }
    public void generateReport(List<SkillGapReport> reports){
        strategy.generateReport(reports);
    }
}
