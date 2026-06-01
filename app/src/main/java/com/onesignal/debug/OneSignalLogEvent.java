package com.onesignal.debug;

import a1.a;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OneSignalLogEvent {
    private final String entry;
    private final LogLevel level;

    public OneSignalLogEvent(LogLevel level, String entry) {
        k.e(level, "level");
        k.e(entry, "entry");
        this.level = level;
        this.entry = entry;
    }

    public static /* synthetic */ OneSignalLogEvent copy$default(OneSignalLogEvent oneSignalLogEvent, LogLevel logLevel, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            logLevel = oneSignalLogEvent.level;
        }
        if ((i2 & 2) != 0) {
            str = oneSignalLogEvent.entry;
        }
        return oneSignalLogEvent.copy(logLevel, str);
    }

    public final LogLevel component1() {
        return this.level;
    }

    public final String component2() {
        return this.entry;
    }

    public final OneSignalLogEvent copy(LogLevel level, String entry) {
        k.e(level, "level");
        k.e(entry, "entry");
        return new OneSignalLogEvent(level, entry);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OneSignalLogEvent)) {
            return false;
        }
        OneSignalLogEvent oneSignalLogEvent = (OneSignalLogEvent) obj;
        return this.level == oneSignalLogEvent.level && k.a(this.entry, oneSignalLogEvent.entry);
    }

    public final String getEntry() {
        return this.entry;
    }

    public final LogLevel getLevel() {
        return this.level;
    }

    public int hashCode() {
        return this.entry.hashCode() + (this.level.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OneSignalLogEvent(level=");
        sb.append(this.level);
        sb.append(", entry=");
        return a.e(')', this.entry, sb);
    }
}
