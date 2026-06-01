package e7;

import b7.i;
import d7.g;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements e, c {
    public static /* synthetic */ Object decodeSerializableValue$default(a aVar, b7.b bVar, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableValue");
        }
        if ((i2 & 2) != 0) {
            obj = null;
        }
        return aVar.decodeSerializableValue(bVar, obj);
    }

    @Override // e7.e
    public c beginStructure(g descriptor) {
        k.e(descriptor, "descriptor");
        return this;
    }

    @Override // e7.e
    public boolean decodeBoolean() {
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) objDecodeValue).booleanValue();
    }

    @Override // e7.c
    public final boolean decodeBooleanElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeBoolean();
    }

    @Override // e7.e
    public byte decodeByte() {
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) objDecodeValue).byteValue();
    }

    @Override // e7.c
    public final byte decodeByteElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeByte();
    }

    @Override // e7.e
    public char decodeChar() {
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) objDecodeValue).charValue();
    }

    @Override // e7.c
    public final char decodeCharElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeChar();
    }

    @Override // e7.c
    public int decodeCollectionSize(g descriptor) {
        k.e(descriptor, "descriptor");
        return -1;
    }

    @Override // e7.e
    public double decodeDouble() {
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) objDecodeValue).doubleValue();
    }

    @Override // e7.c
    public final double decodeDoubleElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeDouble();
    }

    @Override // e7.e
    public int decodeEnum(g enumDescriptor) {
        k.e(enumDescriptor, "enumDescriptor");
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeValue).intValue();
    }

    @Override // e7.e
    public float decodeFloat() {
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) objDecodeValue).floatValue();
    }

    @Override // e7.c
    public final float decodeFloatElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeFloat();
    }

    @Override // e7.e
    public e decodeInline(g descriptor) {
        k.e(descriptor, "descriptor");
        return this;
    }

    @Override // e7.c
    public e decodeInlineElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeInline(descriptor.g(i2));
    }

    @Override // e7.e
    public int decodeInt() {
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) objDecodeValue).intValue();
    }

    @Override // e7.c
    public final int decodeIntElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeInt();
    }

    @Override // e7.e
    public long decodeLong() {
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) objDecodeValue).longValue();
    }

    @Override // e7.c
    public final long decodeLongElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeLong();
    }

    @Override // e7.e
    public boolean decodeNotNullMark() {
        return true;
    }

    @Override // e7.e
    public Void decodeNull() {
        return null;
    }

    @Override // e7.c
    public final <T> T decodeNullableSerializableElement(g descriptor, int i2, b7.b deserializer, T t3) {
        k.e(descriptor, "descriptor");
        k.e(deserializer, "deserializer");
        return (deserializer.getDescriptor().b() || decodeNotNullMark()) ? (T) decodeSerializableValue(deserializer, t3) : (T) decodeNull();
    }

    public <T> T decodeNullableSerializableValue(b7.b deserializer) {
        k.e(deserializer, "deserializer");
        return (deserializer.getDescriptor().b() || decodeNotNullMark()) ? (T) decodeSerializableValue(deserializer) : (T) decodeNull();
    }

    @Override // e7.c
    public boolean decodeSequentially() {
        return false;
    }

    @Override // e7.c
    public <T> T decodeSerializableElement(g descriptor, int i2, b7.b deserializer, T t3) {
        k.e(descriptor, "descriptor");
        k.e(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer, t3);
    }

    @Override // e7.e
    public <T> T decodeSerializableValue(b7.b deserializer) {
        k.e(deserializer, "deserializer");
        return (T) deserializer.deserialize(this);
    }

    @Override // e7.e
    public short decodeShort() {
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) objDecodeValue).shortValue();
    }

    @Override // e7.c
    public final short decodeShortElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeShort();
    }

    @Override // e7.e
    public String decodeString() {
        Object objDecodeValue = decodeValue();
        k.c(objDecodeValue, "null cannot be cast to non-null type kotlin.String");
        return (String) objDecodeValue;
    }

    @Override // e7.c
    public final String decodeStringElement(g descriptor, int i2) {
        k.e(descriptor, "descriptor");
        return decodeString();
    }

    public Object decodeValue() {
        throw new i(b0.a(getClass()) + " can't retrieve untyped values");
    }

    @Override // e7.c
    public void endStructure(g descriptor) {
        k.e(descriptor, "descriptor");
    }

    public <T> T decodeSerializableValue(b7.b deserializer, T t3) {
        k.e(deserializer, "deserializer");
        return (T) decodeSerializableValue(deserializer);
    }
}
