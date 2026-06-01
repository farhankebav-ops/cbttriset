package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.AdObject;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import q6.a0;
import q6.c0;
import q6.e1;
import q6.f1;
import q6.u1;
import q6.w;
import q6.y;
import v5.h;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CleanUpWhenOpportunityExpires {
    private final y coroutineExceptionHandler;
    private final a0 coroutineScope;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CleanUpWhenOpportunityExpires$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        final /* synthetic */ f1 $job;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(f1 f1Var) {
            super(1);
            this.$job = f1Var;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return x.f13520a;
        }

        public final void invoke(Throwable th) {
            this.$job.a(null);
        }
    }

    public CleanUpWhenOpportunityExpires(w defaultDispatcher) {
        k.e(defaultDispatcher, "defaultDispatcher");
        CleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1 cleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1 = new CleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1(q6.x.f13600a);
        this.coroutineExceptionHandler = cleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1;
        this.coroutineScope = c0.b(a.a.O(c0.e(), defaultDispatcher).plus(cleanUpWhenOpportunityExpires$special$$inlined$CoroutineExceptionHandler$1));
    }

    public final void invoke(AdObject adObject) {
        k.e(adObject, "adObject");
        if (adObject.getAdPlayer() == null) {
            throw new IllegalArgumentException("AdObject does not have an adPlayer.");
        }
        u1 u1VarU = c0.u(this.coroutineScope, null, new CleanUpWhenOpportunityExpires$invoke$job$1(adObject, null), 3);
        h coroutineContext = adObject.getAdPlayer().getScope().getCoroutineContext();
        f1 f1Var = (f1) coroutineContext.get(e1.f13546a);
        if (f1Var != null) {
            f1Var.n(new AnonymousClass2(u1VarU));
        } else {
            throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
        }
    }
}
