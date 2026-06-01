package com.bytedance.sdk.component.adexpress.dynamic.tV;

import a1.a;
import android.text.TextUtils;
import com.ironsource.C2300e4;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    public static final Map<String, Integer> IlO;
    private vCE Cc;
    private String EO;
    private String MY;
    private vCE tV;
    private String vCE;

    static {
        HashMap map = new HashMap();
        IlO = map;
        map.put("root", 8);
        map.put("footer", 6);
        map.put("empty", 6);
        map.put("title", 0);
        map.put("subtitle", 0);
        map.put("source", 0);
        map.put("score-count", 0);
        map.put("text_star", 0);
        map.put(C2300e4.h.K0, 0);
        map.put("tag-group", 17);
        map.put("app-version", 0);
        map.put("development-name", 0);
        map.put("privacy-detail", 23);
        map.put("image", 1);
        map.put("image-wide", 1);
        map.put("image-square", 1);
        map.put("image-long", 1);
        map.put("image-splash", 1);
        map.put("image-cover", 1);
        map.put("app-icon", 1);
        map.put("icon-download", 1);
        map.put("logoad", 4);
        a0.j(5, map, "logounion", 9, "logo-union");
        map.put("dislike", 3);
        map.put(MRAIDPresenter.CLOSE, 3);
        map.put("close-fill", 3);
        a0.j(22, map, "webview-close", 12, "feedback-dislike");
        map.put("button", 2);
        map.put("downloadWithIcon", 2);
        map.put("downloadButton", 2);
        map.put("fillButton", 2);
        map.put("laceButton", 2);
        map.put("cardButton", 2);
        map.put("colourMixtureButton", 2);
        map.put("arrowButton", 1);
        map.put("download-progress-button", 2);
        map.put("vessel", 6);
        map.put("image-group", 6);
        map.put("custom-component-vessel", 6);
        map.put("carousel", 24);
        a0.j(26, map, "carousel-vessel", 25, "leisure-interact");
        map.put("video-hd", 7);
        map.put(MimeTypes.BASE_TYPE_VIDEO, 7);
        map.put("video-vd", 7);
        map.put("video-sq", 7);
        map.put("muted", 10);
        a0.j(11, map, "star", 19, "skip-countdowns");
        map.put("skip-with-countdowns-skip-btn", 21);
        map.put("skip-with-countdowns-video-countdown", 13);
        a0.j(20, map, "skip-with-countdowns-skip-countdown", 14, "skip-with-time");
        map.put("skip-with-time-countdown", 13);
        map.put("skip-with-time-skip-btn", 15);
        map.put("skip", 27);
        map.put("timedown", 13);
        map.put(C2300e4.h.H0, 16);
        map.put("scoreCountWithIcon", 6);
        map.put("split-line", 18);
        map.put("creative-playable-bait", 0);
        map.put("score-count-type-2", 0);
        map.put("lottie", 28);
    }

    public vCE Bc() {
        return this.Cc;
    }

    public vCE Cc() {
        return this.tV;
    }

    public String EO() {
        return this.EO;
    }

    public int IlO() {
        if (TextUtils.isEmpty(this.MY)) {
            return 0;
        }
        if (this.MY.equals("logo")) {
            String str = this.MY + this.EO;
            this.MY = str;
            if (str.contains("logoad")) {
                return 4;
            }
            if (this.MY.contains("logounion")) {
                return 5;
            }
        }
        Map<String, Integer> map = IlO;
        if (map.get(this.MY) != null) {
            return map.get(this.MY).intValue();
        }
        return -1;
    }

    public String MY() {
        return this.MY;
    }

    public String tV() {
        return this.vCE;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DynamicLayoutBrick{type='");
        sb.append(this.MY);
        sb.append("', data='");
        sb.append(this.EO);
        sb.append("', value=");
        sb.append(this.tV);
        sb.append(", themeValue=");
        sb.append(this.Cc);
        sb.append(", dataExtraInfo='");
        return a.r(sb, this.vCE, "'}");
    }

    public int vCE() {
        return this.tV.PTq();
    }

    public void EO(String str) {
        this.vCE = str;
    }

    public void MY(String str) {
        this.EO = str;
    }

    public void MY(vCE vce) {
        this.Cc = vce;
    }

    public void IlO(String str) {
        this.MY = str;
    }

    public void IlO(vCE vce) {
        this.tV = vce;
    }
}
