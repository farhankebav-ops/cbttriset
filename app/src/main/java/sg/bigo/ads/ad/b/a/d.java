package sg.bigo.ads.ad.b.a;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.a.k;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends sg.bigo.ads.ad.b.c {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private k f13874x;

    public d(@NonNull sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        k kVarX = gVar.f15497b.x();
        this.f13874x = kVarX;
        this.I = kVarX.c();
    }

    @Override // sg.bigo.ads.ad.b.c
    public final void a(@NonNull ViewGroup viewGroup, MediaView mediaView, @Nullable View view, @Nullable AdOptionsView adOptionsView, @Nullable List<View> list, int i2, @Nullable View... viewArr) {
        super.a(viewGroup, mediaView, view, adOptionsView, list, i2, viewArr);
        if (this.f13874x.b()) {
            sg.bigo.ads.ad.b.a.a(viewGroup, viewGroup, i2, this, this.I);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [sg.bigo.ads.api.core.c] */
    @Override // sg.bigo.ads.ad.b.c, sg.bigo.ads.ad.d, sg.bigo.ads.ad.c
    public final void destroyInMainThread() {
        super.destroyInMainThread();
        if (this.f14031q) {
            return;
        }
        this.f14031q = true;
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) f(), SystemClock.elapsedRealtime() - this.k);
    }
}
