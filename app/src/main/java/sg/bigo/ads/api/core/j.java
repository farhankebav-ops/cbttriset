package sg.bigo.ads.api.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.e;

/* JADX INFO: loaded from: classes6.dex */
public final class j implements sg.bigo.ads.api.a.e {
    public sg.bigo.ads.api.a.f[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public sg.bigo.ads.api.a.f f15510f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15506a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15507b = "en";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15508c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f15509d = "";
    public String g = "";
    public String h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15511i = 0;
    public int j = 0;

    @NonNull
    public e.b l = new e.b();

    @NonNull
    public e.a m = new e.a();

    @NonNull
    public e.c[] k = new e.c[0];

    @Override // sg.bigo.ads.api.a.e
    public final String a() {
        return this.f15508c;
    }

    @Override // sg.bigo.ads.api.a.e
    public final String b() {
        return this.f15509d;
    }

    @Override // sg.bigo.ads.api.a.e
    public final long c() {
        return this.f15506a;
    }

    @Override // sg.bigo.ads.api.a.e
    public final int d() {
        return this.f15511i;
    }

    @Override // sg.bigo.ads.api.a.e
    public final String e() {
        return this.f15507b;
    }

    @Override // sg.bigo.ads.api.a.e
    public final int f() {
        return this.j;
    }

    @Override // sg.bigo.ads.api.a.e
    public final String g() {
        return this.h;
    }

    @Override // sg.bigo.ads.api.a.e
    public final String h() {
        return this.g;
    }

    @Override // sg.bigo.ads.api.a.e
    public final sg.bigo.ads.api.a.f[] i() {
        return this.e;
    }

    @Override // sg.bigo.ads.api.a.e
    public final sg.bigo.ads.api.a.f j() {
        sg.bigo.ads.api.a.f[] fVarArr = this.e;
        if (fVarArr == null || fVarArr.length <= 0) {
            return null;
        }
        return fVarArr[0];
    }

    @Override // sg.bigo.ads.api.a.e
    public final sg.bigo.ads.api.a.f k() {
        return this.f15510f;
    }

    @Override // sg.bigo.ads.api.a.e
    public final e.b l() {
        return this.l;
    }

    @Override // sg.bigo.ads.api.a.e
    public final e.c[] m() {
        return this.k;
    }

    @Override // sg.bigo.ads.api.a.e
    public final e.a n() {
        return this.m;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f15506a = jSONObject.optLong("form_id", 0L);
            this.f15508c = jSONObject.optString("title", "");
            this.f15507b = jSONObject.optString("ad_lang", "en");
            this.f15509d = jSONObject.optString("description", "");
            this.g = jSONObject.optString("purpose", "");
            this.f15511i = jSONObject.optInt("color", 0);
            this.j = jSONObject.optInt("form_style_id", 0);
            this.h = jSONObject.optString("extra", "");
            a(jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(C2300e4.h.H0);
            if (jSONObjectOptJSONObject != null) {
                this.f15510f = new k(jSONObjectOptJSONObject);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("questions");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null) {
                        arrayList.add(new e.c(jSONObjectOptJSONObject2));
                    }
                }
                e.c[] cVarArr = new e.c[arrayList.size()];
                this.k = cVarArr;
                this.k = (e.c[]) arrayList.toArray(cVarArr);
            }
            e.b bVar = this.l;
            String strOptString = jSONObject.optString("privacy", "");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    bVar.f15451a = jSONObject2.optString("name", "");
                    bVar.f15452b = jSONObject2.optString("url", "");
                } catch (JSONException unused) {
                }
            }
            e.a aVar = this.m;
            String strOptString2 = jSONObject.optString("feedback", "");
            if (TextUtils.isEmpty(strOptString2)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(strOptString2);
            aVar.f15447a = jSONObject3.optString("title", "");
            aVar.f15448b = jSONObject3.optString("description", "");
            aVar.f15449c = jSONObject3.optString(C2300e4.h.G0, "");
            aVar.f15450d = jSONObject3.optString("land_url", "");
        } catch (JSONException unused2) {
        }
    }

    private void a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    arrayList.add(new k(jSONObjectOptJSONObject));
                }
            }
            k[] kVarArr = new k[arrayList.size()];
            this.e = kVarArr;
            this.e = (sg.bigo.ads.api.a.f[]) arrayList.toArray(kVarArr);
        }
    }
}
