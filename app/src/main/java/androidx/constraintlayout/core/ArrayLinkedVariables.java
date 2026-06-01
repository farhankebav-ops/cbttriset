package androidx.constraintlayout.core;

import androidx.camera.core.processing.util.a;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    static final int NONE = -1;
    private static float sEpsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    int mCurrentSize = 0;
    private int mRowSize = 8;
    private SolverVariable mCandidate = null;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private int mHead = -1;
    private int mLast = -1;
    private boolean mDidFillOnce = false;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f4, boolean z2) {
        float f8 = sEpsilon;
        if (f4 <= (-f8) || f4 >= f8) {
            int i2 = this.mHead;
            if (i2 == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f4;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.mCurrentSize++;
                if (this.mDidFillOnce) {
                    return;
                }
                int i8 = this.mLast + 1;
                this.mLast = i8;
                int[] iArr = this.mArrayIndices;
                if (i8 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            int i9 = -1;
            for (int i10 = 0; i2 != -1 && i10 < this.mCurrentSize; i10++) {
                int i11 = this.mArrayIndices[i2];
                int i12 = solverVariable.id;
                if (i11 == i12) {
                    float[] fArr = this.mArrayValues;
                    float f9 = fArr[i2] + f4;
                    float f10 = sEpsilon;
                    if (f9 > (-f10) && f9 < f10) {
                        f9 = 0.0f;
                    }
                    fArr[i2] = f9;
                    if (f9 == 0.0f) {
                        if (i2 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i2];
                        } else {
                            int[] iArr2 = this.mArrayNextIndices;
                            iArr2[i9] = iArr2[i2];
                        }
                        if (z2) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i2;
                        }
                        solverVariable.usageInRowCount--;
                        this.mCurrentSize--;
                        return;
                    }
                    return;
                }
                if (i11 < i12) {
                    i9 = i2;
                }
                i2 = this.mArrayNextIndices[i2];
            }
            int length = this.mLast;
            int i13 = length + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i13;
            }
            int[] iArr4 = this.mArrayIndices;
            if (length >= iArr4.length && this.mCurrentSize < iArr4.length) {
                int i14 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i14 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i14] == -1) {
                        length = i14;
                        break;
                    }
                    i14++;
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i15 = this.mRowSize * 2;
                this.mRowSize = i15;
                this.mDidFillOnce = false;
                this.mLast = length - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i15);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
            }
            this.mArrayIndices[length] = solverVariable.id;
            this.mArrayValues[length] = f4;
            if (i9 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[length] = iArr7[i9];
                iArr7[i9] = length;
            } else {
                this.mArrayNextIndices[length] = this.mHead;
                this.mHead = length;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i16 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i16 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i2 = this.mHead;
        for (int i8 = 0; i2 != -1 && i8 < this.mCurrentSize; i8++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i2 = this.mArrayNextIndices[i2];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mCurrentSize = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i2 = this.mHead;
        if (i2 == -1) {
            return false;
        }
        for (int i8 = 0; i2 != -1 && i8 < this.mCurrentSize; i8++) {
            if (this.mArrayIndices[i2] == solverVariable.id) {
                return true;
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i2 = this.mCurrentSize;
        System.out.print("{ ");
        for (int i8 = 0; i8 < i2; i8++) {
            SolverVariable variable = getVariable(i8);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i8) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f4) {
        int i2 = this.mHead;
        for (int i8 = 0; i2 != -1 && i8 < this.mCurrentSize; i8++) {
            float[] fArr = this.mArrayValues;
            fArr[i2] = fArr[i2] / f4;
            i2 = this.mArrayNextIndices[i2];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i2 = this.mHead;
        for (int i8 = 0; i2 != -1 && i8 < this.mCurrentSize; i8++) {
            if (this.mArrayIndices[i2] == solverVariable.id) {
                return this.mArrayValues[i2];
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCurrentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i2) {
        return this.mArrayIndices[i2];
    }

    public final int getNextIndice(int i2) {
        return this.mArrayNextIndices[i2];
    }

    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.mCandidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i2 = this.mHead;
        SolverVariable solverVariable2 = null;
        for (int i8 = 0; i2 != -1 && i8 < this.mCurrentSize; i8++) {
            if (this.mArrayValues[i2] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return solverVariable2;
    }

    public final float getValue(int i2) {
        return this.mArrayValues[i2];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i2) {
        int i8 = this.mHead;
        for (int i9 = 0; i8 != -1 && i9 < this.mCurrentSize; i9++) {
            if (i9 == i2) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i8]];
            }
            i8 = this.mArrayNextIndices[i8];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i2) {
        int i8 = this.mHead;
        for (int i9 = 0; i8 != -1 && i9 < this.mCurrentSize; i9++) {
            if (i9 == i2) {
                return this.mArrayValues[i8];
            }
            i8 = this.mArrayNextIndices[i8];
        }
        return 0.0f;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        int i2 = this.mHead;
        for (int i8 = 0; i2 != -1 && i8 < this.mCurrentSize; i8++) {
            if (this.mArrayValues[i2] > 0.0f) {
                return true;
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i2 = this.mHead;
        if (i2 == -1) {
            return -1;
        }
        for (int i8 = 0; i2 != -1 && i8 < this.mCurrentSize; i8++) {
            if (this.mArrayIndices[i2] == solverVariable.id) {
                return i2;
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i2 = this.mHead;
        for (int i8 = 0; i2 != -1 && i8 < this.mCurrentSize; i8++) {
            float[] fArr = this.mArrayValues;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.mArrayNextIndices[i2];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f4) {
        if (f4 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i2 = this.mHead;
        if (i2 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f4;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (this.mDidFillOnce) {
                return;
            }
            int i8 = this.mLast + 1;
            this.mLast = i8;
            int[] iArr = this.mArrayIndices;
            if (i8 >= iArr.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr.length - 1;
                return;
            }
            return;
        }
        int i9 = -1;
        for (int i10 = 0; i2 != -1 && i10 < this.mCurrentSize; i10++) {
            int i11 = this.mArrayIndices[i2];
            int i12 = solverVariable.id;
            if (i11 == i12) {
                this.mArrayValues[i2] = f4;
                return;
            }
            if (i11 < i12) {
                i9 = i2;
            }
            i2 = this.mArrayNextIndices[i2];
        }
        int length = this.mLast;
        int i13 = length + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i13;
        }
        int[] iArr3 = this.mArrayIndices;
        if (length >= iArr3.length && this.mCurrentSize < iArr3.length) {
            int i14 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i14 >= iArr4.length) {
                    break;
                }
                if (iArr4[i14] == -1) {
                    length = i14;
                    break;
                }
                i14++;
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i15 = this.mRowSize * 2;
            this.mRowSize = i15;
            this.mDidFillOnce = false;
            this.mLast = length - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i15);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
        }
        this.mArrayIndices[length] = solverVariable.id;
        this.mArrayValues[length] = f4;
        if (i9 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[length] = iArr6[i9];
            iArr6[i9] = length;
        } else {
            this.mArrayNextIndices[length] = this.mHead;
            this.mHead = length;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i16 = this.mCurrentSize + 1;
        this.mCurrentSize = i16;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i16 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z2) {
        if (this.mCandidate == solverVariable) {
            this.mCandidate = null;
        }
        int i2 = this.mHead;
        if (i2 == -1) {
            return 0.0f;
        }
        int i8 = 0;
        int i9 = -1;
        while (i2 != -1 && i8 < this.mCurrentSize) {
            if (this.mArrayIndices[i2] == solverVariable.id) {
                if (i2 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i2];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i9] = iArr[i2];
                }
                if (z2) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.mCurrentSize--;
                this.mArrayIndices[i2] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i2;
                }
                return this.mArrayValues[i2];
            }
            i8++;
            i9 = i2;
            i2 = this.mArrayNextIndices[i2];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int i2 = this.mHead;
        String string = "";
        for (int i8 = 0; i2 != -1 && i8 < this.mCurrentSize; i8++) {
            StringBuilder sbR = a.r(a1.a.C(string, " -> "));
            sbR.append(this.mArrayValues[i2]);
            sbR.append(" : ");
            StringBuilder sbR2 = a.r(sbR.toString());
            sbR2.append(this.mCache.mIndexedVariables[this.mArrayIndices[i2]]);
            string = sbR2.toString();
            i2 = this.mArrayNextIndices[i2];
        }
        return string;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z2) {
        float f4 = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z2);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i2 = 0; i2 < currentSize; i2++) {
            SolverVariable variable = arrayRowVariables.getVariable(i2);
            add(variable, arrayRowVariables.get(variable) * f4, z2);
        }
        return f4;
    }
}
