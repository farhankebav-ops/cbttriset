package androidx.emoji2.text.flatbuffer;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class DecodeUtil {
        public static void handleFourBytes(byte b8, byte b9, byte b10, byte b11, char[] cArr, int i2) throws IllegalArgumentException {
            if (!isNotTrailingByte(b9)) {
                if ((((b9 + 112) + (b8 << 28)) >> 30) == 0 && !isNotTrailingByte(b10) && !isNotTrailingByte(b11)) {
                    int iTrailingByteValue = ((b8 & 7) << 18) | (trailingByteValue(b9) << 12) | (trailingByteValue(b10) << 6) | trailingByteValue(b11);
                    cArr[i2] = highSurrogate(iTrailingByteValue);
                    cArr[i2 + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        public static void handleOneByte(byte b8, char[] cArr, int i2) {
            cArr[i2] = (char) b8;
        }

        public static void handleThreeBytes(byte b8, byte b9, byte b10, char[] cArr, int i2) throws IllegalArgumentException {
            if (isNotTrailingByte(b9) || ((b8 == -32 && b9 < -96) || ((b8 == -19 && b9 >= -96) || isNotTrailingByte(b10)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i2] = (char) (((b8 & 15) << 12) | (trailingByteValue(b9) << 6) | trailingByteValue(b10));
        }

        public static void handleTwoBytes(byte b8, byte b9, char[] cArr, int i2) throws IllegalArgumentException {
            if (b8 < -62) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            }
            if (isNotTrailingByte(b9)) {
                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
            }
            cArr[i2] = (char) (((b8 & 31) << 6) | trailingByteValue(b9));
        }

        private static char highSurrogate(int i2) {
            return (char) ((i2 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b8) {
            return b8 > -65;
        }

        public static boolean isOneByte(byte b8) {
            return b8 >= 0;
        }

        public static boolean isThreeBytes(byte b8) {
            return b8 < -16;
        }

        public static boolean isTwoBytes(byte b8) {
            return b8 < -32;
        }

        private static char lowSurrogate(int i2) {
            return (char) ((i2 & IronSourceError.ERROR_RV_SHOW_CALLED_WRONG_STATE) + 56320);
        }

        private static int trailingByteValue(byte b8) {
            return b8 & 63;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i2, int i8) {
            super(androidx.camera.core.processing.util.a.i("Unpaired surrogate at index ", i2, " of ", i8));
        }
    }

    public static Utf8 getDefault() {
        if (DEFAULT == null) {
            DEFAULT = new Utf8Safe();
        }
        return DEFAULT;
    }

    public static void setDefault(Utf8 utf8) {
        DEFAULT = utf8;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i2, int i8);

    public abstract void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer);

    public abstract int encodedLength(CharSequence charSequence);
}
