package androidx.constraintlayout.core;

import a1.a;
import androidx.constraintlayout.core.ArrayRow;
import com.ironsource.C2300e4;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float sEpsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    private final int mNone = -1;
    private int mSize = 16;
    private int mHashSize = 16;
    int[] mKeys = new int[16];
    int[] mNextKeys = new int[16];
    int[] mVariables = new int[16];
    float[] mValues = new float[16];
    int[] mPrevious = new int[16];
    int[] mNext = new int[16];
    int mCount = 0;
    int mHead = -1;

    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i2) {
        int[] iArr;
        int i8 = solverVariable.id % this.mHashSize;
        int[] iArr2 = this.mKeys;
        int i9 = iArr2[i8];
        if (i9 == -1) {
            iArr2[i8] = i2;
        } else {
            while (true) {
                iArr = this.mNextKeys;
                int i10 = iArr[i9];
                if (i10 == -1) {
                    break;
                } else {
                    i9 = i10;
                }
            }
            iArr[i9] = i2;
        }
        this.mNextKeys[i2] = -1;
    }

    private void addVariable(int i2, SolverVariable solverVariable, float f4) {
        this.mVariables[i2] = solverVariable.id;
        this.mValues[i2] = f4;
        this.mPrevious[i2] = -1;
        this.mNext[i2] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i2 = 0; i2 < this.mHashSize; i2++) {
            if (this.mKeys[i2] != -1) {
                String string = hashCode() + " hash [" + i2 + "] => ";
                int i8 = this.mKeys[i2];
                boolean z2 = false;
                while (!z2) {
                    StringBuilder sbX = a.x(string, " ");
                    sbX.append(this.mVariables[i8]);
                    string = sbX.toString();
                    int i9 = this.mNextKeys[i8];
                    if (i9 != -1) {
                        i8 = i9;
                    } else {
                        z2 = true;
                    }
                }
                System.out.println(string);
            }
        }
    }

    private int findEmptySlot() {
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (this.mVariables[i2] == -1) {
                return i2;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i2 = this.mSize * 2;
        this.mVariables = Arrays.copyOf(this.mVariables, i2);
        this.mValues = Arrays.copyOf(this.mValues, i2);
        this.mPrevious = Arrays.copyOf(this.mPrevious, i2);
        this.mNext = Arrays.copyOf(this.mNext, i2);
        this.mNextKeys = Arrays.copyOf(this.mNextKeys, i2);
        for (int i8 = this.mSize; i8 < i2; i8++) {
            this.mVariables[i8] = -1;
            this.mNextKeys[i8] = -1;
        }
        this.mSize = i2;
    }

    private void insertVariable(int i2, SolverVariable solverVariable, float f4) {
        int iFindEmptySlot = findEmptySlot();
        addVariable(iFindEmptySlot, solverVariable, f4);
        if (i2 != -1) {
            this.mPrevious[iFindEmptySlot] = i2;
            int[] iArr = this.mNext;
            iArr[iFindEmptySlot] = iArr[i2];
            iArr[i2] = iFindEmptySlot;
        } else {
            this.mPrevious[iFindEmptySlot] = -1;
            if (this.mCount > 0) {
                this.mNext[iFindEmptySlot] = this.mHead;
                this.mHead = iFindEmptySlot;
            } else {
                this.mNext[iFindEmptySlot] = -1;
            }
        }
        int i8 = this.mNext[iFindEmptySlot];
        if (i8 != -1) {
            this.mPrevious[i8] = iFindEmptySlot;
        }
        addToHashMap(solverVariable, iFindEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i2;
        int i8 = solverVariable.id;
        int i9 = i8 % this.mHashSize;
        int[] iArr2 = this.mKeys;
        int i10 = iArr2[i9];
        if (i10 == -1) {
            return;
        }
        if (this.mVariables[i10] == i8) {
            int[] iArr3 = this.mNextKeys;
            iArr2[i9] = iArr3[i10];
            iArr3[i10] = -1;
            return;
        }
        while (true) {
            iArr = this.mNextKeys;
            i2 = iArr[i10];
            if (i2 == -1 || this.mVariables[i2] == i8) {
                break;
            } else {
                i10 = i2;
            }
        }
        if (i2 == -1 || this.mVariables[i2] != i8) {
            return;
        }
        iArr[i10] = iArr[i2];
        iArr[i2] = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f4, boolean z2) {
        float f8 = sEpsilon;
        if (f4 <= (-f8) || f4 >= f8) {
            int iIndexOf = indexOf(solverVariable);
            if (iIndexOf == -1) {
                put(solverVariable, f4);
                return;
            }
            float[] fArr = this.mValues;
            float f9 = fArr[iIndexOf] + f4;
            fArr[iIndexOf] = f9;
            float f10 = sEpsilon;
            if (f9 <= (-f10) || f9 >= f10) {
                return;
            }
            fArr[iIndexOf] = 0.0f;
            remove(solverVariable, z2);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i2 = this.mCount;
        for (int i8 = 0; i8 < i2; i8++) {
            SolverVariable variable = getVariable(i8);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i9 = 0; i9 < this.mSize; i9++) {
            this.mVariables[i9] = -1;
            this.mNextKeys[i9] = -1;
        }
        for (int i10 = 0; i10 < this.mHashSize; i10++) {
            this.mKeys[i10] = -1;
        }
        this.mCount = 0;
        this.mHead = -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i2 = this.mCount;
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
        int i2 = this.mCount;
        int i8 = this.mHead;
        for (int i9 = 0; i9 < i2; i9++) {
            float[] fArr = this.mValues;
            fArr[i8] = fArr[i8] / f4;
            i8 = this.mNext[i8];
            if (i8 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            return this.mValues[iIndexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i2) {
        int i8 = this.mCount;
        if (i8 == 0) {
            return null;
        }
        int i9 = this.mHead;
        for (int i10 = 0; i10 < i8; i10++) {
            if (i10 == i2 && i9 != -1) {
                return this.mCache.mIndexedVariables[this.mVariables[i9]];
            }
            i9 = this.mNext[i9];
            if (i9 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i2) {
        int i8 = this.mCount;
        int i9 = this.mHead;
        for (int i10 = 0; i10 < i8; i10++) {
            if (i10 == i2) {
                return this.mValues[i9];
            }
            i9 = this.mNext[i9];
            if (i9 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.mCount != 0 && solverVariable != null) {
            int i2 = solverVariable.id;
            int i8 = this.mKeys[i2 % this.mHashSize];
            if (i8 == -1) {
                return -1;
            }
            if (this.mVariables[i8] == i2) {
                return i8;
            }
            do {
                i8 = this.mNextKeys[i8];
                if (i8 == -1) {
                    break;
                }
            } while (this.mVariables[i8] != i2);
            if (i8 != -1 && this.mVariables[i8] == i2) {
                return i8;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i2 = this.mCount;
        int i8 = this.mHead;
        for (int i9 = 0; i9 < i2; i9++) {
            float[] fArr = this.mValues;
            fArr[i8] = fArr[i8] * (-1.0f);
            i8 = this.mNext[i8];
            if (i8 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f4) {
        float f8 = sEpsilon;
        if (f4 > (-f8) && f4 < f8) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f4);
            addToHashMap(solverVariable, 0);
            this.mHead = 0;
            return;
        }
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf != -1) {
            this.mValues[iIndexOf] = f4;
            return;
        }
        if (this.mCount + 1 >= this.mSize) {
            increaseSize();
        }
        int i2 = this.mCount;
        int i8 = this.mHead;
        int i9 = -1;
        for (int i10 = 0; i10 < i2; i10++) {
            int i11 = this.mVariables[i8];
            int i12 = solverVariable.id;
            if (i11 == i12) {
                this.mValues[i8] = f4;
                return;
            }
            if (i11 < i12) {
                i9 = i8;
            }
            i8 = this.mNext[i8];
            if (i8 == -1) {
                break;
            }
        }
        insertVariable(i9, solverVariable, f4);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z2) {
        int iIndexOf = indexOf(solverVariable);
        if (iIndexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f4 = this.mValues[iIndexOf];
        if (this.mHead == iIndexOf) {
            this.mHead = this.mNext[iIndexOf];
        }
        this.mVariables[iIndexOf] = -1;
        int[] iArr = this.mPrevious;
        int i2 = iArr[iIndexOf];
        if (i2 != -1) {
            int[] iArr2 = this.mNext;
            iArr2[i2] = iArr2[iIndexOf];
        }
        int i8 = this.mNext[iIndexOf];
        if (i8 != -1) {
            iArr[i8] = iArr[iIndexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z2) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f4;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String strC;
        String strC2;
        String strC3 = hashCode() + " { ";
        int i2 = this.mCount;
        for (int i8 = 0; i8 < i2; i8++) {
            SolverVariable variable = getVariable(i8);
            if (variable != null) {
                String str = strC3 + variable + " = " + getVariableValue(i8) + " ";
                int iIndexOf = indexOf(variable);
                String strC4 = a.C(str, "[p: ");
                if (this.mPrevious[iIndexOf] != -1) {
                    StringBuilder sbR = androidx.camera.core.processing.util.a.r(strC4);
                    sbR.append(this.mCache.mIndexedVariables[this.mVariables[this.mPrevious[iIndexOf]]]);
                    strC = sbR.toString();
                } else {
                    strC = a.C(strC4, "none");
                }
                String strC5 = a.C(strC, ", n: ");
                if (this.mNext[iIndexOf] != -1) {
                    StringBuilder sbR2 = androidx.camera.core.processing.util.a.r(strC5);
                    sbR2.append(this.mCache.mIndexedVariables[this.mVariables[this.mNext[iIndexOf]]]);
                    strC2 = sbR2.toString();
                } else {
                    strC2 = a.C(strC5, "none");
                }
                strC3 = a.C(strC2, C2300e4.i.e);
            }
        }
        return a.C(strC3, " }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z2) {
        float f4 = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z2);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i2 = 0;
        int i8 = 0;
        while (i2 < currentSize) {
            int i9 = solverVariableValues.mVariables[i8];
            if (i9 != -1) {
                add(this.mCache.mIndexedVariables[i9], solverVariableValues.mValues[i8] * f4, z2);
                i2++;
            }
            i8++;
        }
        return f4;
    }
}
