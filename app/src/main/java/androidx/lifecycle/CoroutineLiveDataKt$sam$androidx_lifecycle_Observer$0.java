package androidx.lifecycle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0 implements Observer, kotlin.jvm.internal.g {
    private final /* synthetic */ e6.l function;

    public CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(e6.l function) {
        kotlin.jvm.internal.k.e(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.g)) {
            return kotlin.jvm.internal.k.a(getFunctionDelegate(), ((kotlin.jvm.internal.g) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.g
    public final q5.c getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
