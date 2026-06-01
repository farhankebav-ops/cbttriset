package com.facebook.ads.androidx.media3.extractor.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.instagram.common.viewpoint.core.AbstractC04182c;
import com.instagram.common.viewpoint.core.AbstractC04664a;
import com.instagram.common.viewpoint.core.C2154or;
import com.instagram.common.viewpoint.core.HR;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
@Deprecated
public class VorbisComment implements Metadata.Entry {
    public static byte[] A02;
    public static final Parcelable.Creator<VorbisComment> CREATOR;
    public final String A00;
    public final String A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{119, 17, 4, 125, 103};
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ byte[] A9S() {
        return AbstractC04182c.A01(this);
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ C2154or A9T() {
        return AbstractC04182c.A00(this);
    }

    static {
        A01();
        CREATOR = new HR();
    }

    public VorbisComment(Parcel parcel) {
        this.A00 = (String) AbstractC04664a.A0f(parcel.readString());
        this.A01 = (String) AbstractC04664a.A0f(parcel.readString());
    }

    public VorbisComment(String str, String str2) {
        this.A00 = str;
        this.A01 = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.A00.equals(vorbisComment.A00) && this.A01.equals(vorbisComment.A01);
    }

    public final int hashCode() {
        int result = this.A00.hashCode();
        return (((17 * 31) + result) * 31) + this.A01.hashCode();
    }

    public final String toString() {
        return A00(1, 4, 91) + this.A00 + A00(0, 1, 86) + this.A01;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.A00);
        parcel.writeString(this.A01);
    }
}
