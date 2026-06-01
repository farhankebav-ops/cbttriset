package okhttp3.logging;

import androidx.core.location.LocationRequestCompat;
import com.ironsource.C2300e4;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.j;
import l7.l;
import l7.z;
import n6.t;
import n7.b;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.internal.IsProbablyUtf8Kt;
import y5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;
    private volatile Set<String> queryParamsNameToRedact;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Level {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level NONE = new Level("NONE", 0);
        public static final Level BASIC = new Level("BASIC", 1);
        public static final Level HEADERS = new Level("HEADERS", 2);
        public static final Level BODY = new Level("BODY", 3);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{NONE, BASIC, HEADERS, BODY};
        }

        static {
            Level[] levelArr$values = $values();
            $VALUES = levelArr$values;
            $ENTRIES = b.n(levelArr$values);
        }

        private Level(String str, int i2) {
        }

        public static a getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
            public static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    k.e(message, "message");
                    Platform.log$default(Platform.Companion.get(), message, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity") || str.equalsIgnoreCase("gzip")) ? false : true;
    }

    private final boolean bodyIsStreaming(Response response) {
        MediaType mediaTypeContentType = response.body().contentType();
        return mediaTypeContentType != null && k.a(mediaTypeContentType.type(), C2300e4.h.K0) && k.a(mediaTypeContentType.subtype(), "event-stream");
    }

    private final void logHeader(Headers headers, int i2) {
        String strValue = this.headersToRedact.contains(headers.name(i2)) ? "██" : headers.value(i2);
        this.logger.log(headers.name(i2) + ": " + strValue);
    }

    /* JADX INFO: renamed from: -deprecated_level, reason: not valid java name */
    public final Level m3610deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        boolean z2;
        boolean z7;
        long j;
        Long lValueOf;
        z zVar;
        Long lValueOf2;
        k.e(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z8 = true;
        boolean z9 = level == Level.BODY;
        if (!z9 && level != Level.HEADERS) {
            z8 = false;
        }
        RequestBody requestBodyBody = request.body();
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(redactUrl$logging_interceptor(request.url()));
        sb.append(connection != null ? " " + connection.protocol() : "");
        String string = sb.toString();
        if (!z8 && requestBodyBody != null) {
            StringBuilder sbX = a1.a.x(string, " (");
            sbX.append(requestBodyBody.contentLength());
            sbX.append("-byte body)");
            string = sbX.toString();
        }
        this.logger.log(string);
        if (z8) {
            Headers headers = request.headers();
            if (requestBodyBody != null) {
                MediaType mediaTypeContentType = requestBodyBody.contentType();
                if (mediaTypeContentType != null) {
                    j = -1;
                    if (headers.get("Content-Type") == null) {
                        z2 = z9;
                        z7 = z8;
                        this.logger.log("Content-Type: " + mediaTypeContentType);
                    } else {
                        z2 = z9;
                        z7 = z8;
                    }
                } else {
                    z2 = z9;
                    z7 = z8;
                    j = -1;
                }
                if (requestBodyBody.contentLength() != j && headers.get("Content-Length") == null) {
                    this.logger.log("Content-Length: " + requestBodyBody.contentLength());
                }
            } else {
                z2 = z9;
                z7 = z8;
                j = -1;
            }
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                logHeader(headers, i2);
            }
            if (!z2 || requestBodyBody == null) {
                this.logger.log("--> END " + request.method());
            } else if (bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else if (requestBodyBody.isDuplex()) {
                this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
            } else if (requestBodyBody.isOneShot()) {
                this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
            } else {
                j jVar = new j();
                requestBodyBody.writeTo(jVar);
                if ("gzip".equalsIgnoreCase(headers.get("Content-Encoding"))) {
                    lValueOf2 = Long.valueOf(jVar.f12868b);
                    zVar = new z(jVar);
                    try {
                        jVar = new j();
                        jVar.H(zVar);
                        zVar.close();
                    } finally {
                    }
                } else {
                    lValueOf2 = null;
                }
                Charset charsetCharsetOrUtf8 = Internal.charsetOrUtf8(requestBodyBody.contentType());
                this.logger.log("");
                if (!IsProbablyUtf8Kt.isProbablyUtf8(jVar)) {
                    this.logger.log("--> END " + request.method() + " (binary " + requestBodyBody.contentLength() + "-byte body omitted)");
                } else if (lValueOf2 != null) {
                    this.logger.log("--> END " + request.method() + " (" + jVar.f12868b + "-byte, " + lValueOf2 + "-gzipped-byte body)");
                } else {
                    this.logger.log(jVar.P(charsetCharsetOrUtf8));
                    this.logger.log("--> END " + request.method() + " (" + requestBodyBody.contentLength() + "-byte body)");
                }
            }
        } else {
            z2 = z9;
            z7 = z8;
            j = -1;
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseProceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyBody = responseProceed.body();
            k.b(responseBodyBody);
            long jContentLength = responseBodyBody.contentLength();
            String str = jContentLength != j ? jContentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<-- " + responseProceed.code());
            if (responseProceed.message().length() > 0) {
                sb2.append(" " + responseProceed.message());
            }
            sb2.append(" " + redactUrl$logging_interceptor(responseProceed.request().url()) + " (" + millis + "ms");
            if (!z7) {
                sb2.append(", " + str + " body");
            }
            sb2.append(")");
            logger.log(sb2.toString());
            if (z7) {
                Headers headers2 = responseProceed.headers();
                int size2 = headers2.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    logHeader(headers2, i8);
                }
                if (z2 && HttpHeaders.promisesBody(responseProceed)) {
                    if (bodyHasUnknownEncoding(responseProceed.headers())) {
                        this.logger.log("<-- END HTTP (encoded body omitted)");
                        return responseProceed;
                    }
                    if (bodyIsStreaming(responseProceed)) {
                        this.logger.log("<-- END HTTP (streaming)");
                        return responseProceed;
                    }
                    l lVarSource = responseBodyBody.source();
                    lVarSource.c(LocationRequestCompat.PASSIVE_INTERVAL);
                    long millis2 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
                    j buffer = lVarSource.getBuffer();
                    if ("gzip".equalsIgnoreCase(headers2.get("Content-Encoding"))) {
                        lValueOf = Long.valueOf(buffer.f12868b);
                        zVar = new z(buffer.clone());
                        try {
                            buffer = new j();
                            buffer.H(zVar);
                            zVar.close();
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } else {
                        lValueOf = null;
                    }
                    Charset charsetCharsetOrUtf82 = Internal.charsetOrUtf8(responseBodyBody.contentType());
                    if (!IsProbablyUtf8Kt.isProbablyUtf8(buffer)) {
                        this.logger.log("");
                        Logger logger2 = this.logger;
                        StringBuilder sbT = androidx.camera.core.processing.util.a.t("<-- END HTTP (", millis2, "ms, binary ");
                        sbT.append(buffer.f12868b);
                        sbT.append("-byte body omitted)");
                        logger2.log(sbT.toString());
                        return responseProceed;
                    }
                    if (jContentLength != 0) {
                        this.logger.log("");
                        this.logger.log(buffer.clone().P(charsetCharsetOrUtf82));
                    }
                    Logger logger3 = this.logger;
                    StringBuilder sb3 = new StringBuilder();
                    StringBuilder sbT2 = androidx.camera.core.processing.util.a.t("<-- END HTTP (", millis2, "ms, ");
                    sbT2.append(buffer.f12868b);
                    sbT2.append("-byte");
                    sb3.append(sbT2.toString());
                    if (lValueOf != null) {
                        sb3.append(", " + lValueOf + "-gzipped-byte");
                    }
                    sb3.append(" body)");
                    logger3.log(sb3.toString());
                    return responseProceed;
                }
                this.logger.log("<-- END HTTP");
            }
            return responseProceed;
        } catch (Exception e) {
            this.logger.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }

    public final void level(Level level) {
        k.e(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(String name) {
        k.e(name, "name");
        t.h0();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        r5.l.Q0(this.headersToRedact, treeSet);
        treeSet.add(name);
        this.headersToRedact = treeSet;
    }

    public final void redactQueryParams(String... name) {
        k.e(name, "name");
        t.h0();
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        r5.l.Q0(this.queryParamsNameToRedact, treeSet);
        r5.l.R0(treeSet, name);
        this.queryParamsNameToRedact = treeSet;
    }

    public final String redactUrl$logging_interceptor(HttpUrl url) {
        k.e(url, "url");
        if (this.queryParamsNameToRedact.isEmpty() || url.querySize() == 0) {
            return url.toString();
        }
        HttpUrl.Builder builderQuery = url.newBuilder().query(null);
        int iQuerySize = url.querySize();
        for (int i2 = 0; i2 < iQuerySize; i2++) {
            String strQueryParameterName = url.queryParameterName(i2);
            builderQuery.addEncodedQueryParameter(strQueryParameterName, this.queryParamsNameToRedact.contains(strQueryParameterName) ? "██" : url.queryParameterValue(i2));
        }
        return builderQuery.toString();
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        k.e(level, "level");
        this.level = level;
        return this;
    }

    public HttpLoggingInterceptor(Logger logger) {
        k.e(logger, "logger");
        this.logger = logger;
        r5.t tVar = r5.t.f13640a;
        this.headersToRedact = tVar;
        this.queryParamsNameToRedact = tVar;
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i2, f fVar) {
        this((i2 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
