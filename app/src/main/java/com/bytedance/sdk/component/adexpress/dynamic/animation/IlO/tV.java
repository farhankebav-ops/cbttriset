package com.bytedance.sdk.component.adexpress.dynamic.animation.IlO;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mmj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tV implements mmj {
    public View EO;
    com.bytedance.sdk.component.adexpress.dynamic.tV.IlO MY;
    private Set<ScheduledFuture<?>> tV = new HashSet();
    public List<ObjectAnimator> IlO = IlO();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO implements Runnable {
        ObjectAnimator IlO;
        ScheduledFuture<?> MY;

        public IlO(ObjectAnimator objectAnimator) {
            this.IlO = objectAnimator;
        }

        public void IlO(ScheduledFuture<?> scheduledFuture) {
            this.MY = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO() != null) {
                com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().EO().EO().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV.IlO.1
                    @Override // java.lang.Runnable
                    public void run() {
                        IlO.this.IlO.resume();
                    }
                });
                if (this.MY != null) {
                    tV.this.tV.remove(this.MY);
                }
            }
        }
    }

    public tV(View view, com.bytedance.sdk.component.adexpress.dynamic.tV.IlO ilO) {
        this.EO = view;
        this.MY = ilO;
    }

    public void EO() {
        List<ObjectAnimator> list = this.IlO;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.MY.cl() > 0.0d) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        IlO ilO = tV.this.new IlO(objectAnimator);
                        ScheduledFuture<?> scheduledFutureIlO = com.bytedance.sdk.component.adexpress.tV.tV.IlO(ilO, (long) (tV.this.MY.cl() * 1000.0d), TimeUnit.MILLISECONDS);
                        ilO.IlO(scheduledFutureIlO);
                        tV.this.tV.add(scheduledFutureIlO);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }

    public abstract List<ObjectAnimator> IlO();

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mmj
    public void MY() {
        List<ObjectAnimator> list = this.IlO;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.tV.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public ObjectAnimator IlO(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.MY.bWL() * 1000.0d));
        if (this.MY.ea() > 0) {
            objectAnimator.setRepeatCount(this.MY.ea() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!"normal".equals(this.MY.zPa())) {
            if ("alternate".equals(this.MY.zPa()) || "alternate-reverse".equals(this.MY.zPa())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.MY.hp())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.MY.zPa())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.MY.zPa())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.IlO.tV.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    tV.this.EO.setVisibility(0);
                    if (tV.this.EO.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE) {
                        ((View) tV.this.EO.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }
}
