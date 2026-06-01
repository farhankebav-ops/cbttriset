package sg.bigo.ads.core.player.a;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import sg.bigo.ads.common.m;

/* JADX INFO: loaded from: classes6.dex */
final class f extends ProxySelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Proxy> f17296a = Arrays.asList(Proxy.NO_PROXY);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProxySelector f17297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f17298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f17299d;

    private f(ProxySelector proxySelector, String str, int i2) {
        this.f17297b = (ProxySelector) m.a(proxySelector);
        this.f17298c = (String) m.a(str);
        this.f17299d = i2;
    }

    public static void a(String str, int i2) {
        ProxySelector.setDefault(new f(ProxySelector.getDefault(), str, i2));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f17297b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return (this.f17298c.equals(uri.getHost()) && this.f17299d == uri.getPort()) ? f17296a : this.f17297b.select(uri);
    }
}
