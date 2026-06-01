package com.bytedance.sdk.component.adexpress.Cc;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    private WeakReference<MY> IlO;

    public EO(MY my) {
        this.IlO = new WeakReference<>(my);
    }

    public void IlO(MY my) {
        this.IlO = new WeakReference<>(my);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get();
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<MY> weakReference = this.IlO;
        return (weakReference == null || weakReference.get() == null) ? "" : this.IlO.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<MY> weakReference = this.IlO;
        return (weakReference == null || weakReference.get() == null) ? "" : this.IlO.get().appInfo();
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void chooseAdResult(String str) {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().chooseAdResult(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().clickEvent(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<MY> weakReference = this.IlO;
        return (weakReference == null || weakReference.get() == null) ? "" : this.IlO.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<MY> weakReference = this.IlO;
        return (weakReference == null || weakReference.get() == null) ? "" : this.IlO.get().getData(str);
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<MY> weakReference = this.IlO;
        return (weakReference == null || weakReference.get() == null) ? "" : this.IlO.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().initRenderFinish();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().muteVideo(str);
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().IlO(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().skipVideo();
    }

    @JavascriptInterface
    public void videoFrameChanged(String str) {
        WeakReference<MY> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().videoFrameChanged(str);
    }
}
