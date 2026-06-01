package com.bytedance.sdk.component.MY.IlO.MY;

import a1.a;
import com.vungle.ads.internal.protos.Sdk;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class IlO implements EO, MY, Cloneable, ByteChannel {
    private static final byte[] EO = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    Cc IlO;
    long MY;

    public final tV Cc() {
        long j = this.MY;
        if (j <= 2147483647L) {
            return tV((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.MY);
    }

    public String EO() {
        try {
            return IlO(this.MY, DmF.IlO);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public boolean IlO() {
        return this.MY == 0;
    }

    public byte MY() {
        long j = this.MY;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        Cc cc = this.IlO;
        int i2 = cc.MY;
        int i8 = cc.EO;
        int i9 = i2 + 1;
        byte b8 = cc.IlO[i2];
        this.MY = j - 1;
        if (i9 != i8) {
            cc.MY = i9;
            return b8;
        }
        this.IlO = cc.MY();
        vCE.IlO(cc);
        return b8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IlO)) {
            return false;
        }
        IlO ilO = (IlO) obj;
        long j = this.MY;
        if (j != ilO.MY) {
            return false;
        }
        long j3 = 0;
        if (j == 0) {
            return true;
        }
        Cc cc = this.IlO;
        Cc cc2 = ilO.IlO;
        int i2 = cc.MY;
        int i8 = cc2.MY;
        while (j3 < this.MY) {
            long jMin = Math.min(cc.EO - i2, cc2.EO - i8);
            int i9 = 0;
            while (i9 < jMin) {
                int i10 = i2 + 1;
                int i11 = i8 + 1;
                if (cc.IlO[i2] != cc2.IlO[i8]) {
                    return false;
                }
                i9++;
                i2 = i10;
                i8 = i11;
            }
            if (i2 == cc.EO) {
                cc = cc.vCE;
                i2 = cc.MY;
            }
            if (i8 == cc2.EO) {
                cc2 = cc2.vCE;
                i8 = cc2.MY;
            }
            j3 += jMin;
        }
        return true;
    }

    public int hashCode() {
        Cc cc = this.IlO;
        if (cc == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i8 = cc.EO;
            for (int i9 = cc.MY; i9 < i8; i9++) {
                i2 = (i2 * 31) + cc.IlO[i9];
            }
            cc = cc.vCE;
        } while (cc != this.IlO);
        return i2;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Cc cc = this.IlO;
        if (cc == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), cc.EO - cc.MY);
        byteBuffer.put(cc.IlO, cc.MY, iMin);
        int i2 = cc.MY + iMin;
        cc.MY = i2;
        this.MY -= (long) iMin;
        if (i2 == cc.EO) {
            this.IlO = cc.MY();
            vCE.IlO(cc);
        }
        return iMin;
    }

    /* JADX INFO: renamed from: tV, reason: merged with bridge method [inline-methods] */
    public IlO clone() {
        IlO ilO = new IlO();
        if (this.MY == 0) {
            return ilO;
        }
        Cc ccIlO = this.IlO.IlO();
        ilO.IlO = ccIlO;
        ccIlO.Bc = ccIlO;
        ccIlO.vCE = ccIlO;
        Cc cc = this.IlO;
        while (true) {
            cc = cc.vCE;
            if (cc == this.IlO) {
                ilO.MY = this.MY;
                return ilO;
            }
            ilO.IlO.Bc.IlO(cc.IlO());
        }
    }

    public String toString() {
        return Cc().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            Cc ccEO = EO(1);
            int iMin = Math.min(i2, 8192 - ccEO.EO);
            byteBuffer.get(ccEO.IlO, ccEO.EO, iMin);
            i2 -= iMin;
            ccEO.EO += iMin;
        }
        this.MY += (long) iRemaining;
        return iRemaining;
    }

    public String IlO(long j, Charset charset) throws EOFException {
        DmF.IlO(this.MY, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        Cc cc = this.IlO;
        int i2 = cc.MY;
        if (((long) i2) + j > cc.EO) {
            return new String(IlO(j), charset);
        }
        String str = new String(cc.IlO, i2, (int) j, charset);
        int i8 = (int) (((long) cc.MY) + j);
        cc.MY = i8;
        this.MY -= j;
        if (i8 == cc.EO) {
            this.IlO = cc.MY();
            vCE.IlO(cc);
        }
        return str;
    }

    public Cc EO(int i2) {
        if (i2 > 0 && i2 <= 8192) {
            Cc cc = this.IlO;
            if (cc == null) {
                Cc ccIlO = vCE.IlO();
                this.IlO = ccIlO;
                ccIlO.Bc = ccIlO;
                ccIlO.vCE = ccIlO;
                return ccIlO;
            }
            Cc cc2 = cc.Bc;
            return (cc2.EO + i2 > 8192 || !cc2.Cc) ? cc2.IlO(vCE.IlO()) : cc2;
        }
        throw new IllegalArgumentException();
    }

    public final tV tV(int i2) {
        if (i2 == 0) {
            return tV.EO;
        }
        return new Bc(this, i2);
    }

    public IlO MY(byte[] bArr, int i2, int i8) {
        if (bArr != null) {
            long j = i8;
            DmF.IlO(bArr.length, i2, j);
            int i9 = i8 + i2;
            while (i2 < i9) {
                Cc ccEO = EO(1);
                int iMin = Math.min(i9 - i2, 8192 - ccEO.EO);
                System.arraycopy(bArr, i2, ccEO.IlO, ccEO.EO, iMin);
                i2 += iMin;
                ccEO.EO += iMin;
            }
            this.MY += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] IlO(long j) throws EOFException {
        DmF.IlO(this.MY, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            IlO(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public void IlO(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int iIlO = IlO(bArr, i2, bArr.length - i2);
            if (iIlO == -1) {
                throw new EOFException();
            }
            i2 += iIlO;
        }
    }

    public IlO MY(int i2) {
        Cc ccEO = EO(1);
        byte[] bArr = ccEO.IlO;
        int i8 = ccEO.EO;
        ccEO.EO = i8 + 1;
        bArr[i8] = (byte) i2;
        this.MY++;
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int IlO(byte[] bArr, int i2, int i8) {
        DmF.IlO(bArr.length, i2, i8);
        Cc cc = this.IlO;
        if (cc == null) {
            return -1;
        }
        int iMin = Math.min(i8, cc.EO - cc.MY);
        System.arraycopy(cc.IlO, cc.MY, bArr, i2, iMin);
        int i9 = cc.MY + iMin;
        cc.MY = i9;
        this.MY -= (long) iMin;
        if (i9 == cc.EO) {
            this.IlO = cc.MY();
            vCE.IlO(cc);
        }
        return iMin;
    }

    public IlO MY(long j) {
        if (j == 0) {
            return MY(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Cc ccEO = EO(iNumberOfTrailingZeros);
        byte[] bArr = ccEO.IlO;
        int i2 = ccEO.EO;
        for (int i8 = (i2 + iNumberOfTrailingZeros) - 1; i8 >= i2; i8--) {
            bArr[i8] = EO[(int) (15 & j)];
            j >>>= 4;
        }
        ccEO.EO += iNumberOfTrailingZeros;
        this.MY += (long) iNumberOfTrailingZeros;
        return this;
    }

    public IlO IlO(String str) {
        return IlO(str, 0, str.length());
    }

    public IlO IlO(String str, int i2, int i8) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i2)));
        }
        if (i8 >= i2) {
            if (i8 > str.length()) {
                StringBuilder sbV = a.v(i8, "endIndex > string.length: ", " > ");
                sbV.append(str.length());
                throw new IllegalArgumentException(sbV.toString());
            }
            while (i2 < i8) {
                char cCharAt2 = str.charAt(i2);
                if (cCharAt2 < 128) {
                    Cc ccEO = EO(1);
                    byte[] bArr = ccEO.IlO;
                    int i9 = ccEO.EO - i2;
                    int iMin = Math.min(i8, 8192 - i9);
                    int i10 = i2 + 1;
                    bArr[i2 + i9] = (byte) cCharAt2;
                    while (true) {
                        i2 = i10;
                        if (i2 >= iMin || (cCharAt = str.charAt(i2)) >= 128) {
                            break;
                        }
                        i10 = i2 + 1;
                        bArr[i2 + i9] = (byte) cCharAt;
                    }
                    int i11 = ccEO.EO;
                    int i12 = (i9 + i2) - i11;
                    ccEO.EO = i11 + i12;
                    this.MY += (long) i12;
                } else {
                    if (cCharAt2 < 2048) {
                        MY((cCharAt2 >> 6) | 192);
                        MY((cCharAt2 & '?') | 128);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i13 = i2 + 1;
                        char cCharAt3 = i13 < i8 ? str.charAt(i13) : (char) 0;
                        if (cCharAt2 <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i14 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            MY((i14 >> 18) | 240);
                            MY(((i14 >> 12) & 63) | 128);
                            MY(((i14 >> 6) & 63) | 128);
                            MY((i14 & 63) | 128);
                            i2 += 2;
                        } else {
                            MY(63);
                            i2 = i13;
                        }
                    } else {
                        MY((cCharAt2 >> '\f') | Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE);
                        MY(((cCharAt2 >> 6) & 63) | 128);
                        MY((cCharAt2 & '?') | 128);
                    }
                    i2++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("endIndex < beginIndex: ", i8, " < ", i2));
    }

    public IlO IlO(int i2) {
        if (i2 < 128) {
            MY(i2);
            return this;
        }
        if (i2 < 2048) {
            MY((i2 >> 6) | 192);
            MY((i2 & 63) | 128);
            return this;
        }
        if (i2 >= 65536) {
            if (i2 <= 1114111) {
                MY((i2 >> 18) | 240);
                MY(((i2 >> 12) & 63) | 128);
                MY(((i2 >> 6) & 63) | 128);
                MY((i2 & 63) | 128);
                return this;
            }
            throw new IllegalArgumentException(a.i(i2, new StringBuilder("Unexpected code point: ")));
        }
        if (i2 >= 55296 && i2 <= 57343) {
            MY(63);
            return this;
        }
        MY((i2 >> 12) | Sdk.SDKError.Reason.AD_LOAD_FAIL_EMPTY_BID_PAYLOAD_VALUE);
        MY(((i2 >> 6) & 63) | 128);
        MY((i2 & 63) | 128);
        return this;
    }

    public IlO IlO(String str, int i2, int i8, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i2)));
        }
        if (i8 >= i2) {
            if (i8 > str.length()) {
                StringBuilder sbV = a.v(i8, "endIndex > string.length: ", " > ");
                sbV.append(str.length());
                throw new IllegalArgumentException(sbV.toString());
            }
            if (charset != null) {
                if (charset.equals(DmF.IlO)) {
                    return IlO(str, i2, i8);
                }
                byte[] bytes = str.substring(i2, i8).getBytes(charset);
                return MY(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("endIndex < beginIndex: ", i8, " < ", i2));
    }
}
