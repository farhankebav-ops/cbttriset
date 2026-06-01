package sg.bigo.ads.api.a;

import androidx.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public interface e {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15447a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15448b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15449c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f15450d = "";
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15451a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15452b = "";
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f15453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String[] f15455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f15456d;

        public c(@NonNull JSONObject jSONObject) {
            this.f15453a = "";
            this.f15454b = 0;
            this.f15455c = null;
            this.f15456d = "";
            this.f15453a = jSONObject.optString("title", "");
            this.f15454b = jSONObject.optInt("type", 0);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                this.f15455c = new String[jSONArrayOptJSONArray.length()];
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    this.f15455c[i2] = jSONArrayOptJSONArray.optString(i2);
                }
            }
            this.f15456d = jSONObject.optString("id", "");
        }
    }

    String a();

    String b();

    long c();

    int d();

    String e();

    int f();

    String g();

    String h();

    f[] i();

    f j();

    f k();

    b l();

    c[] m();

    a n();
}
