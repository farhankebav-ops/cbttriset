package androidx.camera.core.impl;

import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.impl.Observable;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractCameraPresenceSource implements Observable<List<CameraIdentifier>> {
    private static final String TAG = "CameraPresenceSrc";

    @GuardedBy("mLock")
    private List<CameraIdentifier> mCurrentData;

    @GuardedBy("mLock")
    private Throwable mCurrentError;

    @GuardedBy("mLock")
    private boolean mIsActive;
    private final Object mLock;
    private final List<ObserverWrapper> mObservers;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ObserverWrapper {
        final Executor mExecutor;
        final Observable.Observer<? super List<CameraIdentifier>> mObserver;

        public ObserverWrapper(Executor executor, Observable.Observer<? super List<CameraIdentifier>> observer) {
            this.mExecutor = executor;
            this.mObserver = observer;
        }
    }

    public AbstractCameraPresenceSource() {
        this(Collections.EMPTY_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyObserver$0(Throwable th, ObserverWrapper observerWrapper, List list) {
        if (th != null) {
            observerWrapper.mObserver.onError(th);
        } else {
            observerWrapper.mObserver.onNewData(list);
        }
    }

    private void notifyObserver(ObserverWrapper observerWrapper, List<CameraIdentifier> list, Throwable th) {
        observerWrapper.mExecutor.execute(new a(th, observerWrapper, list, 0));
    }

    private void updateState(List<CameraIdentifier> list, Throwable th) {
        boolean z2;
        List<CameraIdentifier> listUnmodifiableList;
        Throwable th2;
        synchronized (this.mLock) {
            try {
                if (th != null) {
                    z2 = this.mCurrentError == null || !this.mCurrentData.isEmpty();
                    this.mCurrentError = th;
                    this.mCurrentData = Collections.EMPTY_LIST;
                } else {
                    Preconditions.checkNotNull(list);
                    boolean z7 = (this.mCurrentError == null && this.mCurrentData.equals(list)) ? false : true;
                    this.mCurrentError = null;
                    this.mCurrentData = list;
                    z2 = z7;
                }
                listUnmodifiableList = Collections.unmodifiableList(this.mCurrentData);
                th2 = this.mCurrentError;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (z2) {
            StringBuilder sb = new StringBuilder("Data changed. Notifying ");
            sb.append(this.mObservers.size());
            sb.append(" observers. Error: ");
            sb.append(th2 != null);
            Log.d(TAG, sb.toString());
            Iterator<ObserverWrapper> it = this.mObservers.iterator();
            while (it.hasNext()) {
                notifyObserver(it.next(), listUnmodifiableList, th2);
            }
        }
    }

    @Override // androidx.camera.core.impl.Observable
    public void addObserver(Executor executor, Observable.Observer<? super List<CameraIdentifier>> observer) {
        List<CameraIdentifier> listUnmodifiableList;
        Throwable th;
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(observer);
        this.mObservers.add(new ObserverWrapper(executor, observer));
        synchronized (this.mLock) {
            try {
                if (!this.mIsActive && !this.mObservers.isEmpty()) {
                    Log.i(TAG, "First observer added. Starting monitoring.");
                    this.mIsActive = true;
                    startMonitoring();
                }
                listUnmodifiableList = Collections.unmodifiableList(this.mCurrentData);
                th = this.mCurrentError;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        notifyObserver(new ObserverWrapper(executor, observer), listUnmodifiableList, th);
    }

    @Override // androidx.camera.core.impl.Observable
    public abstract j2.q fetchData();

    @Override // androidx.camera.core.impl.Observable
    public void removeObserver(Observable.Observer<? super List<CameraIdentifier>> observer) {
        ObserverWrapper next;
        Preconditions.checkNotNull(observer);
        Iterator<ObserverWrapper> it = this.mObservers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next.mObserver.equals(observer)) {
                    break;
                }
            }
        }
        if (next != null) {
            this.mObservers.remove(next);
        }
        synchronized (this.mLock) {
            try {
                if (this.mIsActive && this.mObservers.isEmpty()) {
                    Log.i(TAG, "Last observer removed. Stopping monitoring.");
                    this.mIsActive = false;
                    stopMonitoring();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void startMonitoring();

    public abstract void stopMonitoring();

    public void updateData(List<CameraIdentifier> list) {
        updateState(list, null);
    }

    public void updateError(Throwable th) {
        updateState(null, th);
    }

    public AbstractCameraPresenceSource(List<String> list) {
        this.mLock = new Object();
        this.mObservers = new CopyOnWriteArrayList();
        this.mCurrentError = null;
        this.mIsActive = false;
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CameraIdentifier.create(it.next()));
        }
        this.mCurrentData = arrayList;
    }
}
