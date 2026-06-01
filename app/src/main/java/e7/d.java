package e7;

import b7.j;
import d7.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface d {
    void encodeBooleanElement(g gVar, int i2, boolean z2);

    void encodeByteElement(g gVar, int i2, byte b8);

    void encodeCharElement(g gVar, int i2, char c7);

    void encodeDoubleElement(g gVar, int i2, double d8);

    void encodeFloatElement(g gVar, int i2, float f4);

    f encodeInlineElement(g gVar, int i2);

    void encodeIntElement(g gVar, int i2, int i8);

    void encodeLongElement(g gVar, int i2, long j);

    void encodeNullableSerializableElement(g gVar, int i2, j jVar, Object obj);

    void encodeSerializableElement(g gVar, int i2, j jVar, Object obj);

    void encodeShortElement(g gVar, int i2, short s7);

    void encodeStringElement(g gVar, int i2, String str);

    void endStructure(g gVar);

    boolean shouldEncodeElementDefault(g gVar, int i2);
}
