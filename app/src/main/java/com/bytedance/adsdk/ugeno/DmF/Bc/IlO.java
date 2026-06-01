package com.bytedance.adsdk.ugeno.DmF.Bc;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO extends com.bytedance.adsdk.ugeno.MY.IlO<com.bytedance.adsdk.ugeno.DmF.MY.IlO> {
    public IlO(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.MY.EO
    public void IlO(String str, String str2) {
        super.IlO(str, str2);
        str.getClass();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                MY(str, str2);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.MY.IlO, com.bytedance.adsdk.ugeno.MY.EO
    public void MY() {
        super.MY();
    }
}
