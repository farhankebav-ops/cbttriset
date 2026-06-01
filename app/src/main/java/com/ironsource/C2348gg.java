package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.ads.UnityAds;

/* JADX INFO: renamed from: com.ironsource.gg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2348gg implements InterfaceC2312eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2348gg f8624a = new C2348gg();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q5.f f8625b = n7.b.C(a.f8626a);

    /* JADX INFO: renamed from: com.ironsource.gg$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8626a = new a();

        public a() {
            super(0);
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            try {
                UnityAds unityAds = UnityAds.INSTANCE;
                Object objInvoke = UnityAds.class.getMethod("getVersion", null).invoke(null, null);
                if (objInvoke instanceof String) {
                    return (String) objInvoke;
                }
                return null;
            } catch (Throwable th) {
                C2531r4.d().a(th);
                IronLog.INTERNAL.warning(th.getMessage());
                return null;
            }
        }
    }

    private C2348gg() {
    }

    @Override // com.ironsource.InterfaceC2312eg
    public String a() {
        return (String) f8625b.getValue();
    }
}
