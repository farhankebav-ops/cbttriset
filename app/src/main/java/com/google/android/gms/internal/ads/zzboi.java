package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
public final class zzboi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzboi> CREATOR = new zzboj();

    @SafeParcelable.VersionField(id = 1000)
    public final int zza;

    @SafeParcelable.Field(id = 1)
    public final int zzb;

    @SafeParcelable.Field(id = 2)
    public final String zzc;

    @SafeParcelable.Field(id = 3)
    public final int zzd;

    @SafeParcelable.Constructor
    public zzboi(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) int i8, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i9) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = str;
        this.zzd = i9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int i8 = this.zzb;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i8);
        SafeParcelWriter.writeString(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
