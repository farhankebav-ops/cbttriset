package com.bytedance.sdk.openadsdk.zPa;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.oeT;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements Comparable<IlO> {
    private int Bc;
    private int Cc;
    private int EO;
    private final String MY;
    private long bWL;
    private final ArrayList<Long> IlO = new ArrayList<>();
    private final ArrayList<Long> tV = new ArrayList<>();
    private final ArrayList<Long> vCE = new ArrayList<>();
    private final ArrayList<Long> lEW = new ArrayList<>();
    private final HashMap<String, MY> DmF = new HashMap<>();
    private int NV = 0;
    private int EV = 0;
    private final HashMap<String, MY> rp = new HashMap<>();
    private int hp = 0;
    private final ArrayList<String> ea = new ArrayList<>();

    public IlO(String str) {
        this.MY = str;
    }

    private void MY(@NonNull JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i2;
        int i8;
        int i9;
        int[] iArr;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        int[] iArrRp = com.bytedance.sdk.openadsdk.vCE.IlO.IlO().rp();
        if (iArrRp != null) {
            int i10 = 0;
            while (i10 < iArrRp.length) {
                int i11 = iArrRp[i10];
                long j = RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS;
                long j3 = jElapsedRealtime - (((long) i11) * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
                Iterator<String> it = this.rp.keySet().iterator();
                long j8 = 0;
                while (it.hasNext()) {
                    long j9 = j;
                    String next = it.next();
                    Iterator<String> it2 = it;
                    MY my = this.rp.get(next);
                    if (my != null) {
                        long jIlO = my.IlO(j3, jElapsedRealtime);
                        j8 += jIlO;
                        if (jIlO <= 0 && i10 == iArrRp.length - 1) {
                            hashSet.add(next);
                        }
                    }
                    it = it2;
                    j = j9;
                }
                if (j8 != 0) {
                    jSONObject.put("lp_stay_t_".concat(String.valueOf(i11)), j8);
                    iArr = iArrRp;
                    long jOptInt = ((long) jSONObject2.optInt("lp_stay_t_".concat(String.valueOf(i11)))) + j8;
                    if (jOptInt != 0) {
                        jSONObject2.put("lp_stay_t_".concat(String.valueOf(i11)), jOptInt);
                    }
                } else {
                    iArr = iArrRp;
                }
                i10++;
                iArrRp = iArr;
            }
        }
        int[] iArrHp = com.bytedance.sdk.openadsdk.vCE.IlO.IlO().hp();
        if (iArrHp != null) {
            int i12 = 0;
            while (i12 < iArrHp.length) {
                int i13 = iArrHp[i12];
                long j10 = jElapsedRealtime - (((long) i13) * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
                long j11 = 0;
                int i14 = 0;
                for (String str : this.DmF.keySet()) {
                    HashSet hashSet3 = hashSet;
                    int i15 = i13;
                    MY my2 = this.DmF.get(str);
                    if (my2 != null) {
                        long jIlO2 = my2.IlO(j10, jElapsedRealtime);
                        j11 += jIlO2;
                        if (jIlO2 > 20000) {
                            i14++;
                        }
                        if (jIlO2 <= 0 && i12 == iArrHp.length - 1) {
                            hashSet2.add(str);
                        }
                    }
                    i13 = i15;
                    hashSet = hashSet3;
                }
                HashSet hashSet4 = hashSet;
                int i16 = i13;
                if (j11 != 0) {
                    jSONObject.put("v_stay_t_".concat(String.valueOf(i16)), j11);
                    long jOptInt2 = ((long) jSONObject2.optInt("v_stay_t_".concat(String.valueOf(i16)))) + j11;
                    if (jOptInt2 != 0) {
                        jSONObject2.put("v_stay_t_".concat(String.valueOf(i16)), jOptInt2);
                    }
                }
                if (i14 != 0) {
                    jSONObject.put("v_20s_play_c_".concat(String.valueOf(i16)), i14);
                    int iOptInt = jSONObject2.optInt("v_20s_play_c_".concat(String.valueOf(i16))) + i14;
                    if (iOptInt != 0) {
                        jSONObject2.put("v_20s_play_c_".concat(String.valueOf(i16)), iOptInt);
                    }
                }
                i12++;
                hashSet = hashSet4;
            }
        }
        HashSet hashSet5 = hashSet;
        if (!hashSet5.isEmpty()) {
            Iterator it3 = hashSet5.iterator();
            while (it3.hasNext()) {
                this.rp.remove((String) it3.next());
            }
        }
        if (!hashSet2.isEmpty()) {
            Iterator it4 = hashSet2.iterator();
            while (it4.hasNext()) {
                this.DmF.remove((String) it4.next());
            }
        }
        if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().ea() && (i9 = this.NV) != 0) {
            jSONObject.put("v_stay_t_s", i9);
            int iOptInt2 = jSONObject2.optInt("v_stay_t_s") + this.NV;
            if (iOptInt2 != 0) {
                jSONObject2.put("v_stay_t_s", iOptInt2);
            }
        }
        if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().bWL() && (i8 = this.hp) != 0) {
            jSONObject.put("lp_stay_t_s", i8);
            int iOptInt3 = jSONObject2.optInt("lp_stay_t_s") + this.hp;
            if (iOptInt3 != 0) {
                jSONObject2.put("lp_stay_t_s", iOptInt3);
            }
        }
        if (!com.bytedance.sdk.openadsdk.vCE.IlO.IlO().cl() || (i2 = this.EV) == 0) {
            return;
        }
        jSONObject.put("v_30p_play_c_s", i2);
        int iOptInt4 = jSONObject2.optInt("v_30p_play_c_s") + this.EV;
        if (iOptInt4 != 0) {
            jSONObject2.put("v_30p_play_c_s", iOptInt4);
        }
    }

    public void IlO(@NonNull String str, @Nullable String str2) {
        MY my;
        MY my2;
        MY my3;
        MY my4;
        MY my5;
        MY my6;
        str.getClass();
        switch (str) {
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (my = this.rp.get(str2)) != null) {
                    my.tV(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (my2 = this.rp.get(str2)) != null) {
                    my2.EO(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2) && this.rp.get(str2) == null) {
                    MY my7 = new MY();
                    this.rp.put(str2, my7);
                    my7.IlO(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
            case "videoForceBreak":
            case "play_error":
                if (!TextUtils.isEmpty(str2) && (my3 = this.DmF.get(str2)) != null && my3.IlO() != MY.Cc) {
                    my3.MY(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().ea()) {
                        this.NV = (int) (my3.IlO(this.bWL, SystemClock.elapsedRealtime()) + ((long) this.NV));
                    }
                    break;
                }
                break;
            case "feed_play":
                this.vCE.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().lEW()) {
                    this.Bc++;
                }
                if (!TextUtils.isEmpty(str2) && this.DmF.get(str2) == null) {
                    MY my8 = new MY();
                    this.DmF.put(str2, my8);
                    my8.IlO(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "show":
                this.IlO.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().vCE()) {
                    this.EO++;
                    break;
                }
                break;
            case "click":
                if (!this.ea.contains(str2)) {
                    if (this.ea.size() > 50) {
                        this.ea.subList(0, 25).clear();
                    }
                    this.ea.add(str2);
                    this.tV.add(Long.valueOf(SystemClock.elapsedRealtime()));
                    if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().Bc()) {
                        this.Cc++;
                    }
                    break;
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (my4 = this.DmF.get(str2)) != null) {
                    my4.tV(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (my5 = this.DmF.get(str2)) != null) {
                    my5.EO(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (my6 = this.rp.get(str2)) != null && my6.IlO() != MY.Cc) {
                    my6.MY(SystemClock.elapsedRealtime());
                    if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().bWL()) {
                        this.hp = (int) (my6.IlO(this.bWL, SystemClock.elapsedRealtime()) + ((long) this.hp));
                    }
                    break;
                }
                break;
            case "videoPercent30":
                if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().cl()) {
                    this.EV++;
                    break;
                }
                break;
            case "dislike":
                this.lEW.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
        }
    }

    public JSONObject IlO(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            IlO(jSONObject2, jSONObject);
            MY(jSONObject2, jSONObject);
            return jSONObject2;
        } catch (Throwable th) {
            oeT.EO(th.getMessage(), new Object[0]);
            return jSONObject2;
        }
    }

    public String MY() {
        return this.MY;
    }

    private void IlO(String str, JSONObject jSONObject, ArrayList<Long> arrayList, int[] iArr, long j, JSONObject jSONObject2) throws JSONException {
        int size = arrayList.size() - 1;
        int i2 = 0;
        for (int i8 : iArr) {
            long j3 = j - (((long) i8) * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
            while (size >= 0 && arrayList.get(size).longValue() >= j3) {
                i2++;
                size--;
            }
            if (i2 != 0) {
                jSONObject.put(str + i8, i2);
                int iOptInt = jSONObject2.optInt(str + i8) + i2;
                if (iOptInt != 0) {
                    jSONObject2.put(str + i8, iOptInt);
                }
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void IlO(@NonNull JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        int i2;
        int i8;
        int i9;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        IlO("show_c_", jSONObject, this.IlO, com.bytedance.sdk.openadsdk.vCE.IlO.IlO().DmF(), jElapsedRealtime, jSONObject2);
        IlO("click_c_", jSONObject, this.tV, com.bytedance.sdk.openadsdk.vCE.IlO.IlO().NV(), jElapsedRealtime, jSONObject2);
        IlO("v_play_c_", jSONObject, this.vCE, com.bytedance.sdk.openadsdk.vCE.IlO.IlO().EV(), jElapsedRealtime, jSONObject2);
        IlO("dislike_c_", jSONObject, this.lEW, com.bytedance.sdk.openadsdk.vCE.IlO.IlO().zPa(), jElapsedRealtime, jSONObject2);
        if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().vCE() && (i9 = this.EO) != 0) {
            jSONObject.put("show_c_s", i9);
            int iOptInt = jSONObject2.optInt("show_c_s") + this.EO;
            if (iOptInt != 0) {
                jSONObject2.put("show_c_s", iOptInt);
            }
        }
        if (com.bytedance.sdk.openadsdk.vCE.IlO.IlO().Bc() && (i8 = this.Cc) != 0) {
            jSONObject.put("click_c_s", i8);
            int iOptInt2 = jSONObject2.optInt("click_c_s") + this.Cc;
            if (iOptInt2 != 0) {
                jSONObject2.put("click_c_s", iOptInt2);
            }
        }
        if (!com.bytedance.sdk.openadsdk.vCE.IlO.IlO().lEW() || (i2 = this.Bc) == 0) {
            return;
        }
        jSONObject.put("v_play_c_s", i2);
        int iOptInt3 = jSONObject2.optInt("v_play_c_s") + this.Bc;
        if (iOptInt3 != 0) {
            jSONObject2.put("v_play_c_s", iOptInt3);
        }
    }

    public void IlO() {
        this.bWL = SystemClock.elapsedRealtime();
        this.EV = 0;
        this.Cc = 0;
        this.EO = 0;
        this.hp = 0;
        this.NV = 0;
        this.Bc = 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public int compareTo(IlO ilO) {
        return ilO.EO - this.EO;
    }
}
