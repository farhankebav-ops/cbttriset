package androidx.lifecycle;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.Transformations;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements e6.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f4036b;

    public /* synthetic */ c(MediatorLiveData mediatorLiveData, int i2) {
        this.f4035a = i2;
        this.f4036b = mediatorLiveData;
    }

    @Override // e6.l
    public final Object invoke(Object obj) {
        switch (this.f4035a) {
            case 0:
                return CoroutineLiveDataKt.AnonymousClass2.invokeSuspend$lambda$0(this.f4036b, obj);
            case 1:
                return Transformations.switchMap$lambda$3$lambda$2(this.f4036b, obj);
            default:
                return Transformations.AnonymousClass2.onChanged$lambda$0(this.f4036b, obj);
        }
    }
}
