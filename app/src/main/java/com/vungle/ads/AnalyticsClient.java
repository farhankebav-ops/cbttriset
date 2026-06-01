package com.vungle.ads;

import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.camera.core.processing.i;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.network.VungleHeader;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AnalyticsClient {
    private static final int MAX_BATCH_SIZE = 20;
    private static final long REFRESH_TIME_MILLIS = 5000;
    private static final String TAG = "AnalyticsClient";
    private static VungleThreadPoolExecutor executor;
    private static boolean metricsEnabled;
    private static VungleApiClient vungleApiClient;
    public static final AnalyticsClient INSTANCE = new AnalyticsClient();
    private static final BlockingQueue<Sdk.SDKError.Builder> errors = new LinkedBlockingQueue();
    private static final BlockingQueue<Sdk.SDKMetric.Builder> metrics = new LinkedBlockingQueue();
    private static final BlockingQueue<Sdk.SDKError.Builder> pendingErrors = new LinkedBlockingQueue();
    private static final BlockingQueue<Sdk.SDKMetric.Builder> pendingMetrics = new LinkedBlockingQueue();
    private static LogLevel logLevel = LogLevel.ERROR_LOG_LEVEL_ERROR;
    private static boolean refreshEnabled = true;
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum LogLevel {
        ERROR_LOG_LEVEL_OFF(0),
        ERROR_LOG_LEVEL_ERROR(1),
        ERROR_LOG_LEVEL_DEBUG(2);

        public static final Companion Companion = new Companion(null);
        private final int level;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final LogLevel fromValue(int i2) {
                LogLevel logLevel = LogLevel.ERROR_LOG_LEVEL_DEBUG;
                if (i2 == logLevel.getLevel()) {
                    return logLevel;
                }
                LogLevel logLevel2 = LogLevel.ERROR_LOG_LEVEL_ERROR;
                if (i2 != logLevel2.getLevel()) {
                    LogLevel logLevel3 = LogLevel.ERROR_LOG_LEVEL_OFF;
                    if (i2 == logLevel3.getLevel()) {
                        return logLevel3;
                    }
                }
                return logLevel2;
            }

            private Companion() {
            }
        }

        LogLevel(int i2) {
            this.level = i2;
        }

        public final int getLevel() {
            return this.level;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface RequestListener {
        void onFailure();

        void onSuccess();
    }

    private AnalyticsClient() {
    }

    @WorkerThread
    private final void flushErrors() {
        VungleApiClient vungleApiClient2;
        Logger.Companion companion = Logger.Companion;
        StringBuilder sb = new StringBuilder("Sending ");
        BlockingQueue<Sdk.SDKError.Builder> blockingQueue = errors;
        sb.append(blockingQueue.size());
        sb.append(" errors");
        companion.d(TAG, sb.toString());
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (linkedBlockingQueue.isEmpty() || (vungleApiClient2 = vungleApiClient) == null) {
            return;
        }
        vungleApiClient2.reportErrors(linkedBlockingQueue, new RequestListener() { // from class: com.vungle.ads.AnalyticsClient.flushErrors.1
            @Override // com.vungle.ads.AnalyticsClient.RequestListener
            public void onFailure() {
                Logger.Companion.d(AnalyticsClient.TAG, "Failed to send " + linkedBlockingQueue.size() + " errors");
                AnalyticsClient.INSTANCE.getErrors$vungle_ads_release().addAll(linkedBlockingQueue);
            }

            @Override // com.vungle.ads.AnalyticsClient.RequestListener
            public void onSuccess() {
                Logger.Companion.d(AnalyticsClient.TAG, "Sent " + linkedBlockingQueue.size() + " errors");
            }
        });
    }

    @WorkerThread
    private final void flushMetrics() {
        VungleApiClient vungleApiClient2;
        Logger.Companion companion = Logger.Companion;
        StringBuilder sb = new StringBuilder("Sending ");
        BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue = metrics;
        sb.append(blockingQueue.size());
        sb.append(" metrics");
        companion.d(TAG, sb.toString());
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (linkedBlockingQueue.isEmpty() || (vungleApiClient2 = vungleApiClient) == null) {
            return;
        }
        vungleApiClient2.reportMetrics(linkedBlockingQueue, new RequestListener() { // from class: com.vungle.ads.AnalyticsClient.flushMetrics.1
            @Override // com.vungle.ads.AnalyticsClient.RequestListener
            public void onFailure() {
                Logger.Companion.d(AnalyticsClient.TAG, "Failed to send " + linkedBlockingQueue.size() + " metrics");
                AnalyticsClient.INSTANCE.getMetrics$vungle_ads_release().addAll(linkedBlockingQueue);
            }

            @Override // com.vungle.ads.AnalyticsClient.RequestListener
            public void onSuccess() {
                Logger.Companion.d(AnalyticsClient.TAG, "Sent " + linkedBlockingQueue.size() + " metrics");
            }
        });
    }

    private final Sdk.SDKMetric.Builder genMetric(Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, LogEntry logEntry, String str) {
        String placementRefId$vungle_ads_release;
        String creativeId$vungle_ads_release;
        String eventId$vungle_ads_release;
        String headerUa;
        String adSource$vungle_ads_release;
        Boolean adoEnabled$vungle_ads_release;
        Boolean partialDownloadEnabled$vungle_ads_release;
        String vmVersion$vungle_ads_release;
        Sdk.SDKMetric.Builder value = Sdk.SDKMetric.newBuilder().setType(sDKMetricType).setValue(j);
        String str2 = Build.MANUFACTURER;
        Sdk.SDKMetric.Builder osVersion = value.setMake(str2).setModel(Build.MODEL).setOs("Amazon".equals(str2) ? "amazon" : "android").setOsVersion(String.valueOf(Build.VERSION.SDK_INT));
        String str3 = "";
        if (logEntry == null || (placementRefId$vungle_ads_release = logEntry.getPlacementRefId$vungle_ads_release()) == null) {
            placementRefId$vungle_ads_release = "";
        }
        Sdk.SDKMetric.Builder placementReferenceId = osVersion.setPlacementReferenceId(placementRefId$vungle_ads_release);
        if (logEntry == null || (creativeId$vungle_ads_release = logEntry.getCreativeId$vungle_ads_release()) == null) {
            creativeId$vungle_ads_release = "";
        }
        Sdk.SDKMetric.Builder creativeId = placementReferenceId.setCreativeId(creativeId$vungle_ads_release);
        if (logEntry == null || (eventId$vungle_ads_release = logEntry.getEventId$vungle_ads_release()) == null) {
            eventId$vungle_ads_release = "";
        }
        Sdk.SDKMetric.Builder eventId = creativeId.setEventId(eventId$vungle_ads_release);
        if (str == null) {
            str = "";
        }
        Sdk.SDKMetric.Builder meta = eventId.setMeta(str);
        if (logEntry == null || (headerUa = logEntry.getMediationName$vungle_ads_release()) == null) {
            headerUa = VungleHeader.INSTANCE.getHeaderUa();
        }
        Sdk.SDKMetric.Builder mediationName = meta.setMediationName(headerUa);
        if (logEntry == null || (adSource$vungle_ads_release = logEntry.getAdSource$vungle_ads_release()) == null) {
            adSource$vungle_ads_release = "";
        }
        Sdk.SDKMetric.Builder adSource = mediationName.setAdSource(adSource$vungle_ads_release);
        if (logEntry != null && (vmVersion$vungle_ads_release = logEntry.getVmVersion$vungle_ads_release()) != null) {
            str3 = vmVersion$vungle_ads_release;
        }
        Sdk.SDKMetric.Builder appState = adSource.setVmVersion(str3).setAppState(ActivityManager.Companion.isForeground() ? 0L : 2L);
        if (logEntry != null && (partialDownloadEnabled$vungle_ads_release = logEntry.getPartialDownloadEnabled$vungle_ads_release()) != null) {
            appState.setIsPartialDownloadEnabled(partialDownloadEnabled$vungle_ads_release.booleanValue());
        }
        if (logEntry != null && (adoEnabled$vungle_ads_release = logEntry.getAdoEnabled$vungle_ads_release()) != null) {
            appState.setIsAdoEnabled(adoEnabled$vungle_ads_release.booleanValue());
        }
        k.d(appState, "newBuilder()\n           …abled(it) }\n            }");
        return appState;
    }

    public static /* synthetic */ Sdk.SDKMetric.Builder genMetric$default(AnalyticsClient analyticsClient, Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, LogEntry logEntry, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        return analyticsClient.genMetric(sDKMetricType, j, (i2 & 4) != 0 ? null : logEntry, (i2 & 8) != 0 ? null : str);
    }

    private final Sdk.SDKError.Builder genSDKError(Sdk.SDKError.Reason reason, String str, LogEntry logEntry) {
        String placementRefId$vungle_ads_release;
        String creativeId$vungle_ads_release;
        String eventId$vungle_ads_release;
        String adSource$vungle_ads_release;
        String headerUa;
        Boolean adoEnabled$vungle_ads_release;
        Boolean partialDownloadEnabled$vungle_ads_release;
        String vmVersion$vungle_ads_release;
        Sdk.SDKError.Builder builderNewBuilder = Sdk.SDKError.newBuilder();
        String str2 = Build.MANUFACTURER;
        Sdk.SDKError.Builder at = builderNewBuilder.setOs("Amazon".equals(str2) ? "amazon" : "android").setOsVersion(String.valueOf(Build.VERSION.SDK_INT)).setMake(str2).setModel(Build.MODEL).setReason(reason).setMessage(str).setAt(System.currentTimeMillis());
        String str3 = "";
        if (logEntry == null || (placementRefId$vungle_ads_release = logEntry.getPlacementRefId$vungle_ads_release()) == null) {
            placementRefId$vungle_ads_release = "";
        }
        Sdk.SDKError.Builder placementReferenceId = at.setPlacementReferenceId(placementRefId$vungle_ads_release);
        if (logEntry == null || (creativeId$vungle_ads_release = logEntry.getCreativeId$vungle_ads_release()) == null) {
            creativeId$vungle_ads_release = "";
        }
        Sdk.SDKError.Builder creativeId = placementReferenceId.setCreativeId(creativeId$vungle_ads_release);
        if (logEntry == null || (eventId$vungle_ads_release = logEntry.getEventId$vungle_ads_release()) == null) {
            eventId$vungle_ads_release = "";
        }
        Sdk.SDKError.Builder eventId = creativeId.setEventId(eventId$vungle_ads_release);
        if (logEntry == null || (adSource$vungle_ads_release = logEntry.getAdSource$vungle_ads_release()) == null) {
            adSource$vungle_ads_release = "";
        }
        Sdk.SDKError.Builder adSource = eventId.setAdSource(adSource$vungle_ads_release);
        if (logEntry != null && (vmVersion$vungle_ads_release = logEntry.getVmVersion$vungle_ads_release()) != null) {
            str3 = vmVersion$vungle_ads_release;
        }
        Sdk.SDKError.Builder vmVersion = adSource.setVmVersion(str3);
        if (logEntry == null || (headerUa = logEntry.getMediationName$vungle_ads_release()) == null) {
            headerUa = VungleHeader.INSTANCE.getHeaderUa();
        }
        Sdk.SDKError.Builder appState = vmVersion.setMediationName(headerUa).setAppState(ActivityManager.Companion.isForeground() ? 0L : 2L);
        if (logEntry != null && (partialDownloadEnabled$vungle_ads_release = logEntry.getPartialDownloadEnabled$vungle_ads_release()) != null) {
            appState.setIsPartialDownloadEnabled(partialDownloadEnabled$vungle_ads_release.booleanValue());
        }
        if (logEntry != null && (adoEnabled$vungle_ads_release = logEntry.getAdoEnabled$vungle_ads_release()) != null) {
            appState.setIsAdoEnabled(adoEnabled$vungle_ads_release.booleanValue());
        }
        k.d(appState, "newBuilder()\n           …abled(it) }\n            }");
        return appState;
    }

    public static /* synthetic */ Sdk.SDKError.Builder genSDKError$default(AnalyticsClient analyticsClient, Sdk.SDKError.Reason reason, String str, LogEntry logEntry, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            logEntry = null;
        }
        return analyticsClient.genSDKError(reason, str, logEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initOrUpdate$lambda-1, reason: not valid java name */
    public static final void m3241initOrUpdate$lambda1(VungleThreadPoolExecutor executor2) {
        k.e(executor2, "$executor");
        executor2.execute(new i(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: initOrUpdate$lambda-1$lambda-0, reason: not valid java name */
    public static final void m3242initOrUpdate$lambda1$lambda0() {
        INSTANCE.report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: logError$lambda-2, reason: not valid java name */
    public static final void m3243logError$lambda2(Sdk.SDKError.Reason reason, String message, LogEntry logEntry) {
        k.e(reason, "$reason");
        k.e(message, "$message");
        INSTANCE.logErrorInSameThread(reason, message, logEntry);
    }

    public static /* synthetic */ void logError$vungle_ads_release$default(AnalyticsClient analyticsClient, Sdk.SDKError.Reason reason, String str, LogEntry logEntry, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            logEntry = null;
        }
        analyticsClient.logError$vungle_ads_release(reason, str, logEntry);
    }

    private final synchronized void logErrorInSameThread(Sdk.SDKError.Reason reason, String str, LogEntry logEntry) {
        if (logLevel == LogLevel.ERROR_LOG_LEVEL_OFF) {
            return;
        }
        try {
            Sdk.SDKError.Builder builderGenSDKError = genSDKError(reason, str, logEntry);
            BlockingQueue<Sdk.SDKError.Builder> blockingQueue = errors;
            blockingQueue.put(builderGenSDKError);
            Logger.Companion.w(TAG, "Logging error: " + reason + " with message: " + str + ", mediation: " + builderGenSDKError.getMediationName());
            if (blockingQueue.size() >= 20) {
                report();
            }
        } catch (Exception e) {
            Logger.Companion.e(TAG, "Cannot logError", e);
        }
    }

    public static /* synthetic */ void logErrorInSameThread$default(AnalyticsClient analyticsClient, Sdk.SDKError.Reason reason, String str, LogEntry logEntry, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            logEntry = null;
        }
        analyticsClient.logErrorInSameThread(reason, str, logEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: logMetric$lambda-6, reason: not valid java name */
    public static final void m3244logMetric$lambda6(Sdk.SDKMetric.SDKMetricType metricType, long j, LogEntry logEntry, String str) throws Throwable {
        k.e(metricType, "$metricType");
        INSTANCE.logMetricInSameThread(metricType, j, logEntry, str);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, LogEntry logEntry, String str, int i2, Object obj) throws Throwable {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        analyticsClient.logMetric$vungle_ads_release(sDKMetricType, j, (i2 & 4) != 0 ? null : logEntry, (i2 & 8) != 0 ? null : str);
    }

    private final synchronized void logMetricInSameThread(Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, LogEntry logEntry, String str) throws Throwable {
        Sdk.SDKMetric.Builder builderGenMetric;
        try {
            try {
                if (metricsEnabled) {
                    try {
                        builderGenMetric = genMetric(sDKMetricType, j, logEntry, str);
                    } catch (Exception e) {
                        e = e;
                    }
                    try {
                        BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue = metrics;
                        blockingQueue.put(builderGenMetric);
                        Logger.Companion companion = Logger.Companion;
                        StringBuilder sb = new StringBuilder("Logging Metric ");
                        sb.append(sDKMetricType);
                        sb.append(" with value ");
                        sb.append(j);
                        sb.append(" for placement ");
                        sb.append(logEntry != null ? logEntry.getPlacementRefId$vungle_ads_release() : null);
                        sb.append(" mediation:");
                        sb.append(builderGenMetric.getMediationName());
                        companion.w(TAG, sb.toString());
                        if (blockingQueue.size() >= 20) {
                            report();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        Logger.Companion.e(TAG, "Cannot logMetrics", e);
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public static /* synthetic */ void logMetricInSameThread$default(AnalyticsClient analyticsClient, Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, LogEntry logEntry, String str, int i2, Object obj) throws Throwable {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        analyticsClient.logMetricInSameThread(sDKMetricType, j, (i2 & 4) != 0 ? null : logEntry, (i2 & 8) != 0 ? null : str);
    }

    private final synchronized void report() {
        try {
            if (logLevel != LogLevel.ERROR_LOG_LEVEL_OFF && errors.size() > 0) {
                flushErrors();
            }
            if (metricsEnabled && metrics.size() > 0) {
                flushMetrics();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final BlockingQueue<Sdk.SDKError.Builder> getErrors$vungle_ads_release() {
        return errors;
    }

    public final VungleThreadPoolExecutor getExecutor$vungle_ads_release() {
        return executor;
    }

    public final BlockingQueue<Sdk.SDKMetric.Builder> getMetrics$vungle_ads_release() {
        return metrics;
    }

    public final boolean getMetricsEnabled$vungle_ads_release() {
        return metricsEnabled;
    }

    public final BlockingQueue<Sdk.SDKError.Builder> getPendingErrors$vungle_ads_release() {
        return pendingErrors;
    }

    public final BlockingQueue<Sdk.SDKMetric.Builder> getPendingMetrics$vungle_ads_release() {
        return pendingMetrics;
    }

    public final boolean getRefreshEnabled$vungle_ads_release() {
        return refreshEnabled;
    }

    public final VungleApiClient getVungleApiClient$vungle_ads_release() {
        return vungleApiClient;
    }

    public final synchronized void initOrUpdate$vungle_ads_release(VungleApiClient vungleApiClient2, VungleThreadPoolExecutor executor2, int i2, boolean z2) {
        try {
            k.e(vungleApiClient2, "vungleApiClient");
            k.e(executor2, "executor");
            logLevel = LogLevel.Companion.fromValue(i2);
            metricsEnabled = z2;
            if (i2 == LogLevel.ERROR_LOG_LEVEL_DEBUG.getLevel()) {
                Logger.Companion.enable(true);
            } else if (i2 == LogLevel.ERROR_LOG_LEVEL_ERROR.getLevel() || i2 == LogLevel.ERROR_LOG_LEVEL_OFF.getLevel()) {
                Logger.Companion.enable(false);
            }
            if (isInitialized.getAndSet(true)) {
                Logger.Companion.d(TAG, "AnalyticsClient already initialized");
                return;
            }
            executor = executor2;
            vungleApiClient = vungleApiClient2;
            try {
                BlockingQueue<Sdk.SDKError.Builder> blockingQueue = pendingErrors;
                if (!blockingQueue.isEmpty()) {
                    blockingQueue.drainTo(errors);
                }
            } catch (Exception e) {
                Logger.Companion.e(TAG, "Failed to add pendingErrors to errors queue.", e);
            }
            try {
                BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue2 = pendingMetrics;
                if (!blockingQueue2.isEmpty()) {
                    blockingQueue2.drainTo(metrics);
                }
            } catch (Exception e4) {
                Logger.Companion.e(TAG, "Failed to add pendingMetrics to metrics queue.", e4);
            }
            if (refreshEnabled) {
                Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new c(executor2, 0), 5000L, 5000L, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final AtomicBoolean isInitialized$vungle_ads_release() {
        return isInitialized;
    }

    public final synchronized void logError$vungle_ads_release(Sdk.SDKError.Reason reason, String message, LogEntry logEntry) {
        VungleThreadPoolExecutor vungleThreadPoolExecutor;
        k.e(reason, "reason");
        k.e(message, "message");
        try {
            vungleThreadPoolExecutor = executor;
        } catch (Exception e) {
            Logger.Companion.e(TAG, "Cannot logError " + reason + ", " + message + ", " + logEntry, e);
        }
        if (vungleThreadPoolExecutor != null) {
            vungleThreadPoolExecutor.execute(new b(reason, message, logEntry, 0));
        } else {
            pendingErrors.put(genSDKError(reason, message, logEntry));
        }
    }

    public final synchronized void logMetric$vungle_ads_release(Sdk.SDKMetric.SDKMetricType metricType, final long j, final LogEntry logEntry, final String str) throws Throwable {
        final Sdk.SDKMetric.SDKMetricType sDKMetricType;
        VungleThreadPoolExecutor vungleThreadPoolExecutor;
        try {
            try {
                k.e(metricType, "metricType");
                try {
                    vungleThreadPoolExecutor = executor;
                    try {
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e4) {
                    e = e4;
                    sDKMetricType = metricType;
                }
                if (vungleThreadPoolExecutor == null) {
                    pendingMetrics.put(genMetric(metricType, j, logEntry, str));
                    return;
                }
                sDKMetricType = metricType;
                try {
                    vungleThreadPoolExecutor.execute(new Runnable() { // from class: com.vungle.ads.a
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            AnalyticsClient.m3244logMetric$lambda6(sDKMetricType, j, logEntry, str);
                        }
                    });
                } catch (Exception e8) {
                    e = e8;
                    j = j;
                    logEntry = logEntry;
                    str = str;
                    Logger.Companion.e(TAG, "Cannot logMetric " + sDKMetricType + ", " + j + ", " + logEntry + ", " + str, e);
                }
                Logger.Companion.e(TAG, "Cannot logMetric " + sDKMetricType + ", " + j + ", " + logEntry + ", " + str, e);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final void setExecutor$vungle_ads_release(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        executor = vungleThreadPoolExecutor;
    }

    public final void setMetricsEnabled$vungle_ads_release(boolean z2) {
        metricsEnabled = z2;
    }

    public final void setRefreshEnabled$vungle_ads_release(boolean z2) {
        refreshEnabled = z2;
    }

    public final void setVungleApiClient$vungle_ads_release(VungleApiClient vungleApiClient2) {
        vungleApiClient = vungleApiClient2;
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, SingleValueMetric singleValueMetric, LogEntry logEntry, String str, int i2, Object obj) throws Throwable {
        if ((i2 & 2) != 0) {
            logEntry = null;
        }
        if ((i2 & 4) != 0) {
            str = singleValueMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(singleValueMetric, logEntry, str);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, OneShotSingleValueMetric oneShotSingleValueMetric, LogEntry logEntry, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            logEntry = null;
        }
        if ((i2 & 4) != 0) {
            str = oneShotSingleValueMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(oneShotSingleValueMetric, logEntry, str);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, TimeIntervalMetric timeIntervalMetric, LogEntry logEntry, String str, int i2, Object obj) throws Throwable {
        if ((i2 & 2) != 0) {
            logEntry = null;
        }
        if ((i2 & 4) != 0) {
            str = timeIntervalMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(timeIntervalMetric, logEntry, str);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, OneShotTimeIntervalMetric oneShotTimeIntervalMetric, LogEntry logEntry, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            logEntry = null;
        }
        if ((i2 & 4) != 0) {
            str = oneShotTimeIntervalMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(oneShotTimeIntervalMetric, logEntry, str);
    }

    public final synchronized void logMetric$vungle_ads_release(SingleValueMetric singleValueMetric, LogEntry logEntry, String str) throws Throwable {
        try {
            try {
                k.e(singleValueMetric, "singleValueMetric");
                logMetric$vungle_ads_release(singleValueMetric.getMetricType(), singleValueMetric.getValue(), logEntry, str);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized void logMetric$vungle_ads_release(OneShotSingleValueMetric oneShotSingleValueMetric, LogEntry logEntry, String str) {
        k.e(oneShotSingleValueMetric, "oneShotSingleValueMetric");
        if (!oneShotSingleValueMetric.isLogged()) {
            logMetric$vungle_ads_release((SingleValueMetric) oneShotSingleValueMetric, logEntry, str);
            oneShotSingleValueMetric.markLogged();
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getErrors$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getExecutor$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMetrics$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMetricsEnabled$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getPendingErrors$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getPendingMetrics$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshEnabled$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getVungleApiClient$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void isInitialized$vungle_ads_release$annotations() {
    }

    public final synchronized void logMetric$vungle_ads_release(TimeIntervalMetric timeIntervalMetric, LogEntry logEntry, String str) throws Throwable {
        try {
            try {
                k.e(timeIntervalMetric, "timeIntervalMetric");
                logMetric$vungle_ads_release(timeIntervalMetric.getMetricType(), timeIntervalMetric.getValue(), logEntry, str);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized void logMetric$vungle_ads_release(OneShotTimeIntervalMetric oneShotTimeIntervalMetric, LogEntry logEntry, String str) {
        k.e(oneShotTimeIntervalMetric, "oneShotTimeIntervalMetric");
        if (!oneShotTimeIntervalMetric.isLogged()) {
            logMetric$vungle_ads_release((TimeIntervalMetric) oneShotTimeIntervalMetric, logEntry, str);
            oneShotTimeIntervalMetric.markLogged();
        }
    }
}
