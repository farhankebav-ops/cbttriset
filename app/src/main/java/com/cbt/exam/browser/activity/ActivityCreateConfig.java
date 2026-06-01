package com.cbt.exam.browser.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.balysv.materialripple.MaterialRippleLayout;
import com.cbt.exam.browser.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mimikridev.ads.banner.BannerAd;
import com.mimikridev.utilmanager.config.Statistik;
import com.mimikridev.utilmanager.toast.ToastUtil;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ActivityCreateConfig extends BaseActivity {
    public static final /* synthetic */ int B = 0;
    public android.support.v4.media.g A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MaterialRippleLayout f5087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MaterialRippleLayout f5088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SwitchMaterial f5089d;
    public SwitchMaterial e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SwitchMaterial f5090f;
    public SwitchMaterial g;
    public SwitchMaterial h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SwitchMaterial f5091i;
    public SwitchMaterial j;
    public SwitchMaterial k;
    public SwitchMaterial l;
    public SwitchMaterial m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public EditText f5092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public EditText f5093o;
    public EditText p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public EditText f5094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public EditText f5095r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public EditText f5096s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public EditText f5097t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public EditText f5098u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public EditText f5099v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public EditText f5100w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public EditText f5101x;
    public SharedPreferences y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SharedPreferences.Editor f5102z;

    @Override // com.cbt.exam.browser.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_create_config);
        getWindow().addFlags(128);
        this.A = new android.support.v4.media.g((BaseActivity) this);
        this.f5124a.d();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.y = defaultSharedPreferences;
        this.f5102z = defaultSharedPreferences.edit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.baseline_chevron_left_24);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.setTitle(getResources().getString(R.string.txt_config_preview_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final int i2 = 0;
        toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.q

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCreateConfig f5192b;

            {
                this.f5192b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i8 = i2;
                ActivityCreateConfig activityCreateConfig = this.f5192b;
                switch (i8) {
                    case 0:
                        int i9 = ActivityCreateConfig.B;
                        activityCreateConfig.finish();
                        break;
                    case 1:
                        activityCreateConfig.f5097t.setText("");
                        activityCreateConfig.f5099v.setText("");
                        activityCreateConfig.f5098u.setText("");
                        activityCreateConfig.f5100w.setText("");
                        activityCreateConfig.f5101x.setText("");
                        activityCreateConfig.f5092n.setText("");
                        activityCreateConfig.f5093o.setText("");
                        activityCreateConfig.p.setText("");
                        activityCreateConfig.f5094q.setText("");
                        activityCreateConfig.f5095r.setText("");
                        activityCreateConfig.f5096s.setText("");
                        activityCreateConfig.f5089d.setChecked(false);
                        activityCreateConfig.e.setChecked(false);
                        activityCreateConfig.f5090f.setChecked(false);
                        activityCreateConfig.g.setChecked(false);
                        activityCreateConfig.h.setChecked(false);
                        activityCreateConfig.f5091i.setChecked(false);
                        activityCreateConfig.j.setChecked(false);
                        activityCreateConfig.k.setChecked(false);
                        activityCreateConfig.l.setChecked(true);
                        activityCreateConfig.m.setChecked(true);
                        activityCreateConfig.f5102z.clear();
                        activityCreateConfig.f5102z.apply();
                        ToastUtil.showSuccess(activityCreateConfig, activityCreateConfig.getString(R.string.txt_toast_clearform_succes));
                        break;
                    default:
                        if (((SharedPreferences) activityCreateConfig.A.f3263b).getBoolean("lastconfig", true)) {
                            activityCreateConfig.f5102z.putString("et_url", activityCreateConfig.f5097t.getText().toString());
                            activityCreateConfig.f5102z.putString("et_nama_ujian", activityCreateConfig.f5099v.getText().toString());
                            activityCreateConfig.f5102z.putString("et_nama_sekolah", activityCreateConfig.f5098u.getText().toString());
                            activityCreateConfig.f5102z.putString("et_logo", activityCreateConfig.f5100w.getText().toString());
                            activityCreateConfig.f5102z.putString("et_filename", activityCreateConfig.f5101x.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_custom_ua", activityCreateConfig.f5089d.isChecked());
                            activityCreateConfig.f5102z.putString("et_custom_ua", activityCreateConfig.f5092n.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_timer", activityCreateConfig.e.isChecked());
                            activityCreateConfig.f5102z.putString("et_timer", activityCreateConfig.f5093o.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_message", activityCreateConfig.f5090f.isChecked());
                            activityCreateConfig.f5102z.putString("et_message", activityCreateConfig.p.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_token_masuk", activityCreateConfig.g.isChecked());
                            activityCreateConfig.f5102z.putString("et_token_masuk", activityCreateConfig.f5094q.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_token_keluar", activityCreateConfig.h.isChecked());
                            activityCreateConfig.f5102z.putString("et_token_keluar", activityCreateConfig.f5095r.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_link_keluar", activityCreateConfig.f5091i.isChecked());
                            activityCreateConfig.f5102z.putString("et_link_keluar", activityCreateConfig.f5096s.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_copy_paste", activityCreateConfig.j.isChecked());
                            activityCreateConfig.f5102z.putBoolean("sw_screenshoot", activityCreateConfig.k.isChecked());
                            activityCreateConfig.f5102z.putBoolean("sw_clear_cache", activityCreateConfig.l.isChecked());
                            activityCreateConfig.f5102z.apply();
                        }
                        String strTrim = activityCreateConfig.f5097t.getText().toString().trim();
                        if (strTrim.isEmpty()) {
                            activityCreateConfig.f5097t.setError(activityCreateConfig.getString(R.string.txt_config_error_url));
                            activityCreateConfig.f5097t.requestFocus();
                        } else if (!Patterns.WEB_URL.matcher(strTrim).matches()) {
                            activityCreateConfig.f5097t.setError(activityCreateConfig.getString(R.string.txt_config_error_urlnotvalid));
                            activityCreateConfig.f5097t.requestFocus();
                        } else if (activityCreateConfig.f5089d.isChecked() && activityCreateConfig.f5092n.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5092n.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5092n.requestFocus();
                        } else if (activityCreateConfig.e.isChecked() && activityCreateConfig.f5093o.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5093o.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5093o.requestFocus();
                        } else if (activityCreateConfig.f5090f.isChecked() && activityCreateConfig.p.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.p.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.p.requestFocus();
                        } else if (activityCreateConfig.g.isChecked() && activityCreateConfig.f5094q.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5094q.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5094q.requestFocus();
                        } else if (activityCreateConfig.h.isChecked() && activityCreateConfig.f5095r.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5095r.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5095r.requestFocus();
                        } else if (activityCreateConfig.f5091i.isChecked() && activityCreateConfig.f5096s.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5096s.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5096s.requestFocus();
                        } else {
                            Intent intent = new Intent(activityCreateConfig, (Class<?>) ActivityGenerateConfig.class);
                            intent.putExtra("url", activityCreateConfig.f5097t.getText().toString());
                            intent.putExtra("nama_ujian", activityCreateConfig.f5099v.getText().toString());
                            intent.putExtra("nama_sekolah", activityCreateConfig.f5098u.getText().toString());
                            intent.putExtra("logo", activityCreateConfig.f5100w.getText().toString());
                            intent.putExtra("filename", activityCreateConfig.f5101x.getText().toString());
                            intent.putExtra("customUA_on", activityCreateConfig.f5089d.isChecked());
                            intent.putExtra("customUA_text", activityCreateConfig.f5092n.getText().toString());
                            intent.putExtra("timer_on", activityCreateConfig.e.isChecked());
                            intent.putExtra("timer_value", activityCreateConfig.f5093o.getText().toString());
                            intent.putExtra("message_on", activityCreateConfig.f5090f.isChecked());
                            intent.putExtra("message_text", activityCreateConfig.p.getText().toString());
                            intent.putExtra("tokenMasuk_on", activityCreateConfig.g.isChecked());
                            intent.putExtra("tokenMasuk_text", activityCreateConfig.f5094q.getText().toString());
                            intent.putExtra("tokenKeluar_on", activityCreateConfig.h.isChecked());
                            intent.putExtra("tokenKeluar_text", activityCreateConfig.f5095r.getText().toString());
                            intent.putExtra("linkKeluar_on", activityCreateConfig.f5091i.isChecked());
                            intent.putExtra("linkKeluar_text", activityCreateConfig.f5096s.getText().toString());
                            intent.putExtra("copyPaste_on", activityCreateConfig.j.isChecked());
                            intent.putExtra("screenshoot_on", activityCreateConfig.k.isChecked());
                            intent.putExtra("clearCache_on", activityCreateConfig.l.isChecked());
                            activityCreateConfig.f5124a.g();
                            activityCreateConfig.startActivity(intent);
                            Statistik.getData(activityCreateConfig);
                            activityCreateConfig.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                        break;
                }
            }
        });
        this.f5097t = (EditText) findViewById(R.id.et_url);
        this.f5099v = (EditText) findViewById(R.id.et_nama_ujian);
        this.f5098u = (EditText) findViewById(R.id.et_nama_sekolah);
        this.f5100w = (EditText) findViewById(R.id.et_logo);
        this.f5101x = (EditText) findViewById(R.id.et_filename);
        this.f5089d = (SwitchMaterial) findViewById(R.id.sw_custom_ua);
        this.f5092n = (EditText) findViewById(R.id.et_custom_ua);
        this.e = (SwitchMaterial) findViewById(R.id.sw_timer);
        this.f5093o = (EditText) findViewById(R.id.et_timer);
        this.f5090f = (SwitchMaterial) findViewById(R.id.sw_message);
        this.p = (EditText) findViewById(R.id.et_message);
        this.g = (SwitchMaterial) findViewById(R.id.sw_token_masuk);
        this.f5094q = (EditText) findViewById(R.id.et_token_masuk);
        this.h = (SwitchMaterial) findViewById(R.id.sw_token_keluar);
        this.f5095r = (EditText) findViewById(R.id.et_token_keluar);
        this.f5091i = (SwitchMaterial) findViewById(R.id.sw_link_keluar);
        this.f5096s = (EditText) findViewById(R.id.et_link_keluar);
        this.j = (SwitchMaterial) findViewById(R.id.sw_copy_paste);
        this.k = (SwitchMaterial) findViewById(R.id.sw_screenshoot);
        this.l = (SwitchMaterial) findViewById(R.id.sw_clear_cache);
        this.m = (SwitchMaterial) findViewById(R.id.sw_safeconfig);
        this.f5087b = (MaterialRippleLayout) findViewById(R.id.btn_generate_config);
        this.f5088c = (MaterialRippleLayout) findViewById(R.id.btn_clearform);
        q(this.f5089d, this.f5092n);
        q(this.e, this.f5093o);
        q(this.f5090f, this.p);
        q(this.g, this.f5094q);
        q(this.h, this.f5095r);
        q(this.f5091i, this.f5096s);
        this.f5097t.setText(this.y.getString("et_url", ""));
        this.f5099v.setText(this.y.getString("et_nama_ujian", ""));
        this.f5098u.setText(this.y.getString("et_nama_sekolah", ""));
        this.f5100w.setText(this.y.getString("et_logo", ""));
        this.f5101x.setText(this.y.getString("et_filename", ""));
        Statistik.sendData(this, "cbtexambrowser");
        this.f5089d.setChecked(this.y.getBoolean("sw_custom_ua", false));
        this.f5092n.setText(this.y.getString("et_custom_ua", ""));
        this.f5092n.setVisibility(this.f5089d.isChecked() ? 0 : 8);
        this.e.setChecked(this.y.getBoolean("sw_timer", false));
        this.f5093o.setText(this.y.getString("et_timer", ""));
        this.f5093o.setVisibility(this.e.isChecked() ? 0 : 8);
        this.f5090f.setChecked(this.y.getBoolean("sw_message", false));
        this.p.setText(this.y.getString("et_message", ""));
        this.p.setVisibility(this.f5090f.isChecked() ? 0 : 8);
        this.g.setChecked(this.y.getBoolean("sw_token_masuk", false));
        this.f5094q.setText(this.y.getString("et_token_masuk", ""));
        this.f5094q.setVisibility(this.g.isChecked() ? 0 : 8);
        this.h.setChecked(this.y.getBoolean("sw_token_keluar", false));
        this.f5095r.setText(this.y.getString("et_token_keluar", ""));
        this.f5095r.setVisibility(this.h.isChecked() ? 0 : 8);
        this.f5091i.setChecked(this.y.getBoolean("sw_link_keluar", false));
        this.f5096s.setText(this.y.getString("et_link_keluar", ""));
        this.f5096s.setVisibility(this.f5091i.isChecked() ? 0 : 8);
        this.j.setChecked(this.y.getBoolean("sw_copy_paste", false));
        this.k.setChecked(this.y.getBoolean("sw_screenshoot", false));
        this.l.setChecked(this.y.getBoolean("sw_clear_cache", true));
        this.m.setChecked(((SharedPreferences) this.A.f3263b).getBoolean("lastconfig", true));
        this.m.setOnCheckedChangeListener(new r(this, 0));
        final int i8 = 1;
        this.f5088c.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.q

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCreateConfig f5192b;

            {
                this.f5192b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i8;
                ActivityCreateConfig activityCreateConfig = this.f5192b;
                switch (i82) {
                    case 0:
                        int i9 = ActivityCreateConfig.B;
                        activityCreateConfig.finish();
                        break;
                    case 1:
                        activityCreateConfig.f5097t.setText("");
                        activityCreateConfig.f5099v.setText("");
                        activityCreateConfig.f5098u.setText("");
                        activityCreateConfig.f5100w.setText("");
                        activityCreateConfig.f5101x.setText("");
                        activityCreateConfig.f5092n.setText("");
                        activityCreateConfig.f5093o.setText("");
                        activityCreateConfig.p.setText("");
                        activityCreateConfig.f5094q.setText("");
                        activityCreateConfig.f5095r.setText("");
                        activityCreateConfig.f5096s.setText("");
                        activityCreateConfig.f5089d.setChecked(false);
                        activityCreateConfig.e.setChecked(false);
                        activityCreateConfig.f5090f.setChecked(false);
                        activityCreateConfig.g.setChecked(false);
                        activityCreateConfig.h.setChecked(false);
                        activityCreateConfig.f5091i.setChecked(false);
                        activityCreateConfig.j.setChecked(false);
                        activityCreateConfig.k.setChecked(false);
                        activityCreateConfig.l.setChecked(true);
                        activityCreateConfig.m.setChecked(true);
                        activityCreateConfig.f5102z.clear();
                        activityCreateConfig.f5102z.apply();
                        ToastUtil.showSuccess(activityCreateConfig, activityCreateConfig.getString(R.string.txt_toast_clearform_succes));
                        break;
                    default:
                        if (((SharedPreferences) activityCreateConfig.A.f3263b).getBoolean("lastconfig", true)) {
                            activityCreateConfig.f5102z.putString("et_url", activityCreateConfig.f5097t.getText().toString());
                            activityCreateConfig.f5102z.putString("et_nama_ujian", activityCreateConfig.f5099v.getText().toString());
                            activityCreateConfig.f5102z.putString("et_nama_sekolah", activityCreateConfig.f5098u.getText().toString());
                            activityCreateConfig.f5102z.putString("et_logo", activityCreateConfig.f5100w.getText().toString());
                            activityCreateConfig.f5102z.putString("et_filename", activityCreateConfig.f5101x.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_custom_ua", activityCreateConfig.f5089d.isChecked());
                            activityCreateConfig.f5102z.putString("et_custom_ua", activityCreateConfig.f5092n.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_timer", activityCreateConfig.e.isChecked());
                            activityCreateConfig.f5102z.putString("et_timer", activityCreateConfig.f5093o.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_message", activityCreateConfig.f5090f.isChecked());
                            activityCreateConfig.f5102z.putString("et_message", activityCreateConfig.p.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_token_masuk", activityCreateConfig.g.isChecked());
                            activityCreateConfig.f5102z.putString("et_token_masuk", activityCreateConfig.f5094q.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_token_keluar", activityCreateConfig.h.isChecked());
                            activityCreateConfig.f5102z.putString("et_token_keluar", activityCreateConfig.f5095r.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_link_keluar", activityCreateConfig.f5091i.isChecked());
                            activityCreateConfig.f5102z.putString("et_link_keluar", activityCreateConfig.f5096s.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_copy_paste", activityCreateConfig.j.isChecked());
                            activityCreateConfig.f5102z.putBoolean("sw_screenshoot", activityCreateConfig.k.isChecked());
                            activityCreateConfig.f5102z.putBoolean("sw_clear_cache", activityCreateConfig.l.isChecked());
                            activityCreateConfig.f5102z.apply();
                        }
                        String strTrim = activityCreateConfig.f5097t.getText().toString().trim();
                        if (strTrim.isEmpty()) {
                            activityCreateConfig.f5097t.setError(activityCreateConfig.getString(R.string.txt_config_error_url));
                            activityCreateConfig.f5097t.requestFocus();
                        } else if (!Patterns.WEB_URL.matcher(strTrim).matches()) {
                            activityCreateConfig.f5097t.setError(activityCreateConfig.getString(R.string.txt_config_error_urlnotvalid));
                            activityCreateConfig.f5097t.requestFocus();
                        } else if (activityCreateConfig.f5089d.isChecked() && activityCreateConfig.f5092n.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5092n.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5092n.requestFocus();
                        } else if (activityCreateConfig.e.isChecked() && activityCreateConfig.f5093o.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5093o.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5093o.requestFocus();
                        } else if (activityCreateConfig.f5090f.isChecked() && activityCreateConfig.p.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.p.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.p.requestFocus();
                        } else if (activityCreateConfig.g.isChecked() && activityCreateConfig.f5094q.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5094q.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5094q.requestFocus();
                        } else if (activityCreateConfig.h.isChecked() && activityCreateConfig.f5095r.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5095r.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5095r.requestFocus();
                        } else if (activityCreateConfig.f5091i.isChecked() && activityCreateConfig.f5096s.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5096s.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5096s.requestFocus();
                        } else {
                            Intent intent = new Intent(activityCreateConfig, (Class<?>) ActivityGenerateConfig.class);
                            intent.putExtra("url", activityCreateConfig.f5097t.getText().toString());
                            intent.putExtra("nama_ujian", activityCreateConfig.f5099v.getText().toString());
                            intent.putExtra("nama_sekolah", activityCreateConfig.f5098u.getText().toString());
                            intent.putExtra("logo", activityCreateConfig.f5100w.getText().toString());
                            intent.putExtra("filename", activityCreateConfig.f5101x.getText().toString());
                            intent.putExtra("customUA_on", activityCreateConfig.f5089d.isChecked());
                            intent.putExtra("customUA_text", activityCreateConfig.f5092n.getText().toString());
                            intent.putExtra("timer_on", activityCreateConfig.e.isChecked());
                            intent.putExtra("timer_value", activityCreateConfig.f5093o.getText().toString());
                            intent.putExtra("message_on", activityCreateConfig.f5090f.isChecked());
                            intent.putExtra("message_text", activityCreateConfig.p.getText().toString());
                            intent.putExtra("tokenMasuk_on", activityCreateConfig.g.isChecked());
                            intent.putExtra("tokenMasuk_text", activityCreateConfig.f5094q.getText().toString());
                            intent.putExtra("tokenKeluar_on", activityCreateConfig.h.isChecked());
                            intent.putExtra("tokenKeluar_text", activityCreateConfig.f5095r.getText().toString());
                            intent.putExtra("linkKeluar_on", activityCreateConfig.f5091i.isChecked());
                            intent.putExtra("linkKeluar_text", activityCreateConfig.f5096s.getText().toString());
                            intent.putExtra("copyPaste_on", activityCreateConfig.j.isChecked());
                            intent.putExtra("screenshoot_on", activityCreateConfig.k.isChecked());
                            intent.putExtra("clearCache_on", activityCreateConfig.l.isChecked());
                            activityCreateConfig.f5124a.g();
                            activityCreateConfig.startActivity(intent);
                            Statistik.getData(activityCreateConfig);
                            activityCreateConfig.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                        break;
                }
            }
        });
        final int i9 = 2;
        this.f5087b.setOnClickListener(new View.OnClickListener(this) { // from class: com.cbt.exam.browser.activity.q

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActivityCreateConfig f5192b;

            {
                this.f5192b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i82 = i9;
                ActivityCreateConfig activityCreateConfig = this.f5192b;
                switch (i82) {
                    case 0:
                        int i92 = ActivityCreateConfig.B;
                        activityCreateConfig.finish();
                        break;
                    case 1:
                        activityCreateConfig.f5097t.setText("");
                        activityCreateConfig.f5099v.setText("");
                        activityCreateConfig.f5098u.setText("");
                        activityCreateConfig.f5100w.setText("");
                        activityCreateConfig.f5101x.setText("");
                        activityCreateConfig.f5092n.setText("");
                        activityCreateConfig.f5093o.setText("");
                        activityCreateConfig.p.setText("");
                        activityCreateConfig.f5094q.setText("");
                        activityCreateConfig.f5095r.setText("");
                        activityCreateConfig.f5096s.setText("");
                        activityCreateConfig.f5089d.setChecked(false);
                        activityCreateConfig.e.setChecked(false);
                        activityCreateConfig.f5090f.setChecked(false);
                        activityCreateConfig.g.setChecked(false);
                        activityCreateConfig.h.setChecked(false);
                        activityCreateConfig.f5091i.setChecked(false);
                        activityCreateConfig.j.setChecked(false);
                        activityCreateConfig.k.setChecked(false);
                        activityCreateConfig.l.setChecked(true);
                        activityCreateConfig.m.setChecked(true);
                        activityCreateConfig.f5102z.clear();
                        activityCreateConfig.f5102z.apply();
                        ToastUtil.showSuccess(activityCreateConfig, activityCreateConfig.getString(R.string.txt_toast_clearform_succes));
                        break;
                    default:
                        if (((SharedPreferences) activityCreateConfig.A.f3263b).getBoolean("lastconfig", true)) {
                            activityCreateConfig.f5102z.putString("et_url", activityCreateConfig.f5097t.getText().toString());
                            activityCreateConfig.f5102z.putString("et_nama_ujian", activityCreateConfig.f5099v.getText().toString());
                            activityCreateConfig.f5102z.putString("et_nama_sekolah", activityCreateConfig.f5098u.getText().toString());
                            activityCreateConfig.f5102z.putString("et_logo", activityCreateConfig.f5100w.getText().toString());
                            activityCreateConfig.f5102z.putString("et_filename", activityCreateConfig.f5101x.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_custom_ua", activityCreateConfig.f5089d.isChecked());
                            activityCreateConfig.f5102z.putString("et_custom_ua", activityCreateConfig.f5092n.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_timer", activityCreateConfig.e.isChecked());
                            activityCreateConfig.f5102z.putString("et_timer", activityCreateConfig.f5093o.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_message", activityCreateConfig.f5090f.isChecked());
                            activityCreateConfig.f5102z.putString("et_message", activityCreateConfig.p.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_token_masuk", activityCreateConfig.g.isChecked());
                            activityCreateConfig.f5102z.putString("et_token_masuk", activityCreateConfig.f5094q.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_token_keluar", activityCreateConfig.h.isChecked());
                            activityCreateConfig.f5102z.putString("et_token_keluar", activityCreateConfig.f5095r.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_link_keluar", activityCreateConfig.f5091i.isChecked());
                            activityCreateConfig.f5102z.putString("et_link_keluar", activityCreateConfig.f5096s.getText().toString());
                            activityCreateConfig.f5102z.putBoolean("sw_copy_paste", activityCreateConfig.j.isChecked());
                            activityCreateConfig.f5102z.putBoolean("sw_screenshoot", activityCreateConfig.k.isChecked());
                            activityCreateConfig.f5102z.putBoolean("sw_clear_cache", activityCreateConfig.l.isChecked());
                            activityCreateConfig.f5102z.apply();
                        }
                        String strTrim = activityCreateConfig.f5097t.getText().toString().trim();
                        if (strTrim.isEmpty()) {
                            activityCreateConfig.f5097t.setError(activityCreateConfig.getString(R.string.txt_config_error_url));
                            activityCreateConfig.f5097t.requestFocus();
                        } else if (!Patterns.WEB_URL.matcher(strTrim).matches()) {
                            activityCreateConfig.f5097t.setError(activityCreateConfig.getString(R.string.txt_config_error_urlnotvalid));
                            activityCreateConfig.f5097t.requestFocus();
                        } else if (activityCreateConfig.f5089d.isChecked() && activityCreateConfig.f5092n.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5092n.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5092n.requestFocus();
                        } else if (activityCreateConfig.e.isChecked() && activityCreateConfig.f5093o.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5093o.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5093o.requestFocus();
                        } else if (activityCreateConfig.f5090f.isChecked() && activityCreateConfig.p.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.p.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.p.requestFocus();
                        } else if (activityCreateConfig.g.isChecked() && activityCreateConfig.f5094q.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5094q.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5094q.requestFocus();
                        } else if (activityCreateConfig.h.isChecked() && activityCreateConfig.f5095r.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5095r.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5095r.requestFocus();
                        } else if (activityCreateConfig.f5091i.isChecked() && activityCreateConfig.f5096s.getText().toString().trim().isEmpty()) {
                            activityCreateConfig.f5096s.setError(activityCreateConfig.getString(R.string.txt_config_error_empty));
                            activityCreateConfig.f5096s.requestFocus();
                        } else {
                            Intent intent = new Intent(activityCreateConfig, (Class<?>) ActivityGenerateConfig.class);
                            intent.putExtra("url", activityCreateConfig.f5097t.getText().toString());
                            intent.putExtra("nama_ujian", activityCreateConfig.f5099v.getText().toString());
                            intent.putExtra("nama_sekolah", activityCreateConfig.f5098u.getText().toString());
                            intent.putExtra("logo", activityCreateConfig.f5100w.getText().toString());
                            intent.putExtra("filename", activityCreateConfig.f5101x.getText().toString());
                            intent.putExtra("customUA_on", activityCreateConfig.f5089d.isChecked());
                            intent.putExtra("customUA_text", activityCreateConfig.f5092n.getText().toString());
                            intent.putExtra("timer_on", activityCreateConfig.e.isChecked());
                            intent.putExtra("timer_value", activityCreateConfig.f5093o.getText().toString());
                            intent.putExtra("message_on", activityCreateConfig.f5090f.isChecked());
                            intent.putExtra("message_text", activityCreateConfig.p.getText().toString());
                            intent.putExtra("tokenMasuk_on", activityCreateConfig.g.isChecked());
                            intent.putExtra("tokenMasuk_text", activityCreateConfig.f5094q.getText().toString());
                            intent.putExtra("tokenKeluar_on", activityCreateConfig.h.isChecked());
                            intent.putExtra("tokenKeluar_text", activityCreateConfig.f5095r.getText().toString());
                            intent.putExtra("linkKeluar_on", activityCreateConfig.f5091i.isChecked());
                            intent.putExtra("linkKeluar_text", activityCreateConfig.f5096s.getText().toString());
                            intent.putExtra("copyPaste_on", activityCreateConfig.j.isChecked());
                            intent.putExtra("screenshoot_on", activityCreateConfig.k.isChecked());
                            intent.putExtra("clearCache_on", activityCreateConfig.l.isChecked());
                            activityCreateConfig.f5124a.g();
                            activityCreateConfig.startActivity(intent);
                            Statistik.getData(activityCreateConfig);
                            activityCreateConfig.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                        break;
                }
            }
        });
        getOnBackPressedDispatcher().addCallback(this, new j(this, i9));
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

    public final void q(SwitchMaterial switchMaterial, EditText editText) {
        Statistik.getData(this);
        editText.setVisibility(8);
        switchMaterial.setOnCheckedChangeListener(new r(editText, 1));
    }
}
