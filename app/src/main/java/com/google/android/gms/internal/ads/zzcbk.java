package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdActivity;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcbk {

    @VisibleForTesting
    final String zzf;
    private final com.google.android.gms.ads.internal.util.zzg zzk;

    @VisibleForTesting
    long zza = -1;

    @VisibleForTesting
    long zzb = -1;

    @VisibleForTesting
    int zzc = -1;

    @VisibleForTesting
    int zzd = -1;

    @VisibleForTesting
    long zze = 0;
    private final Object zzj = new Object();

    @VisibleForTesting
    int zzg = 0;

    @VisibleForTesting
    int zzh = 0;

    @VisibleForTesting
    int zzi = 0;

    public zzcbk(String str, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzf = str;
        this.zzk = zzgVar;
    }

    private final void zzi() {
        if (((Boolean) zzbhb.zza.zze()).booleanValue()) {
            synchronized (this.zzj) {
                this.zzc--;
                this.zzd--;
            }
        }
    }

    public final void zza() {
        synchronized (this.zzj) {
            this.zzg++;
        }
    }

    public final void zzb() {
        synchronized (this.zzj) {
            this.zzh++;
        }
    }

    public final void zzc() {
        synchronized (this.zzj) {
            this.zzi++;
        }
    }

    public final int zzd() {
        int i2;
        synchronized (this.zzj) {
            i2 = this.zzi;
        }
        return i2;
    }

    public final void zze(com.google.android.gms.ads.internal.client.zzm zzmVar, long j) {
        Bundle bundle;
        synchronized (this.zzj) {
            try {
                com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzk;
                long jZzm = zzgVar.zzm();
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
                if (this.zzb == -1) {
                    if (jCurrentTimeMillis - jZzm > ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbm)).longValue()) {
                        this.zzd = -1;
                    } else {
                        this.zzd = zzgVar.zzo();
                    }
                    this.zzb = j;
                    this.zza = j;
                } else {
                    this.zza = j;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzef)).booleanValue() || (bundle = zzmVar.zzc) == null || bundle.getInt("gw", 2) != 1) {
                    this.zzc++;
                    int i2 = this.zzd + 1;
                    this.zzd = i2;
                    if (i2 == 0) {
                        this.zze = 0L;
                        zzgVar.zzp(jCurrentTimeMillis);
                    } else {
                        this.zze = jCurrentTimeMillis - zzgVar.zzq();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzf() {
        zzi();
    }

    public final void zzg() {
        zzi();
    }

    public final Bundle zzh(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzj) {
            try {
                bundle = new Bundle();
                if (!this.zzk.zzx()) {
                    bundle.putString("session_id", this.zzf);
                }
                bundle.putLong("basets", this.zzb);
                bundle.putLong("currts", this.zza);
                bundle.putString("seq_num", str);
                bundle.putInt("preqs", this.zzc);
                bundle.putInt("preqs_in_session", this.zzd);
                bundle.putLong("time_in_session", this.zze);
                bundle.putInt("pclick", this.zzg);
                bundle.putInt("pimp", this.zzh);
                Context contextZza = zzbxt.zza(context);
                int identifier = contextZza.getResources().getIdentifier("Theme.Translucent", "style", "android");
                boolean z2 = false;
                if (identifier == 0) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                } else {
                    try {
                        if (identifier == contextZza.getPackageManager().getActivityInfo(new ComponentName(contextZza.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                            z2 = true;
                        } else {
                            int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        int i9 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Fail to fetch AdActivity theme");
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                    }
                }
                bundle.putBoolean("support_transparent_background", z2);
                bundle.putInt("consent_form_action_identifier", zzd());
            } catch (Throwable th) {
                throw th;
            }
        }
        return bundle;
    }
}
