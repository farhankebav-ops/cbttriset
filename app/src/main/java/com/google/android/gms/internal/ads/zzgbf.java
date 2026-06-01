package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgbf {
    private final zzgus zza;
    private final zzgbk zzb;
    private final Set zzc;
    private final String zzd;
    private final zzauc zze;
    private final zzgcd zzf;
    private final zzgjd zzg;

    public zzgbf(zzgus zzgusVar, zzgbk zzgbkVar, zzgcd zzgcdVar, zzfyq zzfyqVar, String str, zzauc zzaucVar, zzifw zzifwVar, zzifw zzifwVar2, zzifw zzifwVar3, zzgjd zzgjdVar) {
        this.zza = zzgusVar;
        this.zzb = zzgbkVar;
        this.zzd = str;
        this.zzf = zzgcdVar;
        this.zze = zzaucVar;
        this.zzg = zzgjdVar;
        int iOrdinal = zzfyqVar.ordinal();
        if (iOrdinal == 0) {
            this.zzc = ((zzift) zzifwVar).zzb();
        } else if (iOrdinal == 1) {
            this.zzc = ((zzift) zzifwVar2).zzb();
        } else {
            if (iOrdinal != 2) {
                throw new IllegalStateException();
            }
            this.zzc = ((zzift) zzifwVar3).zzb();
        }
    }

    public final j2.q zza() {
        if (!this.zzb.zzc()) {
            return zzgui.zza(Integer.toString(7));
        }
        if (!this.zzf.zzb()) {
            return zzgui.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzgbe
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzb();
                }
            }, this.zza);
        }
        Set set = this.zzc;
        ArrayList arrayList = new ArrayList(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(this.zza.zzc((zzgdg) it.next()));
        }
        return zzgui.zzn(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzgbc
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        }, zzguz.zza());
    }

    public final /* synthetic */ String zzb() {
        return this.zzb.zzg(16384, this.zzd);
    }

    public final /* synthetic */ String zzc() {
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzgbd
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzd();
            }
        };
        zzgjb zzgjbVarZza = this.zzg.zza(101);
        try {
            zzgjbVarZza.zza();
            Object objCall = callable.call();
            zzgjbVarZza.zzc();
            return (String) objCall;
        } finally {
        }
    }

    public final /* synthetic */ String zzd() {
        zzauz zzauzVar = (zzauz) this.zze.zzbu();
        String str = this.zzd;
        zzgbk zzgbkVar = this.zzb;
        try {
            return Base64.encodeToString(((zzavq) zzgbkVar.zzf(zzauzVar.zzaN(), str).zzbu()).zzaN(), 11);
        } catch (IllegalArgumentException unused) {
            return zzgbkVar.zzg(4096, str);
        }
    }
}
