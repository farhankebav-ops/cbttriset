package sg.bigo.ads.controller.b;

import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.provider.FontsContractCompat;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.k;
import sg.bigo.ads.api.a.l;
import sg.bigo.ads.api.a.m;
import sg.bigo.ads.common.f;
import sg.bigo.ads.common.n;

/* JADX INFO: loaded from: classes6.dex */
class i implements l, sg.bigo.ads.common.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f16436a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f16437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f16438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f16439d;
    protected int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f16440f;
    protected int g;
    protected int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f16441i;
    protected boolean j;
    protected boolean k;
    protected int l;
    protected String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f16442n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected String f16443o;
    protected List<sg.bigo.ads.api.a.a> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected String f16444q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected String f16445r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected m f16446s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f16447t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected int f16448u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected boolean f16449v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected int f16450w;

    @Override // sg.bigo.ads.api.a.l
    public String a() {
        return this.f16437b;
    }

    @Override // sg.bigo.ads.api.a.l
    public int b() {
        return this.f16438c;
    }

    @Override // sg.bigo.ads.api.a.l
    public int c() {
        return this.f16439d;
    }

    @Override // sg.bigo.ads.api.a.l
    public int d() {
        return this.e;
    }

    @Override // sg.bigo.ads.api.a.l
    public int e() {
        return this.f16440f;
    }

    @Override // sg.bigo.ads.api.a.l
    public int f() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.a.l
    public int g() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.a.l
    public boolean h() {
        return this.f16441i;
    }

    @Override // sg.bigo.ads.api.a.l
    public boolean i() {
        return this.j;
    }

    @Override // sg.bigo.ads.api.a.l
    public boolean j() {
        return this.k;
    }

    @Override // sg.bigo.ads.api.a.l
    public int k() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.a.l
    public String l() {
        return this.m;
    }

    @Override // sg.bigo.ads.api.a.l
    public boolean m() {
        return this.f16442n;
    }

    @Override // sg.bigo.ads.api.a.l
    public String n() {
        return this.f16443o;
    }

    @Override // sg.bigo.ads.api.a.l
    public String o() {
        return this.f16444q;
    }

    @Override // sg.bigo.ads.api.a.l
    public String p() {
        return this.f16445r;
    }

    @Override // sg.bigo.ads.api.a.l
    @NonNull
    public m q() {
        if (this.f16446s == null) {
            this.f16446s = new j(new JSONObject());
        }
        return this.f16446s;
    }

    @Override // sg.bigo.ads.api.a.l
    public int r() {
        return this.f16447t;
    }

    @Override // sg.bigo.ads.api.a.l
    public boolean s() {
        return this.f16447t == 1;
    }

    @Override // sg.bigo.ads.api.a.l
    public boolean t() {
        return this.f16448u == 1;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<sg.bigo.ads.api.a.a> list = this.p;
        if (list != null) {
            for (sg.bigo.ads.api.a.a aVar : list) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(aVar);
            }
        }
        return "{strategyId=" + this.f16437b + ", adType=" + this.f16438c + ", countdown=" + this.f16439d + ", reqTimeout=" + this.e + ", mediaStrategy=" + this.f16440f + ", webViewEnforceDuration=" + this.g + ", videoDirection=" + this.h + ", videoReplay=" + this.f16441i + ", videoMute=" + this.j + ", bannerAutoRefresh=" + this.k + ", bannerRefreshInterval=" + this.l + ", slotId='" + this.m + "', state=" + this.f16442n + ", placementId='" + this.f16443o + "', express=[" + sb.toString() + "], styleId=" + this.f16445r + ", playable=" + this.f16447t + ", isCompanionRenderSupport=" + this.f16448u + ", aucMode=" + this.f16450w + ", nativeAdClickConfig=" + this.f16436a + '}';
    }

    @Override // sg.bigo.ads.api.a.l
    public boolean u() {
        return this.f16449v;
    }

    @Override // sg.bigo.ads.api.a.l
    public int v() {
        return this.f16450w;
    }

    @Override // sg.bigo.ads.api.a.l
    public boolean w() {
        return this.f16450w == 3;
    }

    @Override // sg.bigo.ads.api.a.l
    @NonNull
    public k x() {
        return this.f16436a;
    }

    public void a(@NonNull Parcel parcel) {
        parcel.writeString(this.f16437b);
        parcel.writeInt(this.f16438c);
        parcel.writeInt(this.f16439d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f16440f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.f16441i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeInt(this.f16442n ? 1 : 0);
        parcel.writeString(this.f16443o);
        n.a(parcel, this.p);
        parcel.writeInt(this.f16447t);
        parcel.writeString(this.f16445r);
        m mVar = this.f16446s;
        parcel.writeString(mVar == null ? null : mVar.toString());
        parcel.writeInt(this.f16449v ? 1 : 0);
        parcel.writeInt(this.f16448u);
        parcel.writeInt(this.f16450w);
        n.a(parcel, this.f16436a);
    }

    public void b(@NonNull Parcel parcel) {
        this.f16437b = parcel.readString();
        this.f16438c = parcel.readInt();
        this.f16439d = parcel.readInt();
        this.e = parcel.readInt();
        this.f16440f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.f16441i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readInt() != 0;
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.f16442n = parcel.readInt() != 0;
        this.f16443o = parcel.readString();
        this.p = n.a(parcel, new f.a<sg.bigo.ads.api.a.a>() { // from class: sg.bigo.ads.controller.b.i.1
            @Override // sg.bigo.ads.common.f.a
            public final /* synthetic */ sg.bigo.ads.common.f a() {
                return new a();
            }
        });
        this.f16447t = n.a(parcel, 0);
        this.f16445r = n.a(parcel, "");
        a(n.a(parcel, ""));
        this.f16449v = n.b(parcel, true);
        this.f16448u = n.a(parcel, 0);
        this.f16450w = n.a(parcel, 0);
        n.b(parcel, this.f16436a);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (this.f16438c == 4 && !jSONObject.has("interstitial_video_style")) {
                jSONObject = new JSONObject().put("interstitial_video_style", jSONObject);
            }
            this.f16446s = new j(jSONObject);
        } catch (JSONException unused) {
        }
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            sg.bigo.ads.common.t.a.a(0, "Slot", "parseData error, jsonObject is null.");
            return false;
        }
        this.f16439d = jSONObject.optInt("countdown", 5);
        this.f16438c = jSONObject.optInt("ad_type", -1);
        this.f16437b = jSONObject.optString("strategy_id", "");
        this.e = jSONObject.optInt("req_once_load_timeout", 15);
        this.f16440f = jSONObject.optInt("media_strategy", 0);
        this.g = jSONObject.optInt("webview_enforce_duration", 0) * 1000;
        this.h = jSONObject.optInt("video_direction", 0);
        this.f16441i = sg.bigo.ads.api.core.b.d(this.f16438c) || jSONObject.optInt("video_replay", 1) == 1;
        this.j = sg.bigo.ads.api.core.b.d(this.f16438c) || jSONObject.optInt("video_mute", 0) == 0;
        this.k = jSONObject.optInt("banner_auto_refresh", 0) == 1;
        this.l = jSONObject.optInt("banner_refresh_interval", 20);
        this.m = jSONObject.optString("slot", "");
        this.f16442n = jSONObject.optInt("state", 1) == 1;
        this.f16443o = jSONObject.optString(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, "");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("express_list");
        this.p = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                a aVar = new a();
                if (jSONObjectOptJSONObject == null) {
                    sg.bigo.ads.common.t.a.a(0, "AdExpress", "parseData error, jsonObject is null.");
                } else {
                    aVar.f16387a = jSONObjectOptJSONObject.optLong("id", 0L);
                    aVar.f16388b = jSONObjectOptJSONObject.optString("name", "");
                    aVar.f16389c = jSONObjectOptJSONObject.optString("url", "");
                    aVar.f16390d = jSONObjectOptJSONObject.optString("md5", "");
                    aVar.e = jSONObjectOptJSONObject.optString("style", "");
                    aVar.f16391f = jSONObjectOptJSONObject.optString("ad_types", "");
                    aVar.g = jSONObjectOptJSONObject.optString(FontsContractCompat.Columns.FILE_ID, "");
                    if (aVar.f16387a != 0 && !TextUtils.isEmpty(aVar.f16388b) && !TextUtils.isEmpty(aVar.f16389c) && !TextUtils.isEmpty(aVar.f16390d) && !TextUtils.isEmpty(aVar.f16391f) && !TextUtils.isEmpty(aVar.g)) {
                        this.p.add(aVar);
                    }
                }
            }
        }
        this.f16444q = jSONObject.optString("abflags");
        this.f16447t = jSONObject.optInt("playable", 0);
        this.f16445r = jSONObject.optString("style_id");
        a(jSONObject.optString("interstitial_style_config"));
        this.f16449v = jSONObject.optInt("banner_multiple_click", 1) == 1;
        this.f16448u = jSONObject.optInt("companion_render", 0);
        this.f16450w = jSONObject.optInt("auc_mode", 0);
        g gVar = this.f16436a;
        gVar.f16431a = jSONObject.optInt("video_click_mode", 1) == 1;
        gVar.f16432b = jSONObject.optInt("native_ad_view_clickable", 0) == 1;
        gVar.f16433c = jSONObject.optInt("native_ad_click_type", 0);
        if (this.f16442n) {
            return (TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.f16443o)) ? false : true;
        }
        return true;
    }
}
