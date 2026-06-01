package com.unity3d.ads.adplayer;

import androidx.annotation.CallSuper;
import com.unity3d.ads.adplayer.AdPlayer;
import kotlin.jvm.internal.k;
import q5.x;
import v5.c;
import w5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface FullscreenAdPlayer extends AdPlayer {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        @CallSuper
        public static Object destroy(FullscreenAdPlayer fullscreenAdPlayer, c<? super x> cVar) {
            Object objDestroy = AdPlayer.DefaultImpls.destroy(fullscreenAdPlayer, cVar);
            return objDestroy == a.f17774a ? objDestroy : x.f13520a;
        }

        public static void show(FullscreenAdPlayer fullscreenAdPlayer, ShowOptions showOptions) {
            k.e(showOptions, "showOptions");
            AdPlayer.DefaultImpls.show(fullscreenAdPlayer, showOptions);
        }
    }
}
