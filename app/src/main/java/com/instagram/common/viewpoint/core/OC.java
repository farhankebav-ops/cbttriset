package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class OC extends QT {
    public static String[] A01 = {"LeWmJ2AEMrGR8tgfwsG9m8UwM76zwmUz", "6Bm", "ck2sw", "Oj1Ntvfg6dck0NxJmQASjzaKZXVqT4Sf", "CtYf7ZmPdO", "plI1JnuA", "RZR4g54lk6KTwqItkRA6ECctcTUw", "cGd5igXf7vOVCpmuGQi5cRxrBgQCM2pW"};
    public final /* synthetic */ C03710h A00;

    public OC(C03710h c03710h) {
        this.A00 = c03710h;
    }

    @Override // com.instagram.common.viewpoint.core.QT
    public final void A0L(C05246g c05246g, int i2) {
        int iA25;
        InterfaceC1215Xu interfaceC1215Xu;
        super.A0L(c05246g, i2);
        C1657gI linearLayoutManager = this.A00.getLayoutManager();
        if (linearLayoutManager != null && (iA25 = linearLayoutManager.A25()) >= 0) {
            C03710h c03710h = this.A00;
            int scrollPosition = A01[3].charAt(13);
            if (scrollPosition == 48) {
                throw new RuntimeException();
            }
            A01[5] = "JmqJ93Os7fwoNBdh";
            if (c03710h.getAdapter() == null || iA25 >= this.A00.getAdapter().A0B() || (interfaceC1215Xu = (InterfaceC1215Xu) c05246g.A1F(iA25)) == null) {
                return;
            }
            interfaceC1215Xu.AIV();
        }
    }
}
