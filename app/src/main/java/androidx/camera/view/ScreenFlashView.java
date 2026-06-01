package androidx.camera.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.internal.ScreenFlashUiInfo;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenFlashView extends View {
    private static final long ANIMATION_DURATION_MILLIS = 1000;
    private static final String TAG = "ScreenFlashView";
    private CameraController mCameraController;
    private ImageCapture.ScreenFlash mScreenFlash;
    private Window mScreenFlashWindow;

    @UiThread
    public ScreenFlashView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator animateToFullOpacity(final Runnable runnable) {
        Logger.d(TAG, "animateToFullOpacity");
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(getVisibilityRampUpAnimationDurationMillis());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.camera.view.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f3907a.lambda$animateToFullOpacity$0(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.camera.view.ScreenFlashView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Logger.d(ScreenFlashView.TAG, "ScreenFlash#apply: onAnimationEnd");
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
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
        valueAnimatorOfFloat.start();
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getBrightness() {
        Window window = this.mScreenFlashWindow;
        if (window != null) {
            return window.getAttributes().screenBrightness;
        }
        Logger.e(TAG, "setBrightness: mScreenFlashWindow is null!");
        return Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateToFullOpacity$0(ValueAnimator valueAnimator) {
        Logger.d(TAG, "animateToFullOpacity: value = " + ((Float) valueAnimator.getAnimatedValue()).floatValue());
        setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrightness(float f4) {
        if (this.mScreenFlashWindow == null) {
            Logger.e(TAG, "setBrightness: mScreenFlashWindow is null!");
            return;
        }
        if (Float.isNaN(f4)) {
            Logger.e(TAG, "setBrightness: value is NaN!");
            return;
        }
        WindowManager.LayoutParams attributes = this.mScreenFlashWindow.getAttributes();
        attributes.screenBrightness = f4;
        this.mScreenFlashWindow.setAttributes(attributes);
        Logger.d(TAG, "Brightness set to " + attributes.screenBrightness);
    }

    private void setScreenFlashUiInfo(ImageCapture.ScreenFlash screenFlash) {
        CameraController cameraController = this.mCameraController;
        if (cameraController == null) {
            Logger.d(TAG, "setScreenFlashUiInfo: mCameraController is null!");
        } else {
            cameraController.setScreenFlashUiInfo(new ScreenFlashUiInfo(ScreenFlashUiInfo.ProviderType.SCREEN_FLASH_VIEW, screenFlash));
        }
    }

    private void updateScreenFlash(Window window) {
        StringBuilder sb = new StringBuilder("updateScreenFlash: is new window null = ");
        sb.append(window == null);
        sb.append(",  is new window same as previous = ");
        sb.append(window == this.mScreenFlashWindow);
        Logger.d(TAG, sb.toString());
        if (this.mScreenFlashWindow != window) {
            this.mScreenFlash = window == null ? null : new ImageCapture.ScreenFlash() { // from class: androidx.camera.view.ScreenFlashView.1
                private ValueAnimator mAnimator;
                private float mPreviousBrightness;

                @Override // androidx.camera.core.ImageCapture.ScreenFlash
                public void apply(long j, ImageCapture.ScreenFlashListener screenFlashListener) {
                    Logger.d(ScreenFlashView.TAG, "ScreenFlash#apply");
                    this.mPreviousBrightness = ScreenFlashView.this.getBrightness();
                    ScreenFlashView.this.setBrightness(1.0f);
                    ValueAnimator valueAnimator = this.mAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                    }
                    ScreenFlashView screenFlashView = ScreenFlashView.this;
                    Objects.requireNonNull(screenFlashListener);
                    this.mAnimator = screenFlashView.animateToFullOpacity(new a(screenFlashListener, 3));
                }

                @Override // androidx.camera.core.ImageCapture.ScreenFlash
                public void clear() {
                    Logger.d(ScreenFlashView.TAG, "ScreenFlash#clear");
                    ValueAnimator valueAnimator = this.mAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                        this.mAnimator = null;
                    }
                    ScreenFlashView.this.setAlpha(0.0f);
                    ScreenFlashView.this.setBrightness(this.mPreviousBrightness);
                }
            };
        }
    }

    @UiThread
    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public long getVisibilityRampUpAnimationDurationMillis() {
        return 1000L;
    }

    @UiThread
    public void setController(CameraController cameraController) {
        Threads.checkMainThread();
        CameraController cameraController2 = this.mCameraController;
        if (cameraController2 != null && cameraController2 != cameraController) {
            setScreenFlashUiInfo(null);
        }
        this.mCameraController = cameraController;
        if (cameraController == null) {
            return;
        }
        if (cameraController.getImageCaptureFlashMode() == 3 && this.mScreenFlashWindow == null) {
            throw new IllegalStateException("No window set despite setting FLASH_MODE_SCREEN in CameraController");
        }
        setScreenFlashUiInfo(getScreenFlash());
    }

    @UiThread
    public void setScreenFlashWindow(Window window) {
        Threads.checkMainThread();
        updateScreenFlash(window);
        this.mScreenFlashWindow = window;
        setScreenFlashUiInfo(getScreenFlash());
    }

    @UiThread
    public ScreenFlashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @UiThread
    public ScreenFlashView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    @UiThread
    public ScreenFlashView(Context context, AttributeSet attributeSet, int i2, int i8) {
        super(context, attributeSet, i2, i8);
        setBackgroundColor(-1);
        setAlpha(0.0f);
        setElevation(Float.MAX_VALUE);
    }
}
