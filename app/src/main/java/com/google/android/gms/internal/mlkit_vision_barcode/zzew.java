package com.google.android.gms.internal.mlkit_vision_barcode;

import a1.a;
import com.ironsource.C2300e4;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzew extends zzef implements RunnableFuture {
    private volatile zzer zzc;

    public zzew(zzxh zzxhVar) {
        this.zzc = new zzev(this, zzxhVar);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzer zzerVar = this.zzc;
        if (zzerVar != null) {
            zzerVar.run();
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdz
    public final String zzf() {
        zzer zzerVar = this.zzc;
        return zzerVar != null ? a.m("task=[", zzerVar.toString(), C2300e4.i.e) : super.zzf();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzdz
    public final void zzm() {
        zzer zzerVar;
        if (zzp() && (zzerVar = this.zzc) != null) {
            zzerVar.zze();
        }
        this.zzc = null;
    }
}
