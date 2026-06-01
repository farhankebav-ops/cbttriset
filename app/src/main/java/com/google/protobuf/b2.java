package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b2 extends ByteString {
    static final int[] minLengthByDepth = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a extends ByteString.c {
        ByteString.ByteIterator current = nextPiece();
        final c pieces;

        public a() {
            this.pieces = new c(b2.this, null);
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [com.google.protobuf.ByteString$ByteIterator] */
        private ByteString.ByteIterator nextPiece() {
            if (this.pieces.hasNext()) {
                return this.pieces.next().iterator2();
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null;
        }

        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            ByteString.ByteIterator byteIterator = this.current;
            if (byteIterator == null) {
                throw new NoSuchElementException();
            }
            byte bNextByte = byteIterator.nextByte();
            if (!this.current.hasNext()) {
                this.current = nextPiece();
            }
            return bNextByte;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class c implements Iterator {
        private final ArrayDeque<b2> breadCrumbs;
        private ByteString.g next;

        public /* synthetic */ c(ByteString byteString, a aVar) {
            this(byteString);
        }

        private ByteString.g getLeafByLeft(ByteString byteString) {
            while (byteString instanceof b2) {
                b2 b2Var = (b2) byteString;
                this.breadCrumbs.push(b2Var);
                byteString = b2Var.left;
            }
            return (ByteString.g) byteString;
        }

        private ByteString.g getNextNonEmptyLeaf() {
            ByteString.g leafByLeft;
            do {
                ArrayDeque<b2> arrayDeque = this.breadCrumbs;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                leafByLeft = getLeafByLeft(this.breadCrumbs.pop().right);
            } while (leafByLeft.isEmpty());
            return leafByLeft;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private c(ByteString byteString) {
            if (!(byteString instanceof b2)) {
                this.breadCrumbs = null;
                this.next = (ByteString.g) byteString;
                return;
            }
            b2 b2Var = (b2) byteString;
            ArrayDeque<b2> arrayDeque = new ArrayDeque<>(b2Var.getTreeDepth());
            this.breadCrumbs = arrayDeque;
            arrayDeque.push(b2Var);
            this.next = getLeafByLeft(b2Var.left);
        }

        @Override // java.util.Iterator
        public ByteString.g next() {
            ByteString.g gVar = this.next;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.next = getNextNonEmptyLeaf();
            return gVar;
        }
    }

    public /* synthetic */ b2(ByteString byteString, ByteString byteString2, a aVar) {
        this(byteString, byteString2);
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString2.size() + byteString.size();
        if (size < 128) {
            return concatenateBytes(byteString, byteString2);
        }
        if (byteString instanceof b2) {
            b2 b2Var = (b2) byteString;
            if (byteString2.size() + b2Var.right.size() < 128) {
                return new b2(b2Var.left, concatenateBytes(b2Var.right, byteString2));
            }
            if (b2Var.left.getTreeDepth() > b2Var.right.getTreeDepth() && b2Var.getTreeDepth() > byteString2.getTreeDepth()) {
                return new b2(b2Var.left, new b2(b2Var.right, byteString2));
            }
        }
        return size >= minLength(Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1) ? new b2(byteString, byteString2) : new b(null).balance(byteString, byteString2);
    }

    private static ByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.wrap(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        a aVar = null;
        c cVar = new c(this, aVar);
        ByteString.g gVar = (ByteString.g) cVar.next();
        c cVar2 = new c(byteString, aVar);
        ByteString.g gVar2 = (ByteString.g) cVar2.next();
        int i2 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int size = gVar.size() - i2;
            int size2 = gVar2.size() - i8;
            int iMin = Math.min(size, size2);
            if (!(i2 == 0 ? gVar.equalsRange(gVar2, i8, iMin) : gVar2.equalsRange(gVar, i2, iMin))) {
                return false;
            }
            i9 += iMin;
            int i10 = this.totalLength;
            if (i9 >= i10) {
                if (i9 == i10) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                i2 = 0;
                gVar = (ByteString.g) cVar.next();
            } else {
                i2 += iMin;
                gVar = gVar;
            }
            if (iMin == size2) {
                gVar2 = (ByteString.g) cVar2.next();
                i8 = 0;
            } else {
                i8 += iMin;
            }
        }
    }

    public static int minLength(int i2) {
        int[] iArr = minLengthByDepth;
        if (i2 >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i2];
    }

    public static b2 newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new b2(byteString, byteString2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this, null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i2) {
        ByteString.checkIndex(i2, this.totalLength);
        return internalByteAt(i2);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i2, int i8, int i9) {
        int i10 = i2 + i9;
        int i11 = this.leftLength;
        if (i10 <= i11) {
            this.left.copyToInternal(bArr, i2, i8, i9);
        } else {
            if (i2 >= i11) {
                this.right.copyToInternal(bArr, i2 - i11, i8, i9);
                return;
            }
            int i12 = i11 - i2;
            this.left.copyToInternal(bArr, i2, i8, i12);
            this.right.copyToInternal(bArr, 0, i8 + i12, i9 - i12);
        }
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
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int iPeekCachedHashCode = peekCachedHashCode();
        int iPeekCachedHashCode2 = byteString.peekCachedHashCode();
        if (iPeekCachedHashCode == 0 || iPeekCachedHashCode2 == 0 || iPeekCachedHashCode == iPeekCachedHashCode2) {
            return equalsFragments(byteString);
        }
        return false;
    }

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int i2) {
        int i8 = this.leftLength;
        return i2 < i8 ? this.left.internalByteAt(i2) : this.right.internalByteAt(i2 - i8);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        return this.totalLength >= minLength(this.treeDepth);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int iPartialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        return byteString.partialIsValidUtf8(iPartialIsValidUtf8, 0, byteString.size()) == 0;
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance((Iterable<ByteBuffer>) asReadOnlyByteBufferList(), true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new d();
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i2, int i8, int i9) {
        int i10 = i8 + i9;
        int i11 = this.leftLength;
        if (i10 <= i11) {
            return this.left.partialHash(i2, i8, i9);
        }
        if (i8 >= i11) {
            return this.right.partialHash(i2, i8 - i11, i9);
        }
        int i12 = i11 - i8;
        return this.right.partialHash(this.left.partialHash(i2, i8, i12), 0, i9 - i12);
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i2, int i8, int i9) {
        int i10 = i8 + i9;
        int i11 = this.leftLength;
        if (i10 <= i11) {
            return this.left.partialIsValidUtf8(i2, i8, i9);
        }
        if (i8 >= i11) {
            return this.right.partialIsValidUtf8(i2, i8 - i11, i9);
        }
        int i12 = i11 - i8;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i2, i8, i12), 0, i9 - i12);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i2, int i8) {
        int iCheckRange = ByteString.checkRange(i2, i8, this.totalLength);
        if (iCheckRange == 0) {
            return ByteString.EMPTY;
        }
        if (iCheckRange == this.totalLength) {
            return this;
        }
        int i9 = this.leftLength;
        return i8 <= i9 ? this.left.substring(i2, i8) : i2 >= i9 ? this.right.substring(i2 - i9, i8 - i9) : new b2(this.left.substring(i2), this.right.substring(0, i8 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    public String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i2, int i8) throws IOException {
        int i9 = i2 + i8;
        int i10 = this.leftLength;
        if (i9 <= i10) {
            this.left.writeToInternal(outputStream, i2, i8);
        } else {
            if (i2 >= i10) {
                this.right.writeToInternal(outputStream, i2 - i10, i8);
                return;
            }
            int i11 = i10 - i2;
            this.left.writeToInternal(outputStream, i2, i11);
            this.right.writeToInternal(outputStream, 0, i8 - i11);
        }
    }

    @Override // com.google.protobuf.ByteString
    public void writeToReverse(ByteOutput byteOutput) throws IOException {
        this.right.writeToReverse(byteOutput);
        this.left.writeToReverse(byteOutput);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b {
        private final ArrayDeque<ByteString> prefixesStack;

        private b() {
            this.prefixesStack = new ArrayDeque<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            doBalance(byteString);
            doBalance(byteString2);
            ByteString byteStringPop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty()) {
                byteStringPop = new b2(this.prefixesStack.pop(), byteStringPop, null);
            }
            return byteStringPop;
        }

        private void doBalance(ByteString byteString) {
            if (byteString.isBalanced()) {
                insert(byteString);
                return;
            }
            if (!(byteString instanceof b2)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
            b2 b2Var = (b2) byteString;
            doBalance(b2Var.left);
            doBalance(b2Var.right);
        }

        private int getDepthBinForLength(int i2) {
            int iBinarySearch = Arrays.binarySearch(b2.minLengthByDepth, i2);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        private void insert(ByteString byteString) {
            a aVar;
            int depthBinForLength = getDepthBinForLength(byteString.size());
            int iMinLength = b2.minLength(depthBinForLength + 1);
            if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= iMinLength) {
                this.prefixesStack.push(byteString);
                return;
            }
            int iMinLength2 = b2.minLength(depthBinForLength);
            ByteString byteStringPop = this.prefixesStack.pop();
            while (true) {
                aVar = null;
                if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= iMinLength2) {
                    break;
                } else {
                    byteStringPop = new b2(this.prefixesStack.pop(), byteStringPop, aVar);
                }
            }
            b2 b2Var = new b2(byteStringPop, byteString, aVar);
            while (!this.prefixesStack.isEmpty()) {
                if (this.prefixesStack.peek().size() >= b2.minLength(getDepthBinForLength(b2Var.size()) + 1)) {
                    break;
                } else {
                    b2Var = new b2(this.prefixesStack.pop(), b2Var, aVar);
                }
            }
            this.prefixesStack.push(b2Var);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    private b2(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = byteString2.size() + size;
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new a();
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(ByteOutput byteOutput) throws IOException {
        this.left.writeTo(byteOutput);
        this.right.writeTo(byteOutput);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d extends InputStream {
        private ByteString.g currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private c pieceIterator;

        public d() {
            initialize();
        }

        private void advanceIfCurrentPieceFullyRead() {
            if (this.currentPiece != null) {
                int i2 = this.currentPieceIndex;
                int i8 = this.currentPieceSize;
                if (i2 == i8) {
                    this.currentPieceOffsetInRope += i8;
                    this.currentPieceIndex = 0;
                    if (!this.pieceIterator.hasNext()) {
                        this.currentPiece = null;
                        this.currentPieceSize = 0;
                    } else {
                        ByteString.g next = this.pieceIterator.next();
                        this.currentPiece = next;
                        this.currentPieceSize = next.size();
                    }
                }
            }
        }

        private int availableInternal() {
            return b2.this.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
        }

        private void initialize() {
            c cVar = new c(b2.this, null);
            this.pieceIterator = cVar;
            ByteString.g next = cVar.next();
            this.currentPiece = next;
            this.currentPieceSize = next.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private int readSkipInternal(byte[] bArr, int i2, int i8) {
            int i9 = i8;
            while (i9 > 0) {
                advanceIfCurrentPieceFullyRead();
                if (this.currentPiece == null) {
                    break;
                }
                int iMin = Math.min(this.currentPieceSize - this.currentPieceIndex, i9);
                if (bArr != null) {
                    this.currentPiece.copyTo(bArr, this.currentPieceIndex, i2, iMin);
                    i2 += iMin;
                }
                this.currentPieceIndex += iMin;
                i9 -= iMin;
            }
            return i8 - i9;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return availableInternal();
        }

        @Override // java.io.InputStream
        public void mark(int i2) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i8) {
            bArr.getClass();
            if (i2 < 0 || i8 < 0 || i8 > bArr.length - i2) {
                throw new IndexOutOfBoundsException();
            }
            int skipInternal = readSkipInternal(bArr, i2, i8);
            if (skipInternal != 0) {
                return skipInternal;
            }
            if (i8 > 0 || availableInternal() == 0) {
                return -1;
            }
            return skipInternal;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            initialize();
            readSkipInternal(null, 0, this.mark);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (j < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return readSkipInternal(null, 0, (int) j);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            ByteString.g gVar = this.currentPiece;
            if (gVar == null) {
                return -1;
            }
            int i2 = this.currentPieceIndex;
            this.currentPieceIndex = i2 + 1;
            return gVar.byteAt(i2) & 255;
        }
    }
}
