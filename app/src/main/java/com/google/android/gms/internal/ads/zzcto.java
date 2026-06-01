package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzcto implements zzekw {
    protected final zzfgf zza;
    protected final zzffu zzb;
    private final zzczn zzc;
    private final zzdaa zzd;

    @Nullable
    private final zzfdj zze;
    private final zzcyh zzf;
    private final zzddf zzg;
    private final zzdae zzh;
    private final zzdgk zzi;
    private final zzcxi zzj;
    private final zzdwl zzk;

    public zzcto(zzctn zzctnVar) {
        this.zza = zzctnVar.zza();
        this.zzb = zzctnVar.zzb();
        this.zzc = zzctnVar.zzc();
        this.zzd = zzctnVar.zzd();
        this.zze = zzctnVar.zze();
        this.zzf = zzctnVar.zzf();
        this.zzg = zzctnVar.zzg();
        this.zzh = zzctnVar.zzh();
        this.zzi = zzctnVar.zzi();
        this.zzj = zzctnVar.zzj();
        this.zzk = zzctnVar.zzk();
    }

    public void zzd() {
        this.zzc.zzc(null);
    }

    public void zzj() {
        this.zzd.zzg();
        this.zzh.zza(this);
    }

    public final zzczn zzl() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzekw
    public final void zzm() {
        this.zzi.zzi();
    }

    public final zzcyh zzn() {
        return this.zzf;
    }

    public final zzcxi zzo() {
        return this.zzj;
    }

    @Nullable
    public final zzfdj zzp() {
        return this.zze;
    }

    public final zzdce zzq() {
        return this.zzg.zzn();
    }

    public final zzfgf zzr() {
        return this.zza;
    }

    public final boolean zzs() {
        return this.zzb.zzaq;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzt() {
        zzdwl zzdwlVar;
        List list = this.zzb.zzaC;
        if (list == null || list.isEmpty() || (zzdwlVar = this.zzk) == null) {
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziv)).booleanValue() || list.isEmpty()) {
            return;
        }
        zzgrt zzgrtVarListIterator = ((zzgpe) list).listIterator(0);
        while (zzgrtVarListIterator.hasNext()) {
            zzdwm zzdwmVar = (zzdwm) zzgrtVarListIterator.next();
            int[] iArr = zzdwmVar.zzb;
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (iArr[i2] == 1) {
                    zzdwlVar.zza(zzdwmVar.zza, 1, com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
                    break;
                }
                i2++;
            }
        }
    }
}
