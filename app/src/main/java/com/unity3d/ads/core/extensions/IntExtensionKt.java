package com.unity3d.ads.core.extensions;

import com.google.android.play.core.install.model.InstallErrorCode;
import com.unity3d.ads.adplayer.model.ErrorReason;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IntExtensionKt {
    public static final ErrorReason webResourceToErrorReason(int i2) {
        switch (i2) {
            case -16:
                return ErrorReason.REASON_WEB_ERROR_UNSAFE_RESOURCE;
            case -15:
                return ErrorReason.REASON_WEB_ERROR_TOO_MANY_REQUESTS;
            case -14:
                return ErrorReason.REASON_WEB_ERROR_FILE_NOT_FOUND;
            case -13:
                return ErrorReason.REASON_WEB_ERROR_FILE;
            case -12:
                return ErrorReason.REASON_WEB_ERROR_BAD_URL;
            case -11:
                return ErrorReason.REASON_WEB_ERROR_FAILED_SSL_HANDSHAKE;
            case InstallErrorCode.ERROR_APP_NOT_OWNED /* -10 */:
                return ErrorReason.REASON_WEB_ERROR_UNSUPPORTED_SCHEME;
            case InstallErrorCode.ERROR_PLAY_STORE_NOT_FOUND /* -9 */:
                return ErrorReason.REASON_WEB_ERROR_REDIRECT_LOOP;
            case -8:
                return ErrorReason.REASON_WEB_ERROR_TIMEOUT;
            case InstallErrorCode.ERROR_DOWNLOAD_NOT_PRESENT /* -7 */:
                return ErrorReason.REASON_WEB_ERROR_IO;
            case InstallErrorCode.ERROR_INSTALL_NOT_ALLOWED /* -6 */:
                return ErrorReason.REASON_WEB_ERROR_CONNECT;
            case InstallErrorCode.ERROR_INSTALL_UNAVAILABLE /* -5 */:
                return ErrorReason.REASON_WEB_ERROR_PROXY_AUTHENTICATION;
            case -4:
                return ErrorReason.REASON_WEB_ERROR_AUTHENTICATION;
            case -3:
                return ErrorReason.REASON_WEB_ERROR_UNSUPPORTED_AUTH_SCHEME;
            case -2:
                return ErrorReason.REASON_WEB_ERROR_HOST_LOOKUP;
            case -1:
                return ErrorReason.REASON_WEB_ERROR_UNKNOWN;
            default:
                return ErrorReason.REASON_UNKNOWN;
        }
    }
}
