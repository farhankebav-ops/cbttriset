package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa {
    private AnimatorSet Bc;
    private final IlO Cc;
    private final Context EO;
    com.bytedance.sdk.openadsdk.core.widget.lEW IlO;
    private final oeT MY;
    private final int tV;
    private com.bytedance.sdk.openadsdk.core.widget.Bc vCE;

    public zPa(IlO ilO) {
        this.EO = ilO.gQ;
        this.MY = ilO.MY;
        this.tV = ilO.fdM;
        this.Cc = ilO;
    }

    public void EO() {
        AnimatorSet animatorSet = this.Bc;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void IlO() {
        try {
            if (OOq.EO(this.MY)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.widget.Bc bc = new com.bytedance.sdk.openadsdk.core.widget.Bc(this.EO);
            this.vCE = bc;
            this.IlO = bc.getLoadingProgressBar();
            com.bytedance.sdk.openadsdk.core.Cc.lEW downloadButton = this.vCE.getDownloadButton();
            if (downloadButton != null) {
                downloadButton.setOnClickListener(this.Cc.wPn.Cc());
            }
            this.vCE.IlO(this.MY, this.tV);
        } catch (Throwable unused) {
        }
    }

    public void MY() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(1, 80);
        valueAnimatorOfInt.setDuration(2000L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.zPa.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                com.bytedance.sdk.openadsdk.core.widget.lEW lew = zPa.this.IlO;
                if (lew != null) {
                    lew.setProgress(iIntValue);
                }
            }
        });
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(81, 99);
        valueAnimatorOfInt2.setDuration(3000L);
        valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.zPa.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                com.bytedance.sdk.openadsdk.core.widget.lEW lew = zPa.this.IlO;
                if (lew != null) {
                    lew.setProgress(iIntValue);
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.Bc = animatorSet;
        animatorSet.play(valueAnimatorOfInt).before(valueAnimatorOfInt2);
        this.Bc.start();
    }

    public View tV() {
        return this.vCE;
    }
}
