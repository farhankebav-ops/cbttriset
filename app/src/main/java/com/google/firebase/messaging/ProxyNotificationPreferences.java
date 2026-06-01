package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class ProxyNotificationPreferences {
    private static final String FCM_PREFERENCES = "com.google.firebase.messaging";

    private ProxyNotificationPreferences() {
    }

    private static SharedPreferences getPreference(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    @WorkerThread
    public static boolean isProxyNotificationInitialized(Context context) {
        return getPreference(context).getBoolean("proxy_notification_initialized", false);
    }

    @WorkerThread
    public static boolean isProxyNotificationRetentionSet(SharedPreferences sharedPreferences, boolean z2) {
        return sharedPreferences.contains("proxy_retention") && sharedPreferences.getBoolean("proxy_retention", false) == z2;
    }

    @WorkerThread
    public static void setProxyNotificationsInitialized(Context context, boolean z2) {
        SharedPreferences.Editor editorEdit = getPreference(context).edit();
        editorEdit.putBoolean("proxy_notification_initialized", z2);
        editorEdit.apply();
    }

    @WorkerThread
    public static void setProxyRetention(final Context context, GmsRpc gmsRpc, final boolean z2) {
        if (PlatformVersion.isAtLeastQ() && !isProxyNotificationRetentionSet(getPreference(context), z2)) {
            gmsRpc.setRetainProxiedNotifications(z2).addOnSuccessListener(new androidx.arch.core.executor.a(2), new OnSuccessListener() { // from class: com.google.firebase.messaging.n
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    ProxyNotificationPreferences.setProxyRetentionPreferences(context, z2);
                }
            });
        }
    }

    @WorkerThread
    public static void setProxyRetentionPreferences(Context context, boolean z2) {
        SharedPreferences.Editor editorEdit = getPreference(context).edit();
        editorEdit.putBoolean("proxy_retention", z2);
        editorEdit.apply();
    }
}
