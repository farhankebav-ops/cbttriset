package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends tV {
    public Cc(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        super(view, ilO);
    }

    private void EO(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.MY.xF())).setDuration((int) (this.MY.NV() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.Cc.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Cc.this.EO.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(IlO(duration));
    }

    private void MY(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.MY.xF())).setDuration((int) (this.MY.NV() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.Cc.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Cc.this.EO.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(IlO(duration));
    }

    private void tV(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.MY.xF())).setDuration((int) (this.MY.NV() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(IlO(duration));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV
    public List<ObjectAnimator> IlO() {
        ArrayList arrayList = new ArrayList();
        String strAXM = this.MY.AXM();
        switch (strAXM.hashCode()) {
            case 3029889:
                if (strAXM.equals("both")) {
                    IlO(arrayList);
                    return arrayList;
                }
                break;
            case 3387192:
                strAXM.equals("none");
                break;
            case 483313230:
                if (strAXM.equals("forwards")) {
                    tV(arrayList);
                    return arrayList;
                }
                break;
            case 1356771568:
                if (strAXM.equals("backwards")) {
                    MY(arrayList);
                    return arrayList;
                }
                break;
        }
        EO(arrayList);
        return arrayList;
    }

    private void IlO(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.MY.xF())).setDuration(((int) (this.MY.NV() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO = this.MY;
        ilO.vCE(ilO.ea() * 2);
        list.add(IlO(duration));
    }
}
