package com.vungle.ads.internal.omsdk;

import a4.c;
import android.app.Activity;
import android.support.v4.media.g;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.ironsource.adapters.bigo.banner.BigoBannerAdapter;
import com.ironsource.adapters.vungle.interstitial.VungleInterstitialAdapter;
import com.ironsource.adapters.vungle.rewardedvideo.VungleRewardedVideoAdapter;
import com.mimikridev.utilmanager.firebase.FirebaseUtil;
import com.onesignal.core.internal.startup.StartupService;
import com.vungle.ads.InterstitialAd;
import com.vungle.ads.RewardedAd;
import com.vungle.ads.internal.session.UnclosedAdDetector;
import i4.r1;
import j4.h;
import j4.k3;
import j4.l;
import j4.q4;
import j4.r4;
import w0.i;
import z1.d;
import z1.j;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11011b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f11010a = i2;
        this.f11011b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11010a) {
            case 0:
                OMInjector.m3331init$lambda2((OMInjector) this.f11011b);
                break;
            case 1:
                UnclosedAdDetector.m3351retrieveUnclosedAd$lambda3((UnclosedAdDetector) this.f11011b);
                break;
            case 2:
                FirebaseUtil.lambda$dg$1((Activity) this.f11011b);
                break;
            case 3:
                MaterialButton.a((MaterialButton) this.f11011b);
                break;
            case 4:
                ((CarouselLayoutManager) this.f11011b).requestLayout();
                break;
            case 5:
                StartupService.m3144scheduleStart$lambda2((StartupService) this.f11011b);
                break;
            case 6:
                l lVar = (l) this.f11011b;
                g gVar = lVar.f12296d;
                if (gVar != null) {
                    r1 r1Var = (r1) gVar.f3263b;
                    if (!r1Var.f11948c && !r1Var.f11947b) {
                        gVar.c();
                    }
                }
                lVar.f12295c = null;
                break;
            case 7:
                ((k3) this.f11011b).e();
                break;
            case 8:
                r4 r4Var = ((q4) this.f11011b).e;
                r4Var.f12435b.a(new c(r4Var, 15));
                break;
            case 9:
                ConstraintTrackingWorker.startWork$lambda$0((ConstraintTrackingWorker) this.f11011b);
                break;
            case 10:
                View view = (View) this.f11011b;
                ((InputMethodManager) ContextCompat.getSystemService(view.getContext(), InputMethodManager.class)).showSoftInput(view, 1);
                break;
            case 11:
                BigoBannerAdapter.destroyBannerViewAd$lambda$0((BigoBannerAdapter) this.f11011b);
                break;
            case 12:
                h hVar = (h) this.f11011b;
                ((i) ((x0.c) hVar.f12234d)).j(new j7.a(hVar, 9));
                break;
            case 13:
                g1.h hVar2 = (g1.h) this.f11011b;
                hVar2.f11573c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) hVar2.e;
                ViewDragHelper viewDragHelper = sideSheetBehavior.f5430i;
                if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                    hVar2.a(hVar2.f11572b);
                } else if (sideSheetBehavior.h == 2) {
                    sideSheetBehavior.a(hVar2.f11572b);
                }
                break;
            case 14:
                VungleInterstitialAdapter.showInterstitial$lambda$3((InterstitialAd) this.f11011b);
                break;
            case 15:
                ((d) this.f11011b).s(true);
                break;
            case 16:
                j jVar = (j) this.f11011b;
                boolean zIsPopupShowing = jVar.h.isPopupShowing();
                jVar.s(zIsPopupShowing);
                jVar.m = zIsPopupShowing;
                break;
            case 17:
                ((TextInputLayout) this.f11011b).e.requestLayout();
                break;
            default:
                VungleRewardedVideoAdapter.showRewardedVideo$lambda$4((RewardedAd) this.f11011b);
                break;
        }
    }
}
