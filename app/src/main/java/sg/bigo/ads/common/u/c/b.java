package sg.bigo.ads.common.u.c;

import androidx.annotation.Nullable;
import androidx.webkit.ProxyConfig;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15978b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f15979c;

    private b() {
    }

    @Nullable
    public static b a(String str) {
        b bVar = null;
        if (q.a((CharSequence) str)) {
            return null;
        }
        int iIndexOf = str.indexOf(" ");
        int iIndexOf2 = str.indexOf("-");
        int iIndexOf3 = str.indexOf("/");
        if (iIndexOf >= 0 && iIndexOf3 >= 0 && iIndexOf < iIndexOf3) {
            bVar = new b();
            if (iIndexOf2 > iIndexOf && iIndexOf2 < iIndexOf3) {
                try {
                    bVar.f15977a = Long.parseLong(str.substring(iIndexOf + 1, iIndexOf2));
                    bVar.f15979c = Long.parseLong(str.substring(iIndexOf2 + 1, iIndexOf3));
                } catch (Exception unused) {
                }
            }
            String strSubstring = str.substring(iIndexOf3 + 1);
            if (!ProxyConfig.MATCH_ALL_SCHEMES.equals(strSubstring)) {
                bVar.f15978b = Long.parseLong(strSubstring);
            }
        }
        return bVar;
    }
}
