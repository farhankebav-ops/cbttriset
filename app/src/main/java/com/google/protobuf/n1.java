package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.LazyField;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class n1 implements c2 {
    private final MessageLite defaultInstance;
    private final a0 extensionSchema;
    private final boolean hasExtensions;
    private final p2 unknownFieldSchema;

    private n1(p2 p2Var, a0 a0Var, MessageLite messageLite) {
        this.unknownFieldSchema = p2Var;
        this.hasExtensions = a0Var.hasExtensions(messageLite);
        this.extensionSchema = a0Var;
        this.defaultInstance = messageLite;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(p2 p2Var, Object obj) {
        return p2Var.getSerializedSizeAsMessageSet(p2Var.getFromMessage(obj));
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(p2 p2Var, a0 a0Var, Object obj, a2 a2Var, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        p2 p2Var2;
        a0 a0Var2;
        a2 a2Var2;
        ExtensionRegistryLite extensionRegistryLite2;
        Object builderFromMessage = p2Var.getBuilderFromMessage(obj);
        FieldSet mutableExtensions = a0Var.getMutableExtensions(obj);
        while (a2Var.getFieldNumber() != Integer.MAX_VALUE) {
            try {
                p2Var2 = p2Var;
                a0Var2 = a0Var;
                a2Var2 = a2Var;
                extensionRegistryLite2 = extensionRegistryLite;
            } catch (Throwable th) {
                th = th;
                p2Var2 = p2Var;
            }
            try {
                if (!parseMessageSetItemOrUnknownField(a2Var2, extensionRegistryLite2, a0Var2, mutableExtensions, p2Var2, builderFromMessage)) {
                    p2Var2.setBuilderToMessage(obj, builderFromMessage);
                    return;
                }
                a2Var = a2Var2;
                extensionRegistryLite = extensionRegistryLite2;
                a0Var = a0Var2;
                p2Var = p2Var2;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                p2Var2.setBuilderToMessage(obj, builderFromMessage);
                throw th3;
            }
        }
        p2Var.setBuilderToMessage(obj, builderFromMessage);
    }

    public static <T> n1 newSchema(p2 p2Var, a0 a0Var, MessageLite messageLite) {
        return new n1(p2Var, a0Var, messageLite);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(a2 a2Var, ExtensionRegistryLite extensionRegistryLite, a0 a0Var, FieldSet fieldSet, p2 p2Var, UB ub) throws IOException {
        int tag = a2Var.getTag();
        int uInt32 = 0;
        if (tag != WireFormat.MESSAGE_SET_ITEM_TAG) {
            if (WireFormat.getTagWireType(tag) != 2) {
                return a2Var.skipField();
            }
            Object objFindExtensionByNumber = a0Var.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, WireFormat.getTagFieldNumber(tag));
            if (objFindExtensionByNumber == null) {
                return p2Var.mergeOneFieldFrom(ub, a2Var, 0);
            }
            a0Var.parseLengthPrefixedMessageSetItem(a2Var, objFindExtensionByNumber, extensionRegistryLite, fieldSet);
            return true;
        }
        Object objFindExtensionByNumber2 = null;
        ByteString bytes = null;
        while (a2Var.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = a2Var.getTag();
            if (tag2 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                uInt32 = a2Var.readUInt32();
                objFindExtensionByNumber2 = a0Var.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, uInt32);
            } else if (tag2 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (objFindExtensionByNumber2 != null) {
                    a0Var.parseLengthPrefixedMessageSetItem(a2Var, objFindExtensionByNumber2, extensionRegistryLite, fieldSet);
                } else {
                    bytes = a2Var.readBytes();
                }
            } else if (!a2Var.skipField()) {
                break;
            }
        }
        if (a2Var.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        if (bytes != null) {
            if (objFindExtensionByNumber2 != null) {
                a0Var.parseMessageSetItem(bytes, objFindExtensionByNumber2, extensionRegistryLite, fieldSet);
            } else {
                p2Var.addLengthDelimited(ub, uInt32, bytes);
            }
        }
        return true;
    }

    private <UT, UB> void writeUnknownFieldsHelper(p2 p2Var, Object obj, v2 v2Var) throws IOException {
        p2Var.writeAsMessageSetTo(p2Var.getFromMessage(obj), v2Var);
    }

    @Override // com.google.protobuf.c2
    public boolean equals(Object obj, Object obj2) {
        if (!this.unknownFieldSchema.getFromMessage(obj).equals(this.unknownFieldSchema.getFromMessage(obj2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(obj).equals(this.extensionSchema.getExtensions(obj2));
        }
        return true;
    }

    @Override // com.google.protobuf.c2
    public int getSerializedSize(Object obj) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, obj);
        return this.hasExtensions ? this.extensionSchema.getExtensions(obj).getMessageSetSerializedSize() + unknownFieldsSerializedSize : unknownFieldsSerializedSize;
    }

    @Override // com.google.protobuf.c2
    public int hashCode(Object obj) {
        int iHashCode = this.unknownFieldSchema.getFromMessage(obj).hashCode();
        if (!this.hasExtensions) {
            return iHashCode;
        }
        return this.extensionSchema.getExtensions(obj).hashCode() + (iHashCode * 53);
    }

    @Override // com.google.protobuf.c2
    public final boolean isInitialized(Object obj) {
        return this.extensionSchema.getExtensions(obj).isInitialized();
    }

    @Override // com.google.protobuf.c2
    public void makeImmutable(Object obj) {
        this.unknownFieldSchema.makeImmutable(obj);
        this.extensionSchema.makeImmutable(obj);
    }

    @Override // com.google.protobuf.c2
    public void mergeFrom(Object obj, Object obj2) {
        e2.mergeUnknownFields(this.unknownFieldSchema, obj, obj2);
        if (this.hasExtensions) {
            e2.mergeExtensions(this.extensionSchema, obj, obj2);
        }
    }

    @Override // com.google.protobuf.c2
    public Object newInstance() {
        MessageLite messageLite = this.defaultInstance;
        return messageLite instanceof GeneratedMessageLite ? ((GeneratedMessageLite) messageLite).newMutableInstance() : messageLite.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.c2
    public void writeTo(Object obj, v2 v2Var) throws IOException {
        for (Map.Entry<FieldSet.FieldDescriptorLite<Object>, Object> entry : this.extensionSchema.getExtensions(obj)) {
            FieldSet.FieldDescriptorLite<Object> key = entry.getKey();
            if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof LazyField.a) {
                v2Var.writeMessageSetItem(key.getNumber(), ((LazyField.a) entry).getField().toByteString());
            } else {
                v2Var.writeMessageSetItem(key.getNumber(), entry.getValue());
            }
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, obj, v2Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cf A[EDGE_INSN: B:62:0x00cf->B:34:0x00cf BREAK  A[LOOP:1: B:17:0x006f->B:65:0x006f], SYNTHETIC] */
    @Override // com.google.protobuf.c2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mergeFrom(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.protobuf.f.a r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.n1.mergeFrom(java.lang.Object, byte[], int, int, com.google.protobuf.f$a):void");
    }

    @Override // com.google.protobuf.c2
    public void mergeFrom(Object obj, a2 a2Var, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, obj, a2Var, extensionRegistryLite);
    }
}
