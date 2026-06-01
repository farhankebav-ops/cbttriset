package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import e6.l;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import l6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {
    private final c clazz;
    private final l initializer;

    public ViewModelInitializer(c clazz, l initializer) {
        k.e(clazz, "clazz");
        k.e(initializer, "initializer");
        this.clazz = clazz;
        this.initializer = initializer;
    }

    public final c getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    public final l getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelInitializer(Class<T> clazz, l initializer) {
        this(b0.a(clazz), initializer);
        k.e(clazz, "clazz");
        k.e(initializer, "initializer");
    }
}
