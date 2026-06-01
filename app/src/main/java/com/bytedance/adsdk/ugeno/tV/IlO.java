package com.bytedance.adsdk.ugeno.tV;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements lEW {
    @Override // com.bytedance.adsdk.ugeno.tV.lEW
    public List<Bc> IlO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Bc("slide") { // from class: com.bytedance.adsdk.ugeno.tV.IlO.1
            @Override // com.bytedance.adsdk.ugeno.tV.Bc
            public com.bytedance.adsdk.ugeno.tV.tV.IlO IlO(Context context) {
                return new com.bytedance.adsdk.ugeno.tV.tV.EO(context);
            }
        });
        arrayList.add(new Bc("tap") { // from class: com.bytedance.adsdk.ugeno.tV.IlO.2
            @Override // com.bytedance.adsdk.ugeno.tV.Bc
            public com.bytedance.adsdk.ugeno.tV.tV.IlO IlO(Context context) {
                return new com.bytedance.adsdk.ugeno.tV.tV.Bc(context);
            }
        });
        arrayList.add(new Bc("timer") { // from class: com.bytedance.adsdk.ugeno.tV.IlO.3
            @Override // com.bytedance.adsdk.ugeno.tV.Bc
            public com.bytedance.adsdk.ugeno.tV.tV.IlO IlO(Context context) {
                return new com.bytedance.adsdk.ugeno.tV.tV.lEW(context);
            }
        });
        arrayList.add(new Bc("videoProgress") { // from class: com.bytedance.adsdk.ugeno.tV.IlO.4
            @Override // com.bytedance.adsdk.ugeno.tV.Bc
            public com.bytedance.adsdk.ugeno.tV.tV.IlO IlO(Context context) {
                return new com.bytedance.adsdk.ugeno.tV.tV.EV(context);
            }
        });
        arrayList.add(new Bc("touchStart") { // from class: com.bytedance.adsdk.ugeno.tV.IlO.5
            @Override // com.bytedance.adsdk.ugeno.tV.Bc
            public com.bytedance.adsdk.ugeno.tV.tV.IlO IlO(Context context) {
                return new com.bytedance.adsdk.ugeno.tV.tV.NV(context);
            }
        });
        arrayList.add(new Bc("touchEnd") { // from class: com.bytedance.adsdk.ugeno.tV.IlO.6
            @Override // com.bytedance.adsdk.ugeno.tV.Bc
            public com.bytedance.adsdk.ugeno.tV.tV.IlO IlO(Context context) {
                return new com.bytedance.adsdk.ugeno.tV.tV.DmF(context);
            }
        });
        return arrayList;
    }
}
