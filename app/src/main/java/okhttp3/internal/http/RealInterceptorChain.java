package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall call, List<? extends Interceptor> interceptors, int i2, Exchange exchange, Request request, int i8, int i9, int i10) {
        k.e(call, "call");
        k.e(interceptors, "interceptors");
        k.e(request, "request");
        this.call = call;
        this.interceptors = interceptors;
        this.index = i2;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i8;
        this.readTimeoutMillis = i9;
        this.writeTimeoutMillis = i10;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i2, Exchange exchange, Request request, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i2 = realInterceptorChain.index;
        }
        if ((i11 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        if ((i11 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        if ((i11 & 8) != 0) {
            i8 = realInterceptorChain.connectTimeoutMillis;
        }
        if ((i11 & 16) != 0) {
            i9 = realInterceptorChain.readTimeoutMillis;
        }
        if ((i11 & 32) != 0) {
            i10 = realInterceptorChain.writeTimeoutMillis;
        }
        int i12 = i9;
        int i13 = i10;
        return realInterceptorChain.copy$okhttp(i2, exchange, request, i8, i12, i13);
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange != null) {
            return exchange.getConnection$okhttp();
        }
        return null;
    }

    public final RealInterceptorChain copy$okhttp(int i2, Exchange exchange, Request request, int i8, int i9, int i10) {
        k.e(request, "request");
        return new RealInterceptorChain(this.call, this.interceptors, i2, exchange, request, i8, i9, i10);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        k.e(request, "request");
        if (this.index >= this.interceptors.size()) {
            throw new IllegalStateException("Check failed.");
        }
        this.calls++;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            if (!exchange.getFinder$okhttp().getRoutePlanner().sameHostAndPort(request.url())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (this.calls != 1) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        RealInterceptorChain realInterceptorChainCopy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response responseIntercept = interceptor.intercept(realInterceptorChainCopy$okhttp$default);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.exchange == null || this.index + 1 >= this.interceptors.size() || realInterceptorChainCopy$okhttp$default.calls == 1) {
            return responseIntercept;
        }
        throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i2, TimeUnit unit) {
        k.e(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, _UtilJvmKt.checkDuration("connectTimeout", i2, unit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i2, TimeUnit unit) {
        k.e(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, _UtilJvmKt.checkDuration("readTimeout", i2, unit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i2, TimeUnit unit) {
        k.e(unit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, 0, _UtilJvmKt.checkDuration("writeTimeout", i2, unit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor");
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
