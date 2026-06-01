package com.mimikridev.utilmanager.dialog;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10698a;

    public /* synthetic */ b(int i2) {
        this.f10698a = i2;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        switch (this.f10698a) {
            case 0:
                return DialogUtil.lambda$showErrorDialogExit$3(dialogInterface, i2, keyEvent);
            default:
                return DialogUtil.lambda$showLoadingAds$0(dialogInterface, i2, keyEvent);
        }
    }
}
