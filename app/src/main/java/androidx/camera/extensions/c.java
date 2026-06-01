package androidx.camera.extensions;

import androidx.camera.extensions.internal.VendorExtender;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements VendorExtenderFactory, CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3763a;

    public /* synthetic */ c(Object obj) {
        this.f3763a = obj;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((ExtensionsManager) this.f3763a).lambda$shutdown$1(completer);
    }

    @Override // androidx.camera.extensions.VendorExtenderFactory
    public VendorExtender createVendorExtender(int i2, boolean z2) {
        return ((ExtensionsInfo) this.f3763a).getVendorExtender(i2, z2);
    }
}
