package com.bytedance.adsdk.ugeno.Cc;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.Cc.Cc;
import com.bytedance.adsdk.ugeno.MY.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends com.bytedance.adsdk.ugeno.MY.IlO<Cc> {
    private int Aw;
    private int BES;
    private int La;
    private int eeU;
    private int uF;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO extends IlO.C0032IlO {
        public float OOq;
        public int YA;
        public int dY;
        public int lMM;
        public int nvX;
        public int oc;
        public int tl;
        public float vSq;
        public float wPn;

        public IlO(com.bytedance.adsdk.ugeno.MY.IlO ilO) {
            super(ilO);
            this.tl = 1;
            this.OOq = 0.0f;
            this.wPn = 0.0f;
            this.oc = -1;
            this.vSq = -1.0f;
            this.dY = -1;
            this.lMM = -1;
            this.nvX = ViewCompat.MEASURED_SIZE_MASK;
            this.YA = ViewCompat.MEASURED_SIZE_MASK;
        }

        private int Cc(String str) {
            str.getClass();
            switch (str) {
                case "stretch":
                    return 4;
                case "baseline":
                    return 3;
                case "center":
                    return 2;
                case "flex_start":
                    return 0;
                case "flex_end":
                    return 1;
                default:
                    return -1;
            }
        }

        private float EO(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float MY(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float tV(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return -1.0f;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.MY.IlO.C0032IlO
        public String toString() {
            return "LayoutParams{mWidth=" + this.IlO + ", mHeight=" + this.MY + ", mMargin=" + this.Cc + ", mMarginLeft=" + this.vCE + ", mMarginRight=" + this.Bc + ", mMarginTop=" + this.lEW + ", mMarginBottom=" + this.DmF + ", mParams=" + this.kBB + ", mOrder=" + this.tl + ", mFlexGrow=" + this.OOq + ", mFlexShrink=" + this.wPn + ", mAlignSelf=" + this.oc + ", mFlexBasisPercent=" + this.vSq + ", mMinWidth=" + this.dY + ", mMinHeight=" + this.lMM + ", mMaxWidth=" + this.nvX + ", mMaxHeight=" + this.YA + "} " + super.toString();
        }

        @Override // com.bytedance.adsdk.ugeno.MY.IlO.C0032IlO
        public void IlO(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.IlO(context, str, str2);
            str.getClass();
            switch (str) {
                case "flexBasisPercent":
                    this.vSq = tV(str2);
                    break;
                case "order":
                    this.tl = IlO(str2);
                    break;
                case "flexShrink":
                    this.wPn = EO(str2);
                    break;
                case "flexGrow":
                    this.OOq = MY(str2);
                    break;
                case "alignSelf":
                    this.oc = Cc(str2);
                    break;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.MY.IlO.C0032IlO
        /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
        public Cc.IlO IlO() {
            Cc.IlO ilO = new Cc.IlO((int) this.IlO, (int) this.MY);
            ((ViewGroup.MarginLayoutParams) ilO).leftMargin = (int) this.vCE;
            ((ViewGroup.MarginLayoutParams) ilO).rightMargin = (int) this.Bc;
            ((ViewGroup.MarginLayoutParams) ilO).topMargin = (int) this.lEW;
            ((ViewGroup.MarginLayoutParams) ilO).bottomMargin = (int) this.DmF;
            ilO.EO(this.tl);
            ilO.tV(this.oc);
            ilO.IlO(this.OOq);
            ilO.MY(this.wPn);
            ilO.EO(this.vSq);
            return ilO;
        }

        private int IlO(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 1;
            }
        }
    }

    public vCE(Context context) {
        super(context);
    }

    private int DmF(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int EV(String str) {
        switch (str.hashCode()) {
            case -1881872635:
                str.equals("stretch");
                return 5;
            case -1364013995:
                return str.equals("center") ? 2 : 5;
            case -932331738:
                return str.equals("space_around") ? 4 : 5;
            case 1384876188:
                return str.equals("flex_start") ? 0 : 5;
            case 1682480591:
                return str.equals("space_between") ? 3 : 5;
            case 1744442261:
                return str.equals("flex_end") ? 1 : 5;
            default:
                return 5;
        }
    }

    private int lEW(String str) {
        str.getClass();
        return !str.equals("wrap") ? 0 : 1;
    }

    public int Bc(String str) {
        str.getClass();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public Cc IlO() {
        Cc cc = new Cc(this.MY);
        cc.IlO(this);
        return cc;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        ((Cc) this.Cc).setFlexDirection(this.eeU);
        ((Cc) this.Cc).setFlexWrap(this.BES);
        ((Cc) this.Cc).setJustifyContent(this.La);
        ((Cc) this.Cc).setAlignItems(this.Aw);
        ((Cc) this.Cc).setAlignContent(this.uF);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    public IlO.C0032IlO NV() {
        return new IlO(this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int NV(String str) {
        switch (str.hashCode()) {
            case -1881872635:
                str.equals("stretch");
                return 4;
            case -1720785339:
                return str.equals("baseline") ? 3 : 4;
            case -1364013995:
                return str.equals("center") ? 2 : 4;
            case 1384876188:
                return str.equals("flex_start") ? 0 : 4;
            case 1744442261:
                return str.equals("flex_end") ? 1 : 4;
            default:
                return 4;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.IlO(str, str2);
        str.getClass();
        switch (str) {
            case "alignItems":
                this.Aw = NV(str2);
                break;
            case "flexDirection":
                this.eeU = Bc(str2);
                break;
            case "alignContent":
                this.uF = EV(str2);
                break;
            case "flexWrap":
                this.BES = lEW(str2);
                break;
            case "justifyContent":
                this.La = DmF(str2);
                break;
        }
    }
}
