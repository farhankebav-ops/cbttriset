package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.internal.ads.zzbdz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbdt {
    private final zzbdy zza;
    private final zzbdz.zzt.zza zzb;
    private final boolean zzc;

    private zzbdt() {
        this.zzb = zzbdz.zzt.zzx();
        this.zzc = false;
        this.zza = new zzbdy();
    }

    public static zzbdt zza() {
        return new zzbdt();
    }

    private final synchronized void zzd(int i2) {
        zzbdz.zzt.zza zzaVar = this.zzb;
        zzaVar.zzE();
        zzaVar.zzD(com.google.android.gms.ads.internal.util.zzs.zzk());
        zzbdx zzbdxVar = new zzbdx(this.zza, zzaVar.zzbu().zzaN(), null);
        int i8 = i2 - 1;
        zzbdxVar.zzb(i8);
        zzbdxVar.zza();
        com.google.android.gms.ads.internal.util.zze.zza("Logging Event with event code : ".concat(String.valueOf(Integer.toString(i8, 10))));
    }

    private final synchronized void zze(int i2) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(zzftx.zza().zza(externalStorageDirectory, "clearcut_events.txt")), true);
            try {
                try {
                    fileOutputStream.write(zzf(i2).getBytes());
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                    }
                }
            } catch (IOException unused2) {
                com.google.android.gms.ads.internal.util.zze.zza("Could not write Clearcut to file.");
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    com.google.android.gms.ads.internal.util.zze.zza("Could not close Clearcut output stream.");
                }
            }
        } catch (FileNotFoundException unused4) {
            com.google.android.gms.ads.internal.util.zze.zza("Could not find file for Clearcut");
        }
    }

    private final synchronized String zzf(int i2) {
        StringBuilder sb;
        zzbdz.zzt.zza zzaVar = this.zzb;
        String strZzf = zzaVar.zzf();
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
        String strEncodeToString = Base64.encodeToString(zzaVar.zzbu().zzaN(), 3);
        sb = new StringBuilder("id=");
        sb.append(strZzf);
        sb.append(",timestamp=");
        sb.append(jElapsedRealtime);
        sb.append(",event=");
        sb.append(i2 - 1);
        sb.append(",data=");
        sb.append(strEncodeToString);
        sb.append("\n");
        return sb.toString();
    }

    public final synchronized void zzb(zzbds zzbdsVar) {
        if (this.zzc) {
            try {
                zzbdsVar.zza(this.zzb);
            } catch (NullPointerException e) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    public final synchronized void zzc(int i2) {
        if (this.zzc) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfK)).booleanValue()) {
                zze(i2);
            } else {
                zzd(i2);
            }
        }
    }

    public zzbdt(zzbdy zzbdyVar) {
        this.zzb = zzbdz.zzt.zzx();
        this.zza = zzbdyVar;
        this.zzc = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfJ)).booleanValue();
    }
}
