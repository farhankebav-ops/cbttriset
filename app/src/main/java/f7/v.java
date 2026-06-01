package f7;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f11528a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i1 f11529b = new i1("kotlin.time.Duration", d7.e.j);

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        int i2 = o6.a.f13207d;
        String value = decoder.decodeString();
        kotlin.jvm.internal.k.e(value, "value");
        try {
            return new o6.a(r2.q.h(value));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(a1.a.m("Invalid ISO duration string format: '", value, "'."), e);
        }
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return f11529b;
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        long j = ((o6.a) obj).f13208a;
        int i2 = o6.a.f13207d;
        StringBuilder sb = new StringBuilder();
        if (j < 0) {
            sb.append('-');
        }
        sb.append("PT");
        long j3 = j < 0 ? o6.a.j(j) : j;
        long jI = o6.a.i(j3, o6.c.f13213f);
        boolean z2 = false;
        int i8 = o6.a.f(j3) ? 0 : (int) (o6.a.i(j3, o6.c.e) % ((long) 60));
        int i9 = o6.a.f(j3) ? 0 : (int) (o6.a.i(j3, o6.c.f13212d) % ((long) 60));
        int iE = o6.a.e(j3);
        if (o6.a.f(j)) {
            jI = 9999999999999L;
        }
        boolean z7 = jI != 0;
        boolean z8 = (i9 == 0 && iE == 0) ? false : true;
        if (i8 != 0 || (z8 && z7)) {
            z2 = true;
        }
        if (z7) {
            sb.append(jI);
            sb.append('H');
        }
        if (z2) {
            sb.append(i8);
            sb.append('M');
        }
        if (z8 || (!z7 && !z2)) {
            o6.a.b(sb, i9, iE, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        fVar.encodeString(sb.toString());
    }
}
