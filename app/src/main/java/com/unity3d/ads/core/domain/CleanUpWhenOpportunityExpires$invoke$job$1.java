package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.AdObjectState;
import e6.p;
import q5.x;
import q6.a0;
import r2.q;
import t6.d1;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires$invoke$job$1", f = "CleanUpWhenOpportunityExpires.kt", l = {33, 34, 39}, m = "invokeSuspend")
public final class CleanUpWhenOpportunityExpires$invoke$job$1 extends i implements p {
    final /* synthetic */ AdObject $adObject;
    int label;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires$invoke$job$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires$invoke$job$1$1", f = "CleanUpWhenOpportunityExpires.kt", l = {41}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ AdObject $adObject;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AdObject adObject, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$adObject = adObject;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$adObject, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                ((d1) this.$adObject.getState()).h(AdObjectState.EXPIRED);
                AdPlayer adPlayer = this.$adObject.getAdPlayer();
                this.label = 1;
                if (adPlayer.destroy(this) == aVar) {
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
    public CleanUpWhenOpportunityExpires$invoke$job$1(AdObject adObject, c<? super CleanUpWhenOpportunityExpires$invoke$job$1> cVar) {
        super(2, cVar);
        this.$adObject = adObject;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new CleanUpWhenOpportunityExpires$invoke$job$1(this.$adObject, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        if (r8 == r0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            w5.a r0 = w5.a.f17774a
            int r1 = r7.label
            q5.x r2 = q5.x.f13520a
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L25
            if (r1 == r5) goto L21
            if (r1 == r4) goto L1d
            if (r1 != r3) goto L15
            r2.q.z0(r8)
            return r2
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            r2.q.z0(r8)
            goto L66
        L21:
            r2.q.z0(r8)
            goto L51
        L25:
            r2.q.z0(r8)
            com.unity3d.ads.core.data.model.AdObject r8 = r7.$adObject
            t6.q0 r8 = r8.getTtl()
            t6.d1 r8 = (t6.d1) r8
            java.lang.Object r8 = r8.getValue()
            o6.a r8 = (o6.a) r8
            if (r8 == 0) goto L3b
            long r5 = r8.f13208a
            goto L55
        L3b:
            com.unity3d.ads.core.data.model.AdObject r8 = r7.$adObject
            t6.q0 r8 = r8.getTtl()
            a4.a r1 = new a4.a
            r6 = 26
            r1.<init>(r8, r6)
            r7.label = r5
            java.lang.Object r8 = t6.x0.l(r1, r7)
            if (r8 != r0) goto L51
            goto L88
        L51:
            o6.a r8 = (o6.a) r8
            long r5 = r8.f13208a
        L55:
            r7.label = r4
            long r4 = q6.c0.E(r5)
            java.lang.Object r8 = q6.c0.k(r4, r7)
            if (r8 != r0) goto L62
            goto L63
        L62:
            r8 = r2
        L63:
            if (r8 != r0) goto L66
            goto L88
        L66:
            com.unity3d.ads.core.data.model.AdObject r8 = r7.$adObject
            t6.q0 r8 = r8.getState()
            t6.d1 r8 = (t6.d1) r8
            java.lang.Object r8 = r8.getValue()
            com.unity3d.ads.core.data.model.AdObjectState r1 = com.unity3d.ads.core.data.model.AdObjectState.SHOWING
            if (r8 == r1) goto L89
            q6.q1 r8 = q6.q1.f13579a
            com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires$invoke$job$1$1 r1 = new com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires$invoke$job$1$1
            com.unity3d.ads.core.data.model.AdObject r4 = r7.$adObject
            r5 = 0
            r1.<init>(r4, r5)
            r7.label = r3
            java.lang.Object r8 = q6.c0.H(r1, r8, r7)
            if (r8 != r0) goto L89
        L88:
            return r0
        L89:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires$invoke$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super x> cVar) {
        return ((CleanUpWhenOpportunityExpires$invoke$job$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
