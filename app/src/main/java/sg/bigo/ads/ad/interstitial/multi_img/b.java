package sg.bigo.ads.ad.interstitial.multi_img;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.common.p.g;
import sg.bigo.ads.common.p.h;
import sg.bigo.ads.common.utils.k;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f14843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f14844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f14846d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    List<a> f14847f;
    public int g;

    @NonNull
    final sg.bigo.ads.ad.b.c h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HashSet<String> f14848i = new HashSet<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14855b;

        private a(String str) {
            this.f14854a = str;
            this.f14855b = 0;
        }

        public /* synthetic */ a(String str, byte b8) {
            this(str);
        }
    }

    private b(@NonNull sg.bigo.ads.ad.b.c cVar, m mVar, d dVar, int i2, c cVar2, boolean z2, boolean z7, List<a> list) {
        this.h = cVar;
        this.f14843a = mVar;
        this.f14844b = dVar;
        this.f14846d = cVar2;
        this.f14845c = z2;
        this.e = z7;
        this.f14847f = list;
        this.g = i2;
    }

    @Nullable
    public static b b(sg.bigo.ads.ad.b.c cVar, @NonNull m mVar) {
        d dVarA;
        c cVarA;
        int iA;
        if (cVar == null || mVar == null) {
            return null;
        }
        int iA2 = mVar.a("video_play_page.multi_img_load");
        switch (mVar.a("video_play_page.ad_component_layout")) {
            case 13:
            case 18:
                dVarA = d.TILE;
                cVarA = c.FILL_MATCH_SELF;
                iA = 1;
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                dVarA = d.a(mVar.a("video_play_page.multi_img"));
                cVarA = c.a(mVar.a("video_play_page.multi_render_way"));
                iA = mVar.a("video_play_page.multi_method");
                break;
            default:
                return null;
        }
        return a(cVar, mVar, iA2, dVarA, cVarA, iA == 1, false);
    }

    public static b c(sg.bigo.ads.ad.b.c cVar, @NonNull m mVar) {
        return a(cVar, mVar, mVar.a("video_play_page.multi_img_load", 1), d.a(mVar.a("video_play_page.multi_img")), c.FILL_MATCH_SELF, true, false);
    }

    @NonNull
    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        if (!k.a((Collection) this.f14847f)) {
            Iterator<a> it = this.f14847f.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f14854a);
            }
        }
        return arrayList;
    }

    @Nullable
    public static b a(sg.bigo.ads.ad.b.c cVar, m mVar) {
        if (cVar == null || mVar == null) {
            return null;
        }
        switch (mVar.a("endpage.ad_component_layout")) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return a(cVar, mVar, mVar.a("endpage.multi_img_load"), d.a(mVar.a("endpage.multi_img")), c.a(mVar.a("endpage.multi_render_way")), true, true);
            default:
                return null;
        }
    }

    public final void b() {
        if (k.a((Collection) this.f14847f)) {
            return;
        }
        for (final a aVar : this.f14847f) {
            String str = aVar.f14854a;
            if (!sg.bigo.ads.common.p.e.a(this.h.f14024b.e, str)) {
                if (h.a.f15921a.a(str)) {
                    return;
                }
                sg.bigo.ads.ad.b.c cVar = this.h;
                sg.bigo.ads.common.p.e.a(cVar.f14024b.e, str, ((sg.bigo.ads.core.a.a) cVar.f()).al(), new g() { // from class: sg.bigo.ads.ad.interstitial.multi_img.b.2
                    @Override // sg.bigo.ads.common.p.g
                    public final void a(int i2, @NonNull String str2, String str3) {
                        aVar.f14855b = 2;
                    }

                    @Override // sg.bigo.ads.common.p.g
                    public final void a(@NonNull Bitmap bitmap, @NonNull sg.bigo.ads.common.p.f fVar) {
                        aVar.f14855b = 1;
                    }
                });
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c A[PHI: r3
  0x000c: PHI (r3v11 java.util.ArrayList) = (r3v3 java.util.ArrayList), (r3v3 java.util.ArrayList), (r3v0 java.util.ArrayList) binds: [B:40:0x00af, B:42:0x00b3, B:4:0x0009] A[DONT_GENERATE, DONT_INLINE]] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static sg.bigo.ads.ad.interstitial.multi_img.b a(@androidx.annotation.NonNull sg.bigo.ads.ad.b.c r15, @androidx.annotation.NonNull sg.bigo.ads.api.a.m r16, int r17, sg.bigo.ads.ad.interstitial.multi_img.d r18, sg.bigo.ads.ad.interstitial.multi_img.c r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.ad.interstitial.multi_img.b.a(sg.bigo.ads.ad.b.c, sg.bigo.ads.api.a.m, int, sg.bigo.ads.ad.interstitial.multi_img.d, sg.bigo.ads.ad.interstitial.multi_img.c, boolean, boolean):sg.bigo.ads.ad.interstitial.multi_img.b");
    }

    public final void a(final int i2, final int i8) {
        String str = i2 + "_" + i8;
        if (this.f14848i.contains(str)) {
            return;
        }
        this.f14848i.add(str);
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.ad.interstitial.multi_img.b.1
            /* JADX WARN: Type inference failed for: r5v0, types: [sg.bigo.ads.api.core.c] */
            @Override // java.lang.Runnable
            public final void run() {
                int i9;
                int i10;
                int i11;
                String[] strArrE;
                int length = 0;
                if (k.a((Collection) b.this.f14847f)) {
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                } else {
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    for (a aVar : b.this.f14847f) {
                        String str2 = aVar.f14854a;
                        if (!sg.bigo.ads.common.p.e.a(b.this.h.f14024b.e, str2)) {
                            if (!h.a.f15921a.a(str2)) {
                                int i15 = aVar.f14855b;
                                if (i15 != 1) {
                                    if (i15 == 2) {
                                        i14++;
                                    }
                                }
                            }
                            i12++;
                        }
                        i13++;
                    }
                    i9 = i12;
                    i10 = i13;
                    i11 = i14;
                }
                ?? F = b.this.h.f();
                int i16 = i2;
                int i17 = i8;
                c.d popPage = b.this.h.getPopPage();
                if (popPage != null && (strArrE = popPage.e()) != null) {
                    length = strArrE.length;
                }
                sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) F, i16, i17, length, i9, i10, i11);
            }
        });
    }

    public final void a(String str, int i2) {
        if (k.a((Collection) this.f14847f) || q.a((CharSequence) str)) {
            return;
        }
        for (a aVar : this.f14847f) {
            if (str.equalsIgnoreCase(aVar.f14854a)) {
                aVar.f14855b = i2;
                return;
            }
        }
    }
}
