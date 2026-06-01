package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements q5.f {
    private VM cached;
    private final e6.a extrasProducer;
    private final e6.a factoryProducer;
    private final e6.a storeProducer;
    private final l6.c viewModelClass;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(l6.c viewModelClass, e6.a storeProducer, e6.a factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        kotlin.jvm.internal.k.e(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.k.e(storeProducer, "storeProducer");
        kotlin.jvm.internal.k.e(factoryProducer, "factoryProducer");
    }

    @Override // q5.f
    public boolean isInitialized() {
        return this.cached != null;
    }

    public ViewModelLazy(l6.c viewModelClass, e6.a storeProducer, e6.a factoryProducer, e6.a extrasProducer) {
        kotlin.jvm.internal.k.e(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.k.e(storeProducer, "storeProducer");
        kotlin.jvm.internal.k.e(factoryProducer, "factoryProducer");
        kotlin.jvm.internal.k.e(extrasProducer, "extrasProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
        this.extrasProducer = extrasProducer;
    }

    @Override // q5.f
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) ViewModelProvider.Companion.create((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke()).get(this.viewModelClass);
        this.cached = vm2;
        return vm2;
    }

    public /* synthetic */ ViewModelLazy(l6.c cVar, e6.a aVar, e6.a aVar2, e6.a aVar3, int i2, kotlin.jvm.internal.f fVar) {
        this(cVar, aVar, aVar2, (i2 & 8) != 0 ? new androidx.activity.m(2) : aVar3);
    }
}
