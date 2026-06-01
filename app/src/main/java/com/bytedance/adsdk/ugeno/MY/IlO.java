package com.bytedance.adsdk.ugeno.MY;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO<E extends ViewGroup> extends EO {
    protected List<EO<View>> IlO;

    public IlO(Context context) {
        this(context, null);
    }

    public List<EO<View>> DmF() {
        return this.IlO;
    }

    public void IlO(EO eo) {
        if (eo == null) {
            return;
        }
        this.IlO.add(eo);
        View viewEV = eo.EV();
        if (viewEV != null) {
            ((ViewGroup) this.Cc).addView(viewEV);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
    }

    public C0032IlO NV() {
        return new C0032IlO(this);
    }

    public IlO(Context context, IlO ilO) {
        super(context, ilO);
        this.IlO = new ArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public EO MY(String str) {
        EO<T> eoTV;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.rp)) {
            return this;
        }
        for (EO<View> eo : this.IlO) {
            if (eo != null && (eoTV = eo.tV(str)) != 0) {
                return eoTV;
            }
        }
        return null;
    }

    public void IlO(EO eo, ViewGroup.LayoutParams layoutParams) {
        if (eo == null) {
            return;
        }
        this.IlO.add(eo);
        View viewEV = eo.EV();
        if (viewEV != null) {
            ((ViewGroup) this.Cc).addView(viewEV, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public EO IlO(String str) {
        EO<T> EO;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, this.EV)) {
            return this;
        }
        for (EO<View> eo : this.IlO) {
            if (eo != null && (EO = eo.EO(str)) != 0) {
                return EO;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0032IlO {
        protected boolean AXM;
        protected float Bc;
        protected float Cc;
        protected float DmF;
        protected float EV;
        protected float NV;
        protected float bWL;
        protected boolean cL;
        protected boolean cl;
        protected boolean ea;
        protected boolean es;
        protected float hp;
        protected ViewGroup.LayoutParams kBB;
        protected float lEW;
        protected boolean oeT;
        protected IlO pP;
        protected float rp;
        protected boolean vAh;
        protected float vCE;
        protected boolean xF;
        protected boolean zPa;
        protected float IlO = -2.0f;
        protected float MY = -2.0f;
        protected float EO = 0.0f;
        protected float tV = 0.0f;

        public C0032IlO(IlO ilO) {
            this.pP = ilO;
        }

        public void IlO(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            str.getClass();
            switch (str) {
                case "paddingLeft":
                    this.EV = lEW.IlO(context, str2);
                    this.zPa = true;
                    break;
                case "minWidth":
                    this.EO = lEW.IlO(context, str2);
                    break;
                case "height":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.MY = -1.0f;
                        break;
                    } else {
                        if (!TextUtils.equals(str2, "wrap_content")) {
                            this.MY = lEW.IlO(context, str2);
                        } else {
                            this.MY = -2.0f;
                        }
                        break;
                    }
                    break;
                case "margin":
                    this.Cc = lEW.IlO(context, str2);
                    break;
                case "marginTop":
                    this.lEW = lEW.IlO(context, str2);
                    this.oeT = true;
                    break;
                case "padding":
                    this.NV = lEW.IlO(context, str2);
                    this.ea = true;
                    break;
                case "marginBottom":
                    this.DmF = lEW.IlO(context, str2);
                    this.vAh = true;
                    break;
                case "minHeight":
                    this.tV = lEW.IlO(context, str2);
                    break;
                case "paddingTop":
                    this.rp = lEW.IlO(context, str2);
                    this.cL = true;
                    break;
                case "width":
                    if (TextUtils.equals(str2, "match_parent")) {
                        this.IlO = -1.0f;
                        break;
                    } else {
                        if (!TextUtils.equals(str2, "wrap_content")) {
                            this.IlO = lEW.IlO(context, str2);
                        } else {
                            this.IlO = -2.0f;
                        }
                        break;
                    }
                    break;
                case "paddingBottom":
                    this.bWL = lEW.IlO(context, str2);
                    this.es = true;
                    break;
                case "paddingRight":
                    this.hp = lEW.IlO(context, str2);
                    this.cl = true;
                    break;
                case "marginRight":
                    this.Bc = lEW.IlO(context, str2);
                    this.AXM = true;
                    break;
                case "marginLeft":
                    this.vCE = lEW.IlO(context, str2);
                    this.xF = true;
                    break;
            }
        }

        public String toString() {
            return "LayoutParams{mWidth=" + this.IlO + ", mHeight=" + this.MY + ", mMargin=" + this.Cc + ", mMarginLeft=" + this.vCE + ", mMarginRight=" + this.Bc + ", mMarginTop=" + this.lEW + ", mMarginBottom=" + this.DmF + ", mParams=" + this.kBB + '}';
        }

        public ViewGroup.LayoutParams IlO() {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams((int) this.IlO, (int) this.MY);
            marginLayoutParams.leftMargin = (int) (this.xF ? this.vCE : this.Cc);
            marginLayoutParams.rightMargin = (int) (this.AXM ? this.Bc : this.Cc);
            marginLayoutParams.topMargin = (int) (this.oeT ? this.lEW : this.Cc);
            marginLayoutParams.bottomMargin = (int) (this.vAh ? this.DmF : this.Cc);
            return marginLayoutParams;
        }
    }
}
