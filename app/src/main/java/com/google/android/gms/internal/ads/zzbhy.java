package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbhy implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        boolean z2 = false;
        int i8 = 0;
        boolean z7 = false;
        int i9 = 0;
        boolean z8 = false;
        int i10 = 0;
        int i11 = 0;
        boolean z9 = false;
        int i12 = 0;
        com.google.android.gms.ads.internal.client.zzga zzgaVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 3:
                    i8 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    z7 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    i9 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zzgaVar = (com.google.android.gms.ads.internal.client.zzga) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzga.CREATOR);
                    break;
                case 7:
                    z8 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 8:
                    i10 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 9:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    z9 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbhx(i2, z2, i8, z7, i9, zzgaVar, z8, i10, i11, z9, i12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzbhx[i2];
    }
}
