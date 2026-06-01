package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.wPn;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends com.bytedance.sdk.openadsdk.core.Cc.Bc {
    private boolean Cc;
    private lEW EO;
    private zPa IlO;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW MY;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW tV;
    private boolean vCE;

    public Bc(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (IlO()) {
            MY();
        }
    }

    public boolean IlO() {
        return true;
    }

    public void MY() {
        if (this.Cc) {
            return;
        }
        this.Cc = true;
        Context context = getContext();
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        zPa zpa = new zPa(context);
        this.IlO = zpa;
        zpa.setId(520093745);
        int iMY = BS.MY(context, 64.0f);
        this.IlO.setLayoutParams(new RelativeLayout.LayoutParams(iMY, iMY));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.MY = lew;
        lew.setId(520093746);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(BS.MY(context, 219.0f), -2);
        layoutParams2.topMargin = BS.MY(context, 16.0f);
        this.MY.setLayoutParams(layoutParams2);
        this.MY.setEllipsize(TextUtils.TruncateAt.END);
        this.MY.setGravity(17);
        this.MY.setMaxWidth(BS.MY(context, 150.0f));
        this.MY.setMaxLines(2);
        this.MY.setTextColor(-1);
        this.MY.setTextSize(1, 16.0f);
        lEW lew2 = new lEW(context);
        this.EO = lew2;
        lew2.setId(520093748);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(BS.MY(context, 219.0f), BS.MY(context, 6.0f));
        layoutParams3.topMargin = BS.MY(context, 24.0f);
        this.EO.setLayoutParams(layoutParams3);
        this.tV = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(BS.MY(context, 138.0f), BS.MY(context, 42.0f));
        layoutParams4.topMargin = BS.MY(context, 48.0f);
        this.tV.setLayoutParams(layoutParams4);
        this.tV.setTextColor(-1);
        this.tV.setTextSize(16.0f);
        this.tV.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(2, -1);
        gradientDrawable.setCornerRadius(layoutParams4.height / 2);
        this.tV.setBackground(gradientDrawable);
        linearLayout.addView(this.IlO);
        linearLayout.addView(this.MY);
        linearLayout.addView(this.EO);
        linearLayout.addView(this.tV);
        addView(linearLayout);
    }

    @Nullable
    public com.bytedance.sdk.openadsdk.core.Cc.lEW getDownloadButton() {
        return this.tV;
    }

    @Nullable
    public lEW getLoadingProgressBar() {
        return this.EO;
    }

    public void setProgress(int i2) {
        lEW lew = this.EO;
        if (lew != null) {
            lew.setProgress(i2);
        }
    }

    public void IlO(oeT oet, int i2) {
        if (!this.Cc || oet == null || this.vCE) {
            return;
        }
        this.vCE = true;
        boolean zNm = oet.nm();
        if (zNm || oet.HTA() == null || TextUtils.isEmpty(oet.HTA().IlO())) {
            this.IlO.setVisibility(8);
        } else {
            try {
                com.bytedance.sdk.openadsdk.DmF.tV.IlO(oet.HTA()).EO(1).IlO(new com.bytedance.sdk.openadsdk.DmF.MY(oet, oet.HTA().IlO(), new wPn(this.IlO)));
            } catch (Throwable unused) {
                this.IlO.setVisibility(8);
            }
        }
        if (zNm) {
            this.MY.setText("Loading");
        } else if (TextUtils.isEmpty(oet.dm())) {
            this.MY.setVisibility(8);
        } else {
            this.MY.setText(oet.dm());
        }
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = this.tV;
        if (lew != null) {
            lew.setText(oet.aa());
        }
    }
}
