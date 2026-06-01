package sg.bigo.ads.ad.interstitial.multi_img.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Button;
import sg.bigo.ads.R;
import sg.bigo.ads.api.MediaView;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends d<MediaView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Button f14892a;

    public b(Context context, sg.bigo.ads.ad.interstitial.multi_img.c cVar, boolean z2, int i2, int i8) {
        super(context, cVar, z2, i2, i8, R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_media_layout, R.id.inter_media_layout, R.id.inter_media, R.id.inter_media_main_background);
        this.f14892a = (Button) this.j.findViewById(R.id.inter_btn_mute);
    }

    public final void a(final Bitmap bitmap) {
        ((MediaView) this.l).post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b.this.b(bitmap);
            }
        });
    }

    public final boolean b() {
        int i2;
        int i8 = this.f14904i;
        return i8 == 4 || i8 == 3 || (i2 = this.h) == 4 || i2 == 3;
    }

    public final boolean c() {
        int i2;
        int i8 = this.f14904i;
        return i8 == 5 || i8 == 4 || (i2 = this.h) == 5 || i2 == 4;
    }

    @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d
    public final boolean a() {
        if (super.a()) {
            return true;
        }
        sg.bigo.ads.ad.interstitial.multi_img.c cVar = this.g;
        return cVar != null && cVar.f14860d == 3;
    }
}
