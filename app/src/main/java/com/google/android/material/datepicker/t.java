package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class t implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f5400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f5401b;

    public t(v vVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f5401b = vVar;
        this.f5400a = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        MaterialCalendarGridView materialCalendarGridView = this.f5400a;
        s sVarA = materialCalendarGridView.a();
        if (i2 < sVarA.a() || i2 > sVarA.c()) {
            return;
        }
        if (materialCalendarGridView.a().getItem(i2).longValue() >= this.f5401b.f5405b.f5357a.f5364c.f5339c.f5346a) {
            throw null;
        }
    }
}
