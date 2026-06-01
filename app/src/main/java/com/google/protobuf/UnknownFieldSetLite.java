package com.google.protobuf;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void ensureCapacity(int i2) {
        int[] iArr = this.tags;
        if (i2 > iArr.length) {
            int i8 = this.count;
            int i9 = (i8 / 2) + i8;
            if (i9 >= i2) {
                i2 = i9;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.tags = Arrays.copyOf(iArr, i2);
            this.objects = Arrays.copyOf(this.objects, i2);
        }
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static int hashCode(int[] iArr, int i2) {
        int i8 = 17;
        for (int i9 = 0; i9 < i2; i9++) {
            i8 = (i8 * 31) + iArr[i9];
        }
        return i8;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream codedInputStream) throws IOException {
        int tag;
        do {
            tag = codedInputStream.readTag();
            if (tag == 0) {
                break;
            }
        } while (mergeFieldFrom(tag, codedInputStream));
        return this;
    }

    public static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i2 = unknownFieldSetLite.count + unknownFieldSetLite2.count;
        int[] iArrCopyOf = Arrays.copyOf(unknownFieldSetLite.tags, i2);
        System.arraycopy(unknownFieldSetLite2.tags, 0, iArrCopyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        Object[] objArrCopyOf = Arrays.copyOf(unknownFieldSetLite.objects, i2);
        System.arraycopy(unknownFieldSetLite2.objects, 0, objArrCopyOf, unknownFieldSetLite.count, unknownFieldSetLite2.count);
        return new UnknownFieldSetLite(i2, iArrCopyOf, objArrCopyOf, true);
    }

    public static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    private static boolean objectsEquals(Object[] objArr, Object[] objArr2, int i2) {
        for (int i8 = 0; i8 < i2; i8++) {
            if (!objArr[i8].equals(objArr2[i8])) {
                return false;
            }
        }
        return true;
    }

    private static boolean tagsEquals(int[] iArr, int[] iArr2, int i2) {
        for (int i8 = 0; i8 < i2; i8++) {
            if (iArr[i8] != iArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    private static void writeField(int i2, Object obj, v2 v2Var) throws IOException {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i2);
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            v2Var.writeInt64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 1) {
            v2Var.writeFixed64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 2) {
            v2Var.writeBytes(tagFieldNumber, (ByteString) obj);
            return;
        }
        if (tagWireType != 3) {
            if (tagWireType != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
            }
            v2Var.writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
        } else if (v2Var.fieldOrder() == Writer$FieldOrder.ASCENDING) {
            v2Var.writeStartGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(v2Var);
            v2Var.writeEndGroup(tagFieldNumber);
        } else {
            v2Var.writeEndGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).writeTo(v2Var);
            v2Var.writeStartGroup(tagFieldNumber);
        }
    }

    public void checkMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i2 = this.count;
        return i2 == unknownFieldSetLite.count && tagsEquals(this.tags, unknownFieldSetLite.tags, i2) && objectsEquals(this.objects, unknownFieldSetLite.objects, this.count);
    }

    public int getSerializedSize() {
        int iComputeUInt64Size;
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int serializedSize = 0;
        for (int i8 = 0; i8 < this.count; i8++) {
            int i9 = this.tags[i8];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i9);
            int tagWireType = WireFormat.getTagWireType(i9);
            if (tagWireType == 0) {
                iComputeUInt64Size = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.objects[i8]).longValue());
            } else if (tagWireType == 1) {
                iComputeUInt64Size = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.objects[i8]).longValue());
            } else if (tagWireType == 2) {
                iComputeUInt64Size = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.objects[i8]);
            } else if (tagWireType == 3) {
                serializedSize = ((UnknownFieldSetLite) this.objects[i8]).getSerializedSize() + (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + serializedSize;
            } else {
                if (tagWireType != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
                }
                iComputeUInt64Size = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.objects[i8]).intValue());
            }
            serializedSize = iComputeUInt64Size + serializedSize;
        }
        this.memoizedSerializedSize = serializedSize;
        return serializedSize;
    }

    public int getSerializedSizeAsMessageSet() {
        int i2 = this.memoizedSerializedSize;
        if (i2 != -1) {
            return i2;
        }
        int iComputeRawMessageSetExtensionSize = 0;
        for (int i8 = 0; i8 < this.count; i8++) {
            iComputeRawMessageSetExtensionSize += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.tags[i8]), (ByteString) this.objects[i8]);
        }
        this.memoizedSerializedSize = iComputeRawMessageSetExtensionSize;
        return iComputeRawMessageSetExtensionSize;
    }

    public void makeImmutable() {
        if (this.isMutable) {
            this.isMutable = false;
        }
    }

    public boolean mergeFieldFrom(int i2, CodedInputStream codedInputStream) throws IOException {
        checkMutable();
        int tagFieldNumber = WireFormat.getTagFieldNumber(i2);
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            storeField(i2, Long.valueOf(codedInputStream.readInt64()));
            return true;
        }
        if (tagWireType == 1) {
            storeField(i2, Long.valueOf(codedInputStream.readFixed64()));
            return true;
        }
        if (tagWireType == 2) {
            storeField(i2, codedInputStream.readBytes());
            return true;
        }
        if (tagWireType == 3) {
            UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
            unknownFieldSetLite.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(WireFormat.makeTag(tagFieldNumber, 4));
            storeField(i2, unknownFieldSetLite);
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        storeField(i2, Integer.valueOf(codedInputStream.readFixed32()));
        return true;
    }

    public UnknownFieldSetLite mergeLengthDelimitedField(int i2, ByteString byteString) {
        checkMutable();
        if (i2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        storeField(WireFormat.makeTag(i2, 2), byteString);
        return this;
    }

    public UnknownFieldSetLite mergeVarintField(int i2, int i8) {
        checkMutable();
        if (i2 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        storeField(WireFormat.makeTag(i2, 0), Long.valueOf(i8));
        return this;
    }

    public final void printWithIndent(StringBuilder sb, int i2) {
        for (int i8 = 0; i8 < this.count; i8++) {
            k1.printField(sb, i2, String.valueOf(WireFormat.getTagFieldNumber(this.tags[i8])), this.objects[i8]);
        }
    }

    public void storeField(int i2, Object obj) {
        checkMutable();
        ensureCapacity(this.count + 1);
        int[] iArr = this.tags;
        int i8 = this.count;
        iArr[i8] = i2;
        this.objects[i8] = obj;
        this.count = i8 + 1;
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i2 = 0; i2 < this.count; i2++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.tags[i2]), (ByteString) this.objects[i2]);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i2 = 0; i2 < this.count; i2++) {
            int i8 = this.tags[i2];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i8);
            int tagWireType = WireFormat.getTagWireType(i8);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.objects[i2]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.objects[i2]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.objects[i2]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.objects[i2]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else {
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.objects[i2]).intValue());
            }
        }
    }

    private UnknownFieldSetLite(int i2, int[] iArr, Object[] objArr, boolean z2) {
        this.memoizedSerializedSize = -1;
        this.count = i2;
        this.tags = iArr;
        this.objects = objArr;
        this.isMutable = z2;
    }

    private static int hashCode(Object[] objArr, int i2) {
        int iHashCode = 17;
        for (int i8 = 0; i8 < i2; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return iHashCode;
    }

    public int hashCode() {
        int i2 = this.count;
        return ((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + i2) * 31) + hashCode(this.tags, i2)) * 31) + hashCode(this.objects, this.count);
    }

    public UnknownFieldSetLite mergeFrom(UnknownFieldSetLite unknownFieldSetLite) {
        if (unknownFieldSetLite.equals(getDefaultInstance())) {
            return this;
        }
        checkMutable();
        int i2 = this.count + unknownFieldSetLite.count;
        ensureCapacity(i2);
        System.arraycopy(unknownFieldSetLite.tags, 0, this.tags, this.count, unknownFieldSetLite.count);
        System.arraycopy(unknownFieldSetLite.objects, 0, this.objects, this.count, unknownFieldSetLite.count);
        this.count = i2;
        return this;
    }

    public void writeAsMessageSetTo(v2 v2Var) throws IOException {
        if (v2Var.fieldOrder() == Writer$FieldOrder.DESCENDING) {
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                v2Var.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i2]), this.objects[i2]);
            }
            return;
        }
        for (int i8 = 0; i8 < this.count; i8++) {
            v2Var.writeMessageSetItem(WireFormat.getTagFieldNumber(this.tags[i8]), this.objects[i8]);
        }
    }

    public void writeTo(v2 v2Var) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (v2Var.fieldOrder() == Writer$FieldOrder.ASCENDING) {
            for (int i2 = 0; i2 < this.count; i2++) {
                writeField(this.tags[i2], this.objects[i2], v2Var);
            }
            return;
        }
        for (int i8 = this.count - 1; i8 >= 0; i8--) {
            writeField(this.tags[i8], this.objects[i8], v2Var);
        }
    }
}
