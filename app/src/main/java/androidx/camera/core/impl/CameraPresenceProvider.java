package androidx.camera.core.impl;

import androidx.annotation.GuardedBy;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraPresenceListener;
import androidx.camera.core.CameraState;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraPresenceProvider {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "CameraPresencePrvdr";
    private final Executor backgroundExecutor;
    private CameraFactory cameraFactory;
    private CameraRepository cameraRepository;

    @GuardedBy("observerLock")
    private final Map<String, Observer<CameraState>> cameraStateObservers;
    private volatile List<CameraIdentifier> currentFilteredIds;
    private final CopyOnWriteArrayList<InternalCameraPresenceListener> dependentInternalListeners;
    private final AtomicBoolean isMonitoring;
    private final Object observerLock;
    private final CopyOnWriteArrayList<ListenerWrapper> publicApiListeners;
    private final SourceObservableObserver sourceObserver;
    private Observable<List<CameraIdentifier>> sourcePresenceObservable;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ListenerWrapper {
        private final Executor executor;
        private final CameraPresenceListener listener;

        public ListenerWrapper(CameraPresenceListener listener, Executor executor) {
            kotlin.jvm.internal.k.e(listener, "listener");
            kotlin.jvm.internal.k.e(executor, "executor");
            this.listener = listener;
            this.executor = executor;
        }

        public static /* synthetic */ ListenerWrapper copy$default(ListenerWrapper listenerWrapper, CameraPresenceListener cameraPresenceListener, Executor executor, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                cameraPresenceListener = listenerWrapper.listener;
            }
            if ((i2 & 2) != 0) {
                executor = listenerWrapper.executor;
            }
            return listenerWrapper.copy(cameraPresenceListener, executor);
        }

        public final CameraPresenceListener component1() {
            return this.listener;
        }

        public final Executor component2() {
            return this.executor;
        }

        public final ListenerWrapper copy(CameraPresenceListener listener, Executor executor) {
            kotlin.jvm.internal.k.e(listener, "listener");
            kotlin.jvm.internal.k.e(executor, "executor");
            return new ListenerWrapper(listener, executor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerWrapper)) {
                return false;
            }
            ListenerWrapper listenerWrapper = (ListenerWrapper) obj;
            return kotlin.jvm.internal.k.a(this.listener, listenerWrapper.listener) && kotlin.jvm.internal.k.a(this.executor, listenerWrapper.executor);
        }

        public final Executor getExecutor() {
            return this.executor;
        }

        public final CameraPresenceListener getListener() {
            return this.listener;
        }

        public int hashCode() {
            return this.executor.hashCode() + (this.listener.hashCode() * 31);
        }

        public String toString() {
            return "ListenerWrapper(listener=" + this.listener + ", executor=" + this.executor + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class SourceObservableObserver implements Observable.Observer<List<? extends CameraIdentifier>> {
        public SourceObservableObserver() {
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public void onError(Throwable t3) {
            kotlin.jvm.internal.k.e(t3, "t");
            if (CameraPresenceProvider.this.isMonitoring.get()) {
                Logger.e(CameraPresenceProvider.TAG, "Error from source camera presence observable. Triggering refresh.", t3);
                Observable observable = CameraPresenceProvider.this.sourcePresenceObservable;
                if (observable != null) {
                    observable.fetchData();
                }
            }
        }

        @Override // androidx.camera.core.impl.Observable.Observer
        public /* bridge */ /* synthetic */ void onNewData(List<? extends CameraIdentifier> list) {
            onNewData2((List<CameraIdentifier>) list);
        }

        /* JADX INFO: renamed from: onNewData, reason: avoid collision after fix types in other method */
        public void onNewData2(List<CameraIdentifier> list) {
            CameraFactory cameraFactory;
            List<String> arrayList;
            if (CameraPresenceProvider.this.isMonitoring.get() && (cameraFactory = CameraPresenceProvider.this.cameraFactory) != null) {
                if (list != null) {
                    arrayList = new ArrayList<>(r5.n.L0(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((CameraIdentifier) it.next()).getInternalId());
                    }
                } else {
                    arrayList = r5.r.f13638a;
                }
                try {
                    cameraFactory.onCameraIdsUpdated(arrayList);
                    Set<String> availableCameraIds = cameraFactory.getAvailableCameraIds();
                    kotlin.jvm.internal.k.d(availableCameraIds, "getAvailableCameraIds(...)");
                    ArrayList arrayList2 = new ArrayList(r5.n.L0(availableCameraIds, 10));
                    for (String str : availableCameraIds) {
                        CameraIdentifier.Companion companion = CameraIdentifier.Companion;
                        kotlin.jvm.internal.k.b(str);
                        arrayList2.add(CameraIdentifier.Companion.create$default(companion, str, null, null, 6, null));
                    }
                    CameraPresenceProvider.this.processFilteredCameraIdUpdate(arrayList2);
                } catch (Exception e) {
                    Logger.e(CameraPresenceProvider.TAG, "CameraFactory failed to update. Triggering refresh.", e);
                    Observable observable = CameraPresenceProvider.this.sourcePresenceObservable;
                    if (observable != null) {
                        observable.fetchData();
                    }
                }
            }
        }
    }

    public CameraPresenceProvider(Executor backgroundExecutor) {
        kotlin.jvm.internal.k.e(backgroundExecutor, "backgroundExecutor");
        this.backgroundExecutor = backgroundExecutor;
        this.observerLock = new Object();
        this.sourceObserver = new SourceObservableObserver();
        this.currentFilteredIds = r5.r.f13638a;
        this.isMonitoring = new AtomicBoolean(false);
        this.dependentInternalListeners = new CopyOnWriteArrayList<>();
        this.publicApiListeners = new CopyOnWriteArrayList<>();
        this.cameraStateObservers = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addCameraPresenceListener$lambda$20(CameraPresenceProvider cameraPresenceProvider, CameraPresenceListener cameraPresenceListener) {
        Set<CameraIdentifier> setR1 = r5.l.r1(cameraPresenceProvider.currentFilteredIds);
        if (setR1.isEmpty()) {
            return;
        }
        cameraPresenceListener.onCamerasAdded(setR1);
    }

    private final void clearAllCameraStateObservers() {
        synchronized (this.observerLock) {
            if (this.cameraStateObservers.isEmpty()) {
                return;
            }
            Map mapN0 = r5.x.n0(this.cameraStateObservers);
            this.cameraStateObservers.clear();
            CameraRepository cameraRepository = this.cameraRepository;
            if (cameraRepository != null) {
                LinkedHashSet<CameraInternal> cameras = cameraRepository.getCameras();
                kotlin.jvm.internal.k.d(cameras, "getCameras(...)");
                ArrayList arrayList = new ArrayList(r5.n.L0(cameras, 10));
                Iterator<T> it = cameras.iterator();
                while (it.hasNext()) {
                    arrayList.add(((CameraInternal) it.next()).getCameraInfoInternal());
                }
                Logger.d(TAG, "Clearing all " + mapN0.size() + " state observers.");
                ArrayList arrayList2 = new ArrayList(mapN0.size());
                for (Map.Entry entry : mapN0.entrySet()) {
                    CameraXExecutors.mainThreadExecutor().execute(new a(arrayList, (Observer) entry.getValue(), (String) entry.getKey(), 2));
                    arrayList2.add(q5.x.f13520a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearAllCameraStateObservers$lambda$19$lambda$18(List list, Observer observer, String str) {
        Object next;
        LiveData<CameraState> cameraState;
        try {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (kotlin.jvm.internal.k.a(((CameraInfoInternal) next).getCameraId(), str)) {
                        break;
                    }
                }
            }
            CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) next;
            if (cameraInfoInternal == null || (cameraState = cameraInfoInternal.getCameraState()) == null) {
                return;
            }
            cameraState.removeObserver(observer);
        } catch (IllegalArgumentException unused) {
        }
    }

    private final void conditionallySetupCameraStateObserver(String str) {
        CameraRepository cameraRepository = this.cameraRepository;
        if (cameraRepository == null) {
            return;
        }
        try {
            CameraInternal camera = cameraRepository.getCamera(str);
            kotlin.jvm.internal.k.d(camera, "getCamera(...)");
            CameraInfoInternal cameraInfoInternal = camera.getCameraInfoInternal();
            kotlin.jvm.internal.k.d(cameraInfoInternal, "getCameraInfoInternal(...)");
            setupCameraStateObserver(cameraInfoInternal);
        } catch (IllegalArgumentException unused) {
            Logger.w(TAG, "CameraInternal not found for " + str + ". Cannot setup state observer.");
        }
    }

    private final void notifyPublicCamerasAdded(Set<CameraIdentifier> set) {
        for (ListenerWrapper listenerWrapper : this.publicApiListeners) {
            listenerWrapper.getExecutor().execute(new m(listenerWrapper, set, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyPublicCamerasAdded$lambda$23$lambda$22(ListenerWrapper listenerWrapper, Set set) {
        listenerWrapper.getListener().onCamerasAdded(set);
    }

    private final void notifyPublicCamerasRemoved(Set<CameraIdentifier> set) {
        for (ListenerWrapper listenerWrapper : this.publicApiListeners) {
            listenerWrapper.getExecutor().execute(new m(listenerWrapper, set, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyPublicCamerasRemoved$lambda$25$lambda$24(ListenerWrapper listenerWrapper, Set set) {
        listenerWrapper.getListener().onCamerasRemoved(set);
    }

    private final void notifyPublicListeners(Set<CameraIdentifier> set, Set<CameraIdentifier> set2) {
        if (!set.isEmpty()) {
            Logger.i(TAG, "Notifying " + set.size() + " cameras added.");
            notifyPublicCamerasAdded(set);
        }
        if (set2.isEmpty()) {
            return;
        }
        Logger.i(TAG, "Notifying " + set2.size() + " cameras removed.");
        notifyPublicCamerasRemoved(set2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processFilteredCameraIdUpdate(List<CameraIdentifier> list) {
        List listN1 = r5.l.n1(this.currentFilteredIds);
        if (kotlin.jvm.internal.k.a(list, listN1)) {
            return;
        }
        Set setR1 = r5.l.r1(listN1);
        Set setR12 = r5.l.r1(list);
        Set<CameraIdentifier> setE = n7.b.E(setR12, setR1);
        Set<CameraIdentifier> setE2 = n7.b.E(setR1, setR12);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(r5.n.L0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((CameraIdentifier) it.next()).getInternalId());
        }
        try {
            Iterator<T> it2 = setE2.iterator();
            while (it2.hasNext()) {
                removeCameraStateObserver(((CameraIdentifier) it2.next()).getInternalId());
            }
            CameraRepository cameraRepository = this.cameraRepository;
            if (cameraRepository != null) {
                Logger.d(TAG, "Updating CameraRepository...");
                cameraRepository.onCamerasUpdated(arrayList2);
                arrayList.add(cameraRepository);
                Logger.d(TAG, "CameraRepository updated successfully.");
            }
            if (!this.dependentInternalListeners.isEmpty()) {
                Logger.d(TAG, "Updating " + this.dependentInternalListeners.size() + " dependent listeners...");
                for (InternalCameraPresenceListener internalCameraPresenceListener : this.dependentInternalListeners) {
                    internalCameraPresenceListener.onCamerasUpdated(arrayList2);
                    arrayList.add(internalCameraPresenceListener);
                }
            }
            this.currentFilteredIds = list;
            Iterator<T> it3 = setE.iterator();
            while (it3.hasNext()) {
                conditionallySetupCameraStateObserver(((CameraIdentifier) it3.next()).getInternalId());
            }
            notifyPublicListeners(setE, setE2);
        } catch (Exception e) {
            Logger.e(TAG, "A core module failed to update. Rolling back changes.", e);
            ArrayList arrayList3 = new ArrayList(r5.n.L0(listN1, 10));
            Iterator it4 = listN1.iterator();
            while (it4.hasNext()) {
                arrayList3.add(((CameraIdentifier) it4.next()).getInternalId());
            }
            Iterator it5 = new r5.z(arrayList).iterator();
            while (true) {
                r5.y yVar = (r5.y) it5;
                if (!yVar.f13643a.hasPrevious()) {
                    break;
                }
                InternalCameraPresenceListener internalCameraPresenceListener2 = (InternalCameraPresenceListener) yVar.f13643a.previous();
                try {
                    internalCameraPresenceListener2.onCamerasUpdated(arrayList3);
                } catch (Exception e4) {
                    Logger.e(TAG, "Failed to rollback listener: " + internalCameraPresenceListener2, e4);
                }
            }
            Iterator<T> it6 = setE2.iterator();
            while (it6.hasNext()) {
                conditionallySetupCameraStateObserver(((CameraIdentifier) it6.next()).getInternalId());
            }
            Iterator<T> it7 = setE.iterator();
            while (it7.hasNext()) {
                removeCameraStateObserver(((CameraIdentifier) it7.next()).getInternalId());
            }
        }
    }

    private static final boolean removeCameraPresenceListener$lambda$21(CameraPresenceListener cameraPresenceListener, ListenerWrapper listenerWrapper) {
        return kotlin.jvm.internal.k.a(listenerWrapper.getListener(), cameraPresenceListener);
    }

    private final void removeCameraStateObserver(String str) {
        synchronized (this.observerLock) {
            Observer<CameraState> observerRemove = this.cameraStateObservers.remove(str);
            CameraRepository cameraRepository = this.cameraRepository;
            if (observerRemove != null && cameraRepository != null) {
                try {
                    CameraInternal camera = cameraRepository.getCamera(str);
                    kotlin.jvm.internal.k.d(camera, "getCamera(...)");
                    CameraXExecutors.mainThreadExecutor().execute(new u(2, camera, observerRemove));
                    Logger.d(TAG, "Removed state observer for: " + str);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeCameraStateObserver$lambda$14$lambda$13(CameraInternal cameraInternal, Observer observer) {
        cameraInternal.getCameraInfoInternal().getCameraState().removeObserver(observer);
    }

    private final void setupCameraStateObserver(CameraInfoInternal cameraInfoInternal) {
        final String cameraId = cameraInfoInternal.getCameraId();
        kotlin.jvm.internal.k.d(cameraId, "getCameraId(...)");
        if (this.isMonitoring.get()) {
            synchronized (this.observerLock) {
                if (this.cameraStateObservers.containsKey(cameraId)) {
                    return;
                }
                Observer<CameraState> observer = new Observer() { // from class: androidx.camera.core.impl.n
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        CameraPresenceProvider.setupCameraStateObserver$lambda$12$lambda$10(this.f3619a, cameraId, (CameraState) obj);
                    }
                };
                CameraXExecutors.mainThreadExecutor().execute(new u(4, cameraInfoInternal, observer));
                this.cameraStateObservers.put(cameraId, observer);
                Logger.d(TAG, "Registered state observer for camera: ".concat(cameraId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCameraStateObserver$lambda$12$lambda$10(CameraPresenceProvider cameraPresenceProvider, String str, CameraState cameraState) {
        if (!cameraPresenceProvider.isMonitoring.get()) {
            Logger.d(TAG, "Ignore camera state change handling since already stop monitoring");
            return;
        }
        if ((cameraState != null ? cameraState.getError() : null) == null) {
            if ((cameraState != null ? cameraState.getType() : null) != CameraState.Type.CLOSED) {
                return;
            }
        }
        StringBuilder sbY = a1.a.y("Camera ", str, " state changed to ");
        sbY.append(cameraState.getType());
        sbY.append(" with error: ");
        CameraState.StateError error = cameraState.getError();
        sbY.append(error != null ? Integer.valueOf(error.getCode()) : null);
        sbY.append(". Triggering refresh.");
        Logger.w(TAG, sbY.toString());
        Observable<List<CameraIdentifier>> observable = cameraPresenceProvider.sourcePresenceObservable;
        if (observable != null) {
            observable.fetchData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCameraStateObserver$lambda$12$lambda$11(CameraInfoInternal cameraInfoInternal, Observer observer) {
        cameraInfoInternal.getCameraState().observeForever(observer);
    }

    public final void addCameraPresenceListener(CameraPresenceListener listener, Executor executor) {
        kotlin.jvm.internal.k.e(listener, "listener");
        kotlin.jvm.internal.k.e(executor, "executor");
        this.publicApiListeners.add(new ListenerWrapper(listener, executor));
        executor.execute(new u(3, this, listener));
    }

    public final void addDependentInternalListener(InternalCameraPresenceListener listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        this.dependentInternalListeners.add(listener);
    }

    public final void removeCameraPresenceListener(CameraPresenceListener listener) {
        int iG0;
        kotlin.jvm.internal.k.e(listener, "listener");
        CopyOnWriteArrayList<ListenerWrapper> copyOnWriteArrayList = this.publicApiListeners;
        kotlin.jvm.internal.k.e(copyOnWriteArrayList, "<this>");
        int iG02 = r5.m.G0(copyOnWriteArrayList);
        int i2 = 0;
        if (iG02 >= 0) {
            int i8 = 0;
            while (true) {
                ListenerWrapper listenerWrapper = copyOnWriteArrayList.get(i2);
                if (!removeCameraPresenceListener$lambda$21(listener, listenerWrapper)) {
                    if (i8 != i2) {
                        copyOnWriteArrayList.set(i8, listenerWrapper);
                    }
                    i8++;
                }
                if (i2 == iG02) {
                    break;
                } else {
                    i2++;
                }
            }
            i2 = i8;
        }
        if (i2 >= copyOnWriteArrayList.size() || i2 > (iG0 = r5.m.G0(copyOnWriteArrayList))) {
            return;
        }
        while (true) {
            copyOnWriteArrayList.remove(iG0);
            if (iG0 == i2) {
                return;
            } else {
                iG0--;
            }
        }
    }

    public final void removeDependentInternalListener(InternalCameraPresenceListener listener) {
        kotlin.jvm.internal.k.e(listener, "listener");
        this.dependentInternalListeners.remove(listener);
    }

    public final void shutdown() {
        if (!this.isMonitoring.getAndSet(false)) {
            Logger.d(TAG, "Shutdown called when not monitoring. Ignoring.");
            return;
        }
        Logger.i(TAG, "Shutting down CameraPresenceProvider monitoring.");
        Observable<List<CameraIdentifier>> observable = this.sourcePresenceObservable;
        if (observable != null) {
            observable.removeObserver(this.sourceObserver);
        }
        clearAllCameraStateObservers();
        this.dependentInternalListeners.clear();
        this.publicApiListeners.clear();
        this.currentFilteredIds = r5.r.f13638a;
        this.cameraFactory = null;
        this.cameraRepository = null;
    }

    public final void startup(CameraFactory cameraFactory, CameraRepository cameraRepository) {
        kotlin.jvm.internal.k.e(cameraFactory, "cameraFactory");
        kotlin.jvm.internal.k.e(cameraRepository, "cameraRepository");
        if (this.isMonitoring.compareAndSet(false, true)) {
            Logger.i(TAG, "Starting CameraPresenceProvider monitoring.");
            Set<String> availableCameraIds = cameraFactory.getAvailableCameraIds();
            kotlin.jvm.internal.k.d(availableCameraIds, "getAvailableCameraIds(...)");
            ArrayList arrayList = new ArrayList(r5.n.L0(availableCameraIds, 10));
            for (String str : availableCameraIds) {
                CameraIdentifier.Companion companion = CameraIdentifier.Companion;
                kotlin.jvm.internal.k.b(str);
                arrayList.add(CameraIdentifier.Companion.create$default(companion, str, null, null, 6, null));
            }
            this.currentFilteredIds = arrayList;
            this.cameraFactory = cameraFactory;
            this.cameraRepository = cameraRepository;
            Observable<List<CameraIdentifier>> cameraPresenceSource = cameraFactory.getCameraPresenceSource();
            this.sourcePresenceObservable = cameraPresenceSource;
            if (cameraPresenceSource != null) {
                cameraPresenceSource.addObserver(this.backgroundExecutor, this.sourceObserver);
            }
        }
    }
}
