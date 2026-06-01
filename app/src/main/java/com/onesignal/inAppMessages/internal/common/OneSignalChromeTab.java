package com.onesignal.inAppMessages.internal.common;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OneSignalChromeTab {
    public static final OneSignalChromeTab INSTANCE = new OneSignalChromeTab();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class OneSignalCustomTabsServiceConnection extends CustomTabsServiceConnection {
        private final Context context;
        private final boolean openActivity;
        private final String url;

        public OneSignalCustomTabsServiceConnection(String url, boolean z2, Context context) {
            k.e(url, "url");
            k.e(context, "context");
            this.url = url;
            this.openActivity = z2;
            this.context = context;
        }

        @Override // androidx.browser.customtabs.CustomTabsServiceConnection
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            k.e(componentName, "componentName");
            k.e(customTabsClient, "customTabsClient");
            customTabsClient.warmup(0L);
            CustomTabsSession customTabsSessionNewSession = customTabsClient.newSession(null);
            if (customTabsSessionNewSession == null) {
                return;
            }
            Uri uri = Uri.parse(this.url);
            customTabsSessionNewSession.mayLaunchUrl(uri, null, null);
            if (this.openActivity) {
                CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder(customTabsSessionNewSession).build();
                k.d(customTabsIntentBuild, "mBuilder.build()");
                customTabsIntentBuild.intent.setData(uri);
                customTabsIntentBuild.intent.addFlags(268435456);
                this.context.startActivity(customTabsIntentBuild.intent, customTabsIntentBuild.startAnimationBundle);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            k.e(name, "name");
        }
    }

    private OneSignalChromeTab() {
    }

    private final boolean hasChromeTabLibrary() {
        return true;
    }

    public final boolean open$com_onesignal_inAppMessages(String url, boolean z2, Context context) {
        k.e(url, "url");
        k.e(context, "context");
        if (hasChromeTabLibrary()) {
            return CustomTabsClient.bindCustomTabsService(context, "com.android.chrome", new OneSignalCustomTabsServiceConnection(url, z2, context));
        }
        return false;
    }
}
