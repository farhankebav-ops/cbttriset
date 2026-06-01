package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class ji {
    public static boolean a(InterfaceC2408k5 interfaceC2408k5) {
        return interfaceC2408k5.k().exists();
    }

    public static void b(InterfaceC2408k5 interfaceC2408k5) {
        interfaceC2408k5.l().a(interfaceC2408k5);
        if (interfaceC2408k5.k().exists()) {
            IronSourceStorageUtils.deleteFile(interfaceC2408k5.k());
        }
        try {
            interfaceC2408k5.l().a(interfaceC2408k5.k(), interfaceC2408k5.d().value(), 5, 5);
        } catch (Exception e) {
            C2531r4.d().a(e);
            interfaceC2408k5.i().invoke(new q5.k(r2.q.M(e)));
        }
    }
}
