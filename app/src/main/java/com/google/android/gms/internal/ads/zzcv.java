package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcv {
    @EnsuresNonNull({"#1"})
    @Deprecated
    @Pure
    public static String zza(@Nullable String str) {
        zzgmd.zza(!TextUtils.isEmpty(str));
        return str;
    }
}
