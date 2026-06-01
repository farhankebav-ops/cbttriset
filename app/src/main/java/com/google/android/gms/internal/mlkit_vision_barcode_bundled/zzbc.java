package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "BarhopperAdvancedConfigParcelCreator")
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbd();

    @SafeParcelable.Field(getter = "getMultiScaleDecodingOptions", id = 1)
    private final zzbt zza;

    @SafeParcelable.Field(getter = "getMultiScaleDetectionOptions", id = 2)
    private final zzbv zzb;

    @SafeParcelable.Field(getter = "getQrFilterFinderPatternsOnAngle", id = 3)
    private final boolean zzc = true;

    @SafeParcelable.Field(getter = "getQrEnableFourthCornerApproximation", id = 4)
    private final boolean zzd;

    @SafeParcelable.Constructor
    public zzbc(@SafeParcelable.Param(id = 1) zzbt zzbtVar, @SafeParcelable.Param(id = 2) zzbv zzbvVar, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) boolean z7) {
        this.zza = zzbtVar;
        this.zzb = zzbvVar;
        this.zzd = z7;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final zzbt zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzd;
    }
}
