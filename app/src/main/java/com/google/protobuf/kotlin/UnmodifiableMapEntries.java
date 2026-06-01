package com.google.protobuf.kotlin;

import f6.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class UnmodifiableMapEntries<K, V> extends UnmodifiableCollection<Map.Entry<? extends K, ? extends V>> implements Set<Map.Entry<? extends K, ? extends V>> {
    private final Set<Map.Entry<K, V>> delegate;

    /* JADX INFO: renamed from: com.google.protobuf.kotlin.UnmodifiableMapEntries$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 implements Iterator<Map.Entry<? extends K, ? extends V>>, a {
        private final /* synthetic */ Iterator<Map.Entry<K, V>> $$delegate_0;
        final /* synthetic */ Iterator<Map.Entry<K, V>> $itr;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
            this.$itr = it;
            this.$$delegate_0 = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.$$delegate_0.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return new UnmodifiableMapEntry(this.$itr.next());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnmodifiableMapEntries(Set<? extends Map.Entry<? extends K, ? extends V>> delegate) {
        super(delegate);
        k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // com.google.protobuf.kotlin.UnmodifiableCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry<? extends Object, ? extends Object>) obj);
        }
        return false;
    }

    @Override // com.google.protobuf.kotlin.UnmodifiableCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new AnonymousClass1(this.delegate.iterator());
    }

    public /* bridge */ boolean contains(Map.Entry<? extends Object, ? extends Object> entry) {
        return super.contains(entry);
    }
}
