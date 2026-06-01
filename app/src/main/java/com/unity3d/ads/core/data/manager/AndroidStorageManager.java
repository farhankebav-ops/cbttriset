package com.unity3d.ads.core.data.manager;

import android.content.Context;
import com.unity3d.services.core.device.Storage;
import com.unity3d.services.core.device.StorageManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidStorageManager implements StorageManager {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_INITIALIZED = "configuration.hasInitialized";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public void addStorageLocation(StorageManager.StorageType type, String fileName) {
        k.e(type, "type");
        k.e(fileName, "fileName");
        com.unity3d.services.core.device.StorageManager.addStorageLocation(type, fileName);
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public Storage getStorage(StorageManager.StorageType type) {
        k.e(type, "type");
        Storage storage = com.unity3d.services.core.device.StorageManager.getStorage(type);
        k.d(storage, "getStorage(type)");
        return storage;
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public void hasInitialized() {
        Storage storage = getStorage(StorageManager.StorageType.PRIVATE);
        storage.set(KEY_INITIALIZED, Boolean.TRUE);
        storage.writeStorage();
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public boolean hasStorage(StorageManager.StorageType type) {
        k.e(type, "type");
        return com.unity3d.services.core.device.StorageManager.hasStorage(type);
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public boolean init(Context context) {
        k.e(context, "context");
        return com.unity3d.services.core.device.StorageManager.init(context);
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public void initStorage(StorageManager.StorageType type) {
        k.e(type, "type");
        com.unity3d.services.core.device.StorageManager.initStorage(type);
    }

    @Override // com.unity3d.ads.core.data.manager.StorageManager
    public void removeStorage(StorageManager.StorageType type) {
        k.e(type, "type");
        com.unity3d.services.core.device.StorageManager.removeStorage(type);
    }
}
