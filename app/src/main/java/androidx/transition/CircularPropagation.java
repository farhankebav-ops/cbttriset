package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CircularPropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;

    private static float distance(float f4, float f8, float f9, float f10) {
        float f11 = f9 - f4;
        float f12 = f10 - f8;
        return (float) Math.sqrt((f12 * f12) + (f11 * f11));
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i2;
        int iRound;
        int iCenterX;
        if (transitionValues == null && transitionValues2 == null) {
            return 0L;
        }
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i2 = -1;
        } else {
            transitionValues = transitionValues2;
            i2 = 1;
        }
        int viewX = getViewX(transitionValues);
        int viewY = getViewY(transitionValues);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            iCenterX = epicenter.centerX();
            iRound = epicenter.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int iRound2 = Math.round(viewGroup.getTranslationX() + (viewGroup.getWidth() / 2) + r5[0]);
            iRound = Math.round(viewGroup.getTranslationY() + (viewGroup.getHeight() / 2) + r5[1]);
            iCenterX = iRound2;
        }
        float fDistance = distance(viewX, viewY, iCenterX, iRound) / distance(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round(((duration * ((long) i2)) / this.mPropagationSpeed) * fDistance);
    }

    public void setPropagationSpeed(float f4) {
        if (f4 == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f4;
    }
}
