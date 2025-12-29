package com.skillsGap.observers.notification.producer;

import com.skillsGap.observers.notification.consumer.SkillGapObserver;
import com.skillsGap.pojos.SkillGapReport;

import java.util.ArrayList;
import java.util.List;

public class SkillGapNotificationPublisher {
    private final List<SkillGapObserver> observers = new ArrayList<>();
    public void addObserver(SkillGapObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(SkillGapObserver observer) {
        observers.remove(observer);
    }
    public void notifyUsers(List<SkillGapReport> reports) {

        for (SkillGapReport report : reports) {
            for (SkillGapObserver observer : observers) {
                observer.notify(report);
            }
        }
    }
}
