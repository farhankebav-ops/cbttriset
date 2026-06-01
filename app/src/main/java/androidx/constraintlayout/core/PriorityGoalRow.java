package androidx.constraintlayout.core;

import androidx.camera.core.processing.util.a;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-4f;
    static final int NOT_FOUND = -1;
    GoalVariableAccessor mAccessor;
    private SolverVariable[] mArrayGoals;
    Cache mCache;
    private int mNumGoals;
    private SolverVariable[] mSortArray;
    private int mTableSize;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class GoalVariableAccessor {
        PriorityGoalRow mRow;
        SolverVariable mVariable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.mRow = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f4 = fArr[i2] + solverVariable.mGoalStrengthVector[i2];
                fArr[i2] = f4;
                if (Math.abs(f4) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i2] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f4) {
            boolean z2 = true;
            if (!this.mVariable.inGoal) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float f8 = solverVariable.mGoalStrengthVector[i2];
                    if (f8 != 0.0f) {
                        float f9 = f8 * f4;
                        if (Math.abs(f9) < 1.0E-4f) {
                            f9 = 0.0f;
                        }
                        this.mVariable.mGoalStrengthVector[i2] = f9;
                    } else {
                        this.mVariable.mGoalStrengthVector[i2] = 0.0f;
                    }
                }
                return true;
            }
            for (int i8 = 0; i8 < 9; i8++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f10 = (solverVariable.mGoalStrengthVector[i8] * f4) + fArr[i8];
                fArr[i8] = f10;
                if (Math.abs(f10) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i8] = 0.0f;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                PriorityGoalRow.this.removeGoal(this.mVariable);
            }
            return false;
        }

        public void init(SolverVariable solverVariable) {
            this.mVariable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i2 = 8; i2 >= 0; i2--) {
                float f4 = this.mVariable.mGoalStrengthVector[i2];
                if (f4 > 0.0f) {
                    return false;
                }
                if (f4 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i2 = 0; i2 < 9; i2++) {
                if (this.mVariable.mGoalStrengthVector[i2] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i2 = 8;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                float f4 = solverVariable.mGoalStrengthVector[i2];
                float f8 = this.mVariable.mGoalStrengthVector[i2];
                if (f8 == f4) {
                    i2--;
                } else if (f8 < f4) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.mVariable.mGoalStrengthVector, 0.0f);
        }

        public String toString() {
            String string = "[ ";
            if (this.mVariable != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    StringBuilder sbR = a.r(string);
                    sbR.append(this.mVariable.mGoalStrengthVector[i2]);
                    sbR.append(" ");
                    string = sbR.toString();
                }
            }
            StringBuilder sbX = a1.a.x(string, "] ");
            sbX.append(this.mVariable);
            return sbX.toString();
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mTableSize = 128;
        this.mArrayGoals = new SolverVariable[128];
        this.mSortArray = new SolverVariable[128];
        this.mNumGoals = 0;
        this.mAccessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }

    private void addToGoal(SolverVariable solverVariable) {
        int i2;
        int i8 = this.mNumGoals + 1;
        SolverVariable[] solverVariableArr = this.mArrayGoals;
        if (i8 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.mArrayGoals = solverVariableArr2;
            this.mSortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.mArrayGoals;
        int i9 = this.mNumGoals;
        solverVariableArr3[i9] = solverVariable;
        int i10 = i9 + 1;
        this.mNumGoals = i10;
        if (i10 > 1 && solverVariableArr3[i9].id > solverVariable.id) {
            int i11 = 0;
            while (true) {
                i2 = this.mNumGoals;
                if (i11 >= i2) {
                    break;
                }
                this.mSortArray[i11] = this.mArrayGoals[i11];
                i11++;
            }
            Arrays.sort(this.mSortArray, 0, i2, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.id - solverVariable3.id;
                }
            });
            for (int i12 = 0; i12 < this.mNumGoals; i12++) {
                this.mArrayGoals[i12] = this.mSortArray[i12];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGoal(SolverVariable solverVariable) {
        int i2 = 0;
        while (i2 < this.mNumGoals) {
            if (this.mArrayGoals[i2] == solverVariable) {
                while (true) {
                    int i8 = this.mNumGoals;
                    if (i2 >= i8 - 1) {
                        this.mNumGoals = i8 - 1;
                        solverVariable.inGoal = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.mArrayGoals;
                        int i9 = i2 + 1;
                        solverVariableArr[i2] = solverVariableArr[i9];
                        i2 = i9;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.mAccessor.init(solverVariable);
        this.mAccessor.reset();
        solverVariable.mGoalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.mNumGoals = 0;
        this.mConstantValue = 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.constraintlayout.core.SolverVariable getPivotCandidate(androidx.constraintlayout.core.LinearSystem r5, boolean[] r6) {
        /*
            r4 = this;
            r5 = -1
            r0 = 0
            r1 = r5
        L3:
            int r2 = r4.mNumGoals
            if (r0 >= r2) goto L32
            androidx.constraintlayout.core.SolverVariable[] r2 = r4.mArrayGoals
            r2 = r2[r0]
            int r3 = r2.id
            boolean r3 = r6[r3]
            if (r3 == 0) goto L12
            goto L2f
        L12:
            androidx.constraintlayout.core.PriorityGoalRow$GoalVariableAccessor r3 = r4.mAccessor
            r3.init(r2)
            if (r1 != r5) goto L22
            androidx.constraintlayout.core.PriorityGoalRow$GoalVariableAccessor r2 = r4.mAccessor
            boolean r2 = r2.isNegative()
            if (r2 == 0) goto L2f
            goto L2e
        L22:
            androidx.constraintlayout.core.PriorityGoalRow$GoalVariableAccessor r2 = r4.mAccessor
            androidx.constraintlayout.core.SolverVariable[] r3 = r4.mArrayGoals
            r3 = r3[r1]
            boolean r2 = r2.isSmallerThan(r3)
            if (r2 == 0) goto L2f
        L2e:
            r1 = r0
        L2f:
            int r0 = r0 + 1
            goto L3
        L32:
            if (r1 != r5) goto L36
            r5 = 0
            return r5
        L36:
            androidx.constraintlayout.core.SolverVariable[] r5 = r4.mArrayGoals
            r5 = r5[r1]
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.PriorityGoalRow.getPivotCandidate(androidx.constraintlayout.core.LinearSystem, boolean[]):androidx.constraintlayout.core.SolverVariable");
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.mNumGoals == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String string = " goal -> (" + this.mConstantValue + ") : ";
        for (int i2 = 0; i2 < this.mNumGoals; i2++) {
            this.mAccessor.init(this.mArrayGoals[i2]);
            StringBuilder sbR = a.r(string);
            sbR.append(this.mAccessor);
            sbR.append(" ");
            string = sbR.toString();
        }
        return string;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z2) {
        SolverVariable solverVariable = arrayRow.mVariable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i2 = 0; i2 < currentSize; i2++) {
            SolverVariable variable = arrayRowVariables.getVariable(i2);
            float variableValue = arrayRowVariables.getVariableValue(i2);
            this.mAccessor.init(variable);
            if (this.mAccessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.mConstantValue = (arrayRow.mConstantValue * variableValue) + this.mConstantValue;
        }
        removeGoal(solverVariable);
    }
}
