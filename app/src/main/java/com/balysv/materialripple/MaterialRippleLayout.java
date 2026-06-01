package com.balysv.materialripple;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MaterialRippleLayout extends FrameLayout {
    private static final float DEFAULT_ALPHA = 0.2f;
    private static final int DEFAULT_BACKGROUND = 0;
    private static final int DEFAULT_COLOR = -16777216;
    private static final boolean DEFAULT_DELAY_CLICK = true;
    private static final float DEFAULT_DIAMETER_DP = 35.0f;
    private static final int DEFAULT_DURATION = 350;
    private static final int DEFAULT_FADE_DURATION = 75;
    private static final boolean DEFAULT_HOVER = true;
    private static final boolean DEFAULT_PERSISTENT = false;
    private static final boolean DEFAULT_RIPPLE_OVERLAY = false;
    private static final int DEFAULT_ROUNDED_CORNERS = 0;
    private static final boolean DEFAULT_SEARCH_ADAPTER = false;
    private static final int FADE_EXTRA_DELAY = 50;
    private static final long HOVER_DURATION = 2500;
    private final Rect bounds;
    private View childView;
    private Property<MaterialRippleLayout, Integer> circleAlphaProperty;
    private Point currentCoords;
    private boolean eventCancelled;
    private GestureDetector gestureDetector;
    private boolean hasPerformedLongPress;
    private ObjectAnimator hoverAnimator;
    private int layerType;
    private GestureDetector.SimpleOnGestureListener longClickListener;
    private final Paint paint;
    private AdapterView parentAdapter;
    private PerformClickEvent pendingClickEvent;
    private PressedEvent pendingPressEvent;
    private int positionInAdapter;
    private boolean prepressed;
    private Point previousCoords;
    private float radius;
    private Property<MaterialRippleLayout, Float> radiusProperty;
    private int rippleAlpha;
    private AnimatorSet rippleAnimator;
    private Drawable rippleBackground;
    private int rippleColor;
    private boolean rippleDelayClick;
    private int rippleDiameter;
    private int rippleDuration;
    private int rippleFadeDuration;
    private boolean rippleHover;
    private boolean rippleInAdapter;
    private boolean rippleOverlay;
    private boolean ripplePersistent;
    private float rippleRoundedCorners;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class PerformClickEvent implements Runnable {
        private PerformClickEvent() {
        }

        private void clickAdapterView(AdapterView adapterView) {
            int positionForView = adapterView.getPositionForView(MaterialRippleLayout.this);
            long itemId = adapterView.getAdapter() != null ? adapterView.getAdapter().getItemId(positionForView) : 0L;
            if (positionForView != -1) {
                adapterView.performItemClick(MaterialRippleLayout.this, positionForView, itemId);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MaterialRippleLayout.this.hasPerformedLongPress) {
                return;
            }
            if (MaterialRippleLayout.this.getParent() instanceof AdapterView) {
                clickAdapterView((AdapterView) MaterialRippleLayout.this.getParent());
            } else if (MaterialRippleLayout.this.rippleInAdapter) {
                clickAdapterView(MaterialRippleLayout.this.findParentAdapterView());
            } else {
                MaterialRippleLayout.this.childView.performClick();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class PressedEvent implements Runnable {
        private final MotionEvent event;

        public PressedEvent(MotionEvent motionEvent) {
            this.event = motionEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialRippleLayout.this.prepressed = false;
            MaterialRippleLayout.this.childView.setLongClickable(false);
            MaterialRippleLayout.this.childView.onTouchEvent(this.event);
            MaterialRippleLayout.this.childView.setPressed(true);
            if (MaterialRippleLayout.this.rippleHover) {
                MaterialRippleLayout.this.startHover();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class RippleBuilder {
        private final View child;
        private final Context context;
        private int rippleColor = -16777216;
        private boolean rippleOverlay = false;
        private boolean rippleHover = true;
        private float rippleDiameter = MaterialRippleLayout.DEFAULT_DIAMETER_DP;
        private int rippleDuration = MaterialRippleLayout.DEFAULT_DURATION;
        private float rippleAlpha = 0.2f;
        private boolean rippleDelayClick = true;
        private int rippleFadeDuration = MaterialRippleLayout.DEFAULT_FADE_DURATION;
        private boolean ripplePersistent = false;
        private int rippleBackground = 0;
        private boolean rippleSearchAdapter = false;
        private float rippleRoundedCorner = 0.0f;

        public RippleBuilder(View view) {
            this.child = view;
            this.context = view.getContext();
        }

        public MaterialRippleLayout create() {
            int iIndexOfChild;
            MaterialRippleLayout materialRippleLayout = new MaterialRippleLayout(this.context);
            materialRippleLayout.setRippleColor(this.rippleColor);
            materialRippleLayout.setDefaultRippleAlpha((int) this.rippleAlpha);
            materialRippleLayout.setRippleDelayClick(this.rippleDelayClick);
            materialRippleLayout.setRippleDiameter((int) MaterialRippleLayout.dpToPx(this.context.getResources(), this.rippleDiameter));
            materialRippleLayout.setRippleDuration(this.rippleDuration);
            materialRippleLayout.setRippleFadeDuration(this.rippleFadeDuration);
            materialRippleLayout.setRippleHover(this.rippleHover);
            materialRippleLayout.setRipplePersistent(this.ripplePersistent);
            materialRippleLayout.setRippleOverlay(this.rippleOverlay);
            materialRippleLayout.setRippleBackground(this.rippleBackground);
            materialRippleLayout.setRippleInAdapter(this.rippleSearchAdapter);
            materialRippleLayout.setRippleRoundedCorners((int) MaterialRippleLayout.dpToPx(this.context.getResources(), this.rippleRoundedCorner));
            ViewGroup.LayoutParams layoutParams = this.child.getLayoutParams();
            ViewGroup viewGroup = (ViewGroup) this.child.getParent();
            if (viewGroup != null && (viewGroup instanceof MaterialRippleLayout)) {
                throw new IllegalStateException("MaterialRippleLayout could not be created: parent of the view already is a MaterialRippleLayout");
            }
            if (viewGroup != null) {
                iIndexOfChild = viewGroup.indexOfChild(this.child);
                viewGroup.removeView(this.child);
            } else {
                iIndexOfChild = 0;
            }
            materialRippleLayout.addView(this.child, new ViewGroup.LayoutParams(-1, -1));
            if (viewGroup != null) {
                viewGroup.addView(materialRippleLayout, iIndexOfChild, layoutParams);
            }
            return materialRippleLayout;
        }

        public RippleBuilder rippleAlpha(float f4) {
            this.rippleAlpha = f4 * 255.0f;
            return this;
        }

        public RippleBuilder rippleBackground(int i2) {
            this.rippleBackground = i2;
            return this;
        }

        public RippleBuilder rippleColor(int i2) {
            this.rippleColor = i2;
            return this;
        }

        public RippleBuilder rippleDelayClick(boolean z2) {
            this.rippleDelayClick = z2;
            return this;
        }

        public RippleBuilder rippleDiameterDp(int i2) {
            this.rippleDiameter = i2;
            return this;
        }

        public RippleBuilder rippleDuration(int i2) {
            this.rippleDuration = i2;
            return this;
        }

        public RippleBuilder rippleFadeDuration(int i2) {
            this.rippleFadeDuration = i2;
            return this;
        }

        public RippleBuilder rippleHover(boolean z2) {
            this.rippleHover = z2;
            return this;
        }

        public RippleBuilder rippleInAdapter(boolean z2) {
            this.rippleSearchAdapter = z2;
            return this;
        }

        public RippleBuilder rippleOverlay(boolean z2) {
            this.rippleOverlay = z2;
            return this;
        }

        public RippleBuilder ripplePersistent(boolean z2) {
            this.ripplePersistent = z2;
            return this;
        }

        public RippleBuilder rippleRoundedCorners(int i2) {
            this.rippleRoundedCorner = i2;
            return this;
        }
    }

    public MaterialRippleLayout(Context context) {
        this(context, null, 0);
    }

    private boolean adapterPositionChanged() {
        if (!this.rippleInAdapter) {
            return false;
        }
        int positionForView = findParentAdapterView().getPositionForView(this);
        boolean z2 = positionForView != this.positionInAdapter;
        this.positionInAdapter = positionForView;
        if (z2) {
            cancelPressedEvent();
            cancelAnimations();
            this.childView.setPressed(false);
            setRadius(0.0f);
        }
        return z2;
    }

    private void cancelAnimations() {
        AnimatorSet animatorSet = this.rippleAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.rippleAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator = this.hoverAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelPressedEvent() {
        PressedEvent pressedEvent = this.pendingPressEvent;
        if (pressedEvent != null) {
            removeCallbacks(pressedEvent);
            this.prepressed = false;
        }
    }

    public static float dpToPx(Resources resources, float f4) {
        return TypedValue.applyDimension(1, f4, resources.getDisplayMetrics());
    }

    private boolean findClickableViewInChild(View view, int i2, int i8) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                View childAt = viewGroup.getChildAt(i9);
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                if (rect.contains(i2, i8)) {
                    return findClickableViewInChild(childAt, i2 - rect.left, i8 - rect.top);
                }
            }
        } else if (view != this.childView) {
            return view.isEnabled() && (view.isClickable() || view.isLongClickable() || view.isFocusableInTouchMode());
        }
        return view.isFocusableInTouchMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdapterView findParentAdapterView() {
        AdapterView adapterView = this.parentAdapter;
        if (adapterView != null) {
            return adapterView;
        }
        ViewParent parent = getParent();
        while (!(parent instanceof AdapterView)) {
            try {
                parent = parent.getParent();
            } catch (NullPointerException unused) {
                throw new RuntimeException("Could not find a parent AdapterView");
            }
        }
        AdapterView adapterView2 = (AdapterView) parent;
        this.parentAdapter = adapterView2;
        return adapterView2;
    }

    private float getEndRadius() {
        int width = getWidth();
        int i2 = width / 2;
        int height = getHeight() / 2;
        Point point = this.currentCoords;
        int i8 = point.x;
        float f4 = i2 > i8 ? width - i8 : i8;
        return ((float) Math.sqrt(Math.pow(height > point.y ? r1 - r2 : r2, 2.0d) + Math.pow(f4, 2.0d))) * 1.2f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getRadius() {
        return this.radius;
    }

    private boolean isInScrollingContainer() {
        for (ViewParent parent = getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
            if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public static RippleBuilder on(View view) {
        return new RippleBuilder(view);
    }

    private void setPositionInAdapter() {
        if (this.rippleInAdapter) {
            this.positionInAdapter = findParentAdapterView().getPositionForView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startHover() {
        if (this.eventCancelled) {
            return;
        }
        ObjectAnimator objectAnimator = this.hoverAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, this.radiusProperty, this.rippleDiameter, (float) (Math.sqrt(Math.pow(getHeight(), 2.0d) + Math.pow(getWidth(), 2.0d)) * 1.2000000476837158d)).setDuration(HOVER_DURATION);
        this.hoverAnimator = duration;
        duration.setInterpolator(new LinearInterpolator());
        this.hoverAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRipple(final Runnable runnable) {
        if (this.eventCancelled) {
            return;
        }
        float endRadius = getEndRadius();
        cancelAnimations();
        AnimatorSet animatorSet = new AnimatorSet();
        this.rippleAnimator = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.balysv.materialripple.MaterialRippleLayout.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!MaterialRippleLayout.this.ripplePersistent) {
                    MaterialRippleLayout.this.setRadius(0.0f);
                    MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
                    materialRippleLayout.setRippleAlpha(Integer.valueOf(materialRippleLayout.rippleAlpha));
                }
                if (runnable != null && MaterialRippleLayout.this.rippleDelayClick) {
                    runnable.run();
                }
                MaterialRippleLayout.this.childView.setPressed(false);
            }
        });
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, this.radiusProperty, this.radius, endRadius);
        objectAnimatorOfFloat.setDuration(this.rippleDuration);
        objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, this.circleAlphaProperty, this.rippleAlpha, 0);
        objectAnimatorOfInt.setDuration(this.rippleFadeDuration);
        objectAnimatorOfInt.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfInt.setStartDelay((this.rippleDuration - this.rippleFadeDuration) - 50);
        if (this.ripplePersistent) {
            this.rippleAnimator.play(objectAnimatorOfFloat);
        } else if (getRadius() > endRadius) {
            objectAnimatorOfInt.setStartDelay(0L);
            this.rippleAnimator.play(objectAnimatorOfInt);
        } else {
            this.rippleAnimator.playTogether(objectAnimatorOfFloat, objectAnimatorOfInt);
        }
        this.rippleAnimator.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("MaterialRippleLayout can host only one child");
        }
        this.childView = view;
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean zAdapterPositionChanged = adapterPositionChanged();
        if (!this.rippleOverlay) {
            if (!zAdapterPositionChanged) {
                this.rippleBackground.draw(canvas);
                Point point = this.currentCoords;
                canvas.drawCircle(point.x, point.y, this.radius, this.paint);
            }
            super.draw(canvas);
            return;
        }
        if (!zAdapterPositionChanged) {
            this.rippleBackground.draw(canvas);
        }
        super.draw(canvas);
        if (zAdapterPositionChanged) {
            return;
        }
        if (this.rippleRoundedCorners != 0.0f) {
            Path path = new Path();
            RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            float f4 = this.rippleRoundedCorners;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
            canvas.clipPath(path);
        }
        Point point2 = this.currentCoords;
        canvas.drawCircle(point2.x, point2.y, this.radius, this.paint);
    }

    public <T extends View> T getChildView() {
        return (T) this.childView;
    }

    public int getRippleAlpha() {
        return this.paint.getAlpha();
    }

    @Override // android.view.View
    public boolean isInEditMode() {
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !findClickableViewInChild(this.childView, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i8, int i9, int i10) {
        super.onSizeChanged(i2, i8, i9, i10);
        this.bounds.set(0, 0, i2, i8);
        this.rippleBackground.setBounds(this.bounds);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (!isEnabled() || !this.childView.isEnabled()) {
            return zOnTouchEvent;
        }
        boolean zContains = this.bounds.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        if (zContains) {
            Point point = this.previousCoords;
            Point point2 = this.currentCoords;
            point.set(point2.x, point2.y);
            this.currentCoords.set((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.gestureDetector.onTouchEvent(motionEvent) && !this.hasPerformedLongPress) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    this.pendingClickEvent = new PerformClickEvent();
                    if (this.prepressed) {
                        this.childView.setPressed(true);
                        postDelayed(new Runnable() { // from class: com.balysv.materialripple.MaterialRippleLayout.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MaterialRippleLayout.this.childView.setPressed(false);
                            }
                        }, ViewConfiguration.getPressedStateDuration());
                    }
                    if (zContains) {
                        startRipple(this.pendingClickEvent);
                    } else if (!this.rippleHover) {
                        setRadius(0.0f);
                    }
                    if (!this.rippleDelayClick && zContains) {
                        this.pendingClickEvent.run();
                    }
                    cancelPressedEvent();
                } else if (actionMasked == 2) {
                    if (this.rippleHover) {
                        if (zContains && !this.eventCancelled) {
                            invalidate();
                        } else if (!zContains) {
                            startRipple(null);
                        }
                    }
                    if (!zContains) {
                        cancelPressedEvent();
                        ObjectAnimator objectAnimator = this.hoverAnimator;
                        if (objectAnimator != null) {
                            objectAnimator.cancel();
                        }
                        this.childView.onTouchEvent(motionEvent);
                        this.eventCancelled = true;
                    }
                } else if (actionMasked == 3) {
                    if (this.rippleInAdapter) {
                        Point point3 = this.currentCoords;
                        Point point4 = this.previousCoords;
                        point3.set(point4.x, point4.y);
                        this.previousCoords = new Point();
                    }
                    this.childView.onTouchEvent(motionEvent);
                    if (!this.rippleHover) {
                        this.childView.setPressed(false);
                    } else if (!this.prepressed) {
                        startRipple(null);
                    }
                    cancelPressedEvent();
                }
            } else {
                setPositionInAdapter();
                this.eventCancelled = false;
                this.pendingPressEvent = new PressedEvent(motionEvent);
                if (isInScrollingContainer()) {
                    cancelPressedEvent();
                    this.prepressed = true;
                    postDelayed(this.pendingPressEvent, ViewConfiguration.getTapTimeout());
                } else {
                    this.pendingPressEvent.run();
                }
            }
        }
        return true;
    }

    public void performRipple() {
        this.currentCoords = new Point(getWidth() / 2, getHeight() / 2);
        startRipple(null);
    }

    public void setDefaultRippleAlpha(int i2) {
        this.rippleAlpha = i2;
        this.paint.setAlpha(i2);
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        View view = this.childView;
        if (view == null) {
            throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
        }
        view.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        View view = this.childView;
        if (view == null) {
            throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
        }
        view.setOnLongClickListener(onLongClickListener);
    }

    public void setRadius(float f4) {
        this.radius = f4;
        invalidate();
    }

    public void setRippleAlpha(Integer num) {
        this.paint.setAlpha(num.intValue());
        invalidate();
    }

    public void setRippleBackground(int i2) {
        ColorDrawable colorDrawable = new ColorDrawable(i2);
        this.rippleBackground = colorDrawable;
        colorDrawable.setBounds(this.bounds);
        invalidate();
    }

    public void setRippleColor(int i2) {
        this.rippleColor = i2;
        this.paint.setColor(i2);
        this.paint.setAlpha(this.rippleAlpha);
        invalidate();
    }

    public void setRippleDelayClick(boolean z2) {
        this.rippleDelayClick = z2;
    }

    public void setRippleDiameter(int i2) {
        this.rippleDiameter = i2;
    }

    public void setRippleDuration(int i2) {
        this.rippleDuration = i2;
    }

    public void setRippleFadeDuration(int i2) {
        this.rippleFadeDuration = i2;
    }

    public void setRippleHover(boolean z2) {
        this.rippleHover = z2;
    }

    public void setRippleInAdapter(boolean z2) {
        this.rippleInAdapter = z2;
    }

    public void setRippleOverlay(boolean z2) {
        this.rippleOverlay = z2;
    }

    public void setRipplePersistent(boolean z2) {
        this.ripplePersistent = z2;
    }

    public void setRippleRoundedCorners(int i2) {
        this.rippleRoundedCorners = i2;
        enableClipPathSupportIfNecessary();
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialRippleLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Paint paint = new Paint(1);
        this.paint = paint;
        this.bounds = new Rect();
        this.currentCoords = new Point();
        this.previousCoords = new Point();
        this.longClickListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.balysv.materialripple.MaterialRippleLayout.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                MaterialRippleLayout.this.hasPerformedLongPress = false;
                return super.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                MaterialRippleLayout materialRippleLayout = MaterialRippleLayout.this;
                materialRippleLayout.hasPerformedLongPress = materialRippleLayout.childView.performLongClick();
                if (MaterialRippleLayout.this.hasPerformedLongPress) {
                    if (MaterialRippleLayout.this.rippleHover) {
                        MaterialRippleLayout.this.startRipple(null);
                    }
                    MaterialRippleLayout.this.cancelPressedEvent();
                }
            }
        };
        this.radiusProperty = new Property<MaterialRippleLayout, Float>(Float.class, "radius") { // from class: com.balysv.materialripple.MaterialRippleLayout.4
            @Override // android.util.Property
            public Float get(MaterialRippleLayout materialRippleLayout) {
                return Float.valueOf(materialRippleLayout.getRadius());
            }

            @Override // android.util.Property
            public void set(MaterialRippleLayout materialRippleLayout, Float f4) {
                materialRippleLayout.setRadius(f4.floatValue());
            }
        };
        this.circleAlphaProperty = new Property<MaterialRippleLayout, Integer>(Integer.class, "rippleAlpha") { // from class: com.balysv.materialripple.MaterialRippleLayout.5
            @Override // android.util.Property
            public Integer get(MaterialRippleLayout materialRippleLayout) {
                return Integer.valueOf(materialRippleLayout.getRippleAlpha());
            }

            @Override // android.util.Property
            public void set(MaterialRippleLayout materialRippleLayout, Integer num) {
                materialRippleLayout.setRippleAlpha(num);
            }
        };
        setWillNotDraw(false);
        this.gestureDetector = new GestureDetector(context, this.longClickListener);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialRippleLayout);
        this.rippleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialRippleLayout_mrl_rippleColor, -16777216);
        this.rippleDiameter = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialRippleLayout_mrl_rippleDimension, (int) dpToPx(getResources(), DEFAULT_DIAMETER_DP));
        this.rippleOverlay = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleOverlay, false);
        this.rippleHover = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleHover, true);
        this.rippleDuration = typedArrayObtainStyledAttributes.getInt(R.styleable.MaterialRippleLayout_mrl_rippleDuration, DEFAULT_DURATION);
        this.rippleAlpha = (int) (typedArrayObtainStyledAttributes.getFloat(R.styleable.MaterialRippleLayout_mrl_rippleAlpha, 0.2f) * 255.0f);
        this.rippleDelayClick = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleDelayClick, true);
        this.rippleFadeDuration = typedArrayObtainStyledAttributes.getInteger(R.styleable.MaterialRippleLayout_mrl_rippleFadeDuration, DEFAULT_FADE_DURATION);
        this.rippleBackground = new ColorDrawable(typedArrayObtainStyledAttributes.getColor(R.styleable.MaterialRippleLayout_mrl_rippleBackground, 0));
        this.ripplePersistent = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_ripplePersistent, false);
        this.rippleInAdapter = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MaterialRippleLayout_mrl_rippleInAdapter, false);
        this.rippleRoundedCorners = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialRippleLayout_mrl_rippleRoundedCorners, 0);
        typedArrayObtainStyledAttributes.recycle();
        paint.setColor(this.rippleColor);
        paint.setAlpha(this.rippleAlpha);
        enableClipPathSupportIfNecessary();
    }

    public void performRipple(Point point) {
        this.currentCoords = new Point(point.x, point.y);
        startRipple(null);
    }

    private void enableClipPathSupportIfNecessary() {
    }
}
