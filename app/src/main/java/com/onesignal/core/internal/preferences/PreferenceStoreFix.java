package com.onesignal.core.internal.preferences;

import android.content.Context;
import android.os.Build;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import java.io.File;
import kotlin.jvm.internal.k;
import n6.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PreferenceStoreFix {
    public static final PreferenceStoreFix INSTANCE = new PreferenceStoreFix();

    private PreferenceStoreFix() {
    }

    public final void ensureNoObfuscatedPrefStore(Context context) {
        File[] fileArrListFiles;
        k.e(context, "context");
        try {
            File file = Build.VERSION.SDK_INT >= 24 ? new File(context.getDataDir(), "shared_prefs") : new File(context.getFilesDir().getParentFile(), "shared_prefs");
            File file2 = new File(file, "OneSignal.xml");
            if (file.exists() && file.isDirectory() && !file2.exists() && (fileArrListFiles = file.listFiles()) != null) {
                for (File prefsFile : fileArrListFiles) {
                    k.d(prefsFile, "prefsFile");
                    String name = prefsFile.getName();
                    k.d(name, "getName(...)");
                    if (context.getSharedPreferences(m.R0(name, "."), 0).contains(PreferenceOneSignalKeys.PREFS_LEGACY_PLAYER_ID)) {
                        prefsFile.renameTo(file2);
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            Logging.log(LogLevel.ERROR, "error attempting to fix obfuscated preference store", th);
        }
    }
}
