package okhttp3.internal;

import androidx.core.location.LocationRequestCompat;
import com.ironsource.C2300e4;
import j7.a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import k6.d;
import kotlin.jvm.internal.k;
import l7.j;
import l7.l;
import l7.o0;
import n6.m;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Header;
import r2.q;
import r5.n;
import r5.r;
import r5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class _UtilJvmKt {
    public static final TimeZone UTC;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        k.b(timeZone);
        UTC = timeZone;
        assertionsEnabled = false;
        okHttpName = m.G0(m.F0(OkHttpClient.class.getName(), "okhttp3."), "Client");
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        k.e(eventListener, "<this>");
        return new a(eventListener, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener asFactory$lambda$9(EventListener eventListener, Call it) {
        k.e(it, "it");
        return eventListener;
    }

    public static final void assertLockNotHeld(Dispatcher dispatcher) {
        k.e(dispatcher, "<this>");
        if (assertionsEnabled && Thread.holdsLock(dispatcher)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
        }
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl other) {
        k.e(httpUrl, "<this>");
        k.e(other, "other");
        return k.a(httpUrl.host(), other.host()) && httpUrl.port() == other.port() && k.a(httpUrl.scheme(), other.scheme());
    }

    public static final int checkDuration(String name, long j, TimeUnit unit) {
        k.e(name, "name");
        k.e(unit, "unit");
        if (j < 0) {
            throw new IllegalStateException(name.concat(" < 0").toString());
        }
        long millis = unit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(name.concat(" too large").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(name.concat(" too small").toString());
    }

    /* JADX INFO: renamed from: checkDuration-HG0u8IE, reason: not valid java name */
    public static final int m3600checkDurationHG0u8IE(String name, long j) {
        k.e(name, "name");
        int i2 = o6.a.f13207d;
        if (j < 0) {
            throw new IllegalStateException(name.concat(" < 0").toString());
        }
        long jD = o6.a.d(j);
        if (jD > 2147483647L) {
            throw new IllegalArgumentException(name.concat(" too large").toString());
        }
        if (jD != 0 || j <= 0) {
            return (int) jD;
        }
        throw new IllegalArgumentException(name.concat(" too small").toString());
    }

    public static final void closeQuietly(Socket socket) {
        k.e(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e4) {
            if (!k.a(e4.getMessage(), "bio == null")) {
                throw e4;
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean discard(o0 o0Var, int i2, TimeUnit timeUnit) {
        k.e(o0Var, "<this>");
        k.e(timeUnit, "timeUnit");
        try {
            return skipAll(o0Var, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String format(String format, Object... args) {
        k.e(format, "format");
        k.e(args, "args");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        return String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    public static final long headersContentLength(Response response) {
        k.e(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return _UtilCommonKt.toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        k.e(elements, "elements");
        return toImmutableList(elements);
    }

    public static final boolean isHealthy(Socket socket, l source) {
        k.e(socket, "<this>");
        k.e(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !source.M();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final String peerName(Socket socket) {
        k.e(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        k.d(hostName, "getHostName(...)");
        return hostName;
    }

    public static final Charset readBomAsCharset(l lVar, Charset charset) throws IOException {
        k.e(lVar, "<this>");
        k.e(charset, "default");
        int iF = lVar.f(_UtilCommonKt.getUNICODE_BOMS());
        if (iF == -1) {
            return charset;
        }
        if (iF == 0) {
            return n6.a.f13073a;
        }
        if (iF == 1) {
            return n6.a.f13074b;
        }
        if (iF == 2) {
            Charset charset2 = n6.a.f13073a;
            Charset charset3 = n6.a.e;
            if (charset3 != null) {
                return charset3;
            }
            Charset charsetForName = Charset.forName("UTF-32LE");
            k.d(charsetForName, "forName(...)");
            n6.a.e = charsetForName;
            return charsetForName;
        }
        if (iF == 3) {
            return n6.a.f13075c;
        }
        if (iF != 4) {
            throw new AssertionError();
        }
        Charset charset4 = n6.a.f13073a;
        Charset charset5 = n6.a.f13077f;
        if (charset5 != null) {
            return charset5;
        }
        Charset charsetForName2 = Charset.forName("UTF-32BE");
        k.d(charsetForName2, "forName(...)");
        n6.a.f13077f = charsetForName2;
        return charsetForName2;
    }

    public static final <T> T readFieldOrNull(Object instance, Class<T> fieldType, String fieldName) {
        T tCast;
        Object fieldOrNull;
        k.e(instance, "instance");
        k.e(fieldType, "fieldType");
        k.e(fieldName, "fieldName");
        Class<?> superclass = instance.getClass();
        while (true) {
            tCast = null;
            if (superclass.equals(Object.class)) {
                if (fieldName.equals("delegate") || (fieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, fieldType, fieldName);
            }
            try {
                Field declaredField = superclass.getDeclaredField(fieldName);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(instance);
                if (!fieldType.isInstance(obj)) {
                    break;
                }
                tCast = fieldType.cast(obj);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                k.d(superclass, "getSuperclass(...)");
            }
        }
        return tCast;
    }

    public static final boolean skipAll(o0 o0Var, int i2, TimeUnit timeUnit) throws IOException {
        k.e(o0Var, "<this>");
        k.e(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = o0Var.timeout().hasDeadline() ? o0Var.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        o0Var.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            j jVar = new j();
            while (o0Var.read(jVar, 8192L) != -1) {
                jVar.a();
            }
            if (jDeadlineNanoTime == LocationRequestCompat.PASSIVE_INTERVAL) {
                o0Var.timeout().clearDeadline();
                return true;
            }
            o0Var.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == LocationRequestCompat.PASSIVE_INTERVAL) {
                o0Var.timeout().clearDeadline();
                return false;
            }
            o0Var.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (jDeadlineNanoTime == LocationRequestCompat.PASSIVE_INTERVAL) {
                o0Var.timeout().clearDeadline();
            } else {
                o0Var.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(final String name, final boolean z2) {
        k.e(name, "name");
        return new ThreadFactory() { // from class: j7.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return _UtilJvmKt.threadFactory$lambda$1(name, z2, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadFactory$lambda$1(String str, boolean z2, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z2);
        return thread;
    }

    public static final void threadName(String name, e6.a block) {
        k.e(name, "name");
        k.e(block, "block");
        Thread threadCurrentThread = Thread.currentThread();
        String name2 = threadCurrentThread.getName();
        threadCurrentThread.setName(name);
        try {
            block.invoke();
        } finally {
            threadCurrentThread.setName(name2);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        k.e(headers, "<this>");
        d dVarD0 = q.D0(0, headers.size());
        ArrayList arrayList = new ArrayList(n.L0(dVarD0, 10));
        Iterator it = dVarD0.iterator();
        while (it.hasNext()) {
            int iNextInt = ((v) it).nextInt();
            arrayList.add(new Header(headers.name(iNextInt), headers.value(iNextInt)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        k.e(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().t(), header.component2().t());
        }
        return builder.build();
    }

    public static final String toHexString(long j) {
        String hexString = Long.toHexString(j);
        k.d(hexString, "toHexString(...)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z2) {
        String strHost;
        k.e(httpUrl, "<this>");
        if (m.q0(httpUrl.host(), ":", false)) {
            strHost = C2300e4.i.f8403d + httpUrl.host() + ']';
        } else {
            strHost = httpUrl.host();
        }
        if (!z2 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return strHost;
        }
        return strHost + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return toHostHeader(httpUrl, z2);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        k.e(list, "<this>");
        if (list.isEmpty()) {
            return r.f13638a;
        }
        if (list.size() == 1) {
            List<T> listSingletonList = Collections.singletonList(list.get(0));
            k.d(listSingletonList, "singletonList(...)");
            return listSingletonList;
        }
        Object[] array = list.toArray();
        k.d(array, "toArray(...)");
        List<T> listUnmodifiableList = Collections.unmodifiableList(r5.j.X(array));
        k.d(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public static final <T> List<T> unmodifiable(List<? extends T> list) {
        k.e(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(list);
        k.d(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public static final String toHexString(int i2) {
        String hexString = Integer.toHexString(i2);
        k.d(hexString, "toHexString(...)");
        return hexString;
    }

    public static final <T> Set<T> unmodifiable(Set<? extends T> set) {
        k.e(set, "<this>");
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(set);
        k.d(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public static final <K, V> Map<K, V> unmodifiable(Map<K, ? extends V> map) {
        k.e(map, "<this>");
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        k.d(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        k.e(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final <T> List<T> toImmutableList(T[] tArr) {
        if (tArr != null && tArr.length != 0) {
            if (tArr.length == 1) {
                List<T> listSingletonList = Collections.singletonList(tArr[0]);
                k.d(listSingletonList, "singletonList(...)");
                return listSingletonList;
            }
            List<T> listUnmodifiableList = Collections.unmodifiableList(r5.j.X((Object[]) tArr.clone()));
            k.d(listUnmodifiableList, "unmodifiableList(...)");
            return listUnmodifiableList;
        }
        return r.f13638a;
    }

    public static final void skipAll(l lVar) throws IOException {
        k.e(lVar, "<this>");
        while (!lVar.M()) {
            lVar.skip(lVar.getBuffer().f12868b);
        }
    }
}
