package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends tV {
    private float Cc;
    private IlO tV;
    private float vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO {
        private View MY;

        public IlO(View view) {
            this.MY = view;
        }

        public void IlO(int i2) {
            if (!"top".equals(NV.this.MY.IlO())) {
                ViewGroup.LayoutParams layoutParams = this.MY.getLayoutParams();
                layoutParams.height = i2;
                this.MY.setLayoutParams(layoutParams);
                this.MY.requestLayout();
                return;
            }
            if (NV.this.EO instanceof ViewGroup) {
                for (int i8 = 0; i8 < ((ViewGroup) NV.this.EO).getChildCount(); i8++) {
                    ((ViewGroup) NV.this.EO).getChildAt(i8).setTranslationY(i2 - NV.this.Cc);
                }
            }
            NV nv = NV.this;
            nv.EO.setTranslationY(nv.Cc - i2);
        }
    }

    public NV(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        super(view, ilO);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV
    public List<ObjectAnimator> IlO() {
        int i2;
        String str;
        View view = this.EO;
        if ((view instanceof ImageView) && (view.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc)) {
            this.EO = (View) this.EO.getParent();
        }
        this.EO.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.EO, "alpha", 0.0f, 1.0f).setDuration((int) (this.MY.NV() * 1000.0d));
        this.tV = new IlO(this.EO);
        final int i8 = this.EO.getLayoutParams().height;
        this.Cc = i8;
        this.vCE = this.EO.getLayoutParams().width;
        if ("left".equals(this.MY.IlO()) || "right".equals(this.MY.IlO())) {
            i2 = (int) this.vCE;
            str = "width";
        } else {
            str = "height";
            i2 = i8;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.tV, str, 0, i2).setDuration((int) (this.MY.NV() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(IlO(duration));
        arrayList.add(IlO(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.NV.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                NV.this.tV.IlO(i8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z2) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        return arrayList;
    }
}
