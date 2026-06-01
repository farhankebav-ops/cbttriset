package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(30)
final class zzabc {
    public static void zza(Surface surface, float f4) {
        try {
            surface.setFrameRate(f4, f4 == 0.0f ? 0 : 1);
        } catch (IllegalStateException e) {
            zzdt.zzf("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
        }
    }
}
