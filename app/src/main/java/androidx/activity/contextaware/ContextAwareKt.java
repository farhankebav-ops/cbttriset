package androidx.activity.contextaware;

import a.a;
import android.content.Context;
import e6.l;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareKt {
    public static final <R> Object withContextAvailable(ContextAware contextAware, l lVar, c<R> cVar) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return lVar.invoke(contextPeekAvailableContext);
        }
        q6.l lVar2 = new q6.l(1, a.I(cVar));
        lVar2.r();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(lVar2, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        lVar2.t(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Object objP = lVar2.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }

    private static final <R> Object withContextAvailable$$forInline(ContextAware contextAware, l lVar, c<R> cVar) {
        Context contextPeekAvailableContext = contextAware.peekAvailableContext();
        if (contextPeekAvailableContext != null) {
            return lVar.invoke(contextPeekAvailableContext);
        }
        q6.l lVar2 = new q6.l(1, a.I(cVar));
        lVar2.r();
        ContextAwareKt$withContextAvailable$2$listener$1 contextAwareKt$withContextAvailable$2$listener$1 = new ContextAwareKt$withContextAvailable$2$listener$1(lVar2, lVar);
        contextAware.addOnContextAvailableListener(contextAwareKt$withContextAvailable$2$listener$1);
        lVar2.t(new ContextAwareKt$withContextAvailable$2$1(contextAware, contextAwareKt$withContextAvailable$2$listener$1));
        Object objP = lVar2.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }
}
