package androidx.fragment.app;

import android.content.Intent;
import android.content.res.Configuration;
import androidx.core.util.Consumer;
import androidx.work.InitializationExceptionHandler;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4016b;

    public /* synthetic */ e(Object obj, int i2) {
        this.f4015a = i2;
        this.f4016b = obj;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.f4015a) {
            case 0:
                ((FragmentActivity) this.f4016b).lambda$init$1((Configuration) obj);
                break;
            case 1:
                ((FragmentActivity) this.f4016b).lambda$init$2((Intent) obj);
                break;
            default:
                ((InitializationExceptionHandler) this.f4016b).handleException((Throwable) obj);
                break;
        }
    }
}
