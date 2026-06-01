package com.unity3d.ads.core.domain.scar;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import e6.p;
import kotlin.jvm.internal.k;
import n7.b;
import q5.x;
import q6.a0;
import q6.c0;
import r5.l;
import s6.a;
import t6.p0;
import t6.r0;
import t6.t0;
import t6.w0;
import t6.x0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonScarEventReceiver implements IEventSender {
    private final p0 _gmaEventFlow;
    private final p0 _versionFlow;
    private final t0 gmaEventFlow;
    private final a0 scope;
    private final t0 versionFlow;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.scar.CommonScarEventReceiver$sendEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.scar.CommonScarEventReceiver$sendEvent$1", f = "CommonScarEventReceiver.kt", l = {35, 41, 52, ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 73}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ Enum<?> $eventId;
        final /* synthetic */ Object[] $params;
        int label;
        final /* synthetic */ CommonScarEventReceiver this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Enum<?> r1, Object[] objArr, CommonScarEventReceiver commonScarEventReceiver, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$eventId = r1;
            this.$params = objArr;
            this.this$0 = commonScarEventReceiver;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$eventId, this.$params, this.this$0, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        
            if (r3.emit(r2, r21) == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        
            if (r3.emit(r7, r21) == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
        
            if (r3.emit(r6, r21) == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0122, code lost:
        
            if (r2.emit(r11, r21) == r1) goto L42;
         */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f5  */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.scar.CommonScarEventReceiver.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public CommonScarEventReceiver(a0 scope) {
        k.e(scope, "scope");
        this.scope = scope;
        w0 w0VarA = x0.a((7 & 1) != 0 ? 0 : 100, (7 & 2) == 0 ? 64 : 0, a.f13718a);
        this._versionFlow = w0VarA;
        this.versionFlow = new r0(w0VarA);
        w0 w0VarA2 = x0.a((7 & 1) != 0 ? 0 : 100, (7 & 2) == 0 ? 64 : 0, a.f13718a);
        this._gmaEventFlow = w0VarA2;
        this.gmaEventFlow = new r0(w0VarA2);
    }

    @Override // com.unity3d.services.core.webview.bridge.IEventSender
    public boolean canSend() {
        return true;
    }

    public final t0 getGmaEventFlow() {
        return this.gmaEventFlow;
    }

    public final t0 getVersionFlow() {
        return this.versionFlow;
    }

    @Override // com.unity3d.services.core.webview.bridge.IEventSender
    public boolean sendEvent(Enum<?> eventCategory, Enum<?> eventId, Object... params) {
        k.e(eventCategory, "eventCategory");
        k.e(eventId, "eventId");
        k.e(params, "params");
        if (!l.T0(b.O(WebViewEventCategory.INIT_GMA, WebViewEventCategory.GMA, WebViewEventCategory.BANNER), eventCategory)) {
            return false;
        }
        c0.u(this.scope, null, new AnonymousClass1(eventId, params, this, null), 3);
        return true;
    }
}
