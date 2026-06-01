package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgot {
    private static final zzgot zza = new zzgor();
    private static final zzgot zzb = new zzgos(-1);
    private static final zzgot zzc = new zzgos(1);

    public /* synthetic */ zzgot(byte[] bArr) {
    }

    public static zzgot zzg() {
        return zza;
    }

    public abstract zzgot zza(Object obj, Object obj2, Comparator comparator);

    public abstract zzgot zzb(int i2, int i8);

    public abstract zzgot zzc(boolean z2, boolean z7);

    public abstract zzgot zzd(boolean z2, boolean z7);

    public abstract int zze();
}
