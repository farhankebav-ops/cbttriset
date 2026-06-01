package com.ironsource.mediationsdk.logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class IronSourceLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9218b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IronSourceLogLevel {
        public static final int ERROR = 3;
        public static final int GENERAL = 4;
        public static final int INFO = 1;
        public static final int VERBOSE = 0;
        public static final int WARNING = 2;

        public IronSourceLogLevel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IronSourceTag {
        API,
        ADAPTER_API,
        CALLBACK,
        ADAPTER_CALLBACK,
        NETWORK,
        INTERNAL,
        NATIVE,
        EVENT
    }

    public IronSourceLogger(String str) {
        this.f9218b = str;
        this.f9217a = 0;
    }

    public int a() {
        return this.f9217a;
    }

    public String b() {
        return this.f9218b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof IronSourceLogger)) {
            IronSourceLogger ironSourceLogger = (IronSourceLogger) obj;
            String str = this.f9218b;
            if (str != null && str.equals(ironSourceLogger.f9218b)) {
                return true;
            }
        }
        return false;
    }

    public abstract void log(IronSourceTag ironSourceTag, String str, int i2);

    public abstract void logException(IronSourceTag ironSourceTag, String str, Throwable th);

    public void setDebugLevel(int i2) {
        this.f9217a = i2;
    }

    public IronSourceLogger(String str, int i2) {
        this.f9218b = str;
        this.f9217a = i2;
    }
}
