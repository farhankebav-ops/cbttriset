package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbnv implements zzapn {
    private volatile zzbni zza;
    private final Context zzb;

    public zzbnv(Context context) {
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzapn
    @Nullable
    public final zzapq zza(zzapu zzapuVar) throws zzaqd {
        Parcelable.Creator<zzbnj> creator = zzbnj.CREATOR;
        Map mapZzm = zzapuVar.zzm();
        int size = mapZzm.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i2 = 0;
        for (Map.Entry entry : mapZzm.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzbnj zzbnjVar = new zzbnj(zzapuVar.zzh(), strArr, strArr2);
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
        try {
            zzcca zzccaVar = new zzcca();
            this.zza = new zzbni(this.zzb, com.google.android.gms.ads.internal.zzt.zzs().zza(), new zzbnt(this, zzccaVar), new zzbnu(this, zzccaVar));
            this.zza.checkAvailabilityAndConnect();
            zzbnr zzbnrVar = new zzbnr(this, zzbnjVar);
            zzgus zzgusVar = zzcbv.zza;
            j2.q qVarZzi = zzgui.zzi(zzgui.zzj(zzccaVar, zzbnrVar, zzgusVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfa)).intValue(), TimeUnit.MILLISECONDS, zzcbv.zzd);
            qVarZzi.addListener(new zzbns(this), zzgusVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) qVarZzi.get();
            long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
            StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime2).length() + 32);
            sb.append("Http assets remote cache took ");
            sb.append(jElapsedRealtime2);
            sb.append("ms");
            com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
            zzbnl zzbnlVar = (zzbnl) new zzbxh(parcelFileDescriptor).zza(zzbnl.CREATOR);
            if (zzbnlVar == null) {
                return null;
            }
            if (zzbnlVar.zza) {
                throw new zzaqd(zzbnlVar.zzb);
            }
            String[] strArr3 = zzbnlVar.zze;
            String[] strArr4 = zzbnlVar.zzf;
            if (strArr3.length != strArr4.length) {
                return null;
            }
            HashMap map = new HashMap();
            for (int i8 = 0; i8 < strArr3.length; i8++) {
                map.put(strArr3[i8], strArr4[i8]);
            }
            return new zzapq(zzbnlVar.zzc, zzbnlVar.zzd, map, zzbnlVar.zzg, zzbnlVar.zzh);
        } catch (InterruptedException | ExecutionException unused) {
            long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
            StringBuilder sb2 = new StringBuilder(String.valueOf(jElapsedRealtime3).length() + 32);
            sb2.append("Http assets remote cache took ");
            sb2.append(jElapsedRealtime3);
            sb2.append("ms");
            com.google.android.gms.ads.internal.util.zze.zza(sb2.toString());
            return null;
        } catch (Throwable th) {
            long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
            StringBuilder sb3 = new StringBuilder(String.valueOf(jElapsedRealtime4).length() + 32);
            sb3.append("Http assets remote cache took ");
            sb3.append(jElapsedRealtime4);
            sb3.append("ms");
            com.google.android.gms.ads.internal.util.zze.zza(sb3.toString());
            throw th;
        }
    }

    public final /* synthetic */ void zzb() {
        if (this.zza == null) {
            return;
        }
        this.zza.disconnect();
        Binder.flushPendingCommands();
    }

    public final /* synthetic */ zzbni zzc() {
        return this.zza;
    }
}
