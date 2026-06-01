package com.bytedance.sdk.component.MY.IlO.MY;

import a1.a;
import com.bumptech.glide.load.Key;
import com.ironsource.C2300e4;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV implements Serializable, Comparable<tV> {
    transient int Cc;
    final byte[] tV;
    transient String vCE;
    static final char[] IlO = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset MY = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final tV EO = IlO(new byte[0]);

    public tV(byte[] bArr) {
        this.tV = bArr;
    }

    public static tV IlO(byte... bArr) {
        if (bArr != null) {
            return new tV((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public int EO() {
        return this.tV.length;
    }

    public String MY() {
        byte[] bArr = this.tV;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b8 : bArr) {
            int i8 = i2 + 1;
            char[] cArr2 = IlO;
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
        if (obj instanceof tV) {
            tV tVVar = (tV) obj;
            int iEO = tVVar.EO();
            byte[] bArr = this.tV;
            if (iEO == bArr.length && tVVar.IlO(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.Cc;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.tV);
        this.Cc = iHashCode;
        return iHashCode;
    }

    public byte[] tV() {
        return (byte[]) this.tV.clone();
    }

    public String toString() {
        if (this.tV.length == 0) {
            return "[size=0]";
        }
        String strIlO = IlO();
        int iIlO = IlO(strIlO, 64);
        if (iIlO != -1) {
            String strReplace = strIlO.substring(0, iIlO).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (iIlO >= strIlO.length()) {
                return a.m("[text=", strReplace, C2300e4.i.e);
            }
            return "[size=" + this.tV.length + " text=" + strReplace + "…]";
        }
        if (this.tV.length <= 64) {
            return "[hex=" + MY() + C2300e4.i.e;
        }
        return "[size=" + this.tV.length + " hex=" + IlO(0, 64).MY() + "…]";
    }

    public String IlO() {
        String str = this.vCE;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.tV, MY);
        this.vCE = str2;
        return str2;
    }

    public tV IlO(int i2, int i8) {
        if (i2 >= 0) {
            byte[] bArr = this.tV;
            if (i8 > bArr.length) {
                throw new IllegalArgumentException(a.q(new StringBuilder("endIndex > length("), ")", this.tV.length));
            }
            int i9 = i8 - i2;
            if (i9 >= 0) {
                if (i2 == 0 && i8 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i9];
                System.arraycopy(bArr, i2, bArr2, 0, i9);
                return new tV(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte IlO(int i2) {
        return this.tV[i2];
    }

    public boolean IlO(int i2, tV tVVar, int i8, int i9) {
        return tVVar.IlO(i8, this.tV, i2, i9);
    }

    public boolean IlO(int i2, byte[] bArr, int i8, int i9) {
        if (i2 < 0) {
            return false;
        }
        byte[] bArr2 = this.tV;
        return i2 <= bArr2.length - i9 && i8 >= 0 && i8 <= bArr.length - i9 && DmF.IlO(bArr2, i2, bArr, i8, i9);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public int compareTo(tV tVVar) {
        int iEO = EO();
        int iEO2 = tVVar.EO();
        int iMin = Math.min(iEO, iEO2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int iIlO = IlO(i2) & 255;
            int iIlO2 = tVVar.IlO(i2) & 255;
            if (iIlO != iIlO2) {
                return iIlO < iIlO2 ? -1 : 1;
            }
        }
        if (iEO == iEO2) {
            return 0;
        }
        return iEO < iEO2 ? -1 : 1;
    }

    public static int IlO(String str, int i2) {
        int length = str.length();
        int iCharCount = 0;
        int i8 = 0;
        while (iCharCount < length) {
            if (i8 == i2) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i8++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
