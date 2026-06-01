package com.instagram.common.viewpoint.core;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class DialogInterfaceOnClickListenerC1196Xb implements DialogInterface.OnClickListener {
    public final /* synthetic */ C0978Om A00;

    public DialogInterfaceOnClickListenerC1196Xb(C0978Om c0978Om) {
        this.A00 = c0978Om;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
    }
}
