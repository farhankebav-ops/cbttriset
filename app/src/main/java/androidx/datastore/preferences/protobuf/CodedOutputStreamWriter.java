package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private void writeBoolListInternal(int i2, BooleanArrayList booleanArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < booleanArrayList.size()) {
                this.output.writeBool(i2, booleanArrayList.getBoolean(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeBoolSizeNoTag = 0;
        for (int i9 = 0; i9 < booleanArrayList.size(); i9++) {
            iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(booleanArrayList.getBoolean(i9));
        }
        this.output.writeUInt32NoTag(iComputeBoolSizeNoTag);
        while (i8 < booleanArrayList.size()) {
            this.output.writeBoolNoTag(booleanArrayList.getBoolean(i8));
            i8++;
        }
    }

    private <V> void writeDeterministicBooleanMapEntry(int i2, boolean z2, V v2, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.output.writeTag(i2, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z2), v2));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z2), v2);
    }

    private <V> void writeDeterministicIntegerMap(int i2, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            iArr[i8] = it.next().intValue();
            i8++;
        }
        Arrays.sort(iArr);
        for (int i9 = 0; i9 < size; i9++) {
            int i10 = iArr[i9];
            V v2 = map.get(Integer.valueOf(i10));
            this.output.writeTag(i2, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i10), v2));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i10), v2);
        }
    }

    private <V> void writeDeterministicLongMap(int i2, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            jArr[i8] = it.next().longValue();
            i8++;
        }
        Arrays.sort(jArr);
        for (int i9 = 0; i9 < size; i9++) {
            long j = jArr[i9];
            V v2 = map.get(Long.valueOf(j));
            this.output.writeTag(i2, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j), v2));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j), v2);
        }
    }

    private <K, V> void writeDeterministicMap(int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v2 = map.get(Boolean.FALSE);
                if (v2 != null) {
                    writeDeterministicBooleanMapEntry(i2, false, v2, metadata);
                }
                V v7 = map.get(Boolean.TRUE);
                if (v7 != null) {
                    writeDeterministicBooleanMapEntry(i2, true, v7, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i2, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i2, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i2, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i2, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            strArr[i8] = it.next();
            i8++;
        }
        Arrays.sort(strArr);
        for (int i9 = 0; i9 < size; i9++) {
            String str = strArr[i9];
            V v2 = map.get(str);
            this.output.writeTag(i2, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v2));
            MapEntryLite.writeTo(this.output, metadata, str, v2);
        }
    }

    private void writeDoubleListInternal(int i2, DoubleArrayList doubleArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < doubleArrayList.size()) {
                this.output.writeDouble(i2, doubleArrayList.getDouble(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeDoubleSizeNoTag = 0;
        for (int i9 = 0; i9 < doubleArrayList.size(); i9++) {
            iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(doubleArrayList.getDouble(i9));
        }
        this.output.writeUInt32NoTag(iComputeDoubleSizeNoTag);
        while (i8 < doubleArrayList.size()) {
            this.output.writeDoubleNoTag(doubleArrayList.getDouble(i8));
            i8++;
        }
    }

    private void writeEnumListInternal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < intArrayList.size()) {
                this.output.writeEnum(i2, intArrayList.getInt(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeEnumSizeNoTag = 0;
        for (int i9 = 0; i9 < intArrayList.size(); i9++) {
            iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i9));
        }
        this.output.writeUInt32NoTag(iComputeEnumSizeNoTag);
        while (i8 < intArrayList.size()) {
            this.output.writeEnumNoTag(intArrayList.getInt(i8));
            i8++;
        }
    }

    private void writeFixed32ListInternal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < intArrayList.size()) {
                this.output.writeFixed32(i2, intArrayList.getInt(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeFixed32SizeNoTag = 0;
        for (int i9 = 0; i9 < intArrayList.size(); i9++) {
            iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(intArrayList.getInt(i9));
        }
        this.output.writeUInt32NoTag(iComputeFixed32SizeNoTag);
        while (i8 < intArrayList.size()) {
            this.output.writeFixed32NoTag(intArrayList.getInt(i8));
            i8++;
        }
    }

    private void writeFixed64ListInternal(int i2, LongArrayList longArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < longArrayList.size()) {
                this.output.writeFixed64(i2, longArrayList.getLong(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeFixed64SizeNoTag = 0;
        for (int i9 = 0; i9 < longArrayList.size(); i9++) {
            iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(longArrayList.getLong(i9));
        }
        this.output.writeUInt32NoTag(iComputeFixed64SizeNoTag);
        while (i8 < longArrayList.size()) {
            this.output.writeFixed64NoTag(longArrayList.getLong(i8));
            i8++;
        }
    }

    private void writeFloatListInternal(int i2, FloatArrayList floatArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < floatArrayList.size()) {
                this.output.writeFloat(i2, floatArrayList.getFloat(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeFloatSizeNoTag = 0;
        for (int i9 = 0; i9 < floatArrayList.size(); i9++) {
            iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(floatArrayList.getFloat(i9));
        }
        this.output.writeUInt32NoTag(iComputeFloatSizeNoTag);
        while (i8 < floatArrayList.size()) {
            this.output.writeFloatNoTag(floatArrayList.getFloat(i8));
            i8++;
        }
    }

    private void writeInt32ListInternal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < intArrayList.size()) {
                this.output.writeInt32(i2, intArrayList.getInt(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeInt32SizeNoTag = 0;
        for (int i9 = 0; i9 < intArrayList.size(); i9++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i9));
        }
        this.output.writeUInt32NoTag(iComputeInt32SizeNoTag);
        while (i8 < intArrayList.size()) {
            this.output.writeInt32NoTag(intArrayList.getInt(i8));
            i8++;
        }
    }

    private void writeInt64ListInternal(int i2, LongArrayList longArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < longArrayList.size()) {
                this.output.writeInt64(i2, longArrayList.getLong(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeInt64SizeNoTag = 0;
        for (int i9 = 0; i9 < longArrayList.size(); i9++) {
            iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i9));
        }
        this.output.writeUInt32NoTag(iComputeInt64SizeNoTag);
        while (i8 < longArrayList.size()) {
            this.output.writeInt64NoTag(longArrayList.getLong(i8));
            i8++;
        }
    }

    private void writeLazyString(int i2, Object obj) throws IOException {
        if (obj instanceof String) {
            this.output.writeString(i2, (String) obj);
        } else {
            this.output.writeBytes(i2, (ByteString) obj);
        }
    }

    private void writeSFixed32ListInternal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < intArrayList.size()) {
                this.output.writeSFixed32(i2, intArrayList.getInt(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeSFixed32SizeNoTag = 0;
        for (int i9 = 0; i9 < intArrayList.size(); i9++) {
            iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(intArrayList.getInt(i9));
        }
        this.output.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
        while (i8 < intArrayList.size()) {
            this.output.writeSFixed32NoTag(intArrayList.getInt(i8));
            i8++;
        }
    }

    private void writeSFixed64ListInternal(int i2, LongArrayList longArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < longArrayList.size()) {
                this.output.writeSFixed64(i2, longArrayList.getLong(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeSFixed64SizeNoTag = 0;
        for (int i9 = 0; i9 < longArrayList.size(); i9++) {
            iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(longArrayList.getLong(i9));
        }
        this.output.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
        while (i8 < longArrayList.size()) {
            this.output.writeSFixed64NoTag(longArrayList.getLong(i8));
            i8++;
        }
    }

    private void writeSInt32ListInternal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < intArrayList.size()) {
                this.output.writeSInt32(i2, intArrayList.getInt(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeSInt32SizeNoTag = 0;
        for (int i9 = 0; i9 < intArrayList.size(); i9++) {
            iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i9));
        }
        this.output.writeUInt32NoTag(iComputeSInt32SizeNoTag);
        while (i8 < intArrayList.size()) {
            this.output.writeSInt32NoTag(intArrayList.getInt(i8));
            i8++;
        }
    }

    private void writeSInt64ListInternal(int i2, LongArrayList longArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < longArrayList.size()) {
                this.output.writeSInt64(i2, longArrayList.getLong(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeSInt64SizeNoTag = 0;
        for (int i9 = 0; i9 < longArrayList.size(); i9++) {
            iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i9));
        }
        this.output.writeUInt32NoTag(iComputeSInt64SizeNoTag);
        while (i8 < longArrayList.size()) {
            this.output.writeSInt64NoTag(longArrayList.getLong(i8));
            i8++;
        }
    }

    private void writeUInt32ListInternal(int i2, IntArrayList intArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < intArrayList.size()) {
                this.output.writeUInt32(i2, intArrayList.getInt(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeUInt32SizeNoTag = 0;
        for (int i9 = 0; i9 < intArrayList.size(); i9++) {
            iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i9));
        }
        this.output.writeUInt32NoTag(iComputeUInt32SizeNoTag);
        while (i8 < intArrayList.size()) {
            this.output.writeUInt32NoTag(intArrayList.getInt(i8));
            i8++;
        }
    }

    private void writeUInt64ListInternal(int i2, LongArrayList longArrayList, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < longArrayList.size()) {
                this.output.writeUInt64(i2, longArrayList.getLong(i8));
                i8++;
            }
            return;
        }
        this.output.writeTag(i2, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i9 = 0; i9 < longArrayList.size(); i9++) {
            iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i9));
        }
        this.output.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i8 < longArrayList.size()) {
            this.output.writeUInt64NoTag(longArrayList.getLong(i8));
            i8++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBool(int i2, boolean z2) throws IOException {
        this.output.writeBool(i2, z2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBoolList(int i2, List<Boolean> list, boolean z2) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolListInternal(i2, (BooleanArrayList) list, z2);
        } else {
            writeBoolListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBytes(int i2, ByteString byteString) throws IOException {
        this.output.writeBytes(i2, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBytesList(int i2, List<ByteString> list) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.output.writeBytes(i2, list.get(i8));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDouble(int i2, double d8) throws IOException {
        this.output.writeDouble(i2, d8);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDoubleList(int i2, List<Double> list, boolean z2) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleListInternal(i2, (DoubleArrayList) list, z2);
        } else {
            writeDoubleListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int i2) throws IOException {
        this.output.writeTag(i2, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnum(int i2, int i8) throws IOException {
        this.output.writeEnum(i2, i8);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnumList(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeEnumListInternal(i2, (IntArrayList) list, z2);
        } else {
            writeEnumListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32(int i2, int i8) throws IOException {
        this.output.writeFixed32(i2, i8);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32List(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32ListInternal(i2, (IntArrayList) list, z2);
        } else {
            writeFixed32ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64(int i2, long j) throws IOException {
        this.output.writeFixed64(i2, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64List(int i2, List<Long> list, boolean z2) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64ListInternal(i2, (LongArrayList) list, z2);
        } else {
            writeFixed64ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloat(int i2, float f4) throws IOException {
        this.output.writeFloat(i2, f4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloatList(int i2, List<Float> list, boolean z2) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatListInternal(i2, (FloatArrayList) list, z2);
        } else {
            writeFloatListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeGroup(int i2, Object obj) throws IOException {
        this.output.writeGroup(i2, (MessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeGroupList(int i2, List<?> list) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            writeGroup(i2, list.get(i8));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32(int i2, int i8) throws IOException {
        this.output.writeInt32(i2, i8);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32List(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32ListInternal(i2, (IntArrayList) list, z2);
        } else {
            writeInt32ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64(int i2, long j) throws IOException {
        this.output.writeInt64(i2, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64List(int i2, List<Long> list, boolean z2) throws IOException {
        if (list instanceof LongArrayList) {
            writeInt64ListInternal(i2, (LongArrayList) list, z2);
        } else {
            writeInt64ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public <K, V> void writeMap(int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i2, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i2, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessage(int i2, Object obj) throws IOException {
        this.output.writeMessage(i2, (MessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessageList(int i2, List<?> list) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            writeMessage(i2, list.get(i8));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeMessageSetItem(int i2, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i2, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i2, (MessageLite) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32(int i2, int i8) throws IOException {
        this.output.writeSFixed32(i2, i8);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32List(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeSFixed32ListInternal(i2, (IntArrayList) list, z2);
        } else {
            writeSFixed32ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64(int i2, long j) throws IOException {
        this.output.writeSFixed64(i2, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64List(int i2, List<Long> list, boolean z2) throws IOException {
        if (list instanceof LongArrayList) {
            writeSFixed64ListInternal(i2, (LongArrayList) list, z2);
        } else {
            writeSFixed64ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32(int i2, int i8) throws IOException {
        this.output.writeSInt32(i2, i8);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32List(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32ListInternal(i2, (IntArrayList) list, z2);
        } else {
            writeSInt32ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64(int i2, long j) throws IOException {
        this.output.writeSInt64(i2, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64List(int i2, List<Long> list, boolean z2) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64ListInternal(i2, (LongArrayList) list, z2);
        } else {
            writeSInt64ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int i2) throws IOException {
        this.output.writeTag(i2, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeString(int i2, String str) throws IOException {
        this.output.writeString(i2, str);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeStringList(int i2, List<String> list) throws IOException {
        int i8 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i8 < list.size()) {
                this.output.writeString(i2, list.get(i8));
                i8++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i8 < list.size()) {
                writeLazyString(i2, lazyStringList.getRaw(i8));
                i8++;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32(int i2, int i8) throws IOException {
        this.output.writeUInt32(i2, i8);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32List(int i2, List<Integer> list, boolean z2) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32ListInternal(i2, (IntArrayList) list, z2);
        } else {
            writeUInt32ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64(int i2, long j) throws IOException {
        this.output.writeUInt64(i2, j);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64List(int i2, List<Long> list, boolean z2) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64ListInternal(i2, (LongArrayList) list, z2);
        } else {
            writeUInt64ListInternal(i2, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeGroup(int i2, Object obj, Schema schema) throws IOException {
        this.output.writeGroup(i2, (MessageLite) obj, schema);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessage(int i2, Object obj, Schema schema) throws IOException {
        this.output.writeMessage(i2, (MessageLite) obj, schema);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeGroupList(int i2, List<?> list, Schema schema) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            writeGroup(i2, list.get(i8), schema);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessageList(int i2, List<?> list, Schema schema) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            writeMessage(i2, list.get(i8), schema);
        }
    }

    private void writeBoolListInternal(int i2, List<Boolean> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeBoolSizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(list.get(i9).booleanValue());
            }
            this.output.writeUInt32NoTag(iComputeBoolSizeNoTag);
            while (i8 < list.size()) {
                this.output.writeBoolNoTag(list.get(i8).booleanValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeBool(i2, list.get(i8).booleanValue());
            i8++;
        }
    }

    private void writeDoubleListInternal(int i2, List<Double> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeDoubleSizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(list.get(i9).doubleValue());
            }
            this.output.writeUInt32NoTag(iComputeDoubleSizeNoTag);
            while (i8 < list.size()) {
                this.output.writeDoubleNoTag(list.get(i8).doubleValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeDouble(i2, list.get(i8).doubleValue());
            i8++;
        }
    }

    private void writeEnumListInternal(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeEnumSizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i9).intValue());
            }
            this.output.writeUInt32NoTag(iComputeEnumSizeNoTag);
            while (i8 < list.size()) {
                this.output.writeEnumNoTag(list.get(i8).intValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeEnum(i2, list.get(i8).intValue());
            i8++;
        }
    }

    private void writeFixed32ListInternal(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeFixed32SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(list.get(i9).intValue());
            }
            this.output.writeUInt32NoTag(iComputeFixed32SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeFixed32NoTag(list.get(i8).intValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeFixed32(i2, list.get(i8).intValue());
            i8++;
        }
    }

    private void writeFixed64ListInternal(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeFixed64SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(list.get(i9).longValue());
            }
            this.output.writeUInt32NoTag(iComputeFixed64SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeFixed64NoTag(list.get(i8).longValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeFixed64(i2, list.get(i8).longValue());
            i8++;
        }
    }

    private void writeFloatListInternal(int i2, List<Float> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeFloatSizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(list.get(i9).floatValue());
            }
            this.output.writeUInt32NoTag(iComputeFloatSizeNoTag);
            while (i8 < list.size()) {
                this.output.writeFloatNoTag(list.get(i8).floatValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeFloat(i2, list.get(i8).floatValue());
            i8++;
        }
    }

    private void writeInt32ListInternal(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeInt32SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i9).intValue());
            }
            this.output.writeUInt32NoTag(iComputeInt32SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeInt32NoTag(list.get(i8).intValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeInt32(i2, list.get(i8).intValue());
            i8++;
        }
    }

    private void writeInt64ListInternal(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeInt64SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i9).longValue());
            }
            this.output.writeUInt32NoTag(iComputeInt64SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeInt64NoTag(list.get(i8).longValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeInt64(i2, list.get(i8).longValue());
            i8++;
        }
    }

    private void writeSFixed32ListInternal(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeSFixed32SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i9).intValue());
            }
            this.output.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeSFixed32NoTag(list.get(i8).intValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeSFixed32(i2, list.get(i8).intValue());
            i8++;
        }
    }

    private void writeSFixed64ListInternal(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeSFixed64SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i9).longValue());
            }
            this.output.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeSFixed64NoTag(list.get(i8).longValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeSFixed64(i2, list.get(i8).longValue());
            i8++;
        }
    }

    private void writeSInt64ListInternal(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeSInt64SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i9).longValue());
            }
            this.output.writeUInt32NoTag(iComputeSInt64SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeSInt64NoTag(list.get(i8).longValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeSInt64(i2, list.get(i8).longValue());
            i8++;
        }
    }

    private void writeUInt64ListInternal(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeUInt64SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i9).longValue());
            }
            this.output.writeUInt32NoTag(iComputeUInt64SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeUInt64NoTag(list.get(i8).longValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeUInt64(i2, list.get(i8).longValue());
            i8++;
        }
    }

    public void writeSInt32ListInternal(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeSInt32SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i9).intValue());
            }
            this.output.writeUInt32NoTag(iComputeSInt32SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeSInt32NoTag(list.get(i8).intValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeSInt32(i2, list.get(i8).intValue());
            i8++;
        }
    }

    public void writeUInt32ListInternal(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (z2) {
            this.output.writeTag(i2, 2);
            int iComputeUInt32SizeNoTag = 0;
            for (int i9 = 0; i9 < list.size(); i9++) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i9).intValue());
            }
            this.output.writeUInt32NoTag(iComputeUInt32SizeNoTag);
            while (i8 < list.size()) {
                this.output.writeUInt32NoTag(list.get(i8).intValue());
                i8++;
            }
            return;
        }
        while (i8 < list.size()) {
            this.output.writeUInt32(i2, list.get(i8).intValue());
            i8++;
        }
    }
}
