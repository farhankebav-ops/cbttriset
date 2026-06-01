package com.google.android.material.datepicker;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f5356b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(n nVar, Context context, int i2, int i8) {
        super(context, i2, false);
        this.f5356b = nVar;
        this.f5355a = i8;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        int i2 = this.f5355a;
        n nVar = this.f5356b;
        if (i2 == 0) {
            iArr[0] = nVar.h.getWidth();
            iArr[1] = nVar.h.getWidth();
        } else {
            iArr[0] = nVar.h.getHeight();
            iArr[1] = nVar.h.getHeight();
        }
    }
}
