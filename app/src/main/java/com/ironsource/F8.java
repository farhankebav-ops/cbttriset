package com.ironsource;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.sdk.utils.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class F8 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f6758b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        void a(rg rgVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F8(Context context) {
        super(context);
        kotlin.jvm.internal.k.e(context, "context");
        this.f6757a = "ISNNativeAdContainer";
    }

    private final rg a() {
        return new rg(getVisibility() == 0, getWindowVisibility() == 0, isShown());
    }

    public final a getListener$mediationsdk_release() {
        return this.f6758b;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int i2) {
        kotlin.jvm.internal.k.e(changedView, "changedView");
        Logger.i(this.f6757a, "onVisibilityChanged: " + i2);
        a aVar = this.f6758b;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Logger.i(this.f6757a, "onWindowVisibilityChanged: " + i2);
        a aVar = this.f6758b;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    public final void setListener$mediationsdk_release(a aVar) {
        this.f6758b = aVar;
    }
}
