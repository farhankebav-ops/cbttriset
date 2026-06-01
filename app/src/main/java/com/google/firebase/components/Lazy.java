package com.google.firebase.components;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance;
    private volatile Provider<T> provider;

    public Lazy(T t3) {
        this.instance = UNINITIALIZED;
        this.instance = t3;
    }

    @Override // com.google.firebase.inject.Provider
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
                    t3 = this.provider.get();
                    this.instance = t3;
                    this.provider = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t3;
    }

    @VisibleForTesting
    public boolean isInitialized() {
        return this.instance != UNINITIALIZED;
    }

    public Lazy(Provider<T> provider) {
        this.instance = UNINITIALIZED;
        this.provider = provider;
    }
}
