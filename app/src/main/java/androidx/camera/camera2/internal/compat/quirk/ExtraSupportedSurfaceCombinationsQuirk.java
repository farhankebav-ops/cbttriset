package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ExtraSupportedSurfaceCombinationsQuirk implements Quirk {
    private static final SurfaceCombination FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION = createFullYuvPrivYuvConfiguration();
    private static final SurfaceCombination LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION = createLevel3PrivPrivYuvSubsetConfiguration();
    private static final Set<String> SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS = new HashSet(Arrays.asList("PIXEL 6", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO", "PIXEL 9", "PIXEL 9 PRO", "PIXEL 9 PRO XL", "PIXEL 9 PRO FOLD"));
    private static final Set<String> SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS = new HashSet(Arrays.asList("SM-S921", "SC-51E", "SCG25", "SM-S926", "SM-S928", "SC-52E", "SCG26", "SM-S931", "SM-S936", "SM-S937", "SM-S938", "SCG31", "SCG32", "SC-51F", "SC-52F"));
    private static final String TAG = "ExtraSupportedSurfaceCombinationsQuirk";

    private static SurfaceCombination createFullYuvPrivYuvConfiguration() {
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, SurfaceConfig.ConfigSize.VGA));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, SurfaceConfig.ConfigSize.MAXIMUM));
        return surfaceCombination;
    }

    private static SurfaceCombination createLevel3PrivPrivYuvSubsetConfiguration() {
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, SurfaceConfig.ConfigSize.VGA));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        return surfaceCombination;
    }

    private List<SurfaceCombination> getSamsungS7ExtraCombinations(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("1")) {
            arrayList.add(FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION);
        }
        return arrayList;
    }

    private static boolean isSamsungS7() {
        String str = Build.DEVICE;
        return "heroqltevzw".equalsIgnoreCase(str) || "heroqltetmo".equalsIgnoreCase(str);
    }

    public static boolean load() {
        return isSamsungS7() || supportExtraLevel3ConfigurationsGoogleDevice() || supportExtraLevel3ConfigurationsSamsungDevice();
    }

    private static boolean supportExtraLevel3ConfigurationsGoogleDevice() {
        if (!AndroidStaticDeviceInfoDataSource.STORE_GOOGLE.equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        return SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS.contains(Build.MODEL.toUpperCase(Locale.US));
    }

    private static boolean supportExtraLevel3ConfigurationsSamsungDevice() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        String upperCase = Build.MODEL.toUpperCase(Locale.US);
        Iterator<String> it = SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS.iterator();
        while (it.hasNext()) {
            if (upperCase.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public List<SurfaceCombination> getExtraSupportedSurfaceCombinations(String str) {
        return isSamsungS7() ? getSamsungS7ExtraCombinations(str) : (supportExtraLevel3ConfigurationsGoogleDevice() || supportExtraLevel3ConfigurationsSamsungDevice()) ? Collections.singletonList(LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION) : Collections.EMPTY_LIST;
    }
}
