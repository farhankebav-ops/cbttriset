package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.k;
import l7.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        k.e(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j, j sink, long j3) throws IOException {
        k.e(sink, "sink");
        if (j3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j8 = j;
        long j9 = j3;
        while (j9 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j8, j9, sink);
            j8 += jTransferTo;
            j9 -= jTransferTo;
        }
    }

    public final void write(long j, j source, long j3) throws IOException {
        k.e(source, "source");
        if (j3 < 0 || j3 > source.f12868b) {
            throw new IndexOutOfBoundsException();
        }
        long j8 = j;
        long j9 = j3;
        while (j9 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(source, j8, j9);
            j8 += jTransferFrom;
            j9 -= jTransferFrom;
        }
    }
}
