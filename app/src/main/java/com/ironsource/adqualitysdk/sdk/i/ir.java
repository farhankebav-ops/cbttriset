package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ir {

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private long f2578;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f2579;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private c f2580;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private int f2581;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private String f2582;

        public c(int i2, String str) {
            this.f2581 = i2;
            this.f2582 = str;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public final int m2558() {
            return this.f2581;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public final String m2559() {
            return this.f2582;
        }
    }

    public ir(String str, int i2, String str2, long j) {
        this.f2579 = str;
        this.f2578 = j;
        this.f2580 = new c(i2, str2);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final long m2554() {
        return this.f2578;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final JSONObject m2555() throws JSONException {
        return !TextUtils.isEmpty(this.f2579) ? new JSONObject(this.f2579) : new JSONObject();
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m2556() {
        return this.f2579;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final c m2557() {
        return this.f2580;
    }
}
