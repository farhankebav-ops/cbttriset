package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class WakeLockHolder {
    private static final String EXTRA_WAKEFUL_INTENT = "com.google.firebase.iid.WakeLockHolder.wakefulintent";
    static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    private static final Object syncObject = new Object();

    @GuardedBy("WakeLockHolder.syncObject")
    private static WakeLock wakeLock;

    public static void acquireWakeLock(Intent intent, long j) {
        synchronized (syncObject) {
            try {
                if (wakeLock != null) {
                    setAsWakefulIntent(intent, true);
                    wakeLock.acquire(j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("WakeLockHolder.syncObject")
    private static void checkAndInitWakeLock(Context context) {
        if (wakeLock == null) {
            WakeLock wakeLock2 = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            wakeLock = wakeLock2;
            wakeLock2.setReferenceCounted(true);
        }
    }

    public static void completeWakefulIntent(@NonNull Intent intent) {
        synchronized (syncObject) {
            try {
                if (wakeLock != null && isWakefulIntent(intent)) {
                    setAsWakefulIntent(intent, false);
                    wakeLock.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void initWakeLock(Context context) {
        synchronized (syncObject) {
            checkAndInitWakeLock(context);
        }
    }

    @VisibleForTesting
    public static boolean isWakefulIntent(@NonNull Intent intent) {
        return intent.getBooleanExtra(EXTRA_WAKEFUL_INTENT, false);
    }

    public static void reset() {
        synchronized (syncObject) {
            wakeLock = null;
        }
    }

    public static void sendWakefulServiceIntent(Context context, WithinAppServiceConnection withinAppServiceConnection, Intent intent) {
        synchronized (syncObject) {
            try {
                checkAndInitWakeLock(context);
                boolean zIsWakefulIntent = isWakefulIntent(intent);
                setAsWakefulIntent(intent, true);
                if (!zIsWakefulIntent) {
                    wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
                }
                withinAppServiceConnection.sendIntent(intent).addOnCompleteListener(new l(intent, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void setAsWakefulIntent(@NonNull Intent intent, boolean z2) {
        intent.putExtra(EXTRA_WAKEFUL_INTENT, z2);
    }

    public static ComponentName startWakefulService(@NonNull Context context, @NonNull Intent intent) {
        synchronized (syncObject) {
            try {
                checkAndInitWakeLock(context);
                boolean zIsWakefulIntent = isWakefulIntent(intent);
                setAsWakefulIntent(intent, true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!zIsWakefulIntent) {
                    wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
