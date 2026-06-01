package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e2 {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final p2 UNKNOWN_FIELD_SET_FULL_SCHEMA = getUnknownFieldSetSchema();
    private static final p2 UNKNOWN_FIELD_SET_LITE_SCHEMA = new q2();

    private e2() {
    }

    public static int computeSizeBoolList(int i2, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z2) {
            return CodedOutputStream.computeBoolSize(i2, true) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size) + CodedOutputStream.computeTagSize(i2);
    }

    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int i2, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        for (int i8 = 0; i8 < list.size(); i8++) {
            iComputeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i8));
        }
        return iComputeTagSize;
    }

    public static int computeSizeEnumList(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (!z2) {
            return (CodedOutputStream.computeTagSize(i2) * size) + iComputeSizeEnumListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeEnumListNoTag) + CodedOutputStream.computeTagSize(i2);
    }

    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof p0)) {
            int iComputeEnumSizeNoTag = 0;
            while (i2 < size) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i2).intValue());
                i2++;
            }
            return iComputeEnumSizeNoTag;
        }
        p0 p0Var = (p0) list;
        int iComputeEnumSizeNoTag2 = 0;
        while (i2 < size) {
            iComputeEnumSizeNoTag2 += CodedOutputStream.computeEnumSizeNoTag(p0Var.getInt(i2));
            i2++;
        }
        return iComputeEnumSizeNoTag2;
    }

    public static int computeSizeFixed32List(int i2, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z2) {
            return CodedOutputStream.computeFixed32Size(i2, 0) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 4) + CodedOutputStream.computeTagSize(i2);
    }

    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int i2, List<?> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z2) {
            return CodedOutputStream.computeFixed64Size(i2, 0L) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 8) + CodedOutputStream.computeTagSize(i2);
    }

    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int i2, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(i2, list.get(i8));
        }
        return iComputeGroupSize;
    }

    public static int computeSizeInt32List(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (!z2) {
            return (CodedOutputStream.computeTagSize(i2) * size) + iComputeSizeInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt32ListNoTag) + CodedOutputStream.computeTagSize(i2);
    }

    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof p0)) {
            int iComputeInt32SizeNoTag = 0;
            while (i2 < size) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
            return iComputeInt32SizeNoTag;
        }
        p0 p0Var = (p0) list;
        int iComputeInt32SizeNoTag2 = 0;
        while (i2 < size) {
            iComputeInt32SizeNoTag2 += CodedOutputStream.computeInt32SizeNoTag(p0Var.getInt(i2));
            i2++;
        }
        return iComputeInt32SizeNoTag2;
    }

    public static int computeSizeInt64List(int i2, List<Long> list, boolean z2) {
        if (list.size() == 0) {
            return 0;
        }
        int iComputeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z2) {
            return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt64ListNoTag) + CodedOutputStream.computeTagSize(i2);
        }
        return (CodedOutputStream.computeTagSize(i2) * list.size()) + iComputeSizeInt64ListNoTag;
    }

    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b1)) {
            int iComputeInt64SizeNoTag = 0;
            while (i2 < size) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
            return iComputeInt64SizeNoTag;
        }
        b1 b1Var = (b1) list;
        int iComputeInt64SizeNoTag2 = 0;
        while (i2 < size) {
            iComputeInt64SizeNoTag2 += CodedOutputStream.computeInt64SizeNoTag(b1Var.getLong(i2));
            i2++;
        }
        return iComputeInt64SizeNoTag2;
    }

    public static int computeSizeMessage(int i2, Object obj, c2 c2Var) {
        return obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSize(i2, (LazyFieldLite) obj) : CodedOutputStream.computeMessageSize(i2, (MessageLite) obj, c2Var);
    }

    public static int computeSizeMessageList(int i2, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = list.get(i8);
            iComputeTagSize = (obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj)) + iComputeTagSize;
        }
        return iComputeTagSize;
    }

    public static int computeSizeSInt32List(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (!z2) {
            return (CodedOutputStream.computeTagSize(i2) * size) + iComputeSizeSInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt32ListNoTag) + CodedOutputStream.computeTagSize(i2);
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof p0)) {
            int iComputeSInt32SizeNoTag = 0;
            while (i2 < size) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
            return iComputeSInt32SizeNoTag;
        }
        p0 p0Var = (p0) list;
        int iComputeSInt32SizeNoTag2 = 0;
        while (i2 < size) {
            iComputeSInt32SizeNoTag2 += CodedOutputStream.computeSInt32SizeNoTag(p0Var.getInt(i2));
            i2++;
        }
        return iComputeSInt32SizeNoTag2;
    }

    public static int computeSizeSInt64List(int i2, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (!z2) {
            return (CodedOutputStream.computeTagSize(i2) * size) + iComputeSizeSInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt64ListNoTag) + CodedOutputStream.computeTagSize(i2);
    }

    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b1)) {
            int iComputeSInt64SizeNoTag = 0;
            while (i2 < size) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
            return iComputeSInt64SizeNoTag;
        }
        b1 b1Var = (b1) list;
        int iComputeSInt64SizeNoTag2 = 0;
        while (i2 < size) {
            iComputeSInt64SizeNoTag2 += CodedOutputStream.computeSInt64SizeNoTag(b1Var.getLong(i2));
            i2++;
        }
        return iComputeSInt64SizeNoTag2;
    }

    public static int computeSizeStringList(int i2, List<?> list) {
        int size = list.size();
        int i8 = 0;
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        if (!(list instanceof LazyStringList)) {
            while (i8 < size) {
                Object obj = list.get(i8);
                iComputeTagSize = (obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj)) + iComputeTagSize;
                i8++;
            }
            return iComputeTagSize;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        while (i8 < size) {
            Object raw = lazyStringList.getRaw(i8);
            iComputeTagSize = (raw instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) raw) : CodedOutputStream.computeStringSizeNoTag((String) raw)) + iComputeTagSize;
            i8++;
        }
        return iComputeTagSize;
    }

    public static int computeSizeUInt32List(int i2, List<Integer> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (!z2) {
            return (CodedOutputStream.computeTagSize(i2) * size) + iComputeSizeUInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt32ListNoTag) + CodedOutputStream.computeTagSize(i2);
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof p0)) {
            int iComputeUInt32SizeNoTag = 0;
            while (i2 < size) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i2).intValue());
                i2++;
            }
            return iComputeUInt32SizeNoTag;
        }
        p0 p0Var = (p0) list;
        int iComputeUInt32SizeNoTag2 = 0;
        while (i2 < size) {
            iComputeUInt32SizeNoTag2 += CodedOutputStream.computeUInt32SizeNoTag(p0Var.getInt(i2));
            i2++;
        }
        return iComputeUInt32SizeNoTag2;
    }

    public static int computeSizeUInt64List(int i2, List<Long> list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (!z2) {
            return (CodedOutputStream.computeTagSize(i2) * size) + iComputeSizeUInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt64ListNoTag) + CodedOutputStream.computeTagSize(i2);
    }

    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b1)) {
            int iComputeUInt64SizeNoTag = 0;
            while (i2 < size) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i2).longValue());
                i2++;
            }
            return iComputeUInt64SizeNoTag;
        }
        b1 b1Var = (b1) list;
        int iComputeUInt64SizeNoTag2 = 0;
        while (i2 < size) {
            iComputeUInt64SizeNoTag2 += CodedOutputStream.computeUInt64SizeNoTag(b1Var.getLong(i2));
            i2++;
        }
        return iComputeUInt64SizeNoTag2;
    }

    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i2, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, p2 p2Var) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (enumLiteMap.findValueByNumber(iIntValue) == null) {
                    ub = (UB) storeUnknownEnum(obj, i2, iIntValue, ub, p2Var);
                    it.remove();
                }
            }
            return ub;
        }
        int size = list.size();
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            Integer num = list.get(i9);
            int iIntValue2 = num.intValue();
            if (enumLiteMap.findValueByNumber(iIntValue2) != null) {
                if (i9 != i8) {
                    list.set(i8, num);
                }
                i8++;
            } else {
                ub = (UB) storeUnknownEnum(obj, i2, iIntValue2, ub, p2Var);
            }
        }
        if (i8 != size) {
            list.subList(i8, size).clear();
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            java.lang.reflect.Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return r2.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static p2 getUnknownFieldSetSchema() {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (p2) unknownFieldSetSchemaClass.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(a0 a0Var, T t3, T t7) {
        FieldSet extensions = a0Var.getExtensions(t7);
        if (extensions.isEmpty()) {
            return;
        }
        a0Var.getMutableExtensions(t3).mergeFrom(extensions);
    }

    public static <T> void mergeMap(f1 f1Var, T t3, T t7, long j) {
        r2.putObject(t3, j, f1Var.mergeFrom(r2.getObject(t3, j), r2.getObject(t7, j)));
    }

    public static <T, UT, UB> void mergeUnknownFields(p2 p2Var, T t3, T t7) {
        p2Var.setToMessage(t3, p2Var.merge(p2Var.getFromMessage(t3), p2Var.getFromMessage(t7)));
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean shouldUseTableSwitch(int i2, int i8, int i9) {
        if (i8 < 40) {
            return true;
        }
        long j = ((long) i8) - ((long) i2);
        long j3 = i9;
        return j + 10 <= ((j3 + 3) * 3) + ((2 * j3) + 3);
    }

    public static <UT, UB> UB storeUnknownEnum(Object obj, int i2, int i8, UB ub, p2 p2Var) {
        if (ub == null) {
            ub = (UB) p2Var.getBuilderFromMessage(obj);
        }
        p2Var.addVarint(ub, i2, i8);
        return ub;
    }

    public static String toCamelCase(String str, boolean z2) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if ('a' > cCharAt || cCharAt > 'z') {
                if ('A' > cCharAt || cCharAt > 'Z') {
                    if ('0' <= cCharAt && cCharAt <= '9') {
                        sb.append(cCharAt);
                    }
                    z2 = true;
                } else if (i2 != 0 || z2) {
                    sb.append(cCharAt);
                } else {
                    sb.append((char) (cCharAt + ' '));
                }
            } else if (z2) {
                sb.append((char) (cCharAt - ' '));
            } else {
                sb.append(cCharAt);
            }
            z2 = false;
        }
        return sb.toString();
    }

    public static p2 unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static p2 unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i2, boolean z2, v2 v2Var) throws IOException {
        if (z2) {
            v2Var.writeBool(i2, true);
        }
    }

    public static void writeBoolList(int i2, List<Boolean> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeBoolList(i2, list, z2);
    }

    public static void writeBytes(int i2, ByteString byteString, v2 v2Var) throws IOException {
        if (byteString == null || byteString.isEmpty()) {
            return;
        }
        v2Var.writeBytes(i2, byteString);
    }

    public static void writeBytesList(int i2, List<ByteString> list, v2 v2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeBytesList(i2, list);
    }

    public static void writeDouble(int i2, double d8, v2 v2Var) throws IOException {
        if (Double.doubleToRawLongBits(d8) != 0) {
            v2Var.writeDouble(i2, d8);
        }
    }

    public static void writeDoubleList(int i2, List<Double> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeDoubleList(i2, list, z2);
    }

    public static void writeEnum(int i2, int i8, v2 v2Var) throws IOException {
        if (i8 != 0) {
            v2Var.writeEnum(i2, i8);
        }
    }

    public static void writeEnumList(int i2, List<Integer> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeEnumList(i2, list, z2);
    }

    public static void writeFixed32(int i2, int i8, v2 v2Var) throws IOException {
        if (i8 != 0) {
            v2Var.writeFixed32(i2, i8);
        }
    }

    public static void writeFixed32List(int i2, List<Integer> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeFixed32List(i2, list, z2);
    }

    public static void writeFixed64(int i2, long j, v2 v2Var) throws IOException {
        if (j != 0) {
            v2Var.writeFixed64(i2, j);
        }
    }

    public static void writeFixed64List(int i2, List<Long> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeFixed64List(i2, list, z2);
    }

    public static void writeFloat(int i2, float f4, v2 v2Var) throws IOException {
        if (Float.floatToRawIntBits(f4) != 0) {
            v2Var.writeFloat(i2, f4);
        }
    }

    public static void writeFloatList(int i2, List<Float> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeFloatList(i2, list, z2);
    }

    public static void writeGroupList(int i2, List<?> list, v2 v2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeGroupList(i2, list);
    }

    public static void writeInt32(int i2, int i8, v2 v2Var) throws IOException {
        if (i8 != 0) {
            v2Var.writeInt32(i2, i8);
        }
    }

    public static void writeInt32List(int i2, List<Integer> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeInt32List(i2, list, z2);
    }

    public static void writeInt64(int i2, long j, v2 v2Var) throws IOException {
        if (j != 0) {
            v2Var.writeInt64(i2, j);
        }
    }

    public static void writeInt64List(int i2, List<Long> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeInt64List(i2, list, z2);
    }

    public static void writeLazyFieldList(int i2, List<?> list, v2 v2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            ((LazyFieldLite) it.next()).writeTo(v2Var, i2);
        }
    }

    public static void writeMessage(int i2, Object obj, v2 v2Var) throws IOException {
        if (obj != null) {
            v2Var.writeMessage(i2, obj);
        }
    }

    public static void writeMessageList(int i2, List<?> list, v2 v2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeMessageList(i2, list);
    }

    public static void writeSFixed32(int i2, int i8, v2 v2Var) throws IOException {
        if (i8 != 0) {
            v2Var.writeSFixed32(i2, i8);
        }
    }

    public static void writeSFixed32List(int i2, List<Integer> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeSFixed32List(i2, list, z2);
    }

    public static void writeSFixed64(int i2, long j, v2 v2Var) throws IOException {
        if (j != 0) {
            v2Var.writeSFixed64(i2, j);
        }
    }

    public static void writeSFixed64List(int i2, List<Long> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeSFixed64List(i2, list, z2);
    }

    public static void writeSInt32(int i2, int i8, v2 v2Var) throws IOException {
        if (i8 != 0) {
            v2Var.writeSInt32(i2, i8);
        }
    }

    public static void writeSInt32List(int i2, List<Integer> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeSInt32List(i2, list, z2);
    }

    public static void writeSInt64(int i2, long j, v2 v2Var) throws IOException {
        if (j != 0) {
            v2Var.writeSInt64(i2, j);
        }
    }

    public static void writeSInt64List(int i2, List<Long> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeSInt64List(i2, list, z2);
    }

    public static void writeString(int i2, Object obj, v2 v2Var) throws IOException {
        if (obj instanceof String) {
            writeStringInternal(i2, (String) obj, v2Var);
        } else {
            writeBytes(i2, (ByteString) obj, v2Var);
        }
    }

    private static void writeStringInternal(int i2, String str, v2 v2Var) throws IOException {
        if (str == null || str.isEmpty()) {
            return;
        }
        v2Var.writeString(i2, str);
    }

    public static void writeStringList(int i2, List<String> list, v2 v2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeStringList(i2, list);
    }

    public static void writeUInt32(int i2, int i8, v2 v2Var) throws IOException {
        if (i8 != 0) {
            v2Var.writeUInt32(i2, i8);
        }
    }

    public static void writeUInt32List(int i2, List<Integer> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeUInt32List(i2, list, z2);
    }

    public static void writeUInt64(int i2, long j, v2 v2Var) throws IOException {
        if (j != 0) {
            v2Var.writeUInt64(i2, j);
        }
    }

    public static void writeUInt64List(int i2, List<Long> list, v2 v2Var, boolean z2) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeUInt64List(i2, list, z2);
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static int computeSizeGroupList(int i2, List<MessageLite> list, c2 c2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i8 = 0; i8 < size; i8++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(i2, list.get(i8), c2Var);
        }
        return iComputeGroupSize;
    }

    public static void writeGroupList(int i2, List<?> list, v2 v2Var, c2 c2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeGroupList(i2, list, c2Var);
    }

    public static void writeMessageList(int i2, List<?> list, v2 v2Var, c2 c2Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        v2Var.writeMessageList(i2, list, c2Var);
    }

    public static int computeSizeMessageList(int i2, List<?> list, c2 c2Var) {
        int iComputeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i2) * size;
        for (int i8 = 0; i8 < size; i8++) {
            Object obj = list.get(i8);
            if (obj instanceof LazyFieldLite) {
                iComputeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                iComputeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, c2Var);
            }
            iComputeTagSize = iComputeMessageSizeNoTag + iComputeTagSize;
        }
        return iComputeTagSize;
    }

    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i2, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, p2 p2Var) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i8 = 0;
            for (int i9 = 0; i9 < size; i9++) {
                Integer num = list.get(i9);
                int iIntValue = num.intValue();
                if (enumVerifier.isInRange(iIntValue)) {
                    if (i9 != i8) {
                        list.set(i8, num);
                    }
                    i8++;
                } else {
                    ub = (UB) storeUnknownEnum(obj, i2, iIntValue, ub, p2Var);
                }
            }
            if (i8 != size) {
                list.subList(i8, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!enumVerifier.isInRange(iIntValue2)) {
                ub = (UB) storeUnknownEnum(obj, i2, iIntValue2, ub, p2Var);
                it.remove();
            }
        }
        return ub;
    }
}
