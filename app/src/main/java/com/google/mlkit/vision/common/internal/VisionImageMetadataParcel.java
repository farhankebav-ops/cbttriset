package com.google.mlkit.vision.common.internal;

import android.graphics.Matrix;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
@SafeParcelable.Class(creator = "VisionImageMetadataParcelCreator")
public class VisionImageMetadataParcel extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new zzg();

    @KeepForSdk
    @SafeParcelable.Field(id = 2)
    public final int height;

    @KeepForSdk
    @SafeParcelable.Field(id = 5)
    public final int rotation;

    @KeepForSdk
    @SafeParcelable.Field(id = 4)
    public final long timestampMillis;

    @KeepForSdk
    @SafeParcelable.Field(id = 1)
    public final int width;

    @SafeParcelable.Field(id = 3)
    public final int zza;

    @SafeParcelable.Constructor
    public VisionImageMetadataParcel(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i8, @SafeParcelable.Param(id = 3) int i9, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) int i10) {
        this.width = i2;
        this.height = i8;
        this.zza = i9;
        this.timestampMillis = j;
        this.rotation = i10;
    }

    @Nullable
    @KeepForSdk
    public Matrix getUprightRotationMatrix() {
        return ImageUtils.getInstance().getUprightRotationMatrix(this.width, this.height, this.rotation);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.width);
        SafeParcelWriter.writeInt(parcel, 2, this.height);
        SafeParcelWriter.writeInt(parcel, 3, this.zza);
        SafeParcelWriter.writeLong(parcel, 4, this.timestampMillis);
        SafeParcelWriter.writeInt(parcel, 5, this.rotation);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
