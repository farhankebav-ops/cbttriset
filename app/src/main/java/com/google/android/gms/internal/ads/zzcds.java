package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcds {
    private static final boolean zza;
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;

    @Nullable
    private final zzbfg zze;

    @Nullable
    private final zzbfj zzf;
    private final com.google.android.gms.ads.internal.util.zzbf zzg;
    private final long[] zzh;
    private final String[] zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private zzccx zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;

    static {
        zza = com.google.android.gms.ads.internal.client.zzbb.zze().nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznJ)).intValue();
    }

    public zzcds(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzbfj zzbfjVar, @Nullable zzbfg zzbfgVar) {
        com.google.android.gms.ads.internal.util.zzbe zzbeVar = new com.google.android.gms.ads.internal.util.zzbe();
        zzbeVar.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbeVar.zza("1_5", 1.0d, 5.0d);
        zzbeVar.zza("5_10", 5.0d, 10.0d);
        zzbeVar.zza("10_20", 10.0d, 20.0d);
        zzbeVar.zza("20_30", 20.0d, 30.0d);
        zzbeVar.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzg = zzbeVar.zzb();
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzr = -1L;
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zzc = str;
        this.zzf = zzbfjVar;
        this.zze = zzbfgVar;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzV);
        if (str2 == null) {
            this.zzi = new String[0];
            this.zzh = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        int length = strArrSplit.length;
        this.zzi = new String[length];
        this.zzh = new long[length];
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                this.zzh[i2] = Long.parseLong(strArrSplit[i2]);
            } catch (NumberFormatException e) {
                int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to parse frame hash target time number.", e);
                this.zzh[i2] = -1;
            }
        }
    }

    public final void zza(zzccx zzccxVar) {
        zzbfj zzbfjVar = this.zzf;
        zzbfb.zza(zzbfjVar, this.zze, "vpc2");
        this.zzj = true;
        zzbfjVar.zzd("vpn", zzccxVar.zza());
        this.zzo = zzccxVar;
    }

    public final void zzb() {
        if (!this.zzj || this.zzk) {
            return;
        }
        zzbfb.zza(this.zzf, this.zze, "vfr2");
        this.zzk = true;
    }

    public final void zzc() {
        if (!zza || this.zzp) {
            return;
        }
        Bundle bundleC = androidx.camera.core.processing.util.a.c("type", "native-player-metrics");
        bundleC.putString(AdActivity.REQUEST_KEY_EXTRA, this.zzc);
        bundleC.putString("player", this.zzo.zza());
        for (com.google.android.gms.ads.internal.util.zzbd zzbdVar : this.zzg.zzb()) {
            String str = zzbdVar.zza;
            String strValueOf = String.valueOf(str);
            bundleC.putString("fps_c_".concat(strValueOf), Integer.toString(zzbdVar.zze));
            String strValueOf2 = String.valueOf(str);
            bundleC.putString("fps_p_".concat(strValueOf2), Double.toString(zzbdVar.zzd));
        }
        int i2 = 0;
        while (true) {
            long[] jArr = this.zzh;
            if (i2 >= jArr.length) {
                com.google.android.gms.ads.internal.zzt.zzc().zzg(this.zzb, this.zzd.afmaVersion, "gmob-apps", bundleC, true);
                this.zzp = true;
                return;
            }
            String str2 = this.zzi[i2];
            if (str2 != null) {
                Long lValueOf = Long.valueOf(jArr[i2]);
                new StringBuilder(lValueOf.toString().length() + 3);
                bundleC.putString("fh_".concat(lValueOf.toString()), str2);
            }
            i2++;
        }
    }

    public final void zzd(zzccx zzccxVar) {
        if (this.zzl && !this.zzm) {
            if (com.google.android.gms.ads.internal.util.zze.zzc() && !this.zzm) {
                com.google.android.gms.ads.internal.util.zze.zza("VideoMetricsMixin first frame");
            }
            zzbfb.zza(this.zzf, this.zze, "vff2");
            this.zzm = true;
        }
        long jNanoTime = com.google.android.gms.ads.internal.zzt.zzk().nanoTime();
        if (this.zzn && this.zzq && this.zzr != -1) {
            this.zzg.zza(TimeUnit.SECONDS.toNanos(1L) / (jNanoTime - this.zzr));
        }
        this.zzq = this.zzn;
        this.zzr = jNanoTime;
        long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzW)).longValue();
        long jZzh = zzccxVar.zzh();
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzi;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null && jLongValue > Math.abs(jZzh - this.zzh[i2])) {
                int i8 = 8;
                Bitmap bitmap = zzccxVar.getBitmap(8, 8);
                long j = 63;
                long j3 = 0;
                int i9 = 0;
                while (i9 < i8) {
                    int i10 = 0;
                    while (i10 < i8) {
                        int pixel = bitmap.getPixel(i10, i9);
                        j3 |= (Color.green(pixel) + (Color.red(pixel) + Color.blue(pixel)) > 128 ? 1L : 0L) << ((int) j);
                        j--;
                        i10++;
                        i8 = 8;
                    }
                    i9++;
                    i8 = 8;
                }
                strArr[i2] = String.format("%016X", Long.valueOf(j3));
                return;
            }
            i2++;
        }
    }

    public final void zze() {
        this.zzn = true;
        if (!this.zzk || this.zzl) {
            return;
        }
        zzbfb.zza(this.zzf, this.zze, "vfp2");
        this.zzl = true;
    }

    public final void zzf() {
        this.zzn = false;
    }
}
