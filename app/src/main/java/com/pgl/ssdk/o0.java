package com.pgl.ssdk;

import android.content.Context;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class o0 extends l0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Context f10801n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f10802o;

    public o0(Context context, int i2) {
        super(context);
        this.f10801n = context;
        this.f10802o = i2;
    }

    @Override // com.pgl.ssdk.l0
    public String a() {
        int i2 = this.f10802o;
        if (i2 == 222) {
            return "/ssdk/v2/r?os=0&ver=7.2.0.0.overseas-rc.6&mode=1&app_ver=" + b0.h(this.f10801n) + "&region=" + d0.a() + "&did=" + com.pgl.ssdk.ces.b.d() + "&aid=" + com.pgl.ssdk.ces.b.c();
        }
        if (i2 != 301) {
            return null;
        }
        return "/ssdk/sd/token?os=android&app_id=" + com.pgl.ssdk.ces.b.c() + "&did=" + com.pgl.ssdk.ces.b.d() + "&app_ver=" + b0.h(this.f10801n) + "&platform=android&ver=7.2.0.0.overseas-rc.6&mode=1";
    }

    @Override // com.pgl.ssdk.l0
    public void a(int i2, byte[] bArr) {
        try {
            if (i2 == 200) {
                int i8 = this.f10802o;
                if (i8 == 222) {
                    ((Integer) com.pgl.ssdk.ces.a.meta(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, null, bArr)).getClass();
                    return;
                }
                if (i8 == 301) {
                    Object objA = e1.a(bArr);
                    t0.b("write token result = ".concat(String.valueOf(objA)));
                    if ((objA instanceof Integer) && ((Integer) objA).intValue() == 0) {
                        t0.b("write token succ");
                        e1.f10756a = 200;
                        return;
                    } else {
                        if (objA instanceof String) {
                            e1.f10758c = (String) objA;
                            e1.f10756a = 200;
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            m0.b(this.f10801n);
        } catch (Throwable unused) {
        }
    }
}
