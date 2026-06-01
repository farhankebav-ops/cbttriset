package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "ContactInfoParcelCreator")
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new zzbi();

    @Nullable
    @SafeParcelable.Field(getter = "getName", id = 1)
    private final zzat zza;

    @Nullable
    @SafeParcelable.Field(getter = "getOrganization", id = 2)
    private final String zzb;

    @Nullable
    @SafeParcelable.Field(getter = "getTitle", id = 3)
    private final String zzc;

    @Nullable
    @SafeParcelable.Field(getter = "getPhones", id = 4)
    private final zzau[] zzd;

    @Nullable
    @SafeParcelable.Field(getter = "getEmails", id = 5)
    private final zzar[] zze;

    @Nullable
    @SafeParcelable.Field(getter = "getUrls", id = 6)
    private final String[] zzf;

    @Nullable
    @SafeParcelable.Field(getter = "getAddresses", id = 7)
    private final zzam[] zzg;

    @SafeParcelable.Constructor
    public zzap(@Nullable @SafeParcelable.Param(id = 1) zzat zzatVar, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @Nullable @SafeParcelable.Param(id = 4) zzau[] zzauVarArr, @Nullable @SafeParcelable.Param(id = 5) zzar[] zzarVarArr, @Nullable @SafeParcelable.Param(id = 6) String[] strArr, @Nullable @SafeParcelable.Param(id = 7) zzam[] zzamVarArr) {
        this.zza = zzatVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzauVarArr;
        this.zze = zzarVarArr;
        this.zzf = strArr;
        this.zzg = zzamVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        zzat zzatVar = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzatVar, i2, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.zzd, i2, false);
        SafeParcelWriter.writeTypedArray(parcel, 5, this.zze, i2, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeTypedArray(parcel, 7, this.zzg, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
