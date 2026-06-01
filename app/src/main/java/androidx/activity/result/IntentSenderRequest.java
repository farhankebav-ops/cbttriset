package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    private final Intent fillInIntent;
    private final int flagsMask;
    private final int flagsValues;
    private final IntentSender intentSender;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() { // from class: androidx.activity.result.IntentSenderRequest$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest createFromParcel(Parcel inParcel) {
            k.e(inParcel, "inParcel");
            return new IntentSenderRequest(inParcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest[] newArray(int i2) {
            return new IntentSenderRequest[i2];
        }
    };

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {
        private Intent fillInIntent;
        private int flagsMask;
        private int flagsValues;
        private final IntentSender intentSender;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface Flag {
        }

        public Builder(IntentSender intentSender) {
            k.e(intentSender, "intentSender");
            this.intentSender = intentSender;
        }

        public final IntentSenderRequest build() {
            return new IntentSenderRequest(this.intentSender, this.fillInIntent, this.flagsMask, this.flagsValues);
        }

        public final Builder setFillInIntent(Intent intent) {
            this.fillInIntent = intent;
            return this;
        }

        public final Builder setFlags(int i2, int i8) {
            this.flagsValues = i2;
            this.flagsMask = i8;
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Builder(PendingIntent pendingIntent) {
            k.e(pendingIntent, "pendingIntent");
            IntentSender intentSender = pendingIntent.getIntentSender();
            k.d(intentSender, "getIntentSender(...)");
            this(intentSender);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i2, int i8) {
        k.e(intentSender, "intentSender");
        this.intentSender = intentSender;
        this.fillInIntent = intent;
        this.flagsMask = i2;
        this.flagsValues = i8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Intent getFillInIntent() {
        return this.fillInIntent;
    }

    public final int getFlagsMask() {
        return this.flagsMask;
    }

    public final int getFlagsValues() {
        return this.flagsValues;
    }

    public final IntentSender getIntentSender() {
        return this.intentSender;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i2) {
        k.e(dest, "dest");
        dest.writeParcelable(this.intentSender, i2);
        dest.writeParcelable(this.fillInIntent, i2);
        dest.writeInt(this.flagsMask);
        dest.writeInt(this.flagsValues);
    }

    public /* synthetic */ IntentSenderRequest(IntentSender intentSender, Intent intent, int i2, int i8, int i9, f fVar) {
        this(intentSender, (i9 & 2) != 0 ? null : intent, (i9 & 4) != 0 ? 0 : i2, (i9 & 8) != 0 ? 0 : i8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public IntentSenderRequest(Parcel parcel) {
        k.e(parcel, "parcel");
        Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
        k.b(parcelable);
        this((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
