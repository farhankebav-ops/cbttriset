package sg.bigo.ads.ad;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ironsource.adqualitysdk.sdk.i.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.a.l;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, List<Ad>> f13839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Map<String, List<Ad>>> f13840b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static b f13844a = new b(0);
    }

    /* JADX INFO: renamed from: sg.bigo.ads.ad.b$b, reason: collision with other inner class name */
    public interface InterfaceC0229b {
        boolean a(Ad ad);
    }

    private b() {
        this.f13839a = new ConcurrentHashMap();
        ArrayList arrayList = new ArrayList();
        this.f13840b = arrayList;
        arrayList.add(this.f13839a);
    }

    private int a(String str, @NonNull Map<String, List<Ad>> map) {
        return a(str, map, new InterfaceC0229b() { // from class: sg.bigo.ads.ad.b.1
            @Override // sg.bigo.ads.ad.b.InterfaceC0229b
            public final boolean a(Ad ad) {
                return ad != null && ad.isExpired();
            }
        });
    }

    private static String b(Ad ad) {
        return ad == null ? "null" : ad.toString();
    }

    public /* synthetic */ b(byte b8) {
        this();
    }

    private int a(String str, @NonNull Map<String, List<Ad>> map, @NonNull InterfaceC0229b interfaceC0229b) {
        List<Ad> list = map.get(str);
        int i2 = 0;
        if (list != null && !list.isEmpty()) {
            for (Ad ad : list) {
                if (interfaceC0229b.a(ad)) {
                    a(ad);
                    list.remove(ad);
                    i2++;
                }
            }
        }
        return i2;
    }

    private static String b(l lVar) {
        if (lVar == null) {
            return null;
        }
        String strL = lVar.l();
        if (TextUtils.isEmpty(strL)) {
            return null;
        }
        return strL + "_" + lVar.v() + "_" + lVar.b();
    }

    public final Ad a(l lVar) {
        String strB = b(lVar);
        a0.i(0, strB, "AdCacheManager:key = ", 3, "AdCacheManager");
        Ad ad = null;
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:getAd expiredNum is ".concat(String.valueOf(a(strB, this.f13839a))));
        List<Ad> list = this.f13839a.get(strB);
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            while (i2 < list.size()) {
                try {
                    Ad ad2 = list.get(i2);
                    i2++;
                    ad = ad2;
                } catch (Exception e) {
                    sg.bigo.ads.common.t.a.a(0, "AdCacheManager", "AdCacheManager:getAd end error= " + e.getMessage());
                }
            }
            if (ad != null) {
                list.remove(ad);
            }
            StringBuilder sb = new StringBuilder("AdCacheManager:getAd end cacheNum= ");
            sb.append(list.size());
            sb.append("ad = ");
            a0.g(0, 3, b(ad), "AdCacheManager", sb);
        }
        return ad;
    }

    private void a(final Ad ad) {
        if (ad == null) {
            return;
        }
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.ad.b.2
            @Override // java.lang.Runnable
            public final void run() {
                ad.destroy();
            }
        });
    }

    public final void a(l lVar, Ad ad) {
        h hVar;
        List list;
        if (lVar == null) {
            return;
        }
        String strL = lVar.l();
        String strB = b(lVar);
        if (TextUtils.isEmpty(strB) || (hVar = i.f15457a) == null) {
            return;
        }
        int iH = hVar.q().h(strL);
        Map<String, List<Ad>> map = this.f13839a;
        int iA = a(strB, map);
        List<Ad> list2 = map.get(strB);
        if (list2 == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(ad);
            map.put(strB, copyOnWriteArrayList);
            list = copyOnWriteArrayList;
        } else {
            int iIndexOf = list2.indexOf(ad);
            if (iIndexOf >= 0) {
                list2.set(iIndexOf, ad);
                list = list2;
            } else {
                list2.add(ad);
                list = list2;
            }
        }
        sg.bigo.ads.api.core.c[] cVarArrA = sg.bigo.ads.controller.loader.a.a(ad);
        for (int i2 = 0; cVarArrA != null && i2 < cVarArrA.length; i2++) {
            sg.bigo.ads.api.core.c cVar = cVarArrA[i2];
            cVar.T();
            cVar.S();
        }
        Object[] array = list.toArray();
        if (array != null) {
            List listAsList = Arrays.asList(array);
            Collections.sort(listAsList, Collections.reverseOrder());
            list.clear();
            list.addAll(listAsList);
        }
        int size = list.size();
        if (iH > 0 && size > iH) {
            try {
                Ad ad2 = (Ad) list.remove(iH);
                sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:removeAd due to limit:" + b(ad2));
                a(ad2);
            } catch (Exception e) {
                sg.bigo.ads.common.t.a.a(0, "AdCacheManager", "AdCacheManager:doAdPut, error = " + e.getMessage());
            }
        }
        sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:putAdInCache:" + b(ad));
        sg.bigo.ads.common.t.a.a(0, 3, "AdCacheManager", "AdCacheManager:doAdPut, size = " + list.size() + ", expired num = " + iA);
    }
}
