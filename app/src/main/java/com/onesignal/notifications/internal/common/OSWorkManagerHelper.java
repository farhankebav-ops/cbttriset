package com.onesignal.notifications.internal.common;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OSWorkManagerHelper {
    public static final OSWorkManagerHelper INSTANCE = new OSWorkManagerHelper();

    private OSWorkManagerHelper() {
    }

    private final void initializeWorkManager(Context context) {
        Configuration configurationBuild;
        try {
            Object applicationContext = context.getApplicationContext();
            Configuration.Provider provider = applicationContext instanceof Configuration.Provider ? (Configuration.Provider) applicationContext : null;
            if (provider == null || (configurationBuild = provider.getWorkManagerConfiguration()) == null) {
                configurationBuild = new Configuration.Builder().build();
            }
            k.d(configurationBuild, "(context.applicationCont…uration.Builder().build()");
            WorkManager.initialize(context, configurationBuild);
        } catch (IllegalStateException e) {
            Logging.error("OSWorkManagerHelper initializing WorkManager failed: ", e);
        }
    }

    public final synchronized WorkManager getInstance(Context context) {
        WorkManager workManager;
        k.e(context, "context");
        try {
            workManager = WorkManager.getInstance(context);
            k.d(workManager, "{\n            WorkManage…stance(context)\n        }");
        } catch (IllegalStateException e) {
            Logging.error("OSWorkManagerHelper.getInstance failed, attempting to initialize: ", e);
            initializeWorkManager(context);
            workManager = WorkManager.getInstance(context);
            k.d(workManager, "{\n            /*\n       …stance(context)\n        }");
        }
        return workManager;
    }
}
