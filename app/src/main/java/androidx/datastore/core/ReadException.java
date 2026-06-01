package androidx.datastore.core;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ReadException<T> extends State<T> {
    private final Throwable readException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadException(Throwable readException, int i2) {
        super(i2, null);
        k.e(readException, "readException");
        this.readException = readException;
    }

    public final Throwable getReadException() {
        return this.readException;
    }
}
