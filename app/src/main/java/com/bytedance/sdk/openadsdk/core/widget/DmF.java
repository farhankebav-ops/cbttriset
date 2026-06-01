package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends FrameLayout {
    private com.bytedance.sdk.openadsdk.core.Cc.lEW Bc;
    private TextView Cc;
    private String DmF;
    private TextView EO;
    private boolean IlO;
    private zPa MY;
    private com.bytedance.sdk.openadsdk.core.MY.IlO NV;
    private oeT lEW;
    private ea tV;
    private PAGLogoView vCE;

    public DmF(@NonNull Context context) {
        super(context);
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.zPa.uI);
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.MY.IlO ilO) {
        this.NV = ilO;
        TextView textView = this.Cc;
        if (textView != null) {
            textView.setOnClickListener(ilO);
            this.Cc.setOnTouchListener(this.NV);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            IlO();
        }
    }

    private void MY() {
        Context context = getContext();
        boolean z2 = this.lEW.BES() == 1;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setGravity(1);
        cc.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = z2 ? new FrameLayout.LayoutParams(-1, -2) : new FrameLayout.LayoutParams(BS.MY(context, 327.0f), -2);
        layoutParams.gravity = 17;
        int iMY = BS.MY(context, 24.0f);
        layoutParams.rightMargin = iMY;
        layoutParams.leftMargin = iMY;
        addView(cc, layoutParams);
        zPa zpa = new zPa(context);
        this.MY = zpa;
        zpa.setBackgroundColor(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(BS.MY(context, 80.0f), BS.MY(context, 80.0f));
        layoutParams2.bottomMargin = BS.MY(context, 12.0f);
        cc.addView(this.MY, layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.EO = lew;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew.setEllipsize(truncateAt);
        this.EO.setGravity(17);
        this.EO.setMaxLines(2);
        this.EO.setMaxWidth(BS.MY(context, 180.0f));
        this.EO.setTextColor(-1);
        this.EO.setTextSize(2, 24.0f);
        cc.addView(this.EO, new LinearLayout.LayoutParams(-1, -2));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.Bc = lew2;
        lew2.setEllipsize(truncateAt);
        this.Bc.setGravity(17);
        this.Bc.setMaxLines(2);
        this.Bc.setTextColor(Color.parseColor("#BFFFFFFF"));
        this.Bc.setTextSize(2, 16.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = BS.MY(context, 8.0f);
        cc.addView(this.Bc, layoutParams3);
        this.tV = new ea(context, true);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, BS.MY(context, 16.0f));
        layoutParams4.topMargin = BS.MY(context, 12.0f);
        this.tV.setVisibility(8);
        cc.addView(this.tV, layoutParams4);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.Cc = lew3;
        lew3.setId(520093707);
        this.Cc.setGravity(17);
        this.Cc.setText(pP.IlO(context, "tt_video_download_apk"));
        this.Cc.setTextColor(-1);
        this.Cc.setTextSize(2, 16.0f);
        this.Cc.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_reward_full_video_backup_btn_bg"));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, BS.MY(context, 44.0f));
        layoutParams5.topMargin = BS.MY(context, 54.0f);
        cc.addView(this.Cc, layoutParams5);
        this.vCE = PAGLogoView.createPAGLogoViewByMaterial(context, this.lEW);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, BS.MY(context, 14.0f));
        layoutParams6.gravity = 8388691;
        layoutParams6.leftMargin = BS.MY(context, 18.0f);
        if (z2) {
            layoutParams6.bottomMargin = BS.MY(context, 61.0f);
        } else {
            layoutParams6.bottomMargin = BS.MY(context, 24.0f);
        }
        addView(this.vCE, layoutParams6);
    }

    public void IlO(oeT oet, String str, com.bytedance.sdk.openadsdk.core.MY.IlO ilO) {
        this.lEW = oet;
        this.DmF = str;
        this.NV = ilO;
    }

    private void IlO() {
        if (this.IlO) {
            return;
        }
        this.IlO = true;
        MY();
        this.Cc.setOnClickListener(this.NV);
        this.Cc.setOnTouchListener(this.NV);
        String strAa = this.lEW.aa();
        if (!TextUtils.isEmpty(strAa)) {
            this.Cc.setText(strAa);
        }
        if (this.MY != null && this.lEW.HTA() != null && !TextUtils.isEmpty(this.lEW.HTA().IlO())) {
            com.bytedance.sdk.openadsdk.cL.Bc.IlO().IlO(this.lEW.HTA(), this.MY, this.lEW);
        }
        ea eaVar = this.tV;
        if (eaVar != null) {
            BS.IlO((TextView) null, eaVar, this.lEW);
            if (this.lEW.VH() != null) {
                this.tV.setVisibility(0);
            }
        }
        if (this.EO != null) {
            if (this.lEW.VH() != null && !TextUtils.isEmpty(this.lEW.VH().MY())) {
                this.EO.setText(this.lEW.VH().MY());
            } else if (!TextUtils.isEmpty(this.lEW.hL())) {
                this.EO.setText(this.lEW.hL());
            } else {
                this.EO.setVisibility(8);
            }
        }
        if (this.Bc != null) {
            String strDm = this.lEW.dm();
            if (!TextUtils.isEmpty(strDm)) {
                this.Bc.setText(strDm);
            } else {
                this.Bc.setVisibility(8);
            }
        }
        this.vCE.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.DmF.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.IlO(DmF.this.getContext(), DmF.this.lEW, DmF.this.DmF);
                } catch (Throwable unused) {
                }
            }
        });
    }
}
