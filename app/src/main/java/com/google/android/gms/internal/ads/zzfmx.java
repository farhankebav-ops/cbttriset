package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfmx {
    private final com.google.android.gms.ads.internal.util.client.zzx zza;
    private final com.google.android.gms.ads.internal.util.client.zzu zzb;
    private final zzgut zzc;

    @Nullable
    private final zzfmy zzd;

    @Nullable
    private final zzcjk zze;

    public zzfmx(com.google.android.gms.ads.internal.util.client.zzx zzxVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzgut zzgutVar, @Nullable zzfmy zzfmyVar, @Nullable zzcjk zzcjkVar) {
        this.zza = zzxVar;
        this.zzb = zzuVar;
        this.zzc = zzgutVar;
        this.zzd = zzfmyVar;
        this.zze = zzcjkVar;
    }

    private final j2.q zze(final String str, final long j, final int i2) {
        final String strS;
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = this.zza;
        if (i2 > zzxVar.zza()) {
            zzfmy zzfmyVar = this.zzd;
            if (zzfmyVar == null || !zzxVar.zzd()) {
                return zzgui.zza(com.google.android.gms.ads.internal.util.client.zzt.RETRIABLE_FAILURE);
            }
            zzfmyVar.zza(str, "", 2);
            return zzgui.zza(com.google.android.gms.ads.internal.util.client.zzt.BUFFERED);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjv)).booleanValue()) {
            Uri uri = Uri.parse(str);
            String encodedQuery = uri.getEncodedQuery();
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            builderClearQuery.appendQueryParameter("pa", Integer.toString(i2));
            String strValueOf = String.valueOf(builderClearQuery.build());
            strS = a1.a.s(new StringBuilder(strValueOf.length() + 1 + String.valueOf(encodedQuery).length()), strValueOf, C2300e4.i.f8401c, encodedQuery);
        } else {
            strS = str;
        }
        zzgtq zzgtqVar = new zzgtq() { // from class: com.google.android.gms.internal.ads.zzfmw
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzb(i2, j, str, (com.google.android.gms.ads.internal.util.client.zzt) obj);
            }
        };
        if (j == 0) {
            zzgut zzgutVar = this.zzc;
            return zzgui.zzj(zzgutVar.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzfmv
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzd(strS);
                }
            }), zzgtqVar, zzgutVar);
        }
        zzgut zzgutVar2 = this.zzc;
        return zzgui.zzj(zzgutVar2.zze(new Callable() { // from class: com.google.android.gms.internal.ads.zzfmu
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc(strS);
            }
        }, j, TimeUnit.MILLISECONDS), zzgtqVar, zzgutVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final com.google.android.gms.ads.internal.util.client.zzt zzd(String str) {
        zzcjk zzcjkVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjN)).booleanValue() || (zzcjkVar = this.zze) == null || (!com.google.android.gms.ads.internal.zzt.zzc().zzi(str) && !com.google.android.gms.ads.internal.zzt.zzc().zzj(str))) {
            return this.zzb.zzc(str, null);
        }
        String strZzb = zzcjkVar.zzb();
        HashMap map = new HashMap();
        if (strZzb != null) {
            map.put((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjO), strZzb);
        }
        return this.zzb.zzc(str, map);
    }

    public final j2.q zza(String str) {
        if (str != null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzf)).booleanValue() || !str.isEmpty()) {
                try {
                    return zze(str, 0L, 1);
                } catch (NullPointerException | RejectedExecutionException unused) {
                    return zzgui.zza(com.google.android.gms.ads.internal.util.client.zzt.PERMANENT_FAILURE);
                }
            }
        }
        return zzgui.zza(com.google.android.gms.ads.internal.util.client.zzt.PERMANENT_FAILURE);
    }

    public final /* synthetic */ j2.q zzb(int i2, long j, String str, com.google.android.gms.ads.internal.util.client.zzt zztVar) {
        if (zztVar != com.google.android.gms.ads.internal.util.client.zzt.RETRIABLE_FAILURE) {
            return zzgui.zza(zztVar);
        }
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = this.zza;
        long jZzb = zzxVar.zzb();
        if (i2 != 1) {
            jZzb = (long) (zzxVar.zzc() * j);
        }
        return zze(str, jZzb, i2 + 1);
    }
}
