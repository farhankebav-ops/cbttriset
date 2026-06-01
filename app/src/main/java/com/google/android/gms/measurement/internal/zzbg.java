package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbh();

    @SafeParcelable.Field(id = 2)
    public final String zza;

    @SafeParcelable.Field(id = 3)
    public final zzbe zzb;

    @SafeParcelable.Field(id = 4)
    public final String zzc;

    @SafeParcelable.Field(id = 5)
    public final long zzd;

    public zzbg(zzbg zzbgVar, long j) {
        Preconditions.checkNotNull(zzbgVar);
        this.zza = zzbgVar.zza;
        this.zzb = zzbgVar.zzb;
        this.zzc = zzbgVar.zzc;
        this.zzd = j;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        String str = this.zzc;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + strValueOf.length());
        androidx.camera.core.processing.util.a.A(sb, "origin=", str, ",name=", str2);
        return a1.a.r(sb, ",params=", strValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        zzbh.zza(this, parcel, i2);
    }

    @SafeParcelable.Constructor
    public zzbg(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) zzbe zzbeVar, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) long j) {
        this.zza = str;
        this.zzb = zzbeVar;
        this.zzc = str2;
        this.zzd = j;
    }
}
