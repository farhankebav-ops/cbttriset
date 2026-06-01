package com.ironsource;

import android.text.TextUtils;
import com.ironsource.C2569t8;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Y4> f7892a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Y4> f7893b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Y4> f7894c = new LinkedHashMap();

    private Map<String, Y4> b(C2569t8.e eVar) {
        if (eVar.name().equalsIgnoreCase(C2569t8.e.RewardedVideo.name())) {
            return this.f7892a;
        }
        if (eVar.name().equalsIgnoreCase(C2569t8.e.Interstitial.name())) {
            return this.f7893b;
        }
        if (eVar.name().equalsIgnoreCase(C2569t8.e.Banner.name())) {
            return this.f7894c;
        }
        return null;
    }

    public Collection<Y4> a(C2569t8.e eVar) {
        Map<String, Y4> mapB = b(eVar);
        return mapB != null ? mapB.values() : new ArrayList();
    }

    public Y4 a(C2569t8.e eVar, String str) {
        Map<String, Y4> mapB;
        if (TextUtils.isEmpty(str) || (mapB = b(eVar)) == null) {
            return null;
        }
        return mapB.get(str);
    }

    private void a(C2569t8.e eVar, String str, Y4 y42) {
        Map<String, Y4> mapB;
        if (TextUtils.isEmpty(str) || y42 == null || (mapB = b(eVar)) == null) {
            return;
        }
        mapB.put(str, y42);
    }

    public void b(C2569t8.e eVar, String str) {
        Map<String, Y4> mapB;
        Y4 y4Remove;
        if (TextUtils.isEmpty(str) || (mapB = b(eVar)) == null || (y4Remove = mapB.remove(str)) == null) {
            return;
        }
        y4Remove.a();
    }

    public Y4 a(C2569t8.e eVar, M9 m9) {
        Y4 y42 = new Y4(m9);
        a(eVar, m9.e(), y42);
        return y42;
    }

    public Y4 a(C2569t8.e eVar, String str, Map<String, String> map, Ic ic) {
        Y4 y42 = new Y4(str, str, map, ic);
        a(eVar, str, y42);
        return y42;
    }
}
