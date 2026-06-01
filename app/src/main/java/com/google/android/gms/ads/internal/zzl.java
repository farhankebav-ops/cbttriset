package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();

    @SafeParcelable.Field(id = 2)
    public final boolean zza;

    @SafeParcelable.Field(id = 3)
    public final boolean zzb;

    @SafeParcelable.Field(id = 4)
    public final String zzc;

    @SafeParcelable.Field(id = 5)
    public final boolean zzd;

    @SafeParcelable.Field(id = 6)
    public final float zze;

    @SafeParcelable.Field(id = 7)
    public final int zzf;

    @SafeParcelable.Field(id = 8)
    public final boolean zzg;

    @SafeParcelable.Field(id = 9)
    public final boolean zzh;

    @SafeParcelable.Field(id = 10)
    public final boolean zzi;

    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) boolean z7, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) boolean z8, @SafeParcelable.Param(id = 6) float f4, @SafeParcelable.Param(id = 7) int i2, @SafeParcelable.Param(id = 8) boolean z9, @SafeParcelable.Param(id = 9) boolean z10, @SafeParcelable.Param(id = 10) boolean z11) {
        this.zza = z2;
        this.zzb = z7;
        this.zzc = str;
        this.zzd = z8;
        this.zze = f4;
        this.zzf = i2;
        this.zzg = z9;
        this.zzh = z10;
        this.zzi = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        boolean z2 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, z2);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeFloat(parcel, 6, this.zze);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzl(boolean z2, boolean z7, boolean z8, float f4, int i2, boolean z9, boolean z10, boolean z11) {
        this(z2, z7, null, z8, f4, -1, z9, z10, z11);
    }
}
