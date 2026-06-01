package sg.bigo.ads.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.RoundedFrameLayout;
import sg.bigo.ads.core.adview.f;
import sg.bigo.ads.core.f.a.p;

/* JADX INFO: loaded from: classes6.dex */
public class MediaView extends sg.bigo.ads.api.a<f> {

    public interface a {
        void a(sg.bigo.ads.core.player.b.b bVar);

        void a(boolean z2);

        boolean a();

        void b();
    }

    public MediaView(@NonNull Context context) {
        super(context);
    }

    @Override // sg.bigo.ads.api.a
    @NonNull
    public final /* synthetic */ sg.bigo.ads.core.adview.c a() {
        return new f(this);
    }

    public final float b(int i2, int i8) {
        f viewImpl = getViewImpl();
        if (viewImpl.f16801c == null) {
            return 0.0f;
        }
        return viewImpl.c() > viewImpl.d() ? (((viewImpl.c() * i8) / viewImpl.d()) * 1.0f) / i2 : (((viewImpl.d() * i2) / viewImpl.c()) * 1.0f) / i8;
    }

    public final void c() {
        f viewImpl = getViewImpl();
        AdImageView adImageView = viewImpl.f16801c;
        if (adImageView != null) {
            adImageView.setImageBitmap(null);
            viewImpl.f16801c.a();
            viewImpl.f16801c = null;
        }
        sg.bigo.ads.core.player.b.f fVar = viewImpl.f16800b;
        if (fVar != null) {
            fVar.d();
            viewImpl.f16800b = null;
        }
    }

    public View getImage() {
        return getViewImpl().f16801c;
    }

    @Nullable
    public VideoController getVideoController() {
        return getViewImpl().f16803f;
    }

    public void setImageBlurBorder(boolean z2) {
        getViewImpl().g = z2;
    }

    public void setMediaAreaClickable(boolean z2) {
        getViewImpl().e = Boolean.valueOf(z2);
    }

    public void setOtherClickAreaClick(boolean z2) {
        getViewImpl().f16802d = Boolean.valueOf(z2);
    }

    public MediaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(Bitmap bitmap) {
        getViewImpl().g = false;
        f viewImpl = getViewImpl();
        if (bitmap != null) {
            int iA = e.a(viewImpl.f16783a.getContext(), 10);
            int iA2 = e.a(viewImpl.f16783a.getContext(), 4);
            RoundedFrameLayout roundedFrameLayout = new RoundedFrameLayout(viewImpl.f16783a.getContext());
            roundedFrameLayout.setCornerRadius(iA2);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            boolean z2 = (width == height && viewImpl.f16783a.getWidth() <= viewImpl.f16783a.getHeight()) || width > height;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(z2 ? -1 : -2, z2 ? -2 : -1, 17);
            layoutParams.setMargins(iA, iA, iA, iA);
            roundedFrameLayout.setLayoutParams(layoutParams);
            AdImageView adImageView = new AdImageView(viewImpl.f16783a.getContext());
            adImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            u.a(adImageView, roundedFrameLayout, null, -1);
            u.a(roundedFrameLayout, viewImpl.f16783a, null, -1);
            adImageView.setBlurBorder(viewImpl.g);
            adImageView.setImageBitmap(bitmap);
        }
    }

    @NonNull
    public final a b() {
        return getViewImpl();
    }

    public MediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void a(@NonNull String str) {
        getViewImpl().a(str);
    }

    public final void a(@NonNull o oVar, @Nullable g gVar) {
        getViewImpl().a(oVar, gVar);
    }

    public final void a(@NonNull sg.bigo.ads.core.a.a aVar, @NonNull p pVar, sg.bigo.ads.core.g.c cVar) {
        getViewImpl().a(aVar, pVar, cVar);
    }

    public final void a(@NonNull sg.bigo.ads.core.player.b.d dVar) {
        getViewImpl().a(dVar);
    }
}
