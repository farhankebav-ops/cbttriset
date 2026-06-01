package com.onesignal.common.threading;

import com.onesignal.debug.internal.logging.Logging;
import e6.l;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;
import v5.c;
import v6.n;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ThreadUtilsKt {

    /* JADX INFO: renamed from: com.onesignal.common.threading.ThreadUtilsKt$suspendifyBlocking$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.threading.ThreadUtilsKt$suspendifyBlocking$1", f = "ThreadUtils.kt", l = {33}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ l $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(l lVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$block = lVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$block, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                l lVar = this.$block;
                this.label = 1;
                if (lVar.invoke(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnMain$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26841 extends kotlin.jvm.internal.l implements e6.a {
        final /* synthetic */ l $block;

        /* JADX INFO: renamed from: com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnMain$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnMain$1$1", f = "ThreadUtils.kt", l = {47}, m = "invokeSuspend")
        public static final class C02071 extends i implements p {
            final /* synthetic */ l $block;
            int label;

            /* JADX INFO: renamed from: com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnMain$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            @e(c = "com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnMain$1$1$1", f = "ThreadUtils.kt", l = {48}, m = "invokeSuspend")
            public static final class C02081 extends i implements p {
                final /* synthetic */ l $block;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02081(l lVar, c<? super C02081> cVar) {
                    super(2, cVar);
                    this.$block = lVar;
                }

                @Override // x5.a
                public final c<x> create(Object obj, c<?> cVar) {
                    return new C02081(this.$block, cVar);
                }

                @Override // x5.a
                public final Object invokeSuspend(Object obj) throws Throwable {
                    a aVar = a.f17774a;
                    int i2 = this.label;
                    if (i2 == 0) {
                        q.z0(obj);
                        l lVar = this.$block;
                        this.label = 1;
                        if (lVar.invoke(this) == aVar) {
                            return aVar;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        q.z0(obj);
                    }
                    return x.f13520a;
                }

                @Override // e6.p
                public final Object invoke(a0 a0Var, c<? super x> cVar) {
                    return ((C02081) create(a0Var, cVar)).invokeSuspend(x.f13520a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02071(l lVar, c<? super C02071> cVar) {
                super(2, cVar);
                this.$block = lVar;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                return new C02071(this.$block, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    x6.e eVar = m0.f13566a;
                    r6.c cVar = n.f17641a;
                    C02081 c02081 = new C02081(this.$block, null);
                    this.label = 1;
                    if (c0.H(c02081, cVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                }
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, c<? super x> cVar) {
                return ((C02071) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26841(l lVar) {
            super(0);
            this.$block = lVar;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() throws Throwable {
            m3134invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3134invoke() throws Throwable {
            try {
                c0.A(v5.i.f17610a, new C02071(this.$block, null));
            } catch (Exception e) {
                Logging.error("Exception on thread with switch to main", e);
            }
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnThread$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26851 extends kotlin.jvm.internal.l implements e6.a {
        final /* synthetic */ l $block;
        final /* synthetic */ e6.a $onComplete;

        /* JADX INFO: renamed from: com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnThread$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnThread$1$1", f = "ThreadUtils.kt", l = {93}, m = "invokeSuspend")
        public static final class C02091 extends i implements p {
            final /* synthetic */ l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02091(l lVar, c<? super C02091> cVar) {
                super(2, cVar);
                this.$block = lVar;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                return new C02091(this.$block, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    l lVar = this.$block;
                    this.label = 1;
                    if (lVar.invoke(this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                }
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, c<? super x> cVar) {
                return ((C02091) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26851(e6.a aVar, l lVar) {
            super(0);
            this.$onComplete = aVar;
            this.$block = lVar;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() throws Throwable {
            m3135invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3135invoke() throws Throwable {
            try {
                c0.A(v5.i.f17610a, new C02091(this.$block, null));
                e6.a aVar = this.$onComplete;
                if (aVar != null) {
                    aVar.invoke();
                }
            } catch (Exception e) {
                Logging.error("Exception on thread", e);
            }
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnThread$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends kotlin.jvm.internal.l implements e6.a {
        final /* synthetic */ l $block;
        final /* synthetic */ String $name;

        /* JADX INFO: renamed from: com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnThread$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.onesignal.common.threading.ThreadUtilsKt$suspendifyOnThread$2$1", f = "ThreadUtils.kt", l = {115}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends i implements p {
            final /* synthetic */ l $block;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(l lVar, c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$block = lVar;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                return new AnonymousClass1(this.$block, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    l lVar = this.$block;
                    this.label = 1;
                    if (lVar.invoke(this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                }
                return x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, c<? super x> cVar) {
                return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, l lVar) {
            super(0);
            this.$name = str;
            this.$block = lVar;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() throws Throwable {
            m3136invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3136invoke() throws Throwable {
            try {
                c0.A(v5.i.f17610a, new AnonymousClass1(this.$block, null));
            } catch (Exception e) {
                Logging.error("Exception on thread '" + this.$name + '\'', e);
            }
        }
    }

    public static final void suspendifyBlocking(l block) throws Throwable {
        k.e(block, "block");
        c0.A(v5.i.f17610a, new AnonymousClass1(block, null));
    }

    public static final void suspendifyOnMain(l block) {
        k.e(block, "block");
        q.x0(null, 0, new C26841(block), 31);
    }

    public static final void suspendifyOnThread(int i2, l block) {
        k.e(block, "block");
        suspendifyOnThread(i2, block, (e6.a) null);
    }

    public static /* synthetic */ void suspendifyOnThread$default(int i2, l lVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = -1;
        }
        suspendifyOnThread(i2, lVar);
    }

    public static final void suspendifyOnThread(int i2, l block, e6.a aVar) {
        k.e(block, "block");
        q.x0(null, i2, new C26851(aVar, block), 15);
    }

    public static /* synthetic */ void suspendifyOnThread$default(int i2, l lVar, e6.a aVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = -1;
        }
        if ((i8 & 4) != 0) {
            aVar = null;
        }
        suspendifyOnThread(i2, lVar, aVar);
    }

    public static final void suspendifyOnThread(String name, int i2, l block) {
        k.e(name, "name");
        k.e(block, "block");
        q.x0(name, i2, new AnonymousClass2(name, block), 7);
    }

    public static /* synthetic */ void suspendifyOnThread$default(String str, int i2, l lVar, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i2 = -1;
        }
        suspendifyOnThread(str, i2, lVar);
    }
}
