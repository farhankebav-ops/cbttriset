package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.camera.core.processing.util.a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tl extends vCE {
    public tl(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        this.lEW += 6;
        if (this.rp.zLG()) {
            com.bytedance.sdk.component.adexpress.vCE.IlO ilO = new com.bytedance.sdk.component.adexpress.vCE.IlO(context, this.rp.Bc(), this.rp.Cc(), 1, this.rp.lEW());
            this.ea = ilO;
            ilO.setMaxLines(1);
        } else {
            TextView textView = new TextView(context);
            this.ea = textView;
            textView.setIncludeFontPadding(false);
        }
        this.ea.setTag(Integer.valueOf(getClickArea()));
        addView(this.ea, getWidgetLayoutParams());
    }

    private void EV() {
        if (this.ea instanceof com.bytedance.sdk.component.adexpress.vCE.IlO) {
            String text = getText();
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(text);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.optString(i2));
                }
            } catch (JSONException unused) {
                arrayList.add(text);
            }
            ((com.bytedance.sdk.component.adexpress.vCE.IlO) this.ea).setMaxLines(1);
            ((com.bytedance.sdk.component.adexpress.vCE.IlO) this.ea).setTextColor(this.rp.Bc());
            ((com.bytedance.sdk.component.adexpress.vCE.IlO) this.ea).setTextSize(this.rp.Cc());
            ((com.bytedance.sdk.component.adexpress.vCE.IlO) this.ea).setAnimationText(arrayList);
            ((com.bytedance.sdk.component.adexpress.vCE.IlO) this.ea).setAnimationType(this.rp.ssS());
            ((com.bytedance.sdk.component.adexpress.vCE.IlO) this.ea).setAnimationDuration(this.rp.BS() * 1000);
            ((com.bytedance.sdk.component.adexpress.vCE.IlO) this.ea).IlO();
        }
    }

    private boolean IlO() {
        DynamicRootView dynamicRootView = this.bWL;
        return (dynamicRootView == null || dynamicRootView.getRenderRequest() == null || this.bWL.getRenderRequest().NV() == 4) ? false : true;
    }

    private void NV() {
        int iIlO;
        if (a.B(this.hp, "source") || a.B(this.hp, "title") || a.B(this.hp, "text_star")) {
            int[] iArrMY = com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.MY(this.rp.vCE(), this.rp.Cc(), true);
            int iIlO2 = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), this.rp.MY());
            int iIlO3 = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), this.rp.EO());
            int iIlO4 = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), this.rp.tV());
            int iIlO5 = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), this.rp.IlO());
            int iMin = Math.min(iIlO2, iIlO5);
            if (a.B(this.hp, "source") && (iIlO = ((this.lEW - ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), this.rp.Cc()))) - iIlO2) - iIlO5) > 1 && iIlO <= iMin * 2) {
                int i2 = iIlO / 2;
                this.ea.setPadding(iIlO3, iIlO2 - i2, iIlO4, iIlO5 - (iIlO - i2));
                return;
            }
            int i8 = (((iArrMY[1] + iIlO2) + iIlO5) - this.lEW) - 2;
            if (i8 <= 1) {
                return;
            }
            if (i8 <= iMin * 2) {
                int i9 = i8 / 2;
                this.ea.setPadding(iIlO3, iIlO2 - i9, iIlO4, iIlO5 - (i8 - i9));
            } else if (i8 > iIlO2 + iIlO5) {
                final int i10 = (i8 - iIlO2) - iIlO5;
                this.ea.setPadding(iIlO3, 0, iIlO4, 0);
                if (i10 <= ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), 1.0f)) + 1) {
                    ((TextView) this.ea).setTextSize(this.rp.Cc() - 1.0f);
                } else if (i10 <= (((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), 1.0f)) + 1) * 2) {
                    ((TextView) this.ea).setTextSize(this.rp.Cc() - 2.0f);
                } else {
                    post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.tl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ViewGroup.LayoutParams layoutParams = tl.this.ea.getLayoutParams();
                                tl tlVar = tl.this;
                                layoutParams.height = tlVar.lEW + i10;
                                tlVar.ea.setLayoutParams(layoutParams);
                                tl.this.ea.setTranslationY(-i10);
                                ((ViewGroup) tl.this.ea.getParent()).setClipChildren(false);
                                ((ViewGroup) tl.this.ea.getParent().getParent()).setClipChildren(false);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (iIlO2 > iIlO5) {
                this.ea.setPadding(iIlO3, iIlO2 - (i8 - iMin), iIlO4, iIlO5 - iMin);
            } else {
                this.ea.setPadding(iIlO3, iIlO2 - iMin, iIlO4, iIlO5 - (i8 - iMin));
            }
        }
        if (a.B(this.hp, "fillButton")) {
            this.ea.setTextAlignment(2);
            ((TextView) this.ea).setGravity(17);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        int i2;
        double d8;
        super.DmF();
        if (TextUtils.isEmpty(getText())) {
            this.ea.setVisibility(4);
            return true;
        }
        if (this.rp.zLG()) {
            EV();
            return true;
        }
        ((TextView) this.ea).setText(this.rp.vCE());
        ((TextView) this.ea).setTextDirection(5);
        this.ea.setTextAlignment(this.rp.lEW());
        ((TextView) this.ea).setTextColor(this.rp.Bc());
        ((TextView) this.ea).setTextSize(this.rp.Cc());
        if (this.rp.oeT()) {
            int iVAh = this.rp.vAh();
            if (iVAh > 0) {
                ((TextView) this.ea).setLines(iVAh);
                ((TextView) this.ea).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.ea).setMaxLines(1);
            ((TextView) this.ea).setGravity(17);
            ((TextView) this.ea).setEllipsize(TextUtils.TruncateAt.END);
        }
        com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew = this.hp;
        if (lew != null && lew.NV() != null) {
            if (com.bytedance.sdk.component.adexpress.tV.MY() && IlO() && (a.B(this.hp, "text_star") || a.B(this.hp, "score-count") || a.B(this.hp, "score-count-type-1") || a.B(this.hp, "score-count-type-2"))) {
                setVisibility(8);
                return true;
            }
            if (a.B(this.hp, "score-count") || a.B(this.hp, "score-count-type-2")) {
                try {
                    try {
                        i2 = Integer.parseInt(getText());
                    } catch (Exception unused) {
                    }
                } catch (NumberFormatException unused2) {
                    i2 = -1;
                }
                if (i2 < 0) {
                    if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                        setVisibility(8);
                        return true;
                    }
                    this.ea.setVisibility(0);
                }
                if (TextUtils.equals(this.hp.NV().MY(), "score-count-type-2")) {
                    ((TextView) this.ea).setText(String.format(new DecimalFormat("(###,###,###)").format(i2), Integer.valueOf(i2)));
                    ((TextView) this.ea).setGravity(17);
                    return true;
                }
                IlO((TextView) this.ea, i2, getContext(), "tt_comment_num");
            } else if (a.B(this.hp, "text_star")) {
                try {
                    d8 = Double.parseDouble(getText());
                } catch (Exception unused3) {
                    d8 = -1.0d;
                }
                if (d8 < 0.0d || d8 > 5.0d) {
                    if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                        setVisibility(8);
                        return true;
                    }
                    this.ea.setVisibility(0);
                }
                ((TextView) this.ea).setIncludeFontPadding(false);
                ((TextView) this.ea).setText(String.format("%.1f", Double.valueOf(d8)));
            } else if (TextUtils.equals("privacy-detail", this.hp.NV().MY())) {
                ((TextView) this.ea).setText("Permission list | Privacy policy");
            } else if (a.B(this.hp, "development-name")) {
                ((TextView) this.ea).setText(com.bytedance.sdk.component.utils.pP.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), "tt_text_privacy_development") + getText());
            } else if (a.B(this.hp, "app-version")) {
                ((TextView) this.ea).setText(com.bytedance.sdk.component.utils.pP.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), "tt_text_privacy_app_version") + getText());
            } else {
                ((TextView) this.ea).setText(getText());
            }
            this.ea.setTextAlignment(this.rp.lEW());
            ((TextView) this.ea).setGravity(this.rp.DmF());
            if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                NV();
            }
        }
        return true;
    }

    public String getText() {
        String strVCE = this.rp.vCE();
        if (TextUtils.isEmpty(strVCE)) {
            if (!com.bytedance.sdk.component.adexpress.tV.MY() && a.B(this.hp, "text_star")) {
                strVCE = "5";
            }
            if (!com.bytedance.sdk.component.adexpress.tV.MY() && a.B(this.hp, "score-count")) {
                strVCE = "6870";
            }
        }
        return (a.B(this.hp, "title") || a.B(this.hp, "subtitle")) ? strVCE.replace("\n", "") : strVCE;
    }

    public void IlO(TextView textView, int i2, Context context, String str) {
        textView.setText("(" + String.format(com.bytedance.sdk.component.utils.pP.IlO(context, str), Integer.valueOf(i2)) + ")");
        if (i2 == -1) {
            textView.setVisibility(8);
        }
    }
}
