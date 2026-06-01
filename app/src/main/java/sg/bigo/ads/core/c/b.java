package sg.bigo.ads.core.c;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.iab.omid.library.bigosg.adsession.AdEvents;
import com.iab.omid.library.bigosg.adsession.AdSession;
import com.iab.omid.library.bigosg.adsession.media.InteractionType;
import com.iab.omid.library.bigosg.adsession.media.MediaEvents;
import com.iab.omid.library.bigosg.adsession.media.Position;
import com.iab.omid.library.bigosg.adsession.media.VastProperties;
import com.ironsource.C2300e4;
import sg.bigo.ads.common.n.d;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaEvents f16845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16846b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final AdSession f16847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    private final AdEvents f16848d;

    /* JADX INFO: renamed from: sg.bigo.ads.core.c.b$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f16851b;

        static {
            int[] iArr = new int[a.a().length];
            f16851b = iArr;
            try {
                iArr[a.f16852a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16851b[a.f16853b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16851b[a.f16854c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16851b[a.f16855d - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16851b[a.e - 1] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[EnumC0313b.a().length];
            f16850a = iArr2;
            try {
                iArr2[EnumC0313b.f16857a - 1] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16850a[EnumC0313b.f16858b - 1] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16850a[EnumC0313b.f16859c - 1] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16850a[EnumC0313b.f16860d - 1] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f16852a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f16853b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f16854c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f16855d = 4;
        public static final int e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ int[] f16856f = {1, 2, 3, 4, 5};

        public static int[] a() {
            return (int[]) f16856f.clone();
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: renamed from: sg.bigo.ads.core.c.b$b, reason: collision with other inner class name */
    public static final class EnumC0313b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f16857a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f16858b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f16859c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f16860d = 4;
        private static final /* synthetic */ int[] e = {1, 2, 3, 4};

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    public b(@NonNull AdSession adSession, @Nullable MediaEvents mediaEvents) {
        this.f16847c = adSession;
        this.f16845a = mediaEvents;
        AdEvents adEventsCreateAdEvents = AdEvents.createAdEvents(adSession);
        this.f16848d = adEventsCreateAdEvents;
        try {
            if (this.f16845a != null) {
                adEventsCreateAdEvents.loaded(VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE));
            } else {
                adEventsCreateAdEvents.loaded();
            }
            a(C2300e4.h.f8381r);
        } catch (Exception unused) {
        }
    }

    public final void a() {
        try {
            this.f16848d.impressionOccurred();
            a("impression");
        } catch (Exception unused) {
        }
    }

    public final void b() {
        if (d.b()) {
            c();
        } else {
            d.a(2, new Runnable() { // from class: sg.bigo.ads.core.c.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c();
                }
            });
        }
        this.f16845a = null;
    }

    public final void c() {
        try {
            this.f16847c.finish();
        } catch (Throwable unused) {
        }
    }

    public final void a(float f4, @FloatRange(from = 0.0d, to = 1.0d) float f8) {
        MediaEvents mediaEvents = this.f16845a;
        if (mediaEvents == null) {
            return;
        }
        mediaEvents.start(f4, f8);
        this.f16846b = true;
        a("video start, duration: " + f4 + ", volume: " + f8);
    }

    public final void b(int i2) {
        String str;
        MediaEvents mediaEvents = this.f16845a;
        if (mediaEvents == null) {
            return;
        }
        int i8 = AnonymousClass2.f16851b[i2 - 1];
        if (i8 == 1) {
            mediaEvents.pause();
            str = "video pause";
        } else if (i8 == 2) {
            mediaEvents.resume();
            str = "video resume";
        } else if (i8 == 3) {
            mediaEvents.bufferStart();
            str = "video buffer start";
        } else if (i8 == 4) {
            mediaEvents.bufferFinish();
            str = "video buffer finish";
        } else {
            if (i8 != 5) {
                return;
            }
            mediaEvents.skipped();
            str = "video skipped";
        }
        a(str);
    }

    public final void a(int i2) {
        String str;
        MediaEvents mediaEvents = this.f16845a;
        if (mediaEvents == null) {
            return;
        }
        int i8 = AnonymousClass2.f16850a[i2 - 1];
        if (i8 == 1) {
            mediaEvents.firstQuartile();
            str = "video first quartile";
        } else if (i8 == 2) {
            mediaEvents.midpoint();
            str = "video mid point";
        } else if (i8 == 3) {
            mediaEvents.thirdQuartile();
            str = "video third quartile";
        } else {
            if (i8 != 4) {
                return;
            }
            mediaEvents.complete();
            str = "video complete";
        }
        a(str);
    }

    public final void a(InteractionType interactionType) {
        MediaEvents mediaEvents = this.f16845a;
        if (mediaEvents == null) {
            return;
        }
        mediaEvents.adUserInteraction(interactionType);
        a("ad user interaction: " + interactionType.toString());
    }

    public final void a(String str) {
        StringBuilder sbY = a1.a.y("Event: ", str, " (");
        sbY.append(this.f16847c.getAdSessionId());
        sbY.append(")");
        sg.bigo.ads.common.t.a.a(0, 3, "OMSDK", sbY.toString());
    }
}
