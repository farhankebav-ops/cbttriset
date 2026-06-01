package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
public final class VersionInfoParcel extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<VersionInfoParcel> CREATOR = new zzy();

    @NonNull
    @SafeParcelable.Field(id = 2)
    public String afmaVersion;

    @SafeParcelable.Field(id = 3)
    public int buddyApkVersion;

    @SafeParcelable.Field(id = 4)
    public int clientJarVersion;

    @SafeParcelable.Field(id = 5)
    public boolean isClientJar;

    @SafeParcelable.Field(id = 6)
    public boolean isLiteSdk;

    public VersionInfoParcel(int i2, int i8, boolean z2) {
        this(i2, i8, z2, false, false);
    }

    @NonNull
    public static VersionInfoParcel forPackage() {
        return new VersionInfoParcel(12451000, 12451000, true);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.afmaVersion, false);
        SafeParcelWriter.writeInt(parcel, 3, this.buddyApkVersion);
        SafeParcelWriter.writeInt(parcel, 4, this.clientJarVersion);
        SafeParcelWriter.writeBoolean(parcel, 5, this.isClientJar);
        SafeParcelWriter.writeBoolean(parcel, 6, this.isLiteSdk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public VersionInfoParcel(int i2, int i8, boolean z2, boolean z7) {
        this(i2, i8, z2, false, z7);
    }

    public VersionInfoParcel(int i2, int i8, boolean z2, boolean z7, boolean z8) {
        String str;
        if (z2) {
            str = "0";
        } else {
            str = z7 ? "2" : "1";
        }
        int length = String.valueOf(i2).length();
        StringBuilder sb = new StringBuilder(str.length() + String.valueOf(i8).length() + length + 13 + 1);
        a.k(i2, i8, "afma-sdk-a-v", ".", sb);
        this(a1.a.r(sb, ".", str), i2, i8, z2, z8);
    }

    @SafeParcelable.Constructor
    public VersionInfoParcel(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i8, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z7) {
        this.afmaVersion = str;
        this.buddyApkVersion = i2;
        this.clientJarVersion = i8;
        this.isClientJar = z2;
        this.isLiteSdk = z7;
    }
}
