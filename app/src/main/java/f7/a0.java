package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a0 implements b7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Enum[] f11415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q5.m f11416b;

    public a0(String str, Enum[] enumArr) {
        this.f11415a = enumArr;
        this.f11416b = n7.b.C(new z(0, this, str));
    }

    @Override // b7.b
    public final Object deserialize(e7.e decoder) {
        kotlin.jvm.internal.k.e(decoder, "decoder");
        int iDecodeEnum = decoder.decodeEnum(getDescriptor());
        Enum[] enumArr = this.f11415a;
        if (iDecodeEnum >= 0 && iDecodeEnum < enumArr.length) {
            return enumArr[iDecodeEnum];
        }
        throw new b7.i(iDecodeEnum + " is not among valid " + getDescriptor().h() + " enum values, values size is " + enumArr.length);
    }

    @Override // b7.j, b7.b
    public final d7.g getDescriptor() {
        return (d7.g) this.f11416b.getValue();
    }

    @Override // b7.j
    public final void serialize(e7.f fVar, Object obj) {
        Enum value = (Enum) obj;
        kotlin.jvm.internal.k.e(value, "value");
        Enum[] enumArr = this.f11415a;
        int iQ0 = r5.j.q0(enumArr, value);
        if (iQ0 != -1) {
            fVar.encodeEnum(getDescriptor(), iQ0);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().h());
        sb.append(", must be one of ");
        String string = Arrays.toString(enumArr);
        kotlin.jvm.internal.k.d(string, "toString(...)");
        sb.append(string);
        throw new b7.i(sb.toString());
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().h() + '>';
    }
}
