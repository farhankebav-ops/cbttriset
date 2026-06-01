package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public enum EventType implements Internal.EnumLite {
    UNKNOWN_EVENT_TYPE(0),
    IMPRESSION_EVENT_TYPE(1),
    CLICK_EVENT_TYPE(2);

    public static final int CLICK_EVENT_TYPE_VALUE = 2;
    public static final int IMPRESSION_EVENT_TYPE_VALUE = 1;
    public static final int UNKNOWN_EVENT_TYPE_VALUE = 0;
    private static final Internal.EnumLiteMap<EventType> internalValueMap = new Internal.EnumLiteMap<EventType>() { // from class: com.google.firebase.inappmessaging.EventType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EventType findValueByNumber(int i2) {
            return EventType.forNumber(i2);
        }
    };
    private final int value;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class EventTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new EventTypeVerifier();

        private EventTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i2) {
            return EventType.forNumber(i2) != null;
        }
    }

    EventType(int i2) {
        this.value = i2;
    }

    public static EventType forNumber(int i2) {
        if (i2 == 0) {
            return UNKNOWN_EVENT_TYPE;
        }
        if (i2 == 1) {
            return IMPRESSION_EVENT_TYPE;
        }
        if (i2 != 2) {
            return null;
        }
        return CLICK_EVENT_TYPE;
    }

    public static Internal.EnumLiteMap<EventType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EventTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static EventType valueOf(int i2) {
        return forNumber(i2);
    }
}
