package com.unity3d.ads.core.log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface Logger {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ void error$default(Logger logger, String str, Throwable th, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
            }
            if ((i2 & 2) != 0) {
                th = null;
            }
            logger.error(str, th);
        }

        public static /* synthetic */ void trace$default(Logger logger, String str, Throwable th, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trace");
            }
            if ((i2 & 2) != 0) {
                th = null;
            }
            logger.trace(str, th);
        }
    }

    void debug(String str);

    void error(String str, Throwable th);

    LogLevel getLogLevel();

    void info(String str);

    void setLogLevel(LogLevel logLevel);

    void trace(String str, Throwable th);
}
