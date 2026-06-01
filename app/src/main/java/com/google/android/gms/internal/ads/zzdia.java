package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzdia {
    private final zzdjl zza;

    @Nullable
    private final zzcgy zzb;

    public zzdia(zzdjl zzdjlVar, @Nullable zzcgy zzcgyVar) {
        this.zza = zzdjlVar;
        this.zzb = zzcgyVar;
    }

    public final zzdjl zza() {
        return this.zza;
    }

    @Nullable
    public final zzcgy zzb() {
        return this.zzb;
    }

    @Nullable
    public final View zzc() {
        zzcgy zzcgyVar = this.zzb;
        if (zzcgyVar != null) {
            return zzcgyVar.zzD();
        }
        return null;
    }

    @Nullable
    public final View zzd() {
        zzcgy zzcgyVar = this.zzb;
        if (zzcgyVar == null) {
            return null;
        }
        return zzcgyVar.zzD();
    }

    public Set zze(zzcxf zzcxfVar) {
        return Collections.singleton(new zzdgn(zzcxfVar, zzcbv.zzg));
    }

    public Set zzf(zzcxf zzcxfVar) {
        return Collections.singleton(new zzdgn(zzcxfVar, zzcbv.zzg));
    }

    public final zzdgn zzg(Executor executor) {
        final zzcgy zzcgyVar = this.zzb;
        return new zzdgn(new zzddl() { // from class: com.google.android.gms.internal.ads.zzdhy
            @Override // com.google.android.gms.internal.ads.zzddl
            public final /* synthetic */ void zza() {
                com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL;
                zzcgy zzcgyVar2 = zzcgyVar;
                if (zzcgyVar2 == null || (zzmVarZzL = zzcgyVar2.zzL()) == null) {
                    return;
                }
                zzmVarZzL.zzb();
            }
        }, executor);
    }
}
