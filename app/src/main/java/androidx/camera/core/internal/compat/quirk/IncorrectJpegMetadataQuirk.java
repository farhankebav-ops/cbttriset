package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirk;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class IncorrectJpegMetadataQuirk implements Quirk {
    private static final Set<String> SAMSUNG_DEVICES = new HashSet(Arrays.asList("A24", "BEYOND0", "BEYOND2"));

    private boolean canParseSosMarker(byte[] bArr) {
        byte b8;
        int i2 = 2;
        while (i2 + 4 <= bArr.length && (b8 = bArr[i2]) == -1) {
            if (b8 == -1 && bArr[i2 + 1] == -38) {
                return true;
            }
            i2 += (((bArr[i2 + 2] & 255) << 8) | (bArr[i2 + 3] & 255)) + 2;
        }
        return false;
    }

    private int findSecondFfd8Position(byte[] bArr) {
        int i2 = 2;
        while (true) {
            int i8 = i2 + 1;
            if (i8 > bArr.length) {
                return -1;
            }
            if (bArr[i2] == -1 && bArr[i8] == -40) {
                return i2;
            }
            i2 = i8;
        }
    }

    private static boolean isSamsungProblematicDevice() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && SAMSUNG_DEVICES.contains(Build.DEVICE.toUpperCase(Locale.US));
    }

    public static boolean load() {
        return isSamsungProblematicDevice();
    }

    public byte[] jpegImageToJpegByteArray(ImageProxy imageProxy) {
        int iFindSecondFfd8Position = 0;
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        return (canParseSosMarker(bArr) || (iFindSecondFfd8Position = findSecondFfd8Position(bArr)) != -1) ? Arrays.copyOfRange(bArr, iFindSecondFfd8Position, buffer.limit()) : bArr;
    }
}
