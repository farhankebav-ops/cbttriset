package androidx.emoji2.text.flatbuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
interface ReadBuf {
    byte[] data();

    byte get(int i2);

    boolean getBoolean(int i2);

    double getDouble(int i2);

    float getFloat(int i2);

    int getInt(int i2);

    long getLong(int i2);

    short getShort(int i2);

    String getString(int i2, int i8);

    int limit();
}
