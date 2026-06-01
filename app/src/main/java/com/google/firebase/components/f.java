package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.inject.Provider;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5527c;

    public /* synthetic */ f(int i2, Object obj, Object obj2) {
        this.f5525a = i2;
        this.f5527c = obj;
        this.f5526b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5525a) {
            case 0:
                ((OptionalProvider) this.f5527c).set((Provider) this.f5526b);
                break;
            case 1:
                ((LazySet) this.f5527c).add((Provider) this.f5526b);
                break;
            default:
                EventBus.lambda$publish$0((Map.Entry) this.f5527c, (Event) this.f5526b);
                break;
        }
    }
}
