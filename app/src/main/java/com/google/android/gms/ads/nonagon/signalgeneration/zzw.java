package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzdhh;
import com.google.android.gms.internal.ads.zzdvc;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzw implements zzdhh {
    private final zzdvc zza;
    private final zzv zzb;
    private final String zzc;
    private final int zzd;

    @VisibleForTesting
    public zzw(zzdvc zzdvcVar, zzv zzvVar, String str, int i2) {
        this.zza = zzdvcVar;
        this.zzb = zzvVar;
        this.zzc = str;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zzd(@Nullable zzbj zzbjVar) {
        String strOptString;
        if (zzbjVar == null || this.zzd == 2) {
            return;
        }
        if (TextUtils.isEmpty(zzbjVar.zzc)) {
            this.zzb.zza(this.zzc, zzbjVar.zzb, this.zza);
            return;
        }
        try {
            strOptString = new JSONObject(zzbjVar.zzc).optString("request_id");
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "RenderSignals.getRequestId");
            strOptString = null;
        }
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        this.zzb.zza(strOptString, zzbjVar.zzc, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zze(@Nullable String str) {
    }
}
