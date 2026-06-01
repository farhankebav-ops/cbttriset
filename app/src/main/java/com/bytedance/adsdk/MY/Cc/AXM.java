package com.bytedance.adsdk.MY.Cc;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class AXM {
    private static final Interpolator IlO = new LinearInterpolator();
    private static SparseArray<WeakReference<Interpolator>> MY;

    private static SparseArray<WeakReference<Interpolator>> IlO() {
        if (MY == null) {
            MY = new SparseArray<>();
        }
        return MY;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0263 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> com.bytedance.adsdk.MY.Bc.IlO<T> MY(com.bytedance.adsdk.MY.Bc r24, android.util.JsonReader r25, float r26, com.bytedance.adsdk.MY.Cc.HSR<T> r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 706
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.Cc.AXM.MY(com.bytedance.adsdk.MY.Bc, android.util.JsonReader, float, com.bytedance.adsdk.MY.Cc.HSR):com.bytedance.adsdk.MY.Bc.IlO");
    }

    private static WeakReference<Interpolator> IlO(int i2) {
        WeakReference<Interpolator> weakReference;
        synchronized (AXM.class) {
            weakReference = IlO().get(i2);
        }
        return weakReference;
    }

    private static void IlO(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (AXM.class) {
            MY.put(i2, weakReference);
        }
    }

    public static <T> com.bytedance.adsdk.MY.Bc.IlO<T> IlO(JsonReader jsonReader, com.bytedance.adsdk.MY.Bc bc, float f4, HSR<T> hsr, boolean z2, boolean z7) throws IOException {
        if (z2 && z7) {
            return MY(bc, jsonReader, f4, hsr);
        }
        if (z2) {
            return IlO(bc, jsonReader, f4, hsr);
        }
        return IlO(jsonReader, f4, hsr);
    }

    private static <T> com.bytedance.adsdk.MY.Bc.IlO<T> IlO(com.bytedance.adsdk.MY.Bc bc, JsonReader jsonReader, float f4, HSR<T> hsr) throws IOException {
        Interpolator interpolatorIlO;
        jsonReader.beginObject();
        PointF pointFMY = null;
        T tMY = null;
        T tMY2 = null;
        PointF pointFMY2 = null;
        PointF pointFMY3 = null;
        float fNextDouble = 0.0f;
        boolean z2 = false;
        PointF pointFMY4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "e":
                    tMY = hsr.MY(jsonReader, f4);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                    break;
                case "i":
                    pointFMY4 = xF.MY(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFMY = xF.MY(jsonReader, 1.0f);
                    break;
                case "s":
                    tMY2 = hsr.MY(jsonReader, f4);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFMY3 = xF.MY(jsonReader, f4);
                    break;
                case "to":
                    pointFMY2 = xF.MY(jsonReader, f4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z2) {
            if (pointFMY != null && pointFMY4 != null) {
                interpolatorIlO = IlO(pointFMY, pointFMY4);
            }
            com.bytedance.adsdk.MY.Bc.IlO<T> ilO = new com.bytedance.adsdk.MY.Bc.IlO<>(bc, tMY2, tMY, interpolatorIlO, fNextDouble, null);
            ilO.lEW = pointFMY2;
            ilO.DmF = pointFMY3;
            return ilO;
        }
        tMY = tMY2;
        interpolatorIlO = IlO;
        com.bytedance.adsdk.MY.Bc.IlO<T> ilO2 = new com.bytedance.adsdk.MY.Bc.IlO<>(bc, tMY2, tMY, interpolatorIlO, fNextDouble, null);
        ilO2.lEW = pointFMY2;
        ilO2.DmF = pointFMY3;
        return ilO2;
    }

    private static Interpolator IlO(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.MY.vCE.Cc.MY(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.MY.vCE.Cc.MY(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.MY.vCE.Cc.MY(pointF2.x, -1.0f, 1.0f);
        float fMY = com.bytedance.adsdk.MY.vCE.Cc.MY(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fMY;
        int iIlO = com.bytedance.adsdk.MY.vCE.vCE.IlO(pointF.x, pointF.y, pointF2.x, fMY);
        WeakReference<Interpolator> weakReferenceIlO = com.bytedance.adsdk.MY.Cc.IlO() ? null : IlO(iIlO);
        Interpolator interpolator = weakReferenceIlO != null ? weakReferenceIlO.get() : null;
        if (weakReferenceIlO != null && interpolator != null) {
            return interpolator;
        }
        try {
            linearInterpolator = com.bytedance.adsdk.MY.cl.IlO(pointF.x, pointF.y, pointF2.x, pointF2.y);
        } catch (IllegalArgumentException e) {
            if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                linearInterpolator = com.bytedance.adsdk.MY.cl.IlO(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
            } else {
                linearInterpolator = new LinearInterpolator();
            }
        }
        if (!com.bytedance.adsdk.MY.Cc.IlO()) {
            try {
                IlO(iIlO, (WeakReference<Interpolator>) new WeakReference(linearInterpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return linearInterpolator;
    }

    private static <T> com.bytedance.adsdk.MY.Bc.IlO<T> IlO(JsonReader jsonReader, float f4, HSR<T> hsr) throws IOException {
        return new com.bytedance.adsdk.MY.Bc.IlO<>(hsr.MY(jsonReader, f4));
    }
}
