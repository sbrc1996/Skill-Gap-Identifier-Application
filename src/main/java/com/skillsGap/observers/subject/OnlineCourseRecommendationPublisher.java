package com.skillsGap.observers.subject;

import com.skillsGap.observers.SkillGapObserver;
import com.skillsGap.observers.recommendationObserver.RecommendationObserver;
import com.skillsGap.pojos.SkillGapReport;

import java.util.ArrayList;
import java.util.List;

public class OnlineCourseRecommendationPublisher {
    private final List<RecommendationObserver> observers = new ArrayList<>();

    public void addObserver(RecommendationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(RecommendationObserver observer) {
        observers.remove(observer);
    }

    public void notifyUsers(List<SkillGapReport> reports) {

        for (SkillGapReport report : reports) {
            for (RecommendationObserver observer : observers) {
                observer.notify(report);
            }
        }
    }
}
