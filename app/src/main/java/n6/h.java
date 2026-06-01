package n6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements Iterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f13095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13098d;
    public int e;

    public h(CharSequence string) {
        kotlin.jvm.internal.k.e(string, "string");
        this.f13095a = string;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2;
        int i8;
        int i9 = this.f13096b;
        if (i9 != 0) {
            return i9 == 1;
        }
        if (this.e < 0) {
            this.f13096b = 2;
            return false;
        }
        CharSequence charSequence = this.f13095a;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i10 = this.f13097c; i10 < length2; i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i2 = (cCharAt == '\r' && (i8 = i10 + 1) < charSequence.length() && charSequence.charAt(i8) == '\n') ? 2 : 1;
                length = i10;
                this.f13096b = 1;
                this.e = i2;
                this.f13098d = length;
                return true;
            }
        }
        i2 = -1;
        this.f13096b = 1;
        this.e = i2;
        this.f13098d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f13096b = 0;
        int i2 = this.f13098d;
        int i8 = this.f13097c;
        this.f13097c = this.e + i2;
        return this.f13095a.subSequence(i8, i2).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
