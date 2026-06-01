package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2611w implements InterfaceC2365hf<JSONObject>, InterfaceC2329ff<C2577u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, G0> f10464a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10465b;

    /* JADX INFO: renamed from: com.ironsource.w$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10466a;

        static {
            int[] iArr = new int[EnumC2311ef.values().length];
            try {
                iArr[EnumC2311ef.LoadRequest.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC2311ef.LoadSuccess.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC2311ef.ShowSuccess.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC2311ef.ShowFailed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC2311ef.Destroyed.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f10466a = iArr;
        }
    }

    private final void b(C2577u c2577u) {
        int i2;
        int i8 = a.f10466a[c2577u.f().ordinal()];
        if (i8 == 2) {
            this.f10465b++;
        } else if ((i8 == 3 || i8 == 4 || i8 == 5) && (i2 = this.f10465b) > 0) {
            this.f10465b = i2 - 1;
        }
    }

    public final int a() {
        return this.f10465b;
    }

    @Override // com.ironsource.InterfaceC2329ff
    public void a(C2577u record) {
        kotlin.jvm.internal.k.e(record, "record");
        String strC = record.c();
        Map<String, G0> map = this.f10464a;
        G0 g0 = map.get(strC);
        if (g0 == null) {
            g0 = new G0();
            map.put(strC, g0);
        }
        g0.a(record.a(new C2594v()));
        b(record);
    }

    @Override // com.ironsource.InterfaceC2357h7
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(EnumC2347gf mode) throws JSONException {
        kotlin.jvm.internal.k.e(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, G0> entry : this.f10464a.entrySet()) {
            String key = entry.getKey();
            JSONObject jSONObjectA = entry.getValue().a(mode);
            if (jSONObjectA.length() > 0) {
                jSONObject.put(key, jSONObjectA);
            }
        }
        return jSONObject;
    }

    public final boolean b() {
        return !this.f10464a.isEmpty();
    }
}
