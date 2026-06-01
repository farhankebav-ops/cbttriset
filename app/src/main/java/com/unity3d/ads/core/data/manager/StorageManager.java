package com.unity3d.ads.core.data.manager;

import android.content.Context;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface StorageManager {
    void addStorageLocation(StorageManager.StorageType storageType, String str);

    Storage getStorage(StorageManager.StorageType storageType);

    void hasInitialized();

    boolean hasStorage(StorageManager.StorageType storageType);

    boolean init(Context context);

    void initStorage(StorageManager.StorageType storageType);

    void removeStorage(StorageManager.StorageType storageType);
}
