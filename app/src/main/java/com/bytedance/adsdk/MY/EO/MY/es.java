package com.bytedance.adsdk.MY.EO.MY;

import android.graphics.Paint;
import com.bytedance.adsdk.MY.IlO.IlO.AXM;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es implements EO {
    private final IlO Bc;
    private final com.bytedance.adsdk.MY.EO.IlO.tV Cc;
    private final float DmF;
    private final List<com.bytedance.adsdk.MY.EO.IlO.MY> EO;
    private final String IlO;
    private final com.bytedance.adsdk.MY.EO.IlO.MY MY;
    private final boolean NV;
    private final MY lEW;
    private final com.bytedance.adsdk.MY.EO.IlO.IlO tV;
    private final com.bytedance.adsdk.MY.EO.IlO.MY vCE;

    /* JADX INFO: renamed from: com.bytedance.adsdk.MY.EO.MY.es$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] IlO;
        static final /* synthetic */ int[] MY;

        static {
            int[] iArr = new int[MY.values().length];
            MY = iArr;
            try {
                iArr[MY.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MY[MY.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MY[MY.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[IlO.values().length];
            IlO = iArr2;
            try {
                iArr2[IlO.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                IlO[IlO.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                IlO[IlO.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap IlO() {
            int i2 = AnonymousClass1.IlO[ordinal()];
            return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum MY {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join IlO() {
            int i2 = AnonymousClass1.MY[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public es(String str, com.bytedance.adsdk.MY.EO.IlO.MY my, List<com.bytedance.adsdk.MY.EO.IlO.MY> list, com.bytedance.adsdk.MY.EO.IlO.IlO ilO, com.bytedance.adsdk.MY.EO.IlO.tV tVVar, com.bytedance.adsdk.MY.EO.IlO.MY my2, IlO ilO2, MY my3, float f4, boolean z2) {
        this.IlO = str;
        this.MY = my;
        this.EO = list;
        this.tV = ilO;
        this.Cc = tVVar;
        this.vCE = my2;
        this.Bc = ilO2;
        this.lEW = my3;
        this.DmF = f4;
        this.NV = z2;
    }

    public IlO Bc() {
        return this.Bc;
    }

    public List<com.bytedance.adsdk.MY.EO.IlO.MY> Cc() {
        return this.EO;
    }

    public float DmF() {
        return this.DmF;
    }

    public com.bytedance.adsdk.MY.EO.IlO.tV EO() {
        return this.Cc;
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new AXM(dmF, ilO, this);
    }

    public com.bytedance.adsdk.MY.EO.IlO.IlO MY() {
        return this.tV;
    }

    public boolean NV() {
        return this.NV;
    }

    public MY lEW() {
        return this.lEW;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY tV() {
        return this.vCE;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY vCE() {
        return this.MY;
    }

    public String IlO() {
        return this.IlO;
    }
}
