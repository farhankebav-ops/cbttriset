package o5;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import l5.c;
import l5.d;
import l5.e;
import s4.l;
import s4.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends l implements m {
    public static final Object[] g = new Object[0];
    public static final a[] h = new a[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a[] f13199i = new a[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f13200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f13201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lock f13202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lock f13203d;
    public final AtomicReference e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f13204f;

    public b() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f13202c = reentrantReadWriteLock.readLock();
        this.f13203d = reentrantReadWriteLock.writeLock();
        this.f13201b = new AtomicReference(h);
        this.f13200a = new AtomicReference();
        this.e = new AtomicReference();
    }

    @Override // s4.m
    public final void a(u4.b bVar) {
        if (this.e.get() != null) {
            bVar.dispose();
        }
    }

    @Override // s4.m
    public final void b(Object obj) {
        z4.b.a(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.e.get() != null) {
            return;
        }
        Lock lock = this.f13203d;
        lock.lock();
        this.f13204f++;
        this.f13200a.lazySet(obj);
        lock.unlock();
        for (a aVar : (a[]) this.f13201b.get()) {
            aVar.b(obj, this.f13204f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s4.l
    public final void d(m mVar) {
        a aVar = new a(mVar, this);
        mVar.a(aVar);
        AtomicReference atomicReference = this.f13201b;
        while (true) {
            a[] aVarArr = (a[]) atomicReference.get();
            if (aVarArr == f13199i) {
                Throwable th = (Throwable) this.e.get();
                if (th == c.f12823a) {
                    mVar.onComplete();
                    return;
                } else {
                    mVar.onError(th);
                    return;
                }
            }
            int length = aVarArr.length;
            a[] aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
            while (!atomicReference.compareAndSet(aVarArr, aVarArr2)) {
                if (atomicReference.get() != aVarArr) {
                    break;
                }
            }
            if (aVar.g) {
                e(aVar);
                return;
            }
            if (aVar.g) {
                return;
            }
            synchronized (aVar) {
                try {
                    if (aVar.g) {
                        return;
                    }
                    if (aVar.f13196c) {
                        return;
                    }
                    b bVar = aVar.f13195b;
                    Lock lock = bVar.f13202c;
                    lock.lock();
                    aVar.h = bVar.f13204f;
                    Object obj = bVar.f13200a.get();
                    lock.unlock();
                    aVar.f13197d = obj != null;
                    aVar.f13196c = true;
                    if (obj == null || aVar.test(obj)) {
                        return;
                    }
                    aVar.a();
                    return;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(a aVar) {
        a[] aVarArr;
        while (true) {
            AtomicReference atomicReference = this.f13201b;
            a[] aVarArr2 = (a[]) atomicReference.get();
            int length = aVarArr2.length;
            if (length == 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                } else if (aVarArr2[i2] == aVar) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr = h;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr2, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr2, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr = aVarArr3;
            }
            while (!atomicReference.compareAndSet(aVarArr2, aVarArr)) {
                if (atomicReference.get() != aVarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // s4.m
    public final void onComplete() {
        AtomicReference atomicReference;
        j2.b bVar = c.f12823a;
        do {
            atomicReference = this.e;
            if (atomicReference.compareAndSet(null, bVar)) {
                AtomicReference atomicReference2 = this.f13201b;
                a[] aVarArr = f13199i;
                a[] aVarArr2 = (a[]) atomicReference2.getAndSet(aVarArr);
                e eVar = e.f12825a;
                if (aVarArr2 != aVarArr) {
                    Lock lock = this.f13203d;
                    lock.lock();
                    this.f13204f++;
                    this.f13200a.lazySet(eVar);
                    lock.unlock();
                }
                for (a aVar : aVarArr2) {
                    aVar.b(eVar, this.f13204f);
                }
                return;
            }
        } while (atomicReference.get() == null);
    }

    @Override // s4.m
    public final void onError(Throwable th) {
        AtomicReference atomicReference;
        z4.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        do {
            atomicReference = this.e;
            if (atomicReference.compareAndSet(null, th)) {
                d dVar = new d(th);
                AtomicReference atomicReference2 = this.f13201b;
                a[] aVarArr = f13199i;
                a[] aVarArr2 = (a[]) atomicReference2.getAndSet(aVarArr);
                if (aVarArr2 != aVarArr) {
                    Lock lock = this.f13203d;
                    lock.lock();
                    this.f13204f++;
                    this.f13200a.lazySet(dVar);
                    lock.unlock();
                }
                for (a aVar : aVarArr2) {
                    aVar.b(dVar, this.f13204f);
                }
                return;
            }
        } while (atomicReference.get() == null);
        n7.b.F(th);
    }
}
