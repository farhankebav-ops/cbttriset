package androidx.camera.video.internal.config;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MimeInfo {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class Builder<B> {
        public abstract MimeInfo build();

        public abstract B setMimeType(String str);

        public abstract B setProfile(int i2);
    }

    public abstract String getMimeType();

    public abstract int getProfile();
}
