package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzek implements zzdm {

    @GuardedBy("messagePool")
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzek(Handler handler) {
        this.zzb = handler;
    }

    public static /* synthetic */ void zzn(zzej zzejVar) {
        List list = zza;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(zzejVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static zzej zzo() {
        zzej zzejVar;
        List list = zza;
        synchronized (list) {
            try {
                zzejVar = list.isEmpty() ? new zzej(null) : (zzej) list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzejVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final Looper zza() {
        return this.zzb.getLooper();
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzb(int i2) {
        return this.zzb.hasMessages(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final zzdl zzc(int i2) {
        Handler handler = this.zzb;
        zzej zzejVarZzo = zzo();
        zzejVarZzo.zzb(handler.obtainMessage(i2), this);
        return zzejVarZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final zzdl zzd(int i2, @Nullable Object obj) {
        Handler handler = this.zzb;
        zzej zzejVarZzo = zzo();
        zzejVarZzo.zzb(handler.obtainMessage(i2, obj), this);
        return zzejVarZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final zzdl zze(int i2, int i8, int i9) {
        Handler handler = this.zzb;
        zzej zzejVarZzo = zzo();
        zzejVarZzo.zzb(handler.obtainMessage(i2, i8, i9), this);
        return zzejVarZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final zzdl zzf(int i2, int i8, int i9, @Nullable Object obj) {
        Handler handler = this.zzb;
        zzej zzejVarZzo = zzo();
        zzejVarZzo.zzb(handler.obtainMessage(31, 0, 0, obj), this);
        return zzejVarZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzg(zzdl zzdlVar) {
        return ((zzej) zzdlVar).zzc(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzh(int i2) {
        return this.zzb.sendEmptyMessage(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzi(int i2, int i8) {
        return this.zzb.sendEmptyMessageDelayed(i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzj(int i2, long j) {
        return this.zzb.sendEmptyMessageAtTime(2, j);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final void zzk(int i2) {
        this.zzb.removeMessages(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final void zzl(@Nullable Object obj) {
        this.zzb.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzdm
    public final boolean zzm(Runnable runnable) {
        return this.zzb.post(runnable);
    }
}
