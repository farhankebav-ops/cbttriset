package com.cbt.exam.browser.activity;

import android.view.View;
import android.widget.ProgressBar;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseActivity f5175b;

    public /* synthetic */ i(BaseActivity baseActivity, int i2) {
        this.f5174a = i2;
        this.f5175b = baseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f5174a;
        BaseActivity baseActivity = this.f5175b;
        switch (i2) {
            case 0:
                ProgressBar progressBar = ActivityCbtBrowser.P;
                ((ActivityCbtBrowser) baseActivity).v();
                break;
            default:
                ProgressBar progressBar2 = ExamQR.B;
                ((ExamQR) baseActivity).v();
                break;
        }
    }
}
