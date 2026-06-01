package com.unity3d.services.core.device;

import android.content.Context;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class StorageManager {
    private static final Map<StorageType, String> _storageFileMap = Collections.synchronizedMap(new HashMap());
    private static final List<Storage> _storages = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum StorageType {
        PRIVATE,
        PUBLIC,
        MEMORY
    }

    public static synchronized void addStorageLocation(StorageType storageType, String str) {
        Map<StorageType, String> map = _storageFileMap;
        if (!map.containsKey(storageType)) {
            map.put(storageType, str);
        }
    }

    public static Storage getStorage(StorageType storageType) {
        List<Storage> list = _storages;
        if (list == null) {
            return null;
        }
        synchronized (list) {
            try {
                for (Storage storage : list) {
                    if (storage.getType().equals(storageType)) {
                        return storage;
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public static boolean hasStorage(StorageType storageType) {
        List<Storage> list = _storages;
        if (list == null) {
            return false;
        }
        synchronized (list) {
            try {
                Iterator<Storage> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().getType().equals(storageType)) {
                        return true;
                    }
                }
                return false;
            } finally {
            }
        }
    }

    public static boolean init(Context context) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return false;
        }
        StorageType storageType = StorageType.PUBLIC;
        addStorageLocation(storageType, filesDir + "/" + SdkProperties.getLocalStorageFilePrefix() + "public-data.json");
        if (!setupStorage(storageType)) {
            return false;
        }
        StorageType storageType2 = StorageType.PRIVATE;
        addStorageLocation(storageType2, filesDir + "/" + SdkProperties.getLocalStorageFilePrefix() + "private-data.json");
        if (setupStorage(storageType2)) {
            return setupStorage(StorageType.MEMORY);
        }
        return false;
    }

    public static void initStorage(StorageType storageType) {
        if (hasStorage(storageType)) {
            Storage storage = getStorage(storageType);
            if (storage != null) {
                storage.initStorage();
                return;
            }
            return;
        }
        Map<StorageType, String> map = _storageFileMap;
        if (map.containsKey(storageType)) {
            Storage storage2 = new Storage(map.get(storageType), storageType);
            storage2.initStorage();
            _storages.add(storage2);
        } else if (storageType.equals(StorageType.MEMORY)) {
            InMemoryStorage inMemoryStorage = new InMemoryStorage();
            inMemoryStorage.initStorage();
            _storages.add(inMemoryStorage);
        }
    }

    public static synchronized void removeStorage(StorageType storageType) {
        try {
            if (getStorage(storageType) != null) {
                _storages.remove(getStorage(storageType));
            }
            Map<StorageType, String> map = _storageFileMap;
            if (map != null) {
                map.remove(storageType);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static boolean setupStorage(StorageType storageType) {
        if (hasStorage(storageType)) {
            return true;
        }
        initStorage(storageType);
        Storage storage = getStorage(storageType);
        if (storage != null && !storage.storageFileExists()) {
            storage.writeStorage();
        }
        return storage != null;
    }
}
