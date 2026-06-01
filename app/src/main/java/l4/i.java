package l4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends k {
    public final Method e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Method f12800f;
    public final Method g;
    public final Class h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Class f12801i;

    public i(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
        super(provider);
        this.e = method;
        this.f12800f = method2;
        this.g = method3;
        this.h = cls;
        this.f12801i = cls2;
    }

    @Override // l4.k
    public final void a(SSLSocket sSLSocket) {
        try {
            this.g.invoke(null, sSLSocket);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InvocationTargetException e) {
            k.f12805b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e);
        }
    }

    @Override // l4.k
    public final void c(SSLSocket sSLSocket, String str, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) list.get(i2);
            if (lVar != l.HTTP_1_0) {
                arrayList.add(lVar.f12813a);
            }
        }
        try {
            this.e.invoke(null, sSLSocket, Proxy.newProxyInstance(k.class.getClassLoader(), new Class[]{this.h, this.f12801i}, new j(arrayList)));
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e4) {
            throw new AssertionError(e4);
        }
    }

    @Override // l4.k
    public final String d(SSLSocket sSLSocket) {
        try {
            j jVar = (j) Proxy.getInvocationHandler(this.f12800f.invoke(null, sSLSocket));
            boolean z2 = jVar.f12803b;
            if (!z2 && jVar.f12804c == null) {
                k.f12805b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            }
            if (z2) {
                return null;
            }
            return jVar.f12804c;
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InvocationTargetException unused2) {
            throw new AssertionError();
        }
    }

    @Override // l4.k
    public final int e() {
        return 1;
    }
}
