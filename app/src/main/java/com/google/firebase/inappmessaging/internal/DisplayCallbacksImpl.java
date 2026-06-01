package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.RateLimit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class DisplayCallbacksImpl implements FirebaseInAppMessagingDisplayCallbacks {
    private static final String MESSAGE_CLICK = "message click to metrics logger";
    private final RateLimit appForegroundRateLimit;
    private final CampaignCacheClient campaignCacheClient;
    private final Clock clock;
    private final DataCollectionHelper dataCollectionHelper;
    private final ImpressionStorageClient impressionStorageClient;
    private final InAppMessage inAppMessage;
    private final MetricsLoggerClient metricsLoggerClient;
    private final RateLimiterClient rateLimiterClient;
    private final Schedulers schedulers;
    private final String triggeringEvent;
    private boolean wasImpressed = false;

    @VisibleForTesting
    public DisplayCallbacksImpl(ImpressionStorageClient impressionStorageClient, Clock clock, Schedulers schedulers, RateLimiterClient rateLimiterClient, CampaignCacheClient campaignCacheClient, RateLimit rateLimit, MetricsLoggerClient metricsLoggerClient, DataCollectionHelper dataCollectionHelper, InAppMessage inAppMessage, String str) {
        this.impressionStorageClient = impressionStorageClient;
        this.clock = clock;
        this.schedulers = schedulers;
        this.rateLimiterClient = rateLimiterClient;
        this.campaignCacheClient = campaignCacheClient;
        this.appForegroundRateLimit = rateLimit;
        this.metricsLoggerClient = metricsLoggerClient;
        this.dataCollectionHelper = dataCollectionHelper;
        this.inAppMessage = inAppMessage;
        this.triggeringEvent = str;
    }

    private boolean actionMatches(Action action, Action action2) {
        return action == null ? action2 == null || TextUtils.isEmpty(action2.getActionUrl()) : action.getActionUrl().equals(action2.getActionUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$displayErrorEncountered$4(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) throws Exception {
        this.metricsLoggerClient.logRenderError(this.inAppMessage, inAppMessagingErrorReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$impressionDetected$0() throws Exception {
        this.metricsLoggerClient.logImpression(this.inAppMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$logMessageClick$3(Action action) throws Exception {
        this.metricsLoggerClient.logMessageClick(this.inAppMessage, action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s4.k lambda$maybeToTask$10(TaskCompletionSource taskCompletionSource, Throwable th) throws Exception {
        if (th instanceof Exception) {
            taskCompletionSource.setException((Exception) th);
        } else {
            taskCompletionSource.setException(new RuntimeException(th));
        }
        return e5.e.f11264a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$maybeToTask$9(TaskCompletionSource taskCompletionSource) throws Exception {
        taskCompletionSource.setResult(null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$messageDismissed$2(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) throws Exception {
        this.metricsLoggerClient.logDismiss(this.inAppMessage, inAppMessagingDismissType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateWasImpressed$1() throws Exception {
        this.wasImpressed = true;
    }

    private void logActionNotTaken(String str, s4.h hVar) {
        if (hVar != null) {
            Logging.logd(String.format("Not recording: %s. Reason: %s", str, hVar));
            return;
        }
        if (this.inAppMessage.getCampaignMetadata().getIsTestMessage()) {
            Logging.logd("Not recording: " + str + ". Reason: Message is test message");
            return;
        }
        if (this.dataCollectionHelper.isAutomaticDataCollectionEnabled()) {
            Logging.logd("Not recording: " + str);
        } else {
            Logging.logd("Not recording: " + str + ". Reason: Data collection is disabled");
        }
    }

    private Task<Void> logImpressionIfNeeded(s4.a aVar) {
        if (!this.wasImpressed) {
            impressionDetected();
        }
        return maybeToTask(aVar.f(), this.schedulers.io());
    }

    private Task<Void> logMessageClick(Action action) {
        Logging.logd("Attempting to record: message click to metrics logger");
        return logImpressionIfNeeded(new c5.b(new a(2, this, action), 1));
    }

    private s4.a logToImpressionStore() {
        String campaignId = this.inAppMessage.getCampaignMetadata().getCampaignId();
        Logging.logd("Attempting to record message impression in impression store for id: " + campaignId);
        ImpressionStorageClient impressionStorageClient = this.impressionStorageClient;
        r2.b bVarD = r2.c.d();
        bVarD.b(this.clock.now());
        bVarD.a(campaignId);
        s4.a aVarStoreImpression = impressionStorageClient.storeImpression((r2.c) bVarD.build());
        androidx.camera.camera2.internal.compat.workaround.c cVar = new androidx.camera.camera2.internal.compat.workaround.c(20);
        aVarStoreImpression.getClass();
        r4.c cVar2 = z4.b.f17983c;
        c5.f fVarC = new c5.f(aVarStoreImpression, cVar, cVar2).c(new androidx.camera.camera2.internal.compat.workaround.c(21));
        if (!InAppMessageStreamManager.isAppForegroundEvent(this.triggeringEvent)) {
            return fVarC;
        }
        s4.a aVarIncrement = this.rateLimiterClient.increment(this.appForegroundRateLimit);
        androidx.camera.camera2.internal.compat.workaround.c cVar3 = new androidx.camera.camera2.internal.compat.workaround.c(22);
        aVarIncrement.getClass();
        return new c5.d(new c5.f(aVarIncrement, cVar3, cVar2).c(new androidx.camera.camera2.internal.compat.workaround.c(23))).b(fVarC);
    }

    private static <T> Task<T> maybeToTask(s4.h hVar, s4.p pVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        g gVar = new g(taskCompletionSource);
        hVar.getClass();
        int i2 = 2;
        e5.k kVar = new e5.k(new e5.g(new e5.s(hVar, gVar, z4.b.f17984d), new e5.l(new androidx.webkit.internal.c(taskCompletionSource, 5)), i2), new g(taskCompletionSource), i2);
        z4.b.a(pVar, "scheduler is null");
        e5.b bVar = new e5.b();
        try {
            e5.i iVar = new e5.i(bVar);
            y4.a.e(bVar, iVar);
            b5.b bVar2 = (b5.b) iVar.f11275b;
            u4.b bVarB = pVar.b(new com.unity3d.scar.adapter.common.i(1, iVar, kVar, false));
            bVar2.getClass();
            y4.a.c(bVar2, bVarB);
            return taskCompletionSource.getTask();
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            r2.q.y0(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    private boolean shouldLog() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    private s4.a updateWasImpressed() {
        return new c5.b(new f(this, 0), 1);
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (!shouldLog()) {
            logActionNotTaken("render error to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: render error to metrics logger");
        return maybeToTask(logToImpressionStore().b(new c5.b(new a(3, this, inAppMessagingErrorReason), 1)).b(updateWasImpressed()).f(), this.schedulers.io());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> impressionDetected() {
        if (!shouldLog() || this.wasImpressed) {
            logActionNotTaken("message impression to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: message impression to metrics logger");
        return maybeToTask(logToImpressionStore().b(new c5.b(new f(this, 1), 1)).b(updateWasImpressed()).f(), this.schedulers.io());
    }

    @Deprecated
    public Task<Void> messageClicked() {
        return messageClicked(this.inAppMessage.getAction());
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (!shouldLog()) {
            logActionNotTaken("message dismissal to metrics logger");
            return new TaskCompletionSource().getTask();
        }
        Logging.logd("Attempting to record: message dismissal to metrics logger");
        int i2 = 1;
        return logImpressionIfNeeded(new c5.b(new a(i2, this, inAppMessagingDismissType), i2));
    }

    @VisibleForTesting
    public boolean wasImpressed() {
        return this.wasImpressed;
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks
    public Task<Void> messageClicked(Action action) {
        if (shouldLog()) {
            return action.getActionUrl() == null ? messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK) : logMessageClick(action);
        }
        logActionNotTaken(MESSAGE_CLICK);
        return new TaskCompletionSource().getTask();
    }

    private void logActionNotTaken(String str) {
        logActionNotTaken(str, null);
    }
}
