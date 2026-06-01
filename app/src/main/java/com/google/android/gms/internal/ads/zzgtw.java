package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgtw extends zzgtk {
    private zzgtv zza;

    public zzgtw(zzgpa zzgpaVar, boolean z2, Executor executor, Callable callable) {
        super(zzgpaVar, z2, false);
        this.zza = new zzgtu(this, callable, executor);
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    public final void zzA(int i2) {
        super.zzA(i2);
        if (i2 == 1) {
            this.zza = null;
        }
    }

    public final /* synthetic */ void zzD(zzgtv zzgtvVar) {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    public final void zzi() {
        zzgtv zzgtvVar = this.zza;
        if (zzgtvVar != null) {
            zzgtvVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    public final void zzx() {
        zzgtv zzgtvVar = this.zza;
        if (zzgtvVar != null) {
            zzgtvVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    public final void zzw(int i2, Object obj) {
    }
}
