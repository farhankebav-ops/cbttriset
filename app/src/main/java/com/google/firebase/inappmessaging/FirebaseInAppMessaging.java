package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.workaround.c;
import androidx.camera.core.impl.b;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.TriggeredInAppMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Executor;
import s4.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@FirebaseAppScope
public class FirebaseInAppMessaging {
    private boolean areMessagesSuppressed = false;
    private final DataCollectionHelper dataCollectionHelper;
    private final DeveloperListenerManager developerListenerManager;
    private final DisplayCallbacksFactory displayCallbacksFactory;
    private FirebaseInAppMessagingDisplay fiamDisplay;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final InAppMessageStreamManager inAppMessageStreamManager;

    @Lightweight
    private Executor lightWeightExecutor;
    private final ProgramaticContextualTriggers programaticContextualTriggers;

    @VisibleForTesting
    public FirebaseInAppMessaging(InAppMessageStreamManager inAppMessageStreamManager, @ProgrammaticTrigger ProgramaticContextualTriggers programaticContextualTriggers, DataCollectionHelper dataCollectionHelper, FirebaseInstallationsApi firebaseInstallationsApi, DisplayCallbacksFactory displayCallbacksFactory, DeveloperListenerManager developerListenerManager, @Lightweight Executor executor) throws Exception {
        this.inAppMessageStreamManager = inAppMessageStreamManager;
        this.programaticContextualTriggers = programaticContextualTriggers;
        this.dataCollectionHelper = dataCollectionHelper;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.displayCallbacksFactory = displayCallbacksFactory;
        this.developerListenerManager = developerListenerManager;
        this.lightWeightExecutor = executor;
        firebaseInstallationsApi.getId().addOnSuccessListener(executor, new c(19));
        d dVarCreateFirebaseInAppMessageStream = inAppMessageStreamManager.createFirebaseInAppMessageStream();
        b bVar = new b(this, 18);
        dVarCreateFirebaseInAppMessageStream.getClass();
        dVarCreateFirebaseInAppMessageStream.d(new j5.c(bVar));
    }

    @NonNull
    public static FirebaseInAppMessaging getInstance() {
        return (FirebaseInAppMessaging) FirebaseApp.getInstance().get(FirebaseInAppMessaging.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(String str) {
        Logging.logi("Starting InAppMessaging runtime with Installation ID " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerInAppMessage(TriggeredInAppMessage triggeredInAppMessage) {
        FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay = this.fiamDisplay;
        if (firebaseInAppMessagingDisplay != null) {
            firebaseInAppMessagingDisplay.displayMessage(triggeredInAppMessage.getInAppMessage(), this.displayCallbacksFactory.generateDisplayCallback(triggeredInAppMessage.getInAppMessage(), triggeredInAppMessage.getTriggeringEvent()));
        }
    }

    public void addClickListener(@NonNull FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.developerListenerManager.addClickListener(firebaseInAppMessagingClickListener);
    }

    public void addDismissListener(@NonNull FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        this.developerListenerManager.addDismissListener(firebaseInAppMessagingDismissListener);
    }

    public void addDisplayErrorListener(@NonNull FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.developerListenerManager.addDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener);
    }

    public void addImpressionListener(@NonNull FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.developerListenerManager.addImpressionListener(firebaseInAppMessagingImpressionListener);
    }

    public boolean areMessagesSuppressed() {
        return this.areMessagesSuppressed;
    }

    public void clearDisplayListener() {
        Logging.logi("Removing display event component");
        this.fiamDisplay = null;
    }

    public boolean isAutomaticDataCollectionEnabled() {
        return this.dataCollectionHelper.isAutomaticDataCollectionEnabled();
    }

    public void removeAllListeners() {
        this.developerListenerManager.removeAllListeners();
    }

    public void removeClickListener(@NonNull FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.developerListenerManager.removeClickListener(firebaseInAppMessagingClickListener);
    }

    public void removeDismissListener(@NonNull FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        this.developerListenerManager.removeDismissListener(firebaseInAppMessagingDismissListener);
    }

    public void removeDisplayErrorListener(@NonNull FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.developerListenerManager.removeDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener);
    }

    public void removeImpressionListener(@NonNull FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.developerListenerManager.removeImpressionListener(firebaseInAppMessagingImpressionListener);
    }

    public void setAutomaticDataCollectionEnabled(@Nullable Boolean bool) {
        this.dataCollectionHelper.setAutomaticDataCollectionEnabled(bool);
    }

    public void setMessageDisplayComponent(@NonNull FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay) {
        Logging.logi("Setting display event component");
        this.fiamDisplay = firebaseInAppMessagingDisplay;
    }

    public void setMessagesSuppressed(@NonNull Boolean bool) {
        this.areMessagesSuppressed = bool.booleanValue();
    }

    public void triggerEvent(@NonNull String str) {
        this.programaticContextualTriggers.triggerEvent(str);
    }

    public void addClickListener(@NonNull FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, @NonNull Executor executor) {
        this.developerListenerManager.addClickListener(firebaseInAppMessagingClickListener, executor);
    }

    public void addDismissListener(@NonNull FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, @NonNull Executor executor) {
        this.developerListenerManager.addDismissListener(firebaseInAppMessagingDismissListener, executor);
    }

    public void addDisplayErrorListener(@NonNull FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, @NonNull Executor executor) {
        this.developerListenerManager.addDisplayErrorListener(firebaseInAppMessagingDisplayErrorListener, executor);
    }

    public void addImpressionListener(@NonNull FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, @NonNull Executor executor) {
        this.developerListenerManager.addImpressionListener(firebaseInAppMessagingImpressionListener, executor);
    }

    public void setAutomaticDataCollectionEnabled(boolean z2) {
        this.dataCollectionHelper.setAutomaticDataCollectionEnabled(z2);
    }
}
