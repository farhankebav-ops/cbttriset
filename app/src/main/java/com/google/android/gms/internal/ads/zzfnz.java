package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfnz {
    private final zzfon zzc;
    private final zzfnv zzd;
    private final Context zze;

    @Nullable
    private volatile ConnectivityManager zzf;
    private final Clock zzh;
    private AtomicInteger zzi;
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    private final ConcurrentMap zza = new ConcurrentHashMap();
    private final ConcurrentMap zzb = new ConcurrentHashMap();

    public zzfnz(zzfon zzfonVar, zzfnv zzfnvVar, Context context, Clock clock) {
        this.zzc = zzfonVar;
        this.zzd = zzfnvVar;
        this.zze = context;
        this.zzh = clock;
    }

    public static String zzh(String str, @Nullable AdFormat adFormat) {
        String strName = adFormat == null ? "NULL" : adFormat.name();
        return a1.a.s(new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(strName).length()), str, "#", strName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzi(boolean z2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzx)).booleanValue()) {
            zzj(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzj(boolean z2) {
        try {
            if (z2) {
                Iterator it = this.zza.values().iterator();
                while (it.hasNext()) {
                    ((zzfom) it.next()).zzh();
                }
            } else {
                Iterator it2 = this.zza.values().iterator();
                while (it2.hasNext()) {
                    ((zzfom) it2.next()).zzg();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00f8 A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:3:0x0001, B:4:0x000f, B:6:0x0015, B:8:0x0034, B:10:0x003c, B:13:0x004b, B:14:0x0051, B:16:0x0059, B:18:0x0067, B:19:0x0076, B:20:0x007a, B:21:0x007e, B:22:0x0088, B:24:0x008e, B:26:0x00a0, B:27:0x00b5, B:28:0x00bf, B:30:0x00c5, B:32:0x00e6, B:35:0x00fb, B:37:0x0101, B:34:0x00f8), top: B:43:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized java.util.List zzm(java.util.List r9) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfnz.zzm(java.util.List):java.util.List");
    }

    private final synchronized void zzn(String str, zzfom zzfomVar) {
        zzfomVar.zzc();
        this.zza.put(str, zzfomVar);
    }

    private final synchronized boolean zzo(String str, AdFormat adFormat) {
        boolean z2;
        try {
            Clock clock = this.zzh;
            long jCurrentTimeMillis = clock.currentTimeMillis();
            zzfom zzfomVarZzq = zzq(str, adFormat);
            int iZzn = 0;
            z2 = zzfomVarZzq != null && zzfomVarZzq.zzd();
            Long lValueOf = z2 ? Long.valueOf(clock.currentTimeMillis()) : null;
            zzfoc zzfocVar = new zzfoc(new zzfob(str, adFormat), null);
            zzfnv zzfnvVar = this.zzd;
            int i2 = zzfomVarZzq == null ? 0 : zzfomVarZzq.zze.zzd;
            if (zzfomVarZzq != null) {
                iZzn = zzfomVarZzq.zzn();
            }
            zzfnvVar.zzd(i2, iZzn, jCurrentTimeMillis, lValueOf, zzfomVarZzq != null ? zzfomVarZzq.zzi() : null, zzfocVar, "1");
        } catch (Throwable th) {
            throw th;
        }
        return z2;
    }

    @Nullable
    private final synchronized Object zzp(Class cls, String str, AdFormat adFormat) {
        zzfoc zzfocVar = new zzfoc(new zzfob(str, adFormat), null);
        zzfnv zzfnvVar = this.zzd;
        Clock clock = this.zzh;
        zzfnvVar.zzf(clock.currentTimeMillis(), zzfocVar, -1, -1, "1");
        zzfom zzfomVarZzq = zzq(str, adFormat);
        if (zzfomVarZzq == null) {
            return null;
        }
        try {
            String strZzi = zzfomVarZzq.zzi();
            Object objZze = zzfomVarZzq.zze();
            Object objCast = objZze == null ? null : cls.cast(objZze);
            if (objCast != null) {
                zzfnvVar.zzh(clock.currentTimeMillis(), zzfomVarZzq.zze.zzd, zzfomVarZzq.zzn(), strZzi, zzfocVar, "1");
            }
            return objCast;
        } catch (ClassCastException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "PreloadAdManager.pollAd");
            com.google.android.gms.ads.internal.util.zze.zzb("Unable to cast ad to the requested type:".concat(cls.getName()), e);
            return null;
        }
    }

    @Nullable
    private final synchronized zzfom zzq(String str, AdFormat adFormat) {
        return (zzfom) this.zza.get(zzh(str, adFormat));
    }

    public final synchronized void zza(List list, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        try {
            if (!this.zzg.getAndSet(true)) {
                if (this.zzf == null) {
                    synchronized (this) {
                        if (this.zzf == null) {
                            try {
                                this.zzf = (ConnectivityManager) this.zze.getSystemService("connectivity");
                            } catch (ClassCastException e) {
                                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get connectivity manager", e);
                            }
                        }
                    }
                }
                if (!PlatformVersion.isAtLeastO() || this.zzf == null) {
                    this.zzi = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzF)).intValue());
                } else {
                    try {
                        this.zzf.registerDefaultNetworkCallback(new zzfny(this));
                    } catch (RuntimeException e4) {
                        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to register network callback", e4);
                        this.zzi = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzF)).intValue());
                    }
                }
                com.google.android.gms.ads.internal.zzt.zzg().zzb(new zzfnx(this));
            }
            List<com.google.android.gms.ads.internal.client.zzft> listZzm = zzm(list);
            EnumMap enumMap = new EnumMap(AdFormat.class);
            for (com.google.android.gms.ads.internal.client.zzft zzftVar : listZzm) {
                String str = zzftVar.zza;
                AdFormat adFormat = AdFormat.getAdFormat(zzftVar.zzb);
                zzfom zzfomVarZza = this.zzc.zza(zzftVar, zzceVar);
                if (adFormat != null && zzfomVarZza != null) {
                    AtomicInteger atomicInteger = this.zzi;
                    if (atomicInteger != null) {
                        zzfomVarZza.zzk(atomicInteger.get());
                    }
                    zzfnv zzfnvVar = this.zzd;
                    zzfomVarZza.zzj(zzfnvVar);
                    zzn(zzh(str, adFormat), zzfomVarZza);
                    enumMap.put(adFormat, Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzd(enumMap, adFormat, 0)).intValue() + 1));
                    zzfnvVar.zza(zzftVar.zzd, this.zzh.currentTimeMillis(), new zzfoc(new zzfob(str, adFormat), null), "1");
                }
            }
            this.zzd.zzb(enumMap, this.zzh.currentTimeMillis(), "1");
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean zzb(String str) {
        return zzo(str, AdFormat.REWARDED);
    }

    @Nullable
    public final synchronized zzbyo zzc(String str) {
        return (zzbyo) zzp(zzbyo.class, str, AdFormat.REWARDED);
    }

    public final synchronized boolean zzd(String str) {
        return zzo(str, AdFormat.APP_OPEN_AD);
    }

    @Nullable
    public final synchronized zzbcn zze(String str) {
        return (zzbcn) zzp(zzbcn.class, str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized boolean zzf(String str) {
        return zzo(str, AdFormat.INTERSTITIAL);
    }

    @Nullable
    public final synchronized com.google.android.gms.ads.internal.client.zzbx zzg(String str) {
        return (com.google.android.gms.ads.internal.client.zzbx) zzp(com.google.android.gms.ads.internal.client.zzbx.class, str, AdFormat.INTERSTITIAL);
    }
}
