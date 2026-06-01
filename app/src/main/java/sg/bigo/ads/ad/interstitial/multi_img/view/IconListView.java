package sg.bigo.ads.ad.interstitial.multi_img.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import sg.bigo.ads.R;
import sg.bigo.ads.ad.interstitial.f;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public class IconListView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<a> f14877b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f14878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f14879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f14880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinearLayout f14881d;
        public final TextView e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f14882f;
        public final LinearLayout g;
        public final TextView h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ImageView f14883i;
        public final f.a j;
        public final String k;

        public a(Context context, f.a aVar, String str, boolean z2) {
            this.f14878a = context;
            View viewA = sg.bigo.ads.common.utils.a.a(context, R.layout.bigo_ad_layout_ic_item, null, false);
            this.f14879b = viewA;
            this.f14880c = z2;
            LinearLayout linearLayout = (LinearLayout) viewA.findViewById(R.id.bigo_ad_ic_title_layout);
            this.f14881d = linearLayout;
            this.e = (TextView) viewA.findViewById(R.id.bigo_ad_ic_title_txt);
            this.f14882f = (ImageView) viewA.findViewById(R.id.bigo_ad_ic_title_iv);
            linearLayout.setTag(26);
            LinearLayout linearLayout2 = (LinearLayout) viewA.findViewById(R.id.bigo_ad_ic_desc_layout);
            this.g = linearLayout2;
            this.h = (TextView) viewA.findViewById(R.id.bigo_ad_ic_desc_txt);
            this.f14883i = (ImageView) viewA.findViewById(R.id.bigo_ad_ic_desc_iv);
            linearLayout2.setTag(26);
            this.j = aVar;
            this.k = str;
            a();
        }

        public void a() {
            if (this.j.f14710r == 0) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.e.setText(this.j.f14710r);
                if (this.f14880c) {
                    this.e.setTextColor(-1);
                }
            }
            if (this.j.f14711s == 0) {
                this.f14882f.setVisibility(8);
            } else {
                this.f14882f.setVisibility(0);
                this.f14882f.setImageResource(this.j.f14711s);
            }
            if (this.j.f14712t == 0) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
                this.h.setText(this.j.f14712t);
                if (this.f14880c) {
                    this.h.setTextColor(q.b("#9AFFFFFF", -1));
                }
            }
            if (this.j.f14713u == 0) {
                this.f14883i.setVisibility(8);
            } else {
                this.f14883i.setVisibility(0);
                this.f14883i.setImageResource(this.j.f14713u);
            }
        }
    }

    public static class b extends a {
        public b(Context context, f.a aVar, String str, boolean z2) {
            super(context, aVar, str, z2);
        }

        @Override // sg.bigo.ads.ad.interstitial.multi_img.view.IconListView.a
        public final void a() {
            this.e.setVisibility(0);
            this.e.setText(sg.bigo.ads.common.utils.a.a(this.f14878a, this.j.f14710r, sg.bigo.ads.ad.b.f.a(this.k)));
            if (this.f14880c) {
                this.e.setTextColor(-1);
            }
            this.f14882f.setVisibility(8);
            this.h.setVisibility(0);
            this.h.setText(this.j.f14712t);
            if (this.f14880c) {
                this.h.setTextColor(q.b("#9AFFFFFF", -1));
            }
            this.f14883i.setVisibility(8);
        }
    }

    public static class c extends a {
        public c(Context context, f.a aVar, String str, boolean z2) {
            super(context, aVar, str, z2);
        }

        @Override // sg.bigo.ads.ad.interstitial.multi_img.view.IconListView.a
        public final void a() {
            this.e.setVisibility(8);
            this.f14882f.setVisibility(0);
            this.f14882f.setImageResource(this.j.f14711s);
            this.h.setVisibility(0);
            this.h.setText(this.j.f14712t);
            if (this.f14880c) {
                this.h.setTextColor(q.b("#9AFFFFFF", -1));
            }
            this.f14883i.setVisibility(0);
            this.f14883i.setImageResource(this.j.f14713u);
        }
    }

    public static class d extends a {
        public d(Context context, f.a aVar, String str, boolean z2) {
            super(context, aVar, str, z2);
        }

        @Override // sg.bigo.ads.ad.interstitial.multi_img.view.IconListView.a
        public final void a() {
            this.e.setVisibility(0);
            this.e.setText(sg.bigo.ads.common.utils.a.a(this.f14878a, this.j.f14710r, sg.bigo.ads.ad.b.f.c(this.k)));
            if (this.f14880c) {
                this.e.setTextColor(-1);
            }
            this.f14882f.setVisibility(0);
            this.f14882f.setImageResource(this.j.f14711s);
            this.h.setVisibility(0);
            this.h.setText(sg.bigo.ads.ad.b.f.b(this.k) + " " + sg.bigo.ads.common.utils.a.a(this.f14878a, this.j.f14712t, new Object[0]));
            if (this.f14880c) {
                this.h.setTextColor(q.b("#9AFFFFFF", -1));
            }
            this.f14883i.setVisibility(8);
        }
    }

    public IconListView(Context context) {
        this(context, null);
    }

    private List<a> a(Context context, int i2, String str) {
        d dVar;
        c cVar;
        ArrayList arrayList = new ArrayList();
        if (i2 == 1 || i2 == 2 || i2 == 4 || i2 == 8) {
            List<f.a> listA = f.a.a(i2);
            Random random = new Random();
            while (!listA.isEmpty()) {
                arrayList.add(new a(context, listA.remove(random.nextInt(listA.size())), str, this.f14876a));
            }
            return arrayList;
        }
        boolean z2 = this.f14876a;
        if (z2) {
            dVar = new d(context, f.a.STAR_WHITE, str, z2);
            arrayList.add(dVar);
            arrayList.add(new b(context, f.a.DOWNLOAD_NUM_WHITE, str, this.f14876a));
            cVar = new c(context, f.a.Everyone_WHITE, str, this.f14876a);
        } else {
            dVar = new d(context, f.a.STAR, str, z2);
            arrayList.add(dVar);
            arrayList.add(new b(context, f.a.DOWNLOAD_NUM, str, this.f14876a));
            cVar = new c(context, f.a.Everyone, str, this.f14876a);
        }
        arrayList.add(cVar);
        return arrayList;
    }

    public List<a> getItems() {
        return this.f14877b;
    }

    public void setThemeWhite(boolean z2) {
        this.f14876a = z2;
    }

    public IconListView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(sg.bigo.ads.ad.interstitial.f r9) {
        /*
            r8 = this;
            r8.removeAllViews()
            if (r9 != 0) goto L7
            goto L9c
        L7:
            android.content.Context r0 = r8.getContext()
            int r1 = r9.f14696a
            r2 = 0
            r3 = 1
            if (r1 == r3) goto L59
            r4 = 4
            r5 = 2
            if (r1 == r5) goto L49
            r6 = 3
            r7 = 8
            if (r1 == r6) goto L30
            if (r1 == r4) goto L1e
            goto L9c
        L1e:
            boolean r1 = r9.f14699d
            if (r1 == 0) goto L9c
            boolean r1 = r8.f14876a
            if (r1 == 0) goto L27
            r5 = r7
        L27:
            java.lang.String r9 = r9.f14698c
            java.util.List r9 = r8.a(r0, r5, r9)
        L2d:
            r8.f14877b = r9
            goto L5e
        L30:
            boolean r1 = r9.f14699d
            if (r1 == 0) goto L3c
            boolean r1 = r8.f14876a
            if (r1 == 0) goto L3a
            r4 = r7
            goto L42
        L3a:
            r4 = r5
            goto L42
        L3c:
            boolean r1 = r8.f14876a
            if (r1 == 0) goto L41
            goto L42
        L41:
            r4 = r3
        L42:
            java.lang.String r9 = r9.f14698c
            java.util.List r9 = r8.a(r0, r4, r9)
            goto L2d
        L49:
            boolean r1 = r9.f14699d
            if (r1 == 0) goto L54
        L4d:
            java.lang.String r9 = r9.f14698c
            java.util.List r9 = r8.a(r0, r2, r9)
            goto L2d
        L54:
            boolean r1 = r8.f14876a
            if (r1 == 0) goto L41
            goto L42
        L59:
            boolean r1 = r9.f14699d
            if (r1 == 0) goto L9c
            goto L4d
        L5e:
            java.util.List<sg.bigo.ads.ad.interstitial.multi_img.view.IconListView$a> r9 = r8.f14877b
            boolean r9 = sg.bigo.ads.common.utils.k.a(r9)
            if (r9 == 0) goto L67
            goto L9c
        L67:
            r9 = r2
        L68:
            java.util.List<sg.bigo.ads.ad.interstitial.multi_img.view.IconListView$a> r0 = r8.f14877b
            int r0 = r0.size()
            if (r9 >= r0) goto L9c
            if (r9 <= 0) goto L82
            android.content.Context r0 = r8.getContext()
            boolean r1 = r8.f14876a
            if (r1 == 0) goto L7d
            int r1 = sg.bigo.ads.R.layout.bigo_ad_layout_space
            goto L7f
        L7d:
            int r1 = sg.bigo.ads.R.layout.bigo_ad_layout_space_black
        L7f:
            sg.bigo.ads.common.utils.a.a(r0, r1, r8, r3)
        L82:
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r1 = -2
            r0.<init>(r2, r1)
            r1 = 1065353216(0x3f800000, float:1.0)
            r0.weight = r1
            java.util.List<sg.bigo.ads.ad.interstitial.multi_img.view.IconListView$a> r1 = r8.f14877b
            java.lang.Object r1 = r1.get(r9)
            sg.bigo.ads.ad.interstitial.multi_img.view.IconListView$a r1 = (sg.bigo.ads.ad.interstitial.multi_img.view.IconListView.a) r1
            android.view.View r1 = r1.f14879b
            r8.addView(r1, r0)
            int r9 = r9 + 1
            goto L68
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.multi_img.view.IconListView.a(sg.bigo.ads.ad.interstitial.f):void");
    }

    public IconListView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14876a = false;
        setOrientation(0);
        setGravity(17);
    }
}
