package com.google.protobuf;

import com.google.protobuf.FieldType;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class i0 {
    static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$FieldType$Collection;
    static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType;

    static {
        int[] iArr = new int[JavaType.values().length];
        $SwitchMap$com$google$protobuf$JavaType = iArr;
        try {
            iArr[JavaType.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$com$google$protobuf$JavaType[JavaType.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$com$google$protobuf$JavaType[JavaType.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[FieldType.a.values().length];
        $SwitchMap$com$google$protobuf$FieldType$Collection = iArr2;
        try {
            iArr2[FieldType.a.MAP.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$com$google$protobuf$FieldType$Collection[FieldType.a.VECTOR.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            $SwitchMap$com$google$protobuf$FieldType$Collection[FieldType.a.SCALAR.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
