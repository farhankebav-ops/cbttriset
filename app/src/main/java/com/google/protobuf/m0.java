package com.google.protobuf;

import com.google.protobuf.WireFormat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m0 {
    static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

    static {
        int[] iArr = new int[WireFormat.JavaType.values().length];
        $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr;
        try {
            iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
