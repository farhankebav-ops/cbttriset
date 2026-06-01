package com.facebook.ads.androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.instagram.common.viewpoint.core.AbstractC04664a;
import com.instagram.common.viewpoint.core.C0796Hi;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UrlLinkFrame extends Id3Frame {
    public static byte[] A02;
    public static String[] A03 = {"xxXPcCrNJGLODnntRXdDXuTLETzeRSPk", "BM6YzmnlcmbfbcRTXZNQ791eRQEfQtzt", "fhJqw", "jLA8WfPPASI7lTWhNaBhUXLjINWrZlwE", "SaNh", "Wiu8Q", "Gydj", "3rZ3NkXCEjz6xD1XlhGn8ySTpct48s"};
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR;
    public final String A00;
    public final String A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-84, -110, -25, -28, -34, -81};
    }

    static {
        A01();
        CREATOR = new C0796Hi();
    }

    public UrlLinkFrame(Parcel parcel) {
        super((String) AbstractC04664a.A0f(parcel.readString()));
        this.A00 = parcel.readString();
        this.A01 = (String) AbstractC04664a.A0f(parcel.readString());
    }

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.A00 = str2;
        this.A01 = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (A03[1].charAt(26) == '7') {
            throw new RuntimeException();
        }
        A03[7] = "KGgHB7WLO7OsYt6jFaU1vF";
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        if (super.A00.equals(((Id3Frame) urlLinkFrame).A00) && AbstractC04664a.A1E(this.A00, urlLinkFrame.A00) && AbstractC04664a.A1E(this.A01, urlLinkFrame.A01)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = super.A00.hashCode();
        return (((((17 * 31) + result) * 31) + (this.A00 != null ? this.A00.hashCode() : 0)) * 31) + (this.A01 != null ? this.A01.hashCode() : 0);
    }

    @Override // com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(0, 6, 2) + this.A01;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(super.A00);
        parcel.writeString(this.A00);
        parcel.writeString(this.A01);
    }
}
