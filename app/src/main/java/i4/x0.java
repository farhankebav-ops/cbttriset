package i4;

import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BitSet f11971d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f11973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11974c;

    static {
        BitSet bitSet = new BitSet(127);
        bitSet.set(45);
        bitSet.set(95);
        bitSet.set(46);
        for (char c7 = '0'; c7 <= '9'; c7 = (char) (c7 + 1)) {
            bitSet.set(c7);
        }
        for (char c8 = 'a'; c8 <= 'z'; c8 = (char) (c8 + 1)) {
            bitSet.set(c8);
        }
        f11971d = bitSet;
    }

    public x0(Object obj, String str, boolean z2) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        r2.q.D(lowerCase, "name");
        r2.q.y(!lowerCase.isEmpty(), "token must have at least 1 tchar");
        if (lowerCase.equals("connection")) {
            a1.f11817c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
        }
        for (int i2 = 0; i2 < lowerCase.length(); i2++) {
            char cCharAt = lowerCase.charAt(i2);
            if ((!z2 || cCharAt != ':' || i2 != 0) && !f11971d.get(cCharAt)) {
                throw new IllegalArgumentException(a.a.K("Invalid character '%s' in key name '%s'", Character.valueOf(cCharAt), lowerCase));
            }
        }
        this.f11972a = lowerCase;
        this.f11973b = lowerCase.getBytes(e2.d.f11227a);
        this.f11974c = obj;
    }

    public abstract Object a(byte[] bArr);

    public abstract byte[] b(Object obj);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f11972a.equals(((x0) obj).f11972a);
    }

    public final int hashCode() {
        return this.f11972a.hashCode();
    }

    public final String toString() {
        return a1.a.r(new StringBuilder("Key{name='"), this.f11972a, "'}");
    }
}
