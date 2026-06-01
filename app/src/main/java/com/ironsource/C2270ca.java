package com.ironsource;

import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.ca, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class C2270ca {
    public static final String m = "age";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f8129n = "gen";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f8130o = "lvl";
    public static final String p = "pay";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f8131q = "iapt";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f8132r = "ucd";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f8133s = "segName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8134a;
    private String g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8135b = 999999;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f8136c = 999999.99d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8137d = NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM;
    private final int e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8138f = -1;
    private int h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicBoolean f8139i = null;
    private double j = -1.0d;
    private long k = 0;
    private ArrayList<Pair<String, String>> l = new ArrayList<>();

    @Deprecated
    public int a() {
        return this.f8138f;
    }

    @Deprecated
    public String b() {
        return this.g;
    }

    public double c() {
        return this.j;
    }

    public AtomicBoolean d() {
        return this.f8139i;
    }

    public int e() {
        return this.h;
    }

    public ArrayList<Pair<String, String>> f() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        if (this.f8138f != -1) {
            arrayList.add(new Pair<>(m, a1.a.q(new StringBuilder(), "", this.f8138f)));
        }
        if (!TextUtils.isEmpty(this.g)) {
            arrayList.add(new Pair<>(f8129n, this.g));
        }
        if (this.h != -1) {
            arrayList.add(new Pair<>("lvl", a1.a.q(new StringBuilder(), "", this.h)));
        }
        if (this.f8139i != null) {
            arrayList.add(new Pair<>("pay", this.f8139i + ""));
        }
        if (this.j != -1.0d) {
            arrayList.add(new Pair<>("iapt", this.j + ""));
        }
        if (this.k != 0) {
            arrayList.add(new Pair<>("ucd", a1.a.p(new StringBuilder(), this.k, "")));
        }
        if (!TextUtils.isEmpty(this.f8134a)) {
            arrayList.add(new Pair<>("segName", this.f8134a));
        }
        arrayList.addAll(this.l);
        return arrayList;
    }

    public String g() {
        return this.f8134a;
    }

    public long h() {
        return this.k;
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        ArrayList<Pair<String, String>> arrayListF = f();
        int size = arrayListF.size();
        int i2 = 0;
        while (i2 < size) {
            Pair<String, String> pair = arrayListF.get(i2);
            i2++;
            Pair<String, String> pair2 = pair;
            try {
                jSONObject.put((String) pair2.first, pair2.second);
            } catch (JSONException e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error("exception " + e.getMessage());
            }
        }
        return jSONObject;
    }

    private boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    public void a(int i2) {
        if (i2 > 0 && i2 < this.f8135b) {
            this.h = i2;
            return;
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder sbV = a1.a.v(i2, "setLevel( ", " ) level must be between 1-");
        sbV.append(this.f8135b);
        logger.log(ironSourceTag, sbV.toString(), 2);
    }

    public void a(boolean z2) {
        if (this.f8139i == null) {
            this.f8139i = new AtomicBoolean();
        }
        this.f8139i.set(z2);
    }

    public void a(double d8) {
        if (d8 > 0.0d && d8 < this.f8136c) {
            this.j = Math.floor(d8 * 100.0d) / 100.0d;
            return;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setIAPTotal( " + d8 + " ) iapt must be between 0-" + this.f8136c, 2);
    }

    public void a(long j) {
        if (j > 0) {
            this.k = j;
            return;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setUserCreationDate( " + j + " ) is an invalid timestamp", 2);
    }

    public void a(String str) {
        if (b(str) && a(str, 1, 32)) {
            this.f8134a = str;
        } else {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, a1.a.m("setSegmentName( ", str, " ) segment name must be alphanumeric and 1-32 in length"), 2);
        }
    }

    public void a(String str, String str2) {
        try {
            if (b(str) && b(str2) && a(str, 1, 32) && a(str2, 1, 32)) {
                String str3 = "custom_" + str;
                if (this.l.size() >= 5) {
                    this.l.remove(0);
                }
                this.l.add(new Pair<>(str3, str2));
                return;
            }
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "setCustom( " + str + " , " + str2 + " ) key and value must be alphanumeric and 1-32 in length", 2);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private boolean a(String str, int i2, int i8) {
        return str != null && str.length() >= i2 && str.length() <= i8;
    }
}
