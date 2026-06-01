package com.bytedance.sdk.openadsdk.cl;

import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.bWL;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class Cc implements tV {
    private int Cc;
    private int EO;
    long IlO = System.currentTimeMillis();
    private tV MY;
    private int tV;

    public Cc(tV tVVar, int i2, int i8, int i9) {
        this.MY = tVVar;
        this.EO = i2;
        this.tV = i8;
        this.Cc = i9;
    }

    @Override // com.bytedance.sdk.openadsdk.cl.tV
    public com.bytedance.sdk.openadsdk.cl.MY.IlO generatorModel() {
        com.bytedance.sdk.openadsdk.cl.MY.IlO ilOGeneratorModel = this.MY.generatorModel();
        ilOGeneratorModel.IlO(BuildConfig.VERSION_NAME);
        ilOGeneratorModel.IlO(this.EO);
        ilOGeneratorModel.MY(this.tV);
        ilOGeneratorModel.EO(this.Cc);
        ilOGeneratorModel.MY(this.IlO);
        ilOGeneratorModel.vCE(DmF.MY().Bc());
        ilOGeneratorModel.tV(bWL.tV());
        return ilOGeneratorModel;
    }
}
