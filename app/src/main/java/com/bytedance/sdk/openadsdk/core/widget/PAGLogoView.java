package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PAGLogoView extends LinearLayout {
    protected int containerHeight;
    private com.bytedance.sdk.openadsdk.core.Cc.tV mAdLogo;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW mAdText;

    public PAGLogoView(Context context) {
        this(context, null);
    }

    public static PAGLogoView createPAGLogoViewByMaterial(Context context, oeT oet) {
        PAGLogoView pAGLogoView = new PAGLogoView(context);
        pAGLogoView.initData(oet);
        return pAGLogoView;
    }

    private void initView(Context context) {
        int iMY = BS.MY(context, 2.0f);
        this.containerHeight = BS.MY(getContext(), 12.0f);
        this.mAdLogo = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BS.MY(context, 14.0f), BS.MY(context, 6.0f));
        layoutParams.leftMargin = iMY;
        this.mAdLogo.setLayoutParams(layoutParams);
        this.mAdLogo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mAdText = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, this.containerHeight);
        layoutParams2.leftMargin = iMY;
        layoutParams2.rightMargin = iMY;
        this.mAdText.setLayoutParams(layoutParams2);
        this.mAdText.setTextSize(1, 8.0f);
        this.mAdText.setGravity(17);
        this.mAdText.setTextColor(Color.parseColor("#BFFFFFFF"));
        addView(this.mAdLogo);
        addView(this.mAdText);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(iMY);
        setBackground(gradientDrawable);
        setGravity(16);
    }

    public void initData(oeT oet) {
        if (oet == null) {
            return;
        }
        initData(oet.Uj());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = this.containerHeight;
        super.setLayoutParams(com.bytedance.sdk.openadsdk.core.Cc.DmF.IlO(this, layoutParams));
    }

    public PAGLogoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void initData(com.bytedance.sdk.openadsdk.core.model.MY my) {
        if (my == null) {
            return;
        }
        if (my.Cc()) {
            this.mAdLogo.setImageDrawable(pP.EO(com.bytedance.sdk.openadsdk.core.cl.IlO(), "tt_ad_logo"));
        } else {
            String strIlO = my.IlO();
            if (TextUtils.isEmpty(strIlO)) {
                this.mAdLogo.setVisibility(8);
            } else {
                if (strIlO.contains("logo")) {
                    this.mAdLogo.setImageDrawable(pP.EO(com.bytedance.sdk.openadsdk.core.cl.IlO(), "tt_ad_logo"));
                } else {
                    com.bytedance.sdk.openadsdk.DmF.tV.IlO(strIlO).EO(1).IlO(this.mAdLogo);
                }
                this.mAdLogo.setVisibility(0);
            }
        }
        String strMY = my.MY();
        if (my.Cc()) {
            this.mAdText.setText(pP.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), "tt_logo_en"));
        } else if (TextUtils.isEmpty(strMY)) {
            this.mAdText.setVisibility(8);
        } else {
            this.mAdText.setText(strMY);
            this.mAdText.setVisibility(0);
        }
    }

    public PAGLogoView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initView(context);
    }

    @RequiresApi(api = 21)
    public PAGLogoView(Context context, AttributeSet attributeSet, int i2, int i8) {
        super(context, attributeSet, i2, i8);
        initView(context);
    }
}
