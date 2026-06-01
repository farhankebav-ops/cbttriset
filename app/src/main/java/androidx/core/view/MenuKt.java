package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 implements Iterator<MenuItem>, f6.a {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        public AnonymousClass1(Menu menu) {
            this.$this_iterator = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_iterator.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            x xVar;
            Menu menu = this.$this_iterator;
            int i2 = this.index - 1;
            this.index = i2;
            MenuItem item = menu.getItem(i2);
            if (item != null) {
                menu.removeItem(item.getItemId());
                xVar = x.f13520a;
            } else {
                xVar = null;
            }
            if (xVar == null) {
                throw new IndexOutOfBoundsException();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public MenuItem next() {
            Menu menu = this.$this_iterator;
            int i2 = this.index;
            this.index = i2 + 1;
            MenuItem item = menu.getItem(i2);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(Menu menu, MenuItem menuItem) {
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (kotlin.jvm.internal.k.a(menu.getItem(i2), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, e6.l lVar) {
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            lVar.invoke(menu.getItem(i2));
        }
    }

    public static final void forEachIndexed(Menu menu, e6.p pVar) {
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(i2), menu.getItem(i2));
        }
    }

    public static final MenuItem get(Menu menu, int i2) {
        return menu.getItem(i2);
    }

    public static final m6.h getChildren(final Menu menu) {
        return new m6.h() { // from class: androidx.core.view.MenuKt$children$1
            @Override // m6.h
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(Menu menu, int i2) {
        x xVar;
        MenuItem item = menu.getItem(i2);
        if (item != null) {
            menu.removeItem(item.getItemId());
            xVar = x.f13520a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
