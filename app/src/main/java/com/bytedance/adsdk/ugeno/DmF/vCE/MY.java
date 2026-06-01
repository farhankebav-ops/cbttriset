package com.bytedance.adsdk.ugeno.DmF.vCE;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import com.bytedance.adsdk.ugeno.MY.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends EO<IlO> {
    private int Aw;
    private int BC;
    private float BES;
    private float CQo;
    private float Fv;
    private float IRy;
    protected String IlO;
    private float KS;
    private int La;
    private int NST;

    @Deprecated
    private float Os;

    @Deprecated
    private float QfH;
    private float XvI;

    @Deprecated
    private TextUtils.TruncateAt aP;
    private TextUtils.TruncateAt ao;
    private int eDn;
    protected int eeU;
    private float qyG;
    private int uF;
    private boolean xJ;

    public MY(Context context) {
        super(context);
        this.eeU = ViewCompat.MEASURED_STATE_MASK;
        this.BES = 12.0f;
        this.Aw = Integer.MAX_VALUE;
        this.eDn = GravityCompat.START;
        this.ao = TextUtils.TruncateAt.END;
        this.XvI = -1.0f;
        this.IRy = 400.0f;
    }

    private void DmF() {
        float f4 = this.XvI;
        if (f4 <= 3.0f) {
            ((IlO) this.Cc).setLineSpacing(0.0f, f4);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(lEW.IlO(this.MY, (f4 - (this.BES * 1.2f)) / 2.0f));
            int paddingTop = ((IlO) this.Cc).getPaddingTop() + iRound;
            int paddingBottom = ((IlO) this.Cc).getPaddingBottom() + iRound;
            IlO ilO = (IlO) this.Cc;
            ilO.setPadding(ilO.getPaddingLeft(), paddingTop, ((IlO) this.Cc).getPaddingRight(), paddingBottom);
            ((IlO) this.Cc).setLineHeight(Math.round(lEW.IlO(this.MY, this.XvI)));
        }
    }

    private int EV(String str) {
        str.getClass();
        switch (str) {
            case "center":
                return 17;
            case "center_vertical":
                return 16;
            case "left":
                return 3;
            case "right":
                return 5;
            case "center_horizontal":
                return 1;
            default:
                return 3;
        }
    }

    private int NV(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode == -1178781136) {
            return str.equals("italic") ? 2 : 0;
        }
        if (iHashCode != -1039745817) {
            return (iHashCode == 3029637 && str.equals("bold")) ? 1 : 0;
        }
        str.equals("normal");
        return 0;
    }

    private TextUtils.TruncateAt lEW(String str) {
        str.getClass();
        switch (str) {
            case "center":
                this.aP = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.aP = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.aP = TextUtils.TruncateAt.START;
                break;
            default:
                this.aP = null;
                break;
        }
        return this.aP;
    }

    private int rp(String str) {
        str.getClass();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }

    private void tV() {
        ((IlO) this.Cc).setLineSpacing(0.0f, this.XvI);
    }

    public void Bc(String str) {
        this.IlO = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals("null", str)) {
            this.IlO = "";
        }
        ((IlO) this.Cc).setText(this.IlO);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    /* JADX INFO: renamed from: EO, reason: merged with bridge method [inline-methods] */
    public IlO IlO() {
        IlO ilO = new IlO(this.MY);
        ilO.IlO(this);
        return ilO;
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        if (TextUtils.equals("null", this.IlO)) {
            this.IlO = "";
        }
        Bc(this.IlO);
        ((IlO) this.Cc).setTextSize(1, this.BES);
        ((IlO) this.Cc).setTextColor(this.eeU);
        ((IlO) this.Cc).setLines(this.uF);
        ((IlO) this.Cc).setMaxLines(this.Aw);
        ((IlO) this.Cc).setGravity(this.eDn);
        ((IlO) this.Cc).setIncludeFontPadding(false);
        IlO(this.NST);
        if (oc()) {
            IlO(this.ao);
        } else {
            IlO(this.aP);
        }
        if (this.XvI > 0.0f) {
            if (oc()) {
                DmF();
            } else {
                tV();
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        ((IlO) this.Cc).setBreakStrategy(0);
        if (!oc()) {
            ((IlO) this.Cc).setShadowLayer(this.qyG, this.QfH, this.Os, this.BC);
        } else if (this.xJ) {
            if (this.qyG <= 0.0f) {
                this.qyG = 1.0E-5f;
            }
            ((IlO) this.Cc).setShadowLayer(this.qyG, this.KS, this.CQo, this.BC);
        }
        int i8 = this.La;
        if (i8 == 1) {
            ((IlO) this.Cc).setTypeface(Typeface.DEFAULT, i8);
        } else if (i2 >= 28) {
            Typeface typeface = Typeface.DEFAULT;
            ((IlO) this.Cc).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.IRy, i8 == 2));
        } else if (this.IRy >= 500.0f) {
            ((IlO) this.Cc).setTypeface(Typeface.DEFAULT, 1);
        }
        if (lEW.IlO(this.MY, this.BES) > 0.0f) {
            ((IlO) this.Cc).setLetterSpacing(this.Fv / lEW.IlO(this.MY, this.BES));
        }
    }

    public void IlO(int i2) {
        this.NST = i2;
        if (i2 == Integer.MAX_VALUE) {
            return;
        }
        ((IlO) this.Cc).setPaintFlags(i2);
    }

    public void IlO(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((IlO) this.Cc).setEllipsize(truncateAt);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.IlO(str, str2);
        str.getClass();
        switch (str) {
            case "shadowRadius":
            case "shadowBlur":
                this.qyG = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "shadowColor":
                this.BC = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
                this.xJ = true;
                break;
            case "shadowOffsetX":
                this.KS = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "shadowOffsetY":
                this.CQo = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
            case "textAlign":
                this.eDn = EV(str2);
                break;
            case "textColor":
                this.eeU = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
                break;
            case "textStyle":
                this.La = NV(str2);
                break;
            case "textSize":
                this.BES = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "textDecoration":
                this.NST = rp(str2);
                break;
            case "shadowDx":
                this.QfH = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "shadowDy":
                this.Os = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f);
                break;
            case "fontWeight":
                float fIlO = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, -1.0f);
                this.IRy = fIlO;
                if (fIlO < 1.0f || fIlO > 1000.0f) {
                    this.IRy = 400.0f;
                    break;
                }
                break;
            case "lineHeight":
                this.XvI = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 1.0f);
                break;
            case "text":
                this.IlO = str2;
                break;
            case "lines":
                this.uF = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0);
                break;
            case "ellipsis":
                this.ao = DmF(str2);
                break;
            case "maxLines":
                int iIlO = com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, Integer.MAX_VALUE);
                this.Aw = iIlO > 0 ? iIlO : Integer.MAX_VALUE;
                break;
            case "ellipsize":
                this.aP = lEW(str2);
                break;
            case "letterSpacing":
                this.Fv = lEW.IlO(this.MY, com.bytedance.adsdk.ugeno.Bc.EO.IlO(str2, 0.0f));
                break;
        }
    }

    private TextUtils.TruncateAt DmF(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }
}
