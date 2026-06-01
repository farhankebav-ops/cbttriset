package e5;

import com.google.android.gms.tasks.Task;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends s4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11263b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f11262a = i2;
        this.f11263b = obj;
    }

    @Override // s4.h
    public final void c(s4.j jVar) {
        switch (this.f11262a) {
            case 0:
                c cVar = new c(jVar);
                jVar.a(cVar);
                try {
                    com.google.firebase.inappmessaging.internal.a aVar = (com.google.firebase.inappmessaging.internal.a) this.f11263b;
                    InAppMessageStreamManager.lambda$taskToMaybe$30((Task) aVar.f5619b, (Executor) aVar.f5620c, cVar);
                } catch (Throwable th) {
                    r2.q.y0(th);
                    cVar.onError(th);
                    return;
                }
                break;
            default:
                ((s4.a) ((s4.c) this.f11263b)).d(new m(jVar, 0));
                break;
        }
    }
}
