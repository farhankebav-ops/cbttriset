package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Pb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7387a;

    public Pb(String str) {
        this.f7387a = str;
    }

    private C8 a() throws Exception {
        C8 c8 = new C8(this.f7387a, "metadata.json");
        if (!c8.exists()) {
            a(c8);
        }
        return c8;
    }

    public synchronized JSONObject b() throws Exception {
        return new JSONObject(IronSourceStorageUtils.readFile(a()));
    }

    private void a(C8 c8) throws Exception {
        IronSourceStorageUtils.saveFile(new JSONObject().toString().getBytes(), c8.getPath());
    }

    public synchronized boolean b(String str, JSONObject jSONObject) throws Exception {
        JSONObject jSONObjectB;
        try {
            jSONObjectB = b();
            JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectOptJSONObject.putOpt(next, jSONObject.opt(next));
                }
            } else {
                jSONObjectB.putOpt(str, jSONObject);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a(jSONObjectB);
    }

    private boolean a(JSONObject jSONObject) throws Exception {
        return IronSourceStorageUtils.saveFile(jSONObject.toString().getBytes(), a().getPath()) != 0;
    }

    public synchronized boolean a(String str, JSONObject jSONObject) throws Exception {
        JSONObject jSONObjectB;
        jSONObjectB = b();
        jSONObjectB.put(str, jSONObject);
        return a(jSONObjectB);
    }

    public synchronized boolean a(String str) throws Exception {
        JSONObject jSONObjectB = b();
        if (!jSONObjectB.has(str)) {
            return true;
        }
        jSONObjectB.remove(str);
        return a(jSONObjectB);
    }

    public boolean a(ArrayList<C8> arrayList) throws Exception {
        int size = arrayList.size();
        boolean z2 = true;
        int i2 = 0;
        while (i2 < size) {
            C8 c8 = arrayList.get(i2);
            i2++;
            if (!a(c8.getName())) {
                z2 = false;
            }
        }
        return z2;
    }
}
