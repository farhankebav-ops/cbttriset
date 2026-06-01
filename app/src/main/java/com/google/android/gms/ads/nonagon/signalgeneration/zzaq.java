package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzglu;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzaq implements zzglu {
    static final /* synthetic */ zzaq zza = new zzaq();

    private /* synthetic */ zzaq() {
    }

    @Override // com.google.android.gms.internal.ads.zzglu
    public final /* synthetic */ Object apply(Object obj) {
        int i2 = zzau.zze;
        return ((JSONObject) obj).optString("nas");
    }
}
