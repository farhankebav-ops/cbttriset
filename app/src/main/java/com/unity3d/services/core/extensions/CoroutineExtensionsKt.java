package com.unity3d.services.core.extensions;

import e6.l;
import e6.p;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.k;
import q5.j;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f0;
import r2.q;
import v5.c;
import x5.e;
import x5.i;
import z6.a;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CoroutineExtensionsKt {
    private static final LinkedHashMap<Object, f0> deferreds = new LinkedHashMap<Object, f0>() { // from class: com.unity3d.services.core.extensions.CoroutineExtensionsKt$deferreds$1
        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof f0) {
                return containsValue((f0) obj);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<Object, f0>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Set<Map.Entry<Object, f0>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<Object> getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<f0> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Object> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (obj != null && (obj2 instanceof f0)) {
                return remove(obj, (f0) obj2);
            }
            return false;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<Object, f0> eldest) {
            k.e(eldest, "eldest");
            return size() > 100;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<f0> values() {
            return getValues();
        }

        public /* bridge */ boolean containsValue(f0 f0Var) {
            return super.containsValue((Object) f0Var);
        }

        public /* bridge */ boolean remove(Object obj, f0 f0Var) {
            return super.remove(obj, (Object) f0Var);
        }
    };
    private static final a mutex = d.a();

    /* JADX INFO: renamed from: com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.core.extensions.CoroutineExtensionsKt$memoize$2", f = "CoroutineExtensions.kt", l = {53, 45}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ l $action;
        final /* synthetic */ Object $key;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Object obj, l lVar, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$key = obj;
            this.$action = lVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$key, this.$action, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a0 a0Var;
            Object obj2;
            l lVar;
            a aVar;
            w5.a aVar2 = w5.a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    q.z0(obj);
                    a0Var = (a0) this.L$0;
                    a mutex = CoroutineExtensionsKt.getMutex();
                    Object obj3 = this.$key;
                    l lVar2 = this.$action;
                    this.L$0 = a0Var;
                    this.L$1 = mutex;
                    this.L$2 = obj3;
                    this.L$3 = lVar2;
                    this.label = 1;
                    z6.c cVar = (z6.c) mutex;
                    if (cVar.d(this) != aVar2) {
                        obj2 = obj3;
                        lVar = lVar2;
                        aVar = cVar;
                    }
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                    return obj;
                }
                lVar = (l) this.L$3;
                obj2 = this.L$2;
                aVar = (a) this.L$1;
                a0Var = (a0) this.L$0;
                q.z0(obj);
                LinkedHashMap<Object, f0> deferreds = CoroutineExtensionsKt.getDeferreds();
                f0 f0VarG = deferreds.get(obj2);
                if (f0VarG == null) {
                    f0VarG = c0.g(a0Var, null, new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(lVar, null), 3);
                    deferreds.put(obj2, f0VarG);
                }
                f0 f0Var = f0VarG;
                ((z6.c) aVar).f(null);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                Object objJ = f0Var.j(this);
                return objJ == aVar2 ? aVar2 : objJ;
            } catch (Throwable th) {
                ((z6.c) aVar).f(null);
                throw th;
            }
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            a0 a0Var = (a0) this.L$0;
            a mutex = CoroutineExtensionsKt.getMutex();
            Object obj2 = this.$key;
            l lVar = this.$action;
            z6.c cVar = (z6.c) mutex;
            cVar.d(this);
            try {
                LinkedHashMap<Object, f0> deferreds = CoroutineExtensionsKt.getDeferreds();
                f0 f0VarG = deferreds.get(obj2);
                if (f0VarG == null) {
                    f0VarG = c0.g(a0Var, null, new CoroutineExtensionsKt$memoize$2$deferred$1$1$1(lVar, null), 3);
                    deferreds.put(obj2, f0VarG);
                }
                f0 f0Var = f0VarG;
                cVar.f(null);
                return f0Var.j(this);
            } catch (Throwable th) {
                cVar.f(null);
                throw th;
            }
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super T> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public static final LinkedHashMap<Object, f0> getDeferreds() {
        return deferreds;
    }

    public static final a getMutex() {
        return mutex;
    }

    public static final <T> Object memoize(Object obj, l lVar, c<? super T> cVar) {
        return c0.j(new AnonymousClass2(obj, lVar, null), cVar);
    }

    public static final <R> Object runReturnSuspendCatching(e6.a block) {
        Object objM;
        Throwable thA;
        k.e(block, "block");
        try {
            objM = block.invoke();
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            objM = q.M(th);
        }
        return ((objM instanceof j) && (thA = q5.k.a(objM)) != null) ? q.M(thA) : objM;
    }

    public static final <R> Object runSuspendCatching(e6.a block) {
        k.e(block, "block");
        try {
            return block.invoke();
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            return q.M(th);
        }
    }
}
