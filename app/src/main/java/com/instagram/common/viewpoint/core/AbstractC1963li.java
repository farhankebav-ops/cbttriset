package com.instagram.common.viewpoint.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.li, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1963li extends EK {
    public static String[] A01 = {"LN1kZ6lR3vZBqqrviA4uTSOzBGS9o2bO", "mUQPITaRnEXTrG2Wr7xIAnPzPHhU6DS3", "avW0I4bwWNzzQZleeOInYpLZY9PTle7", "LGUT8ZIo3joumZn9NybI7JCchk0DSCTG", "S4WFRdtC0lcE2afHWARgiwpUU5tNPmtd", "SbOYlLigHNVPkFHrMvYK7wwtNeL", "2fmBOvz22OTh8nUuYBKjoVDFU", "lR30iWlIbuozJgbVtB9O9DOed4NJenPq"};
    public EC A00;

    public abstract Pair<C7G[], InterfaceC1964lj[]> A0d(EC ec, int[][][] iArr, int[] iArr2, C2001mL c2001mL, Timeline timeline) throws C9Y;

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A0Y(com.instagram.common.viewpoint.core.C7D[] r8, com.instagram.common.viewpoint.core.C2120oH r9, int[] r10, boolean r11) throws com.instagram.common.viewpoint.core.C9Y {
        /*
            int r6 = r8.length
            r5 = 0
            r7 = 1
            r4 = 0
        L4:
            int r0 = r8.length
            if (r4 >= r0) goto L39
            r3 = r8[r4]
            r2 = 0
            r1 = 0
        Lb:
            int r0 = r9.A01
            if (r1 >= r0) goto L22
            com.facebook.ads.redexgen.X.or r0 = r9.A08(r1)
            int r0 = r3.AJb(r0)
            int r0 = com.instagram.common.viewpoint.core.AnonymousClass76.A03(r0)
            int r2 = java.lang.Math.max(r2, r0)
            int r1 = r1 + 1
            goto Lb
        L22:
            r0 = r10[r4]
            if (r0 != 0) goto L37
            r0 = 1
        L27:
            if (r2 > r5) goto L31
            if (r2 != r5) goto L34
            if (r11 == 0) goto L34
            if (r7 != 0) goto L34
            if (r0 == 0) goto L34
        L31:
            r6 = r4
            r5 = r2
            r7 = r0
        L34:
            int r4 = r4 + 1
            goto L4
        L37:
            r0 = 0
            goto L27
        L39:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.AbstractC1963li.A0Y(com.facebook.ads.redexgen.X.7D[], com.facebook.ads.redexgen.X.oH, int[], boolean):int");
    }

    public static int[] A0Z(C7D c7d, C2120oH c2120oH) throws C9Y {
        int[] iArr = new int[c2120oH.A01];
        for (int i2 = 0; i2 < c2120oH.A01; i2++) {
            iArr[i2] = c7d.AJb(c2120oH.A08(i2));
        }
        return iArr;
    }

    public static int[] A0a(C7D[] c7dArr) throws C9Y {
        int[] iArr = new int[c7dArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int iAJd = c7dArr[i2].AJd();
            String[] strArr = A01;
            String str = strArr[4];
            String str2 = strArr[1];
            int i8 = str.charAt(23);
            if (i8 == str2.charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "1ViYEGUZxGRCVXLKV1NACncyCaxKGcLE";
            strArr2[1] = "WZkUCc71MckdncxFpAml539B1oxWjr0A";
            iArr[i2] = iAJd;
        }
        return iArr;
    }

    @Override // com.instagram.common.viewpoint.core.EK
    public final EL A0b(C7D[] c7dArr, C1991mA c1991mA, C2001mL c2001mL, Timeline timeline) throws C9Y {
        int[] rendererTrackGroupCounts;
        int[] iArr = new int[c7dArr.length + 1];
        C2120oH[][] c2120oHArr = new C2120oH[c7dArr.length + 1][];
        int[][][] iArr2 = new int[c7dArr.length + 1][][];
        for (int i2 = 0; i2 < c2120oHArr.length; i2++) {
            c2120oHArr[i2] = new C2120oH[c1991mA.A01];
            iArr2[i2] = new int[c1991mA.A01][];
        }
        int[] iArrA0a = A0a(c7dArr);
        for (int i8 = 0; i8 < c1991mA.A01; i8++) {
            C2120oH c2120oHA05 = c1991mA.A05(i8);
            int groupIndex = A0Y(c7dArr, c2120oHA05, iArr, c2120oHA05.A02 == 5);
            if (groupIndex == c7dArr.length) {
                rendererTrackGroupCounts = new int[c2120oHA05.A01];
            } else {
                rendererTrackGroupCounts = A0Z(c7dArr[groupIndex], c2120oHA05);
            }
            int i9 = iArr[groupIndex];
            c2120oHArr[groupIndex][i9] = c2120oHA05;
            iArr2[groupIndex][i9] = rendererTrackGroupCounts;
            iArr[groupIndex] = iArr[groupIndex] + 1;
        }
        C1991mA[] c1991mAArr = new C1991mA[c7dArr.length];
        String[] strArr = new String[c7dArr.length];
        int[] iArr3 = new int[c7dArr.length];
        int i10 = 0;
        while (true) {
            int length = c7dArr.length;
            String[] strArr2 = A01;
            if (strArr2[4].charAt(23) == strArr2[1].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr3 = A01;
            strArr3[4] = "hppY0P6sht5kF7is4RCKyMBKsFUVAoRB";
            strArr3[1] = "XeHPWbHBeoBDFVDQc4DbmKa9NYqMdrJh";
            if (i10 < length) {
                int i11 = iArr[i10];
                c1991mAArr[i10] = new C1991mA((C2120oH[]) AbstractC04664a.A1I(c2120oHArr[i10], i11));
                iArr2[i10] = (int[][]) AbstractC04664a.A1I(iArr2[i10], i11);
                strArr[i10] = c7dArr[i10].getName();
                iArr3[i10] = c7dArr[i10].A9F();
                i10++;
            } else {
                EC ec = new EC(strArr, iArr3, c1991mAArr, iArrA0a, iArr2, new C1991mA((C2120oH[]) AbstractC04664a.A1I(c2120oHArr[c7dArr.length], iArr[c7dArr.length])));
                Pair<C7G[], InterfaceC1964lj[]> pairA0d = A0d(ec, iArr2, iArrA0a, c2001mL, timeline);
                return new EL((C7G[]) pairA0d.first, (InterfaceC1964lj[]) pairA0d.second, EH.A00(ec, (EE[]) pairA0d.second), ec);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.EK
    public final void A0c(Object obj) {
        this.A00 = (EC) obj;
    }
}
