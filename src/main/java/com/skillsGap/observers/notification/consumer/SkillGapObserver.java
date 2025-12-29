package com.skillsGap.observers.notification.consumer;

import com.skillsGap.pojos.SkillGapReport;

public interface SkillGapObserver {
    void notify(SkillGapReport report);
}
