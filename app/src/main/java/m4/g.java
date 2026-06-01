package m4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f12954a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f12955b = new String[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f12956c = new String[256];

    static {
        int i2 = 0;
        int i8 = 0;
        while (true) {
            String[] strArr = f12956c;
            if (i8 >= strArr.length) {
                break;
            }
            strArr[i8] = String.format("%8s", Integer.toBinaryString(i8)).replace(' ', '0');
            i8++;
        }
        String[] strArr2 = f12955b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i9 = iArr[0];
        strArr2[i9 | 8] = a1.a.r(new StringBuilder(), strArr2[i9], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i10 = 0; i10 < 3; i10++) {
            int i11 = iArr2[i10];
            int i12 = iArr[0];
            String[] strArr3 = f12955b;
            int i13 = i12 | i11;
            strArr3[i13] = strArr3[i12] + '|' + strArr3[i11];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i12]);
            sb.append('|');
            strArr3[i13 | 8] = a1.a.r(sb, strArr3[i11], "|PADDED");
        }
        while (true) {
            String[] strArr4 = f12955b;
            if (i2 >= strArr4.length) {
                return;
            }
            if (strArr4[i2] == null) {
                strArr4[i2] = f12956c[i2];
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(boolean r9, int r10, int r11, byte r12, byte r13) {
        /*
            r0 = 10
            r1 = 0
            r2 = 1
            if (r12 >= r0) goto Lb
            java.lang.String[] r0 = m4.g.f12954a
            r0 = r0[r12]
            goto L19
        Lb:
            java.lang.Byte r0 = java.lang.Byte.valueOf(r12)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r3[r1] = r0
            java.lang.String r0 = "0x%02x"
            java.lang.String r0 = java.lang.String.format(r0, r3)
        L19:
            r3 = 5
            r4 = 3
            r5 = 2
            r6 = 4
            if (r13 != 0) goto L22
            java.lang.String r12 = ""
            goto L69
        L22:
            java.lang.String[] r7 = m4.g.f12956c
            if (r12 == r5) goto L67
            if (r12 == r4) goto L67
            if (r12 == r6) goto L5f
            r8 = 6
            if (r12 == r8) goto L5f
            r8 = 7
            if (r12 == r8) goto L67
            r8 = 8
            if (r12 == r8) goto L67
            r8 = 64
            if (r13 >= r8) goto L3d
            java.lang.String[] r7 = m4.g.f12955b
            r7 = r7[r13]
            goto L3f
        L3d:
            r7 = r7[r13]
        L3f:
            if (r12 != r3) goto L4e
            r8 = r13 & 4
            if (r8 == 0) goto L4e
            java.lang.String r12 = "HEADERS"
            java.lang.String r13 = "PUSH_PROMISE"
            java.lang.String r12 = r7.replace(r12, r13)
            goto L69
        L4e:
            if (r12 != 0) goto L5d
            r12 = r13 & 32
            if (r12 == 0) goto L5d
            java.lang.String r12 = "PRIORITY"
            java.lang.String r13 = "COMPRESSED"
            java.lang.String r12 = r7.replace(r12, r13)
            goto L69
        L5d:
            r12 = r7
            goto L69
        L5f:
            if (r13 != r2) goto L64
            java.lang.String r12 = "ACK"
            goto L69
        L64:
            r12 = r7[r13]
            goto L69
        L67:
            r12 = r7[r13]
        L69:
            java.util.Locale r13 = java.util.Locale.US
            if (r9 == 0) goto L70
            java.lang.String r9 = "<<"
            goto L72
        L70:
            java.lang.String r9 = ">>"
        L72:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r1] = r9
            r3[r2] = r10
            r3[r5] = r11
            r3[r4] = r0
            r3[r6] = r12
            java.lang.String r9 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r9 = java.lang.String.format(r13, r9, r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.g.a(boolean, int, int, byte, byte):java.lang.String");
    }
}
