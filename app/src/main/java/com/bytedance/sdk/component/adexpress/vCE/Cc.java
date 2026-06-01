package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends FrameLayout {
    private ImageView IlO;
    private AnimatorSet MY;

    public Cc(Context context) {
        super(context);
        EO();
        tV();
    }

    private void EO() {
        ImageView imageView = new ImageView(getContext());
        this.IlO = imageView;
        imageView.setImageResource(com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_white_hand"));
        int iIlO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iIlO, iIlO);
        layoutParams.gravity = 17;
        addView(this.IlO, layoutParams);
    }

    private void tV() {
        this.MY = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.IlO, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(2000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.IlO, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(2000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.MY.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void IlO() {
        AnimatorSet animatorSet = this.MY;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void MY() {
        AnimatorSet animatorSet = this.MY;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
