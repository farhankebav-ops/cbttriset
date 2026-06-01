package com.unity3d.ads.core.data.manager;

import android.support.v4.media.g;
import com.unity3d.ads.core.domain.offerwall.OfferwallEventData;
import com.unity3d.services.ads.offerwall.OfferwallAdapterBridge;
import com.unity3d.services.ads.offerwall.OfferwallEvent;
import com.unity3d.services.core.log.DeviceLog;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import r5.j;
import r5.m;
import t6.f;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidOfferwallManager implements OfferwallManager {
    private final OfferwallAdapterBridge offerwallBridge;

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidOfferwallManager", f = "AndroidOfferwallManager.kt", l = {28}, m = "loadAd")
    public static final class AnonymousClass1 extends c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidOfferwallManager.this.loadAd(null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$2", f = "AndroidOfferwallManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ String $placementName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$placementName = str;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidOfferwallManager.this.new AnonymousClass2(this.$placementName, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            AndroidOfferwallManager.this.offerwallBridge.loadAd(this.$placementName);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(f fVar, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(fVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$3", f = "AndroidOfferwallManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ String $placementName;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, v5.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$placementName = str;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$placementName, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // e6.p
        public final Object invoke(OfferwallEventData offerwallEventData, v5.c<? super Boolean> cVar) {
            return ((AnonymousClass3) create(offerwallEventData, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            OfferwallEventData offerwallEventData = (OfferwallEventData) this.L$0;
            boolean z2 = false;
            if (m.H0(OfferwallEvent.REQUEST_SUCCESS, OfferwallEvent.REQUEST_FAILED).contains(offerwallEventData.getOfferwallEvent()) && k.a(offerwallEventData.getPlacementName(), this.$placementName)) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidOfferwallManager$showAd$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidOfferwallManager$showAd$1", f = "AndroidOfferwallManager.kt", l = {}, m = "invokeSuspend")
    public static final class C28821 extends i implements p {
        final /* synthetic */ String $placementName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28821(String str, v5.c<? super C28821> cVar) {
            super(2, cVar);
            this.$placementName = str;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return AndroidOfferwallManager.this.new C28821(this.$placementName, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            AndroidOfferwallManager.this.offerwallBridge.showAd(this.$placementName);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(f fVar, v5.c<? super x> cVar) {
            return ((C28821) create(fVar, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.AndroidOfferwallManager$showAd$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.data.manager.AndroidOfferwallManager$showAd$2", f = "AndroidOfferwallManager.kt", l = {44}, m = "invokeSuspend")
    public static final class C28832 extends i implements e6.q {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C28832(v5.c<? super C28832> cVar) {
            super(3, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            OfferwallEventData offerwallEventData;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                f fVar = (f) this.L$0;
                OfferwallEventData offerwallEventData2 = (OfferwallEventData) this.L$1;
                this.L$0 = offerwallEventData2;
                this.label = 1;
                if (fVar.emit(offerwallEventData2, this) == aVar) {
                    return aVar;
                }
                offerwallEventData = offerwallEventData2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                offerwallEventData = (OfferwallEventData) this.L$0;
                q.z0(obj);
            }
            return Boolean.valueOf(!j.Y(new OfferwallEvent[]{OfferwallEvent.ON_CONTENT_DISMISS, OfferwallEvent.SHOW_FAILED}, offerwallEventData.getOfferwallEvent()));
        }

        @Override // e6.q
        public final Object invoke(f fVar, OfferwallEventData offerwallEventData, v5.c<? super Boolean> cVar) {
            C28832 c28832 = new C28832(cVar);
            c28832.L$0 = fVar;
            c28832.L$1 = offerwallEventData;
            return c28832.invokeSuspend(x.f13520a);
        }
    }

    public AndroidOfferwallManager(OfferwallAdapterBridge offerwallBridge) {
        k.e(offerwallBridge, "offerwallBridge");
        this.offerwallBridge = offerwallBridge;
    }

    @Override // com.unity3d.ads.core.data.manager.OfferwallManager
    public Object getVersion(v5.c<? super String> cVar) {
        return this.offerwallBridge.getVersion();
    }

    @Override // com.unity3d.ads.core.data.manager.OfferwallManager
    public Object isAdReady(String str, v5.c<? super Boolean> cVar) {
        return Boolean.valueOf(this.offerwallBridge.isAdReady(str));
    }

    @Override // com.unity3d.ads.core.data.manager.OfferwallManager
    public Object isConnected(v5.c<? super Boolean> cVar) {
        return Boolean.valueOf(this.offerwallBridge.isConnected());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.data.manager.OfferwallManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadAd(java.lang.String r7, v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.unity3d.ads.core.data.manager.AndroidOfferwallManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$1 r0 = (com.unity3d.ads.core.data.manager.AndroidOfferwallManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$1 r0 = new com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L30
            if (r2 != r3) goto L28
            r2.q.z0(r8)
            goto L62
        L28:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L30:
            r2.q.z0(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r2 = "Offerwall Manager - loadAd: "
            r8.<init>(r2)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r8)
            com.unity3d.services.ads.offerwall.OfferwallAdapterBridge r8 = r6.offerwallBridge
            t6.t0 r8 = r8.getOfferwallEventFlow()
            com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$2 r2 = new com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$2
            r2.<init>(r7, r4)
            android.support.v4.media.g r5 = new android.support.v4.media.g
            r5.<init>(r8, r2)
            com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$3 r8 = new com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$3
            r8.<init>(r7, r4)
            r0.label = r3
            java.lang.Object r8 = t6.x0.k(r5, r8, r0)
            if (r8 != r1) goto L62
            return r1
        L62:
            r7 = r8
            com.unity3d.ads.core.domain.offerwall.OfferwallEventData r7 = (com.unity3d.ads.core.domain.offerwall.OfferwallEventData) r7
            com.unity3d.services.ads.offerwall.OfferwallEvent r7 = r7.getOfferwallEvent()
            com.unity3d.services.ads.offerwall.OfferwallEvent r0 = com.unity3d.services.ads.offerwall.OfferwallEvent.REQUEST_SUCCESS
            if (r7 == r0) goto L6e
            r4 = r8
        L6e:
            com.unity3d.ads.core.domain.offerwall.OfferwallEventData r4 = (com.unity3d.ads.core.domain.offerwall.OfferwallEventData) r4
            if (r4 == 0) goto L91
            com.unity3d.ads.core.data.model.exception.LoadException r7 = new com.unity3d.ads.core.data.model.exception.LoadException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Error loading offerwall ad: "
            r8.<init>(r0)
            java.lang.String r0 = r4.getErrorMessage()
            if (r0 != 0) goto L85
            com.unity3d.services.ads.offerwall.OfferwallEvent r0 = r4.getOfferwallEvent()
        L85:
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r0 = 0
            r7.<init>(r0, r8)
            throw r7
        L91:
            q5.x r7 = q5.x.f13520a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.manager.AndroidOfferwallManager.loadAd(java.lang.String, v5.c):java.lang.Object");
    }

    @Override // com.unity3d.ads.core.data.manager.OfferwallManager
    public t6.e showAd(String placementName) {
        k.e(placementName, "placementName");
        DeviceLog.debug("Offerwall Manager - showAd: ".concat(placementName));
        return new a4.a(new s6.q(new g(this.offerwallBridge.getOfferwallEventFlow(), new C28821(placementName, null)), new C28832(null), (v5.c) null));
    }
}
