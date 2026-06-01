package com.bytedance.sdk.component.adexpress.vCE;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends vAh {
    private AnimatorSet EO;
    private TextView IlO;
    private View MY;

    public Bc(Context context) {
        super(context);
        this.EO = new AnimatorSet();
        MY(context);
    }

    private void MY(Context context) {
        View viewIlO = com.bytedance.sdk.component.adexpress.EO.IlO.IlO(context);
        this.MY = viewIlO;
        addView(viewIlO);
        setClipChildren(false);
        this.IlO = (TextView) findViewById(2097610748);
    }

    private void tV() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.MY, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.MY, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.EO.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.EO.setDuration(1000L);
        this.EO.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.vCE.vAh
    public void IlO(Context context) {
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
        this.EO.cancel();
    }
}
