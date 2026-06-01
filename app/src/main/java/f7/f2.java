package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f2 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f2 f11453a = new f2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i1 f11454b = new i1("kotlin.uuid.Uuid", d7.e.j);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        String strConcat;
        kotlin.jvm.internal.k.e(decoder, "decoder");
        String uuidString = decoder.decodeString();
        kotlin.jvm.internal.k.e(uuidString, "uuidString");
        int length = uuidString.length();
        if (length == 32) {
            long jB = n6.d.b(0, 16, uuidString);
            long jB2 = n6.d.b(16, 32, uuidString);
            if (jB != 0 || jB2 != 0) {
                return new p6.a(jB, jB2);
            }
        } else {
            if (length != 36) {
                StringBuilder sb = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                if (uuidString.length() <= 64) {
                    strConcat = uuidString;
                } else {
                    String strSubstring = uuidString.substring(0, 64);
                    kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
                    strConcat = strSubstring.concat("...");
                }
                sb.append(strConcat);
                sb.append("\" of length ");
                sb.append(uuidString.length());
                throw new IllegalArgumentException(sb.toString());
            }
            long jB3 = n6.d.b(0, 8, uuidString);
            r2.q.C(8, uuidString);
            long jB4 = n6.d.b(9, 13, uuidString);
            r2.q.C(13, uuidString);
            long jB5 = n6.d.b(14, 18, uuidString);
            r2.q.C(18, uuidString);
            long jB6 = n6.d.b(19, 23, uuidString);
            r2.q.C(23, uuidString);
            long j = (jB4 << 16) | (jB3 << 32) | jB5;
            long jB7 = n6.d.b(24, 36, uuidString) | (jB6 << 48);
            if (j != 0 || jB7 != 0) {
                return new p6.a(j, jB7);
            }
        }
        return p6.a.f13338c;
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11454b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        p6.a value = (p6.a) obj;
        kotlin.jvm.internal.k.e(value, "value");
        fVar.encodeString(value.toString());
    }
}
