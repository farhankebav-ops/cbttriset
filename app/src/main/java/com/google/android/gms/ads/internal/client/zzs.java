package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        String strCreateString = null;
        zzr[] zzrVarArr = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i8 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 6:
                    i9 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    zzrVarArr = (zzr[]) SafeParcelReader.createTypedArray(parcel, header, zzr.CREATOR);
                    break;
                case 9:
                    z7 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    z8 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z9 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    z10 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 13:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 14:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 15:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 16:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzr(strCreateString, i2, i8, z2, i9, i10, zzrVarArr, z7, z8, z9, z10, z11, z12, z13, z14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzr[i2];
    }
}
