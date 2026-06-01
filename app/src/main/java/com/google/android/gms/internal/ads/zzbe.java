package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbe {
    public static final Object zza = new Object();
    private static final zzak zzp;

    @Nullable
    @Deprecated
    public Object zzc;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public boolean zzi;

    @Nullable
    public zzaf zzj;
    public boolean zzk;
    public long zzl;
    public long zzm;
    public int zzn;
    public int zzo;
    public Object zzb = zza;
    public zzak zzd = zzp;

    static {
        zzz zzzVar = new zzz();
        zzzVar.zza("androidx.media3.common.Timeline");
        zzzVar.zzb(Uri.EMPTY);
        zzp = zzzVar.zzc();
        String str = zzep.zza;
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
        Integer.toString(9, 36);
        Integer.toString(10, 36);
        Integer.toString(11, 36);
        Integer.toString(12, 36);
        Integer.toString(13, 36);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbe.class.equals(obj.getClass())) {
            zzbe zzbeVar = (zzbe) obj;
            if (Objects.equals(this.zzb, zzbeVar.zzb) && Objects.equals(this.zzd, zzbeVar.zzd) && Objects.equals(this.zzj, zzbeVar.zzj) && this.zze == zzbeVar.zze && this.zzf == zzbeVar.zzf && this.zzg == zzbeVar.zzg && this.zzh == zzbeVar.zzh && this.zzi == zzbeVar.zzi && this.zzk == zzbeVar.zzk && this.zzm == zzbeVar.zzm && this.zzn == zzbeVar.zzn && this.zzo == zzbeVar.zzo) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.zzb.hashCode() + Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE) * 31) + this.zzd.hashCode();
        zzaf zzafVar = this.zzj;
        int iHashCode2 = ((iHashCode * 961) + (zzafVar == null ? 0 : zzafVar.hashCode())) * 31;
        long j = this.zze;
        int i2 = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        long j3 = this.zzf;
        int i8 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j8 = this.zzg;
        int i9 = ((((((i8 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzk ? 1 : 0);
        long j9 = this.zzm;
        return ((((((i9 * 961) + ((int) (j9 ^ (j9 >>> 32)))) * 31) + this.zzn) * 31) + this.zzo) * 31;
    }

    public final zzbe zza(Object obj, @Nullable zzak zzakVar, @Nullable Object obj2, long j, long j3, long j8, boolean z2, boolean z7, @Nullable zzaf zzafVar, long j9, long j10, int i2, int i8, long j11) {
        this.zzb = obj;
        if (zzakVar == null) {
            zzakVar = zzp;
        }
        this.zzd = zzakVar;
        this.zzc = null;
        this.zze = -9223372036854775807L;
        this.zzf = -9223372036854775807L;
        this.zzg = -9223372036854775807L;
        this.zzh = z2;
        this.zzi = z7;
        this.zzj = zzafVar;
        this.zzl = 0L;
        this.zzm = j10;
        this.zzn = 0;
        this.zzo = 0;
        this.zzk = false;
        return this;
    }

    public final boolean zzb() {
        return this.zzj != null;
    }
}
