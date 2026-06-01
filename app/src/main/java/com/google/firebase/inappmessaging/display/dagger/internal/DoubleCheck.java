package com.google.firebase.inappmessaging.display.dagger.internal;

import com.google.firebase.inappmessaging.display.dagger.Lazy;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p) {
        return p instanceof Lazy ? (Lazy) p : new DoubleCheck((Provider) Preconditions.checkNotNull(p));
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        Preconditions.checkNotNull(p);
        return p instanceof DoubleCheck ? p : new DoubleCheck(p);
    }

    private static Object reentrantCheck(Object obj, Object obj2) {
        if (obj == UNINITIALIZED || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public T get() {
        T t3;
        T t7 = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t7 != obj) {
            return t7;
        }
        synchronized (this) {
            try {
                t3 = (T) this.instance;
                if (t3 == obj) {
                    t3 = (T) this.provider.get();
                    this.instance = reentrantCheck(this.instance, t3);
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t3;
    }

    public static <P extends a, T> Lazy<T> lazy(P p) {
        return lazy(Providers.asDaggerProvider(p));
    }

    @Deprecated
    public static <P extends a, T> a provider(P p) {
        return provider(Providers.asDaggerProvider(p));
    }
}
