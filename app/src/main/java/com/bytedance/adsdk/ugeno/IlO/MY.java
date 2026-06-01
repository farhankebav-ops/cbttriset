package com.bytedance.adsdk.ugeno.IlO;

import a1.a;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private String Bc;
    private long Cc;
    private int EO;
    private Map<String, TreeMap<Float, String>> IlO;
    private long MY;
    private JSONObject lEW;
    private String tV;
    private IlO vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public String IlO;
        public String MY;
    }

    public IlO Bc() {
        return this.vCE;
    }

    public String Cc() {
        return this.tV;
    }

    public long EO() {
        return this.MY;
    }

    public JSONObject IlO() {
        return this.lEW;
    }

    public Map<String, TreeMap<Float, String>> MY() {
        return this.IlO;
    }

    public String lEW() {
        return this.Bc;
    }

    public int tV() {
        return this.EO;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AnimationModel{mKeyFramesMap=");
        sb.append(this.IlO);
        sb.append(", mDuration=");
        sb.append(this.MY);
        sb.append(", mPlayCount=");
        sb.append(this.EO);
        sb.append(", mPlayDirection=");
        sb.append(this.tV);
        sb.append(", mDelay=");
        sb.append(this.Cc);
        sb.append(", mTransformOrigin='");
        sb.append(this.vCE);
        sb.append("', mTimingFunction='");
        return a.r(sb, this.Bc, "'}");
    }

    public long vCE() {
        return this.Cc;
    }

    public void IlO(JSONObject jSONObject) {
        this.lEW = jSONObject;
    }

    public void MY(long j) {
        this.Cc = j;
    }

    public void IlO(Map<String, TreeMap<Float, String>> map) {
        this.IlO = map;
    }

    public void MY(String str) {
        this.Bc = str;
    }

    public void IlO(long j) {
        this.MY = j;
    }

    public void IlO(int i2) {
        this.EO = i2;
    }

    public void IlO(String str) {
        this.tV = str;
    }

    public void IlO(IlO ilO) {
        this.vCE = ilO;
    }
}
