package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaam extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzaal zzd;
    private boolean zze;

    public /* synthetic */ zzaam(zzaal zzaalVar, SurfaceTexture surfaceTexture, boolean z2, byte[] bArr) {
        super(surfaceTexture);
        this.zzd = zzaalVar;
        this.zza = z2;
    }

    public static synchronized boolean zza(Context context) {
        if (!zzc) {
            try {
            } catch (zzdj e) {
                zzdt.zze("PlaceholderSurface", "Failed to determine secure mode due to GL error: ".concat(String.valueOf(e.getMessage())));
            }
            int i2 = zzdk.zza(context) ? zzdk.zzb() ? 1 : 2 : 0;
            zzb = i2;
            zzc = true;
        }
        return zzb != 0;
    }

    public static zzaam zzb(Context context, boolean z2) {
        boolean z7 = true;
        if (z2 && !zza(context)) {
            z7 = false;
        }
        zzgmd.zzh(z7);
        return new zzaal().zza(z2 ? zzb : 0);
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        zzaal zzaalVar = this.zzd;
        synchronized (zzaalVar) {
            try {
                if (!this.zze) {
                    zzaalVar.zzb();
                    this.zze = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
