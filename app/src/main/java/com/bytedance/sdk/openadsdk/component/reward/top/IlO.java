package com.bytedance.sdk.openadsdk.component.reward.top;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface IlO<T extends View> {
    void clickSkip();

    void clickSound(String str);

    View getCloseButton();

    void setListener(MY my);

    void setShowDislike(boolean z2);

    void setShowSkip(boolean z2);

    void setShowSound(boolean z2);

    void setSkipEnable(boolean z2);

    void setSkipInvisiable();

    void setSkipText(CharSequence charSequence);

    void setSoundMute(boolean z2);

    void setTime(CharSequence charSequence, CharSequence charSequence2);

    void showCloseButton();

    void showCountDownText();

    void showSkipButton();
}
