package sg.bigo.ads.controller.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.api.core.u;
import sg.bigo.ads.core.f.a.a;

/* JADX INFO: loaded from: classes6.dex */
public final class l extends b implements sg.bigo.ads.core.a.a {
    private static final AtomicInteger N = new AtomicInteger();
    protected String D;

    @Nullable
    protected o.a E;

    @Nullable
    protected o.a[] F;

    @Nullable
    protected o.c G;
    protected int H;
    protected int I;

    @Nullable
    protected o.b J;

    @Nullable
    protected o.d K;
    public int L;

    @Nullable
    protected i.b M;

    @Nullable
    private sg.bigo.ads.core.f.a.p O;

    @Nullable
    private sg.bigo.ads.api.core.n P;
    private boolean Q;
    private String R;

    @NonNull
    private int S;
    private int T;

    @NonNull
    private long U;
    private a.C0316a V;
    private a.C0316a W;
    private boolean X;
    private boolean Y;
    private int Z;
    private int aa;
    private int ab;
    private int ac;
    private Pair<Bitmap, String> ad;
    private boolean ae;
    private final String af;
    private String ag;
    private boolean ah;
    private u ai;

    public l(long j, @NonNull sg.bigo.ads.api.core.h hVar, @NonNull sg.bigo.ads.api.a.l lVar, @NonNull JSONObject jSONObject) {
        super(j, hVar, lVar, jSONObject);
        this.I = 0;
        this.L = 0;
        this.Q = false;
        this.S = 0;
        this.T = 0;
        this.X = false;
        this.Y = false;
        this.Z = 4;
        this.aa = 6;
        this.ab = 4;
        this.ac = 0;
        this.ae = false;
        this.D = jSONObject.optString("iurl");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(C2300e4.h.H0);
        if (jSONObjectOptJSONObject != null) {
            this.E = new i(jSONObjectOptJSONObject);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject2 != null) {
                    arrayList.add(new i(jSONObjectOptJSONObject2));
                }
            }
            i[] iVarArr = new i[arrayList.size()];
            this.F = iVarArr;
            this.F = (o.a[]) arrayList.toArray(iVarArr);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(MimeTypes.BASE_TYPE_VIDEO);
        if (jSONObjectOptJSONObject3 != null) {
            this.G = new r(jSONObjectOptJSONObject3);
        }
        this.J = new j(jSONObject);
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_play_cfg");
        if (jSONObjectOptJSONObject4 != null) {
            this.K = new s(jSONObjectOptJSONObject4);
        }
        this.H = jSONObject.optInt("immersive_ad_type", 0);
        try {
            if (1 == this.A) {
                List<sg.bigo.ads.api.core.c> list = this.f16453a;
                if (!sg.bigo.ads.common.utils.k.a((Collection) list)) {
                    sg.bigo.ads.api.a.m mVar = this.y;
                    if (mVar == null || mVar.a("multi_ads.multi_ads_type") != 1) {
                        this.I = 1;
                    } else {
                        this.I = 2;
                    }
                    for (sg.bigo.ads.api.core.c cVar : list) {
                        if (cVar instanceof l) {
                            ((l) cVar).I = this.I;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("display");
        if (jSONObjectOptJSONObject5 != null) {
            this.M = new h(jSONObjectOptJSONObject5);
        }
        this.af = this.l + "_" + this.f16455c + "_" + N.addAndGet(1);
    }

    @Nullable
    private sg.bigo.ads.core.f.a.b bq() {
        sg.bigo.ads.core.f.a.p pVar = this.O;
        if (pVar != null) {
            return pVar.f17056n;
        }
        return null;
    }

    @Override // sg.bigo.ads.api.core.o
    @NonNull
    public final String a(Context context) {
        return aS() ? sg.bigo.ads.common.o.c(context) : sg.bigo.ads.common.o.b(context);
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final o.b aA() {
        return this.J;
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final o.d aB() {
        return this.K;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int aC() {
        return this.S;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int aD() {
        return this.T;
    }

    @Override // sg.bigo.ads.api.core.o
    public final long aE() {
        return this.U;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aF() {
        a.C0316a c0316a = this.W;
        return c0316a != null && c0316a.a();
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aG() {
        a.C0316a c0316a = this.V;
        return c0316a != null && c0316a.a();
    }

    @Override // sg.bigo.ads.api.core.o
    public final int aH() {
        return this.I;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aI() {
        return this.ag;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aJ() {
        return !TextUtils.isEmpty(this.af) ? this.af : String.valueOf(this.j);
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final String aK() {
        sg.bigo.ads.core.f.a.b bVarBq = bq();
        if (bVarBq != null) {
            return bVarBq.f17018c;
        }
        return null;
    }

    @Override // sg.bigo.ads.api.core.o
    public final long aL() {
        o.d dVar = this.K;
        if (dVar != null) {
            return dVar.a();
        }
        return 0L;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int aM() {
        return this.L;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aN() {
        sg.bigo.ads.core.f.a.b bVarBq = bq();
        String str = bVarBq != null ? bVarBq.e : null;
        if (sg.bigo.ads.common.utils.q.b((CharSequence) str)) {
            return str;
        }
        sg.bigo.ads.core.f.a.p pVar = this.O;
        if (pVar != null) {
            return pVar.f17057o;
        }
        return null;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aO() {
        o.d dVar;
        if (!aS() && (dVar = this.K) != null && dVar.b() && dVar.c() < 100) {
            sg.bigo.ads.core.f.a.b bVarBq = bq();
            if (bVarBq != null ? "video/mp4".equals(bVarBq.f17019d) : false) {
                return true;
            }
        }
        return false;
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final String aP() {
        return aK();
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final String aQ() {
        String strAN = aN();
        if (!sg.bigo.ads.common.utils.q.a((CharSequence) strAN)) {
            return strAN;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        return sb.toString();
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aR() {
        return this.h == 2;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aS() {
        sg.bigo.ads.core.f.a.b bVarBq = bq();
        return bVarBq != null && bVarBq.a();
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aT() {
        o.a aVar;
        o.a[] aVarArr = this.F;
        if (aVarArr == null || aVarArr.length <= 0 || (aVar = aVarArr[0]) == null) {
            return null;
        }
        return aVar.c();
    }

    @Override // sg.bigo.ads.api.core.o
    public final long aU() {
        sg.bigo.ads.core.f.a.p pVar = this.O;
        if (pVar != null) {
            return pVar.f17060s;
        }
        return 0L;
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final sg.bigo.ads.api.core.n aV() {
        return this.P;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aW() {
        return this.Q;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void aX() {
        this.Q = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String aY() {
        String strAT;
        if (!sg.bigo.ads.common.utils.q.a((CharSequence) this.R)) {
            return this.R;
        }
        if (aR()) {
            sg.bigo.ads.core.f.a.b bVarBq = bq();
            if (bVarBq != null) {
                this.R = bVarBq.f17019d;
            }
            if (!sg.bigo.ads.common.utils.q.a((CharSequence) this.R)) {
                return this.R;
            }
            strAT = aK();
        } else {
            strAT = aT();
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(strAT));
        this.R = mimeTypeFromExtension;
        return mimeTypeFromExtension;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean aZ() {
        return this.ae;
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final o.a av() {
        return this.E;
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final i.b aw() {
        return this.M;
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final o.a[] ax() {
        return this.F;
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final o.c ay() {
        return this.G;
    }

    @Override // sg.bigo.ads.api.core.o
    @Nullable
    public final String az() {
        return this.D;
    }

    @Override // sg.bigo.ads.api.core.o
    @NonNull
    public final String b(Context context) {
        return a(context) + File.separator + aQ();
    }

    @Override // sg.bigo.ads.api.core.o
    public final void ba() {
        this.ae = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean bb() {
        return this.X;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void bc() {
        this.X = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int bd() {
        return this.Z;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int be() {
        return this.aa;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int bf() {
        return this.ab;
    }

    @Override // sg.bigo.ads.api.core.o
    public final int bg() {
        return this.ac;
    }

    @Override // sg.bigo.ads.api.core.o
    public final Pair<Bitmap, String> bh() {
        return this.ad;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean bi() {
        return this.Y;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void bj() {
        this.Y = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void bk() {
        this.ah = true;
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean bl() {
        return this.ah;
    }

    @Override // sg.bigo.ads.core.a.a
    public final a.C0316a bm() {
        return this.V;
    }

    @Override // sg.bigo.ads.core.a.a
    public final a.C0316a bn() {
        return this.W;
    }

    @Override // sg.bigo.ads.core.a.a
    @NonNull
    public final u bo() {
        if (this.ai == null) {
            this.ai = new u(this.C);
        }
        return this.ai;
    }

    @Override // sg.bigo.ads.core.a.a
    public final sg.bigo.ads.core.f.a.p bp() {
        return this.O;
    }

    @Override // sg.bigo.ads.api.core.o
    public final String c(Context context) {
        Pair pair;
        if (!aO()) {
            this.L = 0;
            return b(context);
        }
        sg.bigo.ads.core.player.a.d dVarB = sg.bigo.ads.core.player.b.a().b();
        String strAK = aK();
        String strA = a(context);
        String strAQ = aQ();
        File file = new File(strA, strAQ);
        if (file.exists()) {
            pair = new Pair(Uri.fromFile(file).toString(), 1);
        } else if (dVarB.a()) {
            StringBuilder sb = new StringBuilder(strAK);
            if (strAK.contains("?")) {
                sb.append(C2300e4.i.f8401c);
            } else {
                sb.append("?");
            }
            androidx.camera.core.processing.util.a.A(sb, "path=", strA, "&name=", strAQ);
            Locale locale = Locale.US;
            pair = new Pair("http://127.0.0.1:" + dVarB.f17283c + "/" + sg.bigo.ads.common.utils.q.e(sb.toString()), 2);
        } else {
            pair = new Pair(strAK, 3);
        }
        this.L = ((Integer) pair.second).intValue();
        return (String) pair.first;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void d(String str) {
        if ("video/mp4".equals(this.R) || sg.bigo.ads.common.utils.q.a((CharSequence) str)) {
            return;
        }
        this.R = str;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void f(int i2) {
        this.S = i2;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void g(int i2) {
        this.T = i2;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void h(int i2) {
        this.Z = i2;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void i(int i2) {
        this.aa = i2;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void j(int i2) {
        this.ab = i2;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void k(int i2) {
        this.ac = i2;
    }

    @Override // sg.bigo.ads.controller.c.b, sg.bigo.ads.api.core.c
    public final String s() {
        sg.bigo.ads.core.f.a.p pVar = this.O;
        return (pVar == null || !sg.bigo.ads.common.utils.q.b((CharSequence) pVar.p)) ? super.s() : this.O.p;
    }

    @Override // sg.bigo.ads.controller.c.b, sg.bigo.ads.api.core.c
    public final String t() {
        sg.bigo.ads.core.f.a.p pVar = this.O;
        return (pVar == null || !sg.bigo.ads.common.utils.q.b((CharSequence) pVar.f17058q)) ? super.t() : this.O.f17058q;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void a(Pair<Bitmap, String> pair) {
        this.ad = pair;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void b(long j) {
        this.U = j;
    }

    @Override // sg.bigo.ads.api.core.o
    public final void a(sg.bigo.ads.api.core.n nVar) {
        sg.bigo.ads.api.core.n nVar2 = this.P;
        if (nVar2 == null || nVar2.f15522c <= 0 || nVar.f15522c != 0) {
            this.P = nVar;
        }
    }

    @Override // sg.bigo.ads.core.a.a
    public final void b(a.C0316a c0316a) {
        this.W = c0316a;
    }

    @Override // sg.bigo.ads.core.a.a
    public final void a(a.C0316a c0316a) {
        this.V = c0316a;
    }

    @Override // sg.bigo.ads.core.a.a
    public final void a(sg.bigo.ads.core.f.a.p pVar) {
        this.O = pVar;
        if (pVar != null && sg.bigo.ads.common.utils.q.b((CharSequence) pVar.m)) {
            N().a(this.O.m);
        }
        o.d dVar = this.K;
        if (dVar != null) {
            dVar.a(aU());
        }
    }

    @Override // sg.bigo.ads.api.core.o
    public final void c(String str) {
        if (this.I == 2) {
            this.I = 3;
            List<sg.bigo.ads.api.core.c> list = this.f16453a;
            if (!sg.bigo.ads.common.utils.k.a((Collection) list)) {
                for (sg.bigo.ads.api.core.c cVar : list) {
                    if (cVar instanceof l) {
                        ((l) cVar).I = this.I;
                    }
                }
            }
        }
        if (this.ag == null) {
            this.ag = str;
        } else {
            this.ag = a1.a.s(new StringBuilder(), this.ag, ",", str);
        }
    }

    @Override // sg.bigo.ads.api.core.o
    public final boolean c(@IntRange(from = 1, to = 100) long j) {
        o.d dVar = this.K;
        return j >= ((long) (dVar != null ? dVar.c() : 50));
    }
}
