package com.ironsource;

import com.ironsource.InterfaceC2505pb;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Oa {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(InterfaceC2505pb<LevelPlayAdInfo> interfaceC2505pb) {
        if (interfaceC2505pb instanceof InterfaceC2505pb.b) {
            return "success";
        }
        if (interfaceC2505pb instanceof InterfaceC2505pb.a) {
            return "failure";
        }
        throw new e2.s(3);
    }
}
