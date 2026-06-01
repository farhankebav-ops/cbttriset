package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class EventType implements NumberedEnum {
    private static final /* synthetic */ y5.a $ENTRIES;
    private static final /* synthetic */ EventType[] $VALUES;
    public static final EventType EVENT_TYPE_UNKNOWN = new EventType("EVENT_TYPE_UNKNOWN", 0, 0);
    public static final EventType SESSION_START = new EventType("SESSION_START", 1, 1);
    private final int number;

    private static final /* synthetic */ EventType[] $values() {
        return new EventType[]{EVENT_TYPE_UNKNOWN, SESSION_START};
    }

    static {
        EventType[] eventTypeArr$values = $values();
        $VALUES = eventTypeArr$values;
        $ENTRIES = n7.b.n(eventTypeArr$values);
    }

    private EventType(String str, int i2, int i8) {
        this.number = i8;
    }

    public static y5.a getEntries() {
        return $ENTRIES;
    }

    public static EventType valueOf(String str) {
        return (EventType) Enum.valueOf(EventType.class, str);
    }

    public static EventType[] values() {
        return (EventType[]) $VALUES.clone();
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public int getNumber() {
        return this.number;
    }
}
