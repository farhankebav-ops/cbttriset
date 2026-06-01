package j4;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class h0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12236b;

    public /* synthetic */ h0(Object obj, int i2) {
        this.f12235a = i2;
        this.f12236b = obj;
    }

    public abstract void a();

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12235a) {
            case 0:
                i4.q qVar = (i4.q) this.f12236b;
                i4.q qVarA = qVar.a();
                try {
                    b();
                    return;
                } finally {
                    qVar.c(qVarA);
                }
            default:
                k4.c cVar = (k4.c) this.f12236b;
                try {
                    if (cVar.f12622i == null) {
                        throw new IOException("Unable to perform write due to unavailable sink.");
                    }
                    a();
                    return;
                } catch (Exception e) {
                    cVar.f12620d.o(e);
                    return;
                }
        }
    }
}
