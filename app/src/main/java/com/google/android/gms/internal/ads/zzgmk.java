package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgmk extends zzgmq {
    final /* synthetic */ zzgls zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgmk(zzgms zzgmsVar, CharSequence charSequence, zzgls zzglsVar) {
        super(zzgmsVar, charSequence);
        this.zza = zzglsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    public final int zzc(int i2) {
        Matcher matcher = ((zzglv) this.zza).zza;
        if (matcher.find(i2)) {
            return matcher.start();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    public final int zzd(int i2) {
        return ((zzglv) this.zza).zza.end();
    }
}
