package e7;

import b7.i;
import b7.j;
import d7.g;
import f7.w0;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements f, d {
    @Override // e7.f
    public d beginCollection(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return beginStructure(descriptor);
    }

    @Override // e7.f
    public d beginStructure(g descriptor) {
        k.e(descriptor, "descriptor");
        return this;
    }

    @Override // e7.f
    public void encodeBoolean(boolean z2) {
        encodeValue(Boolean.valueOf(z2));
    }

    @Override // e7.d
    public final void encodeBooleanElement(g descriptor, int i2, boolean z2) {
        k.e(descriptor, "descriptor");
        if (encodeElement(descriptor, i2)) {
            encodeBoolean(z2);
        }
    }

    @Override // e7.f
    public void encodeByte(byte b8) {
        encodeValue(Byte.valueOf(b8));
    }

    @Override // e7.d
    public final void encodeByteElement(g descriptor, int i2, byte b8) {
        k.e(descriptor, "descriptor");
        if (encodeElement(descriptor, i2)) {
            encodeByte(b8);
        }
    }

    @Override // e7.f
    public void encodeChar(char c7) {
        encodeValue(Character.valueOf(c7));
    }

    @Override // e7.d
    public final void encodeCharElement(g descriptor, int i2, char c7) {
        k.e(descriptor, "descriptor");
        if (encodeElement(descriptor, i2)) {
            encodeChar(c7);
        }
    }

    @Override // e7.f
    public void encodeDouble(double d8) {
        encodeValue(Double.valueOf(d8));
    }

    @Override // e7.d
    public final void encodeDoubleElement(g descriptor, int i2, double d8) {
        k.e(descriptor, "descriptor");
        if (encodeElement(descriptor, i2)) {
            encodeDouble(d8);
        }
    }

    public boolean encodeElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return true;
    }

    @Override // e7.f
    public void encodeEnum(g enumDescriptor, int i2) {
        k.e(enumDescriptor, "enumDescriptor");
        encodeValue(Integer.valueOf(i2));
    }

    @Override // e7.f
    public void encodeFloat(float f4) {
        encodeValue(Float.valueOf(f4));
    }

    @Override // e7.d
    public final void encodeFloatElement(g descriptor, int i2, float f4) {
        k.e(descriptor, "descriptor");
        if (encodeElement(descriptor, i2)) {
            encodeFloat(f4);
        }
    }

    @Override // e7.f
    public f encodeInline(g descriptor) {
        k.e(descriptor, "descriptor");
        return this;
    }

    @Override // e7.d
    public final f encodeInlineElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return encodeElement(descriptor, i2) ? encodeInline(descriptor.g(i2)) : w0.f11536a;
    }

    @Override // e7.f
    public void encodeInt(int i2) {
        encodeValue(Integer.valueOf(i2));
    }

    @Override // e7.d
    public final void encodeIntElement(g descriptor, int i2, int i8) {
        k.e(descriptor, "descriptor");
        if (encodeElement(descriptor, i2)) {
            encodeInt(i8);
        }
    }

    @Override // e7.f
    public void encodeLong(long j) {
        encodeValue(Long.valueOf(j));
    }

    @Override // e7.d
    public final void encodeLongElement(g descriptor, int i2, long j) {
        k.e(descriptor, "descriptor");
        if (encodeElement(descriptor, i2)) {
            encodeLong(j);
        }
    }

    @Override // e7.f
    public void encodeNull() {
        throw new i("'null' is not supported by default");
    }

    @Override // e7.d
    public <T> void encodeNullableSerializableElement(g descriptor, int i2, j serializer, T t3) {
        k.e(descriptor, "descriptor");
        k.e(serializer, "serializer");
        if (encodeElement(descriptor, i2)) {
            encodeNullableSerializableValue(serializer, t3);
        }
    }

    public <T> void encodeNullableSerializableValue(j jVar, T t3) {
        q.S(this, jVar, t3);
    }

    @Override // e7.d
    public <T> void encodeSerializableElement(g descriptor, int i2, j serializer, T t3) {
        k.e(descriptor, "descriptor");
        k.e(serializer, "serializer");
        if (encodeElement(descriptor, i2)) {
            encodeSerializableValue(serializer, t3);
        }
    }

    @Override // e7.f
    public void encodeSerializableValue(j serializer, Object obj) {
        k.e(serializer, "serializer");
        serializer.serialize(this, obj);
    }

    @Override // e7.f
    public void encodeShort(short s7) {
        encodeValue(Short.valueOf(s7));
    }

    @Override // e7.d
    public final void encodeShortElement(g descriptor, int i2, short s7) {
        k.e(descriptor, "descriptor");
        if (encodeElement(descriptor, i2)) {
            encodeShort(s7);
        }
    }

    @Override // e7.f
    public void encodeString(String value) {
        k.e(value, "value");
        encodeValue(value);
    }

    @Override // e7.d
    public final void encodeStringElement(g descriptor, int i2, String value) {
        k.e(descriptor, "descriptor");
        k.e(value, "value");
        if (encodeElement(descriptor, i2)) {
            encodeString(value);
        }
    }

    public void encodeValue(Object value) {
        k.e(value, "value");
        throw new i("Non-serializable " + b0.a(value.getClass()) + " is not supported by " + b0.a(getClass()) + " encoder");
    }

    @Override // e7.d
    public void endStructure(g descriptor) {
        k.e(descriptor, "descriptor");
    }

    public boolean shouldEncodeElementDefault(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return true;
    }

    @Override // e7.f
    public void encodeNotNullMark() {
    }
}
