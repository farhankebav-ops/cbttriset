package com.bytedance.sdk.openadsdk.utils;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Pair;
import androidx.core.view.GravityCompat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private static final Map<String, Pair<? extends Drawable, Integer>> IlO = new HashMap();
    private static Integer MY = null;

    public static Drawable IlO(Context context, String str) {
        return IlO(context, str, true);
    }

    public static Drawable IlO(Context context, String str, boolean z2) {
        Pair<? extends Drawable, Integer> pair;
        MY = Integer.valueOf(com.bytedance.sdk.openadsdk.core.cl.tV().VH());
        "drawable name is: ".concat(String.valueOf(str));
        Map<String, Pair<? extends Drawable, Integer>> map = IlO;
        map.size();
        if (!map.containsKey(str) || (pair = map.get(str)) == null) {
            IlO();
            return IlO(str, context, z2);
        }
        Drawable drawable = (Drawable) pair.first;
        map.put(str, new Pair<>(drawable, Integer.valueOf(((Integer) pair.second).intValue() + 1)));
        return drawable;
    }

    private static Drawable IlO(String str, Context context, boolean z2) {
        Drawable layerDrawable;
        Drawable drawableIlO;
        str.getClass();
        switch (str) {
            case "tt_leftbackicon_selector_for_dark":
                drawableIlO = IlO(com.bytedance.sdk.component.utils.pP.EO(context, "tt_lefterbackicon_titlebar_press_for_dark"), com.bytedance.sdk.component.utils.pP.EO(context, "tt_lefterbackicon_titlebar_for_dark"));
                break;
            case "tt_dislike_dialog_bg":
                drawableIlO = IlO(0, -1, new int[]{BS.MY(context, 8.0f)}, null, null, null);
                break;
            case "tt_leftbackbutton_titlebar_photo_preview":
                drawableIlO = IlO(com.bytedance.sdk.component.utils.pP.EO(context, "tt_white_lefterbackicon_titlebar_press"), com.bytedance.sdk.component.utils.pP.EO(context, "tt_white_lefterbackicon_titlebar"));
                break;
            case "tt_seek_progress":
                layerDrawable = new LayerDrawable(new Drawable[]{IlO(0, Integer.valueOf(Color.parseColor("#A5FFFFFF")), new int[]{BS.MY(context, 1.5f)}, new int[]{-1, BS.MY(context, 1.0f)}, null, null), new ClipDrawable(IlO(0, -1, new int[]{BS.MY(context, 1.5f)}, new int[]{-1, BS.MY(context, 1.0f)}, null, null), GravityCompat.START, 1), new ClipDrawable(IlO(0, Integer.valueOf(Color.parseColor("#fff85959")), new int[]{BS.MY(context, 1.5f)}, new int[]{-1, BS.MY(context, 1.0f)}, null, null), GravityCompat.START, 1)});
                drawableIlO = layerDrawable;
                break;
            case "tt_dislike_middle_seletor":
                drawableIlO = IlO(IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_fde6e6e6")), null, null, null, null), IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_fdffffff")), null, null, null, null));
                break;
            case "tt_ad_cover_btn_begin_bg":
                drawableIlO = IlO(IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_2a90d7")), new int[]{BS.MY(context, 6.0f)}, null, Integer.valueOf(BS.MY(context, 1.0f)), Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "@color/tt_7f2a90d7"))), IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_2a90d7")), new int[]{BS.MY(context, 6.0f)}, null, Integer.valueOf(BS.MY(context, 1.0f)), Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "@color/tt_2a90d7"))));
                break;
            case "tt_leftbackicon_selector":
                drawableIlO = com.bytedance.sdk.component.utils.pP.EO(context, "tt_lefterbackicon_titlebar");
                break;
            case "tt_seek_thumb_normal":
                drawableIlO = IlO(1, -1, null, new int[]{BS.MY(context, 15.0f), BS.MY(context, 15.0f)}, Integer.valueOf(BS.MY(context, 1.0f)), 0);
                break;
            case "tt_stop_movebar_textpage":
                drawableIlO = IlO(com.bytedance.sdk.component.utils.pP.EO(context, "tt_new_pause_video_press"), com.bytedance.sdk.component.utils.pP.EO(context, "tt_new_pause_video"));
                break;
            case "tt_backup_btn_1":
                drawableIlO = IlO(IlO(0, Integer.valueOf(Color.parseColor("#33f32830")), new int[]{BS.MY(context, 4.0f)}, null, null, null), IlO(0, Integer.valueOf(Color.parseColor("#f32830")), new int[]{BS.MY(context, 4.0f)}, null, null, null));
                break;
            case "tt_ad_report_info_bg":
                drawableIlO = IlO(0, -1, new int[]{BS.MY(context, 12.0f), BS.MY(context, 12.0f), 0, 0}, null, null, null);
                break;
            case "tt_playable_btn_bk":
                drawableIlO = IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_00000000")), new int[]{BS.MY(context, 30.0f)}, null, Integer.valueOf(BS.MY(context, 1.0f)), -1);
                break;
            case "tt_dislike_bottom_seletor":
                drawableIlO = IlO(IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_fde6e6e6")), new int[]{0, 0, BS.MY(context, 5.0f), BS.MY(context, 5.0f)}, null, null, null), IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_fdffffff")), new int[]{0, 0, BS.MY(context, 5.0f), BS.MY(context, 5.0f)}, null, null, null));
                break;
            case "tt_seek_thumb_fullscreen":
                drawableIlO = IlO(1, -1, null, new int[]{BS.MY(context, 18.0f), BS.MY(context, 18.0f)}, null, null);
                break;
            case "tt_custom_dialog_bg":
                drawableIlO = IlO(0, -1, new int[]{BS.MY(context, 6.0f)}, null, Integer.valueOf(BS.MY(context, 0.8f)), -1);
                break;
            case "tt_ad_loading_three_mid":
                drawableIlO = IlO(0, null, null, null, Integer.valueOf(BS.MY(context, 1.5f)), -1);
                break;
            case "tt_close_move_detail":
                drawableIlO = IlO(com.bytedance.sdk.component.utils.pP.EO(context, "tt_close_move_details_pressed"), com.bytedance.sdk.component.utils.pP.EO(context, "tt_close_move_details_normal"));
                break;
            case "tt_mute_btn_bg":
                drawableIlO = IlO(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{BS.MY(context, 28.0f), BS.MY(context, 28.0f)}, null, null);
                break;
            case "tt_seek_thumb":
                drawableIlO = IlO(IlO(1, -1, null, new int[]{BS.MY(context, 22.0f), BS.MY(context, 22.0f)}, Integer.valueOf(BS.MY(context, 1.0f)), 0), IlO(1, -1, null, new int[]{BS.MY(context, 15.0f), BS.MY(context, 15.0f)}, Integer.valueOf(BS.MY(context, 1.0f)), 0));
                break;
            case "tt_reward_countdown_bg":
                drawableIlO = IlO(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{BS.MY(context, 28.0f), BS.MY(context, 28.0f)}, null, null);
                break;
            case "tt_play_movebar_textpage":
                drawableIlO = IlO(com.bytedance.sdk.component.utils.pP.EO(context, "tt_new_play_video"), com.bytedance.sdk.component.utils.pP.EO(context, "tt_new_play_video"));
                break;
            case "tt_refreshing_video_textpage":
                drawableIlO = IlO(com.bytedance.sdk.component.utils.pP.EO(context, "tt_refreshing_video_textpage_pressed"), com.bytedance.sdk.component.utils.pP.EO(context, "tt_refreshing_video_textpage_normal"));
                break;
            case "tt_playable_progress_style":
                layerDrawable = new LayerDrawable(new Drawable[]{IlO(0, Integer.valueOf(Color.parseColor("#4DFC625C")), new int[]{BS.MY(context, 3.0f)}, null, null, null), new ClipDrawable(IlO(0, Integer.valueOf(Color.parseColor("#FC625C")), new int[]{BS.MY(context, 3.0f)}, null, null, null), GravityCompat.START, 1)});
                drawableIlO = layerDrawable;
                break;
            case "tt_seek_thumb_fullscreen_selector":
                drawableIlO = IlO(IlO(1, -1, null, new int[]{BS.MY(context, 18.0f), BS.MY(context, 18.0f)}, Integer.valueOf(BS.MY(context, 1.0f)), 0), IlO(1, -1, null, new int[]{BS.MY(context, 18.0f), BS.MY(context, 18.0f)}, Integer.valueOf(BS.MY(context, 1.0f)), 0));
                break;
            case "tt_ad_landing_loading_three_mid":
                drawableIlO = IlO(0, null, null, null, Integer.valueOf(BS.MY(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case "tt_pangle_ad_mute_btn_bg":
                drawableIlO = IlO(1, Integer.valueOf(Color.parseColor("#99333333")), null, new int[]{BS.MY(context, 28.0f), BS.MY(context, 28.0f)}, null, null);
                break;
            case "tt_video_black_desc_gradient":
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setGradientType(0);
                gradientDrawable.setColors(new int[]{com.bytedance.sdk.component.utils.pP.Bc(context, "tt_ff1a1a1a"), com.bytedance.sdk.component.utils.pP.Bc(context, "tt_00000000")});
                gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                layerDrawable = gradientDrawable;
                drawableIlO = layerDrawable;
                break;
            case "tt_ad_loading_three_left":
                drawableIlO = IlO(0, null, new int[]{BS.MY(context, 6.0f), 0, 0, BS.MY(context, 6.0f)}, null, Integer.valueOf(BS.MY(context, 1.5f)), -1);
                break;
            case "tt_mute_wrapper":
                Drawable drawableEO = com.bytedance.sdk.component.utils.pP.EO(context, "tt_mute");
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[0], drawableEO);
                stateListDrawable.setAutoMirrored(true);
                layerDrawable = stateListDrawable;
                drawableIlO = layerDrawable;
                break;
            case "tt_dislike_top_bg":
                drawableIlO = IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_fdffffff")), new int[]{BS.MY(context, 5.0f), BS.MY(context, 5.0f), 0, 0}, null, null, null);
                break;
            case "tt_comment_tv":
                drawableIlO = IlO(0, -1, new int[]{BS.MY(context, 4.0f)}, null, Integer.valueOf(BS.MY(context, 1.0f)), Integer.valueOf(Color.parseColor("#0F161823")));
                break;
            case "tt_reward_full_new_bar_bg":
                drawableIlO = IlO(0, Integer.valueOf(Color.parseColor("#ccffffff")), new int[]{BS.MY(context, 18.0f)}, null, null, null);
                break;
            case "tt_reward_full_video_backup_btn_bg":
                drawableIlO = IlO(0, Integer.valueOf(Color.parseColor("#ff0088ff")), new int[]{BS.MY(context, 6.0f)}, null, null, null);
                break;
            case "tt_full_reward_loading_progress_style":
                GradientDrawable gradientDrawableIlO = IlO(0, Integer.valueOf(Color.parseColor("#EAEAEA")), new int[]{BS.MY(context, 50.0f)}, null, null, null);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(BS.MY(context, 15.0f));
                gradientDrawable2.setColors(new int[]{Color.parseColor("#1A73E8"), Color.parseColor("#569FFF")});
                gradientDrawable2.setGradientType(0);
                gradientDrawable2.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                drawableIlO = new LayerDrawable(new Drawable[]{gradientDrawableIlO, new ScaleDrawable(gradientDrawable2, GravityCompat.START, 1.0f, -1.0f)});
                break;
            case "tt_detail_video_btn_bg":
                drawableIlO = IlO(0, Integer.valueOf(Color.parseColor("#26000000")), new int[]{BS.MY(context, 4.0f)}, null, null, null);
                break;
            case "tt_pangle_banner_btn_bg":
                drawableIlO = IlO(0, Integer.valueOf(Color.parseColor("#ff2f87f8")), new int[]{BS.MY(context, 2.0f)}, new int[]{BS.MY(context, 98.0f), BS.MY(context, 25.0f)}, null, null);
                break;
            case "tt_seek_thumb_fullscreen_press":
                drawableIlO = IlO(1, -1, null, new int[]{BS.MY(context, 18.0f), BS.MY(context, 18.0f)}, Integer.valueOf(BS.MY(context, 1.0f)), 0);
                break;
            case "tt_browser_download_selector":
                drawableIlO = IlO(IlO(0, Integer.valueOf(Color.parseColor("#2582c3")), null, null, null, null), IlO(0, Integer.valueOf(Color.parseColor("#2a90d7")), null, null, null, null));
                break;
            case "tt_ad_loading_three_right":
                drawableIlO = IlO(0, null, new int[]{0, BS.MY(context, 6.0f), BS.MY(context, 6.0f), 0}, null, Integer.valueOf(BS.MY(context, 1.5f)), -1);
                break;
            case "tt_pangle_btn_bg":
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setShape(0);
                gradientDrawable3.setSize(BS.MY(context, 280.0f), BS.MY(context, 38.0f));
                gradientDrawable3.setCornerRadius(BS.MY(context, 19.0f));
                gradientDrawable3.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                gradientDrawable3.setColors(new int[]{Color.parseColor("#fff02d42"), Color.parseColor("#fffc4b3c")});
                gradientDrawable3.setGradientType(0);
                gradientDrawable3.setUseLevel(true);
                layerDrawable = gradientDrawable3;
                drawableIlO = layerDrawable;
                break;
            case "tt_privacy_progress_style":
                drawableIlO = new LayerDrawable(new Drawable[]{IlO(0, Integer.valueOf(Color.parseColor("#33007AFF")), null, null, null, null), new ClipDrawable(IlO(0, Integer.valueOf(Color.parseColor("#007AFF")), null, null, null, null), GravityCompat.START, 1)});
                break;
            case "tt_privacy_btn_bg":
                GradientDrawable gradientDrawable4 = new GradientDrawable();
                gradientDrawable4.setShape(0);
                gradientDrawable4.setSize(BS.MY(context, 258.0f), BS.MY(context, 43.0f));
                gradientDrawable4.setCornerRadius(BS.MY(context, 22.0f));
                gradientDrawable4.setColors(new int[]{Color.parseColor("#73CBFC"), Color.parseColor("#3F9CF7")});
                gradientDrawable4.setGradientType(0);
                layerDrawable = gradientDrawable4;
                drawableIlO = layerDrawable;
                break;
            case "tt_seek_thumb_press":
                drawableIlO = IlO(1, -1, null, new int[]{BS.MY(context, 22.0f), BS.MY(context, 22.0f)}, Integer.valueOf(BS.MY(context, 1.0f)), 0);
                break;
            case "tt_unmute_wrapper":
                Drawable drawableEO2 = com.bytedance.sdk.component.utils.pP.EO(context, "tt_unmute");
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[0], drawableEO2);
                stateListDrawable2.setAutoMirrored(true);
                layerDrawable = stateListDrawable2;
                drawableIlO = layerDrawable;
                break;
            case "tt_titlebar_close_seletor_for_dark":
                drawableIlO = IlO(com.bytedance.sdk.component.utils.pP.EO(context, "tt_titlebar_close_press_for_dark"), com.bytedance.sdk.component.utils.pP.EO(context, "tt_titlebar_close_for_dark"));
                break;
            case "tt_ad_landing_loading_three_right":
                drawableIlO = IlO(0, null, new int[]{0, BS.MY(context, 6.0f), BS.MY(context, 6.0f), 0}, null, Integer.valueOf(BS.MY(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case "tt_landingpage_loading_text_rect":
                drawableIlO = IlO(0, Integer.valueOf(Color.parseColor("#141A73E8")), new int[]{BS.MY(context, 5.0f)}, null, null, null);
                break;
            case "tt_shadow_btn_back_withoutnight":
                Drawable drawableEO3 = com.bytedance.sdk.component.utils.pP.EO(context, "tt_shadow_lefterback_titlebar_press_withoutnight");
                StateListDrawable stateListDrawableIlO = IlO(drawableEO3, com.bytedance.sdk.component.utils.pP.EO(context, "tt_shadow_lefterback_titlebar_withoutnight"));
                stateListDrawableIlO.addState(new int[]{-16842910}, drawableEO3);
                drawableIlO = stateListDrawableIlO;
                break;
            case "tt_circle_solid_mian":
                drawableIlO = IlO(1, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_e0e0e0")), null, null, null, null);
                break;
            case "tt_browser_progress_style":
                drawableIlO = new LayerDrawable(new Drawable[]{IlO(0, -1, new int[]{0}, null, null, null), new ClipDrawable(IlO(0, Integer.valueOf(Color.parseColor("#1A73E8")), new int[]{0}, null, null, null), 3, 1)});
                break;
            case "tt_download_corner_bg":
                drawableIlO = IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_4a90e2")), new int[]{BS.MY(context, 4.0f)}, null, null, null);
                break;
            case "tt_ad_report_info_button_bg":
                drawableIlO = IlO(IlO(0, Integer.valueOf(Color.parseColor("#0D000000")), new int[]{BS.MY(context, 2.0f)}, null, Integer.valueOf(BS.MY(context, 1.0f)), Integer.valueOf(Color.parseColor("#1F000000"))), IlO(0, -1, new int[]{BS.MY(context, 2.0f)}, null, Integer.valueOf(BS.MY(context, 1.0f)), Integer.valueOf(Color.parseColor("#1618231F"))));
                break;
            case "tt_ad_landing_loading_three_left":
                drawableIlO = IlO(0, null, new int[]{BS.MY(context, 6.0f), 0, 0, BS.MY(context, 6.0f)}, null, Integer.valueOf(BS.MY(context, 1.5f)), Integer.valueOf(Color.parseColor("#ABACB0")));
                break;
            case "tt_pangle_ad_close_btn_bg":
                drawableIlO = IlO(1, Integer.valueOf(Color.parseColor("#30333333")), null, new int[]{BS.MY(context, 28.0f), BS.MY(context, 28.0f)}, null, null);
                break;
            case "tt_lefterbackicon_titlebar_press_wrapper":
                Drawable drawableEO4 = com.bytedance.sdk.component.utils.pP.EO(context, "tt_lefterbackicon_titlebar_press");
                StateListDrawable stateListDrawable3 = new StateListDrawable();
                stateListDrawable3.addState(new int[0], drawableEO4);
                stateListDrawable3.setAutoMirrored(true);
                layerDrawable = stateListDrawable3;
                drawableIlO = layerDrawable;
                break;
            case "tt_reward_video_download_btn_bg":
                drawableIlO = IlO(0, Integer.valueOf(Color.parseColor("#ff007aff")), new int[]{BS.MY(context, 18.0f)}, null, null, null);
                break;
            case "tt_ad_loading_rect":
                drawableIlO = IlO(0, Integer.valueOf(Color.parseColor("#33FFFFFF")), new int[]{BS.MY(context, 15.0f)}, null, null, null);
                break;
            case "tt_shadow_btn_back":
                Drawable drawableEO5 = com.bytedance.sdk.component.utils.pP.EO(context, "tt_shadow_lefterback_titlebar_press");
                StateListDrawable stateListDrawableIlO2 = IlO(drawableEO5, com.bytedance.sdk.component.utils.pP.EO(context, "tt_shadow_lefterback_titlebar"));
                stateListDrawableIlO2.addState(new int[]{-16842910}, drawableEO5);
                drawableIlO = stateListDrawableIlO2;
                break;
            case "tt_dislike_top_seletor":
                drawableIlO = IlO(IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_fde6e6e6")), new int[]{BS.MY(context, 5.0f), BS.MY(context, 5.0f), 0, 0}, null, null, null), IlO(0, Integer.valueOf(com.bytedance.sdk.component.utils.pP.Bc(context, "tt_fdffffff")), new int[]{BS.MY(context, 5.0f), BS.MY(context, 5.0f), 0, 0}, null, null, null));
                break;
            case "tt_video_loading_progress_bar":
                RotateDrawable rotateDrawable = new RotateDrawable();
                rotateDrawable.setDrawable(com.bytedance.sdk.component.utils.pP.EO(context, "tt_normalscreen_loading"));
                rotateDrawable.setFromDegrees(0.0f);
                rotateDrawable.setToDegrees(360.0f);
                rotateDrawable.setPivotX(0.5f);
                rotateDrawable.setPivotY(0.5f);
                layerDrawable = rotateDrawable;
                drawableIlO = layerDrawable;
                break;
            case "tt_ad_skip_btn_bg2":
                drawableIlO = IlO(0, Integer.valueOf(Color.parseColor("#66161823")), new int[]{BS.MY(context, 14.0f)}, null, null, null);
                break;
            case "tt_privacy_webview_bg":
                drawableIlO = IlO(0, -1, new int[]{BS.MY(context, 14.5f)}, null, null, null);
                break;
            case "tt_titlebar_close_seletor":
                drawableIlO = com.bytedance.sdk.component.utils.pP.EO(context, "tt_titlebar_close_drawable");
                break;
            default:
                drawableIlO = null;
                break;
        }
        if (z2) {
            IlO.put(str, new Pair<>(drawableIlO, 1));
        }
        return drawableIlO;
    }

    private static void IlO() {
        Map<String, Pair<? extends Drawable, Integer>> map = IlO;
        if (map.size() < MY.intValue()) {
            return;
        }
        String key = null;
        int iIntValue = Integer.MAX_VALUE;
        for (Map.Entry<String, Pair<? extends Drawable, Integer>> entry : map.entrySet()) {
            if (((Integer) entry.getValue().second).intValue() < iIntValue) {
                key = entry.getKey();
                iIntValue = ((Integer) entry.getValue().second).intValue();
                if (iIntValue == 1) {
                    break;
                }
            }
        }
        IlO.remove(key);
    }

    private static GradientDrawable IlO(int i2, Integer num, int[] iArr, int[] iArr2, Integer num2, Integer num3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i2);
        if (num != null) {
            gradientDrawable.setColor(num.intValue());
        }
        int length = iArr != null ? iArr.length : 0;
        if (length == 1) {
            gradientDrawable.setCornerRadius(iArr[0]);
        } else if (length == 4) {
            int i8 = iArr[0];
            int i9 = iArr[1];
            int i10 = iArr[2];
            int i11 = iArr[3];
            gradientDrawable.setCornerRadii(new float[]{i8, i8, i9, i9, i10, i10, i11, i11});
        }
        if (iArr2 != null && iArr2.length == 2) {
            gradientDrawable.setSize(iArr2[0], iArr2[1]);
        }
        if (num2 != null && num3 != null) {
            gradientDrawable.setStroke(num2.intValue(), num3.intValue());
        }
        return gradientDrawable;
    }

    private static StateListDrawable IlO(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (drawable != null) {
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable);
        }
        if (drawable2 != null) {
            stateListDrawable.addState(new int[0], drawable2);
        }
        return stateListDrawable;
    }

    public static Drawable IlO(Context context, int i2) {
        return IlO(context, Color.parseColor("#1A73E8"), i2);
    }

    public static Drawable IlO(Context context, int i2, int i8) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(BS.MY(context, i8));
        return gradientDrawable;
    }
}
