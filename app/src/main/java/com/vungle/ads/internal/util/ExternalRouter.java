package com.vungle.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.vungle.ads.LinkError;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import com.vungle.ads.internal.util.Logger;
import java.net.URISyntaxException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ExternalRouter {
    public static final ExternalRouter INSTANCE = new ExternalRouter();
    private static final String TAG = "ExternalRouter";

    private ExternalRouter() {
    }

    private final Intent getIntentFromUrl(String str, boolean z2) {
        Intent uri = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    uri = Intent.parseUri(str, 0);
                }
            } catch (URISyntaxException e) {
                Logger.Companion.e(TAG, "url format is not correct " + e.getLocalizedMessage());
            }
        }
        if (uri != null && z2) {
            uri.setFlags(268435456);
            return uri;
        }
        return uri;
    }

    public static final boolean launch(String str, String str2, Context context, LogEntry logEntry, PresenterAdOpenCallback presenterAdOpenCallback) {
        k.e(context, "context");
        if ((str != null && str.length() != 0) || (str2 != null && str2.length() != 0)) {
            boolean z2 = !(context instanceof Activity);
            try {
                ExternalRouter externalRouter = INSTANCE;
                return ActivityManager.Companion.startWhenForeground(context, externalRouter.getIntentFromUrl(str, z2), externalRouter.getIntentFromUrl(str2, z2), presenterAdOpenCallback);
            } catch (Exception e) {
                if (str == null || str.length() == 0) {
                    new LinkError(Sdk.SDKError.Reason.LINK_COMMAND_OPEN_FAILED, a1.a.l("Fail to open ", str2)).setLogEntry$vungle_ads_release(logEntry).logErrorNoReturnValue$vungle_ads_release();
                } else {
                    new LinkError(Sdk.SDKError.Reason.DEEPLINK_OPEN_FAILED, a1.a.l("Fail to open ", str)).setLogEntry$vungle_ads_release(logEntry).logErrorNoReturnValue$vungle_ads_release();
                }
                Logger.Companion companion = Logger.Companion;
                companion.e(TAG, "Error while opening url" + e.getLocalizedMessage());
                companion.d(TAG, "Cannot open url " + str2);
            }
        }
        return false;
    }

    public static /* synthetic */ boolean launch$default(String str, String str2, Context context, LogEntry logEntry, PresenterAdOpenCallback presenterAdOpenCallback, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            logEntry = null;
        }
        if ((i2 & 16) != 0) {
            presenterAdOpenCallback = null;
        }
        return launch(str, str2, context, logEntry, presenterAdOpenCallback);
    }
}
