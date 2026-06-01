package com.cbt.exam.browser.activity;

import android.app.Dialog;
import android.view.View;
import android.widget.ProgressBar;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Dialog f5161b;

    public /* synthetic */ d(Dialog dialog, int i2) {
        this.f5160a = i2;
        this.f5161b = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f5160a;
        Dialog dialog = this.f5161b;
        switch (i2) {
            case 0:
                ProgressBar progressBar = ActivityCbtBrowser.P;
                dialog.dismiss();
                break;
            case 1:
                ProgressBar progressBar2 = ActivityCbtBrowser.P;
                dialog.dismiss();
                break;
            case 2:
                int i8 = ActivityConfigConfirm.f5077s;
                dialog.dismiss();
                break;
            case 3:
                ProgressBar progressBar3 = ExamQR.B;
                dialog.dismiss();
                break;
            case 4:
                int i9 = MainActivity.f5146s;
                dialog.dismiss();
                break;
            case 5:
                int i10 = MainActivity.f5146s;
                dialog.dismiss();
                break;
            default:
                int i11 = MainActivity.f5146s;
                dialog.dismiss();
                break;
        }
    }
}
