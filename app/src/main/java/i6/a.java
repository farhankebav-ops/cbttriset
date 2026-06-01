package i6;

import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends d {
    @Override // i6.d
    public final int a(int i2) {
        return ((-i2) >> 31) & (f().nextInt() >>> (32 - i2));
    }

    @Override // i6.d
    public final int b() {
        return f().nextInt();
    }

    @Override // i6.d
    public final int c(int i2) {
        return f().nextInt(i2);
    }

    @Override // i6.d
    public final long d() {
        return f().nextLong();
    }

    public abstract Random f();
}
