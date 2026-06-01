package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfwz {
    private static zzfwz zzb;
    final zzfwv zza;

    private zzfwz(Context context) {
        this.zza = zzfwv.zza(context);
        zzfwu.zza(context);
    }

    public static final zzfwz zza(Context context) {
        zzfwz zzfwzVar;
        synchronized (zzfwz.class) {
            try {
                if (zzb == null) {
                    zzb = new zzfwz(context);
                }
                zzfwzVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfwzVar;
    }

    public final void zzb(@Nullable zzfwt zzfwtVar) throws IOException {
        synchronized (zzfwz.class) {
            zzfwv zzfwvVar = this.zza;
            zzfwvVar.zzf("vendor_scoped_gpid_v2_id");
            zzfwvVar.zzf("vendor_scoped_gpid_v2_creation_time");
        }
    }
}
