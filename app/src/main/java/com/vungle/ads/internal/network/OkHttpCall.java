package com.vungle.ads.internal.network;

import com.vungle.ads.internal.network.converters.Converter;
import com.vungle.ads.internal.util.Logger;
import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.b;
import l7.j;
import l7.l;
import l7.w;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OkHttpCall<T> implements Call<T> {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "OkHttpCall";
    private volatile boolean canceled;
    private final okhttp3.Call rawCall;
    private final Converter<ResponseBody, T> responseConverter;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void throwIfFatal(Throwable th) throws Throwable {
            if ((th instanceof VirtualMachineError) || (th instanceof ThreadDeath) || (th instanceof LinkageError)) {
                throw th;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        private final ResponseBody delegate;
        private final l delegateSource;
        private IOException thrownException;

        public ExceptionCatchingResponseBody(ResponseBody delegate) {
            k.e(delegate, "delegate");
            this.delegate = delegate;
            this.delegateSource = b.c(new w(delegate.source()) { // from class: com.vungle.ads.internal.network.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // l7.w, l7.o0
                public long read(j sink, long j) throws IOException {
                    k.e(sink, "sink");
                    try {
                        return super.read(sink, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.setThrownException(e);
                        throw e;
                    }
                }
            });
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.delegate.contentType();
        }

        public final IOException getThrownException() {
            return this.thrownException;
        }

        public final void setThrownException(IOException iOException) {
            this.thrownException = iOException;
        }

        @Override // okhttp3.ResponseBody
        public l source() {
            return this.delegateSource;
        }

        public final void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;
        private final MediaType contentType;

        public NoContentResponseBody(MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.ResponseBody
        public l source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(okhttp3.Call rawCall, Converter<ResponseBody, T> responseConverter) {
        k.e(rawCall, "rawCall");
        k.e(responseConverter, "responseConverter");
        this.rawCall = rawCall;
        this.responseConverter = responseConverter;
    }

    private final ResponseBody buffer(ResponseBody responseBody) throws IOException {
        j jVar = new j();
        responseBody.source().K(jVar);
        return ResponseBody.Companion.create(jVar, responseBody.contentType(), responseBody.contentLength());
    }

    @Override // com.vungle.ads.internal.network.Call
    public void cancel() {
        okhttp3.Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        call.cancel();
    }

    @Override // com.vungle.ads.internal.network.Call
    public void enqueue(final Callback<T> callback) {
        okhttp3.Call call;
        k.e(callback, "callback");
        synchronized (this) {
            call = this.rawCall;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new okhttp3.Callback(this) { // from class: com.vungle.ads.internal.network.OkHttpCall.enqueue.2
            final /* synthetic */ OkHttpCall<T> this$0;

            {
                this.this$0 = this;
            }

            private final void callFailure(Throwable th) throws Throwable {
                try {
                    callback.onFailure(this.this$0, th);
                } catch (Throwable th2) {
                    OkHttpCall.Companion.throwIfFatal(th2);
                    Logger.Companion.e(OkHttpCall.TAG, "Cannot pass failure to callback", th2);
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call2, IOException e) throws Throwable {
                k.e(call2, "call");
                k.e(e, "e");
                callFailure(e);
            }

            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call2, okhttp3.Response response) throws Throwable {
                k.e(call2, "call");
                k.e(response, "response");
                try {
                    try {
                        callback.onResponse(this.this$0, this.this$0.parseResponse(response));
                    } catch (Throwable th) {
                        OkHttpCall.Companion.throwIfFatal(th);
                        Logger.Companion.e(OkHttpCall.TAG, "Cannot pass response to callback", th);
                    }
                } catch (Throwable th2) {
                    OkHttpCall.Companion.throwIfFatal(th2);
                    callFailure(th2);
                }
            }
        });
    }

    @Override // com.vungle.ads.internal.network.Call
    public Response<T> execute() throws IOException {
        okhttp3.Call call;
        synchronized (this) {
            call = this.rawCall;
        }
        if (this.canceled) {
            call.cancel();
        }
        return parseResponse(call.execute());
    }

    @Override // com.vungle.ads.internal.network.Call
    public boolean isCanceled() {
        boolean zIsCanceled;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            zIsCanceled = this.rawCall.isCanceled();
        }
        return zIsCanceled;
    }

    public final Response<T> parseResponse(okhttp3.Response rawResp) throws IOException {
        k.e(rawResp, "rawResp");
        ResponseBody responseBodyBody = rawResp.body();
        if (responseBodyBody == null) {
            return null;
        }
        okhttp3.Response responseBuild = rawResp.newBuilder().body(new NoContentResponseBody(responseBodyBody.contentType(), responseBodyBody.contentLength())).build();
        int iCode = responseBuild.code();
        if (iCode >= 200 && iCode < 300) {
            if (iCode == 204 || iCode == 205) {
                responseBodyBody.close();
                return Response.Companion.success(null, responseBuild);
            }
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(responseBodyBody);
            try {
                return Response.Companion.success(this.responseConverter.convert(exceptionCatchingResponseBody), responseBuild);
            } catch (Throwable th) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw th;
            }
        }
        try {
            Response<T> responseError = Response.Companion.error(buffer(responseBodyBody), responseBuild);
            responseBodyBody.close();
            return responseError;
        } finally {
        }
    }
}
