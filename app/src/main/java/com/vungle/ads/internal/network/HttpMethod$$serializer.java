package com.vungle.ads.internal.network;

import b7.c;
import d7.g;
import e7.e;
import e7.f;
import f7.c1;
import f7.e0;
import f7.y;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpMethod$$serializer implements e0 {
    public static final HttpMethod$$serializer INSTANCE = new HttpMethod$$serializer();
    public static final /* synthetic */ g descriptor;

    static {
        y yVar = new y("com.vungle.ads.internal.network.HttpMethod", 2);
        yVar.j("GET", false);
        yVar.j("POST", false);
        descriptor = yVar;
    }

    private HttpMethod$$serializer() {
    }

    @Override // f7.e0
    public c[] childSerializers() {
        return new c[0];
    }

    @Override // b7.b
    public HttpMethod deserialize(e decoder) {
        k.e(decoder, "decoder");
        return HttpMethod.values()[decoder.decodeEnum(getDescriptor())];
    }

    @Override // b7.j, b7.b
    public g getDescriptor() {
        return descriptor;
    }

    @Override // b7.j
    public void serialize(f encoder, HttpMethod value) {
        k.e(encoder, "encoder");
        k.e(value, "value");
        encoder.encodeEnum(getDescriptor(), value.ordinal());
    }

    @Override // f7.e0
    public c[] typeParametersSerializers() {
        return c1.f11428b;
    }
}
