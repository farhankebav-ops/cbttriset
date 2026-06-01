package sg.bigo.ads.controller.landing;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONArray;
import sg.bigo.ads.a.a;
import sg.bigo.ads.api.AdActivity;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.controller.form.AdFormActivity;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final WeakHashMap<sg.bigo.ads.ad.c<?, ?>, Integer> f16730a = new WeakHashMap<>();

    public static int a(int i2) {
        if (i2 == 0) {
            return 2;
        }
        if (i2 != 1) {
            return i2 != 2 ? 5 : 4;
        }
        return 3;
    }

    @Nullable
    public static sg.bigo.ads.ad.c<?, ?> b(int i2) {
        sg.bigo.ads.ad.c<?, ?> key;
        WeakHashMap<sg.bigo.ads.ad.c<?, ?>, Integer> weakHashMap = f16730a;
        synchronized (weakHashMap) {
            try {
                Iterator<Map.Entry<sg.bigo.ads.ad.c<?, ?>, Integer>> it = weakHashMap.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        key = null;
                        break;
                    }
                    Map.Entry<sg.bigo.ads.ad.c<?, ?>, Integer> next = it.next();
                    if (next.getValue().intValue() == i2) {
                        key = next.getKey();
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return key;
    }

    public static e a(Context context, String str, String str2, String str3, boolean z2, int i2, @Nullable JSONArray jSONArray, @Nullable sg.bigo.ads.ad.c<?, ?> cVar, boolean z7) {
        ArrayList arrayList;
        if (str != null) {
            arrayList = new ArrayList();
            arrayList.add(str);
        } else {
            arrayList = null;
        }
        return a(context, arrayList, str2, str3, z2, i2, jSONArray, cVar, z7);
    }

    public static e a(Context context, @Nullable List<String> list, String str, String str2, boolean z2, int i2, @Nullable JSONArray jSONArray, @Nullable sg.bigo.ads.ad.c<?, ?> cVar, boolean z7) {
        sg.bigo.ads.ad.c<?, ?> cVar2;
        a aVar;
        e eVar = new e();
        boolean zA = false;
        int i8 = 0;
        eVar.f15486a = 0;
        if (cVar != null && (aVar = cVar.m) != null && !aVar.b()) {
            aVar.a();
        }
        if (list != null) {
            boolean zA2 = false;
            while (true) {
                if (i8 >= list.size()) {
                    break;
                }
                String str3 = list.get(i8);
                if (!TextUtils.isEmpty(str3) && (zA2 = sg.bigo.ads.core.landing.a.a(Uri.parse(str3), context, eVar, str2))) {
                    eVar.f15486a = 1;
                    break;
                }
                i8++;
            }
            zA = zA2;
        }
        if (!zA && z2 && !TextUtils.isEmpty(str2) && (zA = sg.bigo.ads.core.landing.a.a(context, str2))) {
            eVar.f15486a = 4;
        }
        if (zA || TextUtils.isEmpty(str)) {
            cVar2 = cVar;
        } else {
            Uri uri = Uri.parse(str);
            if (sg.bigo.ads.core.landing.a.a(str)) {
                eVar.f15486a = 2;
                zA = sg.bigo.ads.core.landing.a.a(uri, context, eVar);
            } else {
                eVar.f15486a = 3;
                if (i2 == 1) {
                    zA = sg.bigo.ads.core.landing.a.a(context, str, jSONArray);
                } else if (i2 == 2) {
                    zA = a(context, str, cVar, eVar, z7);
                } else {
                    cVar2 = cVar;
                    zA = a(context, str, cVar2, eVar, 0, z7);
                }
            }
            cVar2 = cVar;
        }
        eVar.h = zA;
        if (zA && cVar2 != null) {
            sg.bigo.ads.api.core.c cVarF = cVar2.f();
            if (cVar2.f14034t != cVarF.y()) {
                cVar2.f14032r = -1;
                cVar2.f14034t = cVarF.y();
            }
            cVar2.f14033s = System.currentTimeMillis();
            cVar2.f14032r++;
        }
        return eVar;
    }

    public static void a() {
    }

    private static void a(int i2, @NonNull sg.bigo.ads.ad.c<?, ?> cVar) {
        WeakHashMap<sg.bigo.ads.ad.c<?, ?>, Integer> weakHashMap = f16730a;
        synchronized (weakHashMap) {
            weakHashMap.put(cVar, Integer.valueOf(i2));
        }
    }

    public static void a(Context context, String str, @Nullable sg.bigo.ads.ad.c<?, ?> cVar) {
        JSONArray jSONArrayD;
        int iC;
        e eVar = new e();
        eVar.f15486a = 0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Uri uri = Uri.parse(str);
        if (sg.bigo.ads.core.landing.a.a(str)) {
            eVar.f15486a = 2;
            sg.bigo.ads.core.landing.a.a(uri, context, eVar);
            return;
        }
        eVar.f15486a = 3;
        if (cVar != null) {
            iC = cVar.f().N().c();
            jSONArrayD = cVar.f().N().d();
        } else {
            jSONArrayD = null;
            iC = 0;
        }
        if (iC == 1) {
            sg.bigo.ads.core.landing.a.a(context, str, jSONArrayD);
        } else if (iC == 2) {
            a(context, str, cVar, eVar, false);
        } else {
            a(context, str, cVar, eVar, 0, false);
        }
    }

    public static boolean a(Context context, @NonNull Class<? extends sg.bigo.ads.controller.e.b<?>> cls, @NonNull sg.bigo.ads.ad.c<?, ?> cVar) {
        if (Build.VERSION.SDK_INT == 26) {
            sg.bigo.ads.core.d.b.a(cVar.f(), 3000, 10116, "android 8.0 cannot show popup");
            return false;
        }
        try {
            Intent intentB = AdActivity.b(context, cls);
            int iHashCode = cVar.hashCode();
            a(iHashCode, cVar);
            intentB.putExtra("ad_identifier", iHashCode);
            context.startActivity(intentB);
            return true;
        } catch (Exception e) {
            sg.bigo.ads.core.d.b.a(cVar.f(), 3000, 10116, Log.getStackTraceString(e));
            return false;
        }
    }

    public static boolean a(Context context, @NonNull Class<? extends sg.bigo.ads.controller.e.b<?>> cls, @NonNull sg.bigo.ads.ad.c<?, ?> cVar, boolean z2) {
        try {
            Intent intentE = z2 ? AdActivity.e(context, cls) : AdActivity.d(context, cls);
            int iHashCode = cVar.hashCode();
            a(iHashCode, cVar);
            intentE.putExtra("ad_identifier", iHashCode);
            context.startActivity(intentE);
            return true;
        } catch (Exception e) {
            sg.bigo.ads.core.d.b.a(cVar.f(), 3000, 10116, Log.getStackTraceString(e));
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6, java.lang.String r7, @androidx.annotation.Nullable sg.bigo.ads.ad.c<?, ?> r8, @androidx.annotation.NonNull sg.bigo.ads.api.core.e r9, int r10, boolean r11) {
        /*
            r0 = 0
            r1 = 0
            if (r8 == 0) goto L1d
            java.lang.ref.WeakReference<sg.bigo.ads.ad.c$a> r2 = r8.f14035u     // Catch: java.lang.Exception -> L1b
            if (r2 == 0) goto L1d
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L1b
            if (r2 == 0) goto L1d
            java.lang.ref.WeakReference<sg.bigo.ads.ad.c$a> r2 = r8.f14035u     // Catch: java.lang.Exception -> L1b
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Exception -> L1b
            sg.bigo.ads.ad.c$a r2 = (sg.bigo.ads.ad.c.a) r2     // Catch: java.lang.Exception -> L1b
            sg.bigo.ads.controller.landing.LandingPageStyleConfig r2 = r2.a(r6, r7, r10, r11)     // Catch: java.lang.Exception -> L1b
            goto L1e
        L1b:
            r6 = move-exception
            goto L7c
        L1d:
            r2 = r1
        L1e:
            if (r2 == 0) goto L35
            boolean r3 = r2.a()     // Catch: java.lang.Exception -> L1b
            if (r3 == 0) goto L35
            boolean r3 = r2.b()     // Catch: java.lang.Exception -> L1b
            if (r3 != 0) goto L35
            int r11 = r2.f16676a     // Catch: java.lang.Exception -> L1b
            java.lang.Class<? extends sg.bigo.ads.controller.landing.c> r3 = r2.g     // Catch: java.lang.Exception -> L1b
            android.content.Intent r3 = sg.bigo.ads.api.AdActivity.f(r6, r3)     // Catch: java.lang.Exception -> L1b
            goto L4b
        L35:
            java.lang.Class<sg.bigo.ads.controller.landing.c> r3 = sg.bigo.ads.controller.landing.c.class
            if (r2 == 0) goto L3e
            java.lang.Class<? extends sg.bigo.ads.controller.landing.c> r4 = r2.g     // Catch: java.lang.Exception -> L1b
            if (r4 == 0) goto L3e
            r3 = r4
        L3e:
            if (r11 == 0) goto L46
            android.content.Intent r3 = sg.bigo.ads.api.AdActivity.c(r6, r3)     // Catch: java.lang.Exception -> L1b
        L44:
            r11 = r0
            goto L4b
        L46:
            android.content.Intent r3 = sg.bigo.ads.api.AdActivity.a(r6, r3)     // Catch: java.lang.Exception -> L1b
            goto L44
        L4b:
            java.lang.String r4 = "layout_style"
            r3.putExtra(r4, r2)     // Catch: java.lang.Exception -> L1b
            java.lang.String r4 = "webview_force_time"
            r5 = 1
            if (r2 == 0) goto L58
            int r2 = r2.f16677b     // Catch: java.lang.Exception -> L1b
            goto L59
        L58:
            r2 = r5
        L59:
            r3.putExtra(r4, r2)     // Catch: java.lang.Exception -> L1b
            java.lang.String r2 = "url"
            r3.putExtra(r2, r7)     // Catch: java.lang.Exception -> L1b
            if (r8 == 0) goto L74
            int r7 = r8.hashCode()     // Catch: java.lang.Exception -> L1b
            a(r7, r8)     // Catch: java.lang.Exception -> L1b
            java.lang.String r2 = "ad_identifier"
            r3.putExtra(r2, r7)     // Catch: java.lang.Exception -> L1b
            java.lang.String r7 = "land_way"
            r3.putExtra(r7, r10)     // Catch: java.lang.Exception -> L1b
        L74:
            r6.startActivity(r3)     // Catch: java.lang.Exception -> L1b
            if (r9 == 0) goto L7b
            r9.f15489d = r11     // Catch: java.lang.Exception -> L1b
        L7b:
            return r5
        L7c:
            if (r8 == 0) goto L82
            sg.bigo.ads.api.core.c r1 = r8.f()
        L82:
            r7 = 10116(0x2784, float:1.4176E-41)
            java.lang.String r6 = android.util.Log.getStackTraceString(r6)
            r8 = 3000(0xbb8, float:4.204E-42)
            sg.bigo.ads.core.d.b.a(r1, r8, r7, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.controller.landing.d.a(android.content.Context, java.lang.String, sg.bigo.ads.ad.c, sg.bigo.ads.api.core.e, int, boolean):boolean");
    }

    private static boolean a(Context context, final String str, @Nullable final sg.bigo.ads.ad.c<?, ?> cVar, @NonNull final e eVar, final boolean z2) {
        final b bVar = new b(str, cVar == null ? null : cVar.f(), cVar, cVar != null ? cVar.m : null);
        a.C0225a c0225a = new a.C0225a();
        c0225a.f13779a = str;
        c0225a.f13780b = bVar;
        c0225a.f13781c = new a.b() { // from class: sg.bigo.ads.controller.landing.d.1
            @Override // sg.bigo.ads.a.a.b
            public final void a(Context context2, String str2, int i2, String str3) {
                sg.bigo.ads.common.t.a.a(0, 3, "WebViewStatHelper", "Open landing page by chrome tabs failed, using webView.");
                d.a(context2, str, cVar, eVar, d.a(i2), z2);
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                sg.bigo.ads.ad.c cVar2 = cVar;
                sg.bigo.ads.core.d.b.a(cVar2 == null ? null : cVar2.f(), 3002, 10114, str3);
            }

            @Override // sg.bigo.ads.a.a.b
            public final void a(String str2, String str3, String str4) {
                b bVar2 = bVar;
                bVar2.f16700a = str2;
                bVar2.f16701b = str3;
                bVar2.f16702c = str4;
            }
        };
        c0225a.a().a(context);
        return true;
    }

    public static boolean a(Context context, sg.bigo.ads.ad.c<?, ?> cVar) {
        if (cVar == null) {
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) null, 3000, 10221, "ad == null, launchFormActivity failed");
            return false;
        }
        try {
            Intent intentA = AdFormActivity.a(context);
            int iHashCode = cVar.hashCode();
            int iB_ = cVar.b_();
            a(iHashCode, cVar);
            intentA.putExtra("ad_identifier", iHashCode);
            intentA.putExtra("open_form_time", iB_);
            context.startActivity(intentA);
            return true;
        } catch (Exception e) {
            sg.bigo.ads.core.d.b.a(cVar.f(), 3000, 10221, Log.getStackTraceString(e));
            return false;
        }
    }
}
