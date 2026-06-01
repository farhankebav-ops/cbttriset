package sg.bigo.ads.ad.interstitial.multi_img;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.common.view.ViewFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ViewGroup f14836a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ViewFlow f14839d;
    final int e;
    private final sg.bigo.ads.ad.interstitial.d h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f14837b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f14838c = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14840f = true;
    float g = Float.MIN_VALUE;

    public a(ViewGroup viewGroup, ViewFlow viewFlow, sg.bigo.ads.ad.interstitial.d dVar, int i2) {
        this.f14836a = viewGroup;
        this.f14839d = viewFlow;
        this.h = dVar;
        this.e = i2;
    }

    public final void a(final int i2) {
        if (this.f14840f) {
            sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a aVar = a.this;
                    int i8 = i2;
                    if (i8 == aVar.f14837b && i8 == aVar.f14838c) {
                        aVar.b(i8);
                    }
                }
            });
        }
    }

    public final void b(int i2) {
        if (this.f14840f) {
            View viewA = this.f14839d.a(i2);
            Object tag = viewA.getTag(sg.bigo.ads.ad.interstitial.multi_img.view.d.e);
            if (tag instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d) {
                sg.bigo.ads.ad.interstitial.multi_img.view.d dVar = (sg.bigo.ads.ad.interstitial.multi_img.view.d) tag;
                this.f14837b = i2;
                this.g = Float.MIN_VALUE;
                this.f14838c = i2;
                if (dVar.d(this.e)) {
                    this.f14836a.setBackgroundColor(this.h.a(dVar.f14905n));
                    return;
                }
                if (dVar.c(this.e)) {
                    this.h.a(dVar.f14906o);
                    Bitmap bitmap = dVar.p;
                    int i8 = dVar.f14907q;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(viewA.getResources(), bitmap);
                    bitmapDrawable.setAlpha(i8);
                    ViewGroup viewGroup = this.f14836a;
                    if (bitmap == null) {
                        bitmapDrawable = null;
                    }
                    a(viewGroup, bitmapDrawable, (BitmapDrawable) null);
                }
            }
        }
    }

    public static void a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
        a(viewGroup, "adview_background_main_tag", bitmapDrawable);
        a(viewGroup, "adview_background_second_tag", bitmapDrawable2);
    }

    public static void a(ViewGroup viewGroup, Object obj, BitmapDrawable bitmapDrawable) {
        ImageView imageView;
        View viewFindViewWithTag = viewGroup.findViewWithTag(obj);
        if (viewFindViewWithTag instanceof ImageView) {
            imageView = (ImageView) viewFindViewWithTag;
        } else {
            Context context = viewGroup.getContext();
            if (context != null) {
                ImageView imageView2 = new ImageView(context);
                imageView2.setTag(obj);
                imageView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                u.a(imageView2, viewGroup, null, 0);
                imageView = imageView2;
            } else {
                imageView = null;
            }
        }
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageDrawable(bitmapDrawable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(sg.bigo.ads.ad.interstitial.multi_img.view.d r3, float r4, int r5) {
        /*
            r2 = this;
            int r0 = r2.f14837b
            if (r5 == r0) goto L5
            goto L61
        L5:
            int r0 = r2.e
            boolean r0 = r3.d(r0)
            if (r0 == 0) goto L10
            int r3 = r3.f14905n
            goto L12
        L10:
            int r3 = r3.f14906o
        L12:
            r2.g = r4
            r1 = 0
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 <= 0) goto L1e
            int r5 = r5 + (-1)
        L1b:
            r2.f14838c = r5
            goto L21
        L1e:
            int r5 = r5 + 1
            goto L1b
        L21:
            sg.bigo.ads.common.view.ViewFlow r5 = r2.f14839d
            int r1 = r2.f14838c
            android.view.View r5 = r5.a(r1)
            if (r5 == 0) goto L43
            int r1 = sg.bigo.ads.ad.interstitial.multi_img.view.d.e
            java.lang.Object r5 = r5.getTag(r1)
            boolean r1 = r5 instanceof sg.bigo.ads.ad.interstitial.multi_img.view.d
            if (r1 == 0) goto L43
            sg.bigo.ads.ad.interstitial.multi_img.view.d r5 = (sg.bigo.ads.ad.interstitial.multi_img.view.d) r5
            if (r0 == 0) goto L3c
            int r5 = r5.f14905n
            goto L3e
        L3c:
            int r5 = r5.f14906o
        L3e:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L44
        L43:
            r5 = 0
        L44:
            float r4 = java.lang.Math.abs(r4)
            if (r5 != 0) goto L4c
            r5 = r3
            goto L50
        L4c:
            int r5 = r5.intValue()
        L50:
            int r3 = sg.bigo.ads.common.w.b.a(r4, r3, r5)
            sg.bigo.ads.ad.interstitial.d r4 = r2.h
            int r3 = r4.a(r3)
            if (r0 == 0) goto L61
            android.view.ViewGroup r4 = r2.f14836a
            r4.setBackgroundColor(r3)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.multi_img.a.a(sg.bigo.ads.ad.interstitial.multi_img.view.d, float, int):void");
    }
}
