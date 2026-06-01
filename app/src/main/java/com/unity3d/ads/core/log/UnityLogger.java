package com.unity3d.ads.core.log;

import android.util.Log;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnityLogger implements Logger {
    public static final Companion Companion = new Companion(null);
    private static final String LOG_TAG = "UnityAds";
    private LogLevel logLevel = LogLevel.INFO;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    private final boolean canLog(int i2) {
        return Log.isLoggable("UnityAds", i2) && i2 >= getLogLevel().toAndroidLogLevel();
    }

    @Override // com.unity3d.ads.core.log.Logger
    public void debug(String message) {
        k.e(message, "message");
        if (canLog(3)) {
            Log.d("UnityAds", message);
        }
    }

    @Override // com.unity3d.ads.core.log.Logger
    public void error(String message, Throwable th) {
        k.e(message, "message");
        if (canLog(6)) {
            Log.e("UnityAds", message, th);
        }
    }

    @Override // com.unity3d.ads.core.log.Logger
    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    @Override // com.unity3d.ads.core.log.Logger
    public void info(String message) {
        k.e(message, "message");
        if (canLog(4)) {
            Log.i("UnityAds", message);
        }
    }

    @Override // com.unity3d.ads.core.log.Logger
    public void setLogLevel(LogLevel logLevel) {
        k.e(logLevel, "<set-?>");
        this.logLevel = logLevel;
    }

    @Override // com.unity3d.ads.core.log.Logger
    public void trace(String message, Throwable th) {
        k.e(message, "message");
        if (canLog(2)) {
            Log.v("UnityAds", message, th);
        }
    }
}
