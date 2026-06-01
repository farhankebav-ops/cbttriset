package com.onesignal.debug;

import kotlin.jvm.internal.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum LogLevel {
    NONE,
    FATAL,
    ERROR,
    WARN,
    INFO,
    DEBUG,
    VERBOSE;

    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final LogLevel fromInt(int i2) {
            return LogLevel.values()[i2];
        }

        private Companion() {
        }
    }

    public static final LogLevel fromInt(int i2) {
        return Companion.fromInt(i2);
    }
}
