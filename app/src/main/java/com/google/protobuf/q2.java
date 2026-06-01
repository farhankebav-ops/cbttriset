package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class q2 extends p2 {
    @Override // com.google.protobuf.p2
    public void makeImmutable(Object obj) {
        getFromMessage(obj).makeImmutable();
    }

    @Override // com.google.protobuf.p2
    public boolean shouldDiscardUnknownFields(a2 a2Var) {
        return false;
    }

    @Override // com.google.protobuf.p2
    public void addFixed32(UnknownFieldSetLite unknownFieldSetLite, int i2, int i8) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i2, 5), Integer.valueOf(i8));
    }

    @Override // com.google.protobuf.p2
    public void addFixed64(UnknownFieldSetLite unknownFieldSetLite, int i2, long j) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i2, 1), Long.valueOf(j));
    }

    @Override // com.google.protobuf.p2
    public void addGroup(UnknownFieldSetLite unknownFieldSetLite, int i2, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i2, 3), unknownFieldSetLite2);
    }

    @Override // com.google.protobuf.p2
    public void addLengthDelimited(UnknownFieldSetLite unknownFieldSetLite, int i2, ByteString byteString) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i2, 2), byteString);
    }

    @Override // com.google.protobuf.p2
    public void addVarint(UnknownFieldSetLite unknownFieldSetLite, int i2, long j) {
        unknownFieldSetLite.storeField(WireFormat.makeTag(i2, 0), Long.valueOf(j));
    }

    @Override // com.google.protobuf.p2
    public UnknownFieldSetLite getBuilderFromMessage(Object obj) {
        UnknownFieldSetLite fromMessage = getFromMessage(obj);
        if (fromMessage != UnknownFieldSetLite.getDefaultInstance()) {
            return fromMessage;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        setToMessage(obj, unknownFieldSetLiteNewInstance);
        return unknownFieldSetLiteNewInstance;
    }

    @Override // com.google.protobuf.p2
    public UnknownFieldSetLite getFromMessage(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // com.google.protobuf.p2
    public int getSerializedSize(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    @Override // com.google.protobuf.p2
    public int getSerializedSizeAsMessageSet(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.p2
    public UnknownFieldSetLite merge(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        return UnknownFieldSetLite.getDefaultInstance().equals(unknownFieldSetLite2) ? unknownFieldSetLite : UnknownFieldSetLite.getDefaultInstance().equals(unknownFieldSetLite) ? UnknownFieldSetLite.mutableCopyOf(unknownFieldSetLite, unknownFieldSetLite2) : unknownFieldSetLite.mergeFrom(unknownFieldSetLite2);
    }

    @Override // com.google.protobuf.p2
    public UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    @Override // com.google.protobuf.p2
    public void setBuilderToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        setToMessage(obj, unknownFieldSetLite);
    }

    @Override // com.google.protobuf.p2
    public void setToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    @Override // com.google.protobuf.p2
    public UnknownFieldSetLite toImmutable(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.makeImmutable();
        return unknownFieldSetLite;
    }

    @Override // com.google.protobuf.p2
    public void writeAsMessageSetTo(UnknownFieldSetLite unknownFieldSetLite, v2 v2Var) throws IOException {
        unknownFieldSetLite.writeAsMessageSetTo(v2Var);
    }

    @Override // com.google.protobuf.p2
    public void writeTo(UnknownFieldSetLite unknownFieldSetLite, v2 v2Var) throws IOException {
        unknownFieldSetLite.writeTo(v2Var);
    }
}
