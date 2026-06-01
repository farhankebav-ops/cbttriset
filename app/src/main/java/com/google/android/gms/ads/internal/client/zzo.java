package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        long j3 = 0;
        long j8 = 0;
        int i2 = 0;
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        boolean z7 = false;
        boolean z8 = false;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        Bundle bundleCreateBundle = null;
        ArrayList<String> arrayListCreateStringList = null;
        String strCreateString = null;
        zzfx zzfxVar = null;
        Location location = null;
        String strCreateString2 = null;
        Bundle bundleCreateBundle2 = null;
        Bundle bundleCreateBundle3 = null;
        ArrayList<String> arrayListCreateStringList2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        zzc zzcVar = null;
        String strCreateString5 = null;
        ArrayList<String> arrayListCreateStringList3 = null;
        String strCreateString6 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 3:
                    bundleCreateBundle = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 4:
                    i8 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 6:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 7:
                    i9 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    z7 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 9:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 10:
                    zzfxVar = (zzfx) SafeParcelReader.createParcelable(parcel, header, zzfx.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.createParcelable(parcel, header, Location.CREATOR);
                    break;
                case 12:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 13:
                    bundleCreateBundle2 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 14:
                    bundleCreateBundle3 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 15:
                    arrayListCreateStringList2 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 16:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 17:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 18:
                    z8 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 19:
                    zzcVar = (zzc) SafeParcelReader.createParcelable(parcel, header, zzc.CREATOR);
                    break;
                case 20:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 21:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 22:
                    arrayListCreateStringList3 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 23:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 24:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 25:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 26:
                    j3 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 27:
                    j8 = SafeParcelReader.readLong(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzm(i2, j, bundleCreateBundle, i8, arrayListCreateStringList, z2, i9, z7, strCreateString, zzfxVar, location, strCreateString2, bundleCreateBundle2, bundleCreateBundle3, arrayListCreateStringList2, strCreateString3, strCreateString4, z8, zzcVar, i10, strCreateString5, arrayListCreateStringList3, i11, strCreateString6, i12, j3, j8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzm[i2];
    }
}
