package sg.bigo.ads.core.b.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.aa.c;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.j;
import sg.bigo.ads.core.b.c.b;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b.AbstractRunnableC0312b f16814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final b f16815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final g f16816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Context f16817d;
    private final sg.bigo.ads.core.b.a.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j f16818f;

    public a(Context context, sg.bigo.ads.core.b.a.a aVar, j jVar, g gVar) {
        this.f16817d = context;
        this.f16815b = new b(aVar);
        this.e = aVar;
        this.f16818f = jVar;
        this.f16816c = gVar;
    }

    public final void a() {
        sg.bigo.ads.core.b.c.b.a(this.f16814a);
        this.f16814a = null;
        final List<sg.bigo.ads.common.g.b.a> listB = this.f16815b.b();
        if (listB.isEmpty()) {
            sg.bigo.ads.common.t.a.b("Callback", "sendGeneralStats but event list is empty!!");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<sg.bigo.ads.common.g.b.a> it = listB.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(new JSONObject(it.next().f15714c));
            } catch (JSONException unused) {
            }
        }
        HashMap map = new HashMap();
        map.put("events", jSONArray);
        this.f16818f.a(map, new j.a() { // from class: sg.bigo.ads.core.b.b.a.3
            @Override // sg.bigo.ads.common.j.a
            public final void a() {
                sg.bigo.ads.core.b.c.b.a(new Runnable() { // from class: sg.bigo.ads.core.b.b.a.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        a.this.f16815b.a(listB, true);
                        a.this.f16815b.e();
                        if (a.this.f16815b.d()) {
                            return;
                        }
                        a.this.b();
                    }
                });
            }

            @Override // sg.bigo.ads.common.j.a
            public final void a(int i2, int i8, String str) {
                sg.bigo.ads.core.b.c.b.a(new Runnable() { // from class: sg.bigo.ads.core.b.b.a.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        a.this.f16815b.a(listB, false);
                        a.this.b();
                    }
                });
            }
        });
    }

    public final void b() {
        if (this.f16814a != null) {
            return;
        }
        this.f16814a = sg.bigo.ads.core.b.c.b.a(new Runnable() { // from class: sg.bigo.ads.core.b.b.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (c.b(a.this.f16817d)) {
                    a.this.a();
                    return;
                }
                a aVar = a.this;
                aVar.f16814a = null;
                aVar.b();
            }
        }, this.e.f16809b);
    }

    public final void a(@NonNull final String str, @NonNull final JSONObject jSONObject) {
        sg.bigo.ads.core.b.c.b.a(new Runnable() { // from class: sg.bigo.ads.core.b.b.a.1
            @Override // java.lang.Runnable
            public final void run() {
                sg.bigo.ads.common.g.b.a aVar = new sg.bigo.ads.common.g.b.a(str, jSONObject.toString());
                a.this.f16815b.a(aVar);
                if (TextUtils.isEmpty(a.this.f16816c.P())) {
                    return;
                }
                if ("impression".equals(str) || "clicked".equals(str)) {
                    sg.bigo.ads.common.t.a.a(0, 3, "Callback", "SendImmediately -> action=" + str + ", eventInfo=" + aVar.toString());
                    a.this.a();
                    return;
                }
                sg.bigo.ads.common.t.a.a(0, 3, "Callback", "SendDefer -> action=" + str + ", eventInfo=" + aVar.toString());
                a.a(a.this);
            }
        });
    }

    public static /* synthetic */ void a(a aVar) {
        if (aVar.f16815b.c() >= aVar.e.f16808a) {
            aVar.a();
        } else {
            if (aVar.f16815b.d()) {
                return;
            }
            aVar.b();
        }
    }
}
