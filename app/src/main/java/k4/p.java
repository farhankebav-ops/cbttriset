package k4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e2.h f12678d;
    public static final e2.h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e2.h f12679f;
    public static final e2.h g;
    public static final e2.h h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e2.h f12680i;
    public static final Method j;
    public static final Method k;
    public static final Method l;
    public static final Method m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Method f12681n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Method f12682o;
    public static final Constructor p;

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|67|3|69|4|73|5|(3:61|6|7)|(5:59|8|9|71|10)|43|65|44|63|45|57|58|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fe, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0100, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0101, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0103, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0104, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0106, code lost:
    
        r4.log(java.util.logging.Level.FINER, "Failed to find Android 7.0+ APIs", (java.lang.Throwable) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010c, code lost:
    
        r4.log(java.util.logging.Level.FINER, "Failed to find Android 7.0+ APIs", (java.lang.Throwable) r0);
     */
    static {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.p.<clinit>():void");
    }

    @Override // k4.q
    public final void a(SSLSocket sSLSocket, String str, List list) {
        Constructor constructor;
        boolean z2;
        Method method;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((l4.l) it.next()).f12813a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (str != null) {
            try {
                try {
                    if (q.c(str)) {
                        Method method2 = j;
                        if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                            f12678d.j(sSLSocket, Boolean.TRUE);
                        } else {
                            k.invoke(null, sSLSocket, Boolean.TRUE);
                        }
                        Method method3 = f12682o;
                        if (method3 == null || (constructor = p) == null) {
                            e.j(sSLSocket, str);
                        } else {
                            method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                        }
                    }
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException(e4);
                } catch (InstantiationException e8) {
                    throw new RuntimeException(e8);
                }
            } catch (InvocationTargetException e9) {
                throw new RuntimeException(e9);
            }
        }
        Method method4 = f12681n;
        if (method4 != null) {
            try {
                method4.invoke(sSLSocket, null);
                l.invoke(sSLParameters, strArr);
                z2 = true;
            } catch (InvocationTargetException e10) {
                if (!(e10.getTargetException() instanceof UnsupportedOperationException)) {
                    throw e10;
                }
                q.f12683b.log(Level.FINER, "setApplicationProtocol unsupported, will try old methods");
                z2 = false;
            }
        } else {
            z2 = false;
        }
        sSLSocket.setSSLParameters(sSLParameters);
        if (z2 && (method = m) != null && Arrays.equals(strArr, (String[]) method.invoke(sSLSocket.getSSLParameters(), null))) {
            return;
        }
        Object[] objArr = {l4.k.b(list)};
        l4.k kVar = this.f12685a;
        if (kVar.e() == 1) {
            g.k(sSLSocket, objArr);
        }
        if (kVar.e() == 3) {
            throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
        }
        f12680i.k(sSLSocket, objArr);
    }

    @Override // k4.q
    public final String b(SSLSocket sSLSocket) {
        Logger logger = q.f12683b;
        Method method = f12681n;
        if (method != null) {
            try {
                return (String) method.invoke(sSLSocket, null);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            } catch (InvocationTargetException e8) {
                if (!(e8.getTargetException() instanceof UnsupportedOperationException)) {
                    throw new RuntimeException(e8);
                }
                logger.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
            }
        }
        l4.k kVar = this.f12685a;
        if (kVar.e() == 1) {
            try {
                byte[] bArr = (byte[]) f12679f.k(sSLSocket, new Object[0]);
                if (bArr != null) {
                    return new String(bArr, l4.n.f12820b);
                }
            } catch (Exception e9) {
                logger.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e9);
            }
        }
        if (kVar.e() != 3) {
            try {
                byte[] bArr2 = (byte[]) h.k(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, l4.n.f12820b);
                }
            } catch (Exception e10) {
                logger.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e10);
            }
        }
        return null;
    }

    @Override // k4.q
    public final String d(SSLSocket sSLSocket, String str, List list) {
        String strB = b(sSLSocket);
        return strB == null ? super.d(sSLSocket, str, list) : strB;
    }
}
