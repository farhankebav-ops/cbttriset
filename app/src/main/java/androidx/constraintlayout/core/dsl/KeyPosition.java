package androidx.constraintlayout.core.dsl;

import androidx.camera.core.processing.util.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class KeyPosition extends Keys {
    private int mFrame;
    private String mTarget;
    private String mTransitionEasing = null;
    private float mPercentWidth = Float.NaN;
    private float mPercentHeight = Float.NaN;
    private float mPercentX = Float.NaN;
    private float mPercentY = Float.NaN;
    private Type mPositionType = Type.CARTESIAN;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum Type {
        CARTESIAN,
        SCREEN,
        PATH
    }

    public KeyPosition(String str, int i2) {
        this.mTarget = null;
        this.mFrame = 0;
        this.mTarget = str;
        this.mFrame = i2;
    }

    public int getFrames() {
        return this.mFrame;
    }

    public float getPercentHeight() {
        return this.mPercentHeight;
    }

    public float getPercentWidth() {
        return this.mPercentWidth;
    }

    public float getPercentX() {
        return this.mPercentX;
    }

    public float getPercentY() {
        return this.mPercentY;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public String getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setFrames(int i2) {
        this.mFrame = i2;
    }

    public void setPercentHeight(float f4) {
        this.mPercentHeight = f4;
    }

    public void setPercentWidth(float f4) {
        this.mPercentWidth = f4;
    }

    public void setPercentX(float f4) {
        this.mPercentX = f4;
    }

    public void setPercentY(float f4) {
        this.mPercentY = f4;
    }

    public void setPositionType(Type type) {
        this.mPositionType = type;
    }

    public void setTarget(String str) {
        this.mTarget = str;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public String toString() {
        StringBuilder sbR = a.r("KeyPositions:{\n");
        append(sbR, TypedValues.AttributesType.S_TARGET, this.mTarget);
        sbR.append("frame:");
        sbR.append(this.mFrame);
        sbR.append(",\n");
        if (this.mPositionType != null) {
            sbR.append("type:'");
            sbR.append(this.mPositionType);
            sbR.append("',\n");
        }
        append(sbR, "easing", this.mTransitionEasing);
        append(sbR, "percentX", this.mPercentX);
        append(sbR, "percentY", this.mPercentY);
        append(sbR, "percentWidth", this.mPercentWidth);
        append(sbR, "percentHeight", this.mPercentHeight);
        sbR.append("},\n");
        return sbR.toString();
    }
}
