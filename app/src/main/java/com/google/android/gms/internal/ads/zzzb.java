package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzzb implements zzyv {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzyt[] zzd = new zzyt[100];

    public zzzb(boolean z2, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized zzyt zza() {
        zzyt zzytVar;
        try {
            this.zzb++;
            int i2 = this.zzc;
            if (i2 > 0) {
                zzyt[] zzytVarArr = this.zzd;
                int i8 = i2 - 1;
                this.zzc = i8;
                zzytVar = zzytVarArr[i8];
                if (zzytVar == null) {
                    throw null;
                }
                zzytVarArr[i8] = null;
            } else {
                zzytVar = new zzyt(new byte[65536], 0);
                int i9 = this.zzb;
                zzyt[] zzytVarArr2 = this.zzd;
                int length = zzytVarArr2.length;
                if (i9 > length) {
                    this.zzd = (zzyt[]) Arrays.copyOf(zzytVarArr2, length + length);
                    return zzytVar;
                }
            }
            return zzytVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized void zzb(zzyt zzytVar) {
        zzyt[] zzytVarArr = this.zzd;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        zzytVarArr[i2] = zzytVar;
        this.zzb--;
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized void zzc(@Nullable zzyu zzyuVar) {
        while (zzyuVar != null) {
            try {
                zzyt[] zzytVarArr = this.zzd;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                zzytVarArr[i2] = zzyuVar.zzd();
                this.zzb--;
                zzyuVar = zzyuVar.zze();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzyv
    public final synchronized void zzd() {
        int i2 = this.zza;
        String str = zzep.zza;
        int iMax = Math.max(0, ((i2 + 65535) / 65536) - this.zzb);
        int i8 = this.zzc;
        if (iMax >= i8) {
            return;
        }
        Arrays.fill(this.zzd, iMax, i8, (Object) null);
        this.zzc = iMax;
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i2) {
        int i8 = this.zza;
        this.zza = i2;
        if (i2 < i8) {
            zzd();
        }
    }

    public final synchronized int zzg() {
        return this.zzb * 65536;
    }
}
