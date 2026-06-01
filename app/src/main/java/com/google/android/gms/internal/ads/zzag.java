package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzag {
    public final Uri zza;

    @Nullable
    public final String zzb;

    @Nullable
    public final zzad zzc;

    @Nullable
    public final zzy zzd;
    public final List zze;

    @Nullable
    public final String zzf;
    public final zzgpe zzg;

    @Nullable
    public final Object zzh;
    public final long zzi;

    static {
        String str = zzep.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
    }

    public /* synthetic */ zzag(Uri uri, String str, zzad zzadVar, zzy zzyVar, List list, String str2, zzgpe zzgpeVar, Object obj, long j, byte[] bArr) {
        this.zza = uri;
        int i2 = zzas.zza;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = list;
        this.zzf = null;
        this.zzg = zzgpeVar;
        int i8 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        if (zzgpeVar.size() > 0) {
            throw null;
        }
        zzgpbVar.zzi();
        this.zzh = null;
        this.zzi = -9223372036854775807L;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        zzag zzagVar = (zzag) obj;
        return this.zza.equals(zzagVar.zza) && this.zze.equals(zzagVar.zze) && this.zzg.equals(zzagVar.zzg);
    }

    public final int hashCode() {
        return (int) ((((long) ((this.zzg.hashCode() + ((this.zze.hashCode() + (this.zza.hashCode() * 923521)) * 961)) * 31)) * 31) - Long.MAX_VALUE);
    }
}
