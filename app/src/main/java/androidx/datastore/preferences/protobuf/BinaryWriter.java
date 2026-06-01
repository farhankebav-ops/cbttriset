package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.Utf8;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import okhttp3.internal.http2.Http2Stream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;
    private final BufferAllocator alloc;
    final ArrayDeque<AllocatedBuffer> buffers;
    private final int chunkSize;
    int totalDoneBytes;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.BinaryWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private int limitMinusOne;
        private int pos;

        public SafeDirectWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        private void writeVarint32FiveBytes(int i2) {
            ByteBuffer byteBuffer = this.buffer;
            int i8 = this.pos;
            this.pos = i8 - 1;
            byteBuffer.put(i8, (byte) (i2 >>> 28));
            int i9 = this.pos;
            this.pos = i9 - 4;
            this.buffer.putInt(i9 - 3, (i2 & 127) | 128 | ((((i2 >>> 21) & 127) | 128) << 24) | ((((i2 >>> 14) & 127) | 128) << 16) | ((((i2 >>> 7) & 127) | 128) << 8));
        }

        private void writeVarint32FourBytes(int i2) {
            int i8 = this.pos;
            this.pos = i8 - 4;
            this.buffer.putInt(i8 - 3, (i2 & 127) | 128 | ((266338304 & i2) << 3) | (((2080768 & i2) | 2097152) << 2) | (((i2 & 16256) | 16384) << 1));
        }

        private void writeVarint32OneByte(int i2) {
            ByteBuffer byteBuffer = this.buffer;
            int i8 = this.pos;
            this.pos = i8 - 1;
            byteBuffer.put(i8, (byte) i2);
        }

        private void writeVarint32ThreeBytes(int i2) {
            int i8 = this.pos - 3;
            this.pos = i8;
            this.buffer.putInt(i8, (((i2 & 127) | 128) << 8) | ((2080768 & i2) << 10) | (((i2 & 16256) | 16384) << 9));
        }

        private void writeVarint32TwoBytes(int i2) {
            int i8 = this.pos;
            this.pos = i8 - 2;
            this.buffer.putShort(i8 - 1, (short) ((i2 & 127) | 128 | ((i2 & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long j) {
            int i2 = this.pos;
            this.pos = i2 - 8;
            this.buffer.putLong(i2 - 7, (j & 127) | 128 | ((71494644084506624L & j) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | 2097152) << 2) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 1));
        }

        private void writeVarint64EightBytesWithSign(long j) {
            int i2 = this.pos;
            this.pos = i2 - 8;
            this.buffer.putLong(i2 - 7, (j & 127) | 128 | (((71494644084506624L & j) | 72057594037927936L) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | 2097152) << 2) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 1));
        }

        private void writeVarint64FiveBytes(long j) {
            int i2 = this.pos;
            this.pos = i2 - 5;
            this.buffer.putLong(i2 - 7, (((j & 127) | 128) << 24) | ((34091302912L & j) << 28) | (((266338304 & j) | 268435456) << 27) | (((2080768 & j) | 2097152) << 26) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 25));
        }

        private void writeVarint64FourBytes(long j) {
            writeVarint32FourBytes((int) j);
        }

        private void writeVarint64NineBytes(long j) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, (byte) (j >>> 56));
            writeVarint64EightBytesWithSign(j & 72057594037927935L);
        }

        private void writeVarint64OneByte(long j) {
            writeVarint32OneByte((int) j);
        }

        private void writeVarint64SevenBytes(long j) {
            int i2 = this.pos - 7;
            this.pos = i2;
            this.buffer.putLong(i2, (((j & 127) | 128) << 8) | ((558551906910208L & j) << 14) | (((4363686772736L & j) | 4398046511104L) << 13) | (((34091302912L & j) | 34359738368L) << 12) | (((266338304 & j) | 268435456) << 11) | (((2080768 & j) | 2097152) << 10) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 9));
        }

        private void writeVarint64SixBytes(long j) {
            int i2 = this.pos;
            this.pos = i2 - 6;
            this.buffer.putLong(i2 - 7, (((j & 127) | 128) << 16) | ((4363686772736L & j) << 21) | (((34091302912L & j) | 34359738368L) << 20) | (((266338304 & j) | 268435456) << 19) | (((2080768 & j) | 2097152) << 18) | (((16256 & j) | Http2Stream.EMIT_BUFFER_SIZE) << 17));
        }

        private void writeVarint64TenBytes(long j) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, (byte) (j >>> 63));
            ByteBuffer byteBuffer2 = this.buffer;
            int i8 = this.pos;
            this.pos = i8 - 1;
            byteBuffer2.put(i8, (byte) (((j >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(j & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long j) {
            writeVarint32ThreeBytes((int) j);
        }

        private void writeVarint64TwoBytes(long j) {
            writeVarint32TwoBytes((int) j);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                Java8Compatibility.position(this.buffer, this.pos + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void requireSpace(int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte b8) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, b8);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeBool(int i2, boolean z2) {
            requireSpace(6);
            write(z2 ? (byte) 1 : (byte) 0);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeBytes(int i2, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i2, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int i2) {
            writeTag(i2, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeFixed32(int i2, int i8) {
            requireSpace(9);
            writeFixed32(i8);
            writeTag(i2, 5);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeFixed64(int i2, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i2, 1);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        @Deprecated
        public void writeGroup(int i2, Object obj) throws IOException {
            writeTag(i2, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeInt32(int i2, int i8) {
            requireSpace(15);
            writeInt32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i2, int i8) {
            if (spaceLeft() < i8) {
                this.totalDoneBytes += i8;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i2, i8));
                nextBuffer();
            } else {
                int i9 = this.pos - i8;
                this.pos = i9;
                Java8Compatibility.position(this.buffer, i9 + 1);
                this.buffer.put(bArr, i2, i8);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeMessage(int i2, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeSInt32(int i2, int i8) {
            requireSpace(10);
            writeSInt32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeSInt64(int i2, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int i2) {
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeString(int i2, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeTag(int i2, int i8) {
            writeVarint32(WireFormat.makeTag(i2, i8));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeUInt32(int i2, int i8) {
            requireSpace(10);
            writeVarint32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeUInt64(int i2, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeVarint32(int i2) {
            if ((i2 & (-128)) == 0) {
                writeVarint32OneByte(i2);
                return;
            }
            if ((i2 & (-16384)) == 0) {
                writeVarint32TwoBytes(i2);
                return;
            }
            if (((-2097152) & i2) == 0) {
                writeVarint32ThreeBytes(i2);
            } else if (((-268435456) & i2) == 0) {
                writeVarint32FourBytes(i2);
            } else {
                writeVarint32FiveBytes(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    break;
                case 2:
                    writeVarint64TwoBytes(j);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j);
                    break;
                case 4:
                    writeVarint64FourBytes(j);
                    break;
                case 5:
                    writeVarint64FiveBytes(j);
                    break;
                case 6:
                    writeVarint64SixBytes(j);
                    break;
                case 7:
                    writeVarint64SevenBytes(j);
                    break;
                case 8:
                    writeVarint64EightBytes(j);
                    break;
                case 9:
                    writeVarint64NineBytes(j);
                    break;
                case 10:
                    writeVarint64TenBytes(j);
                    break;
            }
        }

        private void nextBuffer(int i2) {
            nextBuffer(newDirectBuffer(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte[] bArr, int i2, int i8) {
            if (spaceLeft() < i8) {
                nextBuffer(i8);
            }
            int i9 = this.pos - i8;
            this.pos = i9;
            Java8Compatibility.position(this.buffer, i9 + 1);
            this.buffer.put(bArr, i2, i8);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer byteBufferNioBuffer = allocatedBuffer.nioBuffer();
                if (byteBufferNioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = byteBufferNioBuffer;
                    Java8Compatibility.limit(byteBufferNioBuffer, byteBufferNioBuffer.capacity());
                    Java8Compatibility.position(this.buffer, 0);
                    this.buffer.order(ByteOrder.LITTLE_ENDIAN);
                    int iLimit = this.buffer.limit() - 1;
                    this.limitMinusOne = iLimit;
                    this.pos = iLimit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeBool(boolean z2) {
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeFixed32(int i2) {
            int i8 = this.pos;
            this.pos = i8 - 4;
            this.buffer.putInt(i8 - 3, i2);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeFixed64(long j) {
            int i2 = this.pos;
            this.pos = i2 - 8;
            this.buffer.putLong(i2 - 7, j);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeGroup(int i2, Object obj, Schema schema) throws IOException {
            writeTag(i2, 4);
            schema.writeTo(obj, this);
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeInt32(int i2) {
            if (i2 >= 0) {
                writeVarint32(i2);
            } else {
                writeVarint64(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeSInt32(int i2) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                nextBuffer(iRemaining);
            }
            int i2 = this.pos - iRemaining;
            this.pos = i2;
            Java8Compatibility.position(this.buffer, i2 + 1);
            this.buffer.put(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeMessage(int i2, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeString(String str) {
            int i2;
            int i8;
            int i9;
            char cCharAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (cCharAt = str.charAt(length)) < 128) {
                this.buffer.put(this.pos + length, (byte) cCharAt);
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128 && (i9 = this.pos) >= 0) {
                    ByteBuffer byteBuffer = this.buffer;
                    this.pos = i9 - 1;
                    byteBuffer.put(i9, (byte) cCharAt2);
                } else if (cCharAt2 < 2048 && (i8 = this.pos) > 0) {
                    ByteBuffer byteBuffer2 = this.buffer;
                    this.pos = i8 - 1;
                    byteBuffer2.put(i8, (byte) ((cCharAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.buffer;
                    int i10 = this.pos;
                    this.pos = i10 - 1;
                    byteBuffer3.put(i10, (byte) ((cCharAt2 >>> 6) | 960));
                } else if ((cCharAt2 < 55296 || 57343 < cCharAt2) && (i2 = this.pos) > 1) {
                    ByteBuffer byteBuffer4 = this.buffer;
                    this.pos = i2 - 1;
                    byteBuffer4.put(i2, (byte) ((cCharAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.buffer;
                    int i11 = this.pos;
                    this.pos = i11 - 1;
                    byteBuffer5.put(i11, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.buffer;
                    int i12 = this.pos;
                    this.pos = i12 - 1;
                    byteBuffer6.put(i12, (byte) ((cCharAt2 >>> '\f') | 480));
                } else {
                    if (this.pos > 2) {
                        if (length != 0) {
                            char cCharAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                ByteBuffer byteBuffer7 = this.buffer;
                                int i13 = this.pos;
                                this.pos = i13 - 1;
                                byteBuffer7.put(i13, (byte) ((codePoint & 63) | 128));
                                ByteBuffer byteBuffer8 = this.buffer;
                                int i14 = this.pos;
                                this.pos = i14 - 1;
                                byteBuffer8.put(i14, (byte) (((codePoint >>> 6) & 63) | 128));
                                ByteBuffer byteBuffer9 = this.buffer;
                                int i15 = this.pos;
                                this.pos = i15 - 1;
                                byteBuffer9.put(i15, (byte) (((codePoint >>> 12) & 63) | 128));
                                ByteBuffer byteBuffer10 = this.buffer;
                                int i16 = this.pos;
                                this.pos = i16 - 1;
                                byteBuffer10.put(i16, (byte) ((codePoint >>> 18) | 240));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            } else {
                int i2 = this.pos - iRemaining;
                this.pos = i2;
                Java8Compatibility.position(this.buffer, i2 + 1);
                this.buffer.put(byteBuffer);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private int limit;
        private int limitMinusOne;
        private int offset;
        private int offsetMinusOne;
        private int pos;

        public SafeHeapWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i2) {
            byte[] bArr = this.buffer;
            int i8 = this.pos;
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) (i2 >>> 28);
            int i10 = i8 - 2;
            this.pos = i10;
            bArr[i9] = (byte) (((i2 >>> 21) & 127) | 128);
            int i11 = i8 - 3;
            this.pos = i11;
            bArr[i10] = (byte) (((i2 >>> 14) & 127) | 128);
            int i12 = i8 - 4;
            this.pos = i12;
            bArr[i11] = (byte) (((i2 >>> 7) & 127) | 128);
            this.pos = i8 - 5;
            bArr[i12] = (byte) ((i2 & 127) | 128);
        }

        private void writeVarint32FourBytes(int i2) {
            byte[] bArr = this.buffer;
            int i8 = this.pos;
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) (i2 >>> 21);
            int i10 = i8 - 2;
            this.pos = i10;
            bArr[i9] = (byte) (((i2 >>> 14) & 127) | 128);
            int i11 = i8 - 3;
            this.pos = i11;
            bArr[i10] = (byte) (((i2 >>> 7) & 127) | 128);
            this.pos = i8 - 4;
            bArr[i11] = (byte) ((i2 & 127) | 128);
        }

        private void writeVarint32OneByte(int i2) {
            byte[] bArr = this.buffer;
            int i8 = this.pos;
            this.pos = i8 - 1;
            bArr[i8] = (byte) i2;
        }

        private void writeVarint32ThreeBytes(int i2) {
            byte[] bArr = this.buffer;
            int i8 = this.pos;
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) (i2 >>> 14);
            int i10 = i8 - 2;
            this.pos = i10;
            bArr[i9] = (byte) (((i2 >>> 7) & 127) | 128);
            this.pos = i8 - 3;
            bArr[i10] = (byte) ((i2 & 127) | 128);
        }

        private void writeVarint32TwoBytes(int i2) {
            byte[] bArr = this.buffer;
            int i8 = this.pos;
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) (i2 >>> 7);
            this.pos = i8 - 2;
            bArr[i9] = (byte) ((i2 & 127) | 128);
        }

        private void writeVarint64EightBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (j >>> 49);
            int i9 = i2 - 2;
            this.pos = i9;
            bArr[i8] = (byte) (((j >>> 42) & 127) | 128);
            int i10 = i2 - 3;
            this.pos = i10;
            bArr[i9] = (byte) (((j >>> 35) & 127) | 128);
            int i11 = i2 - 4;
            this.pos = i11;
            bArr[i10] = (byte) (((j >>> 28) & 127) | 128);
            int i12 = i2 - 5;
            this.pos = i12;
            bArr[i11] = (byte) (((j >>> 21) & 127) | 128);
            int i13 = i2 - 6;
            this.pos = i13;
            bArr[i12] = (byte) (((j >>> 14) & 127) | 128);
            int i14 = i2 - 7;
            this.pos = i14;
            bArr[i13] = (byte) (((j >>> 7) & 127) | 128);
            this.pos = i2 - 8;
            bArr[i14] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64FiveBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (j >>> 28);
            int i9 = i2 - 2;
            this.pos = i9;
            bArr[i8] = (byte) (((j >>> 21) & 127) | 128);
            int i10 = i2 - 3;
            this.pos = i10;
            bArr[i9] = (byte) (((j >>> 14) & 127) | 128);
            int i11 = i2 - 4;
            this.pos = i11;
            bArr[i10] = (byte) (((j >>> 7) & 127) | 128);
            this.pos = i2 - 5;
            bArr[i11] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64FourBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (j >>> 21);
            int i9 = i2 - 2;
            this.pos = i9;
            bArr[i8] = (byte) (((j >>> 14) & 127) | 128);
            int i10 = i2 - 3;
            this.pos = i10;
            bArr[i9] = (byte) (((j >>> 7) & 127) | 128);
            this.pos = i2 - 4;
            bArr[i10] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64NineBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (j >>> 56);
            int i9 = i2 - 2;
            this.pos = i9;
            bArr[i8] = (byte) (((j >>> 49) & 127) | 128);
            int i10 = i2 - 3;
            this.pos = i10;
            bArr[i9] = (byte) (((j >>> 42) & 127) | 128);
            int i11 = i2 - 4;
            this.pos = i11;
            bArr[i10] = (byte) (((j >>> 35) & 127) | 128);
            int i12 = i2 - 5;
            this.pos = i12;
            bArr[i11] = (byte) (((j >>> 28) & 127) | 128);
            int i13 = i2 - 6;
            this.pos = i13;
            bArr[i12] = (byte) (((j >>> 21) & 127) | 128);
            int i14 = i2 - 7;
            this.pos = i14;
            bArr[i13] = (byte) (((j >>> 14) & 127) | 128);
            int i15 = i2 - 8;
            this.pos = i15;
            bArr[i14] = (byte) (((j >>> 7) & 127) | 128);
            this.pos = i2 - 9;
            bArr[i15] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64OneByte(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) j;
        }

        private void writeVarint64SevenBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (j >>> 42);
            int i9 = i2 - 2;
            this.pos = i9;
            bArr[i8] = (byte) (((j >>> 35) & 127) | 128);
            int i10 = i2 - 3;
            this.pos = i10;
            bArr[i9] = (byte) (((j >>> 28) & 127) | 128);
            int i11 = i2 - 4;
            this.pos = i11;
            bArr[i10] = (byte) (((j >>> 21) & 127) | 128);
            int i12 = i2 - 5;
            this.pos = i12;
            bArr[i11] = (byte) (((j >>> 14) & 127) | 128);
            int i13 = i2 - 6;
            this.pos = i13;
            bArr[i12] = (byte) (((j >>> 7) & 127) | 128);
            this.pos = i2 - 7;
            bArr[i13] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64SixBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (j >>> 35);
            int i9 = i2 - 2;
            this.pos = i9;
            bArr[i8] = (byte) (((j >>> 28) & 127) | 128);
            int i10 = i2 - 3;
            this.pos = i10;
            bArr[i9] = (byte) (((j >>> 21) & 127) | 128);
            int i11 = i2 - 4;
            this.pos = i11;
            bArr[i10] = (byte) (((j >>> 14) & 127) | 128);
            int i12 = i2 - 5;
            this.pos = i12;
            bArr[i11] = (byte) (((j >>> 7) & 127) | 128);
            this.pos = i2 - 6;
            bArr[i12] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64TenBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (j >>> 63);
            int i9 = i2 - 2;
            this.pos = i9;
            bArr[i8] = (byte) (((j >>> 56) & 127) | 128);
            int i10 = i2 - 3;
            this.pos = i10;
            bArr[i9] = (byte) (((j >>> 49) & 127) | 128);
            int i11 = i2 - 4;
            this.pos = i11;
            bArr[i10] = (byte) (((j >>> 42) & 127) | 128);
            int i12 = i2 - 5;
            this.pos = i12;
            bArr[i11] = (byte) (((j >>> 35) & 127) | 128);
            int i13 = i2 - 6;
            this.pos = i13;
            bArr[i12] = (byte) (((j >>> 28) & 127) | 128);
            int i14 = i2 - 7;
            this.pos = i14;
            bArr[i13] = (byte) (((j >>> 21) & 127) | 128);
            int i15 = i2 - 8;
            this.pos = i15;
            bArr[i14] = (byte) (((j >>> 14) & 127) | 128);
            int i16 = i2 - 9;
            this.pos = i16;
            bArr[i15] = (byte) (((j >>> 7) & 127) | 128);
            this.pos = i2 - 10;
            bArr[i16] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (((int) j) >>> 14);
            int i9 = i2 - 2;
            this.pos = i9;
            bArr[i8] = (byte) (((j >>> 7) & 127) | 128);
            this.pos = i2 - 3;
            bArr[i9] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64TwoBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (j >>> 7);
            this.pos = i2 - 2;
            bArr[i8] = (byte) ((((int) j) & 127) | 128);
        }

        public int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                AllocatedBuffer allocatedBuffer = this.allocatedBuffer;
                allocatedBuffer.position((this.pos - allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void requireSpace(int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
        }

        public int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte b8) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = b8;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeBool(int i2, boolean z2) throws IOException {
            requireSpace(6);
            write(z2 ? (byte) 1 : (byte) 0);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeBytes(int i2, ByteString byteString) throws IOException {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i2, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeEndGroup(int i2) {
            writeTag(i2, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeFixed32(int i2, int i8) throws IOException {
            requireSpace(9);
            writeFixed32(i8);
            writeTag(i2, 5);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeFixed64(int i2, long j) throws IOException {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i2, 1);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        @Deprecated
        public void writeGroup(int i2, Object obj) throws IOException {
            writeTag(i2, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeInt32(int i2, int i8) throws IOException {
            requireSpace(15);
            writeInt32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i2, int i8) {
            if (spaceLeft() < i8) {
                this.totalDoneBytes += i8;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i2, i8));
                nextBuffer();
            } else {
                int i9 = this.pos - i8;
                this.pos = i9;
                System.arraycopy(bArr, i2, this.buffer, i9 + 1, i8);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeMessage(int i2, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeSInt32(int i2, int i8) throws IOException {
            requireSpace(10);
            writeSInt32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeSInt64(int i2, long j) throws IOException {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeStartGroup(int i2) {
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeString(int i2, String str) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeTag(int i2, int i8) {
            writeVarint32(WireFormat.makeTag(i2, i8));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeUInt32(int i2, int i8) throws IOException {
            requireSpace(10);
            writeVarint32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeUInt64(int i2, long j) throws IOException {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeVarint32(int i2) {
            if ((i2 & (-128)) == 0) {
                writeVarint32OneByte(i2);
                return;
            }
            if ((i2 & (-16384)) == 0) {
                writeVarint32TwoBytes(i2);
                return;
            }
            if (((-2097152) & i2) == 0) {
                writeVarint32ThreeBytes(i2);
            } else if (((-268435456) & i2) == 0) {
                writeVarint32FourBytes(i2);
            } else {
                writeVarint32FiveBytes(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    break;
                case 2:
                    writeVarint64TwoBytes(j);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j);
                    break;
                case 4:
                    writeVarint64FourBytes(j);
                    break;
                case 5:
                    writeVarint64FiveBytes(j);
                    break;
                case 6:
                    writeVarint64SixBytes(j);
                    break;
                case 7:
                    writeVarint64SevenBytes(j);
                    break;
                case 8:
                    writeVarint64EightBytes(j);
                    break;
                case 9:
                    writeVarint64NineBytes(j);
                    break;
                case 10:
                    writeVarint64TenBytes(j);
                    break;
            }
        }

        private void nextBuffer(int i2) {
            nextBuffer(newHeapBuffer(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte[] bArr, int i2, int i8) {
            if (spaceLeft() < i8) {
                nextBuffer(i8);
            }
            int i9 = this.pos - i8;
            this.pos = i9;
            System.arraycopy(bArr, i2, this.buffer, i9 + 1, i8);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer);
                this.allocatedBuffer = allocatedBuffer;
                this.buffer = allocatedBuffer.array();
                int iArrayOffset = allocatedBuffer.arrayOffset();
                this.limit = allocatedBuffer.limit() + iArrayOffset;
                int iPosition = iArrayOffset + allocatedBuffer.position();
                this.offset = iPosition;
                this.offsetMinusOne = iPosition - 1;
                int i2 = this.limit - 1;
                this.limitMinusOne = i2;
                this.pos = i2;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeBool(boolean z2) {
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeFixed32(int i2) {
            byte[] bArr = this.buffer;
            int i8 = this.pos;
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) ((i2 >> 24) & 255);
            int i10 = i8 - 2;
            this.pos = i10;
            bArr[i9] = (byte) ((i2 >> 16) & 255);
            int i11 = i8 - 3;
            this.pos = i11;
            bArr[i10] = (byte) ((i2 >> 8) & 255);
            this.pos = i8 - 4;
            bArr[i11] = (byte) (i2 & 255);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeFixed64(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i8 = i2 - 1;
            this.pos = i8;
            bArr[i2] = (byte) (((int) (j >> 56)) & 255);
            int i9 = i2 - 2;
            this.pos = i9;
            bArr[i8] = (byte) (((int) (j >> 48)) & 255);
            int i10 = i2 - 3;
            this.pos = i10;
            bArr[i9] = (byte) (((int) (j >> 40)) & 255);
            int i11 = i2 - 4;
            this.pos = i11;
            bArr[i10] = (byte) (((int) (j >> 32)) & 255);
            int i12 = i2 - 5;
            this.pos = i12;
            bArr[i11] = (byte) (((int) (j >> 24)) & 255);
            int i13 = i2 - 6;
            this.pos = i13;
            bArr[i12] = (byte) (((int) (j >> 16)) & 255);
            int i14 = i2 - 7;
            this.pos = i14;
            bArr[i13] = (byte) (((int) (j >> 8)) & 255);
            this.pos = i2 - 8;
            bArr[i14] = (byte) (((int) j) & 255);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeGroup(int i2, Object obj, Schema schema) throws IOException {
            writeTag(i2, 4);
            schema.writeTo(obj, this);
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeInt32(int i2) {
            if (i2 >= 0) {
                writeVarint32(i2);
            } else {
                writeVarint64(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeSInt32(int i2) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                nextBuffer(iRemaining);
            }
            int i2 = this.pos - iRemaining;
            this.pos = i2;
            byteBuffer.get(this.buffer, i2 + 1, iRemaining);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            int i2 = this.pos - iRemaining;
            this.pos = i2;
            byteBuffer.get(this.buffer, i2 + 1, iRemaining);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeMessage(int i2, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeString(String str) {
            int i2;
            int i8;
            int i9;
            char cCharAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (cCharAt = str.charAt(length)) < 128) {
                this.buffer[this.pos + length] = (byte) cCharAt;
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128 && (i9 = this.pos) > this.offsetMinusOne) {
                    byte[] bArr = this.buffer;
                    this.pos = i9 - 1;
                    bArr[i9] = (byte) cCharAt2;
                } else if (cCharAt2 < 2048 && (i8 = this.pos) > this.offset) {
                    byte[] bArr2 = this.buffer;
                    int i10 = i8 - 1;
                    this.pos = i10;
                    bArr2[i8] = (byte) ((cCharAt2 & '?') | 128);
                    this.pos = i8 - 2;
                    bArr2[i10] = (byte) ((cCharAt2 >>> 6) | 960);
                } else if ((cCharAt2 < 55296 || 57343 < cCharAt2) && (i2 = this.pos) > this.offset + 1) {
                    byte[] bArr3 = this.buffer;
                    int i11 = i2 - 1;
                    this.pos = i11;
                    bArr3[i2] = (byte) ((cCharAt2 & '?') | 128);
                    int i12 = i2 - 2;
                    this.pos = i12;
                    bArr3[i11] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    this.pos = i2 - 3;
                    bArr3[i12] = (byte) ((cCharAt2 >>> '\f') | 480);
                } else {
                    if (this.pos > this.offset + 2) {
                        if (length != 0) {
                            char cCharAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                byte[] bArr4 = this.buffer;
                                int i13 = this.pos;
                                int i14 = i13 - 1;
                                this.pos = i14;
                                bArr4[i13] = (byte) ((codePoint & 63) | 128);
                                int i15 = i13 - 2;
                                this.pos = i15;
                                bArr4[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                                int i16 = i13 - 3;
                                this.pos = i16;
                                bArr4[i15] = (byte) (((codePoint >>> 12) & 63) | 128);
                                this.pos = i13 - 4;
                                bArr4[i16] = (byte) ((codePoint >>> 18) | 240);
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class UnsafeDirectWriter extends BinaryWriter {
        private ByteBuffer buffer;
        private long bufferOffset;
        private long limitMinusOne;
        private long pos;

        public UnsafeDirectWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, null);
            nextBuffer();
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i2 >>> 28));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((i2 >>> 21) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((i2 >>> 14) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((i2 >>> 7) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i2 >>> 21));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((i2 >>> 14) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((i2 >>> 7) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32OneByte(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) i2);
        }

        private void writeVarint32ThreeBytes(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i2 >>> 14));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((i2 >>> 7) & 127) | 128));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i2 >>> 7));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (j >>> 49));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j >>> 42) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j >>> 35) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((j >>> 28) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((j >>> 21) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j >>> 14) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j >>> 7) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) ((j & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (j >>> 28));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j >>> 21) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j >>> 14) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((j >>> 7) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((j & 127) | 128));
        }

        private void writeVarint64FourBytes(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (j >>> 21));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j >>> 14) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j >>> 7) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((j & 127) | 128));
        }

        private void writeVarint64NineBytes(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (j >>> 56));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j >>> 49) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j >>> 42) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((j >>> 35) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((j >>> 28) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j >>> 21) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j >>> 14) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((j >>> 7) & 127) | 128));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) ((j & 127) | 128));
        }

        private void writeVarint64OneByte(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) j);
        }

        private void writeVarint64SevenBytes(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (j >>> 42));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j >>> 35) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j >>> 28) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((j >>> 21) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((j >>> 14) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j >>> 7) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) ((j & 127) | 128));
        }

        private void writeVarint64SixBytes(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (j >>> 35));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j >>> 28) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j >>> 21) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((j >>> 14) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((j >>> 7) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) ((j & 127) | 128));
        }

        private void writeVarint64TenBytes(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (j >>> 63));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j >>> 56) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((j >>> 49) & 127) | 128));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((j >>> 42) & 127) | 128));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((j >>> 35) & 127) | 128));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((j >>> 28) & 127) | 128));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((j >>> 21) & 127) | 128));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((j >>> 14) & 127) | 128));
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(j15, (byte) (((j >>> 7) & 127) | 128));
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(j16, (byte) ((j & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((int) j) >>> 14));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((j >>> 7) & 127) | 128));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((j & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (j >>> 7));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((((int) j) & 127) | 128));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                Java8Compatibility.position(this.buffer, bufferPos() + 1);
                this.buffer = null;
                this.pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void requireSpace(int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte b8) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, b8);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeBool(int i2, boolean z2) {
            requireSpace(6);
            write(z2 ? (byte) 1 : (byte) 0);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeBytes(int i2, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i2, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        @Deprecated
        public void writeEndGroup(int i2) {
            writeTag(i2, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeFixed32(int i2, int i8) {
            requireSpace(9);
            writeFixed32(i8);
            writeTag(i2, 5);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeFixed64(int i2, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i2, 1);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeGroup(int i2, Object obj) throws IOException {
            writeTag(i2, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeInt32(int i2, int i8) {
            requireSpace(15);
            writeInt32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i2, int i8) {
            if (spaceLeft() < i8) {
                this.totalDoneBytes += i8;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i2, i8));
                nextBuffer();
            } else {
                this.pos -= (long) i8;
                Java8Compatibility.position(this.buffer, bufferPos() + 1);
                this.buffer.put(bArr, i2, i8);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeMessage(int i2, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeSInt32(int i2, int i8) {
            requireSpace(10);
            writeSInt32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeSInt64(int i2, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        @Deprecated
        public void writeStartGroup(int i2) {
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeString(int i2, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeTag(int i2, int i8) {
            writeVarint32(WireFormat.makeTag(i2, i8));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeUInt32(int i2, int i8) {
            requireSpace(10);
            writeVarint32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeUInt64(int i2, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeVarint32(int i2) {
            if ((i2 & (-128)) == 0) {
                writeVarint32OneByte(i2);
                return;
            }
            if ((i2 & (-16384)) == 0) {
                writeVarint32TwoBytes(i2);
                return;
            }
            if (((-2097152) & i2) == 0) {
                writeVarint32ThreeBytes(i2);
            } else if (((-268435456) & i2) == 0) {
                writeVarint32FourBytes(i2);
            } else {
                writeVarint32FiveBytes(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    break;
                case 2:
                    writeVarint64TwoBytes(j);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j);
                    break;
                case 4:
                    writeVarint64FourBytes(j);
                    break;
                case 5:
                    writeVarint64FiveBytes(j);
                    break;
                case 6:
                    writeVarint64SixBytes(j);
                    break;
                case 7:
                    writeVarint64SevenBytes(j);
                    break;
                case 8:
                    writeVarint64EightBytes(j);
                    break;
                case 9:
                    writeVarint64NineBytes(j);
                    break;
                case 10:
                    writeVarint64TenBytes(j);
                    break;
            }
        }

        private void nextBuffer(int i2) {
            nextBuffer(newDirectBuffer(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte[] bArr, int i2, int i8) {
            if (spaceLeft() < i8) {
                nextBuffer(i8);
            }
            this.pos -= (long) i8;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(bArr, i2, i8);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer byteBufferNioBuffer = allocatedBuffer.nioBuffer();
                if (byteBufferNioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = byteBufferNioBuffer;
                    Java8Compatibility.limit(byteBufferNioBuffer, byteBufferNioBuffer.capacity());
                    Java8Compatibility.position(this.buffer, 0);
                    long jAddressOffset = UnsafeUtil.addressOffset(this.buffer);
                    this.bufferOffset = jAddressOffset;
                    long jLimit = jAddressOffset + ((long) (this.buffer.limit() - 1));
                    this.limitMinusOne = jLimit;
                    this.pos = jLimit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeBool(boolean z2) {
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeFixed32(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) ((i2 >> 24) & 255));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((i2 >> 16) & 255));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((i2 >> 8) & 255));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (i2 & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeFixed64(long j) {
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((int) (j >> 56)) & 255));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((int) (j >> 48)) & 255));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((int) (j >> 40)) & 255));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) (((int) (j >> 32)) & 255));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) (((int) (j >> 24)) & 255));
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(j12, (byte) (((int) (j >> 16)) & 255));
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(j13, (byte) (((int) (j >> 8)) & 255));
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(j14, (byte) (((int) j) & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeGroup(int i2, Object obj, Schema schema) throws IOException {
            writeTag(i2, 4);
            schema.writeTo(obj, this);
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeInt32(int i2) {
            if (i2 >= 0) {
                writeVarint32(i2);
            } else {
                writeVarint64(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeSInt32(int i2) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                nextBuffer(iRemaining);
            }
            this.pos -= (long) iRemaining;
            Java8Compatibility.position(this.buffer, bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeMessage(int i2, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void writeString(java.lang.String r13) {
            /*
                Method dump skipped, instruction units count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryWriter.UnsafeDirectWriter.writeString(java.lang.String):void");
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            } else {
                this.pos -= (long) iRemaining;
                Java8Compatibility.position(this.buffer, bufferPos() + 1);
                this.buffer.put(byteBuffer);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;
        private byte[] buffer;
        private long limit;
        private long limitMinusOne;
        private long offset;
        private long offsetMinusOne;
        private long pos;

        public UnsafeHeapWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, null);
            nextBuffer();
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i2 >>> 28));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((i2 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) (((i2 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) (((i2 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr5, j10, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i2 >>> 21));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((i2 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) (((i2 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32OneByte(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) i2);
        }

        private void writeVarint32ThreeBytes(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i2 >>> 14));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((i2 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i2 >>> 7));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (j >>> 49));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) (((j >>> 42) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr3, j9, (byte) (((j >>> 35) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr4, j10, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr5, j11, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr6, j12, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr7, j13, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr8, j14, (byte) ((j & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (j >>> 28));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr3, j9, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr4, j10, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr5, j11, (byte) ((j & 127) | 128));
        }

        private void writeVarint64FourBytes(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (j >>> 21));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr3, j9, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr4, j10, (byte) ((j & 127) | 128));
        }

        private void writeVarint64NineBytes(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (j >>> 56));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) (((j >>> 49) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr3, j9, (byte) (((j >>> 42) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr4, j10, (byte) (((j >>> 35) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr5, j11, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr6, j12, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr7, j13, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr8, j14, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr9 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr9, j15, (byte) ((j & 127) | 128));
        }

        private void writeVarint64OneByte(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) j);
        }

        private void writeVarint64SevenBytes(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (j >>> 42));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) (((j >>> 35) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr3, j9, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr4, j10, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr5, j11, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr6, j12, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr7, j13, (byte) ((j & 127) | 128));
        }

        private void writeVarint64SixBytes(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (j >>> 35));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr3, j9, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr4, j10, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr5, j11, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr6, j12, (byte) ((j & 127) | 128));
        }

        private void writeVarint64TenBytes(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (j >>> 63));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) (((j >>> 56) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr3, j9, (byte) (((j >>> 49) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr4, j10, (byte) (((j >>> 42) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr5, j11, (byte) (((j >>> 35) & 127) | 128));
            byte[] bArr6 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr6, j12, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr7 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr7, j13, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr8 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr8, j14, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr9 = this.buffer;
            long j15 = this.pos;
            this.pos = j15 - 1;
            UnsafeUtil.putByte(bArr9, j15, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr10 = this.buffer;
            long j16 = this.pos;
            this.pos = j16 - 1;
            UnsafeUtil.putByte(bArr10, j16, (byte) ((j & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (((int) j) >>> 14));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr3, j9, (byte) ((j & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (j >>> 7));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) ((((int) j) & 127) | 128));
        }

        public int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void requireSpace(int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
        }

        public int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte b8) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, b8);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeBool(int i2, boolean z2) {
            requireSpace(6);
            write(z2 ? (byte) 1 : (byte) 0);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeBytes(int i2, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i2, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeEndGroup(int i2) {
            writeTag(i2, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeFixed32(int i2, int i8) {
            requireSpace(9);
            writeFixed32(i8);
            writeTag(i2, 5);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeFixed64(int i2, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i2, 1);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeGroup(int i2, Object obj) throws IOException {
            writeTag(i2, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeInt32(int i2, int i8) {
            requireSpace(15);
            writeInt32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i2, int i8) {
            if (i2 < 0 || i2 + i8 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i8)));
            }
            if (spaceLeft() >= i8) {
                this.pos -= (long) i8;
                System.arraycopy(bArr, i2, this.buffer, arrayPos() + 1, i8);
            } else {
                this.totalDoneBytes += i8;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i2, i8));
                nextBuffer();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeMessage(int i2, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeSInt32(int i2, int i8) {
            requireSpace(10);
            writeSInt32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeSInt64(int i2, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeStartGroup(int i2) {
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeString(int i2, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeTag(int i2, int i8) {
            writeVarint32(WireFormat.makeTag(i2, i8));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeUInt32(int i2, int i8) {
            requireSpace(10);
            writeVarint32(i8);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeUInt64(int i2, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeVarint32(int i2) {
            if ((i2 & (-128)) == 0) {
                writeVarint32OneByte(i2);
                return;
            }
            if ((i2 & (-16384)) == 0) {
                writeVarint32TwoBytes(i2);
                return;
            }
            if (((-2097152) & i2) == 0) {
                writeVarint32ThreeBytes(i2);
            } else if (((-268435456) & i2) == 0) {
                writeVarint32FourBytes(i2);
            } else {
                writeVarint32FiveBytes(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    break;
                case 2:
                    writeVarint64TwoBytes(j);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j);
                    break;
                case 4:
                    writeVarint64FourBytes(j);
                    break;
                case 5:
                    writeVarint64FiveBytes(j);
                    break;
                case 6:
                    writeVarint64SixBytes(j);
                    break;
                case 7:
                    writeVarint64SevenBytes(j);
                    break;
                case 8:
                    writeVarint64EightBytes(j);
                    break;
                case 9:
                    writeVarint64NineBytes(j);
                    break;
                case 10:
                    writeVarint64TenBytes(j);
                    break;
            }
        }

        private void nextBuffer(int i2) {
            nextBuffer(newHeapBuffer(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(byte[] bArr, int i2, int i8) {
            if (i2 < 0 || i2 + i8 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i8)));
            }
            requireSpace(i8);
            this.pos -= (long) i8;
            System.arraycopy(bArr, i2, this.buffer, arrayPos() + 1, i8);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer);
                this.allocatedBuffer = allocatedBuffer;
                this.buffer = allocatedBuffer.array();
                long jArrayOffset = allocatedBuffer.arrayOffset();
                this.limit = ((long) allocatedBuffer.limit()) + jArrayOffset;
                long jPosition = jArrayOffset + ((long) allocatedBuffer.position());
                this.offset = jPosition;
                this.offsetMinusOne = jPosition - 1;
                long j = this.limit - 1;
                this.limitMinusOne = j;
                this.pos = j;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeBool(boolean z2) {
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeFixed32(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) ((i2 >> 24) & 255));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((i2 >> 16) & 255));
            byte[] bArr3 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr3, j8, (byte) ((i2 >> 8) & 255));
            byte[] bArr4 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr4, j9, (byte) (i2 & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeFixed64(long j) {
            byte[] bArr = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr, j3, (byte) (((int) (j >> 56)) & 255));
            byte[] bArr2 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr2, j8, (byte) (((int) (j >> 48)) & 255));
            byte[] bArr3 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr3, j9, (byte) (((int) (j >> 40)) & 255));
            byte[] bArr4 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr4, j10, (byte) (((int) (j >> 32)) & 255));
            byte[] bArr5 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr5, j11, (byte) (((int) (j >> 24)) & 255));
            byte[] bArr6 = this.buffer;
            long j12 = this.pos;
            this.pos = j12 - 1;
            UnsafeUtil.putByte(bArr6, j12, (byte) (((int) (j >> 16)) & 255));
            byte[] bArr7 = this.buffer;
            long j13 = this.pos;
            this.pos = j13 - 1;
            UnsafeUtil.putByte(bArr7, j13, (byte) (((int) (j >> 8)) & 255));
            byte[] bArr8 = this.buffer;
            long j14 = this.pos;
            this.pos = j14 - 1;
            UnsafeUtil.putByte(bArr8, j14, (byte) (((int) j) & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeGroup(int i2, Object obj, Schema schema) throws IOException {
            writeTag(i2, 4);
            schema.writeTo(obj, this);
            writeTag(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeInt32(int i2) {
            if (i2 >= 0) {
                writeVarint32(i2);
            } else {
                writeVarint64(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeSInt32(int i2) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void writeMessage(int i2, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i2, 2);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void writeString(java.lang.String r13) {
            /*
                Method dump skipped, instruction units count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryWriter.UnsafeHeapWriter.writeString(java.lang.String):void");
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            requireSpace(iRemaining);
            this.pos -= (long) iRemaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, iRemaining);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            this.pos -= (long) iRemaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, iRemaining);
        }
    }

    public /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int i2, AnonymousClass1 anonymousClass1) {
        this(bufferAllocator, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte computeUInt64SizeNoTag(long j) {
        byte b8;
        if (((-128) & j) == 0) {
            return (byte) 1;
        }
        if (j < 0) {
            return (byte) 10;
        }
        if (((-34359738368L) & j) != 0) {
            b8 = (byte) 6;
            j >>>= 28;
        } else {
            b8 = 2;
        }
        if (((-2097152) & j) != 0) {
            b8 = (byte) (b8 + 2);
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? (byte) (b8 + 1) : b8;
    }

    public static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.isSupported();
    }

    public static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return newHeapInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int i2) {
        return new SafeDirectWriter(bufferAllocator, i2);
    }

    public static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int i2) {
        return new SafeHeapWriter(bufferAllocator, i2);
    }

    public static BinaryWriter newUnsafeDirectInstance(BufferAllocator bufferAllocator, int i2) {
        if (isUnsafeDirectSupported()) {
            return new UnsafeDirectWriter(bufferAllocator, i2);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    public static BinaryWriter newUnsafeHeapInstance(BufferAllocator bufferAllocator, int i2) {
        if (isUnsafeHeapSupported()) {
            return new UnsafeHeapWriter(bufferAllocator, i2);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private void writeBoolList_Internal(int i2, List<Boolean> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeBool(i2, list.get(size).booleanValue());
            }
            return;
        }
        requireSpace(list.size() + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(list.get(size2).booleanValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    private void writeDoubleList_Internal(int i2, List<Double> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeDouble(i2, list.get(size).doubleValue());
            }
            return;
        }
        requireSpace((list.size() * 8) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(Double.doubleToRawLongBits(list.get(size2).doubleValue()));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    private void writeFixed32List_Internal(int i2, List<Integer> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(i2, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 4) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    private void writeFixed64List_Internal(int i2, List<Long> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(i2, list.get(size).longValue());
            }
            return;
        }
        requireSpace((list.size() * 8) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(list.get(size2).longValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    private void writeFloatList_Internal(int i2, List<Float> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFloat(i2, list.get(size).floatValue());
            }
            return;
        }
        requireSpace((list.size() * 4) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(Float.floatToRawIntBits(list.get(size2).floatValue()));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    private void writeInt32List_Internal(int i2, List<Integer> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeInt32(i2, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    private void writeLazyString(int i2, Object obj) throws IOException {
        if (obj instanceof String) {
            writeString(i2, (String) obj);
        } else {
            writeBytes(i2, (ByteString) obj);
        }
    }

    public static final void writeMapEntryField(Writer writer, int i2, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(i2, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(i2, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(i2, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(i2, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(i2, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(i2, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(i2, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(i2, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(i2, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(i2, (String) obj);
                return;
            case 11:
                writer.writeUInt32(i2, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(i2, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(i2, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(i2, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(i2, obj);
                return;
            case 16:
                writer.writeBytes(i2, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.writeEnum(i2, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    if (!(obj instanceof Integer)) {
                        throw new IllegalArgumentException("Unexpected type for enum in map.");
                    }
                    writer.writeEnum(i2, ((Integer) obj).intValue());
                    return;
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private void writeSInt32List_Internal(int i2, List<Integer> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt32(i2, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 5) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    private void writeSInt64List_Internal(int i2, List<Long> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt64(i2, list.get(size).longValue());
            }
            return;
        }
        requireSpace((list.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(list.get(size2).longValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    private void writeUInt32List_Internal(int i2, List<Integer> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeUInt32(i2, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 5) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeVarint32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    private void writeUInt64List_Internal(int i2, List<Long> list, boolean z2) throws IOException {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeUInt64(i2, list.get(size).longValue());
            }
            return;
        }
        requireSpace((list.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeVarint64(list.get(size2).longValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i2, 2);
    }

    @CanIgnoreReturnValue
    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    public final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    public final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    public abstract void requireSpace(int i2);

    public abstract void writeBool(boolean z2);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeBoolList(int i2, List<Boolean> list, boolean z2) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolList_Internal(i2, (BooleanArrayList) list, z2);
        } else {
            writeBoolList_Internal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeBytesList(int i2, List<ByteString> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(i2, list.get(size));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeDouble(int i2, double d8) throws IOException {
        writeFixed64(i2, Double.doubleToRawLongBits(d8));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeDoubleList(int i2, List<Double> list, boolean z2) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleList_Internal(i2, (DoubleArrayList) list, z2);
        } else {
            writeDoubleList_Internal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeEnum(int i2, int i8) throws IOException {
        writeInt32(i2, i8);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeEnumList(int i2, List<Integer> list, boolean z2) throws IOException {
        writeInt32List(i2, list, z2);
    }

    public abstract void writeFixed32(int i2);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeFixed32List(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32List_Internal(i2, (IntArrayList) list, z2);
        } else {
            writeFixed32List_Internal(i2, list, z2);
        }
    }

    public abstract void writeFixed64(long j);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeFixed64List(int i2, List<Long> list, boolean z2) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64List_Internal(i2, (LongArrayList) list, z2);
        } else {
            writeFixed64List_Internal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeFloat(int i2, float f4) throws IOException {
        writeFixed32(i2, Float.floatToRawIntBits(f4));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeFloatList(int i2, List<Float> list, boolean z2) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatList_Internal(i2, (FloatArrayList) list, z2);
        } else {
            writeFloatList_Internal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int i2, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i2, list.get(size));
        }
    }

    public abstract void writeInt32(int i2);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeInt32List(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32List_Internal(i2, (IntArrayList) list, z2);
        } else {
            writeInt32List_Internal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeInt64(int i2, long j) throws IOException {
        writeUInt64(i2, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeInt64List(int i2, List<Long> list, boolean z2) throws IOException {
        writeUInt64List(i2, list, z2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public <K, V> void writeMap(int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            writeMapEntryField(this, 2, metadata.valueType, entry.getValue());
            writeMapEntryField(this, 1, metadata.keyType, entry.getKey());
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeMessageList(int i2, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i2, list.get(size));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeMessageSetItem(int i2, Object obj) throws IOException {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i2);
        writeTag(1, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeSFixed32(int i2, int i8) throws IOException {
        writeFixed32(i2, i8);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeSFixed32List(int i2, List<Integer> list, boolean z2) throws IOException {
        writeFixed32List(i2, list, z2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeSFixed64(int i2, long j) throws IOException {
        writeFixed64(i2, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeSFixed64List(int i2, List<Long> list, boolean z2) throws IOException {
        writeFixed64List(i2, list, z2);
    }

    public abstract void writeSInt32(int i2);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeSInt32List(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32List_Internal(i2, (IntArrayList) list, z2);
        } else {
            writeSInt32List_Internal(i2, list, z2);
        }
    }

    public abstract void writeSInt64(long j);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeSInt64List(int i2, List<Long> list, boolean z2) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64List_Internal(i2, (LongArrayList) list, z2);
        } else {
            writeSInt64List_Internal(i2, list, z2);
        }
    }

    public abstract void writeString(String str);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeStringList(int i2, List<String> list) throws IOException {
        if (!(list instanceof LazyStringList)) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeString(i2, list.get(size));
            }
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeLazyString(i2, lazyStringList.getRaw(size2));
        }
    }

    public abstract void writeTag(int i2, int i8);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeUInt32List(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32List_Internal(i2, (IntArrayList) list, z2);
        } else {
            writeUInt32List_Internal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeUInt64List(int i2, List<Long> list, boolean z2) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64List_Internal(i2, (LongArrayList) list, z2);
        } else {
            writeUInt64List_Internal(i2, list, z2);
        }
    }

    public abstract void writeVarint32(int i2);

    public abstract void writeVarint64(long j);

    private BinaryWriter(BufferAllocator bufferAllocator, int i2) {
        this.buffers = new ArrayDeque<>(4);
        if (i2 <= 0) {
            throw new IllegalArgumentException("chunkSize must be > 0");
        }
        this.alloc = (BufferAllocator) Internal.checkNotNull(bufferAllocator, "alloc");
        this.chunkSize = i2;
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator, int i2) {
        return isUnsafeDirectSupported() ? newUnsafeDirectInstance(bufferAllocator, i2) : newSafeDirectInstance(bufferAllocator, i2);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator, int i2) {
        return isUnsafeHeapSupported() ? newUnsafeHeapInstance(bufferAllocator, i2) : newSafeHeapInstance(bufferAllocator, i2);
    }

    public final AllocatedBuffer newDirectBuffer(int i2) {
        return this.alloc.allocateDirectBuffer(Math.max(i2, this.chunkSize));
    }

    public final AllocatedBuffer newHeapBuffer(int i2) {
        return this.alloc.allocateHeapBuffer(Math.max(i2, this.chunkSize));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public final void writeGroupList(int i2, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i2, list.get(size), schema);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeMessageList(int i2, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i2, list.get(size), schema);
        }
    }

    private void writeBoolList_Internal(int i2, BooleanArrayList booleanArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace(booleanArrayList.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                writeBool(booleanArrayList.getBoolean(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(i2, booleanArrayList.getBoolean(size2));
        }
    }

    private void writeDoubleList_Internal(int i2, DoubleArrayList doubleArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace((doubleArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(i2, doubleArrayList.getDouble(size2));
        }
    }

    private void writeFixed32List_Internal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace((intArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i2, intArrayList.getInt(size2));
        }
    }

    private void writeFixed64List_Internal(int i2, LongArrayList longArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace((longArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i2, longArrayList.getLong(size2));
        }
    }

    private void writeFloatList_Internal(int i2, FloatArrayList floatArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace((floatArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(i2, floatArrayList.getFloat(size2));
        }
    }

    private void writeInt32List_Internal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace((intArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(i2, intArrayList.getInt(size2));
        }
    }

    private void writeSInt32List_Internal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeSInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i2, intArrayList.getInt(size2));
        }
    }

    private void writeSInt64List_Internal(int i2, LongArrayList longArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeSInt64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i2, longArrayList.getLong(size2));
        }
    }

    private void writeUInt32List_Internal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeVarint32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i2, intArrayList.getInt(size2));
        }
    }

    private void writeUInt64List_Internal(int i2, LongArrayList longArrayList, boolean z2) throws IOException {
        if (z2) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeVarint64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i2, longArrayList.getLong(size2));
        }
    }
}
