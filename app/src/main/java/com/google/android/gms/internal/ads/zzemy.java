package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzemy implements zzehk {

    @Nullable
    private final zzbfp zza;
    private final zzgus zzb;
    private final zzfks zzc;
    private final zzenh zzd;

    public zzemy(zzfks zzfksVar, zzgus zzgusVar, @Nullable zzbfp zzbfpVar, zzenh zzenhVar) {
        this.zzc = zzfksVar;
        this.zzb = zzgusVar;
        this.zza = zzbfpVar;
        this.zzd = zzenhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final boolean zza(zzfgf zzfgfVar, zzffu zzffuVar) {
        zzffz zzffzVar;
        return (this.zza == null || (zzffzVar = zzffuVar.zzs) == null || zzffzVar.zza == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final j2.q zzb(zzfgf zzfgfVar, zzffu zzffuVar) {
        zzcca zzccaVar = new zzcca();
        zzend zzendVar = new zzend();
        zzendVar.zzd(new zzemw(this, zzccaVar, zzfgfVar, zzffuVar, zzendVar));
        zzffz zzffzVar = zzffuVar.zzs;
        final zzbfk zzbfkVar = new zzbfk(zzendVar, zzffzVar.zzb, zzffzVar.zza);
        zzfkm zzfkmVar = zzfkm.CUSTOM_RENDER_SYN;
        zzfks zzfksVar = this.zzc;
        Objects.requireNonNull(zzfksVar);
        return zzfkd.zzd(new zzfjy() { // from class: com.google.android.gms.internal.ads.zzemx
            @Override // com.google.android.gms.internal.ads.zzfjy
            public final /* synthetic */ void zza() throws RemoteException {
                this.zza.zzc(zzbfkVar);
            }
        }, this.zzb, zzfkmVar, zzfksVar).zzj(zzfkm.CUSTOM_RENDER_ACK).zze(zzccaVar).zzi();
    }

    public final /* synthetic */ void zzc(zzbfk zzbfkVar) throws RemoteException {
        this.zza.zze(zzbfkVar);
    }

    public final /* synthetic */ zzenh zzd() {
        return this.zzd;
    }
}
