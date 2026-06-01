package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfwu {
    private static zzfwu zzb;
    final zzfwv zza;

    private zzfwu(Context context) {
        this.zza = zzfwv.zza(context);
    }

    public static final zzfwu zza(Context context) {
        zzfwu zzfwuVar;
        synchronized (zzfwu.class) {
            try {
                if (zzb == null) {
                    zzb = new zzfwu(context);
                }
                zzfwuVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfwuVar;
    }

    public final void zzb(boolean z2) throws IOException {
        synchronized (zzfwu.class) {
            try {
                zzfwv zzfwvVar = this.zza;
                zzfwvVar.zzb("paidv2_publisher_option", Boolean.valueOf(z2));
                if (!z2) {
                    zzfwvVar.zzf("paidv2_creation_time");
                    zzfwvVar.zzf("paidv2_id");
                    zzfwvVar.zzf("vendor_scoped_gpid_v2_id");
                    zzfwvVar.zzf("vendor_scoped_gpid_v2_creation_time");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc() {
        boolean zZze;
        synchronized (zzfwu.class) {
            zZze = this.zza.zze("paidv2_publisher_option", true);
        }
        return zZze;
    }

    public final void zzd(boolean z2) throws IOException {
        synchronized (zzfwu.class) {
            this.zza.zzb("paidv2_user_option", Boolean.valueOf(z2));
        }
    }

    public final boolean zze() {
        boolean zZze;
        synchronized (zzfwu.class) {
            zZze = this.zza.zze("paidv2_user_option", true);
        }
        return zZze;
    }
}
