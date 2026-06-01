package com.google.android.gms.internal.ads;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class zzaei extends zzado {
    private final long zza;

    public zzaei(zzadb zzadbVar, long j) {
        super(zzadbVar);
        zzgmd.zza(zzadbVar.zzn() >= j);
        this.zza = j;
    }

    @Override // com.google.android.gms.internal.ads.zzado, com.google.android.gms.internal.ads.zzadb
    public final long zzm() {
        return super.zzm() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzado, com.google.android.gms.internal.ads.zzadb
    public final long zzn() {
        return super.zzn() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzado, com.google.android.gms.internal.ads.zzadb
    public final long zzo() {
        return super.zzo() - this.zza;
    }
}
