package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfzw implements zzfzn, zzfzj, zzgac {
    private static final zziaa zza;
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private final ExecutorService zzd;
    private final zzfys zze;
    private final boolean zzf;
    private final String zzg;
    private final long zzh;
    private final long zzi;
    private final double zzj;
    private final String zzk;
    private final long zzl;
    private final AtomicBoolean zzm = new AtomicBoolean(false);
    private final Object zzn = new Object();
    private final Object zzo = new Object();
    private final Object zzp = new Object();
    private final zzatf zzq = zzatg.zza();
    private final List zzr = new ArrayList();
    private boolean zzs = false;
    private final HashMap zzt = new HashMap();

    static {
        zzhzz zzhzzVarZzc = zziaa.zzc();
        zzhzzVarZzc.zza(17);
        zza = (zziaa) zzhzzVarZzc.zzbu();
    }

    public zzfzw(Context context, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, zzfys zzfysVar, Random random, String str, long j, long j3, double d8, String str2, long j8) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
        this.zzd = executorService;
        this.zze = zzfysVar;
        this.zzg = str;
        this.zzh = j;
        this.zzi = j3;
        this.zzj = d8;
        this.zzk = str2;
        this.zzl = j8;
        this.zzf = random.nextDouble() < d8;
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    public final j2.q zza() {
        return zzgui.zze(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfzu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzf();
            }
        }, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzfzn
    public final void zzb(int i2, long j, Throwable th, String str) {
        long jLongValue;
        if (this.zzf) {
            synchronized (this.zzo) {
                try {
                    List list = this.zzr;
                    synchronized (this.zzp) {
                        try {
                            HashMap map = this.zzt;
                            Integer numValueOf = Integer.valueOf(i2);
                            Long l = (Long) map.get(numValueOf);
                            if (l == null) {
                                l = 0L;
                            }
                            jLongValue = 1 + l.longValue();
                            map.put(numValueOf, Long.valueOf(jLongValue));
                        } finally {
                        }
                    }
                    list.add(new zzfzt(i2, j, th, str, jLongValue));
                    if (!this.zzs) {
                        this.zzs = true;
                        this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfzv
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzd();
                            }
                        }, this.zzi, TimeUnit.MILLISECONDS);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgac
    public final void zzc(zzgab zzgabVar) {
        synchronized (this.zzn) {
            this.zzq.zzj(zzgabVar.zza());
        }
    }

    public final void zzd() {
        zzatf zzatfVar;
        zzgpe zzgpeVarZzq;
        String string;
        StringWriter stringWriter;
        synchronized (this.zzn) {
            zzatfVar = (zzatf) this.zzq.clone();
        }
        synchronized (this.zzo) {
            List list = this.zzr;
            zzgpeVarZzq = zzgpe.zzq(list);
            list.clear();
            this.zzs = false;
        }
        int size = zzgpeVarZzq.size();
        int i2 = 0;
        int i8 = 0;
        while (i2 < size) {
            zzfzt zzfztVar = (zzfzt) zzgpeVarZzq.get(i2);
            if (i8 >= this.zzh) {
                zze((zzatg) zzatfVar.zzbu());
                zzatfVar.zzb();
                i8 = 0;
            }
            zzatx zzatxVarZza = zzaty.zza();
            zzatxVarZza.zza(zzfztVar.zza);
            zzatxVarZza.zzb(zzfztVar.zzb);
            zzatxVarZza.zze(zzfztVar.zze);
            String str = zzfztVar.zzd;
            if (str != null) {
                zzatxVarZza.zzf(str);
            }
            Throwable th = zzfztVar.zzc;
            zzatxVarZza.zzg(th == null ? 2 : 3);
            if (th != null) {
                zzatxVarZza.zzc(th.getClass().getName());
                try {
                    stringWriter = new StringWriter();
                } catch (IOException unused) {
                    string = "";
                }
                try {
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    try {
                        th.printStackTrace(printWriter);
                        string = stringWriter.toString();
                        printWriter.close();
                        stringWriter.close();
                        zzatxVarZza.zzd(string);
                    } catch (Throwable th2) {
                        try {
                            printWriter.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    try {
                        stringWriter.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                    throw th4;
                }
            }
            zzatfVar.zza((zzaty) zzatxVarZza.zzbu());
            i2++;
            i8++;
        }
        if (i8 > 0) {
            zze((zzatg) zzatfVar.zzbu());
            zzatfVar.zzb();
        }
    }

    public final void zze(zzatg zzatgVar) {
        try {
            zzfzr zzfzrVarZza = zzfzs.zza();
            zzfzrVarZza.zzb(zza);
            zzfzp zzfzpVarZza = zzfzq.zza();
            zzfzpVarZza.zza(zzatgVar);
            zzfzrVarZza.zza((zzfzq) zzfzpVarZza.zzbu());
            this.zze.zzb(this.zzg, ((zzfzs) zzfzrVarZza.zzbu()).zzaN(), CommonGatewayClient.HEADER_PROTOBUF);
        } catch (RuntimeException unused) {
        }
    }

    public final /* synthetic */ void zzf() {
        int i2;
        if (!this.zzf || this.zzm.getAndSet(true)) {
            return;
        }
        Context context = this.zzb;
        String str = this.zzk;
        double d8 = this.zzj;
        long j = this.zzl;
        Locale locale = Locale.getDefault();
        zzatf zzatfVarZza = zzatg.zza();
        zzatfVarZza.zzc(Build.VERSION.SDK_INT);
        zzatfVarZza.zzd(Build.MODEL);
        zzatfVarZza.zze(locale.getLanguage());
        zzatfVarZza.zzf(locale.getCountry());
        zzatfVarZza.zzi(str);
        zzatfVarZza.zzg(context.getPackageName());
        zzatfVarZza.zzl(j);
        if (d8 > 0.0d) {
            zzatfVarZza.zzk((int) (1.0d / d8));
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            zzatfVarZza.zzh(packageManager.getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception unused) {
        }
        try {
            if (packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                i2 = 5;
            } else if (packageManager.hasSystemFeature("android.hardware.type.watch")) {
                i2 = 4;
            } else if (packageManager.hasSystemFeature("android.hardware.type.pc")) {
                i2 = 7;
            } else {
                UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
                i2 = (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) ? 2 : 6;
            }
            zzatfVarZza.zzm(i2);
        } catch (RuntimeException unused2) {
        }
        zzatg zzatgVar = (zzatg) zzatfVarZza.zzbu();
        synchronized (this.zzn) {
            this.zzq.zzbo(zzatgVar);
        }
    }
}
