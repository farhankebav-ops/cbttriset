package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class DataCollectionState implements NumberedEnum {
    private static final /* synthetic */ y5.a $ENTRIES;
    private static final /* synthetic */ DataCollectionState[] $VALUES;
    private final int number;
    public static final DataCollectionState COLLECTION_UNKNOWN = new DataCollectionState("COLLECTION_UNKNOWN", 0, 0);
    public static final DataCollectionState COLLECTION_SDK_NOT_INSTALLED = new DataCollectionState("COLLECTION_SDK_NOT_INSTALLED", 1, 1);
    public static final DataCollectionState COLLECTION_ENABLED = new DataCollectionState("COLLECTION_ENABLED", 2, 2);
    public static final DataCollectionState COLLECTION_DISABLED = new DataCollectionState("COLLECTION_DISABLED", 3, 3);
    public static final DataCollectionState COLLECTION_DISABLED_REMOTE = new DataCollectionState("COLLECTION_DISABLED_REMOTE", 4, 4);
    public static final DataCollectionState COLLECTION_SAMPLED = new DataCollectionState("COLLECTION_SAMPLED", 5, 5);

    private static final /* synthetic */ DataCollectionState[] $values() {
        return new DataCollectionState[]{COLLECTION_UNKNOWN, COLLECTION_SDK_NOT_INSTALLED, COLLECTION_ENABLED, COLLECTION_DISABLED, COLLECTION_DISABLED_REMOTE, COLLECTION_SAMPLED};
    }

    static {
        DataCollectionState[] dataCollectionStateArr$values = $values();
        $VALUES = dataCollectionStateArr$values;
        $ENTRIES = n7.b.n(dataCollectionStateArr$values);
    }

    private DataCollectionState(String str, int i2, int i8) {
        this.number = i8;
    }

    public static y5.a getEntries() {
        return $ENTRIES;
    }

    public static DataCollectionState valueOf(String str) {
        return (DataCollectionState) Enum.valueOf(DataCollectionState.class, str);
    }

    public static DataCollectionState[] values() {
        return (DataCollectionState[]) $VALUES.clone();
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public int getNumber() {
        return this.number;
    }
}
