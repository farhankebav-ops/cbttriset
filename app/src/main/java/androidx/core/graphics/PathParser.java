package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c7, float[] fArr) {
        arrayList.add(new PathDataNode(c7, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            if (pathDataNodeArr[i2].mType != pathDataNodeArr2[i2].mType || pathDataNodeArr[i2].mParams.length != pathDataNodeArr2[i2].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i2, int i8) {
        if (i2 > i8) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i2 < 0 || i2 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i9 = i8 - i2;
        int iMin = Math.min(i9, length - i2);
        float[] fArr2 = new float[i9];
        System.arraycopy(fArr, i2, fArr2, 0, iMin);
        return fArr2;
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i8 = 1;
        while (i8 < str.length()) {
            int iNextStart = nextStart(str, i8);
            String strTrim = str.substring(i2, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i2 = iNextStart;
            i8 = iNextStart + 1;
        }
        if (i8 - i2 == 1 && i2 < str.length()) {
            addNode(arrayList, str.charAt(i2), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException(a1.a.l("Error in parsing ", str), e);
        }
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            pathDataNodeArr2[i2] = new PathDataNode(pathDataNodeArr[i2]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L36
        L27:
            r10.mEndWithNegOrDot = r7
        L29:
            r2 = r0
            r4 = r7
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.mEndWithNegOrDot = r7
            goto L29
        L33:
            r2 = r0
            goto L36
        L35:
            r2 = r7
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i2 = 1;
            int i8 = 0;
            while (i2 < length) {
                extract(str, i2, extractFloatResult);
                int i9 = extractFloatResult.mEndPosition;
                if (i2 < i9) {
                    fArr[i8] = Float.parseFloat(str.substring(i2, i9));
                    i8++;
                }
                i2 = extractFloatResult.mEndWithNegOrDot ? i9 : i9 + 1;
            }
            return copyOfRange(fArr, 0, i8);
        } catch (NumberFormatException e) {
            throw new RuntimeException(a1.a.m("error in parsing \"", str, "\""), e);
        }
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f4, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f4)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static int nextStart(String str, int i2) {
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                }
                i2++;
            }
            if (cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i2++;
        }
        return i2;
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c7 = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c7, pathDataNode.mType, pathDataNode.mParams);
            c7 = pathDataNode.mType;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i2 = 0; i2 < pathDataNodeArr2.length; i2++) {
            pathDataNodeArr[i2].mType = pathDataNodeArr2[i2].mType;
            for (int i8 = 0; i8 < pathDataNodeArr2[i2].mParams.length; i8++) {
                pathDataNodeArr[i2].mParams[i8] = pathDataNodeArr2[i2].mParams[i8];
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(char c7, float[] fArr) {
            this.mType = c7;
            this.mParams = fArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c7, char c8, float[] fArr2) {
            int i2;
            int i8;
            boolean z2;
            boolean z7;
            char c9;
            char c10;
            int i9;
            float f4;
            boolean z8;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            boolean z9;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float f20;
            float f21;
            float f22;
            Path path2 = path;
            boolean z10 = false;
            float f23 = fArr[0];
            boolean z11 = true;
            float f24 = fArr[1];
            char c11 = 2;
            float f25 = fArr[2];
            char c12 = 3;
            float f26 = fArr[3];
            float f27 = fArr[4];
            float f28 = fArr[5];
            switch (c8) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case 'a':
                    i2 = 7;
                    i8 = i2;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                case 'c':
                    i2 = 6;
                    i8 = i2;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                    i8 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i8 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i8 = 4;
                    break;
                case 'Z':
                case INVALID_ADS_ENDPOINT_VALUE:
                    path2.close();
                    path2.moveTo(f27, f28);
                    f23 = f27;
                    f25 = f23;
                    f24 = f28;
                    f26 = f24;
                    i8 = 2;
                    break;
            }
            float f29 = f23;
            float f30 = f24;
            float f31 = f27;
            float f32 = f28;
            int i10 = 0;
            char c13 = c7;
            while (i10 < fArr2.length) {
                if (c8 == 'A') {
                    float f33 = f29;
                    float f34 = f30;
                    z2 = z10;
                    z7 = z11;
                    c9 = c11;
                    c10 = c12;
                    i9 = i10;
                    int i11 = i9 + 5;
                    float f35 = fArr2[i11];
                    int i12 = i9 + 6;
                    float f36 = fArr2[i12];
                    float f37 = fArr2[i9];
                    float f38 = fArr2[i9 + 1];
                    float f39 = fArr2[i9 + 2];
                    if (fArr2[i9 + 3] != 0.0f) {
                        f4 = 0.0f;
                        z8 = z7;
                    } else {
                        f4 = 0.0f;
                        z8 = z2;
                    }
                    drawArc(path, f33, f34, f35, f36, f37, f38, f39, z8, fArr2[i9 + 4] != f4 ? z7 : z2);
                    f25 = fArr2[i11];
                    f29 = f25;
                    f26 = fArr2[i12];
                    f30 = f26;
                } else if (c8 == 'C') {
                    z2 = z10;
                    z7 = z11;
                    c9 = c11;
                    c10 = c12;
                    i9 = i10;
                    int i13 = i9 + 2;
                    int i14 = i9 + 3;
                    int i15 = i9 + 4;
                    int i16 = i9 + 5;
                    path2.cubicTo(fArr2[i9], fArr2[i9 + 1], fArr2[i13], fArr2[i14], fArr2[i15], fArr2[i16]);
                    float f40 = fArr2[i15];
                    float f41 = fArr2[i16];
                    float f42 = fArr2[i13];
                    float f43 = fArr2[i14];
                    f29 = f40;
                    f30 = f41;
                    f26 = f43;
                    f25 = f42;
                } else if (c8 != 'H') {
                    if (c8 != 'Q') {
                        z2 = z10;
                        if (c8 == 'V') {
                            z7 = z11;
                            c9 = c11;
                            c10 = c12;
                            i9 = i10;
                            path2.lineTo(f29, fArr2[i9]);
                            f10 = fArr2[i9];
                        } else if (c8 != 'a') {
                            if (c8 != 'c') {
                                z7 = z11;
                                if (c8 != 'h') {
                                    if (c8 != 'q') {
                                        c9 = c11;
                                        if (c8 != 'v') {
                                            if (c8 != 'L') {
                                                if (c8 != 'M') {
                                                    c10 = c12;
                                                    if (c8 == 'S') {
                                                        if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                                            f29 = (f29 * 2.0f) - f25;
                                                            f30 = (f30 * 2.0f) - f26;
                                                        }
                                                        float f44 = f29;
                                                        float f45 = f30;
                                                        int i17 = i10 + 1;
                                                        int i18 = i10 + 2;
                                                        int i19 = i10 + 3;
                                                        path2.cubicTo(f44, f45, fArr2[i10], fArr2[i17], fArr2[i18], fArr2[i19]);
                                                        f8 = fArr2[i10];
                                                        f9 = fArr2[i17];
                                                        f29 = fArr2[i18];
                                                        f30 = fArr2[i19];
                                                        i9 = i10;
                                                    } else if (c8 == 'T') {
                                                        if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                                            f29 = (f29 * 2.0f) - f25;
                                                            f30 = (f30 * 2.0f) - f26;
                                                        }
                                                        int i20 = i10 + 1;
                                                        path2.quadTo(f29, f30, fArr2[i10], fArr2[i20]);
                                                        float f46 = fArr2[i10];
                                                        f10 = fArr2[i20];
                                                        f25 = f29;
                                                        f26 = f30;
                                                        i9 = i10;
                                                        f29 = f46;
                                                    } else if (c8 == 'l') {
                                                        int i21 = i10 + 1;
                                                        path2.rLineTo(fArr2[i10], fArr2[i21]);
                                                        f29 += fArr2[i10];
                                                        f16 = fArr2[i21];
                                                    } else if (c8 == 'm') {
                                                        float f47 = fArr2[i10];
                                                        f29 += f47;
                                                        float f48 = fArr2[i10 + 1];
                                                        f30 += f48;
                                                        if (i10 > 0) {
                                                            path2.rLineTo(f47, f48);
                                                        } else {
                                                            path2.rMoveTo(f47, f48);
                                                            f31 = f29;
                                                        }
                                                    } else if (c8 == 's') {
                                                        if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                                            f19 = f30 - f26;
                                                            f20 = f29 - f25;
                                                        } else {
                                                            f20 = 0.0f;
                                                            f19 = 0.0f;
                                                        }
                                                        int i22 = i10 + 1;
                                                        int i23 = i10 + 2;
                                                        int i24 = i10 + 3;
                                                        path2.rCubicTo(f20, f19, fArr2[i10], fArr2[i22], fArr2[i23], fArr2[i24]);
                                                        f13 = fArr2[i10] + f29;
                                                        f14 = fArr2[i22] + f30;
                                                        f29 += fArr2[i23];
                                                        f15 = fArr2[i24];
                                                    } else if (c8 == 't') {
                                                        if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                                            f21 = f29 - f25;
                                                            f22 = f30 - f26;
                                                        } else {
                                                            f22 = 0.0f;
                                                            f21 = 0.0f;
                                                        }
                                                        int i25 = i10 + 1;
                                                        path2.rQuadTo(f21, f22, fArr2[i10], fArr2[i25]);
                                                        float f49 = f21 + f29;
                                                        float f50 = f22 + f30;
                                                        f29 += fArr2[i10];
                                                        f30 += fArr2[i25];
                                                        f26 = f50;
                                                        f25 = f49;
                                                    }
                                                } else {
                                                    c10 = c12;
                                                    f17 = fArr2[i10];
                                                    f18 = fArr2[i10 + 1];
                                                    if (i10 > 0) {
                                                        path2.lineTo(f17, f18);
                                                    } else {
                                                        path2.moveTo(f17, f18);
                                                        f29 = f17;
                                                        f31 = f29;
                                                        f30 = f18;
                                                    }
                                                }
                                                f32 = f30;
                                            } else {
                                                c10 = c12;
                                                int i26 = i10 + 1;
                                                path2.lineTo(fArr2[i10], fArr2[i26]);
                                                f17 = fArr2[i10];
                                                f18 = fArr2[i26];
                                            }
                                            f29 = f17;
                                            f30 = f18;
                                        } else {
                                            c10 = c12;
                                            path2.rLineTo(0.0f, fArr2[i10]);
                                            f16 = fArr2[i10];
                                        }
                                        f30 += f16;
                                    } else {
                                        c9 = c11;
                                        c10 = c12;
                                        int i27 = i10 + 1;
                                        int i28 = i10 + 2;
                                        int i29 = i10 + 3;
                                        path2.rQuadTo(fArr2[i10], fArr2[i27], fArr2[i28], fArr2[i29]);
                                        f13 = fArr2[i10] + f29;
                                        f14 = fArr2[i27] + f30;
                                        f29 += fArr2[i28];
                                        f15 = fArr2[i29];
                                    }
                                    f30 += f15;
                                    f25 = f13;
                                    f26 = f14;
                                } else {
                                    c9 = c11;
                                    c10 = c12;
                                    path2.rLineTo(fArr2[i10], 0.0f);
                                    f29 += fArr2[i10];
                                }
                            } else {
                                z7 = z11;
                                c9 = c11;
                                c10 = c12;
                                int i30 = i10 + 2;
                                int i31 = i10 + 3;
                                int i32 = i10 + 4;
                                int i33 = i10 + 5;
                                path2.rCubicTo(fArr2[i10], fArr2[i10 + 1], fArr2[i30], fArr2[i31], fArr2[i32], fArr2[i33]);
                                float f51 = fArr2[i30] + f29;
                                float f52 = fArr2[i31] + f30;
                                f29 += fArr2[i32];
                                f30 += fArr2[i33];
                                f25 = f51;
                                f26 = f52;
                            }
                            i9 = i10;
                        } else {
                            z7 = z11;
                            c9 = c11;
                            c10 = c12;
                            int i34 = i10 + 5;
                            float f53 = fArr2[i34] + f29;
                            int i35 = i10 + 6;
                            float f54 = fArr2[i35] + f30;
                            float f55 = fArr2[i10];
                            float f56 = fArr2[i10 + 1];
                            float f57 = fArr2[i10 + 2];
                            if (fArr2[i10 + 3] != 0.0f) {
                                f11 = 0.0f;
                                f12 = f30;
                                z9 = z7;
                            } else {
                                f11 = 0.0f;
                                f12 = f30;
                                z9 = z2;
                            }
                            i9 = i10;
                            boolean z12 = fArr2[i10 + 4] != f11 ? z7 : z2;
                            float f58 = f29;
                            drawArc(path, f58, f12, f53, f54, f55, f56, f57, z9, z12);
                            f29 = f58 + fArr2[i34];
                            f30 = f12 + fArr2[i35];
                            f25 = f29;
                            f26 = f30;
                        }
                        f30 = f10;
                    } else {
                        z2 = z10;
                        z7 = z11;
                        c9 = c11;
                        c10 = c12;
                        i9 = i10;
                        int i36 = i9 + 1;
                        int i37 = i9 + 2;
                        int i38 = i9 + 3;
                        path2.quadTo(fArr2[i9], fArr2[i36], fArr2[i37], fArr2[i38]);
                        f8 = fArr2[i9];
                        f9 = fArr2[i36];
                        f29 = fArr2[i37];
                        f30 = fArr2[i38];
                    }
                    f25 = f8;
                    f26 = f9;
                } else {
                    z2 = z10;
                    z7 = z11;
                    c9 = c11;
                    c10 = c12;
                    i9 = i10;
                    path2.lineTo(fArr2[i9], f30);
                    f29 = fArr2[i9];
                }
                i10 = i9 + i8;
                path2 = path;
                c13 = c8;
                z10 = z2;
                z11 = z7;
                c11 = c9;
                c12 = c10;
            }
            fArr[z10 ? 1 : 0] = f29;
            fArr[z11 ? 1 : 0] = f30;
            fArr[c11] = f25;
            fArr[c12] = f26;
            fArr[4] = f31;
            fArr[5] = f32;
        }

        private static void arcToBezier(Path path, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
            double d17 = d10;
            int iCeil = (int) Math.ceil(Math.abs((d16 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d14);
            double dSin = Math.sin(d14);
            double dCos2 = Math.cos(d15);
            double dSin2 = Math.sin(d15);
            double d18 = -d17;
            double d19 = d18 * dCos;
            double d20 = d11 * dSin;
            double d21 = (d19 * dSin2) - (d20 * dCos2);
            double d22 = d18 * dSin;
            double d23 = d11 * dCos;
            double d24 = (dCos2 * d23) + (dSin2 * d22);
            double d25 = d16 / ((double) iCeil);
            double d26 = d24;
            double d27 = d21;
            int i2 = 0;
            double d28 = d12;
            double d29 = d13;
            double d30 = d15;
            while (i2 < iCeil) {
                double d31 = d30 + d25;
                double dSin3 = Math.sin(d31);
                double dCos3 = Math.cos(d31);
                double d32 = (((d17 * dCos) * dCos3) + d8) - (d20 * dSin3);
                int i8 = i2;
                double d33 = (d23 * dSin3) + (d10 * dSin * dCos3) + d9;
                double d34 = (d19 * dSin3) - (d20 * dCos3);
                double d35 = (dCos3 * d23) + (dSin3 * d22);
                double d36 = d31 - d30;
                double dTan = Math.tan(d36 / 2.0d);
                double dSqrt = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d36)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d27 * dSqrt) + d28), (float) ((d26 * dSqrt) + d29), (float) (d32 - (dSqrt * d34)), (float) (d33 - (dSqrt * d35)), (float) d32, (float) d33);
                dSin = dSin;
                d25 = d25;
                d28 = d32;
                d22 = d22;
                dCos = dCos;
                d26 = d35;
                d27 = d34;
                d17 = d10;
                d29 = d33;
                i2 = i8 + 1;
                iCeil = iCeil;
                d30 = d31;
            }
        }

        private static void drawArc(Path path, float f4, float f8, float f9, float f10, float f11, float f12, float f13, boolean z2, boolean z7) {
            double d8;
            double d9;
            double radians = Math.toRadians(f13);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d10 = f4;
            double d11 = f8;
            double d12 = f11;
            double d13 = ((d11 * dSin) + (d10 * dCos)) / d12;
            double d14 = f12;
            double d15 = ((d11 * dCos) + (((double) (-f4)) * dSin)) / d14;
            double d16 = f10;
            double d17 = ((d16 * dSin) + (((double) f9) * dCos)) / d12;
            double d18 = ((d16 * dCos) + (((double) (-f9)) * dSin)) / d14;
            double d19 = d13 - d17;
            double d20 = d15 - d18;
            double d21 = (d13 + d17) / 2.0d;
            double d22 = (d15 + d18) / 2.0d;
            double d23 = (d20 * d20) + (d19 * d19);
            if (d23 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d24 = (1.0d / d23) - 0.25d;
            if (d24 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d23);
                float fSqrt = (float) (Math.sqrt(d23) / 1.99999d);
                drawArc(path, f4, f8, f9, f10, f11 * fSqrt, fSqrt * f12, f13, z2, z7);
                return;
            }
            double dSqrt = Math.sqrt(d24);
            double d25 = dSqrt * d19;
            double d26 = dSqrt * d20;
            if (z2 == z7) {
                d8 = d21 - d26;
                d9 = d22 + d25;
            } else {
                d8 = d21 + d26;
                d9 = d22 - d25;
            }
            double dAtan2 = Math.atan2(d15 - d9, d13 - d8);
            double dAtan22 = Math.atan2(d18 - d9, d17 - d8) - dAtan2;
            if (z7 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d27 = d8 * d12;
            double d28 = d9 * d14;
            arcToBezier(path, (d27 * dCos) - (d28 * dSin), (d28 * dCos) + (d27 * dSin), d12, d14, d10, d11, radians, dAtan2, dAtan22);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f4) {
            this.mType = pathDataNode.mType;
            int i2 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i2 >= fArr.length) {
                    return;
                }
                this.mParams[i2] = (pathDataNode2.mParams[i2] * f4) + ((1.0f - f4) * fArr[i2]);
                i2++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f4) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                pathDataNodeArr[i2].interpolatePathDataNode(pathDataNodeArr2[i2], pathDataNodeArr3[i2], f4);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}
