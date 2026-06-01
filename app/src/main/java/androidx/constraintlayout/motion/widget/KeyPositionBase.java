package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    public abstract void calcPosition(int i2, int i8, float f4, float f8, float f9, float f10);

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int i2, int i8, RectF rectF, RectF rectF2, float f4, float f8);

    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f4, float f8, String[] strArr, float[] fArr);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }
}
