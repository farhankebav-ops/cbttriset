package com.cbt.exam.browser.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import com.cbt.exam.browser.R;
import com.mimikridev.utilmanager.config.ConfigManager;
import com.mimikridev.utilmanager.config.SharedPrefConfig;
import com.mimikridev.utilmanager.theme.ThemeManager;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ActivitySplash extends AppCompatActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f5121c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f5122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPrefConfig f5123b;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        GradientDrawable gradientDrawable;
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash);
        this.f5123b = new SharedPrefConfig(this);
        new ConfigManager(this, 57).getConfig();
        ThemeManager themeManager = new ThemeManager(this);
        int i2 = 0;
        if (themeManager.isCustomTheme()) {
            try {
                TextView textView = (TextView) findViewById(R.id.txt_app_name);
                if (themeManager.getAppTitle() != null && !themeManager.getAppTitle().isEmpty()) {
                    textView.setText(themeManager.getAppTitle());
                }
                View viewFindViewById = findViewById(R.id.root_view);
                if (viewFindViewById != null) {
                    Drawable background = viewFindViewById.getBackground();
                    int primaryColor = themeManager.getPrimaryColor();
                    if (background instanceof GradientDrawable) {
                        gradientDrawable = (GradientDrawable) background.mutate();
                        gradientDrawable.setColors(new int[]{primaryColor, -1});
                    } else {
                        gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{primaryColor, -1});
                        gradientDrawable.setShape(0);
                    }
                    ViewCompat.setBackground(viewFindViewById, gradientDrawable);
                }
                getWindow().setStatusBarColor(themeManager.getPrimaryColor());
            } catch (Exception e) {
                Log.e("ThemeError", "Error applying custom theme", e);
            }
        }
        Intent intent = getIntent();
        if (intent != null && "android.intent.action.VIEW".equals(intent.getAction()) && intent.getData() != null) {
            this.f5122a = intent.getData();
        }
        long lastOpenadsTime = this.f5123b.getLastOpenadsTime();
        int openadsCountToday = this.f5123b.getOpenadsCountToday();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(lastOpenadsTime);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            i2 = openadsCountToday;
        } else {
            this.f5123b.setOpenadsCountToday(0);
        }
        if (i2 >= this.f5123b.getMaxOpenAdsPerDay() || jCurrentTimeMillis - lastOpenadsTime <= 7200000) {
            new Handler().postDelayed(new a3.b(this, 16), 3000L);
            return;
        }
        if (this.f5123b.getAd_status().equals("1") && this.f5123b.getOpenad_status().equals("1")) {
            ((MyApplication) getApplication()).showAdIfAvailable(this, new androidx.camera.core.impl.b(this, 11));
        } else {
            new Handler().postDelayed(new a3.b(this, 16), 3000L);
        }
        this.f5123b.setLastOpenadsTime(jCurrentTimeMillis);
        this.f5123b.setOpenadsCountToday(i2 + 1);
    }
}
