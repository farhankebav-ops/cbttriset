package com.onesignal.notifications.internal.common;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class GenerateNotificationOpenIntent {
    private final Context context;
    private final Intent intent;
    private final boolean startApp;

    public GenerateNotificationOpenIntent(Context context, Intent intent, boolean z2) {
        k.e(context, "context");
        this.context = context;
        this.intent = intent;
        this.startApp = z2;
    }

    private final Intent getIntentAppOpen() {
        Intent launchIntentForPackage;
        if (!this.startApp || (launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(this.context.getPackageName())) == null) {
            return null;
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.setFlags(270532608);
        return launchIntentForPackage;
    }

    public final Intent getIntentVisible() {
        Intent intent = this.intent;
        return intent != null ? intent : getIntentAppOpen();
    }
}
