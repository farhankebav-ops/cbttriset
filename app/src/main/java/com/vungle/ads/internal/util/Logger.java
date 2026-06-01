package com.vungle.ads.internal.util;

import android.util.Log;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Logger {
    public static final Companion Companion = new Companion(null);
    private static boolean enabled;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final int d(String tag, String message) {
            k.e(tag, "tag");
            k.e(message, "message");
            if (Logger.enabled) {
                return Log.d(tag, eraseSensitiveData(message));
            }
            return -1;
        }

        public final int e(String tag, String message) {
            k.e(tag, "tag");
            k.e(message, "message");
            if (Logger.enabled) {
                return Log.e(tag, eraseSensitiveData(message));
            }
            return -1;
        }

        public final void enable(boolean z2) {
            Logger.enabled = z2;
        }

        public final String eraseSensitiveData(String str) {
            k.e(str, "<this>");
            Pattern patternCompile = Pattern.compile("[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}\\.[\\d]{1,3}");
            k.d(patternCompile, "compile(\"[\\\\d]{1,3}\\\\.[\\…[\\\\d]{1,3}\\\\.[\\\\d]{1,3}\")");
            String strReplaceAll = patternCompile.matcher(str).replaceAll("xxx.xxx.xxx.xxx");
            k.d(strReplaceAll, "replaceAll(...)");
            return strReplaceAll;
        }

        public final int i(String tag, String message) {
            k.e(tag, "tag");
            k.e(message, "message");
            if (Logger.enabled) {
                return Log.i(tag, eraseSensitiveData(message));
            }
            return -1;
        }

        public final int w(String tag, String message) {
            k.e(tag, "tag");
            k.e(message, "message");
            if (Logger.enabled) {
                return Log.w(tag, eraseSensitiveData(message));
            }
            return -1;
        }

        private Companion() {
        }

        public final int e(String tag, String message, Throwable throwable) {
            k.e(tag, "tag");
            k.e(message, "message");
            k.e(throwable, "throwable");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.e(tag, eraseSensitiveData(message) + "; error: " + throwable.getLocalizedMessage());
        }

        public final int i(String tag, String message, Throwable throwable) {
            k.e(tag, "tag");
            k.e(message, "message");
            k.e(throwable, "throwable");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.i(tag, eraseSensitiveData(message) + "; error: " + throwable.getLocalizedMessage());
        }

        public final int w(String tag, String message, Throwable throwable) {
            k.e(tag, "tag");
            k.e(message, "message");
            k.e(throwable, "throwable");
            if (!Logger.enabled) {
                return -1;
            }
            return Log.w(tag, eraseSensitiveData(message) + "; error: " + throwable.getLocalizedMessage());
        }
    }

    public static final int d(String str, String str2) {
        return Companion.d(str, str2);
    }

    public static final int e(String str, String str2) {
        return Companion.e(str, str2);
    }

    public static final int i(String str, String str2) {
        return Companion.i(str, str2);
    }

    public static final int w(String str, String str2) {
        return Companion.w(str, str2);
    }

    public static final int e(String str, String str2, Throwable th) {
        return Companion.e(str, str2, th);
    }

    public static final int i(String str, String str2, Throwable th) {
        return Companion.i(str, str2, th);
    }

    public static final int w(String str, String str2, Throwable th) {
        return Companion.w(str, str2, th);
    }
}
