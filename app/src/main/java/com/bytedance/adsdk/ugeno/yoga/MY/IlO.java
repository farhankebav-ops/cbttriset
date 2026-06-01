package com.bytedance.adsdk.ugeno.yoga.MY;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import com.bytedance.adsdk.ugeno.IlO;
import com.bytedance.adsdk.ugeno.MY.IlO;
import com.bytedance.adsdk.ugeno.yoga.Cc;
import com.bytedance.adsdk.ugeno.yoga.MY.EO;
import com.bytedance.adsdk.ugeno.yoga.NV;
import com.bytedance.adsdk.ugeno.yoga.bWL;
import com.bytedance.adsdk.ugeno.yoga.hp;
import com.bytedance.adsdk.ugeno.yoga.tV;
import com.bytedance.adsdk.ugeno.yoga.vCE;
import com.ironsource.adqualitysdk.sdk.i.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends com.bytedance.adsdk.ugeno.MY.IlO<EO> {
    private com.bytedance.adsdk.ugeno.yoga.IlO Aw;
    private bWL BES;
    private vCE La;
    private NV eDn;
    private Cc eeU;
    private com.bytedance.adsdk.ugeno.yoga.IlO uF;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.yoga.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0039IlO extends IlO.C0032IlO {
        private boolean AK;
        private boolean BS;
        public float DM;
        private boolean HSR;
        public float OOq;
        public int YA;
        public int dY;
        private boolean gQ;
        public int lMM;
        public int mmj;
        public int nvX;
        public int oc;
        private boolean ssS;
        public int tl;
        public float vSq;
        public float wPn;
        private boolean zLG;

        public C0039IlO(com.bytedance.adsdk.ugeno.MY.IlO ilO) {
            super(ilO);
            this.tl = 1;
            this.OOq = 0.0f;
            this.wPn = 1.0f;
            this.oc = com.bytedance.adsdk.ugeno.yoga.IlO.AUTO.IlO();
            this.vSq = -1.0f;
            this.dY = hp.RELATIVE.IlO();
        }

        private void tV() {
            com.bytedance.adsdk.ugeno.MY.IlO ilO = this.pP;
            if (ilO instanceof IlO) {
                if (((IlO) ilO).Ea() == Cc.ROW && this.pP.nvX() == -2 && this.IlO == -1.0f && !this.pP.gQ()) {
                    this.IlO = -2.0f;
                    this.wPn = 1.0f;
                    this.OOq = 1.0f;
                    this.zLG = true;
                    this.vSq = -1.0f;
                }
                if (((IlO) this.pP).Ea() == Cc.COLUMN && this.pP.YA() == -2 && this.MY == -1.0f && !this.pP.gQ()) {
                    this.MY = -2.0f;
                    this.wPn = 1.0f;
                    this.OOq = 1.0f;
                    this.zLG = true;
                    this.vSq = -1.0f;
                }
            }
        }

        public boolean EO() {
            float f4 = this.IlO;
            if (f4 == -1.0f && this.MY == -1.0f) {
                return false;
            }
            return f4 == -2.0f || this.MY == -2.0f;
        }

        @Override // com.bytedance.adsdk.ugeno.MY.IlO.C0032IlO
        /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
        public EO.IlO IlO() {
            tV();
            EO.IlO ilO = new EO.IlO((int) this.IlO, (int) this.MY);
            ilO.rp((int) (this.xF ? this.vCE : this.Cc));
            ilO.bWL((int) (this.AXM ? this.Bc : this.Cc));
            ilO.EV((int) (this.oeT ? this.lEW : this.Cc));
            ilO.hp((int) (this.vAh ? this.DmF : this.Cc));
            ilO.IlO(this.tl);
            ilO.Cc(this.oc);
            ilO.MY(this.OOq);
            ilO.EO(this.wPn);
            ilO.zPa(this.EO);
            ilO.cl(this.tV);
            if (this.zLG) {
                ilO.tV(this.vSq);
            }
            ilO.vCE(this.dY);
            if (this.BS) {
                ilO.Bc(this.lMM);
            }
            if (this.ssS) {
                ilO.DmF(this.nvX);
            }
            if (this.gQ) {
                ilO.lEW(this.YA);
            }
            if (this.HSR) {
                ilO.NV(this.mmj);
            }
            if (this.AK && EO()) {
                float f4 = this.DM;
                if (f4 > 0.0f) {
                    ilO.ea(f4);
                    ilO.EO(0.0f);
                    ilO.MY(0.0f);
                }
            }
            return ilO;
        }

        @Override // com.bytedance.adsdk.ugeno.MY.IlO.C0032IlO
        public String toString() {
            StringBuilder sb = new StringBuilder("LayoutParams{mOrder=");
            sb.append(this.tl);
            sb.append(", mFlexGrow=");
            sb.append(this.OOq);
            sb.append(", mFlexShrink=");
            sb.append(this.wPn);
            sb.append(", mAlignSelf=");
            sb.append(this.oc);
            sb.append(", mFlexBasis=");
            sb.append(this.vSq);
            sb.append(", mPosition=");
            sb.append(this.dY);
            sb.append(", mTop=");
            sb.append(this.lMM);
            sb.append(", mBottom=");
            sb.append(this.nvX);
            sb.append(", mLeft=");
            sb.append(this.YA);
            sb.append(", mRight=");
            return a0.c(sb, this.mmj, '}');
        }

        @Override // com.bytedance.adsdk.ugeno.MY.IlO.C0032IlO
        public void IlO(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.IlO(context, str, str2);
            str.getClass();
            switch (str) {
                case "flexBasis":
                    this.zLG = true;
                    float fIlO = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, -1.0f);
                    this.vSq = fIlO;
                    this.vSq = lEW.IlO(context, fIlO);
                    break;
                case "bottom":
                    this.ssS = true;
                    this.nvX = (int) lEW.IlO(context, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0));
                    break;
                case "top":
                    this.BS = true;
                    this.lMM = (int) lEW.IlO(context, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0));
                    break;
                case "left":
                    this.gQ = true;
                    this.YA = (int) lEW.IlO(context, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0));
                    break;
                case "order":
                    this.tl = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 1);
                    break;
                case "ratio":
                    this.AK = true;
                    this.DM = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                    break;
                case "right":
                    this.HSR = true;
                    this.mmj = (int) lEW.IlO(context, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0));
                    break;
                case "position":
                    this.dY = hp.IlO(str2).IlO();
                    break;
                case "flexShrink":
                    this.wPn = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 1.0f);
                    break;
                case "flexGrow":
                    this.OOq = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                    break;
                case "alignSelf":
                    this.oc = com.bytedance.adsdk.ugeno.yoga.IlO.IlO(str2).IlO();
                    break;
            }
        }
    }

    public IlO(Context context) {
        super(context);
        this.eeU = Cc.ROW;
        this.BES = bWL.NO_WRAP;
        this.La = vCE.FLEX_START;
        com.bytedance.adsdk.ugeno.yoga.IlO ilO = com.bytedance.adsdk.ugeno.yoga.IlO.STRETCH;
        this.Aw = ilO;
        this.uF = ilO;
    }

    public Cc Ea() {
        return this.eeU;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void hp() {
        if (this.dY) {
            this.eDn.MY(tV.ALL, this.tl);
        }
        if (this.lMM) {
            this.eDn.MY(tV.LEFT, this.OOq);
        }
        if (this.nvX) {
            this.eDn.MY(tV.RIGHT, this.wPn);
        }
        if (this.YA) {
            this.eDn.MY(tV.TOP, this.oc);
        }
        if (this.mmj) {
            this.eDn.MY(tV.BOTTOM, this.vSq);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void tl() {
        ImageView.ScaleType scaleType;
        if (this.gQ) {
            com.bytedance.adsdk.ugeno.Cc.IlO().MY().IlO(this.DmF, this.zLG, new IlO.InterfaceC0030IlO() { // from class: com.bytedance.adsdk.ugeno.yoga.MY.IlO.1
                @Override // com.bytedance.adsdk.ugeno.IlO.InterfaceC0030IlO
                public void IlO(Bitmap bitmap) {
                    final Bitmap bitmapIlO;
                    if (bitmap == null || (bitmapIlO = lEW.IlO(((com.bytedance.adsdk.ugeno.MY.EO) IlO.this).MY, bitmap, (int) ((com.bytedance.adsdk.ugeno.MY.EO) IlO.this).ssS)) == null) {
                        return;
                    }
                    lEW.IlO(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.MY.IlO.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IlO.this.IlO(new BitmapDrawable(bitmapIlO));
                        }
                    });
                }
            });
            return;
        }
        ImageView imageView = new ImageView(this.MY);
        com.bytedance.adsdk.ugeno.Cc.IlO().MY().IlO(this.DmF, this.zLG, imageView, this.Cc.getWidth(), this.Cc.getHeight());
        if (!this.HSR || (scaleType = this.BS) == ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView.setScaleType(scaleType);
        }
        EO.IlO ilO = new EO.IlO(-1, -1);
        ilO.vCE(hp.ABSOLUTE.IlO());
        T t3 = this.Cc;
        if (t3 instanceof EO) {
            ((EO) t3).addView(imageView, 0, ilO);
            IlO(imageView);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public EO IlO() {
        EO eo = new EO(this.MY);
        eo.IlO(this);
        this.eDn = eo.getYogaNode();
        return eo;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        this.eDn.IlO(this.eeU);
        this.eDn.IlO(this.BES);
        this.eDn.IlO(this.La);
        this.eDn.IlO(this.Aw);
        this.eDn.EO(this.uF);
        this.eDn.IlO(true);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    /* JADX INFO: renamed from: tV, reason: merged with bridge method [inline-methods] */
    public C0039IlO NV() {
        return new C0039IlO(this);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(Drawable drawable) {
        ImageView.ScaleType scaleType;
        ImageView imageView = new ImageView(this.MY);
        imageView.setImageDrawable(drawable);
        if (this.HSR && (scaleType = this.BS) != ImageView.ScaleType.FIT_XY) {
            imageView.setScaleType(scaleType);
        } else {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        EO.IlO ilO = new EO.IlO(-1, -1);
        ilO.vCE(hp.ABSOLUTE.IlO());
        T t3 = this.Cc;
        if (t3 instanceof EO) {
            ((EO) t3).addView(imageView, 0, ilO);
            IlO(imageView);
        }
    }

    private void IlO(final ImageView imageView) {
        this.Cc.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.yoga.MY.IlO.2
            @Override // java.lang.Runnable
            public void run() {
                NV nvIlO;
                if (((com.bytedance.adsdk.ugeno.MY.EO) IlO.this).Cc == null || (nvIlO = ((EO) ((com.bytedance.adsdk.ugeno.MY.EO) IlO.this).Cc).IlO(imageView)) == null) {
                    return;
                }
                nvIlO.tV(((com.bytedance.adsdk.ugeno.MY.EO) IlO.this).Cc.getWidth());
                nvIlO.vCE(((com.bytedance.adsdk.ugeno.MY.EO) IlO.this).Cc.getHeight());
                ((com.bytedance.adsdk.ugeno.MY.EO) IlO.this).Cc.requestLayout();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo) {
        super.IlO(eo);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO
    public void IlO(com.bytedance.adsdk.ugeno.MY.EO eo, ViewGroup.LayoutParams layoutParams) {
        if (eo == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.MY.IlO) this).IlO.add(eo);
        View viewEV = eo.EV();
        if (viewEV != null) {
            ((EO) this.Cc).addView(viewEV, layoutParams);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        super.IlO(str, str2);
        str.getClass();
        switch (str) {
            case "alignItems":
                this.Aw = com.bytedance.adsdk.ugeno.yoga.IlO.IlO(str2);
                break;
            case "flexDirection":
                this.eeU = Cc.IlO(str2);
                break;
            case "alignContent":
                this.uF = com.bytedance.adsdk.ugeno.yoga.IlO.IlO(str2);
                break;
            case "flexWrap":
                this.BES = bWL.IlO(str2);
                break;
            case "justifyContent":
                this.La = vCE.IlO(str2);
                break;
        }
    }
}
