package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeix implements zzehk {
    private final Context zza;
    private final zzdjd zzb;
    private final Executor zzc;
    private final zzfft zzd;
    private final zzdvi zze;

    public zzeix(Context context, Executor executor, zzdjd zzdjdVar, zzfft zzfftVar, zzdvi zzdviVar) {
        this.zza = context;
        this.zzb = zzdjdVar;
        this.zzc = executor;
        this.zzd = zzfftVar;
        this.zze = zzdviVar;
    }

    @Nullable
    private static String zze(zzffu zzffuVar) {
        try {
            return zzffuVar.zzv.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final boolean zza(zzfgf zzfgfVar, zzffu zzffuVar) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbfv.zza(context) && !TextUtils.isEmpty(zze(zzffuVar));
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final j2.q zzb(final zzfgf zzfgfVar, final zzffu zzffuVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoe)).booleanValue()) {
            zzdvh zzdvhVarZza = this.zze.zza();
            zzdvhVarZza.zzc("action", "cstm_tbs_rndr");
            zzdvhVarZza.zzd();
        }
        String strZze = zze(zzffuVar);
        final Uri uri = strZze != null ? Uri.parse(strZze) : null;
        final zzffx zzffxVar = zzfgfVar.zzb.zzb;
        return zzgui.zzj(zzgui.zza(null), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzeiw
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzc(uri, zzfgfVar, zzffuVar, zzffxVar, obj);
            }
        }, this.zzc);
    }

    public final /* synthetic */ j2.q zzc(Uri uri, zzfgf zzfgfVar, zzffu zzffuVar, zzffx zzffxVar, Object obj) {
        try {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            customTabsIntentBuild.intent.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(customTabsIntentBuild.intent, null);
            zzcca zzccaVar = new zzcca();
            zzdhx zzdhxVarZzd = this.zzb.zzd(new zzcue(zzfgfVar, zzffuVar, null), new zzdia(new zzeiv(this, zzccaVar, zzffuVar), null));
            zzccaVar.zzc(new AdOverlayInfoParcel(zzcVar, null, zzdhxVarZzd.zzi(), null, new VersionInfoParcel(0, 0, false), null, null, zzffxVar.zzb));
            this.zzd.zzd();
            return zzgui.zza(zzdhxVarZzd.zzh());
        } catch (Throwable th) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }

    public final /* synthetic */ zzdvi zzd() {
        return this.zze;
    }
}
