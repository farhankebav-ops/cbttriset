package androidx.constraintlayout.core.state;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface RegistryCallback {
    String currentLayoutInformation();

    String currentMotionScene();

    long getLastModified();

    void onDimensions(int i2, int i8);

    void onNewMotionScene(String str);

    void onProgress(float f4);

    void setDrawDebug(int i2);

    void setLayoutInformationMode(int i2);
}
