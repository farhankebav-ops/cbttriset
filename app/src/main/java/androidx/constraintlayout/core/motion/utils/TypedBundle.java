package androidx.constraintlayout.core.motion.utils;

import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;
    int[] mTypeInt = new int[10];
    int[] mValueInt = new int[10];
    int mCountInt = 0;
    int[] mTypeFloat = new int[10];
    float[] mValueFloat = new float[10];
    int mCountFloat = 0;
    int[] mTypeString = new int[5];
    String[] mValueString = new String[5];
    int mCountString = 0;
    int[] mTypeBoolean = new int[4];
    boolean[] mValueBoolean = new boolean[4];
    int mCountBoolean = 0;

    public void add(int i2, int i8) {
        int i9 = this.mCountInt;
        int[] iArr = this.mTypeInt;
        if (i9 >= iArr.length) {
            this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.mValueInt;
            this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.mTypeInt;
        int i10 = this.mCountInt;
        iArr3[i10] = i2;
        int[] iArr4 = this.mValueInt;
        this.mCountInt = i10 + 1;
        iArr4[i10] = i8;
    }

    public void addIfNotNull(int i2, String str) {
        if (str != null) {
            add(i2, str);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i2 = 0; i2 < this.mCountInt; i2++) {
            typedValues.setValue(this.mTypeInt[i2], this.mValueInt[i2]);
        }
        for (int i8 = 0; i8 < this.mCountFloat; i8++) {
            typedValues.setValue(this.mTypeFloat[i8], this.mValueFloat[i8]);
        }
        for (int i9 = 0; i9 < this.mCountString; i9++) {
            typedValues.setValue(this.mTypeString[i9], this.mValueString[i9]);
        }
        for (int i10 = 0; i10 < this.mCountBoolean; i10++) {
            typedValues.setValue(this.mTypeBoolean[i10], this.mValueBoolean[i10]);
        }
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }

    public int getInteger(int i2) {
        for (int i8 = 0; i8 < this.mCountInt; i8++) {
            if (this.mTypeInt[i8] == i2) {
                return this.mValueInt[i8];
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TypedBundle{mCountInt=");
        sb.append(this.mCountInt);
        sb.append(", mCountFloat=");
        sb.append(this.mCountFloat);
        sb.append(", mCountString=");
        sb.append(this.mCountString);
        sb.append(", mCountBoolean=");
        return a0.c(sb, this.mCountBoolean, '}');
    }

    public void add(int i2, float f4) {
        int i8 = this.mCountFloat;
        int[] iArr = this.mTypeFloat;
        if (i8 >= iArr.length) {
            this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValueFloat;
            this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTypeFloat;
        int i9 = this.mCountFloat;
        iArr2[i9] = i2;
        float[] fArr2 = this.mValueFloat;
        this.mCountFloat = i9 + 1;
        fArr2[i9] = f4;
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i2 = 0; i2 < this.mCountInt; i2++) {
            typedBundle.add(this.mTypeInt[i2], this.mValueInt[i2]);
        }
        for (int i8 = 0; i8 < this.mCountFloat; i8++) {
            typedBundle.add(this.mTypeFloat[i8], this.mValueFloat[i8]);
        }
        for (int i9 = 0; i9 < this.mCountString; i9++) {
            typedBundle.add(this.mTypeString[i9], this.mValueString[i9]);
        }
        for (int i10 = 0; i10 < this.mCountBoolean; i10++) {
            typedBundle.add(this.mTypeBoolean[i10], this.mValueBoolean[i10]);
        }
    }

    public void add(int i2, String str) {
        int i8 = this.mCountString;
        int[] iArr = this.mTypeString;
        if (i8 >= iArr.length) {
            this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.mValueString;
            this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.mTypeString;
        int i9 = this.mCountString;
        iArr2[i9] = i2;
        String[] strArr2 = this.mValueString;
        this.mCountString = i9 + 1;
        strArr2[i9] = str;
    }

    public void add(int i2, boolean z2) {
        int i8 = this.mCountBoolean;
        int[] iArr = this.mTypeBoolean;
        if (i8 >= iArr.length) {
            this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.mValueBoolean;
            this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.mTypeBoolean;
        int i9 = this.mCountBoolean;
        iArr2[i9] = i2;
        boolean[] zArr2 = this.mValueBoolean;
        this.mCountBoolean = i9 + 1;
        zArr2[i9] = z2;
    }
}
