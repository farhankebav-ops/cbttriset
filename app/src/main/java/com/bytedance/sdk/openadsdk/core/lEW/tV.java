package com.bytedance.sdk.openadsdk.core.lEW;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.bumptech.glide.load.Key;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private static volatile tV EO;
    private static int MY;
    private final List<Cc> IlO = new ArrayList();

    public static tV IlO() {
        if (EO == null) {
            synchronized (tV.class) {
                try {
                    if (EO == null) {
                        EO = new tV();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return EO;
    }

    public int EO() {
        return this.IlO.size();
    }

    @Nullable
    public Cc MY() {
        Cc ccRemove;
        if (EO() > 0 && (ccRemove = this.IlO.remove(0)) != null) {
            return ccRemove;
        }
        return null;
    }

    public void EO(Cc cc) {
        if (cc == null || cc.getWebView() == null) {
            return;
        }
        if (cc.getParent() != null) {
            ((ViewGroup) cc.getParent()).removeView(cc);
        }
        try {
            cc.removeAllViews();
            cc.Bc();
            cc.setWebChromeClient(null);
            cc.setWebViewClient(null);
            cc.setDownloadListener(null);
            cc.setDefaultTextEncodingName(Key.STRING_CHARSET_NAME);
            cc.setAllowFileAccess(false);
            cc.setJavaScriptEnabled(true);
            cc.setCacheMode(-1);
            cc.setDatabaseEnabled(true);
            cc.setSupportZoom(false);
            cc.getWebView().setLayerType(0, null);
            cc.setBackgroundColor(0);
            cc.getWebView().setHorizontalScrollBarEnabled(false);
            cc.getWebView().setHorizontalScrollbarOverlay(false);
            cc.getWebView().setVerticalScrollBarEnabled(false);
            cc.getWebView().setVerticalScrollbarOverlay(false);
            com.bytedance.sdk.openadsdk.core.widget.IlO.EO.IlO(cc);
            cc.bWL();
            cc.setMixedContentMode(0);
        } catch (Exception unused) {
        }
    }

    public void MY(Cc cc) {
        if (cc != null) {
            if (this.IlO.size() >= MY) {
                cc.zPa();
            } else {
                if (this.IlO.contains(cc)) {
                    return;
                }
                EO(cc);
                this.IlO.add(cc);
            }
        }
    }

    @UiThread
    public void IlO(Cc cc) {
        if (cc != null) {
            MY(cc);
        }
    }
}
