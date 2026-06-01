package androidx.camera.core.internal.compat.workaround;

import androidx.annotation.VisibleForTesting;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class InvalidJpegDataParser {
    private final LargeJpegImageQuirk mQuirk = (LargeJpegImageQuirk) DeviceQuirks.get(LargeJpegImageQuirk.class);

    @VisibleForTesting
    public static int getJfifEoiMarkEndPosition(byte[] bArr) {
        byte b8;
        int i2 = 2;
        while (i2 + 4 <= bArr.length && (b8 = bArr[i2]) == -1) {
            int i8 = i2 + 2;
            int i9 = ((bArr[i8] & 255) << 8) | (bArr[i2 + 3] & 255);
            if (b8 == -1 && bArr[i2 + 1] == -38) {
                while (true) {
                    int i10 = i8 + 2;
                    if (i10 > bArr.length) {
                        return -1;
                    }
                    if (bArr[i8] == -1 && bArr[i8 + 1] == -39) {
                        return i10;
                    }
                    i8++;
                }
            } else {
                i2 += i9 + 2;
            }
        }
        return -1;
    }

    public int getValidDataLength(byte[] bArr) {
        LargeJpegImageQuirk largeJpegImageQuirk = this.mQuirk;
        if (largeJpegImageQuirk == null || !largeJpegImageQuirk.shouldCheckInvalidJpegData(bArr)) {
            return bArr.length;
        }
        int jfifEoiMarkEndPosition = getJfifEoiMarkEndPosition(bArr);
        return jfifEoiMarkEndPosition != -1 ? jfifEoiMarkEndPosition : bArr.length;
    }
}
