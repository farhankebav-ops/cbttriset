package com.unity3d.ads.metadata;

import android.content.Context;
import com.unity3d.services.core.device.StorageManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class MediationMetaData extends MetaData {
    public static final String KEY_MISSED_IMPRESSION_ORDINAL = "missedImpressionOrdinal";
    public static final String KEY_NAME = "name";
    public static final String KEY_ORDINAL = "ordinal";
    public static final String KEY_VERSION = "version";

    public MediationMetaData(Context context) {
        super(context);
        setCategory("mediation");
    }

    @Override // com.unity3d.ads.metadata.MetaData
    public StorageManager.StorageType getStorageType() {
        return StorageManager.StorageType.MEMORY;
    }

    public void setMissedImpressionOrdinal(int i2) {
        set(KEY_MISSED_IMPRESSION_ORDINAL, Integer.valueOf(i2));
    }

    public void setName(String str) {
        set("name", str);
    }

    public void setOrdinal(int i2) {
        set(KEY_ORDINAL, Integer.valueOf(i2));
    }

    public void setVersion(String str) {
        set("version", str);
    }
}
