package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzdzv extends Exception {
    private final int zza;

    public zzdzv(int i2) {
        this.zza = i2;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdzv(int i2, String str) {
        super(str);
        this.zza = i2;
    }

    public zzdzv(int i2, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
