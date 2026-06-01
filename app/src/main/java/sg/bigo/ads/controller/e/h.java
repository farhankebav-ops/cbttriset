package sg.bigo.ads.controller.e;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.n;
import sg.bigo.ads.common.f.a;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements a.InterfaceC0284a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final h f16633f = new h();
    private boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f16638i;
    private long j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16634a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f16635b = 5000;
    private long g = 21600000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f16636c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f16637d = 0;

    @NonNull
    public final a e = new a();

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f16639a = System.currentTimeMillis();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f16640b = System.currentTimeMillis();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f16641c = System.currentTimeMillis();

        public a() {
        }

        public final String a(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("start_ts", Long.valueOf(this.f16641c));
                h hVar = h.this;
                jSONObject.putOpt("total_duration", Long.valueOf(hVar.f16636c + hVar.b()));
                h hVar2 = h.this;
                long jB = hVar2.b();
                if (jB > hVar2.f16635b) {
                    hVar2.f16637d = jB;
                } else {
                    jB = hVar2.f16637d;
                }
                jSONObject.putOpt("close_duration", Long.valueOf(jB));
                jSONObject.putOpt("front_total_req_times", Long.valueOf(g.this.f16628c ? r2.f16629a.getAndAdd(1) : r2.f16629a.get()));
                jSONObject.putOpt("back_total_req_times", Long.valueOf(!g.this.f16628c ? r2.f16630b.getAndAdd(1) : r2.f16630b.get()));
                jSONObject.putOpt("close_front_req_times", Long.valueOf(g.this.f16628c ? r8.f16631c.getAndAdd(1) : r8.f16631c.get()));
                jSONObject.putOpt("req_status", Long.valueOf(h.a(h.this)));
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    private h() {
        sg.bigo.ads.common.f.a.a().f15611d = this;
    }

    public static /* synthetic */ int a(h hVar) {
        return hVar.h ? 1 : 2;
    }

    public final long b() {
        long j = this.f16638i;
        if (j > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
            if (jElapsedRealtime > 0 && jElapsedRealtime > this.f16635b) {
                return jElapsedRealtime;
            }
        }
        return 0L;
    }

    public static h a() {
        return f16633f;
    }

    @Override // sg.bigo.ads.common.f.a.InterfaceC0284a
    public final void a(long j, long j3) {
        this.h = true;
        this.f16638i = j;
        a aVar = this.e;
        aVar.f16640b = j3;
        long j8 = this.g;
        if (j8 > 0) {
            long j9 = this.j;
            if (j9 > 0 && j - j9 >= j8) {
                this.f16636c = 0L;
                this.f16637d = 0L;
                aVar.f16641c = System.currentTimeMillis();
                g.a().f16627a.clear();
            }
        }
        a aVar2 = this.e;
        if (aVar2.f16641c == 0) {
            aVar2.f16641c = System.currentTimeMillis();
        }
        g.a().a(true);
    }

    public final void a(n nVar) {
        this.f16634a = nVar.a();
        this.f16635b = nVar.b();
        this.g = nVar.c();
    }

    @Override // sg.bigo.ads.common.f.a.InterfaceC0284a
    public final void a(boolean z2, long j, long j3, long j8) {
        this.h = false;
        this.j = j3;
        this.f16638i = 0L;
        long j9 = j3 - j;
        if (j9 > 0 && j9 > this.f16635b) {
            this.f16636c += j9;
            this.f16637d = j9;
            if (this.f16634a) {
                sg.bigo.ads.core.d.b.a(z2 ? 1 : 2, j8, j9);
            }
        }
        g.a().a(false);
    }
}
