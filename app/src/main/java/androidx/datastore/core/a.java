package androidx.datastore.core;

import androidx.datastore.core.MulticastFileObserver;
import e6.l;
import q6.o0;
import r6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3992c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f3990a = i2;
        this.f3991b = obj;
        this.f3992c = obj2;
    }

    @Override // q6.o0
    public final void dispose() {
        switch (this.f3990a) {
            case 0:
                MulticastFileObserver.Companion.observe$lambda$4((String) this.f3991b, (l) this.f3992c);
                break;
            default:
                c cVar = (c) this.f3991b;
                cVar.f13646a.removeCallbacks((Runnable) this.f3992c);
                break;
        }
    }
}
