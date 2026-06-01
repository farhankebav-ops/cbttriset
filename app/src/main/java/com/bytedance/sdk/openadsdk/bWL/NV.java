package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class NV extends com.bytedance.sdk.openadsdk.core.Cc.EO {
    protected com.bytedance.sdk.openadsdk.core.Cc.lEW Cc;
    protected zPa EO;
    protected com.bytedance.sdk.openadsdk.core.Cc.EO IlO;
    protected com.bytedance.sdk.openadsdk.core.Cc.tV MY;
    protected com.bytedance.sdk.openadsdk.core.Cc.lEW tV;
    protected com.bytedance.sdk.openadsdk.core.Cc.lEW vCE;

    public NV(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        IlO(context);
    }

    public zPa Bc(Context context) {
        zPa zpa = new zPa(context);
        zpa.setScaleType(ImageView.ScaleType.FIT_XY);
        zpa.setBackgroundColor(0);
        return zpa;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.EO Cc(Context context) {
        return new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
    }

    public com.bytedance.sdk.openadsdk.core.Cc.lEW EO(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setEllipsize(TextUtils.TruncateAt.END);
        lew.setMaxLines(1);
        lew.setSingleLine();
        lew.setTextColor(Color.parseColor("#FF999999"));
        lew.setTextSize(2, 12.0f);
        return lew;
    }

    public abstract void IlO(Context context);

    public com.bytedance.sdk.openadsdk.core.Cc.lEW MY(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setEllipsize(TextUtils.TruncateAt.END);
        lew.setMaxLines(1);
        lew.setTextColor(Color.parseColor("#FF999999"));
        lew.setTextSize(2, 16.0f);
        return lew;
    }

    public FrameLayout getTtAdContainer() {
        return this.IlO;
    }

    public TextView getTtFullAdAppName() {
        return this.tV;
    }

    public TextView getTtFullAdDesc() {
        return this.Cc;
    }

    public TextView getTtFullAdDownload() {
        return this.vCE;
    }

    public zPa getTtFullAdIcon() {
        return this.EO;
    }

    public ImageView getTtFullImg() {
        return this.MY;
    }

    public PAGLogoView lEW(Context context) {
        PAGLogoView pAGLogoView = new PAGLogoView(context);
        pAGLogoView.setId(520093739);
        return pAGLogoView;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.lEW tV(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_backup_btn_1"));
        lew.setGravity(17);
        lew.setText(pP.IlO(context, "tt_video_download_apk"));
        lew.setTextColor(-1);
        lew.setTextSize(2, 14.0f);
        return lew;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.tV vCE(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return tVVar;
    }
}
