package androidx.constraintlayout.core.widgets.analyzer;

import a1.a;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int mDirection;
    WidgetRun mFirstRun;
    int mGroupIndex;
    WidgetRun mLastRun;
    public int position = 0;
    public boolean dual = false;
    ArrayList<WidgetRun> mRuns = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i2) {
        this.mFirstRun = null;
        this.mLastRun = null;
        int i8 = index;
        this.mGroupIndex = i8;
        index = i8 + 1;
        this.mFirstRun = widgetRun;
        this.mLastRun = widgetRun;
        this.mDirection = i2;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i2) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.mWidget.isTerminalWidget[i2]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.mDependencies) {
            if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).mRun) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    ArrayList<WidgetRun> arrayList = ((ChainRun) widgetRun).mWidgets;
                    int size = arrayList.size();
                    int i8 = 0;
                    while (i8 < size) {
                        WidgetRun widgetRun4 = arrayList.get(i8);
                        i8++;
                        defineTerminalWidget(widgetRun4, i2);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.mWidget.isTerminalWidget[i2] = false;
                }
                defineTerminalWidget(dependencyNode2.mRun, i2);
            }
        }
        for (Dependency dependency2 : widgetRun.end.mDependencies) {
            if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).mRun) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    ArrayList<WidgetRun> arrayList2 = ((ChainRun) widgetRun).mWidgets;
                    int size2 = arrayList2.size();
                    int i9 = 0;
                    while (i9 < size2) {
                        WidgetRun widgetRun5 = arrayList2.get(i9);
                        i9++;
                        defineTerminalWidget(widgetRun5, i2);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.mWidget.isTerminalWidget[i2] = false;
                }
                defineTerminalWidget(dependencyNode.mRun, i2);
            }
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.mDependencies.size();
        long jMin = j;
        for (int i2 = 0; i2 < size; i2++) {
            Dependency dependency = dependencyNode.mDependencies.get(i2);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    jMin = Math.min(jMin, traverseEnd(dependencyNode2, ((long) dependencyNode2.mMargin) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return jMin;
        }
        long wrapDimension = j - widgetRun.getWrapDimension();
        return Math.min(Math.min(jMin, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - ((long) widgetRun.start.mMargin));
    }

    private long traverseStart(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.mDependencies.size();
        long jMax = j;
        for (int i2 = 0; i2 < size; i2++) {
            Dependency dependency = dependencyNode.mDependencies.get(i2);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    jMax = Math.max(jMax, traverseStart(dependencyNode2, ((long) dependencyNode2.mMargin) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return jMax;
        }
        long wrapDimension = j + widgetRun.getWrapDimension();
        return Math.max(Math.max(jMax, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - ((long) widgetRun.end.mMargin));
    }

    public void add(WidgetRun widgetRun) {
        this.mRuns.add(widgetRun);
        this.mLastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        WidgetRun widgetRun = this.mFirstRun;
        if (widgetRun instanceof ChainRun) {
            if (((ChainRun) widgetRun).orientation != i2) {
                return 0L;
            }
        } else if (i2 == 0) {
            if (!(widgetRun instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i2 == 0 ? constraintWidgetContainer.mHorizontalRun : constraintWidgetContainer.mVerticalRun).start;
        DependencyNode dependencyNode2 = (i2 == 0 ? constraintWidgetContainer.mHorizontalRun : constraintWidgetContainer.mVerticalRun).end;
        boolean zContains = widgetRun.start.mTargets.contains(dependencyNode);
        boolean zContains2 = this.mFirstRun.end.mTargets.contains(dependencyNode2);
        long wrapDimension = this.mFirstRun.getWrapDimension();
        if (!zContains || !zContains2) {
            if (zContains) {
                return Math.max(traverseStart(this.mFirstRun.start, r12.mMargin), ((long) this.mFirstRun.start.mMargin) + wrapDimension);
            }
            if (zContains2) {
                return Math.max(-traverseEnd(this.mFirstRun.end, r12.mMargin), ((long) (-this.mFirstRun.end.mMargin)) + wrapDimension);
            }
            WidgetRun widgetRun2 = this.mFirstRun;
            return (widgetRun2.getWrapDimension() + ((long) widgetRun2.start.mMargin)) - ((long) this.mFirstRun.end.mMargin);
        }
        long jTraverseStart = traverseStart(this.mFirstRun.start, 0L);
        long jTraverseEnd = traverseEnd(this.mFirstRun.end, 0L);
        long j = jTraverseStart - wrapDimension;
        WidgetRun widgetRun3 = this.mFirstRun;
        int i8 = widgetRun3.end.mMargin;
        if (j >= (-i8)) {
            j += (long) i8;
        }
        int i9 = widgetRun3.start.mMargin;
        long j3 = ((-jTraverseEnd) - wrapDimension) - ((long) i9);
        if (j3 >= i9) {
            j3 -= (long) i9;
        }
        float biasPercent = widgetRun3.mWidget.getBiasPercent(i2);
        float f4 = biasPercent > 0.0f ? (long) ((j / (1.0f - biasPercent)) + (j3 / biasPercent)) : 0L;
        long jA = ((long) ((f4 * biasPercent) + 0.5f)) + wrapDimension + ((long) a.a(1.0f, biasPercent, f4, 0.5f));
        WidgetRun widgetRun4 = this.mFirstRun;
        return (((long) widgetRun4.start.mMargin) + jA) - ((long) widgetRun4.end.mMargin);
    }

    public void defineTerminalWidgets(boolean z2, boolean z7) {
        if (z2) {
            WidgetRun widgetRun = this.mFirstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z7) {
            WidgetRun widgetRun2 = this.mFirstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
