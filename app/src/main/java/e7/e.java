package e7;

import d7.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface e {
    c beginStructure(g gVar);

    boolean decodeBoolean();

    byte decodeByte();

    char decodeChar();

    double decodeDouble();

    int decodeEnum(g gVar);

    float decodeFloat();

    e decodeInline(g gVar);

    int decodeInt();

    long decodeLong();

    boolean decodeNotNullMark();

    Void decodeNull();

    Object decodeSerializableValue(b7.b bVar);

    short decodeShort();

    String decodeString();

    i7.f getSerializersModule();
}
