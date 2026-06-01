package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.core.Cc.Cc;
import com.bytedance.sdk.openadsdk.core.Cc.lEW;
import com.bytedance.sdk.openadsdk.core.Cc.tV;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.settings.hp;
import com.bytedance.sdk.openadsdk.core.widget.vCE;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.EV;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TopLayoutDislike2 extends Cc implements IlO<TopLayoutDislike2> {
    private boolean hasCutDown;
    private boolean hasShowClose;
    private boolean isVast;
    private tV mCloseBtn;
    private View mImgDislike;
    private ImageView mImgSound;
    private boolean mIsSoundMute;
    private CharSequence mProgressStr;
    private ImageView mSkipIV;
    private TextView mTextViewCountDown;
    private MY mTopListener;
    private boolean shouldShowSkipTime;
    private int skipTime;
    private int videoDuration;

    public TopLayoutDislike2(@NonNull Context context) {
        this(context, null);
    }

    private ImageView getCommonRingBGImageView() {
        tV tVVar = new tV(getContext());
        int iMY = BS.MY(getContext(), 5.0f);
        tVVar.setPadding(iMY, iMY, iMY, iMY);
        tVVar.setScaleType(ImageView.ScaleType.CENTER);
        tVVar.setBackground(com.bytedance.sdk.openadsdk.core.widget.tV.IlO());
        return tVVar;
    }

    private void initListener() {
        View view = this.mImgDislike;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.MY(view2);
                    }
                }
            });
        }
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TopLayoutDislike2.this.mIsSoundMute = !r0.mIsSoundMute;
                    TopLayoutDislike2.this.mImgSound.setImageDrawable(TopLayoutDislike2.this.mSkipIV != null ? TopLayoutDislike2.this.mIsSoundMute ? pP.EO(TopLayoutDislike2.this.getContext(), "tt_reward_full_mute") : pP.EO(TopLayoutDislike2.this.getContext(), "tt_reward_full_unmute") : TopLayoutDislike2.this.mIsSoundMute ? EV.IlO(TopLayoutDislike2.this.getContext(), "tt_mute_wrapper") : EV.IlO(TopLayoutDislike2.this.getContext(), "tt_unmute_wrapper"));
                    if (TopLayoutDislike2.this.mImgSound.getDrawable() != null) {
                        TopLayoutDislike2.this.mImgSound.getDrawable().setAutoMirrored(true);
                    }
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        Object tag = TopLayoutDislike2.this.mImgSound.getTag(TopLayoutDislike2.this.mImgSound.getId());
                        TopLayoutDislike2.this.mTopListener.IlO(view2, tag instanceof String ? tag.toString() : "nativeClick");
                    }
                    TopLayoutDislike2.this.mImgSound.setTag(TopLayoutDislike2.this.mImgSound.getId(), null);
                }
            });
        }
        ImageView imageView2 = this.mSkipIV;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.IlO(view2);
                    }
                }
            });
        } else {
            TextView textView = this.mTextViewCountDown;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TopLayoutDislike2.this.mTopListener != null) {
                            TopLayoutDislike2.this.mTopListener.IlO(view2);
                        }
                    }
                });
            }
        }
        tV tVVar = this.mCloseBtn;
        if (tVVar != null) {
            tVVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.EO(view2);
                    }
                }
            });
        }
    }

    private void initView() {
        int iMY = BS.MY(getContext(), 16.0f);
        int iMY2 = BS.MY(getContext(), 20.0f);
        int iMY3 = BS.MY(getContext(), 28.0f);
        this.mImgSound = getCommonRingBGImageView();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iMY3, iMY3);
        layoutParams.leftMargin = iMY;
        layoutParams.topMargin = iMY2;
        this.mImgSound.setId(zPa.gYU);
        this.mImgSound.setLayoutParams(layoutParams);
        ImageView commonRingBGImageView = getCommonRingBGImageView();
        this.mImgDislike = commonRingBGImageView;
        commonRingBGImageView.setId(520093713);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iMY3, iMY3);
        layoutParams2.topMargin = iMY2;
        layoutParams2.leftMargin = iMY;
        this.mImgDislike.setLayoutParams(layoutParams2);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        view.setLayoutParams(layoutParams3);
        lEW lew = new lEW(getContext());
        this.mTextViewCountDown = lew;
        lew.setBackground(com.bytedance.sdk.openadsdk.core.widget.tV.MY());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, BS.MY(getContext(), 28.0f));
        layoutParams4.topMargin = BS.MY(getContext(), 20.0f);
        int iMY4 = BS.MY(getContext(), 16.0f);
        layoutParams2.rightMargin = iMY4;
        layoutParams4.rightMargin = iMY4;
        int iMY5 = BS.MY(getContext(), 12.0f);
        BS.MY(getContext(), 5.0f);
        this.mTextViewCountDown.setPadding(iMY5, 0, iMY5, 0);
        this.mTextViewCountDown.setLayoutParams(layoutParams4);
        this.mTextViewCountDown.setGravity(17);
        this.mTextViewCountDown.setTextColor(-1);
        this.mTextViewCountDown.setTextSize(14.0f);
        this.mTextViewCountDown.setVisibility(8);
        ImageView commonRingBGImageView2 = getCommonRingBGImageView();
        this.mSkipIV = commonRingBGImageView2;
        commonRingBGImageView2.setId(520093714);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(iMY3, iMY3);
        layoutParams5.topMargin = iMY2;
        layoutParams5.rightMargin = iMY;
        this.mSkipIV.setLayoutParams(layoutParams5);
        this.mSkipIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tV tVVarMY = vCE.MY(getContext());
        this.mCloseBtn = tVVarMY;
        tVVarMY.setId(520093708);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = 8388661;
        layoutParams6.topMargin = BS.MY(getContext(), 20.0f);
        layoutParams6.rightMargin = BS.MY(getContext(), 24.0f);
        this.mCloseBtn.setLayoutParams(layoutParams6);
        this.mCloseBtn.setContentDescription(pP.IlO(getContext(), "tt_ad_close_text"));
        this.mCloseBtn.setVisibility(8);
        addView(this.mImgSound);
        addView(this.mImgDislike);
        addView(view);
        addView(this.mTextViewCountDown);
        addView(this.mSkipIV);
        addView(this.mCloseBtn);
    }

    private void updateTime(boolean z2) {
        if (this.hasShowClose) {
            return;
        }
        if (this.shouldShowSkipTime) {
            this.mSkipIV.setVisibility(8);
            this.mTextViewCountDown.setVisibility(0);
        } else if (z2) {
            this.mTextViewCountDown.setVisibility(0);
            this.mSkipIV.setVisibility(8);
        } else {
            this.mTextViewCountDown.setVisibility(8);
            this.mSkipIV.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void clickSkip() {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.performClick();
        }
        TextView textView = this.mTextViewCountDown;
        if (textView != null) {
            textView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void clickSound(String str) {
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setTag(imageView.getId(), str);
            this.mImgSound.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public View getCloseButton() {
        return this.mCloseBtn;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setListener(MY my) {
        this.mTopListener = my;
    }

    public void setShouldShowSkipTime(boolean z2) {
        this.shouldShowSkipTime = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setShowDislike(boolean z2) {
        View view = this.mImgDislike;
        if (view == null || this.isVast) {
            return;
        }
        view.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setShowSkip(boolean z2) {
        TextView textView = this.mTextViewCountDown;
        if (textView == null) {
            return;
        }
        if (!z2) {
            textView.setText("");
        }
        if (this.mSkipIV.getVisibility() == 4) {
            return;
        }
        this.hasShowClose = !z2;
        this.mSkipIV.setVisibility((z2 && this.hasCutDown) ? 0 : 8);
        this.mTextViewCountDown.setVisibility(z2 & (TextUtils.isEmpty(this.mTextViewCountDown.getText()) ^ true) ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setShowSound(boolean z2) {
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setSkipEnable(boolean z2) {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setEnabled(z2);
            this.mSkipIV.setClickable(z2);
            return;
        }
        TextView textView = this.mTextViewCountDown;
        if (textView != null) {
            textView.setEnabled(z2);
            this.mTextViewCountDown.setClickable(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setSkipInvisiable() {
        this.mTextViewCountDown.setWidth(20);
        this.mTextViewCountDown.setVisibility(4);
        this.mSkipIV.setVisibility(4);
        this.hasShowClose = true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setSkipText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.mTextViewCountDown.setText(charSequence);
        if (this.mTextViewCountDown.getVisibility() != 0) {
            this.mTextViewCountDown.setVisibility(0);
        }
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setSoundMute(boolean z2) {
        this.mIsSoundMute = z2;
        this.mImgSound.setImageDrawable(this.mSkipIV != null ? z2 ? pP.EO(getContext(), "tt_reward_full_mute") : pP.EO(getContext(), "tt_reward_full_unmute") : z2 ? EV.IlO(getContext(), "tt_mute_wrapper") : EV.IlO(getContext(), "tt_unmute_wrapper"));
        if (this.mImgSound.getDrawable() != null) {
            this.mImgSound.getDrawable().setAutoMirrored(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void setTime(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.mProgressStr = charSequence;
        }
        if (this.mSkipIV == null) {
            return;
        }
        this.hasCutDown = true;
        if (this.shouldShowSkipTime) {
            this.mTextViewCountDown.setText(((Object) this.mProgressStr) + "s");
            updateTime(false);
            return;
        }
        String str = (String) this.mProgressStr;
        try {
            int i2 = this.skipTime;
            int i8 = i2 == 0 ? Integer.parseInt(str) : i2 - (this.videoDuration - Integer.parseInt(str));
            if (i8 <= 0) {
                this.mTextViewCountDown.setText(((Object) this.mProgressStr) + "s");
                updateTime(false);
                return;
            }
            if (this.skipTime == 0) {
                updateTime(false);
                return;
            }
            this.mTextViewCountDown.setText(i8 + "s");
            updateTime(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void showCloseButton() {
        setSkipInvisiable();
        this.mSkipIV.setVisibility(8);
        this.mCloseBtn.setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void showCountDownText() {
        this.mTextViewCountDown.setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.IlO
    public void showSkipButton() {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.mTextViewCountDown.setVisibility(8);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutDislike2 load(@NonNull oeT oet) {
        initView();
        this.mImgDislike.setVisibility(0);
        ((ImageView) this.mImgDislike).setImageResource(pP.tV(cl.IlO(), "tt_reward_full_feedback"));
        if (!hp.aP().hp(String.valueOf(oet.hFV())) || oet.vAh() == 5 || oet.vAh() == 6) {
            this.mSkipIV.setImageResource(pP.tV(cl.IlO(), "tt_close_btn"));
        } else {
            this.mSkipIV.setImageResource(pP.tV(cl.IlO(), "tt_skip_btn"));
        }
        if (this.mSkipIV.getDrawable() != null) {
            this.mSkipIV.getDrawable().setAutoMirrored(true);
        }
        this.mSkipIV.setVisibility(8);
        this.videoDuration = oet.fdM() == null ? 0 : ((int) oet.fdM().f4688d) * oet.fdM().f4694r;
        if (es.tV(oet) && oet.ea() != null) {
            this.videoDuration = (int) oet.ea().MY();
        } else if (es.Cc(oet) && oet.ea() != null) {
            this.videoDuration = (int) oet.ea().tV();
        }
        if (this.videoDuration <= 0) {
            this.videoDuration = 10;
        }
        if (oet.OyN() != 8 || oet.ssS() == null) {
            this.skipTime = oet.MY();
        } else {
            this.skipTime = oet.IlO();
        }
        if (OOq.EO(oet)) {
            this.skipTime = cl.tV().IlO(String.valueOf(oet.hFV()), oet.EJ());
            this.videoDuration = oet.XvI();
        }
        int i2 = this.skipTime;
        this.shouldShowSkipTime = i2 == -1 || i2 >= this.videoDuration;
        if (oet.xJ()) {
            this.mImgDislike.setVisibility(8);
            this.isVast = true;
        }
        this.mTextViewCountDown.setVisibility(4);
        this.mTextViewCountDown.setText("");
        this.mTextViewCountDown.setEnabled(false);
        this.mTextViewCountDown.setClickable(false);
        initListener();
        return this;
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mProgressStr = "";
        setOrientation(0);
    }

    public void clickDislike() {
    }
}
