package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Metric {
    private String meta;
    private Sdk.SDKMetric.SDKMetricType metricType;

    public Metric(Sdk.SDKMetric.SDKMetricType metricType) {
        k.e(metricType, "metricType");
        this.metricType = metricType;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final Sdk.SDKMetric.SDKMetricType getMetricType() {
        return this.metricType;
    }

    public abstract long getValue();

    public final void setMeta(String str) {
        this.meta = str;
    }

    public final void setMetricType(Sdk.SDKMetric.SDKMetricType sDKMetricType) {
        k.e(sDKMetricType, "<set-?>");
        this.metricType = sDKMetricType;
    }
}
