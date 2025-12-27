package com.skillsGap.outputs;

import com.skillsGap.pojos.SkillGapReport;

import java.util.List;

public interface SkillGapReportStrategy {
    void generateReport(List<SkillGapReport> reports);
}
