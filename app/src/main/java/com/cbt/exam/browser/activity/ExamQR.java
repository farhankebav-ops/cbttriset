package com.cbt.exam.browser.activity;

import android.app.ActivityManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.webkit.ProxyConfig;
import com.cbt.exam.browser.R;
import com.cbt.exam.browser.util.cbt.BatteryReceiver;
import com.mimikridev.utilmanager.config.Statistik;
import com.mimikridev.utilmanager.firebase.FirebaseUtil;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ExamQR extends BaseActivity {
    public static ProgressBar B;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f5130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RelativeLayout f5131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RelativeLayout f5132d;
    public RelativeLayout e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f5133f;
    public TextView g;
    public TextView h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f5134i;
    public String j;
    public String k;
    public Dialog l;
    public Integer m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f5135n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ProgressBar f5136o;
    public ImageView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public android.support.v4.media.g f5137q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public BatteryReceiver f5138r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h f5139s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CountDownTimer f5140t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public x f5141u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f5142v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f5143w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f5144x;
    public ActivityManager y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f5145z = false;
    public String A = "";

    @Override // com.cbt.exam.browser.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.y = (ActivityManager) getSystemService("activity");
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        getWindow().setFlags(8192, 8192);
        getWindow().addFlags(128);
        getWindow().addFlags(4194304);
        setContentView(R.layout.activity_exam);
        this.f5137q = new android.support.v4.media.g((BaseActivity) this);
        BatteryReceiver batteryReceiver = new BatteryReceiver((TextView) findViewById(R.id.batterai_stat));
        this.f5138r = batteryReceiver;
        registerReceiver(batteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f5134i = getIntent().getStringExtra("url");
        this.f5135n = Integer.valueOf(getIntent().getIntExtra("timerstat", 0));
        this.m = Integer.valueOf(getIntent().getIntExtra("timer", 0));
        getIntent().getIntExtra("exit_timer", 0);
        this.j = getIntent().getStringExtra("useragent");
        this.k = getIntent().getStringExtra("from");
        this.e = (RelativeLayout) findViewById(R.id.rel_penalty);
        this.f5142v = (TextView) findViewById(R.id.txt_penaltycount);
        this.f5143w = (TextView) findViewById(R.id.txt_penaltyterakhir);
        this.f5144x = (TextView) findViewById(R.id.txt_penaltyreset);
        this.g = (TextView) findViewById(R.id.txt_error);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.loading_icon);
        this.f5136o = progressBar;
        progressBar.setVisibility(0);
        this.p = (ImageView) findViewById(R.id.type_jaringan);
        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progress_bar);
        B = progressBar2;
        progressBar2.setVisibility(0);
        B.setProgress(0);
        B.setAlpha(1.0f);
        this.f5133f = (LinearLayout) findViewById(R.id.lyt_timer);
        this.f5132d = (RelativeLayout) findViewById(R.id.rel_url_error);
        this.f5131c = (RelativeLayout) findViewById(R.id.rel_offline);
        this.h = (TextView) findViewById(R.id.waktu_ujian);
        if (1 == this.f5135n.intValue()) {
            this.f5133f.setVisibility(0);
            this.f5140t = new x(this, TimeUnit.MINUTES.toMillis(this.m.intValue()), 0).start();
        } else {
            this.f5133f.setVisibility(8);
        }
        this.f5139s = new h(this, 1);
        FirebaseUtil.logScreen(this, "Exam QR");
        WebView webView = (WebView) findViewById(R.id.webView);
        this.f5130b = webView;
        webView.setWebViewClient(new y(this));
        this.f5130b.setWebChromeClient(new l(1));
        this.f5130b.getSettings().setMediaPlaybackRequiresUserGesture(false);
        WebSettings settings = this.f5130b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(true);
        Statistik.getApp(this);
        settings.setAllowContentAccess(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        this.f5130b.setOnLongClickListener(new v());
        this.f5130b.setLongClickable(false);
        this.f5130b.setHapticFeedbackEnabled(false);
        String userAgentString = settings.getUserAgentString();
        if (this.k.equals("main_activity") && ((SharedPreferences) this.f5137q.f3263b).getBoolean("useragent", false)) {
            this.f5130b.getSettings().setUserAgentString("cbt-exam-browser");
        }
        if ("confirm_activity".equals(this.k)) {
            if ("0".equals(this.j)) {
                Log.d("ExamQR", "custom_useragent equals(0)");
            } else {
                String str = this.j;
                if (str == null || str.trim().isEmpty() || this.j.contains("\n") || this.j.contains("\r")) {
                    settings.setUserAgentString(userAgentString);
                    Log.w("ExamQR", "Invalid UA from confirm_activity, fallback to default.");
                } else {
                    settings.setUserAgentString(this.j.trim());
                }
            }
        }
        getOnBackPressedDispatcher().addCallback(this, new j(this, 6));
        final int i2 = 0;
        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ExamQR f5202b;

            {
                this.f5202b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i8 = i2;
                ExamQR examQR = this.f5202b;
                switch (i8) {
                    case 0:
                        ProgressBar progressBar3 = ExamQR.B;
                        examQR.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ExamQR.B;
                        ActivityManager activityManager = examQR.y;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            examQR.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ExamQR.B;
                        examQR.t();
                        break;
                    case 3:
                        examQR.f5130b.goForward();
                        break;
                    case 4:
                        examQR.f5130b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ExamQR.B;
                        examQR.t();
                        break;
                    default:
                        if (1 != examQR.f5135n.intValue()) {
                            Dialog dialog = new Dialog(examQR);
                            dialog.requestWindowFeature(1);
                            dialog.setContentView(R.layout.dg_exit);
                            dialog.setCancelable(true);
                            Window window = dialog.getWindow();
                            Objects.requireNonNull(window);
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                            layoutParams.copyFrom(dialog.getWindow().getAttributes());
                            layoutParams.width = -2;
                            layoutParams.height = -2;
                            dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, 3));
                            dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(examQR, dialog, 2));
                            dialog.show();
                            dialog.getWindow().setAttributes(layoutParams);
                        } else {
                            Toast.makeText(examQR, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(examQR, R.string.toast_exittimer2, 0).show();
                        }
                        break;
                }
            }
        });
        final int i8 = 1;
        findViewById(R.id.btn_pinlayar).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ExamQR f5202b;

            {
                this.f5202b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i8;
                ExamQR examQR = this.f5202b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ExamQR.B;
                        examQR.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ExamQR.B;
                        ActivityManager activityManager = examQR.y;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            examQR.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ExamQR.B;
                        examQR.t();
                        break;
                    case 3:
                        examQR.f5130b.goForward();
                        break;
                    case 4:
                        examQR.f5130b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ExamQR.B;
                        examQR.t();
                        break;
                    default:
                        if (1 != examQR.f5135n.intValue()) {
                            Dialog dialog = new Dialog(examQR);
                            dialog.requestWindowFeature(1);
                            dialog.setContentView(R.layout.dg_exit);
                            dialog.setCancelable(true);
                            Window window = dialog.getWindow();
                            Objects.requireNonNull(window);
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                            layoutParams.copyFrom(dialog.getWindow().getAttributes());
                            layoutParams.width = -2;
                            layoutParams.height = -2;
                            dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, 3));
                            dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(examQR, dialog, 2));
                            dialog.show();
                            dialog.getWindow().setAttributes(layoutParams);
                        } else {
                            Toast.makeText(examQR, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(examQR, R.string.toast_exittimer2, 0).show();
                        }
                        break;
                }
            }
        });
        final int i9 = 2;
        findViewById(R.id.btn_error).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ExamQR f5202b;

            {
                this.f5202b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i9;
                ExamQR examQR = this.f5202b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ExamQR.B;
                        examQR.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ExamQR.B;
                        ActivityManager activityManager = examQR.y;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            examQR.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ExamQR.B;
                        examQR.t();
                        break;
                    case 3:
                        examQR.f5130b.goForward();
                        break;
                    case 4:
                        examQR.f5130b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ExamQR.B;
                        examQR.t();
                        break;
                    default:
                        if (1 != examQR.f5135n.intValue()) {
                            Dialog dialog = new Dialog(examQR);
                            dialog.requestWindowFeature(1);
                            dialog.setContentView(R.layout.dg_exit);
                            dialog.setCancelable(true);
                            Window window = dialog.getWindow();
                            Objects.requireNonNull(window);
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                            layoutParams.copyFrom(dialog.getWindow().getAttributes());
                            layoutParams.width = -2;
                            layoutParams.height = -2;
                            dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, 3));
                            dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(examQR, dialog, 2));
                            dialog.show();
                            dialog.getWindow().setAttributes(layoutParams);
                        } else {
                            Toast.makeText(examQR, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(examQR, R.string.toast_exittimer2, 0).show();
                        }
                        break;
                }
            }
        });
        final int i10 = 3;
        findViewById(R.id.btn_forward).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ExamQR f5202b;

            {
                this.f5202b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i10;
                ExamQR examQR = this.f5202b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ExamQR.B;
                        examQR.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ExamQR.B;
                        ActivityManager activityManager = examQR.y;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            examQR.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ExamQR.B;
                        examQR.t();
                        break;
                    case 3:
                        examQR.f5130b.goForward();
                        break;
                    case 4:
                        examQR.f5130b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ExamQR.B;
                        examQR.t();
                        break;
                    default:
                        if (1 != examQR.f5135n.intValue()) {
                            Dialog dialog = new Dialog(examQR);
                            dialog.requestWindowFeature(1);
                            dialog.setContentView(R.layout.dg_exit);
                            dialog.setCancelable(true);
                            Window window = dialog.getWindow();
                            Objects.requireNonNull(window);
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                            layoutParams.copyFrom(dialog.getWindow().getAttributes());
                            layoutParams.width = -2;
                            layoutParams.height = -2;
                            dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, 3));
                            dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(examQR, dialog, 2));
                            dialog.show();
                            dialog.getWindow().setAttributes(layoutParams);
                        } else {
                            Toast.makeText(examQR, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(examQR, R.string.toast_exittimer2, 0).show();
                        }
                        break;
                }
            }
        });
        final int i11 = 4;
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ExamQR f5202b;

            {
                this.f5202b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i11;
                ExamQR examQR = this.f5202b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ExamQR.B;
                        examQR.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ExamQR.B;
                        ActivityManager activityManager = examQR.y;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            examQR.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ExamQR.B;
                        examQR.t();
                        break;
                    case 3:
                        examQR.f5130b.goForward();
                        break;
                    case 4:
                        examQR.f5130b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ExamQR.B;
                        examQR.t();
                        break;
                    default:
                        if (1 != examQR.f5135n.intValue()) {
                            Dialog dialog = new Dialog(examQR);
                            dialog.requestWindowFeature(1);
                            dialog.setContentView(R.layout.dg_exit);
                            dialog.setCancelable(true);
                            Window window = dialog.getWindow();
                            Objects.requireNonNull(window);
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                            layoutParams.copyFrom(dialog.getWindow().getAttributes());
                            layoutParams.width = -2;
                            layoutParams.height = -2;
                            dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, 3));
                            dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(examQR, dialog, 2));
                            dialog.show();
                            dialog.getWindow().setAttributes(layoutParams);
                        } else {
                            Toast.makeText(examQR, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(examQR, R.string.toast_exittimer2, 0).show();
                        }
                        break;
                }
            }
        });
        final int i12 = 5;
        findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ExamQR f5202b;

            {
                this.f5202b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i12;
                ExamQR examQR = this.f5202b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ExamQR.B;
                        examQR.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ExamQR.B;
                        ActivityManager activityManager = examQR.y;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            examQR.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ExamQR.B;
                        examQR.t();
                        break;
                    case 3:
                        examQR.f5130b.goForward();
                        break;
                    case 4:
                        examQR.f5130b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ExamQR.B;
                        examQR.t();
                        break;
                    default:
                        if (1 != examQR.f5135n.intValue()) {
                            Dialog dialog = new Dialog(examQR);
                            dialog.requestWindowFeature(1);
                            dialog.setContentView(R.layout.dg_exit);
                            dialog.setCancelable(true);
                            Window window = dialog.getWindow();
                            Objects.requireNonNull(window);
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                            layoutParams.copyFrom(dialog.getWindow().getAttributes());
                            layoutParams.width = -2;
                            layoutParams.height = -2;
                            dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, 3));
                            dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(examQR, dialog, 2));
                            dialog.show();
                            dialog.getWindow().setAttributes(layoutParams);
                        } else {
                            Toast.makeText(examQR, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(examQR, R.string.toast_exittimer2, 0).show();
                        }
                        break;
                }
            }
        });
        final int i13 = 6;
        findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.w

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ExamQR f5202b;

            {
                this.f5202b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i13;
                ExamQR examQR = this.f5202b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ExamQR.B;
                        examQR.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ExamQR.B;
                        ActivityManager activityManager = examQR.y;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            examQR.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ExamQR.B;
                        examQR.t();
                        break;
                    case 3:
                        examQR.f5130b.goForward();
                        break;
                    case 4:
                        examQR.f5130b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ExamQR.B;
                        examQR.t();
                        break;
                    default:
                        if (1 != examQR.f5135n.intValue()) {
                            Dialog dialog = new Dialog(examQR);
                            dialog.requestWindowFeature(1);
                            dialog.setContentView(R.layout.dg_exit);
                            dialog.setCancelable(true);
                            Window window = dialog.getWindow();
                            Objects.requireNonNull(window);
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                            layoutParams.copyFrom(dialog.getWindow().getAttributes());
                            layoutParams.width = -2;
                            layoutParams.height = -2;
                            dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, 3));
                            dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(examQR, dialog, 2));
                            dialog.show();
                            dialog.getWindow().setAttributes(layoutParams);
                        } else {
                            Toast.makeText(examQR, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(examQR, R.string.toast_exittimer2, 0).show();
                        }
                        break;
                }
            }
        });
        s();
        if (Build.VERSION.SDK_INT < 30) {
            getWindow().getDecorView().setSystemUiVisibility(4870);
        } else {
            getWindow().getInsetsController().hide(WindowInsets.Type.systemBars());
            getWindow().getInsetsController().setSystemBarsBehavior(2);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f5138r);
        CountDownTimer countDownTimer = this.f5140t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        x xVar = this.f5141u;
        if (xVar != null) {
            xVar.cancel();
        }
        this.f5145z = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 187) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        q();
        r();
        unregisterReceiver(this.f5139s);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        super.onPictureInPictureModeChanged(z2, configuration);
        if (Build.VERSION.SDK_INT < 24 || !isInMultiWindowMode()) {
            return;
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        u();
        Statistik.sendData(this, "cbtexambrowser");
        if (Build.VERSION.SDK_INT >= 24 && isInMultiWindowMode()) {
            finish();
        }
        registerReceiver(this.f5139s, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f5145z = false;
        if (System.currentTimeMillis() - getSharedPreferences("penalty_prefs", 0).getLong("penalty_time", 0L) >= 21600000) {
            SharedPreferences.Editor editorEdit = getSharedPreferences("penalty_prefs", 0).edit();
            editorEdit.putInt("violation_count", 0);
            editorEdit.putLong("penalty_time", 0L);
            editorEdit.apply();
            Toast.makeText(this, R.string.txt_penalty_hasreset, 0).show();
        }
        String strV = n7.b.v(this);
        this.f5143w.setText(" " + strV);
        String strW = n7.b.w(this);
        this.f5144x.setText(" " + strW);
        int i2 = getSharedPreferences("penalty_prefs", 0).getInt("violation_count", 0);
        this.f5142v.setText(" " + i2 + " x");
        long j = getSharedPreferences("penalty_prefs", 0).getLong("penalty_time", 0L);
        if (j == 0 || j <= System.currentTimeMillis()) {
            this.e.setVisibility(8);
        } else {
            long jCurrentTimeMillis = j - System.currentTimeMillis();
            this.e.setVisibility(0);
            x xVar = this.f5141u;
            if (xVar != null) {
                xVar.cancel();
            }
            x xVar2 = new x(this, jCurrentTimeMillis, 1);
            this.f5141u = xVar2;
            xVar2.start();
        }
        Statistik.getData(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        if (i2 != 20 || this.f5145z) {
            return;
        }
        n7.b.x(this);
        Log.d("Penalty", "Violation count incremented to: " + getSharedPreferences("penalty_prefs", 0).getInt("violation_count", 0));
        Toast.makeText(this, R.string.txt_penalty_record, 0).show();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        q();
        r();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        u();
    }

    public final void q() {
        if (((SharedPreferences) this.f5137q.f3263b).getInt("security_type", 1) != 1) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) ExamQR.class);
        intent.setFlags(603979776);
        try {
            PendingIntent.getActivity(this, 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL).send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }

    public final void r() {
        this.f5130b.clearCache(true);
        this.f5130b.clearFormData();
        this.f5130b.clearHistory();
        this.f5130b.clearMatches();
        this.f5130b.clearSslPreferences();
        CookieManager.getInstance().removeAllCookies(null);
        WebStorage.getInstance().deleteAllData();
    }

    public final void s() {
        String str;
        String str2 = this.f5134i;
        if (str2 == null || str2.trim().isEmpty()) {
            Toast.makeText(this, R.string.txt_exam_urlnotvalid, 1).show();
            return;
        }
        if (this.f5134i.startsWith(ProxyConfig.MATCH_HTTP)) {
            str = this.f5134i;
        } else {
            str = "https://" + this.f5134i;
        }
        this.f5130b.loadUrl(str);
    }

    public final void t() {
        ProgressBar progressBar = this.f5136o;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        String str = this.A;
        if (str == null || str.contains("error.html")) {
            this.f5130b.loadUrl(this.f5134i);
        } else {
            this.f5130b.loadUrl(this.A);
        }
        this.f5132d.setVisibility(8);
    }

    public final void u() {
        try {
            ActivityManager activityManager = this.y;
            if ((activityManager == null || activityManager.getLockTaskModeState() == 0) ? false : true) {
                return;
            }
            startLockTask();
        } catch (Exception e) {
            Log.e("ExamQR", "Gagal startLockTask: " + e.getMessage());
        }
    }

    public final void v() {
        boolean z2 = true;
        this.f5145z = true;
        Dialog dialog = this.l;
        if (dialog != null && dialog.isShowing()) {
            this.l.dismiss();
        }
        r();
        CountDownTimer countDownTimer = this.f5140t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        x xVar = this.f5141u;
        if (xVar != null) {
            xVar.cancel();
        }
        if (((SharedPreferences) this.f5137q.f3263b).getInt("security_type", 1) == 1) {
            System.exit(0);
        } else {
            try {
                ActivityManager activityManager = this.y;
                if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                    z2 = false;
                }
                if (z2) {
                    stopLockTask();
                }
            } catch (Exception e) {
                Log.e("ExamQR", "Gagal stopLockTask: " + e.getMessage());
            }
        }
        finish();
        this.f5124a.b();
    }
}
