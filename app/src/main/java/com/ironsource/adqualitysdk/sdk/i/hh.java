package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.http.SslError;
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
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;
import androidx.annotation.RequiresApi;
import com.ironsource.adqualitysdk.sdk.i.az;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class hh extends WebViewClient implements az.e, ci {

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2306 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f2307;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f2308;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2309;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private WebViewClient f2310;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private WebViewClient f2311;

    static {
        char[] cArr = new char[IronSourceError.ERROR_RV_LOAD_FAIL_WRONG_AUCTION_ID];
        a0.o("\u0000\u001f\u000eÒ\u001dÔ,ã;ÝJÖYÅhòwÜ\u0086Ö\u0095Û¤Ó³ÈÂÿÑßàÚï×þÕ\rÇ\u001cÑ+Ë:Ñ¶Õ¸\u001d«\u001c\u009a\u0002\u008d\u001eüKï\u0003Þ\u0007ÁH0\n#2\u0012\u0007\u0005(t\ng\u0011V\u0015Y\u0005H\u0011»\u001bª\u000f\u009d\\\u008c\bÿ\u0012î\u0016Ñ\rÀ\u001b3\u0012\":\u0015\u0002\u0004\u0016w\u0000f\u0003i\u0019X+K+º\u0018\u00ad>\u009c'\u008f\u0006þ&á)Ð#Ã/2+%#\u0014k\u00077v3y,hvÕ¬ÛdÈeù{îg\u009f2\u008cz½~¢1Ss@Pqnft\u0017}\u0004r5v:Z+jØnÉaþkïv\u009c#\u008ds²i£aPzA`vigE\u0014}\u0005m\n{;D(^ÙPÎPÿgìA\u009d\\\u0082}³Q ^QXFTwTd\\\u0015\u0010\u001aL\u000bT8K)\rt¾zviwXiOu> -h\u001cl\u0003#òaáYÐlÇC¶a¥z\u0094~\u009bn\u008azyphd_7Nc=y,}\u0013f\u0002pñyàQ×iÆ}µk¤h«r\u009a@\u0089@xsoU^LMm<M#B\u0012H\u0001Dð@çHÖ\u0000Å[´O»ZªA\u0099P\u0088E\u007fCn\u0019T÷Z?I>x o<\u001ei\r!<%#jÒ(Á\u000bð5ç/\u0096&\u0085)´-»\u0001ª1Y5H:\u007f0n-\u001dx\f(32\":Ñ!À;÷2æ\u001e\u0095&\u00846\u008b º\u001f©\u0005X\u000bO\u000b~<m\u001a\u001c\u0007\u0003&2\n!\u0005Ð\u0003Ç\u000fö\u000få\u0007\u0094K\u009b\u0010\u008a\u0018¹\r¨\n_\u001bN\n}\flR\u0000E\u000e\u008d\u001d\u008c,\u0092;\u008eJÛY\u0093h\u0097wØ\u0086\u009a\u0095¢¤\u0097³¸Â\u009aÑ\u0081à\u0085ï\u0095þ\u0081\r\u008b\u001c\u009f+Ì:\u0084I\u0084X¹g\u0089v\u0080\u0085\u0083\u0094¶£\u0090²\u0082Á\u0090Ð\u0095ß\u0085î»æ~è¶û·Ê©Ýµ¬à¿¨\u008e¬\u0091ã`¡s\u0099B¬U\u0083$¡7º\u0006¾\t®\u0018ºë°ú¤Í÷Ü¿¯¿¾\u0082\u0081²\u0090»c¸r\u0098E¶T¶'°6©9³\b\u0081\u001b\u0081C\u008eMF^GoYxE\t\u0010\u001aX+\\4\u0013ÅQÖiç\\ðs\u0081Q\u0092J£N¬^½JN@_Th\u0007yO\nO\u001bn$L5MÆI×|àJñ[\u0082F\u0093_\u009cY\u00adw¾p\u0000E\u000e\u008d\u001d\u008c,\u0092;\u008eJÛY\u0093h\u0097wØ\u0086\u009a\u0095¢¤\u0097³¸Â\u009aÑ\u0081à\u0085ï\u0095þ\u0081\r\u008b\u001c\u009f+Ì:\u0098I\u0082X\u0086g\u009dv\u008b\u0085\u0082\u0094¬£\u008a²\u0097Á\u0087Ð\u0093ß\u0083îºý®\f©\u001b\u008e*¾9«H¬W½f¤u¢ÕrÛºÈ»ù¥î¹\u009fì\u008c¤½ ¢ïS\u00ad@\u0095q f\u008f\u0017\u00ad\u0004¶5²:¢+¶Ø¼É¨þûï³\u009c³\u008d\u008a²°£¿P\u009cA³v½g\u00ad\u0014\u0087\u0005³\n³;\u0081(\u009bÙ\u008fÎ\u0088ÿ\u0098ì\u009e\u0000E\u000e\u008d\u001d\u008c,\u0092;\u008eJÛY\u0093h\u0097wØ\u0086\u009a\u0095¢¤\u0097³¸Â\u009aÑ\u0081à\u0085ï\u0095þ\u0081\r\u008b\u001c\u009f+Ì:\u0084I\u0084X»g\u008dv\u0084\u0085\u0083\u0094\u008c£\u0092²\u0086Á\u0086Ð¤ß\u0092î\u00adý±\f¯\u0000E\u000e\u008d\u001d\u008c,\u0092;\u008eJÛY\u0093h\u0097wØ\u0086\u009a\u0095¢¤\u0097³¸Â\u009aÑ\u0081à\u0085ï\u0095þ\u0081\r\u008b\u001c\u009f+Ì:\u0084I\u0084X¯g\u0087v\u0095\u0085\u008b\u0094·£\u0081²\u0090Á\u0097Ð\u0083ß\u008dî¶ý\u00ad\f®\u001bµ*´9´\u0000E\u000e\u008d\u001d\u008c,\u0092;\u008eJÛY\u0093h\u0097wØ\u0086\u0098\u0095\u0098¤³³\u009bÂ\u0081Ñ\u009fà£ï\u0095þ\u009c\r\u009b\u001c\u008f+\u0081:\u0082I\u0099X\u009ag\u0081v\u0088\u0085\u0088\u0000E\u000e\u008d\u001d\u008c,\u0092;\u008eJÛY\u0093h\u0097wØ\u0086\u009a\u0095¢¤\u0097³¸Â\u009aÑ\u0081à\u0085ï\u0095þ\u0081\r\u008b\u001c\u009f+Ì:\u008fI\u0085X¼g\u0098v\u0083\u0085\u0087\u0094\u0091£\u0081²µÁ\u008bÐ\u0092ß\u0089î«ý»\f¹\u001b\u0094*²9©H\u00adW·f¥u¯\u0000E\u000e\u008d\u001d\u008c,\u0092;\u008eJÛY\u0093h\u0097wØ\u0086\u009a\u0095¢¤\u0097³¸Â\u009aÑ\u0081à\u0085ï\u0095þ\u0081\r\u008b\u001c\u009f+Ì:\u0084I\u0084X»g\u008dv\u0084\u0085\u0083\u0094\u008c£\u0092²\u0086Á\u0086Ð²ß\u0093î³ý\u009b\f¯\u001b®*´9¨\u0000E\u000e\u008d\u001d\u008c,\u0092;\u008eJÛY\u0093h\u0097wØ\u0086\u009a\u0095¢¤\u0097³¸Â\u009aÑ\u0081à\u0085ï\u0095þ\u0081\r\u008b\u001c\u009f+Ì:\u0084I\u0084X»g\u008dv\u0084\u0085\u0083\u0094\u008c£\u0092²\u0086Á\u0086Ð¢ß\u008cî¶ý»\f³\u001b¨*\u00989¿H«W¬f\u0085u³\u0084¤\u0093¡¢¶±¡À¥\u0095¦\u009bn\u0088o¹q®mß8Ìpýtâ;\u0013w\u0000t1z&{WyD\u007fuuz3kc\u0098\u007f\u0089g¾h¯aÜgÍ*òdãj\u0010W\u0001c6d'eThEtJf{Xh~\u0099R\u008eV¿]¬WÝNÂxóQàG\u0011B\u0006e7U$@UGZVK_xY L®\u0084½\u0085\u008c\u009b\u009b\u0087êÒù\u009aÈ\u009e×Ñ&\u00935«\u0004\u009e\u0013±b\u0093q\u0088@\u008cO\u009c^\u0088\u00ad\u0082¼\u0096\u008bÅ\u009a\u008dé\u008dø²Ç\u0084Ö\u008d%\u008a4\u0085\u0003\u009b\u0012\u008fa\u008fp \u007f\u009dN¢]§¬\u0095» \u008a¦\u0099»è\u0082÷´Æ¯Õª$¹3®\u0002®>`0¨#©\u0012·\u0005«tþg¶V²Iý¸¿«\u0087\u009a²\u008d\u009dü¿ï¤Þ Ñ°À¤3®\"º\u0015é\u0004½w§f£Y¸H®»§ª\u008f\u009d·\u008c£ÿµî¶á¬Ð\u009eÃ\u009e2³%\u009c\u0014\u0087\u0007ºv\u008ai\u0098X\u009cK\u0087 ´.|=}\fc\u001b\u007fj*ybHfW)¦kµS\u0084f\u0093IâkñpÀtÏdÞp-z<n\u000b=\u001auiuxMGwV~¥v´z\u0083q\u0092~ávðtÿZÎKÝV,i;[\nO\u0019Eh\\\u0000E\u000e\u008d\u001d\u008c,\u0092;\u008eJÛY\u0093h\u0097wØ\u0086\u009a\u0095¢¤\u0097³¸Â\u009aÑ\u0081à\u0085ï\u0095þ\u0081\r\u008b\u001c\u009f+Ì:\u0084I\u0084Xºg\u008bv\u0086\u0085\u008a\u0094\u0080£§²\u008bÁ\u0083Ð\u008fß\u0087îºýºQ×_\u001fL\u001e}\u0000j\u001c\u001bI\b\u00019\u0005&J×\bÄ0õ\u0005â*\u0093\b\u0080\u0013±\u0017¾\u0007¯\u0013\\\u0019M\rz^k\u0016\u0018\u0016\t)6\u001f'\u0016Ô\u0011Å\u001eò\u0000ã\u0014\u0090\u0014\u0081?\u008e\u001d¿*¬%]!J\u001c{,h9\u0019>\u0006/76$0\u0093¨\u009d`\u008ea¿\u007f¨cÙ6Ê~ûzä5\u0015w\u0006O7z UQwBlsh|xml\u009ef\u008fr¸!©iÚiËVô`åi\u0016n\u0007a0\u007f!kRkCDLy}FnC\u009fu\u0088C¹DªXÛFI\u009aGRTSeMrQ\u0003\u0004\u0010L!H>\u0007ÏEÜ}íHúg\u008bE\u0098^©Z¦J·^DTU@b\u0013s[\u0000[\u0011d.R?VÌ]Ý_êIûl\u0088O\u0099Q\u0096\\§e´rEqRDckpk\u0001cÑyß\u0084Ì\u0094ý´ê\u0090\u009b\u0084\u0088\u0094¹\u0097¦\u0083W\u008dD¿u\u008eb\u0088\u0013»\u0000\u00851\u008a>\u0099/²Ü\u009cÍ\u009aú\u0097ë\u009b\u0098\u0080×\u0099ÙdÊtûWì`\u009dR\u008ea¿e PQ`Bms|dI\u0015a\u0006e7j8`)e", "ISO-8859-1", cArr, 0, IronSourceError.ERROR_RV_LOAD_FAIL_WRONG_AUCTION_ID);
        f2307 = cArr;
        f2308 = -5850815110886846721L;
    }

    public hh(WebViewClient webViewClient, WebViewClient webViewClient2) {
        this.f2310 = webViewClient;
        this.f2311 = webViewClient2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private WebViewClient m2289() {
        int i2 = f2306 + 75;
        f2309 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f2310;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean m2291() {
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            return false;
        }
        f2306 = (f2309 + 99) % 128;
        if (webViewClient.getClass().equals(WebViewClient.class)) {
            return false;
        }
        f2306 = (f2309 + 43) % 128;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r10 == false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m2292(android.webkit.WebView r8, java.lang.String r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.hh.m2292(android.webkit.WebView, java.lang.String, boolean):boolean");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private Object m2293() {
        int i2 = f2306 + 23;
        f2309 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f2311;
        }
        throw null;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z2) {
        try {
            this.f2311.doUpdateVisitedHistory(webView, str, z2);
            f2306 = (f2309 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        } catch (Throwable th) {
            kd.m2919(m2290((char) (TextUtils.getOffsetBefore("", 0) + 72), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 22, Color.alpha(0)).intern(), m2290((char) (Process.myTid() >> 22), 43 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 521).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            super.doUpdateVisitedHistory(webView, str, z2);
            int i2 = f2309 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
            f2306 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            return;
        }
        int i8 = f2306 + 65;
        f2309 = i8 % 128;
        if (i8 % 2 == 0) {
            webViewClient.doUpdateVisitedHistory(webView, str, z2);
        } else {
            webViewClient.doUpdateVisitedHistory(webView, str, z2);
            throw null;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        try {
            this.f2311.onFormResubmission(webView, message, message2);
        } catch (Throwable th) {
            kd.m2919(m2290((char) ('x' - AndroidCharacter.getMirror('0')), TextUtils.indexOf("", "") + 22, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1).intern(), m2290((char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 38 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 456 - TextUtils.getCapsMode("", 0, 0)).intern(), th, false);
        }
        try {
            WebViewClient webViewClient = this.f2310;
            if (webViewClient != null) {
                f2306 = (f2309 + 19) % 128;
                webViewClient.onFormResubmission(webView, message, message2);
                return;
            }
            super.onFormResubmission(webView, message, message2);
            int i2 = f2306 + 19;
            f2309 = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
        } catch (Error e) {
            kd.m2919(m2290((char) (MotionEvent.axisFromString("") + 73), TextUtils.lastIndexOf("", '0', 0) + 23, Color.blue(0)).intern(), m2290((char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), 27 - (ViewConfiguration.getTouchSlop() >> 8), 494 - ExpandableListView.getPackedPositionChild(0L)).intern(), e, false);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        f2309 = (f2306 + 83) % 128;
        try {
            this.f2311.onLoadResource(webView, str);
        } catch (Throwable th) {
            kd.m2919(m2290((char) (72 - TextUtils.indexOf("", "", 0)), Color.alpha(0) + 22, View.combineMeasuredStates(0, 0)).intern(), m2290((char) (17355 - View.MeasureSpec.getSize(0)), ImageFormat.getBitsPerPixel(0) + 36, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 304).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            super.onLoadResource(webView, str);
            int i2 = f2306 + 11;
            f2309 = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
            return;
        }
        int i8 = f2309 + 79;
        f2306 = i8 % 128;
        if (i8 % 2 != 0) {
            webViewClient.onLoadResource(webView, str);
        } else {
            webViewClient.onLoadResource(webView, str);
            throw null;
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public void onPageCommitVisible(WebView webView, String str) {
        int i2 = f2306 + 97;
        f2309 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2290((char) (72 - View.resolveSize(0, 0)), (ViewConfiguration.getTapTimeout() >> 16) + 22, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1).intern(), m2290((char) (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 34, Color.green(0) + 234).intern(), th, false);
        }
        if (i2 % 2 != 0) {
            this.f2311.onPageCommitVisible(webView, str);
            throw null;
        }
        this.f2311.onPageCommitVisible(webView, str);
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            super.onPageCommitVisible(webView, str);
        } else {
            webViewClient.onPageCommitVisible(webView, str);
            f2309 = (f2306 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        int i2 = f2309 + 25;
        f2306 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2290((char) ((Process.myTid() >> 22) + 72), View.combineMeasuredStates(0, 0) + 22, TextUtils.lastIndexOf("", '0') + 1).intern(), m2290((char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 58939), 34 - TextUtils.lastIndexOf("", '0', 0, 0), TextUtils.indexOf("", "", 0) + 268).intern(), th, false);
        }
        if (i2 % 2 == 0) {
            this.f2311.onPageFinished(webView, str);
            throw null;
        }
        this.f2311.onPageFinished(webView, str);
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            super.onPageFinished(webView, str);
            return;
        }
        int i8 = f2309 + 27;
        f2306 = i8 % 128;
        if (i8 % 2 != 0) {
            webViewClient.onPageFinished(webView, str);
        } else {
            webViewClient.onPageFinished(webView, str);
            throw null;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        f2309 = (f2306 + 21) % 128;
        try {
            this.f2311.onPageStarted(webView, str, bitmap);
        } catch (Throwable th) {
            kd.m2919(m2290((char) (72 - View.MeasureSpec.getMode(0)), View.MeasureSpec.makeMeasureSpec(0, 0) + 22, View.combineMeasuredStates(0, 0)).intern(), m2290((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), KeyEvent.getDeadChar(0, 0) + 34, (ViewConfiguration.getFadingEdgeLength() >> 16) + 234).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            super.onPageStarted(webView, str, bitmap);
            return;
        }
        f2306 = (f2309 + 33) % 128;
        webViewClient.onPageStarted(webView, str, bitmap);
        int i2 = f2306 + 51;
        f2309 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        int i2 = f2306 + 39;
        f2309 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2290((char) ('x' - AndroidCharacter.getMirror('0')), (ViewConfiguration.getTapTimeout() >> 16) + 22, KeyEvent.getMaxKeyCode() >> 16).intern(), m2290((char) (ViewConfiguration.getEdgeSlop() >> 16), Color.green(0) + 48, View.getDefaultSize(0, 0) + 604).intern(), th, false);
        }
        if (i2 % 2 != 0) {
            this.f2311.onReceivedClientCertRequest(webView, clientCertRequest);
            throw null;
        }
        this.f2311.onReceivedClientCertRequest(webView, clientCertRequest);
        try {
            WebViewClient webViewClient = this.f2310;
            if (webViewClient == null) {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
                return;
            }
            int i8 = f2306 + 31;
            f2309 = i8 % 128;
            if (i8 % 2 == 0) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
                int i9 = 13 / 0;
            }
        } catch (Throwable th2) {
            kd.m2919(m2290((char) (72 - ExpandableListView.getPackedPositionType(0L)), 22 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern(), m2290((char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 38371), TextUtils.lastIndexOf("", '0') + 52, 652 - TextUtils.getOffsetAfter("", 0)).intern(), th2, false);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        f2309 = (f2306 + 109) % 128;
        try {
            this.f2311.onReceivedError(webView, i2, str, str2);
            f2309 = (f2306 + 101) % 128;
        } catch (Throwable th) {
            kd.m2919(m2290((char) (TextUtils.indexOf("", "") + 72), 22 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern(), m2290((char) TextUtils.getOffsetBefore("", 0), Color.alpha(0) + 36, 420 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i2, str, str2);
        } else {
            super.onReceivedError(webView, i2, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        try {
            this.f2311.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            f2309 = (f2306 + 83) % 128;
        } catch (Throwable th) {
            kd.m2919(m2290((char) (72 - View.MeasureSpec.getSize(0)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 22, (-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern(), m2290((char) (40969 - TextUtils.getCapsMode("", 0, 0)), View.combineMeasuredStates(0, 0) + 46, 703 - View.combineMeasuredStates(0, 0)).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            return;
        }
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        int i2 = f2309 + 49;
        f2306 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        int i2 = f2306 + 15;
        f2309 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2290((char) (72 - (Process.myTid() >> 22)), 23 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1).intern(), m2290((char) (TextUtils.lastIndexOf("", '0') + 37870), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 39, 910 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))).intern(), th, false);
        }
        if (i2 % 2 != 0) {
            this.f2311.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            throw null;
        }
        this.f2311.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        WebViewClient webViewClient = this.f2310;
        if (webViewClient != null) {
            f2306 = (f2309 + 15) % 128;
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            f2306 = (f2309 + 25) % 128;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        int i2 = f2309 + 61;
        f2306 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                this.f2311.onReceivedLoginRequest(webView, str, str2, str3);
                int i8 = 35 / 0;
            } else {
                this.f2311.onReceivedLoginRequest(webView, str, str2, str3);
            }
        } catch (Throwable th) {
            kd.m2919(m2290((char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 73), TextUtils.indexOf("", "") + 22, ViewConfiguration.getMinimumFlingVelocity() >> 16).intern(), m2290((char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 20882), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 44, 867 - ExpandableListView.getPackedPositionType(0L)).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            super.onReceivedLoginRequest(webView, str, str2, str3);
            f2306 = (f2309 + 43) % 128;
            return;
        }
        int i9 = f2309 + 23;
        f2306 = i9 % 128;
        if (i9 % 2 != 0) {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            throw null;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        try {
            this.f2311.onReceivedSslError(webView, sslErrorHandler, sslError);
        } catch (Throwable th) {
            kd.m2919(m2290((char) (Gravity.getAbsoluteGravity(0, 0) + 72), 22 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), ViewConfiguration.getWindowTouchSlop() >> 8).intern(), m2290((char) Color.alpha(0), 40 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), TextUtils.indexOf("", "", 0) + 565).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient != null) {
            f2309 = (f2306 + 65) % 128;
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        int i2 = f2309 + 109;
        f2306 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 84 / 0;
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        int i2 = f2309 + 79;
        f2306 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2290((char) ((KeyEvent.getMaxKeyCode() >> 16) + 72), (KeyEvent.getMaxKeyCode() >> 16) + 22, Drawable.resolveOpacity(0, 0)).intern(), m2290((char) (18911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 40 - ExpandableListView.getPackedPositionGroup(0L), TextUtils.indexOf("", "") + 950).intern(), th, false);
        }
        if (i2 % 2 == 0) {
            this.f2311.onRenderProcessGone(webView, renderProcessGoneDetail);
            throw null;
        }
        this.f2311.onRenderProcessGone(webView, renderProcessGoneDetail);
        WebViewClient webViewClient = this.f2310;
        if (webViewClient != null) {
            return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        int i8 = f2309 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f2306 = i8 % 128;
        if (i8 % 2 != 0) {
            return true;
        }
        throw null;
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f4, float f8) {
        try {
            this.f2311.onScaleChanged(webView, f4, f8);
        } catch (Throwable th) {
            kd.m2919(m2290((char) (71 - TextUtils.lastIndexOf("", '0')), TextUtils.getOffsetBefore("", 0) + 22, KeyEvent.getDeadChar(0, 0)).intern(), m2290((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 35 - Color.argb(0, 0, 0, 0), TextUtils.getOffsetAfter("", 0) + 832).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient != null) {
            int i2 = f2309 + 5;
            f2306 = i2 % 128;
            if (i2 % 2 != 0) {
                webViewClient.onScaleChanged(webView, f4, f8);
                return;
            } else {
                webViewClient.onScaleChanged(webView, f4, f8);
                throw null;
            }
        }
        super.onScaleChanged(webView, f4, f8);
        int i8 = f2309 + 51;
        f2306 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 70 / 0;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        try {
            this.f2311.onTooManyRedirects(webView, message, message2);
            f2306 = (f2309 + 77) % 128;
        } catch (Throwable th) {
            kd.m2919(m2290((char) ((KeyEvent.getMaxKeyCode() >> 16) + 72), (ViewConfiguration.getWindowTouchSlop() >> 8) + 22, ViewConfiguration.getMaximumFlingVelocity() >> 16).intern(), m2290((char) (TextUtils.lastIndexOf("", '0') + 54584), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 38, View.getDefaultSize(0, 0) + 381).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient != null) {
            f2309 = (f2306 + 57) % 128;
            webViewClient.onTooManyRedirects(webView, message, message2);
            return;
        }
        super.onTooManyRedirects(webView, message, message2);
        int i2 = f2306 + 13;
        f2309 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 70 / 0;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        int i2 = f2309 + 71;
        f2306 = i2 % 128;
        try {
        } catch (Throwable th) {
            kd.m2919(m2290((char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 72), 22 - (KeyEvent.getMaxKeyCode() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1).intern(), m2290((char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 8432), 40 - TextUtils.indexOf("", "", 0, 0), 792 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))).intern(), th, false);
        }
        if (i2 % 2 == 0) {
            this.f2311.onUnhandledKeyEvent(webView, keyEvent);
            throw null;
        }
        this.f2311.onUnhandledKeyEvent(webView, keyEvent);
        f2306 = (f2309 + 99) % 128;
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            super.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            f2306 = (f2309 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        f2309 = (f2306 + 63) % 128;
        try {
            this.f2311.shouldInterceptRequest(webView, str);
        } catch (Throwable th) {
            kd.m2919(m2290((char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 72), 22 - (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.lastIndexOf("", '0', 0) + 1).intern(), m2290((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), KeyEvent.keyCodeFromString("") + 43, 338 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            return super.shouldInterceptRequest(webView, str);
        }
        WebResourceResponse webResourceResponseShouldInterceptRequest = webViewClient.shouldInterceptRequest(webView, str);
        f2306 = (f2309 + 5) % 128;
        return webResourceResponseShouldInterceptRequest;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        f2309 = (f2306 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        try {
            this.f2311.shouldOverrideKeyEvent(webView, keyEvent);
            f2306 = (f2309 + 5) % 128;
        } catch (Throwable th) {
            kd.m2919(m2290((char) (72 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), 21 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), View.combineMeasuredStates(0, 0)).intern(), m2290((char) (ExpandableListView.getPackedPositionType(0L) + 15909), 43 - TextUtils.indexOf("", ""), (ViewConfiguration.getTapTimeout() >> 16) + 749).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        f2306 = (f2309 + 107) % 128;
        boolean zM2292 = m2292(webView, str, false);
        f2309 = (f2306 + 13) % 128;
        return zM2292;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2290(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2307[i8 + i9]) ^ (((long) i9) * f2308)) ^ ((long) c7));
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

    @RequiresApi(api = 24)
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private boolean m2294(WebView webView, WebResourceRequest webResourceRequest, boolean z2) {
        try {
            if (this.f2311.shouldOverrideUrlLoading(webView, webResourceRequest) || z2) {
                WebViewClient webViewClient = this.f2310;
                if (webViewClient instanceof hh) {
                    f2306 = (f2309 + 87) % 128;
                    ((hh) webViewClient).m2294(webView, webResourceRequest, true);
                    f2306 = (f2309 + 77) % 128;
                }
                return true;
            }
        } catch (Throwable th) {
            kd.m2919(m2290((char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 72), Color.alpha(0) + 22, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1).intern(), m2290((char) ((KeyEvent.getMaxKeyCode() >> 16) + 29947), 53 - ExpandableListView.getPackedPositionChild(0L), 124 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)).intern(), th, false);
        }
        WebViewClient webViewClient2 = this.f2310;
        if (webViewClient2 != null) {
            int i2 = f2309 + 101;
            f2306 = i2 % 128;
            try {
                if (i2 % 2 != 0) {
                    return webViewClient2.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
                int i8 = 65 / 0;
                return webViewClient2.shouldOverrideUrlLoading(webView, webResourceRequest);
            } catch (Throwable th2) {
                kd.m2919(m2290((char) (73 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 22 - ExpandableListView.getPackedPositionType(0L), ViewConfiguration.getPressedStateDuration() >> 16).intern(), m2290((char) (21681 - TextUtils.lastIndexOf("", '0')), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 56, View.resolveSize(0, 0) + 178).intern(), th2, false);
            }
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        int i2 = f2309 + 93;
        f2306 = i2 % 128;
        int i8 = i2 % 2;
        return m2294(webView, webResourceRequest, false);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        f2309 = (f2306 + 67) % 128;
        try {
            this.f2311.shouldInterceptRequest(webView, webResourceRequest);
        } catch (Throwable th) {
            kd.m2919(m2290((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 71), 22 - View.resolveSize(0, 0), ViewConfiguration.getDoubleTapTimeout() >> 16).intern(), m2290((char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 44 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 338).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient != null) {
            f2309 = (f2306 + 15) % 128;
            return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        f2309 = (f2306 + 29) % 128;
        try {
            this.f2311.onReceivedError(webView, webResourceRequest, webResourceError);
        } catch (Throwable th) {
            kd.m2919(m2290((char) ('x' - AndroidCharacter.getMirror('0')), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 22, ViewConfiguration.getLongPressTimeout() >> 16).intern(), m2290((char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 36 - View.resolveSizeAndState(0, 0, 0), 420 - ((Process.getThreadPriority(0) + 20) >> 6)).intern(), th, false);
        }
        WebViewClient webViewClient = this.f2310;
        if (webViewClient == null) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            return;
        }
        webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        int i2 = f2309 + 81;
        f2306 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 13 / 0;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ci
    /* JADX INFO: renamed from: ﾒ */
    public final Object mo886(String str, List<Object> list, ch chVar) {
        f2309 = (f2306 + 75) % 128;
        int iHashCode = str.hashCode();
        if (iHashCode == 368095040) {
            if (!str.equals(m2290((char) ((ViewConfiguration.getEdgeSlop() >> 16) + 55294), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 18, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1012).intern())) {
                return null;
            }
            f2306 = (f2309 + 11) % 128;
            return m2293();
        }
        if (iHashCode != 381550901 || !str.equals(m2290((char) (53534 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 23, 990 - View.MeasureSpec.makeMeasureSpec(0, 0)).intern())) {
            return null;
        }
        f2306 = (f2309 + 25) % 128;
        return m2289();
    }
}
