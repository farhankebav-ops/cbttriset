package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.ironsource.C2300e4;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdlq {
    private int zza;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzed zzb;

    @Nullable
    private zzbib zzc;

    @Nullable
    private View zzd;

    @Nullable
    private List zze;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzez zzg;

    @Nullable
    private Bundle zzh;

    @Nullable
    private zzcgy zzi;

    @Nullable
    private zzcgy zzj;

    @Nullable
    private zzcgy zzk;

    @Nullable
    private zzehf zzl;

    @Nullable
    private j2.q zzm;

    @Nullable
    private zzcca zzn;

    @Nullable
    private View zzo;

    @Nullable
    private View zzp;

    @Nullable
    private IObjectWrapper zzq;
    private double zzr;

    @Nullable
    private zzbii zzs;

    @Nullable
    private zzbii zzt;

    @Nullable
    private String zzu;
    private float zzx;

    @Nullable
    private String zzy;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private List zzf = Collections.EMPTY_LIST;

    @Nullable
    public static zzdlq zzaf(zzbry zzbryVar) {
        try {
            return zzak(zzam(zzbryVar.zzn(), zzbryVar), zzbryVar.zzo(), (View) zzal(zzbryVar.zzp()), zzbryVar.zze(), zzbryVar.zzf(), zzbryVar.zzg(), zzbryVar.zzs(), zzbryVar.zzi(), (View) zzal(zzbryVar.zzq()), zzbryVar.zzr(), zzbryVar.zzl(), zzbryVar.zzm(), zzbryVar.zzk(), zzbryVar.zzh(), zzbryVar.zzj(), zzbryVar.zzz());
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    @Nullable
    public static zzdlq zzag(zzbrv zzbrvVar) {
        try {
            zzdlp zzdlpVarZzam = zzam(zzbrvVar.zzs(), null);
            zzbib zzbibVarZzt = zzbrvVar.zzt();
            View view = (View) zzal(zzbrvVar.zzr());
            String strZze = zzbrvVar.zze();
            List listZzf = zzbrvVar.zzf();
            String strZzg = zzbrvVar.zzg();
            Bundle bundleZzp = zzbrvVar.zzp();
            String strZzi = zzbrvVar.zzi();
            View view2 = (View) zzal(zzbrvVar.zzu());
            IObjectWrapper iObjectWrapperZzv = zzbrvVar.zzv();
            String strZzj = zzbrvVar.zzj();
            zzbii zzbiiVarZzh = zzbrvVar.zzh();
            zzdlq zzdlqVar = new zzdlq();
            zzdlqVar.zza = 1;
            zzdlqVar.zzb = zzdlpVarZzam;
            zzdlqVar.zzc = zzbibVarZzt;
            zzdlqVar.zzd = view;
            zzdlqVar.zzs("headline", strZze);
            zzdlqVar.zze = listZzf;
            zzdlqVar.zzs(C2300e4.h.E0, strZzg);
            zzdlqVar.zzh = bundleZzp;
            zzdlqVar.zzs("call_to_action", strZzi);
            zzdlqVar.zzo = view2;
            zzdlqVar.zzq = iObjectWrapperZzv;
            zzdlqVar.zzs(C2300e4.h.F0, strZzj);
            zzdlqVar.zzt = zzbiiVarZzh;
            return zzdlqVar;
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    @Nullable
    public static zzdlq zzah(zzbru zzbruVar) {
        zzdlq zzdlqVar;
        zzdlp zzdlpVarZzam;
        zzbib zzbibVarZzv;
        View view;
        String strZze;
        List listZzf;
        String strZzg;
        Bundle bundleZzr;
        String strZzi;
        View view2;
        IObjectWrapper iObjectWrapperZzx;
        String strZzk;
        String strZzl;
        double dZzj;
        zzbii zzbiiVarZzh;
        try {
            zzdlpVarZzam = zzam(zzbruVar.zzt(), null);
            zzbibVarZzv = zzbruVar.zzv();
            view = (View) zzal(zzbruVar.zzu());
            strZze = zzbruVar.zze();
            listZzf = zzbruVar.zzf();
            strZzg = zzbruVar.zzg();
            bundleZzr = zzbruVar.zzr();
            strZzi = zzbruVar.zzi();
            view2 = (View) zzal(zzbruVar.zzw());
            iObjectWrapperZzx = zzbruVar.zzx();
            strZzk = zzbruVar.zzk();
            strZzl = zzbruVar.zzl();
            dZzj = zzbruVar.zzj();
            zzbiiVarZzh = zzbruVar.zzh();
            zzdlqVar = null;
        } catch (RemoteException e) {
            e = e;
            zzdlqVar = null;
        }
        try {
            zzdlq zzdlqVar2 = new zzdlq();
            zzdlqVar2.zza = 2;
            zzdlqVar2.zzb = zzdlpVarZzam;
            zzdlqVar2.zzc = zzbibVarZzv;
            zzdlqVar2.zzd = view;
            zzdlqVar2.zzs("headline", strZze);
            zzdlqVar2.zze = listZzf;
            zzdlqVar2.zzs(C2300e4.h.E0, strZzg);
            zzdlqVar2.zzh = bundleZzr;
            zzdlqVar2.zzs("call_to_action", strZzi);
            zzdlqVar2.zzo = view2;
            zzdlqVar2.zzq = iObjectWrapperZzx;
            zzdlqVar2.zzs(C2300e4.h.U, strZzk);
            zzdlqVar2.zzs("price", strZzl);
            zzdlqVar2.zzr = dZzj;
            zzdlqVar2.zzs = zzbiiVarZzh;
            return zzdlqVar2;
        } catch (RemoteException e4) {
            e = e4;
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad from app install ad mapper", e);
            return zzdlqVar;
        }
    }

    @Nullable
    public static zzdlq zzai(zzbru zzbruVar) {
        try {
            return zzak(zzam(zzbruVar.zzt(), null), zzbruVar.zzv(), (View) zzal(zzbruVar.zzu()), zzbruVar.zze(), zzbruVar.zzf(), zzbruVar.zzg(), zzbruVar.zzr(), zzbruVar.zzi(), (View) zzal(zzbruVar.zzw()), zzbruVar.zzx(), zzbruVar.zzk(), zzbruVar.zzl(), zzbruVar.zzj(), zzbruVar.zzh(), null, 0.0f);
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    @Nullable
    public static zzdlq zzaj(zzbrv zzbrvVar) {
        try {
            return zzak(zzam(zzbrvVar.zzs(), null), zzbrvVar.zzt(), (View) zzal(zzbrvVar.zzr()), zzbrvVar.zze(), zzbrvVar.zzf(), zzbrvVar.zzg(), zzbrvVar.zzp(), zzbrvVar.zzi(), (View) zzal(zzbrvVar.zzu()), zzbrvVar.zzv(), null, null, -1.0d, zzbrvVar.zzh(), zzbrvVar.zzj(), 0.0f);
        } catch (RemoteException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdlq zzak(@Nullable com.google.android.gms.ads.internal.client.zzed zzedVar, zzbib zzbibVar, @Nullable View view, String str, List list, String str2, Bundle bundle, String str3, @Nullable View view2, IObjectWrapper iObjectWrapper, @Nullable String str4, @Nullable String str5, double d8, zzbii zzbiiVar, @Nullable String str6, float f4) {
        zzdlq zzdlqVar = new zzdlq();
        zzdlqVar.zza = 6;
        zzdlqVar.zzb = zzedVar;
        zzdlqVar.zzc = zzbibVar;
        zzdlqVar.zzd = view;
        zzdlqVar.zzs("headline", str);
        zzdlqVar.zze = list;
        zzdlqVar.zzs(C2300e4.h.E0, str2);
        zzdlqVar.zzh = bundle;
        zzdlqVar.zzs("call_to_action", str3);
        zzdlqVar.zzo = view2;
        zzdlqVar.zzq = iObjectWrapper;
        zzdlqVar.zzs(C2300e4.h.U, str4);
        zzdlqVar.zzs("price", str5);
        zzdlqVar.zzr = d8;
        zzdlqVar.zzs = zzbiiVar;
        zzdlqVar.zzs(C2300e4.h.F0, str6);
        zzdlqVar.zzu(f4);
        return zzdlqVar;
    }

    @Nullable
    private static Object zzal(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    @Nullable
    private static zzdlp zzam(@Nullable com.google.android.gms.ads.internal.client.zzed zzedVar, @Nullable zzbry zzbryVar) {
        if (zzedVar == null) {
            return null;
        }
        return new zzdlp(zzedVar, zzbryVar);
    }

    @Nullable
    public final synchronized View zzA() {
        return this.zzd;
    }

    @Nullable
    public final synchronized String zzB() {
        return zzw("headline");
    }

    @Nullable
    public final synchronized List zzC() {
        return this.zze;
    }

    @Nullable
    public final zzbii zzD() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbih.zzh((IBinder) obj);
        }
        return null;
    }

    public final synchronized List zzE() {
        return this.zzf;
    }

    @Nullable
    public final synchronized com.google.android.gms.ads.internal.client.zzez zzF() {
        return this.zzg;
    }

    @Nullable
    public final synchronized String zzG() {
        return zzw(C2300e4.h.E0);
    }

    public final synchronized Bundle zzH() {
        try {
            if (this.zzh == null) {
                this.zzh = new Bundle();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzh;
    }

    @Nullable
    public final synchronized String zzI() {
        return zzw("call_to_action");
    }

    @Nullable
    public final synchronized View zzJ() {
        return this.zzo;
    }

    @Nullable
    public final synchronized View zzK() {
        return this.zzp;
    }

    @Nullable
    public final synchronized IObjectWrapper zzL() {
        return this.zzq;
    }

    @Nullable
    public final synchronized String zzM() {
        return zzw(C2300e4.h.U);
    }

    @Nullable
    public final synchronized String zzN() {
        return zzw("price");
    }

    public final synchronized double zzO() {
        return this.zzr;
    }

    @Nullable
    public final synchronized zzbii zzP() {
        return this.zzs;
    }

    @Nullable
    public final synchronized String zzQ() {
        return zzw(C2300e4.h.F0);
    }

    @Nullable
    public final synchronized zzbii zzR() {
        return this.zzt;
    }

    @Nullable
    public final synchronized String zzS() {
        return this.zzu;
    }

    @Nullable
    public final synchronized zzcgy zzT() {
        return this.zzi;
    }

    @Nullable
    public final synchronized zzcgy zzU() {
        return this.zzj;
    }

    public final synchronized boolean zzV() {
        return this.zzj != null;
    }

    @Nullable
    public final synchronized zzcgy zzW() {
        return this.zzk;
    }

    @Nullable
    public final synchronized j2.q zzX() {
        return this.zzm;
    }

    @Nullable
    public final synchronized zzcca zzY() {
        return this.zzn;
    }

    @Nullable
    public final synchronized zzehf zzZ() {
        return this.zzl;
    }

    public final synchronized void zza(int i2) {
        this.zza = i2;
    }

    @Nullable
    public final synchronized SimpleArrayMap zzaa() {
        return this.zzv;
    }

    public final synchronized float zzab() {
        return this.zzx;
    }

    @Nullable
    public final synchronized String zzac() {
        return this.zzy;
    }

    public final synchronized SimpleArrayMap zzad() {
        return this.zzw;
    }

    public final synchronized void zzae() {
        try {
            zzcgy zzcgyVar = this.zzi;
            if (zzcgyVar != null) {
                zzcgyVar.destroy();
                this.zzi = null;
            }
            zzcgy zzcgyVar2 = this.zzj;
            if (zzcgyVar2 != null) {
                zzcgyVar2.destroy();
                this.zzj = null;
            }
            zzcgy zzcgyVar3 = this.zzk;
            if (zzcgyVar3 != null) {
                zzcgyVar3.destroy();
                this.zzk = null;
            }
            j2.q qVar = this.zzm;
            if (qVar != null) {
                qVar.cancel(false);
                this.zzm = null;
            }
            zzcca zzccaVar = this.zzn;
            if (zzccaVar != null) {
                zzccaVar.cancel(false);
                this.zzn = null;
            }
            this.zzl = null;
            this.zzv.clear();
            this.zzw.clear();
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzh = null;
            this.zzo = null;
            this.zzp = null;
            this.zzq = null;
            this.zzs = null;
            this.zzt = null;
            this.zzu = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zzed zzedVar) {
        this.zzb = zzedVar;
    }

    public final synchronized void zzc(zzbib zzbibVar) {
        this.zzc = zzbibVar;
    }

    public final synchronized void zzd(List list) {
        this.zze = list;
    }

    public final synchronized void zze(List list) {
        this.zzf = list;
    }

    public final synchronized void zzf(@Nullable com.google.android.gms.ads.internal.client.zzez zzezVar) {
        this.zzg = zzezVar;
    }

    public final synchronized void zzg(View view) {
        this.zzo = view;
    }

    public final synchronized void zzh(View view) {
        this.zzp = view;
    }

    public final synchronized void zzi(double d8) {
        this.zzr = d8;
    }

    public final synchronized void zzj(zzbii zzbiiVar) {
        this.zzs = zzbiiVar;
    }

    public final synchronized void zzk(zzbii zzbiiVar) {
        this.zzt = zzbiiVar;
    }

    public final synchronized void zzl(String str) {
        this.zzu = str;
    }

    public final synchronized void zzm(zzcgy zzcgyVar) {
        this.zzi = zzcgyVar;
    }

    public final synchronized void zzn(zzcgy zzcgyVar) {
        this.zzj = zzcgyVar;
    }

    public final synchronized void zzo(zzcgy zzcgyVar) {
        this.zzk = zzcgyVar;
    }

    public final synchronized void zzp(j2.q qVar) {
        this.zzm = qVar;
    }

    public final synchronized void zzq(zzehf zzehfVar) {
        this.zzl = zzehfVar;
    }

    public final synchronized void zzr(zzcca zzccaVar) {
        this.zzn = zzccaVar;
    }

    public final synchronized void zzs(String str, @Nullable String str2) {
        if (str2 == null) {
            this.zzw.remove(str);
        } else {
            this.zzw.put(str, str2);
        }
    }

    public final synchronized void zzt(String str, zzbht zzbhtVar) {
        if (zzbhtVar == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, zzbhtVar);
        }
    }

    public final synchronized void zzu(float f4) {
        this.zzx = f4;
    }

    public final synchronized void zzv(@Nullable String str) {
        this.zzy = str;
    }

    @Nullable
    public final synchronized String zzw(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized int zzx() {
        return this.zza;
    }

    @Nullable
    public final synchronized com.google.android.gms.ads.internal.client.zzed zzy() {
        return this.zzb;
    }

    @Nullable
    public final synchronized zzbib zzz() {
        return this.zzc;
    }
}
