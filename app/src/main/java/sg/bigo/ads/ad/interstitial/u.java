package sg.bigo.ads.ad.interstitial;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.api.AdOptionsView;
import sg.bigo.ads.api.MediaView;
import sg.bigo.ads.api.core.c;

/* JADX INFO: loaded from: classes6.dex */
public class u extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final sg.bigo.ads.ad.b.c f15138c;
    ImageView e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ImageView f15140f;
    public Bitmap g;
    protected Bitmap h;
    private int k = 0;
    private final List<w> l = new ArrayList();
    private boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f15142n = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15141i = 0;
    final AtomicBoolean j = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final d f15139d = new d();

    public interface a {
        Pair<String, String> a(@NonNull TextView textView, @Nullable String str, @Nullable String str2);
    }

    public u(@NonNull sg.bigo.ads.ad.b.c cVar) {
        this.f15138c = cVar;
    }

    public final synchronized void a(@Nullable Bitmap bitmap) {
        try {
            this.g = bitmap;
            Iterator<w> it = this.l.iterator();
            while (it.hasNext()) {
                it.next().a();
                it.remove();
            }
            this.k = 2;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void b(@NonNull final ViewGroup viewGroup) {
        sg.bigo.ads.common.utils.d.a(viewGroup.getContext(), this.g, new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.u.4
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                Bitmap bitmap2 = bitmap;
                View viewFindViewWithTag = viewGroup.findViewWithTag("adview_background_main_tag");
                if (viewFindViewWithTag instanceof ImageView) {
                    u.this.f15140f = (ImageView) viewFindViewWithTag;
                } else {
                    Context context = viewGroup.getContext();
                    if (context != null) {
                        u.this.f15140f = new ImageView(context);
                        u.this.f15140f.setTag("adview_background_main_tag");
                        u.this.f15140f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        sg.bigo.ads.common.utils.u.a(u.this.f15140f, viewGroup, null, 0);
                    }
                }
                ImageView imageView = u.this.f15140f;
                if (imageView == null || bitmap2 == null) {
                    return;
                }
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                u.this.f15140f.setImageBitmap(bitmap2);
            }
        });
    }

    public final void d() {
        if (this.g == null) {
            ImageView imageView = this.e;
            if (imageView != null && this.m) {
                a(imageView);
            }
            if (this.f15140f == null || !this.f15142n) {
                return;
            }
            a(new w() { // from class: sg.bigo.ads.ad.interstitial.u.9
                @Override // sg.bigo.ads.ad.interstitial.w
                public final void a() {
                    final Bitmap bitmapB = sg.bigo.ads.common.utils.d.b(u.this.f15140f.getContext(), u.this.g);
                    u.this.f15140f.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.u.9.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            u.this.f15140f.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            sg.bigo.ads.common.utils.d.a(u.this.f15140f, bitmapB);
                        }
                    });
                }
            });
        }
    }

    @NonNull
    public d e() {
        return this.f15139d;
    }

    @Nullable
    public final synchronized Bitmap g() {
        Bitmap bitmap = this.h;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return this.h;
    }

    @NonNull
    public final synchronized sg.bigo.ads.common.p h() {
        Bitmap bitmap = this.h;
        if (bitmap != null) {
            return new sg.bigo.ads.common.p(bitmap.getWidth(), this.h.getHeight());
        }
        return new sg.bigo.ads.common.p(-1, -1);
    }

    public final synchronized void i() {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.f15138c.f();
        if (aVar.aR()) {
            Bitmap bitmap = this.h;
            if (bitmap == null || bitmap.isRecycled()) {
                if (this.j.compareAndSet(false, true)) {
                    String strAT = aVar.aT();
                    if (sg.bigo.ads.common.utils.q.a((CharSequence) strAT)) {
                        return;
                    }
                    sg.bigo.ads.common.p.e.a(this.f15138c.f14024b.e, strAT, aVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.u.6
                        @Override // sg.bigo.ads.common.p.g
                        public final void a(int i2, @NonNull String str, String str2) {
                            u.this.j.set(false);
                        }

                        @Override // sg.bigo.ads.common.p.g
                        public final void a(@NonNull Bitmap bitmap2, @NonNull sg.bigo.ads.common.p.f fVar) {
                            u uVar = u.this;
                            uVar.h = bitmap2;
                            uVar.f15141i = sg.bigo.ads.common.w.b.a(bitmap2, 0);
                            u.this.j.set(false);
                        }
                    });
                }
            }
        }
    }

    public static void a(@Nullable View view) {
        AdOptionsView adOptionsView;
        if (view == null || (adOptionsView = (AdOptionsView) view.findViewById(R.id.inter_options)) == null) {
            return;
        }
        adOptionsView.setVisibility(adOptionsView.findViewWithTag("ad_options_real_view") == null ? 8 : 0);
    }

    private synchronized void b(final ValueCallback<Bitmap> valueCallback) {
        sg.bigo.ads.core.a.a aVar = (sg.bigo.ads.core.a.a) this.f15138c.f();
        if (!aVar.aR()) {
            String strAT = aVar.aT();
            if (sg.bigo.ads.common.utils.q.a((CharSequence) strAT)) {
                valueCallback.onReceiveValue(null);
                return;
            } else {
                sg.bigo.ads.common.p.e.a(this.f15138c.f14024b.e, strAT, aVar.al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.u.14
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i2, @NonNull String str, String str2) {
                        valueCallback.onReceiveValue(null);
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                        valueCallback.onReceiveValue(bitmap);
                    }
                });
                return;
            }
        }
        String strB = sg.bigo.ads.common.o.b(this.f15138c.f14024b.e, aVar.aN());
        if (sg.bigo.ads.common.utils.q.a((CharSequence) strB)) {
            valueCallback.onReceiveValue(null);
        } else {
            final String path = Uri.parse(strB).getPath();
            sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.u.13
                @Override // java.lang.Runnable
                public final void run() {
                    valueCallback.onReceiveValue(sg.bigo.ads.common.utils.d.a(Uri.parse(path).getPath(), u.this.f15138c.f14024b.e));
                }
            });
        }
    }

    public void a(@NonNull final ViewGroup viewGroup) {
        this.f15142n = true;
        a(new w() { // from class: sg.bigo.ads.ad.interstitial.u.3
            @Override // sg.bigo.ads.ad.interstitial.w
            public final void a() {
                Integer numA = sg.bigo.ads.common.w.b.a(u.this.g);
                if (numA != null) {
                    u.this.f15139d.a(numA.intValue());
                }
                u.this.b(viewGroup);
            }
        });
    }

    public final void a(@NonNull final ViewGroup viewGroup, final int i2) {
        sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.u.5
            @Override // java.lang.Runnable
            @RequiresApi(api = 17)
            public final void run() {
                View viewFindViewWithTag = viewGroup.findViewWithTag("adview_background_main_tag");
                if (viewFindViewWithTag instanceof ImageView) {
                    u.this.f15140f = (ImageView) viewFindViewWithTag;
                } else {
                    Context context = viewGroup.getContext();
                    if (context != null) {
                        u.this.f15140f = new ImageView(context);
                        u.this.f15140f.setTag("adview_background_main_tag");
                        u.this.f15140f.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                        sg.bigo.ads.common.utils.u.a(u.this.f15140f, viewGroup, null, 0);
                    }
                }
                ImageView imageView = u.this.f15140f;
                if (imageView != null) {
                    imageView.setBackgroundColor(i2);
                }
            }
        });
    }

    public void a(@NonNull ViewGroup viewGroup, @NonNull View view, int i2, int i8, int i9, @Nullable View... viewArr) {
        a(viewGroup, view, null, i2, i8, i9, viewArr);
    }

    /* JADX WARN: Type inference failed for: r1v26, types: [sg.bigo.ads.api.core.c] */
    public void a(@NonNull ViewGroup viewGroup, @NonNull View view, a aVar, int i2, int i8, int i9, @Nullable View... viewArr) {
        ArrayList arrayList = new ArrayList();
        c.d popPage = this.f15138c.getPopPage();
        TextView textView = (TextView) view.findViewById(R.id.inter_title);
        if (textView != null) {
            textView.setTag(2);
            a(aVar, textView, this.f15138c.getTitle(), popPage == null ? "" : popPage.b());
            arrayList.add(textView);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.inter_description);
        if (textView2 != null) {
            textView2.setTag(6);
            a(aVar, textView2, this.f15138c.getDescription(), popPage == null ? "" : popPage.c());
            arrayList.add(textView2);
        }
        TextView textView3 = (TextView) view.findViewById(R.id.inter_warning);
        if (textView3 != null) {
            textView3.setTag(8);
            String warning = this.f15138c.getWarning();
            if (TextUtils.isEmpty(warning)) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(warning);
            }
            arrayList.add(textView3);
        }
        TextView textView4 = (TextView) view.findViewById(R.id.inter_btn_cta);
        if (textView4 != null) {
            textView4.setTag(7);
            a(aVar, textView4, this.f15138c.getCallToAction(), "");
            arrayList.add(textView4);
        }
        TextView textView5 = (TextView) view.findViewById(R.id.inter_btn_cta_main);
        if (textView5 != null) {
            textView5.setTag(7);
            a(aVar, textView5, sg.bigo.ads.common.utils.a.a(textView5.getContext(), R.string.bigo_ad_cta_default, new Object[0]), "");
            arrayList.add(textView5);
        }
        final ImageView imageView = (ImageView) view.findViewById(R.id.inter_end_page_image);
        if (imageView != null) {
            imageView.setTag(5);
            final ValueCallback<Bitmap> valueCallback = new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.u.1
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                    final Bitmap bitmap2 = bitmap;
                    imageView.post(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.u.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            imageView.setImageBitmap(bitmap2);
                        }
                    });
                }
            };
            Bitmap bitmap = this.h;
            if (bitmap != null) {
                valueCallback.onReceiveValue(bitmap);
            } else {
                a(new w() { // from class: sg.bigo.ads.ad.interstitial.u.7
                    @Override // sg.bigo.ads.ad.interstitial.w
                    public final void a() {
                        valueCallback.onReceiveValue(u.this.g);
                    }
                });
            }
        }
        TextView textView6 = (TextView) view.findViewById(R.id.inter_company);
        if (textView6 != null) {
            textView6.setTag(26);
            if (popPage == null || sg.bigo.ads.common.utils.q.a((CharSequence) popPage.f())) {
                textView6.setVisibility(8);
            } else {
                a(aVar, textView6, popPage.f(), "");
            }
            arrayList.add(textView6);
        }
        TextView textView7 = (TextView) view.findViewById(R.id.inter_star_num);
        View viewFindViewById = view.findViewById(R.id.inter_star_layout);
        if (textView7 != null && viewFindViewById != null) {
            viewFindViewById.setTag(26);
            textView7.setText(sg.bigo.ads.ad.b.f.c(((sg.bigo.ads.core.a.a) this.f15138c.f()).n()));
            arrayList.add(viewFindViewById);
        }
        TextView textView8 = (TextView) view.findViewById(R.id.inter_commit_num);
        if (textView8 != null) {
            textView8.setTag(26);
            StringBuilder sbX = a1.a.x(sg.bigo.ads.ad.b.f.b(((sg.bigo.ads.core.a.a) this.f15138c.f()).n()), " ");
            sbX.append(sg.bigo.ads.common.utils.a.a(viewGroup.getContext(), R.string.bigo_ad_comment_num_text, new Object[0]));
            textView8.setText(sbX.toString());
            arrayList.add(textView8);
        }
        TextView textView9 = (TextView) view.findViewById(R.id.inter_download_num);
        View viewFindViewById2 = view.findViewById(R.id.inter_download_num_layout);
        if (textView9 != null && viewFindViewById2 != null) {
            viewFindViewById2.setTag(26);
            textView9.setText(sg.bigo.ads.ad.b.f.a(((sg.bigo.ads.core.a.a) this.f15138c.f()).n()));
            arrayList.add(viewFindViewById2);
        }
        View viewFindViewById3 = view.findViewById(R.id.inter_everyone_layout);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setTag(26);
            arrayList.add(viewFindViewById3);
        }
        this.e = (ImageView) view.findViewById(R.id.inter_icon);
        AdOptionsView adOptionsView = (AdOptionsView) view.findViewById(R.id.inter_options);
        MediaView mediaView = (MediaView) view.findViewById(R.id.inter_media);
        sg.bigo.ads.ad.b.c cVar = this.f15138c;
        cVar.I = i9;
        cVar.a(viewGroup, mediaView, this.e, adOptionsView, (List<View>) arrayList, i8, viewArr);
        if (this.e == null || this.f15138c.hasIcon()) {
            return;
        }
        String strA = popPage == null ? "" : popPage.a();
        if (sg.bigo.ads.common.utils.q.a((CharSequence) strA) || !URLUtil.isNetworkUrl(strA)) {
            if (i2 == 2) {
                this.e.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.e.getContext(), R.drawable.bigo_ad_icon_default));
                return;
            } else if (i2 == 1) {
                a(this.e);
                return;
            } else {
                if (i2 == 3) {
                    this.e.setImageDrawable(sg.bigo.ads.common.utils.a.a(this.e.getContext(), R.drawable.bigo_ad_icon_novideo_default));
                    return;
                }
                return;
            }
        }
        if (!sg.bigo.ads.api.a.i.f15457a.n().a(9) || !URLUtil.isHttpUrl(strA)) {
            sg.bigo.ads.ad.b.c cVar2 = this.f15138c;
            sg.bigo.ads.common.p.e.b(cVar2.f14024b.e, null, strA, ((sg.bigo.ads.core.a.a) cVar2.f()).al(), new sg.bigo.ads.common.p.g() { // from class: sg.bigo.ads.ad.interstitial.u.8
                @Override // sg.bigo.ads.common.p.g
                public final void a(int i10, @NonNull String str, String str2) {
                }

                @Override // sg.bigo.ads.common.p.g
                public final void a(@NonNull Bitmap bitmap2, @NonNull sg.bigo.ads.common.p.f fVar) {
                    ImageView imageView2 = u.this.e;
                    if (imageView2 != null) {
                        imageView2.setImageBitmap(bitmap2);
                    }
                }
            });
            return;
        }
        sg.bigo.ads.ad.b.c cVar3 = this.f15138c;
        if (cVar3 == null || cVar3.f() == 0) {
            return;
        }
        sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) this.f15138c.f(), 3000, 10220, "Invalid http url: ".concat(String.valueOf(strA)));
    }

    public final synchronized void a(final ValueCallback<Bitmap> valueCallback) {
        if (valueCallback == null) {
            return;
        }
        a(new w() { // from class: sg.bigo.ads.ad.interstitial.u.12
            @Override // sg.bigo.ads.ad.interstitial.w
            public final void a() {
                valueCallback.onReceiveValue(u.this.g);
            }
        });
    }

    public final void a(@NonNull final ImageView imageView) {
        this.m = true;
        a(new w() { // from class: sg.bigo.ads.ad.interstitial.u.2
            @Override // sg.bigo.ads.ad.interstitial.w
            public final void a() {
                sg.bigo.ads.common.n.d.b(new Runnable() { // from class: sg.bigo.ads.ad.interstitial.u.2.1
                    @Override // java.lang.Runnable
                    @RequiresApi(api = 17)
                    public final void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        imageView.setImageBitmap(u.this.g);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                });
            }
        });
    }

    private static void a(a aVar, @NonNull TextView textView, @Nullable String str, @Nullable String str2) {
        Pair<String, String> pairA;
        if (aVar != null && (pairA = aVar.a(textView, str, str2)) != null) {
            str = (String) pairA.first;
            str2 = (String) pairA.second;
        }
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            textView.setText(str2);
        }
    }

    private synchronized void a(@NonNull w wVar) {
        if (this.g != null) {
            wVar.a();
            return;
        }
        this.l.add(wVar);
        if (this.k == 1) {
            return;
        }
        this.k = 1;
        b(new ValueCallback<Bitmap>() { // from class: sg.bigo.ads.ad.interstitial.u.11
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Bitmap bitmap) {
                u.this.a(bitmap);
            }
        });
    }

    public void f() {
    }
}
