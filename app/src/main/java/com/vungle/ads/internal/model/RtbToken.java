package com.vungle.ads.internal.model;

import b7.c;
import b7.h;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.vungle.ads.internal.model.CommonRequestBody;
import d7.g;
import e7.d;
import f7.c1;
import f7.m1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class RtbToken {
    public static final Companion Companion = new Companion(null);
    private final DeviceNode device;
    private final CommonRequestBody.RequestExt ext;
    private final int ordinalView;
    private final RtbRequest request;
    private final CommonRequestBody.User user;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return RtbToken$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ RtbToken(int i2, DeviceNode deviceNode, CommonRequestBody.User user, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i8, m1 m1Var) {
        if (17 != (i2 & 17)) {
            c1.j(RtbToken$$serializer.INSTANCE.getDescriptor(), i2, 17);
            throw null;
        }
        this.device = deviceNode;
        if ((i2 & 2) == 0) {
            this.user = null;
        } else {
            this.user = user;
        }
        if ((i2 & 4) == 0) {
            this.ext = null;
        } else {
            this.ext = requestExt;
        }
        if ((i2 & 8) == 0) {
            this.request = null;
        } else {
            this.request = rtbRequest;
        }
        this.ordinalView = i8;
    }

    public static /* synthetic */ RtbToken copy$default(RtbToken rtbToken, DeviceNode deviceNode, CommonRequestBody.User user, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            deviceNode = rtbToken.device;
        }
        if ((i8 & 2) != 0) {
            user = rtbToken.user;
        }
        if ((i8 & 4) != 0) {
            requestExt = rtbToken.ext;
        }
        if ((i8 & 8) != 0) {
            rtbRequest = rtbToken.request;
        }
        if ((i8 & 16) != 0) {
            i2 = rtbToken.ordinalView;
        }
        int i9 = i2;
        CommonRequestBody.RequestExt requestExt2 = requestExt;
        return rtbToken.copy(deviceNode, user, requestExt2, rtbRequest, i9);
    }

    public static final void write$Self(RtbToken self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        output.encodeSerializableElement(serialDesc, 0, DeviceNode$$serializer.INSTANCE, self.device);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.user != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, CommonRequestBody$User$$serializer.INSTANCE, self.user);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.ext != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, CommonRequestBody$RequestExt$$serializer.INSTANCE, self.ext);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.request != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, RtbRequest$$serializer.INSTANCE, self.request);
        }
        output.encodeIntElement(serialDesc, 4, self.ordinalView);
    }

    public final DeviceNode component1() {
        return this.device;
    }

    public final CommonRequestBody.User component2() {
        return this.user;
    }

    public final CommonRequestBody.RequestExt component3() {
        return this.ext;
    }

    public final RtbRequest component4() {
        return this.request;
    }

    public final int component5() {
        return this.ordinalView;
    }

    public final RtbToken copy(DeviceNode device, CommonRequestBody.User user, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i2) {
        k.e(device, "device");
        return new RtbToken(device, user, requestExt, rtbRequest, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RtbToken)) {
            return false;
        }
        RtbToken rtbToken = (RtbToken) obj;
        return k.a(this.device, rtbToken.device) && k.a(this.user, rtbToken.user) && k.a(this.ext, rtbToken.ext) && k.a(this.request, rtbToken.request) && this.ordinalView == rtbToken.ordinalView;
    }

    public final DeviceNode getDevice() {
        return this.device;
    }

    public final CommonRequestBody.RequestExt getExt() {
        return this.ext;
    }

    public final int getOrdinalView() {
        return this.ordinalView;
    }

    public final RtbRequest getRequest() {
        return this.request;
    }

    public final CommonRequestBody.User getUser() {
        return this.user;
    }

    public int hashCode() {
        int iHashCode = this.device.hashCode() * 31;
        CommonRequestBody.User user = this.user;
        int iHashCode2 = (iHashCode + (user == null ? 0 : user.hashCode())) * 31;
        CommonRequestBody.RequestExt requestExt = this.ext;
        int iHashCode3 = (iHashCode2 + (requestExt == null ? 0 : requestExt.hashCode())) * 31;
        RtbRequest rtbRequest = this.request;
        return ((iHashCode3 + (rtbRequest != null ? rtbRequest.hashCode() : 0)) * 31) + this.ordinalView;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RtbToken(device=");
        sb.append(this.device);
        sb.append(", user=");
        sb.append(this.user);
        sb.append(", ext=");
        sb.append(this.ext);
        sb.append(", request=");
        sb.append(this.request);
        sb.append(", ordinalView=");
        return a0.c(sb, this.ordinalView, ')');
    }

    public RtbToken(DeviceNode device, CommonRequestBody.User user, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i2) {
        k.e(device, "device");
        this.device = device;
        this.user = user;
        this.ext = requestExt;
        this.request = rtbRequest;
        this.ordinalView = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RtbToken(DeviceNode deviceNode, CommonRequestBody.User user, CommonRequestBody.RequestExt requestExt, RtbRequest rtbRequest, int i2, int i8, f fVar) {
        int i9;
        RtbRequest rtbRequest2;
        user = (i8 & 2) != 0 ? null : user;
        requestExt = (i8 & 4) != 0 ? null : requestExt;
        if ((i8 & 8) != 0) {
            i9 = i2;
            rtbRequest2 = null;
        } else {
            i9 = i2;
            rtbRequest2 = rtbRequest;
        }
        this(deviceNode, user, requestExt, rtbRequest2, i9);
    }

    public static /* synthetic */ void getOrdinalView$annotations() {
    }
}
