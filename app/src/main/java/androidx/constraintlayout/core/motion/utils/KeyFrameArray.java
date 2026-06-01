package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import com.ironsource.C2300e4;
import java.io.PrintStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class KeyFrameArray {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CustomArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomAttribute[] mValues = new CustomAttribute[101];

        public CustomArray() {
            clear();
        }

        public void append(int i2, CustomAttribute customAttribute) {
            if (this.mValues[i2] != null) {
                remove(i2);
            }
            this.mValues[i2] = customAttribute;
            int[] iArr = this.mKeys;
            int i8 = this.mCount;
            this.mCount = i8 + 1;
            iArr[i8] = i2;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i2 = 0;
            while (i2 < this.mCount) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "" : ", ");
                sb.append(valueAt(i2));
                printStream.print(sb.toString());
                i2++;
            }
            System.out.println(C2300e4.i.e);
        }

        public int keyAt(int i2) {
            return this.mKeys[i2];
        }

        public void remove(int i2) {
            this.mValues[i2] = null;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int i10 = this.mCount;
                if (i8 >= i10) {
                    this.mCount = i10 - 1;
                    return;
                }
                int[] iArr = this.mKeys;
                if (i2 == iArr[i8]) {
                    iArr[i8] = 999;
                    i9++;
                }
                if (i8 != i9) {
                    iArr[i8] = iArr[i9];
                }
                i9++;
                i8++;
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomAttribute valueAt(int i2) {
            return this.mValues[this.mKeys[i2]];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class CustomVar {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomVariable[] mValues = new CustomVariable[101];

        public CustomVar() {
            clear();
        }

        public void append(int i2, CustomVariable customVariable) {
            if (this.mValues[i2] != null) {
                remove(i2);
            }
            this.mValues[i2] = customVariable;
            int[] iArr = this.mKeys;
            int i8 = this.mCount;
            this.mCount = i8 + 1;
            iArr[i8] = i2;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i2 = 0;
            while (i2 < this.mCount) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "" : ", ");
                sb.append(valueAt(i2));
                printStream.print(sb.toString());
                i2++;
            }
            System.out.println(C2300e4.i.e);
        }

        public int keyAt(int i2) {
            return this.mKeys[i2];
        }

        public void remove(int i2) {
            this.mValues[i2] = null;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int i10 = this.mCount;
                if (i8 >= i10) {
                    this.mCount = i10 - 1;
                    return;
                }
                int[] iArr = this.mKeys;
                if (i2 == iArr[i8]) {
                    iArr[i8] = 999;
                    i9++;
                }
                if (i8 != i9) {
                    iArr[i8] = iArr[i9];
                }
                i9++;
                i8++;
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomVariable valueAt(int i2) {
            return this.mValues[this.mKeys[i2]];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class FloatArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        float[][] mValues = new float[101][];

        public FloatArray() {
            clear();
        }

        public void append(int i2, float[] fArr) {
            if (this.mValues[i2] != null) {
                remove(i2);
            }
            this.mValues[i2] = fArr;
            int[] iArr = this.mKeys;
            int i8 = this.mCount;
            this.mCount = i8 + 1;
            iArr[i8] = i2;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i2 = 0;
            while (i2 < this.mCount) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "" : ", ");
                sb.append(Arrays.toString(valueAt(i2)));
                printStream.print(sb.toString());
                i2++;
            }
            System.out.println(C2300e4.i.e);
        }

        public int keyAt(int i2) {
            return this.mKeys[i2];
        }

        public void remove(int i2) {
            this.mValues[i2] = null;
            int i8 = 0;
            int i9 = 0;
            while (true) {
                int i10 = this.mCount;
                if (i8 >= i10) {
                    this.mCount = i10 - 1;
                    return;
                }
                int[] iArr = this.mKeys;
                if (i2 == iArr[i8]) {
                    iArr[i8] = 999;
                    i9++;
                }
                if (i8 != i9) {
                    iArr[i8] = iArr[i9];
                }
                i9++;
                i8++;
            }
        }

        public int size() {
            return this.mCount;
        }

        public float[] valueAt(int i2) {
            return this.mValues[this.mKeys[i2]];
        }
    }
}
