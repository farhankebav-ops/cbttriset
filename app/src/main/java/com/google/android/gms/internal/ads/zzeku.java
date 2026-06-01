package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeku {
    final String zza;
    final String zzb;
    int zzc;
    long zzd;

    @Nullable
    final Integer zze;

    public zzeku(String str, String str2, int i2, long j, @Nullable Integer num) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i2;
        this.zzd = j;
        this.zze = num;
    }

    public final String toString() {
        Integer num;
        String str = this.zza;
        int i2 = this.zzc;
        long j = this.zzd;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(i2).length() + 1 + String.valueOf(j).length());
        sb.append(str);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(j);
        String string = sb.toString();
        String str2 = this.zzb;
        if (!TextUtils.isEmpty(str2)) {
            string = a1.a.s(new StringBuilder(string.length() + 1 + String.valueOf(str2).length()), string, ".", str2);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbT)).booleanValue() || (num = this.zze) == null || TextUtils.isEmpty(str2)) {
            return string;
        }
        StringBuilder sb2 = new StringBuilder(string.length() + 1 + num.toString().length());
        sb2.append(string);
        sb2.append(".");
        sb2.append(num);
        return sb2.toString();
    }
}
