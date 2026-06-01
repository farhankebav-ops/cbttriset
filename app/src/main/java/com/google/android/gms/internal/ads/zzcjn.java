package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzcjn implements zzcnr {
    private static zzcjn zza;

    private static synchronized zzcjn zzH(Context context, zzbrj zzbrjVar, int i2, boolean z2, int i8, zzckv zzckvVar) {
        try {
            zzcjn zzcjnVar = zza;
            if (zzcjnVar != null) {
                return zzcjnVar;
            }
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            zzbeu.zza(context);
            if (((Boolean) zzbgm.zze.zze()).booleanValue()) {
                zzbef.zza(context);
            }
            zzfhj zzfhjVarZza = zzfhj.zza(context);
            VersionInfoParcel versionInfoParcelZzb = zzfhjVarZza.zzb(ModuleDescriptor.MODULE_VERSION, false, i8);
            zzfhjVarZza.zzc(zzbrjVar);
            zzclk zzclkVar = new zzclk(null);
            zzcjo zzcjoVar = new zzcjo();
            zzcjoVar.zza(versionInfoParcelZzb);
            zzcjoVar.zzb(context);
            zzcjoVar.zzc(jCurrentTimeMillis);
            zzclkVar.zza(new zzcjp(zzcjoVar, null));
            zzclkVar.zzb(new zzcmh(zzckvVar));
            zzcjn zzcjnVarZzc = zzclkVar.zzc();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoE)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zze().zza(zzfjn.zzc(), zzcjnVarZzc.zzD());
                com.google.android.gms.ads.internal.zzt.zze().zzb();
            }
            ((zzdzt) ((zzckz) zzcjnVarZzc).zzo.zzb()).zza();
            ((zzcjg) ((zzckz) zzcjnVarZzc).zzn.zzb()).zza(context, versionInfoParcelZzb);
            com.google.android.gms.ads.internal.zzt.zzh().zze(context, versionInfoParcelZzb, zzcjnVarZzc.zzD());
            com.google.android.gms.ads.internal.zzt.zzj().zza(context);
            com.google.android.gms.ads.internal.zzt.zzc().zzc(context);
            com.google.android.gms.ads.internal.zzt.zzc().zzd(context);
            com.google.android.gms.ads.internal.util.zzd.zza(context);
            com.google.android.gms.ads.internal.zzt.zzg().zza(context);
            com.google.android.gms.ads.internal.zzt.zzA().zza(context);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoX)).booleanValue()) {
                String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoY);
                if (!str.isEmpty()) {
                    if (Arrays.asList(str.split(",")).contains(context.getPackageName())) {
                        zzcjnVarZzc.zzE().zza(com.google.android.gms.ads.internal.zzt.zzg());
                    }
                }
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoW)).booleanValue()) {
                    zzcjnVarZzc.zzE().zza(com.google.android.gms.ads.internal.zzt.zzg());
                }
            }
            ((com.google.android.gms.ads.internal.util.zzbz) ((zzckz) zzcjnVarZzc).zzao.zzb()).zza();
            zzcag.zzb(context);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgL)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaP)).booleanValue()) {
                    new zzefm(context, versionInfoParcelZzb, new zzbdt(new zzbdy(context)), new zzeer(new zzeen(context), (zzgus) ((zzckz) zzcjnVarZzc).zzd.zzb())).zza(com.google.android.gms.ads.internal.zzt.zzh().zzo().zzx());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoQ)).booleanValue()) {
                zzcjnVarZzc.zzg().zza();
            }
            zza = zzcjnVarZzc;
            return zzcjnVarZzc;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static zzcjn zza(Context context, zzbrj zzbrjVar, int i2) {
        return zzH(context, zzbrjVar, ModuleDescriptor.MODULE_VERSION, false, i2, new zzckv());
    }

    public abstract zzdwz zzA();

    public abstract zzfhd zzB();

    public abstract zzdzl zzC();

    public abstract zzdvi zzD();

    public abstract zzdsq zzE();

    @Override // com.google.android.gms.internal.ads.zzcnr
    public final zzcaz zzF() {
        return zzG();
    }

    public abstract zzcaz zzG();

    public abstract Executor zzb();

    public abstract ScheduledExecutorService zzc();

    public abstract zzdbp zzd();

    public abstract zzcms zze();

    public abstract zzfnt zzf();

    public abstract zzecy zzg();

    public abstract zzeda zzh();

    public abstract zzcsk zzi();

    public abstract zzfck zzj();

    public abstract zzcqt zzk();

    public abstract zzfax zzl();

    public abstract zzdjc zzm();

    public abstract zzfea zzn();

    public abstract zzdjy zzo();

    public abstract zzdrm zzp();

    public abstract zzffn zzq();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzab zzr();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzau zzs();

    public abstract com.google.android.gms.ads.nonagon.signalgeneration.zzv zzt();

    public abstract zzegj zzu();

    public abstract zzfhm zzv();

    public abstract zzdyo zzw();

    public abstract zzflp zzx();

    @Override // com.google.android.gms.internal.ads.zzcnr
    public final zzezc zzy(zzbxj zzbxjVar, int i2) {
        return zzz(new zzfaf(zzbxjVar, i2));
    }

    public abstract zzezc zzz(zzfaf zzfafVar);
}
