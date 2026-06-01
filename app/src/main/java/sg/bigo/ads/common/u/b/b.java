package sg.bigo.ads.common.u.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.G5;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.common.u.a;
import sg.bigo.ads.common.u.f;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes6.dex */
public class b<T extends sg.bigo.ads.common.u.a> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f15962a = f.a("text/plain;charset=utf-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f15963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f15964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f15965d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15966f;
    public int g;
    public String h;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f15967o;

    public b(int i2, @NonNull T t3, Context context) {
        super(i2, t3, true, context);
    }

    @Override // sg.bigo.ads.common.u.b.c
    @NonNull
    public final String a() {
        return "POST";
    }

    @Override // sg.bigo.ads.common.u.b.c
    @Nullable
    public final f b() {
        f fVar = this.f15965d;
        return fVar != null ? fVar : f15962a;
    }

    @Override // sg.bigo.ads.common.u.b.c
    @Nullable
    public final byte[] c() {
        JSONObject jSONObject;
        if (this.f15964c == null && (jSONObject = this.f15963b) != null) {
            String string = jSONObject.toString();
            this.f15967o = string;
            try {
                if (this.e) {
                    String strA = sg.bigo.ads.common.j.a.a(string, "FEFFFFFFFFFAFFFDCBFFFFFFFFFFFF4F");
                    if (TextUtils.isEmpty(strA)) {
                        this.f15966f = false;
                    } else {
                        this.f15966f = true;
                        this.f15967o = strA;
                        a("enc", "1");
                    }
                }
            } catch (Exception unused) {
                this.f15966f = false;
            }
            try {
                this.f15964c = this.f15967o.getBytes(G5.N);
            } catch (UnsupportedEncodingException unused2) {
            }
        }
        return this.f15964c;
    }

    @Override // sg.bigo.ads.common.u.b.c
    @Nullable
    public final String d() {
        return e() >= 0 ? this.f15967o : "content is null.";
    }

    @Override // sg.bigo.ads.common.u.b.c
    public final int e() {
        byte[] bArrC = c();
        return bArrC != null ? bArrC.length : super.e();
    }

    @Override // sg.bigo.ads.common.u.b.c
    public final boolean f() {
        return this.f15966f;
    }

    public final void a(Map<String, Object> map) {
        if (this.f15963b == null || k.a(map)) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                this.f15963b.putOpt(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
        this.f15964c = null;
    }
}
