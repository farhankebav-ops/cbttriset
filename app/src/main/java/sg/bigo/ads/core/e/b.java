package sg.bigo.ads.core.e;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.common.u.a.e;
import sg.bigo.ads.common.u.c.c;
import sg.bigo.ads.common.u.g;
import sg.bigo.ads.common.u.h;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    public interface a {
        void a();

        boolean a(int i2);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2, String str, String str2, @NonNull sg.bigo.ads.common.u.a aVar, String str3, boolean z2, int i8, int i9, Map<String, String> map, int i10, String str4) {
        HashMap map2;
        if (map == null) {
            map = new HashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        map2 = new HashMap(map);
        map2.put("action", str);
        map2.put("track_url", aVar.a());
        map2.put("domain_front", aVar.e() ? aVar.d() : "");
        map2.put("track_name", str3);
        map2.put("states", str2);
        map2.put("src", z2 ? "1" : "0");
        map2.put("res_code", String.valueOf(i10));
        if (str4 == null) {
            str4 = "";
        }
        map2.put("res_msg", str4);
        map2.put("retry", String.valueOf(i8));
        map2.put("out_ad", String.valueOf(i9));
        map2.put("replace", String.valueOf(i2));
        str.getClass();
        switch (str) {
            case "va_cpn_cli":
            case "va_cli":
            case "click_track":
                sg.bigo.ads.core.d.b.b(map2);
                break;
            case "va_cpn_imp":
            case "impl_track":
            case "va_show":
                sg.bigo.ads.core.d.b.a(map2);
                break;
            default:
                sg.bigo.ads.common.t.a.a(0, 3, "TrackerRequestHelper", "reportTrack dont report action =".concat(str));
                break;
        }
    }

    private static void a(int i2, String str, @NonNull sg.bigo.ads.common.u.a aVar, String str2, boolean z2, int i8, int i9, Map<String, String> map) {
        b(i2, str, "start", aVar, str2, z2, i8, i9, map, 0, "");
    }

    public static void a(Context context, int i2, String str, @NonNull sg.bigo.ads.common.u.a aVar, String str2, int i8, Map<String, String> map, a aVar2) {
        a(context, i2, str, aVar, str2, i8, false, 0, map, aVar2);
    }

    public static void a(Context context, final int i2, final String str, @NonNull final sg.bigo.ads.common.u.a aVar, final String str2, final int i8, final boolean z2, final int i9, final Map<String, String> map, final a aVar2) {
        if (sg.bigo.ads.common.x.a.q()) {
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, "TrackerRequestHelper", "track url = " + aVar.a());
        if (i.f15457a.n().a(9) && URLUtil.isHttpUrl(aVar.a())) {
            b(i2, str, "failure", aVar, str2, z2, i9, i8, map, TypedValues.Custom.TYPE_FLOAT, "Invalid http url");
            return;
        }
        a(i2, str, aVar, str2, z2, i9, i8, map);
        sg.bigo.ads.common.u.b.a aVar3 = new sg.bigo.ads.common.u.b.a(aVar, context);
        aVar3.k = e.g();
        g.a(aVar3, new sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.a, sg.bigo.ads.common.u.c.a>() { // from class: sg.bigo.ads.core.e.b.1
            private final List<Integer> k = new ArrayList();
            private int l = -1;
            private boolean m = false;

            @Override // sg.bigo.ads.common.u.b
            public final /* bridge */ /* synthetic */ c a(@NonNull sg.bigo.ads.common.u.c.a aVar4) {
                return aVar4;
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(@NonNull sg.bigo.ads.common.u.b.c cVar, @Nullable String str3, int i10) {
                super.a((sg.bigo.ads.common.u.b.a) cVar, str3, i10);
                this.k.add(Integer.valueOf(i10));
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(@NonNull sg.bigo.ads.common.u.b.c cVar, @NonNull c cVar2) {
                sg.bigo.ads.common.u.c.a aVar4 = (sg.bigo.ads.common.u.c.a) cVar2;
                a aVar5 = aVar2;
                if (aVar5 != null) {
                    aVar5.b();
                }
                b.b(i2, str, "success", aVar, str2, z2, i9, i8, map, aVar4.f15973a, "success");
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(@NonNull sg.bigo.ads.common.u.b.c cVar, @NonNull h hVar) {
                int i10;
                String str3;
                sg.bigo.ads.common.u.a aVar4;
                String str4;
                boolean z7;
                int i11;
                int i12;
                Map map2;
                int i13;
                String message;
                String str5;
                sg.bigo.ads.common.u.b.a aVar5 = (sg.bigo.ads.common.u.b.a) cVar;
                if (this.m || a(aVar5)) {
                    a aVar6 = aVar2;
                    if (aVar6 != null) {
                        aVar6.b();
                    }
                    i10 = i2;
                    str3 = str;
                    aVar4 = aVar;
                    str4 = str2;
                    z7 = z2;
                    i11 = i9;
                    i12 = i8;
                    map2 = map;
                    i13 = this.l;
                    message = "Something wrong occurs when handling the request, but it is still successful";
                    str5 = "success";
                } else {
                    sg.bigo.ads.common.t.a.a(0, 3, "TrackerRequestHelper", "track onError e=" + hVar.getMessage());
                    a aVar7 = aVar2;
                    if (aVar7 != null) {
                        aVar7.a();
                    }
                    i10 = i2;
                    str3 = str;
                    aVar4 = aVar;
                    str4 = str2;
                    z7 = z2;
                    i11 = i9;
                    i12 = i8;
                    map2 = map;
                    i13 = hVar.f15988a;
                    message = hVar.getMessage();
                    str5 = "failure";
                }
                b.b(i10, str3, str5, aVar4, str4, z7, i11, i12, map2, i13, message);
            }

            private boolean a(@NonNull sg.bigo.ads.common.u.b.a aVar4) {
                Iterator<Integer> it = this.k.iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    a aVar5 = aVar2;
                    if ((aVar5 != null && aVar5.a(iIntValue)) || super.a(aVar4, iIntValue)) {
                        this.l = iIntValue;
                        this.m = true;
                        return true;
                    }
                }
                return false;
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ boolean a(@NonNull sg.bigo.ads.common.u.b.c cVar, int i10) {
                this.k.add(Integer.valueOf(i10));
                return a((sg.bigo.ads.common.u.b.a) cVar);
            }
        });
    }
}
