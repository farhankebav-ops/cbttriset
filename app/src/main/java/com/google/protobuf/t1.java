package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class t1 extends ByteString.g {
    private final ByteBuffer buffer;

    public t1(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer slice(int i2, int i8) {
        if (i2 < this.buffer.position() || i8 > this.buffer.limit() || i2 > i8) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i2), Integer.valueOf(i8)));
        }
        ByteBuffer byteBufferSlice = this.buffer.slice();
        w0.position(byteBufferSlice, i2 - this.buffer.position());
        w0.limit(byteBufferSlice, i8 - this.buffer.position());
        return byteBufferSlice;
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i2) {
        try {
            return this.buffer.get(i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e4) {
            throw new ArrayIndexOutOfBoundsException(e4.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i2, int i8, int i9) {
        ByteBuffer byteBufferSlice = this.buffer.slice();
        w0.position(byteBufferSlice, i2);
        byteBufferSlice.get(bArr, i8, i9);
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        return obj instanceof t1 ? this.buffer.equals(((t1) obj).buffer) : obj instanceof b2 ? obj.equals(this) : this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString.g
    public boolean equalsRange(ByteString byteString, int i2, int i8) {
        return substring(0, i8).equals(byteString.substring(i2, i8 + i2));
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int i2) {
        return byteAt(i2);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        return s2.isValidUtf8(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new a();
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i2, int i8, int i9) {
        for (int i10 = i8; i10 < i8 + i9; i10++) {
            i2 = (i2 * 31) + this.buffer.get(i10);
        }
        return i2;
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i2, int i8, int i9) {
        return s2.partialIsValidUtf8(i2, this.buffer, i8, i9 + i8);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i2, int i8) {
        try {
            return new t1(slice(i2, i8));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e4) {
            throw new ArrayIndexOutOfBoundsException(e4.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public String toStringInternal(Charset charset) {
        byte[] byteArray;
        int length;
        int iPosition;
        if (this.buffer.hasArray()) {
            byteArray = this.buffer.array();
            iPosition = this.buffer.position() + this.buffer.arrayOffset();
            length = this.buffer.remaining();
        } else {
            byteArray = toByteArray();
            length = byteArray.length;
            iPosition = 0;
        }
        return new String(byteArray, iPosition, length, charset);
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i2, int i8) throws IOException {
        if (!this.buffer.hasArray()) {
            i.write(slice(i2, i8 + i2), outputStream);
            return;
        }
        outputStream.write(this.buffer.array(), this.buffer.position() + this.buffer.arrayOffset() + i2, i8);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends InputStream {
        private final ByteBuffer buf;

        public a() {
            this.buf = t1.this.buffer.slice();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.buf.remaining();
        }

        @Override // java.io.InputStream
        public void mark(int i2) {
            w0.mark(this.buf);
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.buf.hasRemaining()) {
                return this.buf.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            try {
                w0.reset(this.buf);
            } catch (InvalidMarkException e) {
                throw new IOException(e);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i8) throws IOException {
            if (!this.buf.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i8, this.buf.remaining());
            this.buf.get(bArr, i2, iMin);
            return iMin;
        }
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(ByteOutput byteOutput) throws IOException {
        byteOutput.writeLazy(this.buffer.slice());
    }
}
