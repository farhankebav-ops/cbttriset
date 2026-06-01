package com.cbt.exam.browser.activity;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.view.PreviewView;
import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5198b;

    public /* synthetic */ t(Object obj, int i2) {
        this.f5197a = i2;
        this.f5198b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        PreviewView previewView;
        MeteringPointFactory meteringPointFactory;
        int i2 = this.f5197a;
        Object obj = this.f5198b;
        switch (i2) {
            case 0:
                ActivityScanner activityScanner = (ActivityScanner) obj;
                int i8 = ActivityScanner.f5118d;
                activityScanner.getClass();
                if (motionEvent.getAction() == 0) {
                    l0.e eVar = activityScanner.f5120c;
                    if (eVar.f12734a != null && (previewView = eVar.f12736c) != null && (meteringPointFactory = previewView.getMeteringPointFactory()) != null) {
                        eVar.f12734a.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(meteringPointFactory.createPoint(motionEvent.getX(), motionEvent.getY())).setAutoCancelDuration(3L, TimeUnit.SECONDS).build());
                    }
                }
                return true;
            case 1:
                return AndroidWebViewContainer._init_$lambda$1((AndroidWebViewContainer) obj, view, motionEvent);
            default:
                z1.j jVar = (z1.j) obj;
                if (motionEvent.getAction() == 1) {
                    long jUptimeMillis = SystemClock.uptimeMillis() - jVar.f17910o;
                    if (jUptimeMillis < 0 || jUptimeMillis > 300) {
                        jVar.m = false;
                    }
                    jVar.t();
                    jVar.m = true;
                    jVar.f17910o = SystemClock.uptimeMillis();
                }
                return false;
        }
    }
}
