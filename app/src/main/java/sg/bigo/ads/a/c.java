package sg.bigo.ads.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsIntent;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import sg.bigo.ads.a.a;
import sg.bigo.ads.a.a.a;
import sg.bigo.ads.a.a.b;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f13810a = true;

    private static void a() {
        sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs libs does not exist.");
        f13810a = false;
    }

    public static void a(final Context context) {
        a(context, "", null, "warmup", new Runnable() { // from class: sg.bigo.ads.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                b bVarA = b.a();
                Context context2 = context;
                if (context2 != null) {
                    sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Chrome tabs warming up.");
                    bVarA.a(context2.getApplicationContext());
                }
            }
        });
    }

    public static void a(final Context context, final String str, final int i2, final int i8, final boolean z2, final Bitmap bitmap, final a.c cVar, final a.b bVar) {
        a(context, str, bVar, MRAIDPresenter.OPEN, new Runnable() { // from class: sg.bigo.ads.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                Uri uri;
                final b bVarA = b.a();
                Context context2 = context;
                final String str2 = str;
                int i9 = i2;
                int i10 = i8;
                boolean z7 = z2;
                Bitmap bitmap2 = bitmap;
                final a.c cVar2 = cVar;
                final a.b bVar2 = bVar;
                if (!TextUtils.isEmpty(str2)) {
                    bVarA.f13798b.remove(str2);
                }
                StringBuilder sbY = a1.a.y("Start load url: ", str2, " with chrome tab current thread: ");
                sbY.append(Thread.currentThread().getName());
                sbY.append(".");
                sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", sbY.toString());
                try {
                    uri = Uri.parse(str2);
                } catch (Exception unused) {
                    uri = null;
                }
                if (uri == null) {
                    sg.bigo.ads.common.t.a.a(0, "ChromeTabsStatic", "Stop open chrome tab with error url.");
                    if (bVar2 != null) {
                        bVar2.a(context2, str2, 3, "Invalid url");
                        return;
                    }
                    return;
                }
                bVarA.a(context2);
                bVarA.f13797a.f13787d = new CustomTabsCallback() { // from class: sg.bigo.ads.a.b.1
                    @Override // androidx.browser.customtabs.CustomTabsCallback
                    public final void onNavigationEvent(int i11, Bundle bundle) {
                        super.onNavigationEvent(i11, bundle);
                        if (cVar2 == null) {
                            return;
                        }
                        a0.g(0, 3, b.a(i11), "ChromeTabsStatic", new StringBuilder("Receive custom tab event: "));
                        if (i11 == 5) {
                            cVar2.a();
                            return;
                        }
                        if (i11 == 1) {
                            cVar2.b();
                            return;
                        }
                        if (i11 == 3) {
                            cVar2.d();
                            return;
                        }
                        if (i11 == 4) {
                            cVar2.c();
                            return;
                        }
                        if (i11 == 2) {
                            cVar2.e();
                        } else if (i11 == 6) {
                            cVar2.f();
                            b.this.f13797a.f13787d = null;
                        }
                    }
                };
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(bVarA.f13797a.a());
                if (i9 != 0) {
                    builder.setToolbarColor(i9);
                }
                if (i10 != 0) {
                    builder.setSecondaryToolbarColor(i10);
                }
                if (bitmap2 != null) {
                    builder.setCloseButtonIcon(bitmap2);
                }
                builder.setShowTitle(z7);
                CustomTabsIntent customTabsIntentBuild = builder.build();
                try {
                    Context contextB = sg.bigo.ads.common.f.b.b();
                    if (contextB == null) {
                        contextB = context2;
                    }
                    a.b bVar3 = new a.b() { // from class: sg.bigo.ads.a.b.2
                        @Override // sg.bigo.ads.a.a.a.b
                        public final void a(Context context3, b.a aVar) {
                            a.b bVar4 = bVar2;
                            if (bVar4 != null) {
                                bVar4.a(context3, str2, 2, aVar == null ? "" : aVar.f13792b);
                            }
                        }

                        @Override // sg.bigo.ads.a.a.a.b
                        public final void a(b.a aVar) {
                            a.b bVar4 = bVar2;
                            if (bVar4 == null || aVar == null) {
                                return;
                            }
                            bVar4.a(aVar.e, aVar.f13794d, aVar.f13793c);
                        }
                    };
                    b.a aVarA = sg.bigo.ads.a.a.b.a(contextB);
                    if (aVarA == null || !aVarA.f13791a) {
                        bVar3.a(contextB, aVarA);
                    } else {
                        customTabsIntentBuild.intent.setPackage(aVarA.e);
                        customTabsIntentBuild.launchUrl(contextB, uri);
                        bVar3.a(aVarA);
                    }
                } catch (Exception e) {
                    if (bVar2 != null) {
                        bVar2.a(context2, str2, 4, e.toString());
                    }
                    bVarA.f13797a.f13787d = null;
                }
            }
        });
    }

    public static void a(final Context context, final String str, final a.b bVar) {
        a(context, str, bVar, "preload", new Runnable() { // from class: sg.bigo.ads.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVarA = b.a();
                Context context2 = context;
                String str2 = str;
                a.b bVar2 = bVar;
                StringBuilder sbY = a1.a.y("Start preload url: ", str2, " with chrome tab current thread: ");
                sbY.append(Thread.currentThread().getName());
                sbY.append(".");
                sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", sbY.toString());
                if (context2 == null) {
                    sg.bigo.ads.common.t.a.a(0, "ChromeTabsStatic", "Preload: empty context!");
                    if (bVar2 != null) {
                        bVar2.a(context2, str2, 3, "Invalid context");
                        return;
                    }
                    return;
                }
                Context applicationContext = context2.getApplicationContext();
                if (TextUtils.isEmpty(str2)) {
                    sg.bigo.ads.common.t.a.a(0, "ChromeTabsStatic", "Preload: empty url!");
                    if (bVar2 != null) {
                        bVar2.a(applicationContext, str2, 3, "Invalid url");
                        return;
                    }
                    return;
                }
                bVarA.f13798b.add(str2);
                if (bVarA.a(applicationContext)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Meet the conditions for connection of Chrome service.");
                    bVarA.b();
                    if (bVar2 != null) {
                        bVar2.a("", "0", "");
                        return;
                    }
                    return;
                }
                sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", "Failed to make connection of Chrome service.");
                bVarA.f13798b.remove(str2);
                if (bVar2 != null) {
                    bVar2.a(applicationContext, str2, 2, "Failed to make connection of Chrome service.");
                }
            }
        });
    }

    private static void a(@Nullable Context context, String str, @Nullable a.b bVar, String str2, Runnable runnable) {
        a0.i(0, str2, "start ", 3, "ChromeTabsStatic");
        if (!f13810a) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", a1.a.m("Failed to ", str2, " with not exists chrome tab libs"));
            if (context == null || bVar == null) {
                return;
            }
            bVar.a(context, str, 1, "NoClassDefFoundError");
            return;
        }
        try {
            runnable.run();
        } catch (NoClassDefFoundError e) {
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", a1.a.m("Failed to ", str2, " with not exists chrome tab libs"));
            a();
            if (context == null || bVar == null) {
                return;
            }
            bVar.a(context, str, 1, e.toString());
        } catch (Throwable th) {
            StringBuilder sbY = a1.a.y("Failed to ", str2, " with unknown reason: ");
            sbY.append(th.toString());
            sg.bigo.ads.common.t.a.a(0, 3, "ChromeTabsStatic", sbY.toString());
            if (context == null || bVar == null) {
                return;
            }
            bVar.a(context, str, 4, th.toString());
        }
    }
}
