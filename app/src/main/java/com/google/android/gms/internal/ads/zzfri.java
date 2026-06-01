package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfri extends zzfrd {
    public zzfri(zzfqw zzfqwVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfqwVar, hashSet, jSONObject, j);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        zzfqw zzfqwVar = this.zzd;
        JSONObject jSONObject = this.zzb;
        if (zzfqo.zzg(jSONObject, zzfqwVar.zzd())) {
            return null;
        }
        zzfqwVar.zze(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfre, android.os.AsyncTask
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzfps zzfpsVarZza;
        if (!TextUtils.isEmpty(str) && (zzfpsVarZza = zzfps.zza()) != null) {
            for (zzfoy zzfoyVar : zzfpsVarZza.zze()) {
                if (((zzfrd) this).zza.contains(zzfoyVar.zzh())) {
                    zzfoyVar.zzg().zzh(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
