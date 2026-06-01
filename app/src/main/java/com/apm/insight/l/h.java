package com.apm.insight.l;

import com.ironsource.C2300e4;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Writer f4531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<a> f4532b = new ArrayList();

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4533a = new a("EMPTY_ARRAY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f4534b = new a("NONEMPTY_ARRAY", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f4535c = new a("EMPTY_OBJECT", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f4536d = new a("DANGLING_KEY", 3);
        public static final a e = new a("NONEMPTY_OBJECT", 4);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f4537f = new a("NULL", 5);

        private a(String str, int i2) {
        }
    }

    private h(Writer writer) {
        this.f4531a = writer;
    }

    private h a() throws JSONException, IOException {
        return a(a.f4533a, C2300e4.i.f8403d);
    }

    private h b() throws JSONException, IOException {
        a aVar = a.f4533a;
        return a(C2300e4.i.e);
    }

    private h c() throws JSONException, IOException {
        return a(a.f4535c, "{");
    }

    private h d() throws JSONException, IOException {
        a aVar = a.f4533a;
        return a("}");
    }

    private a e() throws JSONException {
        return this.f4532b.get(r0.size() - 1);
    }

    private void f() throws JSONException, IOException {
        if (this.f4532b.isEmpty()) {
            return;
        }
        a aVarE = e();
        if (aVarE == a.f4533a) {
            a(a.f4534b);
            return;
        }
        if (aVarE == a.f4534b) {
            this.f4531a.write(44);
        } else if (aVarE == a.f4536d) {
            this.f4531a.write(":");
            a(a.e);
        } else if (aVarE != a.f4537f) {
            throw new JSONException("Nesting problem");
        }
    }

    public final String toString() {
        return "";
    }

    private h a(a aVar, String str) throws JSONException, IOException {
        f();
        this.f4532b.add(aVar);
        this.f4531a.write(str);
        return this;
    }

    private void b(String str) throws IOException {
        this.f4531a.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\f') {
                this.f4531a.write("\\f");
            } else if (cCharAt != '\r') {
                if (cCharAt != '\"' && cCharAt != '/' && cCharAt != '\\') {
                    switch (cCharAt) {
                        case '\b':
                            this.f4531a.write("\\b");
                            continue;
                        case '\t':
                            this.f4531a.write("\\t");
                            continue;
                        case '\n':
                            this.f4531a.write("\\n");
                            continue;
                        default:
                            if (cCharAt <= 31) {
                                this.f4531a.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                            }
                            break;
                    }
                } else {
                    this.f4531a.write(92);
                }
                this.f4531a.write(cCharAt);
            } else {
                this.f4531a.write("\\r");
            }
        }
        this.f4531a.write("\"");
    }

    private h c(String str) throws JSONException, IOException {
        a aVarE = e();
        if (aVarE == a.e) {
            this.f4531a.write(44);
        } else if (aVarE != a.f4535c) {
            throw new JSONException("Nesting problem");
        }
        a(a.f4536d);
        b(str);
        return this;
    }

    private h a(String str) throws JSONException, IOException {
        e();
        this.f4532b.remove(r0.size() - 1);
        this.f4531a.write(str);
        return this;
    }

    private void a(a aVar) {
        this.f4532b.set(r0.size() - 1, aVar);
    }

    private h a(Object obj) throws JSONException, IOException {
        if (obj instanceof JSONArray) {
            a((JSONArray) obj);
            return this;
        }
        if (obj instanceof JSONObject) {
            a((JSONObject) obj);
            return this;
        }
        f();
        if (obj != null && obj != JSONObject.NULL) {
            if (obj instanceof Boolean) {
                this.f4531a.write(String.valueOf(obj));
                return this;
            }
            if (obj instanceof Number) {
                this.f4531a.write(JSONObject.numberToString((Number) obj));
                return this;
            }
            b(obj.toString());
            return this;
        }
        this.f4531a.write("null");
        return this;
    }

    public static void a(JSONObject jSONObject, Writer writer) throws Throwable {
        new h(writer).a(jSONObject);
        writer.flush();
    }

    public static void a(JSONArray jSONArray, Writer writer) throws Throwable {
        new h(writer).a(jSONArray);
        writer.flush();
    }

    private void a(JSONObject jSONObject) throws JSONException, IOException {
        c();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c(next).a(jSONObject.get(next));
        }
        d();
    }

    private void a(JSONArray jSONArray) throws JSONException, IOException {
        a();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(jSONArray.get(i2));
        }
        b();
    }
}
