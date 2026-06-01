package com.unity3d.ads.adplayer;

import androidx.annotation.CallSuper;
import com.unity3d.services.ads.offerwall.OfferwallEvent;
import com.unity3d.services.banners.bridge.BannerBridge;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.h;
import q5.x;
import q6.a0;
import q6.c0;
import s6.a;
import t6.e;
import t6.p0;
import t6.x0;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface AdPlayer {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int OFFERWALL_EVENT_QUEUE_SIZE = 5;
    public static final int SCAR_EVENT_QUEUE_SIZE = 10;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public static final int OFFERWALL_EVENT_QUEUE_SIZE = 5;
        public static final int SCAR_EVENT_QUEUE_SIZE = 10;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final p0 broadcastEventChannel = x0.a((7 & 1) != 0 ? 0 : 100, (7 & 2) == 0 ? 64 : 0, a.f13718a);

        private Companion() {
        }

        public final p0 getBroadcastEventChannel() {
            return broadcastEventChannel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        @CallSuper
        public static Object destroy(AdPlayer adPlayer, c<? super x> cVar) {
            c0.i(adPlayer.getScope(), null);
            return x.f13520a;
        }

        public static void show(AdPlayer adPlayer, ShowOptions showOptions) {
            k.e(showOptions, "showOptions");
            throw new h();
        }
    }

    @CallSuper
    Object destroy(c<? super x> cVar);

    void dispatchShowCompleted();

    e getOnLoadEvent();

    e getOnOfferwallEvent();

    e getOnScarEvent();

    e getOnShowEvent();

    a0 getScope();

    WebViewContainer getWebViewContainer();

    Object onAllowedPiiChange(byte[] bArr, c<? super x> cVar);

    Object onBroadcastEvent(String str, c<? super x> cVar);

    Object requestShow(Map<String, ? extends Object> map, c<? super x> cVar);

    Object sendActivityDestroyed(c<? super x> cVar);

    Object sendFocusChange(boolean z2, c<? super x> cVar);

    Object sendGmaEvent(com.unity3d.scar.adapter.common.c cVar, c<? super x> cVar2);

    Object sendMuteChange(boolean z2, c<? super x> cVar);

    Object sendOfferwallEvent(OfferwallEvent offerwallEvent, c<? super x> cVar);

    Object sendPrivacyFsmChange(byte[] bArr, c<? super x> cVar);

    Object sendScarBannerEvent(BannerBridge.BannerEvent bannerEvent, c<? super x> cVar);

    Object sendUserConsentChange(byte[] bArr, c<? super x> cVar);

    Object sendVisibilityChange(boolean z2, c<? super x> cVar);

    Object sendVolumeChange(double d8, c<? super x> cVar);

    void show(ShowOptions showOptions);
}
