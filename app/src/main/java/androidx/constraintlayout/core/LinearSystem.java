package androidx.constraintlayout.core;

import androidx.camera.core.processing.util.a;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    private static final boolean DO_NOT_USE = false;
    public static final boolean FULL_DEBUG = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    private Row mTempGoal;
    private int mPoolSize = 1000;
    public boolean hasSimpleDefinition = false;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int mTableSize = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[1000];
    private int mPoolVariablesCount = 0;
    ArrayRow[] mRows = new ArrayRow[32];

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z2);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z2);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable solverVariableAcquire = this.mCache.mSolverVariablePool.acquire();
        if (solverVariableAcquire == null) {
            solverVariableAcquire = new SolverVariable(type, str);
            solverVariableAcquire.setType(type, str);
        } else {
            solverVariableAcquire.reset();
            solverVariableAcquire.setType(type, str);
        }
        int i2 = this.mPoolVariablesCount;
        int i8 = this.mPoolSize;
        if (i2 >= i8) {
            int i9 = i8 * 2;
            this.mPoolSize = i9;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i9);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i10 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i10 + 1;
        solverVariableArr[i10] = solverVariableAcquire;
        return solverVariableAcquire;
    }

    private void addRow(ArrayRow arrayRow) {
        int i2;
        if (SIMPLIFY_SYNONYMS && arrayRow.mIsSimpleDefinition) {
            arrayRow.mVariable.setFinalValue(this, arrayRow.mConstantValue);
        } else {
            ArrayRow[] arrayRowArr = this.mRows;
            int i8 = this.mNumRows;
            arrayRowArr[i8] = arrayRow;
            SolverVariable solverVariable = arrayRow.mVariable;
            solverVariable.mDefinitionId = i8;
            this.mNumRows = i8 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i9 = 0;
            while (i9 < this.mNumRows) {
                if (this.mRows[i9] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.mRows[i9];
                if (arrayRow2 != null && arrayRow2.mIsSimpleDefinition) {
                    arrayRow2.mVariable.setFinalValue(this, arrayRow2.mConstantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.mOptimizedArrayRowPool.release(arrayRow2);
                    } else {
                        this.mCache.mArrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i9] = null;
                    int i10 = i9 + 1;
                    int i11 = i10;
                    while (true) {
                        i2 = this.mNumRows;
                        if (i10 >= i2) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.mRows;
                        int i12 = i10 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i10];
                        arrayRowArr2[i12] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.mVariable;
                        if (solverVariable2.mDefinitionId == i10) {
                            solverVariable2.mDefinitionId = i12;
                        }
                        i11 = i10;
                        i10++;
                    }
                    if (i11 < i2) {
                        this.mRows[i11] = null;
                    }
                    this.mNumRows = i2 - 1;
                    i9--;
                }
                i9++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void computeValues() {
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow arrayRow = this.mRows[i2];
            arrayRow.mVariable.computedValue = arrayRow.mConstantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f4) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f4);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(type, null);
        solverVariableAcquireSolverVariable.setName(str);
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i2;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, solverVariableAcquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String strC = "";
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            StringBuilder sbR = a.r(strC);
            sbR.append(this.mRows[i2]);
            strC = a1.a.C(sbR.toString(), "\n");
        }
        StringBuilder sbR2 = a.r(strC);
        sbR2.append(this.mGoal);
        sbR2.append("\n");
        System.out.println(sbR2.toString());
    }

    private void displaySolverVariables() {
        StringBuilder sb = new StringBuilder("Display Rows (");
        sb.append(this.mNumRows);
        sb.append("x");
        System.out.println(a1.a.q(sb, ")\n", this.mNumColumns));
    }

    private int enforceBFS(Row row) throws Exception {
        float f4;
        long j;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED) {
                float f8 = 0.0f;
                if (arrayRow.mConstantValue < 0.0f) {
                    boolean z2 = false;
                    int i8 = 0;
                    while (!z2) {
                        Metrics metrics = sMetrics;
                        long j3 = 1;
                        if (metrics != null) {
                            metrics.bfs++;
                        }
                        i8++;
                        float f9 = Float.MAX_VALUE;
                        int i9 = 0;
                        int i10 = -1;
                        int i11 = -1;
                        int i12 = 0;
                        while (true) {
                            if (i9 >= this.mNumRows) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.mRows[i9];
                            if (arrayRow2.mVariable.mType == SolverVariable.Type.UNRESTRICTED || arrayRow2.mIsSimpleDefinition || arrayRow2.mConstantValue >= f8) {
                                f4 = f8;
                                j = j3;
                            } else if (SKIP_COLUMNS) {
                                int currentSize = arrayRow2.variables.getCurrentSize();
                                int i13 = 0;
                                while (i13 < currentSize) {
                                    float f10 = f8;
                                    SolverVariable variable = arrayRow2.variables.getVariable(i13);
                                    long j8 = j3;
                                    float f11 = arrayRow2.variables.get(variable);
                                    if (f11 > f10) {
                                        for (int i14 = 0; i14 < 9; i14++) {
                                            float f12 = variable.mStrengthVector[i14] / f11;
                                            if ((f12 < f9 && i14 == i12) || i14 > i12) {
                                                i12 = i14;
                                                i11 = variable.id;
                                                i10 = i9;
                                                f9 = f12;
                                            }
                                        }
                                    }
                                    i13++;
                                    f8 = f10;
                                    j3 = j8;
                                }
                                f4 = f8;
                                j = j3;
                            } else {
                                f4 = f8;
                                j = j3;
                                for (int i15 = 1; i15 < this.mNumColumns; i15++) {
                                    SolverVariable solverVariable = this.mCache.mIndexedVariables[i15];
                                    float f13 = arrayRow2.variables.get(solverVariable);
                                    if (f13 > f4) {
                                        for (int i16 = 0; i16 < 9; i16++) {
                                            float f14 = solverVariable.mStrengthVector[i16] / f13;
                                            if ((f14 < f9 && i16 == i12) || i16 > i12) {
                                                i12 = i16;
                                                f9 = f14;
                                                i10 = i9;
                                                i11 = i15;
                                            }
                                        }
                                    }
                                }
                            }
                            i9++;
                            f8 = f4;
                            j3 = j;
                        }
                        float f15 = f8;
                        long j9 = j3;
                        if (i10 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i10];
                            arrayRow3.mVariable.mDefinitionId = -1;
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots += j9;
                            }
                            arrayRow3.pivot(this.mCache.mIndexedVariables[i11]);
                            SolverVariable solverVariable2 = arrayRow3.mVariable;
                            solverVariable2.mDefinitionId = i10;
                            solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
                        } else {
                            z2 = true;
                        }
                        if (i8 > this.mNumColumns / 2) {
                            z2 = true;
                        }
                        f8 = f15;
                    }
                    return i8;
                }
            }
        }
        return 0;
    }

    private String getDisplaySize(int i2) {
        int i8 = i2 * 4;
        int i9 = i8 / 1024;
        int i10 = i9 / 1024;
        return i10 > 0 ? a1.a.h(i10, "", " Mb") : i9 > 0 ? a1.a.h(i9, "", " Kb") : a1.a.h(i8, "", " bytes");
    }

    private String getDisplayStrength(int i2) {
        return i2 == 1 ? "LOW" : i2 == 2 ? "MEDIUM" : i2 == 3 ? "HIGH" : i2 == 4 ? "HIGHEST" : i2 == 5 ? "EQUALITY" : i2 == 8 ? "FIXED" : i2 == 6 ? "BARRIER" : "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i2 = this.mTableSize * 2;
        this.mTableSize = i2;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i2);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.mTableSize);
        int i8 = this.mTableSize;
        this.mAlreadyTestedCandidates = new boolean[i8];
        this.mMaxColumns = i8;
        this.mMaxRows = i8;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i8);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private int optimize(Row row, boolean z2) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i2 = 0; i2 < this.mNumColumns; i2++) {
            this.mAlreadyTestedCandidates[i2] = false;
        }
        boolean z7 = false;
        int i8 = 0;
        while (!z7) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i8++;
            if (i8 < this.mNumColumns * 2) {
                if (row.getKey() != null) {
                    this.mAlreadyTestedCandidates[row.getKey().id] = true;
                }
                SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
                if (pivotCandidate != null) {
                    boolean[] zArr = this.mAlreadyTestedCandidates;
                    int i9 = pivotCandidate.id;
                    if (!zArr[i9]) {
                        zArr[i9] = true;
                    }
                }
                if (pivotCandidate != null) {
                    float f4 = Float.MAX_VALUE;
                    int i10 = -1;
                    for (int i11 = 0; i11 < this.mNumRows; i11++) {
                        ArrayRow arrayRow = this.mRows[i11];
                        if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.mIsSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                            float f8 = arrayRow.variables.get(pivotCandidate);
                            if (f8 < 0.0f) {
                                float f9 = (-arrayRow.mConstantValue) / f8;
                                if (f9 < f4) {
                                    i10 = i11;
                                    f4 = f9;
                                }
                            }
                        }
                    }
                    if (i10 > -1) {
                        ArrayRow arrayRow2 = this.mRows[i10];
                        arrayRow2.mVariable.mDefinitionId = -1;
                        Metrics metrics3 = sMetrics;
                        if (metrics3 != null) {
                            metrics3.pivots++;
                        }
                        arrayRow2.pivot(pivotCandidate);
                        SolverVariable solverVariable = arrayRow2.mVariable;
                        solverVariable.mDefinitionId = i10;
                        solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                    }
                } else {
                    z7 = true;
                }
            }
            return i8;
        }
        return i8;
    }

    private void releaseRows() {
        int i2 = 0;
        if (OPTIMIZED_ENGINE) {
            while (i2 < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i2];
                if (arrayRow != null) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i2] = null;
                i2++;
            }
            return;
        }
        while (i2 < this.mNumRows) {
            ArrayRow arrayRow2 = this.mRows[i2];
            if (arrayRow2 != null) {
                this.mCache.mArrayRowPool.release(arrayRow2);
            }
            this.mRows[i2] = null;
            i2++;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f4, int i2) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable solverVariableCreateObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable solverVariableCreateObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable solverVariableCreateObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable solverVariableCreateObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable solverVariableCreateObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable solverVariableCreateObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable solverVariableCreateObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable solverVariableCreateObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow arrayRowCreateRow = createRow();
        double d8 = f4;
        double d9 = i2;
        arrayRowCreateRow.createRowWithAngle(solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable8, (float) (Math.sin(d8) * d9));
        addConstraint(arrayRowCreateRow);
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowWithAngle(solverVariableCreateObjectVariable, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, solverVariableCreateObjectVariable7, (float) (Math.cos(d8) * d9));
        addConstraint(arrayRowCreateRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f4, SolverVariable solverVariable3, SolverVariable solverVariable4, int i8, int i9) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowCentering(solverVariable, solverVariable2, i2, f4, solverVariable3, solverVariable4, i8);
        if (i9 != 8) {
            arrayRowCreateRow.addError(this, i9);
        }
        addConstraint(arrayRowCreateRow);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addConstraint(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L4
            goto La8
        L4:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.sMetrics
            r1 = 1
            if (r0 == 0) goto L18
            long r3 = r0.constraints
            long r3 = r3 + r1
            r0.constraints = r3
            boolean r3 = r8.mIsSimpleDefinition
            if (r3 == 0) goto L18
            long r3 = r0.simpleconstraints
            long r3 = r3 + r1
            r0.simpleconstraints = r3
        L18:
            int r0 = r7.mNumRows
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.mMaxRows
            if (r0 >= r4) goto L27
            int r0 = r7.mNumColumns
            int r0 = r0 + r3
            int r4 = r7.mMaxColumns
            if (r0 < r4) goto L2a
        L27:
            r7.increaseTableSize()
        L2a:
            boolean r0 = r8.mIsSimpleDefinition
            r4 = 0
            if (r0 != 0) goto La3
            r8.updateFromSystem(r7)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L3a
            goto La8
        L3a:
            r8.ensurePositiveConstant()
            boolean r0 = r8.chooseSubject(r7)
            if (r0 == 0) goto L9a
            androidx.constraintlayout.core.SolverVariable r0 = r7.createExtraVariable()
            r8.mVariable = r0
            int r5 = r7.mNumRows
            r7.addRow(r8)
            int r6 = r7.mNumRows
            int r5 = r5 + r3
            if (r6 != r5) goto L9a
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r4.initFromRow(r8)
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r7.optimize(r4, r3)
            int r4 = r0.mDefinitionId
            r5 = -1
            if (r4 != r5) goto L9b
            androidx.constraintlayout.core.SolverVariable r4 = r8.mVariable
            if (r4 != r0) goto L78
            androidx.constraintlayout.core.SolverVariable r0 = r8.pickPivot(r0)
            if (r0 == 0) goto L78
            androidx.constraintlayout.core.Metrics r4 = androidx.constraintlayout.core.LinearSystem.sMetrics
            if (r4 == 0) goto L75
            long r5 = r4.pivots
            long r5 = r5 + r1
            r4.pivots = r5
        L75:
            r8.pivot(r0)
        L78:
            boolean r0 = r8.mIsSimpleDefinition
            if (r0 != 0) goto L81
            androidx.constraintlayout.core.SolverVariable r0 = r8.mVariable
            r0.updateReferencesWithNewDefinition(r7, r8)
        L81:
            boolean r0 = androidx.constraintlayout.core.LinearSystem.OPTIMIZED_ENGINE
            if (r0 == 0) goto L8d
            androidx.constraintlayout.core.Cache r0 = r7.mCache
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.mOptimizedArrayRowPool
            r0.release(r8)
            goto L94
        L8d:
            androidx.constraintlayout.core.Cache r0 = r7.mCache
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r0.mArrayRowPool
            r0.release(r8)
        L94:
            int r0 = r7.mNumRows
            int r0 = r0 - r3
            r7.mNumRows = r0
            goto L9b
        L9a:
            r3 = r4
        L9b:
            boolean r0 = r8.hasKeyVariable()
            if (r0 != 0) goto La2
            goto La8
        La2:
            r4 = r3
        La3:
            if (r4 != 0) goto La8
            r7.addRow(r8)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.addConstraint(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i8) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && i8 == 8 && solverVariable2.isFinalValue && solverVariable.mDefinitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i2);
            return null;
        }
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowEquals(solverVariable, solverVariable2, i2);
        if (i8 != 8) {
            arrayRowCreateRow.addError(this, i8);
        }
        addConstraint(arrayRowCreateRow);
        return arrayRowCreateRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i2);
        addConstraint(arrayRowCreateRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i8) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i2);
        if (i8 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i8);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z2) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i2);
        addConstraint(arrayRowCreateRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i8) {
        ArrayRow arrayRowCreateRow = createRow();
        SolverVariable solverVariableCreateSlackVariable = createSlackVariable();
        solverVariableCreateSlackVariable.strength = 0;
        arrayRowCreateRow.createRowLowerThan(solverVariable, solverVariable2, solverVariableCreateSlackVariable, i2);
        if (i8 != 8) {
            addSingleError(arrayRowCreateRow, (int) (arrayRowCreateRow.variables.get(solverVariableCreateSlackVariable) * (-1.0f)), i8);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f4, int i2) {
        ArrayRow arrayRowCreateRow = createRow();
        arrayRowCreateRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f4);
        if (i2 != 8) {
            arrayRowCreateRow.addError(this, i2);
        }
        addConstraint(arrayRowCreateRow);
    }

    public void addSingleError(ArrayRow arrayRow, int i2, int i8) {
        arrayRow.addSingleError(createErrorVariable(i8, null), i2);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i2) {
        if (solverVariable.mDefinitionId != -1 || i2 != 0) {
            addEquality(solverVariable, solverVariable2, i2, 8);
            return;
        }
        if (solverVariable2.mIsSynonym) {
            solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.mSynonym];
        }
        if (solverVariable.mIsSynonym) {
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.mSynonym];
        } else {
            solverVariable.setSynonym(this, solverVariable2, 0.0f);
        }
    }

    public final void cleanupRows() {
        int i2;
        int i8 = 0;
        while (i8 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i8];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.mIsSimpleDefinition = true;
            }
            if (arrayRow.mIsSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.mVariable;
                solverVariable.computedValue = arrayRow.mConstantValue;
                solverVariable.removeFromRow(arrayRow);
                int i9 = i8;
                while (true) {
                    i2 = this.mNumRows;
                    if (i9 >= i2 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i10 = i9 + 1;
                    arrayRowArr[i9] = arrayRowArr[i10];
                    i9 = i10;
                }
                this.mRows[i2 - 1] = null;
                this.mNumRows = i2 - 1;
                i8--;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                } else {
                    this.mCache.mArrayRowPool.release(arrayRow);
                }
            }
            i8++;
        }
    }

    public SolverVariable createErrorVariable(int i2, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i8 = this.mVariablesID + 1;
        this.mVariablesID = i8;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i8;
        solverVariableAcquireSolverVariable.strength = i2;
        this.mCache.mIndexedVariables[i8] = solverVariableAcquireSolverVariable;
        this.mGoal.addError(solverVariableAcquireSolverVariable);
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i2;
        this.mCache.mIndexedVariables[i2] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i2 = solverVariable.id;
            if (i2 != -1 && i2 <= this.mVariablesID && this.mCache.mIndexedVariables[i2] != null) {
                return solverVariable;
            }
            if (i2 != -1) {
                solverVariable.reset();
            }
            int i8 = this.mVariablesID + 1;
            this.mVariablesID = i8;
            this.mNumColumns++;
            solverVariable.id = i8;
            solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
            this.mCache.mIndexedVariables[i8] = solverVariable;
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRowAcquire;
        if (OPTIMIZED_ENGINE) {
            arrayRowAcquire = this.mCache.mOptimizedArrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        } else {
            arrayRowAcquire = this.mCache.mArrayRowPool.acquire();
            if (arrayRowAcquire == null) {
                arrayRowAcquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRowAcquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRowAcquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable solverVariableAcquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i2 = this.mVariablesID + 1;
        this.mVariablesID = i2;
        this.mNumColumns++;
        solverVariableAcquireSolverVariable.id = i2;
        this.mCache.mIndexedVariables[i2] = solverVariableAcquireSolverVariable;
        return solverVariableAcquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String strQ = a1.a.q(new StringBuilder(" num vars "), "\n", this.mVariablesID);
        for (int i2 = 0; i2 < this.mVariablesID + 1; i2++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i2];
            if (solverVariable != null && solverVariable.isFinalValue) {
                strQ = strQ + " $[" + i2 + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String strC = a1.a.C(strQ, "\n");
        for (int i8 = 0; i8 < this.mVariablesID + 1; i8++) {
            SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
            SolverVariable solverVariable2 = solverVariableArr[i8];
            if (solverVariable2 != null && solverVariable2.mIsSynonym) {
                strC = strC + " ~[" + i8 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.mSynonym] + " + " + solverVariable2.mSynonymDelta + "\n";
            }
        }
        String strC2 = a1.a.C(strC, "\n\n #  ");
        for (int i9 = 0; i9 < this.mNumRows; i9++) {
            StringBuilder sbR = a.r(strC2);
            sbR.append(this.mRows[i9].toReadableString());
            strC2 = a1.a.C(sbR.toString(), "\n #  ");
        }
        if (this.mGoal != null) {
            StringBuilder sbX = a1.a.x(strC2, "Goal: ");
            sbX.append(this.mGoal);
            sbX.append("\n");
            strC2 = sbX.toString();
        }
        System.out.println(strC2);
    }

    public void displaySystemInformation() {
        int iSizeInBytes = 0;
        for (int i2 = 0; i2 < this.mTableSize; i2++) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow != null) {
                iSizeInBytes += arrayRow.sizeInBytes();
            }
        }
        int iSizeInBytes2 = 0;
        for (int i8 = 0; i8 < this.mNumRows; i8++) {
            ArrayRow arrayRow2 = this.mRows[i8];
            if (arrayRow2 != null) {
                iSizeInBytes2 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder("Linear System -> Table size: ");
        sb.append(this.mTableSize);
        sb.append(" (");
        int i9 = this.mTableSize;
        sb.append(getDisplaySize(i9 * i9));
        sb.append(") -- row sizes: ");
        sb.append(getDisplaySize(iSizeInBytes));
        sb.append(", actual size: ");
        sb.append(getDisplaySize(iSizeInBytes2));
        sb.append(" rows: ");
        sb.append(this.mNumRows);
        sb.append("/");
        sb.append(this.mMaxRows);
        sb.append(" cols: ");
        sb.append(this.mNumColumns);
        sb.append("/");
        sb.append(this.mMaxColumns);
        sb.append(" 0 occupied cells, ");
        sb.append(getDisplaySize(0));
        printStream.println(sb.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String strC = "";
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            if (this.mRows[i2].mVariable.mType == SolverVariable.Type.UNRESTRICTED) {
                StringBuilder sbR = a.r(strC);
                sbR.append(this.mRows[i2].toReadableString());
                strC = a1.a.C(sbR.toString(), "\n");
            }
        }
        StringBuilder sbR2 = a.r(strC);
        sbR2.append(this.mGoal);
        sbR2.append("\n");
        System.out.println(sbR2.toString());
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int iSizeInBytes = 0;
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            ArrayRow arrayRow = this.mRows[i2];
            if (arrayRow != null) {
                iSizeInBytes = arrayRow.sizeInBytes() + iSizeInBytes;
            }
        }
        return iSizeInBytes;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public ArrayRow getRow(int i2) {
        return this.mRows[i2];
    }

    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        for (int i2 = 0; i2 < this.mNumRows; i2++) {
            if (!this.mRows[i2].mIsSimpleDefinition) {
                minimizeGoal(this.mGoal);
                return;
            }
        }
        Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        computeValues();
    }

    public void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i2;
        if (!arrayRow.mIsSimpleDefinition || (solverVariable = arrayRow.mVariable) == null) {
            return;
        }
        int i8 = solverVariable.mDefinitionId;
        if (i8 != -1) {
            while (true) {
                i2 = this.mNumRows;
                if (i8 >= i2 - 1) {
                    break;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                int i9 = i8 + 1;
                ArrayRow arrayRow2 = arrayRowArr[i9];
                SolverVariable solverVariable2 = arrayRow2.mVariable;
                if (solverVariable2.mDefinitionId == i9) {
                    solverVariable2.mDefinitionId = i8;
                }
                arrayRowArr[i8] = arrayRow2;
                i8 = i9;
            }
            this.mNumRows = i2 - 1;
        }
        SolverVariable solverVariable3 = arrayRow.mVariable;
        if (!solverVariable3.isFinalValue) {
            solverVariable3.setFinalValue(this, arrayRow.mConstantValue);
        }
        if (OPTIMIZED_ENGINE) {
            this.mCache.mOptimizedArrayRowPool.release(arrayRow);
        } else {
            this.mCache.mArrayRowPool.release(arrayRow);
        }
    }

    public void reset() {
        Cache cache;
        int i2 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i2 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i2];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i2++;
        }
        cache.mSolverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> map = this.mVariables;
        if (map != null) {
            map.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i8 = 0; i8 < this.mNumRows; i8++) {
            ArrayRow arrayRow = this.mRows[i8];
            if (arrayRow != null) {
                arrayRow.mUsed = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    public void addEquality(SolverVariable solverVariable, int i2) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && solverVariable.mDefinitionId == -1) {
            float f4 = i2;
            solverVariable.setFinalValue(this, f4);
            for (int i8 = 0; i8 < this.mVariablesID + 1; i8++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i8];
                if (solverVariable2 != null && solverVariable2.mIsSynonym && solverVariable2.mSynonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.mSynonymDelta + f4);
                }
            }
            return;
        }
        int i9 = solverVariable.mDefinitionId;
        if (i9 != -1) {
            ArrayRow arrayRow = this.mRows[i9];
            if (arrayRow.mIsSimpleDefinition) {
                arrayRow.mConstantValue = i2;
                return;
            }
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.mIsSimpleDefinition = true;
                arrayRow.mConstantValue = i2;
                return;
            } else {
                ArrayRow arrayRowCreateRow = createRow();
                arrayRowCreateRow.createRowEquals(solverVariable, i2);
                addConstraint(arrayRowCreateRow);
                return;
            }
        }
        ArrayRow arrayRowCreateRow2 = createRow();
        arrayRowCreateRow2.createRowDefinition(solverVariable, i2);
        addConstraint(arrayRowCreateRow2);
    }
}
