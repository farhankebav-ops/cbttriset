package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.jvm.internal.w;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements e6.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f4050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4051c;

    public /* synthetic */ m(MediatorLiveData mediatorLiveData, Object obj, int i2) {
        this.f4049a = i2;
        this.f4050b = mediatorLiveData;
        this.f4051c = obj;
    }

    @Override // e6.l
    public final Object invoke(Object obj) {
        switch (this.f4049a) {
            case 0:
                return Transformations.map$lambda$0(this.f4050b, (e6.l) this.f4051c, obj);
            case 1:
                return Transformations.distinctUntilChanged$lambda$4(this.f4050b, (w) this.f4051c, obj);
            default:
                return Transformations.map$lambda$1(this.f4050b, (Function) this.f4051c, obj);
        }
    }
}
