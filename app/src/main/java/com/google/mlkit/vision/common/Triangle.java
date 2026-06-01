package com.google.mlkit.vision.common;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Triangle<T> {
    private final zzp zza;

    @KeepForSdk
    public Triangle(@NonNull T t3, @NonNull T t7, @NonNull T t8) {
        this.zza = zzp.zzj(t3, t7, t8);
    }

    @NonNull
    public List<T> getAllPoints() {
        return this.zza;
    }
}
