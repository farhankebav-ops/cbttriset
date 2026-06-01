package x5;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements v5.c, d, Serializable {
    private final v5.c<Object> completion;

    public a(v5.c cVar) {
        this.completion = cVar;
    }

    public v5.c<x> create(v5.c<?> completion) {
        k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d getCallerFrame() {
        v5.c<Object> cVar = this.completion;
        if (cVar instanceof d) {
            return (d) cVar;
        }
        return null;
    }

    public final v5.c<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str = null;
        if (eVar == null) {
            return null;
        }
        int iV = eVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i2 = iIntValue >= 0 ? eVar.l()[iIntValue] : -1;
        e2.h hVar = f.f17792b;
        e2.h hVar2 = f.f17791a;
        if (hVar == null) {
            try {
                e2.h hVar3 = new e2.h(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                f.f17792b = hVar3;
                hVar = hVar3;
            } catch (Exception unused2) {
                f.f17792b = hVar2;
                hVar = hVar2;
            }
        }
        if (hVar != hVar2 && (method = (Method) hVar.f11231a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = (Method) hVar.f11232b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = (Method) hVar.f11233c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = eVar.c();
        } else {
            strC = str + '/' + eVar.c();
        }
        return new StackTraceElement(strC, eVar.m(), eVar.f(), i2);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // v5.c
    public final void resumeWith(Object obj) {
        v5.c<Object> cVar = this;
        while (true) {
            a aVar = (a) cVar;
            v5.c<Object> cVar2 = aVar.completion;
            k.b(cVar2);
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == w5.a.f17774a) {
                    return;
                }
            } catch (Throwable th) {
                obj = q.M(th);
            }
            aVar.releaseIntercepted();
            if (!(cVar2 instanceof a)) {
                cVar2.resumeWith(obj);
                return;
            }
            cVar = cVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public v5.c<x> create(Object obj, v5.c<?> completion) {
        k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
