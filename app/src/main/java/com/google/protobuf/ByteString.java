package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
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
/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new h(Internal.EMPTY_BYTE_ARRAY);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    private static final j byteArrayCopier;
    private static final long serialVersionUID = 1;
    private int hash = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends c {
        private final int limit;
        private int position = 0;

        public a() {
            this.limit = ByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.limit;
        }

        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            int i2 = this.position;
            if (i2 >= this.limit) {
                throw new NoSuchElementException();
            }
            this.position = i2 + 1;
            return ByteString.this.internalByteAt(i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Comparator {
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.protobuf.ByteString$ByteIterator, java.util.Iterator] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.protobuf.ByteString$ByteIterator, java.util.Iterator] */
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
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class c implements ByteIterator {
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
    public static final class d implements j {
        private d() {
        }

        @Override // com.google.protobuf.j
        public byte[] copyFrom(byte[] bArr, int i2, int i8) {
            return Arrays.copyOfRange(bArr, i2, i8 + i2);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class e extends h {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public e(byte[] bArr, int i2, int i8) {
            super(bArr);
            ByteString.checkRange(i2, i2 + i8, bArr.length);
            this.bytesOffset = i2;
            this.bytesLength = i8;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.protobuf.ByteString.h, com.google.protobuf.ByteString
        public byte byteAt(int i2) {
            ByteString.checkIndex(i2, size());
            return this.bytes[this.bytesOffset + i2];
        }

        @Override // com.google.protobuf.ByteString.h, com.google.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i2, int i8, int i9) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i2, bArr, i8, i9);
        }

        @Override // com.google.protobuf.ByteString.h
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.h, com.google.protobuf.ByteString
        public byte internalByteAt(int i2) {
            return this.bytes[this.bytesOffset + i2];
        }

        @Override // com.google.protobuf.ByteString.h, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class f {
        private final byte[] buffer;
        private final CodedOutputStream output;

        public /* synthetic */ f(int i2, a aVar) {
            this(i2);
        }

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new h(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        private f(int i2) {
            byte[] bArr = new byte[i2];
            this.buffer = bArr;
            this.output = CodedOutputStream.newInstance(bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class g extends ByteString {
        private static final long serialVersionUID = 1;

        public abstract boolean equalsRange(ByteString byteString, int i2, int i8);

        @Override // com.google.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator2();
        }

        @Override // com.google.protobuf.ByteString
        public void writeToReverse(ByteOutput byteOutput) throws IOException {
            writeTo(byteOutput);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class h extends g {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        public h(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int i2) {
            return this.bytes[i2];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public void copyToInternal(byte[] bArr, int i2, int i8, int i9) {
            System.arraycopy(this.bytes, i2, bArr, i8, i9);
        }

        @Override // com.google.protobuf.ByteString
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
            if (!(obj instanceof h)) {
                return obj.equals(this);
            }
            h hVar = (h) obj;
            int iPeekCachedHashCode = peekCachedHashCode();
            int iPeekCachedHashCode2 = hVar.peekCachedHashCode();
            if (iPeekCachedHashCode == 0 || iPeekCachedHashCode2 == 0 || iPeekCachedHashCode == iPeekCachedHashCode2) {
                return equalsRange(hVar, 0, size());
            }
            return false;
        }

        @Override // com.google.protobuf.ByteString.g
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
            if (!(byteString instanceof h)) {
                return byteString.substring(i2, i9).equals(substring(0, i8));
            }
            h hVar = (h) byteString;
            byte[] bArr = this.bytes;
            byte[] bArr2 = hVar.bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i8;
            int offsetIntoBytes2 = getOffsetIntoBytes();
            int offsetIntoBytes3 = hVar.getOffsetIntoBytes() + i2;
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

        @Override // com.google.protobuf.ByteString
        public byte internalByteAt(int i2) {
            return this.bytes[i2];
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return s2.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        @Override // com.google.protobuf.ByteString
        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.protobuf.ByteString
        public final int partialHash(int i2, int i8, int i9) {
            return Internal.partialHash(i2, this.bytes, getOffsetIntoBytes() + i8, i9);
        }

        @Override // com.google.protobuf.ByteString
        public final int partialIsValidUtf8(int i2, int i8, int i9) {
            int offsetIntoBytes = getOffsetIntoBytes() + i8;
            return s2.partialIsValidUtf8(i2, this.bytes, offsetIntoBytes, i9 + offsetIntoBytes);
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int i2, int i8) {
            int iCheckRange = ByteString.checkRange(i2, i8, size());
            return iCheckRange == 0 ? ByteString.EMPTY : new e(this.bytes, getOffsetIntoBytes() + i2, iCheckRange);
        }

        @Override // com.google.protobuf.ByteString
        public final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        @Override // com.google.protobuf.ByteString
        public final void writeToInternal(OutputStream outputStream, int i2, int i8) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i2, i8);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class i implements j {
        private i() {
        }

        @Override // com.google.protobuf.j
        public byte[] copyFrom(byte[] bArr, int i2, int i8) {
            byte[] bArr2 = new byte[i8];
            System.arraycopy(bArr, i2, bArr2, 0, i8);
            return bArr2;
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        byteArrayCopier = com.google.protobuf.b.isOnAndroidDevice() ? new i(aVar) : new d(aVar);
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new b();
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
        return new h(byteArrayCopier.copyFrom(bArr, i2, i8));
    }

    public static ByteString copyFromUtf8(String str) {
        return new h(str.getBytes(Internal.UTF_8));
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

    public static ByteString fromHex(String str) {
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
        return new h(bArr);
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

    public static f newCodedBuilder(int i2) {
        return new f(i2, null);
    }

    public static Output newOutput(int i2) {
        return new Output(i2);
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
        if (size() <= 50) {
            return j2.escapeBytes(this);
        }
        return j2.escapeBytes(substring(0, 47)) + "...";
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public static ByteString wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new t1(byteBuffer);
        }
        return wrap(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.remaining());
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i2);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return b2.concatenate(this, byteString);
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
        } catch (UnsupportedCharsetException e4) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e4);
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
        return new a();
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
            this.flushedBuffers.add(new h(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i2, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i2 = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i2 >= bArr.length) {
                this.flushedBuffers.add(new h(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i2 > 0) {
                this.flushedBuffers.add(new h(Arrays.copyOf(bArr, i2)));
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
        return new h(bArr);
    }

    public static ByteString wrap(byte[] bArr) {
        return new h(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    public static ByteString wrap(byte[] bArr, int i2, int i8) {
        return new e(bArr, i2, i8);
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
        return new h(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new h(str.getBytes(charset));
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
