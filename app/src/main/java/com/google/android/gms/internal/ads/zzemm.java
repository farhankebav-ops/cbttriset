package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzemm implements zzehk {
    private final zzehm zza;
    private final zzehq zzb;
    private final zzfks zzc;
    private final zzgus zzd;

    public zzemm(zzfks zzfksVar, zzgus zzgusVar, zzehm zzehmVar, zzehq zzehqVar) {
        this.zzc = zzfksVar;
        this.zzd = zzgusVar;
        this.zzb = zzehqVar;
        this.zza = zzehmVar;
    }

    @VisibleForTesting
    public static final String zze(String str, int i2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(i2).length());
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final boolean zza(zzfgf zzfgfVar, zzffu zzffuVar) {
        return !zzffuVar.zzt.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final j2.q zzb(final zzfgf zzfgfVar, final zzffu zzffuVar) {
        final zzehn zzehnVarZza;
        Iterator it = zzffuVar.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzehnVarZza = null;
                break;
            }
            try {
                zzehnVarZza = this.zza.zza((String) it.next(), zzffuVar.zzv);
                break;
            } catch (zzfgu unused) {
            }
        }
        if (zzehnVarZza == null) {
            return zzgui.zzc(new zzekd("Unable to instantiate mediation adapter class."));
        }
        zzcca zzccaVar = new zzcca();
        zzehnVarZza.zzc.zza(new zzemj(this, zzehnVarZza, zzccaVar));
        if (zzffuVar.zzM) {
            Bundle bundle = zzfgfVar.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfks zzfksVar = this.zzc;
        zzfkm zzfkmVar = zzfkm.ADAPTER_LOAD_AD_SYN;
        Objects.requireNonNull(zzfksVar);
        return zzfkd.zzd(new zzfjy() { // from class: com.google.android.gms.internal.ads.zzeml
            @Override // com.google.android.gms.internal.ads.zzfjy
            public final /* synthetic */ void zza() throws zzfgu {
                this.zza.zzc(zzfgfVar, zzffuVar, zzehnVarZza);
            }
        }, this.zzd, zzfkmVar, zzfksVar).zzj(zzfkm.ADAPTER_LOAD_AD_ACK).zze(zzccaVar).zzj(zzfkm.ADAPTER_WRAP_ADAPTER).zzb(new zzfjx() { // from class: com.google.android.gms.internal.ads.zzemk
            @Override // com.google.android.gms.internal.ads.zzfjx
            public final /* synthetic */ Object zza(Object obj) {
                return this.zza.zzd(zzfgfVar, zzffuVar, zzehnVarZza, (Void) obj);
            }
        }).zzi();
    }

    public final /* synthetic */ void zzc(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu {
        this.zzb.zza(zzfgfVar, zzffuVar, zzehnVar);
    }

    public final /* synthetic */ Object zzd(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar, Void r42) {
        return this.zzb.zzb(zzfgfVar, zzffuVar, zzehnVar);
    }
}
