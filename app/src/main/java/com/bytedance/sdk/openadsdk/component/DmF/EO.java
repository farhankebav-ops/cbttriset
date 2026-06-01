package com.bytedance.sdk.openadsdk.component.DmF;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.ea;
import com.bytedance.sdk.openadsdk.core.widget.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EO extends com.bytedance.sdk.openadsdk.core.Cc.Bc {
    com.bytedance.sdk.openadsdk.core.Cc.lEW Bc;
    com.bytedance.sdk.openadsdk.core.Cc.lEW Cc;
    zPa DmF;
    com.bytedance.sdk.openadsdk.core.Cc.tV EO;
    com.bytedance.sdk.openadsdk.core.Cc.lEW EV;
    com.bytedance.sdk.openadsdk.core.Cc.tV IlO;
    com.bytedance.sdk.openadsdk.core.Cc.EO MY;
    com.bytedance.sdk.openadsdk.core.Cc.lEW NV;
    final Bc lEW;
    com.bytedance.sdk.openadsdk.core.widget.EO rp;
    PAGLogoView tV;
    zPa vCE;

    public EO(Context context) {
        super(context);
        this.lEW = new Bc(context);
    }

    public abstract com.bytedance.sdk.openadsdk.core.Cc.tV getAdIconView();

    public PAGLogoView getAdLogo() {
        return this.tV;
    }

    public abstract com.bytedance.sdk.openadsdk.core.Cc.lEW getAdTitleTextView();

    public com.bytedance.sdk.openadsdk.core.Cc.tV getBackImage() {
        return this.IlO;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.lEW getClickButton() {
        return this.Cc;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.lEW getContent() {
        return this.EV;
    }

    public com.bytedance.sdk.openadsdk.core.widget.EO getDspAdChoice() {
        return this.rp;
    }

    public zPa getHostAppIcon() {
        return this.vCE;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.lEW getHostAppName() {
        return this.Bc;
    }

    public zPa getIconOnlyView() {
        return this.DmF;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.tV getImageView() {
        return this.EO;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.Cc getOverlayLayout() {
        return null;
    }

    public abstract ea getScoreBar();

    public com.bytedance.sdk.openadsdk.core.Cc.lEW getTitle() {
        return this.NV;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.lEW getTopCountDown() {
        Bc bc = this.lEW;
        if (bc != null) {
            return bc.getTopCountDown();
        }
        return null;
    }

    public View getTopDisLike() {
        Bc bc = this.lEW;
        if (bc != null) {
            return bc.getTopDislike();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.tV getTopSkip() {
        Bc bc = this.lEW;
        if (bc != null) {
            return bc.getTopSkip();
        }
        return null;
    }

    public abstract View getUserInfo();

    public com.bytedance.sdk.openadsdk.core.Cc.EO getVideoContainer() {
        return this.MY;
    }
}
