package androidx.camera.featurecombinationquery;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.hardware.camera2.CameraAccessException;
import android.os.Build;
import android.os.Bundle;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class CameraDeviceSetupCompatFactory {
    private static final String PLAY_SERVICES_IMPL_KEY = "androidx.camera.featurecombinationquery.PLAY_SERVICES_IMPL_PROVIDER_KEY";
    private CameraDeviceSetupCompatProvider mCamera2Provider;
    private final Context mContext;
    private CameraDeviceSetupCompatProvider mPlayServicesProvider;

    public CameraDeviceSetupCompatFactory(Context context) {
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 35) {
            this.mCamera2Provider = new Camera2CameraDeviceSetupCompatProvider(context);
        }
        this.mPlayServicesProvider = getPlayServicesCameraDeviceSetupCompatProvider();
    }

    private CameraDeviceSetupCompatProvider getPlayServicesCameraDeviceSetupCompatProvider() throws IllegalStateException {
        String string;
        try {
            ServiceInfo[] serviceInfoArr = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE).services;
            if (serviceInfoArr == null) {
                return null;
            }
            String str = null;
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                Bundle bundle = serviceInfo.metaData;
                if (bundle != null && (string = bundle.getString(PLAY_SERVICES_IMPL_KEY)) != null) {
                    if (str != null) {
                        throw new IllegalStateException("Multiple Play Services CameraDeviceSetupCompat implementations found in the manifest.");
                    }
                    str = string;
                }
            }
            if (str == null) {
                return null;
            }
            return instantiatePlayServicesImplProvider(str);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private CameraDeviceSetupCompatProvider instantiatePlayServicesImplProvider(String str) {
        try {
            return (CameraDeviceSetupCompatProvider) Class.forName(str).getConstructor(Context.class).newInstance(this.mContext);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to instantiate Play Services CameraDeviceSetupCompat implementation", e);
        }
    }

    public CameraDeviceSetupCompat getCameraDeviceSetupCompat(String str) throws CameraAccessException {
        ArrayList arrayList = new ArrayList();
        CameraDeviceSetupCompatProvider cameraDeviceSetupCompatProvider = this.mPlayServicesProvider;
        if (cameraDeviceSetupCompatProvider != null) {
            arrayList.add(cameraDeviceSetupCompatProvider.getCameraDeviceSetupCompat(str));
        }
        CameraDeviceSetupCompatProvider cameraDeviceSetupCompatProvider2 = this.mCamera2Provider;
        if (cameraDeviceSetupCompatProvider2 != null) {
            try {
                arrayList.add(cameraDeviceSetupCompatProvider2.getCameraDeviceSetupCompat(str));
            } catch (UnsupportedOperationException unused) {
            }
        }
        return new AggregatedCameraDeviceSetupCompat(arrayList);
    }
}
