package com.google.firebase.inappmessaging.display.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class FirebaseInAppMessagingDisplayImpl implements FirebaseInAppMessagingDisplay, Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Logging.logd("Created activity: ".concat(activity.getClass().getName()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Logging.logd("Destroyed activity: ".concat(activity.getClass().getName()));
    }

    public void onActivityPaused(Activity activity) {
        Logging.logd("Pausing activity: ".concat(activity.getClass().getName()));
    }

    public void onActivityResumed(Activity activity) {
        Logging.logd("Resumed activity: ".concat(activity.getClass().getName()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Logging.logd("SavedInstance activity: ".concat(activity.getClass().getName()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Logging.logd("Started activity: ".concat(activity.getClass().getName()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Logging.logd("Stopped activity: ".concat(activity.getClass().getName()));
    }

    @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
    public void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
    }
}
