package com.mimikridev.utilmanager.config;

import android.R;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.ironsource.C2300e4;
import com.mimikridev.ads.util.Constant;
import com.mimikridev.utilmanager.security.Dataku;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class ConfigManager {
    private static final String TAG = "ConfigManager";
    private final Activity activity;
    private final boolean isFromPlayStore;
    private final SharedPrefConfig pref;
    private final FirebaseRemoteConfig rc = FirebaseRemoteConfig.getInstance();
    private final int versionCode;

    public ConfigManager(Activity activity, int i2) {
        this.activity = activity;
        this.pref = new SharedPrefConfig(activity);
        this.versionCode = i2;
        this.isFromPlayStore = "com.android.vending".equals(activity.getPackageManager().getInstallerPackageName(activity.getPackageName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$0(boolean z2, DialogInterface dialogInterface, int i2) {
        String app_redirect_url = this.pref.getApp_redirect_url();
        if (app_redirect_url == null || app_redirect_url.isEmpty()) {
            app_redirect_url = "https://play.google.com/store/apps/details?id=" + this.activity.getPackageName();
        }
        this.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(app_redirect_url)));
        if (z2) {
            this.activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$1(boolean z2, DialogInterface dialogInterface, int i2) {
        if (z2) {
            this.activity.finish();
        } else {
            dialogInterface.dismiss();
        }
    }

    private void minUpdate() {
        try {
            if (this.pref.getApp_version_min() > this.versionCode) {
                showDialog(this.pref.getApp_dialog_title(), this.pref.getApp_dialog_desc(), this.pref.getApp_dialog_btn_ok(), true);
            }
        } catch (Exception e) {
            Log.e("ConfigManager", "minUpdate error: " + e.getMessage(), e);
        }
    }

    private void redirect() {
        try {
            if (this.pref.getApp_redirect_status() == 1) {
                showDialog(this.pref.getApp_dialog_title(), this.pref.getApp_dialog_desc(), this.pref.getApp_dialog_btn_ok(), true);
            }
        } catch (Exception e) {
            Log.e("ConfigManager", "redirect error: " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAdsConfig(AdsConfig adsConfig) {
        try {
            this.pref.setIdAds(adsConfig.id);
            this.pref.setPackageNameAds(adsConfig.package_name);
            this.pref.setVersiApkMin(adsConfig.versi_apk_min);
            this.pref.setVersiApkMax(adsConfig.versi_apk_max);
            this.pref.setAd_status(adsConfig.ad_status);
            this.pref.setAd_type(adsConfig.ad_type);
            this.pref.setBackup_ads(adsConfig.backup_ads);
            this.pref.setOpenad_status(adsConfig.openad_status);
            this.pref.setInterAdInterval(adsConfig.inter_ad_interval);
            this.pref.setNativeAdInterval(adsConfig.native_ad_interval);
            this.pref.setNativeAdIndex(adsConfig.native_ad_index);
            this.pref.setAdmob_pub_id(adsConfig.admob_pub_id);
            this.pref.setAdmob_app_id(adsConfig.admob_app_id);
            this.pref.setAdmob_banner_id(adsConfig.admob_banner_id);
            this.pref.setAdmob_inter_id(adsConfig.admob_inter_id);
            this.pref.setAdmob_reward_id(adsConfig.admob_reward_id);
            this.pref.setAdmob_native_id(adsConfig.admob_native_id);
            this.pref.setAdmob_app_open_id(adsConfig.admob_app_open_id);
            this.pref.setPangle_app_id(adsConfig.pangle_app_id);
            this.pref.setPangle_banner_id(adsConfig.pangle_banner_id);
            this.pref.setPangle_inter_id(adsConfig.pangle_inter_id);
            this.pref.setPangle_native_id(adsConfig.pangle_native_id);
            this.pref.setPangle_reward_id(adsConfig.pangle_reward_id);
            this.pref.setPangle_app_open_id(adsConfig.pangle_app_open_id);
            this.pref.setFan_banner_id(adsConfig.fan_banner_id);
            this.pref.setFan_inter_id(adsConfig.fan_inter_id);
            this.pref.setFan_native_id(adsConfig.fan_native_id);
            this.pref.setIronsource_app_id(adsConfig.ironsource_app_id);
            this.pref.setIronsource_banner_id(adsConfig.ironsource_banner_id);
            this.pref.setIronsource_inter_id(adsConfig.ironsource_inter_id);
            this.pref.setIronsource_native_id(adsConfig.ironsource_native_id);
            this.pref.setIronsource_reward_id(adsConfig.ironsource_reward_id);
            this.pref.setDate_time(adsConfig.date_time);
            this.pref.setTest_mode(adsConfig.test_mode);
            this.pref.setIs_active(adsConfig.is_active);
            this.pref.setMaxRewardPerDay(adsConfig.max_reward_per_day);
            this.pref.setMaxOpenAdsPerDay(adsConfig.max_openads_per_day);
            if (!this.pref.getOnlyfromplaystore().booleanValue()) {
                this.pref.setAd_type(adsConfig.ad_type);
                this.pref.setBackup_ads(adsConfig.backup_ads);
                Log.e("ConfigManager", ": onlyFromPlayStore=off, remote config memperbolehkan di luar Play Store");
            } else if (!this.isFromPlayStore) {
                this.pref.setAd_type(Constant.IRONSOURCE);
                Log.e("ConfigManager", ": Aplikasi dari non Play Store");
            } else {
                this.pref.setAd_type(adsConfig.ad_type);
                this.pref.setBackup_ads(adsConfig.backup_ads);
                Log.e("ConfigManager", ": onlyFromPlayStore=on");
                Log.e("ConfigManager", ": Aplikasi dari Play Store");
            }
        } catch (Exception e) {
            Log.e("ConfigManager", "saveAdsConfig error: " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAppConfig(AppConfig appConfig) {
        try {
            this.pref.setIdApp(appConfig.id);
            this.pref.setNama_apk(appConfig.nama_apk);
            this.pref.setPackage_name(appConfig.package_name);
            this.pref.setApp_icon(appConfig.app_icon);
            this.pref.setApp_version_update(appConfig.app_version_update);
            this.pref.setApp_version_min(appConfig.app_version_min);
            this.pref.setApp_redirect_status(appConfig.app_redirect_status);
            this.pref.setApp_redirect_url(appConfig.app_redirect_url);
            this.pref.setApp_dialog_btn_ok(appConfig.app_dialog_btn_ok);
            this.pref.setApp_dialog_title(appConfig.app_dialog_title);
            this.pref.setApp_dialog_desc(appConfig.app_dialog_desc);
        } catch (Exception e) {
            Log.e("ConfigManager", "saveAppConfig error: " + e.getMessage(), e);
        }
    }

    private void showDialog(String str, String str2, String str3, final boolean z2) {
        if (this.activity.isFinishing()) {
            return;
        }
        int identifier = this.activity.getResources().getIdentifier(C2300e4.h.H0, "drawable", this.activity.getPackageName());
        try {
            AlertDialog.Builder cancelable = new AlertDialog.Builder(this.activity).setTitle(str).setMessage(str2).setCancelable(!z2);
            if (identifier == 0) {
                identifier = R.drawable.ic_dialog_alert;
            }
            AlertDialog.Builder icon = cancelable.setIcon(identifier);
            final int i2 = 0;
            AlertDialog.Builder positiveButton = icon.setPositiveButton(str3, new DialogInterface.OnClickListener(this) { // from class: com.mimikridev.utilmanager.config.a

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ConfigManager f10693b;

                {
                    this.f10693b = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i8) {
                    switch (i2) {
                        case 0:
                            this.f10693b.lambda$showDialog$0(z2, dialogInterface, i8);
                            break;
                        default:
                            this.f10693b.lambda$showDialog$1(z2, dialogInterface, i8);
                            break;
                    }
                }
            });
            if (!z2) {
                final int i8 = 1;
                positiveButton.setNegativeButton("Cancel", new DialogInterface.OnClickListener(this) { // from class: com.mimikridev.utilmanager.config.a

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ ConfigManager f10693b;

                    {
                        this.f10693b = this;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i82) {
                        switch (i8) {
                            case 0:
                                this.f10693b.lambda$showDialog$0(z2, dialogInterface, i82);
                                break;
                            default:
                                this.f10693b.lambda$showDialog$1(z2, dialogInterface, i82);
                                break;
                        }
                    }
                });
            }
            positiveButton.create().show();
        } catch (Exception e) {
            Log.e("ConfigManager", "showDialog error: " + e.getMessage(), e);
        }
    }

    private void updateApp() {
        try {
            if (this.pref.getApp_version_update() > this.versionCode) {
                showDialog(this.pref.getApp_dialog_title(), this.pref.getApp_dialog_desc(), this.pref.getApp_dialog_btn_ok(), false);
            }
        } catch (Exception e) {
            Log.e("ConfigManager", "updateApp error: " + e.getMessage(), e);
        }
    }

    public void checkApp() {
        if (this.activity.isFinishing()) {
            return;
        }
        try {
            minUpdate();
            updateApp();
            redirect();
        } catch (Exception e) {
            Log.e("ConfigManager", "⚠️ checkApp error: " + e.getMessage(), e);
        }
    }

    public void getConfig() {
        this.pref.setOnlyfromplaystore(Boolean.valueOf(this.rc.getBoolean("only_from_playstore")));
        try {
            RestAdapter.createAPI(Dataku.urlApiServer()).getConfig(Dataku.apiKeyConfig(), this.activity.getPackageName(), this.versionCode).enqueue(new Callback<CallbackConfig>() { // from class: com.mimikridev.utilmanager.config.ConfigManager.1
                @Override // retrofit2.Callback
                public void onFailure(@NonNull Call<CallbackConfig> call, @NonNull Throwable th) {
                    Log.e("ConfigManager", "fetchConfig onFailure: " + th.getMessage(), th);
                }

                @Override // retrofit2.Callback
                public void onResponse(@NonNull Call<CallbackConfig> call, @NonNull Response<CallbackConfig> response) {
                    try {
                        if (response.isSuccessful() && response.body() != null) {
                            CallbackConfig callbackConfigBody = response.body();
                            if (callbackConfigBody == null || !callbackConfigBody.status) {
                                Log.e("ConfigManager", "fetchConfig gagal: status false / resp null");
                                return;
                            }
                            AdsConfig adsConfig = callbackConfigBody.ads_config;
                            if (adsConfig != null) {
                                ConfigManager.this.saveAdsConfig(adsConfig);
                            }
                            AppConfig appConfig = callbackConfigBody.app_config;
                            if (appConfig != null) {
                                ConfigManager.this.saveAppConfig(appConfig);
                            }
                            Log.d("ConfigManager", "Config berhasil disimpan ke SharedPreferences");
                            return;
                        }
                        Log.e("ConfigManager", "fetchConfig gagal: response null");
                    } catch (Exception e) {
                        Log.e("ConfigManager", "Error mapping config: " + e.getMessage(), e);
                    }
                }
            });
        } catch (Exception e) {
            Log.e("ConfigManager", "fetchConfig exception: " + e.getMessage(), e);
        }
    }

    public void init() {
        getConfig();
        checkApp();
    }
}
