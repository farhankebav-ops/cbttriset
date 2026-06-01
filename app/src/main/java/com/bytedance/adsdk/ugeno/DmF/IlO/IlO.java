package com.bytedance.adsdk.ugeno.DmF.IlO;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Bc.IlO;
import com.bytedance.adsdk.ugeno.Bc.lEW;
import com.bytedance.adsdk.ugeno.Bc.tV;
import com.bytedance.adsdk.ugeno.Cc;
import com.bytedance.adsdk.ugeno.DmF.vCE.MY;
import com.bytedance.adsdk.ugeno.IlO;
import com.bytedance.adsdk.ugeno.MY.EO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends MY {
    private String Aw;
    private String BES;
    private String La;
    private IlO.C0026IlO NST;
    private boolean XvI;
    private int aP;
    private boolean ao;
    private int eDn;
    private String uF;

    public IlO(Context context) {
        super(context);
        this.La = "row";
    }

    private void tV() {
        if (TextUtils.isEmpty(this.BES)) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setCompoundDrawables(null, null, null, null);
        if (!this.BES.startsWith("local://")) {
            Cc.IlO().MY().IlO(this.DmF, this.BES, new IlO.InterfaceC0030IlO() { // from class: com.bytedance.adsdk.ugeno.DmF.IlO.IlO.1
                @Override // com.bytedance.adsdk.ugeno.IlO.InterfaceC0030IlO
                public void IlO(final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    lEW.IlO(new Runnable() { // from class: com.bytedance.adsdk.ugeno.DmF.IlO.IlO.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IlO.this.MY(new BitmapDrawable(((EO) IlO.this).MY.getResources(), bitmap));
                        }
                    });
                }
            });
            return;
        }
        try {
            String strReplace = this.BES.replace("local://", "");
            Context context = this.MY;
            MY(lEW.IlO(context, tV.IlO(context, strReplace)));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void BS() {
        super.BS();
        if (this.ao) {
            ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setTextColor(this.aP);
        }
        if (this.XvI) {
            if (this.tf) {
                IlO(this.NST);
            } else {
                tV(this.eDn);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DmF.vCE.MY, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
        tV();
        ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void ssS() {
        super.ssS();
        if (this.ao) {
            ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setTextColor(((MY) this).eeU);
        }
        if (this.XvI) {
            if (this.tf) {
                IlO(this.tN);
            } else {
                tV(this.DM);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DmF.vCE.MY, com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        super.IlO(str, str2);
        str.getClass();
        switch (str) {
            case "direction":
                this.La = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.aP = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
                this.ao = true;
                break;
            case "image":
                this.BES = str2;
                break;
            case "highlightImage":
                this.Aw = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.Bc.IlO.EO(str2)) {
                    this.tf = true;
                    this.NST = com.bytedance.adsdk.ugeno.Bc.IlO.MY(str2);
                } else {
                    this.eDn = com.bytedance.adsdk.ugeno.Bc.IlO.IlO(str2);
                    this.tf = false;
                }
                this.XvI = true;
                break;
            case "highlightBackgroundImage":
                this.uF = str2;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void MY(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        String str = this.La;
        switch (str.hashCode()) {
            case -1781065991:
                if (str.equals("column_reverse")) {
                    ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
                    return;
                }
                break;
            case -1354837162:
                if (str.equals("column")) {
                    ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
                    return;
                }
                break;
            case -207799939:
                if (str.equals("row_reverse")) {
                    ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                    return;
                }
                break;
            case 113114:
                str.equals("row");
                break;
        }
        ((com.bytedance.adsdk.ugeno.DmF.vCE.IlO) this.Cc).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
