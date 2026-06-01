package okhttp3.internal.ws;

import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.k;
import l7.a0;
import l7.b;
import l7.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class MessageInflater implements Closeable {
    private final j deflatedBytes;
    private final Inflater inflater;
    private final a0 inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z2) {
        this.noContextTakeover = z2;
        j jVar = new j();
        this.deflatedBytes = jVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new a0(b.c(jVar), inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(j buffer) throws IOException {
        k.e(buffer, "buffer");
        if (this.deflatedBytes.f12868b != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.H(buffer);
        this.deflatedBytes.X(65535);
        long bytesRead = this.inflater.getBytesRead() + this.deflatedBytes.f12868b;
        do {
            this.inflaterSource.a(buffer, LocationRequestCompat.PASSIVE_INTERVAL);
            if (this.inflater.getBytesRead() >= bytesRead) {
                return;
            }
        } while (!this.inflater.finished());
    }
}
