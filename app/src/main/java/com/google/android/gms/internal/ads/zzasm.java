package com.google.android.gms.internal.ads;

import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class zzasm implements Supplier {
    private final /* synthetic */ int zzc;
    public static final /* synthetic */ zzasm zzb = new zzasm(1);
    static final /* synthetic */ zzasm zza = new zzasm(0);

    private /* synthetic */ zzasm(int i2) {
        this.zzc = i2;
    }

    @Override // java.util.function.Supplier
    public final /* synthetic */ Object get() {
        return this.zzc != 0 ? zzatc.zza(null) : new zzasp();
    }
}
