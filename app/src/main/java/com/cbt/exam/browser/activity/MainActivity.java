package com.cbt.exam.browser.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.cardview.widget.CardView;
import androidx.webkit.internal.AssetHelper;
import com.balysv.materialripple.MaterialRippleLayout;
import com.cbt.exam.browser.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mimikridev.ads.appopen.AppOpenAd;
import com.mimikridev.ads.banner.BannerAd;
import com.mimikridev.utilmanager.Tools;
import com.mimikridev.utilmanager.config.ConfigManager;
import com.mimikridev.utilmanager.config.Statistik;
import com.mimikridev.utilmanager.firebase.FirebaseUtil;
import com.mimikridev.utilmanager.theme.ThemeManager;
import com.onesignal.Continue;
import com.onesignal.OneSignal;
import com.onesignal.core.internal.preferences.PreferenceStores;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MainActivity extends BaseActivity {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f5146s = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MaterialRippleLayout f5148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MaterialRippleLayout f5149d;
    public MaterialRippleLayout e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MaterialRippleLayout f5150f;
    public MaterialRippleLayout g;
    public MaterialRippleLayout h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MaterialRippleLayout f5151i;
    public MaterialRippleLayout j;
    public MaterialRippleLayout k;
    public CardView l;
    public CardView m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f5152n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f5153o;
    public TextView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public android.support.v4.media.g f5154q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5147b = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ActivityResultLauncher f5155r = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new androidx.camera.core.impl.b(this, 12));

    @Override // com.cbt.exam.browser.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        try {
            OneSignal.initWithContext(getApplicationContext(), "467bd000-c49d-499f-b8a3-4ac911799361");
            if (OneSignal.getNotifications() != null) {
                try {
                    OneSignal.getNotifications().requestPermission(false, Continue.none());
                } catch (Exception e) {
                    Log.e(PreferenceStores.ONESIGNAL, "Permission error: " + e.getMessage());
                }
            }
            new Handler(Looper.getMainLooper()).postDelayed(new a3.b(this, 17), 2000L);
        } catch (Exception e4) {
            Log.e(PreferenceStores.ONESIGNAL, "Inisialisasi gagal: " + e4.getMessage());
        }
        FirebaseUtil.init(this);
        FirebaseUtil.Properties(this, "free");
        this.f5124a.d();
        android.support.v4.media.g gVar = new android.support.v4.media.g((BaseActivity) this);
        this.f5154q = gVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            SharedPreferences.Editor editor = (SharedPreferences.Editor) gVar.f3264c;
            editor.putInt("security_type", 1);
            editor.apply();
        }
        if (i2 >= 26) {
            SharedPreferences.Editor editor2 = (SharedPreferences.Editor) this.f5154q.f3264c;
            editor2.putInt("security_type", 2);
            editor2.apply();
        }
        new ConfigManager(this, 57).init();
        Statistik.sendData(this, "cbtexambrowser");
        Statistik.getData(this);
        this.f5148c = (MaterialRippleLayout) findViewById(R.id.cd_inputurl);
        this.f5149d = (MaterialRippleLayout) findViewById(R.id.cd_scanqr);
        this.e = (MaterialRippleLayout) findViewById(R.id.cd_bukafile);
        this.f5150f = (MaterialRippleLayout) findViewById(R.id.cd_buatconfig);
        this.g = (MaterialRippleLayout) findViewById(R.id.cd_about);
        this.h = (MaterialRippleLayout) findViewById(R.id.cd_rate);
        this.f5151i = (MaterialRippleLayout) findViewById(R.id.cd_share);
        this.j = (MaterialRippleLayout) findViewById(R.id.cd_setting);
        this.f5152n = (TextView) findViewById(R.id.txt_app_name);
        ((TextView) findViewById(R.id.txt_app_version)).setText("v 6.6");
        this.l = (CardView) findViewById(R.id.cd_app_announcement);
        this.f5153o = (TextView) findViewById(R.id.txt_app_announcement);
        this.m = (CardView) findViewById(R.id.cd_ads);
        this.k = (MaterialRippleLayout) findViewById(R.id.cd_ads_materialripple);
        this.p = (TextView) findViewById(R.id.txt_ads);
        ThemeManager themeManager = new ThemeManager(this);
        if (!themeManager.getAnnouncement().isEmpty()) {
            this.l.setVisibility(0);
            this.f5153o.setText(themeManager.getAnnouncement());
        }
        if (!themeManager.getBtnbelitxt().isEmpty()) {
            this.m.setVisibility(0);
            this.p.setText(themeManager.getBtnbelitxt());
        }
        if (!themeManager.getAppTitle().isEmpty()) {
            this.f5152n.setText(themeManager.getAppTitle());
        }
        if (themeManager.isCustomTheme()) {
            View viewFindViewById = findViewById(R.id.root_view);
            try {
                getWindow().setStatusBarColor(themeManager.getPrimaryColor());
                if (viewFindViewById != null) {
                    Drawable background = viewFindViewById.getBackground();
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background.mutate()).setColors(new int[]{themeManager.getPrimaryColor(), -1});
                    } else {
                        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{themeManager.getPrimaryColor(), -1});
                        gradientDrawable.setShape(0);
                        viewFindViewById.setBackground(gradientDrawable);
                    }
                }
            } catch (Exception e8) {
                Log.e("ThemeManager", "Comprehensive theme error: " + e8.getMessage());
            }
        }
        r(getIntent());
        final int i8 = 0;
        this.k.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.z

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f5207b;

            {
                this.f5207b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i9 = i8;
                MainActivity mainActivity = this.f5207b;
                switch (i9) {
                    case 0:
                        int i10 = MainActivity.f5146s;
                        mainActivity.getClass();
                        try {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cbt.exam.browser.pro")));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                        break;
                    case 1:
                        int i11 = MainActivity.f5146s;
                        MainActivity mainActivity2 = this.f5207b;
                        Dialog dialog = new Dialog(mainActivity2);
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.dg_inputurl);
                        dialog.setCancelable(true);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            window.setLayout(-2, -2);
                            window.setWindowAnimations(R.style.DialogAnimationFadeScale);
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_address);
                        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.input_layout_address);
                        View viewFindViewById2 = dialog.findViewById(R.id.bt_close);
                        View viewFindViewById3 = dialog.findViewById(R.id.btn_enter);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity2);
                        textInputEditText.setText(defaultSharedPreferences.getString("autoSave", ""));
                        textInputEditText.addTextChangedListener(new a0(defaultSharedPreferences));
                        viewFindViewById2.setOnClickListener(new f(mainActivity2, dialog, 3));
                        viewFindViewById3.setOnClickListener(new p(mainActivity2, textInputEditText, textInputLayout, defaultSharedPreferences, dialog, 1));
                        mainActivity2.getWindow().setSoftInputMode(3);
                        dialog.show();
                        break;
                    case 2:
                        int i12 = MainActivity.f5146s;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityScanner.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        ActivityResultLauncher activityResultLauncher = mainActivity.f5155r;
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/*"});
                        activityResultLauncher.launch(intent);
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        int i13 = MainActivity.f5146s;
                        mainActivity.f5124a.g();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityCreateConfig.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        int i14 = MainActivity.f5146s;
                        Dialog dialog2 = new Dialog(mainActivity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setContentView(R.layout.dialog_about);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        Objects.requireNonNull(window2);
                        window2.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        layoutParams.copyFrom(dialog2.getWindow().getAttributes());
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        ((TextView) dialog2.findViewById(R.id.tv_version)).setText("Version 6.6");
                        dialog2.findViewById(R.id.bt_tutup).setOnClickListener(new d(dialog2, 5));
                        dialog2.findViewById(R.id.bt_close).setOnClickListener(new d(dialog2, 6));
                        dialog2.show();
                        dialog2.getWindow().setAttributes(layoutParams);
                        break;
                    case 6:
                        int i15 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Tools.rateApp(mainActivity, "com.cbt.exam.browser");
                        break;
                    case 7:
                        int i16 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.SUBJECT", mainActivity.getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", mainActivity.getString(R.string.btn_share_txt) + "\nhttps://play.google.com/store/apps/details?id=com.cbt.exam.browser");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        mainActivity.startActivity(intent2);
                        break;
                    default:
                        int i17 = MainActivity.f5146s;
                        Dialog dialog3 = new Dialog(mainActivity);
                        dialog3.requestWindowFeature(1);
                        dialog3.setContentView(R.layout.dg_customua);
                        dialog3.setCancelable(true);
                        Window window3 = dialog3.getWindow();
                        Objects.requireNonNull(window3);
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        layoutParams2.copyFrom(dialog3.getWindow().getAttributes());
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        SwitchMaterial switchMaterial = (SwitchMaterial) dialog3.findViewById(R.id.switch_useragent);
                        switchMaterial.setChecked(((SharedPreferences) mainActivity.f5154q.f3263b).getBoolean("useragent", false));
                        switchMaterial.setOnCheckedChangeListener(new r(mainActivity, 2));
                        dialog3.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog3, 4));
                        dialog3.show();
                        dialog3.getWindow().setAttributes(layoutParams2);
                        break;
                }
            }
        });
        final int i9 = 1;
        this.f5148c.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.z

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f5207b;

            {
                this.f5207b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i92 = i9;
                MainActivity mainActivity = this.f5207b;
                switch (i92) {
                    case 0:
                        int i10 = MainActivity.f5146s;
                        mainActivity.getClass();
                        try {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cbt.exam.browser.pro")));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                        break;
                    case 1:
                        int i11 = MainActivity.f5146s;
                        MainActivity mainActivity2 = this.f5207b;
                        Dialog dialog = new Dialog(mainActivity2);
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.dg_inputurl);
                        dialog.setCancelable(true);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            window.setLayout(-2, -2);
                            window.setWindowAnimations(R.style.DialogAnimationFadeScale);
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_address);
                        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.input_layout_address);
                        View viewFindViewById2 = dialog.findViewById(R.id.bt_close);
                        View viewFindViewById3 = dialog.findViewById(R.id.btn_enter);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity2);
                        textInputEditText.setText(defaultSharedPreferences.getString("autoSave", ""));
                        textInputEditText.addTextChangedListener(new a0(defaultSharedPreferences));
                        viewFindViewById2.setOnClickListener(new f(mainActivity2, dialog, 3));
                        viewFindViewById3.setOnClickListener(new p(mainActivity2, textInputEditText, textInputLayout, defaultSharedPreferences, dialog, 1));
                        mainActivity2.getWindow().setSoftInputMode(3);
                        dialog.show();
                        break;
                    case 2:
                        int i12 = MainActivity.f5146s;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityScanner.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        ActivityResultLauncher activityResultLauncher = mainActivity.f5155r;
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/*"});
                        activityResultLauncher.launch(intent);
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        int i13 = MainActivity.f5146s;
                        mainActivity.f5124a.g();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityCreateConfig.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        int i14 = MainActivity.f5146s;
                        Dialog dialog2 = new Dialog(mainActivity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setContentView(R.layout.dialog_about);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        Objects.requireNonNull(window2);
                        window2.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        layoutParams.copyFrom(dialog2.getWindow().getAttributes());
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        ((TextView) dialog2.findViewById(R.id.tv_version)).setText("Version 6.6");
                        dialog2.findViewById(R.id.bt_tutup).setOnClickListener(new d(dialog2, 5));
                        dialog2.findViewById(R.id.bt_close).setOnClickListener(new d(dialog2, 6));
                        dialog2.show();
                        dialog2.getWindow().setAttributes(layoutParams);
                        break;
                    case 6:
                        int i15 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Tools.rateApp(mainActivity, "com.cbt.exam.browser");
                        break;
                    case 7:
                        int i16 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.SUBJECT", mainActivity.getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", mainActivity.getString(R.string.btn_share_txt) + "\nhttps://play.google.com/store/apps/details?id=com.cbt.exam.browser");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        mainActivity.startActivity(intent2);
                        break;
                    default:
                        int i17 = MainActivity.f5146s;
                        Dialog dialog3 = new Dialog(mainActivity);
                        dialog3.requestWindowFeature(1);
                        dialog3.setContentView(R.layout.dg_customua);
                        dialog3.setCancelable(true);
                        Window window3 = dialog3.getWindow();
                        Objects.requireNonNull(window3);
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        layoutParams2.copyFrom(dialog3.getWindow().getAttributes());
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        SwitchMaterial switchMaterial = (SwitchMaterial) dialog3.findViewById(R.id.switch_useragent);
                        switchMaterial.setChecked(((SharedPreferences) mainActivity.f5154q.f3263b).getBoolean("useragent", false));
                        switchMaterial.setOnCheckedChangeListener(new r(mainActivity, 2));
                        dialog3.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog3, 4));
                        dialog3.show();
                        dialog3.getWindow().setAttributes(layoutParams2);
                        break;
                }
            }
        });
        final int i10 = 2;
        this.f5149d.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.z

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f5207b;

            {
                this.f5207b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i92 = i10;
                MainActivity mainActivity = this.f5207b;
                switch (i92) {
                    case 0:
                        int i102 = MainActivity.f5146s;
                        mainActivity.getClass();
                        try {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cbt.exam.browser.pro")));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                        break;
                    case 1:
                        int i11 = MainActivity.f5146s;
                        MainActivity mainActivity2 = this.f5207b;
                        Dialog dialog = new Dialog(mainActivity2);
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.dg_inputurl);
                        dialog.setCancelable(true);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            window.setLayout(-2, -2);
                            window.setWindowAnimations(R.style.DialogAnimationFadeScale);
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_address);
                        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.input_layout_address);
                        View viewFindViewById2 = dialog.findViewById(R.id.bt_close);
                        View viewFindViewById3 = dialog.findViewById(R.id.btn_enter);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity2);
                        textInputEditText.setText(defaultSharedPreferences.getString("autoSave", ""));
                        textInputEditText.addTextChangedListener(new a0(defaultSharedPreferences));
                        viewFindViewById2.setOnClickListener(new f(mainActivity2, dialog, 3));
                        viewFindViewById3.setOnClickListener(new p(mainActivity2, textInputEditText, textInputLayout, defaultSharedPreferences, dialog, 1));
                        mainActivity2.getWindow().setSoftInputMode(3);
                        dialog.show();
                        break;
                    case 2:
                        int i12 = MainActivity.f5146s;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityScanner.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        ActivityResultLauncher activityResultLauncher = mainActivity.f5155r;
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/*"});
                        activityResultLauncher.launch(intent);
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        int i13 = MainActivity.f5146s;
                        mainActivity.f5124a.g();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityCreateConfig.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        int i14 = MainActivity.f5146s;
                        Dialog dialog2 = new Dialog(mainActivity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setContentView(R.layout.dialog_about);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        Objects.requireNonNull(window2);
                        window2.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        layoutParams.copyFrom(dialog2.getWindow().getAttributes());
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        ((TextView) dialog2.findViewById(R.id.tv_version)).setText("Version 6.6");
                        dialog2.findViewById(R.id.bt_tutup).setOnClickListener(new d(dialog2, 5));
                        dialog2.findViewById(R.id.bt_close).setOnClickListener(new d(dialog2, 6));
                        dialog2.show();
                        dialog2.getWindow().setAttributes(layoutParams);
                        break;
                    case 6:
                        int i15 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Tools.rateApp(mainActivity, "com.cbt.exam.browser");
                        break;
                    case 7:
                        int i16 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.SUBJECT", mainActivity.getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", mainActivity.getString(R.string.btn_share_txt) + "\nhttps://play.google.com/store/apps/details?id=com.cbt.exam.browser");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        mainActivity.startActivity(intent2);
                        break;
                    default:
                        int i17 = MainActivity.f5146s;
                        Dialog dialog3 = new Dialog(mainActivity);
                        dialog3.requestWindowFeature(1);
                        dialog3.setContentView(R.layout.dg_customua);
                        dialog3.setCancelable(true);
                        Window window3 = dialog3.getWindow();
                        Objects.requireNonNull(window3);
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        layoutParams2.copyFrom(dialog3.getWindow().getAttributes());
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        SwitchMaterial switchMaterial = (SwitchMaterial) dialog3.findViewById(R.id.switch_useragent);
                        switchMaterial.setChecked(((SharedPreferences) mainActivity.f5154q.f3263b).getBoolean("useragent", false));
                        switchMaterial.setOnCheckedChangeListener(new r(mainActivity, 2));
                        dialog3.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog3, 4));
                        dialog3.show();
                        dialog3.getWindow().setAttributes(layoutParams2);
                        break;
                }
            }
        });
        final int i11 = 3;
        this.e.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.z

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f5207b;

            {
                this.f5207b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i92 = i11;
                MainActivity mainActivity = this.f5207b;
                switch (i92) {
                    case 0:
                        int i102 = MainActivity.f5146s;
                        mainActivity.getClass();
                        try {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cbt.exam.browser.pro")));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                        break;
                    case 1:
                        int i112 = MainActivity.f5146s;
                        MainActivity mainActivity2 = this.f5207b;
                        Dialog dialog = new Dialog(mainActivity2);
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.dg_inputurl);
                        dialog.setCancelable(true);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            window.setLayout(-2, -2);
                            window.setWindowAnimations(R.style.DialogAnimationFadeScale);
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_address);
                        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.input_layout_address);
                        View viewFindViewById2 = dialog.findViewById(R.id.bt_close);
                        View viewFindViewById3 = dialog.findViewById(R.id.btn_enter);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity2);
                        textInputEditText.setText(defaultSharedPreferences.getString("autoSave", ""));
                        textInputEditText.addTextChangedListener(new a0(defaultSharedPreferences));
                        viewFindViewById2.setOnClickListener(new f(mainActivity2, dialog, 3));
                        viewFindViewById3.setOnClickListener(new p(mainActivity2, textInputEditText, textInputLayout, defaultSharedPreferences, dialog, 1));
                        mainActivity2.getWindow().setSoftInputMode(3);
                        dialog.show();
                        break;
                    case 2:
                        int i12 = MainActivity.f5146s;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityScanner.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        ActivityResultLauncher activityResultLauncher = mainActivity.f5155r;
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/*"});
                        activityResultLauncher.launch(intent);
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        int i13 = MainActivity.f5146s;
                        mainActivity.f5124a.g();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityCreateConfig.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        int i14 = MainActivity.f5146s;
                        Dialog dialog2 = new Dialog(mainActivity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setContentView(R.layout.dialog_about);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        Objects.requireNonNull(window2);
                        window2.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        layoutParams.copyFrom(dialog2.getWindow().getAttributes());
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        ((TextView) dialog2.findViewById(R.id.tv_version)).setText("Version 6.6");
                        dialog2.findViewById(R.id.bt_tutup).setOnClickListener(new d(dialog2, 5));
                        dialog2.findViewById(R.id.bt_close).setOnClickListener(new d(dialog2, 6));
                        dialog2.show();
                        dialog2.getWindow().setAttributes(layoutParams);
                        break;
                    case 6:
                        int i15 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Tools.rateApp(mainActivity, "com.cbt.exam.browser");
                        break;
                    case 7:
                        int i16 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.SUBJECT", mainActivity.getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", mainActivity.getString(R.string.btn_share_txt) + "\nhttps://play.google.com/store/apps/details?id=com.cbt.exam.browser");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        mainActivity.startActivity(intent2);
                        break;
                    default:
                        int i17 = MainActivity.f5146s;
                        Dialog dialog3 = new Dialog(mainActivity);
                        dialog3.requestWindowFeature(1);
                        dialog3.setContentView(R.layout.dg_customua);
                        dialog3.setCancelable(true);
                        Window window3 = dialog3.getWindow();
                        Objects.requireNonNull(window3);
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        layoutParams2.copyFrom(dialog3.getWindow().getAttributes());
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        SwitchMaterial switchMaterial = (SwitchMaterial) dialog3.findViewById(R.id.switch_useragent);
                        switchMaterial.setChecked(((SharedPreferences) mainActivity.f5154q.f3263b).getBoolean("useragent", false));
                        switchMaterial.setOnCheckedChangeListener(new r(mainActivity, 2));
                        dialog3.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog3, 4));
                        dialog3.show();
                        dialog3.getWindow().setAttributes(layoutParams2);
                        break;
                }
            }
        });
        final int i12 = 4;
        this.f5150f.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.z

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f5207b;

            {
                this.f5207b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i92 = i12;
                MainActivity mainActivity = this.f5207b;
                switch (i92) {
                    case 0:
                        int i102 = MainActivity.f5146s;
                        mainActivity.getClass();
                        try {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cbt.exam.browser.pro")));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                        break;
                    case 1:
                        int i112 = MainActivity.f5146s;
                        MainActivity mainActivity2 = this.f5207b;
                        Dialog dialog = new Dialog(mainActivity2);
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.dg_inputurl);
                        dialog.setCancelable(true);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            window.setLayout(-2, -2);
                            window.setWindowAnimations(R.style.DialogAnimationFadeScale);
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_address);
                        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.input_layout_address);
                        View viewFindViewById2 = dialog.findViewById(R.id.bt_close);
                        View viewFindViewById3 = dialog.findViewById(R.id.btn_enter);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity2);
                        textInputEditText.setText(defaultSharedPreferences.getString("autoSave", ""));
                        textInputEditText.addTextChangedListener(new a0(defaultSharedPreferences));
                        viewFindViewById2.setOnClickListener(new f(mainActivity2, dialog, 3));
                        viewFindViewById3.setOnClickListener(new p(mainActivity2, textInputEditText, textInputLayout, defaultSharedPreferences, dialog, 1));
                        mainActivity2.getWindow().setSoftInputMode(3);
                        dialog.show();
                        break;
                    case 2:
                        int i122 = MainActivity.f5146s;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityScanner.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        ActivityResultLauncher activityResultLauncher = mainActivity.f5155r;
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/*"});
                        activityResultLauncher.launch(intent);
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        int i13 = MainActivity.f5146s;
                        mainActivity.f5124a.g();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityCreateConfig.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        int i14 = MainActivity.f5146s;
                        Dialog dialog2 = new Dialog(mainActivity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setContentView(R.layout.dialog_about);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        Objects.requireNonNull(window2);
                        window2.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        layoutParams.copyFrom(dialog2.getWindow().getAttributes());
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        ((TextView) dialog2.findViewById(R.id.tv_version)).setText("Version 6.6");
                        dialog2.findViewById(R.id.bt_tutup).setOnClickListener(new d(dialog2, 5));
                        dialog2.findViewById(R.id.bt_close).setOnClickListener(new d(dialog2, 6));
                        dialog2.show();
                        dialog2.getWindow().setAttributes(layoutParams);
                        break;
                    case 6:
                        int i15 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Tools.rateApp(mainActivity, "com.cbt.exam.browser");
                        break;
                    case 7:
                        int i16 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.SUBJECT", mainActivity.getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", mainActivity.getString(R.string.btn_share_txt) + "\nhttps://play.google.com/store/apps/details?id=com.cbt.exam.browser");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        mainActivity.startActivity(intent2);
                        break;
                    default:
                        int i17 = MainActivity.f5146s;
                        Dialog dialog3 = new Dialog(mainActivity);
                        dialog3.requestWindowFeature(1);
                        dialog3.setContentView(R.layout.dg_customua);
                        dialog3.setCancelable(true);
                        Window window3 = dialog3.getWindow();
                        Objects.requireNonNull(window3);
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        layoutParams2.copyFrom(dialog3.getWindow().getAttributes());
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        SwitchMaterial switchMaterial = (SwitchMaterial) dialog3.findViewById(R.id.switch_useragent);
                        switchMaterial.setChecked(((SharedPreferences) mainActivity.f5154q.f3263b).getBoolean("useragent", false));
                        switchMaterial.setOnCheckedChangeListener(new r(mainActivity, 2));
                        dialog3.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog3, 4));
                        dialog3.show();
                        dialog3.getWindow().setAttributes(layoutParams2);
                        break;
                }
            }
        });
        final int i13 = 5;
        this.g.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.z

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f5207b;

            {
                this.f5207b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i92 = i13;
                MainActivity mainActivity = this.f5207b;
                switch (i92) {
                    case 0:
                        int i102 = MainActivity.f5146s;
                        mainActivity.getClass();
                        try {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cbt.exam.browser.pro")));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                        break;
                    case 1:
                        int i112 = MainActivity.f5146s;
                        MainActivity mainActivity2 = this.f5207b;
                        Dialog dialog = new Dialog(mainActivity2);
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.dg_inputurl);
                        dialog.setCancelable(true);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            window.setLayout(-2, -2);
                            window.setWindowAnimations(R.style.DialogAnimationFadeScale);
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_address);
                        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.input_layout_address);
                        View viewFindViewById2 = dialog.findViewById(R.id.bt_close);
                        View viewFindViewById3 = dialog.findViewById(R.id.btn_enter);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity2);
                        textInputEditText.setText(defaultSharedPreferences.getString("autoSave", ""));
                        textInputEditText.addTextChangedListener(new a0(defaultSharedPreferences));
                        viewFindViewById2.setOnClickListener(new f(mainActivity2, dialog, 3));
                        viewFindViewById3.setOnClickListener(new p(mainActivity2, textInputEditText, textInputLayout, defaultSharedPreferences, dialog, 1));
                        mainActivity2.getWindow().setSoftInputMode(3);
                        dialog.show();
                        break;
                    case 2:
                        int i122 = MainActivity.f5146s;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityScanner.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        ActivityResultLauncher activityResultLauncher = mainActivity.f5155r;
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/*"});
                        activityResultLauncher.launch(intent);
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        int i132 = MainActivity.f5146s;
                        mainActivity.f5124a.g();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityCreateConfig.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        int i14 = MainActivity.f5146s;
                        Dialog dialog2 = new Dialog(mainActivity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setContentView(R.layout.dialog_about);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        Objects.requireNonNull(window2);
                        window2.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        layoutParams.copyFrom(dialog2.getWindow().getAttributes());
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        ((TextView) dialog2.findViewById(R.id.tv_version)).setText("Version 6.6");
                        dialog2.findViewById(R.id.bt_tutup).setOnClickListener(new d(dialog2, 5));
                        dialog2.findViewById(R.id.bt_close).setOnClickListener(new d(dialog2, 6));
                        dialog2.show();
                        dialog2.getWindow().setAttributes(layoutParams);
                        break;
                    case 6:
                        int i15 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Tools.rateApp(mainActivity, "com.cbt.exam.browser");
                        break;
                    case 7:
                        int i16 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.SUBJECT", mainActivity.getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", mainActivity.getString(R.string.btn_share_txt) + "\nhttps://play.google.com/store/apps/details?id=com.cbt.exam.browser");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        mainActivity.startActivity(intent2);
                        break;
                    default:
                        int i17 = MainActivity.f5146s;
                        Dialog dialog3 = new Dialog(mainActivity);
                        dialog3.requestWindowFeature(1);
                        dialog3.setContentView(R.layout.dg_customua);
                        dialog3.setCancelable(true);
                        Window window3 = dialog3.getWindow();
                        Objects.requireNonNull(window3);
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        layoutParams2.copyFrom(dialog3.getWindow().getAttributes());
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        SwitchMaterial switchMaterial = (SwitchMaterial) dialog3.findViewById(R.id.switch_useragent);
                        switchMaterial.setChecked(((SharedPreferences) mainActivity.f5154q.f3263b).getBoolean("useragent", false));
                        switchMaterial.setOnCheckedChangeListener(new r(mainActivity, 2));
                        dialog3.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog3, 4));
                        dialog3.show();
                        dialog3.getWindow().setAttributes(layoutParams2);
                        break;
                }
            }
        });
        final int i14 = 6;
        this.h.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.z

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f5207b;

            {
                this.f5207b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i92 = i14;
                MainActivity mainActivity = this.f5207b;
                switch (i92) {
                    case 0:
                        int i102 = MainActivity.f5146s;
                        mainActivity.getClass();
                        try {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cbt.exam.browser.pro")));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                        break;
                    case 1:
                        int i112 = MainActivity.f5146s;
                        MainActivity mainActivity2 = this.f5207b;
                        Dialog dialog = new Dialog(mainActivity2);
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.dg_inputurl);
                        dialog.setCancelable(true);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            window.setLayout(-2, -2);
                            window.setWindowAnimations(R.style.DialogAnimationFadeScale);
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_address);
                        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.input_layout_address);
                        View viewFindViewById2 = dialog.findViewById(R.id.bt_close);
                        View viewFindViewById3 = dialog.findViewById(R.id.btn_enter);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity2);
                        textInputEditText.setText(defaultSharedPreferences.getString("autoSave", ""));
                        textInputEditText.addTextChangedListener(new a0(defaultSharedPreferences));
                        viewFindViewById2.setOnClickListener(new f(mainActivity2, dialog, 3));
                        viewFindViewById3.setOnClickListener(new p(mainActivity2, textInputEditText, textInputLayout, defaultSharedPreferences, dialog, 1));
                        mainActivity2.getWindow().setSoftInputMode(3);
                        dialog.show();
                        break;
                    case 2:
                        int i122 = MainActivity.f5146s;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityScanner.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        ActivityResultLauncher activityResultLauncher = mainActivity.f5155r;
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/*"});
                        activityResultLauncher.launch(intent);
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        int i132 = MainActivity.f5146s;
                        mainActivity.f5124a.g();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityCreateConfig.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        int i142 = MainActivity.f5146s;
                        Dialog dialog2 = new Dialog(mainActivity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setContentView(R.layout.dialog_about);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        Objects.requireNonNull(window2);
                        window2.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        layoutParams.copyFrom(dialog2.getWindow().getAttributes());
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        ((TextView) dialog2.findViewById(R.id.tv_version)).setText("Version 6.6");
                        dialog2.findViewById(R.id.bt_tutup).setOnClickListener(new d(dialog2, 5));
                        dialog2.findViewById(R.id.bt_close).setOnClickListener(new d(dialog2, 6));
                        dialog2.show();
                        dialog2.getWindow().setAttributes(layoutParams);
                        break;
                    case 6:
                        int i15 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Tools.rateApp(mainActivity, "com.cbt.exam.browser");
                        break;
                    case 7:
                        int i16 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.SUBJECT", mainActivity.getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", mainActivity.getString(R.string.btn_share_txt) + "\nhttps://play.google.com/store/apps/details?id=com.cbt.exam.browser");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        mainActivity.startActivity(intent2);
                        break;
                    default:
                        int i17 = MainActivity.f5146s;
                        Dialog dialog3 = new Dialog(mainActivity);
                        dialog3.requestWindowFeature(1);
                        dialog3.setContentView(R.layout.dg_customua);
                        dialog3.setCancelable(true);
                        Window window3 = dialog3.getWindow();
                        Objects.requireNonNull(window3);
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        layoutParams2.copyFrom(dialog3.getWindow().getAttributes());
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        SwitchMaterial switchMaterial = (SwitchMaterial) dialog3.findViewById(R.id.switch_useragent);
                        switchMaterial.setChecked(((SharedPreferences) mainActivity.f5154q.f3263b).getBoolean("useragent", false));
                        switchMaterial.setOnCheckedChangeListener(new r(mainActivity, 2));
                        dialog3.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog3, 4));
                        dialog3.show();
                        dialog3.getWindow().setAttributes(layoutParams2);
                        break;
                }
            }
        });
        final int i15 = 7;
        this.f5151i.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.z

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f5207b;

            {
                this.f5207b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i92 = i15;
                MainActivity mainActivity = this.f5207b;
                switch (i92) {
                    case 0:
                        int i102 = MainActivity.f5146s;
                        mainActivity.getClass();
                        try {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cbt.exam.browser.pro")));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                        break;
                    case 1:
                        int i112 = MainActivity.f5146s;
                        MainActivity mainActivity2 = this.f5207b;
                        Dialog dialog = new Dialog(mainActivity2);
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.dg_inputurl);
                        dialog.setCancelable(true);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            window.setLayout(-2, -2);
                            window.setWindowAnimations(R.style.DialogAnimationFadeScale);
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_address);
                        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.input_layout_address);
                        View viewFindViewById2 = dialog.findViewById(R.id.bt_close);
                        View viewFindViewById3 = dialog.findViewById(R.id.btn_enter);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity2);
                        textInputEditText.setText(defaultSharedPreferences.getString("autoSave", ""));
                        textInputEditText.addTextChangedListener(new a0(defaultSharedPreferences));
                        viewFindViewById2.setOnClickListener(new f(mainActivity2, dialog, 3));
                        viewFindViewById3.setOnClickListener(new p(mainActivity2, textInputEditText, textInputLayout, defaultSharedPreferences, dialog, 1));
                        mainActivity2.getWindow().setSoftInputMode(3);
                        dialog.show();
                        break;
                    case 2:
                        int i122 = MainActivity.f5146s;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityScanner.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        ActivityResultLauncher activityResultLauncher = mainActivity.f5155r;
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/*"});
                        activityResultLauncher.launch(intent);
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        int i132 = MainActivity.f5146s;
                        mainActivity.f5124a.g();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityCreateConfig.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        int i142 = MainActivity.f5146s;
                        Dialog dialog2 = new Dialog(mainActivity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setContentView(R.layout.dialog_about);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        Objects.requireNonNull(window2);
                        window2.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        layoutParams.copyFrom(dialog2.getWindow().getAttributes());
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        ((TextView) dialog2.findViewById(R.id.tv_version)).setText("Version 6.6");
                        dialog2.findViewById(R.id.bt_tutup).setOnClickListener(new d(dialog2, 5));
                        dialog2.findViewById(R.id.bt_close).setOnClickListener(new d(dialog2, 6));
                        dialog2.show();
                        dialog2.getWindow().setAttributes(layoutParams);
                        break;
                    case 6:
                        int i152 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Tools.rateApp(mainActivity, "com.cbt.exam.browser");
                        break;
                    case 7:
                        int i16 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.SUBJECT", mainActivity.getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", mainActivity.getString(R.string.btn_share_txt) + "\nhttps://play.google.com/store/apps/details?id=com.cbt.exam.browser");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        mainActivity.startActivity(intent2);
                        break;
                    default:
                        int i17 = MainActivity.f5146s;
                        Dialog dialog3 = new Dialog(mainActivity);
                        dialog3.requestWindowFeature(1);
                        dialog3.setContentView(R.layout.dg_customua);
                        dialog3.setCancelable(true);
                        Window window3 = dialog3.getWindow();
                        Objects.requireNonNull(window3);
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        layoutParams2.copyFrom(dialog3.getWindow().getAttributes());
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        SwitchMaterial switchMaterial = (SwitchMaterial) dialog3.findViewById(R.id.switch_useragent);
                        switchMaterial.setChecked(((SharedPreferences) mainActivity.f5154q.f3263b).getBoolean("useragent", false));
                        switchMaterial.setOnCheckedChangeListener(new r(mainActivity, 2));
                        dialog3.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog3, 4));
                        dialog3.show();
                        dialog3.getWindow().setAttributes(layoutParams2);
                        break;
                }
            }
        });
        final int i16 = 8;
        this.j.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.z

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MainActivity f5207b;

            {
                this.f5207b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i92 = i16;
                MainActivity mainActivity = this.f5207b;
                switch (i92) {
                    case 0:
                        int i102 = MainActivity.f5146s;
                        mainActivity.getClass();
                        try {
                            mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.cbt.exam.browser.pro")));
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return;
                        }
                        break;
                    case 1:
                        int i112 = MainActivity.f5146s;
                        MainActivity mainActivity2 = this.f5207b;
                        Dialog dialog = new Dialog(mainActivity2);
                        dialog.requestWindowFeature(1);
                        dialog.setContentView(R.layout.dg_inputurl);
                        dialog.setCancelable(true);
                        Window window = dialog.getWindow();
                        if (window != null) {
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            window.setLayout(-2, -2);
                            window.setWindowAnimations(R.style.DialogAnimationFadeScale);
                        }
                        TextInputEditText textInputEditText = (TextInputEditText) dialog.findViewById(R.id.input_address);
                        TextInputLayout textInputLayout = (TextInputLayout) dialog.findViewById(R.id.input_layout_address);
                        View viewFindViewById2 = dialog.findViewById(R.id.bt_close);
                        View viewFindViewById3 = dialog.findViewById(R.id.btn_enter);
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mainActivity2);
                        textInputEditText.setText(defaultSharedPreferences.getString("autoSave", ""));
                        textInputEditText.addTextChangedListener(new a0(defaultSharedPreferences));
                        viewFindViewById2.setOnClickListener(new f(mainActivity2, dialog, 3));
                        viewFindViewById3.setOnClickListener(new p(mainActivity2, textInputEditText, textInputLayout, defaultSharedPreferences, dialog, 1));
                        mainActivity2.getWindow().setSoftInputMode(3);
                        dialog.show();
                        break;
                    case 2:
                        int i122 = MainActivity.f5146s;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityScanner.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 3:
                        ActivityResultLauncher activityResultLauncher = mainActivity.f5155r;
                        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("*/*");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"application/octet-stream", "application/*"});
                        activityResultLauncher.launch(intent);
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 4:
                        int i132 = MainActivity.f5146s;
                        mainActivity.f5124a.g();
                        mainActivity.startActivity(new Intent(mainActivity.getBaseContext(), (Class<?>) ActivityCreateConfig.class));
                        mainActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                    case 5:
                        int i142 = MainActivity.f5146s;
                        Dialog dialog2 = new Dialog(mainActivity);
                        dialog2.requestWindowFeature(1);
                        dialog2.setContentView(R.layout.dialog_about);
                        dialog2.setCancelable(true);
                        Window window2 = dialog2.getWindow();
                        Objects.requireNonNull(window2);
                        window2.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                        layoutParams.copyFrom(dialog2.getWindow().getAttributes());
                        layoutParams.width = -2;
                        layoutParams.height = -2;
                        ((TextView) dialog2.findViewById(R.id.tv_version)).setText("Version 6.6");
                        dialog2.findViewById(R.id.bt_tutup).setOnClickListener(new d(dialog2, 5));
                        dialog2.findViewById(R.id.bt_close).setOnClickListener(new d(dialog2, 6));
                        dialog2.show();
                        dialog2.getWindow().setAttributes(layoutParams);
                        break;
                    case 6:
                        int i152 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Tools.rateApp(mainActivity, "com.cbt.exam.browser");
                        break;
                    case 7:
                        int i162 = MainActivity.f5146s;
                        mainActivity.getClass();
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.SEND");
                        intent2.putExtra("android.intent.extra.SUBJECT", mainActivity.getString(R.string.app_name));
                        intent2.putExtra("android.intent.extra.TEXT", mainActivity.getString(R.string.btn_share_txt) + "\nhttps://play.google.com/store/apps/details?id=com.cbt.exam.browser");
                        intent2.setType(AssetHelper.DEFAULT_MIME_TYPE);
                        mainActivity.startActivity(intent2);
                        break;
                    default:
                        int i17 = MainActivity.f5146s;
                        Dialog dialog3 = new Dialog(mainActivity);
                        dialog3.requestWindowFeature(1);
                        dialog3.setContentView(R.layout.dg_customua);
                        dialog3.setCancelable(true);
                        Window window3 = dialog3.getWindow();
                        Objects.requireNonNull(window3);
                        window3.setBackgroundDrawable(new ColorDrawable(0));
                        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
                        layoutParams2.copyFrom(dialog3.getWindow().getAttributes());
                        layoutParams2.width = -2;
                        layoutParams2.height = -2;
                        SwitchMaterial switchMaterial = (SwitchMaterial) dialog3.findViewById(R.id.switch_useragent);
                        switchMaterial.setChecked(((SharedPreferences) mainActivity.f5154q.f3263b).getBoolean("useragent", false));
                        switchMaterial.setOnCheckedChangeListener(new r(mainActivity, 2));
                        dialog3.findViewById(R.id.bt_cancel).setOnClickListener(new d(dialog3, 4));
                        dialog3.show();
                        dialog3.getWindow().setAttributes(layoutParams2);
                        break;
                }
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new j(this, 7));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        j0.a aVar;
        super.onDestroy();
        if (!isFinishing() || (aVar = this.f5124a) == null) {
            return;
        }
        BannerAd bannerAd = aVar.f12051f;
        if (bannerAd != null) {
            bannerAd.destroyAndDetachBanner();
        }
        j0.a aVar2 = this.f5124a;
        BannerAd bannerAd2 = aVar2.f12051f;
        if (bannerAd2 != null) {
            bannerAd2.destroyAndDetachBanner();
        }
        AppOpenAd appOpenAd = aVar2.e;
        if (appOpenAd != null) {
            appOpenAd.destroyOpenAd();
        }
        aVar2.g = null;
        aVar2.h = null;
        aVar2.f12052i = null;
        aVar2.f12047a.clear();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        r(intent);
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

    public final void q(String str) {
        try {
            s(a.a.v(str));
        } catch (Exception e) {
            Log.e("MainActivity", "Error decrypt config", e);
            Toast.makeText(this, getString(R.string.txt_cbtfile_error_decrypt), 1).show();
        }
    }

    public final void r(Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        Uri data = intent.getData();
        if (!"android.intent.action.VIEW".equals(action) || data == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 24) {
                t(data);
                return;
            }
            try {
                InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(data);
                if (inputStreamOpenInputStream != null) {
                    try {
                        q(u(inputStreamOpenInputStream));
                    } catch (Throwable th) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
            } catch (IOException e) {
                Log.e("MainActivity", "Error reading content URI", e);
                Toast.makeText(this, getString(R.string.txt_cbtfile_error_read), 1).show();
            }
        } catch (Exception e4) {
            Log.e("MainActivity", "Error opening CBT file", e4);
            Toast.makeText(this, getString(R.string.txt_cbtfile_error_open), 1).show();
        }
    }

    public final void s(JSONObject jSONObject) {
        try {
            Intent intent = new Intent(this, (Class<?>) ActivityConfigConfirm.class);
            intent.putExtra("config_json", jSONObject.toString());
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, getString(R.string.txt_cbtfile_error_open) + e.getMessage(), 1).show();
        }
    }

    public final void t(Uri uri) {
        try {
            String path = uri.getPath();
            Objects.requireNonNull(path);
            File file = new File(path);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                String strU = u(fileInputStream);
                fileInputStream.close();
                q(strU);
            }
        } catch (Exception e) {
            Log.e("MainActivity", "Error reading file URI", e);
            Toast.makeText(this, getString(R.string.txt_cbtfile_error_read), 1).show();
        }
    }

    public final String u(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        int i2 = 0;
        do {
            int i8 = bufferedReader.read(cArr);
            if (i8 == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, i8);
            i2 += i8;
        } while (i2 <= 5242880);
        throw new IOException(getString(R.string.txt_cbtfile_error_over) + " (>5 MB)");
    }
}
