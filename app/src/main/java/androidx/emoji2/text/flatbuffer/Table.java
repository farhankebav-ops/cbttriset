package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Table {
    protected ByteBuffer bb;
    protected int bb_pos;
    Utf8 utf8 = Utf8.getDefault();
    private int vtable_size;
    private int vtable_start;

    public static boolean __has_identifier(ByteBuffer byteBuffer, String str) {
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        for (int i2 = 0; i2 < 4; i2++) {
            if (str.charAt(i2) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i2))) {
                return false;
            }
        }
        return true;
    }

    public static int compareStrings(int i2, int i8, ByteBuffer byteBuffer) {
        int i9 = byteBuffer.getInt(i2) + i2;
        int i10 = byteBuffer.getInt(i8) + i8;
        int i11 = byteBuffer.getInt(i9);
        int i12 = byteBuffer.getInt(i10);
        int i13 = i9 + 4;
        int i14 = i10 + 4;
        int iMin = Math.min(i11, i12);
        for (int i15 = 0; i15 < iMin; i15++) {
            int i16 = i15 + i13;
            int i17 = i15 + i14;
            if (byteBuffer.get(i16) != byteBuffer.get(i17)) {
                return byteBuffer.get(i16) - byteBuffer.get(i17);
            }
        }
        return i11 - i12;
    }

    public int __indirect(int i2) {
        return this.bb.getInt(i2) + i2;
    }

    public int __offset(int i2) {
        if (i2 < this.vtable_size) {
            return this.bb.getShort(this.vtable_start + i2);
        }
        return 0;
    }

    public void __reset(int i2, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer == null) {
            this.bb_pos = 0;
            this.vtable_start = 0;
            this.vtable_size = 0;
        } else {
            this.bb_pos = i2;
            int i8 = i2 - byteBuffer.getInt(i2);
            this.vtable_start = i8;
            this.vtable_size = this.bb.getShort(i8);
        }
    }

    public String __string(int i2) {
        return __string(i2, this.bb, this.utf8);
    }

    public Table __union(Table table, int i2) {
        return __union(table, i2, this.bb);
    }

    public int __vector(int i2) {
        int i8 = i2 + this.bb_pos;
        return this.bb.getInt(i8) + i8 + 4;
    }

    public ByteBuffer __vector_as_bytebuffer(int i2, int i8) {
        int i__offset = __offset(i2);
        if (i__offset == 0) {
            return null;
        }
        ByteBuffer byteBufferOrder = this.bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int i__vector = __vector(i__offset);
        byteBufferOrder.position(i__vector);
        byteBufferOrder.limit((__vector_len(i__offset) * i8) + i__vector);
        return byteBufferOrder;
    }

    public ByteBuffer __vector_in_bytebuffer(ByteBuffer byteBuffer, int i2, int i8) {
        int i__offset = __offset(i2);
        if (i__offset == 0) {
            return null;
        }
        int i__vector = __vector(i__offset);
        byteBuffer.rewind();
        byteBuffer.limit((__vector_len(i__offset) * i8) + i__vector);
        byteBuffer.position(i__vector);
        return byteBuffer;
    }

    public int __vector_len(int i2) {
        int i8 = i2 + this.bb_pos;
        return this.bb.getInt(this.bb.getInt(i8) + i8);
    }

    public ByteBuffer getByteBuffer() {
        return this.bb;
    }

    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    public void sortTables(int[] iArr, final ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        Arrays.sort(numArr, new Comparator<Integer>() { // from class: androidx.emoji2.text.flatbuffer.Table.1
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return Table.this.keysCompare(num, num2, byteBuffer);
            }
        });
        for (int i8 = 0; i8 < iArr.length; i8++) {
            iArr[i8] = numArr[i8].intValue();
        }
    }

    public static int __indirect(int i2, ByteBuffer byteBuffer) {
        return byteBuffer.getInt(i2) + i2;
    }

    public static int __offset(int i2, int i8, ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity() - i8;
        return byteBuffer.getShort((i2 + iCapacity) - byteBuffer.getInt(iCapacity)) + iCapacity;
    }

    public static String __string(int i2, ByteBuffer byteBuffer, Utf8 utf8) {
        int i8 = byteBuffer.getInt(i2) + i2;
        return utf8.decodeUtf8(byteBuffer, i8 + 4, byteBuffer.getInt(i8));
    }

    public static Table __union(Table table, int i2, ByteBuffer byteBuffer) {
        table.__reset(__indirect(i2, byteBuffer), byteBuffer);
        return table;
    }

    public static int compareStrings(int i2, byte[] bArr, ByteBuffer byteBuffer) {
        int i8 = byteBuffer.getInt(i2) + i2;
        int i9 = byteBuffer.getInt(i8);
        int length = bArr.length;
        int i10 = i8 + 4;
        int iMin = Math.min(i9, length);
        for (int i11 = 0; i11 < iMin; i11++) {
            int i12 = i11 + i10;
            if (byteBuffer.get(i12) != bArr[i11]) {
                return byteBuffer.get(i12) - bArr[i11];
            }
        }
        return i9 - length;
    }

    public void __reset() {
        __reset(0, null);
    }
}
