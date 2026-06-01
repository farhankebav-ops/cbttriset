package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class StringVector extends BaseVector {
    private Utf8 utf8 = Utf8.getDefault();

    public StringVector __assign(int i2, int i8, ByteBuffer byteBuffer) {
        __reset(i2, i8, byteBuffer);
        return this;
    }

    public String get(int i2) {
        return Table.__string(__element(i2), this.bb, this.utf8);
    }
}
