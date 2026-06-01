package com.cbt.exam.browser.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.Camera;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.balysv.materialripple.MaterialRippleLayout;
import com.cbt.exam.browser.R;
import com.mimikridev.utilmanager.config.Statistik;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ActivityScanner extends BaseActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f5118d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PreviewView f5119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l0.e f5120c;

    @Override // com.cbt.exam.browser.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scanner);
        this.f5119b = (PreviewView) findViewById(R.id.previewView);
        this.f5124a.d();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.baseline_chevron_left_24);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.setTitle(getResources().getString(R.string.txt_scanner_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final int i2 = 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.s

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityScanner f5196b;

            {
                this.f5196b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i8 = i2;
                ActivityScanner activityScanner = this.f5196b;
                switch (i8) {
                    case 0:
                        int i9 = ActivityScanner.f5118d;
                        activityScanner.finish();
                        break;
                    case 1:
                        l0.e eVar = activityScanner.f5120c;
                        Camera camera = eVar.f12734a;
                        if (camera != null && camera.getCameraInfo().hasFlashUnit()) {
                            eVar.e = !eVar.e;
                            eVar.f12734a.getCameraControl().enableTorch(eVar.e);
                            break;
                        }
                        break;
                    default:
                        l0.e eVar2 = activityScanner.f5120c;
                        eVar2.f12738f = !eVar2.f12738f;
                        eVar2.b();
                        eVar2.a(activityScanner, activityScanner, eVar2.f12736c);
                        break;
                }
            }
        });
        l0.e eVar = new l0.e();
        eVar.e = false;
        eVar.f12738f = false;
        eVar.g = false;
        this.f5120c = eVar;
        eVar.h = new androidx.camera.core.impl.b(this, 10);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            this.f5120c.a(this, this, this.f5119b);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 100);
        }
        final int i8 = 1;
        ((MaterialRippleLayout) findViewById(R.id.cd_flash)).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.s

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityScanner f5196b;

            {
                this.f5196b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i8;
                ActivityScanner activityScanner = this.f5196b;
                switch (i82) {
                    case 0:
                        int i9 = ActivityScanner.f5118d;
                        activityScanner.finish();
                        break;
                    case 1:
                        l0.e eVar2 = activityScanner.f5120c;
                        Camera camera = eVar2.f12734a;
                        if (camera != null && camera.getCameraInfo().hasFlashUnit()) {
                            eVar2.e = !eVar2.e;
                            eVar2.f12734a.getCameraControl().enableTorch(eVar2.e);
                            break;
                        }
                        break;
                    default:
                        l0.e eVar22 = activityScanner.f5120c;
                        eVar22.f12738f = !eVar22.f12738f;
                        eVar22.b();
                        eVar22.a(activityScanner, activityScanner, eVar22.f12736c);
                        break;
                }
            }
        });
        final int i9 = 2;
        ((MaterialRippleLayout) findViewById(R.id.cd_switch)).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.s

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityScanner f5196b;

            {
                this.f5196b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i9;
                ActivityScanner activityScanner = this.f5196b;
                switch (i82) {
                    case 0:
                        int i92 = ActivityScanner.f5118d;
                        activityScanner.finish();
                        break;
                    case 1:
                        l0.e eVar2 = activityScanner.f5120c;
                        Camera camera = eVar2.f12734a;
                        if (camera != null && camera.getCameraInfo().hasFlashUnit()) {
                            eVar2.e = !eVar2.e;
                            eVar2.f12734a.getCameraControl().enableTorch(eVar2.e);
                            break;
                        }
                        break;
                    default:
                        l0.e eVar22 = activityScanner.f5120c;
                        eVar22.f12738f = !eVar22.f12738f;
                        eVar22.b();
                        eVar22.a(activityScanner, activityScanner, eVar22.f12736c);
                        break;
                }
            }
        });
        this.f5119b.setOnTouchListener(new t(this, 0));
        Statistik.getApp(this);
        getOnBackPressedDispatcher().addCallback(this, new j(this, 4));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        l0.e eVar = this.f5120c;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        l0.e eVar = this.f5120c;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 100 && iArr.length > 0 && iArr[0] == 0) {
            this.f5120c.a(this, this, this.f5119b);
        } else {
            Toast.makeText(this, getString(R.string.camera_permision), 0).show();
        }
    }
}
