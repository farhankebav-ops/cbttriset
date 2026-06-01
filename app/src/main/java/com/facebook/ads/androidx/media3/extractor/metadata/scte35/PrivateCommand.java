package com.facebook.ads.androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.instagram.common.viewpoint.core.AbstractC04664a;
import com.instagram.common.viewpoint.core.C0806Ht;
import com.instagram.common.viewpoint.core.C4J;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new C0806Ht();
    public final long A00;
    public final long A01;
    public final byte[] A02;

    public PrivateCommand(long j, byte[] bArr, long j3) {
        this.A01 = j3;
        this.A00 = j;
        this.A02 = bArr;
    }

    public PrivateCommand(Parcel parcel) {
        this.A01 = parcel.readLong();
        this.A00 = parcel.readLong();
        this.A02 = (byte[]) AbstractC04664a.A0f(parcel.createByteArray());
    }

    public /* synthetic */ PrivateCommand(Parcel parcel, C0806Ht c0806Ht) {
        this(parcel);
    }

    public static PrivateCommand A00(C4J c4j, int i2, long j) {
        long jA0Q = c4j.A0Q();
        byte[] bArr = new byte[i2 - 4];
        c4j.A0k(bArr, 0, bArr.length);
        return new PrivateCommand(jA0Q, bArr, j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
        parcel.writeByteArray(this.A02);
    }
}
