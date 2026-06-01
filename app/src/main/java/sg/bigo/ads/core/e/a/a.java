package sg.bigo.ads.core.e.a;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.core.r;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f16910a;
    private AtomicBoolean p;

    public a(r rVar, e[] eVarArr, e[] eVarArr2, e[] eVarArr3, e[] eVarArr4, Map<String, String> map) {
        super(rVar, eVarArr, eVarArr2, eVarArr3, eVarArr4, map);
        this.f16910a = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
    }

    @Override // sg.bigo.ads.core.e.a.b
    public final void a(Context context, boolean z2) {
        if (this.f16910a.compareAndSet(false, true)) {
            super.a(context, z2);
        } else {
            sg.bigo.ads.common.t.a.a(0, 3, "AdEarlyTracker", "Impression already tracked, so skipping this call.");
        }
    }
}
