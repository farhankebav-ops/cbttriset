package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzgc extends IOException {
    public final int zza;

    public zzgc(int i2) {
        this.zza = i2;
    }

    public zzgc(@Nullable String str, int i2) {
        super(str);
        this.zza = i2;
    }

    public zzgc(@Nullable String str, @Nullable Throwable th, int i2) {
        super(str, th);
        this.zza = i2;
    }

    public zzgc(@Nullable Throwable th, int i2) {
        super(th);
        this.zza = i2;
    }
}
