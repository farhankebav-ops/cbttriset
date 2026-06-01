package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.ea;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es {
    private final Context Bc;
    private final RelativeLayout Cc;
    private TextView DmF;
    ea IlO;
    TTAdDislikeToast MY;
    private com.bytedance.sdk.openadsdk.core.Cc.vCE NV;
    private ImageView lEW;
    private boolean rp;
    private final oeT vCE;
    final AtomicBoolean EO = new AtomicBoolean(false);
    final AtomicBoolean tV = new AtomicBoolean(false);
    private final int EV = BS.MY(com.bytedance.sdk.openadsdk.core.cl.IlO(), 44.0f);

    public es(Context context, RelativeLayout relativeLayout, oeT oet) {
        this.Bc = context;
        this.Cc = relativeLayout;
        this.vCE = oet;
        Cc();
    }

    private void Bc() {
        this.MY.show(TTAdDislikeToast.getDislikeTip());
    }

    private void Cc() {
        this.lEW = (ImageView) this.Cc.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.qz);
        this.DmF = (TextView) this.Cc.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.qvT);
        ImageView imageView = (ImageView) this.Cc.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.ts);
        this.NV = (com.bytedance.sdk.openadsdk.core.Cc.vCE) this.Cc.findViewById(com.bytedance.sdk.openadsdk.utils.zPa.BO);
        oeT oet = this.vCE;
        if (oet != null) {
            this.DmF.setText(TextUtils.isEmpty(oet.dm()) ? pP.IlO(this.Bc, "tt_web_title_default") : this.vCE.dm());
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.es.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                es.this.tV();
            }
        });
    }

    private void vCE() {
        try {
            if (this.IlO == null) {
                ea eaVar = new ea(this.Bc, this.vCE);
                this.IlO = eaVar;
                eaVar.setDislikeSource("landing_page");
                this.IlO.setCallback(new ea.IlO() { // from class: com.bytedance.sdk.openadsdk.common.es.6
                    @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                    public void IlO(View view) {
                        es.this.EO.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                    public void MY(View view) {
                        es.this.EO.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.ea.IlO
                    public void IlO(FilterWord filterWord) {
                        if (es.this.tV.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        es.this.tV.set(true);
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) this.Cc.getRootView().findViewById(R.id.content);
            frameLayout.addView(this.IlO);
            if (this.MY == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.Bc);
                this.MY = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "TTTitleNewStyleManager", th);
        }
    }

    public ImageView EO() {
        return this.lEW;
    }

    public void MY() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Cc.getLayoutParams();
            if (this.rp || marginLayoutParams.topMargin != 0) {
                return;
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, -this.EV);
            valueAnimatorOfInt.setDuration(300L);
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.common.es.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    es.this.Cc.setLayoutParams(marginLayoutParams);
                }
            });
            valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.common.es.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    es.this.rp = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    es.this.rp = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            valueAnimatorOfInt.start();
        } catch (Throwable unused) {
        }
    }

    public void tV() {
        if (this.tV.get()) {
            Bc();
            return;
        }
        if (this.IlO == null) {
            vCE();
        }
        ea eaVar = this.IlO;
        if (eaVar != null) {
            eaVar.IlO();
        }
    }

    public void IlO(int i2) {
        if (i2 == 100) {
            this.NV.setVisibility(8);
        } else {
            this.NV.setVisibility(0);
            this.NV.setProgress(i2);
        }
    }

    public void IlO() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Cc.getLayoutParams();
            if (this.rp) {
                return;
            }
            int i2 = marginLayoutParams.topMargin;
            int i8 = this.EV;
            if (i2 == (-i8)) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(-i8, 0);
                valueAnimatorOfInt.setDuration(300L);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.common.es.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        es.this.Cc.setLayoutParams(marginLayoutParams);
                    }
                });
                valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.common.es.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        es.this.rp = false;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        es.this.rp = true;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                valueAnimatorOfInt.start();
            }
        } catch (Throwable unused) {
        }
    }
}
