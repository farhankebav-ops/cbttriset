package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.df, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2293df implements Lb<Xe, C2577u> {
    @Override // com.ironsource.Lb
    public C2577u a(Xe input) {
        String strH;
        String strI;
        String strG;
        W7 w7E;
        String strC;
        kotlin.jvm.internal.k.e(input, "input");
        EnumC2311ef enumC2311efB = input.b();
        N nA = input.a();
        if (nA == null || (strH = nA.h()) == null) {
            strH = "0";
        }
        N nA2 = input.a();
        if (nA2 == null || (strI = nA2.i()) == null) {
            strI = "0";
        }
        N nA3 = input.a();
        if (nA3 == null || (strG = nA3.g()) == null) {
            strG = "0";
        }
        N nA4 = input.a();
        if (nA4 == null || (w7E = nA4.e()) == null) {
            w7E = W7.UnknownProvider;
        }
        N nA5 = input.a();
        return new C2577u(enumC2311efB, strH, strI, strG, w7E, (nA5 == null || (strC = nA5.c()) == null) ? "0" : strC);
    }
}
