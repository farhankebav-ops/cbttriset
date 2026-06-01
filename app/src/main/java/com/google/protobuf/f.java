package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.WireFormat;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    private f() {
    }

    private static void checkRecursionLimit(int i2) throws InvalidProtocolBufferException {
        if (i2 >= recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public static int decodeBoolList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) {
        h hVar = (h) protobufList;
        int iDecodeVarint64 = decodeVarint64(bArr, i8, aVar);
        hVar.addBoolean(aVar.long1 != 0);
        while (iDecodeVarint64 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint64, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeVarint64 = decodeVarint64(bArr, iDecodeVarint32, aVar);
            hVar.addBoolean(aVar.long1 != 0);
        }
        return iDecodeVarint64;
    }

    public static int decodeBytes(byte[] bArr, int i2, a aVar) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1;
        if (i8 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i8 > bArr.length - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i8 == 0) {
            aVar.object1 = ByteString.EMPTY;
            return iDecodeVarint32;
        }
        aVar.object1 = ByteString.copyFrom(bArr, iDecodeVarint32, i8);
        return iDecodeVarint32 + i8;
    }

    public static int decodeBytesList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i8, aVar);
        int i10 = aVar.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 > bArr.length - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i10 == 0) {
            protobufList.add(ByteString.EMPTY);
        } else {
            protobufList.add(ByteString.copyFrom(bArr, iDecodeVarint32, i10));
            iDecodeVarint32 += i10;
        }
        while (iDecodeVarint32 < i9) {
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, aVar);
            int i11 = aVar.int1;
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i11 > bArr.length - iDecodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i11 == 0) {
                protobufList.add(ByteString.EMPTY);
            } else {
                protobufList.add(ByteString.copyFrom(bArr, iDecodeVarint32, i11));
                iDecodeVarint32 += i11;
            }
        }
        return iDecodeVarint32;
    }

    public static double decodeDouble(byte[] bArr, int i2) {
        return Double.longBitsToDouble(decodeFixed64(bArr, i2));
    }

    public static int decodeDoubleList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) {
        t tVar = (t) protobufList;
        tVar.addDouble(decodeDouble(bArr, i8));
        int i10 = i8 + 8;
        while (i10 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, i10, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            tVar.addDouble(decodeDouble(bArr, iDecodeVarint32));
            i10 = iDecodeVarint32 + 8;
        }
        return i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int decodeExtension(int i2, byte[] bArr, int i8, int i9, GeneratedMessageLite.ExtendableMessage<?, ?> extendableMessage, GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension, p2 p2Var, a aVar) throws IOException {
        int i10;
        int i11;
        FieldSet fieldSet = extendableMessage.extensions;
        int i12 = i2 >>> 3;
        if (generatedExtension.descriptor.isRepeated() && generatedExtension.descriptor.isPacked()) {
            switch (e.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    t tVar = new t();
                    int iDecodePackedDoubleList = decodePackedDoubleList(bArr, i8, tVar, aVar);
                    fieldSet.setField(generatedExtension.descriptor, tVar);
                    return iDecodePackedDoubleList;
                case 2:
                    j0 j0Var = new j0();
                    int iDecodePackedFloatList = decodePackedFloatList(bArr, i8, j0Var, aVar);
                    fieldSet.setField(generatedExtension.descriptor, j0Var);
                    return iDecodePackedFloatList;
                case 3:
                case 4:
                    b1 b1Var = new b1();
                    int iDecodePackedVarint64List = decodePackedVarint64List(bArr, i8, b1Var, aVar);
                    fieldSet.setField(generatedExtension.descriptor, b1Var);
                    return iDecodePackedVarint64List;
                case 5:
                case 6:
                    p0 p0Var = new p0();
                    int iDecodePackedVarint32List = decodePackedVarint32List(bArr, i8, p0Var, aVar);
                    fieldSet.setField(generatedExtension.descriptor, p0Var);
                    return iDecodePackedVarint32List;
                case 7:
                case 8:
                    b1 b1Var2 = new b1();
                    int iDecodePackedFixed64List = decodePackedFixed64List(bArr, i8, b1Var2, aVar);
                    fieldSet.setField(generatedExtension.descriptor, b1Var2);
                    return iDecodePackedFixed64List;
                case 9:
                case 10:
                    p0 p0Var2 = new p0();
                    int iDecodePackedFixed32List = decodePackedFixed32List(bArr, i8, p0Var2, aVar);
                    fieldSet.setField(generatedExtension.descriptor, p0Var2);
                    return iDecodePackedFixed32List;
                case 11:
                    h hVar = new h();
                    int iDecodePackedBoolList = decodePackedBoolList(bArr, i8, hVar, aVar);
                    fieldSet.setField(generatedExtension.descriptor, hVar);
                    return iDecodePackedBoolList;
                case 12:
                    p0 p0Var3 = new p0();
                    int iDecodePackedSInt32List = decodePackedSInt32List(bArr, i8, p0Var3, aVar);
                    fieldSet.setField(generatedExtension.descriptor, p0Var3);
                    return iDecodePackedSInt32List;
                case 13:
                    b1 b1Var3 = new b1();
                    int iDecodePackedSInt64List = decodePackedSInt64List(bArr, i8, b1Var3, aVar);
                    fieldSet.setField(generatedExtension.descriptor, b1Var3);
                    return iDecodePackedSInt64List;
                case 14:
                    p0 p0Var4 = new p0();
                    int iDecodePackedVarint32List2 = decodePackedVarint32List(bArr, i8, p0Var4, aVar);
                    e2.filterUnknownEnumList(extendableMessage, i12, p0Var4, generatedExtension.descriptor.getEnumType(), (Object) null, p2Var);
                    fieldSet.setField(generatedExtension.descriptor, p0Var4);
                    return iDecodePackedVarint32List2;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.descriptor.getLiteType());
            }
        }
        Object objValueOf = null;
        if (generatedExtension.getLiteType() == WireFormat.FieldType.ENUM) {
            i8 = decodeVarint32(bArr, i8, aVar);
            if (generatedExtension.descriptor.getEnumType().findValueByNumber(aVar.int1) == null) {
                e2.storeUnknownEnum(extendableMessage, i12, aVar.int1, null, p2Var);
                return i8;
            }
            objValueOf = Integer.valueOf(aVar.int1);
        } else {
            switch (e.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    i10 = i8;
                    objValueOf = Double.valueOf(decodeDouble(bArr, i10));
                    i8 = i10 + 8;
                    break;
                case 2:
                    i11 = i8;
                    objValueOf = Float.valueOf(decodeFloat(bArr, i11));
                    i8 = i11 + 4;
                    break;
                case 3:
                case 4:
                    i8 = decodeVarint64(bArr, i8, aVar);
                    objValueOf = Long.valueOf(aVar.long1);
                    break;
                case 5:
                case 6:
                    i8 = decodeVarint32(bArr, i8, aVar);
                    objValueOf = Integer.valueOf(aVar.int1);
                    break;
                case 7:
                case 8:
                    i10 = i8;
                    objValueOf = Long.valueOf(decodeFixed64(bArr, i10));
                    i8 = i10 + 8;
                    break;
                case 9:
                case 10:
                    i11 = i8;
                    objValueOf = Integer.valueOf(decodeFixed32(bArr, i11));
                    i8 = i11 + 4;
                    break;
                case 11:
                    i8 = decodeVarint64(bArr, i8, aVar);
                    objValueOf = Boolean.valueOf(aVar.long1 != 0);
                    break;
                case 12:
                    i8 = decodeVarint32(bArr, i8, aVar);
                    objValueOf = Integer.valueOf(CodedInputStream.decodeZigZag32(aVar.int1));
                    break;
                case 13:
                    i8 = decodeVarint64(bArr, i8, aVar);
                    objValueOf = Long.valueOf(CodedInputStream.decodeZigZag64(aVar.long1));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i8 = decodeBytes(bArr, i8, aVar);
                    objValueOf = aVar.object1;
                    break;
                case 16:
                    i8 = decodeString(bArr, i8, aVar);
                    objValueOf = aVar.object1;
                    break;
                case 17:
                    int i13 = (i12 << 3) | 4;
                    c2 c2VarSchemaFor = x1.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int iDecodeGroupField = decodeGroupField(c2VarSchemaFor, bArr, i8, i9, i13, aVar);
                        fieldSet.addRepeatedField(generatedExtension.descriptor, aVar.object1);
                        return iDecodeGroupField;
                    }
                    Object field = fieldSet.getField(generatedExtension.descriptor);
                    if (field == null) {
                        field = c2VarSchemaFor.newInstance();
                        fieldSet.setField(generatedExtension.descriptor, field);
                    }
                    return mergeGroupField(field, c2VarSchemaFor, bArr, i8, i9, i13, aVar);
                case 18:
                    c2 c2VarSchemaFor2 = x1.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int iDecodeMessageField = decodeMessageField(c2VarSchemaFor2, bArr, i8, i9, aVar);
                        fieldSet.addRepeatedField(generatedExtension.descriptor, aVar.object1);
                        return iDecodeMessageField;
                    }
                    Object field2 = fieldSet.getField(generatedExtension.descriptor);
                    if (field2 == null) {
                        field2 = c2VarSchemaFor2.newInstance();
                        fieldSet.setField(generatedExtension.descriptor, field2);
                    }
                    return mergeMessageField(field2, c2VarSchemaFor2, bArr, i8, i9, aVar);
            }
        }
        if (generatedExtension.isRepeated()) {
            fieldSet.addRepeatedField(generatedExtension.descriptor, objValueOf);
            return i8;
        }
        fieldSet.setField(generatedExtension.descriptor, objValueOf);
        return i8;
    }

    public static int decodeExtensionOrUnknownField(int i2, byte[] bArr, int i8, int i9, Object obj, MessageLite messageLite, p2 p2Var, a aVar) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtensionFindLiteExtensionByNumber = aVar.extensionRegistry.findLiteExtensionByNumber(messageLite, i2 >>> 3);
        if (generatedExtensionFindLiteExtensionByNumber == null) {
            return decodeUnknownField(i2, bArr, i8, i9, m1.getMutableUnknownFields(obj), aVar);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return decodeExtension(i2, bArr, i8, i9, extendableMessage, generatedExtensionFindLiteExtensionByNumber, p2Var, aVar);
    }

    public static int decodeFixed32(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static int decodeFixed32List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) {
        p0 p0Var = (p0) protobufList;
        p0Var.addInt(decodeFixed32(bArr, i8));
        int i10 = i8 + 4;
        while (i10 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, i10, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            p0Var.addInt(decodeFixed32(bArr, iDecodeVarint32));
            i10 = iDecodeVarint32 + 4;
        }
        return i10;
    }

    public static long decodeFixed64(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public static int decodeFixed64List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) {
        b1 b1Var = (b1) protobufList;
        b1Var.addLong(decodeFixed64(bArr, i8));
        int i10 = i8 + 8;
        while (i10 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, i10, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            b1Var.addLong(decodeFixed64(bArr, iDecodeVarint32));
            i10 = iDecodeVarint32 + 8;
        }
        return i10;
    }

    public static float decodeFloat(byte[] bArr, int i2) {
        return Float.intBitsToFloat(decodeFixed32(bArr, i2));
    }

    public static int decodeFloatList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) {
        j0 j0Var = (j0) protobufList;
        j0Var.addFloat(decodeFloat(bArr, i8));
        int i10 = i8 + 4;
        while (i10 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, i10, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            j0Var.addFloat(decodeFloat(bArr, iDecodeVarint32));
            i10 = iDecodeVarint32 + 4;
        }
        return i10;
    }

    public static int decodeGroupField(c2 c2Var, byte[] bArr, int i2, int i8, int i9, a aVar) throws IOException {
        Object objNewInstance = c2Var.newInstance();
        int iMergeGroupField = mergeGroupField(objNewInstance, c2Var, bArr, i2, i8, i9, aVar);
        c2Var.makeImmutable(objNewInstance);
        aVar.object1 = objNewInstance;
        return iMergeGroupField;
    }

    public static int decodeGroupList(c2 c2Var, int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        int i10 = (i2 & (-8)) | 4;
        int iDecodeGroupField = decodeGroupField(c2Var, bArr, i8, i9, i10, aVar);
        protobufList.add(aVar.object1);
        while (iDecodeGroupField < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeGroupField, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeGroupField = decodeGroupField(c2Var, bArr, iDecodeVarint32, i9, i10, aVar);
            protobufList.add(aVar.object1);
        }
        return iDecodeGroupField;
    }

    public static int decodeMessageField(c2 c2Var, byte[] bArr, int i2, int i8, a aVar) throws IOException {
        Object objNewInstance = c2Var.newInstance();
        int iMergeMessageField = mergeMessageField(objNewInstance, c2Var, bArr, i2, i8, aVar);
        c2Var.makeImmutable(objNewInstance);
        aVar.object1 = objNewInstance;
        return iMergeMessageField;
    }

    public static int decodeMessageList(c2 c2Var, int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        int iDecodeMessageField = decodeMessageField(c2Var, bArr, i8, i9, aVar);
        protobufList.add(aVar.object1);
        while (iDecodeMessageField < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeMessageField, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeMessageField = decodeMessageField(c2Var, bArr, iDecodeVarint32, i9, aVar);
            protobufList.add(aVar.object1);
        }
        return iDecodeMessageField;
    }

    public static int decodePackedBoolList(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        h hVar = (h) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint64(bArr, iDecodeVarint32, aVar);
            hVar.addBoolean(aVar.long1 != 0);
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedDoubleList(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        t tVar = (t) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            tVar.addDouble(decodeDouble(bArr, iDecodeVarint32));
            iDecodeVarint32 += 8;
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed32List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        p0 p0Var = (p0) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            p0Var.addInt(decodeFixed32(bArr, iDecodeVarint32));
            iDecodeVarint32 += 4;
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed64List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        b1 b1Var = (b1) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            b1Var.addLong(decodeFixed64(bArr, iDecodeVarint32));
            iDecodeVarint32 += 8;
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFloatList(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        j0 j0Var = (j0) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            j0Var.addFloat(decodeFloat(bArr, iDecodeVarint32));
            iDecodeVarint32 += 4;
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt32List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        p0 p0Var = (p0) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint32, aVar);
            p0Var.addInt(CodedInputStream.decodeZigZag32(aVar.int1));
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt64List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        b1 b1Var = (b1) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint64(bArr, iDecodeVarint32, aVar);
            b1Var.addLong(CodedInputStream.decodeZigZag64(aVar.long1));
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint32List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        p0 p0Var = (p0) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint32, aVar);
            p0Var.addInt(aVar.int1);
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint64List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, a aVar) throws IOException {
        b1 b1Var = (b1) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint64(bArr, iDecodeVarint32, aVar);
            b1Var.addLong(aVar.long1);
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeSInt32List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) {
        p0 p0Var = (p0) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i8, aVar);
        p0Var.addInt(CodedInputStream.decodeZigZag32(aVar.int1));
        while (iDecodeVarint32 < i9) {
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, aVar);
            p0Var.addInt(CodedInputStream.decodeZigZag32(aVar.int1));
        }
        return iDecodeVarint32;
    }

    public static int decodeSInt64List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) {
        b1 b1Var = (b1) protobufList;
        int iDecodeVarint64 = decodeVarint64(bArr, i8, aVar);
        b1Var.addLong(CodedInputStream.decodeZigZag64(aVar.long1));
        while (iDecodeVarint64 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint64, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeVarint64 = decodeVarint64(bArr, iDecodeVarint32, aVar);
            b1Var.addLong(CodedInputStream.decodeZigZag64(aVar.long1));
        }
        return iDecodeVarint64;
    }

    public static int decodeString(byte[] bArr, int i2, a aVar) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1;
        if (i8 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i8 == 0) {
            aVar.object1 = "";
            return iDecodeVarint32;
        }
        aVar.object1 = new String(bArr, iDecodeVarint32, i8, Internal.UTF_8);
        return iDecodeVarint32 + i8;
    }

    public static int decodeStringList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i8, aVar);
        int i10 = aVar.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 == 0) {
            protobufList.add("");
        } else {
            protobufList.add(new String(bArr, iDecodeVarint32, i10, Internal.UTF_8));
            iDecodeVarint32 += i10;
        }
        while (iDecodeVarint32 < i9) {
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, aVar);
            int i11 = aVar.int1;
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i11 == 0) {
                protobufList.add("");
            } else {
                protobufList.add(new String(bArr, iDecodeVarint32, i11, Internal.UTF_8));
                iDecodeVarint32 += i11;
            }
        }
        return iDecodeVarint32;
    }

    public static int decodeStringListRequireUtf8(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i8, aVar);
        int i10 = aVar.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 == 0) {
            protobufList.add("");
        } else {
            int i11 = iDecodeVarint32 + i10;
            if (!s2.isValidUtf8(bArr, iDecodeVarint32, i11)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            protobufList.add(new String(bArr, iDecodeVarint32, i10, Internal.UTF_8));
            iDecodeVarint32 = i11;
        }
        while (iDecodeVarint32 < i9) {
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, aVar);
            int i12 = aVar.int1;
            if (i12 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i12 == 0) {
                protobufList.add("");
            } else {
                int i13 = iDecodeVarint32 + i12;
                if (!s2.isValidUtf8(bArr, iDecodeVarint32, i13)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                protobufList.add(new String(bArr, iDecodeVarint32, i12, Internal.UTF_8));
                iDecodeVarint32 = i13;
            }
        }
        return iDecodeVarint32;
    }

    public static int decodeStringRequireUtf8(byte[] bArr, int i2, a aVar) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i2, aVar);
        int i8 = aVar.int1;
        if (i8 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i8 == 0) {
            aVar.object1 = "";
            return iDecodeVarint32;
        }
        aVar.object1 = s2.decodeUtf8(bArr, iDecodeVarint32, i8);
        return iDecodeVarint32 + i8;
    }

    public static int decodeUnknownField(int i2, byte[] bArr, int i8, int i9, UnknownFieldSetLite unknownFieldSetLite, a aVar) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i2) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            int iDecodeVarint64 = decodeVarint64(bArr, i8, aVar);
            unknownFieldSetLite.storeField(i2, Long.valueOf(aVar.long1));
            return iDecodeVarint64;
        }
        if (tagWireType == 1) {
            unknownFieldSetLite.storeField(i2, Long.valueOf(decodeFixed64(bArr, i8)));
            return i8 + 8;
        }
        if (tagWireType == 2) {
            int iDecodeVarint32 = decodeVarint32(bArr, i8, aVar);
            int i10 = aVar.int1;
            if (i10 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i10 > bArr.length - iDecodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i10 == 0) {
                unknownFieldSetLite.storeField(i2, ByteString.EMPTY);
            } else {
                unknownFieldSetLite.storeField(i2, ByteString.copyFrom(bArr, iDecodeVarint32, i10));
            }
            return iDecodeVarint32 + i10;
        }
        if (tagWireType != 3) {
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            unknownFieldSetLite.storeField(i2, Integer.valueOf(decodeFixed32(bArr, i8)));
            return i8 + 4;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        int i11 = (i2 & (-8)) | 4;
        int i12 = aVar.recursionDepth + 1;
        aVar.recursionDepth = i12;
        checkRecursionLimit(i12);
        int i13 = 0;
        while (true) {
            if (i8 >= i9) {
                break;
            }
            int iDecodeVarint322 = decodeVarint32(bArr, i8, aVar);
            i13 = aVar.int1;
            if (i13 == i11) {
                i8 = iDecodeVarint322;
                break;
            }
            i8 = decodeUnknownField(i13, bArr, iDecodeVarint322, i9, unknownFieldSetLiteNewInstance, aVar);
        }
        aVar.recursionDepth--;
        if (i8 > i9 || i13 != i11) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        unknownFieldSetLite.storeField(i2, unknownFieldSetLiteNewInstance);
        return i8;
    }

    public static int decodeVarint32(byte[] bArr, int i2, a aVar) {
        int i8 = i2 + 1;
        byte b8 = bArr[i2];
        if (b8 < 0) {
            return decodeVarint32(b8, bArr, i8, aVar);
        }
        aVar.int1 = b8;
        return i8;
    }

    public static int decodeVarint32List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) {
        p0 p0Var = (p0) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i8, aVar);
        p0Var.addInt(aVar.int1);
        while (iDecodeVarint32 < i9) {
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, aVar);
            p0Var.addInt(aVar.int1);
        }
        return iDecodeVarint32;
    }

    public static int decodeVarint64(byte[] bArr, int i2, a aVar) {
        int i8 = i2 + 1;
        long j = bArr[i2];
        if (j < 0) {
            return decodeVarint64(j, bArr, i8, aVar);
        }
        aVar.long1 = j;
        return i8;
    }

    public static int decodeVarint64List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, a aVar) {
        b1 b1Var = (b1) protobufList;
        int iDecodeVarint64 = decodeVarint64(bArr, i8, aVar);
        b1Var.addLong(aVar.long1);
        while (iDecodeVarint64 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint64, aVar);
            if (i2 != aVar.int1) {
                break;
            }
            iDecodeVarint64 = decodeVarint64(bArr, iDecodeVarint32, aVar);
            b1Var.addLong(aVar.long1);
        }
        return iDecodeVarint64;
    }

    public static int mergeGroupField(Object obj, c2 c2Var, byte[] bArr, int i2, int i8, int i9, a aVar) throws IOException {
        int i10 = aVar.recursionDepth + 1;
        aVar.recursionDepth = i10;
        checkRecursionLimit(i10);
        int message = ((m1) c2Var).parseMessage(obj, bArr, i2, i8, i9, aVar);
        aVar.recursionDepth--;
        aVar.object1 = obj;
        return message;
    }

    public static int mergeMessageField(Object obj, c2 c2Var, byte[] bArr, int i2, int i8, a aVar) throws IOException {
        int iDecodeVarint32 = i2 + 1;
        int i9 = bArr[i2];
        if (i9 < 0) {
            iDecodeVarint32 = decodeVarint32(i9, bArr, iDecodeVarint32, aVar);
            i9 = aVar.int1;
        }
        int i10 = iDecodeVarint32;
        if (i9 < 0 || i9 > i8 - i10) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i11 = aVar.recursionDepth + 1;
        aVar.recursionDepth = i11;
        checkRecursionLimit(i11);
        int i12 = i10 + i9;
        c2Var.mergeFrom(obj, bArr, i10, i12, aVar);
        aVar.recursionDepth--;
        aVar.object1 = obj;
        return i12;
    }

    public static void setRecursionLimit(int i2) {
        recursionLimit = i2;
    }

    public static int skipField(int i2, byte[] bArr, int i8, int i9, a aVar) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i2) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            return decodeVarint64(bArr, i8, aVar);
        }
        if (tagWireType == 1) {
            return i8 + 8;
        }
        if (tagWireType == 2) {
            return decodeVarint32(bArr, i8, aVar) + aVar.int1;
        }
        if (tagWireType != 3) {
            if (tagWireType == 5) {
                return i8 + 4;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        int i10 = (i2 & (-8)) | 4;
        int i11 = 0;
        while (i8 < i9) {
            i8 = decodeVarint32(bArr, i8, aVar);
            i11 = aVar.int1;
            if (i11 == i10) {
                break;
            }
            i8 = skipField(i11, bArr, i8, i9, aVar);
        }
        if (i8 > i9 || i11 != i10) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i8;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;
        public int recursionDepth;

        public a() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        public a(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    public static int decodeVarint32(int i2, byte[] bArr, int i8, a aVar) {
        int i9 = i2 & 127;
        int i10 = i8 + 1;
        byte b8 = bArr[i8];
        if (b8 >= 0) {
            aVar.int1 = i9 | (b8 << 7);
            return i10;
        }
        int i11 = i9 | ((b8 & 127) << 7);
        int i12 = i8 + 2;
        byte b9 = bArr[i10];
        if (b9 >= 0) {
            aVar.int1 = i11 | (b9 << 14);
            return i12;
        }
        int i13 = i11 | ((b9 & 127) << 14);
        int i14 = i8 + 3;
        byte b10 = bArr[i12];
        if (b10 >= 0) {
            aVar.int1 = i13 | (b10 << 21);
            return i14;
        }
        int i15 = i13 | ((b10 & 127) << 21);
        int i16 = i8 + 4;
        byte b11 = bArr[i14];
        if (b11 >= 0) {
            aVar.int1 = i15 | (b11 << 28);
            return i16;
        }
        int i17 = i15 | ((b11 & 127) << 28);
        while (true) {
            int i18 = i16 + 1;
            if (bArr[i16] >= 0) {
                aVar.int1 = i17;
                return i18;
            }
            i16 = i18;
        }
    }

    public static int decodeVarint64(long j, byte[] bArr, int i2, a aVar) {
        int i8 = i2 + 1;
        byte b8 = bArr[i2];
        long j3 = (j & 127) | (((long) (b8 & 127)) << 7);
        int i9 = 7;
        while (b8 < 0) {
            int i10 = i8 + 1;
            byte b9 = bArr[i8];
            i9 += 7;
            j3 |= ((long) (b9 & 127)) << i9;
            i8 = i10;
            b8 = b9;
        }
        aVar.long1 = j3;
        return i8;
    }
}
