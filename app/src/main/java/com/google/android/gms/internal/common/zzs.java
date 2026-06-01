package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzs extends zzv {
    final /* synthetic */ zzp zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzw zzwVar, CharSequence charSequence, zzp zzpVar) {
        super(zzwVar, charSequence);
        this.zza = zzpVar;
    }

    @Override // com.google.android.gms.internal.common.zzv
    public final int zzc(int i2) {
        CharSequence charSequence = ((zzv) this).zzb;
        int length = charSequence.length();
        zzr.zzc(i2, length, FirebaseAnalytics.Param.INDEX);
        while (i2 < length) {
            if (this.zza.zza(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzv
    public final int zzd(int i2) {
        return i2 + 1;
    }
}
