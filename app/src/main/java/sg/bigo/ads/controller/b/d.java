package sg.bigo.ads.controller.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.core.r;

/* JADX INFO: loaded from: classes6.dex */
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f16411a;
    public final sg.bigo.ads.common.h.a.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final sg.bigo.ads.core.d.a.a f16412f;
    public final sg.bigo.ads.core.b.a.a g;

    public d(@NonNull Context context) {
        super(context);
        this.f16411a = new r();
        this.e = new sg.bigo.ads.common.h.a.a();
        this.f16412f = new sg.bigo.ads.core.d.a.a();
        this.g = new sg.bigo.ads.core.b.a.a();
    }

    @Override // sg.bigo.ads.common.e
    public final void a(Context context) {
        super.a(context);
        if (!TextUtils.isEmpty(this.f16424w)) {
            try {
                d(new JSONObject(this.f16424w));
            } catch (JSONException unused) {
            }
        }
        if (!TextUtils.isEmpty(this.f16423v)) {
            try {
                a(new JSONObject(this.f16423v));
            } catch (JSONException unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.f16422u)) {
            try {
                b(new JSONObject(this.f16422u));
            } catch (JSONException unused3) {
            }
        }
        if (TextUtils.isEmpty(this.f16425x)) {
            return;
        }
        try {
            c(new JSONObject(this.f16425x));
        } catch (JSONException unused4) {
        }
    }

    @Override // sg.bigo.ads.common.e
    public final String b() {
        return "GlobalConfigData";
    }

    @Override // sg.bigo.ads.controller.b.e
    public final void c(JSONObject jSONObject) {
        this.f16412f.a(jSONObject);
    }

    @Override // sg.bigo.ads.controller.b.e
    public final void d(JSONObject jSONObject) {
        this.g.a(jSONObject);
    }

    @Override // sg.bigo.ads.api.a.h
    @NonNull
    public final r m() {
        return this.f16411a;
    }

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("GlobalConfigData{huaweiAdIdInfo=");
        sb.append(this.h);
        sb.append(", googleAdIdInfo=");
        sb.append(this.f16415i);
        sb.append(", location=");
        sb.append(this.j);
        sb.append(", state=");
        sb.append(this.m);
        sb.append(", configId=");
        sb.append(this.f16416n);
        sb.append(", interval=");
        sb.append(this.f16417o);
        sb.append(", token='");
        sb.append(this.p);
        sb.append("', antiBan='");
        sb.append(this.f16418q);
        sb.append("', strategy=");
        sb.append(this.f16419r);
        sb.append(", abflags='");
        sb.append(this.f16420s);
        sb.append("', country='");
        sb.append(this.f16421t);
        sb.append("', creatives='");
        sb.append(this.f16422u);
        sb.append("', trackConfig='");
        sb.append(this.f16423v);
        sb.append("', callbackConfig='");
        sb.append(this.f16424w);
        sb.append("', reportConfig='");
        sb.append(this.f16425x);
        sb.append("', appCheckConfig='");
        sb.append(this.y);
        sb.append("', uid='");
        sb.append(this.f16426z);
        sb.append("', maxRequestNum=");
        sb.append(this.A);
        sb.append(", negFeedbackState=");
        sb.append(this.B);
        sb.append(", omUrl='");
        sb.append(this.C);
        sb.append("', globalSwitch=");
        sb.append(this.E.f15519a);
        sb.append(", bannerJsUrl='");
        sb.append(this.D);
        sb.append("', reqCountry='");
        sb.append(this.L);
        sb.append("', appFlag='");
        return a1.a.q(sb, "'}", this.N);
    }

    @Override // sg.bigo.ads.controller.b.e
    public final void a(JSONObject jSONObject) {
        this.f16411a.a(jSONObject);
    }

    @Override // sg.bigo.ads.controller.b.e
    public final void b(JSONObject jSONObject) {
        this.e.a(jSONObject);
    }
}
