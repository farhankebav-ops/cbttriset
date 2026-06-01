package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LongVector extends BaseVector {
    public LongVector __assign(int i2, ByteBuffer byteBuffer) {
        __reset(i2, 8, byteBuffer);
        return this;
    }

    public long get(int i2) {
        return this.bb.getLong(__element(i2));
    }
}
