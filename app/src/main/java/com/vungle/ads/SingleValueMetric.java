package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SingleValueMetric extends Metric {
    private Long value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleValueMetric(Sdk.SDKMetric.SDKMetricType metricType) {
        super(metricType);
        k.e(metricType, "metricType");
    }

    public final void addValue(long j) {
        Long l = this.value;
        this.value = Long.valueOf((l != null ? l.longValue() : 0L) + j);
    }

    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public final Long m3275getValue() {
        return this.value;
    }

    public final void markTime() {
        this.value = Long.valueOf(System.currentTimeMillis());
    }

    public final void setValue(Long l) {
        this.value = l;
    }

    @Override // com.vungle.ads.Metric
    public long getValue() {
        Long l = this.value;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }
}
