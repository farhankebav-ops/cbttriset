package com.onesignal.inAppMessages.internal.display.impl;

import e6.l;
import q5.x;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1", f = "WebViewManager.kt", l = {238}, m = "invokeSuspend")
public final class WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1 extends i implements l {
    final /* synthetic */ int $pagePxHeight;
    int label;
    final /* synthetic */ WebViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1(WebViewManager webViewManager, int i2, c<? super WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1> cVar) {
        super(1, cVar);
        this.this$0 = webViewManager;
        this.$pagePxHeight = i2;
    }

    @Override // x5.a
    public final c<x> create(c<?> cVar) {
        return new WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1(this.this$0, this.$pagePxHeight, cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        w5.a aVar = w5.a.f17774a;
        int i2 = this.label;
        if (i2 == 0) {
            q.z0(obj);
            WebViewManager webViewManager = this.this$0;
            Integer num = new Integer(this.$pagePxHeight);
            this.label = 1;
            if (webViewManager.showMessageView(num, this) == aVar) {
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
        return ((WebViewManager$calculateHeightAndShowWebViewAfterNewActivity$2$1) create(cVar)).invokeSuspend(x.f13520a);
    }
}
