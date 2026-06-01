package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import androidx.annotation.NonNull;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzawo {
    public static final String zza(@NonNull Context context, @NonNull String str, long j, boolean z2) {
        try {
            zzavi zzaviVarZza = zzavj.zza();
            zzaviVarZza.zzb(str);
            zzaviVarZza.zza("0.460000000");
            zzaviVarZza.zzd(context.getPackageName());
            zzaviVarZza.zzf((System.currentTimeMillis() - j) / 1000);
            zzaviVarZza.zzc(System.currentTimeMillis() / 1000);
            try {
                zzaviVarZza.zze(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                zzaviVarZza.zze(-1L);
            }
            zzavp zzavpVarZzc = zzavz.zzc(((zzavj) zzaviVarZza.zzbu()).zzaN(), null);
            zzavpVarZzc.zzc(5);
            zzavpVarZzc.zzd(2);
            return Base64.encodeToString(((zzavq) zzavpVarZzc.zzbu()).zzaN(), 11);
        } catch (UnsupportedEncodingException | GeneralSecurityException unused2) {
            return Integer.toString(7);
        }
    }
}
