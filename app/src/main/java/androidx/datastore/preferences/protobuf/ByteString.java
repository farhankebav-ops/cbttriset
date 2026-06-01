package androidx.datastore.preferences.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    private static final ByteArrayCopier byteArrayCopier;
    private static final long serialVersionUID = 1;
    private int hash = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class AbstractByteIterator implements ByteIterator {
        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i2, int i8) {
            return Arrays.copyOfRange(bArr, i2, i8 + i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public BoundedByteString(byte[] bArr, int i2, int i8) {
            super(bArr);
            ByteString.checkRange(i2, i2 + i8, bArr.length);
            this.bytesOffset = i2;
            this.bytesLength = i8;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i2) {
            ByteString.checkIndex(i2, size());
            return this.bytes[this.bytesOffset + i2];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i2, int i8, int i9) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i2, bArr, i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public byte internalByteAt(int i2) {
            return this.bytes[this.bytesOffset + i2];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i2, int i8);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        private CodedBuilder(int i2) {
            byte[] bArr = new byte[i2];
            this.buffer = bArr;
            this.output = CodedOutputStream.newInstance(bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        public abstract boolean equalsRange(ByteString byteString, int i2, int i8);

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void writeToReverse(ByteOutput byteOutput) throws IOException {
            writeTo(byteOutput);
        }

        private LeafByteString() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        public LiteralByteString(byte[] bArr) {
            super();
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i2) {
            return this.bytes[i2];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i2, int i8, int i9) {
            System.arraycopy(this.bytes, i2, bArr, i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int iPeekCachedHashCode = peekCachedHashCode();
            int iPeekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (iPeekCachedHashCode == 0 || iPeekCachedHashCode2 == 0 || iPeekCachedHashCode == iPeekCachedHashCode2) {
                return equalsRange(literalByteString, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LeafByteString
        public final boolean equalsRange(ByteString byteString, int i2, int i8) {
            if (i8 > byteString.size()) {
                throw new IllegalArgumentException("Length too large: " + i8 + size());
            }
            int i9 = i2 + i8;
            if (i9 > byteString.size()) {
                StringBuilder sbW = a1.a.w(i2, "Ran off end of other: ", ", ", i8, ", ");
                sbW.append(byteString.size());
                throw new IllegalArgumentException(sbW.toString());
            }
            if (!(byteString instanceof LiteralByteString)) {
                return byteString.substring(i2, i9).equals(substring(0, i8));
            }
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            byte[] bArr = this.bytes;
            byte[] bArr2 = literalByteString.bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i8;
            int offsetIntoBytes2 = getOffsetIntoBytes();
            int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i2;
            while (offsetIntoBytes2 < offsetIntoBytes) {
                if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                    return false;
                }
                offsetIntoBytes2++;
                offsetIntoBytes3++;
            }
            return true;
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte internalByteAt(int i2) {
            return this.bytes[i2];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int partialHash(int i2, int i8, int i9) {
            return Internal.partialHash(i2, this.bytes, getOffsetIntoBytes() + i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final int partialIsValidUtf8(int i2, int i8, int i9) {
            int offsetIntoBytes = getOffsetIntoBytes() + i8;
            return Utf8.partialIsValidUtf8(i2, this.bytes, offsetIntoBytes, i9 + offsetIntoBytes);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteString substring(int i2, int i8) {
            int iCheckRange = ByteString.checkRange(i2, i8, size());
            return iCheckRange == 0 ? ByteString.EMPTY : new BoundedByteString(this.bytes, getOffsetIntoBytes() + i2, iCheckRange);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void writeToInternal(OutputStream outputStream, int i2, int i8) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i2, i8);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final void writeTo(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class NioByteString extends LeafByteString {
        private final ByteBuffer buffer;

        public NioByteString(ByteBuffer byteBuffer) {
            super();
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
            Java8Compatibility.position(byteBufferSlice, i2 - this.buffer.position());
            Java8Compatibility.limit(byteBufferSlice, i8 - this.buffer.position());
            return byteBufferSlice;
        }

        private Object writeReplace() {
            return ByteString.copyFrom(this.buffer.slice());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public ByteBuffer asReadOnlyByteBuffer() {
            return this.buffer.asReadOnlyBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i2) {
            try {
                return this.buffer.get(i2);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw e;
            } catch (IndexOutOfBoundsException e4) {
                throw new ArrayIndexOutOfBoundsException(e4.getMessage());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.buffer.slice());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i2, int i8, int i9) {
            ByteBuffer byteBufferSlice = this.buffer.slice();
            Java8Compatibility.position(byteBufferSlice, i2);
            byteBufferSlice.get(bArr, i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
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
            return obj instanceof NioByteString ? this.buffer.equals(((NioByteString) obj).buffer) : obj instanceof RopeByteString ? obj.equals(this) : this.buffer.equals(byteString.asReadOnlyByteBuffer());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LeafByteString
        public boolean equalsRange(ByteString byteString, int i2, int i8) {
            return substring(0, i8).equals(byteString.substring(i2, i8 + i2));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte internalByteAt(int i2) {
            return byteAt(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public boolean isValidUtf8() {
            return Utf8.isValidUtf8(this.buffer);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.buffer, true);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public InputStream newInput() {
            return new InputStream() { // from class: androidx.datastore.preferences.protobuf.ByteString.NioByteString.1
                private final ByteBuffer buf;

                {
                    this.buf = NioByteString.this.buffer.slice();
                }

                @Override // java.io.InputStream
                public int available() throws IOException {
                    return this.buf.remaining();
                }

                @Override // java.io.InputStream
                public void mark(int i2) {
                    Java8Compatibility.mark(this.buf);
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
                        Java8Compatibility.reset(this.buf);
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
            };
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int partialHash(int i2, int i8, int i9) {
            for (int i10 = i8; i10 < i8 + i9; i10++) {
                i2 = (i2 * 31) + this.buffer.get(i10);
            }
            return i2;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int partialIsValidUtf8(int i2, int i8, int i9) {
            return Utf8.partialIsValidUtf8(i2, this.buffer, i8, i9 + i8);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.buffer.remaining();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public ByteString substring(int i2, int i8) {
            try {
                return new NioByteString(slice(i2, i8));
            } catch (ArrayIndexOutOfBoundsException e) {
                throw e;
            } catch (IndexOutOfBoundsException e4) {
                throw new ArrayIndexOutOfBoundsException(e4.getMessage());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
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

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void writeToInternal(OutputStream outputStream, int i2, int i8) throws IOException {
            if (!this.buffer.hasArray()) {
                ByteBufferWriter.write(slice(i2, i8 + i2), outputStream);
                return;
            }
            outputStream.write(this.buffer.array(), this.buffer.position() + this.buffer.arrayOffset() + i2, i8);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public void writeTo(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.buffer.slice());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i2, int i8) {
            byte[] bArr2 = new byte[i8];
            System.arraycopy(bArr, i2, bArr2, 0, i8);
            return bArr2;
        }
    }

    static {
        byteArrayCopier = Android.isOnAndroidDevice() ? new SystemByteArrayCopier() : new ArraysByteArrayCopier();
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() { // from class: androidx.datastore.preferences.protobuf.ByteString.2
            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.datastore.preferences.protobuf.ByteString$ByteIterator, java.util.Iterator] */
            /* JADX WARN: Type inference failed for: r1v0, types: [androidx.datastore.preferences.protobuf.ByteString$ByteIterator, java.util.Iterator] */
            @Override // java.util.Comparator
            public int compare(ByteString byteString, ByteString byteString2) {
                ?? Iterator2 = byteString.iterator2();
                ?? Iterator22 = byteString2.iterator2();
                while (Iterator2.hasNext() && Iterator22.hasNext()) {
                    int iCompareTo = Integer.valueOf(ByteString.toInt(Iterator2.nextByte())).compareTo(Integer.valueOf(ByteString.toInt(Iterator22.nextByte())));
                    if (iCompareTo != 0) {
                        return iCompareTo;
                    }
                }
                return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
            }
        };
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(a1.a.h(i2, "length (", ") must be >= 1"));
        }
        if (i2 == 1) {
            return it.next();
        }
        int i8 = i2 >>> 1;
        return balancedConcat(it, i8).concat(balancedConcat(it, i2 - i8));
    }

    public static void checkIndex(int i2, int i8) {
        if (((i8 - (i2 + 1)) | i2) < 0) {
            if (i2 >= 0) {
                throw new ArrayIndexOutOfBoundsException(androidx.camera.core.processing.util.a.i("Index > length: ", i2, ", ", i8));
            }
            throw new ArrayIndexOutOfBoundsException(a1.a.g(i2, "Index < 0: "));
        }
    }

    @CanIgnoreReturnValue
    public static int checkRange(int i2, int i8, int i9) {
        int i10 = i8 - i2;
        if ((i2 | i8 | i10 | (i9 - i8)) >= 0) {
            return i10;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(a1.a.h(i2, "Beginning index: ", " < 0"));
        }
        if (i8 < i2) {
            throw new IndexOutOfBoundsException(androidx.camera.core.processing.util.a.i("Beginning index larger than ending index: ", i2, ", ", i8));
        }
        throw new IndexOutOfBoundsException(androidx.camera.core.processing.util.a.i("End index: ", i8, " >= ", i9));
    }

    public static ByteString copyFrom(byte[] bArr, int i2, int i8) {
        checkRange(i2, i2 + i8, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i2, i8));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.UTF_8));
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    private static int extractHexDigit(String str, int i2) {
        int iHexDigit = hexDigit(str.charAt(i2));
        if (iHexDigit != -1) {
            return iHexDigit;
        }
        StringBuilder sbY = a1.a.y("Invalid hexString ", str, " must only contain [0-9a-fA-F] but contained ");
        sbY.append(str.charAt(i2));
        sbY.append(" at index ");
        sbY.append(i2);
        throw new NumberFormatException(sbY.toString());
    }

    public static ByteString fromHex(@CompileTimeConstant String str) {
        if (str.length() % 2 != 0) {
            StringBuilder sbY = a1.a.y("Invalid hexString ", str, " of length ");
            sbY.append(str.length());
            sbY.append(" must be even.");
            throw new NumberFormatException(sbY.toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i8 = i2 * 2;
            bArr[i2] = (byte) (extractHexDigit(str, i8 + 1) | (extractHexDigit(str, i8) << 4));
        }
        return new LiteralByteString(bArr);
    }

    private static int hexDigit(char c7) {
        if (c7 >= '0' && c7 <= '9') {
            return c7 - '0';
        }
        if (c7 >= 'A' && c7 <= 'F') {
            return c7 - '7';
        }
        if (c7 < 'a' || c7 > 'f') {
            return -1;
        }
        return c7 - 'W';
    }

    public static CodedBuilder newCodedBuilder(int i2) {
        return new CodedBuilder(i2);
    }

    public static Output newOutput(int i2) {
        return new Output(i2);
    }

    public static ByteString nioByteString(ByteBuffer byteBuffer) {
        return new NioByteString(byteBuffer);
    }

    private static ByteString readChunk(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i8 = 0;
        while (i8 < i2) {
            int i9 = inputStream.read(bArr, i8, i2 - i8);
            if (i9 == -1) {
                break;
            }
            i8 += i9;
        }
        if (i8 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i8);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int toInt(byte b8) {
        return b8 & 255;
    }

    private String truncateAndEscapeForDisplay() {
        return size() <= 50 ? TextFormatEscaper.escapeBytes(this) : a1.a.r(new StringBuilder(), TextFormatEscaper.escapeBytes(substring(0, 47)), "...");
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public static ByteString wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return wrap(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i2);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i2) {
        copyTo(bArr, 0, i2, size());
    }

    public abstract void copyToInternal(byte[] bArr, int i2, int i8, int i9);

    public final boolean endsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString);
    }

    public abstract boolean equals(Object obj);

    public abstract int getTreeDepth();

    public final int hashCode() {
        int iPartialHash = this.hash;
        if (iPartialHash == 0) {
            int size = size();
            iPartialHash = partialHash(size, 0, size);
            if (iPartialHash == 0) {
                iPartialHash = 1;
            }
            this.hash = iPartialHash;
        }
        return iPartialHash;
    }

    public abstract byte internalByteAt(int i2);

    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int i2, int i8, int i9);

    public abstract int partialIsValidUtf8(int i2, int i8, int i9);

    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(0, byteString.size()).equals(byteString);
    }

    public final ByteString substring(int i2) {
        return substring(i2, size());
    }

    public abstract ByteString substring(int i2, int i8);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e);
            throw unsupportedEncodingException;
        }
    }

    public abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    public abstract void writeTo(ByteOutput byteOutput) throws IOException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public final void writeTo(OutputStream outputStream, int i2, int i8) throws IOException {
        checkRange(i2, i2 + i8, size());
        if (i8 > 0) {
            writeToInternal(outputStream, i2, i8);
        }
    }

    public abstract void writeToInternal(OutputStream outputStream, int i2, int i8) throws IOException;

    public abstract void writeToReverse(ByteOutput byteOutput) throws IOException;

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i2) throws IOException {
        return readFrom(inputStream, i2, i2);
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i2, int i8, int i9) {
        checkRange(i2, i2 + i9, size());
        checkRange(i8, i8 + i9, bArr.length);
        if (i9 > 0) {
            copyToInternal(bArr, i2, i8, i9);
        }
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Byte> iterator2() {
        return new AbstractByteIterator() { // from class: androidx.datastore.preferences.protobuf.ByteString.1
            private final int limit;
            private int position = 0;

            {
                this.limit = ByteString.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.position < this.limit;
            }

            @Override // androidx.datastore.preferences.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                int i2 = this.position;
                if (i2 >= this.limit) {
                    throw new NoSuchElementException();
                }
                this.position = i2 + 1;
                return ByteString.this.internalByteAt(i2);
            }
        };
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i2, int i8) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString chunk = readChunk(inputStream, i2);
            if (chunk == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(chunk);
            i2 = Math.min(i2 * 2, i8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        public Output(int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.initialCapacity = i2;
            this.flushedBuffers = new ArrayList<>();
            this.buffer = new byte[i2];
        }

        private void flushFullBuffer(int i2) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i2, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i2 = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i2 >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i2 > 0) {
                this.flushedBuffers.add(new LiteralByteString(Arrays.copyOf(bArr, i2)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        public synchronized void reset() {
            this.flushedBuffers.clear();
            this.flushedBuffersTotalBytes = 0;
            this.bufferPos = 0;
        }

        public synchronized int size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom(this.flushedBuffers);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i2) {
            try {
                if (this.bufferPos == this.buffer.length) {
                    flushFullBuffer(1);
                }
                byte[] bArr = this.buffer;
                int i8 = this.bufferPos;
                this.bufferPos = i8 + 1;
                bArr[i8] = (byte) i2;
            } catch (Throwable th) {
                throw th;
            }
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            int i2;
            ByteString[] byteStringArr;
            byte[] bArr;
            int i8;
            synchronized (this) {
                byteStringArr = (ByteString[]) this.flushedBuffers.toArray(new ByteString[0]);
                bArr = this.buffer;
                i8 = this.bufferPos;
            }
            for (ByteString byteString : byteStringArr) {
                byteString.writeTo(outputStream);
            }
            outputStream.write(Arrays.copyOf(bArr, i8));
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i2, int i8) {
            try {
                byte[] bArr2 = this.buffer;
                int length = bArr2.length;
                int i9 = this.bufferPos;
                if (i8 <= length - i9) {
                    System.arraycopy(bArr, i2, bArr2, i9, i8);
                    this.bufferPos += i8;
                } else {
                    int length2 = bArr2.length - i9;
                    System.arraycopy(bArr, i2, bArr2, i9, length2);
                    int i10 = i8 - length2;
                    flushFullBuffer(i10);
                    System.arraycopy(bArr, i2 + length2, this.buffer, 0, i10);
                    this.bufferPos = i10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i2) {
        checkRange(0, i2, byteBuffer.remaining());
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    public static ByteString wrap(byte[] bArr, int i2, int i8) {
        return new BoundedByteString(bArr, i2, i8);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        return a1.a.r(androidx.camera.core.processing.util.a.s("<ByteString@", size, hexString, " size=", " contents=\""), truncateAndEscapeForDisplay(), "\">");
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int size;
        if (!(iterable instanceof Collection)) {
            Iterator<ByteString> it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        } else {
            size = ((Collection) iterable).size();
        }
        if (size == 0) {
            return EMPTY;
        }
        return balancedConcat(iterable.iterator(), size);
    }
}
