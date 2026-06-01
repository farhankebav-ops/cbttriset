package com.google.protobuf;

import com.google.protobuf.s2;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private boolean serializationDeterministic;
    r wrapper;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = r2.hasUnsafeArrayOperations();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(String str) {
            super(a1.a.l("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str));
        }

        public OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        public OutOfSpaceException(String str, Throwable th) {
            super(a1.a.l("CodedOutputStream was writing to a flat byte array and ran out of space.: ", str), th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class a extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        public a(int i2) {
            super();
            if (i2 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i2, 20)];
            this.buffer = bArr;
            this.limit = bArr.length;
        }

        public final void buffer(byte b8) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = b8;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int i2) {
            byte[] bArr = this.buffer;
            int i8 = this.position;
            int i9 = i8 + 1;
            this.position = i9;
            bArr[i8] = (byte) (i2 & 255);
            int i10 = i8 + 2;
            this.position = i10;
            bArr[i9] = (byte) ((i2 >> 8) & 255);
            int i11 = i8 + 3;
            this.position = i11;
            bArr[i10] = (byte) ((i2 >> 16) & 255);
            this.position = i8 + 4;
            bArr[i11] = (byte) ((i2 >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            int i8 = i2 + 1;
            this.position = i8;
            bArr[i2] = (byte) (j & 255);
            int i9 = i2 + 2;
            this.position = i9;
            bArr[i8] = (byte) ((j >> 8) & 255);
            int i10 = i2 + 3;
            this.position = i10;
            bArr[i9] = (byte) ((j >> 16) & 255);
            int i11 = i2 + 4;
            this.position = i11;
            bArr[i10] = (byte) (255 & (j >> 24));
            int i12 = i2 + 5;
            this.position = i12;
            bArr[i11] = (byte) (((int) (j >> 32)) & 255);
            int i13 = i2 + 6;
            this.position = i13;
            bArr[i12] = (byte) (((int) (j >> 40)) & 255);
            int i14 = i2 + 7;
            this.position = i14;
            bArr[i13] = (byte) (((int) (j >> 48)) & 255);
            this.position = i2 + 8;
            bArr[i14] = (byte) (((int) (j >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int i2) {
            if (i2 >= 0) {
                bufferUInt32NoTag(i2);
            } else {
                bufferUInt64NoTag(i2);
            }
        }

        public final void bufferTag(int i2, int i8) {
            bufferUInt32NoTag(WireFormat.makeTag(i2, i8));
        }

        public final void bufferUInt32NoTag(int i2) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((i2 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i8 = this.position;
                    this.position = i8 + 1;
                    bArr[i8] = (byte) ((i2 & 127) | 128);
                    this.totalBytesWritten++;
                    i2 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                bArr2[i9] = (byte) i2;
                this.totalBytesWritten++;
                return;
            }
            long j = this.position;
            while ((i2 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                r2.putByte(bArr3, i10, (byte) ((i2 & 127) | 128));
                i2 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i11 = this.position;
            this.position = i11 + 1;
            r2.putByte(bArr4, i11, (byte) i2);
            this.totalBytesWritten += (int) (((long) this.position) - j);
        }

        public final void bufferUInt64NoTag(long j) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) & 127) | 128);
                    this.totalBytesWritten++;
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr2[i8] = (byte) j;
                this.totalBytesWritten++;
                return;
            }
            long j3 = this.position;
            while ((j & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                r2.putByte(bArr3, i9, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i10 = this.position;
            this.position = i10 + 1;
            r2.putByte(bArr4, i10, (byte) j);
            this.totalBytesWritten += (int) (((long) this.position) - j3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        public b(byte[] bArr, int i2, int i8) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i9 = i2 + i8;
            if ((i2 | i8 | (bArr.length - i9)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i8)));
            }
            this.buffer = bArr;
            this.offset = i2;
            this.position = i2;
            this.limit = i9;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte b8) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = b8;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int i2, boolean z2) throws IOException {
            writeTag(i2, 0);
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i2, int i8) throws IOException {
            writeUInt32NoTag(i8);
            write(bArr, i2, i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int i2, int i8) throws IOException {
            writeTag(i2, 5);
            writeFixed32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i2) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i8 = this.position;
                int i9 = i8 + 1;
                this.position = i9;
                bArr[i8] = (byte) (i2 & 255);
                int i10 = i8 + 2;
                this.position = i10;
                bArr[i9] = (byte) ((i2 >> 8) & 255);
                int i11 = i8 + 3;
                this.position = i11;
                bArr[i10] = (byte) ((i2 >> 16) & 255);
                this.position = i8 + 4;
                bArr[i11] = (byte) ((i2 >> 24) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int i2, long j) throws IOException {
            writeTag(i2, 1);
            writeFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i8 = i2 + 1;
                this.position = i8;
                bArr[i2] = (byte) (((int) j) & 255);
                int i9 = i2 + 2;
                this.position = i9;
                bArr[i8] = (byte) (((int) (j >> 8)) & 255);
                int i10 = i2 + 3;
                this.position = i10;
                bArr[i9] = (byte) (((int) (j >> 16)) & 255);
                int i11 = i2 + 4;
                this.position = i11;
                bArr[i10] = (byte) (((int) (j >> 24)) & 255);
                int i12 = i2 + 5;
                this.position = i12;
                bArr[i11] = (byte) (((int) (j >> 32)) & 255);
                int i13 = i2 + 6;
                this.position = i13;
                bArr[i12] = (byte) (((int) (j >> 40)) & 255);
                int i14 = i2 + 7;
                this.position = i14;
                bArr[i13] = (byte) (((int) (j >> 48)) & 255);
                this.position = i2 + 8;
                bArr[i14] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int i2, int i8) throws IOException {
            writeTag(i2, 0);
            writeInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag(i2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i2, int i8) throws IOException {
            write(bArr, i2, i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            w0.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) throws IOException {
            int i2 = this.position;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    writeUInt32NoTag(s2.encodedLength(str));
                    this.position = s2.encode(str, this.buffer, this.position, spaceLeft());
                    return;
                }
                int i8 = i2 + iComputeUInt32SizeNoTag2;
                this.position = i8;
                int iEncode = s2.encode(str, this.buffer, i8, spaceLeft());
                this.position = i2;
                writeUInt32NoTag((iEncode - i2) - iComputeUInt32SizeNoTag2);
                this.position = iEncode;
            } catch (s2.d e) {
                this.position = i2;
                inefficientWriteStringNoTag(str, e);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int i2, int i8) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i8));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int i2, int i8) throws IOException {
            writeTag(i2, 0);
            writeUInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i2) throws IOException {
            while ((i2 & (-128)) != 0) {
                try {
                    byte[] bArr = this.buffer;
                    int i8 = this.position;
                    this.position = i8 + 1;
                    bArr[i8] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr2 = this.buffer;
            int i9 = this.position;
            this.position = i9 + 1;
            bArr2[i9] = (byte) i2;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int i2, long j) throws IOException {
            writeTag(i2, 0);
            writeUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j) throws IOException {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS && spaceLeft() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    r2.putByte(bArr, i2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                r2.putByte(bArr2, i8, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i9 = this.position;
                    this.position = i9 + 1;
                    bArr3[i9] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            }
            byte[] bArr4 = this.buffer;
            int i10 = this.position;
            this.position = i10 + 1;
            bArr4[i10] = (byte) j;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArray(int i2, byte[] bArr, int i8, int i9) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessage(int i2, MessageLite messageLite, c2 c2Var) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(c2Var));
            c2Var.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite, c2 c2Var) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(c2Var));
            c2Var.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(byte[] bArr, int i2, int i8) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.buffer, this.position, i8);
                this.position += i8;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i8)), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void write(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, iRemaining);
                this.position += iRemaining;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(iRemaining)), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c extends a {
        private final ByteOutput out;

        public c(ByteOutput byteOutput, int i2) {
            super(i2);
            if (byteOutput == null) {
                throw new NullPointerException("out");
            }
            this.out = byteOutput;
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i2) throws IOException {
            if (this.limit - this.position < i2) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b8) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i2, boolean z2) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i2, 0);
            buffer(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i2, int i8) throws IOException {
            writeUInt32NoTag(i8);
            write(bArr, i2, i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i2, int i8) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i2, 5);
            bufferFixed32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i2) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i2, long j) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i2, 1);
            bufferFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i2, int i8) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag(i2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i2, int i8) throws IOException {
            flush();
            this.out.writeLazy(bArr, i2, i8);
            this.totalBytesWritten += i8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            w0.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int length = str.length() * 3;
            int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i2 = iComputeUInt32SizeNoTag + length;
            int i8 = this.limit;
            if (i2 > i8) {
                byte[] bArr = new byte[length];
                int iEncode = s2.encode(str, bArr, 0, length);
                writeUInt32NoTag(iEncode);
                writeLazy(bArr, 0, iEncode);
                return;
            }
            if (i2 > i8 - this.position) {
                doFlush();
            }
            int i9 = this.position;
            try {
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    int iEncodedLength = s2.encodedLength(str);
                    bufferUInt32NoTag(iEncodedLength);
                    this.position = s2.encode(str, this.buffer, this.position, iEncodedLength);
                    this.totalBytesWritten += iEncodedLength;
                    return;
                }
                int i10 = i9 + iComputeUInt32SizeNoTag2;
                this.position = i10;
                int iEncode2 = s2.encode(str, this.buffer, i10, this.limit - i10);
                this.position = i9;
                int i11 = (iEncode2 - i9) - iComputeUInt32SizeNoTag2;
                bufferUInt32NoTag(i11);
                this.position = iEncode2;
                this.totalBytesWritten += i11;
            } catch (s2.d e) {
                this.totalBytesWritten -= this.position - i9;
                this.position = i9;
                inefficientWriteStringNoTag(str, e);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i2, int i8) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i8));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i2, int i8) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferUInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i2) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i2, long j) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i2, byte[] bArr, int i8, int i9) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i2, MessageLite messageLite, c2 c2Var) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite, c2Var);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, c2 c2Var) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(c2Var));
            c2Var.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i2, int i8) throws IOException {
            flush();
            this.out.write(bArr, i2, i8);
            this.totalBytesWritten += i8;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            flush();
            int iRemaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class d extends b {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        public d(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.protobuf.CodedOutputStream.b, com.google.protobuf.CodedOutputStream
        public void flush() {
            w0.position(this.byteBuffer, getTotalBytesWritten() + this.initialPosition);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class e extends a {
        private final OutputStream out;

        public e(OutputStream outputStream, int i2) {
            super(i2);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.out = outputStream;
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i2) throws IOException {
            if (this.limit - this.position < i2) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b8) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i2, boolean z2) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i2, 0);
            buffer(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i2, int i8) throws IOException {
            writeUInt32NoTag(i8);
            write(bArr, i2, i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i2, int i8) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i2, 5);
            bufferFixed32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i2) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i2, long j) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i2, 1);
            bufferFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i2, int i8) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag(i2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i2, int i8) throws IOException {
            write(bArr, i2, i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            w0.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int iEncodedLength;
            try {
                int length = str.length() * 3;
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i2 = iComputeUInt32SizeNoTag + length;
                int i8 = this.limit;
                if (i2 > i8) {
                    byte[] bArr = new byte[length];
                    int iEncode = s2.encode(str, bArr, 0, length);
                    writeUInt32NoTag(iEncode);
                    writeLazy(bArr, 0, iEncode);
                    return;
                }
                if (i2 > i8 - this.position) {
                    doFlush();
                }
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i9 = this.position;
                try {
                    if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                        int i10 = i9 + iComputeUInt32SizeNoTag2;
                        this.position = i10;
                        int iEncode2 = s2.encode(str, this.buffer, i10, this.limit - i10);
                        this.position = i9;
                        iEncodedLength = (iEncode2 - i9) - iComputeUInt32SizeNoTag2;
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = iEncode2;
                    } else {
                        iEncodedLength = s2.encodedLength(str);
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = s2.encode(str, this.buffer, this.position, iEncodedLength);
                    }
                    this.totalBytesWritten += iEncodedLength;
                } catch (s2.d e) {
                    this.totalBytesWritten -= this.position - i9;
                    this.position = i9;
                    throw e;
                } catch (ArrayIndexOutOfBoundsException e4) {
                    throw new OutOfSpaceException(e4);
                }
            } catch (s2.d e8) {
                inefficientWriteStringNoTag(str, e8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i2, int i8) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i8));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i2, int i8) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferUInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i2) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i2, long j) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i2, byte[] bArr, int i8, int i9) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i2, MessageLite messageLite, c2 c2Var) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite, c2Var);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, c2 c2Var) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(c2Var));
            c2Var.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i2, int i8) throws IOException {
            int i9 = this.limit;
            int i10 = this.position;
            if (i9 - i10 >= i8) {
                System.arraycopy(bArr, i2, this.buffer, i10, i8);
                this.position += i8;
                this.totalBytesWritten += i8;
                return;
            }
            int i11 = i9 - i10;
            System.arraycopy(bArr, i2, this.buffer, i10, i11);
            int i12 = i2 + i11;
            int i13 = i8 - i11;
            this.position = this.limit;
            this.totalBytesWritten += i11;
            doFlush();
            if (i13 <= this.limit) {
                System.arraycopy(bArr, i12, this.buffer, 0, i13);
                this.position = i13;
            } else {
                this.out.write(bArr, i12, i13);
            }
            this.totalBytesWritten += i13;
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i2 = this.limit;
            int i8 = this.position;
            if (i2 - i8 >= iRemaining) {
                byteBuffer.get(this.buffer, i8, iRemaining);
                this.position += iRemaining;
                this.totalBytesWritten += iRemaining;
                return;
            }
            int i9 = i2 - i8;
            byteBuffer.get(this.buffer, i8, i9);
            int i10 = iRemaining - i9;
            this.position = this.limit;
            this.totalBytesWritten += i9;
            doFlush();
            while (true) {
                int i11 = this.limit;
                if (i10 > i11) {
                    byteBuffer.get(this.buffer, 0, i11);
                    this.out.write(this.buffer, 0, this.limit);
                    int i12 = this.limit;
                    i10 -= i12;
                    this.totalBytesWritten += i12;
                } else {
                    byteBuffer.get(this.buffer, 0, i10);
                    this.position = i10;
                    this.totalBytesWritten += i10;
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class f extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        public f(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) throws IOException {
            try {
                s2.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            w0.position(this.originalBuffer, this.buffer.position());
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.buffer.remaining();
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b8) throws IOException {
            try {
                this.buffer.put(b8);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i2, boolean z2) throws IOException {
            writeTag(i2, 0);
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i2, int i8) throws IOException {
            writeUInt32NoTag(i8);
            write(bArr, i2, i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i2, int i8) throws IOException {
            writeTag(i2, 5);
            writeFixed32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i2) throws IOException {
            try {
                this.buffer.putInt(i2);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i2, long j) throws IOException {
            writeTag(i2, 1);
            writeFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws IOException {
            try {
                this.buffer.putLong(j);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i2, int i8) throws IOException {
            writeTag(i2, 0);
            writeInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag(i2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i2, int i8) throws IOException {
            write(bArr, i2, i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            w0.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int iPosition = this.buffer.position();
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    writeUInt32NoTag(s2.encodedLength(str));
                    encode(str);
                    return;
                }
                int iPosition2 = this.buffer.position() + iComputeUInt32SizeNoTag2;
                w0.position(this.buffer, iPosition2);
                encode(str);
                int iPosition3 = this.buffer.position();
                w0.position(this.buffer, iPosition);
                writeUInt32NoTag(iPosition3 - iPosition2);
                w0.position(this.buffer, iPosition3);
            } catch (s2.d e) {
                w0.position(this.buffer, iPosition);
                inefficientWriteStringNoTag(str, e);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i2, int i8) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i8));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i2, int i8) throws IOException {
            writeTag(i2, 0);
            writeUInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i2) throws IOException {
            while ((i2 & (-128)) != 0) {
                try {
                    this.buffer.put((byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new OutOfSpaceException(e);
                }
            }
            this.buffer.put((byte) i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i2, long j) throws IOException {
            writeTag(i2, 0);
            writeUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws IOException {
            while (((-128) & j) != 0) {
                try {
                    this.buffer.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new OutOfSpaceException(e);
                }
            }
            this.buffer.put((byte) j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i2, byte[] bArr, int i8, int i9) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i2, int i8) throws IOException {
            try {
                this.buffer.put(bArr, i2, i8);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(e);
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i2, MessageLite messageLite, c2 c2Var) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite, c2Var);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, c2 c2Var) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(c2Var));
            c2Var.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class g extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        public g(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long jAddressOffset = r2.addressOffset(byteBuffer);
            this.address = jAddressOffset;
            long jPosition = ((long) byteBuffer.position()) + jAddressOffset;
            this.initialPosition = jPosition;
            long jLimit = jAddressOffset + ((long) byteBuffer.limit());
            this.limit = jLimit;
            this.oneVarintLimit = jLimit - 10;
            this.position = jPosition;
        }

        private int bufferPos(long j) {
            return (int) (j - this.address);
        }

        public static boolean isSupported() {
            return r2.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j) {
            w0.position(this.buffer, bufferPos(j));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void flush() {
            w0.position(this.originalBuffer, bufferPos(this.position));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte b8) throws IOException {
            long j = this.position;
            if (j >= this.limit) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
            }
            this.position = 1 + j;
            r2.putByte(j, b8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBool(int i2, boolean z2) throws IOException {
            writeTag(i2, 0);
            write(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i2, int i8) throws IOException {
            writeUInt32NoTag(i8);
            write(bArr, i2, i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32(int i2, int i8) throws IOException {
            writeTag(i2, 5);
            writeFixed32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i2) throws IOException {
            this.buffer.putInt(bufferPos(this.position), i2);
            this.position += 4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64(int i2, long j) throws IOException {
            writeTag(i2, 1);
            writeFixed64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws IOException {
            this.buffer.putLong(bufferPos(this.position), j);
            this.position += 8;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32(int i2, int i8) throws IOException {
            writeTag(i2, 0);
            writeInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag(i2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i2, int i8) throws IOException {
            write(bArr, i2, i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            w0.clear(byteBufferDuplicate);
            write(byteBufferDuplicate);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            long j = this.position;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 != iComputeUInt32SizeNoTag) {
                    int iEncodedLength = s2.encodedLength(str);
                    writeUInt32NoTag(iEncodedLength);
                    repositionBuffer(this.position);
                    s2.encodeUtf8(str, this.buffer);
                    this.position += (long) iEncodedLength;
                    return;
                }
                int iBufferPos = bufferPos(this.position) + iComputeUInt32SizeNoTag2;
                w0.position(this.buffer, iBufferPos);
                s2.encodeUtf8(str, this.buffer);
                int iPosition = this.buffer.position() - iBufferPos;
                writeUInt32NoTag(iPosition);
                this.position += (long) iPosition;
            } catch (s2.d e) {
                this.position = j;
                repositionBuffer(j);
                inefficientWriteStringNoTag(str, e);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            } catch (IndexOutOfBoundsException e8) {
                throw new OutOfSpaceException(e8);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeTag(int i2, int i8) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i8));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32(int i2, int i8) throws IOException {
            writeTag(i2, 0);
            writeUInt32NoTag(i8);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i2) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((i2 & (-128)) != 0) {
                    long j = this.position;
                    this.position = j + 1;
                    r2.putByte(j, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                long j3 = this.position;
                this.position = 1 + j3;
                r2.putByte(j3, (byte) i2);
                return;
            }
            while (true) {
                long j8 = this.position;
                if (j8 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
                }
                if ((i2 & (-128)) == 0) {
                    this.position = 1 + j8;
                    r2.putByte(j8, (byte) i2);
                    return;
                } else {
                    this.position = j8 + 1;
                    r2.putByte(j8, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64(int i2, long j) throws IOException {
            writeTag(i2, 0);
            writeUInt64NoTag(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((j & (-128)) != 0) {
                    long j3 = this.position;
                    this.position = j3 + 1;
                    r2.putByte(j3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j8 = this.position;
                this.position = 1 + j8;
                r2.putByte(j8, (byte) j);
                return;
            }
            while (true) {
                long j9 = this.position;
                if (j9 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), 1));
                }
                if ((j & (-128)) == 0) {
                    this.position = 1 + j9;
                    r2.putByte(j9, (byte) j);
                    return;
                } else {
                    this.position = j9 + 1;
                    r2.putByte(j9, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeByteArray(int i2, byte[] bArr, int i8, int i9) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i8, i9);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessage(int i2, MessageLite messageLite, c2 c2Var) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite, c2Var);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, c2 c2Var) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(c2Var));
            c2Var.writeTo(messageLite, this.wrapper);
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(byte[] bArr, int i2, int i8) throws IOException {
            if (bArr != null && i2 >= 0 && i8 >= 0 && bArr.length - i8 >= i2) {
                long j = i8;
                long j3 = this.limit - j;
                long j8 = this.position;
                if (j3 >= j8) {
                    r2.copyMemory(bArr, i2, j8, j);
                    this.position += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i8)));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int iRemaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += (long) iRemaining;
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }
    }

    public static int computeBoolSize(int i2, boolean z2) {
        return computeBoolSizeNoTag(z2) + computeTagSize(i2);
    }

    public static int computeBoolSizeNoTag(boolean z2) {
        return 1;
    }

    public static int computeByteArraySize(int i2, byte[] bArr) {
        return computeByteArraySizeNoTag(bArr) + computeTagSize(i2);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i2, ByteBuffer byteBuffer) {
        return computeByteBufferSizeNoTag(byteBuffer) + computeTagSize(i2);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i2, ByteString byteString) {
        return computeBytesSizeNoTag(byteString) + computeTagSize(i2);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int i2, double d8) {
        return computeDoubleSizeNoTag(d8) + computeTagSize(i2);
    }

    public static int computeDoubleSizeNoTag(double d8) {
        return 8;
    }

    public static int computeEnumSize(int i2, int i8) {
        return computeEnumSizeNoTag(i8) + computeTagSize(i2);
    }

    public static int computeEnumSizeNoTag(int i2) {
        return computeInt32SizeNoTag(i2);
    }

    public static int computeFixed32Size(int i2, int i8) {
        return computeFixed32SizeNoTag(i8) + computeTagSize(i2);
    }

    public static int computeFixed32SizeNoTag(int i2) {
        return 4;
    }

    public static int computeFixed64Size(int i2, long j) {
        return computeFixed64SizeNoTag(j) + computeTagSize(i2);
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSize(int i2, float f4) {
        return computeFloatSizeNoTag(f4) + computeTagSize(i2);
    }

    public static int computeFloatSizeNoTag(float f4) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i2, MessageLite messageLite) {
        return messageLite.getSerializedSize() + (computeTagSize(i2) * 2);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i2, int i8) {
        return computeInt32SizeNoTag(i8) + computeTagSize(i2);
    }

    public static int computeInt32SizeNoTag(int i2) {
        if (i2 >= 0) {
            return computeUInt32SizeNoTag(i2);
        }
        return 10;
    }

    public static int computeInt64Size(int i2, long j) {
        return computeInt64SizeNoTag(j) + computeTagSize(i2);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i2, LazyFieldLite lazyFieldLite) {
        return computeLazyFieldSize(3, lazyFieldLite) + computeUInt32Size(2, i2) + (computeTagSize(1) * 2);
    }

    public static int computeLazyFieldSize(int i2, LazyFieldLite lazyFieldLite) {
        return computeLazyFieldSizeNoTag(lazyFieldLite) + computeTagSize(i2);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int i2) {
        return computeUInt32SizeNoTag(i2) + i2;
    }

    public static int computeMessageSetExtensionSize(int i2, MessageLite messageLite) {
        return computeMessageSize(3, messageLite) + computeUInt32Size(2, i2) + (computeTagSize(1) * 2);
    }

    public static int computeMessageSize(int i2, MessageLite messageLite) {
        return computeMessageSizeNoTag(messageLite) + computeTagSize(i2);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    public static int computePreferredBufferSize(int i2) {
        if (i2 > 4096) {
            return 4096;
        }
        return i2;
    }

    public static int computeRawMessageSetExtensionSize(int i2, ByteString byteString) {
        return computeBytesSize(3, byteString) + computeUInt32Size(2, i2) + (computeTagSize(1) * 2);
    }

    @Deprecated
    public static int computeRawVarint32Size(int i2) {
        return computeUInt32SizeNoTag(i2);
    }

    @Deprecated
    public static int computeRawVarint64Size(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeSFixed32Size(int i2, int i8) {
        return computeSFixed32SizeNoTag(i8) + computeTagSize(i2);
    }

    public static int computeSFixed32SizeNoTag(int i2) {
        return 4;
    }

    public static int computeSFixed64Size(int i2, long j) {
        return computeSFixed64SizeNoTag(j) + computeTagSize(i2);
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeSInt32Size(int i2, int i8) {
        return computeSInt32SizeNoTag(i8) + computeTagSize(i2);
    }

    public static int computeSInt32SizeNoTag(int i2) {
        return computeUInt32SizeNoTag(encodeZigZag32(i2));
    }

    public static int computeSInt64Size(int i2, long j) {
        return computeSInt64SizeNoTag(j) + computeTagSize(i2);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(encodeZigZag64(j));
    }

    public static int computeStringSize(int i2, String str) {
        return computeStringSizeNoTag(str) + computeTagSize(i2);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = s2.encodedLength(str);
        } catch (s2.d unused) {
            length = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeTagSize(int i2) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i2, 0));
    }

    public static int computeUInt32Size(int i2, int i8) {
        return computeUInt32SizeNoTag(i8) + computeTagSize(i2);
    }

    public static int computeUInt32SizeNoTag(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i2, long j) {
        return computeUInt64SizeNoTag(j) + computeTagSize(i2);
    }

    public static int computeUInt64SizeNoTag(long j) {
        int i2;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i2 = 6;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j) != 0) {
            i2 += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public static int encodeZigZag32(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new f(byteBuffer);
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new g(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String str, s2.d dVar) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e4) {
            throw new OutOfSpaceException(e4);
        }
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte b8) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void write(byte[] bArr, int i2, int i8) throws IOException;

    public abstract void writeBool(int i2, boolean z2) throws IOException;

    public final void writeBoolNoTag(boolean z2) throws IOException {
        write(z2 ? (byte) 1 : (byte) 0);
    }

    public abstract void writeByteArray(int i2, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int i2, byte[] bArr, int i8, int i9) throws IOException;

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i2, int i8) throws IOException;

    public abstract void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int i2, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i2, double d8) throws IOException {
        writeFixed64(i2, Double.doubleToRawLongBits(d8));
    }

    public final void writeDoubleNoTag(double d8) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d8));
    }

    public final void writeEnum(int i2, int i8) throws IOException {
        writeInt32(i2, i8);
    }

    public final void writeEnumNoTag(int i2) throws IOException {
        writeInt32NoTag(i2);
    }

    public abstract void writeFixed32(int i2, int i8) throws IOException;

    public abstract void writeFixed32NoTag(int i2) throws IOException;

    public abstract void writeFixed64(int i2, long j) throws IOException;

    public abstract void writeFixed64NoTag(long j) throws IOException;

    public final void writeFloat(int i2, float f4) throws IOException {
        writeFixed32(i2, Float.floatToRawIntBits(f4));
    }

    public final void writeFloatNoTag(float f4) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f4));
    }

    @Deprecated
    public final void writeGroup(int i2, MessageLite messageLite) throws IOException {
        writeTag(i2, 3);
        writeGroupNoTag(messageLite);
        writeTag(i2, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i2, int i8) throws IOException;

    public abstract void writeInt32NoTag(int i2) throws IOException;

    public final void writeInt64(int i2, long j) throws IOException {
        writeUInt64(i2, j);
    }

    public final void writeInt64NoTag(long j) throws IOException {
        writeUInt64NoTag(j);
    }

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    @Override // com.google.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i2, int i8) throws IOException;

    public abstract void writeMessage(int i2, MessageLite messageLite) throws IOException;

    public abstract void writeMessage(int i2, MessageLite messageLite, c2 c2Var) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite, c2 c2Var) throws IOException;

    public abstract void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException;

    public final void writeRawByte(byte b8) throws IOException {
        write(b8);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Deprecated
    public final void writeRawLittleEndian32(int i2) throws IOException {
        writeFixed32NoTag(i2);
    }

    @Deprecated
    public final void writeRawLittleEndian64(long j) throws IOException {
        writeFixed64NoTag(j);
    }

    public abstract void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException;

    @Deprecated
    public final void writeRawVarint32(int i2) throws IOException {
        writeUInt32NoTag(i2);
    }

    @Deprecated
    public final void writeRawVarint64(long j) throws IOException {
        writeUInt64NoTag(j);
    }

    public final void writeSFixed32(int i2, int i8) throws IOException {
        writeFixed32(i2, i8);
    }

    public final void writeSFixed32NoTag(int i2) throws IOException {
        writeFixed32NoTag(i2);
    }

    public final void writeSFixed64(int i2, long j) throws IOException {
        writeFixed64(i2, j);
    }

    public final void writeSFixed64NoTag(long j) throws IOException {
        writeFixed64NoTag(j);
    }

    public final void writeSInt32(int i2, int i8) throws IOException {
        writeUInt32(i2, encodeZigZag32(i8));
    }

    public final void writeSInt32NoTag(int i2) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i2));
    }

    public final void writeSInt64(int i2, long j) throws IOException {
        writeUInt64(i2, encodeZigZag64(j));
    }

    public final void writeSInt64NoTag(long j) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j));
    }

    public abstract void writeString(int i2, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i2, int i8) throws IOException;

    public abstract void writeUInt32(int i2, int i8) throws IOException;

    public abstract void writeUInt32NoTag(int i2) throws IOException;

    public abstract void writeUInt64(int i2, long j) throws IOException;

    public abstract void writeUInt64NoTag(long j) throws IOException;

    private CodedOutputStream() {
    }

    @Deprecated
    public static int computeGroupSize(int i2, MessageLite messageLite, c2 c2Var) {
        return computeGroupSizeNoTag(messageLite, c2Var) + (computeTagSize(i2) * 2);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite, c2 c2Var) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(c2Var);
    }

    public static int computeMessageSize(int i2, MessageLite messageLite, c2 c2Var) {
        return computeMessageSizeNoTag(messageLite, c2Var) + computeTagSize(i2);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite, c2 c2Var) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(c2Var));
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i2) {
        return new e(outputStream, i2);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite, c2 c2Var) throws IOException {
        c2Var.writeTo(messageLite, this.wrapper);
    }

    public final void writeRawByte(int i2) throws IOException {
        write((byte) i2);
    }

    public final void writeRawBytes(byte[] bArr, int i2, int i8) throws IOException {
        write(bArr, i2, i8);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.writeTo(this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i2, int i8) {
        return new b(bArr, i2, i8);
    }

    @Deprecated
    public final void writeGroup(int i2, MessageLite messageLite, c2 c2Var) throws IOException {
        writeTag(i2, 3);
        writeGroupNoTag(messageLite, c2Var);
        writeTag(i2, 4);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new d(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (g.isSupported()) {
                return newUnsafeInstance(byteBuffer);
            }
            return newSafeInstance(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i2) {
        return newInstance(byteBuffer);
    }

    public static CodedOutputStream newInstance(ByteOutput byteOutput, int i2) {
        if (i2 >= 0) {
            return new c(byteOutput, i2);
        }
        throw new IllegalArgumentException("bufferSize must be positive");
    }
}
