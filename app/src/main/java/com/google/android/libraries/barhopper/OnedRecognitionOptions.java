package com.google.android.libraries.barhopper;

import com.google.android.apps.common.proguard.UsedByNative;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@UsedByNative("jni_common.cc")
public class OnedRecognitionOptions {

    @UsedByNative("jni_common.cc")
    private int ean13UpcaMinConsistentLines = 1;

    @UsedByNative("jni_common.cc")
    private int ean8MinConsistentLines = 3;

    @UsedByNative("jni_common.cc")
    private int upceMinConsistentLines = 3;

    @UsedByNative("jni_common.cc")
    private int code128MinConsistentLines = 1;

    @UsedByNative("jni_common.cc")
    private int code39MinConsistentLines = 2;

    @UsedByNative("jni_common.cc")
    private int code93MinConsistentLines = 2;

    @UsedByNative("jni_common.cc")
    private int itfMinConsistentLines = 3;

    @UsedByNative("jni_common.cc")
    private int codabarMinConsistentLines = 2;

    @UsedByNative("jni_common.cc")
    private int code128MinCodeLength = 2;

    @UsedByNative("jni_common.cc")
    private int code39MinCodeLength = 2;

    @UsedByNative("jni_common.cc")
    private int code93MinCodeLength = 2;

    @UsedByNative("jni_common.cc")
    private int itfMinCodeLength = 6;

    @UsedByNative("jni_common.cc")
    private int codabarMinCodeLength = 6;

    @UsedByNative("jni_common.cc")
    private boolean code39UseCheckDigit = false;

    @UsedByNative("jni_common.cc")
    private boolean code39UseExtendedMode = false;
}
