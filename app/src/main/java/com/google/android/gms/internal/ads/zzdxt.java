package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdxt {
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdsy zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdvt zzl;
    private final VersionInfoParcel zzm;
    private final zzdfu zzo;
    private final zzflp zzp;
    private boolean zza = false;
    private boolean zzb = false;

    @GuardedBy("this")
    private boolean zzc = false;
    private final zzcca zze = new zzcca();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;
    private final long zzd = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();

    public zzdxt(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdsy zzdsyVar, ScheduledExecutorService scheduledExecutorService, zzdvt zzdvtVar, VersionInfoParcel versionInfoParcel, zzdfu zzdfuVar, zzflp zzflpVar) {
        this.zzh = zzdsyVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdvtVar;
        this.zzm = versionInfoParcel;
        this.zzo = zzdfuVar;
        this.zzp = zzflpVar;
        zzm("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    private final synchronized j2.q zzu() {
        String strZzd = com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzd();
        if (!TextUtils.isEmpty(strZzd)) {
            return zzgui.zza(strZzd);
        }
        final zzcca zzccaVar = new zzcca();
        com.google.android.gms.ads.internal.zzt.zzh().zzo().zzk(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxm
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzg(zzccaVar);
            }
        });
        return zzccaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzv, reason: merged with bridge method [inline-methods] */
    public final void zzm(String str, boolean z2, String str2, int i2) {
        this.zzn.put(str, new zzbnw(str, z2, i2, str2));
    }

    public final void zza() {
        this.zzq = false;
    }

    public final void zzb(final zzbod zzbodVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    zzbodVar.zzb(this.zza.zzd());
                } catch (RemoteException e) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
                }
            }
        }, this.zzj);
    }

    public final void zzc() {
        if (!((Boolean) zzbha.zza.zze()).booleanValue()) {
            if (this.zzm.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzce)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.zza) {
                            return;
                        }
                        this.zzl.zze();
                        this.zzo.zze();
                        zzcca zzccaVar = this.zze;
                        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxl
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzf();
                            }
                        };
                        Executor executor = this.zzi;
                        zzccaVar.addListener(runnable, executor);
                        this.zza = true;
                        j2.q qVarZzu = zzu();
                        this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxn
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzh();
                            }
                        }, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcg)).longValue(), TimeUnit.SECONDS);
                        zzgui.zzr(qVarZzu, new zzdxj(this), executor);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzm("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(Boolean.FALSE);
        this.zza = true;
        this.zzb = true;
    }

    public final List zzd() {
        ArrayList arrayList = new ArrayList();
        Map map = this.zzn;
        for (String str : map.keySet()) {
            zzbnw zzbnwVar = (zzbnw) map.get(str);
            arrayList.add(new zzbnw(str, zzbnwVar.zzb, zzbnwVar.zzc, zzbnwVar.zzd));
        }
        return arrayList;
    }

    public final boolean zze() {
        return this.zzb;
    }

    public final /* synthetic */ void zzf() {
        this.zzl.zzf();
        this.zzo.zzf();
        this.zzb = true;
    }

    public final /* synthetic */ void zzg(final zzcca zzccaVar) {
        this.zzi.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdxr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                String strZzd = com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzd();
                boolean zIsEmpty = TextUtils.isEmpty(strZzd);
                zzcca zzccaVar2 = zzccaVar;
                if (zIsEmpty) {
                    zzccaVar2.zzd(new Exception());
                } else {
                    zzccaVar2.zzc(strZzd);
                }
            }
        });
    }

    public final /* synthetic */ void zzh() {
        synchronized (this) {
            try {
                if (this.zzc) {
                    return;
                }
                zzm("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - this.zzd));
                this.zzl.zzc("com.google.android.gms.ads.MobileAds", "timeout");
                this.zzo.zzc("com.google.android.gms.ads.MobileAds", "timeout");
                this.zze.zzd(new Exception());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzi(Object obj, zzcca zzccaVar, String str, long j, zzflc zzflcVar) {
        synchronized (obj) {
            try {
                if (!zzccaVar.isDone()) {
                    zzm(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - j));
                    this.zzl.zzc(str, "timeout");
                    this.zzo.zzc(str, "timeout");
                    zzflp zzflpVar = this.zzp;
                    zzflcVar.zzk(AndroidInitializeBoldSDK.MSG_TIMEOUT);
                    zzflcVar.zzd(false);
                    zzflpVar.zzb(zzflcVar.zzm());
                    zzccaVar.zzc(Boolean.FALSE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ Object zzj(zzflc zzflcVar) {
        this.zze.zzc(Boolean.TRUE);
        zzflcVar.zzd(true);
        this.zzp.zzb(zzflcVar.zzm());
        return null;
    }

    public final /* synthetic */ void zzk(String str, zzboa zzboaVar, zzfhl zzfhlVar, List list) {
        try {
            try {
                if (Objects.equals(str, "com.google.ads.mediation.admob.AdMobAdapter")) {
                    zzboaVar.zze();
                    return;
                }
                Context context = (Context) this.zzg.get();
                if (context == null) {
                    context = this.zzf;
                }
                zzfhlVar.zzA(context, zzboaVar, list);
            } catch (RemoteException e) {
                throw new zzgnb(e);
            } catch (zzfgu unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
                sb.append("Failed to initialize adapter. ");
                sb.append(str);
                sb.append(" does not implement the initialize() method.");
                zzboaVar.zzf(sb.toString());
            }
        } catch (RemoteException e4) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e4);
        }
    }

    public final /* synthetic */ void zzl(String str) {
        final zzdxt zzdxtVar = this;
        Context context = zzdxtVar.zzf;
        int i2 = 5;
        final zzflc zzflcVarA = r.a(context, 5);
        zzflcVarA.zza();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                final String next = itKeys.next();
                final zzflc zzflcVarA2 = r.a(context, i2);
                zzflcVarA2.zza();
                zzflcVarA2.zzi(next);
                final Object obj = new Object();
                final zzcca zzccaVar = new zzcca();
                j2.q qVarZzi = zzgui.zzi(zzccaVar, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcf)).longValue(), TimeUnit.SECONDS, zzdxtVar.zzk);
                zzdxtVar.zzl.zza(next);
                zzdxtVar.zzo.zza(next);
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
                qVarZzi.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxo
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzi(obj, zzccaVar, next, jElapsedRealtime, zzflcVarA2);
                    }
                }, zzdxtVar.zzi);
                arrayList.add(qVarZzi);
                try {
                } catch (JSONException e) {
                    e = e;
                    zzdxtVar = this;
                }
                try {
                    final zzdxk zzdxkVar = new zzdxk(this, obj, next, jElapsedRealtime, zzflcVarA2, zzccaVar);
                    zzdxtVar = this;
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    final ArrayList arrayList2 = new ArrayList();
                    if (jSONObjectOptJSONObject != null) {
                        try {
                            JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("data");
                            int i8 = 0;
                            while (i8 < jSONArray.length()) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i8);
                                String strOptString = jSONObject2.optString("format", "");
                                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                                Bundle bundle = new Bundle();
                                if (jSONObjectOptJSONObject2 != null) {
                                    Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                    while (itKeys2.hasNext()) {
                                        String next2 = itKeys2.next();
                                        bundle.putString(next2, jSONObjectOptJSONObject2.optString(next2, ""));
                                        jSONArray = jSONArray;
                                    }
                                }
                                JSONArray jSONArray2 = jSONArray;
                                arrayList2.add(new zzbog(strOptString, bundle));
                                i8++;
                                jSONArray = jSONArray2;
                            }
                        } catch (JSONException unused) {
                        }
                    }
                    zzdxtVar.zzm(next, false, "", 0);
                    try {
                        final zzfhl zzfhlVarZza = zzdxtVar.zzh.zza(next, new JSONObject());
                        zzdxtVar.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxq
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzk(next, zzdxkVar, zzfhlVarZza, arrayList2);
                            }
                        });
                    } catch (zzfgu e4) {
                        try {
                            String string = "Failed to create Adapter.";
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoa)).booleanValue()) {
                                String message = e4.getMessage();
                                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 26);
                                sb.append("Failed to create Adapter.");
                                sb.append(" ");
                                sb.append(message);
                                string = sb.toString();
                            }
                            zzdxkVar.zzf(string);
                        } catch (RemoteException e8) {
                            int i9 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e8);
                        }
                    }
                    i2 = 5;
                } catch (JSONException e9) {
                    e = e9;
                    zzdxtVar = this;
                    com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e);
                    zzdxtVar.zzo.zzd("MalformedJson");
                    zzdxtVar.zzl.zzd("MalformedJson");
                    zzdxtVar.zze.zzd(e);
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdapterInitializer.updateAdapterStatus");
                    zzflp zzflpVar = zzdxtVar.zzp;
                    zzflcVarA.zzj(e);
                    zzflcVarA.zzd(false);
                    zzflpVar.zzb(zzflcVarA.zzm());
                }
            }
            zzgui.zzn(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxp
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    this.zza.zzj(zzflcVarA);
                    return null;
                }
            }, zzdxtVar.zzi);
        } catch (JSONException e10) {
            e = e10;
            com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e);
            zzdxtVar.zzo.zzd("MalformedJson");
            zzdxtVar.zzl.zzd("MalformedJson");
            zzdxtVar.zze.zzd(e);
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdapterInitializer.updateAdapterStatus");
            zzflp zzflpVar2 = zzdxtVar.zzp;
            zzflcVarA.zzj(e);
            zzflcVarA.zzd(false);
            zzflpVar2.zzb(zzflcVarA.zzm());
        }
    }

    public final /* synthetic */ void zzn(boolean z2) {
        this.zzc = true;
    }

    public final /* synthetic */ long zzo() {
        return this.zzd;
    }

    public final /* synthetic */ zzcca zzp() {
        return this.zze;
    }

    public final /* synthetic */ Executor zzq() {
        return this.zzi;
    }

    public final /* synthetic */ zzdvt zzr() {
        return this.zzl;
    }

    public final /* synthetic */ zzdfu zzs() {
        return this.zzo;
    }

    public final /* synthetic */ zzflp zzt() {
        return this.zzp;
    }
}
