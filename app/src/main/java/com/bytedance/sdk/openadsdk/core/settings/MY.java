package com.bytedance.sdk.openadsdk.core.settings;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public boolean AXM;
    public int Bc;
    public int Cc;
    public int DmF;
    public int EO;
    public int EV;
    public String IlO;
    public int MY;
    public int NV;
    public int OOq;
    public JSONObject YA;
    public int bWL;
    public int cL;
    public int cl;
    public boolean dY;
    public int ea;
    public int es;
    public int hp;
    public int kBB;
    public int lEW;
    public int lMM;
    public int nvX;
    public boolean oc;
    public int oeT;
    public int pP;
    public int rp;
    public int tV;
    public int tl;
    public List<String> vAh;
    public int vCE;
    public boolean vSq;
    public int wPn;
    public int xF;
    public int zPa;

    public MY(JSONObject jSONObject) {
        this.MY = 1;
        this.EO = 1;
        this.tV = 2;
        this.Cc = 1;
        this.vCE = 100;
        this.Bc = 0;
        this.lEW = 2;
        this.DmF = 1;
        this.NV = 3;
        this.EV = 30;
        this.rp = 30;
        this.hp = 1;
        this.bWL = 1;
        this.ea = 2;
        this.zPa = 1500;
        this.cl = 2;
        this.cL = 3500;
        this.es = 0;
        this.xF = 5;
        this.AXM = false;
        this.oeT = 0;
        this.kBB = 2;
        this.pP = -1;
        this.tl = 0;
        this.OOq = 0;
        this.wPn = 5;
        this.oc = true;
        this.vSq = false;
        this.dY = false;
        this.lMM = 0;
        this.nvX = -1;
        new JSONObject();
        this.YA = jSONObject;
        if (jSONObject == null) {
            return;
        }
        this.IlO = jSONObject.optString("code_id");
        this.MY = jSONObject.optInt("auto_play", 1);
        this.nvX = jSONObject.optInt("endcard_close_time", -1);
        this.EO = jSONObject.optInt("voice_control", 1);
        this.tV = jSONObject.optInt("rv_preload", 2);
        this.Cc = jSONObject.optInt("nv_preload", 1);
        this.vCE = Math.min(100, Math.max(0, jSONObject.optInt("proportion_watching", 100)));
        this.Bc = jSONObject.optInt("skip_time_displayed", 0);
        this.lEW = jSONObject.optInt("video_skip_result", 2);
        this.DmF = jSONObject.optInt("reg_creative_control", 1);
        this.NV = jSONObject.optInt("play_bar_show_time", 3);
        int iOptInt = jSONObject.optInt("rv_skip_time", 30);
        this.EV = iOptInt;
        if (iOptInt < 0) {
            this.EV = 30;
        }
        this.hp = jSONObject.optInt("voice_control", 2);
        this.bWL = jSONObject.optInt("if_show_win", 1);
        this.ea = jSONObject.optInt("sp_preload", 2);
        this.zPa = jSONObject.optInt("stop_time", 1500);
        this.cl = jSONObject.optInt("native_playable_delay", 2);
        this.cL = jSONObject.optInt("time_out_control", -1);
        this.pP = jSONObject.optInt("playable_close_time", -1);
        this.es = jSONObject.optInt("playable_reward_type", 0);
        this.oeT = jSONObject.optInt("reward_is_callback", 0);
        int iOptInt2 = jSONObject.optInt("iv_skip_time", 5);
        this.xF = iOptInt2;
        if (iOptInt2 < 0) {
            this.xF = 5;
        }
        IlO(jSONObject.optJSONArray("parent_tpl_ids"));
        this.kBB = jSONObject.optInt("slot_type", 2);
        this.AXM = jSONObject.optBoolean("close_on_click", false);
        this.tl = jSONObject.optInt("allow_system_back", 0);
        this.OOq = jSONObject.optInt("splash_skip_time", 0);
        this.wPn = jSONObject.optInt("splash_image_count_down_time", 5);
        this.vSq = jSONObject.optBoolean("splash_count_down_time_off", false);
        this.dY = jSONObject.optBoolean("splash_close_on_click", false);
        int iOptInt3 = jSONObject.optInt("splash_load_strategy", 0);
        this.lMM = iOptInt3;
        if (iOptInt3 < 0 || iOptInt3 > 1) {
            this.lMM = 0;
        }
        this.oc = jSONObject.optBoolean("allow_mediaview_click", true);
        if (!IlO(this.EO)) {
            this.EO = 1;
        }
        if (!IlO(this.hp)) {
            this.hp = 1;
        }
        this.rp = jSONObject.optInt("multi_rv_skip_time", 30);
    }

    private static boolean IlO(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public void IlO(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        this.vAh = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                this.vAh.add(jSONArray.get(i2).toString());
            } catch (Exception unused) {
                return;
            }
        }
    }

    public MY(String str, int i2) {
        this.MY = 1;
        this.EO = 1;
        this.tV = 2;
        this.Cc = 1;
        this.vCE = 100;
        this.Bc = 0;
        this.lEW = 2;
        this.DmF = 1;
        this.NV = 3;
        this.EV = 30;
        this.rp = 30;
        this.hp = 1;
        this.bWL = 1;
        this.ea = 2;
        this.zPa = 1500;
        this.cl = 2;
        this.cL = 3500;
        this.es = 0;
        this.xF = 5;
        this.AXM = false;
        this.oeT = 0;
        this.kBB = 2;
        this.pP = -1;
        this.tl = 0;
        this.OOq = 0;
        this.wPn = 5;
        this.oc = true;
        this.vSq = false;
        this.dY = false;
        this.lMM = 0;
        this.nvX = -1;
        this.YA = new JSONObject();
        this.IlO = str;
        this.EO = i2;
    }
}
