package com.onesignal;

import android.content.Context;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.debug.IDebugManager;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.session.ISessionManager;
import com.onesignal.user.IUserManager;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OneSignal {
    public static final OneSignal INSTANCE = new OneSignal();
    private static final f oneSignal$delegate = b.C(OneSignal$oneSignal$2.INSTANCE);

    private OneSignal() {
    }

    public static final boolean getConsentGiven() {
        return INSTANCE.getOneSignal().getConsentGiven();
    }

    public static final boolean getConsentRequired() {
        return INSTANCE.getOneSignal().getConsentRequired();
    }

    public static final IDebugManager getDebug() {
        return INSTANCE.getOneSignal().getDebug();
    }

    public static final boolean getDisableGMSMissingPrompt() {
        return INSTANCE.getOneSignal().getDisableGMSMissingPrompt();
    }

    public static final IInAppMessagesManager getInAppMessages() {
        return INSTANCE.getOneSignal().getInAppMessages();
    }

    public static final ILocationManager getLocation() {
        return INSTANCE.getOneSignal().getLocation();
    }

    public static final INotificationsManager getNotifications() {
        return INSTANCE.getOneSignal().getNotifications();
    }

    private final IOneSignal getOneSignal() {
        return (IOneSignal) oneSignal$delegate.getValue();
    }

    public static final String getSdkVersion() {
        return INSTANCE.getOneSignal().getSdkVersion();
    }

    public static final ISessionManager getSession() {
        return INSTANCE.getOneSignal().getSession();
    }

    public static final IUserManager getUser() {
        return INSTANCE.getOneSignal().getUser();
    }

    public static final void initWithContext(Context context, String appId) {
        k.e(context, "context");
        k.e(appId, "appId");
        INSTANCE.getOneSignal().initWithContext(context, appId);
    }

    public static final boolean isInitialized() {
        return INSTANCE.getOneSignal().isInitialized();
    }

    public static final void login(String externalId) {
        k.e(externalId, "externalId");
        INSTANCE.getOneSignal().login(externalId);
    }

    public static /* synthetic */ void login$default(String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        login(str, str2);
    }

    public static final void logout() {
        INSTANCE.getOneSignal().logout();
    }

    public static final void setConsentGiven(boolean z2) {
        INSTANCE.getOneSignal().setConsentGiven(z2);
    }

    public static final void setConsentRequired(boolean z2) {
        INSTANCE.getOneSignal().setConsentRequired(z2);
    }

    public static final void setDisableGMSMissingPrompt(boolean z2) {
        INSTANCE.getOneSignal().setDisableGMSMissingPrompt(z2);
    }

    public final <T> T getService() {
        getServices();
        k.k();
        throw null;
    }

    public final <T> T getServiceOrNull() {
        getServices();
        k.k();
        throw null;
    }

    public final IServiceProvider getServices() {
        IOneSignal oneSignal = getOneSignal();
        k.c(oneSignal, "null cannot be cast to non-null type com.onesignal.common.services.IServiceProvider");
        return (IServiceProvider) oneSignal;
    }

    public static final boolean initWithContext(Context context) {
        k.e(context, "context");
        return INSTANCE.getOneSignal().initWithContext(context, null);
    }

    public static final void login(String externalId, String str) {
        k.e(externalId, "externalId");
        INSTANCE.getOneSignal().login(externalId, str);
    }

    public static /* synthetic */ void getConsentGiven$annotations() {
    }

    public static /* synthetic */ void getConsentRequired$annotations() {
    }

    public static /* synthetic */ void getDebug$annotations() {
    }

    public static /* synthetic */ void getDisableGMSMissingPrompt$annotations() {
    }

    public static /* synthetic */ void getInAppMessages$annotations() {
    }

    public static /* synthetic */ void getLocation$annotations() {
    }

    public static /* synthetic */ void getNotifications$annotations() {
    }

    public static /* synthetic */ void getSdkVersion$annotations() {
    }

    public static /* synthetic */ void getSession$annotations() {
    }

    public static /* synthetic */ void getUser$annotations() {
    }

    public static /* synthetic */ void isInitialized$annotations() {
    }
}
