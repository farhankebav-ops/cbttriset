package com.bykv.vk.openvk.IlO.IlO.IlO.EO;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f4688d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4689f;
    public String g;
    public String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4690i;
    public String j;
    public int k;
    public int l;
    public int m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4691n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4692o = 0;
    public int p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4693q = 307200;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4694r = 1;

    public final String a() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = s.a.a(this.g);
        }
        return this.j;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", this.f4685a);
            jSONObject.put("cover_url", this.f4689f);
            jSONObject.put("cover_width", this.f4686b);
            jSONObject.put("endcard", this.h);
            jSONObject.put("file_hash", a());
            jSONObject.put("resolution", this.e);
            jSONObject.put("size", this.f4687c);
            jSONObject.put("video_duration", this.f4688d);
            jSONObject.put("video_url", this.g);
            jSONObject.put("playable_download_url", this.f4690i);
            jSONObject.put("if_playable_loading_show", this.m);
            jSONObject.put("remove_loading_page_type", this.f4691n);
            jSONObject.put("fallback_endcard_judge", this.k);
            jSONObject.put("video_preload_size", c());
            jSONObject.put("reward_video_cached_type", this.f4692o);
            jSONObject.put("execute_cached_type", this.p);
            jSONObject.put("endcard_render", this.l);
            jSONObject.put("replay_time", this.f4694r);
            jSONObject.put("play_speed_ratio", -1.0f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public final int c() {
        if (this.f4693q < 0) {
            this.f4693q = 307200;
        }
        long j = this.f4693q;
        long j3 = this.f4687c;
        if (j > j3) {
            this.f4693q = (int) j3;
        }
        return this.f4693q;
    }
}
