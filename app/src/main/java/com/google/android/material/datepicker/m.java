package com.google.android.material.datepicker;

import android.view.View;
import com.cbt.exam.browser.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f5362a;

    public m(n nVar) {
        this.f5362a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        n nVar = this.f5362a;
        int i2 = nVar.e;
        if (i2 == 2) {
            nVar.c(1);
            nVar.h.announceForAccessibility(nVar.getString(R.string.mtrl_picker_toggled_to_day_selection));
        } else if (i2 == 1) {
            nVar.c(2);
            nVar.g.announceForAccessibility(nVar.getString(R.string.mtrl_picker_toggled_to_year_selection));
        }
    }
}
