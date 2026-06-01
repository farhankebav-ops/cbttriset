package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.dY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends FrameLayout {
    private cl Cc;
    private ImageView EO;
    private Context IlO;
    private ImageView MY;
    private TextView tV;
    private AnimatorSet vCE;

    public EO(@NonNull Context context) {
        super(context);
        this.vCE = new AnimatorSet();
        this.IlO = context;
        Cc();
        vCE();
    }

    private void Cc() {
        FrameLayout frameLayout = new FrameLayout(this.IlO);
        this.Cc = new cl(this.IlO);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 95.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.Cc, layoutParams);
        this.MY = new ImageView(this.IlO);
        int iIlO = dY.IlO(this.IlO, 60.0f);
        this.MY.setImageDrawable(com.bytedance.sdk.component.adexpress.tV.lEW.IlO(1, null, null, new int[]{iIlO, iIlO}, Integer.valueOf(dY.IlO(this.IlO, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 75.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.MY, layoutParams2);
        this.EO = new ImageView(this.IlO);
        int iIlO2 = dY.IlO(this.IlO, 50.0f);
        this.EO.setImageDrawable(com.bytedance.sdk.component.adexpress.tV.lEW.IlO(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iIlO2, iIlO2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 63.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.IlO, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.EO, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.IlO);
        this.tV = textView;
        textView.setTextColor(-1);
        this.tV.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.tV, layoutParams4);
    }

    private void vCE() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.EO, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.EO, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.vCE.setDuration(800L);
        this.vCE.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void EO() {
        this.Cc.IlO();
    }

    public void IlO() {
        this.vCE.start();
    }

    public void MY() {
        this.vCE.cancel();
    }

    public void setGuideText(String str) {
        this.tV.setText(str);
    }

    public void tV() {
        this.Cc.MY();
        this.Cc.EO();
    }
}
