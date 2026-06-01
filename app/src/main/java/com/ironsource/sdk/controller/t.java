package com.ironsource.sdk.controller;

import android.app.Activity;
import android.media.AudioManager;
import com.ironsource.C2531r4;
import com.ironsource.V7;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.services.core.device.MimeTypes;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class t {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioManager f10069a;

        public a(AudioManager audioManager) {
            this.f10069a = audioManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.a(this.f10069a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioManager f10070a;

        public b(AudioManager audioManager) {
            this.f10070a = audioManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.b(this.f10070a);
        }
    }

    public static void a(Activity activity) {
        V7.f7731a.b(new a((AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO)));
    }

    public static void b(Activity activity) {
        V7.f7731a.b(new b((AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AudioManager audioManager) {
        try {
            audioManager.abandonAudioFocus(null);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(AudioManager audioManager) {
        try {
            audioManager.requestAudioFocus(null, 3, 2);
        } catch (Throwable th) {
            C2531r4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }
}
