package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.mUsage = versionedParcel.readInt(audioAttributesImplBase.mUsage, 1);
        audioAttributesImplBase.mContentType = versionedParcel.readInt(audioAttributesImplBase.mContentType, 2);
        audioAttributesImplBase.mFlags = versionedParcel.readInt(audioAttributesImplBase.mFlags, 3);
        audioAttributesImplBase.mLegacyStream = versionedParcel.readInt(audioAttributesImplBase.mLegacyStream, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(audioAttributesImplBase.mUsage, 1);
        versionedParcel.writeInt(audioAttributesImplBase.mContentType, 2);
        versionedParcel.writeInt(audioAttributesImplBase.mFlags, 3);
        versionedParcel.writeInt(audioAttributesImplBase.mLegacyStream, 4);
    }
}
