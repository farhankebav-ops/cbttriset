package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgkl extends zzgjj {
    final /* synthetic */ zzgkn zza;
    private final zzgks zzb;

    public zzgkl(zzgkn zzgknVar, zzgks zzgksVar) {
        Objects.requireNonNull(zzgknVar);
        this.zza = zzgknVar;
        this.zzb = zzgksVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgjk
    public final void zzb(Bundle bundle) {
        int i2 = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        int i8 = bundle.getInt("uiMode", 0);
        zzgkq zzgkqVarZzd = zzgkr.zzd();
        zzgkqVarZzd.zza(i2);
        if (string != null) {
            zzgkqVarZzd.zzb(string);
        }
        zzgkqVarZzd.zzc(i8);
        this.zzb.zza(zzgkqVarZzd.zzd());
        if (i2 == 8157) {
            this.zza.zzd();
        }
    }
}
