package com.google.android.play.core.review.internal;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzp extends zzj {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzr zzb;

    public zzp(zzr zzrVar, IBinder iBinder) {
        this.zza = iBinder;
        this.zzb = zzrVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        this.zzb.zza.zzn = zze.zzb(this.zza);
        zzt.zzq(this.zzb.zza);
        this.zzb.zza.zzh = false;
        Iterator it = this.zzb.zza.zze.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.zzb.zza.zze.clear();
    }
}
