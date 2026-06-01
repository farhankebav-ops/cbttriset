package okhttp3.internal.connection;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.f;
import l7.b;
import l7.k;
import l7.l;
import l7.r0;
import n6.n;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConnectPlan implements RoutePlanner.Plan, ExchangeCodec.Carrier {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private final int attempt;
    private volatile boolean canceled;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final int connectionSpecIndex;
    private Handshake handshake;
    private final boolean isTlsFallback;
    private final int pingIntervalMillis;
    private Protocol protocol;
    private Socket rawSocket;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final Route route;
    private final RealRoutePlanner routePlanner;
    private final List<Route> routes;
    private k sink;
    private Socket socket;
    private final int socketConnectTimeoutMillis;
    private final int socketReadTimeoutMillis;
    private l source;
    private final TaskRunner taskRunner;
    private final Request tunnelRequest;
    private final ConnectionUser user;
    private final int writeTimeoutMillis;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ConnectPlan(TaskRunner taskRunner, RealConnectionPool connectionPool, int i2, int i8, int i9, int i10, int i11, boolean z2, ConnectionUser user, RealRoutePlanner routePlanner, Route route, List<Route> list, int i12, Request request, int i13, boolean z7) {
        kotlin.jvm.internal.k.e(taskRunner, "taskRunner");
        kotlin.jvm.internal.k.e(connectionPool, "connectionPool");
        kotlin.jvm.internal.k.e(user, "user");
        kotlin.jvm.internal.k.e(routePlanner, "routePlanner");
        kotlin.jvm.internal.k.e(route, "route");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.readTimeoutMillis = i2;
        this.writeTimeoutMillis = i8;
        this.socketConnectTimeoutMillis = i9;
        this.socketReadTimeoutMillis = i10;
        this.pingIntervalMillis = i11;
        this.retryOnConnectionFailure = z2;
        this.user = user;
        this.routePlanner = routePlanner;
        this.route = route;
        this.routes = list;
        this.attempt = i12;
        this.tunnelRequest = request;
        this.connectionSpecIndex = i13;
        this.isTlsFallback = z7;
    }

    private final void connectSocket() throws IOException {
        Socket socketCreateSocket;
        Proxy.Type type = getRoute().proxy().type();
        int i2 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i2 == 1 || i2 == 2) {
            socketCreateSocket = getRoute().address().socketFactory().createSocket();
            kotlin.jvm.internal.k.b(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(getRoute().proxy());
        }
        this.rawSocket = socketCreateSocket;
        if (this.canceled) {
            throw new IOException("canceled");
        }
        socketCreateSocket.setSoTimeout(this.socketReadTimeoutMillis);
        try {
            Platform.Companion.get().connectSocket(socketCreateSocket, getRoute().socketAddress(), this.socketConnectTimeoutMillis);
            try {
                this.source = b.c(b.k(socketCreateSocket));
                this.sink = b.b(b.i(socketCreateSocket));
            } catch (NullPointerException e) {
                if (kotlin.jvm.internal.k.a(e.getMessage(), NPE_THROW_WITH_NULL)) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e4) {
            ConnectException connectException = new ConnectException("Failed to connect to " + getRoute().socketAddress());
            connectException.initCause(e4);
            throw connectException;
        }
    }

    private final void connectTls(SSLSocket sSLSocket, ConnectionSpec connectionSpec) throws IOException {
        Address address = getRoute().address();
        try {
            if (connectionSpec.supportsTlsExtensions()) {
                Platform.Companion.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            Handshake.Companion companion = Handshake.Companion;
            kotlin.jvm.internal.k.b(session);
            Handshake handshake = companion.get(session);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier();
            kotlin.jvm.internal.k.b(hostnameVerifier);
            if (hostnameVerifier.verify(address.url().host(), session)) {
                CertificatePinner certificatePinner = address.certificatePinner();
                kotlin.jvm.internal.k.b(certificatePinner);
                Handshake handshake2 = new Handshake(handshake.tlsVersion(), handshake.cipherSuite(), handshake.localCertificates(), new okhttp3.a(certificatePinner, handshake, address, 1));
                this.handshake = handshake2;
                certificatePinner.check$okhttp(address.url().host(), new androidx.activity.result.b(handshake2, 11));
                String selectedProtocol = connectionSpec.supportsTlsExtensions() ? Platform.Companion.get().getSelectedProtocol(sSLSocket) : null;
                this.socket = sSLSocket;
                this.source = b.c(b.k(sSLSocket));
                this.sink = b.b(b.i(sSLSocket));
                this.protocol = selectedProtocol != null ? Protocol.Companion.get(selectedProtocol) : Protocol.HTTP_1_1;
                Platform.Companion.get().afterHandshake(sSLSocket);
                return;
            }
            List<Certificate> listPeerCertificates = handshake.peerCertificates();
            if (listPeerCertificates.isEmpty()) {
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
            }
            Certificate certificate = listPeerCertificates.get(0);
            kotlin.jvm.internal.k.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) certificate;
            throw new SSLPeerUnverifiedException(n.c0("\n            |Hostname " + address.url().host() + " not verified:\n            |    certificate: " + CertificatePinner.Companion.pin(x509Certificate) + "\n            |    DN: " + x509Certificate.getSubjectDN().getName() + "\n            |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(x509Certificate) + "\n            "));
        } catch (Throwable th) {
            Platform.Companion.get().afterHandshake(sSLSocket);
            _UtilJvmKt.closeQuietly(sSLSocket);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List connectTls$lambda$4(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        CertificateChainCleaner certificateChainCleaner$okhttp = certificatePinner.getCertificateChainCleaner$okhttp();
        kotlin.jvm.internal.k.b(certificateChainCleaner$okhttp);
        return certificateChainCleaner$okhttp.clean(handshake.peerCertificates(), address.url().host());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List connectTls$lambda$6(Handshake handshake) {
        List<Certificate> listPeerCertificates = handshake.peerCertificates();
        ArrayList arrayList = new ArrayList(r5.n.L0(listPeerCertificates, 10));
        for (Certificate certificate : listPeerCertificates) {
            kotlin.jvm.internal.k.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }

    private final ConnectPlan copy(int i2, Request request, int i8, boolean z2) {
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.user, this.routePlanner, getRoute(), this.routes, i2, request, i8, z2);
    }

    public static /* synthetic */ ConnectPlan copy$default(ConnectPlan connectPlan, int i2, Request request, int i8, boolean z2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i2 = connectPlan.attempt;
        }
        if ((i9 & 2) != 0) {
            request = connectPlan.tunnelRequest;
        }
        if ((i9 & 4) != 0) {
            i8 = connectPlan.connectionSpecIndex;
        }
        if ((i9 & 8) != 0) {
            z2 = connectPlan.isTlsFallback;
        }
        return connectPlan.copy(i2, request, i8, z2);
    }

    private final Request createTunnel() throws IOException {
        Request request = this.tunnelRequest;
        kotlin.jvm.internal.k.b(request);
        String str = "CONNECT " + _UtilJvmKt.toHostHeader(getRoute().address().url(), true) + " HTTP/1.1";
        while (true) {
            l lVar = this.source;
            if (lVar == null) {
                kotlin.jvm.internal.k.l("source");
                throw null;
            }
            k kVar = this.sink;
            if (kVar == null) {
                kotlin.jvm.internal.k.l("sink");
                throw null;
            }
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, lVar, kVar);
            l lVar2 = this.source;
            if (lVar2 == null) {
                kotlin.jvm.internal.k.l("source");
                throw null;
            }
            r0 r0VarTimeout = lVar2.timeout();
            long j = this.readTimeoutMillis;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            r0VarTimeout.timeout(j, timeUnit);
            k kVar2 = this.sink;
            if (kVar2 == null) {
                kotlin.jvm.internal.k.l("sink");
                throw null;
            }
            kVar2.timeout().timeout(this.writeTimeoutMillis, timeUnit);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response.Builder responseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            kotlin.jvm.internal.k.b(responseHeaders);
            Response responseBuild = responseHeaders.request(request).build();
            http1ExchangeCodec.skipConnectBody(responseBuild);
            int iCode = responseBuild.code();
            if (iCode == 200) {
                return null;
            }
            if (iCode != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + responseBuild.code());
            }
            Request requestAuthenticate = getRoute().address().proxyAuthenticator().authenticate(getRoute(), responseBuild);
            if (requestAuthenticate == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (MRAIDPresenter.CLOSE.equalsIgnoreCase(Response.header$default(responseBuild, "Connection", null, 2, null))) {
                return requestAuthenticate;
            }
            request = requestAuthenticate;
        }
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    /* JADX INFO: renamed from: cancel */
    public void mo3601cancel() {
        this.canceled = true;
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    public final void closeQuietly() {
        Socket socket = this.socket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: connectTcp */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.internal.connection.RoutePlanner.ConnectResult mo3605connectTcp() throws java.lang.Throwable {
        /*
            r14 = this;
            java.net.Socket r0 = r14.rawSocket
            if (r0 != 0) goto Laf
            okhttp3.internal.connection.ConnectionUser r0 = r14.user
            r0.addPlanToCancel(r14)
            r1 = 0
            okhttp3.internal.connection.ConnectionUser r0 = r14.user     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
            okhttp3.Route r2 = r14.getRoute()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
            r0.connectStart(r2)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
            r14.connectSocket()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
            r1 = 1
            okhttp3.internal.connection.RoutePlanner$ConnectResult r2 = new okhttp3.internal.connection.RoutePlanner$ConnectResult     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L30
            r6 = 6
            r7 = 0
            r4 = 0
            r5 = 0
            r3 = r14
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L2a
            okhttp3.internal.connection.ConnectionUser r0 = r3.user
            r0.removePlanToCancel(r14)
            return r2
        L27:
            r0 = move-exception
            goto La0
        L2a:
            r0 = move-exception
        L2b:
            r11 = r0
            goto L33
        L2d:
            r0 = move-exception
            r3 = r14
            goto La0
        L30:
            r0 = move-exception
            r3 = r14
            goto L2b
        L33:
            okhttp3.Route r0 = r14.getRoute()     // Catch: java.lang.Throwable -> L27
            okhttp3.Address r0 = r0.address()     // Catch: java.lang.Throwable -> L27
            java.net.Proxy r0 = r0.proxy()     // Catch: java.lang.Throwable -> L27
            if (r0 != 0) goto L7c
            okhttp3.Route r0 = r14.getRoute()     // Catch: java.lang.Throwable -> L27
            java.net.Proxy r0 = r0.proxy()     // Catch: java.lang.Throwable -> L27
            java.net.Proxy$Type r0 = r0.type()     // Catch: java.lang.Throwable -> L27
            java.net.Proxy$Type r2 = java.net.Proxy.Type.DIRECT     // Catch: java.lang.Throwable -> L27
            if (r0 == r2) goto L7c
            okhttp3.Route r0 = r14.getRoute()     // Catch: java.lang.Throwable -> L27
            okhttp3.Address r0 = r0.address()     // Catch: java.lang.Throwable -> L27
            java.net.ProxySelector r0 = r0.proxySelector()     // Catch: java.lang.Throwable -> L27
            okhttp3.Route r2 = r14.getRoute()     // Catch: java.lang.Throwable -> L27
            okhttp3.Address r2 = r2.address()     // Catch: java.lang.Throwable -> L27
            okhttp3.HttpUrl r2 = r2.url()     // Catch: java.lang.Throwable -> L27
            java.net.URI r2 = r2.uri()     // Catch: java.lang.Throwable -> L27
            okhttp3.Route r4 = r14.getRoute()     // Catch: java.lang.Throwable -> L27
            java.net.Proxy r4 = r4.proxy()     // Catch: java.lang.Throwable -> L27
            java.net.SocketAddress r4 = r4.address()     // Catch: java.lang.Throwable -> L27
            r0.connectFailed(r2, r4, r11)     // Catch: java.lang.Throwable -> L27
        L7c:
            okhttp3.internal.connection.ConnectionUser r0 = r3.user     // Catch: java.lang.Throwable -> L27
            okhttp3.Route r2 = r14.getRoute()     // Catch: java.lang.Throwable -> L27
            r4 = 0
            r0.connectFailed(r2, r4, r11)     // Catch: java.lang.Throwable -> L27
            okhttp3.internal.connection.RoutePlanner$ConnectResult r8 = new okhttp3.internal.connection.RoutePlanner$ConnectResult     // Catch: java.lang.Throwable -> L27
            r12 = 2
            r13 = 0
            r10 = 0
            r9 = r3
            r8.<init>(r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L9e
            okhttp3.internal.connection.ConnectionUser r0 = r3.user
            r0.removePlanToCancel(r14)
            if (r1 != 0) goto L9d
            java.net.Socket r0 = r3.rawSocket
            if (r0 == 0) goto L9d
            okhttp3.internal._UtilJvmKt.closeQuietly(r0)
        L9d:
            return r8
        L9e:
            r0 = move-exception
            r3 = r9
        La0:
            okhttp3.internal.connection.ConnectionUser r2 = r3.user
            r2.removePlanToCancel(r14)
            if (r1 != 0) goto Lae
            java.net.Socket r1 = r3.rawSocket
            if (r1 == 0) goto Lae
            okhttp3.internal._UtilJvmKt.closeQuietly(r1)
        Lae:
            throw r0
        Laf:
            r3 = r14
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "TCP already connected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ConnectPlan.mo3605connectTcp():okhttp3.internal.connection.RoutePlanner$ConnectResult");
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0192  */
    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: connectTlsEtc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.internal.connection.RoutePlanner.ConnectResult mo3606connectTlsEtc() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ConnectPlan.mo3606connectTlsEtc():okhttp3.internal.connection.RoutePlanner$ConnectResult");
    }

    public final RoutePlanner.ConnectResult connectTunnel$okhttp() throws IOException {
        Request requestCreateTunnel = createTunnel();
        if (requestCreateTunnel == null) {
            return new RoutePlanner.ConnectResult(this, null, null, 6, null);
        }
        Socket socket = this.rawSocket;
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
        int i2 = this.attempt + 1;
        if (i2 < 21) {
            this.user.callConnectEnd(getRoute(), null);
            return new RoutePlanner.ConnectResult(this, copy$default(this, i2, requestCreateTunnel, 0, false, 12, null), null, 4, null);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        this.user.connectFailed(getRoute(), null, protocolException);
        return new RoutePlanner.ConnectResult(this, null, protocolException, 2, null);
    }

    public final int getConnectionSpecIndex$okhttp() {
        return this.connectionSpecIndex;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public Route getRoute() {
        return this.route;
    }

    public final List<Route> getRoutes$okhttp() {
        return this.routes;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: handleSuccess */
    public RealConnection mo3602handleSuccess() {
        this.user.updateRouteDatabaseAfterSuccess(getRoute());
        RealConnection realConnection = this.connection;
        kotlin.jvm.internal.k.b(realConnection);
        this.user.connectionConnectEnd(realConnection, getRoute());
        ReusePlan reusePlanPlanReusePooledConnection$okhttp = this.routePlanner.planReusePooledConnection$okhttp(this, this.routes);
        if (reusePlanPlanReusePooledConnection$okhttp != null) {
            return reusePlanPlanReusePooledConnection$okhttp.getConnection();
        }
        synchronized (realConnection) {
            this.connectionPool.put(realConnection);
            this.user.acquireConnectionNoEvents(realConnection);
        }
        this.user.connectionAcquired(realConnection);
        this.user.connectionConnectionAcquired(realConnection);
        return realConnection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public boolean isReady() {
        return this.protocol != null;
    }

    public final boolean isTlsFallback$okhttp() {
        return this.isTlsFallback;
    }

    public final ConnectPlan nextConnectionSpec$okhttp(List<ConnectionSpec> connectionSpecs, SSLSocket sslSocket) {
        kotlin.jvm.internal.k.e(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        int i2 = this.connectionSpecIndex + 1;
        int size = connectionSpecs.size();
        for (int i8 = i2; i8 < size; i8++) {
            if (connectionSpecs.get(i8).isCompatible(sslSocket)) {
                return copy$default(this, 0, null, i8, this.connectionSpecIndex != -1, 3, null);
            }
        }
        return null;
    }

    public final ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp(List<ConnectionSpec> connectionSpecs, SSLSocket sslSocket) throws IOException {
        kotlin.jvm.internal.k.e(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.k.e(sslSocket, "sslSocket");
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        ConnectPlan connectPlanNextConnectionSpec$okhttp = nextConnectionSpec$okhttp(connectionSpecs, sslSocket);
        if (connectPlanNextConnectionSpec$okhttp != null) {
            return connectPlanNextConnectionSpec$okhttp;
        }
        StringBuilder sb = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isTlsFallback);
        sb.append(", modes=");
        sb.append(connectionSpecs);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        kotlin.jvm.internal.k.b(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        kotlin.jvm.internal.k.d(string, "toString(...)");
        sb.append(string);
        throw new UnknownServiceException(sb.toString());
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* JADX INFO: renamed from: retry */
    public RoutePlanner.Plan mo3603retry() {
        return new ConnectPlan(this.taskRunner, this.connectionPool, this.readTimeoutMillis, this.writeTimeoutMillis, this.socketConnectTimeoutMillis, this.socketReadTimeoutMillis, this.pingIntervalMillis, this.retryOnConnectionFailure, this.user, this.routePlanner, getRoute(), this.routes, this.attempt, this.tunnelRequest, this.connectionSpecIndex, this.isTlsFallback);
    }

    public final void setSocket$okhttp(Socket socket) {
        this.socket = socket;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void trackFailure(RealCall call, IOException iOException) {
        kotlin.jvm.internal.k.e(call, "call");
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void noNewExchanges() {
    }
}
