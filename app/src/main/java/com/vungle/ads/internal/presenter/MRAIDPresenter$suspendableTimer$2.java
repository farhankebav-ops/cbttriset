package com.vungle.ads.internal.presenter;

import com.vungle.ads.HeartbeatMissingError;
import com.vungle.ads.internal.util.SuspendableTimer;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MRAIDPresenter$suspendableTimer$2 extends l implements e6.a {
    final /* synthetic */ MRAIDPresenter this$0;

    /* JADX INFO: renamed from: com.vungle.ads.internal.presenter.MRAIDPresenter$suspendableTimer$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.a {
        final /* synthetic */ MRAIDPresenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MRAIDPresenter mRAIDPresenter) {
            super(0);
            this.this$0 = mRAIDPresenter;
        }

        @Override // e6.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m3343invoke();
            return x.f13520a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3343invoke() {
            this.this$0.reportErrorAndCloseAd(new HeartbeatMissingError());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MRAIDPresenter$suspendableTimer$2(MRAIDPresenter mRAIDPresenter) {
        super(0);
        this.this$0 = mRAIDPresenter;
    }

    @Override // e6.a
    public final SuspendableTimer invoke() {
        return new SuspendableTimer(6.0d, true, null, new AnonymousClass1(this.this$0), 4, null);
    }
}
