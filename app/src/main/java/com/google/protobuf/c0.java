package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends a0 {
    @Override // com.google.protobuf.a0
    public int extensionNumber(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.a) entry.getKey()).getNumber();
    }

    @Override // com.google.protobuf.a0
    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i2) {
        return extensionRegistryLite.findLiteExtensionByNumber(messageLite, i2);
    }

    @Override // com.google.protobuf.a0
    public FieldSet getExtensions(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    @Override // com.google.protobuf.a0
    public FieldSet getMutableExtensions(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).ensureExtensionsAreMutable();
    }

    @Override // com.google.protobuf.a0
    public boolean hasExtensions(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // com.google.protobuf.a0
    public void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    @Override // com.google.protobuf.a0
    public <UT, UB> UB parseExtension(Object obj, a2 a2Var, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet, UB ub, p2 p2Var) throws IOException {
        Object objValueOf;
        Object field;
        ArrayList arrayList;
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj2;
        int number = generatedExtension.getNumber();
        if (generatedExtension.descriptor.isRepeated() && generatedExtension.descriptor.isPacked()) {
            switch (b0.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    a2Var.readDoubleList(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    a2Var.readFloatList(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    a2Var.readInt64List(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    a2Var.readUInt64List(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    a2Var.readInt32List(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    a2Var.readFixed64List(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    a2Var.readFixed32List(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    a2Var.readBoolList(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    a2Var.readUInt32List(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    a2Var.readSFixed32List(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    a2Var.readSFixed64List(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    a2Var.readSInt32List(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    a2Var.readSInt64List(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    a2Var.readEnumList(arrayList);
                    ub = (UB) e2.filterUnknownEnumList(obj, number, arrayList, generatedExtension.descriptor.getEnumType(), ub, p2Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.descriptor.getLiteType());
            }
            fieldSet.setField(generatedExtension.descriptor, arrayList);
            return ub;
        }
        if (generatedExtension.getLiteType() != WireFormat.FieldType.ENUM) {
            switch (b0.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    objValueOf = Double.valueOf(a2Var.readDouble());
                    break;
                case 2:
                    objValueOf = Float.valueOf(a2Var.readFloat());
                    break;
                case 3:
                    objValueOf = Long.valueOf(a2Var.readInt64());
                    break;
                case 4:
                    objValueOf = Long.valueOf(a2Var.readUInt64());
                    break;
                case 5:
                    objValueOf = Integer.valueOf(a2Var.readInt32());
                    break;
                case 6:
                    objValueOf = Long.valueOf(a2Var.readFixed64());
                    break;
                case 7:
                    objValueOf = Integer.valueOf(a2Var.readFixed32());
                    break;
                case 8:
                    objValueOf = Boolean.valueOf(a2Var.readBool());
                    break;
                case 9:
                    objValueOf = Integer.valueOf(a2Var.readUInt32());
                    break;
                case 10:
                    objValueOf = Integer.valueOf(a2Var.readSFixed32());
                    break;
                case 11:
                    objValueOf = Long.valueOf(a2Var.readSFixed64());
                    break;
                case 12:
                    objValueOf = Integer.valueOf(a2Var.readSInt32());
                    break;
                case 13:
                    objValueOf = Long.valueOf(a2Var.readSInt64());
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    objValueOf = a2Var.readBytes();
                    break;
                case 16:
                    objValueOf = a2Var.readString();
                    break;
                case 17:
                    if (!generatedExtension.isRepeated()) {
                        Object field2 = fieldSet.getField(generatedExtension.descriptor);
                        if (field2 instanceof GeneratedMessageLite) {
                            c2 c2VarSchemaFor = x1.getInstance().schemaFor(field2);
                            if (!((GeneratedMessageLite) field2).isMutable()) {
                                Object objNewInstance = c2VarSchemaFor.newInstance();
                                c2VarSchemaFor.mergeFrom(objNewInstance, field2);
                                fieldSet.setField(generatedExtension.descriptor, objNewInstance);
                                field2 = objNewInstance;
                            }
                            a2Var.mergeGroupField(field2, c2VarSchemaFor, extensionRegistryLite);
                            return ub;
                        }
                    }
                    objValueOf = a2Var.readGroup(generatedExtension.getMessageDefaultInstance().getClass(), extensionRegistryLite);
                    break;
                case 18:
                    if (!generatedExtension.isRepeated()) {
                        Object field3 = fieldSet.getField(generatedExtension.descriptor);
                        if (field3 instanceof GeneratedMessageLite) {
                            c2 c2VarSchemaFor2 = x1.getInstance().schemaFor(field3);
                            if (!((GeneratedMessageLite) field3).isMutable()) {
                                Object objNewInstance2 = c2VarSchemaFor2.newInstance();
                                c2VarSchemaFor2.mergeFrom(objNewInstance2, field3);
                                fieldSet.setField(generatedExtension.descriptor, objNewInstance2);
                                field3 = objNewInstance2;
                            }
                            a2Var.mergeMessageField(field3, c2VarSchemaFor2, extensionRegistryLite);
                            return ub;
                        }
                    }
                    objValueOf = a2Var.readMessage(generatedExtension.getMessageDefaultInstance().getClass(), extensionRegistryLite);
                    break;
                default:
                    objValueOf = null;
                    break;
            }
        } else {
            int int32 = a2Var.readInt32();
            if (generatedExtension.descriptor.getEnumType().findValueByNumber(int32) == null) {
                return (UB) e2.storeUnknownEnum(obj, number, int32, ub, p2Var);
            }
            objValueOf = Integer.valueOf(int32);
        }
        if (generatedExtension.isRepeated()) {
            fieldSet.addRepeatedField(generatedExtension.descriptor, objValueOf);
            return ub;
        }
        int i2 = b0.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()];
        if ((i2 == 17 || i2 == 18) && (field = fieldSet.getField(generatedExtension.descriptor)) != null) {
            objValueOf = Internal.mergeMessage(field, objValueOf);
        }
        fieldSet.setField(generatedExtension.descriptor, objValueOf);
        return ub;
    }

    @Override // com.google.protobuf.a0
    public void parseLengthPrefixedMessageSetItem(a2 a2Var, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        fieldSet.setField(generatedExtension.descriptor, a2Var.readMessage(generatedExtension.getMessageDefaultInstance().getClass(), extensionRegistryLite));
    }

    @Override // com.google.protobuf.a0
    public void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        MessageLite.Builder builderNewBuilderForType = generatedExtension.getMessageDefaultInstance().newBuilderForType();
        CodedInputStream codedInputStreamNewCodedInput = byteString.newCodedInput();
        builderNewBuilderForType.mergeFrom(codedInputStreamNewCodedInput, extensionRegistryLite);
        fieldSet.setField(generatedExtension.descriptor, builderNewBuilderForType.buildPartial());
        codedInputStreamNewCodedInput.checkLastTagWas(0);
    }

    @Override // com.google.protobuf.a0
    public void serializeExtension(v2 v2Var, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.a aVar = (GeneratedMessageLite.a) entry.getKey();
        if (!aVar.isRepeated()) {
            switch (b0.$SwitchMap$com$google$protobuf$WireFormat$FieldType[aVar.getLiteType().ordinal()]) {
                case 1:
                    v2Var.writeDouble(aVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    v2Var.writeFloat(aVar.getNumber(), ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    v2Var.writeInt64(aVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    v2Var.writeUInt64(aVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    v2Var.writeInt32(aVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    v2Var.writeFixed64(aVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    v2Var.writeFixed32(aVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    v2Var.writeBool(aVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 9:
                    v2Var.writeUInt32(aVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 10:
                    v2Var.writeSFixed32(aVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 11:
                    v2Var.writeSFixed64(aVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 12:
                    v2Var.writeSInt32(aVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    v2Var.writeSInt64(aVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 14:
                    v2Var.writeInt32(aVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    v2Var.writeBytes(aVar.getNumber(), (ByteString) entry.getValue());
                    break;
                case 16:
                    v2Var.writeString(aVar.getNumber(), (String) entry.getValue());
                    break;
                case 17:
                    v2Var.writeGroup(aVar.getNumber(), entry.getValue(), x1.getInstance().schemaFor((Class) entry.getValue().getClass()));
                    break;
                case 18:
                    v2Var.writeMessage(aVar.getNumber(), entry.getValue(), x1.getInstance().schemaFor((Class) entry.getValue().getClass()));
                    break;
            }
        }
        switch (b0.$SwitchMap$com$google$protobuf$WireFormat$FieldType[aVar.getLiteType().ordinal()]) {
            case 1:
                e2.writeDoubleList(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 2:
                e2.writeFloatList(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 3:
                e2.writeInt64List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 4:
                e2.writeUInt64List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 5:
                e2.writeInt32List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 6:
                e2.writeFixed64List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 7:
                e2.writeFixed32List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 8:
                e2.writeBoolList(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 9:
                e2.writeUInt32List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 10:
                e2.writeSFixed32List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 11:
                e2.writeSFixed64List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 12:
                e2.writeSInt32List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 13:
                e2.writeSInt64List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 14:
                e2.writeInt32List(aVar.getNumber(), (List) entry.getValue(), v2Var, aVar.isPacked());
                break;
            case 15:
                e2.writeBytesList(aVar.getNumber(), (List) entry.getValue(), v2Var);
                break;
            case 16:
                e2.writeStringList(aVar.getNumber(), (List) entry.getValue(), v2Var);
                break;
            case 17:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    e2.writeGroupList(aVar.getNumber(), (List) entry.getValue(), v2Var, x1.getInstance().schemaFor((Class) list.get(0).getClass()));
                    break;
                }
                break;
            case 18:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    e2.writeMessageList(aVar.getNumber(), (List) entry.getValue(), v2Var, x1.getInstance().schemaFor((Class) list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }

    @Override // com.google.protobuf.a0
    public void setExtensions(Object obj, FieldSet fieldSet) {
        ((GeneratedMessageLite.ExtendableMessage) obj).extensions = fieldSet;
    }
}
