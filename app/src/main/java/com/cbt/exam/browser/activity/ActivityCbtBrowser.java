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
import android.text.Editable;
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
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.webkit.ProxyConfig;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cbt.exam.browser.R;
import com.cbt.exam.browser.util.cbt.BatteryReceiver;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mimikridev.utilmanager.config.Statistik;
import com.mimikridev.utilmanager.firebase.FirebaseUtil;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ActivityCbtBrowser extends BaseActivity {
    public static ProgressBar P;
    public String A;
    public String B;
    public String C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public Dialog N;
    public Integer O;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f5061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RelativeLayout f5062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RelativeLayout f5063d;
    public RelativeLayout e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f5064f;
    public LinearLayout g;
    public TextView h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f5065i;
    public ProgressBar j;
    public ImageView k;
    public ImageView l;
    public android.support.v4.media.g m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BatteryReceiver f5066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public h f5067o;
    public CountDownTimer p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public k f5068q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f5069r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f5070s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f5071t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ActivityManager f5072u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f5073v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f5074w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f5075x;
    public String y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f5076z;

    @Override // com.cbt.exam.browser.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        this.f5072u = (ActivityManager) getSystemService("activity");
        setContentView(R.layout.activity_exam);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("config_json");
        String str3 = "ExamQR";
        if (stringExtra != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.f5075x = jSONObject.optString("url", "");
                this.y = jSONObject.optString("nama_ujian", "");
                this.f5076z = jSONObject.optString("nama_sekolah", "");
                this.A = jSONObject.optString("logo", "");
                this.E = jSONObject.optBoolean("custom_ua_status", false);
                this.B = jSONObject.optString("custom_ua", "");
                this.F = jSONObject.optBoolean("timer_status", false);
                this.O = Integer.valueOf(jSONObject.optInt("timer", 0));
                this.M = jSONObject.optBoolean("msg_status", false);
                jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, "");
                this.L = jSONObject.optBoolean("token_masuk_status", false);
                jSONObject.optString("token_masuk", "");
                this.G = jSONObject.optBoolean("token_keluar_status", false);
                this.C = jSONObject.optString("token_keluar", "");
                this.H = jSONObject.optBoolean("link_keluar_status", false);
                this.D = jSONObject.optString("link_keluar", "");
                this.I = jSONObject.optBoolean("allow_copy_paste", false);
                this.J = jSONObject.optBoolean("allow_screenshoot", false);
                this.K = jSONObject.optBoolean("clear_cache", false);
                str = str3;
            } catch (JSONException e) {
                e = e;
                str = str3;
            }
            try {
                Log.d(str, "URL: " + this.f5075x);
                Log.d(str, "Timer Status: " + this.F + ", Timer Value: " + this.O);
                StringBuilder sb = new StringBuilder("Custom UA Status: ");
                sb.append(this.E);
                Log.d(str, sb.toString());
                Log.d(str, "Allow Copy Paste: " + this.I);
                Log.d(str, "Token Masuk Status: " + this.L);
                Log.d(str, "Message Status: " + this.M);
            } catch (JSONException e4) {
                e = e4;
                e.printStackTrace();
                Toast.makeText(this, "Error parsing config JSON", 0).show();
                finish();
            }
            str3 = str;
        } else {
            this.f5075x = intent.getStringExtra("url");
            this.y = intent.getStringExtra("nama_ujian");
            this.f5076z = intent.getStringExtra("nama_sekolah");
            this.A = intent.getStringExtra("logo");
            this.B = intent.getStringExtra("custom_ua");
            this.E = intent.getBooleanExtra("custom_ua_status", false);
            this.O = Integer.valueOf(intent.getIntExtra("timer", 0));
            this.F = intent.getBooleanExtra("timer_status", false);
            this.C = intent.getStringExtra("token_keluar");
            this.G = intent.getBooleanExtra("token_keluar_status", false);
            this.D = intent.getStringExtra("link_keluar");
            this.H = intent.getBooleanExtra("link_keluar_status", false);
            this.I = intent.getBooleanExtra("allow_copy_paste", false);
            this.J = intent.getBooleanExtra("allow_screenshoot", false);
            this.K = intent.getBooleanExtra("clear_cache", false);
            this.L = false;
            this.M = false;
        }
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        if (this.J) {
            getWindow().clearFlags(8192);
        } else {
            getWindow().setFlags(8192, 8192);
        }
        getWindow().addFlags(128);
        getWindow().addFlags(4194304);
        this.m = new android.support.v4.media.g((BaseActivity) this);
        BatteryReceiver batteryReceiver = new BatteryReceiver((TextView) findViewById(R.id.batterai_stat));
        this.f5066n = batteryReceiver;
        registerReceiver(batteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.e = (RelativeLayout) findViewById(R.id.rel_penalty);
        this.f5069r = (TextView) findViewById(R.id.txt_penaltycount);
        this.f5070s = (TextView) findViewById(R.id.txt_penaltyterakhir);
        this.f5071t = (TextView) findViewById(R.id.txt_penaltyreset);
        this.h = (TextView) findViewById(R.id.txt_error);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.loading_icon);
        this.j = progressBar;
        progressBar.setVisibility(0);
        this.k = (ImageView) findViewById(R.id.type_jaringan);
        ProgressBar progressBar2 = (ProgressBar) findViewById(R.id.progress_bar);
        P = progressBar2;
        progressBar2.setVisibility(0);
        P.setProgress(0);
        P.setAlpha(1.0f);
        this.f5064f = (LinearLayout) findViewById(R.id.lyt_timer);
        this.g = (LinearLayout) findViewById(R.id.lyt_logo);
        this.f5063d = (RelativeLayout) findViewById(R.id.rel_url_error);
        this.f5062c = (RelativeLayout) findViewById(R.id.rel_offline);
        String str4 = this.f5076z;
        if (str4 != null && !str4.isEmpty()) {
            ((TextView) findViewById(R.id.nama_sekolah)).setText(this.f5076z);
        }
        String str5 = this.y;
        if (str5 != null && !str5.isEmpty()) {
            ((TextView) findViewById(R.id.nama_ujian)).setText(this.y);
        }
        String str6 = this.A;
        if (str6 != null && !str6.isEmpty()) {
            this.l = (ImageView) findViewById(R.id.logo);
            Glide.with((FragmentActivity) this).load(this.A).placeholder(R.drawable.icon).thumbnail(0.3f).diskCacheStrategy(DiskCacheStrategy.ALL).into(this.l);
            this.g.setVisibility(0);
        }
        this.f5065i = (TextView) findViewById(R.id.waktu_ujian);
        if (!this.F || this.O.intValue() <= 0) {
            this.f5064f.setVisibility(8);
        } else {
            this.f5064f.setVisibility(0);
            this.p = new k(this, TimeUnit.MINUTES.toMillis(this.O.intValue()), 0).start();
        }
        this.f5067o = new h(this, 0);
        FirebaseUtil.logScreen(this, "Exam QR");
        WebView webView = (WebView) findViewById(R.id.webView);
        this.f5061b = webView;
        webView.setWebViewClient(new n(this));
        this.f5061b.setWebChromeClient(new l(0));
        this.f5061b.getSettings().setMediaPlaybackRequiresUserGesture(false);
        WebSettings settings = this.f5061b.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.getUserAgentString();
        if (this.E && (str2 = this.B) != null && !str2.trim().isEmpty()) {
            settings.setUserAgentString(this.B.trim());
            Log.d(str3, "Custom User Agent applied: " + this.B);
        }
        if (this.I) {
            this.f5061b.setLongClickable(true);
            this.f5061b.setHapticFeedbackEnabled(true);
            this.f5061b.setOnLongClickListener(null);
            this.f5061b.setOnCreateContextMenuListener(new c());
            Log.d("WebView", "✅ Copy-paste diizinkan");
        } else {
            this.f5061b.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.cbt.exam.browser.activity.a
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    ProgressBar progressBar3 = ActivityCbtBrowser.P;
                    ActivityCbtBrowser activityCbtBrowser = this.f5156a;
                    activityCbtBrowser.getClass();
                    Toast.makeText(activityCbtBrowser, R.string.txt_notallowcopypaste, 0).show();
                    return true;
                }
            });
            this.f5061b.setLongClickable(false);
            this.f5061b.setHapticFeedbackEnabled(false);
            this.f5061b.setOnCreateContextMenuListener(null);
            this.f5061b.setOnDragListener(new b());
        }
        getOnBackPressedDispatcher().addCallback(this, new j(this, 0));
        final int i2 = 0;
        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCbtBrowser f5171b;

            {
                this.f5171b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str7;
                int i8 = i2;
                final ActivityCbtBrowser activityCbtBrowser = this.f5171b;
                switch (i8) {
                    case 0:
                        ProgressBar progressBar3 = ActivityCbtBrowser.P;
                        activityCbtBrowser.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ActivityCbtBrowser.P;
                        ActivityManager activityManager = activityCbtBrowser.f5072u;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            activityCbtBrowser.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    case 3:
                        activityCbtBrowser.f5061b.goForward();
                        break;
                    case 4:
                        activityCbtBrowser.f5061b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    default:
                        int i9 = 0;
                        if (activityCbtBrowser.F && activityCbtBrowser.O.intValue() > 0) {
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer2, 0).show();
                        } else {
                            int i10 = 1;
                            if (!activityCbtBrowser.G || (str7 = activityCbtBrowser.C) == null || str7.isEmpty()) {
                                Dialog dialog = new Dialog(activityCbtBrowser);
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
                                dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, i10));
                                dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(activityCbtBrowser, dialog, i9));
                                dialog.show();
                                dialog.getWindow().setAttributes(layoutParams);
                            } else {
                                final Dialog dialog2 = new Dialog(activityCbtBrowser);
                                dialog2.requestWindowFeature(1);
                                dialog2.setContentView(R.layout.dg_token);
                                dialog2.setCancelable(true);
                                Window window2 = dialog2.getWindow();
                                Objects.requireNonNull(window2);
                                window2.setBackgroundDrawable(new ColorDrawable(0));
                                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                                layoutParams2.copyFrom(dialog2.getWindow().getAttributes());
                                layoutParams2.width = -2;
                                layoutParams2.height = -2;
                                dialog2.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog2, i9));
                                TextView textView = (TextView) dialog2.findViewById(R.id.txt_judul);
                                TextView textView2 = (TextView) dialog2.findViewById(R.id.txt_msg);
                                final TextInputEditText textInputEditText = (TextInputEditText) dialog2.findViewById(R.id.input_token);
                                final TextInputLayout textInputLayout = (TextInputLayout) dialog2.findViewById(R.id.lyt_input_token);
                                textView.setText(activityCbtBrowser.getString(R.string.txt_token_judul_out));
                                textView2.setText(activityCbtBrowser.getString(R.string.txt_token_msg));
                                dialog2.findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() { // from class: com.cbt.exam.browser.activity.e
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        ProgressBar progressBar7 = ActivityCbtBrowser.P;
                                        ActivityCbtBrowser activityCbtBrowser2 = activityCbtBrowser;
                                        activityCbtBrowser2.getClass();
                                        TextInputEditText textInputEditText2 = textInputEditText;
                                        Editable text = textInputEditText2.getText();
                                        Objects.requireNonNull(text);
                                        boolean zIsEmpty = text.toString().trim().isEmpty();
                                        TextInputLayout textInputLayout2 = textInputLayout;
                                        if (zIsEmpty) {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_warn));
                                            return;
                                        }
                                        textInputLayout2.setErrorEnabled(false);
                                        if (textInputEditText2.getText().toString().trim().equals(activityCbtBrowser2.C)) {
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast1), 1).show();
                                            activityCbtBrowser2.v();
                                        } else {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_toast2));
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast2), 0).show();
                                        }
                                        dialog2.dismiss();
                                    }
                                });
                                dialog2.show();
                                dialog2.getWindow().setAttributes(layoutParams2);
                            }
                        }
                        break;
                }
            }
        });
        final int i8 = 1;
        findViewById(R.id.btn_pinlayar).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCbtBrowser f5171b;

            {
                this.f5171b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str7;
                int i82 = i8;
                final ActivityCbtBrowser activityCbtBrowser = this.f5171b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ActivityCbtBrowser.P;
                        activityCbtBrowser.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ActivityCbtBrowser.P;
                        ActivityManager activityManager = activityCbtBrowser.f5072u;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            activityCbtBrowser.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    case 3:
                        activityCbtBrowser.f5061b.goForward();
                        break;
                    case 4:
                        activityCbtBrowser.f5061b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    default:
                        int i9 = 0;
                        if (activityCbtBrowser.F && activityCbtBrowser.O.intValue() > 0) {
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer2, 0).show();
                        } else {
                            int i10 = 1;
                            if (!activityCbtBrowser.G || (str7 = activityCbtBrowser.C) == null || str7.isEmpty()) {
                                Dialog dialog = new Dialog(activityCbtBrowser);
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
                                dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, i10));
                                dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(activityCbtBrowser, dialog, i9));
                                dialog.show();
                                dialog.getWindow().setAttributes(layoutParams);
                            } else {
                                final Dialog dialog2 = new Dialog(activityCbtBrowser);
                                dialog2.requestWindowFeature(1);
                                dialog2.setContentView(R.layout.dg_token);
                                dialog2.setCancelable(true);
                                Window window2 = dialog2.getWindow();
                                Objects.requireNonNull(window2);
                                window2.setBackgroundDrawable(new ColorDrawable(0));
                                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                                layoutParams2.copyFrom(dialog2.getWindow().getAttributes());
                                layoutParams2.width = -2;
                                layoutParams2.height = -2;
                                dialog2.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog2, i9));
                                TextView textView = (TextView) dialog2.findViewById(R.id.txt_judul);
                                TextView textView2 = (TextView) dialog2.findViewById(R.id.txt_msg);
                                final TextInputEditText textInputEditText = (TextInputEditText) dialog2.findViewById(R.id.input_token);
                                final TextInputLayout textInputLayout = (TextInputLayout) dialog2.findViewById(R.id.lyt_input_token);
                                textView.setText(activityCbtBrowser.getString(R.string.txt_token_judul_out));
                                textView2.setText(activityCbtBrowser.getString(R.string.txt_token_msg));
                                dialog2.findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() { // from class: com.cbt.exam.browser.activity.e
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        ProgressBar progressBar7 = ActivityCbtBrowser.P;
                                        ActivityCbtBrowser activityCbtBrowser2 = activityCbtBrowser;
                                        activityCbtBrowser2.getClass();
                                        TextInputEditText textInputEditText2 = textInputEditText;
                                        Editable text = textInputEditText2.getText();
                                        Objects.requireNonNull(text);
                                        boolean zIsEmpty = text.toString().trim().isEmpty();
                                        TextInputLayout textInputLayout2 = textInputLayout;
                                        if (zIsEmpty) {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_warn));
                                            return;
                                        }
                                        textInputLayout2.setErrorEnabled(false);
                                        if (textInputEditText2.getText().toString().trim().equals(activityCbtBrowser2.C)) {
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast1), 1).show();
                                            activityCbtBrowser2.v();
                                        } else {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_toast2));
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast2), 0).show();
                                        }
                                        dialog2.dismiss();
                                    }
                                });
                                dialog2.show();
                                dialog2.getWindow().setAttributes(layoutParams2);
                            }
                        }
                        break;
                }
            }
        });
        final int i9 = 2;
        findViewById(R.id.btn_error).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCbtBrowser f5171b;

            {
                this.f5171b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str7;
                int i82 = i9;
                final ActivityCbtBrowser activityCbtBrowser = this.f5171b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ActivityCbtBrowser.P;
                        activityCbtBrowser.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ActivityCbtBrowser.P;
                        ActivityManager activityManager = activityCbtBrowser.f5072u;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            activityCbtBrowser.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    case 3:
                        activityCbtBrowser.f5061b.goForward();
                        break;
                    case 4:
                        activityCbtBrowser.f5061b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    default:
                        int i92 = 0;
                        if (activityCbtBrowser.F && activityCbtBrowser.O.intValue() > 0) {
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer2, 0).show();
                        } else {
                            int i10 = 1;
                            if (!activityCbtBrowser.G || (str7 = activityCbtBrowser.C) == null || str7.isEmpty()) {
                                Dialog dialog = new Dialog(activityCbtBrowser);
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
                                dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, i10));
                                dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(activityCbtBrowser, dialog, i92));
                                dialog.show();
                                dialog.getWindow().setAttributes(layoutParams);
                            } else {
                                final Dialog dialog2 = new Dialog(activityCbtBrowser);
                                dialog2.requestWindowFeature(1);
                                dialog2.setContentView(R.layout.dg_token);
                                dialog2.setCancelable(true);
                                Window window2 = dialog2.getWindow();
                                Objects.requireNonNull(window2);
                                window2.setBackgroundDrawable(new ColorDrawable(0));
                                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                                layoutParams2.copyFrom(dialog2.getWindow().getAttributes());
                                layoutParams2.width = -2;
                                layoutParams2.height = -2;
                                dialog2.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog2, i92));
                                TextView textView = (TextView) dialog2.findViewById(R.id.txt_judul);
                                TextView textView2 = (TextView) dialog2.findViewById(R.id.txt_msg);
                                final TextInputEditText textInputEditText = (TextInputEditText) dialog2.findViewById(R.id.input_token);
                                final TextInputLayout textInputLayout = (TextInputLayout) dialog2.findViewById(R.id.lyt_input_token);
                                textView.setText(activityCbtBrowser.getString(R.string.txt_token_judul_out));
                                textView2.setText(activityCbtBrowser.getString(R.string.txt_token_msg));
                                dialog2.findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() { // from class: com.cbt.exam.browser.activity.e
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        ProgressBar progressBar7 = ActivityCbtBrowser.P;
                                        ActivityCbtBrowser activityCbtBrowser2 = activityCbtBrowser;
                                        activityCbtBrowser2.getClass();
                                        TextInputEditText textInputEditText2 = textInputEditText;
                                        Editable text = textInputEditText2.getText();
                                        Objects.requireNonNull(text);
                                        boolean zIsEmpty = text.toString().trim().isEmpty();
                                        TextInputLayout textInputLayout2 = textInputLayout;
                                        if (zIsEmpty) {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_warn));
                                            return;
                                        }
                                        textInputLayout2.setErrorEnabled(false);
                                        if (textInputEditText2.getText().toString().trim().equals(activityCbtBrowser2.C)) {
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast1), 1).show();
                                            activityCbtBrowser2.v();
                                        } else {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_toast2));
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast2), 0).show();
                                        }
                                        dialog2.dismiss();
                                    }
                                });
                                dialog2.show();
                                dialog2.getWindow().setAttributes(layoutParams2);
                            }
                        }
                        break;
                }
            }
        });
        final int i10 = 3;
        findViewById(R.id.btn_forward).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCbtBrowser f5171b;

            {
                this.f5171b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str7;
                int i82 = i10;
                final ActivityCbtBrowser activityCbtBrowser = this.f5171b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ActivityCbtBrowser.P;
                        activityCbtBrowser.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ActivityCbtBrowser.P;
                        ActivityManager activityManager = activityCbtBrowser.f5072u;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            activityCbtBrowser.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    case 3:
                        activityCbtBrowser.f5061b.goForward();
                        break;
                    case 4:
                        activityCbtBrowser.f5061b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    default:
                        int i92 = 0;
                        if (activityCbtBrowser.F && activityCbtBrowser.O.intValue() > 0) {
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer2, 0).show();
                        } else {
                            int i102 = 1;
                            if (!activityCbtBrowser.G || (str7 = activityCbtBrowser.C) == null || str7.isEmpty()) {
                                Dialog dialog = new Dialog(activityCbtBrowser);
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
                                dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, i102));
                                dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(activityCbtBrowser, dialog, i92));
                                dialog.show();
                                dialog.getWindow().setAttributes(layoutParams);
                            } else {
                                final Dialog dialog2 = new Dialog(activityCbtBrowser);
                                dialog2.requestWindowFeature(1);
                                dialog2.setContentView(R.layout.dg_token);
                                dialog2.setCancelable(true);
                                Window window2 = dialog2.getWindow();
                                Objects.requireNonNull(window2);
                                window2.setBackgroundDrawable(new ColorDrawable(0));
                                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                                layoutParams2.copyFrom(dialog2.getWindow().getAttributes());
                                layoutParams2.width = -2;
                                layoutParams2.height = -2;
                                dialog2.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog2, i92));
                                TextView textView = (TextView) dialog2.findViewById(R.id.txt_judul);
                                TextView textView2 = (TextView) dialog2.findViewById(R.id.txt_msg);
                                final TextInputEditText textInputEditText = (TextInputEditText) dialog2.findViewById(R.id.input_token);
                                final TextInputLayout textInputLayout = (TextInputLayout) dialog2.findViewById(R.id.lyt_input_token);
                                textView.setText(activityCbtBrowser.getString(R.string.txt_token_judul_out));
                                textView2.setText(activityCbtBrowser.getString(R.string.txt_token_msg));
                                dialog2.findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() { // from class: com.cbt.exam.browser.activity.e
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        ProgressBar progressBar7 = ActivityCbtBrowser.P;
                                        ActivityCbtBrowser activityCbtBrowser2 = activityCbtBrowser;
                                        activityCbtBrowser2.getClass();
                                        TextInputEditText textInputEditText2 = textInputEditText;
                                        Editable text = textInputEditText2.getText();
                                        Objects.requireNonNull(text);
                                        boolean zIsEmpty = text.toString().trim().isEmpty();
                                        TextInputLayout textInputLayout2 = textInputLayout;
                                        if (zIsEmpty) {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_warn));
                                            return;
                                        }
                                        textInputLayout2.setErrorEnabled(false);
                                        if (textInputEditText2.getText().toString().trim().equals(activityCbtBrowser2.C)) {
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast1), 1).show();
                                            activityCbtBrowser2.v();
                                        } else {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_toast2));
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast2), 0).show();
                                        }
                                        dialog2.dismiss();
                                    }
                                });
                                dialog2.show();
                                dialog2.getWindow().setAttributes(layoutParams2);
                            }
                        }
                        break;
                }
            }
        });
        final int i11 = 4;
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCbtBrowser f5171b;

            {
                this.f5171b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str7;
                int i82 = i11;
                final ActivityCbtBrowser activityCbtBrowser = this.f5171b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ActivityCbtBrowser.P;
                        activityCbtBrowser.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ActivityCbtBrowser.P;
                        ActivityManager activityManager = activityCbtBrowser.f5072u;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            activityCbtBrowser.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    case 3:
                        activityCbtBrowser.f5061b.goForward();
                        break;
                    case 4:
                        activityCbtBrowser.f5061b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    default:
                        int i92 = 0;
                        if (activityCbtBrowser.F && activityCbtBrowser.O.intValue() > 0) {
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer2, 0).show();
                        } else {
                            int i102 = 1;
                            if (!activityCbtBrowser.G || (str7 = activityCbtBrowser.C) == null || str7.isEmpty()) {
                                Dialog dialog = new Dialog(activityCbtBrowser);
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
                                dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, i102));
                                dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(activityCbtBrowser, dialog, i92));
                                dialog.show();
                                dialog.getWindow().setAttributes(layoutParams);
                            } else {
                                final Dialog dialog2 = new Dialog(activityCbtBrowser);
                                dialog2.requestWindowFeature(1);
                                dialog2.setContentView(R.layout.dg_token);
                                dialog2.setCancelable(true);
                                Window window2 = dialog2.getWindow();
                                Objects.requireNonNull(window2);
                                window2.setBackgroundDrawable(new ColorDrawable(0));
                                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                                layoutParams2.copyFrom(dialog2.getWindow().getAttributes());
                                layoutParams2.width = -2;
                                layoutParams2.height = -2;
                                dialog2.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog2, i92));
                                TextView textView = (TextView) dialog2.findViewById(R.id.txt_judul);
                                TextView textView2 = (TextView) dialog2.findViewById(R.id.txt_msg);
                                final TextInputEditText textInputEditText = (TextInputEditText) dialog2.findViewById(R.id.input_token);
                                final TextInputLayout textInputLayout = (TextInputLayout) dialog2.findViewById(R.id.lyt_input_token);
                                textView.setText(activityCbtBrowser.getString(R.string.txt_token_judul_out));
                                textView2.setText(activityCbtBrowser.getString(R.string.txt_token_msg));
                                dialog2.findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() { // from class: com.cbt.exam.browser.activity.e
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        ProgressBar progressBar7 = ActivityCbtBrowser.P;
                                        ActivityCbtBrowser activityCbtBrowser2 = activityCbtBrowser;
                                        activityCbtBrowser2.getClass();
                                        TextInputEditText textInputEditText2 = textInputEditText;
                                        Editable text = textInputEditText2.getText();
                                        Objects.requireNonNull(text);
                                        boolean zIsEmpty = text.toString().trim().isEmpty();
                                        TextInputLayout textInputLayout2 = textInputLayout;
                                        if (zIsEmpty) {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_warn));
                                            return;
                                        }
                                        textInputLayout2.setErrorEnabled(false);
                                        if (textInputEditText2.getText().toString().trim().equals(activityCbtBrowser2.C)) {
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast1), 1).show();
                                            activityCbtBrowser2.v();
                                        } else {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_toast2));
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast2), 0).show();
                                        }
                                        dialog2.dismiss();
                                    }
                                });
                                dialog2.show();
                                dialog2.getWindow().setAttributes(layoutParams2);
                            }
                        }
                        break;
                }
            }
        });
        final int i12 = 5;
        findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCbtBrowser f5171b;

            {
                this.f5171b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str7;
                int i82 = i12;
                final ActivityCbtBrowser activityCbtBrowser = this.f5171b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ActivityCbtBrowser.P;
                        activityCbtBrowser.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ActivityCbtBrowser.P;
                        ActivityManager activityManager = activityCbtBrowser.f5072u;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            activityCbtBrowser.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    case 3:
                        activityCbtBrowser.f5061b.goForward();
                        break;
                    case 4:
                        activityCbtBrowser.f5061b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    default:
                        int i92 = 0;
                        if (activityCbtBrowser.F && activityCbtBrowser.O.intValue() > 0) {
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer2, 0).show();
                        } else {
                            int i102 = 1;
                            if (!activityCbtBrowser.G || (str7 = activityCbtBrowser.C) == null || str7.isEmpty()) {
                                Dialog dialog = new Dialog(activityCbtBrowser);
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
                                dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, i102));
                                dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(activityCbtBrowser, dialog, i92));
                                dialog.show();
                                dialog.getWindow().setAttributes(layoutParams);
                            } else {
                                final Dialog dialog2 = new Dialog(activityCbtBrowser);
                                dialog2.requestWindowFeature(1);
                                dialog2.setContentView(R.layout.dg_token);
                                dialog2.setCancelable(true);
                                Window window2 = dialog2.getWindow();
                                Objects.requireNonNull(window2);
                                window2.setBackgroundDrawable(new ColorDrawable(0));
                                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                                layoutParams2.copyFrom(dialog2.getWindow().getAttributes());
                                layoutParams2.width = -2;
                                layoutParams2.height = -2;
                                dialog2.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog2, i92));
                                TextView textView = (TextView) dialog2.findViewById(R.id.txt_judul);
                                TextView textView2 = (TextView) dialog2.findViewById(R.id.txt_msg);
                                final TextInputEditText textInputEditText = (TextInputEditText) dialog2.findViewById(R.id.input_token);
                                final TextInputLayout textInputLayout = (TextInputLayout) dialog2.findViewById(R.id.lyt_input_token);
                                textView.setText(activityCbtBrowser.getString(R.string.txt_token_judul_out));
                                textView2.setText(activityCbtBrowser.getString(R.string.txt_token_msg));
                                dialog2.findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() { // from class: com.cbt.exam.browser.activity.e
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        ProgressBar progressBar7 = ActivityCbtBrowser.P;
                                        ActivityCbtBrowser activityCbtBrowser2 = activityCbtBrowser;
                                        activityCbtBrowser2.getClass();
                                        TextInputEditText textInputEditText2 = textInputEditText;
                                        Editable text = textInputEditText2.getText();
                                        Objects.requireNonNull(text);
                                        boolean zIsEmpty = text.toString().trim().isEmpty();
                                        TextInputLayout textInputLayout2 = textInputLayout;
                                        if (zIsEmpty) {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_warn));
                                            return;
                                        }
                                        textInputLayout2.setErrorEnabled(false);
                                        if (textInputEditText2.getText().toString().trim().equals(activityCbtBrowser2.C)) {
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast1), 1).show();
                                            activityCbtBrowser2.v();
                                        } else {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_toast2));
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast2), 0).show();
                                        }
                                        dialog2.dismiss();
                                    }
                                });
                                dialog2.show();
                                dialog2.getWindow().setAttributes(layoutParams2);
                            }
                        }
                        break;
                }
            }
        });
        final int i13 = 6;
        findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.g

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCbtBrowser f5171b;

            {
                this.f5171b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str7;
                int i82 = i13;
                final ActivityCbtBrowser activityCbtBrowser = this.f5171b;
                switch (i82) {
                    case 0:
                        ProgressBar progressBar3 = ActivityCbtBrowser.P;
                        activityCbtBrowser.s();
                        break;
                    case 1:
                        ProgressBar progressBar4 = ActivityCbtBrowser.P;
                        ActivityManager activityManager = activityCbtBrowser.f5072u;
                        if (activityManager == null || activityManager.getLockTaskModeState() == 0) {
                            activityCbtBrowser.startLockTask();
                        }
                        break;
                    case 2:
                        ProgressBar progressBar5 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    case 3:
                        activityCbtBrowser.f5061b.goForward();
                        break;
                    case 4:
                        activityCbtBrowser.f5061b.goBack();
                        break;
                    case 5:
                        ProgressBar progressBar6 = ActivityCbtBrowser.P;
                        activityCbtBrowser.t();
                        break;
                    default:
                        int i92 = 0;
                        if (activityCbtBrowser.F && activityCbtBrowser.O.intValue() > 0) {
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer1, 0).show();
                            Toast.makeText(activityCbtBrowser, R.string.toast_exittimer2, 0).show();
                        } else {
                            int i102 = 1;
                            if (!activityCbtBrowser.G || (str7 = activityCbtBrowser.C) == null || str7.isEmpty()) {
                                Dialog dialog = new Dialog(activityCbtBrowser);
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
                                dialog.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog, i102));
                                dialog.findViewById(R.id.bt_exit).setOnClickListener(new f(activityCbtBrowser, dialog, i92));
                                dialog.show();
                                dialog.getWindow().setAttributes(layoutParams);
                            } else {
                                final Dialog dialog2 = new Dialog(activityCbtBrowser);
                                dialog2.requestWindowFeature(1);
                                dialog2.setContentView(R.layout.dg_token);
                                dialog2.setCancelable(true);
                                Window window2 = dialog2.getWindow();
                                Objects.requireNonNull(window2);
                                window2.setBackgroundDrawable(new ColorDrawable(0));
                                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                                layoutParams2.copyFrom(dialog2.getWindow().getAttributes());
                                layoutParams2.width = -2;
                                layoutParams2.height = -2;
                                dialog2.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog2, i92));
                                TextView textView = (TextView) dialog2.findViewById(R.id.txt_judul);
                                TextView textView2 = (TextView) dialog2.findViewById(R.id.txt_msg);
                                final TextInputEditText textInputEditText = (TextInputEditText) dialog2.findViewById(R.id.input_token);
                                final TextInputLayout textInputLayout = (TextInputLayout) dialog2.findViewById(R.id.lyt_input_token);
                                textView.setText(activityCbtBrowser.getString(R.string.txt_token_judul_out));
                                textView2.setText(activityCbtBrowser.getString(R.string.txt_token_msg));
                                dialog2.findViewById(R.id.bt_open).setOnClickListener(new View.OnClickListener() { // from class: com.cbt.exam.browser.activity.e
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        ProgressBar progressBar7 = ActivityCbtBrowser.P;
                                        ActivityCbtBrowser activityCbtBrowser2 = activityCbtBrowser;
                                        activityCbtBrowser2.getClass();
                                        TextInputEditText textInputEditText2 = textInputEditText;
                                        Editable text = textInputEditText2.getText();
                                        Objects.requireNonNull(text);
                                        boolean zIsEmpty = text.toString().trim().isEmpty();
                                        TextInputLayout textInputLayout2 = textInputLayout;
                                        if (zIsEmpty) {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_warn));
                                            return;
                                        }
                                        textInputLayout2.setErrorEnabled(false);
                                        if (textInputEditText2.getText().toString().trim().equals(activityCbtBrowser2.C)) {
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast1), 1).show();
                                            activityCbtBrowser2.v();
                                        } else {
                                            textInputLayout2.setError(activityCbtBrowser2.getString(R.string.txt_token_toast2));
                                            Toast.makeText(activityCbtBrowser2, activityCbtBrowser2.getString(R.string.txt_token_toast2), 0).show();
                                        }
                                        dialog2.dismiss();
                                    }
                                });
                                dialog2.show();
                                dialog2.getWindow().setAttributes(layoutParams2);
                            }
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
        unregisterReceiver(this.f5066n);
        CountDownTimer countDownTimer = this.p;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        k kVar = this.f5068q;
        if (kVar != null) {
            kVar.cancel();
        }
        this.f5073v = true;
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
        if (true) return;
        super.onPause();
        q();
        r();
        unregisterReceiver(this.f5067o);
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
        registerReceiver(this.f5067o, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f5073v = false;
        if (System.currentTimeMillis() - getSharedPreferences("penalty_prefs", 0).getLong("penalty_time", 0L) >= 21600000) {
            SharedPreferences.Editor editorEdit = getSharedPreferences("penalty_prefs", 0).edit();
            editorEdit.putInt("violation_count", 0);
            editorEdit.putLong("penalty_time", 0L);
            editorEdit.apply();
            Toast.makeText(this, R.string.txt_penalty_hasreset, 0).show();
        }
        String strV = n7.b.v(this);
        this.f5070s.setText(" " + strV);
        String strW = n7.b.w(this);
        this.f5071t.setText(" " + strW);
        int i2 = getSharedPreferences("penalty_prefs", 0).getInt("violation_count", 0);
        this.f5069r.setText(" " + i2 + " x");
        long j = getSharedPreferences("penalty_prefs", 0).getLong("penalty_time", 0L);
        if (j == 0 || j <= System.currentTimeMillis()) {
            this.e.setVisibility(8);
        } else {
            long jCurrentTimeMillis = j - System.currentTimeMillis();
            this.e.setVisibility(0);
            k kVar = this.f5068q;
            if (kVar != null) {
                kVar.cancel();
            }
            k kVar2 = new k(this, jCurrentTimeMillis, 1);
            this.f5068q = kVar2;
            kVar2.start();
        }
        Statistik.getData(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
    if (true) return; // <--- TAMBAHKAN BARIS INI
    super.onTrimMemory(i2);
    if (i2 != 20 || this.f5073v) {
        return;
    }
    n7.b.x(this); // Ini fungsi jahanam yang naikin violation_count
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
        if (((SharedPreferences) this.m.f3263b).getInt("security_type", 1) != 1) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) ActivityCbtBrowser.class);
        intent.setFlags(603979776);
        try {
            PendingIntent.getActivity(this, 0, intent, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL).send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }

    public final void r() {
        if (this.K) {
            this.f5061b.clearCache(true);
            this.f5061b.clearFormData();
            this.f5061b.clearHistory();
            this.f5061b.clearMatches();
            this.f5061b.clearSslPreferences();
            CookieManager.getInstance().removeAllCookies(null);
            WebStorage.getInstance().deleteAllData();
        }
    }

    public final void s() {
        String str;
        String str2 = this.f5075x;
        if (str2 == null || str2.trim().isEmpty()) {
            Toast.makeText(this, R.string.txt_exam_urlnotvalid, 1).show();
            return;
        }
        if (this.f5075x.startsWith(ProxyConfig.MATCH_HTTP)) {
            str = this.f5075x;
        } else {
            str = "https://" + this.f5075x;
        }
        this.f5061b.loadUrl(str);
    }

    public final void t() {
        ProgressBar progressBar = this.j;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        String str = this.f5074w;
        if (str == null || str.contains("error.html")) {
            this.f5061b.loadUrl(this.f5075x);
        } else {
            this.f5061b.loadUrl(this.f5074w);
        }
        this.f5063d.setVisibility(8);
    }

    public final void u() {
    if (true) return; // <--- TAMBAHKAN BARIS INI
    try {
        ActivityManager activityManager = this.f5072u;
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
        this.f5073v = true;
        Dialog dialog = this.N;
        if (dialog != null && dialog.isShowing()) {
            this.N.dismiss();
        }
        r();
        CountDownTimer countDownTimer = this.p;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        k kVar = this.f5068q;
        if (kVar != null) {
            kVar.cancel();
        }
        if (((SharedPreferences) this.m.f3263b).getInt("security_type", 1) == 1) {
            System.exit(0);
        } else {
            try {
                ActivityManager activityManager = this.f5072u;
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
