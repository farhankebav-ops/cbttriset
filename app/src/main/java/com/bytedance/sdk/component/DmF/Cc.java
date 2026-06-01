package com.bytedance.sdk.component.DmF;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.DmF.vCE;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends WebView {
    private boolean Cc;
    private boolean EO;
    public long IlO;
    private final HashSet<String> MY;
    private boolean tV;
    private EO vCE;

    public Cc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MY = new HashSet<>();
        this.IlO = System.currentTimeMillis();
        IlO();
    }

    private void IlO() {
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(false);
        settings.setAllowFileAccess(false);
        settings.setSavePassword(false);
        setWebViewClient(new vCE.IlO());
    }

    private void MY() {
        if (this.EO) {
            return;
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        setOnClickListener(null);
        setOnTouchListener(null);
        Iterator<String> it = this.MY.iterator();
        while (it.hasNext()) {
            super.removeJavascriptInterface(it.next());
        }
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        toString();
        if (this.EO || this.Cc) {
            return;
        }
        super.addJavascriptInterface(obj, str);
        this.MY.add(str);
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z2) {
        if (this.EO || this.Cc) {
            return;
        }
        super.clearCache(z2);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        toString();
        if (this.EO) {
            return;
        }
        this.EO = true;
        MY();
        super.destroy();
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.EO && !this.Cc) {
            super.evaluateJavascript(str, valueCallback);
        } else if (valueCallback != null) {
            valueCallback.onReceiveValue("");
        }
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (this.EO || this.Cc) {
            return;
        }
        super.goBack();
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i2) {
        if (this.EO || this.Cc) {
            return;
        }
        super.goBackOrForward(i2);
    }

    @Override // android.webkit.WebView
    public void goForward() {
        if (this.EO || this.Cc) {
            return;
        }
        super.goForward();
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.EO || this.Cc) {
            return;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (this.EO || this.Cc) {
            return;
        }
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError unused) {
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        toString();
        if (this.tV) {
            destroy();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.EO || this.Cc) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        if (this.EO || this.Cc) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i2, i8);
        }
    }

    @Override // android.webkit.WebView
    public void onPause() {
        if (this.EO || this.Cc) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void onResume() {
        if (this.EO || this.Cc) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void pauseTimers() {
        if (this.EO || this.Cc) {
            return;
        }
        super.pauseTimers();
    }

    @Override // android.webkit.WebView
    public void reload() {
        if (this.EO || this.Cc) {
            return;
        }
        super.reload();
    }

    @Override // android.webkit.WebView
    public void removeJavascriptInterface(String str) {
        if (this.EO || this.Cc) {
            return;
        }
        super.removeJavascriptInterface(str);
        this.MY.remove(str);
    }

    @Override // android.webkit.WebView
    public void resumeTimers() {
        if (this.EO || this.Cc) {
            return;
        }
        super.resumeTimers();
    }

    public void setDestroyOnDetached(boolean z2) {
        this.tV = z2;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        EO eo = this.vCE;
        if (eo == null) {
            super.setOnTouchListener(onTouchListener);
        } else {
            eo.IlO(onTouchListener);
            super.setOnTouchListener(this.vCE);
        }
    }

    public void setRecycler(boolean z2) {
        this.Cc = z2;
    }

    public void setTouchListenerProxy(EO eo) {
        this.vCE = eo;
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (this.EO || this.Cc) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        if (this.EO || this.Cc) {
            return;
        }
        try {
            super.loadUrl(str, map);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError unused) {
        }
    }

    public Cc(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.MY = new HashSet<>();
        this.IlO = System.currentTimeMillis();
        IlO();
    }
}
