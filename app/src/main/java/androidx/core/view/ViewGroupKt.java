package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 implements Iterator<View>, f6.a {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        public AnonymousClass1(ViewGroup viewGroup) {
            this.$this_iterator = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.$this_iterator;
            int i2 = this.index - 1;
            this.index = i2;
            viewGroup.removeViewAt(i2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup viewGroup = this.$this_iterator;
            int i2 = this.index;
            this.index = i2 + 1;
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(ViewGroup viewGroup, View view) {
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, e6.l lVar) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            lVar.invoke(viewGroup.getChildAt(i2));
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, e6.p pVar) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            pVar.invoke(Integer.valueOf(i2), viewGroup.getChildAt(i2));
        }
    }

    public static final View get(ViewGroup viewGroup, int i2) {
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        StringBuilder sbV = a1.a.v(i2, "Index: ", ", Size: ");
        sbV.append(viewGroup.getChildCount());
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public static final m6.h getChildren(final ViewGroup viewGroup) {
        return new m6.h() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // m6.h
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final m6.h getDescendants(final ViewGroup viewGroup) {
        return new m6.h() { // from class: androidx.core.view.ViewGroupKt$special$$inlined$Sequence$1
            @Override // m6.h
            public Iterator<View> iterator() {
                return new TreeIterator(ViewGroupKt.getChildren(viewGroup).iterator(), ViewGroupKt$descendants$1$1.INSTANCE);
            }
        };
    }

    public static final k6.d getIndices(ViewGroup viewGroup) {
        return r2.q.D0(0, viewGroup.getChildCount());
    }

    public static final int getSize(ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        return new AnonymousClass1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2) {
        marginLayoutParams.setMargins(i2, i2, i2, i2);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i8, @Px int i9, @Px int i10) {
        marginLayoutParams.setMargins(i2, i8, i9, i10);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i2 = marginLayoutParams.leftMargin;
        }
        if ((i11 & 2) != 0) {
            i8 = marginLayoutParams.topMargin;
        }
        if ((i11 & 4) != 0) {
            i9 = marginLayoutParams.rightMargin;
        }
        if ((i11 & 8) != 0) {
            i10 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i2, i8, i9, i10);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i8, @Px int i9, @Px int i10) {
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i8;
        marginLayoutParams.setMarginEnd(i9);
        marginLayoutParams.bottomMargin = i10;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i2 = marginLayoutParams.getMarginStart();
        }
        if ((i11 & 2) != 0) {
            i8 = marginLayoutParams.topMargin;
        }
        if ((i11 & 4) != 0) {
            i9 = marginLayoutParams.getMarginEnd();
        }
        if ((i11 & 8) != 0) {
            i10 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i8;
        marginLayoutParams.setMarginEnd(i9);
        marginLayoutParams.bottomMargin = i10;
    }
}
