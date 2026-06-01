package com.instagram.common.viewpoint.core;

import android.media.MediaCodecInfo;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AP {
    public static String[] A00 = {"XFGs1lyyeZSUQVmeVGOQgjZdx0Lg5SQ7", "gIr6pD0DRCuLw9pu", "xFdIOEguE42sAuXi", "sWe2SXgfKDUPeP6q9qV3qPenQfS3yrFL", "xArwsOhMvePeNXFYJk80LlCaAczGuKur", "d6DKz523SxuOwdk6", "C714aw4WOKSmleIF7c9CmjeVatfjbSsR", "QY3y3Mpjcqc9dDZ4GPBIzJJwsqI"};

    public static int A00(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i8, double d8) {
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty() || AR.A07()) {
            return 0;
        }
        MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i2, i8, (int) d8);
        for (int i9 = 0; i9 < supportedPerformancePoints.size(); i9++) {
            if (supportedPerformancePoints.get(i9).covers(performancePoint)) {
                return 2;
            }
        }
        if (A00[3].charAt(9) != 'D') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[5] = "YcALvT0VMkVLsK9p";
        strArr[1] = "SPZaEiX7Pp9WtVjf";
        return 1;
    }
}
