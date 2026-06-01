package com.cbt.exam.browser.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.balysv.materialripple.MaterialRippleLayout;
import com.cbt.exam.browser.R;
import com.mimikridev.ads.banner.BannerAd;
import com.mimikridev.utilmanager.config.Statistik;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ConfirmActivity extends BaseActivity {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5127d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5128f;
    public MaterialRippleLayout g;
    public TextView h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f5129i;

    @Override // com.cbt.exam.browser.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_confirm);
        this.f5124a.d();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.baseline_chevron_left_24);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.setTitle("Confirm");
        final int i2 = 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.u

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ConfirmActivity f5200b;

            {
                this.f5200b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i8 = i2;
                ConfirmActivity confirmActivity = this.f5200b;
                switch (i8) {
                    case 0:
                        int i9 = ConfirmActivity.j;
                        confirmActivity.getClass();
                        Intent intent = new Intent(confirmActivity.getBaseContext(), (Class<?>) ExamQR.class);
                        intent.putExtra("url", confirmActivity.f5125b);
                        intent.putExtra("timer", Integer.parseInt(confirmActivity.f5126c));
                        intent.putExtra("timerstat", Integer.parseInt(confirmActivity.f5128f));
                        intent.putExtra("useragent", confirmActivity.f5127d);
                        intent.putExtra("from", "confirm_activity");
                        confirmActivity.startActivity(intent);
                        confirmActivity.finish();
                        break;
                    default:
                        int i10 = ConfirmActivity.j;
                        confirmActivity.finish();
                        break;
                }
            }
        });
        this.f5125b = getIntent().getStringExtra("url");
        this.f5126c = getIntent().getStringExtra("lamates");
        this.f5127d = getIntent().getStringExtra("useragent");
        this.e = getIntent().getStringExtra("pesan");
        Statistik.sendData(this, "cbtexambrowser");
        this.h = (TextView) findViewById(R.id.lamates);
        this.f5129i = (TextView) findViewById(R.id.pesan);
        Log.d("CONF", "url = " + this.f5125b);
        Log.d("CONF", "lamates = " + this.f5126c);
        Log.d("CONF", "useragent = " + this.f5127d);
        Log.d("CONF", "pesan = " + this.e);
        if ("0".equals(this.f5126c)) {
            this.h.setText(getResources().getString(R.string.txt_scanqr_lamates));
            this.f5128f = "0";
        } else {
            this.h.setText(this.f5126c + " " + getResources().getString(R.string.txt_scanqr_menit));
            this.f5128f = "1";
        }
        if ("0".equals(this.e)) {
            this.f5129i.setText(getResources().getString(R.string.txt_scanqr_pesan));
        } else {
            this.f5129i.setText(this.e);
        }
        this.g = (MaterialRippleLayout) findViewById(R.id.btn_masukujian);
        Statistik.getData(this);
        final int i8 = 0;
        this.g.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.u

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ConfirmActivity f5200b;

            {
                this.f5200b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i8;
                ConfirmActivity confirmActivity = this.f5200b;
                switch (i82) {
                    case 0:
                        int i9 = ConfirmActivity.j;
                        confirmActivity.getClass();
                        Intent intent = new Intent(confirmActivity.getBaseContext(), (Class<?>) ExamQR.class);
                        intent.putExtra("url", confirmActivity.f5125b);
                        intent.putExtra("timer", Integer.parseInt(confirmActivity.f5126c));
                        intent.putExtra("timerstat", Integer.parseInt(confirmActivity.f5128f));
                        intent.putExtra("useragent", confirmActivity.f5127d);
                        intent.putExtra("from", "confirm_activity");
                        confirmActivity.startActivity(intent);
                        confirmActivity.finish();
                        break;
                    default:
                        int i10 = ConfirmActivity.j;
                        confirmActivity.finish();
                        break;
                }
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new j(this, 5));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        j0.a aVar;
        BannerAd bannerAd;
        super.onDestroy();
        if (!isFinishing() || (aVar = this.f5124a) == null || (bannerAd = aVar.f12051f) == null) {
            return;
        }
        bannerAd.destroyAndDetachBanner();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Statistik.getData(this);
        j0.a aVar = this.f5124a;
        if (aVar != null) {
            aVar.h(this);
            this.f5124a.f();
        }
    }
}
