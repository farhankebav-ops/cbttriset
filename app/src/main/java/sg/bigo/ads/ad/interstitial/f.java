package sg.bigo.ads.ad.interstitial;

import java.util.ArrayList;
import java.util.List;
import sg.bigo.ads.R;

/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14699d;

    public enum a {
        STAR(0, R.string.bigo_ad_ic_blank, R.drawable.bigo_ad_ic_star, R.string.bigo_ad_comment_num_text, 0),
        DOWNLOAD_NUM(0, R.string.bigo_ad_ic_blank, 0, R.string.bigo_ad_download_num_text, 0),
        Everyone(0, 0, R.drawable.bigo_ad_ic_everyone, R.string.bigo_ad_ic_everyone, R.drawable.bigo_ad_ic_everyone_ic_info),
        WEB(1, 0, R.drawable.bigo_ad_ic_web, R.string.bigo_ad_ic_web, 0),
        RECOMMENDED(1, 0, R.drawable.bigo_ad_ic_recommend, R.string.bigo_ad_ic_recommended, 0),
        REVIEWS(3, 0, R.drawable.bigo_ad_ic_star2, R.string.bigo_ad_comment_num_text, 0),
        APPLICATION(2, 0, R.drawable.bigo_ad_ic_phone, R.string.bigo_ad_ic_application, 0),
        DOWNLOAD(2, 0, R.drawable.bigo_ad_ic_download_box, R.string.bigo_ad_download_num_text, 0),
        STAR_WHITE(0, R.string.bigo_ad_ic_blank, R.drawable.bigo_ad_ic_star_white, R.string.bigo_ad_comment_num_text, 0),
        DOWNLOAD_NUM_WHITE(0, R.string.bigo_ad_ic_blank, 0, R.string.bigo_ad_download_num_text, 0),
        Everyone_WHITE(0, 0, R.drawable.bigo_ad_ic_everyone_white, R.string.bigo_ad_ic_everyone, R.drawable.bigo_ad_ic_info_white),
        WEB_WHITE(4, 0, R.drawable.bigo_ad_ic_web_white, R.string.bigo_ad_ic_web, 0),
        RECOMMENDED_WHITE(4, 0, R.drawable.bigo_ad_ic_recommend_white, R.string.bigo_ad_ic_recommended, 0),
        REVIEWS_WHITE(12, 0, R.drawable.bigo_ad_ic_star2_white, R.string.bigo_ad_comment_num_text, 0),
        APPLICATION_WHITE(8, 0, R.drawable.bigo_ad_ic_phone_white, R.string.bigo_ad_ic_application, 0),
        DOWNLOAD_WHITE(8, 0, R.drawable.bigo_ad_ic_download_box_white, R.string.bigo_ad_download_num_text, 0);


        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f14709q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f14710r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f14711s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f14712t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final int f14713u;

        a(int i2, int i8, int i9, int i10, int i11) {
            this.f14709q = i2;
            this.f14710r = i8;
            this.f14711s = i9;
            this.f14712t = i10;
            this.f14713u = i11;
        }

        public static List<a> a(int i2) {
            a[] aVarArrValues = values();
            ArrayList arrayList = new ArrayList();
            for (a aVar : aVarArrValues) {
                int i8 = aVar.f14709q;
                if ((i8 & i2) > 0 || i8 == i2) {
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
    }

    public f(int i2, int i8, String str) {
        this.f14696a = i2;
        this.f14697b = i8;
        this.f14698c = str;
        this.f14699d = !sg.bigo.ads.common.utils.q.a((CharSequence) str);
    }
}
