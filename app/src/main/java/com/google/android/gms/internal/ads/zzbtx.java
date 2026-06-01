package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@SafeParcelable.Class(creator = "RtbVersionInfoParcelCreator")
public final class zzbtx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbtx> CREATOR = new zzbty();

    @SafeParcelable.Field(id = 1)
    public final int zza;

    @SafeParcelable.Field(id = 2)
    public final int zzb;

    @SafeParcelable.Field(id = 3)
    public final int zzc;

    @SafeParcelable.Constructor
    public zzbtx(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i8, @SafeParcelable.Param(id = 3) int i9) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = i9;
    }

    public static zzbtx zza(VersionInfo versionInfo) {
        return new zzbtx(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbtx)) {
            zzbtx zzbtxVar = (zzbtx) obj;
            if (zzbtxVar.zzc == this.zzc && zzbtxVar.zzb == this.zzb && zzbtxVar.zza == this.zza) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        int i2 = this.zza;
        int length = String.valueOf(i2).length();
        int i8 = this.zzb;
        int length2 = String.valueOf(i8).length();
        int i9 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 1 + length2 + 1 + String.valueOf(i9).length());
        androidx.camera.core.processing.util.a.w(i2, i8, ".", ".", sb);
        sb.append(i9);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int i8 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i8);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
