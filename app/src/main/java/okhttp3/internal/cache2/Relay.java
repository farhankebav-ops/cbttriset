package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.j;
import l7.m;
import l7.o0;
import l7.r0;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.concurrent.Lockable;
import r4.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Relay implements Lockable {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final m PREFIX_CLEAN;
    public static final m PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final j buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final m metadata;
    private int sourceCount;
    private o0 upstream;
    private final j upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Relay edit(File file, o0 upstream, m metadata, long j) throws IOException {
            k.e(file, "file");
            k.e(upstream, "upstream");
            k.e(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, upstream, 0L, metadata, j, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            k.e(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            k.d(channel, "getChannel(...)");
            FileOperator fileOperator = new FileOperator(channel);
            j jVar = new j();
            fileOperator.read(0L, jVar, Relay.FILE_HEADER_SIZE);
            if (!k.a(jVar.J(r11.d()), Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long j = jVar.readLong();
            long j3 = jVar.readLong();
            j jVar2 = new j();
            fileOperator.read(Relay.FILE_HEADER_SIZE + j, jVar2, j3);
            return new Relay(randomAccessFile, null, j, jVar2.J(jVar2.f12868b), 0L, null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class RelaySource implements o0 {
        private FileOperator fileOperator;
        private long sourcePos;
        private final r0 timeout = new r0();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            k.b(file);
            FileChannel channel = file.getChannel();
            k.d(channel, "getChannel(...)");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            Relay relay = Relay.this;
            synchronized (relay) {
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (relay.getSourceCount() == 0) {
                    RandomAccessFile file = relay.getFile();
                    relay.setFile(null);
                    randomAccessFile = file;
                }
            }
            if (randomAccessFile != null) {
                _UtilCommonKt.closeQuietly(randomAccessFile);
            }
        }

        @Override // l7.o0
        public long read(j sink, long j) throws IOException {
            char c7;
            k.e(sink, "sink");
            if (this.fileOperator == null) {
                throw new IllegalStateException("Check failed.");
            }
            Relay relay = Relay.this;
            synchronized (relay) {
                while (true) {
                    try {
                        if (this.sourcePos != relay.getUpstreamPos()) {
                            long upstreamPos = relay.getUpstreamPos() - relay.getBuffer().f12868b;
                            if (this.sourcePos >= upstreamPos) {
                                long jMin = Math.min(j, relay.getUpstreamPos() - this.sourcePos);
                                relay.getBuffer().g(this.sourcePos - upstreamPos, sink, jMin);
                                this.sourcePos += jMin;
                                return jMin;
                            }
                            c7 = 2;
                        } else if (!relay.getComplete()) {
                            if (relay.getUpstreamReader() == null) {
                                relay.setUpstreamReader(Thread.currentThread());
                                c7 = 1;
                                break;
                            }
                            this.timeout.waitUntilNotified(relay);
                        } else {
                            return -1L;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (c7 == 2) {
                    long jMin2 = Math.min(j, Relay.this.getUpstreamPos() - this.sourcePos);
                    FileOperator fileOperator = this.fileOperator;
                    k.b(fileOperator);
                    fileOperator.read(this.sourcePos + Relay.FILE_HEADER_SIZE, sink, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    o0 upstream = Relay.this.getUpstream();
                    k.b(upstream);
                    long j3 = upstream.read(Relay.this.getUpstreamBuffer(), Relay.this.getBufferMaxSize());
                    if (j3 == -1) {
                        Relay relay2 = Relay.this;
                        relay2.commit(relay2.getUpstreamPos());
                        Relay relay3 = Relay.this;
                        synchronized (relay3) {
                            relay3.setUpstreamReader(null);
                            relay3.notifyAll();
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j3, j);
                    Relay.this.getUpstreamBuffer().g(0L, sink, jMin3);
                    this.sourcePos += jMin3;
                    FileOperator fileOperator2 = this.fileOperator;
                    k.b(fileOperator2);
                    fileOperator2.write(Relay.this.getUpstreamPos() + Relay.FILE_HEADER_SIZE, Relay.this.getUpstreamBuffer().clone(), j3);
                    Relay relay4 = Relay.this;
                    synchronized (relay4) {
                        try {
                            relay4.getBuffer().write(relay4.getUpstreamBuffer(), j3);
                            if (relay4.getBuffer().f12868b > relay4.getBufferMaxSize()) {
                                relay4.getBuffer().skip(relay4.getBuffer().f12868b - relay4.getBufferMaxSize());
                            }
                            relay4.setUpstreamPos(relay4.getUpstreamPos() + j3);
                        } finally {
                        }
                    }
                    Relay relay5 = Relay.this;
                    synchronized (relay5) {
                        relay5.setUpstreamReader(null);
                        relay5.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th2) {
                    Relay relay6 = Relay.this;
                    synchronized (relay6) {
                        relay6.setUpstreamReader(null);
                        relay6.notifyAll();
                        throw th2;
                    }
                }
            }
        }

        @Override // l7.o0
        public r0 timeout() {
            return this.timeout;
        }
    }

    static {
        m mVar = m.f12880d;
        PREFIX_CLEAN = c.e("OkHttp cache v1\n");
        PREFIX_DIRTY = c.e("OkHttp DIRTY :(\n");
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, o0 o0Var, long j, m mVar, long j3, f fVar) {
        this(randomAccessFile, o0Var, j, mVar, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(m mVar, long j, long j3) throws IOException {
        j jVar = new j();
        jVar.w(mVar);
        jVar.Y(j);
        jVar.Y(j3);
        if (jVar.f12868b != FILE_HEADER_SIZE) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        RandomAccessFile randomAccessFile = this.file;
        k.b(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        k.d(channel, "getChannel(...)");
        new FileOperator(channel).write(0L, jVar, FILE_HEADER_SIZE);
    }

    private final void writeMetadata(long j) throws IOException {
        j jVar = new j();
        jVar.w(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        k.b(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        k.d(channel, "getChannel(...)");
        new FileOperator(channel).write(FILE_HEADER_SIZE + j, jVar, this.metadata.d());
    }

    public final void commit(long j) throws IOException {
        writeMetadata(j);
        RandomAccessFile randomAccessFile = this.file;
        k.b(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.d());
        RandomAccessFile randomAccessFile2 = this.file;
        k.b(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        o0 o0Var = this.upstream;
        if (o0Var != null) {
            _UtilCommonKt.closeQuietly(o0Var);
        }
        this.upstream = null;
    }

    public final j getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final o0 getUpstream() {
        return this.upstream;
    }

    public final j getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final m metadata() {
        return this.metadata;
    }

    public final o0 newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z2) {
        this.complete = z2;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i2) {
        this.sourceCount = i2;
    }

    public final void setUpstream(o0 o0Var) {
        this.upstream = o0Var;
    }

    public final void setUpstreamPos(long j) {
        this.upstreamPos = j;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    private Relay(RandomAccessFile randomAccessFile, o0 o0Var, long j, m mVar, long j3) {
        this.file = randomAccessFile;
        this.upstream = o0Var;
        this.upstreamPos = j;
        this.metadata = mVar;
        this.bufferMaxSize = j3;
        this.upstreamBuffer = new j();
        this.complete = o0Var == null;
        this.buffer = new j();
    }
}
