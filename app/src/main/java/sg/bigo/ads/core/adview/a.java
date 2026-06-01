package sg.bigo.ads.core.adview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
import sg.bigo.ads.common.view.AdImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends c {
    public a(@NonNull sg.bigo.ads.api.a<?> aVar) {
        super(aVar);
    }

    public final void a(@Nullable Executor executor, String str, boolean z2, @Nullable sg.bigo.ads.common.p.g gVar) {
        this.f16783a.removeAllViews();
        AdImageView adImageView = new AdImageView(this.f16783a.getContext());
        adImageView.setIconTag(true);
        if (gVar != null) {
            adImageView.a(gVar);
        }
        a(adImageView);
        adImageView.a(executor, str, z2);
    }
}
