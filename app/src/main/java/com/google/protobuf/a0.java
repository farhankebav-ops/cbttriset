package com.google.protobuf;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 {
    public abstract int extensionNumber(Map.Entry<?, ?> entry);

    public abstract Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i2);

    public abstract FieldSet getExtensions(Object obj);

    public abstract FieldSet getMutableExtensions(Object obj);

    public abstract boolean hasExtensions(MessageLite messageLite);

    public abstract void makeImmutable(Object obj);

    public abstract <UT, UB> UB parseExtension(Object obj, a2 a2Var, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet, UB ub, p2 p2Var) throws IOException;

    public abstract void parseLengthPrefixedMessageSetItem(a2 a2Var, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) throws IOException;

    public abstract void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet fieldSet) throws IOException;

    public abstract void serializeExtension(v2 v2Var, Map.Entry<?, ?> entry) throws IOException;

    public abstract void setExtensions(Object obj, FieldSet fieldSet);
}
