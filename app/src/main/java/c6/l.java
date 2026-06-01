package c6;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l implements Iterator, f6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f4238c;

    public l(m mVar) {
        this.f4238c = mVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws IOException {
        if (this.f4236a == null && !this.f4237b) {
            String line = ((BufferedReader) this.f4238c.f4240b).readLine();
            this.f4236a = line;
            if (line == null) {
                this.f4237b = true;
            }
        }
        return this.f4236a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.f4236a;
        this.f4236a = null;
        kotlin.jvm.internal.k.b(str);
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
