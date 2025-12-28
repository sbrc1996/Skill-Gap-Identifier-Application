package com.skillsGap.observers.recommendationObserver;

import com.skillsGap.pojos.SkillGapReport;

public interface RecommendationObserver {
    void notify(SkillGapReport report);
}
