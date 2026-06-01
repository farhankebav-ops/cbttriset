package com.bytedance.adsdk.MY.EO.EO;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.LongSparseArray;
import com.bytedance.adsdk.MY.EO.IlO.EV;
import com.bytedance.adsdk.MY.EO.MY;
import com.bytedance.adsdk.MY.EO.MY.zPa;
import com.bytedance.adsdk.MY.IlO.MY.ea;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends com.bytedance.adsdk.MY.EO.EO.IlO {
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> AXM;
    private final StringBuilder Bc;
    private final Matrix DmF;
    private final Paint EV;
    private final Paint NV;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Typeface, Typeface> OOq;
    private final List<IlO> bWL;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> cL;
    private final com.bytedance.adsdk.MY.Bc cl;
    private final ea ea;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> es;
    private final LongSparseArray<String> hp;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> kBB;
    private final RectF lEW;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> oeT;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> pP;
    private final Map<com.bytedance.adsdk.MY.EO.tV, List<com.bytedance.adsdk.MY.IlO.IlO.tV>> rp;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> tl;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> vAh;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> xF;
    private final com.bytedance.adsdk.MY.DmF zPa;

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.EO.EO.DmF$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] IlO;

        static {
            int[] iArr = new int[MY.IlO.values().length];
            IlO = iArr;
            try {
                iArr[MY.IlO.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                IlO[MY.IlO.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                IlO[MY.IlO.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        private String IlO;
        private float MY;

        private IlO() {
            this.IlO = "";
            this.MY = 0.0f;
        }

        public void IlO(String str, float f4) {
            this.IlO = str;
            this.MY = f4;
        }
    }

    public DmF(com.bytedance.adsdk.MY.DmF dmF, Cc cc) {
        com.bytedance.adsdk.MY.EO.IlO.MY my;
        com.bytedance.adsdk.MY.EO.IlO.MY my2;
        com.bytedance.adsdk.MY.EO.IlO.IlO ilO;
        com.bytedance.adsdk.MY.EO.IlO.IlO ilO2;
        super(dmF, cc);
        this.Bc = new StringBuilder(2);
        this.lEW = new RectF();
        this.DmF = new Matrix();
        int i2 = 1;
        this.NV = new Paint(i2) { // from class: com.bytedance.adsdk.MY.EO.EO.DmF.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.EV = new Paint(i2) { // from class: com.bytedance.adsdk.MY.EO.EO.DmF.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.rp = new HashMap();
        this.hp = new LongSparseArray<>();
        this.bWL = new ArrayList();
        this.zPa = dmF;
        this.cl = cc.IlO();
        ea eaVarIlO = cc.es().IlO();
        this.ea = eaVarIlO;
        eaVarIlO.IlO(this);
        IlO(eaVarIlO);
        EV evXF = cc.xF();
        if (evXF != null && (ilO2 = evXF.IlO) != null) {
            com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> IlO2 = ilO2.IlO();
            this.cL = IlO2;
            IlO2.IlO(this);
            IlO(this.cL);
        }
        if (evXF != null && (ilO = evXF.MY) != null) {
            com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> IlO3 = ilO.IlO();
            this.xF = IlO3;
            IlO3.IlO(this);
            IlO(this.xF);
        }
        if (evXF != null && (my2 = evXF.EO) != null) {
            com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO4 = my2.IlO();
            this.oeT = IlO4;
            IlO4.IlO(this);
            IlO(this.oeT);
        }
        if (evXF == null || (my = evXF.tV) == null) {
            return;
        }
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO5 = my.IlO();
        this.kBB = IlO5;
        IlO5.IlO(this);
        IlO(this.kBB);
    }

    private boolean EO(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 8 || Character.getType(i2) == 19;
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO, com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        super.IlO(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, this.cl.tV().width(), this.cl.tV().height());
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO
    public void MY(Canvas canvas, Matrix matrix, int i2) {
        super.MY(canvas, matrix, i2);
        com.bytedance.adsdk.MY.EO.MY myBc = this.ea.Bc();
        com.bytedance.adsdk.MY.EO.EO eo = this.cl.ea().get(myBc.MY);
        if (eo == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        IlO(myBc, matrix);
        if (this.zPa.pP()) {
            IlO(myBc, matrix, eo, canvas);
        } else {
            IlO(myBc, eo, canvas);
        }
        canvas.restore();
    }

    private void IlO(com.bytedance.adsdk.MY.EO.MY my, Matrix matrix) {
        com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO = this.es;
        if (ilO != null) {
            this.NV.setColor(ilO.Bc().intValue());
        } else {
            com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO2 = this.cL;
            if (ilO2 != null) {
                this.NV.setColor(ilO2.Bc().intValue());
            } else {
                this.NV.setColor(my.lEW);
            }
        }
        com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO3 = this.AXM;
        if (ilO3 != null) {
            this.EV.setColor(ilO3.Bc().intValue());
        } else {
            com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> ilO4 = this.xF;
            if (ilO4 != null) {
                this.EV.setColor(ilO4.Bc().intValue());
            } else {
                this.EV.setColor(my.DmF);
            }
        }
        int iIntValue = ((this.tV.IlO() == null ? 100 : this.tV.IlO().Bc().intValue()) * 255) / 100;
        this.NV.setAlpha(iIntValue);
        this.EV.setAlpha(iIntValue);
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> ilO5 = this.vAh;
        if (ilO5 != null) {
            this.EV.setStrokeWidth(ilO5.Bc().floatValue());
            return;
        }
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> ilO6 = this.oeT;
        if (ilO6 != null) {
            this.EV.setStrokeWidth(ilO6.Bc().floatValue());
        } else {
            this.EV.setStrokeWidth(com.bytedance.adsdk.MY.vCE.vCE.IlO() * my.NV);
        }
    }

    private IlO MY(int i2) {
        for (int size = this.bWL.size(); size < i2; size++) {
            this.bWL.add(new IlO());
        }
        return this.bWL.get(i2 - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(com.bytedance.adsdk.MY.EO.MY r17, android.graphics.Matrix r18, com.bytedance.adsdk.MY.EO.EO r19, android.graphics.Canvas r20) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            com.bytedance.adsdk.MY.IlO.MY.IlO<java.lang.Float, java.lang.Float> r1 = r0.tl
            if (r1 == 0) goto L13
            java.lang.Object r1 = r1.Bc()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L15
        L13:
            float r1 = r7.EO
        L15:
            r2 = 1120403456(0x42c80000, float:100.0)
            float r4 = r1 / r2
            float r8 = com.bytedance.adsdk.MY.vCE.vCE.IlO(r18)
            java.lang.String r1 = r7.IlO
            java.util.List r9 = r0.IlO(r1)
            int r10 = r9.size()
            int r1 = r7.Cc
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            com.bytedance.adsdk.MY.IlO.MY.IlO<java.lang.Float, java.lang.Float> r2 = r0.pP
            if (r2 == 0) goto L3e
            java.lang.Object r2 = r2.Bc()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L3b:
            float r1 = r1 + r2
        L3c:
            r5 = r1
            goto L4d
        L3e:
            com.bytedance.adsdk.MY.IlO.MY.IlO<java.lang.Float, java.lang.Float> r2 = r0.kBB
            if (r2 == 0) goto L3c
            java.lang.Object r2 = r2.Bc()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L3b
        L4d:
            r11 = 0
            r1 = -1
            r12 = r1
            r13 = r11
        L51:
            if (r13 >= r10) goto La7
            java.lang.Object r1 = r9.get(r13)
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r2 = r7.hp
            if (r2 != 0) goto L5f
            r2 = 0
            goto L61
        L5f:
            float r2 = r2.x
        L61:
            r6 = 1
            r3 = r19
            java.util.List r14 = r0.IlO(r1, r2, r3, r4, r5, r6)
            r15 = r11
        L69:
            int r1 = r14.size()
            if (r15 >= r1) goto L9d
            java.lang.Object r1 = r14.get(r15)
            com.bytedance.adsdk.MY.EO.EO.DmF$IlO r1 = (com.bytedance.adsdk.MY.EO.EO.DmF.IlO) r1
            int r12 = r12 + 1
            r20.save()
            float r2 = com.bytedance.adsdk.MY.EO.EO.DmF.IlO.IlO(r1)
            r3 = r20
            r0.IlO(r3, r7, r12, r2)
            java.lang.String r1 = com.bytedance.adsdk.MY.EO.EO.DmF.IlO.MY(r1)
            r6 = r4
            r2 = r7
            r4 = r3
            r7 = r5
            r5 = r8
            r3 = r19
            r0.IlO(r1, r2, r3, r4, r5, r6, r7)
            r4 = r6
            r20.restore()
            int r15 = r15 + 1
            r0 = r16
            r5 = r7
            r7 = r17
            goto L69
        L9d:
            r7 = r5
            r5 = r8
            int r13 = r13 + 1
            r0 = r16
            r5 = r7
            r7 = r17
            goto L51
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.EO.EO.DmF.IlO(com.bytedance.adsdk.MY.EO.MY, android.graphics.Matrix, com.bytedance.adsdk.MY.EO.EO, android.graphics.Canvas):void");
    }

    private void IlO(String str, com.bytedance.adsdk.MY.EO.MY my, com.bytedance.adsdk.MY.EO.EO eo, Canvas canvas, float f4, float f8, float f9) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.bytedance.adsdk.MY.EO.tV tVVar = this.cl.bWL().get(com.bytedance.adsdk.MY.EO.tV.IlO(str.charAt(i2), eo.IlO(), eo.EO()));
            if (tVVar != null) {
                IlO(tVVar, f8, my, canvas);
                canvas.translate((com.bytedance.adsdk.MY.vCE.vCE.IlO() * ((float) tVVar.MY()) * f8) + f9, 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void IlO(com.bytedance.adsdk.MY.EO.MY r13, com.bytedance.adsdk.MY.EO.EO r14, android.graphics.Canvas r15) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.EO.EO.DmF.IlO(com.bytedance.adsdk.MY.EO.MY, com.bytedance.adsdk.MY.EO.EO, android.graphics.Canvas):void");
    }

    private void IlO(Canvas canvas, com.bytedance.adsdk.MY.EO.MY my, int i2, float f4) {
        PointF pointF = my.rp;
        PointF pointF2 = my.hp;
        float fIlO = com.bytedance.adsdk.MY.vCE.vCE.IlO();
        float f8 = (i2 * my.vCE * fIlO) + (pointF == null ? 0.0f : (my.vCE * 0.6f * fIlO) + pointF.y);
        float f9 = pointF == null ? 0.0f : pointF.x;
        float f10 = pointF2 != null ? pointF2.x : 0.0f;
        int i8 = AnonymousClass3.IlO[my.tV.ordinal()];
        if (i8 == 1) {
            canvas.translate(f9, f8);
        } else if (i8 == 2) {
            canvas.translate((f9 + f10) - f4, f8);
        } else {
            if (i8 != 3) {
                return;
            }
            canvas.translate(((f10 / 2.0f) + f9) - (f4 / 2.0f), f8);
        }
    }

    private Typeface IlO(com.bytedance.adsdk.MY.EO.EO eo) {
        Typeface typefaceBc;
        com.bytedance.adsdk.MY.IlO.MY.IlO<Typeface, Typeface> ilO = this.OOq;
        if (ilO != null && (typefaceBc = ilO.Bc()) != null) {
            return typefaceBc;
        }
        Typeface typefaceIlO = this.zPa.IlO(eo);
        return typefaceIlO != null ? typefaceIlO : eo.tV();
    }

    private List<String> IlO(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void IlO(String str, com.bytedance.adsdk.MY.EO.MY my, Canvas canvas, float f4) {
        int length = 0;
        while (length < str.length()) {
            String strIlO = IlO(str, length);
            length += strIlO.length();
            IlO(strIlO, my, canvas);
            canvas.translate(this.NV.measureText(strIlO) + f4, 0.0f);
        }
    }

    private List<IlO> IlO(String str, float f4, com.bytedance.adsdk.MY.EO.EO eo, float f8, float f9, boolean z2) {
        float fMeasureText;
        int i2 = 0;
        int i8 = 0;
        boolean z7 = false;
        int i9 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (z2) {
                com.bytedance.adsdk.MY.EO.tV tVVar = this.cl.bWL().get(com.bytedance.adsdk.MY.EO.tV.IlO(cCharAt, eo.IlO(), eo.EO()));
                if (tVVar != null) {
                    fMeasureText = (com.bytedance.adsdk.MY.vCE.vCE.IlO() * ((float) tVVar.MY()) * f8) + f9;
                }
            } else {
                fMeasureText = this.NV.measureText(str.substring(i10, i10 + 1)) + f9;
            }
            if (cCharAt == ' ') {
                z7 = true;
                f12 = fMeasureText;
            } else if (z7) {
                z7 = false;
                i9 = i10;
                f11 = fMeasureText;
            } else {
                f11 += fMeasureText;
            }
            f10 += fMeasureText;
            if (f4 > 0.0f && f10 >= f4 && cCharAt != ' ') {
                i2++;
                IlO ilOMY = MY(i2);
                if (i9 == i8) {
                    ilOMY.IlO(str.substring(i8, i10).trim(), (f10 - fMeasureText) - ((r9.length() - r7.length()) * f12));
                    i8 = i10;
                    i9 = i8;
                    f10 = fMeasureText;
                    f11 = f10;
                } else {
                    ilOMY.IlO(str.substring(i8, i9 - 1).trim(), ((f10 - f11) - ((r7.length() - r13.length()) * f12)) - f12);
                    f10 = f11;
                    i8 = i9;
                }
            }
        }
        if (f10 > 0.0f) {
            i2++;
            MY(i2).IlO(str.substring(i8), f10);
        }
        return this.bWL.subList(0, i2);
    }

    private void IlO(com.bytedance.adsdk.MY.EO.tV tVVar, float f4, com.bytedance.adsdk.MY.EO.MY my, Canvas canvas) {
        List<com.bytedance.adsdk.MY.IlO.IlO.tV> listIlO = IlO(tVVar);
        for (int i2 = 0; i2 < listIlO.size(); i2++) {
            Path pathTV = listIlO.get(i2).tV();
            pathTV.computeBounds(this.lEW, false);
            this.DmF.reset();
            this.DmF.preTranslate(0.0f, com.bytedance.adsdk.MY.vCE.vCE.IlO() * (-my.Bc));
            this.DmF.preScale(f4, f4);
            pathTV.transform(this.DmF);
            if (my.EV) {
                IlO(pathTV, this.NV, canvas);
                IlO(pathTV, this.EV, canvas);
            } else {
                IlO(pathTV, this.EV, canvas);
                IlO(pathTV, this.NV, canvas);
            }
        }
    }

    private void IlO(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void IlO(String str, com.bytedance.adsdk.MY.EO.MY my, Canvas canvas) {
        if (my.EV) {
            IlO(str, this.NV, canvas);
            IlO(str, this.EV, canvas);
        } else {
            IlO(str, this.EV, canvas);
            IlO(str, this.NV, canvas);
        }
    }

    private void IlO(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.bytedance.adsdk.MY.IlO.IlO.tV> IlO(com.bytedance.adsdk.MY.EO.tV tVVar) {
        if (this.rp.containsKey(tVVar)) {
            return this.rp.get(tVVar);
        }
        List<zPa> listIlO = tVVar.IlO();
        int size = listIlO.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new com.bytedance.adsdk.MY.IlO.IlO.tV(this.zPa, this, listIlO.get(i2), this.cl));
        }
        this.rp.put(tVVar, arrayList);
        return arrayList;
    }

    private String IlO(String str, int i2) {
        int iCodePointAt = str.codePointAt(i2);
        int iCharCount = Character.charCount(iCodePointAt) + i2;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!EO(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.hp.indexOfKey(j) >= 0) {
            return this.hp.get(j);
        }
        this.Bc.setLength(0);
        while (i2 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i2);
            this.Bc.appendCodePoint(iCodePointAt3);
            i2 += Character.charCount(iCodePointAt3);
        }
        String string = this.Bc.toString();
        this.hp.put(j, string);
        return string;
    }
}
