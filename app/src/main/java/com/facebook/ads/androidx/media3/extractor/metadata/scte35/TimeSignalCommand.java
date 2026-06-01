package com.facebook.ads.androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.instagram.common.viewpoint.core.C4J;
import com.instagram.common.viewpoint.core.C4R;
import com.instagram.common.viewpoint.core.I0;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static String[] A02 = {"fBCCr7VwDgvhDxdGkzRiY2TvWvmZmARS", "lBD0fDkRFVdGPYWDbMcaGx4cyXv4WEJh", "6y4HJXgmtxqVkaNMzYZBmSXA6CGxm4DJ", "vpsLDrGqE5zherZQZMMLL6G3cLRsG8Dm", "qp0fDGr3Nzl8ahCuvet6k2311zos", "c5cBfT4Hj52dvZvyRqGaKhWxL68ft04u", "OtVyWYxYdMxR9geYu5t1Sc80NPuk", "8DkmlbSWSEaEI0nee1I51BPAFd"};
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new I0();
    public final long A00;
    public final long A01;

    public TimeSignalCommand(long j, long j3) {
        this.A01 = j;
        this.A00 = j3;
    }

    public /* synthetic */ TimeSignalCommand(long j, long j3, I0 i0) {
        this(j, j3);
    }

    public static long A00(C4J c4j, long j) {
        long jA0I = c4j.A0I();
        if ((128 & jA0I) == 0) {
            return -9223372036854775807L;
        }
        long firstByte = c4j.A0Q();
        long j3 = (((1 & jA0I) << 32) | firstByte) + j;
        if (A02[7].length() == 21) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[5] = "5vtaLYhnTEc2lUg08l0YEv2QqnnKhzp8";
        strArr[0] = "gGhCeZV4kOFdoFbuN1d60dh6MMvStMtQ";
        return j3 & 8589934591L;
    }

    public static TimeSignalCommand A01(C4J c4j, long j, C4R c4r) {
        long jA00 = A00(c4j, j);
        return new TimeSignalCommand(jA00, c4r.A06(jA00));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
    }
}
