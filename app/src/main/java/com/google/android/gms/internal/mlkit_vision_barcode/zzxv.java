package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "GeoPointParcelCreator")
public final class zzxv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxv> CREATOR = new zzyk();

    @SafeParcelable.Field(getter = "getLat", id = 1)
    private final double zza;

    @SafeParcelable.Field(getter = "getLng", id = 2)
    private final double zzb;

    @SafeParcelable.Constructor
    public zzxv(@SafeParcelable.Param(id = 1) double d8, @SafeParcelable.Param(id = 2) double d9) {
        this.zza = d8;
        this.zzb = d9;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeDouble(parcel, 1, this.zza);
        SafeParcelWriter.writeDouble(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final double zza() {
        return this.zza;
    }

    public final double zzb() {
        return this.zzb;
    }
}
