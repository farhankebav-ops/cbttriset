package e7;

import d7.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface c {
    boolean decodeBooleanElement(g gVar, int i2);

    byte decodeByteElement(g gVar, int i2);

    char decodeCharElement(g gVar, int i2);

    int decodeCollectionSize(g gVar);

    double decodeDoubleElement(g gVar, int i2);

    int decodeElementIndex(g gVar);

    float decodeFloatElement(g gVar, int i2);

    e decodeInlineElement(g gVar, int i2);

    int decodeIntElement(g gVar, int i2);

    long decodeLongElement(g gVar, int i2);

    Object decodeNullableSerializableElement(g gVar, int i2, b7.b bVar, Object obj);

    boolean decodeSequentially();

    Object decodeSerializableElement(g gVar, int i2, b7.b bVar, Object obj);

    short decodeShortElement(g gVar, int i2);

    String decodeStringElement(g gVar, int i2);

    void endStructure(g gVar);

    i7.f getSerializersModule();
}
