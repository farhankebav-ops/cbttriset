package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzqd extends Exception {
    public final int zza;
    public final boolean zzb;

    public zzqd(int i2, int i8, int i9, int i10, int i11, zzv zzvVar, boolean z2, @Nullable Exception exc) {
        String strValueOf = String.valueOf(zzvVar);
        int length = String.valueOf(i2).length();
        int length2 = String.valueOf(i8).length();
        int length3 = String.valueOf(i9).length();
        int length4 = String.valueOf(i10).length();
        int length5 = String.valueOf(i11).length();
        int length6 = strValueOf.length();
        int i12 = length + 31 + length2 + 2 + length3 + 2 + length4 + 2 + length5 + 2;
        String str = true != z2 ? "" : " (recoverable)";
        StringBuilder sb = new StringBuilder(str.length() + i12 + length6);
        com.google.android.gms.ads.internal.client.a.k(i2, i8, "AudioTrack init failed ", " Config(", sb);
        com.google.android.gms.ads.internal.client.a.k(i9, i10, ", ", ", ", sb);
        sb.append(", ");
        sb.append(i11);
        sb.append(") ");
        sb.append(strValueOf);
        sb.append(str);
        super(sb.toString(), exc);
        this.zza = i2;
        this.zzb = z2;
    }
}
