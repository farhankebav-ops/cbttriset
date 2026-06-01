package com.unity3d.mediation.segment;

import android.text.TextUtils;
import com.ironsource.C2531r4;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;
import q5.i;
import r5.n;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LevelPlaySegment {
    public static final a Companion = new a(null);
    public static final String IAPT = "iapt";
    public static final String LEVEL = "lvl";
    public static final String PAYING = "pay";
    public static final String SEGMENT_NAME = "segName";
    public static final String USER_CREATION_DATE = "ucd";
    private static final int h = 999999;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final double f10951i = 999999.99d;
    private static final int j = 5;
    private static final String k = "custom";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10955d;
    private long g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<i> f10952a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f10953b = new AtomicBoolean(false);
    private int e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f10956f = -1.0d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }
    }

    private final boolean a(String str) {
        if (str == null) {
            return false;
        }
        Pattern patternCompile = Pattern.compile("^[a-zA-Z0-9]*$");
        k.d(patternCompile, "compile(...)");
        return patternCompile.matcher(str).matches();
    }

    public final ArrayList<i> getCustoms$mediationsdk_release() {
        return this.f10952a;
    }

    public final double getIapTotal() {
        return this.f10956f;
    }

    public final int getLevel() {
        return this.e;
    }

    public final ArrayList<i> getSegmentData() {
        IronLog.API.info("");
        ArrayList<i> arrayList = new ArrayList<>();
        int i2 = this.e;
        if (i2 != -1) {
            arrayList.add(new i("lvl", String.valueOf(i2)));
        }
        if (this.f10954c) {
            arrayList.add(new i("pay", String.valueOf(isPaying())));
        }
        double d8 = this.f10956f;
        if (d8 != -1.0d) {
            arrayList.add(new i("iapt", String.valueOf(d8)));
        }
        long j3 = this.g;
        if (j3 != 0) {
            arrayList.add(new i("ucd", String.valueOf(j3)));
        }
        String str = this.f10955d;
        if (str != null && !TextUtils.isEmpty(str)) {
            arrayList.add(new i(SEGMENT_NAME, str));
        }
        ArrayList<i> arrayList2 = this.f10952a;
        ArrayList arrayList3 = new ArrayList(n.L0(arrayList2, 10));
        int size = arrayList2.size();
        int i8 = 0;
        while (i8 < size) {
            i iVar = arrayList2.get(i8);
            i8++;
            i iVar2 = iVar;
            arrayList3.add(new i("custom_" + iVar2.f13498a, iVar2.f13499b));
        }
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    public final String getSegmentName() {
        return this.f10955d;
    }

    public final long getUserCreationDate() {
        return this.g;
    }

    public final boolean isPaying() {
        return this.f10953b.get();
    }

    public final void setCustom(String key, String value) {
        k.e(key, "key");
        k.e(value, "value");
        IronLog.API.info("");
        try {
            if (a(key) && a(key, 1, 32) && a(value) && a(value, 1, 32)) {
                if (this.f10952a.size() >= 5) {
                    this.f10952a.remove(0);
                }
                this.f10952a.add(new i(key, value));
                return;
            }
            IronLog.INTERNAL.warning(key + ", " + value + " must be alphanumeric and 1-32 in length");
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public final void setIapTotal(double d8) {
        IronLog.API.info("");
        if (0.0d <= d8 && d8 <= f10951i) {
            double d9 = 100;
            this.f10956f = Math.floor(d8 * d9) / d9;
            return;
        }
        IronLog.INTERNAL.warning(d8 + " must be between 0-999999.99");
    }

    public final void setLevel(int i2) {
        IronLog.API.info("");
        if (1 <= i2 && i2 < 1000000) {
            this.e = i2;
            return;
        }
        IronLog.INTERNAL.warning(i2 + " must be between 1-999999");
    }

    public final void setPaying(boolean z2) {
        IronLog.API.info("");
        this.f10954c = true;
        this.f10953b.set(z2);
    }

    public final void setSegmentName(String str) {
        IronLog.API.info("");
        if (a(str) && a(str, 1, 32)) {
            this.f10955d = str;
            return;
        }
        IronLog.INTERNAL.warning(str + " must be alphanumeric and 1-32 in length");
    }

    public final void setUserCreationDate(long j3) {
        IronLog.API.info("");
        if (j3 > 0) {
            this.g = j3;
            return;
        }
        IronLog.INTERNAL.warning(j3 + " is an invalid timestamp");
    }

    public final JSONObject toJson() {
        IronLog.API.info("");
        JSONObject jSONObject = new JSONObject();
        ArrayList<i> segmentData = getSegmentData();
        int size = segmentData.size();
        int i2 = 0;
        while (i2 < size) {
            i iVar = segmentData.get(i2);
            i2++;
            i iVar2 = iVar;
            try {
                jSONObject.put((String) iVar2.f13498a, (String) iVar2.f13499b);
            } catch (JSONException e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error("exception " + e.getMessage());
            }
        }
        return jSONObject;
    }

    private final boolean a(String str, int i2, int i8) {
        return str != null && str.length() >= i2 && str.length() <= i8;
    }
}
