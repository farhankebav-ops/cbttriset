package l7;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class m implements Serializable, Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f12880d = new m(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f12881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f12882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f12883c;

    public m(byte[] data) {
        kotlin.jvm.internal.k.e(data, "data");
        this.f12881a = data;
    }

    public static int g(m mVar, m other) {
        mVar.getClass();
        kotlin.jvm.internal.k.e(other, "other");
        return mVar.f(other.h(), 0);
    }

    public static int k(m mVar, m other) {
        mVar.getClass();
        kotlin.jvm.internal.k.e(other, "other");
        return mVar.j(other.h());
    }

    public static /* synthetic */ m q(m mVar, int i2, int i8, int i9) {
        if ((i9 & 1) != 0) {
            i2 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = -1234567890;
        }
        return mVar.p(i2, i8);
    }

    public String a() {
        byte[] map = a.f12834a;
        byte[] bArr = this.f12881a;
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i8 = 0;
        while (i2 < length) {
            byte b8 = bArr[i2];
            int i9 = i2 + 2;
            byte b9 = bArr[i2 + 1];
            i2 += 3;
            byte b10 = bArr[i9];
            bArr2[i8] = map[(b8 & 255) >> 2];
            bArr2[i8 + 1] = map[((b8 & 3) << 4) | ((b9 & 255) >> 4)];
            int i10 = i8 + 3;
            bArr2[i8 + 2] = map[((b9 & 15) << 2) | ((b10 & 255) >> 6)];
            i8 += 4;
            bArr2[i10] = map[b10 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b11 = bArr[i2];
            bArr2[i8] = map[(b11 & 255) >> 2];
            bArr2[i8 + 1] = map[(b11 & 3) << 4];
            bArr2[i8 + 2] = 61;
            bArr2[i8 + 3] = 61;
        } else if (length2 == 2) {
            int i11 = i2 + 1;
            byte b12 = bArr[i2];
            byte b13 = bArr[i11];
            bArr2[i8] = map[(b12 & 255) >> 2];
            bArr2[i8 + 1] = map[((b12 & 3) << 4) | ((b13 & 255) >> 4)];
            bArr2[i8 + 2] = map[(b13 & 15) << 2];
            bArr2[i8 + 3] = 61;
        }
        return new String(bArr2, n6.a.f13073a);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(m other) {
        kotlin.jvm.internal.k.e(other, "other");
        int iD = d();
        int iD2 = other.d();
        int iMin = Math.min(iD, iD2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i8 = i(i2) & 255;
            int i9 = other.i(i2) & 255;
            if (i8 != i9) {
                return i8 < i9 ? -1 : 1;
            }
        }
        if (iD == iD2) {
            return 0;
        }
        return iD < iD2 ? -1 : 1;
    }

    public m c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f12881a, 0, d());
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.k.b(bArrDigest);
        return new m(bArrDigest);
    }

    public int d() {
        return this.f12881a.length;
    }

    public String e() {
        byte[] bArr = this.f12881a;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b8 : bArr) {
            int i8 = i2 + 1;
            char[] cArr2 = m7.b.f12998a;
            cArr[i2] = cArr2[(b8 >> 4) & 15];
            i2 += 2;
            cArr[i8] = cArr2[b8 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            int iD = mVar.d();
            byte[] bArr = this.f12881a;
            if (iD == bArr.length && mVar.m(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int f(byte[] other, int i2) {
        kotlin.jvm.internal.k.e(other, "other");
        byte[] bArr = this.f12881a;
        int length = bArr.length - other.length;
        int iMax = Math.max(i2, 0);
        if (iMax > length) {
            return -1;
        }
        while (!b.a(iMax, 0, other.length, bArr, other)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public byte[] h() {
        return this.f12881a;
    }

    public int hashCode() {
        int i2 = this.f12882b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f12881a);
        this.f12882b = iHashCode;
        return iHashCode;
    }

    public byte i(int i2) {
        return this.f12881a[i2];
    }

    public int j(byte[] other) {
        kotlin.jvm.internal.k.e(other, "other");
        int iD = d();
        byte[] bArr = this.f12881a;
        for (int iMin = Math.min(iD, bArr.length - other.length); -1 < iMin; iMin--) {
            if (b.a(iMin, 0, other.length, bArr, other)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean l(int i2, m other, int i8) {
        kotlin.jvm.internal.k.e(other, "other");
        return other.m(0, this.f12881a, i2, i8);
    }

    public boolean m(int i2, byte[] other, int i8, int i9) {
        kotlin.jvm.internal.k.e(other, "other");
        if (i2 < 0) {
            return false;
        }
        byte[] bArr = this.f12881a;
        return i2 <= bArr.length - i9 && i8 >= 0 && i8 <= other.length - i9 && b.a(i2, i8, i9, bArr, other);
    }

    public final boolean n(m prefix) {
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return l(0, prefix, prefix.d());
    }

    public String o(Charset charset) {
        kotlin.jvm.internal.k.e(charset, "charset");
        return new String(this.f12881a, charset);
    }

    public m p(int i2, int i8) {
        if (i8 == -1234567890) {
            i8 = d();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f12881a;
        if (i8 > bArr.length) {
            throw new IllegalArgumentException(com.ironsource.adqualitysdk.sdk.i.a0.c(new StringBuilder("endIndex > length("), bArr.length, ')').toString());
        }
        if (i8 - i2 >= 0) {
            return (i2 == 0 && i8 == bArr.length) ? this : new m(r5.j.i0(bArr, i2, i8));
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
    }

    public m r() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f12881a;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b8 = bArr[i2];
            if (b8 >= 65 && b8 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                kotlin.jvm.internal.k.d(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i2] = (byte) (b8 + 32);
                for (int i8 = i2 + 1; i8 < bArrCopyOf.length; i8++) {
                    byte b9 = bArrCopyOf[i8];
                    if (b9 >= 65 && b9 <= 90) {
                        bArrCopyOf[i8] = (byte) (b9 + 32);
                    }
                }
                return new m(bArrCopyOf);
            }
            i2++;
        }
    }

    public byte[] s() {
        byte[] bArr = this.f12881a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.k.d(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public final String t() {
        String str = this.f12883c;
        if (str != null) {
            return str;
        }
        byte[] bArrH = h();
        kotlin.jvm.internal.k.e(bArrH, "<this>");
        String str2 = new String(bArrH, n6.a.f13073a);
        this.f12883c = str2;
        return str2;
    }

    public String toString() {
        byte b8;
        int i2;
        byte[] bArr = this.f12881a;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        loop0: while (true) {
            if (i8 >= length) {
                break;
            }
            byte b9 = bArr[i8];
            if (b9 >= 0) {
                int i11 = i10 + 1;
                if (i10 == 64) {
                    break;
                }
                if ((b9 != 10 && b9 != 13 && ((b9 >= 0 && b9 < 32) || (127 <= b9 && b9 < 160))) || b9 == 65533) {
                    break;
                }
                i9 += b9 < 65536 ? 1 : 2;
                i8++;
                while (true) {
                    i10 = i11;
                    if (i8 < length && (b8 = bArr[i8]) >= 0) {
                        i8++;
                        i11 = i10 + 1;
                        if (i10 == 64) {
                            break loop0;
                        }
                        if ((b8 != 10 && b8 != 13 && ((b8 >= 0 && b8 < 32) || (127 <= b8 && b8 < 160))) || b8 == 65533) {
                            break loop0;
                        }
                        i9 += b8 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b9 >> 5) == -2) {
                int i12 = i8 + 1;
                if (length > i12) {
                    byte b10 = bArr[i12];
                    if ((b10 & 192) == 128) {
                        int i13 = (b10 ^ 3968) ^ (b9 << 6);
                        if (i13 >= 128) {
                            i2 = i10 + 1;
                            if (i10 == 64) {
                                break;
                            }
                            if ((i13 != 10 && i13 != 13 && ((i13 >= 0 && i13 < 32) || (127 <= i13 && i13 < 160))) || i13 == 65533) {
                                break;
                            }
                            i9 += i13 < 65536 ? 1 : 2;
                            i8 += 2;
                            i10 = i2;
                        } else if (i10 != 64) {
                            break;
                        }
                    } else if (i10 != 64) {
                        break;
                    }
                } else if (i10 != 64) {
                    break;
                }
            } else if ((b9 >> 4) == -2) {
                int i14 = i8 + 2;
                if (length > i14) {
                    byte b11 = bArr[i8 + 1];
                    if ((b11 & 192) == 128) {
                        byte b12 = bArr[i14];
                        if ((b12 & 192) == 128) {
                            int i15 = ((b12 ^ (-123008)) ^ (b11 << 6)) ^ (b9 << 12);
                            if (i15 < 2048) {
                                if (i10 != 64) {
                                    break;
                                }
                            } else if (55296 > i15 || i15 >= 57344) {
                                i2 = i10 + 1;
                                if (i10 == 64) {
                                    break;
                                }
                                if ((i15 != 10 && i15 != 13 && ((i15 >= 0 && i15 < 32) || (127 <= i15 && i15 < 160))) || i15 == 65533) {
                                    break;
                                }
                                i9 += i15 < 65536 ? 1 : 2;
                                i8 += 3;
                                i10 = i2;
                            } else if (i10 != 64) {
                                break;
                            }
                        } else if (i10 != 64) {
                            break;
                        }
                    } else if (i10 != 64) {
                        break;
                    }
                } else if (i10 != 64) {
                    break;
                }
            } else if ((b9 >> 3) == -2) {
                int i16 = i8 + 3;
                if (length > i16) {
                    byte b13 = bArr[i8 + 1];
                    if ((b13 & 192) == 128) {
                        byte b14 = bArr[i8 + 2];
                        if ((b14 & 192) == 128) {
                            byte b15 = bArr[i16];
                            if ((b15 & 192) == 128) {
                                int i17 = (((b15 ^ 3678080) ^ (b14 << 6)) ^ (b13 << 12)) ^ (b9 << 18);
                                if (i17 > 1114111) {
                                    if (i10 != 64) {
                                        break;
                                    }
                                } else if (55296 > i17 || i17 >= 57344) {
                                    if (i17 >= 65536) {
                                        i2 = i10 + 1;
                                        if (i10 == 64) {
                                            break;
                                        }
                                        if ((i17 != 10 && i17 != 13 && ((i17 >= 0 && i17 < 32) || (127 <= i17 && i17 < 160))) || i17 == 65533) {
                                            break;
                                        }
                                        i9 += i17 < 65536 ? 1 : 2;
                                        i8 += 4;
                                        i10 = i2;
                                    } else if (i10 != 64) {
                                        break;
                                    }
                                } else if (i10 != 64) {
                                    break;
                                }
                            } else if (i10 != 64) {
                                break;
                            }
                        } else if (i10 != 64) {
                            break;
                        }
                    } else if (i10 != 64) {
                        break;
                    }
                } else if (i10 != 64) {
                    break;
                }
            } else if (i10 != 64) {
                break;
            }
        }
        i9 = -1;
        if (i9 != -1) {
            String strT = t();
            String strSubstring = strT.substring(0, i9);
            kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
            String strL0 = n6.t.l0(n6.t.l0(n6.t.l0(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i9 >= strT.length()) {
                return androidx.camera.core.processing.util.a.f(']', "[text=", strL0);
            }
            return "[size=" + bArr.length + " text=" + strL0 + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + e() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 > bArr.length) {
            throw new IllegalArgumentException(com.ironsource.adqualitysdk.sdk.i.a0.c(new StringBuilder("endIndex > length("), bArr.length, ')').toString());
        }
        sb.append((64 == bArr.length ? this : new m(r5.j.i0(bArr, 0, 64))).e());
        sb.append("…]");
        return sb.toString();
    }

    public void u(int i2, j jVar) {
        jVar.m3451write(this.f12881a, 0, i2);
    }
}
