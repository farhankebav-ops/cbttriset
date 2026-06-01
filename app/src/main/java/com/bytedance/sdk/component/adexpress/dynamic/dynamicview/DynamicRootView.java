package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.tV, com.bytedance.sdk.component.adexpress.theme.IlO {
    private String bgColor;
    private Map<Integer, String> bgMaterialCenterCalcColor;
    private Cc dynamicBaseWidget;
    private int logoUnionHeight;
    private Context mContext;
    private com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO mDynamicClickListener;
    boolean mIsMute;
    private ThemeStatusBroadcastReceiver mReceiver;
    private com.bytedance.sdk.component.adexpress.MY.EV mRenderListener;
    private com.bytedance.sdk.component.adexpress.MY.hp mRenderRequest;
    private ViewGroup mTimeOut;
    private com.bytedance.sdk.component.adexpress.dynamic.MY muteListener;
    protected final com.bytedance.sdk.component.adexpress.MY.bWL renderResult;
    private int scoreCountWithIcon;
    private List<com.bytedance.sdk.component.adexpress.dynamic.EO> timeOutListener;
    private int timedown;
    private com.bytedance.sdk.component.adexpress.dynamic.Cc videoListener;
    public View videoView;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z2, com.bytedance.sdk.component.adexpress.MY.hp hpVar, com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO ilO) {
        super(context);
        this.mTimeOut = null;
        this.timedown = 0;
        this.timeOutListener = new ArrayList();
        this.logoUnionHeight = 0;
        this.scoreCountWithIcon = 0;
        this.mContext = context;
        com.bytedance.sdk.component.adexpress.MY.bWL bwl = new com.bytedance.sdk.component.adexpress.MY.bWL();
        this.renderResult = bwl;
        bwl.IlO(2);
        this.mDynamicClickListener = ilO;
        ilO.IlO(this);
        this.mReceiver = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.IlO(this);
        this.mIsMute = z2;
        this.mRenderRequest = hpVar;
    }

    private void checkCanOpenLandingPage(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        com.bytedance.sdk.component.adexpress.dynamic.tV.vCE vceCc;
        com.bytedance.sdk.component.adexpress.dynamic.tV.Cc ccNV = lew.NV();
        if (ccNV == null || (vceCc = ccNV.Cc()) == null) {
            return;
        }
        this.renderResult.MY(vceCc.KS());
    }

    private boolean checkSizeValid() {
        Cc cc = this.dynamicBaseWidget;
        return cc.Cc > 0.0f && cc.vCE > 0.0f;
    }

    private void setClipChildren(ViewGroup viewGroup, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !lew.kBB()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void beginHideFromVisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 4);
    }

    public void beginShowFromInvisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 0);
    }

    public void callBackRenderFail(int i2, String str) {
        this.renderResult.IlO(false);
        this.renderResult.MY(i2);
        this.renderResult.IlO(str);
        this.mRenderListener.IlO(this.renderResult);
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.bgMaterialCenterCalcColor;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.vCE.IlO getDynamicClickListener() {
        return this.mDynamicClickListener;
    }

    public int getLogoUnionHeight() {
        return this.logoUnionHeight;
    }

    public com.bytedance.sdk.component.adexpress.MY.EV getRenderListener() {
        return this.mRenderListener;
    }

    public com.bytedance.sdk.component.adexpress.MY.hp getRenderRequest() {
        return this.mRenderRequest;
    }

    public int getScoreCountWithIcon() {
        return this.scoreCountWithIcon;
    }

    public ViewGroup getTimeOut() {
        return this.mTimeOut;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.EO> getTimeOutListener() {
        return this.timeOutListener;
    }

    public int getTimedown() {
        return this.timedown;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.IlO
    public void onThemeChanged(int i2) {
        Cc cc = this.dynamicBaseWidget;
        if (cc == null) {
            return;
        }
        cc.IlO(i2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void onvideoComplate() {
        try {
            this.videoListener.IlO();
        } catch (Exception unused) {
        }
    }

    public void render(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, int i2) {
        this.dynamicBaseWidget = renderDynamicView(lew, this, i2);
        this.renderResult.IlO(true);
        this.renderResult.IlO(this.dynamicBaseWidget.Cc);
        this.renderResult.MY(this.dynamicBaseWidget.vCE);
        this.renderResult.IlO(this.videoView);
        this.mRenderListener.IlO(this.renderResult);
    }

    public Cc renderDynamicView(com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew, ViewGroup viewGroup, int i2) {
        if (lew == null) {
            return null;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> listEV = lew.EV();
        Cc ccIlO = com.bytedance.sdk.component.adexpress.dynamic.IlO.MY.IlO(this.mContext, this, lew);
        if (ccIlO instanceof dY) {
            callBackRenderFail(i2 == 3 ? 128 : Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, "unknow widget");
            return null;
        }
        checkCanOpenLandingPage(lew);
        ccIlO.EO();
        if (viewGroup != null) {
            viewGroup.addView(ccIlO);
            setClipChildren(viewGroup, lew);
        }
        if (listEV == null || listEV.size() <= 0) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> it = listEV.iterator();
        while (it.hasNext()) {
            renderDynamicView(it.next(), ccIlO, i2);
        }
        return ccIlO;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.bgMaterialCenterCalcColor = map;
    }

    public void setDislikeView(View view) {
        this.mDynamicClickListener.MY(view);
    }

    public void setLogoUnionHeight(int i2) {
        this.logoUnionHeight = i2;
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.MY my) {
        this.muteListener = my;
    }

    public void setRenderListener(com.bytedance.sdk.component.adexpress.MY.EV ev) {
        this.mRenderListener = ev;
        this.mDynamicClickListener.IlO(ev);
    }

    public void setScoreCountWithIcon(int i2) {
        this.scoreCountWithIcon = i2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setSoundMute(boolean z2) {
        com.bytedance.sdk.component.adexpress.dynamic.MY my = this.muteListener;
        if (my != null) {
            my.setSoundMute(z2);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setTime(CharSequence charSequence, int i2, int i8, boolean z2) {
        for (int i9 = 0; i9 < this.timeOutListener.size(); i9++) {
            if (this.timeOutListener.get(i9) != null) {
                this.timeOutListener.get(i9).IlO(charSequence, i2 == 1, i8, z2);
            }
        }
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.mTimeOut = viewGroup;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.EO eo) {
        this.timeOutListener.add(eo);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.tV
    public void setTimeUpdate(int i2) {
        this.videoListener.setTimeUpdate(i2);
    }

    public void setTimedown(int i2) {
        this.timedown = i2;
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.Cc cc) {
        this.videoListener = cc;
    }

    public void updateRenderInfoForVideo(double d8, double d9, double d10, double d11, float f4) {
        this.renderResult.EO(d8);
        this.renderResult.tV(d9);
        this.renderResult.Cc(d10);
        this.renderResult.vCE(d11);
        this.renderResult.IlO(f4);
        this.renderResult.MY(f4);
        this.renderResult.EO(f4);
        this.renderResult.tV(f4);
    }

    public void beginShowFromInvisible(Cc cc, int i2) {
        if (cc == null) {
            return;
        }
        if (cc.getBeginInvisibleAndShow()) {
            cc.setVisibility(i2);
            View view = cc.ea;
            if (view != null) {
                view.setVisibility(i2);
            }
        }
        int childCount = cc.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            if (cc.getChildAt(i8) instanceof Cc) {
                beginShowFromInvisible((Cc) cc.getChildAt(i8), i2);
            }
        }
    }
}
