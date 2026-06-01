package com.instagram.common.viewpoint.core;

import android.content.DialogInterface;
import android.widget.EditText;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class DialogInterfaceOnClickListenerC1197Xc implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText A00;
    public final /* synthetic */ C0978Om A01;

    public DialogInterfaceOnClickListenerC1197Xc(C0978Om c0978Om, EditText editText) {
        this.A01 = c0978Om;
        this.A00 = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.A01.A03.execute(new C0981Op(this, dialogInterface));
    }
}
