package androidx.constraintlayout.core.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class GridEngine {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int VERTICAL = 1;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    private int mNextAvailableIndex = 0;
    private int mNumWidgets;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    private String mStrSkips;
    private String mStrSpans;

    public GridEngine() {
    }

    private void addAllConstraintPositions() {
        for (int i2 = 0; i2 < this.mNumWidgets; i2++) {
            if (leftOfWidget(i2) == -1) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return;
                } else {
                    addConstraintPosition(i2, rowByIndex, colByIndex, 1, 1);
                }
            }
        }
    }

    private void addConstraintPosition(int i2, int i8, int i9, int i10, int i11) {
        int[] iArr = this.mConstraintMatrix[i2];
        iArr[0] = i9;
        iArr[1] = i8;
        iArr[2] = (i9 + i11) - 1;
        iArr[3] = (i8 + i10) - 1;
    }

    private void fillConstraintMatrix(boolean z2) {
        int[][] spans;
        int[][] spans2;
        if (z2) {
            for (int i2 = 0; i2 < this.mPositionMatrix.length; i2++) {
                int i8 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i8 < zArr[0].length) {
                        zArr[i2][i8] = true;
                        i8++;
                    }
                }
            }
            for (int i9 = 0; i9 < this.mConstraintMatrix.length; i9++) {
                int i10 = 0;
                while (true) {
                    int[][] iArr = this.mConstraintMatrix;
                    if (i10 < iArr[0].length) {
                        iArr[i9][i10] = -1;
                        i10++;
                    }
                }
            }
        }
        this.mNextAvailableIndex = 0;
        String str = this.mStrSkips;
        if (str != null && !str.trim().isEmpty() && (spans2 = parseSpans(this.mStrSkips)) != null) {
            handleSkips(spans2);
        }
        String str2 = this.mStrSpans;
        if (str2 != null && !str2.trim().isEmpty() && (spans = parseSpans(this.mStrSpans)) != null) {
            handleSpans(spans);
        }
        addAllConstraintPositions();
    }

    private int getColByIndex(int i2) {
        return this.mOrientation == 1 ? i2 / this.mRows : i2 % this.mColumns;
    }

    private int getNextPosition() {
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            i2 = this.mNextAvailableIndex;
            if (i2 >= this.mRows * this.mColumns) {
                return -1;
            }
            int rowByIndex = getRowByIndex(i2);
            int colByIndex = getColByIndex(this.mNextAvailableIndex);
            boolean[] zArr = this.mPositionMatrix[rowByIndex];
            if (zArr[colByIndex]) {
                zArr[colByIndex] = false;
                z2 = true;
            }
            this.mNextAvailableIndex++;
        }
        return i2;
    }

    private int getRowByIndex(int i2) {
        return this.mOrientation == 1 ? i2 % this.mRows : i2 / this.mColumns;
    }

    private void handleSkips(int[][] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int rowByIndex = getRowByIndex(iArr[i2][0]);
            int colByIndex = getColByIndex(iArr[i2][0]);
            int[] iArr2 = iArr[i2];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int rowByIndex = getRowByIndex(iArr[i2][0]);
            int colByIndex = getColByIndex(iArr[i2][0]);
            int[] iArr2 = iArr[i2];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return;
            }
            int[] iArr3 = iArr[i2];
            addConstraintPosition(i2, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
        }
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i2 = this.mNumWidgets;
        if (i2 > 0) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i2, 4);
            this.mConstraintMatrix = iArr;
            for (int[] iArr2 : iArr) {
                Arrays.fill(iArr2, -1);
            }
        }
    }

    private boolean invalidatePositions(int i2, int i8, int i9, int i10) {
        for (int i11 = i2; i11 < i2 + i9; i11++) {
            for (int i12 = i8; i12 < i8 + i10; i12++) {
                boolean[][] zArr = this.mPositionMatrix;
                if (i11 < zArr.length && i12 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i11];
                    if (zArr2[i12]) {
                        zArr2[i12] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isSpansValid(CharSequence charSequence) {
        return charSequence != null;
    }

    private int[][] parseSpans(String str) {
        if (!isSpansValid(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 3);
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            String[] strArrSplit2 = strArrSplit[i2].trim().split(":");
            String[] strArrSplit3 = strArrSplit2[1].split("x");
            iArr[i2][0] = Integer.parseInt(strArrSplit2[0]);
            iArr[i2][1] = Integer.parseInt(strArrSplit3[0]);
            iArr[i2][2] = Integer.parseInt(strArrSplit3[1]);
        }
        return iArr;
    }

    private void updateActualRowsAndColumns() {
        int i2;
        int i8 = this.mRowsSet;
        if (i8 != 0 && (i2 = this.mColumnsSet) != 0) {
            this.mRows = i8;
            this.mColumns = i2;
            return;
        }
        int i9 = this.mColumnsSet;
        if (i9 > 0) {
            this.mColumns = i9;
            this.mRows = ((this.mNumWidgets + i9) - 1) / i9;
        } else if (i8 > 0) {
            this.mRows = i8;
            this.mColumns = ((this.mNumWidgets + i8) - 1) / i8;
        } else {
            int iSqrt = (int) (Math.sqrt(this.mNumWidgets) + 1.5d);
            this.mRows = iSqrt;
            this.mColumns = ((this.mNumWidgets + iSqrt) - 1) / iSqrt;
        }
    }

    public int bottomOfWidget(int i2) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2][3];
    }

    public int leftOfWidget(int i2) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2][0];
    }

    public int rightOfWidget(int i2) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2][2];
    }

    public void setColumns(int i2) {
        if (i2 <= 50 && this.mColumnsSet != i2) {
            this.mColumnsSet = i2;
            updateActualRowsAndColumns();
        }
    }

    public void setNumWidgets(int i2) {
        if (i2 > this.mRows * this.mColumns) {
            return;
        }
        this.mNumWidgets = i2;
    }

    public void setOrientation(int i2) {
        if ((i2 == 0 || i2 == 1) && this.mOrientation != i2) {
            this.mOrientation = i2;
        }
    }

    public void setRows(int i2) {
        if (i2 <= 50 && this.mRowsSet != i2) {
            this.mRowsSet = i2;
            updateActualRowsAndColumns();
        }
    }

    public void setSkips(String str) {
        String str2 = this.mStrSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mStrSkips = str;
        }
    }

    public void setSpans(CharSequence charSequence) {
        String str = this.mStrSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mStrSpans = charSequence.toString();
        }
    }

    public void setup() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z2 = false;
        if (iArr != null && iArr.length == this.mNumWidgets && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z2 = true;
        }
        if (!z2) {
            initVariables();
        }
        fillConstraintMatrix(z2);
    }

    public int topOfWidget(int i2) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i2 >= iArr.length) {
            return 0;
        }
        return iArr[i2][1];
    }

    public GridEngine(int i2, int i8) {
        this.mRowsSet = i2;
        this.mColumnsSet = i8;
        if (i2 > 50) {
            this.mRowsSet = 3;
        }
        if (i8 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initVariables();
    }

    public GridEngine(int i2, int i8, int i9) {
        this.mRowsSet = i2;
        this.mColumnsSet = i8;
        this.mNumWidgets = i9;
        if (i2 > 50) {
            this.mRowsSet = 3;
        }
        if (i8 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        int i10 = this.mRows;
        int i11 = this.mColumns;
        if (i9 > i10 * i11 || i9 < 1) {
            this.mNumWidgets = i10 * i11;
        }
        initVariables();
        fillConstraintMatrix(false);
    }
}
