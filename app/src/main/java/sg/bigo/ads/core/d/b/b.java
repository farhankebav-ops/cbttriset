package sg.bigo.ads.core.d.b;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.g;
import sg.bigo.ads.common.j;
import sg.bigo.ads.core.d.a.a;
import sg.bigo.ads.core.d.c.a;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final sg.bigo.ads.core.d.a.a f16877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a.b f16878b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final c f16879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final g f16880d;
    final Context e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final j f16881f;

    public b(Context context, sg.bigo.ads.core.d.a.a aVar, j jVar, g gVar) {
        this.e = context;
        this.f16879c = new c(aVar);
        this.f16877a = aVar;
        this.f16881f = jVar;
        this.f16880d = gVar;
    }

    public static a b(String str, Map<String, String> map) {
        return new a(str, map);
    }

    public final void a() {
        sg.bigo.ads.core.d.c.a.a(this.f16878b);
        this.f16878b = null;
        final List<sg.bigo.ads.common.g.b.b> listA = this.f16879c.a();
        if (listA.isEmpty()) {
            sg.bigo.ads.common.t.a.b("Stats", "sendGeneralStats but event list is empty!!");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            for (sg.bigo.ads.common.g.b.b bVar : listA) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_id", bVar.f15718b);
                jSONObject.put("event_info", bVar.f15719c);
                jSONArray.put(jSONObject);
            }
        } catch (JSONException unused) {
        }
        HashMap map = new HashMap();
        map.put("sdk_events", jSONArray);
        this.f16881f.a(map, new j.a() { // from class: sg.bigo.ads.core.d.b.b.3
            @Override // sg.bigo.ads.common.j.a
            public final void a() {
                sg.bigo.ads.core.d.c.a.a(new Runnable() { // from class: sg.bigo.ads.core.d.b.b.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        b.this.f16879c.a(listA, true);
                        b.this.f16879c.d();
                        b.this.b();
                    }
                });
            }

            @Override // sg.bigo.ads.common.j.a
            public final void a(int i2, int i8, String str) {
                sg.bigo.ads.core.d.c.a.a(new Runnable() { // from class: sg.bigo.ads.core.d.b.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        b.this.f16879c.a(listA, false);
                        b.this.b();
                    }
                });
            }
        });
    }

    public final void a(@NonNull final String str, @NonNull final Map<String, String> map) {
        sg.bigo.ads.core.d.c.a.a(new Runnable() { // from class: sg.bigo.ads.core.d.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                a.C0314a c0314a = b.this.f16877a.f16868c.get(str);
                boolean z2 = c0314a == null ? true : c0314a.f16871c;
                a.C0314a c0314a2 = b.this.f16877a.f16868c.get(str);
                long jCurrentTimeMillis = System.currentTimeMillis() + ((long) (c0314a2 == null ? 3600000 : c0314a2.f16872d));
                a aVarB = b.b(str, map);
                b bVar = b.this;
                bVar.f16879c.a(aVarB.a(bVar.f16880d, jCurrentTimeMillis));
                if (z2) {
                    sg.bigo.ads.common.t.a.a(0, 3, "Stats", "SendDefer -> eventId=" + str + ", events=" + map);
                    b.a(b.this);
                    return;
                }
                sg.bigo.ads.common.t.a.a(0, 3, "Stats", "SendImmediately -> eventId=" + str + ", events=" + map);
                b.this.a();
            }
        });
    }

    public final void b() {
        if (this.f16878b != null) {
            return;
        }
        if (this.f16879c.c()) {
            sg.bigo.ads.common.t.a.a(0, 3, "Stats", "no events waitting for sending");
        } else {
            this.f16878b = sg.bigo.ads.core.d.c.a.a(new Runnable() { // from class: sg.bigo.ads.core.d.b.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (sg.bigo.ads.common.aa.c.b(b.this.e)) {
                        b.this.a();
                        return;
                    }
                    b bVar = b.this;
                    bVar.f16878b = null;
                    bVar.b();
                }
            }, this.f16877a.f16867b);
        }
    }

    public static /* synthetic */ void a(b bVar) {
        if (bVar.f16879c.b() >= bVar.f16877a.f16866a) {
            bVar.a();
        } else {
            bVar.b();
        }
    }
}
