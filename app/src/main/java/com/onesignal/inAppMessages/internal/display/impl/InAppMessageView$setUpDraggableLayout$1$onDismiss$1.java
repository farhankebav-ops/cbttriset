package com.onesignal.inAppMessages.internal.display.impl;

import e6.l;
import q5.x;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$setUpDraggableLayout$1$onDismiss$1", f = "InAppMessageView.kt", l = {351}, m = "invokeSuspend")
public final class InAppMessageView$setUpDraggableLayout$1$onDismiss$1 extends i implements l {
    int label;
    final /* synthetic */ InAppMessageView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageView$setUpDraggableLayout$1$onDismiss$1(InAppMessageView inAppMessageView, c<? super InAppMessageView$setUpDraggableLayout$1$onDismiss$1> cVar) {
        super(1, cVar);
        this.this$0 = inAppMessageView;
    }

    @Override // x5.a
    public final c<x> create(c<?> cVar) {
        return new InAppMessageView$setUpDraggableLayout$1$onDismiss$1(this.this$0, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            InAppMessageView inAppMessageView = this.this$0;
            this.label = 1;
            if (inAppMessageView.finishAfterDelay(this) == aVar) {
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

    @Override // e6.l
    public final Object invoke(c<? super x> cVar) {
        return ((InAppMessageView$setUpDraggableLayout$1$onDismiss$1) create(cVar)).invokeSuspend(x.f13520a);
    }
}
