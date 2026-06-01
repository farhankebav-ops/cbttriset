package k6;

import java.util.NoSuchElementException;
import r5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12715d;

    public c(int i2, int i8, int i9) {
        this.f12712a = i9;
        this.f12713b = i8;
        boolean z2 = false;
        if (i9 <= 0 ? i2 >= i8 : i2 <= i8) {
            z2 = true;
        }
        this.f12714c = z2;
        this.f12715d = z2 ? i2 : i8;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12714c;
    }

    @Override // r5.v
    public final int nextInt() {
        int i2 = this.f12715d;
        if (i2 != this.f12713b) {
            this.f12715d = this.f12712a + i2;
            return i2;
        }
        if (!this.f12714c) {
            throw new NoSuchElementException();
        }
        this.f12714c = false;
        return i2;
    }
}
