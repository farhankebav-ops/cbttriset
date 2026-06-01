package com.unity3d.services.core.request.metrics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class InitMetric {
    private static final String INIT_METRIC_ENVIRONMENT_NOT_OK = "native_init_environment_not_ok";
    private static final String INIT_METRIC_ENVIRONMENT_OK = "native_init_environment_ok";

    public static Metric newInitEnvironmentNotOk() {
        return new Metric(INIT_METRIC_ENVIRONMENT_NOT_OK, null);
    }

    public static Metric newInitEnvironmentOk() {
        return new Metric(INIT_METRIC_ENVIRONMENT_OK, null);
    }
}
