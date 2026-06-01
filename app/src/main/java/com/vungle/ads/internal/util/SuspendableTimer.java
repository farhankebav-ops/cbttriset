package com.vungle.ads.internal.util;

import android.os.CountDownTimer;
import androidx.annotation.VisibleForTesting;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SuspendableTimer {
    private final double durationSecs;
    private boolean isCanceled;
    private boolean isPaused;
    private double nextDurationSecs;
    private final e6.a onFinish;
    private final e6.a onTick;
    private final boolean repeats;
    private long startTimeMillis;
    private CountDownTimer timer;

    /* JADX INFO: renamed from: com.vungle.ads.internal.util.SuspendableTimer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.a {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3379invoke() {
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3379invoke();
            return x.f13520a;
        }
    }

    public SuspendableTimer(double d8, boolean z2, e6.a onTick, e6.a onFinish) {
        k.e(onTick, "onTick");
        k.e(onFinish, "onFinish");
        this.durationSecs = d8;
        this.repeats = z2;
        this.onTick = onTick;
        this.onFinish = onFinish;
        this.nextDurationSecs = d8;
    }

    private final CountDownTimer createCountdown(long j) {
        return new CountDownTimer(j, this) { // from class: com.vungle.ads.internal.util.SuspendableTimer.createCountdown.1
            final /* synthetic */ SuspendableTimer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j, j);
                this.this$0 = this;
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                SuspendableTimer suspendableTimer = this.this$0;
                suspendableTimer.onFinish.invoke();
                if (!suspendableTimer.repeats || suspendableTimer.isCanceled) {
                    suspendableTimer.cancel();
                } else {
                    suspendableTimer.setNextDurationSecs$vungle_ads_release(suspendableTimer.durationSecs);
                    suspendableTimer.start();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                this.this$0.onTick.invoke();
            }
        };
    }

    private final long getDurationMillis() {
        return (long) (this.durationSecs * ((double) 1000));
    }

    private final double getElapsedSecs() {
        return getElapsedMillis$vungle_ads_release() / ((long) 1000);
    }

    private final long getNextDurationMillis() {
        return (long) (this.nextDurationSecs * ((double) 1000));
    }

    public final void cancel() {
        this.isPaused = false;
        this.isCanceled = true;
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
    }

    public final long getElapsedMillis$vungle_ads_release() {
        long jCurrentTimeMillis;
        long nextDurationMillis;
        if (this.isPaused) {
            jCurrentTimeMillis = getDurationMillis();
            nextDurationMillis = getNextDurationMillis();
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            nextDurationMillis = this.startTimeMillis;
        }
        return jCurrentTimeMillis - nextDurationMillis;
    }

    public final double getNextDurationSecs$vungle_ads_release() {
        return this.nextDurationSecs;
    }

    public final long getStartTimeMillis$vungle_ads_release() {
        return this.startTimeMillis;
    }

    public final CountDownTimer getTimer$vungle_ads_release() {
        return this.timer;
    }

    public final void pause() {
        if (this.timer == null) {
            return;
        }
        this.nextDurationSecs -= getElapsedSecs();
        this.isPaused = true;
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
    }

    public final void reset() {
        cancel();
        start();
    }

    public final void resume() {
        if (this.isPaused) {
            this.isPaused = false;
            start();
        }
    }

    public final void setNextDurationSecs$vungle_ads_release(double d8) {
        this.nextDurationSecs = d8;
    }

    public final void setStartTimeMillis$vungle_ads_release(long j) {
        this.startTimeMillis = j;
    }

    public final void setTimer$vungle_ads_release(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    public final void start() {
        this.startTimeMillis = System.currentTimeMillis();
        CountDownTimer countDownTimerCreateCountdown = createCountdown(getNextDurationMillis());
        this.timer = countDownTimerCreateCountdown;
        if (countDownTimerCreateCountdown != null) {
            countDownTimerCreateCountdown.start();
        }
    }

    public /* synthetic */ SuspendableTimer(double d8, boolean z2, e6.a aVar, e6.a aVar2, int i2, f fVar) {
        this(d8, z2, (i2 & 4) != 0 ? AnonymousClass1.INSTANCE : aVar, aVar2);
    }

    @VisibleForTesting
    public static /* synthetic */ void getElapsedMillis$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getNextDurationSecs$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStartTimeMillis$vungle_ads_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTimer$vungle_ads_release$annotations() {
    }
}
