package sg.bigo.ads.ad.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.ironsource.Mf;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.SplashAd;
import sg.bigo.ads.api.SplashAdInteractionListener;

/* JADX INFO: loaded from: classes6.dex */
public class AdSplashActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Integer, b> f15255a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f15256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f15257c = new AtomicBoolean(false);

    public static void a(@NonNull Context context, @NonNull b bVar) {
        Intent intent = new Intent(context, (Class<?>) (bVar.getStyle() == SplashAd.Style.HORIZONTAL ? LandscapeAdSplashActivity.class : AdSplashActivity.class));
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        int iHashCode = bVar.hashCode();
        intent.putExtra("splash_hash", iHashCode);
        f15255a.put(Integer.valueOf(iHashCode), bVar);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            if (this.f15256b == null || !this.f15257c.compareAndSet(false, true)) {
                return;
            }
            this.f15256b.f15397z.onAdClosed();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            Window window = getWindow();
            if (window != null) {
                window.setFlags(1024, 1024);
            }
            Intent intent = getIntent();
            if (intent != null) {
                int intExtra = intent.getIntExtra("splash_hash", -1);
                Map<Integer, b> map = f15255a;
                b bVar = map.get(Integer.valueOf(intExtra));
                if (bVar != null) {
                    map.remove(Integer.valueOf(intExtra));
                    FrameLayout frameLayout = new FrameLayout(this);
                    frameLayout.setBackgroundColor(-1);
                    setContentView(frameLayout);
                    this.f15256b = bVar;
                    bVar.f15397z.f15427c = new SplashAdInteractionListener() { // from class: sg.bigo.ads.ad.splash.AdSplashActivity.1
                        @Override // sg.bigo.ads.api.AdInteractionListener
                        public final void onAdClicked() {
                            sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", Mf.f7244f);
                        }

                        @Override // sg.bigo.ads.api.AdInteractionListener
                        public final void onAdClosed() {
                            sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", Mf.g);
                        }

                        @Override // sg.bigo.ads.api.AdInteractionListener
                        public final void onAdError(@NonNull AdError adError) {
                            if (adError == null) {
                                return;
                            }
                            sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", "onAdError: " + adError.getCode() + " " + adError.getMessage());
                        }

                        @Override // sg.bigo.ads.api.SplashAdInteractionListener
                        public final void onAdFinished() {
                            sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", "onAdFinished");
                        }

                        @Override // sg.bigo.ads.api.AdInteractionListener
                        public final void onAdImpression() {
                            sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", "onAdImpression");
                        }

                        @Override // sg.bigo.ads.api.AdInteractionListener
                        public final void onAdOpened() {
                            sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", Mf.f7242c);
                        }

                        @Override // sg.bigo.ads.api.SplashAdInteractionListener
                        public final void onAdSkipped() {
                            sg.bigo.ads.common.t.a.a(0, 3, "AdSplashActivity", "onAdSkipped");
                            AdSplashActivity.this.finish();
                        }
                    };
                    bVar.a(frameLayout);
                    b bVar2 = this.f15256b;
                    if (bVar2 != null) {
                        bVar2.f15397z.onAdOpened();
                        return;
                    }
                    return;
                }
            }
            finish();
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f15256b != null && this.f15257c.compareAndSet(false, true)) {
                this.f15256b.f15397z.onAdClosed();
            }
            b bVar = this.f15256b;
            if (bVar != null) {
                bVar.destroy();
                this.f15256b = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        b bVar = this.f15256b;
        if (bVar == null || !bVar.isSkippable()) {
            return true;
        }
        this.f15256b.d(8);
        return true;
    }

    @Override // android.app.Activity
    public void onResume() {
        View decorView;
        super.onResume();
        try {
            Window window = getWindow();
            if (window == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            decorView.setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable unused) {
            finish();
        }
    }
}
