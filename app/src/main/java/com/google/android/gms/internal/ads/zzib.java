package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzib extends zzau {
    public final int zzc;

    @Nullable
    public final String zzd;
    public final int zze;

    @Nullable
    public final zzv zzf;
    public final int zzg;

    @Nullable
    public final zzuu zzh;
    final boolean zzi;

    private zzib(int i2, Throwable th, int i8) {
        this(i2, th, null, i8, null, -1, null, 4, null, false);
    }

    public static zzib zza(IOException iOException, int i2) {
        return new zzib(0, iOException, i2);
    }

    public static zzib zzb(Throwable th, String str, int i2, @Nullable zzv zzvVar, int i8, @Nullable zzuu zzuuVar, boolean z2, int i9) {
        if (zzvVar == null) {
            i8 = 4;
        }
        return new zzib(1, th, null, i9, str, i2, zzvVar, i8, zzuuVar, z2);
    }

    public static zzib zzc(RuntimeException runtimeException, int i2) {
        return new zzib(2, runtimeException, i2);
    }

    @CheckResult
    public final zzib zzd(@Nullable zzuu zzuuVar) {
        String message = getMessage();
        String str = zzep.zza;
        return new zzib(message, getCause(), this.zza, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzuuVar, this.zzb, this.zzi);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private zzib(int i2, @Nullable Throwable th, @Nullable String str, int i8, @Nullable String str2, int i9, @Nullable zzv zzvVar, int i10, @Nullable zzuu zzuuVar, boolean z2) {
        String str3;
        int i11;
        String strS;
        String str4;
        if (i2 == 0) {
            str3 = str2;
            i11 = i9;
            strS = "Source error";
        } else if (i2 != 1) {
            strS = "Unexpected runtime error";
            str3 = str2;
            i11 = i9;
        } else {
            String strValueOf = String.valueOf(zzvVar);
            String str5 = zzep.zza;
            if (i10 == 0) {
                str4 = "NO";
            } else if (i10 == 1) {
                str4 = "NO_UNSUPPORTED_TYPE";
            } else if (i10 == 2) {
                str4 = "NO_UNSUPPORTED_DRM";
            } else if (i10 == 3) {
                str4 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i10 != 4) {
                    throw new IllegalStateException();
                }
                str4 = "YES";
            }
            StringBuilder sb = new StringBuilder(str4.length() + strValueOf.length() + androidx.camera.core.processing.util.a.D(String.valueOf(str2).length() + 14, 9, String.valueOf(i9)) + 19);
            str3 = str2;
            sb.append(str3);
            sb.append(" error, index=");
            i11 = i9;
            sb.append(i11);
            sb.append(", format=");
            strS = a1.a.s(sb, strValueOf, ", format_supported=", str4);
        }
        this(TextUtils.isEmpty(null) ? strS : strS.concat(": null"), th, i8, i2, str3, i11, zzvVar, i10, zzuuVar, SystemClock.elapsedRealtime(), z2);
    }

    private zzib(String str, @Nullable Throwable th, int i2, int i8, @Nullable String str2, int i9, @Nullable zzv zzvVar, int i10, @Nullable zzuu zzuuVar, long j, boolean z2) {
        boolean z7;
        super(str, th, i2, Bundle.EMPTY, j);
        if (!z2) {
            z7 = true;
        } else if (i8 == 1) {
            i8 = 1;
            z7 = true;
        } else {
            z7 = false;
        }
        zzgmd.zza(z7);
        zzgmd.zza(th != null);
        this.zzc = i8;
        this.zzd = str2;
        this.zze = i9;
        this.zzf = zzvVar;
        this.zzg = i10;
        this.zzh = zzuuVar;
        this.zzi = z2;
    }
}
