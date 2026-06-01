package com.vungle.ads.internal.load;

import a3.d;
import com.unity3d.services.ads.operation.show.b;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.AssetRequestError;
import com.vungle.ads.PrivacyIconFallbackError;
import com.vungle.ads.internal.downloader.AssetDownloadListener;
import com.vungle.ads.internal.downloader.DefaultPrivacyIconInjector;
import com.vungle.ads.internal.downloader.DownloadRequest;
import com.vungle.ads.internal.model.AdAsset;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.platform.DeviceCheckUtils;
import com.vungle.ads.internal.util.Logger;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BaseAdLoader$assetDownloadListener$1 implements AssetDownloadListener {
    private boolean partialDownloadRecorded;
    final /* synthetic */ BaseAdLoader this$0;

    public BaseAdLoader$assetDownloadListener$1(BaseAdLoader baseAdLoader) {
        this.this$0 = baseAdLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onError$lambda-1, reason: not valid java name */
    public static final void m3322onError$lambda1(DownloadRequest downloadRequest, BaseAdLoader this$0, BaseAdLoader$assetDownloadListener$1 this$1, AssetDownloadListener.DownloadError downloadError) {
        k.e(downloadRequest, "$downloadRequest");
        k.e(this$0, "this$0");
        k.e(this$1, "this$1");
        AdAsset asset = downloadRequest.getAsset();
        if (asset.isPrivacyIcon()) {
            File fileInjectPrivacyIcon = DefaultPrivacyIconInjector.INSTANCE.injectPrivacyIcon(this$0.getPathProvider().getVmDir());
            if (fileInjectPrivacyIcon != null && fileInjectPrivacyIcon.exists()) {
                this$1.onSuccess(fileInjectPrivacyIcon, downloadRequest);
                return;
            }
            new PrivacyIconFallbackError("Failed to inject default privacy icon").setLogEntry$vungle_ads_release(this$0.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
        }
        this$0.fullyDownloaded.set(false);
        if (asset.isRequired()) {
            this$0.requiredAssetDownloaded.set(false);
        }
        new AssetRequestError("Failed to download assets " + asset.getServerPath() + ". error: " + downloadError + " proxyEnabled=" + DeviceCheckUtils.INSTANCE.isProxyEnabled(this$0.getContext())).setLogEntry$vungle_ads_release(this$0.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
        if (asset.isRequired()) {
            this$0.downloadRequiredAssets.remove(downloadRequest.getAsset().getServerPath());
            if (this$0.downloadRequiredAssets.isEmpty()) {
                this$0.onAdLoadFailed(new AssetRequestError("Error: Failed to download required assets."));
                this$0.cancel();
                return;
            }
        }
        if (this$0.downloadCount.decrementAndGet() <= 0) {
            this$0.onAdLoadFailed(new AssetRequestError("Error: Failed to download assets."));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onProgress$lambda-0, reason: not valid java name */
    public static final void m3323onProgress$lambda0(BaseAdLoader this$0, AdAsset adAsset) throws Throwable {
        k.e(this$0, "this$0");
        k.e(adAsset, "$adAsset");
        this$0.downloadRequiredAssets.remove(adAsset.getServerPath());
        if (this$0.downloadRequiredAssets.isEmpty()) {
            if (this$0.requiredAssetDownloaded.get()) {
                this$0.onRequiredDownloadCompleted();
            } else {
                this$0.onAdLoadFailed(new AssetRequestError("Failed to download required assets."));
                this$0.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onSuccess$lambda-2, reason: not valid java name */
    public static final void m3324onSuccess$lambda2(File file, BaseAdLoader$assetDownloadListener$1 this$0, DownloadRequest downloadRequest, BaseAdLoader this$1) throws Throwable {
        k.e(file, "$file");
        k.e(this$0, "this$0");
        k.e(downloadRequest, "$downloadRequest");
        k.e(this$1, "this$1");
        if (!file.exists()) {
            this$0.onError(new AssetDownloadListener.DownloadError(-1, new IOException("Downloaded file not found!"), AssetDownloadListener.DownloadError.ErrorReason.Companion.getFILE_NOT_FOUND_ERROR()), downloadRequest);
            return;
        }
        AdAsset asset = downloadRequest.getAsset();
        asset.setFileSize(file.length());
        asset.setStatus(AdAsset.Status.DOWNLOAD_SUCCESS);
        if (asset.isHtmlTemplate()) {
            downloadRequest.stopTemplateRecord();
            this$1.templateHtmlSizeMetric.setValue(Long.valueOf(file.length()));
            AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(this$1.templateHtmlSizeMetric, this$1.getLogEntry$vungle_ads_release(), asset.getServerPath());
        } else if (asset.isMainVideo()) {
            this$1.mainVideoSizeMetric.setValue(Long.valueOf(file.length()));
            AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(this$1.mainVideoSizeMetric, this$1.getLogEntry$vungle_ads_release(), asset.getServerPath());
        }
        AdPayload advertisement$vungle_ads_release = this$1.getAdvertisement$vungle_ads_release();
        if (advertisement$vungle_ads_release != null) {
            advertisement$vungle_ads_release.updateAdAssetPath(asset.getAdIdentifier(), file);
        }
        if (asset.isHtmlTemplate() && !this$1.processVmTemplate(asset, this$1.getAdvertisement$vungle_ads_release())) {
            this$1.fullyDownloaded.set(false);
            if (asset.isRequired()) {
                this$1.requiredAssetDownloaded.set(false);
            }
        }
        if (asset.isRequired()) {
            this$1.downloadRequiredAssets.remove(asset.getServerPath());
            if (this$1.downloadRequiredAssets.isEmpty()) {
                if (!this$1.requiredAssetDownloaded.get()) {
                    this$1.onAdLoadFailed(new AssetRequestError("Failed to download required assets."));
                    this$1.cancel();
                    return;
                }
                this$1.onRequiredDownloadCompleted();
            }
        }
        if (this$1.downloadCount.decrementAndGet() <= 0) {
            if (this$1.fullyDownloaded.get()) {
                this$1.onDownloadCompleted(this$1.getAdRequest());
            } else {
                this$1.onAdLoadFailed(new AssetRequestError("Failed to download assets."));
            }
        }
    }

    @Override // com.vungle.ads.internal.downloader.AssetDownloadListener
    public void onError(AssetDownloadListener.DownloadError downloadError, DownloadRequest downloadRequest) {
        k.e(downloadRequest, "downloadRequest");
        Logger.Companion.e("BaseAdLoader", "onError called: " + downloadError);
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new d(downloadRequest, this.this$0, this, downloadError, 9));
    }

    @Override // com.vungle.ads.internal.downloader.AssetDownloadListener
    public void onProgress(AssetDownloadListener.Progress progress, DownloadRequest downloadRequest) {
        k.e(progress, "progress");
        k.e(downloadRequest, "downloadRequest");
        AdAsset asset = downloadRequest.getAsset();
        Logger.Companion companion = Logger.Companion;
        companion.d("BaseAdLoader", "Download progress: " + progress + " url: " + asset.getServerPath());
        if (!asset.isRequired() || asset.getPercentage() == null || asset.getPercentage().intValue() <= 0 || progress.getProgressPercent() < asset.getPercentage().intValue() || this.partialDownloadRecorded) {
            return;
        }
        this.partialDownloadRecorded = true;
        downloadRequest.stopPartialDownloadRecord();
        companion.w("BaseAdLoader", "Download progress: hit chunk percentage=" + asset.getPercentage() + " for url: " + asset.getServerPath());
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new b(3, this.this$0, asset));
    }

    @Override // com.vungle.ads.internal.downloader.AssetDownloadListener
    public void onStart(DownloadRequest downloadRequest) {
        k.e(downloadRequest, "downloadRequest");
        Logger.Companion.w("BaseAdLoader", "onStart called: " + downloadRequest.getAsset().getServerPath());
        AdAsset asset = downloadRequest.getAsset();
        if (asset.isRequired()) {
            Integer percentage = asset.getPercentage();
            if ((percentage != null ? percentage.intValue() : 0) > 0) {
                downloadRequest.startPartialDownloadRecord();
            }
        }
    }

    @Override // com.vungle.ads.internal.downloader.AssetDownloadListener
    public void onSuccess(File file, DownloadRequest downloadRequest) {
        k.e(file, "file");
        k.e(downloadRequest, "downloadRequest");
        this.this$0.getSdkExecutors().getBackgroundExecutor().execute(new d(file, this, downloadRequest, this.this$0, 8));
    }
}
