package com.google.android.material.datepicker;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f5358a;

    public j(n nVar) {
        this.f5358a = nVar;
        a0.c(null);
        a0.c(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if ((recyclerView.getAdapter() instanceof c0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            this.f5358a.getClass();
            throw null;
        }
    }
}
