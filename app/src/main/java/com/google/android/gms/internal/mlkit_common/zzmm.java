package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public enum zzmm implements zzba {
    UNKNOWN(0),
    TRANSLATE(1);

    private final int zzd;

    zzmm(int i2) {
        this.zzd = i2;
    }

    public static zzmm zzb(int i2) {
        for (zzmm zzmmVar : values()) {
            if (zzmmVar.zzd == i2) {
                return zzmmVar;
            }
        }
        return UNKNOWN;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzba
    public final int zza() {
        return this.zzd;
    }
}
