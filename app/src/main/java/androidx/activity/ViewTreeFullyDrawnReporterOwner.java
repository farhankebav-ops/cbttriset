package androidx.activity;

import android.view.View;
import androidx.core.viewtree.ViewTree;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeFullyDrawnReporterOwner {
    public static final FullyDrawnReporterOwner get(View view) {
        kotlin.jvm.internal.k.e(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(R.id.report_drawn);
            FullyDrawnReporterOwner fullyDrawnReporterOwner = tag instanceof FullyDrawnReporterOwner ? (FullyDrawnReporterOwner) tag : null;
            if (fullyDrawnReporterOwner != null) {
                return fullyDrawnReporterOwner;
            }
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        return null;
    }

    public static final void set(View view, FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        kotlin.jvm.internal.k.e(view, "<this>");
        kotlin.jvm.internal.k.e(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        view.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
