package com.google.protobuf;

import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class FieldSet {
    private static final int DEFAULT_FIELD_MAP_ARRAY_SIZE = 16;
    private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
    private final f2 fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        private f2 fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        public /* synthetic */ a(h0 h0Var) {
            this();
        }

        private FieldSet buildImpl(boolean z2) {
            if (this.fields.isEmpty()) {
                return FieldSet.emptySet();
            }
            this.isMutable = false;
            f2 f2VarCloneAllFieldsMap = this.fields;
            if (this.hasNestedBuilders) {
                f2VarCloneAllFieldsMap = FieldSet.cloneAllFieldsMap(f2VarCloneAllFieldsMap, false);
                replaceBuilders(f2VarCloneAllFieldsMap, z2);
            }
            FieldSet fieldSet = new FieldSet(f2VarCloneAllFieldsMap, null);
            fieldSet.hasLazyField = this.hasLazyField;
            return fieldSet;
        }

        private void ensureIsMutable() {
            if (this.isMutable) {
                return;
            }
            this.fields = FieldSet.cloneAllFieldsMap(this.fields, true);
            this.isMutable = true;
        }

        public static <T extends FieldDescriptorLite<T>> a fromFieldSet(FieldSet fieldSet) {
            a aVar = new a(FieldSet.cloneAllFieldsMap(fieldSet.fields, true));
            aVar.hasLazyField = fieldSet.hasLazyField;
            return aVar;
        }

        private void mergeFromField(Map.Entry<FieldDescriptorLite<Object>, Object> entry) {
            FieldDescriptorLite<Object> key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                value = ((LazyField) value).getValue();
            }
            if (key.isRepeated()) {
                List arrayList = (List) getFieldAllowBuilders(key);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.fields.put((Comparable<Object>) key, (Object) arrayList);
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    arrayList.add(FieldSet.cloneIfMutable(it.next()));
                }
                return;
            }
            if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
                this.fields.put((Comparable<Object>) key, FieldSet.cloneIfMutable(value));
                return;
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(key);
            if (fieldAllowBuilders == null) {
                this.fields.put((Comparable<Object>) key, FieldSet.cloneIfMutable(value));
            } else if (fieldAllowBuilders instanceof MessageLite.Builder) {
                key.internalMergeFrom((MessageLite.Builder) fieldAllowBuilders, (MessageLite) value);
            } else {
                this.fields.put((Comparable<Object>) key, (Object) key.internalMergeFrom(((MessageLite) fieldAllowBuilders).toBuilder(), (MessageLite) value).build());
            }
        }

        private static Object replaceBuilder(Object obj, boolean z2) {
            if (!(obj instanceof MessageLite.Builder)) {
                return obj;
            }
            MessageLite.Builder builder = (MessageLite.Builder) obj;
            return z2 ? builder.buildPartial() : builder.build();
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(f2 f2Var, boolean z2) {
            for (int i2 = 0; i2 < f2Var.getNumArrayEntries(); i2++) {
                replaceBuilders(f2Var.getArrayEntryAt(i2), z2);
            }
            Iterator<Map.Entry<Comparable<Object>, Object>> it = f2Var.getOverflowEntries().iterator();
            while (it.hasNext()) {
                replaceBuilders(it.next(), z2);
            }
        }

        private void verifyType(FieldDescriptorLite<Object> fieldDescriptorLite, Object obj) {
            if (FieldSet.isValidType(fieldDescriptorLite.getLiteType(), obj)) {
                return;
            }
            if (fieldDescriptorLite.getLiteType().getJavaType() != WireFormat.JavaType.MESSAGE || !(obj instanceof MessageLite.Builder)) {
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(fieldDescriptorLite.getNumber()), fieldDescriptorLite.getLiteType().getJavaType(), obj.getClass().getName()));
            }
        }

        public void addRepeatedField(FieldDescriptorLite<Object> fieldDescriptorLite, Object obj) {
            List arrayList;
            ensureIsMutable();
            if (!fieldDescriptorLite.isRepeated()) {
                throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            verifyType(fieldDescriptorLite, obj);
            Object fieldAllowBuilders = getFieldAllowBuilders(fieldDescriptorLite);
            if (fieldAllowBuilders == null) {
                arrayList = new ArrayList();
                this.fields.put((Comparable<Object>) fieldDescriptorLite, (Object) arrayList);
            } else {
                arrayList = (List) fieldAllowBuilders;
            }
            arrayList.add(obj);
        }

        public FieldSet build() {
            return buildImpl(false);
        }

        public FieldSet buildPartial() {
            return buildImpl(true);
        }

        public void clearField(FieldDescriptorLite<Object> fieldDescriptorLite) {
            ensureIsMutable();
            this.fields.remove(fieldDescriptorLite);
            if (this.fields.isEmpty()) {
                this.hasLazyField = false;
            }
        }

        public Map<FieldDescriptorLite<Object>, Object> getAllFields() {
            if (!this.hasLazyField) {
                return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
            }
            f2 f2VarCloneAllFieldsMap = FieldSet.cloneAllFieldsMap(this.fields, false);
            if (this.fields.isImmutable()) {
                f2VarCloneAllFieldsMap.makeImmutable();
                return f2VarCloneAllFieldsMap;
            }
            replaceBuilders(f2VarCloneAllFieldsMap, true);
            return f2VarCloneAllFieldsMap;
        }

        public Object getField(FieldDescriptorLite<Object> fieldDescriptorLite) {
            return replaceBuilders(fieldDescriptorLite, getFieldAllowBuilders(fieldDescriptorLite), true);
        }

        public Object getFieldAllowBuilders(FieldDescriptorLite<Object> fieldDescriptorLite) {
            Object obj = this.fields.get(fieldDescriptorLite);
            return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
        }

        public Object getRepeatedField(FieldDescriptorLite<Object> fieldDescriptorLite, int i2) {
            if (this.hasNestedBuilders) {
                ensureIsMutable();
            }
            return replaceBuilder(getRepeatedFieldAllowBuilders(fieldDescriptorLite, i2), true);
        }

        public Object getRepeatedFieldAllowBuilders(FieldDescriptorLite<Object> fieldDescriptorLite, int i2) {
            if (!fieldDescriptorLite.isRepeated()) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(fieldDescriptorLite);
            if (fieldAllowBuilders != null) {
                return ((List) fieldAllowBuilders).get(i2);
            }
            throw new IndexOutOfBoundsException();
        }

        public int getRepeatedFieldCount(FieldDescriptorLite<Object> fieldDescriptorLite) {
            if (!fieldDescriptorLite.isRepeated()) {
                throw new IllegalArgumentException("getRepeatedFieldCount() can only be called on repeated fields.");
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(fieldDescriptorLite);
            if (fieldAllowBuilders == null) {
                return 0;
            }
            return ((List) fieldAllowBuilders).size();
        }

        public boolean hasField(FieldDescriptorLite<Object> fieldDescriptorLite) {
            if (fieldDescriptorLite.isRepeated()) {
                throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
            }
            return this.fields.get(fieldDescriptorLite) != null;
        }

        public boolean isInitialized() {
            for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
                if (!FieldSet.isInitialized(this.fields.getArrayEntryAt(i2))) {
                    return false;
                }
            }
            Iterator<Map.Entry<Comparable<Object>, Object>> it = this.fields.getOverflowEntries().iterator();
            while (it.hasNext()) {
                if (!FieldSet.isInitialized(it.next())) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void mergeFrom(FieldSet fieldSet) {
            ensureIsMutable();
            for (int i2 = 0; i2 < fieldSet.fields.getNumArrayEntries(); i2++) {
                mergeFromField(fieldSet.fields.getArrayEntryAt(i2));
            }
            Iterator<Map.Entry<Comparable<Object>, Object>> it = fieldSet.fields.getOverflowEntries().iterator();
            while (it.hasNext()) {
                mergeFromField(it.next());
            }
        }

        public void setField(FieldDescriptorLite<Object> fieldDescriptorLite, Object obj) {
            ensureIsMutable();
            if (!fieldDescriptorLite.isRepeated()) {
                verifyType(fieldDescriptorLite, obj);
            } else {
                if (!(obj instanceof List)) {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                ArrayList arrayList = new ArrayList((List) obj);
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    verifyType(fieldDescriptorLite, obj2);
                    this.hasNestedBuilders = this.hasNestedBuilders || (obj2 instanceof MessageLite.Builder);
                }
                obj = arrayList;
            }
            if (obj instanceof LazyField) {
                this.hasLazyField = true;
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            this.fields.put((Comparable<Object>) fieldDescriptorLite, obj);
        }

        public void setRepeatedField(FieldDescriptorLite<Object> fieldDescriptorLite, int i2, Object obj) {
            ensureIsMutable();
            if (!fieldDescriptorLite.isRepeated()) {
                throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            Object fieldAllowBuilders = getFieldAllowBuilders(fieldDescriptorLite);
            if (fieldAllowBuilders == null) {
                throw new IndexOutOfBoundsException();
            }
            verifyType(fieldDescriptorLite, obj);
            ((List) fieldAllowBuilders).set(i2, obj);
        }

        private a() {
            this(f2.newFieldMap(16));
        }

        private a(f2 f2Var) {
            this.fields = f2Var;
            this.isMutable = true;
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> entry, boolean z2) {
            entry.setValue(replaceBuilders(entry.getKey(), entry.getValue(), z2));
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T t3, Object obj, boolean z2) {
            if (obj == null || t3.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
                return obj;
            }
            if (t3.isRepeated()) {
                if (obj instanceof List) {
                    List arrayList = (List) obj;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        Object obj2 = arrayList.get(i2);
                        Object objReplaceBuilder = replaceBuilder(obj2, z2);
                        if (objReplaceBuilder != obj2) {
                            if (arrayList == obj) {
                                arrayList = new ArrayList(arrayList);
                            }
                            arrayList.set(i2, objReplaceBuilder);
                        }
                    }
                    return arrayList;
                }
                throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + obj.getClass());
            }
            return replaceBuilder(obj, z2);
        }
    }

    public /* synthetic */ FieldSet(f2 f2Var, h0 h0Var) {
        this(f2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> f2 cloneAllFieldsMap(f2 f2Var, boolean z2) {
        f2 f2VarNewFieldMap = f2.newFieldMap(16);
        for (int i2 = 0; i2 < f2Var.getNumArrayEntries(); i2++) {
            cloneFieldEntry(f2VarNewFieldMap, f2Var.getArrayEntryAt(i2), z2);
        }
        Iterator<Map.Entry<Comparable<Object>, Object>> it = f2Var.getOverflowEntries().iterator();
        while (it.hasNext()) {
            cloneFieldEntry(f2VarNewFieldMap, it.next(), z2);
        }
        return f2VarNewFieldMap;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z2) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            map.put(key, ((LazyField) value).getValue());
        } else if (z2 && (value instanceof List)) {
            map.put(key, new ArrayList((List) value));
        } else {
            map.put(key, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object cloneIfMutable(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int computeElementSize(WireFormat.FieldType fieldType, int i2, Object obj) {
        int iComputeTagSize = CodedOutputStream.computeTagSize(i2);
        if (fieldType == WireFormat.FieldType.GROUP) {
            iComputeTagSize *= 2;
        }
        return computeElementSizeNoTag(fieldType, obj) + iComputeTagSize;
    }

    public static int computeElementSizeNoTag(WireFormat.FieldType fieldType, Object obj) {
        switch (h0.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                return obj instanceof LazyField ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 18:
                return obj instanceof Internal.EnumLite ? CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return computeElementSize(liteType, number, obj);
        }
        List list = (List) obj;
        int iComputeElementSize = 0;
        if (!fieldDescriptorLite.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iComputeElementSize += computeElementSize(liteType, number, it.next());
            }
            return iComputeElementSize;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iComputeElementSize += computeElementSizeNoTag(liteType, it2.next());
        }
        return CodedOutputStream.computeUInt32SizeNoTag(iComputeElementSize) + CodedOutputStream.computeTagSize(number) + iComputeElementSize;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet emptySet() {
        return DEFAULT_INSTANCE;
    }

    public static int getWireFormatForFieldType(WireFormat.FieldType fieldType, boolean z2) {
        if (z2) {
            return 2;
        }
        return fieldType.getWireType();
    }

    private static boolean isMessageFieldValueInitialized(Object obj) {
        if (obj instanceof MessageLiteOrBuilder) {
            return ((MessageLiteOrBuilder) obj).isInitialized();
        }
        if (obj instanceof LazyField) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidType(WireFormat.FieldType fieldType, Object obj) {
        Internal.checkNotNull(obj);
        switch (h0.$SwitchMap$com$google$protobuf$WireFormat$JavaType[fieldType.getJavaType().ordinal()]) {
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof Internal.EnumLite)) {
                }
                break;
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                }
                break;
        }
        return false;
    }

    private void mergeFromField(Map.Entry<FieldDescriptorLite<Object>, Object> entry) {
        FieldDescriptorLite<Object> key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).getValue();
        }
        if (key.isRepeated()) {
            Object field = getField(key);
            if (field == null) {
                field = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) field).add(cloneIfMutable(it.next()));
            }
            this.fields.put((Comparable<Object>) key, field);
            return;
        }
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            this.fields.put((Comparable<Object>) key, cloneIfMutable(value));
            return;
        }
        Object field2 = getField(key);
        if (field2 == null) {
            this.fields.put((Comparable<Object>) key, cloneIfMutable(value));
        } else {
            this.fields.put((Comparable<Object>) key, (Object) key.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
        }
    }

    public static <T extends FieldDescriptorLite<T>> a newBuilder() {
        return new a((h0) null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet newFieldSet() {
        return new FieldSet();
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z2) throws IOException {
        return z2 ? WireFormat.readPrimitiveField(codedInputStream, fieldType, WireFormat.a.STRICT) : WireFormat.readPrimitiveField(codedInputStream, fieldType, WireFormat.a.LOOSE);
    }

    private void verifyType(FieldDescriptorLite<Object> fieldDescriptorLite, Object obj) {
        if (!isValidType(fieldDescriptorLite.getLiteType(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(fieldDescriptorLite.getNumber()), fieldDescriptorLite.getLiteType().getJavaType(), obj.getClass().getName()));
        }
    }

    public static void writeElement(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i2, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i2, (MessageLite) obj);
        } else {
            codedOutputStream.writeTag(i2, getWireFormatForFieldType(fieldType, false));
            writeElementNoTag(codedOutputStream, fieldType, obj);
        }
    }

    public static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (h0.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                break;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeStringNoTag((String) obj);
                } else {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                }
                break;
            case 12:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                } else {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                }
                break;
            case 13:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                break;
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof Internal.EnumLite)) {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                } else {
                    codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                }
                break;
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            if (obj instanceof LazyField) {
                writeElement(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
                return;
            } else {
                writeElement(codedOutputStream, liteType, number, obj);
                return;
            }
        }
        List list = (List) obj;
        if (!fieldDescriptorLite.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                writeElement(codedOutputStream, liteType, number, it.next());
            }
        } else {
            if (list.isEmpty()) {
                return;
            }
            codedOutputStream.writeTag(number, 2);
            Iterator it2 = list.iterator();
            int iComputeElementSizeNoTag = 0;
            while (it2.hasNext()) {
                iComputeElementSizeNoTag += computeElementSizeNoTag(liteType, it2.next());
            }
            codedOutputStream.writeUInt32NoTag(iComputeElementSizeNoTag);
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                writeElementNoTag(codedOutputStream, liteType, it3.next());
            }
        }
    }

    public void addRepeatedField(FieldDescriptorLite<Object> fieldDescriptorLite, Object obj) {
        List arrayList;
        if (!fieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        verifyType(fieldDescriptorLite, obj);
        Object field = getField(fieldDescriptorLite);
        if (field == null) {
            arrayList = new ArrayList();
            this.fields.put((Comparable<Object>) fieldDescriptorLite, (Object) arrayList);
        } else {
            arrayList = (List) field;
        }
        arrayList.add(obj);
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public void clearField(FieldDescriptorLite<Object> fieldDescriptorLite) {
        this.fields.remove(fieldDescriptorLite);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }

    public Iterator<Map.Entry<FieldDescriptorLite<Object>, Object>> descendingIterator() {
        return this.hasLazyField ? new LazyField.b(this.fields.descendingEntrySet().iterator()) : this.fields.descendingEntrySet().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldSet) {
            return this.fields.equals(((FieldSet) obj).fields);
        }
        return false;
    }

    public Map<FieldDescriptorLite<Object>, Object> getAllFields() {
        if (!this.hasLazyField) {
            return this.fields.isImmutable() ? this.fields : Collections.unmodifiableMap(this.fields);
        }
        f2 f2VarCloneAllFieldsMap = cloneAllFieldsMap(this.fields, false);
        if (this.fields.isImmutable()) {
            f2VarCloneAllFieldsMap.makeImmutable();
        }
        return f2VarCloneAllFieldsMap;
    }

    public Object getField(FieldDescriptorLite<Object> fieldDescriptorLite) {
        Object obj = this.fields.get(fieldDescriptorLite);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getMessageSetSerializedSize() {
        int messageSetSerializedSize = 0;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            messageSetSerializedSize += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i2));
        }
        Iterator<Map.Entry<Comparable<Object>, Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            messageSetSerializedSize += getMessageSetSerializedSize(it.next());
        }
        return messageSetSerializedSize;
    }

    public Object getRepeatedField(FieldDescriptorLite<Object> fieldDescriptorLite, int i2) {
        if (!fieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fieldDescriptorLite);
        if (field != null) {
            return ((List) field).get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getRepeatedFieldCount(FieldDescriptorLite<Object> fieldDescriptorLite) {
        if (!fieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fieldDescriptorLite);
        if (field == null) {
            return 0;
        }
        return ((List) field).size();
    }

    public int getSerializedSize() {
        int iComputeFieldSize = 0;
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            Map.Entry<Comparable<Object>, Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
            iComputeFieldSize += computeFieldSize((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry<Comparable<Object>, Object> entry : this.fields.getOverflowEntries()) {
            iComputeFieldSize += computeFieldSize((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        return iComputeFieldSize;
    }

    public boolean hasField(FieldDescriptorLite<Object> fieldDescriptorLite) {
        if (fieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.fields.get(fieldDescriptorLite) != null;
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public boolean isInitialized() {
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            if (!isInitialized(this.fields.getArrayEntryAt(i2))) {
                return false;
            }
        }
        Iterator<Map.Entry<Comparable<Object>, Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            if (!isInitialized(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorLite<Object>, Object>> iterator() {
        return this.hasLazyField ? new LazyField.b(this.fields.entrySet().iterator()) : this.fields.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            Map.Entry<Comparable<Object>, Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
            if (arrayEntryAt.getValue() instanceof GeneratedMessageLite) {
                ((GeneratedMessageLite) arrayEntryAt.getValue()).makeImmutable();
            }
        }
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void mergeFrom(FieldSet fieldSet) {
        for (int i2 = 0; i2 < fieldSet.fields.getNumArrayEntries(); i2++) {
            mergeFromField(fieldSet.fields.getArrayEntryAt(i2));
        }
        Iterator<Map.Entry<Comparable<Object>, Object>> it = fieldSet.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            mergeFromField(it.next());
        }
    }

    public void setField(FieldDescriptorLite<Object> fieldDescriptorLite, Object obj) {
        if (!fieldDescriptorLite.isRepeated()) {
            verifyType(fieldDescriptorLite, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                verifyType(fieldDescriptorLite, obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put((Comparable<Object>) fieldDescriptorLite, obj);
    }

    public void setRepeatedField(FieldDescriptorLite<Object> fieldDescriptorLite, int i2, Object obj) {
        if (!fieldDescriptorLite.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fieldDescriptorLite);
        if (field == null) {
            throw new IndexOutOfBoundsException();
        }
        verifyType(fieldDescriptorLite, obj);
        ((List) field).set(i2, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            writeMessageSetTo(this.fields.getArrayEntryAt(i2), codedOutputStream);
        }
        Iterator<Map.Entry<Comparable<Object>, Object>> it = this.fields.getOverflowEntries().iterator();
        while (it.hasNext()) {
            writeMessageSetTo(it.next(), codedOutputStream);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            Map.Entry<Comparable<Object>, Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
            writeField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
        }
        for (Map.Entry<Comparable<Object>, Object> entry : this.fields.getOverflowEntries()) {
            writeField((FieldDescriptorLite) entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }

    private FieldSet() {
        this.fields = f2.newFieldMap(16);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FieldSet m233clone() {
        FieldSet fieldSetNewFieldSet = newFieldSet();
        for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
            Map.Entry<Comparable<Object>, Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
            fieldSetNewFieldSet.setField((FieldDescriptorLite) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        for (Map.Entry<Comparable<Object>, Object> entry : this.fields.getOverflowEntries()) {
            fieldSetNewFieldSet.setField((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        fieldSetNewFieldSet.hasLazyField = this.hasLazyField;
        return fieldSetNewFieldSet;
    }

    private FieldSet(boolean z2) {
        this(f2.newFieldMap(0));
        makeImmutable();
    }

    private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorLite<Object>, Object> entry) {
        FieldDescriptorLite<Object> key = entry.getKey();
        Object value = entry.getValue();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
            if (value instanceof LazyField) {
                return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), (LazyField) value);
            }
            return CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) value);
        }
        return computeFieldSize(key, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        if (key.isRepeated()) {
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                if (!isMessageFieldValueInitialized(it.next())) {
                    return false;
                }
            }
            return true;
        }
        return isMessageFieldValueInitialized(entry.getValue());
    }

    private void writeMessageSetTo(Map.Entry<FieldDescriptorLite<Object>, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        FieldDescriptorLite<Object> key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                codedOutputStream.writeRawMessageSetExtension(entry.getKey().getNumber(), ((LazyField) value).toByteString());
                return;
            } else {
                codedOutputStream.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) value);
                return;
            }
        }
        writeField(key, entry.getValue(), codedOutputStream);
    }

    private FieldSet(f2 f2Var) {
        this.fields = f2Var;
        makeImmutable();
    }
}
