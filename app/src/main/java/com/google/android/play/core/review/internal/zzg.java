package com.google.android.play.core.review.internal;

import a1.a;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzg extends zzb implements zzh {
    public zzg() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    @Override // com.google.android.play.core.review.internal.zzb
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i8) throws RemoteException {
        if (i2 != 2) {
            return false;
        }
        Parcelable.Creator creator = Bundle.CREATOR;
        int i9 = zzc.zza;
        Bundle bundle = (Bundle) (parcel.readInt() == 0 ? null : (Parcelable) creator.createFromParcel(parcel));
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(a.g(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
        zzb(bundle);
        return true;
    }
}
