package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkc extends zzkm {
    public zzkc(zzkg zzkgVar, String str, Long l, boolean z2) {
        super(zzkgVar, str, l, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String str = this.zzb;
        String string = obj.toString();
        Log.e("PhenotypeFlag", androidx.camera.core.processing.util.a.n(new StringBuilder(str.length() + 25 + string.length()), "Invalid long value for ", str, ": ", string));
        return null;
    }
}
