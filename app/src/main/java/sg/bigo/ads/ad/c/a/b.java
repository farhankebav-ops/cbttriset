package sg.bigo.ads.ad.c.a;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.mlkit.common.MlKitException;
import sg.bigo.ads.R;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends a {
    private View h;

    public b(@NonNull sg.bigo.ads.ad.b.c cVar, @NonNull Context context) {
        super(cVar, context);
        sg.bigo.ads.api.c.b.a(0);
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int a() {
        return R.layout.bigo_ad_native_banner_medium;
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int b() {
        return e.a(this.f14058c, 8);
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int[] c() {
        return new int[]{e.a(this.f14058c, -57), e.a(this.f14058c, 153)};
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final void d() {
        this.f14057b = new FrameLayout(this.f14058c);
        int iA = e.a(this.f14058c, 276);
        int iA2 = e.a(this.f14058c, 174);
        MediaView mediaView = new MediaView(this.f14058c);
        this.f14059d = mediaView;
        mediaView.setImageBlurBorder(false);
        this.f14059d.setLayoutParams(new ViewGroup.LayoutParams(iA, iA2));
        View viewA = sg.bigo.ads.common.utils.a.a(this.f14058c, R.layout.bigo_ad_banner_placeholder_img, null, false);
        this.h = viewA;
        if (viewA != null) {
            u.a(viewA, this.f14059d, null, -1);
            View view = this.h;
            a.a((TextView) view.findViewById(R.id.bigo_ad_banner_background_text), this.f14056a.getTitle(), "");
            a.a((TextView) view.findViewById(R.id.bigo_ad_image_title), this.f14056a.getTitle(), "");
            a.a((TextView) view.findViewById(R.id.bigo_ad_banner_image_description), this.f14056a.getDescription(), "");
            TextView textView = (TextView) view.findViewById(R.id.bigo_ad_banner_image_domain);
            String advertiser = this.f14056a.getAdvertiser();
            if (textView != null) {
                if (TextUtils.isEmpty(advertiser)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(advertiser);
                }
            }
        }
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int i() {
        return MlKitException.LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE;
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final int j() {
        return 250;
    }

    @Override // sg.bigo.ads.ad.c.a.a
    public final void b(int i2) {
        if (this.h != null) {
            this.h.setBackground(new BitmapDrawable(this.f14058c.getResources(), g()));
        }
        super.b(i2);
    }
}
