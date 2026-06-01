package com.unity3d.services.core.domain;

import q6.m0;
import q6.w;
import v6.n;
import x6.d;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SDKDispatchers implements ISDKDispatchers {

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private final w f3197default;
    private final w io;
    private final w main;

    public SDKDispatchers() {
        e eVar = m0.f13566a;
        this.io = d.f17810a;
        this.f3197default = m0.f13566a;
        this.main = n.f17641a;
    }

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    public w getDefault() {
        return this.f3197default;
    }

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    public w getIo() {
        return this.io;
    }

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    public w getMain() {
        return this.main;
    }
}
