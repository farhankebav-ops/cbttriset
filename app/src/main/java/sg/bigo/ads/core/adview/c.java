package sg.bigo.ads.core.adview;

import android.view.View;
import androidx.annotation.NonNull;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.api.a<?> f16783a;

    public c(@NonNull sg.bigo.ads.api.a<?> aVar) {
        this.f16783a = aVar;
    }

    public final void a(int i2) {
        this.f16783a.setTag(Integer.valueOf(i2));
    }

    public void a(View view) {
        u.a(view, this.f16783a, null, -1);
    }

    public boolean a(int i2, int i8) {
        return u.a(this.f16783a, i2, i8);
    }
}
