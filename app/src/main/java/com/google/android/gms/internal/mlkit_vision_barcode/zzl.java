package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "ContactInfoCreator")
@SafeParcelable.Reserved({1})
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzy();

    @SafeParcelable.Field(id = 2)
    public zzp zza;

    @SafeParcelable.Field(id = 3)
    public String zzb;

    @SafeParcelable.Field(id = 4)
    public String zzc;

    @SafeParcelable.Field(id = 5)
    public zzq[] zzd;

    @SafeParcelable.Field(id = 6)
    public zzn[] zze;

    @SafeParcelable.Field(id = 7)
    public String[] zzf;

    @SafeParcelable.Field(id = 8)
    public zzi[] zzg;

    public zzl() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zzd, i2, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zze, i2, false);
        SafeParcelWriter.writeStringArray(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzg, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Param(id = 2) zzp zzpVar, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) zzq[] zzqVarArr, @SafeParcelable.Param(id = 6) zzn[] zznVarArr, @SafeParcelable.Param(id = 7) String[] strArr, @SafeParcelable.Param(id = 8) zzi[] zziVarArr) {
        this.zza = zzpVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzqVarArr;
        this.zze = zznVarArr;
        this.zzf = strArr;
        this.zzg = zziVarArr;
    }
}
