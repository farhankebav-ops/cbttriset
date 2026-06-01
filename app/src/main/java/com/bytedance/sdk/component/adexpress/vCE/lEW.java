package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends vAh {
    private int Cc;
    private ImageView EO;
    private TextView IlO;
    private ImageView MY;
    private ImageView tV;
    private AnimatorSet vCE;

    public lEW(Context context) {
        super(context);
        this.vCE = new AnimatorSet();
        MY(context);
    }

    private void MY(Context context) {
        addView(com.bytedance.sdk.component.adexpress.EO.IlO.MY(context));
        this.MY = (ImageView) findViewById(2097610751);
        this.EO = (ImageView) findViewById(2097610750);
        this.tV = (ImageView) findViewById(2097610749);
        this.IlO = (TextView) findViewById(2097610748);
    }

    private void tV() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(2000L);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.vCE.vAh
    public void IlO(Context context) {
    }

    public float getAlphaColor() {
        return this.Cc;
    }

    public void setAlphaColor(int i2) {
        if (i2 < 0 || i2 > 60) {
            return;
        }
        int i8 = i2 + 195;
        ImageView imageView = this.tV;
        int iRgb = Color.rgb(i8, i8, i8);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(iRgb, mode);
        int i9 = ((i2 + 20) % 60) + 195;
        this.EO.setColorFilter(Color.rgb(i9, i9, i9), mode);
        int i10 = ((i2 + 40) % 60) + 195;
        this.MY.setColorFilter(Color.rgb(i10, i10, i10), mode);
    }

    public void setButtonText(String str) {
        if (this.IlO == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.IlO.setText(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.vCE.vAh
    public void IlO() {
        tV();
    }

    @Override // com.bytedance.sdk.component.adexpress.vCE.vAh
    public void MY() {
        this.vCE.cancel();
    }
}
