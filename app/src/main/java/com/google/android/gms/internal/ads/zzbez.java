package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class zzbez {

    @VisibleForTesting
    String zzd;

    @VisibleForTesting
    Context zze;

    @VisibleForTesting
    String zzf;
    private AtomicBoolean zzh;
    private File zzi;

    @VisibleForTesting
    final BlockingQueue zza = new ArrayBlockingQueue(100);

    @VisibleForTesting
    final LinkedHashMap zzb = new LinkedHashMap();

    @VisibleForTesting
    final Map zzc = new HashMap();
    private final HashSet zzg = new HashSet(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));

    private final void zzg(Map map, zzbfi zzbfiVar) throws Throwable {
        Uri.Builder builderBuildUpon = Uri.parse(this.zzd).buildUpon();
        for (Map.Entry entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String string = builderBuildUpon.build().toString();
        if (zzbfiVar != null) {
            StringBuilder sb = new StringBuilder(string);
            if (!TextUtils.isEmpty(zzbfiVar.zza())) {
                sb.append("&it=");
                sb.append(zzbfiVar.zza());
            }
            if (!TextUtils.isEmpty(zzbfiVar.zzb())) {
                sb.append("&blat=");
                sb.append(zzbfiVar.zzb());
            }
            string = sb.toString();
        }
        if (!this.zzh.get()) {
            com.google.android.gms.ads.internal.zzt.zzc();
            com.google.android.gms.ads.internal.util.zzs.zzP(this.zze, this.zzf, string);
            return;
        }
        File file = this.zzi;
        if (file == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("CsiReporter: File doesn't exist. Cannot write CSI data to file.");
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                try {
                    fileOutputStream2.write(string.getBytes());
                    fileOutputStream2.write(10);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        int i8 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("CsiReporter: Cannot close file: sdk_csi_data.txt.", e);
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream = fileOutputStream2;
                    int i9 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("CsiReporter: Cannot close file: sdk_csi_data.txt.", e8);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e9) {
                            int i10 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("CsiReporter: Cannot close file: sdk_csi_data.txt.", e9);
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void zza(Context context, String str, String str2, Map map) {
        File externalStorageDirectory;
        this.zze = context;
        this.zzf = str;
        this.zzd = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.zzh = atomicBoolean;
        atomicBoolean.set(((Boolean) zzbgp.zzc.zze()).booleanValue());
        if (this.zzh.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzi = new File(zzftx.zza().zza(externalStorageDirectory, "sdk_csi_data.txt"));
        }
        for (Map.Entry entry : map.entrySet()) {
            this.zzb.put((String) entry.getKey(), (String) entry.getValue());
        }
        zzcbv.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbey
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() throws Throwable {
                this.zza.zzf();
            }
        });
        Map map2 = this.zzc;
        zzbff zzbffVar = zzbff.zzb;
        map2.put("action", zzbffVar);
        map2.put(FirebaseAnalytics.Param.AD_FORMAT, zzbffVar);
        map2.put("e", zzbff.zzc);
    }

    public final boolean zzb(zzbfj zzbfjVar) {
        return this.zza.offer(zzbfjVar);
    }

    public final Map zzc(Map map, @Nullable Map map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            linkedHashMap.put(str, zzd(str).zza((String) linkedHashMap.get(str), str2));
        }
        return linkedHashMap;
    }

    public final zzbff zzd(String str) {
        zzbff zzbffVar = (zzbff) this.zzc.get(str);
        return zzbffVar != null ? zzbffVar : zzbff.zza;
    }

    public final void zze(String str) throws Throwable {
        if (this.zzg.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sdkVersion", this.zzf);
        linkedHashMap.put("ue", str);
        zzg(zzc(this.zzb, linkedHashMap), null);
    }

    public final /* synthetic */ void zzf() throws Throwable {
        while (true) {
            try {
                zzbfj zzbfjVar = (zzbfj) this.zza.take();
                zzbfi zzbfiVarZzc = zzbfjVar.zzc();
                if (!TextUtils.isEmpty(zzbfiVarZzc.zza())) {
                    zzg(zzc(this.zzb, zzbfjVar.zze()), zzbfiVarZzc);
                }
            } catch (InterruptedException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }
}
