package com.bykv.vk.openvk.preload.geckox.logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class GeckoLogger {
    private static boolean DEBUG = false;
    private static Logger sLogger = new DefaultLogger();

    public static void d(String str, Object... objArr) {
        Logger logger;
        if (!DEBUG || (logger = sLogger) == null) {
            return;
        }
        logger.d(str, objArr);
    }

    public static void disable() {
        DEBUG = false;
    }

    public static void e(String str, String str2, Throwable th) {
        Logger logger;
        if (!DEBUG || (logger = sLogger) == null) {
            return;
        }
        logger.e(str, str2, th);
    }

    public static void enable() {
        DEBUG = true;
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static void redirect(Logger logger) {
        sLogger = logger;
    }

    public static void w(String str, String str2, Throwable th) {
        Logger logger;
        if (!DEBUG || (logger = sLogger) == null) {
            return;
        }
        logger.w(str, str2, th);
    }

    public static void w(String str, String str2) {
        Logger logger;
        if (!DEBUG || (logger = sLogger) == null) {
            return;
        }
        logger.w(str, str2);
    }
}
