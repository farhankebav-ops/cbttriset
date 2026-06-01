package e7;

import b7.j;
import d7.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface f {
    d beginCollection(g gVar, int i2);

    d beginStructure(g gVar);

    void encodeBoolean(boolean z2);

    void encodeByte(byte b8);

    void encodeChar(char c7);

    void encodeDouble(double d8);

    void encodeEnum(g gVar, int i2);

    void encodeFloat(float f4);

    f encodeInline(g gVar);

    void encodeInt(int i2);

    void encodeLong(long j);

    void encodeNotNullMark();

    void encodeNull();

    void encodeSerializableValue(j jVar, Object obj);

    void encodeShort(short s7);

    void encodeString(String str);

    i7.f getSerializersModule();
}
