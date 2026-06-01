package androidx.camera.view.impl;

import a.a;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Px;
import androidx.annotation.UiThread;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ZoomGestureDetector {
    private static final int ANCHORED_ZOOM_MODE_DOUBLE_TAP = 1;
    private static final int ANCHORED_ZOOM_MODE_NONE = 0;
    private static final int ANCHORED_ZOOM_MODE_STYLUS = 2;
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_MIN_SPAN = 0;
    private static final float SCALE_FACTOR = 0.5f;
    private int anchoredZoomMode;
    private float anchoredZoomStartX;
    private float anchoredZoomStartY;
    private final Context context;
    private float currentSpan;
    private float currentSpanX;
    private float currentSpanY;
    private boolean eventBeforeOrAboveStartingGestureEvent;
    private long eventTime;

    @Px
    private int focusX;

    @Px
    private int focusY;
    private GestureDetector gestureDetector;
    private float initialSpan;
    private boolean isInProgress;
    private boolean isQuickZoomEnabled;
    private boolean isStylusZoomEnabled;
    private final OnZoomGestureListener listener;
    private final int minSpan;
    private long prevTime;
    private float previousSpan;
    private float previousSpanX;
    private float previousSpanY;
    private final int spanSlop;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OnZoomGestureListener {
        @UiThread
        boolean onZoomEvent(ZoomEvent zoomEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class ZoomEvent {
        private final long eventTime;
        private final int focusX;
        private final int focusY;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Begin extends ZoomEvent {
            public Begin(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) @Px int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) @Px int i8) {
                super(j, i2, i8, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class End extends ZoomEvent {
            private final float incrementalScaleFactor;

            public End(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) @Px int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) @Px int i8, @FloatRange(from = 0.0d, fromInclusive = false) float f4) {
                super(j, i2, i8, null);
                this.incrementalScaleFactor = f4;
            }

            public final float getIncrementalScaleFactor() {
                return this.incrementalScaleFactor;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Move extends ZoomEvent {
            private final float incrementalScaleFactor;

            public Move(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) @Px int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) @Px int i8, @FloatRange(from = 0.0d, fromInclusive = false) float f4) {
                super(j, i2, i8, null);
                this.incrementalScaleFactor = f4;
            }

            public final float getIncrementalScaleFactor() {
                return this.incrementalScaleFactor;
            }
        }

        public /* synthetic */ ZoomEvent(long j, int i2, int i8, f fVar) {
            this(j, i2, i8);
        }

        public final long getEventTime() {
            return this.eventTime;
        }

        public final int getFocusX() {
            return this.focusX;
        }

        public final int getFocusY() {
            return this.focusY;
        }

        private ZoomEvent(@IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) long j, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) @Px int i2, @IntRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_LONG) @Px int i8) {
            this.eventTime = j;
            this.focusX = i2;
            this.focusY = i8;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZoomGestureDetector(Context context, @Px int i2, OnZoomGestureListener listener) {
        this(context, i2, 0, listener, 4, null);
        k.e(context, "context");
        k.e(listener, "listener");
    }

    private final float getIncrementalScaleFactor() {
        if (!inAnchoredZoomMode()) {
            float f4 = this.previousSpan;
            if (f4 > 0.0f) {
                return this.currentSpan / f4;
            }
            return 1.0f;
        }
        boolean z2 = this.eventBeforeOrAboveStartingGestureEvent;
        boolean z7 = (z2 && this.currentSpan < this.previousSpan) || (!z2 && this.currentSpan > this.previousSpan);
        float fAbs = Math.abs(1 - (this.currentSpan / this.previousSpan)) * 0.5f;
        if (this.previousSpan <= this.spanSlop) {
            return 1.0f;
        }
        return z7 ? fAbs + 1.0f : 1.0f - fAbs;
    }

    private final boolean inAnchoredZoomMode() {
        return this.anchoredZoomMode != 0;
    }

    public final long getTimeDelta() {
        return this.eventTime - this.prevTime;
    }

    public final boolean isQuickZoomEnabled() {
        return this.isQuickZoomEnabled;
    }

    public final boolean isStylusZoomEnabled() {
        return this.isStylusZoomEnabled;
    }

    @UiThread
    public final boolean onTouchEvent(MotionEvent event) {
        boolean z2;
        float f4;
        float f8;
        k.e(event, "event");
        this.eventTime = event.getEventTime();
        int actionMasked = event.getActionMasked();
        if (this.isQuickZoomEnabled) {
            this.gestureDetector.onTouchEvent(event);
        }
        int pointerCount = event.getPointerCount();
        boolean z7 = (event.getButtonState() & 32) != 0;
        boolean z8 = this.anchoredZoomMode == 2 && !z7;
        boolean z9 = actionMasked == 1 || actionMasked == 3 || z8;
        float f9 = 0.0f;
        if (actionMasked == 0 || z9) {
            if (this.isInProgress) {
                z2 = true;
                this.listener.onZoomEvent(new ZoomEvent.End(this.eventTime, this.focusX, this.focusY, getIncrementalScaleFactor()));
                this.isInProgress = false;
                this.initialSpan = 0.0f;
                this.anchoredZoomMode = 0;
            } else {
                z2 = true;
                if (inAnchoredZoomMode() && z9) {
                    this.isInProgress = false;
                    this.initialSpan = 0.0f;
                    this.anchoredZoomMode = 0;
                }
            }
            if (!z9) {
            }
            return z2;
        }
        z2 = true;
        if (!this.isInProgress && this.isStylusZoomEnabled && !inAnchoredZoomMode() && !z9 && z7) {
            this.anchoredZoomStartX = event.getX();
            this.anchoredZoomStartY = event.getY();
            this.anchoredZoomMode = 2;
            this.initialSpan = 0.0f;
        }
        boolean z10 = (actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z8) ? z2 : false;
        boolean z11 = actionMasked == 6 ? z2 : false;
        int actionIndex = z11 ? event.getActionIndex() : -1;
        int i2 = z11 ? pointerCount - 1 : pointerCount;
        if (inAnchoredZoomMode()) {
            f8 = this.anchoredZoomStartX;
            f4 = this.anchoredZoomStartY;
            this.eventBeforeOrAboveStartingGestureEvent = event.getY() < f4 ? z2 : false;
        } else {
            float x2 = 0.0f;
            float y = 0.0f;
            for (int i8 = 0; i8 < pointerCount; i8++) {
                if (actionIndex != i8) {
                    x2 += event.getX(i8);
                    y += event.getY(i8);
                }
            }
            float f10 = i2;
            float f11 = x2 / f10;
            f4 = y / f10;
            f8 = f11;
        }
        float fAbs = 0.0f;
        for (int i9 = 0; i9 < pointerCount; i9++) {
            if (actionIndex != i9) {
                float fAbs2 = Math.abs(event.getX(i9) - f8) + f9;
                fAbs = Math.abs(event.getY(i9) - f4) + fAbs;
                f9 = fAbs2;
            }
        }
        float f12 = i2;
        float f13 = f9 / f12;
        float f14 = fAbs / f12;
        float f15 = 2;
        float f16 = f13 * f15;
        float f17 = f14 * f15;
        float fHypot = inAnchoredZoomMode() ? f17 : (float) Math.hypot(f16, f17);
        boolean z12 = this.isInProgress;
        this.focusX = a.U(f8);
        this.focusY = a.U(f4);
        if (!inAnchoredZoomMode() && this.isInProgress && (fHypot < this.minSpan || z10)) {
            this.listener.onZoomEvent(new ZoomEvent.End(this.eventTime, this.focusX, this.focusY, getIncrementalScaleFactor()));
            this.isInProgress = false;
            this.initialSpan = fHypot;
        }
        if (z10) {
            this.currentSpanX = f16;
            this.previousSpanX = f16;
            this.currentSpanY = f17;
            this.previousSpanY = f17;
            this.currentSpan = fHypot;
            this.previousSpan = fHypot;
            this.initialSpan = fHypot;
        }
        int i10 = inAnchoredZoomMode() ? this.spanSlop : this.minSpan;
        if (!this.isInProgress && fHypot >= i10 && (z12 || Math.abs(fHypot - this.initialSpan) > this.spanSlop)) {
            this.currentSpanX = f16;
            this.previousSpanX = f16;
            this.currentSpanY = f17;
            this.previousSpanY = f17;
            this.currentSpan = fHypot;
            this.previousSpan = fHypot;
            long j = this.eventTime;
            this.prevTime = j;
            this.isInProgress = this.listener.onZoomEvent(new ZoomEvent.Begin(j, this.focusX, this.focusY));
        }
        if (actionMasked == 2) {
            this.currentSpanX = f16;
            this.currentSpanY = f17;
            this.currentSpan = fHypot;
            if (this.isInProgress ? this.listener.onZoomEvent(new ZoomEvent.Move(this.eventTime, this.focusX, this.focusY, getIncrementalScaleFactor())) : z2) {
                this.previousSpanX = this.currentSpanX;
                this.previousSpanY = this.currentSpanY;
                this.previousSpan = this.currentSpan;
                this.prevTime = this.eventTime;
            }
        }
        return z2;
    }

    public final void setQuickZoomEnabled(boolean z2) {
        this.isQuickZoomEnabled = z2;
    }

    public final void setStylusZoomEnabled(boolean z2) {
        this.isStylusZoomEnabled = z2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZoomGestureDetector(Context context, OnZoomGestureListener listener) {
        this(context, 0, 0, listener, 6, null);
        k.e(context, "context");
        k.e(listener, "listener");
    }

    public ZoomGestureDetector(Context context, @Px int i2, @Px int i8, OnZoomGestureListener listener) {
        k.e(context, "context");
        k.e(listener, "listener");
        this.context = context;
        this.spanSlop = i2;
        this.minSpan = i8;
        this.listener = listener;
        this.isQuickZoomEnabled = true;
        this.isStylusZoomEnabled = true;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: androidx.camera.view.impl.ZoomGestureDetector$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                k.e(e, "e");
                this.this$0.anchoredZoomStartX = e.getX();
                this.this$0.anchoredZoomStartY = e.getY();
                this.this$0.anchoredZoomMode = 1;
                return true;
            }
        });
    }

    public /* synthetic */ ZoomGestureDetector(Context context, int i2, int i8, OnZoomGestureListener onZoomGestureListener, int i9, f fVar) {
        this(context, (i9 & 2) != 0 ? ViewConfiguration.get(context).getScaledTouchSlop() * 2 : i2, (i9 & 4) != 0 ? 0 : i8, onZoomGestureListener);
    }
}
