package androidx.emoji2.text.flatbuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b8);

    void put(byte[] bArr, int i2, int i8);

    void putBoolean(boolean z2);

    void putDouble(double d8);

    void putFloat(float f4);

    void putInt(int i2);

    void putLong(long j);

    void putShort(short s7);

    boolean requestCapacity(int i2);

    void set(int i2, byte b8);

    void set(int i2, byte[] bArr, int i8, int i9);

    void setBoolean(int i2, boolean z2);

    void setDouble(int i2, double d8);

    void setFloat(int i2, float f4);

    void setInt(int i2, int i8);

    void setLong(int i2, long j);

    void setShort(int i2, short s7);

    int writePosition();
}
