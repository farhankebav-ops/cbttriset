package com.vungle.ads.internal.presenter;

import com.vungle.ads.internal.util.HandlerScheduler;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MRAIDPresenter$scheduler$2 extends l implements e6.a {
    public static final MRAIDPresenter$scheduler$2 INSTANCE = new MRAIDPresenter$scheduler$2();

    public MRAIDPresenter$scheduler$2() {
        super(0);
    }

    @Override // e6.a
    public final HandlerScheduler invoke() {
        return new HandlerScheduler();
    }
}
