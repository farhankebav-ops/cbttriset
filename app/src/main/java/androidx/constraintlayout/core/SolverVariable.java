package androidx.constraintlayout.core;

import androidx.camera.core.processing.util.a;
import androidx.exifinterface.media.ExifInterface;
import com.ironsource.C2300e4;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    private static final boolean DO_NOT_USE = false;
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int sUniqueConstantId = 1;
    private static int sUniqueErrorId = 1;
    private static int sUniqueId = 1;
    private static int sUniqueSlackId = 1;
    private static int sUniqueUnrestrictedId = 1;
    public float computedValue;
    public int id;
    public boolean inGoal;
    public boolean isFinalValue;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    int mDefinitionId;
    float[] mGoalStrengthVector;
    HashSet<ArrayRow> mInRows;
    boolean mIsSynonym;
    private String mName;
    float[] mStrengthVector;
    int mSynonym;
    float mSynonymDelta;
    Type mType;
    public int strength;
    public int usageInRowCount;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.mDefinitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.mStrengthVector = new float[9];
        this.mGoalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        this.mInRows = null;
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            StringBuilder sbR = a.r(str);
            sbR.append(sUniqueErrorId);
            return sbR.toString();
        }
        int iOrdinal = type.ordinal();
        if (iOrdinal == 0) {
            StringBuilder sb = new StringBuilder("U");
            int i2 = sUniqueUnrestrictedId + 1;
            sUniqueUnrestrictedId = i2;
            sb.append(i2);
            return sb.toString();
        }
        if (iOrdinal == 1) {
            StringBuilder sb2 = new StringBuilder("C");
            int i8 = sUniqueConstantId + 1;
            sUniqueConstantId = i8;
            sb2.append(i8);
            return sb2.toString();
        }
        if (iOrdinal == 2) {
            StringBuilder sb3 = new StringBuilder(ExifInterface.LATITUDE_SOUTH);
            int i9 = sUniqueSlackId + 1;
            sUniqueSlackId = i9;
            sb3.append(i9);
            return sb3.toString();
        }
        if (iOrdinal == 3) {
            StringBuilder sb4 = new StringBuilder("e");
            int i10 = sUniqueErrorId + 1;
            sUniqueErrorId = i10;
            sb4.append(i10);
            return sb4.toString();
        }
        if (iOrdinal != 4) {
            throw new AssertionError(type.name());
        }
        StringBuilder sb5 = new StringBuilder(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i11 = sUniqueId + 1;
        sUniqueId = i11;
        sb5.append(i11);
        return sb5.toString();
    }

    public static void increaseErrorId() {
        sUniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i2 = 0;
        while (true) {
            int i8 = this.mClientEquationsCount;
            if (i2 >= i8) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i8 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i9 = this.mClientEquationsCount;
                arrayRowArr2[i9] = arrayRow;
                this.mClientEquationsCount = i9 + 1;
                return;
            }
            if (this.mClientEquations[i2] == arrayRow) {
                return;
            } else {
                i2++;
            }
        }
    }

    public void clearStrengths() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.mStrengthVector[i2] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i2 = this.mClientEquationsCount;
        int i8 = 0;
        while (i8 < i2) {
            if (this.mClientEquations[i8] == arrayRow) {
                while (i8 < i2 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i9 = i8 + 1;
                    arrayRowArr[i8] = arrayRowArr[i9];
                    i8 = i9;
                }
                this.mClientEquationsCount--;
                return;
            }
            i8++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.mDefinitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        int i2 = this.mClientEquationsCount;
        for (int i8 = 0; i8 < i2; i8++) {
            this.mClientEquations[i8] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.mGoalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f4) {
        this.computedValue = f4;
        this.isFinalValue = true;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        int i2 = this.mClientEquationsCount;
        this.mDefinitionId = -1;
        for (int i8 = 0; i8 < i2; i8++) {
            this.mClientEquations[i8].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f4) {
        this.mIsSynonym = true;
        this.mSynonym = solverVariable.id;
        this.mSynonymDelta = f4;
        int i2 = this.mClientEquationsCount;
        this.mDefinitionId = -1;
        for (int i8 = 0; i8 < i2; i8++) {
            this.mClientEquations[i8].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String strC = this + C2300e4.i.f8403d;
        int i2 = 0;
        boolean z2 = false;
        boolean z7 = true;
        while (i2 < this.mStrengthVector.length) {
            StringBuilder sbR = a.r(strC);
            sbR.append(this.mStrengthVector[i2]);
            String string = sbR.toString();
            float[] fArr = this.mStrengthVector;
            float f4 = fArr[i2];
            if (f4 > 0.0f) {
                z2 = false;
            } else if (f4 < 0.0f) {
                z2 = true;
            }
            if (f4 != 0.0f) {
                z7 = false;
            }
            strC = i2 < fArr.length - 1 ? a1.a.C(string, ", ") : a1.a.C(string, "] ");
            i2++;
        }
        if (z2) {
            strC = a1.a.C(strC, " (-)");
        }
        return z7 ? a1.a.C(strC, " (*)") : strC;
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i2 = this.mClientEquationsCount;
        for (int i8 = 0; i8 < i2; i8++) {
            this.mClientEquations[i8].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(SolverVariable solverVariable) {
        return this.id - solverVariable.id;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.mDefinitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.mStrengthVector = new float[9];
        this.mGoalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        this.mInRows = null;
        this.mType = type;
    }
}
