package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.ie, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractRunnableC2382ie implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8732a = new a(null);

    /* JADX INFO: renamed from: com.ironsource.ie$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: com.ironsource.ie$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0185a extends AbstractRunnableC2382ie {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ e6.a f8733b;

            public C0185a(e6.a aVar) {
                this.f8733b = aVar;
            }

            @Override // com.ironsource.AbstractRunnableC2382ie
            public void a() {
                this.f8733b.invoke();
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final AbstractRunnableC2382ie a(e6.a block) {
            kotlin.jvm.internal.k.e(block, "block");
            return new C0185a(block);
        }

        private a() {
        }
    }

    public abstract void a() throws Exception;

    public void a(Throwable t3) {
        kotlin.jvm.internal.k.e(t3, "t");
        C2627wf.a(t3);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            C2531r4.d().a(th);
            try {
                a(th);
            } catch (Throwable th2) {
                C2531r4.d().a(th2);
            }
        }
    }
}
