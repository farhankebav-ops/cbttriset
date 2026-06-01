package androidx.core.view;

import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends kotlin.jvm.internal.j implements e6.l {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // e6.l
    public final ViewParent invoke(ViewParent viewParent) {
        return viewParent.getParent();
    }
}
