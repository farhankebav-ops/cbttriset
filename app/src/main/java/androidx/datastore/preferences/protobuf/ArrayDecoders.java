package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class ArrayDecoders {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.ArrayDecoders$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    private ArrayDecoders() {
    }

    private static void checkRecursionLimit(int i2) throws InvalidProtocolBufferException {
        if (i2 >= recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public static int decodeBoolList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int iDecodeVarint64 = decodeVarint64(bArr, i8, registers);
        booleanArrayList.addBoolean(registers.long1 != 0);
        while (iDecodeVarint64 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint64, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeVarint64 = decodeVarint64(bArr, iDecodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        return iDecodeVarint64;
    }

    public static int decodeBytes(byte[] bArr, int i2, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1;
        if (i8 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i8 > bArr.length - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i8 == 0) {
            registers.object1 = ByteString.EMPTY;
            return iDecodeVarint32;
        }
        registers.object1 = ByteString.copyFrom(bArr, iDecodeVarint32, i8);
        return iDecodeVarint32 + i8;
    }

    public static int decodeBytesList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i8, registers);
        int i10 = registers.int1;
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
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, registers);
            int i11 = registers.int1;
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

    public static int decodeDoubleList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(decodeDouble(bArr, i8));
        int i10 = i8 + 8;
        while (i10 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, i10, registers);
            if (i2 != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(decodeDouble(bArr, iDecodeVarint32));
            i10 = iDecodeVarint32 + 8;
        }
        return i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int decodeExtension(int i2, byte[] bArr, int i8, int i9, GeneratedMessageLite.ExtendableMessage<?, ?> extendableMessage, GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        int i10;
        int i11;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        int i12 = i2 >>> 3;
        if (generatedExtension.descriptor.isRepeated() && generatedExtension.descriptor.isPacked()) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    DoubleArrayList doubleArrayList = new DoubleArrayList();
                    int iDecodePackedDoubleList = decodePackedDoubleList(bArr, i8, doubleArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, doubleArrayList);
                    return iDecodePackedDoubleList;
                case 2:
                    FloatArrayList floatArrayList = new FloatArrayList();
                    int iDecodePackedFloatList = decodePackedFloatList(bArr, i8, floatArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, floatArrayList);
                    return iDecodePackedFloatList;
                case 3:
                case 4:
                    LongArrayList longArrayList = new LongArrayList();
                    int iDecodePackedVarint64List = decodePackedVarint64List(bArr, i8, longArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, longArrayList);
                    return iDecodePackedVarint64List;
                case 5:
                case 6:
                    IntArrayList intArrayList = new IntArrayList();
                    int iDecodePackedVarint32List = decodePackedVarint32List(bArr, i8, intArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, intArrayList);
                    return iDecodePackedVarint32List;
                case 7:
                case 8:
                    LongArrayList longArrayList2 = new LongArrayList();
                    int iDecodePackedFixed64List = decodePackedFixed64List(bArr, i8, longArrayList2, registers);
                    fieldSet.setField(generatedExtension.descriptor, longArrayList2);
                    return iDecodePackedFixed64List;
                case 9:
                case 10:
                    IntArrayList intArrayList2 = new IntArrayList();
                    int iDecodePackedFixed32List = decodePackedFixed32List(bArr, i8, intArrayList2, registers);
                    fieldSet.setField(generatedExtension.descriptor, intArrayList2);
                    return iDecodePackedFixed32List;
                case 11:
                    BooleanArrayList booleanArrayList = new BooleanArrayList();
                    int iDecodePackedBoolList = decodePackedBoolList(bArr, i8, booleanArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, booleanArrayList);
                    return iDecodePackedBoolList;
                case 12:
                    IntArrayList intArrayList3 = new IntArrayList();
                    int iDecodePackedSInt32List = decodePackedSInt32List(bArr, i8, intArrayList3, registers);
                    fieldSet.setField(generatedExtension.descriptor, intArrayList3);
                    return iDecodePackedSInt32List;
                case 13:
                    LongArrayList longArrayList3 = new LongArrayList();
                    int iDecodePackedSInt64List = decodePackedSInt64List(bArr, i8, longArrayList3, registers);
                    fieldSet.setField(generatedExtension.descriptor, longArrayList3);
                    return iDecodePackedSInt64List;
                case 14:
                    IntArrayList intArrayList4 = new IntArrayList();
                    int iDecodePackedVarint32List2 = decodePackedVarint32List(bArr, i8, intArrayList4, registers);
                    SchemaUtil.filterUnknownEnumList((Object) extendableMessage, i12, (List<Integer>) intArrayList4, generatedExtension.descriptor.getEnumType(), (Object) null, (UnknownFieldSchema<UT, Object>) unknownFieldSchema);
                    fieldSet.setField(generatedExtension.descriptor, intArrayList4);
                    return iDecodePackedVarint32List2;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.descriptor.getLiteType());
            }
        }
        Object objValueOf = null;
        if (generatedExtension.getLiteType() == WireFormat.FieldType.ENUM) {
            i8 = decodeVarint32(bArr, i8, registers);
            if (generatedExtension.descriptor.getEnumType().findValueByNumber(registers.int1) == null) {
                SchemaUtil.storeUnknownEnum(extendableMessage, i12, registers.int1, null, unknownFieldSchema);
                return i8;
            }
            objValueOf = Integer.valueOf(registers.int1);
        } else {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
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
                    i8 = decodeVarint64(bArr, i8, registers);
                    objValueOf = Long.valueOf(registers.long1);
                    break;
                case 5:
                case 6:
                    i8 = decodeVarint32(bArr, i8, registers);
                    objValueOf = Integer.valueOf(registers.int1);
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
                    i8 = decodeVarint64(bArr, i8, registers);
                    objValueOf = Boolean.valueOf(registers.long1 != 0);
                    break;
                case 12:
                    i8 = decodeVarint32(bArr, i8, registers);
                    objValueOf = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                    break;
                case 13:
                    i8 = decodeVarint64(bArr, i8, registers);
                    objValueOf = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i8 = decodeBytes(bArr, i8, registers);
                    objValueOf = registers.object1;
                    break;
                case 16:
                    i8 = decodeString(bArr, i8, registers);
                    objValueOf = registers.object1;
                    break;
                case 17:
                    int i13 = (i12 << 3) | 4;
                    Schema schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int iDecodeGroupField = decodeGroupField(schemaSchemaFor, bArr, i8, i9, i13, registers);
                        fieldSet.addRepeatedField(generatedExtension.descriptor, registers.object1);
                        return iDecodeGroupField;
                    }
                    Object field = fieldSet.getField(generatedExtension.descriptor);
                    if (field == null) {
                        field = schemaSchemaFor.newInstance();
                        fieldSet.setField(generatedExtension.descriptor, field);
                    }
                    return mergeGroupField(field, schemaSchemaFor, bArr, i8, i9, i13, registers);
                case 18:
                    Schema schemaSchemaFor2 = Protobuf.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int iDecodeMessageField = decodeMessageField(schemaSchemaFor2, bArr, i8, i9, registers);
                        fieldSet.addRepeatedField(generatedExtension.descriptor, registers.object1);
                        return iDecodeMessageField;
                    }
                    Object field2 = fieldSet.getField(generatedExtension.descriptor);
                    if (field2 == null) {
                        field2 = schemaSchemaFor2.newInstance();
                        fieldSet.setField(generatedExtension.descriptor, field2);
                    }
                    return mergeMessageField(field2, schemaSchemaFor2, bArr, i8, i9, registers);
            }
        }
        if (generatedExtension.isRepeated()) {
            fieldSet.addRepeatedField(generatedExtension.descriptor, objValueOf);
            return i8;
        }
        fieldSet.setField(generatedExtension.descriptor, objValueOf);
        return i8;
    }

    public static int decodeExtensionOrUnknownField(int i2, byte[] bArr, int i8, int i9, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtensionFindLiteExtensionByNumber = registers.extensionRegistry.findLiteExtensionByNumber(messageLite, i2 >>> 3);
        if (generatedExtensionFindLiteExtensionByNumber == null) {
            return decodeUnknownField(i2, bArr, i8, i9, MessageSchema.getMutableUnknownFields(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return decodeExtension(i2, bArr, i8, i9, extendableMessage, generatedExtensionFindLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    public static int decodeFixed32(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static int decodeFixed32List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(decodeFixed32(bArr, i8));
        int i10 = i8 + 4;
        while (i10 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, i10, registers);
            if (i2 != registers.int1) {
                break;
            }
            intArrayList.addInt(decodeFixed32(bArr, iDecodeVarint32));
            i10 = iDecodeVarint32 + 4;
        }
        return i10;
    }

    public static long decodeFixed64(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public static int decodeFixed64List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(decodeFixed64(bArr, i8));
        int i10 = i8 + 8;
        while (i10 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, i10, registers);
            if (i2 != registers.int1) {
                break;
            }
            longArrayList.addLong(decodeFixed64(bArr, iDecodeVarint32));
            i10 = iDecodeVarint32 + 8;
        }
        return i10;
    }

    public static float decodeFloat(byte[] bArr, int i2) {
        return Float.intBitsToFloat(decodeFixed32(bArr, i2));
    }

    public static int decodeFloatList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(decodeFloat(bArr, i8));
        int i10 = i8 + 4;
        while (i10 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, i10, registers);
            if (i2 != registers.int1) {
                break;
            }
            floatArrayList.addFloat(decodeFloat(bArr, iDecodeVarint32));
            i10 = iDecodeVarint32 + 4;
        }
        return i10;
    }

    public static int decodeGroupField(Schema schema, byte[] bArr, int i2, int i8, int i9, Registers registers) throws IOException {
        Object objNewInstance = schema.newInstance();
        int iMergeGroupField = mergeGroupField(objNewInstance, schema, bArr, i2, i8, i9, registers);
        schema.makeImmutable(objNewInstance);
        registers.object1 = objNewInstance;
        return iMergeGroupField;
    }

    public static int decodeGroupList(Schema schema, int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i10 = (i2 & (-8)) | 4;
        int iDecodeGroupField = decodeGroupField(schema, bArr, i8, i9, i10, registers);
        protobufList.add(registers.object1);
        while (iDecodeGroupField < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeGroupField, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeGroupField = decodeGroupField(schema, bArr, iDecodeVarint32, i9, i10, registers);
            protobufList.add(registers.object1);
        }
        return iDecodeGroupField;
    }

    public static int decodeMessageField(Schema schema, byte[] bArr, int i2, int i8, Registers registers) throws IOException {
        Object objNewInstance = schema.newInstance();
        int iMergeMessageField = mergeMessageField(objNewInstance, schema, bArr, i2, i8, registers);
        schema.makeImmutable(objNewInstance);
        registers.object1 = objNewInstance;
        return iMergeMessageField;
    }

    public static int decodeMessageList(Schema<?> schema, int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int iDecodeMessageField = decodeMessageField(schema, bArr, i8, i9, registers);
        protobufList.add(registers.object1);
        while (iDecodeMessageField < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeMessageField, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeMessageField = decodeMessageField(schema, bArr, iDecodeVarint32, i9, registers);
            protobufList.add(registers.object1);
        }
        return iDecodeMessageField;
    }

    public static int decodePackedBoolList(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint64(bArr, iDecodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedDoubleList(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            doubleArrayList.addDouble(decodeDouble(bArr, iDecodeVarint32));
            iDecodeVarint32 += 8;
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed32List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            intArrayList.addInt(decodeFixed32(bArr, iDecodeVarint32));
            iDecodeVarint32 += 4;
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed64List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            longArrayList.addLong(decodeFixed64(bArr, iDecodeVarint32));
            iDecodeVarint32 += 8;
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFloatList(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            floatArrayList.addFloat(decodeFloat(bArr, iDecodeVarint32));
            iDecodeVarint32 += 4;
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt32List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint32, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt64List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint64(bArr, iDecodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint32List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint32, registers);
            intArrayList.addInt(registers.int1);
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint64List(byte[] bArr, int i2, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1 + iDecodeVarint32;
        while (iDecodeVarint32 < i8) {
            iDecodeVarint32 = decodeVarint64(bArr, iDecodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        if (iDecodeVarint32 == i8) {
            return iDecodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeSInt32List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i8, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (iDecodeVarint32 < i9) {
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return iDecodeVarint32;
    }

    public static int decodeSInt64List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iDecodeVarint64 = decodeVarint64(bArr, i8, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (iDecodeVarint64 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint64, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeVarint64 = decodeVarint64(bArr, iDecodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return iDecodeVarint64;
    }

    public static int decodeString(byte[] bArr, int i2, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1;
        if (i8 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i8 == 0) {
            registers.object1 = "";
            return iDecodeVarint32;
        }
        registers.object1 = new String(bArr, iDecodeVarint32, i8, Internal.UTF_8);
        return iDecodeVarint32 + i8;
    }

    public static int decodeStringList(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i8, registers);
        int i10 = registers.int1;
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
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, registers);
            int i11 = registers.int1;
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

    public static int decodeStringListRequireUtf8(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i8, registers);
        int i10 = registers.int1;
        if (i10 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i10 == 0) {
            protobufList.add("");
        } else {
            int i11 = iDecodeVarint32 + i10;
            if (!Utf8.isValidUtf8(bArr, iDecodeVarint32, i11)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            protobufList.add(new String(bArr, iDecodeVarint32, i10, Internal.UTF_8));
            iDecodeVarint32 = i11;
        }
        while (iDecodeVarint32 < i9) {
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, registers);
            int i12 = registers.int1;
            if (i12 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i12 == 0) {
                protobufList.add("");
            } else {
                int i13 = iDecodeVarint32 + i12;
                if (!Utf8.isValidUtf8(bArr, iDecodeVarint32, i13)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                protobufList.add(new String(bArr, iDecodeVarint32, i12, Internal.UTF_8));
                iDecodeVarint32 = i13;
            }
        }
        return iDecodeVarint32;
    }

    public static int decodeStringRequireUtf8(byte[] bArr, int i2, Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i8 = registers.int1;
        if (i8 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i8 == 0) {
            registers.object1 = "";
            return iDecodeVarint32;
        }
        registers.object1 = Utf8.decodeUtf8(bArr, iDecodeVarint32, i8);
        return iDecodeVarint32 + i8;
    }

    public static int decodeUnknownField(int i2, byte[] bArr, int i8, int i9, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i2) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            int iDecodeVarint64 = decodeVarint64(bArr, i8, registers);
            unknownFieldSetLite.storeField(i2, Long.valueOf(registers.long1));
            return iDecodeVarint64;
        }
        if (tagWireType == 1) {
            unknownFieldSetLite.storeField(i2, Long.valueOf(decodeFixed64(bArr, i8)));
            return i8 + 8;
        }
        if (tagWireType == 2) {
            int iDecodeVarint32 = decodeVarint32(bArr, i8, registers);
            int i10 = registers.int1;
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
        int i12 = registers.recursionDepth + 1;
        registers.recursionDepth = i12;
        checkRecursionLimit(i12);
        int i13 = 0;
        while (true) {
            if (i8 >= i9) {
                break;
            }
            int iDecodeVarint322 = decodeVarint32(bArr, i8, registers);
            i13 = registers.int1;
            if (i13 == i11) {
                i8 = iDecodeVarint322;
                break;
            }
            i8 = decodeUnknownField(i13, bArr, iDecodeVarint322, i9, unknownFieldSetLiteNewInstance, registers);
        }
        registers.recursionDepth--;
        if (i8 > i9 || i13 != i11) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        unknownFieldSetLite.storeField(i2, unknownFieldSetLiteNewInstance);
        return i8;
    }

    public static int decodeVarint32(byte[] bArr, int i2, Registers registers) {
        int i8 = i2 + 1;
        byte b8 = bArr[i2];
        if (b8 < 0) {
            return decodeVarint32(b8, bArr, i8, registers);
        }
        registers.int1 = b8;
        return i8;
    }

    public static int decodeVarint32List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int iDecodeVarint32 = decodeVarint32(bArr, i8, registers);
        intArrayList.addInt(registers.int1);
        while (iDecodeVarint32 < i9) {
            int iDecodeVarint322 = decodeVarint32(bArr, iDecodeVarint32, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint322, registers);
            intArrayList.addInt(registers.int1);
        }
        return iDecodeVarint32;
    }

    public static int decodeVarint64(byte[] bArr, int i2, Registers registers) {
        int i8 = i2 + 1;
        long j = bArr[i2];
        if (j < 0) {
            return decodeVarint64(j, bArr, i8, registers);
        }
        registers.long1 = j;
        return i8;
    }

    public static int decodeVarint64List(int i2, byte[] bArr, int i8, int i9, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int iDecodeVarint64 = decodeVarint64(bArr, i8, registers);
        longArrayList.addLong(registers.long1);
        while (iDecodeVarint64 < i9) {
            int iDecodeVarint32 = decodeVarint32(bArr, iDecodeVarint64, registers);
            if (i2 != registers.int1) {
                break;
            }
            iDecodeVarint64 = decodeVarint64(bArr, iDecodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        return iDecodeVarint64;
    }

    public static int mergeGroupField(Object obj, Schema schema, byte[] bArr, int i2, int i8, int i9, Registers registers) throws IOException {
        int i10 = registers.recursionDepth + 1;
        registers.recursionDepth = i10;
        checkRecursionLimit(i10);
        int message = ((MessageSchema) schema).parseMessage(obj, bArr, i2, i8, i9, registers);
        registers.recursionDepth--;
        registers.object1 = obj;
        return message;
    }

    public static int mergeMessageField(Object obj, Schema schema, byte[] bArr, int i2, int i8, Registers registers) throws IOException {
        int iDecodeVarint32 = i2 + 1;
        int i9 = bArr[i2];
        if (i9 < 0) {
            iDecodeVarint32 = decodeVarint32(i9, bArr, iDecodeVarint32, registers);
            i9 = registers.int1;
        }
        int i10 = iDecodeVarint32;
        if (i9 < 0 || i9 > i8 - i10) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i11 = registers.recursionDepth + 1;
        registers.recursionDepth = i11;
        checkRecursionLimit(i11);
        int i12 = i10 + i9;
        schema.mergeFrom(obj, bArr, i10, i12, registers);
        registers.recursionDepth--;
        registers.object1 = obj;
        return i12;
    }

    public static void setRecursionLimit(int i2) {
        recursionLimit = i2;
    }

    public static int skipField(int i2, byte[] bArr, int i8, int i9, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i2) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i2);
        if (tagWireType == 0) {
            return decodeVarint64(bArr, i8, registers);
        }
        if (tagWireType == 1) {
            return i8 + 8;
        }
        if (tagWireType == 2) {
            return decodeVarint32(bArr, i8, registers) + registers.int1;
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
            i8 = decodeVarint32(bArr, i8, registers);
            i11 = registers.int1;
            if (i11 == i10) {
                break;
            }
            i8 = skipField(i11, bArr, i8, i9, registers);
        }
        if (i8 > i9 || i11 != i10) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i8;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;
        public int recursionDepth;

        public Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        public Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    public static int decodeVarint32(int i2, byte[] bArr, int i8, Registers registers) {
        int i9 = i2 & 127;
        int i10 = i8 + 1;
        byte b8 = bArr[i8];
        if (b8 >= 0) {
            registers.int1 = i9 | (b8 << 7);
            return i10;
        }
        int i11 = i9 | ((b8 & 127) << 7);
        int i12 = i8 + 2;
        byte b9 = bArr[i10];
        if (b9 >= 0) {
            registers.int1 = i11 | (b9 << 14);
            return i12;
        }
        int i13 = i11 | ((b9 & 127) << 14);
        int i14 = i8 + 3;
        byte b10 = bArr[i12];
        if (b10 >= 0) {
            registers.int1 = i13 | (b10 << 21);
            return i14;
        }
        int i15 = i13 | ((b10 & 127) << 21);
        int i16 = i8 + 4;
        byte b11 = bArr[i14];
        if (b11 >= 0) {
            registers.int1 = i15 | (b11 << 28);
            return i16;
        }
        int i17 = i15 | ((b11 & 127) << 28);
        while (true) {
            int i18 = i16 + 1;
            if (bArr[i16] >= 0) {
                registers.int1 = i17;
                return i18;
            }
            i16 = i18;
        }
    }

    public static int decodeVarint64(long j, byte[] bArr, int i2, Registers registers) {
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
        registers.long1 = j3;
        return i8;
    }
}
