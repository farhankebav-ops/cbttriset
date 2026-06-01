package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.webkit.UserAgentMetadata;
import androidx.webkit.WebViewMediaIntegrityApiStatusConfig;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class WebSettingsAdapter {
    private final WebSettingsBoundaryInterface mBoundaryInterface;

    public WebSettingsAdapter(@NonNull WebSettingsBoundaryInterface webSettingsBoundaryInterface) {
        this.mBoundaryInterface = webSettingsBoundaryInterface;
    }

    public int getAttributionRegistrationBehavior() {
        return this.mBoundaryInterface.getAttributionBehavior();
    }

    public boolean getBackForwardCacheEnabled() {
        return this.mBoundaryInterface.getBackForwardCacheEnabled();
    }

    public int getDisabledActionModeMenuItems() {
        return this.mBoundaryInterface.getDisabledActionModeMenuItems();
    }

    public boolean getEnterpriseAuthenticationAppLinkPolicyEnabled() {
        return this.mBoundaryInterface.getEnterpriseAuthenticationAppLinkPolicyEnabled();
    }

    public int getForceDark() {
        return this.mBoundaryInterface.getForceDark();
    }

    public int getForceDarkStrategy() {
        return this.mBoundaryInterface.getForceDarkBehavior();
    }

    public boolean getOffscreenPreRaster() {
        return this.mBoundaryInterface.getOffscreenPreRaster();
    }

    @NonNull
    public Set<String> getRequestedWithHeaderOriginAllowList() {
        return this.mBoundaryInterface.getRequestedWithHeaderOriginAllowList();
    }

    public boolean getSafeBrowsingEnabled() {
        return this.mBoundaryInterface.getSafeBrowsingEnabled();
    }

    public int getSpeculativeLoadingStatus() {
        return this.mBoundaryInterface.getSpeculativeLoadingStatus();
    }

    @NonNull
    public UserAgentMetadata getUserAgentMetadata() {
        return UserAgentMetadataInternal.getUserAgentMetadataFromMap(this.mBoundaryInterface.getUserAgentMetadataMap());
    }

    public int getWebAuthenticationSupport() {
        return this.mBoundaryInterface.getWebauthnSupport();
    }

    @NonNull
    public WebViewMediaIntegrityApiStatusConfig getWebViewMediaIntegrityApiStatus() {
        return new WebViewMediaIntegrityApiStatusConfig.Builder(this.mBoundaryInterface.getWebViewMediaIntegrityApiDefaultStatus()).setOverrideRules(this.mBoundaryInterface.getWebViewMediaIntegrityApiOverrideRules()).build();
    }

    public boolean isAlgorithmicDarkeningAllowed() {
        return this.mBoundaryInterface.isAlgorithmicDarkeningAllowed();
    }

    public void setAlgorithmicDarkeningAllowed(boolean z2) {
        this.mBoundaryInterface.setAlgorithmicDarkeningAllowed(z2);
    }

    public void setAttributionRegistrationBehavior(int i2) {
        this.mBoundaryInterface.setAttributionBehavior(i2);
    }

    public void setBackForwardCacheEnabled(boolean z2) {
        this.mBoundaryInterface.setBackForwardCacheEnabled(z2);
    }

    public void setDisabledActionModeMenuItems(int i2) {
        this.mBoundaryInterface.setDisabledActionModeMenuItems(i2);
    }

    public void setEnterpriseAuthenticationAppLinkPolicyEnabled(boolean z2) {
        this.mBoundaryInterface.setEnterpriseAuthenticationAppLinkPolicyEnabled(z2);
    }

    public void setForceDark(int i2) {
        this.mBoundaryInterface.setForceDark(i2);
    }

    public void setForceDarkStrategy(int i2) {
        this.mBoundaryInterface.setForceDarkBehavior(i2);
    }

    public void setOffscreenPreRaster(boolean z2) {
        this.mBoundaryInterface.setOffscreenPreRaster(z2);
    }

    public void setRequestedWithHeaderOriginAllowList(@NonNull Set<String> set) {
        this.mBoundaryInterface.setRequestedWithHeaderOriginAllowList(set);
    }

    public void setSafeBrowsingEnabled(boolean z2) {
        this.mBoundaryInterface.setSafeBrowsingEnabled(z2);
    }

    public void setSpeculativeLoadingStatus(int i2) {
        this.mBoundaryInterface.setSpeculativeLoadingStatus(i2);
    }

    public void setUserAgentMetadata(@NonNull UserAgentMetadata userAgentMetadata) {
        this.mBoundaryInterface.setUserAgentMetadataFromMap(UserAgentMetadataInternal.convertUserAgentMetadataToMap(userAgentMetadata));
    }

    public void setWebAuthenticationSupport(int i2) {
        this.mBoundaryInterface.setWebauthnSupport(i2);
    }

    public void setWebViewMediaIntegrityApiStatus(@NonNull WebViewMediaIntegrityApiStatusConfig webViewMediaIntegrityApiStatusConfig) {
        this.mBoundaryInterface.setWebViewMediaIntegrityApiStatus(webViewMediaIntegrityApiStatusConfig.getDefaultStatus(), webViewMediaIntegrityApiStatusConfig.getOverrideRules());
    }
}
