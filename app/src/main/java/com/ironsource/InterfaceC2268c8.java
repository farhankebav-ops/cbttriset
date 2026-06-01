package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.c8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface InterfaceC2268c8<T> {

    /* JADX INFO: renamed from: com.ironsource.c8$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a<ListenerType> implements InterfaceC2268c8<ListenerType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ListenerType f8122a;

        /* JADX INFO: renamed from: com.ironsource.c8$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class C0181a extends AbstractRunnableC2382ie {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Runnable f8123b;

            public C0181a(Runnable runnable) {
                this.f8123b = runnable;
            }

            @Override // com.ironsource.AbstractRunnableC2382ie
            public void a() {
                this.f8123b.run();
            }
        }

        public final ListenerType a() {
            return this.f8122a;
        }

        public final void b(ListenerType listenertype) {
            this.f8122a = listenertype;
        }

        public static /* synthetic */ void a(a aVar, Runnable runnable, boolean z2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeOnUIThreadIfConditionMet");
            }
            if ((i2 & 2) != 0) {
                z2 = true;
            }
            aVar.a(runnable, z2);
        }

        public final void a(Runnable runnable, boolean z2) {
            kotlin.jvm.internal.k.e(runnable, "runnable");
            if (z2) {
                IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new C0181a(runnable), 0L, 2, null);
            }
        }

        public final void a(String instanceId, String message) {
            kotlin.jvm.internal.k.e(instanceId, "instanceId");
            kotlin.jvm.internal.k.e(message, "message");
            IronLog.CALLBACK.info(message + " instanceId=" + instanceId);
        }

        @Override // com.ironsource.InterfaceC2268c8
        public void a(ListenerType listenertype) {
            this.f8122a = listenertype;
        }
    }

    void a(T t3);
}
