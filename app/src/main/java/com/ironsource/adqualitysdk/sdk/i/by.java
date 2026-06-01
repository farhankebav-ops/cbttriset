package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
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
import android.widget.ExpandableListView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.ironsource.G9;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.AdCache;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.UserDataManager;
import net.pubnative.lite.sdk.api.RequestManager;
import net.pubnative.lite.sdk.auction.AdSourceConfig;
import net.pubnative.lite.sdk.auction.Auction;
import net.pubnative.lite.sdk.auction.HyBidAdSource;
import net.pubnative.lite.sdk.auction.VastTagAdSource;
import net.pubnative.lite.sdk.banner.presenter.BannerPresenterFactory;
import net.pubnative.lite.sdk.banner.presenter.MraidAdPresenter;
import net.pubnative.lite.sdk.banner.presenter.VastAdPresenter;
import net.pubnative.lite.sdk.browser.BrowserManager;
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialAd;
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialBroadcastReceiver;
import net.pubnative.lite.sdk.interstitial.HyBidInterstitialBroadcastSender;
import net.pubnative.lite.sdk.interstitial.PNInterstitialAd;
import net.pubnative.lite.sdk.interstitial.activity.HyBidInterstitialActivity;
import net.pubnative.lite.sdk.interstitial.activity.MraidInterstitialActivity;
import net.pubnative.lite.sdk.interstitial.activity.VastInterstitialActivity;
import net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenterDecorator;
import net.pubnative.lite.sdk.interstitial.presenter.InterstitialPresenterFactory;
import net.pubnative.lite.sdk.interstitial.presenter.MraidInterstitialPresenter;
import net.pubnative.lite.sdk.interstitial.presenter.VastInterstitialPresenter;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.models.AdData;
import net.pubnative.lite.sdk.models.AdExt;
import net.pubnative.lite.sdk.models.AdResponse;
import net.pubnative.lite.sdk.models.AdvertisingInfo;
import net.pubnative.lite.sdk.models.RemoteConfigAppInfo;
import net.pubnative.lite.sdk.models.VASTtag;
import net.pubnative.lite.sdk.mraid.MRAIDBanner;
import net.pubnative.lite.sdk.mraid.MRAIDInterstitial;
import net.pubnative.lite.sdk.mraid.MRAIDView;
import net.pubnative.lite.sdk.presenter.AdPresenterDecorator;
import net.pubnative.lite.sdk.presenter.PresenterFactory;
import net.pubnative.lite.sdk.rewarded.HyBidRewardedAd;
import net.pubnative.lite.sdk.rewarded.HyBidRewardedBroadcastReceiver;
import net.pubnative.lite.sdk.rewarded.HyBidRewardedBroadcastSender;
import net.pubnative.lite.sdk.rewarded.activity.HyBidRewardedActivity;
import net.pubnative.lite.sdk.rewarded.activity.VastRewardedActivity;
import net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenterDecorator;
import net.pubnative.lite.sdk.rewarded.presenter.RewardedPresenterFactory;
import net.pubnative.lite.sdk.rewarded.presenter.VastRewardedPresenter;
import net.pubnative.lite.sdk.views.HyBidAdView;
import net.pubnative.lite.sdk.views.HyBidBannerAdView;
import net.pubnative.lite.sdk.views.HyBidLeaderboardAdView;
import net.pubnative.lite.sdk.views.HyBidMRectAdView;
import net.pubnative.lite.sdk.views.PNAPIContentInfoView;
import net.pubnative.lite.sdk.views.PNAdView;
import net.pubnative.lite.sdk.views.PNBannerAdView;
import net.pubnative.lite.sdk.views.PNMRectAdView;
import net.pubnative.lite.sdk.views.PNWebView;
import net.pubnative.lite.sdk.visibility.ImpressionManager;
import net.pubnative.lite.sdk.vpaid.PlayerInfo;
import net.pubnative.lite.sdk.vpaid.VideoAd;
import net.pubnative.lite.sdk.vpaid.VideoAdController;
import net.pubnative.lite.sdk.vpaid.VideoAdListener;
import net.pubnative.lite.sdk.vpaid.VideoAdView;
import net.pubnative.lite.sdk.vpaid.models.vast.ClickThrough;
import net.pubnative.lite.sdk.vpaid.models.vast.ClickTracking;
import net.pubnative.lite.sdk.vpaid.models.vast.Companion;
import net.pubnative.lite.sdk.vpaid.models.vast.CompanionAds;
import net.pubnative.lite.sdk.vpaid.models.vast.CompanionClickThrough;
import net.pubnative.lite.sdk.vpaid.models.vast.CompanionClickTracking;
import net.pubnative.lite.sdk.vpaid.models.vast.Creative;
import net.pubnative.lite.sdk.vpaid.models.vast.Creatives;
import net.pubnative.lite.sdk.vpaid.models.vast.InLine;
import net.pubnative.lite.sdk.vpaid.models.vast.MediaFile;
import net.pubnative.lite.sdk.vpaid.models.vast.MediaFiles;
import net.pubnative.lite.sdk.vpaid.models.vast.StaticResource;
import net.pubnative.lite.sdk.vpaid.models.vast.VASTAdTagURI;
import net.pubnative.lite.sdk.vpaid.models.vast.Vast;
import net.pubnative.lite.sdk.vpaid.models.vast.VastAdSource;
import net.pubnative.lite.sdk.vpaid.models.vast.VideoClicks;
import net.pubnative.lite.sdk.vpaid.models.vast.Wrapper;
import net.pubnative.lite.sdk.vpaid.models.vpaid.CreativeParams;
import net.pubnative.lite.sdk.vpaid.response.AdParams;
import net.pubnative.lite.sdk.vpaid.response.VastProcessor;
import net.pubnative.lite.sdk.vpaid.vast.ViewControllerVast;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class by extends bg {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f1132 = null;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f1133 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1134 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1135;

    static {
        char[] cArr = new char[2355];
        a0.o("ë\u0011øªÌ\u000fÑ®¥\u0015ßtÌÛøbåÊ\u0091~¾ïªl\u0019¹\n\u0015>\u009d#\u0000W\u0080x?l¤\u0091K\u0085ñ¶WÚæÏcóóç\u008b\b\u0012\u0000I\u0013ç'd:ìNMaÁuO\u0088¯\u009c?¯´Ã)Ö\u008fê\u0016þc\u0011ë%s8Ò\u001c\u009b\u000f&;¬&\"R\u0084}\bi\u0081\u0094B\u0080ø³}ßÌÊ@öÔâ¹\u007fÙlvXßEi1Å\u001eX\nÇ÷;ã\u008bÐ-¼\u0092©\u0010\u0095\u0089\u0081ý\u0000H\u0013ó'V:÷NLaóuX\u0088\u0095\u009c?¯¯Ã\u0016Ö\u008dê\u001dÛ:È\u0087ü\u000bá\u0086\u0095\u0010º¿®7SëGXtå\u0018g\r÷1f%\rÊ\u0085\u0000A\u0013ÿ'w:êNAaÝuR_\u008bL\"x³e9\u0011\u0084>\t*¥×}Ãüð`\u009cÈ\u0089IµÅ¡®N7z\u0099g\b\u0013\u0080\u0000\t,\u0098ÙsÅâãFðóÄ~Ùü\u00adG\u0082ø\u0096Sk\u009d\u007f)L´ \u001c5\u0080\t\u001d\u001d}òâÆoÖ»Å\u0006ñ\u008aì\u0007\u0098\u0084·;£\u0081^YJØyD\u0015ì\u0000m<á(\u008aÇ\u0013Ú\u0015É¯ý,à¾\u0094\f»\u0080¯\u0019RÜFfuã\u0019R\fÞ0J$'\u0000H\u0013ó'V:÷NLaûuR\u0088²\u009c5¯¨Ã\u0017Ö\u009aê\u0011þv\u0011å%w8ÌLk_Ð\u0000H\u0013ó'V:÷NLaûuR\u0088²\u009c5¯¨Ã\u0017Ö\u009aê\u0011þv\u0011å%w8ÌLh_ÆsQ\u0086©\u009a6\u00ad¿Á\u0007Ô\u0083è\u000eüV\u000fë#{6ÇJE]Àq%\u0084¸\u009e\u009c\u008d'¹\u0082¤#Ð\u0098ÿ/ë\u0086\u0016f\u0002á1|]ÃHNtÅ`¢\u008f1»£¦\u0018Ò¼Á\u0012í\u0085\u0018}\u0004â3k_ÓJWvÚb\u0083\u0091?½¢¨\u0012Ô\u009dÃ\u0010\u0000P\u0013Ä']:ðN\\a×uN\u0088µ\u009c$¯³Ã\u0010Ö\u0087ê\u0019þn\u0011Í%r\u0000I\u0013ä'`:ûNZaÁuH\u0088¯\u009c$¯³Ã\u0005Ö\u0082ê(þp\u0011é%e8ÅLD_Às[\u0086º\u009a\u0016\u00ad¹Á\u0005Ô\u009fè\büe\u000fú#w6ÐVúEWqÓlH\u0018é7r#ûÞ\u001cÊ\u0097ù\u0000\u0095¶\u00801¼\u009b¨ÃGZsÖnv\u001a÷\ts%èÐ\tÌ§û\u000e\u0097¶\u00827¾¦ªÅYD\u0000M\u0013ø'u:÷NLaûuR\u0088²\u009c5¯¨Ã\u0017Ö\u009aê\u0011þv\u0011å%w8ÌLz_Æs[\u0086»\u009a7\u00ad²Á\u0012Ô\u0095è\búKéöÝzÀ÷´|\u009bÁ\u008fUr¾f?U´9\r,\u009a\u0010\u0011\u0004vëðßgÂí¶E¥Ì\u0089P|°`!Wµ;\u001e.\u009fïÌüMÈÂÕ\u0012¡ú\u008ee\u009aüg\ns\u0093@\f,¯9:\u0005¿\u0011\u008eþBÊÝ×v£í°8\u009cïi\u000eu\u009bBP.\u00ad;<\u0007¬\u0013Ãà^ÌÉÙt¥ç²`\u009e\u008bk\tw\u009aDRP«=3\tª\u0015ÍâDÎÑÛr§õ´4\u0080¨m\u0017y¶F+R¬?\u001f\u000b²\u0017ÞäUðÌÝw©æ¶q\u0082\u0092o\u0005{\u009bH,T\u008f!7\rV\u0019Áæ@òÕß~«é\u0000H\u0013ó'V:÷NLaûuR\u0088²\u009c5¯¨Ã\u0017Ö\u009aê\u0011þv\u0011å%w8ÌLk_×sJ\u0086¡\u009a$\u00adµÁ\u0012Ô\u0089êsùòÍ}Ð\u00ad¤E\u008bÚ\u009fCbµv,E³)\u0010<\u0085\u0000\u0000\u00141ûýÏbÒÉ¦Rµ\u0087\u0099Pl±p$Gï+\u0012>\u0083\u0002\u0013\u0016|åáÉvÜË X·ß\u009b4n¶r%AíU\u00148\u008c\f\u0015\u0010rçûËnÞÍ¢J±\u008b\u0085\u0012h£|*C\u0094W\u0013: \u000e\r\u0012aáêõsØÈ¬Y³Î\u0087-jº~$M\u0093Q0$\u0088\bé\u001c~ãÿ÷jÚÁ®V\u0000M\u0013ø'u:÷NLaûuR\u0088²\u009c5¯¨Ã\u0017Ö\u009aê\u0011þv\u0011å%w8ÌLk_×sJ\u0086¡\u009a$\u00adµÁ\u0012Ô\u0089\u0000n\u0013ï'`:°NXaÇu^\u0088¨\u009c1¯®Ã\rÖ\u0098ê\u001dþ,\u0011à%\u007f8ÔLO_\u009asM\u0086¬\u009a9\u00adòÁ\u000fÔ\u009eè\u000eüa\u000fü#k6ÖJE]Âq)\u0084«\u00988«ð¿\tÒ\u0091æ\búo\ræ!s4ÐHW[\u0096o\u0014\u0082\u00ad\u0096%©\u0094½#Ð\u009aä\nøm\u000bà\u001fo2ÒFYYÎm-\u0080¯\u00944§£»\u000fÎ\u0082âéö|\tý\u001dj0ÑaErøFt[ù/r\u0000Ï\u0014[é°ý1Îº¢\u0003·\u0094\u008b\u001f\u009fxpþDiYò-Z>Ó\u0012Dç\u00adû(Ì» \f\u0000A\u0013î2Ø!w\u0015É\bf|ÅSJ\u0000A\u0013î'Q:æN\\\u0000A\u0013î'F:ûN[aÂuS\u0088¨\u009c#¯¿ZHIç}k`ò\u0014S;Ï/\\Ò¼Æ0õ½\u0099\n\u008c®°\u001f¤mKêè$û\u0099Ï\u000fÒ\u0087¦*\u0089¡\u009d\t`ßtHGÊ+{>ÿ\u0002O\u0016\u0004ù\u008aÍ)Ð¸¤:·\u00adCÓPNdÂyO\rÙ\"V6Þ\u008dw\u009eâªo·íÃVìÞøo\u0005\u0099\u0011\u001d\u0000M\u0013Ø'U:×NlaûuR\u0088²\u009c5¯¨Ã\u0017Ö\u009aê\u0011þv\u0011å%w8Ì\u0000M\u0013Ø'U:×Nlaðu]\u0088¨\u009c>¯¿Ã\u0016\u0000A\u0013î'D:ìNMaÁuY\u0088¨\u009c$¯¿Ã\u0016Öªê\u001dþa\u0011ã%d8ÁL^_ÛsL\u0000P\u0013ø'q:íNMaÜuH\u0088£\u009c\"¯\u009cÃ\u0005Ö\u008dê\fþm\u0011þ%o\u0000H\u0013ó'V:÷NLaàuY\u0088±\u009c1¯¨Ã\u0000Ö\u008bê\u001cþC\u0011è\u0000H\u0013ó'V:÷NLaàuY\u0088±\u009c1¯¨Ã\u0000Ö\u008bê\u001cþ@\u0011þ%y8ÁLN_×s_\u0086»\u009a&\u00ad\u008eÁ\u0003Ô\u0093è\u001füm\u000fø#}6Ð±s¢È\u0096m\u008bÌÿwÐÛÄb9\u008a-\n\u001e\u0093r;g°['O{ Å\u0094B\u0089úýuîìÂd7\u0080+\u001d\u001c´p8e¥Y%MZ¾Ç\u0000R\u0013ï'c:ÿNZaÖuY\u0088¢\u009c\u0000¯¨Ã\u0001Ö\u009dê\u001dþl\u0011ø%s8ÒLn_Ñs]\u0086§\u009a \u00ad½Á\u0012Ô\u009fè\b»¥¨\u0018\u009c\u0094\u0081\bõ\u00adÚ!Î®3U'÷\u0014_xömjQêE\u009bª\u000f\u009e\u0084\u0083%÷\u009bä\"Èª=K!Ê\u0016Yzè\u0000V\u0013ë'g:êNza×uK\u0088§\u009c\"¯¾Ã\u0001Ö\u008aê(þp\u0011é%e8ÅLD_Às[\u0086º\u0099\u0095\u008a\u0014¾\u009b£K×£ø<ì¥\u0011S\u0005Ê6UZöOcsæg×\u0088\u001b¼\u0084¡/Õ´Æaê¶\u001fW\u0003Â4\tXïMnqöe\u009e\u0096\u0007º\u0087¯<Ó³ÄcèÚ\u001dR\u0001Û2L&åK`\u007fóc\u0084\u0094E¸©\u00ad&Ñ\u0097Â*öÝ\u001be\u000fÈ0l$ðI}}áa\u0096\u0092\r\u0086¦«>ß¿À(ôÉ\u0019\\\r×>`\u0000H\u0013ó'V:÷NLaàuY\u0088±\u009c1¯¨Ã\u0000Ö\u008bê\u001cþC\u0011ï%b8ÉL\\_ÝsJ\u0086±\u0000n\u0013ï'`:°NXaÇu^\u0088¨\u009c1¯®Ã\rÖ\u0098ê\u001dþ,\u0011à%\u007f8ÔLO_\u009asM\u0086¬\u009a9\u00adòÁ\u0014Ô\u0095è\rüe\u000fü#|6ÇJH]\u0098q!\u0084©\u0098 «·¿\u001eÒ\u009bæ\bú\u007f\r¾!L4ÅH][Ìo\u0010\u0082©\u0096!©\u0081½\u0018Ð\u0090ä\u001bøl\u000bÓ\u001f\u007f2ÒFYYÌm-\u0080º\u0094!\u009c\u009a\u008f'»«¦&Ò¶ý\u001bé\u0087\u0014k\u0000î3r_ÍJFvõb\u00ad\u008d4¹³¤\u001aÐ\u008fÃ\fï\u008b\u0000P\u0013Ä'U:úN~aÛuY\u0088±\u0000H\u0013ó'V:÷NLaóuX\u0088\u0090\u009c9¯¿Ã\u0013l]\u007fæKCVâ\"Y\rå\u0019Hä½ð+Ãª¯\u0003ºº\u0086\t\u0092A}ðIfTÂ\u0000H\u0013ó'V:÷NLaþuY\u0088§\u009c4¯¿Ã\u0016Ö\u008cê\u0017þc\u0011þ%r8áLN_âsW\u0086\u00ad\u009a%\u0000H\u0013ó'V:÷NLaÿun\u0088£\u009c3¯®Ã%Ö\u008aê.þk\u0011é%a\u0000P\u0013Ä'U:ÎNaañuS\u0088¨\u009c$¯¿Ã\nÖ\u009aê1þl\u0011ê%y8öLC_ÑsI\u0000P\u0013Ä'V:ÿNFaÜuY\u0088´\u009c\u0011¯¾Ã2Ö\u0087ê\u001dþu\u0001ò\u0012f&û;nOï`stê\u0089%\u009d\u0096®.Â¯×)ë\u00ad\u0011I\u0002Ý6Z+â_SpýdL\u0099º\u008d>\u0000V\u0013ã'p:ûNGaóuX\u0000V\u0013ã'p:ûNGaóuX\u0088\u008a\u009c9¯©Ã\u0010Ö\u008bê\u0016þg\u0011þY\u008fJ:~©c\"\u0017\u009e8*,\u0081ÑIÅàöf\u009aÊ×\bÄµð9í´\u0099&¶\u009e¢\r_ûKkx÷\u0014I\u0001ß=T\u0000P\u0013æ'u:çNMaÀuu\u0088¨\u009c6¯µ\u0000H\u0013ó'V:÷NLaûuR\u0088²\u009c5¯¨Ã\u0017Ö\u009aê\u0011þv\u0011å%w8ÌLk_Ðsr\u0086¡\u009a!\u00ad¨Á\u0003Ô\u009eè\u001füvè\u000fû´Ï\u0011Ò°¦\u000b\u0089§\u009d\u001e`ötvGï+G>Ì\u0002[\u0016\u0004ù¯Í\u001dÐ\u008e¤\u001e·\u0087\u009b\u001cnárpEé=\u0086.=\u001a\u0098\u00079s\u0082\\=H\u0096µ^¡÷\u0092qþÝël×ßÃ¿,6\u0018½\u0005\u0000q\u0081b\bPñCmwçjR\u001eé1r%öØ\"Ì\u0091ÿ3\u0093¨\u00868º©®ÂAGuÖhw\u0000A\u0013î'D:ÿNZaÓuQ\u0088µË¶Ø\u0003ì\u0091ñ\t\u0085\u008bª=¾²CRWÂdU\bè\u001db!ý5\u0090Ú:î\u0097ó3\u0087¾\u009eú\u008dO¹Ü¤WÐëÿ_ëô\u0016)\u0002\u00931\u0018]¼H0t»`Â\u008fL»ß¦~\u0000V\u0013ã'p:ûNGañuP\u0088¯\u009c3¯±Ã\u00178Û+~\u001få\u0002evÛY~MÌ°,¤§\u00977û\u009bî\u001eñ\u008bâ.ÖµË5¿\u008b\u0090.\u0084\u0086yomû^y2Å'H\u001b×\u0000C\u0013å'y:îNIaÜuU\u0088©\u009c>¶½¥\u001b\u0091\u0087\u008c\u0010ø·×\"Ã«>W*À\u0019euþ`c\u0097Ê\u0084l°ð\u00adgÙÀöUâÜ\u001f \u000b·8\u0010T\u0081A\u000e}\u0092ià\u0086Q²÷¯[ÛÌÈHäÐ\u0011)\u0000C\u0013å'y:îNIaÜuU\u0088©\u009c>¯\u0099Ã\bÖ\u0087ê\u001bþi\u0011Ø%d8ÁLI_ßsW\u0086¦\u009a5\u0000C\u0013ø'q:ÿN\\aÛuJ\u0088£¬4¿\u008f\u008b\u0006\u0096\u0088â+Í¬Ù=$Ô0Tâ1ñ\u009cÅ Ø\u008f¬>\u0083¯úÞécÝïÀb´á\u009b^\u008fçr!f\u00adU 9\u008f,\u0003\u0000M\u0013ï'p:÷NIaôuU\u0088ª\u009c53\u008a (\u0014·\t0}\u008eR3F\u0092»m¯ò\u009cn^ëMFyÍdR\u0010ù?i+ÖÖ\u001bÂ\u009bñ\r\u009d©\u0088$´£ ß3Ü a\u0014í\t`\u0000W\u0013ø'u:îNXa×uNùBêßÞSÃÞ·}\u0098Â\u008c|q³e#V\u009b:\"/³\u0000C\u0013ø'q:ÿN\\aÛuJ\u0088£\u009c\u0000¯»Ã\u0016Ö\u008fê\u0015þq\u0000g\u0013ï'`:ßNXaÂuh\u0088©\u009c;¯¿Ã\nÜ¯Ï?û\u0080æ=\u0092\u0099½\u0015©\u0088Td@ósx\u001fô\nA6Ú\"¡Í%ù\u0091ä\u0002Q/B³v<k\u0094\u001f\u001d0\u008a$\u0005ÙõÍMþâ\u0092t\u0087Û»W¯*@µt$i\u0099\u001d\u0004ÒÊÁBõÍèr\u009cá³U§âZ\u0004N\u0093»¡¨)\u009c¦\u0081\u0019õ\u008aÚ7Î\u00883e'÷\u0014hxËm^QÛE\u008dª.\u0000g\u0013ï'`:ßNLaäu]\u0088µ\u009c$\u0086\u0080\u0095\b¡\u0087¼8È«ç\u000fó´\u000eO\u001aÒ)tEç\u0017ý\u0004u0ú-EYÖvebÃ\u009f(\u008b«8ú+r\u001fý\u0002BvÑYnMÒ°(¤¨\u00973\u0000g\u0013ï'`:ßNLaðuY\u0088§\u009c3¯µÃ\nÖ\u009d\u0000g\u0013ï'`:ßNLaóuO\u0088µ\u009c5¯®Ã1Ö\u009cê\u0014\u0000g\u0013ï'`:ßNLaöu]\u0088²\u009c1¯\u0092Ã\u0010Ö\u0083ê\u0014\u0000g\u0013ï'`:ßNLaöu]\u0088²\u009c1¯\u0090Ã\u0017\u0000g\u0013ï'`:ßNLaöu]\u0088²\u009c1¯\u008fÃ\u0016Ö\u0082\u0000g\u0013ï'`:ßNLaöu]\u0088²\u009c1¯\u0089Ã\u0010Ö\u009cê\u0011þl\u0011ë%P8ÉLO_ØsZÊCÙØíQðß\u0084|«÷¿HB¤V&e\u0093\t \u001c« 74cÛÈïzòé\u0086y\u0095à¹{L\u0086P\u0017g\u008e\"Ó1[\u0005Ô\u0018kløCVWéª\u0000¾\u0085\u008d\u0003á£ô\tÈ¸ÜÄ3Q\u0007Ì\u001asmØ~PJßW`#ó\f]\u0018âå\u000bñ\u008eÂ\b®¨»\u0018\u0087£\u0000g\u0013ï'`:ßNLaâu]\u0088´\u009c1¯·Ã\u0017Ö¸ê\u0011þf\u0011é%y8òLO_ÐsW\u0086º\u009a7\u00ad¿Á\u0012Ô¥è\büh\u0000g\u0013ï'`:ßNLaâu]\u0088´\u009c1¯·Ã\u0017Ö«ê\u0016þf\u0011Ï%w8ÒLN_æs[\u0086¬\u009a;\u00ad®Á\u0003Ô\u0093è\u000eüQ\u000fü#t\u0000g\u0013ï'`:ßNLaâu]\u0088´\u009c1¯·Ã\u0017Ö¸ê\u0011þf\u0011é%y8ãLF_Ýs]\u0086£\u009a!\u0000g\u0013ï'`:ßNLaâu]\u0088´\u009c1¯·Ã\u0017Ö«ê\u0016þf\u0011Ï%w8ÒLN_÷sR\u0086¡\u009a1\u00ad·Á\u0015\u009bú\u0088r¼ý¡BÕÑú\u007fîÀ\u0013)\u0007¬4*X\u008aM%q\u008ceû\u008at¾ä£{×ÞÄEèÆ\u001d\u0000\u0001½6-Z\u0088O!s\u008egê\u0094g\u0000g\u0013ï'`:ßNLaâu]\u0088´\u009c1¯·Ã\u0017Ö«ê\u0016þf\u0011Ï%w8ÒLN_ásL\u0086¤\u009a\u001e\u00adµÁ\u0015Ô\u0084ø0ë¸ß7Â\u0088¶\u001b\u0099µ\u008d\npãdfWà;@\u0000g\u0013ï'`:ÈNAaÖuY\u0088©\u009c\u0013¯¶Ã\rÖ\u008dê\u0013þq\u0011Ï%z8ÉLI_ßsj\u0086 \u009a \u00ad³Á\u0013Ô\u0097è\u0012í\u0012þ\u009aÊ\u0015×½£4\u008c£\u0098,eÜqfBÃ.x;ø\u0007f\u0013\u0004üºÈ\u000fÕ¼¡<²ª\u009e\u001fkÏwF@Ê,x9ì\u0005a\u0011\u0016â·Î\u0004Û¤§-z\fi\u0084]\u000b@¶4,\u001b´\u000f'òÌæUÕØ¹`¬ë\u0090P\u0084\u0005k\u008e_\u001eB 6\u0015%·\t'üÌàL×Ð»eÍgÞïê`÷Ý\u0083Z¬×¸]E²Q9b¬\u000e\u0001\u001b\u00ad'\u00173oÜüèwõÎ\u0081C\u0092Û¾PK\u0089W6`¯%Ò6Z\u0002Õ\u001fbkóDkPà\u00ad\u001d¹\u0080\u008a,æ£ó>Ï¬ÛÃ4P\u0000Õ\u001dpiì\u0000g\u0013ï'`:ÈNIaÁuH\u0088\u0087\u009c4¯\u0089Ã\u000bÖ\u009bê\nþa\u0011é%U8ÒLO_ÕsJ\u0086¡\u009a$\u00ad¹Á\u0015\u007fDlÌXCEð1n\u001eõ\nv÷\u0084ã5Ð\u0090¼+©¨\u0095\u000f\u0081Dn×ZAÕ&Æ®ò!ï\u008c\u009b\u001d´\u0092 \t]îIrzÉ\u0016@\u0003Ü?V+6Ä¿ð4í\u0084\u0099?\u008a\u0090¦\u0007Sý\u0000g\u0013ï'`:ÍN\\aÓuH\u0088¯\u009c3¯\u0088Ã\u0001Ö\u009dê\u0017þw\u0011þ%u8ÅLi_Æs[\u0086©\u009a&\u00adµÁ\u0010Ô\u0095è.ü}\u000fþ#}\u0000g\u0013ï'`:ÉNZaÓuL\u0088¶\u009c5¯¨Ã'Ö\u009cê\u001dþc\u0011ø%\u007f8ÖLO_Ç\u0000g\u0013ï'`:ÉNZaÓuL\u0088¶\u009c5¯¨Ã2Ö¯ê+þV\u0011Í%r8ôLK_Ósk\u0086\u009a\u009a\u001b\u0000g\u0013ï'`:ÝNZa×u]\u0088²\u009c9¯¬Ã\u0001Ö¾ê\u0019þp\u0011í%{8ÓLi_Æs[\u0086©\u009a&\u00adµÁ\u0010Ô\u0095è>üe\u000fú#y\u0000g\u0013ï'`:ÝNZa×u]\u0088²\u009c9¯¬Ã\u0001Ö¾ê\u0019þp\u0011í%{8ÓLo_ÚsH\u0086¡\u009a \u00ad³Á\bÔ\u009dè\u001füj\u000fú#N6ÃJ^]Å", "ISO-8859-1", cArr, 0, 2355);
        f1132 = cArr;
        f1133 = -6809736618199477366L;
    }

    public by(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private static List<String> m1327(AdParams adParams) {
        int i2 = f1135 + 101;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            adParams.getEndCardUrlList();
            throw null;
        }
        List<String> endCardUrlList = adParams.getEndCardUrlList();
        f1134 = (f1135 + 1) % 128;
        return endCardUrlList;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static String m1328(AdParams adParams) {
        int i2 = f1135 + 91;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return adParams.getVideoRedirectUrl();
        }
        adParams.getVideoRedirectUrl();
        throw null;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static List<String> m1329(AdParams adParams) {
        f1135 = (f1134 + 11) % 128;
        List<String> endCardClicks = adParams.getEndCardClicks();
        int i2 = f1135 + 79;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 98 / 0;
        }
        return endCardClicks;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static List<String> m1330(AdParams adParams) {
        f1134 = (f1135 + 55) % 128;
        List<String> videoClicks = adParams.getVideoClicks();
        int i2 = f1135 + 31;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 65 / 0;
        }
        return videoClicks;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static List<String> m1331(AdParams adParams) {
        int i2 = f1135 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            adParams.getVideoFileUrlsList();
            throw null;
        }
        List<String> videoFileUrlsList = adParams.getVideoFileUrlsList();
        f1134 = (f1135 + 67) % 128;
        return videoFileUrlsList;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static String m1332(AdParams adParams) {
        f1134 = (f1135 + 85) % 128;
        String endCardRedirectUrl = adParams.getEndCardRedirectUrl();
        int i2 = f1135 + 51;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return endCardRedirectUrl;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static String m1333() {
        f1135 = (f1134 + 5) % 128;
        String appToken = HyBid.getAppToken();
        int i2 = f1135 + 13;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 0 / 0;
        }
        return appToken;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static /* synthetic */ List m1338(AdParams adParams) {
        f1134 = (f1135 + 97) % 128;
        List<String> listM1327 = m1327(adParams);
        int i2 = f1135 + 19;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return listM1327;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static /* synthetic */ List m1340(AdParams adParams) {
        f1135 = (f1134 + 107) % 128;
        List<String> listM1331 = m1331(adParams);
        int i2 = f1135 + 39;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 72 / 0;
        }
        return listM1331;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ String m1341() {
        f1134 = (f1135 + 73) % 128;
        String strM1333 = m1333();
        int i2 = f1135 + 11;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return strM1333;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public static /* synthetic */ List m1345(AdParams adParams) {
        f1134 = (f1135 + 19) % 128;
        List<String> listM1329 = m1329(adParams);
        int i2 = f1134 + 3;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return listM1329;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1349(StaticResource staticResource) {
        f1134 = (f1135 + 45) % 128;
        String strM1383 = m1383(staticResource);
        f1135 = (f1134 + 67) % 128;
        return strM1383;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m1358(AdData adData) {
        int i2 = f1134 + 61;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1394(adData);
        }
        m1394(adData);
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1368(Ad ad) {
        int i2 = f1134 + 1;
        f1135 = i2 % 128;
        int i8 = i2 % 2;
        String strM1337 = m1337(ad);
        if (i8 != 0) {
            int i9 = 37 / 0;
        }
        f1134 = (f1135 + 87) % 128;
        return strM1337;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ e m1378(by byVar, VideoAdListener videoAdListener, ch chVar) {
        f1135 = (f1134 + 91) % 128;
        e eVarM1379 = byVar.m1379(videoAdListener, chVar);
        int i2 = f1135 + 59;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return eVarM1379;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m1393(Ad ad) {
        f1134 = (f1135 + 35) % 128;
        String strM1339 = m1339(ad);
        f1135 = (f1134 + 39) % 128;
        return strM1339;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static String m1334(Ad ad) {
        int i2 = f1135 + 79;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return ad.getVast();
        }
        ad.getVast();
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static String m1337(Ad ad) {
        f1135 = (f1134 + 17) % 128;
        String creativeId = ad.getCreativeId();
        f1134 = (f1135 + 73) % 128;
        return creativeId;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static String m1339(Ad ad) {
        f1134 = (f1135 + 29) % 128;
        String zoneId = ad.getZoneId();
        int i2 = f1134 + 103;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return zoneId;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static String m1342(Ad ad, String str) {
        f1135 = (f1134 + 71) % 128;
        String assetUrl = ad.getAssetUrl(str);
        int i2 = f1135 + 91;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 68 / 0;
        }
        return assetUrl;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static AdData m1346(Ad ad, String str) {
        f1135 = (f1134 + 19) % 128;
        AdData asset = ad.getAsset(str);
        f1134 = (f1135 + 81) % 128;
        return asset;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1351(AdParams adParams) {
        f1135 = (f1134 + 33) % 128;
        String strM1328 = m1328(adParams);
        int i2 = f1134 + 83;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM1328;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m1359(AdData adData, String str) {
        f1135 = (f1134 + 19) % 128;
        String strM1348 = m1348(adData, str);
        f1135 = (f1134 + 93) % 128;
        return strM1348;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1369(Ad ad, String str) {
        f1135 = (f1134 + 65) % 128;
        String strM1342 = m1342(ad, str);
        f1134 = (f1135 + 11) % 128;
        return strM1342;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1381(Ad ad) {
        int i2 = f1135 + 93;
        f1134 = i2 % 128;
        int i8 = i2 % 2;
        String strM1334 = m1334(ad);
        if (i8 == 0) {
            int i9 = 15 / 0;
        }
        return strM1334;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m1395(MediaFile mediaFile) {
        int i2 = f1134 + 91;
        f1135 = i2 % 128;
        if (i2 % 2 != 0) {
            m1360(mediaFile);
            throw null;
        }
        String strM1360 = m1360(mediaFile);
        int i8 = f1135 + 55;
        f1134 = i8 % 128;
        if (i8 % 2 != 0) {
            return strM1360;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static List<AdData> m1336(Ad ad, String str) {
        f1135 = (f1134 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        List<AdData> beacons = ad.getBeacons(str);
        int i2 = f1135 + 91;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return beacons;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static String m1343(AdParams adParams) {
        f1135 = (f1134 + 51) % 128;
        String adParams2 = adParams.getAdParams();
        f1135 = (f1134 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        return adParams2;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static String m1344(AdData adData) {
        int i2 = f1135 + 53;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return adData.getURL();
        }
        adData.getURL();
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ List m1352(Ad ad, String str) {
        f1134 = (f1135 + 63) % 128;
        List<AdData> listM1336 = m1336(ad, str);
        f1135 = (f1134 + 67) % 128;
        return listM1336;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m1362(CreativeParams creativeParams) {
        int i2 = f1135 + 53;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            m1350(creativeParams);
            throw null;
        }
        String strM1350 = m1350(creativeParams);
        f1135 = (f1134 + 103) % 128;
        return strM1350;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1370(AdData adData) {
        int i2 = f1134 + 33;
        f1135 = i2 % 128;
        if (i2 % 2 != 0) {
            m1344(adData);
            throw null;
        }
        String strM1344 = m1344(adData);
        int i8 = f1134 + 3;
        f1135 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 65 / 0;
        }
        return strM1344;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1382(AdData adData) {
        f1134 = (f1135 + 85) % 128;
        String strM1347 = m1347(adData);
        int i2 = f1134 + 65;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM1347;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m1396(StaticResource staticResource) {
        f1134 = (f1135 + 43) % 128;
        String strM1361 = m1361(staticResource);
        int i2 = f1135 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return strM1361;
        }
        throw null;
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e extends VideoAdListener implements hc<VideoAdListener> {

        /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
        private static int f1174 = 1;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static short[] f1176 = null;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static int f1177 = -584027865;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f1179 = 0;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static int f1180 = -144942445;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static int f1181 = 89;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private VideoAdListener f1183;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private ch f1184;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static byte[] f1175 = {-58, 0, 14, 2, 0, -18, 34, -17, 3, -14, 35, -24, 35, -45, -1, 65, -68, 13, -9, 9, -15, 1, 10, 29, -24, 35, -46, 10, 1, -5, 19, -61, 3, 8, 27, -30, 3, -14, 35, -24, 35, -45, -1, 65, -68, 13, -9, 9, -15, 1, 10, 29, -24, 35, -46, 10, 1, -5, 19, -62, -1, -15, 2, 17, -19, 33, -17, 35, -45, -1, 65, -68, 13, -9, 9, -15, 1, 10, 29, -24, 35, -46, 10, 1, -5, 19, -62, -1, -6, 8, -6, -3, 41, -33, 35, -45, -1, 65, -68, 13, -9, 9, -15, 1, 10, 29, -24, 35, -46, 10, 1, -5, 19, -58, -10, 41, -35, 5, 2, -4, 19, -18, -5, 37, -32, 35, -45, -1, 65, -68, 13, -9, 9, -15, 1, 10, 29, -24, 35, -46, 10, 1, -5, 19, -54, 8, 7, 21, -17, -14, 17, 30, -33, -10, 41, -40, -2, -5, 1, -2, 50, -43, -1, 65, -68, 13, -9, 9, -15, 1, 10, 29, -24, 35, -46, 10, 1, -5, 19, -51, -10, -7, 6, 41, -30, -14, 17, 30, -33, -10, 41, -40, -2, -5, 1, -2, 50, -33, 35, -45, -1, 65, -68, 13, -9, 9, -15, 1, 10, 29, -24, 35, -46, 10, 1, -5, 19, -56, 3, 8, 27, -30, 3, -14, 35, -24, -14, 17, 30, -33, -10, 41, -41, -1, 65, -68, 13, -9, 9, -15, 1, 10, 29, -24, 35, -46, 10, 1, -5, 19};

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static int[] f1178 = {939213787, -580340080, -1566692816, 644381725, 1553210343, 484788871, 1623657751, 998203890, -1376132022, -201857803, -567488946, -2110397265, -181864720, 2082142435, -1881948138, -1211318802, -455504042, 436733505};

        public e(VideoAdListener videoAdListener, ch chVar) {
            this.f1183 = videoAdListener;
            this.f1184 = chVar;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private VideoAdListener m1404() {
            int i2 = f1174;
            VideoAdListener videoAdListener = this.f1183;
            int i8 = i2 + 71;
            f1179 = i8 % 128;
            if (i8 % 2 == 0) {
                return videoAdListener;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m1405(int[] iArr, int i2) {
            String str;
            synchronized (d.f1664) {
                try {
                    char[] cArr = new char[4];
                    char[] cArr2 = new char[iArr.length << 1];
                    int[] iArr2 = (int[]) f1178.clone();
                    d.f1665 = 0;
                    while (true) {
                        int i8 = d.f1665;
                        if (i8 < iArr.length) {
                            int i9 = iArr[i8];
                            char c7 = (char) (i9 >> 16);
                            cArr[0] = c7;
                            char c8 = (char) i9;
                            cArr[1] = c8;
                            char c9 = (char) (iArr[i8 + 1] >> 16);
                            cArr[2] = c9;
                            char c10 = (char) iArr[i8 + 1];
                            cArr[3] = c10;
                            d.f1663 = (c7 << 16) + c8;
                            d.f1666 = (c9 << 16) + c10;
                            d.m1895(iArr2);
                            for (int i10 = 0; i10 < 16; i10++) {
                                int i11 = d.f1663 ^ iArr2[i10];
                                d.f1663 = i11;
                                int iM1894 = d.m1894(i11) ^ d.f1666;
                                int i12 = d.f1663;
                                d.f1663 = iM1894;
                                d.f1666 = i12;
                            }
                            int i13 = d.f1663;
                            int i14 = d.f1666;
                            d.f1663 = i14;
                            d.f1666 = i13;
                            int i15 = i13 ^ iArr2[16];
                            d.f1666 = i15;
                            int i16 = i14 ^ iArr2[17];
                            d.f1663 = i16;
                            cArr[0] = (char) (i16 >>> 16);
                            cArr[1] = (char) i16;
                            cArr[2] = (char) (i15 >>> 16);
                            cArr[3] = (char) i15;
                            d.m1895(iArr2);
                            int i17 = d.f1665;
                            cArr2[i17 << 1] = cArr[0];
                            cArr2[(i17 << 1) + 1] = cArr[1];
                            cArr2[(i17 << 1) + 2] = cArr[2];
                            cArr2[(i17 << 1) + 3] = cArr[3];
                            d.f1665 = i17 + 2;
                        } else {
                            str = new String(cArr2, 0, i2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m1406(int i2, short s7, int i8, byte b8, int i9) {
            String string;
            synchronized (n.f2979) {
                try {
                    StringBuilder sb = new StringBuilder();
                    int i10 = f1181;
                    int i11 = i2 + i10;
                    int i12 = i11 == -1 ? 1 : 0;
                    if (i12 != 0) {
                        byte[] bArr = f1175;
                        i11 = bArr != null ? (byte) (bArr[f1180 + i8] + i10) : (short) (f1176[f1180 + i8] + i10);
                    }
                    if (i11 > 0) {
                        n.f2984 = ((i8 + i11) - 2) + f1180 + i12;
                        n.f2982 = b8;
                        char c7 = (char) (i9 + f1177);
                        n.f2981 = c7;
                        sb.append(c7);
                        n.f2980 = n.f2981;
                        n.f2983 = 1;
                        while (n.f2983 < i11) {
                            byte[] bArr2 = f1175;
                            if (bArr2 != null) {
                                int i13 = n.f2984;
                                n.f2984 = i13 - 1;
                                n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                            } else {
                                short[] sArr = f1176;
                                int i14 = n.f2984;
                                n.f2984 = i14 - 1;
                                n.f2981 = (char) (n.f2980 + (((short) (sArr[i14] + s7)) ^ n.f2982));
                            }
                            sb.append(n.f2981);
                            n.f2980 = n.f2981;
                            n.f2983++;
                        }
                    }
                    string = sb.toString();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return string;
        }

        public void onAdClicked() {
            f1179 = (f1174 + 25) % 128;
            by.this.m885(this, this.f1184, m1406(TextUtils.indexOf("", "", 0) - 90, (short) (TextUtils.indexOf((CharSequence) "", '0') + 1), Color.rgb(0, 0, 0) + 161719747, (byte) (Process.myPid() >> 22), 584027951 - Color.red(0)).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                f1179 = (f1174 + 13) % 128;
                videoAdListener.onAdClicked();
            }
        }

        public void onAdCustomEndCardFound() {
            f1174 = (f1179 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            by.this.m885(this, this.f1184, m1406((-90) - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (short) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 144942624 - TextUtils.indexOf("", ""), (byte) Color.red(0), 584027950 - TextUtils.indexOf((CharSequence) "", '0', 0)).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                f1179 = (f1174 + 13) % 128;
                videoAdListener.onAdCustomEndCardFound();
                f1179 = (f1174 + 1) % 128;
            }
        }

        public void onAdDidReachEnd() {
            f1174 = (f1179 + 21) % 128;
            by.this.m885(this, this.f1184, m1406((-91) - TextUtils.lastIndexOf("", '0'), (short) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), Color.green(0) + 144942558, (byte) ((-1) - MotionEvent.axisFromString("")), ((byte) KeyEvent.getModifierMetaStateMask()) + 584027952).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i2 = f1174 + 37;
                f1179 = i2 % 128;
                int i8 = i2 % 2;
                videoAdListener.onAdDidReachEnd();
                if (i8 != 0) {
                    throw null;
                }
            }
            int i9 = f1179 + 109;
            f1174 = i9 % 128;
            if (i9 % 2 == 0) {
                throw null;
            }
        }

        public void onAdDismissed() {
            f1174 = (f1179 + 73) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, -311394025, -1973429101, 576639838, -1173026891, -830317484, 2052191369, -2004309470, -833450549}, 29 - View.combineMeasuredStates(0, 0)).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                videoAdListener.onAdDismissed();
            }
            f1174 = (f1179 + 11) % 128;
        }

        public void onAdExpired() {
            f1179 = (f1174 + 39) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, -311394025, -1973429101, -1784051366, -1182277992, 1879770121, 1514650601}, TextUtils.getOffsetAfter("", 0) + 27).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                videoAdListener.onAdExpired();
                f1174 = (f1179 + 19) % 128;
            }
        }

        public void onAdLoadFail(PlayerInfo playerInfo) {
            f1174 = (f1179 + 115) % 128;
            by.this.m885(this, this.f1184, m1406((-90) - (ViewConfiguration.getWindowTouchSlop() >> 8), (short) (AndroidCharacter.getMirror('0') - '0'), Process.getGidForName("") + 144942477, (byte) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 584027951 - (KeyEvent.getMaxKeyCode() >> 16)).intern(), playerInfo);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                videoAdListener.onAdLoadFail(playerInfo);
                f1174 = (f1179 + 55) % 128;
            }
        }

        public void onAdLoadSuccess() {
            by.this.m885(this, this.f1184, m1406(View.combineMeasuredStates(0, 0) - 90, (short) (Process.myPid() >> 22), 144942445 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (byte) Drawable.resolveOpacity(0, 0), Color.alpha(0) + 584027951).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i2 = f1179 + 115;
                f1174 = i2 % 128;
                int i8 = i2 % 2;
                videoAdListener.onAdLoadSuccess();
                if (i8 == 0) {
                    throw null;
                }
            }
            int i9 = f1174 + 99;
            f1179 = i9 % 128;
            if (i9 % 2 != 0) {
                int i10 = 89 / 0;
            }
        }

        public void onAdSkipped() {
            f1174 = (f1179 + 69) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, -311394025, -1973429101, -2107819289, -716408852, 1250663745, 1072134780}, 27 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                videoAdListener.onAdSkipped();
            }
            int i2 = f1174 + 49;
            f1179 = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
        }

        public void onAdStarted() {
            f1179 = (f1174 + 77) % 128;
            by.this.m885(this, this.f1184, m1406((ViewConfiguration.getLongPressTimeout() >> 16) - 90, (short) TextUtils.getOffsetAfter("", 0), 144942503 - ExpandableListView.getPackedPositionChild(0L), (byte) (ViewConfiguration.getLongPressTimeout() >> 16), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 584027950).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                videoAdListener.onAdStarted();
                f1179 = (f1174 + 107) % 128;
            }
        }

        public void onCustomCTACLick(boolean z2) {
            f1179 = (f1174 + 97) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 1481075777, -31121084, -936772139, 317960317, 277504261, -1364773198, -245864811, -1626857594}, MotionEvent.axisFromString("") + 33).intern(), Boolean.valueOf(z2));
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i2 = f1174 + 97;
                f1179 = i2 % 128;
                int i8 = i2 % 2;
                videoAdListener.onCustomCTACLick(z2);
                if (i8 != 0) {
                    throw null;
                }
            }
        }

        public void onCustomCTALoadFail() {
            f1174 = (f1179 + 53) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 1481075777, -31121084, -936772139, 317960317, -1513806524, 2049809152, 1503611873, 1322356701, -327602717, -1218832200}, 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i2 = f1174 + 61;
                f1179 = i2 % 128;
                int i8 = i2 % 2;
                videoAdListener.onCustomCTALoadFail();
                if (i8 != 0) {
                    throw null;
                }
            }
            f1174 = (f1179 + 25) % 128;
        }

        public void onCustomCTAShow() {
            f1179 = (f1174 + 9) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 1481075777, -31121084, -936772139, 317960317, 98521060, -606364628, 1514241374, -1419997118}, 31 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                f1179 = (f1174 + 47) % 128;
                videoAdListener.onCustomCTAShow();
                f1174 = (f1179 + 53) % 128;
            }
        }

        public void onCustomEndCardClick(String str) {
            f1179 = (f1174 + 73) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 1481075777, -31121084, -936772139, 317960317, 1086086034, 1484446967, -649114445, 1408318090, -1257246111, 665678114}, 36 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), str);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                videoAdListener.onCustomEndCardClick(str);
                f1179 = (f1174 + 109) % 128;
            }
            f1179 = (f1174 + 99) % 128;
        }

        public void onCustomEndCardShow(String str) {
            f1179 = (f1174 + 57) % 128;
            by.this.m885(this, this.f1184, m1406(MotionEvent.axisFromString("") - 89, (short) (ViewConfiguration.getEdgeSlop() >> 16), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 144942588, (byte) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 584027952 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern(), str);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i2 = f1179 + 25;
                f1174 = i2 % 128;
                int i8 = i2 % 2;
                videoAdListener.onCustomEndCardShow(str);
                if (i8 == 0) {
                    throw null;
                }
            }
        }

        public void onDefaultEndCardClick(String str) {
            f1174 = (f1179 + 99) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 642414011, -84571454, 55182382, -1585862397, -1470890030, -792046111, -816336688, 903316208, -1794012682, -1081103121, 944161398, 1140352251}, TextUtils.lastIndexOf("", '0', 0) + 38).intern(), str);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i2 = f1179 + 29;
                f1174 = i2 % 128;
                int i8 = i2 % 2;
                videoAdListener.onDefaultEndCardClick(str);
                if (i8 == 0) {
                    int i9 = 18 / 0;
                }
            }
        }

        public void onDefaultEndCardShow(String str) {
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 642414011, -84571454, 55182382, -1585862397, -1470890030, -792046111, -816336688, 903316208, 2028638640, -41119860}, 36 - View.combineMeasuredStates(0, 0)).intern(), str);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i2 = f1174 + 35;
                f1179 = i2 % 128;
                int i8 = i2 % 2;
                videoAdListener.onDefaultEndCardShow(str);
                if (i8 != 0) {
                    throw null;
                }
                f1174 = (f1179 + 39) % 128;
            }
        }

        public void onEndCardClosed(Boolean bool) {
            f1179 = (f1174 + 9) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 860157695, -1198357486, -105724731, -1853711581, -2030937648, 242398801, -1734980099, -67523894}, 31 - Drawable.resolveOpacity(0, 0)).intern(), bool);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                f1174 = (f1179 + 23) % 128;
                videoAdListener.onEndCardClosed(bool);
            }
        }

        public void onEndCardLoadFail(Boolean bool) {
            f1174 = (f1179 + 27) % 128;
            by.this.m885(this, this.f1184, m1406((ViewConfiguration.getMaximumFlingVelocity() >> 16) - 90, (short) (AndroidCharacter.getMirror('0') - '0'), 144942662 - Color.argb(0, 0, 0, 0), (byte) TextUtils.indexOf("", "", 0, 0), 584027951 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern(), bool);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i2 = f1174 + 111;
                f1179 = i2 % 128;
                int i8 = i2 % 2;
                videoAdListener.onEndCardLoadFail(bool);
                if (i8 != 0) {
                    throw null;
                }
            }
            int i9 = f1174 + 11;
            f1179 = i9 % 128;
            if (i9 % 2 != 0) {
                throw null;
            }
        }

        public void onEndCardLoadSuccess(Boolean bool) {
            f1179 = (f1174 + 69) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 860157695, -1198357486, -105724731, -1853711581, -373644041, -65317717, 233485353, -987285495, -176438144, -1209930138}, TextUtils.indexOf("", "", 0) + 36).intern(), bool);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                videoAdListener.onEndCardLoadSuccess(bool);
                f1179 = (f1174 + 7) % 128;
            }
        }

        public void onEndCardSkipped(Boolean bool) {
            f1179 = (f1174 + 85) % 128;
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 860157695, -1198357486, -105724731, -1853711581, -259975133, 1575992382, -560016518, 1702034011}, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 32).intern(), bool);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                videoAdListener.onEndCardSkipped(bool);
            }
            f1174 = (f1179 + 23) % 128;
        }

        public void onLeaveApp() {
            int i2 = f1174 + 23;
            f1179 = i2 % 128;
            if (i2 % 2 != 0) {
                by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, -1843914197, -1837672131, -195958753, 1130398060, 2134748653, -374195594}, 16777242 / Color.rgb(0, 0, 1)).intern(), new Object[0]);
                if (this.f1183 == null) {
                    return;
                }
            } else {
                by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, -1843914197, -1837672131, -195958753, 1130398060, 2134748653, -374195594}, Color.rgb(0, 0, 0) + 16777242).intern(), new Object[0]);
                if (this.f1183 == null) {
                    return;
                }
            }
            this.f1183.onLeaveApp();
            f1179 = (f1174 + 11) % 128;
        }

        public void onReplay() {
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 768076836, 41723337, -834862812, 3325546}, View.getDefaultSize(0, 0) + 24).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                f1179 = (f1174 + 77) % 128;
                videoAdListener.onReplay();
                f1179 = (f1174 + 15) % 128;
            }
        }

        public void onReplayFinish() {
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, 768076836, 41723337, -834862812, 3325546, -581048736, 1490116252, 531412453, 452772307}, Drawable.resolveOpacity(0, 0) + 30).intern(), new Object[0]);
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i2 = f1174 + 57;
                f1179 = i2 % 128;
                int i8 = i2 % 2;
                videoAdListener.onReplayFinish();
                if (i8 != 0) {
                    throw null;
                }
            }
            int i9 = f1179 + 81;
            f1174 = i9 % 128;
            if (i9 % 2 == 0) {
                int i10 = 67 / 0;
            }
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.hc
        /* JADX INFO: renamed from: ｋ */
        public final /* synthetic */ VideoAdListener mo831() {
            int i2 = f1174 + 55;
            f1179 = i2 % 128;
            if (i2 % 2 != 0) {
                m1404();
                throw null;
            }
            VideoAdListener videoAdListenerM1404 = m1404();
            int i8 = f1179 + 49;
            f1174 = i8 % 128;
            if (i8 % 2 != 0) {
                return videoAdListenerM1404;
            }
            throw null;
        }

        public void onAdDismissed(int i2) {
            by.this.m885(this, this.f1184, m1405(new int[]{-1297565383, -915862706, -732466139, 9775678, -1385856802, 1528902865, -1538045529, -740434867, -311394025, -1973429101, 576639838, -1173026891, -830317484, 2052191369, -1325342318, -2015764093, -789547324, -710207421, -1660925095, -1705686337, 2139036112, 536337709}, 41 - Color.argb(0, 0, 0, 0)).intern(), Integer.valueOf(i2));
            VideoAdListener videoAdListener = this.f1183;
            if (videoAdListener != null) {
                int i8 = f1179 + 15;
                f1174 = i8 % 128;
                int i9 = i8 % 2;
                videoAdListener.onAdDismissed(i2);
                if (i9 == 0) {
                    throw null;
                }
            }
            int i10 = f1179 + 101;
            f1174 = i10 % 128;
            if (i10 % 2 == 0) {
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static String m1335(AdParams adParams) {
        f1135 = (f1134 + 61) % 128;
        String id = adParams.getId();
        int i2 = f1135 + 39;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 36 / 0;
        }
        return id;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ AdParams m1356(VideoAdController videoAdController) {
        f1135 = (f1134 + 47) % 128;
        AdParams adParamsM1391 = m1391(videoAdController);
        f1134 = (f1135 + 59) % 128;
        return adParamsM1391;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m1363(AdParams adParams) {
        f1134 = (f1135 + 45) % 128;
        String strM1343 = m1343(adParams);
        int i2 = f1134 + 37;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM1343;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ List m1372(AdParams adParams) {
        f1135 = (f1134 + 19) % 128;
        List<String> listM1330 = m1330(adParams);
        int i2 = f1135 + 25;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return listM1330;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1384(CreativeParams creativeParams) {
        int i2 = f1135 + 17;
        f1134 = i2 % 128;
        int i8 = i2 % 2;
        String strM1371 = m1371(creativeParams);
        if (i8 == 0) {
            int i9 = 5 / 0;
        }
        return strM1371;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m1397(AdParams adParams) {
        f1135 = (f1134 + 49) % 128;
        String strM1332 = m1332(adParams);
        f1135 = (f1134 + 37) % 128;
        return strM1332;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ AdData m1364(Ad ad, String str) {
        f1135 = (f1134 + 115) % 128;
        AdData adDataM1346 = m1346(ad, str);
        f1134 = (f1135 + 73) % 128;
        return adDataM1346;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ CompanionAds m1373(Creative creative) {
        f1134 = (f1135 + 63) % 128;
        CompanionAds companionAdsM1400 = m1400(creative);
        f1135 = (f1134 + 105) % 128;
        return companionAdsM1400;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1385(AdParams adParams) {
        f1135 = (f1134 + 57) % 128;
        String strM1335 = m1335(adParams);
        int i2 = f1135 + 51;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return strM1335;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ AdData m1399(Ad ad, String str) {
        f1135 = (f1134 + 65) % 128;
        AdData adDataM1387 = m1387(ad, str);
        f1135 = (f1134 + 9) % 128;
        return adDataM1387;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        int i2 = f1135 + 23;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            HyBid.getHyBidVersion();
            throw null;
        }
        String hyBidVersion = HyBid.getHyBidVersion();
        int i8 = f1134 + 101;
        f1135 = i8 % 128;
        if (i8 % 2 == 0) {
            return hyBidVersion;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static JSONObject m1357(Ad ad) {
        JSONObject json;
        int i2 = f1134 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f1135 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                json = ad.toJson();
                int i8 = 48 / 0;
            } else {
                json = ad.toJson();
            }
            f1134 = (f1135 + 61) % 128;
            return json;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ ClickThrough m1365(VideoClicks videoClicks) {
        f1135 = (f1134 + 61) % 128;
        ClickThrough clickThroughM1353 = m1353(videoClicks);
        int i2 = f1134 + 79;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return clickThroughM1353;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ Creatives m1374(VastAdSource vastAdSource) {
        f1134 = (f1135 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        Creatives creativesM1354 = m1354(vastAdSource);
        int i2 = f1135 + 59;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 17 / 0;
        }
        return creativesM1354;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ List m1386(VideoClicks videoClicks) {
        int i2 = f1135 + 1;
        f1134 = i2 % 128;
        int i8 = i2 % 2;
        List<ClickTracking> listM1398 = m1398(videoClicks);
        if (i8 == 0) {
            int i9 = 37 / 0;
        }
        return listM1398;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ Creatives m1402(InLine inLine) {
        int i2 = f1134 + 89;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1389(inLine);
        }
        m1389(inLine);
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ Creatives m1366(Wrapper wrapper) {
        f1134 = (f1135 + 57) % 128;
        Creatives creativesM1390 = m1390(wrapper);
        f1135 = (f1134 + 7) % 128;
        return creativesM1390;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ VASTAdTagURI m1375(Wrapper wrapper) {
        f1134 = (f1135 + 13) % 128;
        VASTAdTagURI vASTAdTagURIM1355 = m1355(wrapper);
        int i2 = f1134 + 9;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return vASTAdTagURIM1355;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ CompanionClickThrough m1388(Companion companion) {
        f1134 = (f1135 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        CompanionClickThrough companionClickThroughM1401 = m1401(companion);
        int i2 = f1134 + 33;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return companionClickThroughM1401;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean m1403(VideoAd videoAd) {
        f1135 = (f1134 + 115) % 128;
        boolean zIsRewarded = videoAd.isRewarded();
        f1135 = (f1134 + 3) % 128;
        return zIsRewarded;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ JSONObject m1367(Ad ad) {
        f1135 = (f1134 + 65) % 128;
        JSONObject jSONObjectM1357 = m1357(ad);
        f1135 = (f1134 + 19) % 128;
        return jSONObjectM1357;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m1376(VideoAd videoAd, VideoAdListener videoAdListener) {
        f1134 = (f1135 + 97) % 128;
        m1392(videoAd, videoAdListener);
        f1135 = (f1134 + 17) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1394(AdData adData) {
        f1134 = (f1135 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        String html = adData.getHtml();
        int i2 = f1135 + 49;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return html;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1380((char) (ViewConfiguration.getTapTimeout() >> 16), TextUtils.indexOf("", "", 0, 0) + 11, (ViewConfiguration.getJumpTapTimeout() >> 16) + 1632).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1341();
            }
        });
        map.put(m1380((char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 56518), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 18, View.MeasureSpec.makeMeasureSpec(0, 0) + 1643).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.15
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Boolean.valueOf(by.m1377((VideoAd) list.get(0)));
            }
        });
        map.put(m1380((char) (Color.blue(0) + 20828), 17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 1661 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.24
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                by.m1376((VideoAd) list.get(0), (VideoAdListener) list.get(1));
                return null;
            }
        });
        map.put(m1380((char) (ExpandableListView.getPackedPositionChild(0L) + 53934), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 8, KeyEvent.normalizeMetaState(0) + 1678).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.34
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1367((Ad) list.get(0));
            }
        });
        map.put(m1380((char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 48070), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 15, 1687 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.33
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1368((Ad) list.get(0));
            }
        });
        map.put(m1380((char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 10 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 1702 - Color.alpha(0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.32
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1381((Ad) list.get(0));
            }
        });
        map.put(m1380((char) (Color.alpha(0) + 34535), TextUtils.getOffsetBefore("", 0) + 11, AndroidCharacter.getMirror('0') + 1663).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.40
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1393((Ad) list.get(0));
            }
        });
        map.put(m1380((char) (6042 - KeyEvent.normalizeMetaState(0)), (ViewConfiguration.getEdgeSlop() >> 16) + 9, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + IronSourceConstants.errorCode_TEST_SUITE_SDK_NOT_INITIALIZED).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.39
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1399((Ad) list.get(0), (String) list.get(1));
            }
        });
        map.put(m1380((char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 14493), View.MeasureSpec.makeMeasureSpec(0, 0) + 10, MotionEvent.axisFromString("") + 1732).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.36
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1364((Ad) list.get(0), (String) list.get(1));
            }
        });
        map.put(m1380((char) Drawable.resolveOpacity(0, 0), TextUtils.indexOf("", "", 0, 0) + 12, KeyEvent.getDeadChar(0, 0) + 1741).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1352((Ad) list.get(0), (String) list.get(1));
            }
        });
        map.put(m1380((char) KeyEvent.normalizeMetaState(0), (-16777203) - Color.rgb(0, 0, 0), 1753 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1369((Ad) list.get(0), (String) list.get(1));
            }
        });
        map.put(m1380((char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 13 - (Process.myTid() >> 22), 1766 - View.resolveSizeAndState(0, 0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1358((AdData) list.get(0));
            }
        });
        map.put(m1380((char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), TextUtils.indexOf("", "", 0) + 11, View.getDefaultSize(0, 0) + 1779).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1382((AdData) list.get(0));
            }
        });
        map.put(m1380((char) View.combineMeasuredStates(0, 0), 11 - TextUtils.indexOf((CharSequence) "", '0', 0), 1789 - TextUtils.indexOf((CharSequence) "", '0', 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.8
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1370((AdData) list.get(0));
            }
        });
        map.put(m1380((char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), Color.green(0) + 20, Gravity.getAbsoluteGravity(0, 0) + 1802).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.10
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1359((AdData) list.get(0), (String) list.get(1));
            }
        });
        map.put(m1380((char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 51744), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 23, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1822).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.6
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1378(by.this, (VideoAdListener) list.get(0), chVar);
            }
        });
        map.put(m1380((char) (8884 - TextUtils.indexOf("", "", 0, 0)), 16 - ExpandableListView.getPackedPositionChild(0L), 1846 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.9
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1363((AdParams) list.get(0));
            }
        });
        map.put(m1380((char) (28095 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), 13 - (ViewConfiguration.getEdgeSlop() >> 16), 1862 - TextUtils.indexOf("", "", 0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.7
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1385((AdParams) list.get(0));
            }
        });
        map.put(m1380((char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 27, 1875 - (ViewConfiguration.getFadingEdgeLength() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.11
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1351((AdParams) list.get(0));
            }
        });
        map.put(m1380((char) View.MeasureSpec.getSize(0), 29 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1902 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.14
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1397((AdParams) list.get(0));
            }
        });
        map.put(m1380((char) (ViewConfiguration.getTouchSlop() >> 8), 22 - Color.blue(0), 1931 - TextUtils.getTrimmedLength("")).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.13
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1372((AdParams) list.get(0));
            }
        });
        map.put(m1380((char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 24, (ViewConfiguration.getEdgeSlop() >> 16) + 1953).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.12
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1345((AdParams) list.get(0));
            }
        });
        map.put(m1380((char) (39837 - View.MeasureSpec.getSize(0)), 28 - TextUtils.getTrimmedLength(""), TextUtils.lastIndexOf("", '0', 0, 0) + 1978).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.18
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1340((AdParams) list.get(0));
            }
        });
        map.put(m1380((char) ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getLongPressTimeout() >> 16) + 25, 2006 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.19
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1338((AdParams) list.get(0));
            }
        });
        map.put(m1380((char) (ImageFormat.getBitsPerPixel(0) + 63576), ((Process.getThreadPriority(0) + 20) >> 6) + 11, 2030 - (ViewConfiguration.getPressedStateDuration() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.16
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1356((VideoAdController) list.get(0));
            }
        });
        map.put(m1380((char) Color.green(0), 26 - (ViewConfiguration.getPressedStateDuration() >> 16), MotionEvent.axisFromString("") + 2042).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.20
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1365((VideoClicks) list.get(0));
            }
        });
        map.put(m1380((char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 60790), TextUtils.indexOf("", "", 0) + 31, ExpandableListView.getPackedPositionType(0L) + 2067).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.17
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1386((VideoClicks) list.get(0));
            }
        });
        map.put(m1380((char) (31338 - TextUtils.lastIndexOf("", '0', 0)), ((Process.getThreadPriority(0) + 20) >> 6) + 24, 2098 - View.MeasureSpec.makeMeasureSpec(0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.23
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1388((Companion) list.get(0));
            }
        });
        map.put(m1380((char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 52480), 23 - (ViewConfiguration.getPressedStateDuration() >> 16), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2121).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.21
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1373((Creative) list.get(0));
            }
        });
        map.put(m1380((char) (9654 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), 18 - (Process.myPid() >> 22), TextUtils.indexOf("", "") + 2145).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.22
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1402((InLine) list.get(0));
            }
        });
        map.put(m1380((char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), TextUtils.lastIndexOf("", '0', 0, 0) + 25, KeyEvent.keyCodeFromString("") + 2163).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.25
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1374((VastAdSource) list.get(0));
            }
        });
        map.put(m1380((char) ((-16744669) - Color.rgb(0, 0, 0)), 16 - View.MeasureSpec.makeMeasureSpec(0, 0), 2187 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.26
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1395((MediaFile) list.get(0));
            }
        });
        map.put(m1380((char) ((ViewConfiguration.getEdgeSlop() >> 16) + 54593), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 20, TextUtils.indexOf("", "", 0, 0) + G9.a.f6841c).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.27
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1349((StaticResource) list.get(0));
            }
        });
        map.put(m1380((char) Color.green(0), 29 - (ViewConfiguration.getPressedStateDuration() >> 16), 2224 - Color.argb(0, 0, 0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.28
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1396((StaticResource) list.get(0));
            }
        });
        map.put(m1380((char) Gravity.getAbsoluteGravity(0, 0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 19, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2253).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.29
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1366((Wrapper) list.get(0));
            }
        });
        map.put(m1380((char) (ViewConfiguration.getTouchSlop() >> 8), (ViewConfiguration.getFadingEdgeLength() >> 16) + 22, (ViewConfiguration.getScrollBarSize() >> 8) + 2272).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.30
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1375((Wrapper) list.get(0));
            }
        });
        map.put(m1380((char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 29, KeyEvent.keyCodeFromString("") + 2294).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.35
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1384((CreativeParams) list.get(0));
            }
        });
        map.put(m1380((char) (TextUtils.lastIndexOf("", '0', 0) + 1), 32 - Gravity.getAbsoluteGravity(0, 0), 2323 - (ViewConfiguration.getWindowTouchSlop() >> 8)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.by.31
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return by.m1362((CreativeParams) list.get(0));
            }
        });
        f1134 = (f1135 + 47) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ boolean m1377(VideoAd videoAd) {
        int i2 = f1135 + 31;
        f1134 = i2 % 128;
        int i8 = i2 % 2;
        boolean zM1403 = m1403(videoAd);
        if (i8 == 0) {
            int i9 = 75 / 0;
        }
        return zM1403;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static List<ClickTracking> m1398(VideoClicks videoClicks) {
        f1134 = (f1135 + 49) % 128;
        List<ClickTracking> clickTrackingList = videoClicks.getClickTrackingList();
        f1134 = (f1135 + 45) % 128;
        return clickTrackingList;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo826(String str) {
        switch (str.hashCode()) {
            case -2115104349:
                if (str.equals(m1380((char) (View.combineMeasuredStates(0, 0) + 23001), 11 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 1264 - TextUtils.getOffsetAfter("", 0)).intern())) {
                    return VideoAdView.class;
                }
                return null;
            case -2101083431:
                if (str.equals(m1380((char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 57976), KeyEvent.normalizeMetaState(0) + 6, 1545 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))).intern())) {
                    return InLine.class;
                }
                return null;
            case -2095699225:
                if (str.equals(m1380((char) (TextUtils.indexOf((CharSequence) "", '0') + 24852), Color.red(0) + 24, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 642).intern())) {
                    return VastInterstitialActivity.class;
                }
                return null;
            case -2049897434:
                if (str.equals(m1380((char) KeyEvent.keyCodeFromString(""), (ViewConfiguration.getJumpTapTimeout() >> 16) + 11, KeyEvent.getDeadChar(0, 0) + 1427).intern())) {
                    return VideoClicks.class;
                }
                return null;
            case -2030915791:
                if (str.equals(m1380((char) ExpandableListView.getPackedPositionGroup(0L), 61 - (ViewConfiguration.getLongPressTimeout() >> 16), 1031 - ExpandableListView.getPackedPositionType(0L)).intern())) {
                    return VastRewardedActivity.class;
                }
                return null;
            case -2022878658:
                if (str.equals(m1380((char) (7369 - ((Process.getThreadPriority(0) + 20) >> 6)), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 14, 45 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern())) {
                    return RequestManager.class;
                }
                return null;
            case -1973009238:
                if (!str.equals(m1380((char) (64135 - TextUtils.lastIndexOf("", '0')), 13 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 1550 - View.MeasureSpec.makeMeasureSpec(0, 0)).intern())) {
                    return null;
                }
                int i2 = f1135 + 47;
                f1134 = i2 % 128;
                if (i2 % 2 == 0) {
                    return PNAPIContentInfoView.class;
                }
                return VastAdSource.class;
            case -1867123455:
                if (str.equals(m1380((char) (39420 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (ViewConfiguration.getTapTimeout() >> 16) + 62, 948 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))).intern())) {
                    return HyBidRewardedActivity.class;
                }
                return null;
            case -1758764491:
                if (!str.equals(m1380((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (-16777202) - Color.rgb(0, 0, 0), 1619 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern())) {
                    return null;
                }
                f1135 = (f1134 + 83) % 128;
                return CreativeParams.class;
            case -1741983831:
                if (str.equals(m1380((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 8 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 1384 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern())) {
                    return AdParams.class;
                }
                return null;
            case -1692490108:
                if (str.equals(m1380((char) (44151 - TextUtils.getOffsetBefore("", 0)), 9 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1535).intern())) {
                    return Creatives.class;
                }
                return null;
            case -1668741680:
                if (str.equals(m1380((char) (ExpandableListView.getPackedPositionGroup(0L) + 64029), 25 - Color.alpha(0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 358).intern())) {
                    return VastInterstitialPresenter.class;
                }
                return null;
            case -1474059205:
                if (str.equals(m1380((char) ((ViewConfiguration.getEdgeSlop() >> 16) + 4377), 10 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getJumpTapTimeout() >> 16) + 1233).intern())) {
                    return PNWebView.class;
                }
                return null;
            case -1454339106:
                if (str.equals(m1380((char) (40660 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), 32 - Color.red(0), MotionEvent.axisFromString("") + 228).intern())) {
                    return HyBidInterstitialBroadcastSender.class;
                }
                return null;
            case -1305745411:
                if (str.equals(m1380((char) View.MeasureSpec.getMode(0), Color.rgb(0, 0, 0) + 16777231, (ViewConfiguration.getFadingEdgeLength() >> 16) + 804).intern())) {
                    return HyBidRewardedAd.class;
                }
                return null;
            case -1042733280:
                if (str.equals(m1380((char) ((ViewConfiguration.getScrollBarSize() >> 8) + 32664), 15 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 58 - TextUtils.getCapsMode("", 0, 0)).intern())) {
                    return AdSourceConfig.class;
                }
                return null;
            case -1040143378:
                if (str.equals(m1380((char) (View.MeasureSpec.getMode(0) + 58123), (-16777200) - Color.rgb(0, 0, 0), TextUtils.lastIndexOf("", '0') + Sdk.SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE).intern())) {
                    return MraidAdPresenter.class;
                }
                return null;
            case -1034806157:
                if (str.equals(m1380((char) (KeyEvent.getMaxKeyCode() >> 16), 7 - (ViewConfiguration.getTouchSlop() >> 8), 1600 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern())) {
                    return Wrapper.class;
                }
                return null;
            case -1007287447:
                if (str.equals(m1380((char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), ImageFormat.getBitsPerPixel(0) + 22, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1010).intern())) {
                    return HyBidRewardedActivity.class;
                }
                return null;
            case -917597044:
                if (str.equals(m1380((char) (59932 - TextUtils.lastIndexOf("", '0', 0, 0)), 69 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 479).intern())) {
                    return MraidInterstitialActivity.class;
                }
                return null;
            case -889171374:
                if (str.equals(m1380((char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), 24 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 549 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern())) {
                    return MraidInterstitialActivity.class;
                }
                return null;
            case -844922724:
                if (str.equals(m1380((char) (TextUtils.getOffsetBefore("", 0) + 36154), 9 - Color.red(0), 732 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern())) {
                    return MRAIDView.class;
                }
                return null;
            case -801627293:
                if (!str.equals(m1380((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), Color.alpha(0) + 11, 756 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern())) {
                    return null;
                }
                int i8 = f1135 + 89;
                f1134 = i8 % 128;
                if (i8 % 2 == 0) {
                    return InterstitialPresenterDecorator.class;
                }
                return MRAIDBanner.class;
            case -747024196:
                if (!str.equals(m1380((char) (45371 - KeyEvent.keyCodeFromString("")), 28 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 849 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)).intern())) {
                    return null;
                }
                int i9 = f1134 + 13;
                f1135 = i9 % 128;
                if (i9 % 2 != 0) {
                    return null;
                }
                return HyBidRewardedBroadcastSender.class;
            case -729230458:
                if (str.equals(m1380((char) (55134 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 13, 1274 - TextUtils.lastIndexOf("", '0', 0)).intern())) {
                    return VastProcessor.class;
                }
                return null;
            case -709708726:
                if (str.equals(m1380((char) TextUtils.getOffsetBefore("", 0), View.combineMeasuredStates(0, 0) + 13, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 72).intern())) {
                    return HyBidAdSource.class;
                }
                return null;
            case -617879491:
                if (str.equals(m1380((char) (TextUtils.indexOf((CharSequence) "", '0') + 14489), 11 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 1438 - TextUtils.getCapsMode("", 0, 0)).intern())) {
                    return ClickThrough.class;
                }
                return null;
            case -594285390:
                if (!str.equals(m1380((char) TextUtils.indexOf("", "", 0), AndroidCharacter.getMirror('0') - '!', Color.rgb(0, 0, 0) + 16778465).intern())) {
                    return null;
                }
                int i10 = f1135 + 95;
                f1134 = i10 % 128;
                if (i10 % 2 != 0) {
                    return VideoAdListener.class;
                }
                return AdSourceConfig.class;
            case -589715152:
                if (str.equals(m1380((char) ((-1) - ImageFormat.getBitsPerPixel(0)), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 20, 1186 - TextUtils.getOffsetAfter("", 0)).intern())) {
                    return PNAPIContentInfoView.class;
                }
                return null;
            case -587420703:
                if (str.equals(m1380((char) (63764 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), TextUtils.lastIndexOf("", '0') + 13, TextUtils.indexOf("", "", 0, 0) + 1606).intern())) {
                    return VASTAdTagURI.class;
                }
                return null;
            case -567645543:
                if (str.equals(m1380((char) (ImageFormat.getBitsPerPixel(0) + 1), 22 - TextUtils.indexOf("", "", 0), 1148 - View.resolveSizeAndState(0, 0, 0)).intern())) {
                    return HyBidLeaderboardAdView.class;
                }
                return null;
            case -520974940:
                if (str.equals(m1380((char) ExpandableListView.getPackedPositionGroup(0L), 10 - (Process.myTid() >> 22), 680 - TextUtils.indexOf("", "", 0)).intern())) {
                    return AdResponse.class;
                }
                return null;
            case -514201671:
                if (str.equals(m1380((char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 55020), 15 - Gravity.getAbsoluteGravity(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0) + 145).intern())) {
                    return VastAdPresenter.class;
                }
                return null;
            case -385055469:
                if (!str.equals(m1380((char) (13255 - View.MeasureSpec.getSize(0)), Drawable.resolveOpacity(0, 0) + 10, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1571).intern())) {
                    return null;
                }
                int i11 = f1135 + 57;
                f1134 = i11 % 128;
                if (i11 % 2 == 0) {
                    return HyBidRewardedAd.Listener.class;
                }
                return MediaFiles.class;
            case -348198615:
                if (str.equals(m1380((char) (38793 - TextUtils.getOffsetBefore("", 0)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 21, 1484 - KeyEvent.normalizeMetaState(0)).intern())) {
                    return CompanionClickThrough.class;
                }
                return null;
            case -242952691:
                if (str.equals(m1380((char) KeyEvent.keyCodeFromString(""), 16 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 260).intern())) {
                    return PNInterstitialAd.class;
                }
                return null;
            case -232966702:
                if (!str.equals(m1380((char) (23049 - TextUtils.indexOf("", "")), TextUtils.getTrimmedLength("") + 15, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 691).intern())) {
                    return null;
                }
                f1135 = (f1134 + 95) % 128;
                return AdvertisingInfo.class;
            case -217201711:
                if (str.equals(m1380((char) (59463 - Color.argb(0, 0, 0, 0)), 23 - View.MeasureSpec.getMode(0), 1325 - (ViewConfiguration.getTapTimeout() >> 16)).intern())) {
                    return HyBidRewardedAd.Listener.class;
                }
                return null;
            case -205981873:
                if (str.equals(m1380((char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 11, 1288 - Color.blue(0)).intern())) {
                    return PlayerInfo.class;
                }
                return null;
            case -150968480:
                if (str.equals(m1380((char) Drawable.resolveOpacity(0, 0), 8 - ((byte) KeyEvent.getModifierMetaStateMask()), 1562 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)).intern())) {
                    return MediaFile.class;
                }
                return null;
            case -133293208:
                if (str.equals(m1380((char) (15822 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), 18 - TextUtils.indexOf((CharSequence) "", '0'), 1348 - ExpandableListView.getPackedPositionGroup(0L)).intern())) {
                    return HyBidAdView.Listener.class;
                }
                return null;
            case -114588646:
                if (str.equals(m1380((char) (40621 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 16, 1410 - (Process.myPid() >> 22)).intern())) {
                    return VideoAdController.class;
                }
                return null;
            case 2115:
                if (str.equals(m1380((char) ((-1) - TextUtils.lastIndexOf("", '0')), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 2, 667 - (ViewConfiguration.getKeyRepeatDelay() >> 16)).intern())) {
                    return Ad.class;
                }
                return null;
            case 2658924:
                if (str.equals(m1380((char) ((ViewConfiguration.getTouchSlop() >> 8) + 13194), 4 - (ViewConfiguration.getTapTimeout() >> 16), 1595 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern())) {
                    return Vast.class;
                }
                return null;
            case 22955995:
                if (str.equals(m1380((char) (418 - Color.red(0)), ExpandableListView.getPackedPositionGroup(0L) + 13, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1219).intern())) {
                    return PNMRectAdView.class;
                }
                return null;
            case 63078110:
                if (str.equals(m1380((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), 5 - (ViewConfiguration.getFadingEdgeLength() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 676).intern())) {
                    return AdExt.class;
                }
                return null;
            case 70165004:
                if (str.equals(m1380((char) (ImageFormat.getBitsPerPixel(0) + 60250), 5 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), View.MeasureSpec.getSize(0)).intern())) {
                    return HyBid.class;
                }
                return null;
            case 152629510:
                if (str.equals(m1380((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getTouchSlop() >> 8) + 8, 1112 - TextUtils.getTrimmedLength("")).intern())) {
                    return PNAdView.class;
                }
                return null;
            case 254077974:
                if (str.equals(m1380((char) Color.red(0), Gravity.getAbsoluteGravity(0, 0) + 20, Color.alpha(0) + 768).intern())) {
                    return AdPresenterDecorator.class;
                }
                return null;
            case 271735736:
                if (str.equals(m1380((char) (6636 - TextUtils.indexOf("", "", 0, 0)), (ViewConfiguration.getLongPressTimeout() >> 16) + 15, 12 - View.resolveSize(0, 0)).intern())) {
                    return UserDataManager.class;
                }
                return null;
            case 282218207:
                if (str.equals(m1380((char) TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 30, TextUtils.lastIndexOf("", '0', 0) + 276).intern())) {
                    return InterstitialPresenterDecorator.class;
                }
                return null;
            case 287435653:
                if (str.equals(m1380((char) (55895 - Color.green(0)), Color.red(0) + 14, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 160).intern())) {
                    return BrowserManager.class;
                }
                return null;
            case 353872196:
                if (str.equals(m1380((char) TextUtils.indexOf("", "", 0, 0), 17 - Drawable.resolveOpacity(0, 0), Color.argb(0, 0, 0, 0) + 27).intern())) {
                    return ImpressionManager.class;
                }
                return null;
            case 378666444:
                if (str.equals(m1380((char) (56171 - Process.getGidForName("")), 15 - TextUtils.getCapsMode("", 0, 0), 85 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern())) {
                    return VastTagAdSource.class;
                }
                return null;
            case 424904237:
                if (str.equals(m1380((char) (KeyEvent.keyCodeFromString("") + 52192), 18 - Drawable.resolveOpacity(0, 0), 1392 - TextUtils.getOffsetBefore("", 0)).intern())) {
                    return ViewControllerVast.class;
                }
                return null;
            case 441957133:
                if (str.equals(m1380((char) View.MeasureSpec.getMode(0), 16 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), Process.getGidForName("") + 1171).intern())) {
                    return HyBidMRectAdView.class;
                }
                return null;
            case 476474561:
                if (str.equals(m1380((char) (61346 - View.MeasureSpec.getSize(0)), View.MeasureSpec.makeMeasureSpec(0, 0) + 70, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 384).intern())) {
                    return HyBidInterstitialActivity.class;
                }
                return null;
            case 482776408:
                if (str.equals(m1380((char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 34 - (ViewConfiguration.getJumpTapTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 194).intern())) {
                    return HyBidInterstitialBroadcastReceiver.class;
                }
                return null;
            case 485976319:
                if (str.equals(m1380((char) (Process.getGidForName("") + 57142), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 7, TextUtils.getOffsetAfter("", 0) + 5).intern())) {
                    return AdCache.class;
                }
                return null;
            case 504900231:
                if (str.equals(m1380((char) (ViewConfiguration.getFadingEdgeLength() >> 16), 25 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 453 - TextUtils.indexOf((CharSequence) "", '0')).intern())) {
                    return HyBidInterstitialActivity.class;
                }
                return null;
            case 591135468:
                if (str.equals(m1380((char) (Process.myTid() >> 22), 9 - TextUtils.getOffsetBefore("", 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1462).intern())) {
                    return Companion.class;
                }
                return null;
            case 606183598:
                if (str.equals(m1380((char) (22195 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 27, 304 - ((byte) KeyEvent.getModifierMetaStateMask())).intern())) {
                    return InterstitialPresenterFactory.class;
                }
                return null;
            case 676623548:
                if (str.equals(m1380((char) (24248 - KeyEvent.keyCodeFromString("")), 14 - Color.alpha(0), 1581 - View.resolveSizeAndState(0, 0, 0)).intern())) {
                    return StaticResource.class;
                }
                return null;
            case 767767497:
                if (str.equals(m1380((char) (40140 - (Process.myPid() >> 22)), AndroidCharacter.getMirror('0') - 28, Color.green(0) + 1092).intern())) {
                    return VastRewardedActivity.class;
                }
                return null;
            case 789926062:
                if (str.equals(m1380((char) (24521 - TextUtils.getOffsetAfter("", 0)), 22 - Color.green(0), 107 - View.MeasureSpec.getSize(0)).intern())) {
                    return BannerPresenterFactory.class;
                }
                return null;
            case 862687632:
                if (str.equals(m1380((char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 48119), (KeyEvent.getMaxKeyCode() >> 16) + 24, View.resolveSizeAndState(0, 0, 0) + TypedValues.Custom.TYPE_STRING).intern())) {
                    return RewardedPresenterFactory.class;
                }
                return null;
            case 956069326:
                if (str.equals(m1380((char) ((KeyEvent.getMaxKeyCode() >> 16) + 17285), KeyEvent.keyCodeFromString("") + 7, 724 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern())) {
                    return VASTtag.class;
                }
                return null;
            case 1002796579:
                if (str.equals(m1380((char) (ViewConfiguration.getDoubleTapTimeout() >> 16), TextUtils.indexOf("", "", 0, 0) + 7, 100 - ExpandableListView.getPackedPositionGroup(0L)).intern())) {
                    return Auction.class;
                }
                return null;
            case 1044987291:
                if (str.equals(m1380((char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), TextUtils.lastIndexOf("", '0', 0, 0) + 20, 173 - ((byte) KeyEvent.getModifierMetaStateMask())).intern())) {
                    return HyBidInterstitialAd.class;
                }
                return null;
            case 1150879268:
                if (str.equals(m1380((char) (TextUtils.indexOf((CharSequence) "", '0') + 46847), (ViewConfiguration.getScrollBarSize() >> 8) + 12, 1471 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern())) {
                    return CompanionAds.class;
                }
                return null;
            case 1164559907:
                if (str.equals(m1380((char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 17 - TextUtils.getOffsetBefore("", 0), 740 - (ViewConfiguration.getFadingEdgeLength() >> 16)).intern())) {
                    return MRAIDInterstitial.class;
                }
                return null;
            case 1199380782:
                if (str.equals(m1380((char) Color.alpha(0), (Process.myTid() >> 22) + 21, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 926).intern())) {
                    return VastRewardedPresenter.class;
                }
                return null;
            case 1228519789:
                if (str.equals(m1380((char) View.resolveSizeAndState(0, 0, 0), 69 - TextUtils.indexOf("", "", 0, 0), 574 - (ViewConfiguration.getKeyRepeatDelay() >> 16)).intern())) {
                    return VastInterstitialActivity.class;
                }
                return null;
            case 1241891335:
                if (!str.equals(m1380((char) (KeyEvent.keyCodeFromString("") + 59510), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 18, TextUtils.getOffsetBefore("", 0) + 705).intern())) {
                    return null;
                }
                f1135 = (f1134 + 17) % 128;
                return RemoteConfigAppInfo.class;
            case 1250739860:
                if (!str.equals(m1380((char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 11 - KeyEvent.keyCodeFromString(""), Color.alpha(0) + 1120).intern())) {
                    return null;
                }
                int i12 = f1135 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
                f1134 = i12 % 128;
                if (i12 % 2 == 0) {
                    return null;
                }
                return HyBidAdView.class;
            case 1296210799:
                if (str.equals(m1380((char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), View.MeasureSpec.getMode(0) + 27, 1298 - Drawable.resolveOpacity(0, 0)).intern())) {
                    return HyBidInterstitialAd.Listener.class;
                }
                return null;
            case 1373883333:
                if (!str.equals(m1380((char) TextUtils.indexOf("", "", 0), TextUtils.getOffsetBefore("", 0) + 26, (ViewConfiguration.getEdgeSlop() >> 16) + 333).intern())) {
                    return null;
                }
                int i13 = f1134 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                f1135 = i13 % 128;
                if (i13 % 2 == 0) {
                    return MraidInterstitialPresenter.class;
                }
                return HyBidAdView.class;
            case 1402445010:
                if (str.equals(m1380((char) (ViewConfiguration.getTapTimeout() >> 16), TextUtils.lastIndexOf("", '0') + 15, 1206 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))).intern())) {
                    return PNBannerAdView.class;
                }
                return null;
            case 1506578400:
                if (str.equals(m1380((char) (27669 - KeyEvent.normalizeMetaState(0)), 17 - (Process.myPid() >> 22), TextUtils.indexOf((CharSequence) "", '0', 0) + 1132).intern())) {
                    return HyBidBannerAdView.class;
                }
                return null;
            case 1521679714:
                if (str.equals(m1380((char) Color.blue(0), 16 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 788).intern())) {
                    return PresenterFactory.class;
                }
                return null;
            case 1607572150:
                if (str.equals(m1380((char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0)), (KeyEvent.getMaxKeyCode() >> 16) + 30, 818 - TextUtils.lastIndexOf("", '0')).intern())) {
                    return HyBidRewardedBroadcastReceiver.class;
                }
                return null;
            case 1877773523:
                if (str.equals(m1380((char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), 21 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 1504 - TextUtils.lastIndexOf("", '0', 0)).intern())) {
                    return CompanionClickTracking.class;
                }
                return null;
            case 1885066191:
                if (str.equals(m1380((char) Gravity.getAbsoluteGravity(0, 0), 8 - Color.alpha(0), 1527 - (Process.myPid() >> 22)).intern())) {
                    return Creative.class;
                }
                return null;
            case 1955369613:
                if (str.equals(m1380((char) (TextUtils.lastIndexOf("", '0', 0, 0) + 12954), 6 - (ViewConfiguration.getJumpTapTimeout() >> 16), Process.getGidForName("") + 670).intern())) {
                    return AdData.class;
                }
                return null;
            case 1969459009:
                if (str.equals(m1380((char) (Process.myPid() >> 22), 25 - TextUtils.lastIndexOf("", '0', 0), 877 - View.MeasureSpec.getMode(0)).intern())) {
                    return RewardedPresenterDecorator.class;
                }
                return null;
            case 2079062148:
                if (str.equals(m1380((char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 20645), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 17, 1367 - (ViewConfiguration.getTouchSlop() >> 8)).intern())) {
                    return e.class;
                }
                return null;
            case 2107600959:
                if (str.equals(m1380((char) (61896 - TextUtils.indexOf("", "")), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 13, 1450 - (ViewConfiguration.getLongPressTimeout() >> 16)).intern())) {
                    return ClickTracking.class;
                }
                return null;
            case 2117435870:
                if (str.equals(m1380((char) TextUtils.indexOf("", "", 0, 0), (KeyEvent.getMaxKeyCode() >> 16) + 7, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1242).intern())) {
                    return VideoAd.class;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1371(CreativeParams creativeParams) {
        int i2 = f1135 + 79;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            creativeParams.getCreativeData();
            throw null;
        }
        String creativeData = creativeParams.getCreativeData();
        int i8 = f1135 + 59;
        f1134 = i8 % 128;
        if (i8 % 2 != 0) {
            return creativeData;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static CompanionClickThrough m1401(Companion companion) {
        f1134 = (f1135 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        CompanionClickThrough companionClickThrough = companion.getCompanionClickThrough();
        f1135 = (f1134 + 109) % 128;
        return companionClickThrough;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1347(AdData adData) {
        int i2 = f1134 + 61;
        f1135 = i2 % 128;
        if (i2 % 2 != 0) {
            adData.getJS();
            throw null;
        }
        String js = adData.getJS();
        int i8 = f1134 + 27;
        f1135 = i8 % 128;
        if (i8 % 2 == 0) {
            return js;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static CompanionAds m1400(Creative creative) {
        f1135 = (f1134 + 39) % 128;
        CompanionAds companionAds = creative.getCompanionAds();
        f1134 = (f1135 + 109) % 128;
        return companionAds;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1348(AdData adData, String str) {
        f1135 = (f1134 + 83) % 128;
        String stringField = adData.getStringField(str);
        int i2 = f1134 + 19;
        f1135 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 19 / 0;
        }
        return stringField;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static ClickThrough m1353(VideoClicks videoClicks) {
        f1134 = (f1135 + 93) % 128;
        ClickThrough clickThrough = videoClicks.getClickThrough();
        int i2 = f1134 + 29;
        f1135 = i2 % 128;
        if (i2 % 2 == 0) {
            return clickThrough;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static Creatives m1354(VastAdSource vastAdSource) {
        f1135 = (f1134 + 59) % 128;
        Creatives creatives = vastAdSource.getCreatives();
        f1135 = (f1134 + 61) % 128;
        return creatives;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static VASTAdTagURI m1355(Wrapper wrapper) {
        int i2 = f1135 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f1134 = i2 % 128;
        if (i2 % 2 == 0) {
            wrapper.getVastAdTagURI();
            throw null;
        }
        VASTAdTagURI vastAdTagURI = wrapper.getVastAdTagURI();
        int i8 = f1134 + 15;
        f1135 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 36 / 0;
        }
        return vastAdTagURI;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1350(CreativeParams creativeParams) {
        f1135 = (f1134 + 7) % 128;
        String environmentVars = creativeParams.getEnvironmentVars();
        int i2 = f1135 + 61;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return environmentVars;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static AdData m1387(Ad ad, String str) {
        int i2 = f1134 + 47;
        f1135 = i2 % 128;
        int i8 = i2 % 2;
        AdData meta = ad.getMeta(str);
        if (i8 != 0) {
            int i9 = 83 / 0;
        }
        return meta;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static void m1392(VideoAd videoAd, VideoAdListener videoAdListener) {
        int i2 = f1135 + 17;
        f1134 = i2 % 128;
        int i8 = i2 % 2;
        videoAd.setAdListener(videoAdListener);
        if (i8 == 0) {
            int i9 = 74 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private e m1379(VideoAdListener videoAdListener, ch chVar) {
        e eVar = new e(videoAdListener, chVar);
        int i2 = f1134 + 31;
        f1135 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 72 / 0;
        }
        return eVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static AdParams m1391(VideoAdController videoAdController) {
        int i2 = f1135 + 13;
        f1134 = i2 % 128;
        int i8 = i2 % 2;
        AdParams adParams = videoAdController.getAdParams();
        if (i8 == 0) {
            int i9 = 86 / 0;
        }
        int i10 = f1135 + 21;
        f1134 = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 69 / 0;
        }
        return adParams;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static Creatives m1389(InLine inLine) {
        f1135 = (f1134 + 17) % 128;
        Creatives creatives = inLine.getCreatives();
        f1135 = (f1134 + 77) % 128;
        return creatives;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1383(StaticResource staticResource) {
        f1134 = (f1135 + 99) % 128;
        String text = staticResource.getText();
        int i2 = f1135 + 59;
        f1134 = i2 % 128;
        if (i2 % 2 != 0) {
            return text;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static Creatives m1390(Wrapper wrapper) {
        f1134 = (f1135 + 91) % 128;
        Creatives creatives = wrapper.getCreatives();
        f1135 = (f1134 + 19) % 128;
        return creatives;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1380(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f1132[i8 + i9]) ^ (((long) i9) * f1133)) ^ ((long) c7));
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1360(MediaFile mediaFile) {
        int i2 = f1134 + 25;
        f1135 = i2 % 128;
        if (i2 % 2 != 0) {
            mediaFile.getText();
            throw null;
        }
        String text = mediaFile.getText();
        f1135 = (f1134 + 13) % 128;
        return text;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1361(StaticResource staticResource) {
        int i2 = f1134 + 101;
        f1135 = i2 % 128;
        if (i2 % 2 != 0) {
            staticResource.getCreativeType();
            throw null;
        }
        String creativeType = staticResource.getCreativeType();
        f1135 = (f1134 + 13) % 128;
        return creativeType;
    }
}
