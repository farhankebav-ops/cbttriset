package androidx.collection;

import e6.p;
import f6.a;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import r5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C03271<T> implements Iterator<T>, a {
        final /* synthetic */ SparseArrayCompat<T> $this_valueIterator;
        private int index;

        public C03271(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_valueIterator = sparseArrayCompat;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArrayCompat<T> sparseArrayCompat = this.$this_valueIterator;
            int i2 = this.index;
            this.index = i2 + 1;
            return sparseArrayCompat.valueAt(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }

    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i2) {
        k.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.containsKey(i2);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, p action) {
        k.e(sparseArrayCompat, "<this>");
        k.e(action, "action");
        int size = sparseArrayCompat.size();
        for (int i2 = 0; i2 < size; i2++) {
            action.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i2)), sparseArrayCompat.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int i2, T t3) {
        k.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.get(i2, t3);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> sparseArrayCompat, int i2, e6.a defaultValue) {
        k.e(sparseArrayCompat, "<this>");
        k.e(defaultValue, "defaultValue");
        T t3 = sparseArrayCompat.get(i2);
        return t3 == null ? (T) defaultValue.invoke() : t3;
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        k.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        k.e(sparseArrayCompat, "<this>");
        return !sparseArrayCompat.isEmpty();
    }

    public static final <T> v keyIterator(final SparseArrayCompat<T> sparseArrayCompat) {
        k.e(sparseArrayCompat, "<this>");
        return new v() { // from class: androidx.collection.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArrayCompat.size();
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // r5.v
            public int nextInt() {
                SparseArrayCompat<T> sparseArrayCompat2 = sparseArrayCompat;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArrayCompat2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> other) {
        k.e(sparseArrayCompat, "<this>");
        k.e(other, "other");
        SparseArrayCompat<T> sparseArrayCompat2 = new SparseArrayCompat<>(other.size() + sparseArrayCompat.size());
        sparseArrayCompat2.putAll(sparseArrayCompat);
        sparseArrayCompat2.putAll(other);
        return sparseArrayCompat2;
    }

    public static final /* synthetic */ boolean remove(SparseArrayCompat sparseArrayCompat, int i2, Object obj) {
        k.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.remove(i2, obj);
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i2, T t3) {
        k.e(sparseArrayCompat, "<this>");
        sparseArrayCompat.put(i2, t3);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        k.e(sparseArrayCompat, "<this>");
        return new C03271(sparseArrayCompat);
    }
}
