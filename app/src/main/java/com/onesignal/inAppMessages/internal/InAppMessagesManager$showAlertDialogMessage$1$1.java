package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import e6.l;
import java.util.List;
import q5.x;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$showAlertDialogMessage$1$1", f = "InAppMessagesManager.kt", l = {954}, m = "invokeSuspend")
public final class InAppMessagesManager$showAlertDialogMessage$1$1 extends i implements l {
    final /* synthetic */ InAppMessage $inAppMessage;
    final /* synthetic */ List<InAppMessagePrompt> $prompts;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InAppMessagesManager$showAlertDialogMessage$1$1(InAppMessagesManager inAppMessagesManager, InAppMessage inAppMessage, List<? extends InAppMessagePrompt> list, c<? super InAppMessagesManager$showAlertDialogMessage$1$1> cVar) {
        super(1, cVar);
        this.this$0 = inAppMessagesManager;
        this.$inAppMessage = inAppMessage;
        this.$prompts = list;
    }

    @Override // x5.a
    public final c<x> create(c<?> cVar) {
        return new InAppMessagesManager$showAlertDialogMessage$1$1(this.this$0, this.$inAppMessage, this.$prompts, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            InAppMessagesManager inAppMessagesManager = this.this$0;
            InAppMessage inAppMessage = this.$inAppMessage;
            List<InAppMessagePrompt> list = this.$prompts;
            this.label = 1;
            if (inAppMessagesManager.showMultiplePrompts(inAppMessage, list, this) == aVar) {
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
        return ((InAppMessagesManager$showAlertDialogMessage$1$1) create(cVar)).invokeSuspend(x.f13520a);
    }
}
