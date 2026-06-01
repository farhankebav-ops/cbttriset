package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ironsource.adqualitysdk.sdk.i.az;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class hk extends WebChromeClient implements az.e, ci {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2331 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f2332;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f2333;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2334;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private WebChromeClient f2335;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private WebChromeClient f2336;

    static {
        char[] cArr = new char[1100];
        a0.o("\u0000WK\u001f\u0096\u0096â--\u0080y\u0010Ä³\u0010;[µ§\tò¨>W\u0089ÝÕ\\ Ølb·Å\u0003yNû\u009a|åé1v|\u0013Ç\u0084\u0083»Èö\u0015xaÿ®dú¼GK\u0093ÆØ\u000e$Ùqn½¢\n\nV¥£!ï¬4;\u0080\u008aÍ\u000f\u0019\u0082fV²\u0093ÿìDX\u0090üÝ{)ývRÂÃ\u000f_[Á {ìÖ9%\u0085¤Ò7\u001e³k8\u0016¥]è\u0080fôá;zo¢ÒU\u0006ØM\u0010±Çäp(¼\u009f\u0014Ã»6?z²¡%\u0015\u0094X\u0011\u008c\u009cóH'\u008djòÑD\u0005õHi¼áãWWÎ\u009aWÎÈ5ryÉ¬.\u0010¸G+÷\u0087¼ÊaD\u0015ÃÚX\u008e\u00803wçú¬2På\u0005RÉ\u009e~6\"\u0099×\u001d\u009b\u0090@\u0007ô¶¹3m¾\u0012jÆ¯\u008bÐ0fä×©K]Ã\u0002u¶ì{u/êÔM\u0098áM\u0017ñ\u0098èò£¿~1\n¶Å-\u0091õ,\u0002ø\u008f³GO\u0090\u001a'ÖëaC=ìÈh\u0084å_rëÃ¦FrË\r\u001fÙÚ\u0094¥/\u0013û¢¶>B¶\u001d\u0000©\u0099d\u00000\u009fË%\u0087\u0098Rxîà¹quÖ\u0000vÜÄ\u0097O#òþO\u008aß\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç¥\u0013\u0018^\u0085ª\u0013õ\u009dA-\u008c¡Ø8#©o-ºì\u0006]QË\u009d_Gµ\føÑv¥ñjj>²\u0083EWÈ\u001c\u0000à×µ`y¬Î\u0004\u0092«g/+¢ð5D\u0084\t\u0001Ý\u008c¢Xv\u009d;â\u0080NTé\u0019~íñ²m\u0006ÝËQ\u009fÈdY(Ýý\u001cA\u00ad\u0016;Ú¯Ë\t\u0080D]Ê)MæÖ²\u000e\u000fùÛt\u0090¼lk9Üõ\u0010B¸\u001e\u0017ë\u0093§\u001e|\u0089È8\u0085½Q0.äú!·^\fùØN\u0095ÃaI>æ\u008aqGÉ\u0013ièä¤hq\u0099Í\u000f\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç¤\u0013\u0015^\u009bª\u0011õ»A+\u008c¦Ø\n#©o#ºÏ\u0006G.Áe\u008c¸\u0002Ì\u0085\u0003\u001eWÆê1>¼ut\u0089£Ü\u0014\u0010Ø§pûß\u000e[BÖ\u0099A-ð`u´øË,\u001féR\u0096é1=\u0098p\u0001\u0084\u0093Û?o\u008b¢?ö¦\r&A«\u0094I\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç¼\u0013\u0003^«ª\bõ»A*\u008c¦øX³\u0015n\u009b\u001a\u001cÕ\u0087\u0081_<¨è%£í_:\n\u008dÆAqé-FØÂ\u0094OOØûi¶ìba\u001dµÉp\u0084\u000f?¡ë\u001e¦´R\u0016\r\u00ad¹#t¦ #Û¶\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç¼\u0013\u0003^ºª\u0016õ±A5\u008c¢Ø8\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç¼\u0013\u0003^¨ª\u0001õ¸A7\u008c Ø)#\u0093o.ºÖ\u0006[QÏ\u009dL\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç³\u0013\b^\u0089ª\u0001õ»A<\u008c·Ø(#\u0082o!ºÎ\u0006UQÌ\u009dIèÑ4y\u007fÇËe\u0016åbp\u00ad\u001f\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç±\u0013\u0015^\u0085ª\bõ±A;\u008c³Ø8#¯o/ºÔ\u0006dQË\u009dZèÏ4u\u007fåËc\u0016ãbk\u00ad\u0010ø\u008bD!\u008f\u0084Û\t&\u0097r\n½¦\t!T¥ 2ëÈáèª¥w+\u0003¬Ì7\u0098ï%\u0018ñ\u0095º]F\u008a\u0013=ßñhY4öÁr\u008dÿVhâÙ¯\\{Ñ\u0004\u0005ÐÀ\u009d¿&\u001cò¸¿(K¥\u0014\u001c \u0096m\u001e9\u0095Â\u0002\u008e\u0082[yçÉ°f|÷\tbÕØ\u009eH*Î÷N\u0083ÆL½\u0019&¥\u0097n(:¯Ç(\u0093§\\\u000bè\u008cµ\bA\u009f\ne\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç¦\u0013\u0015^\u0098ª\tõ·A+\u008c¡Ø%#©o.ºè\u0006QQß\u009d]èÇ4o\u007fâ\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§)ò¥>R\u0089ÔÕ[ ÂlA·\u0080\u0003uNæ\u009agåï1k|\u0012ÇÖ\u0013\u001f^\u0084ª4õ»A*\u008c¿Ø%#µo3ºÓ\u0006[QÀ\u009dzèÇ4m\u007fãËu\u0016ùbp\u009bRÐ\u001f\r\u0091y\u0016¶\u008dâU_¢\u008b/Àç<0i\u0087¥K\u0012ãNL»È÷E,Ò\u0098cÕæ\u0001k~¿ªzç\u0005\\±\u0088\u0002Å\u008f1\u001en Ú<\u0017¶C2¸¾ô9!ÿ\u009dFÊÈ\u0006JsÐ¯xäõPD\u008düù}6\nc\u008aß\t\u0014\u009e@\u0015©~â3?½K:\u0084¡Ðym\u008e¹\u0003òË\u000e\u0012[\u009e\u0097i ï|`\u0089ùÅz\u001e»ªNçÝ3\\LÔ\u0098PÕ)níº$÷¿\u0003\u000f\\\u0080è\u0011%\u0084q\u001e\u008a\u008eÆ\b\u0013è¯`øû4AAü\u009dVÖØbN¿ÂËK\u0004\u0006Q¢í'&´r8\u008f·Û\u0004\u0014\u008b\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç¼\u0013\u0003^¾ª\rõ³A=\u008c½Ø9#²\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Çµ\u0013\u001f^\u0084ª\u0017õ±A4\u008c·Ø\u0001#£o3ºÉ\u0006UQÉ\u009dM×\"\u009coAá5fúý®%\u0013ÒÇ_\u008c\u0097p@%÷é;^\u0093\u0002<÷¸»5`¢Ô\u0013\u0099\u0096M\u001b2Ïæ\u0002«~\u0010åÄS\u0089è}e\"Ø\u0096J[Ù\u000f_ô÷¸Nm¹Ñ6\u0086¦J\u001f?ªã\b¨\u0085\u001c\u0012Á\u009f ,ka¶ïÂh\róY+äÜ0Q{\u0099\u0087NÒù\u001e5©\u009dõ2\u0000¶L;\u0097¬#\u001dn\u0098º\u0015ÅÁ\u0011\f\\pçë3O~ê\u008aiÕÒa^¬÷øJ\u0003ÎOM\u009aº&3q ½\u0011È¹\u0014\u001a_\u0098ë\u000b6\u0086B\u001e\u008ddØÇdr¯àûx¢\u0099éÔ4Z@Ý\u008fFÛ\u009efi²äù,\u0005ûPL\u009c\u0080+(w\u0087\u0082\u0003Î\u008e\u0015\u0019¡¨ì-8 Gt\u0093¹ÞÅe^±úü_\bËWkãð.kzô\u0081RÍõ\u0018\u0015¤\u009có\u001d?\u0086J\u0007\u0000EK\b\u0096\u0086â\u0001-\u009ayBÄµ\u00108[ð§'ò\u0090>\\\u0089ôÕ[ ßlR·Å\u0003tNñ\u009a|å¨1m|\u0012Ç¥\u0013\u0018^\u0085ª\u0013õ\u0098A1\u008c¾Ø)#\u0085o(ºÕ\u0006[QÝ\u009dMèÐOÛ\u0004£Ù<\u00ad\u0085b&6¿\u008b\u0010_\u009a\u0014\tè\u0092½/qçÆf\u009aÍox#èøsLË\u0001MÕñªX~×3¥\u0088$\\¸\u0000gK\u001f\u0096\u0080â:-\u008ay5Ä¹\u00104[\u0093§\"ò¶>Q\u0089ÕÕW ïlJ·É\u0003\u007fNú\u009az", "ISO-8859-1", cArr, 0, 1100);
        f2332 = cArr;
        f2333 = -3465604994163651718L;
    }

    public hk(WebChromeClient webChromeClient, WebChromeClient webChromeClient2) {
        this.f2336 = webChromeClient;
        this.f2335 = webChromeClient2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private WebChromeClient m2300() {
        int i2 = (f2334 + 21) % 128;
        f2331 = i2;
        WebChromeClient webChromeClient = this.f2336;
        f2334 = (i2 + 31) % 128;
        return webChromeClient;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private Object m2301() {
        int i2 = f2334 + 33;
        int i8 = i2 % 128;
        f2331 = i8;
        if (i2 % 2 == 0) {
            throw null;
        }
        WebChromeClient webChromeClient = this.f2335;
        f2334 = (i8 + 75) % 128;
        return webChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        f2334 = (f2331 + 71) % 128;
        try {
            this.f2335.getDefaultVideoPoster();
        } catch (Throwable th) {
            kd.m2919(m2302((char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), 23 - Process.getGidForName(""), ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0)).intern(), m2302((char) (ExpandableListView.getPackedPositionType(0L) + 55143), 42 - Color.green(0), 890 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            return super.getDefaultVideoPoster();
        }
        f2334 = (f2331 + 39) % 128;
        return webChromeClient.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        try {
            this.f2335.getVideoLoadingProgressView();
        } catch (Throwable th) {
            kd.m2919(m2302((char) Color.green(0), 24 - KeyEvent.keyCodeFromString(""), ViewConfiguration.getKeyRepeatDelay() >> 16).intern(), m2302((char) (Color.blue(0) + 8297), 48 - (ViewConfiguration.getPressedStateDuration() >> 16), 931 - View.MeasureSpec.getSize(0)).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            return super.getVideoLoadingProgressView();
        }
        f2334 = (f2331 + 55) % 128;
        View videoLoadingProgressView = webChromeClient.getVideoLoadingProgressView();
        f2334 = (f2331 + 29) % 128;
        return videoLoadingProgressView;
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        int i2 = f2331 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f2334 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                this.f2335.getVisitedHistory(valueCallback);
                int i8 = 73 / 0;
            } else {
                this.f2335.getVisitedHistory(valueCallback);
            }
        } catch (Throwable th) {
            kd.m2919(m2302((char) ((Process.getThreadPriority(0) + 20) >> 6), 24 - (ViewConfiguration.getTapTimeout() >> 16), (-1) - TextUtils.indexOf((CharSequence) "", '0')).intern(), m2302((char) (41692 - Gravity.getAbsoluteGravity(0, 0)), 38 - (ViewConfiguration.getTouchSlop() >> 8), (ViewConfiguration.getTouchSlop() >> 8) + 979).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient != null) {
            webChromeClient.getVisitedHistory(valueCallback);
            return;
        }
        super.getVisitedHistory(valueCallback);
        int i9 = f2331 + 39;
        f2334 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        f2334 = (f2331 + 71) % 128;
        try {
            this.f2335.onCloseWindow(webView);
        } catch (Throwable th) {
            kd.m2919(m2302((char) (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getPressedStateDuration() >> 16) + 24, ExpandableListView.getPackedPositionType(0L)).intern(), m2302((char) (((byte) KeyEvent.getModifierMetaStateMask()) + 11909), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 33, 320 - (ViewConfiguration.getScrollDefaultDelay() >> 16)).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            super.onCloseWindow(webView);
            return;
        }
        webChromeClient.onCloseWindow(webView);
        int i2 = f2331 + 55;
        f2334 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 20 / 0;
        }
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i2, String str2) {
        f2334 = (f2331 + 31) % 128;
        try {
            this.f2335.onConsoleMessage(str, i2, str2);
        } catch (Throwable th) {
            kd.m2919(m2302((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getEdgeSlop() >> 16) + 24, TextUtils.lastIndexOf("", '0', 0) + 1).intern(), m2302((char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 37 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 853).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            super.onConsoleMessage(str, i2, str2);
            return;
        }
        int i8 = f2331 + 83;
        f2334 = i8 % 128;
        if (i8 % 2 == 0) {
            webChromeClient.onConsoleMessage(str, i2, str2);
        } else {
            webChromeClient.onConsoleMessage(str, i2, str2);
            throw null;
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z2, boolean z7, Message message) {
        f2331 = (f2334 + 111) % 128;
        try {
            this.f2335.onCreateWindow(webView, z2, z7, message);
        } catch (Throwable th) {
            kd.m2919(m2302((char) (Process.getGidForName("") + 1), 24 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), View.resolveSize(0, 0)).intern(), m2302((char) (ImageFormat.getBitsPerPixel(0) + 52045), 35 - Drawable.resolveOpacity(0, 0), 249 - TextUtils.indexOf((CharSequence) "", '0')).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            return super.onCreateWindow(webView, z2, z7, message);
        }
        f2334 = (f2331 + 77) % 128;
        boolean zOnCreateWindow = webChromeClient.onCreateWindow(webView, z2, z7, message);
        int i2 = f2334 + 33;
        f2331 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 30 / 0;
        }
        return zOnCreateWindow;
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onExceededDatabaseQuota(String str, String str2, long j, long j3, long j8, WebStorage.QuotaUpdater quotaUpdater) {
        try {
            this.f2335.onExceededDatabaseQuota(str, str2, j, j3, j8, quotaUpdater);
            f2334 = (f2331 + 45) % 128;
        } catch (Throwable th) {
            kd.m2919(m2302((char) (KeyEvent.getMaxKeyCode() >> 16), 24 - View.getDefaultSize(0, 0), ViewConfiguration.getPressedStateDuration() >> 16).intern(), m2302((char) (ViewConfiguration.getTapTimeout() >> 16), 43 - MotionEvent.axisFromString(""), ImageFormat.getBitsPerPixel(0) + 485).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient != null) {
            webChromeClient.onExceededDatabaseQuota(str, str2, j, j3, j8, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j3, j8, quotaUpdater);
            f2331 = (f2334 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        try {
            this.f2335.onGeolocationPermissionsHidePrompt();
        } catch (Throwable th) {
            kd.m2919(m2302((char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), 24 - (ViewConfiguration.getScrollBarSize() >> 8), 1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern(), m2302((char) (Color.red(0) + 57773), Process.getGidForName("") + 56, (ViewConfiguration.getEdgeSlop() >> 16) + 583).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            super.onGeolocationPermissionsHidePrompt();
            f2334 = (f2331 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
            return;
        }
        int i2 = f2331 + 111;
        f2334 = i2 % 128;
        if (i2 % 2 == 0) {
            webChromeClient.onGeolocationPermissionsHidePrompt();
        } else {
            webChromeClient.onGeolocationPermissionsHidePrompt();
            int i8 = 86 / 0;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        f2334 = (f2331 + 23) % 128;
        try {
            this.f2335.onGeolocationPermissionsShowPrompt(str, callback);
            f2331 = (f2334 + 35) % 128;
        } catch (Throwable th) {
            kd.m2919(m2302((char) (ViewConfiguration.getWindowTouchSlop() >> 8), (ViewConfiguration.getPressedStateDuration() >> 16) + 24, ExpandableListView.getPackedPositionGroup(0L)).intern(), m2302((char) (TextUtils.lastIndexOf("", '0') + 1), 55 - ExpandableListView.getPackedPositionGroup(0L), 528 - (Process.myTid() >> 22)).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            f2331 = (f2334 + 97) % 128;
            webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        int i2 = f2334 + 69;
        f2331 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2302((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 24 - (Process.myTid() >> 22), ViewConfiguration.getLongPressTimeout() >> 16).intern(), m2302((char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18416), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 36, 213 - TextUtils.getCapsMode("", 0, 0)).intern(), th, false);
        }
        if (i2 % 2 == 0) {
            this.f2335.onHideCustomView();
            throw null;
        }
        this.f2335.onHideCustomView();
        f2334 = (f2331 + 35) % 128;
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            super.onHideCustomView();
            return;
        }
        int i8 = f2334 + 65;
        f2331 = i8 % 128;
        if (i8 % 2 != 0) {
            webChromeClient.onHideCustomView();
        } else {
            webChromeClient.onHideCustomView();
            throw null;
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        int i2 = f2334 + 5;
        f2331 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2302((char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), Process.getGidForName("") + 25, View.MeasureSpec.getMode(0)).intern(), m2302((char) ((-1) - Process.getGidForName("")), 30 - KeyEvent.getDeadChar(0, 0), 354 - ((Process.getThreadPriority(0) + 20) >> 6)).intern(), th, false);
        }
        if (i2 % 2 == 0) {
            this.f2335.onJsAlert(webView, str, str2, jsResult);
            throw null;
        }
        this.f2335.onJsAlert(webView, str, str2, jsResult);
        f2331 = (f2334 + 9) % 128;
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient != null) {
            return webChromeClient.onJsAlert(webView, str, str2, jsResult);
        }
        boolean zOnJsAlert = super.onJsAlert(webView, str, str2, jsResult);
        int i8 = f2331 + 107;
        f2334 = i8 % 128;
        if (i8 % 2 == 0) {
            return zOnJsAlert;
        }
        throw null;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        try {
            this.f2335.onJsBeforeUnload(webView, str, str2, jsResult);
        } catch (Throwable th) {
            kd.m2919(m2302((char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), ImageFormat.getBitsPerPixel(0) + 25, ImageFormat.getBitsPerPixel(0) + 1).intern(), m2302((char) View.combineMeasuredStates(0, 0), 37 - Color.alpha(0), 447 - (Process.myTid() >> 22)).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient != null) {
            boolean zOnJsBeforeUnload = webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult);
            f2334 = (f2331 + 83) % 128;
            return zOnJsBeforeUnload;
        }
        boolean zOnJsBeforeUnload2 = super.onJsBeforeUnload(webView, str, str2, jsResult);
        int i2 = f2334 + 93;
        f2331 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 46 / 0;
        }
        return zOnJsBeforeUnload2;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        try {
            this.f2335.onJsConfirm(webView, str, str2, jsResult);
        } catch (Throwable th) {
            kd.m2919(m2302((char) (ViewConfiguration.getScrollDefaultDelay() >> 16), (Process.myPid() >> 22) + 24, ViewConfiguration.getDoubleTapTimeout() >> 16).intern(), m2302((char) (63517 - TextUtils.getCapsMode("", 0, 0)), 32 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 384 - TextUtils.getOffsetAfter("", 0)).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        f2331 = (f2334 + 23) % 128;
        boolean zOnJsConfirm = webChromeClient.onJsConfirm(webView, str, str2, jsResult);
        f2331 = (f2334 + 109) % 128;
        return zOnJsConfirm;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        f2334 = (f2331 + 69) % 128;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f2335.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            webView = webView;
            str = str;
            str2 = str2;
            str3 = str3;
            jsPromptResult = jsPromptResult;
        } catch (Throwable th2) {
            th = th2;
            webView = webView;
            str = str;
            str2 = str2;
            str3 = str3;
            jsPromptResult = jsPromptResult;
            kd.m2919(m2302((char) Color.blue(0), 24 - TextUtils.getCapsMode("", 0, 0), MotionEvent.axisFromString("") + 1).intern(), m2302((char) Color.argb(0, 0, 0, 0), 31 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.lastIndexOf("", '0', 0) + TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        f2334 = (f2331 + 49) % 128;
        return webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public boolean onJsTimeout() {
        try {
            this.f2335.onJsTimeout();
        } catch (Throwable th) {
            kd.m2919(m2302((char) ('0' - AndroidCharacter.getMirror('0')), 24 - View.MeasureSpec.makeMeasureSpec(0, 0), KeyEvent.getDeadChar(0, 0)).intern(), m2302((char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), View.MeasureSpec.getSize(0) + 32, 821 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            return super.onJsTimeout();
        }
        f2334 = (f2331 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        boolean zOnJsTimeout = webChromeClient.onJsTimeout();
        f2334 = (f2331 + 59) % 128;
        return zOnJsTimeout;
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        try {
            this.f2335.onPermissionRequest(permissionRequest);
            f2331 = (f2334 + 19) % 128;
        } catch (Throwable th) {
            kd.m2919(m2302((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), (ViewConfiguration.getScrollBarSize() >> 8) + 24, TextUtils.getOffsetBefore("", 0)).intern(), m2302((char) ((-1) - TextUtils.lastIndexOf("", '0')), Color.red(0) + 40, 638 - View.combineMeasuredStates(0, 0)).intern(), th, false);
        }
        try {
            WebChromeClient webChromeClient = this.f2336;
            if (webChromeClient == null) {
                super.onPermissionRequest(permissionRequest);
            } else {
                f2331 = (f2334 + 67) % 128;
                webChromeClient.onPermissionRequest(permissionRequest);
            }
        } catch (Throwable th2) {
            kd.m2919(m2302((char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 24 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), AndroidCharacter.getMirror('0') - '0').intern(), m2302((char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), 43 - TextUtils.getOffsetAfter("", 0), KeyEvent.getDeadChar(0, 0) + 678).intern(), th2, false);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        try {
            this.f2335.onPermissionRequestCanceled(permissionRequest);
        } catch (Throwable th) {
            kd.m2919(m2302((char) KeyEvent.keyCodeFromString(""), 24 - Color.argb(0, 0, 0, 0), TextUtils.getCapsMode("", 0, 0)).intern(), m2302((char) (39704 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 48 - ((Process.getThreadPriority(0) + 20) >> 6), 720 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern(), th, false);
        }
        try {
            WebChromeClient webChromeClient = this.f2336;
            if (webChromeClient == null) {
                super.onPermissionRequestCanceled(permissionRequest);
                return;
            }
            f2334 = (f2331 + 51) % 128;
            f2331 = (f2334 + 65) % 128;
            webChromeClient.onPermissionRequestCanceled(permissionRequest);
        } catch (Throwable th2) {
            kd.m2919(m2302((char) View.resolveSizeAndState(0, 0, 0), 24 - Color.green(0), ViewConfiguration.getTapTimeout() >> 16).intern(), m2302((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 43322), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 50, 770 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern(), th2, false);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        try {
            this.f2335.onProgressChanged(webView, i2);
        } catch (Throwable th) {
            kd.m2919(m2302((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 25 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), View.MeasureSpec.getSize(0)).intern(), m2302((char) (Color.rgb(0, 0, 0) + 16811006), TextUtils.lastIndexOf("", '0', 0) + 39, (ViewConfiguration.getEdgeSlop() >> 16) + 24).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            super.onProgressChanged(webView, i2);
            return;
        }
        f2331 = (f2334 + 115) % 128;
        webChromeClient.onProgressChanged(webView, i2);
        int i8 = f2331 + 109;
        f2334 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 48 / 0;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        int i2 = f2331 + 9;
        f2334 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2302((char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 24, ViewConfiguration.getKeyRepeatTimeout() >> 16).intern(), m2302((char) (MotionEvent.axisFromString("") + 63427), (Process.myPid() >> 22) + 35, 98 - View.MeasureSpec.getMode(0)).intern(), th, false);
        }
        if (i2 % 2 != 0) {
            this.f2335.onReceivedIcon(webView, bitmap);
            throw null;
        }
        this.f2335.onReceivedIcon(webView, bitmap);
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient != null) {
            webChromeClient.onReceivedIcon(webView, bitmap);
            return;
        }
        super.onReceivedIcon(webView, bitmap);
        int i8 = f2334 + 107;
        f2331 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        int i2 = f2331 + 99;
        f2334 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                this.f2335.onReceivedTitle(webView, str);
                int i8 = 56 / 0;
            } else {
                this.f2335.onReceivedTitle(webView, str);
            }
        } catch (Throwable th) {
            kd.m2919(m2302((char) Color.blue(0), TextUtils.getOffsetBefore("", 0) + 24, ViewConfiguration.getMaximumFlingVelocity() >> 16).intern(), m2302((char) ((ViewConfiguration.getJumpTapTimeout() >> 16) + 5856), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 36, 61 - TextUtils.lastIndexOf("", '0', 0)).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            super.onReceivedTitle(webView, str);
        } else {
            f2331 = (f2334 + 11) % 128;
            webChromeClient.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z2) {
        f2334 = (f2331 + 81) % 128;
        try {
            this.f2335.onReceivedTouchIconUrl(webView, str, z2);
        } catch (Throwable th) {
            kd.m2919(m2302((char) (TextUtils.indexOf((CharSequence) "", '0') + 1), 24 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1).intern(), m2302((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 59574), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 42, 132 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient != null) {
            webChromeClient.onReceivedTouchIconUrl(webView, str, z2);
            f2334 = (f2331 + 71) % 128;
            return;
        }
        super.onReceivedTouchIconUrl(webView, str, z2);
        int i2 = f2331 + 41;
        f2334 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        try {
            this.f2335.onRequestFocus(webView);
            f2334 = (f2331 + 95) % 128;
        } catch (Throwable th) {
            kd.m2919(m2302((char) (ViewConfiguration.getTouchSlop() >> 8), KeyEvent.keyCodeFromString("") + 24, 1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern(), m2302((char) Gravity.getAbsoluteGravity(0, 0), 34 - MotionEvent.axisFromString(""), 285 - TextUtils.getTrimmedLength("")).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            super.onRequestFocus(webView);
            return;
        }
        int i2 = f2334 + 33;
        f2331 = i2 % 128;
        if (i2 % 2 != 0) {
            webChromeClient.onRequestFocus(webView);
        } else {
            webChromeClient.onRequestFocus(webView);
            int i8 = 58 / 0;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        int i2 = f2334 + 77;
        f2331 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                this.f2335.onShowCustomView(view, customViewCallback);
                int i8 = 81 / 0;
            } else {
                this.f2335.onShowCustomView(view, customViewCallback);
            }
        } catch (Throwable th) {
            kd.m2919(m2302((char) TextUtils.getCapsMode("", 0, 0), 23 - TextUtils.lastIndexOf("", '0'), ViewConfiguration.getWindowTouchSlop() >> 8).intern(), m2302((char) View.combineMeasuredStates(0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 38, Color.red(0) + 176).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            super.onShowCustomView(view, customViewCallback);
            return;
        }
        webChromeClient.onShowCustomView(view, customViewCallback);
        int i9 = f2331 + 19;
        f2334 = i9 % 128;
        if (i9 % 2 != 0) {
            int i10 = 23 / 0;
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        f2331 = (f2334 + 51) % 128;
        try {
            this.f2335.onShowFileChooser(webView, valueCallback, fileChooserParams);
        } catch (Throwable th) {
            kd.m2919(m2302((char) TextUtils.indexOf("", "", 0), TextUtils.lastIndexOf("", '0', 0) + 25, ViewConfiguration.getTouchSlop() >> 8).intern(), m2302((char) (ViewConfiguration.getLongPressTimeout() >> 16), Color.green(0) + 38, TextUtils.getOffsetAfter("", 0) + PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient == null) {
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
        f2331 = (f2334 + 29) % 128;
        return webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ci
    /* JADX INFO: renamed from: ﾒ */
    public final Object mo886(String str, List<Object> list, ch chVar) {
        f2331 = (f2334 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        int iHashCode = str.hashCode();
        if (iHashCode != 1395849045) {
            if (iHashCode == 1442029578 && str.equals(m2302((char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 20412), 24 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), TextUtils.indexOf((CharSequence) "", '0', 0) + IronSourceError.ERROR_DO_RV_LOAD_DURING_SHOW).intern())) {
                f2331 = (f2334 + 95) % 128;
                return m2300();
            }
        } else if (str.equals(m2302((char) Color.red(0), 20 - (ViewConfiguration.getEdgeSlop() >> 16), View.getDefaultSize(0, 0) + 1080).intern())) {
            Object objM2301 = m2301();
            int i2 = f2334 + 87;
            f2331 = i2 % 128;
            if (i2 % 2 != 0) {
                return objM2301;
            }
            throw null;
        }
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2302(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2332[i8 + i9]) ^ (((long) i9) * f2333)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        try {
            this.f2335.onShowCustomView(view, i2, customViewCallback);
            f2331 = (f2334 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        } catch (Throwable th) {
            kd.m2919(m2302((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 24 - (Process.myPid() >> 22), ViewConfiguration.getScrollBarFadeDuration() >> 16).intern(), m2302((char) View.MeasureSpec.getMode(0), 37 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 176 - TextUtils.indexOf("", "", 0, 0)).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient != null) {
            f2334 = (f2331 + 115) % 128;
            webChromeClient.onShowCustomView(view, i2, customViewCallback);
        } else {
            super.onShowCustomView(view, i2, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        f2334 = (f2331 + 89) % 128;
        try {
            this.f2335.onConsoleMessage(consoleMessage);
            f2334 = (f2331 + 99) % 128;
        } catch (Throwable th) {
            kd.m2919(m2302((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 24 - (ViewConfiguration.getTapTimeout() >> 16), TextUtils.indexOf("", "", 0)).intern(), m2302((char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), View.combineMeasuredStates(0, 0) + 37, 852 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern(), th, false);
        }
        WebChromeClient webChromeClient = this.f2336;
        if (webChromeClient != null) {
            int i2 = f2331 + 11;
            f2334 = i2 % 128;
            if (i2 % 2 == 0) {
                return webChromeClient.onConsoleMessage(consoleMessage);
            }
            webChromeClient.onConsoleMessage(consoleMessage);
            throw null;
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
