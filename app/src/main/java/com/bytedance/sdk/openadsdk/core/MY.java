package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.IlO.IlO.IlO.EO.c;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.EV.IlO.MY;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zLG;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public String IlO;
        public int MY;

        public IlO(String str, int i2) {
            this.IlO = str;
            this.MY = i2;
        }
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.xF Bc(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.xF xFVar = new com.bytedance.sdk.openadsdk.core.model.xF();
        if (jSONObject == null) {
            xFVar.IlO(10L);
            xFVar.MY(20L);
            xFVar.EO(10L);
            xFVar.tV(20L);
            xFVar.IlO("");
            return xFVar;
        }
        xFVar.IlO(jSONObject.optLong("onlylp_loading_maxtime", 10L));
        xFVar.MY(jSONObject.optLong("straight_lp_showtime", 20L));
        xFVar.EO(jSONObject.optLong("onlyagg_loading_maxtime", 10L));
        xFVar.tV(jSONObject.optLong("straight_agg_showtime", 20L));
        xFVar.IlO(jSONObject.optString("loading_text", ""));
        return xFVar;
    }

    private static FilterWord Cc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("options");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    FilterWord filterWordCc = Cc(jSONArrayOptJSONArray.optJSONObject(i2));
                    if (filterWordCc != null && filterWordCc.isValid()) {
                        filterWord.addOption(filterWordCc);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static com.bytedance.sdk.openadsdk.core.model.vCE DmF(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.vCE vce = new com.bytedance.sdk.openadsdk.core.model.vCE();
        if (jSONObject == null) {
            vce.EO(0);
            vce.tV(0);
            vce.MY(new ArrayList());
            vce.Cc(0);
            vce.IlO(new ArrayList());
            vce.MY(0);
            vce.IlO(0);
            return vce;
        }
        vce.EO(jSONObject.optInt("interceptor_x", 0));
        vce.tV(jSONObject.optInt("interceptor_y", 0));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("interceptor_page");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i2)));
            }
        }
        vce.MY(arrayList);
        vce.Cc(jSONObject.optInt("interceptor_interval_time", 0));
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("url_regular");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i8 = 0; i8 < jSONArrayOptJSONArray2.length(); i8++) {
                arrayList2.add(jSONArrayOptJSONArray2.optString(i8));
            }
        }
        vce.IlO(arrayList2);
        vce.MY(jSONObject.optInt("boc_index", 0));
        vce.IlO(jSONObject.optInt("is_act", 0));
        return vce;
    }

    private static com.bytedance.sdk.openadsdk.core.NV.Bc.IlO EO(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.NV.Bc.IlO ilO = new com.bytedance.sdk.openadsdk.core.NV.Bc.IlO();
        ilO.IlO(jSONObject.optString("id"));
        ilO.MY(jSONObject.optString("md5"));
        ilO.EO(jSONObject.optString("url"));
        return ilO;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.EV EV(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.EV ev = new com.bytedance.sdk.openadsdk.core.model.EV();
        ev.IlO(jSONObject.optString("deeplink_url"));
        ev.MY(jSONObject.optString("fallback_url"));
        ev.IlO(jSONObject.optInt("fallback_type"));
        return ev;
    }

    private static boolean IlO(int i2) {
        return i2 == 2 || i2 == 3 || i2 == 8;
    }

    public static AdSlot MY(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("mCodeId", "");
        int iOptInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int iOptInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        float fOptDouble = (float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
        float fOptDouble2 = (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
        int iOptInt3 = jSONObject.optInt("mAdCount", 6);
        boolean zOptBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String strOptString2 = jSONObject.optString("mRewardName", "");
        int iOptInt4 = jSONObject.optInt("mRewardAmount", 0);
        String strOptString3 = jSONObject.optString("mMediaExtra", "");
        String strOptString4 = jSONObject.optString("mUserID", "");
        jSONObject.optInt("mOrientation", 2);
        int iOptInt5 = jSONObject.optInt("mNativeAdType", 0);
        boolean zOptBoolean2 = jSONObject.optBoolean("mIsAutoPlay", false);
        boolean zOptBoolean3 = jSONObject.optBoolean("mIsExpressAd", false);
        String strOptString5 = jSONObject.optString("mBidAdm", "");
        return new AdSlot.Builder().setCodeId(strOptString).setImageAcceptedSize(iOptInt, iOptInt2).setExpressViewAcceptedSize(fOptDouble, fOptDouble2).setAdCount(iOptInt3).setSupportDeepLink(zOptBoolean).setRewardName(strOptString2).setRewardAmount(iOptInt4).setMediaExtra(strOptString3).setUserID(strOptString4).setNativeAdType(iOptInt5).setIsAutoPlay(zOptBoolean2).isExpressAd(zOptBoolean3).withBid(strOptString5).setDurationSlotType(jSONObject.optInt("mDurationSlotType", 0)).build();
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.rp NV(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.rp rpVar = new com.bytedance.sdk.openadsdk.core.model.rp();
        rpVar.IlO(jSONObject.optInt("if_send_click", 0));
        return rpVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.cl lEW(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.cl clVar = new com.bytedance.sdk.openadsdk.core.model.cl();
        if (jSONObject == null) {
            clVar.tV(5);
            clVar.Cc(30);
            clVar.vCE(70);
            clVar.Bc(1);
            clVar.lEW(com.bytedance.sdk.openadsdk.core.model.cl.IlO);
            clVar.EO(0);
            clVar.MY(0);
            clVar.IlO(3);
            return clVar;
        }
        clVar.tV(jSONObject.optInt("ceiling_time", 5));
        clVar.Cc(jSONObject.optInt("ceiling_ratio", 30));
        clVar.vCE(jSONObject.optInt("expand_ratio", 70));
        clVar.Bc(jSONObject.optInt("back_type", 1));
        clVar.lEW(jSONObject.optInt("boc_return_type", com.bytedance.sdk.openadsdk.core.model.cl.IlO));
        clVar.EO(jSONObject.optInt("pre_render_status", 0));
        clVar.MY(jSONObject.optInt("pre_render_use_gecko", 0));
        clVar.IlO(jSONObject.optInt("pre_render_add_type", 3));
        return clVar;
    }

    private static Map<String, Object> rp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private static com.bytedance.sdk.openadsdk.core.model.Cc tV(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("splash_clickarea", 2);
        int iOptInt2 = jSONObject.optInt("splash_layout_id", 1);
        long jOptLong = jSONObject.optLong("load_wait_time", 0L);
        long j = jOptLong >= 0 ? jOptLong : 0L;
        int iOptInt3 = jSONObject.optInt("skip_time", -1);
        com.bytedance.sdk.openadsdk.core.model.Cc cc = new com.bytedance.sdk.openadsdk.core.model.Cc();
        cc.MY(iOptInt);
        cc.EO(iOptInt2);
        cc.IlO(j);
        cc.IlO(iOptInt3);
        return cc;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.model.tV vCE(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.tV tVVar = new com.bytedance.sdk.openadsdk.core.model.tV();
        tVVar.MY(jSONObject.optString("app_name"));
        tVVar.EO(jSONObject.optString(C2300e4.h.V));
        tVVar.IlO(jSONObject.optString("download_url"));
        tVVar.IlO(jSONObject.optDouble(FirebaseAnalytics.Param.SCORE, -1.0d));
        tVVar.IlO(jSONObject.optInt("comment_num", -1));
        tVVar.MY(jSONObject.optInt("app_size", 0));
        tVVar.tV(jSONObject.optString("app_category"));
        return tVVar;
    }

    @Nullable
    public static Pair<com.bytedance.sdk.openadsdk.core.model.IlO, ArrayList<Integer>> IlO(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pP pPVar, com.bytedance.sdk.openadsdk.core.model.EO eo) {
        int i2;
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.model.IlO ilO = new com.bytedance.sdk.openadsdk.core.model.IlO();
            ilO.IlO(jSONObject.optString("request_id"));
            ilO.IlO(jSONObject.optInt("ret"));
            int i8 = 0;
            ilO.MY(jSONObject.optInt("multi_ad_style", 0));
            ilO.MY(jSONObject.optString("message"));
            String strOptString = jSONObject.optString("gdid_encrypted");
            if (jSONObject.has("choose_ui_data")) {
                ilO.MY(jSONObject.optJSONObject("choose_ui_data"));
                ilO.IlO(true);
            }
            ilO.IlO(com.bytedance.sdk.openadsdk.core.model.AXM.IlO(jSONObject.optJSONObject("loop_config")));
            String strOptString2 = jSONObject.optString("auction_price");
            if (ilO.EO() != 0) {
                return null;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                ArrayList arrayList2 = ilO.hp() ? new ArrayList() : null;
                int i9 = 0;
                while (i9 < jSONArrayOptJSONArray.length()) {
                    com.bytedance.sdk.openadsdk.core.model.oeT oetIlO = IlO(jSONArrayOptJSONArray.optJSONObject(i9), adSlot, pPVar);
                    if (oetIlO != null && ilO.hp()) {
                        if (oetIlO.vAh() == 30 || oetIlO.vAh() == 39 || oetIlO.vAh() == 40 || oetIlO.vAh() == 41) {
                            oetIlO.DmF(true);
                        } else {
                            ilO.MY(0);
                            arrayList2 = null;
                        }
                    }
                    int iIlO = IlO(oetIlO);
                    if (iIlO != 200) {
                        if (oetIlO != null) {
                            com.bytedance.sdk.openadsdk.tV.EO.MY(oetIlO, zLG.EO(oetIlO.fHv()), iIlO);
                        } else {
                            com.bytedance.sdk.openadsdk.tV.EO.MY((com.bytedance.sdk.openadsdk.core.model.oeT) null, "", iIlO);
                        }
                        arrayList.add(Integer.valueOf(iIlO));
                        if (arrayList2 != null && oetIlO != null) {
                            arrayList2.add(new IlO(oetIlO.Jm(), iIlO));
                        }
                        if (oetIlO == null || !(oetIlO.vAh() == 39 || oetIlO.vAh() == 41)) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                            ilO.MY(0);
                        }
                        jSONArrayOptJSONArray.remove(i9);
                        i9--;
                    } else {
                        i2 = 0;
                        oetIlO.DmF(strOptString2);
                        if (!TextUtils.isEmpty(strOptString)) {
                            oetIlO.tl(strOptString);
                        }
                        ilO.IlO(oetIlO);
                    }
                    i9++;
                    i8 = i2;
                }
                int i10 = i8;
                List<com.bytedance.sdk.openadsdk.core.model.oeT> listTV = ilO.tV();
                if (listTV != null) {
                    int size = listTV.size();
                    jSONObject.put("creatives", jSONArrayOptJSONArray);
                    for (int i11 = i10; i11 < size; i11++) {
                        com.bytedance.sdk.openadsdk.core.model.oeT oet = listTV.get(i11);
                        if (oet != null) {
                            oet.vSq(jSONObject.toString());
                        }
                    }
                }
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    IlO((ArrayList<IlO>) arrayList2);
                }
                i8 = length;
            }
            IlO(i8, ilO, (ArrayList<Integer>) arrayList, eo);
            return new Pair<>(ilO, arrayList);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.AdInfoFactory", th.getMessage());
            return null;
        }
    }

    private static int EO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        int iIlO;
        String strEO = zLG.EO(oet.fHv());
        if (oet.lQ() == 0) {
            iIlO = IlO(oet.zTS());
            if (iIlO != 200) {
                com.bytedance.sdk.openadsdk.tV.EO.EO(oet, strEO, iIlO);
                return iIlO;
            }
        } else {
            iIlO = 200;
        }
        int iJz = oet.Jz();
        if (iJz != 2 && iJz != 3) {
            if (iJz == 4) {
                int iIlO2 = IlO(oet.VH());
                if (iIlO2 != 200) {
                    com.bytedance.sdk.openadsdk.tV.EO.EO(oet, strEO, iIlO2);
                }
                return iIlO2;
            }
            if (iJz != 8) {
                return iIlO;
            }
        }
        if (!tV(oet) || !TextUtils.isEmpty(oet.pFe())) {
            return iIlO;
        }
        com.bytedance.sdk.openadsdk.tV.EO.EO(oet, strEO, 406);
        return 406;
    }

    private static boolean tV(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        return (oet.xJ() || oet.Os()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int MY(com.bytedance.sdk.openadsdk.core.model.oeT r8) {
        /*
            int r0 = r8.fHv()
            java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.zLG.EO(r0)
            int r1 = r8.lQ()
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != 0) goto L1c
            com.bytedance.sdk.openadsdk.core.model.EV r1 = r8.zTS()
            int r1 = IlO(r1)
            com.bytedance.sdk.openadsdk.tV.EO.EO(r8, r0, r1)
            goto L1d
        L1c:
            r1 = r2
        L1d:
            int r3 = r8.Jz()
            r4 = 2
            r5 = 406(0x196, float:5.69E-43)
            r6 = 417(0x1a1, float:5.84E-43)
            r7 = 407(0x197, float:5.7E-43)
            if (r3 == r4) goto L79
            r4 = 3
            if (r3 == r4) goto L79
            r4 = 4
            if (r3 == r4) goto L35
            r4 = 8
            if (r3 == r4) goto L79
            goto L8d
        L35:
            com.bytedance.sdk.openadsdk.core.model.tV r3 = r8.VH()
            if (r3 != 0) goto L40
            com.bytedance.sdk.openadsdk.tV.EO.EO(r8, r0, r7)
            r1 = r7
            goto L8d
        L40:
            java.lang.String r4 = r3.EO()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L59
            java.lang.String r4 = r3.IlO()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L59
            com.bytedance.sdk.openadsdk.tV.EO.EO(r8, r0, r6)
            r1 = r6
            goto L8d
        L59:
            java.lang.String r4 = r3.EO()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L69
            r1 = 416(0x1a0, float:5.83E-43)
            com.bytedance.sdk.openadsdk.tV.EO.EO(r8, r0, r1)
            goto L8d
        L69:
            java.lang.String r3 = r3.IlO()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L8d
            r1 = 408(0x198, float:5.72E-43)
            com.bytedance.sdk.openadsdk.tV.EO.EO(r8, r0, r1)
            goto L8d
        L79:
            boolean r3 = tV(r8)
            if (r3 == 0) goto L8d
            java.lang.String r3 = r8.pFe()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L8d
            com.bytedance.sdk.openadsdk.tV.EO.EO(r8, r0, r5)
            r1 = r5
        L8d:
            if (r1 == r6) goto L9a
            if (r1 == r7) goto L9a
            if (r1 != r5) goto L94
            goto L9a
        L94:
            if (r1 == r2) goto L99
            com.bytedance.sdk.openadsdk.tV.EO.MY(r8, r0, r1)
        L99:
            return r2
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.MY.MY(com.bytedance.sdk.openadsdk.core.model.oeT):int");
    }

    private static int IlO(c cVar, boolean z2) {
        if (cVar == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(cVar.g)) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (z2 || !TextUtils.isEmpty(cVar.f4689f)) {
            return 200;
        }
        return TTAdConstant.VIDEO_COVER_URL_CODE;
    }

    private static void IlO(int i2, final com.bytedance.sdk.openadsdk.core.model.IlO ilO, final ArrayList<Integer> arrayList, final com.bytedance.sdk.openadsdk.core.model.EO eo) {
        if (ilO == null || i2 < 2 || !ilO.lEW()) {
            return;
        }
        final int size = i2 - (ilO.tV() != null ? ilO.tV().size() : 0);
        final boolean z2 = ilO.DmF() == null;
        if (size > 0 || z2) {
            com.bytedance.sdk.openadsdk.ea.EO.IlO();
            com.bytedance.sdk.openadsdk.ea.EO.IlO("choose_ad_parsing_error", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.MY.1
                @Override // com.bytedance.sdk.openadsdk.ea.MY
                public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", ilO.MY());
                    jSONObject.put("material_error", size);
                    jSONObject.put("choose_ui_error", z2 ? 1 : 0);
                    ArrayList arrayList2 = arrayList;
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) arrayList).toString());
                    }
                    com.bytedance.sdk.openadsdk.core.model.EO eo2 = eo;
                    if (eo2 != null) {
                        jSONObject.put("server_res_str", eo2.IlO());
                    }
                    return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("choose_ad_parsing_error").MY(jSONObject.toString());
                }
            });
        }
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.model.oeT IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return IlO(jSONObject, (AdSlot) null, (com.bytedance.sdk.openadsdk.core.model.pP) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x0646 A[PHI: r0
  0x0646: PHI (r0v85 int) = (r0v84 int), (r0v134 int) binds: [B:148:0x0632, B:153:0x0643] A[DONT_GENERATE, DONT_INLINE]] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bytedance.sdk.openadsdk.core.model.oeT IlO(org.json.JSONObject r16, com.bytedance.sdk.openadsdk.AdSlot r17, com.bytedance.sdk.openadsdk.core.model.pP r18) {
        /*
            Method dump skipped, instruction units count: 1965
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.MY.IlO(org.json.JSONObject, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.core.model.pP):com.bytedance.sdk.openadsdk.core.model.oeT");
    }

    private static void IlO(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (jSONObject != null) {
            int iOptInt = jSONObject.optInt("iv_skip_time", -1);
            int iOptInt2 = jSONObject.optInt("rv_skip_time", -1);
            if (iOptInt != -1) {
                oet.IlO(iOptInt);
            }
            if (iOptInt2 != -1) {
                oet.MY(iOptInt2);
            }
        }
    }

    private static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason_code", -1);
            jSONObject.put("error_code", -1);
            com.bytedance.sdk.openadsdk.tV.EO.MY(oet, str, "load_vast_fail", jSONObject);
        } catch (Exception unused) {
        }
    }

    private static void IlO(final com.bytedance.sdk.openadsdk.core.model.oeT oet, final String str, final com.bytedance.sdk.openadsdk.core.EV.IlO ilO, final long j, final MY.IlO ilO2) {
        com.bytedance.sdk.openadsdk.tV.EO.IlO(new com.bytedance.sdk.component.lEW.lEW("vast_parser") { // from class: com.bytedance.sdk.openadsdk.core.MY.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    com.bytedance.sdk.openadsdk.core.EV.IlO ilO3 = ilO;
                    String str2 = "load_vast_fail";
                    if (ilO3 == null) {
                        jSONObject.put("reason_code", -2);
                        MY.IlO ilO4 = ilO2;
                        if (ilO4 != null) {
                            jSONObject.put("error_code", ilO4.IlO);
                        }
                    } else if (TextUtils.isEmpty(ilO3.DmF()) || TextUtils.isEmpty(ilO.vCE()) || ilO.lEW() <= 0.0d) {
                        jSONObject.put("reason_code", -3);
                        jSONObject.put("error_code", -3);
                    } else {
                        jSONObject.put("duration", System.currentTimeMillis() - j);
                        MY.IlO ilO5 = ilO2;
                        if (ilO5 != null) {
                            jSONObject.put("wrapper_count", ilO5.MY);
                            jSONObject.put("impression_links_null", ilO2.EO);
                        }
                        str2 = "load_vast_success";
                    }
                    com.bytedance.sdk.openadsdk.tV.EO.MY(oet, str, str2, jSONObject);
                    com.bytedance.sdk.openadsdk.core.EV.IlO ilO6 = ilO;
                    if (ilO6 == null || ilO6.MY() == null || !TextUtils.isEmpty(ilO.MY().vCE())) {
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("error_code", 1000);
                        jSONObject2.put("description", "1000:Image url is null");
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.tV.EO.MY(oet, str, "load_vast_icon_fail", jSONObject2);
                    ilO.IlO((com.bytedance.sdk.openadsdk.core.EV.MY) null);
                } catch (Exception unused2) {
                }
            }
        });
    }

    private static Pair<com.bytedance.sdk.openadsdk.core.EV.IlO, MY.IlO> IlO(String str, int i2, int i8) {
        int iEO;
        int iCc;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i8 == 1 || i8 == 5) {
            iEO = 0;
            iCc = 0;
        } else {
            iEO = BS.EO(cl.IlO());
            iCc = BS.Cc(cl.IlO());
            if (i2 == 2) {
                iCc = iEO;
                iEO = iCc;
            }
        }
        com.bytedance.sdk.openadsdk.core.EV.IlO.IlO.Cc cc = new com.bytedance.sdk.openadsdk.core.EV.IlO.IlO.Cc(cl.IlO(), iEO, iCc);
        return new Pair<>(cc.IlO(str, new ArrayList()), cc.vCE);
    }

    private static void IlO(com.bytedance.sdk.openadsdk.core.EV.IlO ilO, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        ilO.IlO(oet);
        if (!IlO(oet.Jz())) {
            oet.vAh(2);
        }
        oet.Bc(1);
        oet.IlO(ilO);
        if (!TextUtils.isEmpty(ilO.tV())) {
            oet.ea(ilO.tV());
        }
        if (!TextUtils.isEmpty(ilO.Cc())) {
            oet.zPa(ilO.Cc());
        }
        oet.hp(ilO.vCE());
        oet.IlO((com.bytedance.sdk.openadsdk.core.model.tV) null);
        c cVarFdM = oet.fdM();
        if (cVarFdM == null) {
            cVarFdM = new c();
        }
        cVarFdM.g = ilO.Bc();
        cVarFdM.f4688d = ilO.lEW();
        cVarFdM.j = null;
        cVarFdM.f4689f = null;
        cVarFdM.h = null;
        oet.IlO(cVarFdM);
        if (ilO.MY() != null && !TextUtils.isEmpty(ilO.MY().Cc())) {
            com.bytedance.sdk.openadsdk.core.model.zPa zpa = new com.bytedance.sdk.openadsdk.core.model.zPa();
            zpa.IlO(ilO.MY().Cc());
            zpa.IlO(ilO.MY().MY());
            zpa.MY(ilO.MY().EO());
            oet.IlO(zpa);
            return;
        }
        if (oet.HTA() == null) {
            com.bytedance.sdk.openadsdk.core.model.zPa zpa2 = new com.bytedance.sdk.openadsdk.core.model.zPa();
            zpa2.IlO("https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/static/images/2023620white.jpeg");
            zpa2.IlO(98);
            zpa2.MY(98);
            oet.IlO(zpa2);
        }
    }

    @Nullable
    private static c IlO(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.oeT oet, boolean z2) {
        int iOptInt;
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f4685a = jSONObject.optInt("cover_height");
        cVar.f4686b = jSONObject.optInt("cover_width");
        cVar.e = jSONObject.optString("resolution");
        cVar.f4687c = jSONObject.optLong("size");
        double dOptDouble = jSONObject.optDouble("video_duration", 0.0d);
        cVar.f4688d = dOptDouble;
        int iOptInt2 = jSONObject.optInt("replay_time", 1);
        if (dOptDouble > 15.0d || oet.oc() == 1 || !com.bytedance.sdk.openadsdk.core.model.oeT.Cc(oet)) {
            iOptInt2 = 1;
        }
        cVar.f4694r = Math.min(4, Math.max(1, iOptInt2));
        cVar.f4689f = jSONObject.optString("cover_url");
        cVar.g = jSONObject.optString("video_url");
        cVar.h = jSONObject.optString("endcard");
        cVar.f4690i = jSONObject.optString("playable_download_url");
        cVar.j = jSONObject.optString("file_hash");
        cVar.m = jSONObject.optInt("if_playable_loading_show", 0);
        cVar.f4691n = jSONObject.optInt("remove_loading_page_type", 0);
        cVar.k = jSONObject.optInt("fallback_endcard_judge", 0);
        cVar.f4693q = jSONObject.optInt("video_preload_size", 307200);
        cVar.f4692o = jSONObject.optInt("reward_video_cached_type", 0);
        cVar.p = jSONObject.optInt("execute_cached_type", 0);
        if (z2) {
            iOptInt = jSONObject.optInt("endcard_render", 0);
        } else {
            iOptInt = jSONObject.optInt("endcard_render", -1);
        }
        cVar.l = iOptInt;
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int IlO(com.bytedance.sdk.openadsdk.core.model.oeT r5) {
        /*
            r0 = 401(0x191, float:5.62E-43)
            r1 = 0
            if (r5 != 0) goto Lb
            java.lang.String r5 = ""
            com.bytedance.sdk.openadsdk.tV.EO.EO(r1, r5, r0)
            return r0
        Lb:
            int r2 = r5.fHv()
            java.lang.String r2 = com.bytedance.sdk.openadsdk.utils.zLG.EO(r2)
            java.lang.String r3 = r5.ED()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto Lbd
            java.lang.String r3 = r5.ED()
            int r3 = r3.length()
            r4 = 1
            if (r3 > r4) goto L2a
            goto Lbd
        L2a:
            boolean r3 = r5.Os()
            if (r3 == 0) goto L64
            int r3 = r5.fHv()
            if (r3 >= 0) goto L47
            com.bytedance.sdk.openadsdk.AdSlot r3 = r5.ssS()
            if (r3 == 0) goto L44
            com.bytedance.sdk.openadsdk.AdSlot r3 = r5.ssS()
            r3.getDurationSlotType()
            goto L47
        L44:
            r5.OyN()
        L47:
            boolean r3 = r5.pS()
            if (r3 == 0) goto L4f
            java.lang.String r2 = "fullscreen_interstitial_ad"
        L4f:
            java.lang.String r3 = r5.KS()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L5f
            java.lang.String r3 = "load_html_fail"
            com.bytedance.sdk.openadsdk.tV.EO.MY(r5, r2, r3, r1)
            return r0
        L5f:
            java.lang.String r0 = "load_html_success"
            com.bytedance.sdk.openadsdk.tV.EO.MY(r5, r2, r0, r1)
        L64:
            int r0 = r5.lQ()
            if (r0 != 0) goto La9
            int r0 = r5.uI()
            r1 = 2
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L9b
            r1 = 3
            if (r0 == r1) goto L9b
            r1 = 4
            if (r0 == r1) goto L9b
            r1 = 5
            if (r0 == r1) goto L89
            r1 = 15
            if (r0 == r1) goto L89
            r1 = 16
            if (r0 == r1) goto L9b
            r1 = 50
            if (r0 == r1) goto L89
            goto La9
        L89:
            com.bykv.vk.openvk.IlO.IlO.IlO.EO.c r0 = r5.fdM()
            boolean r1 = r5.xJ()
            int r0 = IlO(r0, r1)
            if (r0 == r3) goto La9
            com.bytedance.sdk.openadsdk.tV.EO.EO(r5, r2, r0)
            return r0
        L9b:
            java.util.List r0 = r5.Hg()
            int r0 = IlO(r0)
            if (r0 == r3) goto La9
            com.bytedance.sdk.openadsdk.tV.EO.EO(r5, r2, r0)
            return r0
        La9:
            com.bytedance.sdk.openadsdk.core.settings.vCE r0 = com.bytedance.sdk.openadsdk.core.settings.hp.aP()
            boolean r0 = r0.tf()
            if (r0 == 0) goto Lb8
            int r5 = EO(r5)
            return r5
        Lb8:
            int r5 = MY(r5)
            return r5
        Lbd:
            r0 = 402(0x192, float:5.63E-43)
            com.bytedance.sdk.openadsdk.tV.EO.EO(r5, r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.MY.IlO(com.bytedance.sdk.openadsdk.core.model.oeT):int");
    }

    private static int IlO(com.bytedance.sdk.openadsdk.core.model.EV ev) {
        if (ev == null) {
            return 200;
        }
        if (TextUtils.isEmpty(ev.IlO())) {
            return 403;
        }
        if (TextUtils.isEmpty(ev.MY())) {
            return 404;
        }
        return (ev.EO() == 1 || ev.EO() == 2) ? 200 : 405;
    }

    private static int IlO(com.bytedance.sdk.openadsdk.core.model.tV tVVar) {
        if (tVVar == null) {
            return 407;
        }
        if (TextUtils.isEmpty(tVVar.IlO())) {
            return 408;
        }
        return TextUtils.isEmpty(tVVar.EO()) ? 416 : 200;
    }

    private static int IlO(List<com.bytedance.sdk.openadsdk.core.model.zPa> list) {
        if (list == null) {
            return 409;
        }
        if (list.size() <= 0) {
            return 410;
        }
        for (com.bytedance.sdk.openadsdk.core.model.zPa zpa : list) {
            if (zpa == null) {
                return 411;
            }
            if (TextUtils.isEmpty(zpa.IlO())) {
                return TTAdConstant.IMAGE_URL_CODE;
            }
        }
        return 200;
    }

    private static void IlO(final ArrayList<IlO> arrayList) {
        com.bytedance.sdk.openadsdk.ea.EO.IlO("multiple_ads_parsing_error", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.MY.3
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            @Nullable
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("material_error", arrayList.size());
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    IlO ilO = (IlO) obj;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", ilO.IlO);
                    jSONObject2.put("error_msg", ilO.MY);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("error_cid_list", jSONArray);
                return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("multiple_ads_parsing_error").MY(jSONObject.toString());
            }
        });
    }
}
