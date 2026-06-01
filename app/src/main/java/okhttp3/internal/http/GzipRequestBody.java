package okhttp3.internal.http;

import java.io.IOException;
import kotlin.jvm.internal.k;
import l7.b;
import l7.i0;
import l7.y;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class GzipRequestBody extends RequestBody {
    private final RequestBody delegate;

    public GzipRequestBody(RequestBody delegate) {
        k.e(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return -1L;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.delegate.contentType();
    }

    public final RequestBody getDelegate() {
        return this.delegate;
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        return this.delegate.isOneShot();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(l7.k sink) throws IOException {
        k.e(sink, "sink");
        i0 i0VarB = b.b(new y(sink));
        try {
            this.delegate.writeTo(i0VarB);
            i0VarB.close();
        } finally {
        }
    }
}
