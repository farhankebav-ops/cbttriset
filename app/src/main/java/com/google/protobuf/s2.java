package com.google.protobuf;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class s2 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final b processor;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b8, byte b9, byte b10, byte b11, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(b9)) {
                if ((((b9 + 112) + (b8 << 28)) >> 30) == 0 && !isNotTrailingByte(b10) && !isNotTrailingByte(b11)) {
                    int iTrailingByteValue = ((b8 & 7) << 18) | (trailingByteValue(b9) << 12) | (trailingByteValue(b10) << 6) | trailingByteValue(b11);
                    cArr[i2] = highSurrogate(iTrailingByteValue);
                    cArr[i2 + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b8, char[] cArr, int i2) {
            cArr[i2] = (char) b8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b8, byte b9, byte b10, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b9) || ((b8 == -32 && b9 < -96) || ((b8 == -19 && b9 >= -96) || isNotTrailingByte(b10)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i2] = (char) (((b8 & 15) << 12) | (trailingByteValue(b9) << 6) | trailingByteValue(b10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b8, byte b9, char[] cArr, int i2) throws InvalidProtocolBufferException {
            if (b8 < -62 || isNotTrailingByte(b9)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i2] = (char) (((b8 & 31) << 6) | trailingByteValue(b9));
        }

        private static char highSurrogate(int i2) {
            return (char) ((i2 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte b8) {
            return b8 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b8) {
            return b8 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b8) {
            return b8 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
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
    public static abstract class b {
        public final String decodeUtf8(ByteBuffer byteBuffer, int i2, int i8) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i8);
            }
            return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i2, i8) : decodeUtf8Default(byteBuffer, i2, i8);
        }

        public abstract String decodeUtf8(byte[] bArr, int i2, int i8) throws InvalidProtocolBufferException;

        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i2, int i8) throws InvalidProtocolBufferException {
            if ((i2 | i8 | ((byteBuffer.limit() - i2) - i8)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i8)));
            }
            int i9 = i2 + i8;
            char[] cArr = new char[i8];
            int i10 = 0;
            while (i2 < i9) {
                byte b8 = byteBuffer.get(i2);
                if (!a.isOneByte(b8)) {
                    break;
                }
                i2++;
                a.handleOneByte(b8, cArr, i10);
                i10++;
            }
            int i11 = i10;
            while (i2 < i9) {
                int i12 = i2 + 1;
                byte b9 = byteBuffer.get(i2);
                if (a.isOneByte(b9)) {
                    int i13 = i11 + 1;
                    a.handleOneByte(b9, cArr, i11);
                    while (i12 < i9) {
                        byte b10 = byteBuffer.get(i12);
                        if (!a.isOneByte(b10)) {
                            break;
                        }
                        i12++;
                        a.handleOneByte(b10, cArr, i13);
                        i13++;
                    }
                    i11 = i13;
                    i2 = i12;
                } else if (a.isTwoBytes(b9)) {
                    if (i12 >= i9) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i2 += 2;
                    a.handleTwoBytes(b9, byteBuffer.get(i12), cArr, i11);
                    i11++;
                } else if (a.isThreeBytes(b9)) {
                    if (i12 >= i9 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i14 = i2 + 2;
                    i2 += 3;
                    a.handleThreeBytes(b9, byteBuffer.get(i12), byteBuffer.get(i14), cArr, i11);
                    i11++;
                } else {
                    if (i12 >= i9 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b11 = byteBuffer.get(i12);
                    int i15 = i2 + 3;
                    byte b12 = byteBuffer.get(i2 + 2);
                    i2 += 4;
                    a.handleFourBytes(b9, b11, b12, byteBuffer.get(i15), cArr, i11);
                    i11 += 2;
                }
            }
            return new String(cArr, 0, i11);
        }

        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i2, int i8) throws InvalidProtocolBufferException;

        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i2, int i8);

        public final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                w0.position(byteBuffer, s2.encode(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        public final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int length = charSequence.length();
            int iPosition = byteBuffer.position();
            int i2 = 0;
            while (i2 < length) {
                try {
                    char cCharAt = charSequence.charAt(i2);
                    if (cCharAt >= 128) {
                        break;
                    }
                    byteBuffer.put(iPosition + i2, (byte) cCharAt);
                    i2++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (Math.max(i2, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                }
            }
            if (i2 == length) {
                w0.position(byteBuffer, iPosition + i2);
                return;
            }
            iPosition += i2;
            while (i2 < length) {
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt2 < 128) {
                    byteBuffer.put(iPosition, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i8 = iPosition + 1;
                    try {
                        byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                        byteBuffer.put(i8, (byte) ((cCharAt2 & '?') | 128));
                        iPosition = i8;
                    } catch (IndexOutOfBoundsException unused2) {
                        iPosition = i8;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (Math.max(i2, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                    }
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i9 = i2 + 1;
                        if (i9 != length) {
                            try {
                                char cCharAt3 = charSequence.charAt(i9);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i10 = iPosition + 1;
                                    try {
                                        byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                        int i11 = iPosition + 2;
                                        try {
                                            byteBuffer.put(i10, (byte) (((codePoint >>> 12) & 63) | 128));
                                            iPosition += 3;
                                            byteBuffer.put(i11, (byte) (((codePoint >>> 6) & 63) | 128));
                                            byteBuffer.put(iPosition, (byte) ((codePoint & 63) | 128));
                                            i2 = i9;
                                        } catch (IndexOutOfBoundsException unused3) {
                                            i2 = i9;
                                            iPosition = i11;
                                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (Math.max(i2, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                                        }
                                    } catch (IndexOutOfBoundsException unused4) {
                                        iPosition = i10;
                                        i2 = i9;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (Math.max(i2, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                                    }
                                } else {
                                    i2 = i9;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                        }
                        throw new d(i2, length);
                    }
                    int i12 = iPosition + 1;
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE));
                    iPosition += 2;
                    byteBuffer.put(i12, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
                }
                i2++;
                iPosition++;
            }
            w0.position(byteBuffer, iPosition);
        }

        public abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        public final boolean isValidUtf8(byte[] bArr, int i2, int i8) {
            return partialIsValidUtf8(0, bArr, i2, i8) == 0;
        }

        public final int partialIsValidUtf8(int i2, ByteBuffer byteBuffer, int i8, int i9) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? partialIsValidUtf8Direct(i2, byteBuffer, i8, i9) : partialIsValidUtf8Default(i2, byteBuffer, i8, i9);
            }
            int iArrayOffset = byteBuffer.arrayOffset();
            return partialIsValidUtf8(i2, byteBuffer.array(), i8 + iArrayOffset, iArrayOffset + i9);
        }

        public abstract int partialIsValidUtf8(int i2, byte[] bArr, int i8, int i9);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int partialIsValidUtf8Default(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L92
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L92
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = com.google.protobuf.s2.access$000(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L64
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L62
                int r7 = com.google.protobuf.s2.access$000(r0, r1)
                return r7
            L62:
                r9 = 0
                goto L6a
            L64:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L6a:
                if (r9 != 0) goto L7c
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r9 < r10) goto L79
                int r7 = com.google.protobuf.s2.access$100(r0, r1, r7)
                return r7
            L79:
                r5 = r9
                r9 = r7
                r7 = r5
            L7c:
                if (r1 > r3) goto L91
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L91
                if (r9 > r3) goto L91
                int r9 = r7 + 1
                byte r7 = r8.get(r7)
                if (r7 <= r3) goto L92
            L91:
                return r2
            L92:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s2.b.partialIsValidUtf8Default(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int partialIsValidUtf8Direct(int i2, ByteBuffer byteBuffer, int i8, int i9);

        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i2, int i8) {
            return partialIsValidUtf8(0, byteBuffer, i2, i8) == 0;
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i2, int i8) {
            int iEstimateConsecutiveAscii = s2.estimateConsecutiveAscii(byteBuffer, i2, i8) + i2;
            while (iEstimateConsecutiveAscii < i8) {
                int i9 = iEstimateConsecutiveAscii + 1;
                byte b8 = byteBuffer.get(iEstimateConsecutiveAscii);
                if (b8 >= 0) {
                    iEstimateConsecutiveAscii = i9;
                } else if (b8 < -32) {
                    if (i9 >= i8) {
                        return b8;
                    }
                    if (b8 < -62 || byteBuffer.get(i9) > -65) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 2;
                } else {
                    if (b8 >= -16) {
                        if (i9 >= i8 - 2) {
                            return s2.incompleteStateFor(byteBuffer, b8, i9, i8 - i9);
                        }
                        int i10 = iEstimateConsecutiveAscii + 2;
                        byte b9 = byteBuffer.get(i9);
                        if (b9 <= -65) {
                            if ((((b9 + 112) + (b8 << 28)) >> 30) == 0) {
                                int i11 = iEstimateConsecutiveAscii + 3;
                                if (byteBuffer.get(i10) <= -65) {
                                    iEstimateConsecutiveAscii += 4;
                                    if (byteBuffer.get(i11) > -65) {
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    if (i9 >= i8 - 1) {
                        return s2.incompleteStateFor(byteBuffer, b8, i9, i8 - i9);
                    }
                    int i12 = iEstimateConsecutiveAscii + 2;
                    byte b10 = byteBuffer.get(i9);
                    if (b10 > -65 || ((b8 == -32 && b10 < -96) || ((b8 == -19 && b10 >= -96) || byteBuffer.get(i12) > -65))) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class d extends IllegalArgumentException {
        public d(int i2, int i8) {
            super(androidx.camera.core.processing.util.a.i("Unpaired surrogate at index ", i2, " of ", i8));
        }
    }

    static {
        processor = (!e.isAvailable() || com.google.protobuf.b.isOnAndroidDevice()) ? new c() : new e();
    }

    private s2() {
    }

    public static String decodeUtf8(ByteBuffer byteBuffer, int i2, int i8) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i2, i8);
    }

    public static int encode(CharSequence charSequence, byte[] bArr, int i2, int i8) {
        return processor.encodeUtf8(charSequence, bArr, i2, i8);
    }

    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i2 < length) {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i2);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i2++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i8 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < 2048) {
                i8 += (127 - cCharAt) >>> 31;
            } else {
                i8 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i2) < 65536) {
                        throw new d(i2, length);
                    }
                    i2++;
                }
            }
            i2++;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i2, int i8) {
        int i9 = i8 - 7;
        int i10 = i2;
        while (i10 < i9 && (byteBuffer.getLong(i10) & (-9187201950435737472L)) == 0) {
            i10 += 8;
        }
        return i10 - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static int partialIsValidUtf8(int i2, byte[] bArr, int i8, int i9) {
        return processor.partialIsValidUtf8(i2, bArr, i8, i9);
    }

    public static String decodeUtf8(byte[] bArr, int i2, int i8) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i2, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i2, int i8) {
        if (i2 > -12 || i8 > -65) {
            return -1;
        }
        return i2 ^ (i8 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i2, int i8) {
        return processor.isValidUtf8(bArr, i2, i8);
    }

    public static int partialIsValidUtf8(int i2, ByteBuffer byteBuffer, int i8, int i9) {
        return processor.partialIsValidUtf8(i2, byteBuffer, i8, i9);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class e extends b {
        public static boolean isAvailable() {
            return r2.hasUnsafeArrayOperations() && r2.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j, int i2) {
            int i8 = 0;
            if (i2 < 16) {
                return 0;
            }
            int i9 = 8 - (((int) j) & 7);
            while (i8 < i9) {
                long j3 = 1 + j;
                if (r2.getByte(bArr, j) < 0) {
                    return i8;
                }
                i8++;
                j = j3;
            }
            while (true) {
                int i10 = i8 + 8;
                if (i10 > i2 || (r2.getLong((Object) bArr, r2.BYTE_ARRAY_BASE_OFFSET + j) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j += 8;
                i8 = i10;
            }
            while (i8 < i2) {
                long j8 = j + 1;
                if (r2.getByte(bArr, j) < 0) {
                    return i8;
                }
                i8++;
                j = j8;
            }
            return i2;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i2, long j, int i8) {
            if (i8 == 0) {
                return s2.incompleteStateFor(i2);
            }
            if (i8 == 1) {
                return s2.incompleteStateFor(i2, r2.getByte(bArr, j));
            }
            if (i8 == 2) {
                return s2.incompleteStateFor(i2, r2.getByte(bArr, j), r2.getByte(bArr, j + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.s2.b
        public String decodeUtf8(byte[] bArr, int i2, int i8) throws InvalidProtocolBufferException {
            Charset charset = Internal.UTF_8;
            String str = new String(bArr, i2, i8, charset);
            if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i2, i8 + i2))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            return str;
        }

        @Override // com.google.protobuf.s2.b
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i2, int i8) throws InvalidProtocolBufferException {
            int i9;
            if ((i2 | i8 | ((byteBuffer.limit() - i2) - i8)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i8)));
            }
            long jAddressOffset = r2.addressOffset(byteBuffer) + ((long) i2);
            long j = ((long) i8) + jAddressOffset;
            char[] cArr = new char[i8];
            int i10 = 0;
            while (jAddressOffset < j) {
                byte b8 = r2.getByte(jAddressOffset);
                if (!a.isOneByte(b8)) {
                    break;
                }
                jAddressOffset++;
                a.handleOneByte(b8, cArr, i10);
                i10++;
            }
            int i11 = i10;
            while (jAddressOffset < j) {
                long j3 = jAddressOffset + 1;
                byte b9 = r2.getByte(jAddressOffset);
                if (a.isOneByte(b9)) {
                    i9 = i11 + 1;
                    a.handleOneByte(b9, cArr, i11);
                    while (j3 < j) {
                        byte b10 = r2.getByte(j3);
                        if (!a.isOneByte(b10)) {
                            break;
                        }
                        j3++;
                        a.handleOneByte(b10, cArr, i9);
                        i9++;
                    }
                    jAddressOffset = j3;
                } else if (a.isTwoBytes(b9)) {
                    if (j3 >= j) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    jAddressOffset += 2;
                    a.handleTwoBytes(b9, r2.getByte(j3), cArr, i11);
                    i11++;
                } else if (a.isThreeBytes(b9)) {
                    if (j3 >= j - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j8 = 2 + jAddressOffset;
                    jAddressOffset += 3;
                    i9 = i11 + 1;
                    a.handleThreeBytes(b9, r2.getByte(j3), r2.getByte(j8), cArr, i11);
                } else {
                    if (j3 >= j - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b11 = r2.getByte(j3);
                    long j9 = jAddressOffset + 3;
                    byte b12 = r2.getByte(2 + jAddressOffset);
                    jAddressOffset += 4;
                    a.handleFourBytes(b9, b11, b12, r2.getByte(j9), cArr, i11);
                    i11 += 2;
                }
                i11 = i9;
            }
            return new String(cArr, 0, i11);
        }

        @Override // com.google.protobuf.s2.b
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i2, int i8) {
            long j;
            long j3;
            long j8;
            int i9;
            char cCharAt;
            long j9 = i2;
            long j10 = ((long) i8) + j9;
            int length = charSequence.length();
            if (length > i8 || bArr.length - i8 < i2) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i2 + i8));
            }
            int i10 = 0;
            while (true) {
                j = 1;
                if (i10 >= length || (cCharAt = charSequence.charAt(i10)) >= 128) {
                    break;
                }
                r2.putByte(bArr, j9, (byte) cCharAt);
                i10++;
                j9 = 1 + j9;
            }
            if (i10 == length) {
                return (int) j9;
            }
            while (i10 < length) {
                char cCharAt2 = charSequence.charAt(i10);
                if (cCharAt2 < 128 && j9 < j10) {
                    r2.putByte(bArr, j9, (byte) cCharAt2);
                    j8 = j10;
                    j3 = j;
                    j9 += j;
                } else if (cCharAt2 >= 2048 || j9 > j10 - 2) {
                    j3 = j;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j9 > j10 - 3) {
                        j8 = j10;
                        if (j9 > j8 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i9 = i10 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i9)))) {
                                throw new d(i10, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j9);
                        }
                        int i11 = i10 + 1;
                        if (i11 != length) {
                            char cCharAt3 = charSequence.charAt(i11);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                r2.putByte(bArr, j9, (byte) ((codePoint >>> 18) | 240));
                                r2.putByte(bArr, j9 + j3, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j11 = j9 + 3;
                                r2.putByte(bArr, j9 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j9 += 4;
                                r2.putByte(bArr, j11, (byte) ((codePoint & 63) | 128));
                                i10 = i11;
                            } else {
                                i10 = i11;
                            }
                        }
                        throw new d(i10 - 1, length);
                    }
                    r2.putByte(bArr, j9, (byte) ((cCharAt2 >>> '\f') | 480));
                    j8 = j10;
                    long j12 = j9 + 2;
                    r2.putByte(bArr, j9 + j3, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    j9 += 3;
                    r2.putByte(bArr, j12, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    j3 = j;
                    long j13 = j9 + j3;
                    r2.putByte(bArr, j9, (byte) ((cCharAt2 >>> 6) | 960));
                    j9 += 2;
                    r2.putByte(bArr, j13, (byte) ((cCharAt2 & '?') | 128));
                    j8 = j10;
                }
                i10++;
                j = j3;
                j10 = j8;
            }
            return (int) j9;
        }

        @Override // com.google.protobuf.s2.b
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j;
            char c7;
            long j3;
            long j8;
            long j9;
            int i2;
            char c8;
            char cCharAt;
            long jAddressOffset = r2.addressOffset(byteBuffer);
            long jPosition = ((long) byteBuffer.position()) + jAddressOffset;
            long jLimit = ((long) byteBuffer.limit()) + jAddressOffset;
            int length = charSequence.length();
            if (length > jLimit - jPosition) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
            int i8 = 0;
            while (true) {
                j = 1;
                c7 = 128;
                if (i8 >= length || (cCharAt = charSequence.charAt(i8)) >= 128) {
                    break;
                }
                r2.putByte(jPosition, (byte) cCharAt);
                i8++;
                jPosition = 1 + jPosition;
            }
            if (i8 == length) {
                w0.position(byteBuffer, (int) (jPosition - jAddressOffset));
                return;
            }
            while (i8 < length) {
                char cCharAt2 = charSequence.charAt(i8);
                if (cCharAt2 >= c7 || jPosition >= jLimit) {
                    j3 = j;
                    if (cCharAt2 < 2048 && jPosition <= jLimit - 2) {
                        long j10 = jPosition + j3;
                        r2.putByte(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                        jPosition += 2;
                        r2.putByte(j10, (byte) ((cCharAt2 & '?') | 128));
                        j8 = jAddressOffset;
                        j9 = jLimit;
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            j8 = jAddressOffset;
                            j9 = jLimit;
                            if (jPosition > j9 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i2 = i8 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i2)))) {
                                    throw new d(i8, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + jPosition);
                            }
                            int i9 = i8 + 1;
                            if (i9 != length) {
                                char cCharAt3 = charSequence.charAt(i9);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    r2.putByte(jPosition, (byte) ((codePoint >>> 18) | 240));
                                    c8 = 128;
                                    r2.putByte(jPosition + j3, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j11 = jPosition + 3;
                                    r2.putByte(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    jPosition += 4;
                                    r2.putByte(j11, (byte) ((codePoint & 63) | 128));
                                    i8 = i9;
                                } else {
                                    i8 = i9;
                                }
                            }
                            throw new d(i8 - 1, length);
                        }
                        r2.putByte(jPosition, (byte) ((cCharAt2 >>> '\f') | 480));
                        j8 = jAddressOffset;
                        long j12 = jPosition + 2;
                        j9 = jLimit;
                        r2.putByte(jPosition + j3, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        jPosition += 3;
                        r2.putByte(j12, (byte) ((cCharAt2 & '?') | 128));
                    }
                    c8 = 128;
                } else {
                    r2.putByte(jPosition, (byte) cCharAt2);
                    j8 = jAddressOffset;
                    j9 = jLimit;
                    c8 = c7;
                    jPosition += j;
                    j3 = j;
                }
                i8++;
                c7 = c8;
                j = j3;
                jAddressOffset = j8;
                jLimit = j9;
            }
            w0.position(byteBuffer, (int) (jPosition - jAddressOffset));
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
        
            if (com.google.protobuf.r2.getByte(r13, r2) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (com.google.protobuf.r2.getByte(r13, r2) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.s2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int partialIsValidUtf8(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instruction units count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s2.e.partialIsValidUtf8(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
        
            if (com.google.protobuf.r2.getByte(r2) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
        
            if (com.google.protobuf.r2.getByte(r2) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.s2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int partialIsValidUtf8Direct(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instruction units count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s2.e.partialIsValidUtf8Direct(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int unsafeEstimateConsecutiveAscii(long j, int i2) {
            if (i2 < 16) {
                return 0;
            }
            int i8 = (int) ((-j) & 7);
            int i9 = i8;
            while (i9 > 0) {
                long j3 = 1 + j;
                if (r2.getByte(j) < 0) {
                    return i8 - i9;
                }
                i9--;
                j = j3;
            }
            int i10 = i2 - i8;
            while (i10 >= 8 && (r2.getLong(j) & (-9187201950435737472L)) == 0) {
                j += 8;
                i10 -= 8;
            }
            return i2 - i10;
        }

        private static int unsafeIncompleteStateFor(long j, int i2, int i8) {
            if (i8 == 0) {
                return s2.incompleteStateFor(i2);
            }
            if (i8 == 1) {
                return s2.incompleteStateFor(i2, r2.getByte(j));
            }
            if (i8 == 2) {
                return s2.incompleteStateFor(i2, r2.getByte(j), r2.getByte(j + 1));
            }
            throw new AssertionError();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int partialIsValidUtf8(byte[] r10, long r11, int r13) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r11, r13)
                int r13 = r13 - r0
                long r0 = (long) r0
                long r11 = r11 + r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r13 <= 0) goto L1a
                long r4 = r11 + r2
                byte r1 = com.google.protobuf.r2.getByte(r10, r11)
                if (r1 < 0) goto L19
                int r13 = r13 + (-1)
                r11 = r4
                goto L9
            L19:
                r11 = r4
            L1a:
                if (r13 != 0) goto L1d
                return r0
            L1d:
                int r0 = r13 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r13 = r13 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r11
                byte r11 = com.google.protobuf.r2.getByte(r10, r11)
                if (r11 <= r6) goto L37
                goto L39
            L37:
                r11 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L48:
                int r13 = r13 + (-3)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.r2.getByte(r10, r11)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r11 = r11 + r8
                byte r0 = com.google.protobuf.r2.getByte(r10, r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r11, r0)
                return r10
            L6d:
                int r13 = r13 + (-4)
                long r2 = r2 + r11
                byte r0 = com.google.protobuf.r2.getByte(r10, r11)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r11
                byte r0 = com.google.protobuf.r2.getByte(r10, r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r11 = r11 + r0
                byte r0 = com.google.protobuf.r2.getByte(r10, r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s2.e.partialIsValidUtf8(byte[], long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static int partialIsValidUtf8(long r10, int r12) {
            /*
                int r0 = unsafeEstimateConsecutiveAscii(r10, r12)
                long r1 = (long) r0
                long r10 = r10 + r1
                int r12 = r12 - r0
            L7:
                r0 = 0
                r1 = r0
            L9:
                r2 = 1
                if (r12 <= 0) goto L1a
                long r4 = r10 + r2
                byte r1 = com.google.protobuf.r2.getByte(r10)
                if (r1 < 0) goto L19
                int r12 = r12 + (-1)
                r10 = r4
                goto L9
            L19:
                r10 = r4
            L1a:
                if (r12 != 0) goto L1d
                return r0
            L1d:
                int r0 = r12 + (-1)
                r4 = -32
                r5 = -1
                r6 = -65
                if (r1 >= r4) goto L3a
                if (r0 != 0) goto L29
                return r1
            L29:
                int r12 = r12 + (-2)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r10
                byte r10 = com.google.protobuf.r2.getByte(r10)
                if (r10 <= r6) goto L37
                goto L39
            L37:
                r10 = r2
                goto L7
            L39:
                return r5
            L3a:
                r7 = -16
                r8 = 2
                if (r1 >= r7) goto L65
                r7 = 2
                if (r0 >= r7) goto L48
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L48:
                int r12 = r12 + (-3)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.r2.getByte(r10)
                if (r0 > r6) goto L64
                r7 = -96
                if (r1 != r4) goto L57
                if (r0 < r7) goto L64
            L57:
                r4 = -19
                if (r1 != r4) goto L5d
                if (r0 >= r7) goto L64
            L5d:
                long r10 = r10 + r8
                byte r0 = com.google.protobuf.r2.getByte(r2)
                if (r0 <= r6) goto L7
            L64:
                return r5
            L65:
                r4 = 3
                if (r0 >= r4) goto L6d
                int r10 = unsafeIncompleteStateFor(r10, r1, r0)
                return r10
            L6d:
                int r12 = r12 + (-4)
                long r2 = r2 + r10
                byte r0 = com.google.protobuf.r2.getByte(r10)
                if (r0 > r6) goto L8f
                int r1 = r1 << 28
                int r0 = r0 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L8f
                long r8 = r8 + r10
                byte r0 = com.google.protobuf.r2.getByte(r2)
                if (r0 > r6) goto L8f
                r0 = 3
                long r10 = r10 + r0
                byte r0 = com.google.protobuf.r2.getByte(r8)
                if (r0 <= r6) goto L7
            L8f:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s2.e.partialIsValidUtf8(long, int):int");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i2, int i8, int i9) {
        if (i2 > -12 || i8 > -65 || i9 > -65) {
            return -1;
        }
        return (i2 ^ (i8 << 8)) ^ (i9 << 16);
    }

    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i2, int i8) {
        byte b8 = bArr[i2 - 1];
        int i9 = i8 - i2;
        if (i9 == 0) {
            return incompleteStateFor(b8);
        }
        if (i9 == 1) {
            return incompleteStateFor(b8, bArr[i2]);
        }
        if (i9 == 2) {
            return incompleteStateFor(b8, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i2, int i8, int i9) {
        if (i9 == 0) {
            return incompleteStateFor(i2);
        }
        if (i9 == 1) {
            return incompleteStateFor(i2, byteBuffer.get(i8));
        }
        if (i9 == 2) {
            return incompleteStateFor(i2, byteBuffer.get(i8), byteBuffer.get(i8 + 1));
        }
        throw new AssertionError();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c extends b {
        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i2, int i8) {
            while (i2 < i8) {
                int i9 = i2 + 1;
                byte b8 = bArr[i2];
                if (b8 < 0) {
                    if (b8 < -32) {
                        if (i9 >= i8) {
                            return b8;
                        }
                        if (b8 >= -62) {
                            i2 += 2;
                            if (bArr[i9] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b8 < -16) {
                        if (i9 >= i8 - 1) {
                            return s2.incompleteStateFor(bArr, i9, i8);
                        }
                        int i10 = i2 + 2;
                        byte b9 = bArr[i9];
                        if (b9 <= -65 && ((b8 != -32 || b9 >= -96) && (b8 != -19 || b9 < -96))) {
                            i2 += 3;
                            if (bArr[i10] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i9 >= i8 - 2) {
                        return s2.incompleteStateFor(bArr, i9, i8);
                    }
                    int i11 = i2 + 2;
                    byte b10 = bArr[i9];
                    if (b10 <= -65) {
                        if ((((b10 + 112) + (b8 << 28)) >> 30) == 0) {
                            int i12 = i2 + 3;
                            if (bArr[i11] <= -65) {
                                i2 += 4;
                                if (bArr[i12] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i2 = i9;
            }
            return 0;
        }

        @Override // com.google.protobuf.s2.b
        public String decodeUtf8(byte[] bArr, int i2, int i8) throws InvalidProtocolBufferException {
            if ((i2 | i8 | ((bArr.length - i2) - i8)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i8)));
            }
            int i9 = i2 + i8;
            char[] cArr = new char[i8];
            int i10 = 0;
            while (i2 < i9) {
                byte b8 = bArr[i2];
                if (!a.isOneByte(b8)) {
                    break;
                }
                i2++;
                a.handleOneByte(b8, cArr, i10);
                i10++;
            }
            int i11 = i10;
            while (i2 < i9) {
                int i12 = i2 + 1;
                byte b9 = bArr[i2];
                if (a.isOneByte(b9)) {
                    int i13 = i11 + 1;
                    a.handleOneByte(b9, cArr, i11);
                    while (i12 < i9) {
                        byte b10 = bArr[i12];
                        if (!a.isOneByte(b10)) {
                            break;
                        }
                        i12++;
                        a.handleOneByte(b10, cArr, i13);
                        i13++;
                    }
                    i11 = i13;
                    i2 = i12;
                } else if (a.isTwoBytes(b9)) {
                    if (i12 >= i9) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i2 += 2;
                    a.handleTwoBytes(b9, bArr[i12], cArr, i11);
                    i11++;
                } else if (a.isThreeBytes(b9)) {
                    if (i12 >= i9 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i14 = i2 + 2;
                    i2 += 3;
                    a.handleThreeBytes(b9, bArr[i12], bArr[i14], cArr, i11);
                    i11++;
                } else {
                    if (i12 >= i9 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b11 = bArr[i12];
                    int i15 = i2 + 3;
                    byte b12 = bArr[i2 + 2];
                    i2 += 4;
                    a.handleFourBytes(b9, b11, b12, bArr[i15], cArr, i11);
                    i11 += 2;
                }
            }
            return new String(cArr, 0, i11);
        }

        @Override // com.google.protobuf.s2.b
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i2, int i8) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i2, i8);
        }

        @Override // com.google.protobuf.s2.b
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i2, int i8) {
            int i9;
            int i10;
            char cCharAt;
            int length = charSequence.length();
            int i11 = i8 + i2;
            int i12 = 0;
            while (i12 < length && (i10 = i12 + i2) < i11 && (cCharAt = charSequence.charAt(i12)) < 128) {
                bArr[i10] = (byte) cCharAt;
                i12++;
            }
            if (i12 == length) {
                return i2 + length;
            }
            int i13 = i2 + i12;
            while (i12 < length) {
                char cCharAt2 = charSequence.charAt(i12);
                if (cCharAt2 < 128 && i13 < i11) {
                    bArr[i13] = (byte) cCharAt2;
                    i13++;
                } else if (cCharAt2 < 2048 && i13 <= i11 - 2) {
                    int i14 = i13 + 1;
                    bArr[i13] = (byte) ((cCharAt2 >>> 6) | 960);
                    i13 += 2;
                    bArr[i14] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i13 > i11 - 3) {
                        if (i13 > i11 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i9 = i12 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i9)))) {
                                throw new d(i12, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i13);
                        }
                        int i15 = i12 + 1;
                        if (i15 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i15);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i13] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i13 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i16 = i13 + 3;
                                bArr[i13 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i13 += 4;
                                bArr[i16] = (byte) ((codePoint & 63) | 128);
                                i12 = i15;
                            } else {
                                i12 = i15;
                            }
                        }
                        throw new d(i12 - 1, length);
                    }
                    bArr[i13] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i17 = i13 + 2;
                    bArr[i13 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i13 += 3;
                    bArr[i17] = (byte) ((cCharAt2 & '?') | 128);
                }
                i12++;
            }
            return i13;
        }

        @Override // com.google.protobuf.s2.b
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // com.google.protobuf.s2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int partialIsValidUtf8(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L86
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L86
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = com.google.protobuf.s2.access$000(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                if (r1 != 0) goto L5c
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5a
                int r7 = com.google.protobuf.s2.access$000(r0, r1)
                return r7
            L5a:
                r9 = 0
                goto L62
            L5c:
                int r7 = r7 >> 16
                byte r7 = (byte) r7
                r5 = r9
                r9 = r7
                r7 = r5
            L62:
                if (r9 != 0) goto L72
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r9 < r10) goto L6f
                int r7 = com.google.protobuf.s2.access$100(r0, r1, r7)
                return r7
            L6f:
                r5 = r9
                r9 = r7
                r7 = r5
            L72:
                if (r1 > r3) goto L85
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r1 = r1 + r0
                int r0 = r1 >> 30
                if (r0 != 0) goto L85
                if (r9 > r3) goto L85
                int r9 = r7 + 1
                r7 = r8[r7]
                if (r7 <= r3) goto L86
            L85:
                return r2
            L86:
                int r7 = partialIsValidUtf8(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.s2.c.partialIsValidUtf8(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.s2.b
        public int partialIsValidUtf8Direct(int i2, ByteBuffer byteBuffer, int i8, int i9) {
            return partialIsValidUtf8Default(i2, byteBuffer, i8, i9);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i2, int i8) {
            while (i2 < i8 && bArr[i2] >= 0) {
                i2++;
            }
            if (i2 >= i8) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i2, i8);
        }
    }
}
