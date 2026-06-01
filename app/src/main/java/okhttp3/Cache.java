package okhttp3;

import androidx.core.location.LocationRequestCompat;
import androidx.webkit.ProxyConfig;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.g0;
import l7.i;
import l7.i0;
import l7.j;
import l7.j0;
import l7.l;
import l7.n0;
import l7.o0;
import l7.v;
import l7.w;
import n6.m;
import n6.t;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import r2.q;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CacheResponseBody extends ResponseBody {
        private final l bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            k.e(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = l7.b.c(new w(snapshot.getSource(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // l7.w, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return _UtilCommonKt.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public l source() {
            return this.bodySource;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i2 = 0; i2 < size; i2++) {
                if ("Vary".equalsIgnoreCase(headers.name(i2))) {
                    String strValue = headers.value(i2);
                    if (treeSet == null) {
                        t.h0();
                        treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                    }
                    Iterator it = m.J0(strValue, new char[]{','}).iterator();
                    while (it.hasNext()) {
                        treeSet.add(m.T0((String) it.next()).toString());
                    }
                }
            }
            return treeSet == null ? r5.t.f13640a : treeSet;
        }

        public final boolean hasVaryAll(Response response) {
            k.e(response, "<this>");
            return varyFields(response.headers()).contains(ProxyConfig.MATCH_ALL_SCHEMES);
        }

        public final String key(HttpUrl url) {
            k.e(url, "url");
            l7.m mVar = l7.m.f12880d;
            return r4.c.e(url.toString()).c("MD5").e();
        }

        public final int readInt$okhttp(l source) throws IOException {
            k.e(source, "source");
            try {
                long jO = source.O();
                String strD = source.D();
                if (jO >= 0 && jO <= 2147483647L && strD.length() <= 0) {
                    return (int) jO;
                }
                throw new IOException("expected an int but was \"" + jO + strD + '\"');
            } catch (NumberFormatException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            k.e(response, "<this>");
            Response responseNetworkResponse = response.networkResponse();
            k.b(responseNetworkResponse);
            return varyHeaders(responseNetworkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(Response cachedResponse, Headers cachedRequest, Request newRequest) {
            k.e(cachedResponse, "cachedResponse");
            k.e(cachedRequest, "cachedRequest");
            k.e(newRequest, "newRequest");
            Set<String> setVaryFields = varyFields(cachedResponse.headers());
            if (setVaryFields != null && setVaryFields.isEmpty()) {
                return true;
            }
            for (String str : setVaryFields) {
                if (!k.a(cachedRequest.values(str), newRequest.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        private Companion() {
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> setVaryFields = varyFields(headers2);
            if (setVaryFields.isEmpty()) {
                return Headers.EMPTY;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                String strName = headers.name(i2);
                if (setVaryFields.contains(strName)) {
                    builder.add(strName, headers.value(i2));
                }
            }
            return builder.build();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class RealCacheRequest implements CacheRequest {
        private final n0 body;
        private final n0 cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(final Cache cache, DiskLruCache.Editor editor) {
            k.e(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            n0 n0VarNewSink = editor.newSink(1);
            this.cacheOut = n0VarNewSink;
            this.body = new v(n0VarNewSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // l7.v, l7.n0, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Cache cache2 = cache;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache2) {
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (this.done) {
                    return;
                }
                this.done = true;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                _UtilCommonKt.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public n0 body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z2) {
            this.done = z2;
        }
    }

    /* JADX INFO: renamed from: okhttp3.Cache$urls$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 implements Iterator<String>, f6.a {
        private boolean canRemove;
        private final Iterator<DiskLruCache.Snapshot> delegate;
        private String nextUrl;

        public AnonymousClass1(Cache cache) {
            this.delegate = cache.getCache$okhttp().snapshots();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextUrl != null) {
                return true;
            }
            this.canRemove = false;
            while (this.delegate.hasNext()) {
                try {
                    DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        continue;
                        this.nextUrl = l7.b.c(next.getSource(0)).h(LocationRequestCompat.PASSIVE_INTERVAL);
                        q.I(next, null);
                        return true;
                    } finally {
                        try {
                            continue;
                        } catch (Throwable th) {
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() before next()");
            }
            this.delegate.remove();
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextUrl;
            k.b(str);
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }
    }

    public Cache(g0 directory, long j, l7.t fileSystem, TaskRunner taskRunner) {
        k.e(directory, "directory");
        k.e(fileSystem, "fileSystem");
        k.e(taskRunner, "taskRunner");
        this.cache = new DiskLruCache(fileSystem, directory, VERSION, 2, j, taskRunner);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    /* JADX INFO: renamed from: -deprecated_directory, reason: not valid java name */
    public final File m3468deprecated_directory() {
        return this.cache.getDirectory().toFile();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory().toFile();
    }

    public final g0 directoryPath() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) {
        k.e(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                _UtilCommonKt.closeQuietly(response.body());
                return null;
            } catch (IOException unused) {
                _UtilCommonKt.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editorEdit$default;
        k.e(response, "response");
        String strMethod = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!k.a(strMethod, "GET")) {
            return null;
        }
        Companion companion = Companion;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editorEdit$default = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
            if (editorEdit$default == null) {
                return null;
            }
            try {
                entry.writeTo(editorEdit$default);
                return new RealCacheRequest(this, editorEdit$default);
            } catch (IOException unused2) {
                abortQuietly(editorEdit$default);
                return null;
            }
        } catch (IOException unused3) {
            editorEdit$default = null;
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        k.e(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i2) {
        this.writeAbortCount = i2;
    }

    public final void setWriteSuccessCount$okhttp(int i2) {
        this.writeSuccessCount = i2;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        try {
            k.e(cacheStrategy, "cacheStrategy");
            this.requestCount++;
            if (cacheStrategy.getNetworkRequest() != null) {
                this.networkCount++;
            } else if (cacheStrategy.getCacheResponse() != null) {
                this.hitCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void update$okhttp(Response cached, Response network) {
        DiskLruCache.Editor editorEdit;
        k.e(cached, "cached");
        k.e(network, "network");
        Entry entry = new Entry(network);
        ResponseBody responseBodyBody = cached.body();
        k.c(responseBodyBody, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        try {
            editorEdit = ((CacheResponseBody) responseBodyBody).getSnapshot().edit();
            if (editorEdit == null) {
                return;
            }
            try {
                entry.writeTo(editorEdit);
                editorEdit.commit();
            } catch (IOException unused) {
                abortQuietly(editorEdit);
            }
        } catch (IOException unused2) {
            editorEdit = null;
        }
    }

    public final Iterator<String> urls() throws IOException {
        return new AnonymousClass1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(l7.t fileSystem, g0 directory, long j) {
        this(directory, j, fileSystem, TaskRunner.INSTANCE);
        k.e(fileSystem, "fileSystem");
        k.e(directory, "directory");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Cache(File directory, long j) {
        k.e(directory, "directory");
        l7.t tVar = l7.t.SYSTEM;
        String str = g0.f12850b;
        this(tVar, w1.f.e(directory), j);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Entry {
        public static final Companion Companion = new Companion(null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            public /* synthetic */ Companion(f fVar) {
                this();
            }

            private Companion() {
            }
        }

        static {
            StringBuilder sb = new StringBuilder();
            Platform.Companion companion = Platform.Companion;
            sb.append(companion.get().getPrefix());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        public Entry(o0 rawSource) throws IOException {
            k.e(rawSource, "rawSource");
            try {
                j0 j0VarC = l7.b.c(rawSource);
                String strH = j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL);
                HttpUrl httpUrl = HttpUrl.Companion.parse(strH);
                if (httpUrl == null) {
                    IOException iOException = new IOException("Cache corruption for ".concat(strH));
                    Platform.Companion.get().log("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.url = httpUrl;
                this.requestMethod = j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL);
                Headers.Builder builder = new Headers.Builder();
                int int$okhttp = Cache.Companion.readInt$okhttp(j0VarC);
                for (int i2 = 0; i2 < int$okhttp; i2++) {
                    builder.addLenient$okhttp(j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL));
                }
                this.varyHeaders = builder.build();
                StatusLine statusLine = StatusLine.Companion.parse(j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL));
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                Headers.Builder builder2 = new Headers.Builder();
                int int$okhttp2 = Cache.Companion.readInt$okhttp(j0VarC);
                for (int i8 = 0; i8 < int$okhttp2; i8++) {
                    builder2.addLenient$okhttp(j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL));
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (this.url.isHttps()) {
                    String strH2 = j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL);
                    if (strH2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strH2 + '\"');
                    }
                    this.handshake = Handshake.Companion.get(!j0VarC.M() ? TlsVersion.Companion.forJavaName(j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL)) : TlsVersion.SSL_3_0, CipherSuite.Companion.forJavaName(j0VarC.h(LocationRequestCompat.PASSIVE_INTERVAL)), readCertificateList(j0VarC), readCertificateList(j0VarC));
                } else {
                    this.handshake = null;
                }
                rawSource.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    q.I(rawSource, th);
                    throw th2;
                }
            }
        }

        private final List<Certificate> readCertificateList(l lVar) throws IOException {
            int int$okhttp = Cache.Companion.readInt$okhttp(lVar);
            if (int$okhttp == -1) {
                return r.f13638a;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509);
                ArrayList arrayList = new ArrayList(int$okhttp);
                int i2 = 0;
                for (int i8 = 0; i8 < int$okhttp; i8++) {
                    String strD = lVar.D();
                    j jVar = new j();
                    l7.m mVar = l7.m.f12880d;
                    l7.m mVarC = r4.c.c(strD);
                    if (mVarC == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    jVar.w(mVarC);
                    arrayList.add(certificateFactory.generateCertificate(new i(jVar, i2)));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private final void writeCertList(l7.k kVar, List<? extends Certificate> list) throws IOException {
            try {
                kVar.G(list.size()).writeByte(10);
                Iterator<? extends Certificate> it = list.iterator();
                while (it.hasNext()) {
                    byte[] encoded = it.next().getEncoded();
                    l7.m mVar = l7.m.f12880d;
                    k.b(encoded);
                    kVar.C(r4.c.g(encoded).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            k.e(request, "request");
            k.e(response, "response");
            return k.a(this.url, request.url()) && k.a(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            k.e(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request(this.url, this.varyHeaders, this.requestMethod, null, 8, null)).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            k.e(editor, "editor");
            i0 i0VarB = l7.b.b(editor.newSink(0));
            try {
                i0VarB.C(this.url.toString());
                i0VarB.writeByte(10);
                i0VarB.C(this.requestMethod);
                i0VarB.writeByte(10);
                i0VarB.G(this.varyHeaders.size());
                i0VarB.writeByte(10);
                int size = this.varyHeaders.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i0VarB.C(this.varyHeaders.name(i2));
                    i0VarB.C(": ");
                    i0VarB.C(this.varyHeaders.value(i2));
                    i0VarB.writeByte(10);
                }
                i0VarB.C(new StatusLine(this.protocol, this.code, this.message).toString());
                i0VarB.writeByte(10);
                i0VarB.G(this.responseHeaders.size() + 2);
                i0VarB.writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    i0VarB.C(this.responseHeaders.name(i8));
                    i0VarB.C(": ");
                    i0VarB.C(this.responseHeaders.value(i8));
                    i0VarB.writeByte(10);
                }
                i0VarB.C(SENT_MILLIS);
                i0VarB.C(": ");
                i0VarB.G(this.sentRequestMillis);
                i0VarB.writeByte(10);
                i0VarB.C(RECEIVED_MILLIS);
                i0VarB.C(": ");
                i0VarB.G(this.receivedResponseMillis);
                i0VarB.writeByte(10);
                if (this.url.isHttps()) {
                    i0VarB.writeByte(10);
                    Handshake handshake = this.handshake;
                    k.b(handshake);
                    i0VarB.C(handshake.cipherSuite().javaName());
                    i0VarB.writeByte(10);
                    writeCertList(i0VarB, this.handshake.peerCertificates());
                    writeCertList(i0VarB, this.handshake.localCertificates());
                    i0VarB.C(this.handshake.tlsVersion().javaName());
                    i0VarB.writeByte(10);
                }
                i0VarB.close();
            } finally {
            }
        }

        public Entry(Response response) {
            k.e(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
