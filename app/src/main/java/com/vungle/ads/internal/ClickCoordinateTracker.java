package com.vungle.ads.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.TpatError;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.network.TpatRequest;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.ViewUtility;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n7.b;
import q5.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ClickCoordinateTracker {
    private static final String TAG = "ClickCoordinateTracker";
    private final AdPayload advertisement;
    private final Context context;
    private final ClickCoordinate currentClick;
    public static final Companion Companion = new Companion(null);
    private static final String MACRO_REQ_WIDTH = Pattern.quote("{{{req_width}}}");
    private static final String MACRO_REQ_HEIGHT = Pattern.quote("{{{req_height}}}");
    private static final String MACRO_WIDTH = Pattern.quote("{{{width}}}");
    private static final String MACRO_HEIGHT = Pattern.quote("{{{height}}}");
    private static final String MACRO_DOWN_X = Pattern.quote("{{{down_x}}}");
    private static final String MACRO_DOWN_Y = Pattern.quote("{{{down_y}}}");
    private static final String MACRO_UP_X = Pattern.quote("{{{up_x}}}");
    private static final String MACRO_UP_Y = Pattern.quote("{{{up_y}}}");

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class ClickCoordinate {
        private Coordinate downCoordinate;
        private Coordinate upCoordinate;

        public ClickCoordinate(Coordinate downCoordinate, Coordinate upCoordinate) {
            k.e(downCoordinate, "downCoordinate");
            k.e(upCoordinate, "upCoordinate");
            this.downCoordinate = downCoordinate;
            this.upCoordinate = upCoordinate;
        }

        public static /* synthetic */ ClickCoordinate copy$default(ClickCoordinate clickCoordinate, Coordinate coordinate, Coordinate coordinate2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                coordinate = clickCoordinate.downCoordinate;
            }
            if ((i2 & 2) != 0) {
                coordinate2 = clickCoordinate.upCoordinate;
            }
            return clickCoordinate.copy(coordinate, coordinate2);
        }

        public final Coordinate component1() {
            return this.downCoordinate;
        }

        public final Coordinate component2() {
            return this.upCoordinate;
        }

        public final ClickCoordinate copy(Coordinate downCoordinate, Coordinate upCoordinate) {
            k.e(downCoordinate, "downCoordinate");
            k.e(upCoordinate, "upCoordinate");
            return new ClickCoordinate(downCoordinate, upCoordinate);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClickCoordinate)) {
                return false;
            }
            ClickCoordinate clickCoordinate = (ClickCoordinate) obj;
            return k.a(this.downCoordinate, clickCoordinate.downCoordinate) && k.a(this.upCoordinate, clickCoordinate.upCoordinate);
        }

        public final Coordinate getDownCoordinate() {
            return this.downCoordinate;
        }

        public final Coordinate getUpCoordinate() {
            return this.upCoordinate;
        }

        public int hashCode() {
            return this.upCoordinate.hashCode() + (this.downCoordinate.hashCode() * 31);
        }

        public final boolean ready() {
            return (this.downCoordinate.getX() == Integer.MIN_VALUE || this.downCoordinate.getY() == Integer.MIN_VALUE || this.upCoordinate.getX() == Integer.MIN_VALUE || this.upCoordinate.getY() == Integer.MIN_VALUE) ? false : true;
        }

        public final void setDownCoordinate(Coordinate coordinate) {
            k.e(coordinate, "<set-?>");
            this.downCoordinate = coordinate;
        }

        public final void setUpCoordinate(Coordinate coordinate) {
            k.e(coordinate, "<set-?>");
            this.upCoordinate = coordinate;
        }

        public String toString() {
            return "ClickCoordinate(downCoordinate=" + this.downCoordinate + ", upCoordinate=" + this.upCoordinate + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Coordinate {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final int f11006x;
        private final int y;

        public Coordinate(int i2, int i8) {
            this.f11006x = i2;
            this.y = i8;
        }

        public static /* synthetic */ Coordinate copy$default(Coordinate coordinate, int i2, int i8, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                i2 = coordinate.f11006x;
            }
            if ((i9 & 2) != 0) {
                i8 = coordinate.y;
            }
            return coordinate.copy(i2, i8);
        }

        public final int component1() {
            return this.f11006x;
        }

        public final int component2() {
            return this.y;
        }

        public final Coordinate copy(int i2, int i8) {
            return new Coordinate(i2, i8);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Coordinate)) {
                return false;
            }
            Coordinate coordinate = (Coordinate) obj;
            return this.f11006x == coordinate.f11006x && this.y == coordinate.y;
        }

        public final int getX() {
            return this.f11006x;
        }

        public final int getY() {
            return this.y;
        }

        public int hashCode() {
            return (this.f11006x * 31) + this.y;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Coordinate(x=");
            sb.append(this.f11006x);
            sb.append(", y=");
            return a0.c(sb, this.y, ')');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DeviceScreenInfo {
        private final Context context;
        private final DisplayMetrics dm;

        public DeviceScreenInfo(Context context) {
            k.e(context, "context");
            this.context = context;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.dm = displayMetrics;
            Object systemService = context.getSystemService("window");
            k.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        }

        public static /* synthetic */ DeviceScreenInfo copy$default(DeviceScreenInfo deviceScreenInfo, Context context, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                context = deviceScreenInfo.context;
            }
            return deviceScreenInfo.copy(context);
        }

        public final Context component1() {
            return this.context;
        }

        public final DeviceScreenInfo copy(Context context) {
            k.e(context, "context");
            return new DeviceScreenInfo(context);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeviceScreenInfo) && k.a(this.context, ((DeviceScreenInfo) obj).context);
        }

        public final Context getContext() {
            return this.context;
        }

        public final int getDeviceHeight() {
            return this.dm.heightPixels;
        }

        public final int getDeviceWidth() {
            return this.dm.widthPixels;
        }

        public int hashCode() {
            return this.context.hashCode();
        }

        public String toString() {
            return "DeviceScreenInfo(context=" + this.context + ')';
        }
    }

    public ClickCoordinateTracker(Context context, AdPayload advertisement) {
        k.e(context, "context");
        k.e(advertisement, "advertisement");
        this.context = context;
        this.advertisement = advertisement;
        this.currentClick = new ClickCoordinate(new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE), new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    private final int getDeviceHeight() {
        return new DeviceScreenInfo(this.context).getDeviceHeight();
    }

    private final int getDeviceWidth() {
        return new DeviceScreenInfo(this.context).getDeviceWidth();
    }

    private final int getRequestedHeight() {
        int iAdHeight = this.advertisement.adHeight();
        return iAdHeight == 0 ? getDeviceHeight() : ViewUtility.INSTANCE.dpToPixels(this.context, iAdHeight);
    }

    private final int getRequestedWidth() {
        int iAdWidth = this.advertisement.adWidth();
        return iAdWidth == 0 ? getDeviceWidth() : ViewUtility.INSTANCE.dpToPixels(this.context, iAdWidth);
    }

    private final void sendClickCoordinates() {
        List<String> tpatUrls$default = AdPayload.getTpatUrls$default(this.advertisement, AdPayload.TPAT_CLICK_COORDINATES_URLS, null, null, 6, null);
        if (tpatUrls$default == null || tpatUrls$default.isEmpty()) {
            new TpatError(Sdk.SDKError.Reason.EMPTY_TPAT_ERROR, "Empty urls for tpat: video.clickCoordinates").setLogEntry$vungle_ads_release(this.advertisement.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
            return;
        }
        int requestedWidth = getRequestedWidth();
        int requestedHeight = getRequestedHeight();
        int requestedWidth2 = getRequestedWidth();
        int requestedHeight2 = getRequestedHeight();
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        q5.f fVarB = b.B(g.f13494a, new ClickCoordinateTracker$sendClickCoordinates$$inlined$inject$1(this.context));
        for (String input : tpatUrls$default) {
            String MACRO_REQ_WIDTH2 = MACRO_REQ_WIDTH;
            k.d(MACRO_REQ_WIDTH2, "MACRO_REQ_WIDTH");
            Pattern patternCompile = Pattern.compile(MACRO_REQ_WIDTH2);
            k.d(patternCompile, "compile(...)");
            String replacement = String.valueOf(requestedWidth);
            k.e(input, "input");
            k.e(replacement, "replacement");
            String strReplaceAll = patternCompile.matcher(input).replaceAll(replacement);
            k.d(strReplaceAll, "replaceAll(...)");
            String MACRO_REQ_HEIGHT2 = MACRO_REQ_HEIGHT;
            k.d(MACRO_REQ_HEIGHT2, "MACRO_REQ_HEIGHT");
            Pattern patternCompile2 = Pattern.compile(MACRO_REQ_HEIGHT2);
            k.d(patternCompile2, "compile(...)");
            String replacement2 = String.valueOf(requestedHeight);
            k.e(replacement2, "replacement");
            String strReplaceAll2 = patternCompile2.matcher(strReplaceAll).replaceAll(replacement2);
            k.d(strReplaceAll2, "replaceAll(...)");
            String MACRO_WIDTH2 = MACRO_WIDTH;
            k.d(MACRO_WIDTH2, "MACRO_WIDTH");
            Pattern patternCompile3 = Pattern.compile(MACRO_WIDTH2);
            k.d(patternCompile3, "compile(...)");
            String replacement3 = String.valueOf(requestedWidth2);
            k.e(replacement3, "replacement");
            String strReplaceAll3 = patternCompile3.matcher(strReplaceAll2).replaceAll(replacement3);
            k.d(strReplaceAll3, "replaceAll(...)");
            String MACRO_HEIGHT2 = MACRO_HEIGHT;
            k.d(MACRO_HEIGHT2, "MACRO_HEIGHT");
            Pattern patternCompile4 = Pattern.compile(MACRO_HEIGHT2);
            k.d(patternCompile4, "compile(...)");
            String replacement4 = String.valueOf(requestedHeight2);
            k.e(replacement4, "replacement");
            String strReplaceAll4 = patternCompile4.matcher(strReplaceAll3).replaceAll(replacement4);
            k.d(strReplaceAll4, "replaceAll(...)");
            String MACRO_DOWN_X2 = MACRO_DOWN_X;
            k.d(MACRO_DOWN_X2, "MACRO_DOWN_X");
            Pattern patternCompile5 = Pattern.compile(MACRO_DOWN_X2);
            k.d(patternCompile5, "compile(...)");
            String replacement5 = String.valueOf(this.currentClick.getDownCoordinate().getX());
            k.e(replacement5, "replacement");
            String strReplaceAll5 = patternCompile5.matcher(strReplaceAll4).replaceAll(replacement5);
            k.d(strReplaceAll5, "replaceAll(...)");
            String MACRO_DOWN_Y2 = MACRO_DOWN_Y;
            k.d(MACRO_DOWN_Y2, "MACRO_DOWN_Y");
            Pattern patternCompile6 = Pattern.compile(MACRO_DOWN_Y2);
            k.d(patternCompile6, "compile(...)");
            String replacement6 = String.valueOf(this.currentClick.getDownCoordinate().getY());
            k.e(replacement6, "replacement");
            String strReplaceAll6 = patternCompile6.matcher(strReplaceAll5).replaceAll(replacement6);
            k.d(strReplaceAll6, "replaceAll(...)");
            String MACRO_UP_X2 = MACRO_UP_X;
            k.d(MACRO_UP_X2, "MACRO_UP_X");
            Pattern patternCompile7 = Pattern.compile(MACRO_UP_X2);
            k.d(patternCompile7, "compile(...)");
            String replacement7 = String.valueOf(this.currentClick.getUpCoordinate().getX());
            k.e(replacement7, "replacement");
            String strReplaceAll7 = patternCompile7.matcher(strReplaceAll6).replaceAll(replacement7);
            k.d(strReplaceAll7, "replaceAll(...)");
            String MACRO_UP_Y2 = MACRO_UP_Y;
            k.d(MACRO_UP_Y2, "MACRO_UP_Y");
            Pattern patternCompile8 = Pattern.compile(MACRO_UP_Y2);
            k.d(patternCompile8, "compile(...)");
            String replacement8 = String.valueOf(this.currentClick.getUpCoordinate().getY());
            k.e(replacement8, "replacement");
            String strReplaceAll8 = patternCompile8.matcher(strReplaceAll7).replaceAll(replacement8);
            k.d(strReplaceAll8, "replaceAll(...)");
            TpatSender.sendTpat$default(m3292sendClickCoordinates$lambda0(fVarB), new TpatRequest.Builder(strReplaceAll8).tpatKey(Constants.COORDINATE).build(), false, 2, null);
        }
    }

    /* JADX INFO: renamed from: sendClickCoordinates$lambda-0, reason: not valid java name */
    private static final TpatSender m3292sendClickCoordinates$lambda0(q5.f fVar) {
        return (TpatSender) fVar.getValue();
    }

    public final ClickCoordinate getCurrentClick$vungle_ads_release() {
        return this.currentClick;
    }

    public final void trackCoordinate(MotionEvent event) {
        k.e(event, "event");
        if (this.advertisement.isClickCoordinatesTrackingEnabled()) {
            int action = event.getAction();
            if (action == 0) {
                this.currentClick.setDownCoordinate(new Coordinate((int) event.getX(), (int) event.getY()));
            } else {
                if (action != 1) {
                    return;
                }
                this.currentClick.setUpCoordinate(new Coordinate((int) event.getX(), (int) event.getY()));
                if (this.currentClick.ready()) {
                    sendClickCoordinates();
                }
            }
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getCurrentClick$vungle_ads_release$annotations() {
    }
}
