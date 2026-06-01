package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbqb {
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;

    @Nullable
    private final zzflp zze;
    private final com.google.android.gms.ads.internal.util.zzbc zzf;
    private final com.google.android.gms.ads.internal.util.zzbc zzg;

    @Nullable
    private zzbqa zzh;
    private final Object zza = new Object();
    private int zzi = 1;

    public zzbqb(Context context, VersionInfoParcel versionInfoParcel, String str, com.google.android.gms.ads.internal.util.zzbc zzbcVar, com.google.android.gms.ads.internal.util.zzbc zzbcVar2, @Nullable zzflp zzflpVar) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = versionInfoParcel;
        this.zze = zzflpVar;
        this.zzf = zzbcVar;
        this.zzg = zzbcVar2;
    }

    public final zzbqa zza(@Nullable zzaxa zzaxaVar) {
        zzflc zzflcVarA = r.a(this.zzb, 6);
        zzflcVarA.zza();
        final zzbqa zzbqaVar = new zzbqa(this.zzg);
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        final zzaxa zzaxaVar2 = null;
        zzcbv.zzf.execute(new Runnable(zzaxaVar2, zzbqaVar) { // from class: com.google.android.gms.internal.ads.zzbpr
            private final /* synthetic */ zzbqa zzb;

            {
                this.zzb = zzbqaVar;
            }

            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc(null, this.zzb);
            }
        });
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine: Promise created");
        zzbqaVar.zze(new zzbpk(this, zzbqaVar, zzflcVarA), new zzbpl(this, zzbqaVar, zzflcVarA));
        return zzbqaVar;
    }

    public final zzbpv zzb(@Nullable zzaxa zzaxaVar) {
        com.google.android.gms.ads.internal.util.zze.zza("getEngine: Trying to acquire lock");
        Object obj = this.zza;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("getEngine: Lock acquired");
                com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Trying to acquire lock");
                synchronized (obj) {
                    try {
                        com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock acquired");
                        zzbqa zzbqaVar = this.zzh;
                        if (zzbqaVar != null && this.zzi == 0) {
                            zzbqaVar.zze(new zzcce() { // from class: com.google.android.gms.internal.ads.zzbpn
                                @Override // com.google.android.gms.internal.ads.zzcce
                                public final /* synthetic */ void zza(Object obj2) {
                                    this.zza.zzd((zzbow) obj2);
                                }
                            }, zzbpo.zza);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock released");
        zzbqa zzbqaVar2 = this.zzh;
        if (zzbqaVar2 != null && zzbqaVar2.zzi() != -1) {
            int i2 = this.zzi;
            if (i2 == 0) {
                com.google.android.gms.ads.internal.util.zze.zza("getEngine (NO_UPDATE): Lock released");
                return this.zzh.zza();
            }
            if (i2 != 1) {
                com.google.android.gms.ads.internal.util.zze.zza("getEngine (UPDATING): Lock released");
                return this.zzh.zza();
            }
            this.zzi = 2;
            zza(null);
            com.google.android.gms.ads.internal.util.zze.zza("getEngine (PENDING_UPDATE): Lock released");
            return this.zzh.zza();
        }
        this.zzi = 2;
        this.zzh = zza(null);
        com.google.android.gms.ads.internal.util.zze.zza("getEngine (NULL or REJECTED): Lock released");
        return this.zzh.zza();
    }

    public final /* synthetic */ void zzc(zzaxa zzaxaVar, final zzbqa zzbqaVar) {
        final long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
        final ArrayList arrayList = new ArrayList();
        try {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before createJavascriptEngine");
            final zzbpe zzbpeVar = new zzbpe(this.zzb, this.zzd, null, null);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After createJavascriptEngine");
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbpeVar.zzi(new zzbov() { // from class: com.google.android.gms.internal.ads.zzbpp
                @Override // com.google.android.gms.internal.ads.zzbov
                public final /* synthetic */ void zza() {
                    long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
                    final long j = jCurrentTimeMillis;
                    final ArrayList arrayList2 = arrayList;
                    arrayList2.add(Long.valueOf(jCurrentTimeMillis2 - j));
                    String strValueOf = String.valueOf(arrayList2.get(0));
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 52);
                    sb.append("LoadNewJavascriptEngine(onEngLoaded) latency is ");
                    sb.append(strValueOf);
                    sb.append(" ms.");
                    com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
                    zzfuz zzfuzVar = com.google.android.gms.ads.internal.util.zzs.zza;
                    final zzbqb zzbqbVar = this.zza;
                    final zzbqa zzbqaVar2 = zzbqaVar;
                    final zzbow zzbowVar = zzbpeVar;
                    zzfuzVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbpq
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzbqbVar.zze(zzbqaVar2, zzbowVar, arrayList2, j);
                        }
                    }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzc)).intValue());
                }
            });
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbpeVar.zzm("/jsLoaded", new zzbpg(this, jCurrentTimeMillis, zzbqaVar, zzbpeVar));
            com.google.android.gms.ads.internal.util.zzbv zzbvVar = new com.google.android.gms.ads.internal.util.zzbv();
            zzbph zzbphVar = new zzbph(this, null, zzbpeVar, zzbvVar);
            zzbvVar.zzb(zzbphVar);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbpeVar.zzm("/requestReload", zzbphVar);
            String str = this.zzc;
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(str)));
            if (str.endsWith(".js")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbpeVar.zzf(str);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (str.startsWith("<html>")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbpeVar.zzh(str);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbpeVar.zzg(str);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new zzbpj(this, zzbqaVar, zzbpeVar, arrayList, jCurrentTimeMillis), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzd)).intValue());
        } catch (Throwable th) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error creating webview.", th);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzip)).booleanValue()) {
                zzbqaVar.zzh(th, "SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine");
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzir)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzh().zzh(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbqaVar.zzg();
            } else {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbqaVar.zzg();
            }
        }
    }

    public final /* synthetic */ void zzd(zzbow zzbowVar) {
        if (zzbowVar.zzk()) {
            this.zzi = 1;
        }
    }

    public final /* synthetic */ void zze(zzbqa zzbqaVar, final zzbow zzbowVar, ArrayList arrayList, long j) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
                if (zzbqaVar.zzi() != -1 && zzbqaVar.zzi() != 1) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzip)).booleanValue()) {
                        zzbqaVar.zzh(new TimeoutException("Unable to receive /jsLoaded GMSG."), "SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener");
                    } else {
                        zzbqaVar.zzg();
                    }
                    zzgus zzgusVar = zzcbv.zzf;
                    Objects.requireNonNull(zzbowVar);
                    zzgusVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbpm
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzbowVar.zzj();
                        }
                    });
                    String strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzc));
                    int iZzi = zzbqaVar.zzi();
                    int i2 = this.zzi;
                    String strValueOf2 = String.valueOf(arrayList.get(0));
                    long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - j;
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 94 + String.valueOf(iZzi).length() + 39 + String.valueOf(i2).length() + 57 + strValueOf2.length() + 42 + String.valueOf(jCurrentTimeMillis).length() + 15);
                    sb.append("Could not receive /jsLoaded in ");
                    sb.append(strValueOf);
                    sb.append(" ms. JS engine session reference status(onEngLoadedTimeout) is ");
                    sb.append(iZzi);
                    sb.append(". Update status(onEngLoadedTimeout) is ");
                    sb.append(i2);
                    sb.append(". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is ");
                    sb.append(strValueOf2);
                    sb.append(" ms. Total latency(onEngLoadedTimeout) is ");
                    sb.append(jCurrentTimeMillis);
                    sb.append(" ms. Rejecting.");
                    com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
                    com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                    return;
                }
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ Object zzf() {
        return this.zza;
    }

    public final /* synthetic */ zzflp zzg() {
        return this.zze;
    }

    public final /* synthetic */ zzbqa zzh() {
        return this.zzh;
    }

    public final /* synthetic */ void zzi(zzbqa zzbqaVar) {
        this.zzh = zzbqaVar;
    }

    public final /* synthetic */ int zzj() {
        return this.zzi;
    }

    public final /* synthetic */ void zzk(int i2) {
        this.zzi = i2;
    }
}
