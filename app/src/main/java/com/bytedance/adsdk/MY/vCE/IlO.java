package com.bytedance.adsdk.MY.vCE;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> IlO = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> MY = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> EO = new CopyOnWriteArraySet();

    public void Cc() {
        Iterator<Animator.AnimatorPauseListener> it = this.EO.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }

    public void EO() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.IlO.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    public void IlO(boolean z2) {
        for (Animator.AnimatorListener animatorListener : this.MY) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z2);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    public void MY(boolean z2) {
        for (Animator.AnimatorListener animatorListener : this.MY) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z2);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.MY.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.EO.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.IlO.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.MY.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.IlO.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.MY.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.EO.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.IlO.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public void tV() {
        Iterator<Animator.AnimatorPauseListener> it = this.EO.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    public void IlO() {
        Iterator<Animator.AnimatorListener> it = this.MY.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    public void MY() {
        Iterator<Animator.AnimatorListener> it = this.MY.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }
}
