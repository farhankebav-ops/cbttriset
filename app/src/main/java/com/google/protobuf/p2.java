package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p2 {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    private final void mergeFrom(Object obj, a2 a2Var, int i2) throws IOException {
        while (a2Var.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(obj, a2Var, i2)) {
        }
    }

    public abstract void addFixed32(Object obj, int i2, int i8);

    public abstract void addFixed64(Object obj, int i2, long j);

    public abstract void addGroup(Object obj, int i2, Object obj2);

    public abstract void addLengthDelimited(Object obj, int i2, ByteString byteString);

    public abstract void addVarint(Object obj, int i2, long j);

    public abstract Object getBuilderFromMessage(Object obj);

    public abstract Object getFromMessage(Object obj);

    public abstract int getSerializedSize(Object obj);

    public abstract int getSerializedSizeAsMessageSet(Object obj);

    public abstract void makeImmutable(Object obj);

    public abstract Object merge(Object obj, Object obj2);

    public final boolean mergeOneFieldFrom(Object obj, a2 a2Var, int i2) throws IOException {
        int tag = a2Var.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(obj, tagFieldNumber, a2Var.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(obj, tagFieldNumber, a2Var.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(obj, tagFieldNumber, a2Var.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            addFixed32(obj, tagFieldNumber, a2Var.readFixed32());
            return true;
        }
        Object objNewBuilder = newBuilder();
        int iMakeTag = WireFormat.makeTag(tagFieldNumber, 4);
        int i8 = i2 + 1;
        if (i8 >= recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        mergeFrom(objNewBuilder, a2Var, i8);
        if (iMakeTag != a2Var.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        addGroup(obj, tagFieldNumber, toImmutable(objNewBuilder));
        return true;
    }

    public abstract Object newBuilder();

    public abstract void setBuilderToMessage(Object obj, Object obj2);

    public void setRecursionLimit(int i2) {
        recursionLimit = i2;
    }

    public abstract void setToMessage(Object obj, Object obj2);

    public abstract boolean shouldDiscardUnknownFields(a2 a2Var);

    public abstract Object toImmutable(Object obj);

    public abstract void writeAsMessageSetTo(Object obj, v2 v2Var) throws IOException;

    public abstract void writeTo(Object obj, v2 v2Var) throws IOException;
}
