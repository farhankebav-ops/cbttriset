package com.bytedance.sdk.component.adexpress.Cc;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.IlO.tl;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private WeakReference<tl> IlO;

    public tV(tl tlVar) {
        this.IlO = new WeakReference<>(tlVar);
    }

    public void IlO(tl tlVar) {
        this.IlO = new WeakReference<>(tlVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<tl> weakReference = this.IlO;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.IlO.get().invokeMethod(str);
    }
}
