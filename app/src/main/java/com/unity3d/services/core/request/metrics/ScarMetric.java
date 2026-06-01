package com.unity3d.services.core.request.metrics;

import a1.a;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ScarMetric {
    private static final String ASYNC_PREFIX = "async";
    private static final String HB_SIGNALS_FETCH_FAILURE = "native_hb_signals_%s_fetch_failure";
    private static final String HB_SIGNALS_FETCH_START = "native_hb_signals_%s_fetch_start";
    private static final String HB_SIGNALS_FETCH_SUCCESS = "native_hb_signals_%s_fetch_success";
    private static final String HB_SIGNALS_UPLOAD_FAILURE = "native_hb_signals_%s_upload_failure";
    private static final String HB_SIGNALS_UPLOAD_START = "native_hb_signals_%s_upload_start";
    private static final String HB_SIGNALS_UPLOAD_SUCCESS = "native_hb_signals_%s_upload_success";
    private static final String REASON = "reason";
    private static final String SYNC_PREFIX = "sync";
    private static long _fetchStartTime;
    private static long _uploadStartTime;

    private static long getTotalFetchTime() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - _fetchStartTime);
    }

    private static long getTotalUploadTime() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - _uploadStartTime);
    }

    public static Metric hbSignalsFetchFailure(boolean z2, String str) {
        return new Metric(a.m("native_hb_signals_", z2 ? ASYNC_PREFIX : "sync", "_fetch_failure"), Long.valueOf(getTotalFetchTime()), androidx.camera.core.processing.util.a.u("reason", str));
    }

    public static Metric hbSignalsFetchStart(boolean z2) {
        _fetchStartTime = System.nanoTime();
        return new Metric(a.m("native_hb_signals_", z2 ? ASYNC_PREFIX : "sync", "_fetch_start"), null);
    }

    public static Metric hbSignalsFetchSuccess(boolean z2) {
        return new Metric(a.m("native_hb_signals_", z2 ? ASYNC_PREFIX : "sync", "_fetch_success"), Long.valueOf(getTotalFetchTime()));
    }

    public static Metric hbSignalsUploadFailure(boolean z2, String str) {
        return new Metric(a.m("native_hb_signals_", z2 ? ASYNC_PREFIX : "sync", "_upload_failure"), Long.valueOf(getTotalUploadTime()), androidx.camera.core.processing.util.a.u("reason", str));
    }

    public static Metric hbSignalsUploadStart(boolean z2) {
        _uploadStartTime = System.nanoTime();
        return new Metric(a.m("native_hb_signals_", z2 ? ASYNC_PREFIX : "sync", "_upload_start"), null);
    }

    public static Metric hbSignalsUploadSuccess(boolean z2) {
        return new Metric(a.m("native_hb_signals_", z2 ? ASYNC_PREFIX : "sync", "_upload_success"), Long.valueOf(getTotalUploadTime()));
    }
}
