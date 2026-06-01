package com.google.firebase.inappmessaging.internal;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingClickListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDismissListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayErrorListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingImpressionListener;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class DeveloperListenerManager {
    private final Executor backgroundExecutor;
    private Map<FirebaseInAppMessagingClickListener, ClicksExecutorAndListener> registeredClickListeners = new HashMap();
    private Map<FirebaseInAppMessagingDismissListener, DismissExecutorAndListener> registeredDismissListeners = new HashMap();
    private Map<FirebaseInAppMessagingDisplayErrorListener, ErrorsExecutorAndListener> registeredErrorListeners = new HashMap();
    private Map<FirebaseInAppMessagingImpressionListener, ImpressionExecutorAndListener> registeredImpressionListeners = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ClicksExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingClickListener> {
        FirebaseInAppMessagingClickListener listener;

        public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingClickListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingClickListener getListener() {
            return this.listener;
        }

        public ClicksExecutorAndListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
            super(null);
            this.listener = firebaseInAppMessagingClickListener;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class DismissExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingDismissListener> {
        FirebaseInAppMessagingDismissListener listener;

        public DismissExecutorAndListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingDismissListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingDismissListener getListener() {
            return this.listener;
        }

        public DismissExecutorAndListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
            super(null);
            this.listener = firebaseInAppMessagingDismissListener;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ErrorsExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingDisplayErrorListener> {
        FirebaseInAppMessagingDisplayErrorListener listener;

        public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingDisplayErrorListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingDisplayErrorListener getListener() {
            return this.listener;
        }

        public ErrorsExecutorAndListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
            super(null);
            this.listener = firebaseInAppMessagingDisplayErrorListener;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class ExecutorAndListener<T> {
        private final Executor executor;

        public ExecutorAndListener(Executor executor) {
            this.executor = executor;
        }

        public abstract T getListener();

        public Executor withExecutor(Executor executor) {
            Executor executor2 = this.executor;
            return executor2 == null ? executor : executor2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ImpressionExecutorAndListener extends ExecutorAndListener<FirebaseInAppMessagingImpressionListener> {
        FirebaseInAppMessagingImpressionListener listener;

        public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor) {
            super(executor);
            this.listener = firebaseInAppMessagingImpressionListener;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.inappmessaging.internal.DeveloperListenerManager.ExecutorAndListener
        public FirebaseInAppMessagingImpressionListener getListener() {
            return this.listener;
        }

        public ImpressionExecutorAndListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
            super(null);
            this.listener = firebaseInAppMessagingImpressionListener;
        }
    }

    public DeveloperListenerManager(@Background Executor executor) {
        this.backgroundExecutor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$displayErrorEncountered$1(ErrorsExecutorAndListener errorsExecutorAndListener, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        errorsExecutorAndListener.getListener().displayErrorEncountered(inAppMessage, inAppMessagingErrorReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$impressionDetected$0(ImpressionExecutorAndListener impressionExecutorAndListener, InAppMessage inAppMessage) {
        impressionExecutorAndListener.getListener().impressionDetected(inAppMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$messageClicked$2(ClicksExecutorAndListener clicksExecutorAndListener, InAppMessage inAppMessage, Action action) {
        clicksExecutorAndListener.getListener().messageClicked(inAppMessage, action);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$messageDismissed$3(DismissExecutorAndListener dismissExecutorAndListener, InAppMessage inAppMessage) {
        dismissExecutorAndListener.getListener().messageDismissed(inAppMessage);
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, new ClicksExecutorAndListener(firebaseInAppMessagingClickListener));
    }

    public void addDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        this.registeredDismissListeners.put(firebaseInAppMessagingDismissListener, new DismissExecutorAndListener(firebaseInAppMessagingDismissListener));
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(firebaseInAppMessagingDisplayErrorListener));
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(firebaseInAppMessagingImpressionListener));
    }

    public void displayErrorEncountered(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        for (ErrorsExecutorAndListener errorsExecutorAndListener : this.registeredErrorListeners.values()) {
            errorsExecutorAndListener.withExecutor(this.backgroundExecutor).execute(new d(errorsExecutorAndListener, inAppMessage, inAppMessagingErrorReason, 0));
        }
    }

    @VisibleForTesting
    public Map getAllListeners() {
        HashMap map = new HashMap();
        map.putAll(this.registeredClickListeners);
        map.putAll(this.registeredImpressionListeners);
        map.putAll(this.registeredErrorListeners);
        map.putAll(this.registeredDismissListeners);
        return map;
    }

    public void impressionDetected(InAppMessage inAppMessage) {
        for (ImpressionExecutorAndListener impressionExecutorAndListener : this.registeredImpressionListeners.values()) {
            impressionExecutorAndListener.withExecutor(this.backgroundExecutor).execute(new e(1, impressionExecutorAndListener, inAppMessage));
        }
    }

    public void messageClicked(InAppMessage inAppMessage, Action action) {
        for (ClicksExecutorAndListener clicksExecutorAndListener : this.registeredClickListeners.values()) {
            clicksExecutorAndListener.withExecutor(this.backgroundExecutor).execute(new d(clicksExecutorAndListener, inAppMessage, action, 1));
        }
    }

    public void messageDismissed(InAppMessage inAppMessage) {
        for (DismissExecutorAndListener dismissExecutorAndListener : this.registeredDismissListeners.values()) {
            dismissExecutorAndListener.withExecutor(this.backgroundExecutor).execute(new e(0, dismissExecutorAndListener, inAppMessage));
        }
    }

    public void removeAllListeners() {
        this.registeredClickListeners.clear();
        this.registeredImpressionListeners.clear();
        this.registeredErrorListeners.clear();
        this.registeredDismissListeners.clear();
    }

    public void removeClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener) {
        this.registeredClickListeners.remove(firebaseInAppMessagingClickListener);
    }

    public void removeDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener) {
        this.registeredDismissListeners.remove(firebaseInAppMessagingDismissListener);
    }

    public void removeDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener) {
        this.registeredErrorListeners.remove(firebaseInAppMessagingDisplayErrorListener);
    }

    public void removeImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener) {
        this.registeredImpressionListeners.remove(firebaseInAppMessagingImpressionListener);
    }

    public void addClickListener(FirebaseInAppMessagingClickListener firebaseInAppMessagingClickListener, Executor executor) {
        this.registeredClickListeners.put(firebaseInAppMessagingClickListener, new ClicksExecutorAndListener(firebaseInAppMessagingClickListener, executor));
    }

    public void addDismissListener(FirebaseInAppMessagingDismissListener firebaseInAppMessagingDismissListener, Executor executor) {
        this.registeredDismissListeners.put(firebaseInAppMessagingDismissListener, new DismissExecutorAndListener(firebaseInAppMessagingDismissListener, executor));
    }

    public void addDisplayErrorListener(FirebaseInAppMessagingDisplayErrorListener firebaseInAppMessagingDisplayErrorListener, Executor executor) {
        this.registeredErrorListeners.put(firebaseInAppMessagingDisplayErrorListener, new ErrorsExecutorAndListener(firebaseInAppMessagingDisplayErrorListener, executor));
    }

    public void addImpressionListener(FirebaseInAppMessagingImpressionListener firebaseInAppMessagingImpressionListener, Executor executor) {
        this.registeredImpressionListeners.put(firebaseInAppMessagingImpressionListener, new ImpressionExecutorAndListener(firebaseInAppMessagingImpressionListener, executor));
    }
}
