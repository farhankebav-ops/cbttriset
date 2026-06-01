package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzew {
    public final int zzd;

    public static String zze(int i2) {
        char c7 = (char) ((i2 >> 24) & 255);
        char c8 = (char) ((i2 >> 16) & 255);
        char c9 = (char) ((i2 >> 8) & 255);
        char c10 = (char) (i2 & 255);
        StringBuilder sb = new StringBuilder(a1.a.b(String.valueOf(c7).length(), String.valueOf(c8).length(), String.valueOf(c9).length(), String.valueOf(c10).length()));
        sb.append(c7);
        sb.append(c8);
        sb.append(c9);
        sb.append(c10);
        return sb.toString();
    }

    public String toString() {
        return zze(this.zzd);
    }
}
