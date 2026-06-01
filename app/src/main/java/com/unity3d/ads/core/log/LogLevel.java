package com.unity3d.ads.core.log;

import e2.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum LogLevel {
    DISABLED(0),
    ERROR(1),
    INFO(2),
    DEBUG(3),
    TRACE(4);

    private final int level;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogLevel.TRACE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    LogLevel(int i2) {
        this.level = i2;
    }

    public final int getLevel$unity_ads_defaultRelease() {
        return this.level;
    }

    public final int toAndroidLogLevel() {
        int i2 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1) {
            return Integer.MAX_VALUE;
        }
        if (i2 == 2) {
            return 6;
        }
        if (i2 == 3) {
            return 4;
        }
        if (i2 == 4) {
            return 3;
        }
        if (i2 == 5) {
            return 2;
        }
        throw new s(3);
    }
}
