package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements v2 {
    private final CodedOutputStream output;

    private r(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static r forCodedOutput(CodedOutputStream codedOutputStream) {
        r rVar = codedOutputStream.wrapper;
        return rVar != null ? rVar : new r(codedOutputStream);
    }

    private <V> void writeDeterministicBooleanMapEntry(int i2, boolean z2, V v2, MapEntryLite.a aVar) throws IOException {
        this.output.writeTag(i2, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(aVar, Boolean.valueOf(z2), v2));
        MapEntryLite.writeTo(this.output, aVar, Boolean.valueOf(z2), v2);
    }

    private <V> void writeDeterministicIntegerMap(int i2, MapEntryLite.a aVar, Map<Integer, V> map) throws IOException {
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
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(aVar, Integer.valueOf(i10), v2));
            MapEntryLite.writeTo(this.output, aVar, Integer.valueOf(i10), v2);
        }
    }

    private <V> void writeDeterministicLongMap(int i2, MapEntryLite.a aVar, Map<Long, V> map) throws IOException {
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
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(aVar, Long.valueOf(j), v2));
            MapEntryLite.writeTo(this.output, aVar, Long.valueOf(j), v2);
        }
    }

    private <K, V> void writeDeterministicMap(int i2, MapEntryLite.a aVar, Map<K, V> map) throws IOException {
        switch (q.$SwitchMap$com$google$protobuf$WireFormat$FieldType[aVar.keyType.ordinal()]) {
            case 1:
                V v2 = map.get(Boolean.FALSE);
                if (v2 != null) {
                    writeDeterministicBooleanMapEntry(i2, false, v2, aVar);
                }
                V v7 = map.get(Boolean.TRUE);
                if (v7 != null) {
                    writeDeterministicBooleanMapEntry(i2, true, v7, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i2, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i2, aVar, map);
                return;
            case 12:
                writeDeterministicStringMap(i2, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i2, MapEntryLite.a aVar, Map<String, V> map) throws IOException {
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
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(aVar, str, v2));
            MapEntryLite.writeTo(this.output, aVar, str, v2);
        }
    }

    private void writeLazyString(int i2, Object obj) throws IOException {
        if (obj instanceof String) {
            this.output.writeString(i2, (String) obj);
        } else {
            this.output.writeBytes(i2, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.v2
    public Writer$FieldOrder fieldOrder() {
        return Writer$FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // com.google.protobuf.v2
    public void writeBool(int i2, boolean z2) throws IOException {
        this.output.writeBool(i2, z2);
    }

    @Override // com.google.protobuf.v2
    public void writeBoolList(int i2, List<Boolean> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeBool(i2, list.get(i8).booleanValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeBytes(int i2, ByteString byteString) throws IOException {
        this.output.writeBytes(i2, byteString);
    }

    @Override // com.google.protobuf.v2
    public void writeBytesList(int i2, List<ByteString> list) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            this.output.writeBytes(i2, list.get(i8));
        }
    }

    @Override // com.google.protobuf.v2
    public void writeDouble(int i2, double d8) throws IOException {
        this.output.writeDouble(i2, d8);
    }

    @Override // com.google.protobuf.v2
    public void writeDoubleList(int i2, List<Double> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeDouble(i2, list.get(i8).doubleValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    @Deprecated
    public void writeEndGroup(int i2) throws IOException {
        this.output.writeTag(i2, 4);
    }

    @Override // com.google.protobuf.v2
    public void writeEnum(int i2, int i8) throws IOException {
        this.output.writeEnum(i2, i8);
    }

    @Override // com.google.protobuf.v2
    public void writeEnumList(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeEnum(i2, list.get(i8).intValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeFixed32(int i2, int i8) throws IOException {
        this.output.writeFixed32(i2, i8);
    }

    @Override // com.google.protobuf.v2
    public void writeFixed32List(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeFixed32(i2, list.get(i8).intValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeFixed64(int i2, long j) throws IOException {
        this.output.writeFixed64(i2, j);
    }

    @Override // com.google.protobuf.v2
    public void writeFixed64List(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeFixed64(i2, list.get(i8).longValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeFloat(int i2, float f4) throws IOException {
        this.output.writeFloat(i2, f4);
    }

    @Override // com.google.protobuf.v2
    public void writeFloatList(int i2, List<Float> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeFloat(i2, list.get(i8).floatValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    @Deprecated
    public void writeGroup(int i2, Object obj) throws IOException {
        this.output.writeGroup(i2, (MessageLite) obj);
    }

    @Override // com.google.protobuf.v2
    @Deprecated
    public void writeGroupList(int i2, List<?> list) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            writeGroup(i2, list.get(i8));
        }
    }

    @Override // com.google.protobuf.v2
    public void writeInt32(int i2, int i8) throws IOException {
        this.output.writeInt32(i2, i8);
    }

    @Override // com.google.protobuf.v2
    public void writeInt32List(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeInt32(i2, list.get(i8).intValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeInt64(int i2, long j) throws IOException {
        this.output.writeInt64(i2, j);
    }

    @Override // com.google.protobuf.v2
    public void writeInt64List(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeInt64(i2, list.get(i8).longValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public <K, V> void writeMap(int i2, MapEntryLite.a aVar, Map<K, V> map) throws IOException {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i2, aVar, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i2, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(aVar, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.v2
    public void writeMessage(int i2, Object obj) throws IOException {
        this.output.writeMessage(i2, (MessageLite) obj);
    }

    @Override // com.google.protobuf.v2
    public void writeMessageList(int i2, List<?> list) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            writeMessage(i2, list.get(i8));
        }
    }

    @Override // com.google.protobuf.v2
    public final void writeMessageSetItem(int i2, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i2, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i2, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.v2
    public void writeSFixed32(int i2, int i8) throws IOException {
        this.output.writeSFixed32(i2, i8);
    }

    @Override // com.google.protobuf.v2
    public void writeSFixed32List(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeSFixed32(i2, list.get(i8).intValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeSFixed64(int i2, long j) throws IOException {
        this.output.writeSFixed64(i2, j);
    }

    @Override // com.google.protobuf.v2
    public void writeSFixed64List(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeSFixed64(i2, list.get(i8).longValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeSInt32(int i2, int i8) throws IOException {
        this.output.writeSInt32(i2, i8);
    }

    @Override // com.google.protobuf.v2
    public void writeSInt32List(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeSInt32(i2, list.get(i8).intValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeSInt64(int i2, long j) throws IOException {
        this.output.writeSInt64(i2, j);
    }

    @Override // com.google.protobuf.v2
    public void writeSInt64List(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeSInt64(i2, list.get(i8).longValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    @Deprecated
    public void writeStartGroup(int i2) throws IOException {
        this.output.writeTag(i2, 3);
    }

    @Override // com.google.protobuf.v2
    public void writeString(int i2, String str) throws IOException {
        this.output.writeString(i2, str);
    }

    @Override // com.google.protobuf.v2
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

    @Override // com.google.protobuf.v2
    public void writeUInt32(int i2, int i8) throws IOException {
        this.output.writeUInt32(i2, i8);
    }

    @Override // com.google.protobuf.v2
    public void writeUInt32List(int i2, List<Integer> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeUInt32(i2, list.get(i8).intValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeUInt64(int i2, long j) throws IOException {
        this.output.writeUInt64(i2, j);
    }

    @Override // com.google.protobuf.v2
    public void writeUInt64List(int i2, List<Long> list, boolean z2) throws IOException {
        int i8 = 0;
        if (!z2) {
            while (i8 < list.size()) {
                this.output.writeUInt64(i2, list.get(i8).longValue());
                i8++;
            }
            return;
        }
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
    }

    @Override // com.google.protobuf.v2
    public void writeGroup(int i2, Object obj, c2 c2Var) throws IOException {
        this.output.writeGroup(i2, (MessageLite) obj, c2Var);
    }

    @Override // com.google.protobuf.v2
    public void writeMessage(int i2, Object obj, c2 c2Var) throws IOException {
        this.output.writeMessage(i2, (MessageLite) obj, c2Var);
    }

    @Override // com.google.protobuf.v2
    public void writeGroupList(int i2, List<?> list, c2 c2Var) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            writeGroup(i2, list.get(i8), c2Var);
        }
    }

    @Override // com.google.protobuf.v2
    public void writeMessageList(int i2, List<?> list, c2 c2Var) throws IOException {
        for (int i8 = 0; i8 < list.size(); i8++) {
            writeMessage(i2, list.get(i8), c2Var);
        }
    }
}
