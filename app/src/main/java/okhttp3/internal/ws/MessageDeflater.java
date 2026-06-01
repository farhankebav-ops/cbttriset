package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.k;
import l7.b;
import l7.h;
import l7.j;
import l7.m;
import l7.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class MessageDeflater implements Closeable {
    private final j deflatedBytes;
    private final Deflater deflater;
    private final n deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z2) {
        this.noContextTakeover = z2;
        j jVar = new j();
        this.deflatedBytes = jVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new n(b.b(jVar), deflater);
    }

    private final boolean endsWith(j jVar, m mVar) {
        return jVar.I(jVar.f12868b - ((long) mVar.d()), mVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.deflaterSink.close();
    }

    public final void deflate(j buffer) throws IOException {
        k.e(buffer, "buffer");
        if (this.deflatedBytes.f12868b != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(buffer, buffer.f12868b);
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.EMPTY_DEFLATE_BLOCK)) {
            j jVar = this.deflatedBytes;
            long j = jVar.f12868b - ((long) 4);
            h hVarN = jVar.n(b.f12839a);
            try {
                hVarN.a(j);
                hVarN.close();
            } finally {
            }
        } else {
            this.deflatedBytes.x(0);
        }
        j jVar2 = this.deflatedBytes;
        buffer.write(jVar2, jVar2.f12868b);
    }
}
