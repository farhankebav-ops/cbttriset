package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f5352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f5353c;

    public /* synthetic */ f(n nVar, v vVar, int i2) {
        this.f5351a = i2;
        this.f5353c = nVar;
        this.f5352b = vVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5351a) {
            case 0:
                n nVar = this.f5353c;
                int iFindLastVisibleItemPosition = ((LinearLayoutManager) nVar.h.getLayoutManager()).findLastVisibleItemPosition() - 1;
                Calendar calendarA = a0.a(this.f5352b.f5404a.f5337a.f5391a);
                calendarA.add(2, iFindLastVisibleItemPosition);
                nVar.b(new r(calendarA));
                break;
            default:
                n nVar2 = this.f5353c;
                int iFindFirstVisibleItemPosition = ((LinearLayoutManager) nVar2.h.getLayoutManager()).findFirstVisibleItemPosition() + 1;
                Calendar calendarA2 = a0.a(this.f5352b.f5404a.f5337a.f5391a);
                calendarA2.add(2, iFindFirstVisibleItemPosition);
                nVar2.b(new r(calendarA2));
                break;
        }
    }
}
