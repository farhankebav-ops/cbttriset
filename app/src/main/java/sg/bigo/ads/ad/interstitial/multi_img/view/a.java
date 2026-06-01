package sg.bigo.ads.ad.interstitial.multi_img.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import sg.bigo.ads.R;
import sg.bigo.ads.common.p.f;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.view.AdImageView;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends d<AdImageView> implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private sg.bigo.ads.ad.interstitial.multi_img.b f14884a;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ValueCallback<a> f14885t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f14886u;

    public a(Context context, sg.bigo.ads.ad.interstitial.multi_img.b bVar, sg.bigo.ads.ad.interstitial.multi_img.c cVar, int i2, int i8, String str, boolean z2, ValueCallback<a> valueCallback) {
        super(context, cVar, false, i2, i8, R.layout.bigo_ad_activity_interstitial_rich_video_multi_img_item_layout, R.id.inter_media_item_layout, R.id.inter_media_item, R.id.inter_media_item_background);
        this.f14884a = bVar;
        this.f14886u = str;
        this.f14885t = valueCallback;
        if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
            ((AdImageView) this.l).a(this);
            ((AdImageView) this.l).a(str, z2);
            if (bVar != null) {
                bVar.a(str, 0);
            }
        }
        ((AdImageView) this.l).setFadeEnable(true);
        this.j.setStrokeWidth(e.a(context, 1));
        this.j.setStrokeColor(q.b("#08000000", -7829368));
        ((AdImageView) this.l).setBackgroundColor(q.b("#FFE1E1E6", -7829368));
        ((AdImageView) this.l).setImageDrawable(sg.bigo.ads.common.utils.a.a(context, R.drawable.bigo_ad_icon_default_only_icon));
    }

    @Override // sg.bigo.ads.common.p.g
    public final void a(int i2, @NonNull String str, String str2) {
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.f14884a;
        if (bVar != null) {
            bVar.a(this.f14886u, 2);
        }
        ((AdImageView) this.l).post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.a.3
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.f14885t != null) {
                    a.this.f14885t.onReceiveValue(a.this);
                }
            }
        });
    }

    public final void a(final Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        ((AdImageView) this.l).post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.a(a.this, bitmap);
                ((AdImageView) a.this.l).setImageBitmap(bitmap);
            }
        });
    }

    @Override // sg.bigo.ads.common.p.g
    public final void a(@NonNull final Bitmap bitmap, @NonNull f fVar) {
        sg.bigo.ads.ad.interstitial.multi_img.b bVar = this.f14884a;
        if (bVar != null) {
            bVar.a(this.f14886u, 1);
        }
        ((AdImageView) this.l).post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.view.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.a(a.this, bitmap);
                ((AdImageView) a.this.l).setBackground(null);
            }
        });
    }

    public static /* synthetic */ void a(a aVar, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 0 && height > 0) {
            ViewGroup.LayoutParams layoutParams = aVar.j.getLayoutParams();
            if (layoutParams instanceof ViewFlow.b) {
                ViewFlow.b bVar = (ViewFlow.b) layoutParams;
                bVar.f16158a = width;
                bVar.f16159b = height;
            }
            aVar.j.setLayoutParams(layoutParams);
            aVar.a(width, height);
        }
        aVar.b(bitmap);
    }

    @Override // sg.bigo.ads.ad.interstitial.multi_img.view.d
    public final boolean a() {
        if (super.a()) {
            return true;
        }
        sg.bigo.ads.ad.interstitial.multi_img.c cVar = this.g;
        if (cVar == null) {
            return false;
        }
        int i2 = cVar.f14860d;
        return i2 == 3 || i2 == 2;
    }
}
