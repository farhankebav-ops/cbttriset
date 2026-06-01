package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.material.datepicker.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3261a;

    public /* synthetic */ f(int i2) {
        this.f3261a = i2;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Uri mediaUri;
        Bundle bundle;
        b.b bVar = null;
        switch (this.f3261a) {
            case 0:
                return new MediaBrowserCompat$MediaItem(parcel);
            case 1:
                Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (objCreateFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                String mediaId = mediaDescription.getMediaId();
                CharSequence title = mediaDescription.getTitle();
                CharSequence subtitle = mediaDescription.getSubtitle();
                CharSequence description = mediaDescription.getDescription();
                Bitmap iconBitmap = mediaDescription.getIconBitmap();
                Uri iconUri = mediaDescription.getIconUri();
                Bundle extras = mediaDescription.getExtras();
                if (extras != null) {
                    android.support.v4.media.session.g.a(extras);
                    mediaUri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
                } else {
                    mediaUri = null;
                }
                if (mediaUri == null) {
                    bundle = extras;
                } else if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                    bundle = null;
                } else {
                    extras.remove("android.support.v4.media.description.MEDIA_URI");
                    extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    bundle = extras;
                }
                if (mediaUri == null) {
                    mediaUri = mediaDescription.getMediaUri();
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
                mediaDescriptionCompat.f3250i = objCreateFromParcel;
                return mediaDescriptionCompat;
            case 2:
                return new MediaMetadataCompat(parcel);
            case 3:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 4:
                return new MediaSessionCompat$QueueItem(parcel);
            case 5:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.f3271a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 6:
                return new MediaSessionCompat$Token(parcel.readParcelable(null), null);
            case 7:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.f3274a = parcel.readInt();
                parcelableVolumeInfo.f3276c = parcel.readInt();
                parcelableVolumeInfo.f3277d = parcel.readInt();
                parcelableVolumeInfo.e = parcel.readInt();
                parcelableVolumeInfo.f3275b = parcel.readInt();
                return parcelableVolumeInfo;
            case 8:
                return new PlaybackStateCompat(parcel);
            case 9:
                b.d dVar = new b.d();
                IBinder strongBinder = parcel.readStrongBinder();
                int i2 = b.c.f4112b;
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(b.b.f4111y6);
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b.b)) {
                        b.a aVar = new b.a();
                        aVar.f4110a = strongBinder;
                        bVar = aVar;
                    } else {
                        bVar = (b.b) iInterfaceQueryLocalInterface;
                    }
                }
                dVar.f4114a = bVar;
                return dVar;
            case 10:
                return new com.google.android.material.datepicker.b((r) parcel.readParcelable(r.class.getClassLoader()), (r) parcel.readParcelable(r.class.getClassLoader()), (com.google.android.material.datepicker.d) parcel.readParcelable(com.google.android.material.datepicker.d.class.getClassLoader()), (r) parcel.readParcelable(r.class.getClassLoader()), parcel.readInt());
            case 11:
                return new com.google.android.material.datepicker.d(parcel.readLong());
            case 12:
                return r.a(parcel.readInt(), parcel.readInt());
            case 13:
                k1.b bVar2 = new k1.b(parcel);
                bVar2.f12596a = ((Integer) parcel.readValue(k1.b.class.getClassLoader())).intValue();
                return bVar2;
            default:
                l3.b bVar3 = new l3.b(parcel);
                bVar3.f12764a = parcel.readFloat();
                bVar3.f12765b = parcel.readFloat();
                bVar3.f12766c = parcel.readByte() != 0;
                bVar3.f12767d = parcel.readFloat();
                bVar3.e = parcel.readInt();
                bVar3.f12768f = parcel.readInt();
                bVar3.g = parcel.readInt();
                bVar3.h = parcel.readInt();
                bVar3.f12769i = parcel.readInt();
                bVar3.j = parcel.readByte() != 0;
                bVar3.k = parcel.readByte() != 0;
                return bVar3;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i2) {
        switch (this.f3261a) {
            case 0:
                return new MediaBrowserCompat$MediaItem[i2];
            case 1:
                return new MediaDescriptionCompat[i2];
            case 2:
                return new MediaMetadataCompat[i2];
            case 3:
                return new RatingCompat[i2];
            case 4:
                return new MediaSessionCompat$QueueItem[i2];
            case 5:
                return new MediaSessionCompat$ResultReceiverWrapper[i2];
            case 6:
                return new MediaSessionCompat$Token[i2];
            case 7:
                return new ParcelableVolumeInfo[i2];
            case 8:
                return new PlaybackStateCompat[i2];
            case 9:
                return new b.d[i2];
            case 10:
                return new com.google.android.material.datepicker.b[i2];
            case 11:
                return new com.google.android.material.datepicker.d[i2];
            case 12:
                return new r[i2];
            case 13:
                return new k1.b[i2];
            default:
                return new l3.b[i2];
        }
    }
}
