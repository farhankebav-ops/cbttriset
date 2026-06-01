package com.onesignal;

import android.content.Context;
import com.onesignal.debug.IDebugManager;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.session.ISessionManager;
import com.onesignal.user.IUserManager;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IOneSignal {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static void login(IOneSignal iOneSignal, String externalId) {
            k.e(externalId, "externalId");
            iOneSignal.login(externalId, null);
        }

        public static /* synthetic */ void login$default(IOneSignal iOneSignal, String str, String str2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
            }
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            iOneSignal.login(str, str2);
        }
    }

    boolean getConsentGiven();

    boolean getConsentRequired();

    IDebugManager getDebug();

    boolean getDisableGMSMissingPrompt();

    IInAppMessagesManager getInAppMessages();

    ILocationManager getLocation();

    INotificationsManager getNotifications();

    String getSdkVersion();

    ISessionManager getSession();

    IUserManager getUser();

    boolean initWithContext(Context context, String str);

    boolean isInitialized();

    void login(String str);

    void login(String str, String str2);

    void logout();

    void setConsentGiven(boolean z2);

    void setConsentRequired(boolean z2);

    void setDisableGMSMissingPrompt(boolean z2);
}
