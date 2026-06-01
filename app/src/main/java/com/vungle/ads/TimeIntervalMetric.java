package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class TimeIntervalMetric extends DualValueMetric {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType metricType) {
        super(metricType);
        k.e(metricType, "metricType");
    }

    private final long calculateIntervalDuration() {
        long currentTime = getCurrentTime();
        Long valueSecond = getValueSecond();
        long jLongValue = valueSecond != null ? valueSecond.longValue() : currentTime;
        Long valueFirst = getValueFirst();
        if (valueFirst != null) {
            currentTime = valueFirst.longValue();
        }
        return (jLongValue - currentTime) / ((long) 1000000);
    }

    private final long getCurrentTime() {
        return System.nanoTime();
    }

    @Override // com.vungle.ads.Metric
    public long getValue() {
        return calculateIntervalDuration();
    }

    public void markEnd() {
        setValueSecond(Long.valueOf(getCurrentTime()));
    }

    public void markStart() {
        setValueFirst(Long.valueOf(getCurrentTime()));
    }
}
