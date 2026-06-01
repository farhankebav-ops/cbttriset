package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CameraRepository implements InternalCameraPresenceListener {
    private static final String TAG = "CameraRepository";
    private CameraFactory mCameraFactory;

    @GuardedBy("mCamerasLock")
    private CallbackToFutureAdapter.Completer<Void> mDeinitCompleter;

    @GuardedBy("mCamerasLock")
    private j2.q mDeinitFuture;
    private final Object mCamerasLock = new Object();

    @GuardedBy("mCamerasLock")
    private final Map<String, CameraInternal> mCameras = new LinkedHashMap();

    @GuardedBy("mCamerasLock")
    private final Set<CameraInternal> mReleasingCameras = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$deinit$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mCamerasLock) {
            this.mDeinitCompleter = completer;
        }
        return "CameraRepository-deinit";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deinit$1(CameraInternal cameraInternal) {
        synchronized (this.mCamerasLock) {
            try {
                this.mReleasingCameras.remove(cameraInternal);
                if (this.mReleasingCameras.isEmpty()) {
                    Preconditions.checkNotNull(this.mDeinitCompleter);
                    this.mDeinitCompleter.set(null);
                    this.mDeinitCompleter = null;
                    this.mDeinitFuture = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j2.q deinit() {
        synchronized (this.mCamerasLock) {
            try {
                if (this.mCameras.isEmpty()) {
                    j2.q qVarImmediateFuture = this.mDeinitFuture;
                    if (qVarImmediateFuture == null) {
                        qVarImmediateFuture = Futures.immediateFuture(null);
                    }
                    return qVarImmediateFuture;
                }
                j2.q future = this.mDeinitFuture;
                if (future == null) {
                    future = CallbackToFutureAdapter.getFuture(new b(this, 1));
                    this.mDeinitFuture = future;
                }
                this.mReleasingCameras.addAll(this.mCameras.values());
                for (CameraInternal cameraInternal : this.mCameras.values()) {
                    cameraInternal.release().addListener(new u(5, this, cameraInternal), CameraXExecutors.directExecutor());
                }
                this.mCameras.clear();
                return future;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CameraInternal getCamera(String str) {
        CameraInternal cameraInternal;
        synchronized (this.mCamerasLock) {
            try {
                cameraInternal = this.mCameras.get(str);
                if (cameraInternal == null) {
                    throw new IllegalArgumentException("Invalid camera: " + str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cameraInternal;
    }

    public Set<String> getCameraIds() {
        LinkedHashSet linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet(this.mCameras.keySet());
        }
        return linkedHashSet;
    }

    public LinkedHashSet<CameraInternal> getCameras() {
        LinkedHashSet<CameraInternal> linkedHashSet;
        synchronized (this.mCamerasLock) {
            linkedHashSet = new LinkedHashSet<>(this.mCameras.values());
        }
        return linkedHashSet;
    }

    public void init(CameraFactory cameraFactory) throws InitializationException {
        this.mCameraFactory = cameraFactory;
        synchronized (this.mCamerasLock) {
            try {
                for (String str : cameraFactory.getAvailableCameraIds()) {
                    Logger.d(TAG, "Added camera: " + str);
                    CameraInternal cameraInternalPut = this.mCameras.put(str, cameraFactory.getCamera(str));
                    if (cameraInternalPut != null) {
                        cameraInternalPut.release();
                    }
                }
            } catch (CameraUnavailableException e) {
                throw new InitializationException(e);
            }
        }
    }

    @Override // androidx.camera.core.impl.InternalCameraPresenceListener
    public void onCamerasUpdated(List<String> list) throws CameraUpdateException {
        HashSet<String> hashSet;
        HashMap map = new HashMap();
        synchronized (this.mCamerasLock) {
            hashSet = new HashSet(list);
            hashSet.removeAll(this.mCameras.keySet());
        }
        try {
            for (String str : hashSet) {
                map.put(str, this.mCameraFactory.getCamera(str));
            }
            synchronized (this.mCamerasLock) {
                try {
                    HashSet hashSet2 = new HashSet(this.mCameras.keySet());
                    hashSet2.removeAll(list);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(this.mCameras.get((String) it.next()));
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (String str2 : list) {
                        if (this.mCameras.containsKey(str2)) {
                            linkedHashMap.put(str2, this.mCameras.get(str2));
                        } else {
                            linkedHashMap.put(str2, (CameraInternal) map.get(str2));
                        }
                    }
                    this.mCameras.clear();
                    this.mCameras.putAll(linkedHashMap);
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        CameraInternal cameraInternal = (CameraInternal) obj;
                        if (cameraInternal != null) {
                            cameraInternal.onRemoved();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (CameraUnavailableException e) {
            throw new CameraUpdateException("Failed to create CameraInternal", e);
        }
    }
}
