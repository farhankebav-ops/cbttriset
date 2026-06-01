package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzat extends IOException {
    public final boolean zza;
    public final int zzb;

    public zzat(@Nullable String str, @Nullable Throwable th, boolean z2, int i2) {
        super(str, th);
        this.zza = z2;
        this.zzb = i2;
    }

    public static zzat zza(@Nullable String str, @Nullable Throwable th) {
        return new zzat(str, th, true, 0);
    }

    public static zzat zzb(@Nullable String str, @Nullable Throwable th) {
        return new zzat(str, th, true, 1);
    }

    public static zzat zzc(@Nullable String str) {
        return new zzat(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        String strConcat = message != null ? message.concat(" ") : "";
        boolean z2 = this.zza;
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + String.valueOf(z2).length() + strConcat.length() + 20 + 11 + 1);
        sb.append(strConcat);
        sb.append("{contentIsMalformed=");
        sb.append(z2);
        sb.append(", dataType=");
        return a1.a.q(sb, "}", i2);
    }
}
