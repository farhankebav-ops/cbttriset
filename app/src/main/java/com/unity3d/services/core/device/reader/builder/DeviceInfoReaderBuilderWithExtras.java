package com.unity3d.services.core.device.reader.builder;

import com.unity3d.services.core.configuration.ConfigurationReader;
import com.unity3d.services.core.configuration.PrivacyConfigStorage;
import com.unity3d.services.core.device.reader.DeviceInfoReaderWithExtras;
import com.unity3d.services.core.device.reader.IDeviceInfoReader;
import com.unity3d.services.core.device.reader.IGameSessionIdReader;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class DeviceInfoReaderBuilderWithExtras extends DeviceInfoReaderBuilder {
    private Map<String, String> _extras;

    public DeviceInfoReaderBuilderWithExtras(ConfigurationReader configurationReader, PrivacyConfigStorage privacyConfigStorage, IGameSessionIdReader iGameSessionIdReader) {
        super(configurationReader, privacyConfigStorage, iGameSessionIdReader);
    }

    @Override // com.unity3d.services.core.device.reader.builder.DeviceInfoReaderBuilder
    public IDeviceInfoReader build() {
        return this._extras == null ? super.build() : new DeviceInfoReaderWithExtras(super.build(), this._extras);
    }

    public void setExtras(Map<String, String> map) {
        this._extras = map;
    }
}
