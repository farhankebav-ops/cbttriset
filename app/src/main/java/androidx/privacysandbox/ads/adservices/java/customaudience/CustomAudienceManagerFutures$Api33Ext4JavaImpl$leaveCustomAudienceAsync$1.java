package androidx.privacysandbox.ads.adservices.java.customaudience;

import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.LeaveCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1", f = "CustomAudienceManagerFutures.kt", l = {166}, m = "invokeSuspend")
public final class CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1 extends i implements p {
    final /* synthetic */ LeaveCustomAudienceRequest $request;
    int label;
    final /* synthetic */ CustomAudienceManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(CustomAudienceManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, LeaveCustomAudienceRequest leaveCustomAudienceRequest, c<? super CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1> cVar) {
        super(2, cVar);
        this.this$0 = api33Ext4JavaImpl;
        this.$request = leaveCustomAudienceRequest;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1(this.this$0, this.$request, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            CustomAudienceManager customAudienceManager = this.this$0.mCustomAudienceManager;
            k.b(customAudienceManager);
            LeaveCustomAudienceRequest leaveCustomAudienceRequest = this.$request;
            this.label = 1;
            if (customAudienceManager.leaveCustomAudience(leaveCustomAudienceRequest, this) == aVar) {
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
        return ((CustomAudienceManagerFutures$Api33Ext4JavaImpl$leaveCustomAudienceAsync$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
