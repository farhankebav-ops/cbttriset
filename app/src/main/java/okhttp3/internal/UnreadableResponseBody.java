package okhttp3.internal;

import kotlin.jvm.internal.k;
import l7.b;
import l7.j;
import l7.l;
import l7.o0;
import l7.r0;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnreadableResponseBody extends ResponseBody implements o0 {
    private final long contentLength;
    private final MediaType mediaType;

    public UnreadableResponseBody(MediaType mediaType, long j) {
        this.mediaType = mediaType;
        this.contentLength = j;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.mediaType;
    }

    @Override // l7.o0
    public long read(j sink, long j) {
        k.e(sink, "sink");
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    @Override // okhttp3.ResponseBody
    public l source() {
        return b.c(this);
    }

    @Override // l7.o0
    public r0 timeout() {
        return r0.NONE;
    }

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
