package androidx.constraintlayout.core.parser;

import a1.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CLNumber extends CLElement {
    float mValue;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.mValue = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLNumber) {
            float f4 = getFloat();
            float f8 = ((CLNumber) obj).getFloat();
            if ((Float.isNaN(f4) && Float.isNaN(f8)) || f4 == f8) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Float.parseFloat(content());
        }
        return this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Integer.parseInt(content());
        }
        return (int) this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        float f4 = this.mValue;
        return iHashCode + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0);
    }

    public boolean isInt() {
        float f4 = getFloat();
        return ((float) ((int) f4)) == f4;
    }

    public void putValue(float f4) {
        this.mValue = f4;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i2, int i8) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i2);
        float f4 = getFloat();
        int i9 = (int) f4;
        if (i9 == f4) {
            sb.append(i9);
        } else {
            sb.append(f4);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        float f4 = getFloat();
        int i2 = (int) f4;
        if (i2 == f4) {
            return a.g(i2, "");
        }
        return "" + f4;
    }

    public CLNumber(float f4) {
        super(null);
        this.mValue = f4;
    }
}
