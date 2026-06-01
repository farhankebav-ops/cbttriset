package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.ironsource.C2300e4;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhx implements zzkl {
    public static final zzgpe zza = zzgpe.zzn(C2300e4.h.f8363b, "content", "data", "android.resource", "rawresource", "asset");
    private final zzbe zzb;
    private final zzbd zzc;
    private final zzzb zzd;
    private final long zze;
    private final long zzf;
    private final long zzg;
    private final long zzh;
    private final long zzi;
    private final long zzj;
    private final long zzk;
    private final long zzl;
    private final long zzm;
    private final zzgph zzn;
    private final ConcurrentHashMap zzo;
    private long zzp;

    public zzhx() {
        zzzb zzzbVar = new zzzb(true, 65536);
        zzgph zzgphVarZza = zzgph.zza();
        zzq(1000, 0, "bufferForPlaybackMs", "0");
        zzq(1000, 0, "bufferForPlaybackForLocalPlaybackMs", "0");
        zzq(2000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzq(1000, 0, "bufferForPlaybackAfterRebufferForLocalPlaybackMs", "0");
        zzq(C2300e4.b.f8307d, 1000, "minBufferMs", "bufferForPlaybackMs");
        zzq(1000, 1000, "minBufferForLocalPlaybackMs", "bufferForPlaybackForLocalPlaybackMs");
        zzq(C2300e4.b.f8307d, 2000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzq(1000, 1000, "minBufferForLocalPlaybackMs", "bufferForPlaybackAfterRebufferForLocalPlaybackMs");
        zzq(C2300e4.b.f8307d, C2300e4.b.f8307d, "maxBufferMs", "minBufferMs");
        zzq(C2300e4.b.f8307d, 1000, "maxBufferForLocalPlaybackMs", "minBufferForLocalPlaybackMs");
        zzq(0, 0, "backBufferDurationMs", "0");
        this.zzb = new zzbe();
        this.zzc = new zzbd();
        this.zzd = zzzbVar;
        this.zze = zzep.zzq(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT);
        this.zzf = zzep.zzq(1000L);
        this.zzg = zzep.zzq(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT);
        this.zzh = zzep.zzq(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT);
        this.zzi = zzep.zzq(1000L);
        this.zzj = zzep.zzq(1000L);
        this.zzk = zzep.zzq(2000L);
        this.zzl = zzep.zzq(1000L);
        this.zzm = zzep.zzq(0L);
        this.zzo = new ConcurrentHashMap();
        this.zzn = zzgph.zzc(zzgphVarZza);
        this.zzp = -1L;
    }

    private final int zzm(zzpc zzpcVar) {
        Integer num = (Integer) this.zzn.get(zzpcVar.zzb);
        if (num == null || num.intValue() == -1) {
            return -1;
        }
        return num.intValue();
    }

    private final void zzn(zzpc zzpcVar) {
        ConcurrentHashMap concurrentHashMap = this.zzo;
        zzhw zzhwVar = (zzhw) concurrentHashMap.get(zzpcVar);
        if (zzhwVar != null) {
            int i2 = zzhwVar.zza - 1;
            zzhwVar.zza = i2;
            if (i2 == 0) {
                concurrentHashMap.remove(zzpcVar);
                zzo();
            }
        }
    }

    private final void zzo() {
        ConcurrentHashMap concurrentHashMap = this.zzo;
        if (concurrentHashMap.isEmpty()) {
            this.zzd.zze();
            return;
        }
        zzzb zzzbVar = this.zzd;
        Iterator it = concurrentHashMap.values().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += ((zzhw) it.next()).zzc;
        }
        zzzbVar.zzf(i2);
    }

    private final boolean zzp(zzkk zzkkVar) {
        zzbf zzbfVar = zzkkVar.zzb;
        zzag zzagVar = zzbfVar.zzb(zzbfVar.zzo(zzkkVar.zzc.zza, this.zzc).zzc, this.zzb, 0L).zzd.zzb;
        if (zzagVar == null) {
            return false;
        }
        String scheme = zzagVar.zza.getScheme();
        return TextUtils.isEmpty(scheme) || zza.contains(scheme);
    }

    private static void zzq(int i2, int i8, String str, String str2) {
        if (i2 < i8) {
            throw new IllegalArgumentException(zzgmu.zzd("%s cannot be less than %s", str, str2));
        }
    }

    private final int zzr(zzpc zzpcVar) {
        zzhw zzhwVar = (zzhw) this.zzo.get(zzpcVar);
        zzhwVar.getClass();
        return zzhwVar.zzc() * 65536;
    }

    private final int zzs(zzpc zzpcVar) {
        zzhw zzhwVar = (zzhw) this.zzo.get(zzpcVar);
        zzhwVar.getClass();
        return zzhwVar.zzc;
    }

    private static final boolean zzt(boolean z2) {
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zza(zzpc zzpcVar) {
        long id = Thread.currentThread().getId();
        long j = this.zzp;
        zzgmd.zzi(j == -1 || j == id, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.zzp = id;
        ConcurrentHashMap concurrentHashMap = this.zzo;
        zzhw zzhwVar = (zzhw) concurrentHashMap.get(zzpcVar);
        if (zzhwVar == null) {
            concurrentHashMap.put(zzpcVar, new zzhw());
        } else {
            zzhwVar.zza++;
        }
        zzhw zzhwVar2 = (zzhw) concurrentHashMap.get(zzpcVar);
        zzhwVar2.getClass();
        int iZzm = zzm(zzpcVar);
        if (iZzm == -1) {
            iZzm = 13107200;
        }
        zzhwVar2.zzc = iZzm;
        zzhwVar2.zzb = false;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzb(zzkk zzkkVar, zzwv zzwvVar, zzyk[] zzykVarArr) {
        ConcurrentHashMap concurrentHashMap = this.zzo;
        zzpc zzpcVar = zzkkVar.zza;
        int iZzm = zzm(zzpcVar);
        zzhw zzhwVar = (zzhw) concurrentHashMap.get(zzpcVar);
        zzhwVar.getClass();
        if (iZzm == -1) {
            boolean zZzp = zzp(zzkkVar);
            int length = zzykVarArr.length;
            int i2 = 0;
            int i8 = 0;
            while (true) {
                int i9 = 13107200;
                if (i2 < length) {
                    zzyk zzykVar = zzykVarArr[i2];
                    if (zzykVar != null) {
                        switch (zzykVar.zza().zzc) {
                            case -1:
                            case 1:
                                break;
                            case 0:
                                i9 = 144310272;
                                break;
                            case 2:
                                i9 = !zZzp ? 131072000 : 19660800;
                                break;
                            case 3:
                            case 5:
                            default:
                                i9 = 131072;
                                break;
                            case 4:
                                i9 = 26214400;
                                break;
                        }
                        i8 += i9;
                    }
                    i2++;
                } else {
                    iZzm = Math.max(13107200, i8);
                }
            }
        }
        zzhwVar.zzc = iZzm;
        zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzc(zzpc zzpcVar) {
        zzn(zzpcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzd(zzpc zzpcVar) {
        zzn(zzpcVar);
        if (this.zzo.isEmpty()) {
            this.zzp = -1L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final zzyv zze(zzpc zzpcVar) {
        return new zzhv(this, zzpcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final long zzf(zzpc zzpcVar) {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzg(zzpc zzpcVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzh(zzkk zzkkVar) {
        ConcurrentHashMap concurrentHashMap = this.zzo;
        zzpc zzpcVar = zzkkVar.zza;
        zzhw zzhwVar = (zzhw) concurrentHashMap.get(zzpcVar);
        zzhwVar.getClass();
        int iZzr = zzr(zzpcVar);
        int iZzs = zzs(zzpcVar);
        if (zzpcVar.equals(zzpc.zza)) {
            return iZzr < iZzs;
        }
        boolean zZzp = zzp(zzkkVar);
        long jMin = zZzp ? this.zzf : this.zze;
        long j = zZzp ? this.zzh : this.zzg;
        float f4 = zzkkVar.zzf;
        if (f4 > 1.0f) {
            jMin = Math.min(zzep.zzv(jMin, f4), j);
        }
        long j3 = zzkkVar.zze;
        if (j3 < Math.max(jMin, 500000L)) {
            boolean z2 = zzt(zZzp) || iZzr < iZzs;
            zzhwVar.zzb = z2;
            if (!z2 && j3 < 500000) {
                zzdt.zzc("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j3 >= j || iZzr >= iZzs) {
            zzhwVar.zzb = false;
        }
        return zzhwVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzi(zzkk zzkkVar) {
        long jMin;
        boolean z2;
        boolean z7 = zzkkVar.zzg;
        long j = zzkkVar.zze;
        float f4 = zzkkVar.zzf;
        boolean zZzp = zzp(zzkkVar);
        long jZzw = zzep.zzw(j, f4);
        if (z7) {
            if (zZzp) {
                jMin = this.zzl;
                z2 = true;
            } else {
                jMin = this.zzk;
                z2 = false;
            }
        } else if (zZzp) {
            jMin = this.zzj;
            z2 = true;
        } else {
            jMin = this.zzi;
            z2 = false;
        }
        long j3 = zzkkVar.zzh;
        if (j3 != -9223372036854775807L) {
            jMin = Math.min(j3 / 2, jMin);
        }
        if (jMin <= 0 || jZzw >= jMin) {
            return true;
        }
        if (!zzt(z2)) {
            zzpc zzpcVar = zzkkVar.zza;
            if (zzr(zzpcVar) >= zzs(zzpcVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzj(zzpc zzpcVar, zzbf zzbfVar, zzuu zzuuVar, long j) {
        Iterator it = this.zzo.values().iterator();
        while (it.hasNext()) {
            if (((zzhw) it.next()).zzb) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ zzzb zzk() {
        return this.zzd;
    }

    public final /* synthetic */ ConcurrentHashMap zzl() {
        return this.zzo;
    }
}
