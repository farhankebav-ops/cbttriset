package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.internal.ads.zzbdz;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfid implements zzfic {
    private final ConcurrentHashMap zza;
    private final zzfij zzb;
    private final zzfif zzc = new zzfif();

    public zzfid(zzfij zzfijVar) {
        this.zza = new ConcurrentHashMap(zzfijVar.zzd);
        this.zzb = zzfijVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfij> creator = zzfij.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgR)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            zzfij zzfijVar = this.zzb;
            sb.append(zzfijVar.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzg());
            int i2 = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i2++;
                sb.append(i2);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfim) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i8 = 0; i8 < ((zzfib) entry.getValue()).zzc(); i8++) {
                    sb.append("[O]");
                }
                for (int iZzc = ((zzfib) entry.getValue()).zzc(); iZzc < zzfijVar.zzd; iZzc++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfib) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i2 < zzfijVar.zzc) {
                i2++;
                sb.append(i2);
                sb.append(".\n");
            }
            String string = sb.toString();
            int i9 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    @Nullable
    public final synchronized zzfil zza(zzfim zzfimVar) {
        zzfil zzfilVarZzb;
        try {
            zzfib zzfibVar = (zzfib) this.zza.get(zzfimVar);
            if (zzfibVar != null) {
                zzfilVarZzb = zzfibVar.zzb();
                if (zzfilVarZzb == null) {
                    this.zzc.zzb();
                }
                zzfiz zzfizVarZzh = zzfibVar.zzh();
                if (zzfilVarZzb != null) {
                    zzbdz.zzb.zzc zzcVarZzs = zzbdz.zzb.zzs();
                    zzbdz.zzb.zza.C0133zza c0133zzaZzs = zzbdz.zzb.zza.zzs();
                    c0133zzaZzs.zzc(zzbdz.zzb.zzd.IN_MEMORY);
                    zzbdz.zzb.zze.zza zzaVarZzq = zzbdz.zzb.zze.zzq();
                    zzaVarZzq.zzc(zzfizVarZzh.zza);
                    zzaVarZzq.zzg(zzfizVarZzh.zzb);
                    c0133zzaZzs.zzh(zzaVarZzq);
                    zzcVarZzs.zzh(c0133zzaZzs);
                    zzfilVarZzb.zza.zza().zzd().zzj(zzcVarZzs.zzbu());
                }
                zzf();
            } else {
                this.zzc.zza();
                zzf();
                zzfilVarZzb = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzfilVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    public final synchronized boolean zzb(zzfim zzfimVar, zzfil zzfilVar) {
        boolean zZza;
        try {
            ConcurrentHashMap concurrentHashMap = this.zza;
            zzfib zzfibVar = (zzfib) concurrentHashMap.get(zzfimVar);
            zzfilVar.zzd = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            if (zzfibVar == null) {
                zzfij zzfijVar = this.zzb;
                zzfib zzfibVar2 = new zzfib(zzfijVar.zzd, zzfijVar.zze * 1000);
                if (concurrentHashMap.size() == zzfijVar.zzc) {
                    int i2 = zzfijVar.zzg;
                    int i8 = i2 - 1;
                    zzfim zzfimVar2 = null;
                    if (i2 == 0) {
                        throw null;
                    }
                    long jZzd = LocationRequestCompat.PASSIVE_INTERVAL;
                    if (i8 == 0) {
                        for (Map.Entry entry : concurrentHashMap.entrySet()) {
                            if (((zzfib) entry.getValue()).zzd() < jZzd) {
                                jZzd = ((zzfib) entry.getValue()).zzd();
                                zzfimVar2 = (zzfim) entry.getKey();
                            }
                        }
                        if (zzfimVar2 != null) {
                            concurrentHashMap.remove(zzfimVar2);
                        }
                    } else if (i8 == 1) {
                        for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                            if (((zzfib) entry2.getValue()).zze() < jZzd) {
                                jZzd = ((zzfib) entry2.getValue()).zze();
                                zzfimVar2 = (zzfim) entry2.getKey();
                            }
                        }
                        if (zzfimVar2 != null) {
                            concurrentHashMap.remove(zzfimVar2);
                        }
                    } else if (i8 == 2) {
                        int iZzf = Integer.MAX_VALUE;
                        for (Map.Entry entry3 : concurrentHashMap.entrySet()) {
                            if (((zzfib) entry3.getValue()).zzf() < iZzf) {
                                iZzf = ((zzfib) entry3.getValue()).zzf();
                                zzfimVar2 = (zzfim) entry3.getKey();
                            }
                        }
                        if (zzfimVar2 != null) {
                            concurrentHashMap.remove(zzfimVar2);
                        }
                    }
                    this.zzc.zzd();
                }
                concurrentHashMap.put(zzfimVar, zzfibVar2);
                this.zzc.zzc();
                zzfibVar = zzfibVar2;
            }
            zZza = zzfibVar.zza(zzfilVar);
            zzfif zzfifVar = this.zzc;
            zzfifVar.zze();
            zzfie zzfieVarZzf = zzfifVar.zzf();
            zzfiz zzfizVarZzh = zzfibVar.zzh();
            zzbdz.zzb.zzc zzcVarZzs = zzbdz.zzb.zzs();
            zzbdz.zzb.zza.C0133zza c0133zzaZzs = zzbdz.zzb.zza.zzs();
            c0133zzaZzs.zzc(zzbdz.zzb.zzd.IN_MEMORY);
            zzbdz.zzb.zzg.zza zzaVarZzs = zzbdz.zzb.zzg.zzs();
            zzaVarZzs.zzc(zzfieVarZzf.zza);
            zzaVarZzs.zzg(zzfieVarZzf.zzb);
            zzaVarZzs.zzk(zzfizVarZzh.zzb);
            c0133zzaZzs.zzn(zzaVarZzs);
            zzcVarZzs.zzh(c0133zzaZzs);
            zzfilVar.zza.zza().zzd().zzk(zzcVarZzs.zzbu());
            zzf();
        } catch (Throwable th) {
            throw th;
        }
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    public final synchronized boolean zzc(zzfim zzfimVar) {
        zzfib zzfibVar = (zzfib) this.zza.get(zzfimVar);
        if (zzfibVar == null) {
            return true;
        }
        return zzfibVar.zzc() < this.zzb.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    @Deprecated
    public final zzfim zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, com.google.android.gms.ads.internal.client.zzx zzxVar) {
        zzfij zzfijVar = this.zzb;
        return new zzfin(zzmVar, str, new zzbxm(zzfijVar.zza).zza().zzj, zzfijVar.zzf, zzxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    public final zzfij zze() {
        return this.zzb;
    }
}
