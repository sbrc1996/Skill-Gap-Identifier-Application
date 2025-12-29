package com.skillsGap.observers.recommendation.consumer;

import com.skillsGap.pojos.SkillGapReport;

public interface RecommendationObserver {
    void notify(SkillGapReport report);
}
