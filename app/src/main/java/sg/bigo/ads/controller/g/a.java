package sg.bigo.ads.controller.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.Q6;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.api.core.q;
import sg.bigo.ads.common.u.a;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a<T extends sg.bigo.ads.common.u.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f16651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final sg.bigo.ads.common.g f16652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final sg.bigo.ads.controller.a.b f16653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final long f16654d;

    @Nullable
    protected final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    protected final String f16655f;

    @Nullable
    protected final String g;
    public final q h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f16656i;
    private final sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.b, sg.bigo.ads.common.u.c.d> j;

    /* JADX INFO: renamed from: sg.bigo.ads.controller.g.a$a, reason: collision with other inner class name */
    public static class C0308a extends sg.bigo.ads.common.u.b.b<sg.bigo.ads.controller.a.f> {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private final long f16666o;

        public C0308a(Context context, int i2, @NonNull sg.bigo.ads.controller.a.f fVar, long j) {
            super(i2, fVar, context);
            this.f16666o = j;
        }

        @Override // sg.bigo.ads.common.u.b.c
        public final void h() {
            super.h();
            sg.bigo.ads.controller.a.f fVar = (sg.bigo.ads.controller.a.f) this.j;
            HashMap map = new HashMap();
            map.put("pre_host", fVar.f());
            map.put("host_cfg_clear", Integer.valueOf(fVar.h() ? 1 : 0));
            map.put("host_src", fVar.i());
            sg.bigo.ads.controller.a.j jVarG = fVar.g();
            if (jVarG != null) {
                map.put("host_type", Integer.valueOf(jVarG.d()));
            }
            a(map);
            long j = this.f16666o;
            if (j > 0) {
                fVar.a(j);
            }
        }
    }

    public interface b {
        void a(String str, Object obj);
    }

    public a(@NonNull sg.bigo.ads.common.g gVar, @Nullable sg.bigo.ads.controller.a.b bVar) {
        this(gVar, bVar, 15000L);
    }

    public final int a() {
        return this.f16651a;
    }

    public abstract void a(int i2, int i8, String str);

    public abstract void a(@NonNull String str, @NonNull Map<String, Object> map);

    public abstract void a(@NonNull b bVar);

    public final void b() {
        final JSONObject jSONObject;
        String str;
        Object objA;
        String str2;
        sg.bigo.ads.common.u.a aVarF = f();
        sg.bigo.ads.common.u.b.b c0308a = aVarF instanceof sg.bigo.ads.controller.a.f ? new C0308a(this.f16652b.af(), this.f16651a, (sg.bigo.ads.controller.a.f) aVarF, e()) : new sg.bigo.ads.common.u.b.b(this.f16651a, aVarF, this.f16652b.af());
        boolean z2 = false;
        int i2 = 0;
        z2 = false;
        if (sg.bigo.ads.common.x.a.q() && !(this instanceof l)) {
            String str3 = "Missing CCPA consent";
            if (sg.bigo.ads.common.x.a.m() == 2) {
                str2 = "Missing GDPR consent";
                i2 = 1;
            } else {
                str2 = "Missing CCPA consent";
            }
            if (sg.bigo.ads.common.x.a.o() == 2) {
                i2++;
                str2 = "Missing LGPD consent";
            }
            if (sg.bigo.ads.common.x.a.n() == 2) {
                i2++;
            } else {
                str3 = str2;
            }
            if (sg.bigo.ads.common.x.a.p() == 2) {
                i2++;
                str3 = "Missing COPPA consent";
            }
            if (i2 > 1) {
                str3 = "Missing user consent";
            }
            this.j.a(c0308a, new sg.bigo.ads.common.u.h(800, str3));
            return;
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.putOpt("app_key", sg.bigo.ads.common.utils.q.a(this.f16652b.a()));
            jSONObject.putOpt("pkg_name", sg.bigo.ads.common.utils.q.a(this.f16652b.b()));
            jSONObject.putOpt("pkg_ver", sg.bigo.ads.common.utils.q.a(this.f16652b.c()));
            jSONObject.putOpt("pkg_vc", Integer.valueOf(this.f16652b.d()));
            jSONObject.putOpt("pkg_ch", this.f16652b.e());
            jSONObject.putOpt(Q6.F, sg.bigo.ads.common.utils.q.a(this.f16652b.i()));
            jSONObject.putOpt("os_ver", sg.bigo.ads.common.utils.q.a(this.f16652b.j()));
            jSONObject.putOpt("os_lang", this.f16652b.k());
            jSONObject.putOpt("vendor", this.f16652b.l());
            jSONObject.putOpt(Q6.B, this.f16652b.m());
            jSONObject.putOpt("resolution", this.f16652b.o());
            jSONObject.putOpt("dpi", Integer.valueOf(this.f16652b.p()));
            jSONObject.putOpt("dpi_f", this.f16652b.q());
            jSONObject.putOpt("net", this.f16652b.r());
            jSONObject.putOpt("timezone", this.f16652b.s());
            jSONObject.putOpt("country", this.f16652b.t());
            jSONObject.putOpt("sdk_ver", sg.bigo.ads.common.utils.q.a(this.f16652b.y()));
            jSONObject.putOpt("sdk_vc", 50501);
            if (sg.bigo.ads.common.x.a.q()) {
                str = "consent_status";
                objA = Integer.valueOf(sg.bigo.ads.core.d.b.b());
            } else {
                jSONObject.putOpt(Q6.U0, sg.bigo.ads.common.utils.q.a(this.f16652b.A()));
                jSONObject.putOpt("hw_id", sg.bigo.ads.common.utils.q.a(this.f16652b.G()));
                jSONObject.putOpt("fire_id", sg.bigo.ads.common.utils.q.a(this.f16652b.ae()));
                str = "af_id";
                objA = sg.bigo.ads.common.utils.q.a(this.f16652b.B());
            }
            jSONObject.putOpt(str, objA);
            jSONObject.putOpt("uid", sg.bigo.ads.common.utils.q.a(this.f16652b.C()));
            long jD = this.f16652b.D();
            jSONObject.putOpt("timestamp", Long.valueOf(jD));
            jSONObject.putOpt("abflags", this.f16652b.E());
            jSONObject.putOpt("batsa", Integer.valueOf(this.f16652b.ag() ? 1 : 0));
            jSONObject.putOpt("datasa", Integer.valueOf(this.f16652b.ah()));
            jSONObject.putOpt("root", Integer.valueOf(this.f16652b.ai() ? 1 : 0));
            String string = UUID.randomUUID().toString();
            jSONObject.putOpt("request_id", sg.bigo.ads.common.utils.q.a(string));
            jSONObject.putOpt("sdk_channel", this.f16652b.aa());
            jSONObject.putOpt("simulator_file", Integer.valueOf(this.f16652b.ab()));
            jSONObject.putOpt("sim_country", this.f16655f);
            jSONObject.putOpt("system_country", this.g);
            jSONObject.putOpt("inst_src", this.f16652b.T());
            a(new b() { // from class: sg.bigo.ads.controller.g.a.3
                @Override // sg.bigo.ads.controller.g.a.b
                public final void a(String str4, Object obj) {
                    if (TextUtils.isEmpty(str4)) {
                        return;
                    }
                    try {
                        jSONObject.putOpt(str4, obj);
                    } catch (JSONException unused) {
                    }
                }
            });
            jSONObject.putOpt("sign", sg.bigo.ads.common.utils.m.a(a(jD, string).toString()));
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (sg.bigo.ads.common.x.a.t() && j()) {
            z2 = true;
        }
        sg.bigo.ads.common.u.f fVarD = d();
        c0308a.f15963b = jSONObject;
        c0308a.f15964c = null;
        c0308a.f15965d = fVarD;
        c0308a.e = z2;
        c0308a.l = this.f16654d;
        c0308a.a("SDK-Version-Code", BigoAdSdk.getSDKVersion());
        c0308a.k = c();
        sg.bigo.ads.common.u.b bVar = this.j;
        if (bVar == null) {
            bVar = sg.bigo.ads.common.u.b.f15958d;
        }
        sg.bigo.ads.common.u.g.f15987a.a(c0308a, bVar);
    }

    @Nullable
    public abstract sg.bigo.ads.common.n.e c();

    public sg.bigo.ads.common.u.f d() {
        return sg.bigo.ads.common.u.b.b.f15962a;
    }

    public long e() {
        return 0L;
    }

    @NonNull
    public abstract T f();

    public boolean g() {
        return true;
    }

    public boolean h() {
        return true;
    }

    public abstract void i();

    public abstract boolean j();

    public a(@NonNull sg.bigo.ads.common.g gVar, @Nullable sg.bigo.ads.controller.a.b bVar, long j) {
        this.h = new q();
        this.f16656i = null;
        this.j = new sg.bigo.ads.common.u.b<sg.bigo.ads.common.u.b.b, sg.bigo.ads.common.u.c.d>() { // from class: sg.bigo.ads.controller.g.a.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private long f16658b = -1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f16659c = false;

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ sg.bigo.ads.common.u.c.c a(@NonNull sg.bigo.ads.common.u.c.a aVar) {
                return new sg.bigo.ads.common.u.c.d(aVar);
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(@NonNull sg.bigo.ads.common.u.b.c cVar) {
                super.a((sg.bigo.ads.common.u.b.b) cVar);
                this.f16658b = SystemClock.elapsedRealtime();
                this.f16659c = sg.bigo.ads.common.f.b.d();
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(@NonNull sg.bigo.ads.common.u.b.c cVar, @NonNull sg.bigo.ads.common.u.c.c cVar2) {
                sg.bigo.ads.common.u.b.b bVar2 = (sg.bigo.ads.common.u.b.b) cVar;
                sg.bigo.ads.common.u.c.d dVar = (sg.bigo.ads.common.u.c.d) cVar2;
                String strA = dVar.a();
                if (bVar2.f15966f) {
                    try {
                        if (TextUtils.isEmpty(strA) || !strA.trim().startsWith("{")) {
                            String strA2 = sg.bigo.ads.common.j.a.a(strA, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F", null);
                            if (TextUtils.isEmpty(strA2)) {
                                bVar2.g = 0;
                            } else {
                                try {
                                    bVar2.g = 1;
                                    strA = strA2;
                                } catch (Exception unused) {
                                    strA = strA2;
                                    bVar2.g = 2;
                                    try {
                                        bVar2.h = dVar.a("logid");
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                        } else {
                            bVar2.g = 3;
                        }
                        bVar2.h = dVar.a("logid");
                    } catch (Exception unused3) {
                    }
                }
                a aVar = a.this;
                q qVar = aVar.h;
                boolean z2 = bVar2.e;
                boolean z7 = bVar2.f15966f;
                int i2 = bVar2.g;
                String str = bVar2.h;
                qVar.f15525a = z2;
                qVar.f15526b = z7;
                qVar.f15527c = i2;
                qVar.f15528d = str;
                if (z2 && (!z7 || i2 != 1)) {
                    if (z7) {
                        aVar.i();
                    } else {
                        sg.bigo.ads.common.x.a.u();
                    }
                }
                sg.bigo.ads.controller.h.a aVar2 = new sg.bigo.ads.controller.h.a(strA);
                if (aVar2.a()) {
                    a.this.a(bVar2.g(), aVar2.f16674c, aVar2.f16675d);
                } else {
                    a.this.a(bVar2.g(), 1005, aVar2.f16672a, aVar2.f16673b, aVar2.f16675d);
                }
                a.a(a.this, sg.bigo.ads.common.utils.l.a(aVar2.f16675d, "host_cfg"), bVar2.g(), this.f16658b);
                if (a.this.g() && a.this.f16656i == null) {
                    long jElapsedRealtime = this.f16658b > 0 ? SystemClock.elapsedRealtime() - this.f16658b : 0L;
                    T t3 = bVar2.j;
                    String strD = t3.e() ? t3.d() : "";
                    String strG = bVar2.g();
                    int i8 = dVar.f15980a.f15973a;
                    boolean z8 = this.f16659c;
                    int iE = bVar2.e();
                    a aVar3 = a.this;
                    String str2 = aVar3.e;
                    String str3 = aVar3.f16655f;
                    String str4 = aVar3.g;
                    sg.bigo.ads.common.g gVar2 = aVar3.f16652b;
                    sg.bigo.ads.core.d.b.a(strG, strD, true, jElapsedRealtime, i8, "", z8, iE, str2, str3, str4, gVar2 != null ? gVar2.X() : null, bVar2.e, bVar2.f15966f, bVar2.g, bVar2.h);
                }
            }

            @Override // sg.bigo.ads.common.u.b
            public final /* synthetic */ void a(@NonNull sg.bigo.ads.common.u.b.c cVar, @NonNull sg.bigo.ads.common.u.h hVar) {
                int i2;
                String str;
                sg.bigo.ads.common.u.b.b bVar2 = (sg.bigo.ads.common.u.b.b) cVar;
                if (a.this.g() && a.this.f16656i == null) {
                    long jElapsedRealtime = this.f16658b > 0 ? SystemClock.elapsedRealtime() - this.f16658b : 0L;
                    String strG = bVar2.g();
                    if (hVar.f15988a == 900) {
                        strG = "https://invalid.url";
                    }
                    String str2 = strG;
                    T t3 = bVar2.j;
                    String strD = t3.e() ? t3.d() : "";
                    int i8 = hVar.f15988a;
                    String message = hVar.getMessage();
                    boolean z2 = this.f16659c;
                    int iE = bVar2.e();
                    a aVar = a.this;
                    String str3 = aVar.e;
                    String str4 = aVar.f16655f;
                    String str5 = aVar.g;
                    sg.bigo.ads.common.g gVar2 = aVar.f16652b;
                    sg.bigo.ads.core.d.b.a(str2, strD, false, jElapsedRealtime, i8, message, z2, iE, str3, str4, str5, gVar2 == null ? null : gVar2.X(), bVar2.e, bVar2.f15966f, bVar2.g, bVar2.h);
                }
                int i9 = hVar.f15988a;
                if (i9 == 701 || i9 == 702) {
                    i2 = 1025;
                    str = "Request timeout.";
                } else {
                    str = "(" + hVar.f15988a + ") " + hVar.getMessage();
                    i2 = IronSourceError.ERROR_RV_LOAD_DURING_LOAD;
                }
                a.this.a(bVar2.g(), i2, hVar.f15988a, str, null);
                a.this.a(bVar2.g());
            }
        };
        this.f16651a = sg.bigo.ads.common.y.a.a();
        this.f16652b = gVar;
        this.f16653c = bVar;
        this.f16654d = j;
        this.e = gVar.Q();
        this.f16655f = gVar.R();
        this.g = gVar.S();
    }

    @NonNull
    @CallSuper
    public StringBuilder a(long j, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.a()));
        sb.append(",");
        sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.b()));
        sb.append(",");
        sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.c()));
        sb.append(",");
        sb.append(this.f16652b.d());
        sb.append(",");
        sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.i()));
        sb.append(",");
        sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.j()));
        sb.append(",");
        sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.y()));
        sb.append(",50501,");
        sb.append(j);
        if (sg.bigo.ads.common.x.a.q()) {
            sb.append(",,,");
            sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.C()));
            sb.append(",");
        } else {
            sb.append(",");
            sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.A()));
            sb.append(",");
            sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.B()));
            sb.append(",");
            sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.C()));
            sb.append(",");
            sb.append(sg.bigo.ads.common.utils.q.a(this.f16652b.G()));
        }
        sb.append(",");
        sb.append(sg.bigo.ads.common.utils.q.a(str));
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.f16653c != null && h() && this.f16656i == null) {
            this.f16653c.a(100L, str);
        }
    }

    @CallSuper
    public void a(String str, int i2, int i8, String str2, @Nullable Map<String, Object> map) {
        a(i2, i8, str2);
    }

    @CallSuper
    public void a(String str, @NonNull String str2, @NonNull Map<String, Object> map) {
        a(str2, map);
    }

    public static /* synthetic */ void a(a aVar, final String str, final String str2, final long j) {
        if (aVar.f16653c != null) {
            if (TextUtils.isEmpty(str)) {
                aVar.a(str2);
            } else {
                sg.bigo.ads.common.n.d.a(3, new Runnable() { // from class: sg.bigo.ads.controller.g.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a aVar2 = a.this;
                        sg.bigo.ads.controller.a.b bVar = aVar2.f16653c;
                        if (bVar == null || bVar.a(str, str2, j, aVar2.g()).f16379d == 0) {
                            return;
                        }
                        a.this.a(str2);
                    }
                });
            }
        }
    }
}
