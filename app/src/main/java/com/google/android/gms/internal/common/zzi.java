package com.google.android.gms.internal.common;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzi {
    private final Class zza;

    @Nullable
    private final Object zzb;

    private zzi(Class cls, @Nullable Object obj) {
        this.zza = cls;
        this.zzb = obj;
    }

    public static zzi zzb(Class cls, @Nullable Object obj) {
        return new zzi(cls, obj);
    }

    public final Class zzc() {
        return this.zza;
    }

    @Nullable
    public final Object zzd() {
        return this.zzb;
    }

    public /* synthetic */ zzi(Class cls, Object obj, byte[] bArr) {
        this(cls, obj);
    }
}
