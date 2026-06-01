package androidx.gridlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.camera.core.processing.util.a;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.gridlayout.R;
import com.ironsource.C2300e4;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class GridLayout extends ViewGroup {
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    public static final Alignment BASELINE;
    public static final Alignment BOTTOM;
    static final int CAN_STRETCH = 2;
    public static final Alignment CENTER;
    private static final int DEFAULT_ALIGNMENT_MODE = 1;
    static final int DEFAULT_CONTAINER_MARGIN = 0;
    private static final int DEFAULT_COUNT = Integer.MIN_VALUE;
    static final boolean DEFAULT_ORDER_PRESERVED = true;
    private static final int DEFAULT_ORIENTATION = 0;
    private static final boolean DEFAULT_USE_DEFAULT_MARGINS = false;
    public static final Alignment END;
    public static final Alignment FILL;
    public static final int HORIZONTAL = 0;
    static final int INFLEXIBLE = 0;
    private static final Alignment LEADING;
    public static final Alignment LEFT;
    static final int MAX_SIZE = 100000;
    public static final Alignment RIGHT;
    public static final Alignment START;
    public static final Alignment TOP;
    private static final Alignment TRAILING;
    public static final int UNDEFINED = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH = 0;
    public static final int VERTICAL = 1;
    int mAlignmentMode;
    int mDefaultGap;
    final Axis mHorizontalAxis;
    int mLastLayoutParamsHashCode;
    int mOrientation;
    Printer mPrinter;
    boolean mUseDefaultMargins;
    final Axis mVerticalAxis;
    static final Printer LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
    static final Printer NO_PRINTER = new Printer() { // from class: androidx.gridlayout.widget.GridLayout.1
        @Override // android.util.Printer
        public void println(String str) {
        }
    };
    private static final int ORIENTATION = R.styleable.GridLayout_orientation;
    private static final int ROW_COUNT = R.styleable.GridLayout_rowCount;
    private static final int COLUMN_COUNT = R.styleable.GridLayout_columnCount;
    private static final int USE_DEFAULT_MARGINS = R.styleable.GridLayout_useDefaultMargins;
    private static final int ALIGNMENT_MODE = R.styleable.GridLayout_alignmentMode;
    private static final int ROW_ORDER_PRESERVED = R.styleable.GridLayout_rowOrderPreserved;
    private static final int COLUMN_ORDER_PRESERVED = R.styleable.GridLayout_columnOrderPreserved;
    static final Alignment UNDEFINED_ALIGNMENT = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.2
        @Override // androidx.gridlayout.widget.GridLayout.Alignment
        public int getAlignmentValue(View view, int i2, int i8) {
            return Integer.MIN_VALUE;
        }

        @Override // androidx.gridlayout.widget.GridLayout.Alignment
        public String getDebugString() {
            return "UNDEFINED";
        }

        @Override // androidx.gridlayout.widget.GridLayout.Alignment
        public int getGravityOffset(View view, int i2) {
            return Integer.MIN_VALUE;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Arc {
        public final Interval span;
        public boolean valid = true;
        public final MutableInt value;

        public Arc(Interval interval, MutableInt mutableInt) {
            this.span = interval;
            this.value = mutableInt;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.span);
            sb.append(" ");
            sb.append(!this.valid ? "+>" : "->");
            sb.append(" ");
            sb.append(this.value);
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> cls, Class<V> cls2) {
            this.keyType = cls;
            this.valueType = cls2;
        }

        public static <K, V> Assoc<K, V> of(Class<K> cls, Class<V> cls2) {
            return new Assoc<>(cls, cls2);
        }

        public PackedMap<K, V> pack() {
            int size = size();
            Object[] objArr = (Object[]) Array.newInstance((Class<?>) this.keyType, size);
            Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.valueType, size);
            for (int i2 = 0; i2 < size; i2++) {
                objArr[i2] = get(i2).first;
                objArr2[i2] = get(i2).second;
            }
            return new PackedMap<>(objArr, objArr2);
        }

        public void put(K k, V v2) {
            add(Pair.create(k, v2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class Axis {
        static final int COMPLETE = 2;
        static final int NEW = 0;
        static final int PENDING = 1;
        public Arc[] arcs;
        PackedMap<Interval, MutableInt> backwardLinks;
        public int[] deltas;
        PackedMap<Interval, MutableInt> forwardLinks;
        PackedMap<Spec, Bounds> groupBounds;
        public boolean hasWeights;
        public final boolean horizontal;
        public int[] leadingMargins;
        public int[] locations;
        public int[] trailingMargins;
        public int definedCount = Integer.MIN_VALUE;
        private int maxIndex = Integer.MIN_VALUE;
        public boolean groupBoundsValid = false;
        public boolean forwardLinksValid = false;
        public boolean backwardLinksValid = false;
        public boolean leadingMarginsValid = false;
        public boolean trailingMarginsValid = false;
        public boolean arcsValid = false;
        public boolean locationsValid = false;
        public boolean hasWeightsValid = false;
        boolean orderPreserved = true;
        private MutableInt parentMin = new MutableInt(0);
        private MutableInt parentMax = new MutableInt(-100000);

        public Axis(boolean z2) {
            this.horizontal = z2;
        }

        private void addComponentSizes(List<Arc> list, PackedMap<Interval, MutableInt> packedMap) {
            int i2 = 0;
            while (true) {
                Interval[] intervalArr = packedMap.keys;
                if (i2 >= intervalArr.length) {
                    return;
                }
                include(list, intervalArr[i2], packedMap.values[i2], false);
                i2++;
            }
        }

        private String arcsToString(List<Arc> list) {
            String strM;
            String str = this.horizontal ? "x" : "y";
            StringBuilder sb = new StringBuilder();
            boolean z2 = true;
            for (Arc arc : list) {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(", ");
                }
                Interval interval = arc.span;
                int i2 = interval.min;
                int i8 = interval.max;
                int i9 = arc.value.value;
                if (i2 < i8) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(i8);
                    sb2.append("-");
                    sb2.append(str);
                    sb2.append(i2);
                    strM = a.m(sb2, ">=", i9);
                } else {
                    strM = str + i2 + "-" + str + i8 + "<=" + (-i9);
                }
                sb.append(strM);
            }
            return sb.toString();
        }

        private int calculateMaxIndex() {
            int childCount = GridLayout.this.getChildCount();
            int iMax = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i2));
                Interval interval = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                iMax = Math.max(Math.max(Math.max(iMax, interval.min), interval.max), interval.size());
            }
            if (iMax == -1) {
                return Integer.MIN_VALUE;
            }
            return iMax;
        }

        private float calculateTotalWeight() {
            int childCount = GridLayout.this.getChildCount();
            float f4 = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    f4 += (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                }
            }
            return f4;
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        private void computeGroupBounds() {
            for (Bounds bounds : this.groupBounds.values) {
                bounds.reset();
            }
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                boolean z2 = this.horizontal;
                Spec spec = z2 ? layoutParams.columnSpec : layoutParams.rowSpec;
                this.groupBounds.getValue(i2).include(GridLayout.this, childAt, spec, this, GridLayout.this.getMeasurementIncludingMargin(childAt, z2) + (spec.weight == 0.0f ? 0 : getDeltas()[i2]));
            }
        }

        private boolean computeHasWeights() {
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    if ((this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight != 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        private void computeLinks(PackedMap<Interval, MutableInt> packedMap, boolean z2) {
            for (MutableInt mutableInt : packedMap.values) {
                mutableInt.reset();
            }
            Bounds[] boundsArr = getGroupBounds().values;
            for (int i2 = 0; i2 < boundsArr.length; i2++) {
                int size = boundsArr[i2].size(z2);
                MutableInt value = packedMap.getValue(i2);
                int i8 = value.value;
                if (!z2) {
                    size = -size;
                }
                value.value = Math.max(i8, size);
            }
        }

        private void computeLocations(int[] iArr) {
            if (hasWeights()) {
                solveAndDistributeSpace(iArr);
            } else {
                solve(iArr);
            }
            if (this.orderPreserved) {
                return;
            }
            int i2 = iArr[0];
            int length = iArr.length;
            for (int i8 = 0; i8 < length; i8++) {
                iArr[i8] = iArr[i8] - i2;
            }
        }

        private void computeMargins(boolean z2) {
            int[] iArr = z2 ? this.leadingMargins : this.trailingMargins;
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = GridLayout.this.getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    boolean z7 = this.horizontal;
                    Interval interval = (z7 ? layoutParams.columnSpec : layoutParams.rowSpec).span;
                    int i8 = z2 ? interval.min : interval.max;
                    iArr[i8] = Math.max(iArr[i8], GridLayout.this.getMargin1(childAt, z7, z2));
                }
            }
        }

        private Arc[] createArcs() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            addComponentSizes(arrayList, getForwardLinks());
            addComponentSizes(arrayList2, getBackwardLinks());
            if (this.orderPreserved) {
                int i2 = 0;
                while (i2 < getCount()) {
                    int i8 = i2 + 1;
                    include(arrayList, new Interval(i2, i8), new MutableInt(0));
                    i2 = i8;
                }
            }
            int count = getCount();
            include(arrayList, new Interval(0, count), this.parentMin, false);
            include(arrayList2, new Interval(count, 0), this.parentMax, false);
            return (Arc[]) GridLayout.append(topologicalSort(arrayList), topologicalSort(arrayList2));
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc assocOf = Assoc.of(Spec.class, Bounds.class);
            int childCount = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i2));
                boolean z2 = this.horizontal;
                Spec spec = z2 ? layoutParams.columnSpec : layoutParams.rowSpec;
                assocOf.put(spec, spec.getAbsoluteAlignment(z2).getBounds());
            }
            return assocOf.pack();
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean z2) {
            Assoc assocOf = Assoc.of(Interval.class, MutableInt.class);
            Spec[] specArr = getGroupBounds().keys;
            int length = specArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                assocOf.put(z2 ? specArr[i2].span : specArr[i2].span.inverse(), new MutableInt());
            }
            return assocOf.pack();
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks(false);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, false);
                this.backwardLinksValid = true;
            }
            return this.backwardLinks;
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(true);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, true);
                this.forwardLinksValid = true;
            }
            return this.forwardLinks;
        }

        private int getMaxIndex() {
            if (this.maxIndex == Integer.MIN_VALUE) {
                this.maxIndex = Math.max(0, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        private int getMeasure(int i2, int i8) {
            setParentConstraints(i2, i8);
            return size(getLocations());
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = true;
            }
            return this.hasWeights;
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt, boolean z2) {
            if (interval.size() == 0) {
                return;
            }
            if (z2) {
                Iterator<Arc> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().span.equals(interval)) {
                        return;
                    }
                }
            }
            list.add(new Arc(interval, mutableInt));
        }

        private void init(int[] iArr) {
            Arrays.fill(iArr, 0);
        }

        private void logError(String str, Arc[] arcArr, boolean[] zArr) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < arcArr.length; i2++) {
                Arc arc = arcArr[i2];
                if (zArr[i2]) {
                    arrayList.add(arc);
                }
                if (!arc.valid) {
                    arrayList2.add(arc);
                }
            }
            Printer printer = GridLayout.this.mPrinter;
            StringBuilder sbX = a1.a.x(str, " constraints: ");
            sbX.append(arcsToString(arrayList));
            sbX.append(" are inconsistent; permanently removing: ");
            sbX.append(arcsToString(arrayList2));
            sbX.append(". ");
            printer.println(sbX.toString());
        }

        private boolean relax(int[] iArr, Arc arc) {
            if (!arc.valid) {
                return false;
            }
            Interval interval = arc.span;
            int i2 = interval.min;
            int i8 = interval.max;
            int i9 = iArr[i2] + arc.value.value;
            if (i9 <= iArr[i8]) {
                return false;
            }
            iArr[i8] = i9;
            return true;
        }

        private void setParentConstraints(int i2, int i8) {
            this.parentMin.value = i2;
            this.parentMax.value = -i8;
            this.locationsValid = false;
        }

        private void shareOutDelta(int i2, float f4) {
            Arrays.fill(this.deltas, 0);
            int childCount = GridLayout.this.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = GridLayout.this.getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = GridLayout.this.getLayoutParams(childAt);
                    float f8 = (this.horizontal ? layoutParams.columnSpec : layoutParams.rowSpec).weight;
                    if (f8 != 0.0f) {
                        int iRound = Math.round((i2 * f8) / f4);
                        this.deltas[i8] = iRound;
                        i2 -= iRound;
                        f4 -= f8;
                    }
                }
            }
        }

        private int size(int[] iArr) {
            return iArr[getCount()];
        }

        private boolean solve(Arc[] arcArr, int[] iArr) {
            return solve(arcArr, iArr, true);
        }

        private void solveAndDistributeSpace(int[] iArr) {
            Arrays.fill(getDeltas(), 0);
            solve(iArr);
            boolean z2 = true;
            int childCount = (GridLayout.this.getChildCount() * this.parentMin.value) + 1;
            if (childCount < 2) {
                return;
            }
            float fCalculateTotalWeight = calculateTotalWeight();
            int i2 = -1;
            int i8 = 0;
            while (i8 < childCount) {
                int i9 = (int) ((((long) i8) + ((long) childCount)) / 2);
                invalidateValues();
                shareOutDelta(i9, fCalculateTotalWeight);
                boolean zSolve = solve(getArcs(), iArr, false);
                if (zSolve) {
                    i8 = i9 + 1;
                    i2 = i9;
                } else {
                    childCount = i9;
                }
                z2 = zSolve;
            }
            if (i2 <= 0 || z2) {
                return;
            }
            invalidateValues();
            shareOutDelta(i2, fCalculateTotalWeight);
            solve(iArr);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.gridlayout.widget.GridLayout$Axis$1] */
        private Arc[] topologicalSort(Arc[] arcArr) {
            return new Object(arcArr) { // from class: androidx.gridlayout.widget.GridLayout.Axis.1
                Arc[][] arcsByVertex;
                int cursor;
                Arc[] result;
                final /* synthetic */ Arc[] val$arcs;
                int[] visited;

                {
                    this.val$arcs = arcArr;
                    this.result = new Arc[arcArr.length];
                    this.cursor = r0.length - 1;
                    this.arcsByVertex = Axis.this.groupArcsByFirstVertex(arcArr);
                    this.visited = new int[Axis.this.getCount() + 1];
                }

                public Arc[] sort() {
                    int length = this.arcsByVertex.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        walk(i2);
                    }
                    return this.result;
                }

                public void walk(int i2) {
                    int[] iArr = this.visited;
                    if (iArr[i2] != 0) {
                        return;
                    }
                    iArr[i2] = 1;
                    for (Arc arc : this.arcsByVertex[i2]) {
                        walk(arc.span.max);
                        Arc[] arcArr2 = this.result;
                        int i8 = this.cursor;
                        this.cursor = i8 - 1;
                        arcArr2[i8] = arc;
                    }
                    this.visited[i2] = 2;
                }
            }.sort();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = true;
            }
            return this.arcs;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[GridLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = true;
            }
            return this.groupBounds;
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[getCount() + 1];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(true);
                this.leadingMarginsValid = true;
            }
            return this.leadingMargins;
        }

        public int[] getLocations() {
            if (this.locations == null) {
                this.locations = new int[getCount() + 1];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = true;
            }
            return this.locations;
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[getCount() + 1];
            }
            if (!this.trailingMarginsValid) {
                computeMargins(false);
                this.trailingMarginsValid = true;
            }
            return this.trailingMargins;
        }

        public Arc[][] groupArcsByFirstVertex(Arc[] arcArr) {
            int count = getCount() + 1;
            Arc[][] arcArr2 = new Arc[count][];
            int[] iArr = new int[count];
            for (Arc arc : arcArr) {
                int i2 = arc.span.min;
                iArr[i2] = iArr[i2] + 1;
            }
            for (int i8 = 0; i8 < count; i8++) {
                arcArr2[i8] = new Arc[iArr[i8]];
            }
            Arrays.fill(iArr, 0);
            for (Arc arc2 : arcArr) {
                int i9 = arc2.span.min;
                Arc[] arcArr3 = arcArr2[i9];
                int i10 = iArr[i9];
                iArr[i9] = i10 + 1;
                arcArr3[i10] = arc2;
            }
            return arcArr2;
        }

        public void invalidateStructure() {
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.deltas = null;
            this.hasWeightsValid = false;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
        }

        public boolean isOrderPreserved() {
            return this.orderPreserved;
        }

        public void layout(int i2) {
            setParentConstraints(i2, i2);
            getLocations();
        }

        public void setCount(int i2) {
            if (i2 != Integer.MIN_VALUE && i2 < getMaxIndex()) {
                GridLayout.handleInvalidParams((this.horizontal ? "column" : "row").concat("Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child"));
            }
            this.definedCount = i2;
        }

        public void setOrderPreserved(boolean z2) {
            this.orderPreserved = z2;
            invalidateStructure();
        }

        private boolean solve(Arc[] arcArr, int[] iArr, boolean z2) {
            String str = this.horizontal ? "horizontal" : "vertical";
            int count = getCount() + 1;
            boolean[] zArr = null;
            for (int i2 = 0; i2 < arcArr.length; i2++) {
                init(iArr);
                for (int i8 = 0; i8 < count; i8++) {
                    boolean zRelax = false;
                    for (Arc arc : arcArr) {
                        zRelax |= relax(iArr, arc);
                    }
                    if (!zRelax) {
                        if (zArr != null) {
                            logError(str, arcArr, zArr);
                        }
                        return true;
                    }
                }
                if (!z2) {
                    return false;
                }
                boolean[] zArr2 = new boolean[arcArr.length];
                for (int i9 = 0; i9 < count; i9++) {
                    int length = arcArr.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        zArr2[i10] = zArr2[i10] | relax(iArr, arcArr[i10]);
                    }
                }
                if (i2 == 0) {
                    zArr = zArr2;
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= arcArr.length) {
                        break;
                    }
                    if (zArr2[i11]) {
                        Arc arc2 = arcArr[i11];
                        Interval interval = arc2.span;
                        if (interval.min >= interval.max) {
                            arc2.valid = false;
                            break;
                        }
                    }
                    i11++;
                }
            }
            return true;
        }

        private Arc[] topologicalSort(List<Arc> list) {
            return topologicalSort((Arc[]) list.toArray(new Arc[list.size()]));
        }

        public int getMeasure(int i2) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == Integer.MIN_VALUE) {
                return getMeasure(0, size);
            }
            if (mode == 0) {
                return getMeasure(0, GridLayout.MAX_SIZE);
            }
            if (mode != 1073741824) {
                return 0;
            }
            return getMeasure(size, size);
        }

        private void include(List<Arc> list, Interval interval, MutableInt mutableInt) {
            include(list, interval, mutableInt, true);
        }

        private boolean solve(int[] iArr) {
            return solve(getArcs(), iArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Interval {
        public final int max;
        public final int min;

        public Interval(int i2, int i8) {
            this.min = i2;
            this.max = i8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Interval.class != obj.getClass()) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.max == interval.max && this.min == interval.min;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }

        public Interval inverse() {
            return new Interval(this.max, this.min);
        }

        public int size() {
            return this.max - this.min;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(C2300e4.i.f8403d);
            sb.append(this.min);
            sb.append(", ");
            return a1.a.q(sb, C2300e4.i.e, this.max);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        public PackedMap(K[] kArr, V[] vArr) {
            int[] iArrCreateIndex = createIndex(kArr);
            this.index = iArrCreateIndex;
            this.keys = (K[]) compact(kArr, iArrCreateIndex);
            this.values = (V[]) compact(vArr, iArrCreateIndex);
        }

        private static <K> K[] compact(K[] kArr, int[] iArr) {
            int length = kArr.length;
            K[] kArr2 = (K[]) ((Object[]) Array.newInstance(kArr.getClass().getComponentType(), GridLayout.max2(iArr, -1) + 1));
            for (int i2 = 0; i2 < length; i2++) {
                kArr2[iArr[i2]] = kArr[i2];
            }
            return kArr2;
        }

        private static <K> int[] createIndex(K[] kArr) {
            int length = kArr.length;
            int[] iArr = new int[length];
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < length; i2++) {
                K k = kArr[i2];
                Integer numValueOf = (Integer) map.get(k);
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(map.size());
                    map.put(k, numValueOf);
                }
                iArr[i2] = numValueOf.intValue();
            }
            return iArr;
        }

        public V getValue(int i2) {
            return this.values[this.index[i2]];
        }
    }

    static {
        Alignment alignment = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.3
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i2, int i8) {
                return 0;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "LEADING";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i2) {
                return 0;
            }
        };
        LEADING = alignment;
        Alignment alignment2 = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.4
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "TRAILING";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i2) {
                return i2;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i2, int i8) {
                return i2;
            }
        };
        TRAILING = alignment2;
        TOP = alignment;
        BOTTOM = alignment2;
        START = alignment;
        END = alignment2;
        LEFT = createSwitchingAlignment(alignment, alignment2);
        RIGHT = createSwitchingAlignment(alignment2, alignment);
        CENTER = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.6
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i2, int i8) {
                return i2 >> 1;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "CENTER";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i2) {
                return i2 >> 1;
            }
        };
        BASELINE = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.7
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i2, int i8) {
                if (view.getVisibility() == 8) {
                    return 0;
                }
                int baseline = view.getBaseline();
                if (baseline == -1) {
                    return Integer.MIN_VALUE;
                }
                return baseline;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public Bounds getBounds() {
                return new Bounds() { // from class: androidx.gridlayout.widget.GridLayout.7.1
                    private int size;

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    public int getOffset(GridLayout gridLayout, View view, Alignment alignment3, int i2, boolean z2) {
                        return Math.max(0, super.getOffset(gridLayout, view, alignment3, i2, z2));
                    }

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    public void include(int i2, int i8) {
                        super.include(i2, i8);
                        this.size = Math.max(this.size, i2 + i8);
                    }

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    public void reset() {
                        super.reset();
                        this.size = Integer.MIN_VALUE;
                    }

                    @Override // androidx.gridlayout.widget.GridLayout.Bounds
                    public int size(boolean z2) {
                        return Math.max(super.size(z2), this.size);
                    }
                };
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "BASELINE";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i2) {
                return 0;
            }
        };
        FILL = new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.8
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i2, int i8) {
                return Integer.MIN_VALUE;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "FILL";
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i2) {
                return 0;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getSizeInCell(View view, int i2, int i8) {
                return i8;
            }
        };
    }

    public GridLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mHorizontalAxis = new Axis(true);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(R.dimen.default_gap);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.GridLayout, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        try {
            setRowCount(typedArrayObtainStyledAttributes.getInt(ROW_COUNT, Integer.MIN_VALUE));
            setColumnCount(typedArrayObtainStyledAttributes.getInt(COLUMN_COUNT, Integer.MIN_VALUE));
            setOrientation(typedArrayObtainStyledAttributes.getInt(ORIENTATION, 0));
            setUseDefaultMargins(typedArrayObtainStyledAttributes.getBoolean(USE_DEFAULT_MARGINS, false));
            setAlignmentMode(typedArrayObtainStyledAttributes.getInt(ALIGNMENT_MODE, 1));
            setRowOrderPreserved(typedArrayObtainStyledAttributes.getBoolean(ROW_ORDER_PRESERVED, true));
            setColumnOrderPreserved(typedArrayObtainStyledAttributes.getBoolean(COLUMN_ORDER_PRESERVED, true));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int adjust(int i2, int i8) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i8 + i2), View.MeasureSpec.getMode(i2));
    }

    public static <T> T[] append(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static boolean canStretch(int i2) {
        return (i2 & 2) != 0;
    }

    private void checkLayoutParams(LayoutParams layoutParams, boolean z2) {
        String str = z2 ? "column" : "row";
        Interval interval = (z2 ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        int i2 = interval.min;
        if (i2 != Integer.MIN_VALUE && i2 < 0) {
            handleInvalidParams(str.concat(" indices must be positive"));
        }
        int i8 = (z2 ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i8 != Integer.MIN_VALUE) {
            if (interval.max > i8) {
                handleInvalidParams(str + " indices (start + span) mustn't exceed the " + str + " count");
            }
            if (interval.size() > i8) {
                handleInvalidParams(str + " span mustn't exceed the " + str + " count");
            }
        }
    }

    private static int clip(Interval interval, boolean z2, int i2) {
        int size = interval.size();
        if (i2 == 0) {
            return size;
        }
        return Math.min(size, i2 - (z2 ? Math.min(interval.min, i2) : 0));
    }

    private int computeLayoutParamsHashCode() {
        int childCount = getChildCount();
        int iHashCode = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                iHashCode = ((LayoutParams) childAt.getLayoutParams()).hashCode() + (iHashCode * 31);
            }
        }
        return iHashCode;
    }

    private void consistencyCheck() {
        int i2 = this.mLastLayoutParamsHashCode;
        if (i2 == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (i2 != computeLayoutParamsHashCode()) {
            this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            invalidateStructure();
            consistencyCheck();
        }
    }

    private static Alignment createSwitchingAlignment(final Alignment alignment, final Alignment alignment2) {
        return new Alignment() { // from class: androidx.gridlayout.widget.GridLayout.5
            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getAlignmentValue(View view, int i2, int i8) {
                return (view.getLayoutDirection() == 1 ? alignment2 : alignment).getAlignmentValue(view, i2, i8);
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public String getDebugString() {
                return "SWITCHING[L:" + alignment.getDebugString() + ", R:" + alignment2.getDebugString() + C2300e4.i.e;
            }

            @Override // androidx.gridlayout.widget.GridLayout.Alignment
            public int getGravityOffset(View view, int i2) {
                return (view.getLayoutDirection() == 1 ? alignment2 : alignment).getGravityOffset(view, i2);
            }
        };
    }

    private static boolean fits(int[] iArr, int i2, int i8, int i9) {
        if (i9 > iArr.length) {
            return false;
        }
        while (i8 < i9) {
            if (iArr[i8] > i2) {
                return false;
            }
            i8++;
        }
        return true;
    }

    public static Alignment getAlignment(int i2, boolean z2) {
        int i8 = (i2 & (z2 ? 7 : 112)) >> (z2 ? 0 : 4);
        return i8 != 1 ? i8 != 3 ? i8 != 5 ? i8 != 7 ? i8 != 8388611 ? i8 != 8388613 ? UNDEFINED_ALIGNMENT : END : START : FILL : z2 ? RIGHT : BOTTOM : z2 ? LEFT : TOP : CENTER;
    }

    private int getDefaultMargin(View view) {
        if (this.mUseDefaultMargins && view.getClass() != Space.class) {
            return this.mDefaultGap / 2;
        }
        return 0;
    }

    private int getMargin(View view, boolean z2, boolean z7) {
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, z2, z7);
        }
        Axis axis = z2 ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] leadingMargins = z7 ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams layoutParams = getLayoutParams(view);
        Interval interval = (z2 ? layoutParams.columnSpec : layoutParams.rowSpec).span;
        return leadingMargins[z7 ? interval.min : interval.max];
    }

    private int getMeasurement(View view, boolean z2) {
        return z2 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private int getTotalMargin(View view, boolean z2) {
        return getMargin(view, z2, true) + getMargin(view, z2, false);
    }

    public static void handleInvalidParams(String str) {
        throw new IllegalArgumentException(a1.a.C(str, ". "));
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = 0;
        Axis axis = this.mHorizontalAxis;
        if (axis != null) {
            axis.invalidateStructure();
        }
        Axis axis2 = this.mVerticalAxis;
        if (axis2 != null) {
            axis2.invalidateStructure();
        }
        invalidateValues();
    }

    private void invalidateValues() {
        Axis axis = this.mHorizontalAxis;
        if (axis == null || this.mVerticalAxis == null) {
            return;
        }
        axis.invalidateValues();
        this.mVerticalAxis.invalidateValues();
    }

    private boolean isLayoutRtlCompat() {
        return getLayoutDirection() == 1;
    }

    public static int max2(int[] iArr, int i2) {
        for (int i8 : iArr) {
            i2 = Math.max(i2, i8);
        }
        return i2;
    }

    private void measureChildWithMargins2(View view, int i2, int i8, int i9, int i10) {
        view.measure(ViewGroup.getChildMeasureSpec(i2, getTotalMargin(view, true), i9), ViewGroup.getChildMeasureSpec(i8, getTotalMargin(view, false), i10));
    }

    private void measureChildrenWithMargins(int i2, int i8, boolean z2) {
        int i9;
        int i10;
        int childCount = getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 8) {
                i9 = i2;
                i10 = i8;
            } else {
                LayoutParams layoutParams = getLayoutParams(childAt);
                if (z2) {
                    i9 = i2;
                    i10 = i8;
                    measureChildWithMargins2(childAt, i9, i10, ((ViewGroup.MarginLayoutParams) layoutParams).width, ((ViewGroup.MarginLayoutParams) layoutParams).height);
                } else {
                    i9 = i2;
                    i10 = i8;
                    boolean z7 = this.mOrientation == 0;
                    Spec spec = z7 ? layoutParams.columnSpec : layoutParams.rowSpec;
                    if (spec.getAbsoluteAlignment(z7) == FILL) {
                        Interval interval = spec.span;
                        int[] locations = (z7 ? this.mHorizontalAxis : this.mVerticalAxis).getLocations();
                        int totalMargin = (locations[interval.max] - locations[interval.min]) - getTotalMargin(childAt, z7);
                        if (z7) {
                            measureChildWithMargins2(childAt, i9, i10, totalMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height);
                        } else {
                            measureChildWithMargins2(childAt, i9, i10, ((ViewGroup.MarginLayoutParams) layoutParams).width, totalMargin);
                        }
                    }
                }
            }
            i11++;
            i2 = i9;
            i8 = i10;
        }
    }

    private static void procrusteanFill(int[] iArr, int i2, int i8, int i9) {
        int length = iArr.length;
        Arrays.fill(iArr, Math.min(i2, length), Math.min(i8, length), i9);
    }

    private static void setCellGroup(LayoutParams layoutParams, int i2, int i8, int i9, int i10) {
        layoutParams.setRowSpecSpan(new Interval(i2, i8 + i2));
        layoutParams.setColumnSpecSpan(new Interval(i9, i10 + i9));
    }

    public static Spec spec(int i2, int i8, Alignment alignment, float f4) {
        return new Spec(i2 != Integer.MIN_VALUE, i2, i8, alignment, f4);
    }

    private void validateLayoutParams() {
        boolean z2 = this.mOrientation == 0;
        int i2 = (z2 ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (i2 == Integer.MIN_VALUE) {
            i2 = 0;
        }
        int[] iArr = new int[i2];
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i10).getLayoutParams();
            Spec spec = z2 ? layoutParams.rowSpec : layoutParams.columnSpec;
            Interval interval = spec.span;
            boolean z7 = spec.startDefined;
            int size = interval.size();
            if (z7) {
                i8 = interval.min;
            }
            Spec spec2 = z2 ? layoutParams.columnSpec : layoutParams.rowSpec;
            Interval interval2 = spec2.span;
            boolean z8 = spec2.startDefined;
            int iClip = clip(interval2, z8, i2);
            if (z8) {
                i9 = interval2.min;
            }
            if (i2 != 0) {
                if (!z7 || !z8) {
                    while (true) {
                        int i11 = i9 + iClip;
                        if (fits(iArr, i8, i9, i11)) {
                            break;
                        }
                        if (z8) {
                            i8++;
                        } else if (i11 <= i2) {
                            i9++;
                        } else {
                            i8++;
                            i9 = 0;
                        }
                    }
                }
                procrusteanFill(iArr, i9, i9 + iClip, i8 + size);
            }
            if (z2) {
                setCellGroup(layoutParams, i8, size, i9, iClip);
            } else {
                setCellGroup(layoutParams, i9, iClip, i8, size);
            }
            i9 += iClip;
        }
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    public final LayoutParams getLayoutParams(View view) {
        return (LayoutParams) view.getLayoutParams();
    }

    public int getMargin1(View view, boolean z2, boolean z7) {
        LayoutParams layoutParams = getLayoutParams(view);
        int i2 = z2 ? z7 ? ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin : ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : z7 ? ((ViewGroup.MarginLayoutParams) layoutParams).topMargin : ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        return i2 == Integer.MIN_VALUE ? getDefaultMargin(view) : i2;
    }

    public final int getMeasurementIncludingMargin(View view, boolean z2) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        return getMeasurement(view, z2) + getTotalMargin(view, z2);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.isOrderPreserved();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.isOrderPreserved();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        GridLayout gridLayout = this;
        gridLayout.consistencyCheck();
        int i14 = i9 - i2;
        int paddingLeft = gridLayout.getPaddingLeft();
        int paddingTop = gridLayout.getPaddingTop();
        int paddingRight = gridLayout.getPaddingRight();
        int paddingBottom = gridLayout.getPaddingBottom();
        gridLayout.mHorizontalAxis.layout((i14 - paddingLeft) - paddingRight);
        gridLayout.mVerticalAxis.layout(((i10 - i8) - paddingTop) - paddingBottom);
        int[] locations = gridLayout.mHorizontalAxis.getLocations();
        int[] locations2 = gridLayout.mVerticalAxis.getLocations();
        int childCount = gridLayout.getChildCount();
        int i15 = 0;
        while (i15 < childCount) {
            View childAt = gridLayout.getChildAt(i15);
            if (childAt.getVisibility() == 8) {
                i11 = i14;
                i12 = paddingLeft;
                i13 = paddingTop;
            } else {
                LayoutParams layoutParams = gridLayout.getLayoutParams(childAt);
                Spec spec = layoutParams.columnSpec;
                Spec spec2 = layoutParams.rowSpec;
                Interval interval = spec.span;
                Interval interval2 = spec2.span;
                int i16 = locations[interval.min];
                int i17 = locations2[interval2.min];
                int i18 = locations[interval.max] - i16;
                int i19 = locations2[interval2.max] - i17;
                int measurement = gridLayout.getMeasurement(childAt, true);
                i11 = i14;
                int measurement2 = gridLayout.getMeasurement(childAt, false);
                Alignment absoluteAlignment = spec.getAbsoluteAlignment(true);
                Alignment absoluteAlignment2 = spec2.getAbsoluteAlignment(false);
                Bounds value = gridLayout.mHorizontalAxis.getGroupBounds().getValue(i15);
                Bounds value2 = gridLayout.mVerticalAxis.getGroupBounds().getValue(i15);
                i12 = paddingLeft;
                int gravityOffset = absoluteAlignment.getGravityOffset(childAt, i18 - value.size(true));
                int gravityOffset2 = absoluteAlignment2.getGravityOffset(childAt, i19 - value2.size(true));
                int margin = gridLayout.getMargin(childAt, true, true);
                int margin2 = gridLayout.getMargin(childAt, false, true);
                int margin3 = gridLayout.getMargin(childAt, true, false);
                int i20 = margin + margin3;
                int margin4 = margin2 + gridLayout.getMargin(childAt, false, false);
                int offset = value.getOffset(gridLayout, childAt, absoluteAlignment, measurement + i20, true);
                i13 = paddingTop;
                int offset2 = value2.getOffset(this, childAt, absoluteAlignment2, measurement2 + margin4, false);
                int sizeInCell = absoluteAlignment.getSizeInCell(childAt, measurement, i18 - i20);
                int sizeInCell2 = absoluteAlignment2.getSizeInCell(childAt, measurement2, i19 - margin4);
                int i21 = i16 + gravityOffset + offset;
                int i22 = !isLayoutRtlCompat() ? i12 + margin + i21 : (((i11 - sizeInCell) - paddingRight) - margin3) - i21;
                int i23 = i13 + i17 + gravityOffset2 + offset2 + margin2;
                if (sizeInCell != childAt.getMeasuredWidth() || sizeInCell2 != childAt.getMeasuredHeight()) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(sizeInCell, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(sizeInCell2, BasicMeasure.EXACTLY));
                }
                childAt.layout(i22, i23, sizeInCell + i22, sizeInCell2 + i23);
            }
            i15++;
            gridLayout = this;
            paddingTop = i13;
            i14 = i11;
            paddingLeft = i12;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i8) {
        int measure;
        int measure2;
        consistencyCheck();
        invalidateValues();
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int iAdjust = adjust(i2, -paddingRight);
        int iAdjust2 = adjust(i8, -paddingBottom);
        measureChildrenWithMargins(iAdjust, iAdjust2, true);
        if (this.mOrientation == 0) {
            measure = this.mHorizontalAxis.getMeasure(iAdjust);
            measureChildrenWithMargins(iAdjust, iAdjust2, false);
            measure2 = this.mVerticalAxis.getMeasure(iAdjust2);
        } else {
            int measure3 = this.mVerticalAxis.getMeasure(iAdjust2);
            measureChildrenWithMargins(iAdjust, iAdjust2, false);
            measure = this.mHorizontalAxis.getMeasure(iAdjust);
            measure2 = measure3;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(measure + paddingRight, getSuggestedMinimumWidth()), i2, 0), View.resolveSizeAndState(Math.max(measure2 + paddingBottom, getSuggestedMinimumHeight()), i8, 0));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        invalidateStructure();
    }

    public void setAlignmentMode(int i2) {
        this.mAlignmentMode = i2;
        requestLayout();
    }

    public void setColumnCount(int i2) {
        this.mHorizontalAxis.setCount(i2);
        invalidateStructure();
        requestLayout();
    }

    public void setColumnOrderPreserved(boolean z2) {
        this.mHorizontalAxis.setOrderPreserved(z2);
        invalidateStructure();
        requestLayout();
    }

    public void setOrientation(int i2) {
        if (this.mOrientation != i2) {
            this.mOrientation = i2;
            invalidateStructure();
            requestLayout();
        }
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = NO_PRINTER;
        }
        this.mPrinter = printer;
    }

    public void setRowCount(int i2) {
        this.mVerticalAxis.setCount(i2);
        invalidateStructure();
        requestLayout();
    }

    public void setRowOrderPreserved(boolean z2) {
        this.mVerticalAxis.setOrderPreserved(z2);
        invalidateStructure();
        requestLayout();
    }

    public void setUseDefaultMargins(boolean z2) {
        this.mUseDefaultMargins = z2;
        requestLayout();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        public Bounds() {
            reset();
        }

        public int getOffset(GridLayout gridLayout, View view, Alignment alignment, int i2, boolean z2) {
            return this.before - alignment.getAlignmentValue(view, i2, ViewGroupCompat.getLayoutMode(gridLayout));
        }

        public void include(int i2, int i8) {
            this.before = Math.max(this.before, i2);
            this.after = Math.max(this.after, i8);
        }

        public void reset() {
            this.before = Integer.MIN_VALUE;
            this.after = Integer.MIN_VALUE;
            this.flexibility = 2;
        }

        public int size(boolean z2) {
            return (z2 || !GridLayout.canStretch(this.flexibility)) ? this.before + this.after : GridLayout.MAX_SIZE;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Bounds{before=");
            sb.append(this.before);
            sb.append(", after=");
            return a0.c(sb, this.after, '}');
        }

        public final void include(GridLayout gridLayout, View view, Spec spec, Axis axis, int i2) {
            this.flexibility &= spec.getFlexibility();
            int alignmentValue = spec.getAbsoluteAlignment(axis.horizontal).getAlignmentValue(view, i2, ViewGroupCompat.getLayoutMode(gridLayout));
            include(alignmentValue, i2 - alignmentValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public void reset() {
            this.value = Integer.MIN_VALUE;
        }

        public String toString() {
            return Integer.toString(this.value);
        }

        public MutableInt(int i2) {
            this.value = i2;
        }
    }

    public static Spec spec(int i2, Alignment alignment, float f4) {
        return spec(i2, 1, alignment, f4);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public static Spec spec(int i2, int i8, float f4) {
        return spec(i2, i8, UNDEFINED_ALIGNMENT, f4);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static Spec spec(int i2, float f4) {
        return spec(i2, 1, f4);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Spec {
        static final float DEFAULT_WEIGHT = 0.0f;
        static final Spec UNDEFINED = GridLayout.spec(Integer.MIN_VALUE);
        final Alignment alignment;
        final Interval span;
        final boolean startDefined;
        final float weight;

        private Spec(boolean z2, Interval interval, Alignment alignment, float f4) {
            this.startDefined = z2;
            this.span = interval;
            this.alignment = alignment;
            this.weight = f4;
        }

        public final Spec copyWriteAlignment(Alignment alignment) {
            return new Spec(this.startDefined, this.span, alignment, this.weight);
        }

        public final Spec copyWriteSpan(Interval interval) {
            return new Spec(this.startDefined, interval, this.alignment, this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Spec)) {
                return false;
            }
            Spec spec = (Spec) obj;
            return this.alignment.equals(spec.alignment) && this.span.equals(spec.span);
        }

        public Alignment getAbsoluteAlignment(boolean z2) {
            Alignment alignment = this.alignment;
            return alignment != GridLayout.UNDEFINED_ALIGNMENT ? alignment : this.weight == 0.0f ? z2 ? GridLayout.START : GridLayout.BASELINE : GridLayout.FILL;
        }

        public final int getFlexibility() {
            return (this.alignment == GridLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? 0 : 2;
        }

        public int hashCode() {
            return this.alignment.hashCode() + (this.span.hashCode() * 31);
        }

        public Spec(boolean z2, int i2, int i8, Alignment alignment, float f4) {
            this(z2, new Interval(i2, i8 + i2), alignment, f4);
        }
    }

    public static Spec spec(int i2, int i8, Alignment alignment) {
        return spec(i2, i8, alignment, 0.0f);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int BOTTOM_MARGIN;
        private static final int COLUMN;
        private static final int COLUMN_SPAN;
        private static final int COLUMN_WEIGHT;
        private static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
        private static final int DEFAULT_HEIGHT = -2;
        private static final int DEFAULT_MARGIN = Integer.MIN_VALUE;
        private static final int DEFAULT_ROW = Integer.MIN_VALUE;
        private static final Interval DEFAULT_SPAN;
        private static final int DEFAULT_SPAN_SIZE;
        private static final int DEFAULT_WIDTH = -2;
        private static final int GRAVITY;
        private static final int LEFT_MARGIN;
        private static final int MARGIN;
        private static final int RIGHT_MARGIN;
        private static final int ROW;
        private static final int ROW_SPAN;
        private static final int ROW_WEIGHT;
        private static final int TOP_MARGIN;
        public Spec columnSpec;
        public Spec rowSpec;

        static {
            Interval interval = new Interval(Integer.MIN_VALUE, -2147483647);
            DEFAULT_SPAN = interval;
            DEFAULT_SPAN_SIZE = interval.size();
            MARGIN = R.styleable.GridLayout_Layout_android_layout_margin;
            LEFT_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginLeft;
            TOP_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginTop;
            RIGHT_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginRight;
            BOTTOM_MARGIN = R.styleable.GridLayout_Layout_android_layout_marginBottom;
            COLUMN = R.styleable.GridLayout_Layout_layout_column;
            COLUMN_SPAN = R.styleable.GridLayout_Layout_layout_columnSpan;
            COLUMN_WEIGHT = R.styleable.GridLayout_Layout_layout_columnWeight;
            ROW = R.styleable.GridLayout_Layout_layout_row;
            ROW_SPAN = R.styleable.GridLayout_Layout_layout_rowSpan;
            ROW_WEIGHT = R.styleable.GridLayout_Layout_layout_rowWeight;
            GRAVITY = R.styleable.GridLayout_Layout_layout_gravity;
        }

        private LayoutParams(int i2, int i8, int i9, int i10, int i11, int i12, Spec spec, Spec spec2) {
            super(i2, i8);
            Spec spec3 = Spec.UNDEFINED;
            this.rowSpec = spec3;
            this.columnSpec = spec3;
            setMargins(i9, i10, i11, i12);
            this.rowSpec = spec;
            this.columnSpec = spec2;
        }

        private void init(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int i2 = typedArrayObtainStyledAttributes.getInt(GRAVITY, 0);
                int i8 = typedArrayObtainStyledAttributes.getInt(COLUMN, Integer.MIN_VALUE);
                int i9 = COLUMN_SPAN;
                int i10 = DEFAULT_SPAN_SIZE;
                this.columnSpec = GridLayout.spec(i8, typedArrayObtainStyledAttributes.getInt(i9, i10), GridLayout.getAlignment(i2, true), typedArrayObtainStyledAttributes.getFloat(COLUMN_WEIGHT, 0.0f));
                this.rowSpec = GridLayout.spec(typedArrayObtainStyledAttributes.getInt(ROW, Integer.MIN_VALUE), typedArrayObtainStyledAttributes.getInt(ROW_SPAN, i10), GridLayout.getAlignment(i2, false), typedArrayObtainStyledAttributes.getFloat(ROW_WEIGHT, 0.0f));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        private void reInitSuper(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridLayout_Layout);
            try {
                int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(MARGIN, Integer.MIN_VALUE);
                ((ViewGroup.MarginLayoutParams) this).leftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(LEFT_MARGIN, dimensionPixelSize);
                ((ViewGroup.MarginLayoutParams) this).topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(TOP_MARGIN, dimensionPixelSize);
                ((ViewGroup.MarginLayoutParams) this).rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(RIGHT_MARGIN, dimensionPixelSize);
                ((ViewGroup.MarginLayoutParams) this).bottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(BOTTOM_MARGIN, dimensionPixelSize);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LayoutParams)) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            return this.columnSpec.equals(layoutParams.columnSpec) && this.rowSpec.equals(layoutParams.rowSpec);
        }

        public int hashCode() {
            return this.columnSpec.hashCode() + (this.rowSpec.hashCode() * 31);
        }

        @Override // android.view.ViewGroup.LayoutParams
        public void setBaseAttributes(TypedArray typedArray, int i2, int i8) {
            ((ViewGroup.MarginLayoutParams) this).width = typedArray.getLayoutDimension(i2, -2);
            ((ViewGroup.MarginLayoutParams) this).height = typedArray.getLayoutDimension(i8, -2);
        }

        public final void setColumnSpecSpan(Interval interval) {
            this.columnSpec = this.columnSpec.copyWriteSpan(interval);
        }

        public void setGravity(int i2) {
            this.rowSpec = this.rowSpec.copyWriteAlignment(GridLayout.getAlignment(i2, false));
            this.columnSpec = this.columnSpec.copyWriteAlignment(GridLayout.getAlignment(i2, true));
        }

        public final void setRowSpecSpan(Interval interval) {
            this.rowSpec = this.rowSpec.copyWriteSpan(interval);
        }

        public LayoutParams(Spec spec, Spec spec2) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, spec, spec2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public LayoutParams() {
            Spec spec = Spec.UNDEFINED;
            this(spec, spec);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
            this.rowSpec = layoutParams.rowSpec;
            this.columnSpec = layoutParams.columnSpec;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Spec spec = Spec.UNDEFINED;
            this.rowSpec = spec;
            this.columnSpec = spec;
            reInitSuper(context, attributeSet);
            init(context, attributeSet);
        }
    }

    public static Spec spec(int i2, Alignment alignment) {
        return spec(i2, 1, alignment);
    }

    public static Spec spec(int i2, int i8) {
        return spec(i2, i8, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int i2) {
        return spec(i2, 1);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams)) {
            return false;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        checkLayoutParams(layoutParams2, true);
        checkLayoutParams(layoutParams2, false);
        return true;
    }

    public GridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Alignment {
        public abstract int getAlignmentValue(View view, int i2, int i8);

        public Bounds getBounds() {
            return new Bounds();
        }

        public abstract String getDebugString();

        public abstract int getGravityOffset(View view, int i2);

        public String toString() {
            return "Alignment:" + getDebugString();
        }

        public int getSizeInCell(View view, int i2, int i8) {
            return i2;
        }
    }
}
