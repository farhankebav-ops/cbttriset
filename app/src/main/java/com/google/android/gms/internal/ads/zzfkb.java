package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfkb {
    final /* synthetic */ zzfkk zza;
    private final Object zzb;
    private final List zzc;

    public /* synthetic */ zzfkb(zzfkk zzfkkVar, Object obj, List list, byte[] bArr) {
        Objects.requireNonNull(zzfkkVar);
        this.zza = zzfkkVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfkj zza(Callable callable) {
        List list = this.zzc;
        zzguh zzguhVarZzp = zzgui.zzp(list);
        j2.q qVarZza = zzguhVarZzp.zza(zzfka.zza, zzcbv.zzg);
        zzfkk zzfkkVar = this.zza;
        return new zzfkj(zzfkkVar, this.zzb, null, qVarZza, list, zzguhVarZzp.zza(callable, zzfkkVar.zze()), null);
    }
}
