package androidx.core.util;

import android.util.LruCache;
import e6.p;
import e6.r;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements p {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // e6.p
        public final Integer invoke(Object obj, Object obj2) {
            return 1;
        }
    }

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // e6.l
        public final Object invoke(Object obj) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass3 extends l implements r {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        public final void invoke(boolean z2, Object obj, Object obj2, Object obj3) {
        }

        @Override // e6.r
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke(((Boolean) obj).booleanValue(), obj2, obj3, obj4);
            return x.f13520a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ e6.l $create;
        final /* synthetic */ r $onEntryRemoved;
        final /* synthetic */ p $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(int i2, p pVar, e6.l lVar, r rVar) {
            super(i2);
            this.$sizeOf = pVar;
            this.$create = lVar;
            this.$onEntryRemoved = rVar;
        }

        @Override // android.util.LruCache
        public V create(K k) {
            return (V) this.$create.invoke(k);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z2, K k, V v2, V v7) {
            this.$onEntryRemoved.invoke(Boolean.valueOf(z2), k, v2, v7);
        }

        @Override // android.util.LruCache
        public int sizeOf(K k, V v2) {
            return ((Number) this.$sizeOf.invoke(k, v2)).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i2, p pVar, e6.l lVar, r rVar) {
        return new AnonymousClass4(i2, pVar, lVar, rVar);
    }

    public static /* synthetic */ LruCache lruCache$default(int i2, p pVar, e6.l lVar, r rVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            pVar = AnonymousClass1.INSTANCE;
        }
        if ((i8 & 4) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        if ((i8 & 8) != 0) {
            rVar = AnonymousClass3.INSTANCE;
        }
        return new AnonymousClass4(i2, pVar, lVar, rVar);
    }
}
