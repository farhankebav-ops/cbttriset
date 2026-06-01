package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.core.internal.view.SupportMenu;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Grid extends VirtualLayout {
    private static final boolean DEBUG_BOXES = false;
    public static final int HORIZONTAL = 0;
    private static final String TAG = "Grid";
    public static final int VERTICAL = 1;
    private int[] mBoxViewIds;
    private View[] mBoxViews;
    private int mColumns;
    private int mColumnsSet;
    ConstraintLayout mContainer;
    private float mHorizontalGaps;
    private final int mMaxColumns;
    private final int mMaxRows;
    private int mNextAvailableIndex;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    Set<Integer> mSpanIds;
    private String mStrColumnWeights;
    private String mStrRowWeights;
    private String mStrSkips;
    private String mStrSpans;
    private boolean mUseRtl;
    private boolean mValidateInputs;
    private float mVerticalGaps;

    public Grid(Context context) {
        super(context);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    private boolean arrangeWidgets() {
        View[] views = getViews(this.mContainer);
        for (int i2 = 0; i2 < this.mCount; i2++) {
            if (!this.mSpanIds.contains(Integer.valueOf(this.mIds[i2]))) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return false;
                }
                connectView(views[i2], rowByIndex, colByIndex, 1, 1);
            }
        }
        return true;
    }

    private void buildBoxes() {
        int iMax = Math.max(this.mRows, this.mColumns);
        View[] viewArr = this.mBoxViews;
        int i2 = 0;
        if (viewArr == null) {
            this.mBoxViews = new View[iMax];
            int i8 = 0;
            while (true) {
                View[] viewArr2 = this.mBoxViews;
                if (i8 >= viewArr2.length) {
                    break;
                }
                viewArr2[i8] = makeNewView();
                i8++;
            }
        } else if (iMax != viewArr.length) {
            View[] viewArr3 = new View[iMax];
            for (int i9 = 0; i9 < iMax; i9++) {
                View[] viewArr4 = this.mBoxViews;
                if (i9 < viewArr4.length) {
                    viewArr3[i9] = viewArr4[i9];
                } else {
                    viewArr3[i9] = makeNewView();
                }
            }
            int i10 = iMax;
            while (true) {
                View[] viewArr5 = this.mBoxViews;
                if (i10 >= viewArr5.length) {
                    break;
                }
                this.mContainer.removeView(viewArr5[i10]);
                i10++;
            }
            this.mBoxViews = viewArr3;
        }
        this.mBoxViewIds = new int[iMax];
        while (true) {
            View[] viewArr6 = this.mBoxViews;
            if (i2 >= viewArr6.length) {
                setBoxViewVerticalChains();
                setBoxViewHorizontalChains();
                return;
            } else {
                this.mBoxViewIds[i2] = viewArr6[i2].getId();
                i2++;
            }
        }
    }

    private void clearHParams(View view) {
        ConstraintLayout.LayoutParams layoutParamsParams = params(view);
        layoutParamsParams.horizontalWeight = -1.0f;
        layoutParamsParams.leftToRight = -1;
        layoutParamsParams.leftToLeft = -1;
        layoutParamsParams.rightToLeft = -1;
        layoutParamsParams.rightToRight = -1;
        ((ViewGroup.MarginLayoutParams) layoutParamsParams).leftMargin = -1;
        view.setLayoutParams(layoutParamsParams);
    }

    private void clearVParams(View view) {
        ConstraintLayout.LayoutParams layoutParamsParams = params(view);
        layoutParamsParams.verticalWeight = -1.0f;
        layoutParamsParams.topToBottom = -1;
        layoutParamsParams.topToTop = -1;
        layoutParamsParams.bottomToTop = -1;
        layoutParamsParams.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) layoutParamsParams).topMargin = -1;
        view.setLayoutParams(layoutParamsParams);
    }

    private void connectView(View view, int i2, int i8, int i9, int i10) {
        ConstraintLayout.LayoutParams layoutParamsParams = params(view);
        int[] iArr = this.mBoxViewIds;
        layoutParamsParams.leftToLeft = iArr[i8];
        layoutParamsParams.topToTop = iArr[i2];
        layoutParamsParams.rightToRight = iArr[(i8 + i10) - 1];
        layoutParamsParams.bottomToBottom = iArr[(i2 + i9) - 1];
        view.setLayoutParams(layoutParamsParams);
    }

    private boolean generateGrid(boolean z2) {
        int[][] spans;
        int[][] spans2;
        if (this.mContainer == null || this.mRows < 1 || this.mColumns < 1) {
            return false;
        }
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
            this.mSpanIds.clear();
        }
        this.mNextAvailableIndex = 0;
        buildBoxes();
        String str = this.mStrSkips;
        boolean zHandleSkips = (str == null || str.trim().isEmpty() || (spans2 = parseSpans(this.mStrSkips)) == null) ? true : handleSkips(spans2);
        String str2 = this.mStrSpans;
        if (str2 != null && !str2.trim().isEmpty() && (spans = parseSpans(this.mStrSpans)) != null) {
            zHandleSkips &= handleSpans(this.mIds, spans);
        }
        return (zHandleSkips && arrangeWidgets()) || !this.mValidateInputs;
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

    private boolean handleSkips(int[][] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int rowByIndex = getRowByIndex(iArr[i2][0]);
            int colByIndex = getColByIndex(iArr[i2][0]);
            int[] iArr2 = iArr[i2];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return false;
            }
        }
        return true;
    }

    private boolean handleSpans(int[] iArr, int[][] iArr2) {
        View[] views = getViews(this.mContainer);
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            int rowByIndex = getRowByIndex(iArr2[i2][0]);
            int colByIndex = getColByIndex(iArr2[i2][0]);
            int[] iArr3 = iArr2[i2];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr3[1], iArr3[2])) {
                return false;
            }
            View view = views[i2];
            int[] iArr4 = iArr2[i2];
            connectView(view, rowByIndex, colByIndex, iArr4[1], iArr4[2]);
            this.mSpanIds.add(Integer.valueOf(iArr[i2]));
        }
        return true;
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
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
        return true;
    }

    private boolean isWeightsValid(String str) {
        return true;
    }

    private View makeNewView() {
        View view = new View(getContext());
        view.setId(View.generateViewId());
        view.setVisibility(4);
        this.mContainer.addView(view, new ConstraintLayout.LayoutParams(0, 0));
        return view;
    }

    private ConstraintLayout.LayoutParams params(View view) {
        return (ConstraintLayout.LayoutParams) view.getLayoutParams();
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

    private float[] parseWeights(int i2, String str) {
        float[] fArr = null;
        if (str != null && !str.trim().isEmpty()) {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length != i2) {
                return null;
            }
            fArr = new float[i2];
            for (int i8 = 0; i8 < i2; i8++) {
                fArr[i8] = Float.parseFloat(strArrSplit[i8].trim());
            }
        }
        return fArr;
    }

    private void setBoxViewHorizontalChains() {
        int i2;
        int id = getId();
        int iMax = Math.max(this.mRows, this.mColumns);
        float[] weights = parseWeights(this.mColumns, this.mStrColumnWeights);
        int i8 = 0;
        ConstraintLayout.LayoutParams layoutParamsParams = params(this.mBoxViews[0]);
        if (this.mColumns == 1) {
            clearHParams(this.mBoxViews[0]);
            layoutParamsParams.leftToLeft = id;
            layoutParamsParams.rightToRight = id;
            this.mBoxViews[0].setLayoutParams(layoutParamsParams);
            return;
        }
        while (true) {
            i2 = this.mColumns;
            if (i8 >= i2) {
                break;
            }
            ConstraintLayout.LayoutParams layoutParamsParams2 = params(this.mBoxViews[i8]);
            clearHParams(this.mBoxViews[i8]);
            if (weights != null) {
                layoutParamsParams2.horizontalWeight = weights[i8];
            }
            if (i8 > 0) {
                layoutParamsParams2.leftToRight = this.mBoxViewIds[i8 - 1];
            } else {
                layoutParamsParams2.leftToLeft = id;
            }
            if (i8 < this.mColumns - 1) {
                layoutParamsParams2.rightToLeft = this.mBoxViewIds[i8 + 1];
            } else {
                layoutParamsParams2.rightToRight = id;
            }
            if (i8 > 0) {
                ((ViewGroup.MarginLayoutParams) layoutParamsParams2).leftMargin = (int) this.mHorizontalGaps;
            }
            this.mBoxViews[i8].setLayoutParams(layoutParamsParams2);
            i8++;
        }
        while (i2 < iMax) {
            ConstraintLayout.LayoutParams layoutParamsParams3 = params(this.mBoxViews[i2]);
            clearHParams(this.mBoxViews[i2]);
            layoutParamsParams3.leftToLeft = id;
            layoutParamsParams3.rightToRight = id;
            this.mBoxViews[i2].setLayoutParams(layoutParamsParams3);
            i2++;
        }
    }

    private void setBoxViewVerticalChains() {
        int i2;
        int id = getId();
        int iMax = Math.max(this.mRows, this.mColumns);
        float[] weights = parseWeights(this.mRows, this.mStrRowWeights);
        int i8 = 0;
        if (this.mRows == 1) {
            ConstraintLayout.LayoutParams layoutParamsParams = params(this.mBoxViews[0]);
            clearVParams(this.mBoxViews[0]);
            layoutParamsParams.topToTop = id;
            layoutParamsParams.bottomToBottom = id;
            this.mBoxViews[0].setLayoutParams(layoutParamsParams);
            return;
        }
        while (true) {
            i2 = this.mRows;
            if (i8 >= i2) {
                break;
            }
            ConstraintLayout.LayoutParams layoutParamsParams2 = params(this.mBoxViews[i8]);
            clearVParams(this.mBoxViews[i8]);
            if (weights != null) {
                layoutParamsParams2.verticalWeight = weights[i8];
            }
            if (i8 > 0) {
                layoutParamsParams2.topToBottom = this.mBoxViewIds[i8 - 1];
            } else {
                layoutParamsParams2.topToTop = id;
            }
            if (i8 < this.mRows - 1) {
                layoutParamsParams2.bottomToTop = this.mBoxViewIds[i8 + 1];
            } else {
                layoutParamsParams2.bottomToBottom = id;
            }
            if (i8 > 0) {
                ((ViewGroup.MarginLayoutParams) layoutParamsParams2).topMargin = (int) this.mHorizontalGaps;
            }
            this.mBoxViews[i8].setLayoutParams(layoutParamsParams2);
            i8++;
        }
        while (i2 < iMax) {
            ConstraintLayout.LayoutParams layoutParamsParams3 = params(this.mBoxViews[i2]);
            clearVParams(this.mBoxViews[i2]);
            layoutParamsParams3.topToTop = id;
            layoutParamsParams3.bottomToBottom = id;
            this.mBoxViews[i2].setLayoutParams(layoutParamsParams3);
            i2++;
        }
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
            this.mRows = ((this.mCount + i9) - 1) / i9;
        } else if (i8 > 0) {
            this.mRows = i8;
            this.mColumns = ((this.mCount + i8) - 1) / i8;
        } else {
            int iSqrt = (int) (Math.sqrt(this.mCount) + 1.5d);
            this.mRows = iSqrt;
            this.mColumns = ((this.mCount + iSqrt) - 1) / iSqrt;
        }
    }

    public String getColumnWeights() {
        return this.mStrColumnWeights;
    }

    public int getColumns() {
        return this.mColumnsSet;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public String getRowWeights() {
        return this.mStrRowWeights;
    }

    public int getRows() {
        return this.mRowsSet;
    }

    public String getSkips() {
        return this.mStrSkips;
    }

    public String getSpans() {
        return this.mStrSpans;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = true;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Grid);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Grid_grid_rows) {
                    this.mRowsSet = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_columns) {
                    this.mColumnsSet = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_spans) {
                    this.mStrSpans = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_skips) {
                    this.mStrSkips = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_rowWeights) {
                    this.mStrRowWeights = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_columnWeights) {
                    this.mStrColumnWeights = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_orientation) {
                    this.mOrientation = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.Grid_grid_horizontalGaps) {
                    this.mHorizontalGaps = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_verticalGaps) {
                    this.mVerticalGaps = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_validateInputs) {
                    this.mValidateInputs = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R.styleable.Grid_grid_useRtl) {
                    this.mUseRtl = typedArrayObtainStyledAttributes.getBoolean(index, false);
                }
            }
            updateActualRowsAndColumns();
            initVariables();
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer = (ConstraintLayout) getParent();
        generateGrid(false);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            Paint paint = new Paint();
            paint.setColor(SupportMenu.CATEGORY_MASK);
            paint.setStyle(Paint.Style.STROKE);
            int top = getTop();
            int left = getLeft();
            int bottom = getBottom();
            int right = getRight();
            for (View view : this.mBoxViews) {
                int left2 = view.getLeft() - left;
                int top2 = view.getTop() - top;
                int right2 = view.getRight() - left;
                int bottom2 = view.getBottom() - top;
                canvas.drawRect(left2, 0.0f, right2, bottom - top, paint);
                canvas.drawRect(0.0f, top2, right - left, bottom2, paint);
            }
        }
    }

    public void setColumnWeights(String str) {
        if (isWeightsValid(str)) {
            String str2 = this.mStrColumnWeights;
            if (str2 == null || !str2.equals(str)) {
                this.mStrColumnWeights = str;
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setColumns(int i2) {
        if (i2 <= 50 && this.mColumnsSet != i2) {
            this.mColumnsSet = i2;
            updateActualRowsAndColumns();
            initVariables();
            generateGrid(false);
            invalidate();
        }
    }

    public void setHorizontalGaps(float f4) {
        if (f4 >= 0.0f && this.mHorizontalGaps != f4) {
            this.mHorizontalGaps = f4;
            generateGrid(true);
            invalidate();
        }
    }

    public void setOrientation(int i2) {
        if ((i2 == 0 || i2 == 1) && this.mOrientation != i2) {
            this.mOrientation = i2;
            generateGrid(true);
            invalidate();
        }
    }

    public void setRowWeights(String str) {
        if (isWeightsValid(str)) {
            String str2 = this.mStrRowWeights;
            if (str2 == null || !str2.equals(str)) {
                this.mStrRowWeights = str;
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setRows(int i2) {
        if (i2 <= 50 && this.mRowsSet != i2) {
            this.mRowsSet = i2;
            updateActualRowsAndColumns();
            initVariables();
            generateGrid(false);
            invalidate();
        }
    }

    public void setSkips(String str) {
        if (isSpansValid(str)) {
            String str2 = this.mStrSkips;
            if (str2 == null || !str2.equals(str)) {
                this.mStrSkips = str;
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setSpans(CharSequence charSequence) {
        if (isSpansValid(charSequence)) {
            String str = this.mStrSpans;
            if (str == null || !str.contentEquals(charSequence)) {
                this.mStrSpans = charSequence.toString();
                generateGrid(true);
                invalidate();
            }
        }
    }

    public void setVerticalGaps(float f4) {
        if (f4 >= 0.0f && this.mVerticalGaps != f4) {
            this.mVerticalGaps = f4;
            generateGrid(true);
            invalidate();
        }
    }

    public Grid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }

    public Grid(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mMaxRows = 50;
        this.mMaxColumns = 50;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
    }
}
