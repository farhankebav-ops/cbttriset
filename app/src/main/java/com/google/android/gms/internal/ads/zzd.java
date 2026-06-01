package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.os.Build;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd {
    public static final zzd zza = new zzd(0, 0, 1, 1, 0, false, null);

    @Nullable
    private AudioAttributes zzb;

    static {
        String str = zzep.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    public /* synthetic */ zzd(int i2, int i8, int i9, int i10, int i11, boolean z2, byte[] bArr) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzd.class != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return -2092275855;
    }

    public final AudioAttributes zza() {
        if (this.zzb == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                usage.setAllowedCapturePolicy(1);
            }
            if (i2 >= 32) {
                usage.setSpatializationBehavior(0);
                usage.setIsContentSpatialized(false);
            }
            this.zzb = usage.build();
        }
        return this.zzb;
    }
}
