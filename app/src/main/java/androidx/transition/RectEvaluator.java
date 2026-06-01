package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f4, Rect rect, Rect rect2) {
        int i2 = rect.left + ((int) ((rect2.left - r0) * f4));
        int i8 = rect.top + ((int) ((rect2.top - r1) * f4));
        int i9 = rect.right + ((int) ((rect2.right - r2) * f4));
        int i10 = rect.bottom + ((int) ((rect2.bottom - r6) * f4));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i2, i8, i9, i10);
        }
        rect3.set(i2, i8, i9, i10);
        return this.mRect;
    }
}
