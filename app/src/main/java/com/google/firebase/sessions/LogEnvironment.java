package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class LogEnvironment implements NumberedEnum {
    private static final /* synthetic */ y5.a $ENTRIES;
    private static final /* synthetic */ LogEnvironment[] $VALUES;
    private final int number;
    public static final LogEnvironment LOG_ENVIRONMENT_UNKNOWN = new LogEnvironment("LOG_ENVIRONMENT_UNKNOWN", 0, 0);
    public static final LogEnvironment LOG_ENVIRONMENT_AUTOPUSH = new LogEnvironment("LOG_ENVIRONMENT_AUTOPUSH", 1, 1);
    public static final LogEnvironment LOG_ENVIRONMENT_STAGING = new LogEnvironment("LOG_ENVIRONMENT_STAGING", 2, 2);
    public static final LogEnvironment LOG_ENVIRONMENT_PROD = new LogEnvironment("LOG_ENVIRONMENT_PROD", 3, 3);

    private static final /* synthetic */ LogEnvironment[] $values() {
        return new LogEnvironment[]{LOG_ENVIRONMENT_UNKNOWN, LOG_ENVIRONMENT_AUTOPUSH, LOG_ENVIRONMENT_STAGING, LOG_ENVIRONMENT_PROD};
    }

    static {
        LogEnvironment[] logEnvironmentArr$values = $values();
        $VALUES = logEnvironmentArr$values;
        $ENTRIES = n7.b.n(logEnvironmentArr$values);
    }

    private LogEnvironment(String str, int i2, int i8) {
        this.number = i8;
    }

    public static y5.a getEntries() {
        return $ENTRIES;
    }

    public static LogEnvironment valueOf(String str) {
        return (LogEnvironment) Enum.valueOf(LogEnvironment.class, str);
    }

    public static LogEnvironment[] values() {
        return (LogEnvironment[]) $VALUES.clone();
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public int getNumber() {
        return this.number;
    }
}
