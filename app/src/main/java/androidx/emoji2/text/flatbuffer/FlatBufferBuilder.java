package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    ByteBuffer bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.buf.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i2) {
            return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i2, ByteBufferFactory byteBufferFactory) {
        this(i2, byteBufferFactory, null, Utf8.getDefault());
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    public static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int iCapacity = byteBuffer.capacity();
        if (((-1073741824) & iCapacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i2 = iCapacity == 0 ? 1 : iCapacity << 1;
        byteBuffer.position(0);
        ByteBuffer byteBufferNewByteBuffer = byteBufferFactory.newByteBuffer(i2);
        byteBufferNewByteBuffer.position(byteBufferNewByteBuffer.clear().capacity() - iCapacity);
        byteBufferNewByteBuffer.put(byteBuffer);
        return byteBufferNewByteBuffer;
    }

    public static boolean isFieldPresent(Table table, int i2) {
        return table.__offset(i2) != 0;
    }

    public void Nested(int i2) {
        if (i2 != offset()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void addBoolean(boolean z2) {
        prep(1, 0);
        putBoolean(z2);
    }

    public void addByte(byte b8) {
        prep(1, 0);
        putByte(b8);
    }

    public void addDouble(double d8) {
        prep(8, 0);
        putDouble(d8);
    }

    public void addFloat(float f4) {
        prep(4, 0);
        putFloat(f4);
    }

    public void addInt(int i2) {
        prep(4, 0);
        putInt(i2);
    }

    public void addLong(long j) {
        prep(8, 0);
        putLong(j);
    }

    public void addOffset(int i2) {
        prep(4, 0);
        putInt((offset() - i2) + 4);
    }

    public void addShort(short s7) {
        prep(2, 0);
        putShort(s7);
    }

    public void addStruct(int i2, int i8, int i9) {
        if (i8 != i9) {
            Nested(i8);
            slot(i2);
        }
    }

    public void clear() {
        this.space = this.bb.capacity();
        this.bb.clear();
        this.minalign = 1;
        while (true) {
            int i2 = this.vtable_in_use;
            if (i2 <= 0) {
                this.vtable_in_use = 0;
                this.nested = false;
                this.finished = false;
                this.object_start = 0;
                this.num_vtables = 0;
                this.vector_num_elems = 0;
                return;
            }
            int[] iArr = this.vtable;
            int i8 = i2 - 1;
            this.vtable_in_use = i8;
            iArr[i8] = 0;
        }
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.bb;
        int i2 = this.space - length;
        this.space = i2;
        byteBuffer.position(i2);
        this.bb.put(bArr);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t3, int[] iArr) {
        t3.sortTables(iArr, this.bb);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int iEncodedLength = this.utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, iEncodedLength, 1);
        ByteBuffer byteBuffer = this.bb;
        int i2 = this.space - iEncodedLength;
        this.space = i2;
        byteBuffer.position(i2);
        this.utf8.encodeUtf8(charSequence, this.bb);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i2, int i8, int i9) {
        int i10 = i2 * i8;
        startVector(i2, i8, i9);
        ByteBuffer byteBuffer = this.bb;
        int i11 = this.space - i10;
        this.space = i11;
        byteBuffer.position(i11);
        ByteBuffer byteBufferOrder = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.limit(i10);
        return byteBufferOrder;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.bb;
    }

    public int endTable() {
        int i2;
        if (this.vtable == null || !this.nested) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        addInt(0);
        int iOffset = offset();
        int i8 = this.vtable_in_use - 1;
        while (i8 >= 0 && this.vtable[i8] == 0) {
            i8--;
        }
        for (int i9 = i8; i9 >= 0; i9--) {
            int i10 = this.vtable[i9];
            addShort((short) (i10 != 0 ? iOffset - i10 : 0));
        }
        addShort((short) (iOffset - this.object_start));
        addShort((short) ((i8 + 3) * 2));
        int i11 = 0;
        loop2: while (true) {
            if (i11 >= this.num_vtables) {
                i2 = 0;
                break;
            }
            int iCapacity = this.bb.capacity() - this.vtables[i11];
            int i12 = this.space;
            short s7 = this.bb.getShort(iCapacity);
            if (s7 == this.bb.getShort(i12)) {
                for (int i13 = 2; i13 < s7; i13 += 2) {
                    if (this.bb.getShort(iCapacity + i13) != this.bb.getShort(i12 + i13)) {
                        break;
                    }
                }
                i2 = this.vtables[i11];
                break loop2;
            }
            i11++;
        }
        if (i2 != 0) {
            int iCapacity2 = this.bb.capacity() - iOffset;
            this.space = iCapacity2;
            this.bb.putInt(iCapacity2, i2 - iOffset);
        } else {
            int i14 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i14 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i14 * 2);
            }
            int[] iArr2 = this.vtables;
            int i15 = this.num_vtables;
            this.num_vtables = i15 + 1;
            iArr2[i15] = offset();
            ByteBuffer byteBuffer = this.bb;
            byteBuffer.putInt(byteBuffer.capacity() - iOffset, offset() - iOffset);
        }
        this.nested = false;
        return iOffset;
    }

    public int endVector() {
        if (!this.nested) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    }

    public void finish(int i2, boolean z2) {
        prep(this.minalign, (z2 ? 4 : 0) + 4);
        addOffset(i2);
        if (z2) {
            addInt(this.bb.capacity() - this.space);
        }
        this.bb.position(this.space);
        this.finished = true;
    }

    public void finishSizePrefixed(int i2) {
        finish(i2, true);
    }

    public void finished() {
        if (!this.finished) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public FlatBufferBuilder forceDefaults(boolean z2) {
        this.force_defaults = z2;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.bb = byteBuffer;
        byteBuffer.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.bb.capacity() - this.space;
    }

    public void pad(int i2) {
        for (int i8 = 0; i8 < i2; i8++) {
            ByteBuffer byteBuffer = this.bb;
            int i9 = this.space - 1;
            this.space = i9;
            byteBuffer.put(i9, (byte) 0);
        }
    }

    public void prep(int i2, int i8) {
        if (i2 > this.minalign) {
            this.minalign = i2;
        }
        int i9 = ((~((this.bb.capacity() - this.space) + i8)) + 1) & (i2 - 1);
        while (this.space < i9 + i2 + i8) {
            int iCapacity = this.bb.capacity();
            ByteBuffer byteBuffer = this.bb;
            ByteBuffer byteBufferGrowByteBuffer = growByteBuffer(byteBuffer, this.bb_factory);
            this.bb = byteBufferGrowByteBuffer;
            if (byteBuffer != byteBufferGrowByteBuffer) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space = (this.bb.capacity() - iCapacity) + this.space;
        }
        pad(i9);
    }

    public void putBoolean(boolean z2) {
        ByteBuffer byteBuffer = this.bb;
        int i2 = this.space - 1;
        this.space = i2;
        byteBuffer.put(i2, z2 ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b8) {
        ByteBuffer byteBuffer = this.bb;
        int i2 = this.space - 1;
        this.space = i2;
        byteBuffer.put(i2, b8);
    }

    public void putDouble(double d8) {
        ByteBuffer byteBuffer = this.bb;
        int i2 = this.space - 8;
        this.space = i2;
        byteBuffer.putDouble(i2, d8);
    }

    public void putFloat(float f4) {
        ByteBuffer byteBuffer = this.bb;
        int i2 = this.space - 4;
        this.space = i2;
        byteBuffer.putFloat(i2, f4);
    }

    public void putInt(int i2) {
        ByteBuffer byteBuffer = this.bb;
        int i8 = this.space - 4;
        this.space = i8;
        byteBuffer.putInt(i8, i2);
    }

    public void putLong(long j) {
        ByteBuffer byteBuffer = this.bb;
        int i2 = this.space - 8;
        this.space = i2;
        byteBuffer.putLong(i2, j);
    }

    public void putShort(short s7) {
        ByteBuffer byteBuffer = this.bb;
        int i2 = this.space - 2;
        this.space = i2;
        byteBuffer.putShort(i2, s7);
    }

    public void required(int i2, int i8) {
        int iCapacity = this.bb.capacity() - i2;
        if (this.bb.getShort((iCapacity - this.bb.getInt(iCapacity)) + i8) == 0) {
            throw new AssertionError(a1.a.h(i8, "FlatBuffers: field ", " must be set"));
        }
    }

    public byte[] sizedByteArray(int i2, int i8) {
        finished();
        byte[] bArr = new byte[i8];
        this.bb.position(i2);
        this.bb.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer byteBufferDuplicate = this.bb.duplicate();
        byteBufferDuplicate.position(this.space);
        byteBufferDuplicate.limit(this.bb.capacity());
        return new ByteBufferBackedInputStream(byteBufferDuplicate);
    }

    public void slot(int i2) {
        this.vtable[i2] = offset();
    }

    public void startTable(int i2) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i2) {
            this.vtable = new int[i2];
        }
        this.vtable_in_use = i2;
        Arrays.fill(this.vtable, 0, i2, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int i2, int i8, int i9) {
        notNested();
        this.vector_num_elems = i8;
        int i10 = i2 * i8;
        prep(4, i10);
        prep(i9, i10);
        this.nested = true;
    }

    public FlatBufferBuilder(int i2, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        i2 = i2 <= 0 ? 1 : i2;
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.bb = byteBuffer;
            byteBuffer.clear();
            this.bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.bb = byteBufferFactory.newByteBuffer(i2);
        }
        this.utf8 = utf8;
        this.space = this.bb.capacity();
    }

    public void addBoolean(int i2, boolean z2, boolean z7) {
        if (this.force_defaults || z2 != z7) {
            addBoolean(z2);
            slot(i2);
        }
    }

    public void addByte(int i2, byte b8, int i8) {
        if (this.force_defaults || b8 != i8) {
            addByte(b8);
            slot(i2);
        }
    }

    public void addDouble(int i2, double d8, double d9) {
        if (this.force_defaults || d8 != d9) {
            addDouble(d8);
            slot(i2);
        }
    }

    public void addFloat(int i2, float f4, double d8) {
        if (this.force_defaults || f4 != d8) {
            addFloat(f4);
            slot(i2);
        }
    }

    public void addInt(int i2, int i8, int i9) {
        if (this.force_defaults || i8 != i9) {
            addInt(i8);
            slot(i2);
        }
    }

    public void addLong(int i2, long j, long j3) {
        if (this.force_defaults || j != j3) {
            addLong(j);
            slot(i2);
        }
    }

    public void addShort(int i2, short s7, int i8) {
        if (this.force_defaults || s7 != i8) {
            addShort(s7);
            slot(i2);
        }
    }

    public void finishSizePrefixed(int i2, String str) {
        finish(i2, str, true);
    }

    public void addOffset(int i2, int i8, int i9) {
        if (this.force_defaults || i8 != i9) {
            addOffset(i8);
            slot(i2);
        }
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.bb.capacity() - this.space);
    }

    public int createByteVector(byte[] bArr, int i2, int i8) {
        startVector(1, i8, 1);
        ByteBuffer byteBuffer = this.bb;
        int i9 = this.space - i8;
        this.space = i9;
        byteBuffer.position(i9);
        this.bb.put(bArr, i2, i8);
        return endVector();
    }

    public void finish(int i2) {
        finish(i2, false);
    }

    public int createString(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i2 = this.space - iRemaining;
        this.space = i2;
        byteBuffer2.position(i2);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i2, String str, boolean z2) {
        prep(this.minalign, (z2 ? 4 : 0) + 8);
        if (str.length() == 4) {
            for (int i8 = 3; i8 >= 0; i8--) {
                addByte((byte) str.charAt(i8));
            }
            finish(i2, z2);
            return;
        }
        throw new AssertionError("FlatBuffers: file identifier must be length 4");
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        startVector(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i2 = this.space - iRemaining;
        this.space = i2;
        byteBuffer2.position(i2);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i2, String str) {
        finish(i2, str, false);
    }

    public FlatBufferBuilder(int i2) {
        this(i2, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i2);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, new HeapByteBufferFactory());
    }
}
