package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcfn extends zzcfe implements zzcdh {
    public static final /* synthetic */ int zzd = 0;
    private zzcdi zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcew zzi;
    private long zzj;
    private long zzk;

    public zzcfn(zzcdr zzcdrVar, zzcdq zzcdqVar) {
        super(zzcdrVar);
        zzcgg zzcggVar = new zzcgg(zzcdrVar.getContext(), zzcdqVar, (zzcdr) this.zzc.get(), null);
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("ExoPlayerAdapter initialized.");
        this.zze = zzcggVar;
        zzcggVar.zzs(this);
    }

    public static final String zzc(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.zzf(str)));
    }

    private final void zzd(long j) {
        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb();
            }
        }, j);
    }

    private static String zzx(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1 + String.valueOf(message).length());
        androidx.camera.core.processing.util.a.A(sb, str, "/", canonicalName, ":");
        sb.append(message);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzcfe, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcdi zzcdiVar = this.zze;
        if (zzcdiVar != null) {
            zzcdiVar.zzs(null);
            this.zze.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzD() {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Precache onRenderedFirstFrame");
    }

    public final zzcdi zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzs(null);
        zzcdi zzcdiVar = this.zze;
        this.zze = null;
        return zzcdiVar;
    }

    public final /* synthetic */ void zzb() {
        long jLongValue;
        long jIntValue;
        boolean zBooleanValue;
        long j;
        long j3;
        long j8;
        String strZzc = zzc(this.zzf);
        try {
            jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzS)).longValue() * 1000;
            jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzv)).intValue();
            zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue();
        } catch (Exception e) {
            String str = this.zzf;
            String message = e.getMessage();
            String strN = androidx.camera.core.processing.util.a.n(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length()), "Failed to preload url ", str, " Exception: ", message);
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(strN);
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(this.zzf, strZzc, "error", zzx("error", e));
        }
        synchronized (this) {
            if (com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zzj > jLongValue) {
                StringBuilder sb = new StringBuilder(String.valueOf(jLongValue).length() + 27);
                sb.append("Timeout reached. Limit: ");
                sb.append(jLongValue);
                sb.append(" ms");
                throw new IOException(sb.toString());
            }
            if (this.zzg) {
                throw new IOException("Abort requested before buffering finished. ");
            }
            if (!this.zzh) {
                if (!this.zze.zzB()) {
                    throw new IOException("ExoPlayer was released during preloading.");
                }
                long jZzH = this.zze.zzH();
                if (jZzH > 0) {
                    long jZzN = this.zze.zzN();
                    if (jZzN != this.zzk) {
                        boolean z2 = jZzN > 0;
                        j3 = jZzH;
                        j8 = jZzN;
                        j = jIntValue;
                        zzm(this.zzf, strZzc, j8, j3, z2, zBooleanValue ? this.zze.zzI() : -1L, zBooleanValue ? this.zze.zzJ() : -1L, zBooleanValue ? this.zze.zzK() : -1L, zzcdi.zzP(), zzcdi.zzQ());
                        this.zzk = j8;
                    } else {
                        j = jIntValue;
                        j3 = jZzH;
                        j8 = jZzN;
                    }
                    if (j8 >= j3) {
                        zzp(this.zzf, strZzc, j3);
                    } else if (this.zze.zzO() >= j && j8 > 0) {
                    }
                }
                zzd(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzT)).longValue());
                return;
            }
            com.google.android.gms.ads.internal.zzt.zzB().zzd(this.zzi);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final boolean zze(String str) {
        return zzf(str, new String[]{str});
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final boolean zzf(String str, String[] strArr) {
        Clock clock;
        String str2;
        String str3;
        long j;
        long j3;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        boolean z2;
        this.zzf = str;
        String strZzc = zzc(str);
        String str4 = " ms";
        String str5 = "Timeout reached. Limit: ";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                uriArr[i2] = Uri.parse(strArr[i2]);
            }
            this.zze.zzq(uriArr, this.zzb);
            zzcdr zzcdrVar = (zzcdr) this.zzc.get();
            if (zzcdrVar != null) {
                zzcdrVar.zzt(strZzc, this);
            }
            Clock clockZzk = com.google.android.gms.ads.internal.zzt.zzk();
            long jCurrentTimeMillis = clockZzk.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzT)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzS)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzv)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue();
            long j13 = -1;
            while (true) {
                synchronized (this) {
                    if (clockZzk.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                        long j14 = jLongValue2;
                        StringBuilder sb = new StringBuilder(String.valueOf(j14).length() + 27);
                        sb.append(str5);
                        sb.append(j14);
                        sb.append(str4);
                        throw new IOException(sb.toString());
                    }
                    if (this.zzg) {
                        throw new IOException("Abort requested before buffering finished. ");
                    }
                    if (!this.zzh) {
                        if (!this.zze.zzB()) {
                            throw new IOException("ExoPlayer was released during preloading.");
                        }
                        long jZzH = this.zze.zzH();
                        if (jZzH > 0) {
                            clock = clockZzk;
                            long jZzN = this.zze.zzN();
                            if (jZzN != j13) {
                                if (jZzN > 0) {
                                    j12 = jLongValue2;
                                    z2 = true;
                                } else {
                                    j12 = jLongValue2;
                                    z2 = false;
                                }
                                long j15 = jLongValue;
                                j10 = jZzH;
                                str3 = str5;
                                j9 = j15;
                                str2 = str4;
                                j11 = jZzN;
                                j3 = jIntValue;
                                j = j12;
                                zzm(str, strZzc, j11, j10, z2, zBooleanValue ? this.zze.zzI() : -1L, zBooleanValue ? this.zze.zzJ() : -1L, zBooleanValue ? this.zze.zzK() : -1L, zzcdi.zzP(), zzcdi.zzQ());
                                j13 = j11;
                            } else {
                                str3 = str5;
                                j9 = jLongValue;
                                j3 = jIntValue;
                                j10 = jZzH;
                                str2 = str4;
                                j = jLongValue2;
                                j11 = jZzN;
                            }
                            if (j11 >= j10) {
                                zzp(str, strZzc, j10);
                            } else if (this.zze.zzO() < j3 || j11 <= 0) {
                                j8 = j9;
                            }
                        } else {
                            clock = clockZzk;
                            str2 = str4;
                            str3 = str5;
                            j = jLongValue2;
                            j3 = jIntValue;
                            j8 = jLongValue;
                        }
                        try {
                            wait(j8);
                        } catch (InterruptedException unused) {
                            throw new IOException("Wait interrupted.");
                        }
                    }
                }
                jLongValue = j8;
                str4 = str2;
                jLongValue2 = j;
                jIntValue = j3;
                str5 = str3;
                clockZzk = clock;
            }
            return true;
        } catch (Exception e) {
            String message = e.getMessage();
            String strN = androidx.camera.core.processing.util.a.n(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length()), "Failed to preload url ", str, " Exception: ", message);
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(strN);
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(str, strZzc, "error", zzx("error", e));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final boolean zzg(String str, String[] strArr, zzcew zzcewVar) {
        this.zzf = str;
        this.zzi = zzcewVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                uriArr[i2] = Uri.parse(strArr[i2]);
            }
            this.zze.zzq(uriArr, this.zzb);
            zzcdr zzcdrVar = (zzcdr) this.zzc.get();
            if (zzcdrVar != null) {
                zzcdrVar.zzt(strZzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            this.zzk = -1L;
            zzd(0L);
            return true;
        } catch (Exception e) {
            String message = e.getMessage();
            String strN = androidx.camera.core.processing.util.a.n(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length()), "Failed to preload url ", str, " Exception: ", message);
            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(strN);
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(str, strZzc, "error", zzx("error", e));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzh(int i2) {
        this.zze.zzG(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzi(int i2) {
        this.zze.zzF(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzj(int i2) {
        this.zze.zzy(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzk(int i2) {
        this.zze.zzz(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzl() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzq(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzr(final boolean z2, final long j) {
        final zzcdr zzcdrVar = (zzcdr) this.zzc.get();
        if (zzcdrVar != null) {
            zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcdrVar.zzu(z2, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzu(String str, Exception exc) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzv(String str, Exception exc) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache exception", exc);
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzs(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdh
    public final void zzt(int i2, int i8) {
    }
}
