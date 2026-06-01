package com.unity3d.services.core.device;

import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import e6.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.a;
import org.json.JSONObject;
import r5.n;
import r5.r;
import t6.d1;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Storage extends JsonStorage {
    public static final Companion Companion = new Companion(null);
    private static final q0 onStorageEventCallbacks = x0.c(r.f13638a);
    private final String _targetFileName;
    private final StorageManager.StorageType type;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void addStorageEventCallback(l callback) {
            d1 d1Var;
            Object value;
            k.e(callback, "callback");
            q0 q0Var = Storage.onStorageEventCallbacks;
            do {
                d1Var = (d1) q0Var;
                value = d1Var.getValue();
            } while (!d1Var.g(value, r5.l.g1((List) value, callback)));
        }

        public final void removeStorageEventCallback(l callback) {
            d1 d1Var;
            Object value;
            ArrayList arrayList;
            k.e(callback, "callback");
            q0 q0Var = Storage.onStorageEventCallbacks;
            do {
                d1Var = (d1) q0Var;
                value = d1Var.getValue();
                List list = (List) value;
                k.e(list, "<this>");
                arrayList = new ArrayList(n.L0(list, 10));
                boolean z2 = false;
                for (Object obj : list) {
                    boolean z7 = true;
                    if (!z2 && k.a(obj, callback)) {
                        z2 = true;
                        z7 = false;
                    }
                    if (z7) {
                        arrayList.add(obj);
                    }
                }
            } while (!d1Var.g(value, arrayList));
        }

        private Companion() {
        }
    }

    public Storage(String _targetFileName, StorageManager.StorageType type) {
        k.e(_targetFileName, "_targetFileName");
        k.e(type, "type");
        this._targetFileName = _targetFileName;
        this.type = type;
    }

    public synchronized boolean clearStorage() {
        clearData();
        return new File(this._targetFileName).delete();
    }

    public final StorageManager.StorageType getType() {
        return this.type;
    }

    public final synchronized boolean initStorage() {
        readStorage();
        super.initData();
        return true;
    }

    public synchronized boolean readStorage() {
        byte[] fileBytes;
        boolean z2 = true;
        try {
            try {
                fileBytes = Utilities.readFileBytes(new File(this._targetFileName));
            } catch (Exception e) {
                DeviceLog.debug("Failed to read storage JSON file:", e);
            }
        } catch (FileNotFoundException e4) {
            DeviceLog.debug("Storage JSON file not found in local cache:", e4);
        }
        if (fileBytes == null) {
            return false;
        }
        setData(new JSONObject(new String(fileBytes, a.f13073a)));
        return z2;
        z2 = false;
        return z2;
    }

    public final synchronized void sendEvent(StorageEvent storageEvent, Object obj) {
        List list = (List) ((d1) onStorageEventCallbacks).getValue();
        if (list.isEmpty()) {
            if (!(WebViewApp.getCurrentApp() != null ? WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORAGE, storageEvent, this.type.name(), obj) : false)) {
                DeviceLog.debug("Couldn't send storage event to WebApp");
            }
            return;
        }
        k.b(storageEvent);
        StorageEventInfo storageEventInfo = new StorageEventInfo(storageEvent, this.type, obj);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((l) it.next()).invoke(storageEventInfo);
        }
    }

    public final synchronized boolean storageFileExists() {
        return new File(this._targetFileName).exists();
    }

    public synchronized boolean writeStorage() {
        File file = new File(this._targetFileName);
        if (getData() == null) {
            return false;
        }
        return Utilities.writeFile(file, getData().toString());
    }
}
