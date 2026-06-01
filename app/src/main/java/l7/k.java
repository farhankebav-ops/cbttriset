package l7;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public interface k extends n0, WritableByteChannel {
    k A(int i2);

    k B();

    k C(String str);

    k E(m mVar);

    k G(long j);

    long H(o0 o0Var);

    k Q(long j);

    k S(int i2, int i8, String str);

    OutputStream T();

    @Override // l7.n0, java.io.Flushable
    void flush();

    j getBuffer();

    k write(byte[] bArr);

    k write(byte[] bArr, int i2, int i8);

    k writeByte(int i2);

    k writeInt(int i2);

    k writeShort(int i2);

    k z();
}
