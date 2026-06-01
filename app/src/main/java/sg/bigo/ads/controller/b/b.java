package sg.bigo.ads.controller.b;

import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.a.l;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements sg.bigo.ads.api.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public h f16392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f16393b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private Map<Integer, Map<Integer, a>> f16394c = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f16395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f16398d;
        int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f16399f;
        int g;
    }

    private a a(l lVar) {
        int iB;
        Map<Integer, a> map;
        if (lVar == null) {
            return null;
        }
        int iV = lVar.v();
        if (iV == 0) {
            iV = 1;
        }
        if (iV == 3 || (iB = lVar.b()) == 2 || (map = this.f16394c.get(Integer.valueOf(iV))) == null) {
            return null;
        }
        return map.get(Integer.valueOf(iB));
    }

    private a k(String str) {
        h hVar;
        if (TextUtils.isEmpty(str) || (hVar = this.f16392a) == null) {
            return null;
        }
        return a(hVar.a(str));
    }

    @Override // sg.bigo.ads.common.f
    public final void b(@NonNull Parcel parcel) {
        a(parcel.readString());
    }

    @Override // sg.bigo.ads.api.a.b
    public final boolean c(String str) {
        h hVar;
        l lVarA;
        int iB;
        if (TextUtils.isEmpty(str) || (hVar = this.f16392a) == null || (lVarA = hVar.a(str)) == null) {
            return false;
        }
        int iV = lVarA.v();
        if (iV == 0) {
            iV = 1;
        }
        return (iV == 3 || (iB = lVarA.b()) == 2 || iB == 12) ? false : true;
    }

    @Override // sg.bigo.ads.api.a.b
    public final String d(String str) {
        h hVar;
        l lVarA;
        if (TextUtils.isEmpty(str) || (hVar = this.f16392a) == null || (lVarA = hVar.a(str)) == null) {
            return null;
        }
        return String.valueOf(lVarA.b());
    }

    @Override // sg.bigo.ads.api.a.b
    public final long e(String str) {
        a aVarK = k(str);
        if (aVarK != null) {
            return aVarK.f16395a;
        }
        return 0L;
    }

    @Override // sg.bigo.ads.api.a.b
    public final int f(String str) {
        a aVarK = k(str);
        if (aVarK != null) {
            return aVarK.f16399f;
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.a.b
    public final int g(String str) {
        a aVarK = k(str);
        if (aVarK != null) {
            return aVarK.g;
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.a.b
    public final int h(String str) {
        a aVarK = k(str);
        if (aVarK != null) {
            return aVarK.f16396b;
        }
        return 0;
    }

    @Override // sg.bigo.ads.api.a.b
    public final boolean i(String str) {
        a aVarK = k(str);
        return aVarK != null && aVarK.f16397c == 1;
    }

    @Override // sg.bigo.ads.api.a.b
    public final long j(String str) {
        a aVarK = k(str);
        if (aVarK != null) {
            return aVarK.f16398d;
        }
        return 0L;
    }

    @Override // sg.bigo.ads.common.f
    public final void a(@NonNull Parcel parcel) {
        parcel.writeString(this.f16393b);
    }

    @Override // sg.bigo.ads.api.a.b
    public final boolean b(String str) {
        a aVarK = k(str);
        return aVarK != null && aVarK.e == 1;
    }

    @Override // sg.bigo.ads.api.a.b
    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.f16394c.isEmpty()) {
                return;
            }
            this.f16394c = new HashMap();
            return;
        }
        this.f16393b = str;
        try {
            JSONArray jSONArray = new JSONArray(str);
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    a aVar = new a();
                    aVar.f16395a = jSONObjectOptJSONObject.optLong("tmax", 15L);
                    aVar.f16396b = jSONObjectOptJSONObject.optInt("cache_num", 2);
                    aVar.f16397c = jSONObjectOptJSONObject.optInt("single_ad", 0);
                    aVar.f16398d = jSONObjectOptJSONObject.optLong("single_tmax", 15L);
                    aVar.e = jSONObjectOptJSONObject.optInt("tmax_switch", 0);
                    aVar.f16399f = jSONObjectOptJSONObject.optInt("tmax_strategy", 0);
                    aVar.g = jSONObjectOptJSONObject.optInt("assign_strategy", 0);
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("auc_type");
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("ad_type");
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null) {
                        for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                            int iOptInt = jSONArrayOptJSONArray.optInt(i8);
                            if (iOptInt == 0) {
                                iOptInt = 1;
                            }
                            Map map2 = (Map) map.get(Integer.valueOf(iOptInt));
                            if (map2 == null) {
                                map2 = new HashMap();
                                map.put(Integer.valueOf(iOptInt), map2);
                            }
                            for (int i9 = 0; i9 < jSONArrayOptJSONArray2.length(); i9++) {
                                int iOptInt2 = jSONArrayOptJSONArray2.optInt(i9);
                                if (((a) map2.get(Integer.valueOf(iOptInt2))) == null) {
                                    map2.put(Integer.valueOf(iOptInt2), aVar);
                                }
                            }
                        }
                    }
                }
            }
            this.f16394c = map;
        } catch (JSONException unused) {
        }
    }
}
