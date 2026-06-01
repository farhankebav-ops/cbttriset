package com.vungle.ads.internal.presenter;

import android.content.Context;
import com.vungle.ads.internal.ClickCoordinateTracker;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class MRAIDPresenter$clickCoordinateTracker$2 extends l implements e6.a {
    final /* synthetic */ MRAIDPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MRAIDPresenter$clickCoordinateTracker$2(MRAIDPresenter mRAIDPresenter) {
        super(0);
        this.this$0 = mRAIDPresenter;
    }

    @Override // e6.a
    public final ClickCoordinateTracker invoke() {
        Context context = this.this$0.adWidget.getContext();
        k.d(context, "adWidget.context");
        return new ClickCoordinateTracker(context, this.this$0.advertisement);
    }
}
