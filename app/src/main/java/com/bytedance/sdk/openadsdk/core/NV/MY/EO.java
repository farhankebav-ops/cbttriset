package com.bytedance.sdk.openadsdk.core.NV.MY;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends com.bytedance.adsdk.ugeno.DmF.EO.IlO {
    public EO(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.DmF.EO.IlO
    public String Bc(String str) {
        str.getClass();
        switch (str) {
            case "unmuted":
                return "tt_reward_full_unmute";
            case "feedback":
                return "tt_reward_full_feedback";
            case "right_arrow":
                return "tt_skip_btn";
            case "logo":
                return "tt_ad_logo";
            case "close":
                return "tt_close_btn";
            case "muted":
                return "tt_reward_full_mute";
            default:
                return null;
        }
    }
}
