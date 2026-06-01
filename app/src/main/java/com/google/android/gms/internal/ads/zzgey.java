package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgey implements zzftm {
    private final Context zza;
    private final zzghy zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;

    public zzgey(Context context, zzfxt zzfxtVar, zzghy zzghyVar) {
        this.zza = context;
        this.zzc = zzfxtVar.zzb();
        this.zzd = zzfxtVar.zzj();
        this.zze = zzfxtVar.zzk();
        this.zzb = zzghyVar;
    }

    public final void zza(Map map) {
        j2.q qVar;
        zzauz zzauzVar;
        map.put("v", this.zzc);
        map.put("t", new Throwable());
        try {
            qVar = (j2.q) map.get("gs");
        } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused) {
        }
        String strZzb = (qVar == null || (Build.VERSION.SDK_INT >= 31 && !qVar.isDone()) || (zzauzVar = (zzauz) qVar.get(this.zzd, TimeUnit.MILLISECONDS)) == null || zzauzVar.zzb().length() <= 1) ? ExifInterface.LONGITUDE_EAST : zzauzVar.zzb();
        if (strZzb.equals(ExifInterface.LONGITUDE_EAST)) {
            try {
                j2.q qVar2 = (j2.q) map.get("ai");
                if (qVar2 != null) {
                    String str = (String) qVar2.get(this.zze, TimeUnit.MILLISECONDS);
                    if (!zzgmu.zzc(str)) {
                        strZzb = str;
                    }
                }
            } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused2) {
            }
        }
        map.put("int", strZzb);
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final Map zzb() {
        Map mapZzb = this.zzb.zzb();
        zza(mapZzb);
        return mapZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final Map zzc() {
        Map mapZzc = this.zzb.zzc(this.zza, null);
        zza(mapZzc);
        return mapZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final Map zzd() {
        Map mapZzd = this.zzb.zzd();
        zza(mapZzd);
        return mapZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzftm
    public final Map zze() {
        HashMap map = new HashMap();
        map.put("t", new Throwable());
        return map;
    }
}
