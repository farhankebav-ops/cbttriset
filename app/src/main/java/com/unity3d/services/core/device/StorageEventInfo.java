package com.unity3d.services.core.device;

import com.unity3d.services.core.device.StorageManager;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class StorageEventInfo {
    private final StorageEvent eventType;
    private final StorageManager.StorageType storageType;
    private final Object value;

    public StorageEventInfo(StorageEvent eventType, StorageManager.StorageType storageType, Object obj) {
        k.e(eventType, "eventType");
        k.e(storageType, "storageType");
        this.eventType = eventType;
        this.storageType = storageType;
        this.value = obj;
    }

    public static /* synthetic */ StorageEventInfo copy$default(StorageEventInfo storageEventInfo, StorageEvent storageEvent, StorageManager.StorageType storageType, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            storageEvent = storageEventInfo.eventType;
        }
        if ((i2 & 2) != 0) {
            storageType = storageEventInfo.storageType;
        }
        if ((i2 & 4) != 0) {
            obj = storageEventInfo.value;
        }
        return storageEventInfo.copy(storageEvent, storageType, obj);
    }

    public final StorageEvent component1() {
        return this.eventType;
    }

    public final StorageManager.StorageType component2() {
        return this.storageType;
    }

    public final Object component3() {
        return this.value;
    }

    public final StorageEventInfo copy(StorageEvent eventType, StorageManager.StorageType storageType, Object obj) {
        k.e(eventType, "eventType");
        k.e(storageType, "storageType");
        return new StorageEventInfo(eventType, storageType, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorageEventInfo)) {
            return false;
        }
        StorageEventInfo storageEventInfo = (StorageEventInfo) obj;
        return this.eventType == storageEventInfo.eventType && this.storageType == storageEventInfo.storageType && k.a(this.value, storageEventInfo.value);
    }

    public final StorageEvent getEventType() {
        return this.eventType;
    }

    public final StorageManager.StorageType getStorageType() {
        return this.storageType;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = (this.storageType.hashCode() + (this.eventType.hashCode() * 31)) * 31;
        Object obj = this.value;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "StorageEventInfo(eventType=" + this.eventType + ", storageType=" + this.storageType + ", value=" + this.value + ')';
    }
}
