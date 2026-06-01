package androidx.constraintlayout.core.dsl;

import androidx.camera.core.processing.util.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class KeyPositions extends Keys {
    private int[] mFrames;
    private String[] mTarget;
    private String mTransitionEasing = null;
    private Type mPositionType = null;
    private float[] mPercentWidth = null;
    private float[] mPercentHeight = null;
    private float[] mPercentX = null;
    private float[] mPercentY = null;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum Type {
        CARTESIAN,
        SCREEN,
        PATH
    }

    public KeyPositions(int i2, String... strArr) {
        this.mFrames = null;
        this.mTarget = strArr;
        this.mFrames = new int[i2];
        float length = 100.0f / (r3.length + 1);
        int i8 = 0;
        while (true) {
            int[] iArr = this.mFrames;
            if (i8 >= iArr.length) {
                return;
            }
            iArr[i8] = (int) ((i8 * length) + length);
            i8++;
        }
    }

    public int[] getFrames() {
        return this.mFrames;
    }

    public float[] getPercentHeight() {
        return this.mPercentHeight;
    }

    public float[] getPercentWidth() {
        return this.mPercentWidth;
    }

    public float[] getPercentX() {
        return this.mPercentX;
    }

    public float[] getPercentY() {
        return this.mPercentY;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public String[] getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setFrames(int... iArr) {
        this.mFrames = iArr;
    }

    public void setPercentHeight(float... fArr) {
        this.mPercentHeight = fArr;
    }

    public void setPercentWidth(float... fArr) {
        this.mPercentWidth = fArr;
    }

    public void setPercentX(float... fArr) {
        this.mPercentX = fArr;
    }

    public void setPercentY(float... fArr) {
        this.mPercentY = fArr;
    }

    public void setPositionType(Type type) {
        this.mPositionType = type;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public String toString() {
        StringBuilder sbR = a.r("KeyPositions:{\n");
        append(sbR, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sbR.append("frame:");
        sbR.append(Arrays.toString(this.mFrames));
        sbR.append(",\n");
        if (this.mPositionType != null) {
            sbR.append("type:'");
            sbR.append(this.mPositionType);
            sbR.append("',\n");
        }
        append(sbR, "easing", this.mTransitionEasing);
        append(sbR, "percentX", this.mPercentX);
        append(sbR, "percentX", this.mPercentY);
        append(sbR, "percentWidth", this.mPercentWidth);
        append(sbR, "percentHeight", this.mPercentHeight);
        sbR.append("},\n");
        return sbR.toString();
    }
}
