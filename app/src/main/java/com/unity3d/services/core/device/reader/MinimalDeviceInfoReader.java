package com.unity3d.services.core.device.reader;

import androidx.camera.core.processing.util.a;
import com.ironsource.Q6;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class MinimalDeviceInfoReader implements IDeviceInfoReader {
    final IGameSessionIdReader _gameSessionIdReader;

    public MinimalDeviceInfoReader(IGameSessionIdReader iGameSessionIdReader) {
        this._gameSessionIdReader = iGameSessionIdReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        HashMap mapU = a.u(Q6.H, "android");
        mapU.put("sdkVersion", Integer.valueOf(SdkProperties.getVersionCode()));
        mapU.put("sdkVersionName", SdkProperties.getVersionName());
        mapU.put("idfi", Device.getIdfi());
        mapU.put(JsonStorageKeyNames.GAME_SESSION_ID_NORMALIZED_KEY, this._gameSessionIdReader.getGameSessionIdAndStore());
        mapU.put("ts", Long.valueOf(System.currentTimeMillis()));
        mapU.put(AndroidGetAdPlayerContext.KEY_GAME_ID, ClientProperties.getGameId());
        return mapU;
    }
}
