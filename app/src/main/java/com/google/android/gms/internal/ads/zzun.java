package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzun extends zzui {
    public static final Object zzc = new Object();

    @Nullable
    private final Object zzd;

    @Nullable
    private final Object zze;

    private zzun(zzbf zzbfVar, @Nullable Object obj, @Nullable Object obj2) {
        super(zzbfVar);
        this.zzd = obj;
        this.zze = obj2;
    }

    public static zzun zzp(zzak zzakVar) {
        return new zzun(new zzuo(zzakVar), zzbe.zza, zzc);
    }

    public static zzun zzq(zzbf zzbfVar, @Nullable Object obj, @Nullable Object obj2) {
        return new zzun(zzbfVar, obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzui, com.google.android.gms.internal.ads.zzbf
    public final zzbe zzb(int i2, zzbe zzbeVar, long j) {
        this.zzb.zzb(i2, zzbeVar, j);
        if (Objects.equals(zzbeVar.zzb, this.zzd)) {
            zzbeVar.zzb = zzbe.zza;
        }
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzui, com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i2, zzbd zzbdVar, boolean z2) {
        this.zzb.zzd(i2, zzbdVar, z2);
        if (Objects.equals(zzbdVar.zzb, this.zze) && z2) {
            zzbdVar.zzb = zzc;
        }
        return zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzui, com.google.android.gms.internal.ads.zzbf
    public final int zze(Object obj) {
        Object obj2;
        if (zzc.equals(obj) && (obj2 = this.zze) != null) {
            obj = obj2;
        }
        return this.zzb.zze(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzui, com.google.android.gms.internal.ads.zzbf
    public final Object zzf(int i2) {
        Object objZzf = this.zzb.zzf(i2);
        return Objects.equals(objZzf, this.zze) ? zzc : objZzf;
    }

    public final zzun zzr(zzbf zzbfVar) {
        return new zzun(zzbfVar, this.zzd, this.zze);
    }

    public final /* synthetic */ Object zzs() {
        return this.zze;
    }
}
