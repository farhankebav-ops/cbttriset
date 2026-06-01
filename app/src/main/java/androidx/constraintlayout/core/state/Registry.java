package androidx.constraintlayout.core.state;

import androidx.core.location.LocationRequestCompat;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class Registry {
    private static final Registry sRegistry = new Registry();
    private HashMap<String, RegistryCallback> mCallbacks = new HashMap<>();

    public static Registry getInstance() {
        return sRegistry;
    }

    public String currentContent(String str) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            return registryCallback.currentMotionScene();
        }
        return null;
    }

    public String currentLayoutInformation(String str) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            return registryCallback.currentLayoutInformation();
        }
        return null;
    }

    public long getLastModified(String str) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        return registryCallback != null ? registryCallback.getLastModified() : LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public Set<String> getLayoutList() {
        return this.mCallbacks.keySet();
    }

    public void register(String str, RegistryCallback registryCallback) {
        this.mCallbacks.put(str, registryCallback);
    }

    public void setDrawDebug(String str, int i2) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.setDrawDebug(i2);
        }
    }

    public void setLayoutInformationMode(String str, int i2) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.setLayoutInformationMode(i2);
        }
    }

    public void unregister(String str, RegistryCallback registryCallback) {
        this.mCallbacks.remove(str);
    }

    public void updateContent(String str, String str2) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.onNewMotionScene(str2);
        }
    }

    public void updateDimensions(String str, int i2, int i8) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.onDimensions(i2, i8);
        }
    }

    public void updateProgress(String str, float f4) {
        RegistryCallback registryCallback = this.mCallbacks.get(str);
        if (registryCallback != null) {
            registryCallback.onProgress(f4);
        }
    }
}
