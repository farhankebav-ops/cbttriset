package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "ImageMetadataParcelCreator")
public final class zzcc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcc> CREATOR = new zzcd();

    @SafeParcelable.Field(getter = "getImageFormat", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getWidth", id = 2)
    private final int zzb;

    @SafeParcelable.Field(getter = "getHeight", id = 3)
    private final int zzc;

    @SafeParcelable.Field(getter = "getRotation", id = 4)
    private final int zzd;

    @SafeParcelable.Field(getter = "getTimestampMs", id = 5)
    private final long zze;

    @SafeParcelable.Constructor
    public zzcc(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i8, @SafeParcelable.Param(id = 3) int i9, @SafeParcelable.Param(id = 4) int i10, @SafeParcelable.Param(id = 5) long j) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = i9;
        this.zzd = i10;
        this.zze = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final int zzd() {
        return this.zzb;
    }
}
