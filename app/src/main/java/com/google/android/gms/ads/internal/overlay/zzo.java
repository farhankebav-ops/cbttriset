package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j = 0;
        boolean z2 = false;
        int i2 = 0;
        int i8 = 0;
        boolean z7 = false;
        zzc zzcVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String strCreateString = null;
        String strCreateString2 = null;
        IBinder iBinder5 = null;
        String strCreateString3 = null;
        VersionInfoParcel versionInfoParcel = null;
        String strCreateString4 = null;
        com.google.android.gms.ads.internal.zzl zzlVar = null;
        IBinder iBinder6 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        IBinder iBinder7 = null;
        IBinder iBinder8 = null;
        IBinder iBinder9 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    zzcVar = (zzc) SafeParcelReader.createParcelable(parcel, header, zzc.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 6:
                    iBinder4 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 7:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 8:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 9:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 10:
                    iBinder5 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 11:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 12:
                    i8 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 13:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) SafeParcelReader.createParcelable(parcel, header, VersionInfoParcel.CREATOR);
                    break;
                case 15:
                case 20:
                case 21:
                case 22:
                case 23:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 16:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 17:
                    zzlVar = (com.google.android.gms.ads.internal.zzl) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.zzl.CREATOR);
                    break;
                case 18:
                    iBinder6 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 19:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 24:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 25:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                case 26:
                    iBinder7 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 27:
                    iBinder8 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 28:
                    iBinder9 = SafeParcelReader.readIBinder(parcel, header);
                    break;
                case 29:
                    z7 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 30:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new AdOverlayInfoParcel(zzcVar, iBinder, iBinder2, iBinder3, iBinder4, strCreateString, z2, strCreateString2, iBinder5, i2, i8, strCreateString3, versionInfoParcel, strCreateString4, zzlVar, iBinder6, strCreateString5, strCreateString6, strCreateString7, iBinder7, iBinder8, iBinder9, z7, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new AdOverlayInfoParcel[i2];
    }
}
