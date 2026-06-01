package sg.bigo.ads.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import sg.bigo.ads.api.core.BaseAdActivityImpl;

/* JADX INFO: loaded from: classes6.dex */
public class AdActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private BaseAdActivityImpl f15429a;

    @NonNull
    public static Intent a(Context context, @NonNull Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) AdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    @NonNull
    public static Intent c(Context context, @NonNull Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) LandscapeAdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    @NonNull
    public static Intent d(Context context, @NonNull Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) CompanionAdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    @NonNull
    public static Intent e(Context context, @NonNull Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) LandscapeCompanionAdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    @NonNull
    public static Intent f(Context context, @NonNull Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) LandingStyleableActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    public int b() {
        return 0;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f15429a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.X();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i8, Intent intent) {
        super.onActivityResult(i2, i8, intent);
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f15429a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.a(i2, i8, intent);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f15429a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.W();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        boolean z2;
        Throwable th;
        try {
            Constructor<?> declaredConstructor = Class.forName(getIntent().getStringExtra("impl_clazz")).getDeclaredConstructor(Activity.class);
            declaredConstructor.setAccessible(true);
            this.f15429a = (BaseAdActivityImpl) declaredConstructor.newInstance(this);
            a();
            super.onCreate(bundle);
            try {
                this.f15429a.J = b();
                this.f15429a.N();
            } catch (Throwable th2) {
                th = th2;
                z2 = true;
                getIntent().putExtra("create_error_flag", true);
                getIntent().putExtra("create_error_msg", Log.getStackTraceString(th));
                if (!z2) {
                    super.onCreate(bundle);
                }
                finish();
            }
        } catch (Throwable th3) {
            z2 = false;
            th = th3;
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f15429a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.D();
                this.f15429a = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f15429a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.V();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f15429a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.U();
            }
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        BaseAdActivityImpl baseAdActivityImpl = this.f15429a;
        return baseAdActivityImpl != null && baseAdActivityImpl.b(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        try {
            BaseAdActivityImpl baseAdActivityImpl = this.f15429a;
            if (baseAdActivityImpl != null) {
                baseAdActivityImpl.g(z2);
            }
        } catch (Throwable unused) {
        }
    }

    @NonNull
    public static Intent b(Context context, @NonNull Class<? extends BaseAdActivityImpl> cls) {
        Intent intent = new Intent(context, (Class<?>) PopupAdActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("impl_clazz", cls.getName());
        return intent;
    }

    public void a() {
    }
}
