package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4014b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f4013a = i2;
        this.f4014b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.f4013a) {
            case 0:
                return ((FragmentActivity) this.f4014b).lambda$init$0();
            case 1:
                return ((FragmentManager) this.f4014b).lambda$attachController$4();
            default:
                return SavedStateHandleImpl.savedStateProvider$lambda$0((SavedStateHandleImpl) this.f4014b);
        }
    }
}
