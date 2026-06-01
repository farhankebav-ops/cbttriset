package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import gatewayprotocol.v1.AdFormatOuterClass;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface GetAdPlayerConfigRequest {
    Object invoke(String str, ByteString byteString, ByteString byteString2, AdFormatOuterClass.AdFormat adFormat, c<? super UniversalRequestOuterClass.UniversalRequest> cVar);
}
