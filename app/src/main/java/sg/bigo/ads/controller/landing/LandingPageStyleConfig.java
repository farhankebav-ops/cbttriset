package sg.bigo.ads.controller.landing;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public class LandingPageStyleConfig implements Parcelable {
    public static final Parcelable.Creator<LandingPageStyleConfig> CREATOR = new Parcelable.Creator<LandingPageStyleConfig>() { // from class: sg.bigo.ads.controller.landing.LandingPageStyleConfig.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LandingPageStyleConfig createFromParcel(Parcel parcel) {
            return new LandingPageStyleConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LandingPageStyleConfig[] newArray(int i2) {
            return new LandingPageStyleConfig[i2];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f16679d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f16680f;
    public final Class<? extends c> g;

    public LandingPageStyleConfig(Parcel parcel) {
        this.g = (Class) parcel.readSerializable();
        this.f16678c = parcel.readInt();
        this.f16676a = parcel.readInt();
        this.f16677b = parcel.readInt();
        this.f16679d = parcel.readInt();
        this.e = parcel.readInt();
        this.f16680f = parcel.readFloat();
    }

    public final boolean a() {
        return this.g != null && this.f16679d > 0;
    }

    public final boolean b() {
        int i2 = this.f16676a;
        return i2 == 0 || i2 == 7 || i2 == 8;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeSerializable(this.g);
        parcel.writeInt(this.f16678c);
        parcel.writeInt(this.f16676a);
        parcel.writeInt(this.f16677b);
        parcel.writeInt(this.f16679d);
        parcel.writeInt(this.e);
        parcel.writeFloat(this.f16680f);
    }

    public LandingPageStyleConfig(Class<? extends c> cls, int i2, int i8, int i9, int i10, int i11, float f4) {
        this.g = cls;
        this.f16678c = i2;
        this.f16676a = i8;
        this.f16677b = i9;
        this.f16679d = i10;
        this.e = i11;
        this.f16680f = f4;
    }
}
