package sg.bigo.ads.ad.c;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ImageView f14076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    sg.bigo.ads.ad.b.c f14077b;

    public b(@NonNull sg.bigo.ads.ad.b.c cVar) {
        ImageView imageView;
        Context context;
        this.f14077b = cVar;
        if (cVar == null || (context = cVar.f14024b.f15500f) == null) {
            imageView = null;
        } else {
            imageView = new ImageView(context);
            int iA = e.a(context, 38);
            imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(iA, iA));
            imageView.setVisibility(8);
        }
        this.f14076a = imageView;
    }

    public final void a() {
        ImageView imageView = this.f14076a;
        if (imageView != null) {
            u.b(imageView);
            this.f14076a = null;
        }
        sg.bigo.ads.ad.b.c cVar = this.f14077b;
        if (cVar != null) {
            cVar.destroy();
            this.f14077b = null;
        }
    }
}
