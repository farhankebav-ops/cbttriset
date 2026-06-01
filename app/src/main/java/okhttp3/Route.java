package okhttp3;

import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.jvm.internal.k;
import n6.m;
import okhttp3.internal._HostnamesCommonKt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Route {
    private final Address address;
    private final Proxy proxy;
    private final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress socketAddress) {
        k.e(address, "address");
        k.e(proxy, "proxy");
        k.e(socketAddress, "socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = socketAddress;
    }

    /* JADX INFO: renamed from: -deprecated_address, reason: not valid java name */
    public final Address m3596deprecated_address() {
        return this.address;
    }

    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m3597deprecated_proxy() {
        return this.proxy;
    }

    /* JADX INFO: renamed from: -deprecated_socketAddress, reason: not valid java name */
    public final InetSocketAddress m3598deprecated_socketAddress() {
        return this.socketAddress;
    }

    public final Address address() {
        return this.address;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        return k.a(route.address, this.address) && k.a(route.proxy, this.proxy) && k.a(route.socketAddress, this.socketAddress);
    }

    public int hashCode() {
        return this.socketAddress.hashCode() + ((this.proxy.hashCode() + ((this.address.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31)) * 31);
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        if (this.proxy.type() != Proxy.Type.HTTP) {
            return false;
        }
        return this.address.sslSocketFactory() != null || this.address.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE);
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    public String toString() {
        String hostAddress;
        StringBuilder sb = new StringBuilder();
        String strHost = this.address.url().host();
        InetAddress address = this.socketAddress.getAddress();
        String canonicalHost = (address == null || (hostAddress = address.getHostAddress()) == null) ? null : _HostnamesCommonKt.toCanonicalHost(hostAddress);
        if (m.r0(strHost, ':')) {
            androidx.camera.core.processing.util.a.z(sb, C2300e4.i.f8403d, strHost, C2300e4.i.e);
        } else {
            sb.append(strHost);
        }
        if (this.address.url().port() != this.socketAddress.getPort() || strHost.equals(canonicalHost)) {
            sb.append(":");
            sb.append(this.address.url().port());
        }
        if (!strHost.equals(canonicalHost)) {
            if (k.a(this.proxy, Proxy.NO_PROXY)) {
                sb.append(" at ");
            } else {
                sb.append(" via proxy ");
            }
            if (canonicalHost == null) {
                sb.append("<unresolved>");
            } else if (m.r0(canonicalHost, ':')) {
                androidx.camera.core.processing.util.a.z(sb, C2300e4.i.f8403d, canonicalHost, C2300e4.i.e);
            } else {
                sb.append(canonicalHost);
            }
            sb.append(":");
            sb.append(this.socketAddress.getPort());
        }
        return sb.toString();
    }
}
