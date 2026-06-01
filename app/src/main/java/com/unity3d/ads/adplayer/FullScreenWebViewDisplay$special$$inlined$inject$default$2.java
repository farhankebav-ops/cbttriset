package com.unity3d.ads.adplayer;

import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.domain.ISDKDispatchers;
import e6.a;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FullScreenWebViewDisplay$special$$inlined$inject$default$2 extends l implements a {
    final /* synthetic */ String $named;
    final /* synthetic */ IServiceComponent $this_inject;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenWebViewDisplay$special$$inlined$inject$default$2(IServiceComponent iServiceComponent, String str) {
        super(0);
        this.$this_inject = iServiceComponent;
        this.$named = str;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.unity3d.services.core.domain.ISDKDispatchers, java.lang.Object] */
    @Override // e6.a
    public final ISDKDispatchers invoke() {
        IServiceComponent iServiceComponent = this.$this_inject;
        return iServiceComponent.getServiceProvider().getRegistry().getService(this.$named, b0.a(ISDKDispatchers.class));
    }
}
