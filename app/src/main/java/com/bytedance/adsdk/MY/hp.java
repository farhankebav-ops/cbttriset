package com.bytedance.adsdk.MY;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp<T> {
    public static Executor IlO = Executors.newCachedThreadPool();
    private volatile rp<T> Cc;
    private final Set<EV<Throwable>> EO;
    private final Set<EV<T>> MY;
    private final Handler tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO extends FutureTask<rp<T>> {
        public IlO(Callable<rp<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                hp.this.IlO((rp) get());
            } catch (InterruptedException | ExecutionException e) {
                hp.this.IlO(new rp(e));
            }
        }
    }

    public hp(Callable<rp<T>> callable) {
        this(callable, false);
    }

    public synchronized hp<T> EO(EV<Throwable> ev) {
        try {
            rp<T> rpVar = this.Cc;
            if (rpVar != null && rpVar.MY() != null) {
                ev.IlO(rpVar.MY());
            }
            this.EO.add(ev);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized hp<T> MY(EV<T> ev) {
        this.MY.remove(ev);
        return this;
    }

    public synchronized hp<T> tV(EV<Throwable> ev) {
        this.EO.remove(ev);
        return this;
    }

    public hp(Callable<rp<T>> callable, boolean z2) {
        this.MY = new LinkedHashSet(1);
        this.EO = new LinkedHashSet(1);
        this.tV = new Handler(Looper.getMainLooper());
        this.Cc = null;
        if (!z2) {
            IlO.execute(new IlO(callable));
            return;
        }
        try {
            IlO((rp) callable.call());
        } catch (Throwable th) {
            IlO((rp) new rp<>(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(rp<T> rpVar) {
        if (this.Cc == null) {
            this.Cc = rpVar;
            IlO();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized hp<T> IlO(EV<T> ev) {
        try {
            rp<T> rpVar = this.Cc;
            if (rpVar != null && rpVar.IlO() != null) {
                ev.IlO(rpVar.IlO());
            }
            this.MY.add(ev);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    private void IlO() {
        this.tV.post(new Runnable() { // from class: com.bytedance.adsdk.MY.hp.1
            @Override // java.lang.Runnable
            public void run() {
                rp rpVar = hp.this.Cc;
                if (rpVar == null) {
                    return;
                }
                if (rpVar.IlO() != null) {
                    hp.this.IlO(rpVar.IlO());
                } else {
                    hp.this.IlO(rpVar.MY());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IlO(T t3) {
        ArrayList arrayList = new ArrayList(this.MY);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((EV) obj).IlO(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IlO(Throwable th) {
        ArrayList arrayList = new ArrayList(this.EO);
        if (arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((EV) obj).IlO(th);
        }
    }
}
