package l7;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface l extends o0, ReadableByteChannel {
    String D();

    void F(long j);

    boolean I(long j, m mVar);

    m J(long j);

    long K(j jVar);

    byte[] L();

    boolean M();

    long N(long j, m mVar);

    long O();

    String P(Charset charset);

    m R();

    long U();

    InputStream V();

    boolean c(long j);

    void d(j jVar, long j);

    int f(f0 f0Var);

    j getBuffer();

    String h(long j);

    j0 peek();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    void skip(long j);
}
