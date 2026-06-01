package com.bytedance.adsdk.ugeno.tV.MY;

import com.bytedance.adsdk.ugeno.tV.vCE;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class IlO {
    public static final HashSet<String> IlO = new HashSet<>(Arrays.asList("convert", "dislike", "openAppPermission", "openAppPolicy", "openPrivacy", "openAppFunction", MRAIDPresenter.CLOSE, "skip", "videoControl", "pauseVideo", "resumeVideo", "muteVideo", "preventEvent"));
    protected String Bc;
    protected String Cc;
    protected com.bytedance.adsdk.ugeno.MY.EO EO;
    protected vCE.IlO MY;
    protected String tV;
    protected Map<String, String> vCE;

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.tV.MY.IlO$IlO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class C0035IlO {
        public static IlO IlO(com.bytedance.adsdk.ugeno.MY.EO eo, String str, vCE.IlO ilO) {
            if (ilO == null) {
                return null;
            }
            com.bytedance.adsdk.ugeno.tV.MY myIlO = com.bytedance.adsdk.ugeno.tV.tV.IlO(ilO.MY());
            if (myIlO == null) {
                return new EO(eo, str, ilO);
            }
            IlO IlO = myIlO.IlO(eo, str, ilO);
            return IlO == null ? new EO(eo, str, ilO) : IlO;
        }
    }

    public IlO(com.bytedance.adsdk.ugeno.MY.EO eo, String str, vCE.IlO ilO) {
        this.EO = eo;
        this.MY = ilO;
        this.Bc = str;
        MY();
    }

    private void MY() {
        vCE.IlO ilO = this.MY;
        if (ilO == null) {
            return;
        }
        this.tV = ilO.IlO();
        this.Cc = this.MY.MY();
        this.vCE = this.MY.EO();
    }

    public abstract void IlO();
}
