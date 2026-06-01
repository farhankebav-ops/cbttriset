package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaw implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ boolean zzd;

    public zzaw(zzax zzaxVar, Context context, String str, boolean z2, boolean z7) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z2;
        this.zzd = z7;
        Objects.requireNonNull(zzaxVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzt.zzc();
        Context context = this.zza;
        AlertDialog.Builder builderZzO = zzs.zzO(context);
        builderZzO.setMessage(this.zzb);
        if (this.zzc) {
            builderZzO.setTitle("Error");
        } else {
            builderZzO.setTitle("Info");
        }
        if (this.zzd) {
            builderZzO.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builderZzO.setPositiveButton("Learn More", new zzav(this, context));
            builderZzO.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builderZzO.create().show();
    }
}
