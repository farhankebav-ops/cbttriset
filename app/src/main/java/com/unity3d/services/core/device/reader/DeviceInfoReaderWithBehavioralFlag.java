package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.device.reader.pii.NonBehavioralFlag;
import com.unity3d.services.core.device.reader.pii.NonBehavioralFlagReader;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class DeviceInfoReaderWithBehavioralFlag implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final NonBehavioralFlagReader _nonBehavioralFlagReader;

    public DeviceInfoReaderWithBehavioralFlag(IDeviceInfoReader iDeviceInfoReader, NonBehavioralFlagReader nonBehavioralFlagReader) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._nonBehavioralFlagReader = nonBehavioralFlagReader;
    }

    @Override // com.unity3d.services.core.device.reader.IDeviceInfoReader
    public Map<String, Object> getDeviceInfoData() {
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        if (this._nonBehavioralFlagReader.getUserNonBehavioralFlag() != NonBehavioralFlag.UNKNOWN) {
            deviceInfoData.put(JsonStorageKeyNames.USER_NON_BEHAVIORAL_KEY, Boolean.valueOf(this._nonBehavioralFlagReader.getUserNonBehavioralFlag() == NonBehavioralFlag.TRUE));
        }
        return deviceInfoData;
    }
}
