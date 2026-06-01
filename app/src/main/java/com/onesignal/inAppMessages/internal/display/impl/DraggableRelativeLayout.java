package com.onesignal.inAppMessages.internal.display.impl;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.onesignal.common.ViewUtils;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DraggableRelativeLayout extends RelativeLayout {
    public static final Companion Companion = new Companion(null);
    private static final int EXTRA_PX_DISMISS;
    private static final int MARGIN_PX_SIZE;
    private boolean dismissing;
    private final boolean draggingDisabled;
    private ViewDragHelper mDragHelper;
    private DraggableListener mListener;
    private Params params;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface DraggableListener {
        void onDismiss();

        void onDragEnd();

        void onDragStart();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Params {
        public static final Companion Companion = new Companion(null);
        public static final int DRAGGABLE_DIRECTION_DOWN = 1;
        public static final int DRAGGABLE_DIRECTION_UP = 0;
        private int dismissingYPos;
        private int dismissingYVelocity;
        private int dragDirection;
        private int dragThresholdY;
        private boolean draggingDisabled;
        private int height;
        private int maxXPos;
        private int maxYPos;
        private int messageHeight;
        private int offScreenYPos;
        private int posY;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            private Companion() {
            }
        }

        public final int getDismissingYPos() {
            return this.dismissingYPos;
        }

        public final int getDismissingYVelocity() {
            return this.dismissingYVelocity;
        }

        public final int getDragDirection() {
            return this.dragDirection;
        }

        public final int getDragThresholdY() {
            return this.dragThresholdY;
        }

        public final boolean getDraggingDisabled() {
            return this.draggingDisabled;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getMaxXPos() {
            return this.maxXPos;
        }

        public final int getMaxYPos() {
            return this.maxYPos;
        }

        public final int getMessageHeight() {
            return this.messageHeight;
        }

        public final int getOffScreenYPos() {
            return this.offScreenYPos;
        }

        public final int getPosY() {
            return this.posY;
        }

        public final void setDismissingYPos(int i2) {
            this.dismissingYPos = i2;
        }

        public final void setDismissingYVelocity(int i2) {
            this.dismissingYVelocity = i2;
        }

        public final void setDragDirection(int i2) {
            this.dragDirection = i2;
        }

        public final void setDragThresholdY(int i2) {
            this.dragThresholdY = i2;
        }

        public final void setDraggingDisabled(boolean z2) {
            this.draggingDisabled = z2;
        }

        public final void setHeight(int i2) {
            this.height = i2;
        }

        public final void setMaxXPos(int i2) {
            this.maxXPos = i2;
        }

        public final void setMaxYPos(int i2) {
            this.maxYPos = i2;
        }

        public final void setMessageHeight(int i2) {
            this.messageHeight = i2;
        }

        public final void setOffScreenYPos(int i2) {
            this.offScreenYPos = i2;
        }

        public final void setPosY(int i2) {
            this.posY = i2;
        }
    }

    static {
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        MARGIN_PX_SIZE = viewUtils.dpToPx(28);
        EXTRA_PX_DISMISS = viewUtils.dpToPx(64);
    }

    public DraggableRelativeLayout(Context context) {
        super(context);
        setClipChildren(false);
        createDragHelper();
    }

    private final void createDragHelper() {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.createDragHelper.1
            private int lastYPos;

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View child, int i2, int i8) {
                k.e(child, "child");
                Params params = DraggableRelativeLayout.this.params;
                k.b(params);
                return params.getMaxXPos();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View child, int i2, int i8) {
                k.e(child, "child");
                Params params = DraggableRelativeLayout.this.params;
                k.b(params);
                if (params.getDraggingDisabled()) {
                    Params params2 = DraggableRelativeLayout.this.params;
                    k.b(params2);
                    return params2.getMaxYPos();
                }
                this.lastYPos = i2;
                Params params3 = DraggableRelativeLayout.this.params;
                k.b(params3);
                if (params3.getDragDirection() == 1) {
                    Params params4 = DraggableRelativeLayout.this.params;
                    k.b(params4);
                    if (i2 >= params4.getDragThresholdY() && DraggableRelativeLayout.this.mListener != null) {
                        DraggableListener draggableListener = DraggableRelativeLayout.this.mListener;
                        k.b(draggableListener);
                        draggableListener.onDragStart();
                    }
                    Params params5 = DraggableRelativeLayout.this.params;
                    k.b(params5);
                    if (i2 < params5.getMaxYPos()) {
                        Params params6 = DraggableRelativeLayout.this.params;
                        k.b(params6);
                        return params6.getMaxYPos();
                    }
                } else {
                    Params params7 = DraggableRelativeLayout.this.params;
                    k.b(params7);
                    if (i2 <= params7.getDragThresholdY() && DraggableRelativeLayout.this.mListener != null) {
                        DraggableListener draggableListener2 = DraggableRelativeLayout.this.mListener;
                        k.b(draggableListener2);
                        draggableListener2.onDragStart();
                    }
                    Params params8 = DraggableRelativeLayout.this.params;
                    k.b(params8);
                    if (i2 > params8.getMaxYPos()) {
                        Params params9 = DraggableRelativeLayout.this.params;
                        k.b(params9);
                        return params9.getMaxYPos();
                    }
                }
                return i2;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0097  */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onViewReleased(android.view.View r3, float r4, float r5) {
                /*
                    Method dump skipped, instruction units count: 223
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.AnonymousClass1.onViewReleased(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View child, int i2) {
                k.e(child, "child");
                return true;
            }
        });
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        ViewDragHelper viewDragHelper = this.mDragHelper;
        k.b(viewDragHelper);
        if (viewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void dismiss() {
        this.dismissing = true;
        ViewDragHelper viewDragHelper = this.mDragHelper;
        k.b(viewDragHelper);
        int left = getLeft();
        Params params = this.params;
        k.b(params);
        viewDragHelper.smoothSlideViewTo(this, left, params.getOffScreenYPos());
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        DraggableListener draggableListener;
        k.e(event, "event");
        if (this.dismissing) {
            return true;
        }
        int action = event.getAction();
        if ((action == 0 || action == 5) && (draggableListener = this.mListener) != null) {
            k.b(draggableListener);
            draggableListener.onDragEnd();
        }
        ViewDragHelper viewDragHelper = this.mDragHelper;
        k.b(viewDragHelper);
        viewDragHelper.processTouchEvent(event);
        return false;
    }

    public final void setListener(DraggableListener draggableListener) {
        this.mListener = draggableListener;
    }

    public final void setParams(Params params) {
        k.e(params, "params");
        this.params = params;
        params.setOffScreenYPos(((Resources.getSystem().getDisplayMetrics().heightPixels - params.getMessageHeight()) - params.getPosY()) + params.getPosY() + params.getMessageHeight() + EXTRA_PX_DISMISS);
        params.setDismissingYVelocity(ViewUtils.INSTANCE.dpToPx(3000));
        if (params.getDragDirection() != 0) {
            params.setDismissingYPos((params.getMaxYPos() * 2) + (params.getMessageHeight() / 3));
        } else {
            params.setOffScreenYPos((-params.getMessageHeight()) - MARGIN_PX_SIZE);
            params.setDismissingYVelocity(-params.getDismissingYVelocity());
            params.setDismissingYPos(params.getOffScreenYPos() / 3);
        }
    }
}
