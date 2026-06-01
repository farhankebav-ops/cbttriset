package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfwx extends zzfww {
    private static zzfwx zzd;

    private zzfwx(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfwx zzh(Context context) {
        zzfwx zzfwxVar;
        synchronized (zzfwx.class) {
            try {
                if (zzd == null) {
                    zzd = new zzfwx(context);
                }
                zzfwxVar = zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfwxVar;
    }

    public final zzfwt zzi(long j, boolean z2) throws IOException {
        zzfwt zzfwtVarZza;
        synchronized (zzfwx.class) {
            zzfwtVarZza = zza(null, null, j, z2);
        }
        return zzfwtVarZza;
    }

    public final zzfwt zzj(String str, String str2, long j, boolean z2) throws IOException {
        zzfwt zzfwtVarZza;
        synchronized (zzfwx.class) {
            zzfwtVarZza = zza(str, str2, j, z2);
        }
        return zzfwtVarZza;
    }

    public final void zzk() throws IOException {
        synchronized (zzfwx.class) {
            zzc(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzfwx.class) {
            zzc(true);
        }
    }
}
