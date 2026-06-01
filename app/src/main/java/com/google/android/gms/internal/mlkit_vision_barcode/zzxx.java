package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "PhoneParcelCreator")
public final class zzxx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxx> CREATOR = new zzyq();

    @SafeParcelable.Field(getter = "getType", id = 1)
    private final int zza;

    @Nullable
    @SafeParcelable.Field(getter = "getNumber", id = 2)
    private final String zzb;

    @SafeParcelable.Constructor
    public zzxx(@SafeParcelable.Param(id = 1) int i2, @Nullable @SafeParcelable.Param(id = 2) String str) {
        this.zza = i2;
        this.zzb = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }
}
